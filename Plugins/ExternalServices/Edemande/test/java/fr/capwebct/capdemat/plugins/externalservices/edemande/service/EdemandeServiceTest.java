package fr.capwebct.capdemat.plugins.externalservices.edemande.service;

import static org.junit.Assert.*;

import fr.cg95.cvq.business.document.Document;
import fr.cg95.cvq.business.request.school.StudyGrantRequest;
import fr.cg95.cvq.business.users.CreationBean;
import fr.cg95.cvq.business.users.HomeFolder;
import fr.cg95.cvq.security.SecurityContext;
import fr.cg95.cvq.service.document.IDocumentTypeService;
import fr.cg95.cvq.service.request.external.IRequestExternalService;
import fr.cg95.cvq.service.request.school.StudyGrantRequestFeeder;
import fr.cg95.cvq.service.request.school.StudyGrantRequestServiceTest;

public class EdemandeServiceTest extends StudyGrantRequestServiceTest {

    private IRequestExternalService requestExternalService;

    @Override
    public void onSetUp() throws Exception {
        super.onSetUp();
        requestExternalService = getApplicationBean("requestExternalService");
    }

    public void testChargerTypeDemande() throws Exception {
        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.FRONT_OFFICE_CONTEXT);

        // create a vo card request (to create home folder and associates)
        CreationBean cb = gimmeAnHomeFolderWithRequest();

        SecurityContext.setCurrentEcitizen(cb.getLogin());

        // get the home folder id
        HomeFolder homeFolder = homeFolderService.getById(cb.getHomeFolderId());
        assertNotNull(homeFolder);
        Long homeFolderId = homeFolder.getId();
        assertNotNull(homeFolderId);

        // fill and create the request
        //////////////////////////////

        StudyGrantRequest request = fillMeARequest();
        request.setRequesterId(SecurityContext.getCurrentUserId());
        request.setHomeFolderId(homeFolderId);
        StudyGrantRequestFeeder.setSubject(request, requestService.getSubjectPolicy(), null, homeFolder);
        Document document = new Document();
        document.setDocumentType(documentTypeService.getDocumentTypeByType(IDocumentTypeService.SCHOOL_CERTIFICATE_TYPE));
        document.setHomeFolderId(homeFolderId);
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
            requestWorkflowService.create(request);
        requestDocumentService.addDocument(requestId, documentId);

        try {
            requestExternalService.sendRequest(request);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

