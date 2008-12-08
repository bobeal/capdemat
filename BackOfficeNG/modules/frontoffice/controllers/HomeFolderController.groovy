import fr.cg95.cvq.business.users.*
import fr.cg95.cvq.security.SecurityContext
import fr.cg95.cvq.service.users.IHomeFolderService
import fr.cg95.cvq.service.users.IIndividualService

class HomeFolderController {

    IHomeFolderService homeFolderService
    IIndividualService individualService
    
    Adult currentEcitizen = SecurityContext.getCurrentEcitizen()

    def index = {
        def result = ['adults':[], 'children': [], homeFolder: []]
        def homeFolderId = currentEcitizen.homeFolder.id
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
                'ownerRoles' : prepareOwnerRoles(adult)
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
                'childSubjectRoles' : prepareChildSubjectRoles(child)
            ])
        }
        
        result.homeFolder = [
            'state' : currentEcitizen.homeFolder.state,
            'isActive' : currentEcitizen.homeFolder.enabled ? message(code:'message.yes') : message(code:'message.no'),
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
                    'roles':prepareChildSubjectRoles(individual)]
        } else {
            return ['individual':individual, 'isChild':false, 
                    'ownerRoles':prepareOwnerRoles(individual),
                    'subjectRoles':prepareAdultSubjectRoles(individual)]
        }
    }
    
    def protected prepareChildSubjectRoles = { child ->
        def childSubjectRoles = []
        homeFolderService.getBySubjectRoles(child.id,
                [RoleType.CLR_FATHER,RoleType.CLR_MOTHER,RoleType.CLR_TUTOR] as RoleType[]).each { individual ->
            childSubjectRoles.add(['fullName': "${individual.firstName} ${individual.lastName}",
                    'roles': individual.getIndividualRoles(child.id)])
        }
        return childSubjectRoles
    }
    
    def protected prepareAdultSubjectRoles = { adult ->
        def adultSubjectRoles = []
        homeFolderService.getBySubjectRole(adult.id, RoleType.TUTOR).each { individual ->
            adultSubjectRoles.add(['fullName': "${individual.firstName} ${individual.lastName}",
                'roles': individual.getIndividualRoles(adult.id)])
        }
        return adultSubjectRoles
    }

    def protected prepareOwnerRoles = { individual ->
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
