import fr.cg95.cvq.business.users.*
import fr.cg95.cvq.security.SecurityContext
import fr.cg95.cvq.service.users.IHomeFolderService

class HomeFolderController {

    IHomeFolderService homeFolderService
    Adult currentEcitizen;

    def beforeInterceptor = {
        this.currentEcitizen = SecurityContext.getCurrentEcitizen();
    }
    
    def index = {
        def result = ['adults':[], 'children': [], homeFolder: []]
        def homeFolderId = currentEcitizen.homeFolder.id
        homeFolderService.getAdults(homeFolderId).each {
            result.adults.add([
                'id' : it.id,
                'title' : message('code':"homeFolder.adult.title.${it.title.toString().toLowerCase()}"),
                'fullName' : "${it.firstName} ${it.lastName}",
                'email' : it.email,
                'homePhone' : it.homePhone,
                'mobilePhone' : it.mobilePhone,
                'birthDate' : it.birthDate,
                'birthCountry' : it.birthCountry,
                'birthPostalCode' : it.birthPostalCode,
                'birthCity' : it.birthCity,
                'addressDetails' : "${it.adress.streetNumber} "+
                    "${it.adress.streetName} "+
                    "${it.adress.postalCode} "+
                    "${it.adress.city}"
            ])
        }
        homeFolderService.getChildren(homeFolderId).each{
            def rs = []
            homeFolderService.getBySubjectRoles(it.id,
                [RoleType.CLR_FATHER,RoleType.CLR_MOTHER,RoleType.CLR_TUTOR] as RoleType[]).each {
                rs.add(['fullName': "${it.firstName} ${it.lastName}"])
            }
            result.children.add([
                'id' : it.id,
                'sex' : it.sex,
                'fullName' : "${it.firstName} ${it.lastName}",
                'birthDate' : it.birthDate,
                'birthCountry' : it.birthCountry,
                'birthPostalCode' : it.birthPostalCode,
                'birthCity' : it.birthCity,
                'responsables' : rs,
                'addressDetails' : "${it.adress.streetNumber} "+
                    "${it.adress.streetName} "+
                    "${it.adress.postalCode} "+
                    "${it.adress.city}"
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
//        homeFolderService.getBySubjectRoles()
        return result
    }
}
