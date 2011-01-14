import fr.cg95.cvq.business.users.RoleType
import fr.cg95.cvq.service.users.IHomeFolderService
import fr.cg95.cvq.service.users.IIndividualService

class HomeFolderAdaptorService {

    IHomeFolderService homeFolderService
    IIndividualService individualService

    public prepareAdultSubjectRoles(adult ) {
        def adultSubjectRoles = []
        homeFolderService.getBySubjectRole(adult.id, RoleType.TUTOR).each { individual ->
            adultSubjectRoles.add(['fullName': "${individual.firstName} ${individual.lastName}",
                'roles': individual.getIndividualRoles(adult.id)])
        }
        return adultSubjectRoles
    }

    public prepareOwnerRoles(individual) {
        def ownerRoles = ['homeFolder':[],'individual':[]]
        individual.individualRoles.each { individualRole ->
            if (individualRole.individualId) {
                def subject = individualService.getById(individualRole.individualId)
                ownerRoles.individual.add(['role':individualRole.role, 
                                           'subjectName':subject.firstName + " " + subject.lastName])
            } else {
                ownerRoles.homeFolder.add(['role':individualRole.role])                
            }
        }
        return ownerRoles
    }
}
