package fr.capwebct.capdemat.plugins.externalservices.edemande.service;

import org.springframework.beans.factory.annotation.Autowired;

import fr.cg95.cvq.business.document.Document;
import fr.cg95.cvq.business.request.school.StudyGrantRequest;
import fr.cg95.cvq.security.SecurityContext;
import fr.cg95.cvq.service.document.IDocumentTypeService;
import fr.cg95.cvq.service.request.RequestTestCase;
import fr.cg95.cvq.service.request.external.IRequestExternalService;
import fr.cg95.cvq.service.request.school.impl.StudyGrantRequestService;

public class EdemandeServiceTest extends RequestTestCase {

    private IRequestExternalService requestExternalService;

    @Autowired
    private StudyGrantRequestService studyGrantRequestService;

    @Override
    public void onSetUp() throws Exception {
        super.onSetUp();
        requestExternalService = getApplicationBean("requestExternalService");
    }

    public void testChargerTypeDemande() throws Exception {
        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.FRONT_OFFICE_CONTEXT);
        SecurityContext.setCurrentEcitizen(fake.responsibleId);

        // fill and create the request
        //////////////////////////////

        StudyGrantRequest request = (StudyGrantRequest)requestWorkflowService.getSkeletonRequest(
                studyGrantRequestService.getLabel());
        request.setRequesterId(SecurityContext.getCurrentUserId());
        request.setHomeFolderId(fake.id);
        request.setSubjectId(fake.childId);
        Document document = new Document();
        document.setDocumentType(documentTypeService.getDocumentTypeByType(IDocumentTypeService.SCHOOL_CERTIFICATE_TYPE));
        document.setHomeFolderId(fake.id);
        document.setIndividualId(request.getSubjectId());
        Long documentId = documentService.create(document);
        //DocumentBinary documentBinary = new DocumentBinary();
        //File file = getResourceFile("zenexity.png");
        //byte[] data = new byte[(int) file.length()];
        //FileInputStream fis = new FileInputStream(file);
        //fis.read(data);
        //documentBinary.setData(data);
        //iDocumentService.addPage(documentId, documentBinary);
        //document.setDatas(null);
        Long requestId =
            requestWorkflowService.create(request, null, null, null);
        requestDocumentService.addDocument(requestId, documentId);

        try {
            requestExternalService.sendRequest(request);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

