import fr.cg95.cvq.business.users.*
import fr.cg95.cvq.security.SecurityContext
import fr.cg95.cvq.service.users.IHomeFolderService
import fr.cg95.cvq.service.users.IIndividualService

class HomeFolderController {

    IHomeFolderService homeFolderService
    IIndividualService individualService
    
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
    
}
