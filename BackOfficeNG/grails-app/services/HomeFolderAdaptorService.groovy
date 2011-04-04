import fr.cg95.cvq.business.users.RoleType
import fr.cg95.cvq.business.users.UserAction
import fr.cg95.cvq.business.users.UserState
import fr.cg95.cvq.service.users.IUserSearchService
import fr.cg95.cvq.util.UserUtils
import fr.cg95.cvq.util.translation.ITranslationService

import grails.converters.JSON

class HomeFolderAdaptorService {

    IUserSearchService userSearchService
    ITranslationService translationService

    public prepareAdultSubjectRoles(adult) {
        def adultSubjectRoles = []
        userSearchService.listBySubjectRole(adult.id, RoleType.TUTOR).each { individual ->
            adultSubjectRoles.add(['fullName': "${individual.firstName} ${individual.lastName}",
                'roles': individual.getIndividualRoles(adult.id)])
        }
        return adultSubjectRoles
    }

    public prepareOwnerRoles(individual) {
        def ownerRoles = ['homeFolder':[],'individual':[]]
        individual.individualRoles.each { individualRole ->
            if (individualRole.individualId) {
                def subject = userSearchService.getById(individualRole.individualId)
                ownerRoles.individual.add(['role':individualRole.role, 
                                           'subjectName':subject.firstName + " " + subject.lastName])
            } else {
                ownerRoles.homeFolder.add(['role':individualRole.role])                
            }
        }
        return ownerRoles
    }

    public roleOwners(subjectId) {
        def roleOwners = []
        (userSearchService.getAdults(userSearchService.getById(subjectId).homeFolder.id).findAll{ it.state != UserState.ARCHIVED }).each { adult ->
            def roleOwner = ['adult':adult, 'roles':[]]
            if (!adult.getIndividualRoles(subjectId).isEmpty()) {
                adult.getIndividualRoles(subjectId).each { individualRole ->
                    roleOwner['roles'].add(individualRole.role)
                }
            }
            roleOwners.add(roleOwner)
        }
        return roleOwners
    }

    public prepareActions(actions) {
        if (!actions) actions = []
        return actions.collect { prepareAction(it) }
    }

    public prepareAction(action) {
        if (!action) return null
        def result = [
            "type" : CapdematUtils.adaptCapdematEnum(action.type, "userAction.type"),
            "date" : action.date,
            "note" : action.note
        ]
        if (action.data) {
            JSON.parse(action.data).each {
                switch (it.key) {
                    case "state" :
                        result.state = CapdematUtils.adaptCapdematEnum(it.value, "user.state")
                        break
                    case "quality" :
                        result.state = CapdematUtils.adaptCapdematEnum(it.value, "qoS.quality")
                        break
                    case "user" : 
                        result.user = it.value
                        result.user.nature = UserUtils.getNature(action.userId)
                        break;
                    default :
                        result.(it.key) = it.value
                        break
                }
            }
        }
        return result
    }
}
