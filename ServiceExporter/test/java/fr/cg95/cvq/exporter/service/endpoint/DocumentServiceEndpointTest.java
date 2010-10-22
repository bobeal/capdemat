package fr.cg95.cvq.exporter.service.endpoint;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import static org.junit.Assert.*;

import org.apache.axis.encoding.Base64;
import org.junit.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.xmlbeans.XmlBeansMarshaller;

import fr.capwebct.capdemat.GetDocumentListRequestDocument;
import fr.capwebct.capdemat.GetDocumentResponseDocument.GetDocumentResponse;
import fr.capwebct.capdemat.GetDocumentRequestDocument.GetDocumentRequest;
import fr.capwebct.capdemat.GetDocumentRequestDocument;
import fr.capwebct.capdemat.GetDocumentListResponseDocument.GetDocumentListResponse;
import fr.capwebct.capdemat.GetDocumentListRequestDocument.GetDocumentListRequest;
import fr.cg95.cvq.business.document.Document;
import fr.cg95.cvq.business.document.DocumentBinary;
import fr.cg95.cvq.business.document.DocumentState;
import fr.cg95.cvq.business.document.DocumentType;
import fr.cg95.cvq.business.request.Request;
import fr.cg95.cvq.business.users.CreationBean;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.exception.CvqObjectNotFoundException;
import fr.cg95.cvq.external.ExternalServiceBean;
import fr.cg95.cvq.external.IExternalProviderService;
import fr.cg95.cvq.security.SecurityContext;
import fr.cg95.cvq.service.authority.LocalAuthorityConfigurationBean;
import fr.cg95.cvq.service.document.IDocumentTypeService;
import fr.cg95.cvq.service.request.IRequestTypeService;
import fr.cg95.cvq.service.request.RequestTestCase;

public class DocumentServiceEndpointTest extends RequestTestCase {
   
    @Autowired
    private IExternalProviderService fakeExternalService;

    private String fakeExternalServiceLabel = "Fake External Service";
    
    @Override
    public void onSetUp() throws Exception {
        super.onSetUp();
        
        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.ADMIN_CONTEXT);
        
        ExternalServiceBean esb = new ExternalServiceBean();
        esb.setGenerateTracedRequest(true);
        List<String> requestTypes = new ArrayList<String>();
        requestTypes.add(IRequestTypeService.VO_CARD_REGISTRATION_REQUEST);
        esb.setRequestTypes(requestTypes);
        LocalAuthorityConfigurationBean lacb = SecurityContext.getCurrentConfigurationBean();
        lacb.registerExternalService(fakeExternalService, esb);
    }
    
    @Test
    public void testGetDocumentList() throws Exception {
        
        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.BACK_OFFICE_CONTEXT);
        SecurityContext.setCurrentAgent(agentNameWithManageRoles);
        
        /* Initialize internal variables */
        DocumentListServiceEndpoint docListEndpoint =
            new DocumentListServiceEndpoint(new XmlBeansMarshaller());
        docListEndpoint.setRequestDocumentService(requestDocumentService);

        try {
            
            CreationBean cb = this.gimmeAnHomeFolderWithRequest();
            SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.ADMIN_CONTEXT);
            Request request = requestSearchService.getById(cb.getRequestId(), false);
            requestDocumentService.addDocument(request, createDocumentForRequest(request,"pdf"));
            requestDocumentService.addDocument(request, createDocumentForRequest(request, "pdf"));
            continueWithNewTransaction();
            
            SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.BACK_OFFICE_CONTEXT);
            SecurityContext.setCurrentExternalService(fakeExternalServiceLabel);
            
            GetDocumentListRequest getDocumentRequest = GetDocumentListRequest.Factory.newInstance();
            GetDocumentListRequestDocument getDocumentListRequestDocument = 
                GetDocumentListRequestDocument.Factory.newInstance();
            
            getDocumentRequest.setRequestId(request.getId());
            getDocumentListRequestDocument.setGetDocumentListRequest(getDocumentRequest);
            continueWithNewTransaction();
            
            
            // test we get our document list
            GetDocumentListResponse getDocListResponse = 
                (GetDocumentListResponse) docListEndpoint.invokeInternal(getDocumentListRequestDocument);
            int getCountDocument = getDocListResponse.getDocumentArray().length;
            String getTypeDocument = getDocListResponse.getDocumentArray(0).getType();
            String getStateDocument = getDocListResponse.getDocumentArray(0).getState();
            Calendar getEndValidityDate = getDocListResponse.getDocumentArray(0).getEndValidityDate();
            Calendar getValidationDate = getDocListResponse.getDocumentArray(0).getValidationDate();
            DocumentType docType = 
                documentTypeService.getDocumentTypeByType(IDocumentTypeService.OLD_CNI_TYPE);
            assertEquals("Bad number of document list to response",2, getCountDocument);
            assertEquals("Bad type of document to response",docType.getName(), getTypeDocument);
            assertEquals("Bad state of document to response",DocumentState.VALIDATED.toString(), getStateDocument);
            assertNotNull("Bad end validity date of document to response", getEndValidityDate);
            assertNotNull("Bad validation date of document to response", getValidationDate);
            
        } catch (Exception e) {
            e.printStackTrace();
            fail("Unwaited exception trown : " + e.getMessage());
        }
    }
    
    @Test
    public void testGetDocumentListWithBadId() throws Exception {
        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.BACK_OFFICE_CONTEXT);
        SecurityContext.setCurrentAgent(agentNameWithManageRoles);
        
        /* Initialize internal variables */
        DocumentListServiceEndpoint docListEndpoint =
            new DocumentListServiceEndpoint(new XmlBeansMarshaller());
        docListEndpoint.setRequestDocumentService(requestDocumentService);

        try {
            SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.BACK_OFFICE_CONTEXT);
            SecurityContext.setCurrentExternalService(fakeExternalServiceLabel);
            
            GetDocumentListRequest getDocumentListRequest = GetDocumentListRequest.Factory.newInstance();
            GetDocumentListRequestDocument getDocumentListRequestDocument = GetDocumentListRequestDocument.Factory.newInstance();
            getDocumentListRequest.setRequestId(12345); // use a random id
            
            getDocumentListRequestDocument.setGetDocumentListRequest(getDocumentListRequest);
            continueWithNewTransaction();
            
            SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.BACK_OFFICE_CONTEXT);
            SecurityContext.setCurrentAgent(agentNameWithManageRoles);
            
            GetDocumentListResponse getDocListResponse = 
                (GetDocumentListResponse) docListEndpoint.invokeInternal(getDocumentListRequestDocument);
            
            String getError = getDocListResponse.getError();
            assertEquals("Problem, no error permissions","Access denied! No permissions granted", getError);
            
        } catch (Exception e) {
            e.printStackTrace();
            fail("Unwaited exception trown : " + e.getMessage());
        }
    }
    
    @Test
    public void testGetDocument() throws Exception {
        
        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.BACK_OFFICE_CONTEXT);
        SecurityContext.setCurrentAgent(agentNameWithManageRoles);
        
        /* Initialize internal variables */
        DocumentServiceEndpoint docEndpoint =
            new DocumentServiceEndpoint(new XmlBeansMarshaller());
        docEndpoint.setRequestDocumentService(requestDocumentService);

        try {
            CreationBean cb = this.gimmeAnHomeFolderWithRequest();
            Request request = requestSearchService.getById(cb.getRequestId(), false);
            Long documentId = createDocumentForRequest(request,"pdf");
            requestDocumentService.addDocument(request, documentId);
            continueWithNewTransaction();
            
            SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.BACK_OFFICE_CONTEXT);
            SecurityContext.setCurrentExternalService(fakeExternalServiceLabel);
            
            GetDocumentRequest getDocumentRequest = GetDocumentRequest.Factory.newInstance();
            GetDocumentRequestDocument getDocumentRequestDocument = 
                GetDocumentRequestDocument.Factory.newInstance();
            
            getDocumentRequest.setDocumentId(documentId);
            getDocumentRequest.setRequestId(request.getId());
            getDocumentRequest.setMergeDocument(false);
            getDocumentRequestDocument.setGetDocumentRequest(getDocumentRequest);
            continueWithNewTransaction();
            
            // test we get our document list
            GetDocumentResponse getDocResponse = 
                (GetDocumentResponse) docEndpoint.invokeInternal(getDocumentRequestDocument);
            
            assertEquals(2, getDocResponse.getDocumentBinaryArray().length);
            int getLenghtResponseBinaryDocument = 
                Base64.decode(new String(getDocResponse.getDocumentBinaryArray(0))).length;
            
            SecurityContext.setCurrentAgent(agentNameWithManageRoles);
            
            int getLenghtBinaryDocument = 
                documentService.getById(documentId).getDatas().get(0).getData().length;
            assertEquals("Bad number of document list to response", 
                    getLenghtBinaryDocument, getLenghtResponseBinaryDocument);
            
        } catch (Exception e) {
            e.printStackTrace();
            fail("Unwaited exception trown : " + e.getMessage());
        }
    }
    
    @Test
    public void testGetDocumentWithMergeDocument() throws Exception {

        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.BACK_OFFICE_CONTEXT);
        SecurityContext.setCurrentAgent(agentNameWithManageRoles);
        
        /* Initialize internal variables */
        DocumentServiceEndpoint docEndpoint =
            new DocumentServiceEndpoint(new XmlBeansMarshaller());
        docEndpoint.setRequestDocumentService(requestDocumentService);

        try {
            CreationBean cb = this.gimmeAnHomeFolderWithRequest();
            Request request = requestSearchService.getById(cb.getRequestId(), false);
            Long documentId = createDocumentForRequest(request,"image");
            requestDocumentService.addDocument(request, documentId);
            continueWithNewTransaction();
            
            SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.BACK_OFFICE_CONTEXT);
            SecurityContext.setCurrentExternalService(fakeExternalServiceLabel);
            
            GetDocumentRequest getDocumentRequest = GetDocumentRequest.Factory.newInstance();
            GetDocumentRequestDocument getDocumentRequestDocument = 
                GetDocumentRequestDocument.Factory.newInstance();
            
            getDocumentRequest.setDocumentId(documentId);
            getDocumentRequest.setRequestId(request.getId());
            getDocumentRequest.setMergeDocument(true);
            getDocumentRequestDocument.setGetDocumentRequest(getDocumentRequest);
            continueWithNewTransaction();
            
            // test we get our document list
            GetDocumentResponse getDocResponse = 
                (GetDocumentResponse) docEndpoint.invokeInternal(getDocumentRequestDocument);
            
            assertEquals(1, getDocResponse.getDocumentBinaryArray().length);
            int getLenghtResponseBinaryDocument = 
                Base64.decode(new String(getDocResponse.getDocumentBinaryArray(0))).length;
            
            SecurityContext.setCurrentAgent(agentNameWithManageRoles);
            
            int getLenghtBinaryDocument = 
                documentService.getById(documentId).getDatas().get(0).getData().length;
            assertEquals("Bad number of document list to response", 
                    getLenghtBinaryDocument, getLenghtResponseBinaryDocument);
            
        } catch (Exception e) {
            e.printStackTrace();
            fail("Unwaited exception trown : " + e.getMessage());
        }
    }
    
    @Test
    public void testGetDocumentWithBadId() throws Exception {
        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.BACK_OFFICE_CONTEXT);
        SecurityContext.setCurrentAgent(agentNameWithManageRoles);
        
        /* Initialize internal variables */
        DocumentServiceEndpoint docEndpoint =
            new DocumentServiceEndpoint(new XmlBeansMarshaller());
        docEndpoint.setRequestDocumentService(requestDocumentService);

        try {
            SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.BACK_OFFICE_CONTEXT);
            SecurityContext.setCurrentExternalService(fakeExternalServiceLabel);
            
            GetDocumentRequest getDocumentRequest = GetDocumentRequest.Factory.newInstance();
            GetDocumentRequestDocument getDocumentRequestDocument = GetDocumentRequestDocument.Factory.newInstance();
            getDocumentRequest.setRequestId(12345); // use a random id
            getDocumentRequest.setDocumentId(12345); // use a random id
            
            getDocumentRequestDocument.setGetDocumentRequest(getDocumentRequest);
            continueWithNewTransaction();
            
            SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.BACK_OFFICE_CONTEXT);
            SecurityContext.setCurrentAgent(agentNameWithManageRoles);
            
            GetDocumentResponse getDocResponse = 
                (GetDocumentResponse) docEndpoint.invokeInternal(getDocumentRequestDocument);
            
            String getError = getDocResponse.getError();
            assertEquals("Problem, no error permissions","Access denied! No permissions granted", getError);
            
        } catch (Exception e) {
            e.printStackTrace();
            fail("Unwaited exception trown : " + e.getMessage());
        }
    }
    
    @Test
    public void testGetDocumentWithJustPdf() throws Exception {
        
        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.BACK_OFFICE_CONTEXT);
        SecurityContext.setCurrentAgent(agentNameWithManageRoles);
        
        /* Initialize internal variables */
        DocumentServiceEndpoint docEndpoint =
            new DocumentServiceEndpoint(new XmlBeansMarshaller());
        docEndpoint.setRequestDocumentService(requestDocumentService);

        try {
            CreationBean cb = this.gimmeAnHomeFolderWithRequest();
            Request request = requestSearchService.getById(cb.getRequestId(), false);
            continueWithNewTransaction();
            
            SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.BACK_OFFICE_CONTEXT);
            SecurityContext.setCurrentExternalService(fakeExternalServiceLabel);
            
            GetDocumentRequest getDocumentRequest = GetDocumentRequest.Factory.newInstance();
            GetDocumentRequestDocument getDocumentRequestDocument = 
                GetDocumentRequestDocument.Factory.newInstance();
            
            getDocumentRequest.setRequestId(request.getId());
            getDocumentRequest.setPdfSummary(true);
            getDocumentRequest.setMergeDocument(false);
            getDocumentRequestDocument.setGetDocumentRequest(getDocumentRequest);
            continueWithNewTransaction();
            
            // test we get our pdf
            GetDocumentResponse getDocResponse = 
                (GetDocumentResponse) docEndpoint.invokeInternal(getDocumentRequestDocument);
            
            assertNotNull("The list of document retun is null", getDocResponse.getDocumentBinaryArray());
            assertEquals("There isn't only one document", 1, getDocResponse.getDocumentBinaryArray().length);
            
        } catch (Exception e) {
            e.printStackTrace();
            fail("Unwaited exception trown : " + e.getMessage());
        }
    }
    
    @Test
    public void testGetDocumentWithDocumentAndPdf() throws Exception {
        
        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.BACK_OFFICE_CONTEXT);
        SecurityContext.setCurrentAgent(agentNameWithManageRoles);
        
        /* Initialize internal variables */
        DocumentServiceEndpoint docEndpoint =
            new DocumentServiceEndpoint(new XmlBeansMarshaller());
        docEndpoint.setRequestDocumentService(requestDocumentService);

        try {
            CreationBean cb = this.gimmeAnHomeFolderWithRequest();
            Request request = requestSearchService.getById(cb.getRequestId(), false);
            Long documentId = createDocumentForRequest(request,"image");
            requestDocumentService.addDocument(request, documentId);
            continueWithNewTransaction();
            
            SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.BACK_OFFICE_CONTEXT);
            SecurityContext.setCurrentExternalService(fakeExternalServiceLabel);
            
            GetDocumentRequest getDocumentRequest = GetDocumentRequest.Factory.newInstance();
            GetDocumentRequestDocument getDocumentRequestDocument = 
                GetDocumentRequestDocument.Factory.newInstance();
            
            getDocumentRequest.setDocumentId(documentId);
            getDocumentRequest.setRequestId(request.getId());
            getDocumentRequest.setMergeDocument(true);
            getDocumentRequest.setPdfSummary(true);
            getDocumentRequestDocument.setGetDocumentRequest(getDocumentRequest);
            continueWithNewTransaction();
            
            // test we get our document and pdf
            GetDocumentResponse getDocResponse = 
                (GetDocumentResponse) docEndpoint.invokeInternal(getDocumentRequestDocument);
            
            assertEquals("Problem : we don't have two document", 2, getDocResponse.getDocumentBinaryArray().length);
            
        } catch (Exception e) {
            e.printStackTrace();
            fail("Unwaited exception trown : " + e.getMessage());
        }
    }
    
    private Long createDocumentForRequest(Request request, String contentType) 
        throws CvqObjectNotFoundException, CvqException, IOException {
        DocumentType docType = 
            documentTypeService.getDocumentTypeByType(IDocumentTypeService.OLD_CNI_TYPE);
        Document doc = new Document(request.getHomeFolderId(), null, docType, null);
        Long docId = documentService.create(doc);
        documentService.updateDocumentState(docId, DocumentState.VALIDATED,"", new Date());
        DocumentBinary page = new DocumentBinary();
        File file;
        if (contentType.equals("pdf")) {
            file = getResourceFile("test.pdf");
        } else {
            file = getResourceFile("health_notebook.jpg");
        }
        byte[] data = new byte[(int) file.length()];
        FileInputStream fis = new FileInputStream(file);
        fis.read(data);
        page.setData(data);
        documentService.addPage(docId, page);
        page = new DocumentBinary();
        page.setData(data);
        documentService.addPage(docId, page);
        return docId;
    }
    

}
