import fr.cg95.cvq.authentication.IAuthenticationService
import fr.cg95.cvq.business.users.*
import fr.cg95.cvq.dao.hibernate.HibernateUtil
import fr.cg95.cvq.exception.CvqAuthenticationFailedException
import fr.cg95.cvq.exception.CvqBadPasswordException
import fr.cg95.cvq.exception.CvqModelException
import fr.cg95.cvq.exception.CvqValidationException
import fr.cg95.cvq.security.SecurityContext
import fr.cg95.cvq.service.request.IRequestSearchService
import fr.cg95.cvq.service.request.IRequestServiceRegistry
import fr.cg95.cvq.service.request.IRequestTypeService
import fr.cg95.cvq.service.request.IRequestWorkflowService
import fr.cg95.cvq.service.users.IHomeFolderService
import fr.cg95.cvq.service.users.IIndividualService
import fr.cg95.cvq.service.users.IUserWorkflowService

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
    IUserWorkflowService userWorkflowService

    def homeFolderAdaptorService
    def individualAdaptorService
    def jcaptchaService
    def securityService

    Adult currentEcitizen

    def beforeInterceptor = {
        currentEcitizen = SecurityContext.getCurrentEcitizen();
    }

    def index = {
        def homeFolderId = currentEcitizen.homeFolder.id
        def children = homeFolderService.getChildren(homeFolderId)
        // FIXME : Poor implementation : db request on Role are crappy
        def childResponsibles = [:]
        children.each {
            childResponsibles.put(it.id, homeFolderService.listBySubjectRoles(it.id, RoleType.childRoleTypes))
        }
        Individual.metaClass.homeFolderResponsible = {
            def role = null
            delegate.individualRoles.each {
                if (it.homeFolderId) role = it.role
            }
            return role
        }

        if (params.idToDelete)
            flash.idToDelete = Long.valueOf(params.idToDelete)

        // TODO: filter individual by state ine Service Layer
        return ['homeFolder': currentEcitizen.homeFolder,
                'adults':  homeFolderService.getAdults(homeFolderId).findAll{ it.state != UserState.ARCHIVED },
                'children': children.findAll{ it.state != UserState.ARCHIVED },
                'childResponsibles' : childResponsibles]
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
                    redirect(controller : "frontofficeRequestType", action : "start", id : params.requestTypeLabel)
                    return false
                }
            } else {
                return model
            }
        }
    }

    def deleteIndividual = {
        userWorkflowService.changeState(individualService.getById(Long.valueOf(params.id)), UserState.ARCHIVED)
        redirect(action : 'index')
    }

    def adult = {
        def model = [:]
        def individual
        if (params.id) {
            individual = individualService.getAdultById(Long.valueOf(params.id))
        } else {
            individual = new Adult()
            // hack : WTF is an unknown title ?
            individual.title = null
            individual.address = currentEcitizen.address.clone()
        }
        if (request.post) {
            try {
                if (individual.id) {
                    historize(params.fragment, individual)
                    if (individual.id == currentEcitizen.id && params.fragment == 'identity') {
                        securityService.setEcitizenSessionInformation(individual.login, session)
                    }
                } else {
                    addAdult(individual)
                }
                redirect(action : "adult", params : ["id" : individual.id])
                return false
            } catch (CvqValidationException e) {
                model["invalidFields"] = e.invalidFields
                session.doRollback = true
            }
        }
        Adult.metaClass.fragmentMode = { name ->
            def template = '/adult' + StringUtils.firstCase(name,'Upper')
            return (name == params.fragment  ? 'edit' : 'static') + template
        }
        model['adult'] = individual
        if (individual.id) {
            model['ownerRoles'] = homeFolderAdaptorService.prepareOwnerRoles(individual)
        }
        return model
    }

    def child = {
        def model = [:]
        def individual
        if (params.id) {
            individual = individualService.getChildById(Long.valueOf(params.id))
        } else {
            individual = new Child()
            // hack : WTF is an unknown sex ?
            individual.sex = null
        }
        if (request.post) {
            try {
                if (individual.id && params.roleOwnerId) {
                    if (!params.roleType)
                        throw new CvqValidationException(['legalResponsibles'])
                    def owner = individualService.getById(Long.valueOf(params.roleOwnerId))
                    homeFolderService.link(owner, individual, [RoleType.forString(params.roleType)])
                    redirect(url:createLink(action:'child', params:['id':individual.id, 'fragment':params.fragment]) + '#' + params.fragment)
                    return false
                } else if (individual.id) {
                    historize(params.fragment, individual)
                } else {
                    addChild(individual)
                }
                redirect(action : 'child', params : ['id' : individual.id])
                return false
            } catch (CvqValidationException e) {
                // hack hibernate
                if (!params.id) individual.id = null
                flash['invalidFields'] = e.invalidFields
                session.doRollback = true
            }
        }
        Child.metaClass.fragmentMode = { name ->
            def template = '/child' + StringUtils.firstCase(name,'Upper')
            return (name == params.fragment  ? 'edit' : 'static') + template
        }
        model["child"] = individual
        if (individual.id) {
            model['roleOwners'] = ('responsibles' != params.fragment) ? homeFolderService.listBySubjectRoles(individual.id, RoleType.childRoleTypes) : homeFolderAdaptorService.roleOwners(individual.id)
            model['currentEcitizen'] = currentEcitizen
            model['currentRoleOwnerId'] = params.roleOwnerId ? Long.valueOf(params.roleOwnerId) : 0
        } else {
            model['adults'] = homeFolderService.getAdults(currentEcitizen.homeFolder.id)
        }
        return model
    }

    def unlink = {
        def child = individualService.getById(Long.valueOf(params.id))
        def owner = individualService.getById(Long.valueOf(params.roleOwnerId))
        homeFolderService.unlink(owner, child)
        def invalidFields = individualService.validate(child)
        if (!invalidFields.isEmpty()) {
            flash['invalidFields'] = invalidFields
            session.doRollback = true
        }
        redirect(url:createLink(action:'child', params:['id':params.id, 'fragment':params.fragment]) + '#' + params.fragment)
    }

    private addAdult(individual) throws CvqValidationException {
        DataBindingUtils.initBind(individual, params)
        bind(individual)
        def invalidFields = individualService.validate(individual)
        if (!invalidFields.isEmpty())
            throw new CvqValidationException(invalidFields)
        homeFolderService.addAdult(currentEcitizen.homeFolder, individual, false)
    }

    private addChild(individual) throws CvqValidationException {
        bind(individual)
        homeFolderService.addChild(currentEcitizen.homeFolder, individual)
        params.roles.each {
            if (it.value instanceof GrailsParameterMap && it.value.owner != '' && it.value.type != '') {
                homeFolderService.link(
                    individualService.getById(Long.valueOf(it.value.owner)),
                    individual, [RoleType.forString(it.value.type)])
            }
        }
        def invalidFields = individualService.validate(individual)
        if (!invalidFields.isEmpty())
            throw new CvqValidationException(invalidFields)
    }

    // FIXME :
    private historize(fragment, individual) throws CvqValidationException {
        def fields, dto
        if (fragment == 'identity') {
            dto = individual instanceof Adult ? new Adult() : new Child()
            fields = individual instanceof Adult ?
                ["title", "familyStatus", "lastName", "maidenName", "nameOfUse", "firstName", "firstName2", "firstName3", "profession"] :
                ["born", "lastName", "firstName", "firstName2", "firstName3", "sex", "birthDate", "birthPostalCode", "birthCity", "birthCountry"]
        }
        if (fragment == 'contact') {
            dto = new Adult()
            fields = ["email", "homePhone", "mobilePhone", "officePhone"]
        }
        if (fragment == "connexion") {
            dto = new Adult()
            fields = ["question", "answer"]
        }
        if (fragment == 'address') {
            dto = new Address()
            fields = ["additionalDeliveryInformation", "additionalGeographicalInformation", "city", "cityInseeCode", "countryName", "placeNameOrService", "postalCode", "streetMatriculation", "streetName", "streetNumber", "streetRivoliCode"]
        }
        bind(dto)
        individualAdaptorService.historize(individual,
            (fragment == 'address' ? individual.address : individual), dto, fragment, fields)
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
                historize("connexion", currentEcitizen)
                flash.successMessage = message("code":"homeFolder.adult.property.question.changeSuccess")
            }
            redirect(controller : "frontofficeHomeFolder")
        }
    }
}
