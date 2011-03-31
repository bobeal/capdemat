package fr.cg95.cvq.external.endpoint;

import java.util.List;

import org.springframework.oxm.Marshaller;
import org.springframework.ws.server.endpoint.AbstractMarshallingPayloadEndpoint;

import fr.capwebct.capdemat.GetHomeFoldersResponseDocument;
import fr.capwebct.capdemat.HomeFolderType;
import fr.capwebct.capdemat.IndividualType;
import fr.capwebct.capdemat.GetHomeFoldersResponseDocument.GetHomeFoldersResponse;

import fr.cg95.cvq.business.users.Address;
import fr.cg95.cvq.business.users.Adult;
import fr.cg95.cvq.business.users.Child;
import fr.cg95.cvq.business.users.HomeFolder;
import fr.cg95.cvq.business.users.Individual;
import fr.cg95.cvq.business.users.RoleType;
import fr.cg95.cvq.security.SecurityContext;
import fr.cg95.cvq.service.users.IHomeFolderService;

public class HomeFolderServiceEndpoint extends AbstractMarshallingPayloadEndpoint {

    private IHomeFolderService homeFolderService;
    
    public HomeFolderServiceEndpoint(Marshaller marshaller) {
        super(marshaller);
    }

    @Override
    protected Object invokeInternal(Object request) throws Exception {
       
       GetHomeFoldersResponseDocument responseDocument =
            GetHomeFoldersResponseDocument.Factory.newInstance();
       GetHomeFoldersResponse response = 
            responseDocument.addNewGetHomeFoldersResponse();
        //Switch to admin context to be able to call services without permission exceptions
        String currentExternalService = SecurityContext.getCurrentExternalService();
        SecurityContext.setCurrentContext(SecurityContext.ADMIN_CONTEXT);
        List<HomeFolder> homeFolders = homeFolderService.getAll(true, true);
        for (HomeFolder homeFolder : homeFolders) {
            HomeFolderType homeFolderType = response.addNewHomeFolder();
            homeFolderType.setId(homeFolder.getId());
            Address address = homeFolder.getAddress();
            homeFolderType.setAddress(address.getStreetNumber() + " " + address.getStreetName());
            for (Object object : homeFolder.getIndividuals()) {
                Individual individual = (Individual) object;
                IndividualType individualType = homeFolderType.addNewIndividual();
                individualType.setId(individual.getId());
                individualType.setFirstName(individual.getFirstName());
                individualType.setLastName(individual.getLastName());
                if (individual instanceof Adult) {
                    Adult adult = (Adult) individual;
                    if (homeFolderService.hasHomeFolderRole(adult.getId(), homeFolder.getId(),
                            RoleType.HOME_FOLDER_RESPONSIBLE))
                        individualType.setIsHomeFolderResponsible(true);
                } else if (individual instanceof Child) {
                    individualType.setIsChild(true);
                }
            }
        }

       // Reset to original context
       SecurityContext.setCurrentContext(SecurityContext.BACK_OFFICE_CONTEXT);
       SecurityContext.setCurrentExternalService(currentExternalService);

       return response;
    }

    public void setHomeFolderService(IHomeFolderService homeFolderService) {
        this.homeFolderService = homeFolderService;
    }
}
