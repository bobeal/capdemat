package fr.capwebct.capdemat.plugins.externalservices.edemande.service;

import fr.cg95.cvq.business.document.Document;
import fr.cg95.cvq.business.request.school.StudyGrantRequest;
import fr.cg95.cvq.business.users.CreationBean;
import fr.cg95.cvq.business.users.HomeFolder;
import fr.cg95.cvq.external.IExternalService;
import fr.cg95.cvq.security.SecurityContext;
import fr.cg95.cvq.service.document.IDocumentTypeService;
import fr.cg95.cvq.service.request.school.StudyGrantRequestFeeder;
import fr.cg95.cvq.service.request.school.StudyGrantRequestServiceTest;

public class EdemandeServiceTest extends StudyGrantRequestServiceTest {

    private IExternalService externalService;

    protected void onSetUp() throws Exception {
        super.onSetUp();
        externalService = getApplicationBean("externalService");
    }

    public void testChargerTypeDemande() throws Exception {
        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.FRONT_OFFICE_CONTEXT);

        // create a vo card request (to create home folder and associates)
        CreationBean cb = gimmeAnHomeFolder();

        SecurityContext.setCurrentEcitizen(cb.getLogin());

        // get the home folder id
        HomeFolder homeFolder = iHomeFolderService.getById(cb.getHomeFolderId());
        assertNotNull(homeFolder);
        Long homeFolderId = homeFolder.getId();
        assertNotNull(homeFolderId);

        // fill and create the request
        //////////////////////////////

        StudyGrantRequest request = fillMeARequest();
        request.setRequesterId(SecurityContext.getCurrentUserId());
        request.setHomeFolderId(homeFolderId);
        StudyGrantRequestFeeder.setSubject(request, 
            iStudyGrantRequestService.getSubjectPolicy(), null, homeFolder);
        Document document = new Document();
        document.setDocumentType(iDocumentTypeService.getDocumentTypeByType(IDocumentTypeService.SCHOOL_CERTIFICATE_TYPE));
        document.setHomeFolderId(homeFolderId);
        document.setIndividualId(request.getSubjectId());
        Long documentId = iDocumentService.create(document);
        //DocumentBinary documentBinary = new DocumentBinary();
        //File file = getResourceFile("zenexity.png");
        //byte[] data = new byte[(int) file.length()];
        //FileInputStream fis = new FileInputStream(file);
        //fis.read(data);
        //documentBinary.setData(data);
        //iDocumentService.addPage(documentId, documentBinary);
        //document.setDatas(null);
        Long requestId =
            iStudyGrantRequestService.create(request);
        iStudyGrantRequestService.addDocument(requestId, documentId);

        try {
            externalService.sendRequest(request);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

