package fr.cg95.cvq.exporter.service.endpoint;

import org.springframework.oxm.Marshaller;

import fr.capwebct.capdemat.HomeFolderMappingRequestDocument;
import fr.capwebct.capdemat.HomeFolderMappingType;
import fr.capwebct.capdemat.IndividualMappingType;
import fr.capwebct.capdemat.HomeFolderMappingRequestDocument.HomeFolderMappingRequest;
import fr.cg95.cvq.business.external.ExternalServiceIdentifierMapping;
import fr.cg95.cvq.business.external.ExternalServiceIndividualMapping;
import fr.cg95.cvq.external.IExternalService;
import fr.cg95.cvq.security.SecurityContext;

public class HomeFolderMappingServiceEndpoint extends SecuredServiceEndpoint {

    private IExternalService externalService;

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
        ExternalServiceIdentifierMapping esim = 
            externalService.getIdentifierMapping(currentExternalService, homeFolderMappingType.getExternalCapDematId());
        externalService.addHomeFolderMapping(currentExternalService, esim.getHomeFolderId(), 
                homeFolderMappingType.getExternalId());
        IndividualMappingType[] individualMappingTypes = homeFolderMappingRequest.getIndividualMappingArray();
        for (int i = 0; i < individualMappingTypes.length; i++) {
            for (ExternalServiceIndividualMapping indMapping : esim.getIndividualsMappings()) {
                if (indMapping.getExternalCapDematId().equals(individualMappingTypes[i].getExternalCapDematId()))
                    externalService.setExternalId(currentExternalService, esim.getHomeFolderId(), 
                            indMapping.getIndividualId(), 
                            individualMappingTypes[i].getExternalId());
            }
        }
        
        // Reset to original context
        SecurityContext.setCurrentContext(SecurityContext.BACK_OFFICE_CONTEXT);
        SecurityContext.setCurrentExternalService(currentExternalService);

        return null;
    }

    public void setExternalService(IExternalService externalService) {
        this.externalService = externalService;
    }
}
