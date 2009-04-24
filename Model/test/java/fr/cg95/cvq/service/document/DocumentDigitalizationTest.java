package fr.cg95.cvq.service.document;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import fr.cg95.cvq.business.authority.LocalAuthority;
import fr.cg95.cvq.business.document.Document;
import fr.cg95.cvq.business.document.DocumentBinary;
import fr.cg95.cvq.business.users.CreationBean;
import fr.cg95.cvq.business.users.HomeFolder;
import fr.cg95.cvq.exception.CvqDisabledFunctionalityException;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.security.SecurityContext;
import fr.cg95.cvq.testtool.ServiceTestCase;

public class DocumentDigitalizationTest extends ServiceTestCase {

    public void testDocumentDigitalization() throws CvqException, IOException {
        
        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.FRONT_OFFICE_CONTEXT);

        // create background data
        CreationBean cb = gimmeAnHomeFolder();
        String responsibleLogin = cb.getLogin();

        SecurityContext.setCurrentEcitizen(responsibleLogin);

        // get home folder id from request id
        HomeFolder homeFolder = iHomeFolderService.getById(cb.getHomeFolderId());
        Long homeFolderId = homeFolder.getId();

        // create a document
        Document doc = new Document();
        doc.setDocumentType(iDocumentTypeService.getDocumentTypeByType(IDocumentTypeService.IDENTITY_RECEIPT_TYPE));
        doc.setHomeFolderId(homeFolderId);
        Long docId = iDocumentService.create(doc);

        // add binary data
        DocumentBinary docBin = new DocumentBinary();
        File file = getResourceFile("health_notebook.jpg");
        byte[] data = new byte[(int) file.length()];
        FileInputStream fis = new FileInputStream(file);
        fis.read(data);
        docBin.setData(data);
        iDocumentService.addPage(docId, docBin);
        
        LocalAuthority la = SecurityContext.getCurrentSite();
        la.setDocumentDigitalizationEnabled(false);
        try {
            iDocumentService.addPage(docId, docBin);
            fail("should have thrown an exception");
        } catch (CvqDisabledFunctionalityException cdfe) {
            // that was expected
        }
    }
}
