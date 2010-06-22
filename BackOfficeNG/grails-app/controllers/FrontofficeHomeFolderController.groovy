import fr.cg95.cvq.authentication.IAuthenticationService
import fr.cg95.cvq.business.users.*
import fr.cg95.cvq.dao.hibernate.HibernateUtil
import fr.cg95.cvq.exception.CvqAuthenticationFailedException
import fr.cg95.cvq.exception.CvqBadPasswordException
import fr.cg95.cvq.exception.CvqModelException
import fr.cg95.cvq.security.SecurityContext
import fr.cg95.cvq.service.request.IRequestSearchService
import fr.cg95.cvq.service.request.IRequestTypeService
import fr.cg95.cvq.service.request.IRequestWorkflowService
import fr.cg95.cvq.service.users.IHomeFolderService
import fr.cg95.cvq.service.users.IIndividualService

class FrontofficeHomeFolderController {

    IHomeFolderService homeFolderService
    IIndividualService individualService
    IAuthenticationService authenticationService
    IRequestSearchService requestSearchService
    IRequestTypeService requestTypeService
	IRequestWorkflowService requestWorkflowService

    def homeFolderAdaptorService
    def jcaptchaService
    def securityService

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
                'fullName' : child.isChildBorn ? "${child.firstName} ${child.lastName}" :
                    message('code':"request.subject.childNoBorn", args:[child.getFullName()]),
                'birthDate' : child.birthDate,
                'birthCountry' : child.birthCountry,
                'birthPostalCode' : child.birthPostalCode,
                'birthCity' : child.birthCity,
                'childSubjectRoles' : homeFolderAdaptorService.prepareChildSubjectRoles(child),
                'isChildBorn' : child.isChildBorn
            ])
        }
        
        result.homeFolder = [
            'state' : currentEcitizen.homeFolder.state,
            'isActive' : currentEcitizen.homeFolder.enabled,
            'addressDetails' :   "${currentEcitizen.homeFolder.adress.streetNumber ?: ''} "+
                                 "${currentEcitizen.homeFolder.adress.streetName} " +
                                 "${currentEcitizen.homeFolder.adress.postalCode} " +
                                 "${currentEcitizen.homeFolder.adress.city}"
        ]
        
        def enabled = true, message = null
        try {
            requestWorkflowService.isAccountModificationRequestAuthorized(currentEcitizen.homeFolder)
        } catch (CvqModelException cvqme) {
            enabled = false
            message = cvqme.i18nKey
        }
        result.hfmr = [
            'label': IRequestTypeService.HOME_FOLDER_MODIFICATION_REQUEST,
            'enabled': enabled,
            'message': message
        ]
        
        return result
    }

    def create = {
        def model = [:]
        model["invalidFields"] = []
        if (request.get) {
            return model
        } else if (request.post) {
            Adult adult = new Adult()
            DataBindingUtils.initBind(adult, params)
            bind(adult)
            model["adult"] = adult
            model["invalidFields"] = individualService.validate(adult, true)
            if (!jcaptchaService.validateResponse("captchaImage", session.id, params.captchaText)) {
                model["invalidFields"].add("captchaText")
            }
            if (model["invalidFields"].isEmpty()) {
                homeFolderService.addHomeFolderRole(adult, RoleType.HOME_FOLDER_RESPONSIBLE)
                homeFolderService.create(adult)
                SecurityContext.setCurrentEcitizen(adult)
                HibernateUtil.getSession().flush()
                securityService.setEcitizenSessionInformation(adult.login, session)
                if (params.requestTypeLabel) {
                    redirect(controller : "frontofficeRequest", action : "edit",
                        params : ["label" : params.requestTypeLabel])
                    return false
                }
            } else {
                return model
            }
        }
    }

    def adult = {
        def model = [:]
        def individual
        def template = "adult"
        if (params.id) {
            individual = individualService.getAdultById(Long.valueOf(params.id))
        } else {
            individual = new Adult()
            // hack : WTF is an unknown title ?
            individual.title = null
        }
        if (request.post) {
            DataBindingUtils.initBind(individual, params)
            bind(individual)
            model["invalidFields"] = individualService.validate(individual, false)
            if (model["invalidFields"].isEmpty()) {
                if (individual.id) {
                    individualService.modify(individual)
                } else {
                    individualService.create(individual, SecurityContext.currentEcitizen.homeFolder, individual.adress, false)
                }
                if (params.requestId) {
                    requestSearchService.getById(Long.valueOf(params.requestId), false).subjectId =
                        individual.id
                    redirect(controller : "frontofficeRequest", action : "edit",
                        params : ["id" : params.requestId])
                } else {
                    redirect(action : "adult", params : ["id" : individual.id])
                }
                return false
            }
        }
        model["adult"] = individual
        if (params.mode == "edit") {
            template += "Edit"
        } else {
            model["ownerRoles"] = homeFolderAdaptorService.prepareOwnerRoles(individual)
            model["subjectRoles"] = homeFolderAdaptorService.prepareAdultSubjectRoles(individual)
        }
        render(view : template, model : model)
    }

    def child = {
        def model = [:]
        def individual
        def template = "child"
        if (params.id) {
            individual = individualService.getChildById(Long.valueOf(params.id))
        } else {
            individual = new Child()
            // hack : WTF is an unknown sex ?
            individual.sex = null
        }
        if (request.post) {
            DataBindingUtils.initBind(individual, params)
            bind(individual)
            model["invalidFields"] = individualService.validate(individual)
            if (model["invalidFields"].isEmpty()) {
                if (individual.id) {
                    individualService.modify(individual)
                } else {
                    individualService.create(individual, SecurityContext.currentEcitizen.homeFolder, individual.adress, false)
                }
                if (params.requestId) {
                    requestSearchService.getById(Long.valueOf(params.requestId), false).subjectId =
                        individual.id
                    redirect(controller : "frontofficeRequest", action : "edit",
                        params : ["id" : params.requestId])
                } else {
                    redirect(action : "child", params : ["id" : individual.id])
                }
                return false
            }
        }
        model["child"] = individual
        if (params.mode == "edit") {
            template += "Edit"
        } else {
            model["roles"] = homeFolderAdaptorService.prepareChildSubjectRoles(individual)
        }
        render(view : template, model : model)
    }

    def editPassword = {
        def model = ["passwordMinLength" : authenticationService.passwordMinLength]
        if (request.get) {
            return model
        } else if (request.post) {
            if (params.cancel == null) {
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
            }
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
                flash.errorMessage = message("code":"account.error.invalidLogin")
                render(view : "answerLogin", model : [])
                return false
            }
            if (adult.answer == params.answer) {
                def password = authenticationService.generatePassword()
                authenticationService.resetAdultPassword(adult, password)
                def category = requestTypeService.getRequestTypeByLabel("VO Card").category
                def categoryEmail = null
                if (category != null) {
                    categoryEmail = category.primaryEmail
                }
                def notificationType = homeFolderService.notifyPasswordReset(adult, password, categoryEmail)
                switch (notificationType) {
                    case IHomeFolderService.PasswordResetNotificationType.INLINE :
                        flash.successMessage = message("code" : "account.message.passwordResetSuccessAdultEmail", "args" : [password])
                        break
                    case IHomeFolderService.PasswordResetNotificationType.ADULT_EMAIL :
                        flash.successMessage = message("code" : "account.message.passwordResetSuccessAdultEmail", "args" : [adult.email])
                        break
                    case IHomeFolderService.PasswordResetNotificationType.CATEGORY_EMAIL :
                        flash.successMessage = message("code" : "account.message.passwordResetSuccessAdultEmail")
                        break
                }
                redirect(controller : "frontofficeHome", action : "login")
                return false
            } else {
                if (!params.comesFromLoginStep) {
                    flash.errorMessage = message("code":"account.error.invalidAnswer")
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
            if (params.cancel == null) {
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
            }
            redirect(controller : "frontofficeHomeFolder")
        }
    }
}
