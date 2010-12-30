package fr.cg95.cvq.external.endpoint;

import org.springframework.oxm.Marshaller;

import fr.capwebct.capdemat.HomeFolderMappingRequestDocument;
import fr.capwebct.capdemat.HomeFolderMappingType;
import fr.capwebct.capdemat.IndividualMappingType;
import fr.capwebct.capdemat.HomeFolderMappingRequestDocument.HomeFolderMappingRequest;
import fr.cg95.cvq.business.users.external.HomeFolderMapping;
import fr.cg95.cvq.business.users.external.IndividualMapping;
import fr.cg95.cvq.security.SecurityContext;
import fr.cg95.cvq.service.users.external.IExternalHomeFolderService;

public class HomeFolderMappingServiceEndpoint extends SecuredServiceEndpoint {

    private IExternalHomeFolderService externalHomeFolderService;

    public HomeFolderMappingServiceEndpoint(Marshaller marshaller) {
        super(marshaller);
    }

    @Override
    protected Object invokeInternal(Object arg0) throws Exception {

        HomeFolderMappingRequest homeFolderMappingRequest =
            ((HomeFolderMappingRequestDocument) arg0).getHomeFolderMappingRequest();

        // Switch to admin context to be able to call services without permission exceptions
        String currentExternalService = SecurityContext.getCurrentExternalService();
        SecurityContext.setCurrentContext(SecurityContext.ADMIN_CONTEXT);

        HomeFolderMappingType homeFolderMappingType = homeFolderMappingRequest.getHomeFolderMapping();
        HomeFolderMapping esim = 
            externalHomeFolderService.getHomeFolderMapping(currentExternalService, homeFolderMappingType.getExternalCapDematId());
        externalHomeFolderService.addHomeFolderMapping(currentExternalService, esim.getHomeFolderId(), 
                homeFolderMappingType.getExternalId());
        IndividualMappingType[] individualMappingTypes = homeFolderMappingRequest.getIndividualMappingArray();
        for (int i = 0; i < individualMappingTypes.length; i++) {
            for (IndividualMapping indMapping : esim.getIndividualsMappings()) {
                if (indMapping.getExternalCapDematId().equals(individualMappingTypes[i].getExternalCapDematId()))
                    externalHomeFolderService.setExternalId(currentExternalService, esim.getHomeFolderId(), 
                            indMapping.getIndividualId(), 
                            individualMappingTypes[i].getExternalId());
            }
        }
        
        // Reset to original context
        SecurityContext.setCurrentContext(SecurityContext.BACK_OFFICE_CONTEXT);
        SecurityContext.setCurrentExternalService(currentExternalService);

        return null;
    }

    public void setExternalHomeFolderService(IExternalHomeFolderService externalHomeFolderService) {
        this.externalHomeFolderService = externalHomeFolderService;
    }
}
