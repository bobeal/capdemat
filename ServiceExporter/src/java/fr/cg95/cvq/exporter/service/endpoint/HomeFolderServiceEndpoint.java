package fr.cg95.cvq.exporter.service.endpoint;

import java.util.Set;

import org.apache.log4j.Logger;
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
import fr.cg95.cvq.business.users.RoleEnum;
import fr.cg95.cvq.service.users.IHomeFolderService;

public class HomeFolderServiceEndpoint extends AbstractMarshallingPayloadEndpoint{

    private Logger logger = Logger.getLogger(HomeFolderServiceEndpoint.class);
    
    private IHomeFolderService homeFolderService;
    
    public HomeFolderServiceEndpoint(Marshaller marshaller) {
        super(marshaller);
    }

   @Override
    protected Object invokeInternal(Object request) throws Exception {
       logger.debug("invokeInternal() received request : " + request);
       
       GetHomeFoldersResponseDocument responseDocument =
            GetHomeFoldersResponseDocument.Factory.newInstance();
       GetHomeFoldersResponse response = 
            responseDocument.addNewGetHomeFoldersResponse();
        Set<HomeFolder> homeFolders = homeFolderService.getAll();
        for (HomeFolder homeFolder : homeFolders) {
            HomeFolderType homeFolderType = response.addNewHomeFolder();
            homeFolderType.setId(homeFolder.getId());
            // TODO : better porting
            Address address = homeFolder.getAdress();
            homeFolderType.setAddress(address.getStreetNumber() + " " + address.getStreetName());
            for (Object object : homeFolder.getIndividuals()) {
                Individual individual = (Individual) object;
                IndividualType individualType = homeFolderType.addNewIndividual();
                individualType.setId(individual.getId());
                individualType.setFirstName(individual.getFirstName());
                individualType.setLastName(individual.getLastName());
                if (individual instanceof Adult) {
                    Adult adult = (Adult) individual;
                    if (adult.hasHomeFolderRole(RoleEnum.HOME_FOLDER_RESPONSIBLE))
                        individualType.setIsHomeFolderResponsible(true);
                } else if (individual instanceof Child) {
                    individualType.setIsChild(true);
                }
            }
        }

        logger.debug("invokeInternal() returning " + response.toString());
        return response;
    }

    public void setHomeFolderService(IHomeFolderService homeFolderService) {
        this.homeFolderService = homeFolderService;
    }
}
