import fr.cg95.cvq.authentication.IAuthenticationService
import fr.cg95.cvq.business.users.*
import fr.cg95.cvq.exception.CvqAuthenticationFailedException
import fr.cg95.cvq.exception.CvqBadPasswordException
import fr.cg95.cvq.security.SecurityContext
import fr.cg95.cvq.service.request.IRequestService
import fr.cg95.cvq.service.users.IHomeFolderService
import fr.cg95.cvq.service.users.IIndividualService

class HomeFolderController {

    IHomeFolderService homeFolderService
    IIndividualService individualService
    IAuthenticationService authenticationService
    IRequestService defaultRequestService

    def homeFolderAdaptorService
    
    Adult currentEcitizen

    def beforeInterceptor = {
        this.currentEcitizen = SecurityContext.getCurrentEcitizen();
    }

    def index = {
        def result = ['adults':[], 'children': [], homeFolder: []]
        def homeFolderId = SecurityContext.currentEcitizen.homeFolder.id
        homeFolderService.getAdults(homeFolderId).each { adult ->
            result.adults.add([
                'id' : adult.id,
                'title' : message('code':"homeFolder.adult.title.${adult.title.toString().toLowerCase()}"),
                'fullName' : "${adult.firstName} ${adult.lastName}",
                'email' : adult.email,
                'homePhone' : adult.homePhone,
                'mobilePhone' : adult.mobilePhone,
                'birthDate' : adult.birthDate,
                'birthCountry' : adult.birthCountry,
                'birthPostalCode' : adult.birthPostalCode,
                'birthCity' : adult.birthCity,
                'ownerRoles' : homeFolderAdaptorService.prepareOwnerRoles(adult)
            ])
        }
        homeFolderService.getChildren(homeFolderId).each{ child ->
            result.children.add([
                'id' : child.id,
                'sex' : child.sex,
                'fullName' : "${child.firstName} ${child.lastName}",
                'birthDate' : child.birthDate,
                'birthCountry' : child.birthCountry,
                'birthPostalCode' : child.birthPostalCode,
                'birthCity' : child.birthCity,
                'childSubjectRoles' : homeFolderAdaptorService.prepareChildSubjectRoles(child)
            ])
        }
        
        result.homeFolder = [
            'state' : currentEcitizen.homeFolder.state,
            'isActive' : currentEcitizen.homeFolder.enabled,
            'addressDetails' :   "${currentEcitizen.homeFolder.adress.streetNumber} "+
                                 "${currentEcitizen.homeFolder.adress.streetName} " +
                                 "${currentEcitizen.homeFolder.adress.postalCode} " +
                                 "${currentEcitizen.homeFolder.adress.city}"
        ]
        return result
    }
    
    def individual = {
        def individual = individualService.getById(Long.valueOf(params.id))
        if (individual instanceof Child) {
            return ['individual':individual, 'isChild':true, 
                    'roles':homeFolderAdaptorService.prepareChildSubjectRoles(individual)]
        } else {
            return ['individual':individual, 'isChild':false, 
                    'ownerRoles':homeFolderAdaptorService.prepareOwnerRoles(individual),
                    'subjectRoles':homeFolderAdaptorService.prepareAdultSubjectRoles(individual)]
        }
    }
    
    def editPassword = {
        def model = ["passwordMinLength" : authenticationService.passwordMinLength]
        if (request.get) {
            return model
        } else if (request.post) {
            if (params.newPassword != params.newPasswordConfirmation) {
                flash.errorMessage = message("code":"homeFolder.adult.property.newPasswordConfirmation.validationError")
                return model
            } else if (params.newPassword == null || params.newPassword.length() < authenticationService.passwordMinLength) {
                flash.errorMessage = message("code":"homeFolder.adult.property.newPassword.validationError", "args":[authenticationService.passwordMinLength])
                return model
            }
            try {
                individualService.modifyPassword(currentEcitizen, params.oldPassword, params.newPassword)
            } catch (CvqBadPasswordException e) {
                flash.errorMessage = message("code":"homeFolder.adult.property.oldPassword.validationError")
                return model
            }
            flash.successMessage = message("code":"homeFolder.adult.property.password.changeSuccess")
            redirect(controller : "frontofficeHomeFolder")
        }
    }

    def resetPassword = {
        if (request.get) {
            render(view : "answerLogin", model : [])
            return false
        } else if (request.post) {
            def adult = individualService.getByLogin(params.login)
            if (adult == null) {
                flash.errorMessage = message("code":"entered.login.invalid")
                render(view : "answerLogin", model : [])
                return false
            }
            if (adult.answer == params.answer) {
                def password = authenticationService.generatePassword()
                authenticationService.resetAdultPassword(adult, password)
                def category = defaultRequestService.getRequestTypeByLabel("VO Card Request").category
                def categoryEmail = null
                if (category != null) {
                    categoryEmail = category.primaryEmail
                }
                def notificationType = homeFolderService.notifyPasswordReset(adult, password, categoryEmail)
                switch (notificationType) {
                    case IHomeFolderService.PasswordResetNotificationType.INLINE :
                        flash.successMessage = message("code" : "password.reset.success.no.email", "args" : [password])
                        break
                    case IHomeFolderService.PasswordResetNotificationType.ADULT_EMAIL :
                        flash.successMessage = message("code" : "password.reset.success.adult.email", "args" : [adult.email])
                        break
                    case IHomeFolderService.PasswordResetNotificationType.CATEGORY_EMAIL :
                        flash.successMessage = message("code" : "password.reset.success.category.email")
                        break
                }
                redirect(controller : "frontofficeHome", action : "login")
                return false
            } else {
                if (!params.comesFromLoginStep) {
                    flash.errorMessage = message("code":"answer.invalid")
                }
                render(view : "answerQuestion", model : ["question" : adult.question, "login" : params.login])
                return false
            }
        }
    }

    def editQuestion = {
        def model = ["question" : currentEcitizen.question, "answer" : currentEcitizen.answer]
        if (request.get) {
            return model
        } else if (request.post) {
            try {
                authenticationService.authenticate(currentEcitizen.login, params.password)
            } catch (CvqAuthenticationFailedException e) {
                flash.errorMessage = message("code":"homeFolder.adult.property.oldPassword.validationError")
                return model
            }
            if (params.question != message("code":"homeFolder.adult.question.q1")
                   && params.question != message("code":"homeFolder.adult.question.q2")
                   && params.question != message("code":"homeFolder.adult.question.q3")
                   && params.question != message("code":"homeFolder.adult.question.q4")
               ) {
                flash.errorMessage = message("code":"homeFolder.adult.property.question.validationError")
                return model
            }
            if (params.answer == null || params.answer.trim().isEmpty()) {
                flash.errorMessage = message("code":"homeFolder.adult.property.answer.validationError")
                return model
            }
            currentEcitizen.question = params.question
            currentEcitizen.answer = params.answer
            individualService.modify(currentEcitizen)
            flash.successMessage = message("code":"homeFolder.adult.property.question.changeSuccess")
            redirect(controller : "frontofficeHomeFolder")
        }
    }
}
