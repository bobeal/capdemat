package fr.cg95.cvq.exporter.service.endpoint;

import java.util.List;

import org.springframework.oxm.Marshaller;
import org.springframework.ws.server.endpoint.AbstractMarshallingPayloadEndpoint;

import fr.capwebct.capdemat.GetHomeFoldersResponseDocument;
import fr.capwebct.capdemat.HomeFolderType;
import fr.capwebct.capdemat.IndividualType;
import fr.capwebct.capdemat.GetHomeFoldersResponseDocument.GetHomeFoldersResponse;

import fr.cg95.cvq.business.request.Request;
import fr.cg95.cvq.business.users.Address;
import fr.cg95.cvq.business.users.Adult;
import fr.cg95.cvq.business.users.Child;
import fr.cg95.cvq.business.users.HomeFolder;
import fr.cg95.cvq.business.users.Individual;
import fr.cg95.cvq.business.users.RoleType;
import fr.cg95.cvq.service.request.IRequestSearchService;
import fr.cg95.cvq.service.users.IHomeFolderService;

public class HomeFolderServiceEndpoint extends AbstractMarshallingPayloadEndpoint {

    private IHomeFolderService homeFolderService;
    private IRequestSearchService requestSearchService;
    
    public HomeFolderServiceEndpoint(Marshaller marshaller) {
        super(marshaller);
    }

    @Override
    protected Object invokeInternal(Object request) throws Exception {
       
       GetHomeFoldersResponseDocument responseDocument =
            GetHomeFoldersResponseDocument.Factory.newInstance();
       GetHomeFoldersResponse response = 
            responseDocument.addNewGetHomeFoldersResponse();
        List<HomeFolder> homeFolders = homeFolderService.getAll(true, true);
        for (HomeFolder homeFolder : homeFolders) {
            List<Request> voCardRequests =
                requestSearchService.getByHomeFolderIdAndRequestLabel(homeFolder.getId(),
                    "VO Card Request", false);
            if (voCardRequests == null || voCardRequests.isEmpty()) {
//               logger.debug("invokeInternal() ignoring home folder " + homeFolder.getId()
//                       + " without VO Card request");
                continue;
            }
            HomeFolderType homeFolderType = response.addNewHomeFolder();
            homeFolderType.setId(homeFolder.getId());
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
                    if (homeFolderService.hasHomeFolderRole(adult.getId(), homeFolder.getId(),
                            RoleType.HOME_FOLDER_RESPONSIBLE))
                        individualType.setIsHomeFolderResponsible(true);
                } else if (individual instanceof Child) {
                    individualType.setIsChild(true);
                }
            }
        }

        return response;
    }

    public void setHomeFolderService(IHomeFolderService homeFolderService) {
        this.homeFolderService = homeFolderService;
    }

    public void setRequestSearchService(IRequestSearchService requestSearchService) {
        this.requestSearchService = requestSearchService;
    }
}
