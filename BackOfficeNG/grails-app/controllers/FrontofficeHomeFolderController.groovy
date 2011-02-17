import fr.cg95.cvq.authentication.IAuthenticationService
import fr.cg95.cvq.business.users.*
import fr.cg95.cvq.dao.hibernate.HibernateUtil
import fr.cg95.cvq.exception.CvqAuthenticationFailedException
import fr.cg95.cvq.exception.CvqBadPasswordException
import fr.cg95.cvq.exception.CvqModelException
import fr.cg95.cvq.security.SecurityContext
import fr.cg95.cvq.service.request.IRequestSearchService
import fr.cg95.cvq.service.request.IRequestServiceRegistry
import fr.cg95.cvq.service.request.IRequestTypeService
import fr.cg95.cvq.service.request.IRequestWorkflowService
import fr.cg95.cvq.service.users.IHomeFolderService
import fr.cg95.cvq.service.users.IIndividualService

import com.octo.captcha.service.CaptchaServiceException
import org.codehaus.groovy.grails.web.servlet.mvc.GrailsParameterMap

class FrontofficeHomeFolderController {

    IHomeFolderService homeFolderService
    IIndividualService individualService
    IAuthenticationService authenticationService
    IRequestSearchService requestSearchService
    IRequestServiceRegistry requestServiceRegistry
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
                'fullName' : child.born ? "${child.firstName} ${child.lastName}" :
                    message('code':"request.subject.childNoBorn", args:[child.getFullName()]),
                'birthDate' : child.birthDate,
                'birthCountry' : child.birthCountry,
                'birthPostalCode' : child.birthPostalCode,
                'birthCity' : child.birthCity,
                'roleOwners' : homeFolderService.listBySubjectRoles(child.id,
                    [RoleType.CLR_FATHER, RoleType.CLR_MOTHER, RoleType.CLR_TUTOR] as RoleType[]),
                'born' : child.born
            ])
        }
        
        result.homeFolder = [
            'state' : currentEcitizen.homeFolder.state,
            'isActive' : currentEcitizen.homeFolder.enabled,
            'addressDetails' :   "${currentEcitizen.homeFolder.address.streetNumber ?: ''} "+
                                 "${currentEcitizen.homeFolder.address.streetName} " +
                                 "${currentEcitizen.homeFolder.address.postalCode} " +
                                 "${currentEcitizen.homeFolder.address.city}"
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
        def model = [
            "invalidFields" : [],
            "temporary" : params.requestTypeLabel && requestServiceRegistry.getRequestService(
                params.requestTypeLabel).supportUnregisteredCreation()
        ]
        if (request.get) {
            return model
        } else if (request.post) {
            Adult adult = new Adult()
            DataBindingUtils.initBind(adult, params)
            bind(adult)
            model["adult"] = adult
            model["invalidFields"] = individualService.validate(adult, !model["temporary"] || !params.boolean("temporary"))
            boolean captchaIsValid = false
            try {
                captchaIsValid = jcaptchaService.validateResponse("captchaImage", session.id, params.captchaText)
            } catch (CaptchaServiceException e) {
                // no need to throw an exception when the captcha has expired...
            }
            if (!captchaIsValid) {
                model["invalidFields"].add("captchaText")
            }
            if (model["invalidFields"].isEmpty()) {
                homeFolderService.create(adult, model["temporary"] && params.boolean("temporary"))
                securityService.setEcitizenSessionInformation(adult.login, session)
                if (params.requestTypeLabel) {
                    flash.precedeByAccountCreation = true
                    redirect(controller : "frontofficeRequestType", action : "start", id : params.requestTypeLabel)
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
            individual.address = SecurityContext.currentEcitizen.address.clone()
        }
        if (request.post) {
            DataBindingUtils.initBind(individual, params)
            bind(individual)
            model["invalidFields"] = individualService.validate(individual, false)
            if (model["invalidFields"].isEmpty()) {
                if (individual.id) individualService.modify(individual)
                else homeFolderService.addAdult(this.currentEcitizen.homeFolder, individual, false)
                redirect(action : "adult", params : ["id" : individual.id])
                return false
            } else {
                session.doRollback = true
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
            individual.homeFolder = currentEcitizen.homeFolder
            // hack : WTF is an unknown sex ?
            individual.sex = null
        }
        if (request.post) {
            bind(individual)
            if (individual.id)
                homeFolderService.removeRolesOnSubject(
                    SecurityContext.currentEcitizen.homeFolder.id, individual.id)
            params.roles.each {
                if (it.value instanceof GrailsParameterMap && it.value.owner != '' && it.value.type != '') {
                    homeFolderService.addIndividualRole(individualService.getById(Long.valueOf(it.value.owner)),
                        individual, RoleType.forString(it.value.type))
                }
            }
            model["invalidFields"] = individualService.validate(individual)
            if (model["invalidFields"].isEmpty()) {
                if (individual.id) individualService.modify(individual)
                else homeFolderService.addChild(this.currentEcitizen.homeFolder, individual)
                redirect(action : "child", params : ["id" : individual.id])
                return false
            } else {
                session.doRollback = true
            }
        }
        model["child"] = individual
        model["roleOwners"] = individual.id ?
            homeFolderService.listBySubjectRoles(individual.id,
                [RoleType.CLR_FATHER, RoleType.CLR_MOTHER, RoleType.CLR_TUTOR] as RoleType[])
                .sort { a, b ->
                  if (a.id == b.id) return a.fullName.compareTo(b.fullName)
                  if (a.id == SecurityContext.currentEcitizen.id) return -1
                  if (b.id == SecurityContext.currentEcitizen.id) return 1
                  return a.fullName.compareTo(b.fullName)
                } : []
        if (params.mode == "edit") {
            template += "Edit"
            model["adults"] = homeFolderService.getAdults(SecurityContext.currentEcitizen.homeFolder.id)
            model["currentUser"] = SecurityContext.currentEcitizen
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
