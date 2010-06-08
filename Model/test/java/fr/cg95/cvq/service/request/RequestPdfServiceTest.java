package fr.cg95.cvq.service.request;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.lowagie.text.pdf.PdfReader;

import fr.cg95.cvq.business.document.DocumentBinary;
import fr.cg95.cvq.business.request.RequestDocument;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.security.SecurityContext;
import fr.cg95.cvq.service.document.DocumentTestCase;

public class RequestPdfServiceTest extends DocumentTestCase {
    @Autowired
    private IRequestPdfService requestPdfService;
    
    @Test
    public void testGenerateDocumentsArchive()
        throws CvqException, IOException {
        
        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.BACK_OFFICE_CONTEXT);
        SecurityContext.setCurrentAgent(agentNameWithCategoriesRoles);
        
        List<RequestDocument> documents = new ArrayList<RequestDocument>();
        
        // with image documents
        RequestDocument rqtDoc = new RequestDocument();
        rqtDoc.setDocumentId(gimmeImageDocument());
        documents.add(rqtDoc);
        rqtDoc = new RequestDocument();
        rqtDoc.setDocumentId(gimmeImageDocument());
        documents.add(rqtDoc);
        
        byte[] result = requestPdfService.generateDocumentsArchive(documents);
        
        continueWithNewTransaction();
        
        // test
        assertNotNull("Error", result);
        
        // with pdf documents
        continueWithNewTransaction();
        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.BACK_OFFICE_CONTEXT);
        SecurityContext.setCurrentAgent(agentNameWithCategoriesRoles);
        
        documents.clear();
        
        rqtDoc = new RequestDocument();
        rqtDoc.setDocumentId(gimmePdfDocument());
        documents.add(rqtDoc);
        rqtDoc = new RequestDocument();
        rqtDoc.setDocumentId(gimmePdfDocument());
        documents.add(rqtDoc);
        
        result = requestPdfService.generateDocumentsArchive(documents);
        
        continueWithNewTransaction();
        
        // test
        assertNotNull("Error", result);
        
        // with both : image and pdf documents
        continueWithNewTransaction();
        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.BACK_OFFICE_CONTEXT);
        SecurityContext.setCurrentAgent(agentNameWithCategoriesRoles);
        
        documents.clear();
        
        rqtDoc = new RequestDocument();
        rqtDoc.setDocumentId(gimmeImageDocument());
        documents.add(rqtDoc);
        rqtDoc = new RequestDocument();
        rqtDoc.setDocumentId(gimmePdfDocument());
        documents.add(rqtDoc);
        
        result = requestPdfService.generateDocumentsArchive(documents);
        
        continueWithNewTransaction();
        
        // test
        assertNotNull("Error", result);
    }
}
