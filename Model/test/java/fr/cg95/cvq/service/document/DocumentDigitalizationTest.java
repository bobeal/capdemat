package fr.cg95.cvq.service.document;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.junit.Test;

import static org.junit.Assert.*;

import fr.cg95.cvq.business.authority.LocalAuthority;
import fr.cg95.cvq.business.document.Document;
import fr.cg95.cvq.business.document.DocumentBinary;
import fr.cg95.cvq.business.users.CreationBean;
import fr.cg95.cvq.business.users.HomeFolder;
import fr.cg95.cvq.exception.CvqDisabledFunctionalityException;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.security.SecurityContext;

public class DocumentDigitalizationTest extends DocumentTestCase {

    @Test
    public void testDocumentDigitalization() throws CvqException, IOException {
        
        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.FRONT_OFFICE_CONTEXT);

        // create background data
        CreationBean cb = gimmeAnHomeFolder();
        String responsibleLogin = cb.getLogin();

        SecurityContext.setCurrentEcitizen(responsibleLogin);

        // get home folder id from request id
        HomeFolder homeFolder = homeFolderService.getById(cb.getHomeFolderId());
        Long homeFolderId = homeFolder.getId();

        // create a document
        Document doc = new Document();
        doc.setDocumentType(documentTypeService.getDocumentTypeByType(IDocumentTypeService.IDENTITY_RECEIPT_TYPE));
        doc.setHomeFolderId(homeFolderId);
        Long docId = documentService.create(doc);

        // add binary data
        DocumentBinary docBin = new DocumentBinary();
        File file = getResourceFile("health_notebook.jpg");
        byte[] data = new byte[(int) file.length()];
        FileInputStream fis = new FileInputStream(file);
        fis.read(data);
        docBin.setData(data);
        documentService.addPage(docId, docBin);
        
        LocalAuthority la = SecurityContext.getCurrentSite();
        la.setDocumentDigitalizationEnabled(false);
        try {
            documentService.addPage(docId, docBin);
            fail("should have thrown an exception");
        } catch (CvqDisabledFunctionalityException cdfe) {
            // that was expected
        }
        la.setDocumentDigitalizationEnabled(true);
    }
}
