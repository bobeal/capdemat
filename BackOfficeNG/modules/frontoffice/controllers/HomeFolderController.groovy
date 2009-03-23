import fr.cg95.cvq.authentication.IAuthenticationService
import fr.cg95.cvq.business.users.*
import fr.cg95.cvq.exception.CvqAuthenticationFailedException
import fr.cg95.cvq.exception.CvqBadPasswordException
import fr.cg95.cvq.security.SecurityContext
import fr.cg95.cvq.service.users.IHomeFolderService
import fr.cg95.cvq.service.users.IIndividualService

class HomeFolderController {

    IHomeFolderService homeFolderService
    IIndividualService individualService
    IAuthenticationService authenticationService

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
