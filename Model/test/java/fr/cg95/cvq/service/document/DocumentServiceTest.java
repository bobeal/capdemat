package fr.cg95.cvq.service.document;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Hashtable;
import java.util.List;
import java.util.Set;

import junit.framework.Assert;

import fr.cg95.cvq.business.document.DepositOrigin;
import fr.cg95.cvq.business.document.DepositType;
import fr.cg95.cvq.business.document.Document;
import fr.cg95.cvq.business.document.DocumentBinary;
import fr.cg95.cvq.business.document.DocumentType;
import fr.cg95.cvq.business.users.CreationBean;
import fr.cg95.cvq.business.users.HomeFolder;
import fr.cg95.cvq.business.users.Individual;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.security.PermissionException;
import fr.cg95.cvq.security.SecurityContext;
import fr.cg95.cvq.service.document.IDocumentService;

/**
 * The tests for the {@link IDocumentService document service}.
 *
 * @author bor@zenexity.fr
 */
public class DocumentServiceTest extends DocumentTestCase {

    public void testAll()
        throws CvqException, java.io.IOException, java.io.FileNotFoundException {

        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.FRONT_OFFICE_CONTEXT);

        // ensure document digitalization is enabled
        assertTrue(SecurityContext.getCurrentSite().isDocumentDigitalizationEnabled());
        
        // ensure all document types have been bootstrapped
        List<DocumentType> allDocumentTypes = iDocumentTypeService.getAllDocumentTypes();
        assertEquals(36, allDocumentTypes.size());
        
        // create background data
        CreationBean cb = gimmeAnHomeFolder();
        String responsibleLogin = cb.getLogin();

        SecurityContext.setCurrentEcitizen(responsibleLogin);

        Individual anIndividual = iHomeFolderService.getAdults(cb.getHomeFolderId()).get(0);

        // create a document
        Document doc = new Document();
        doc.setDepositId(anIndividual.getId());
        doc.setDepositOrigin(DepositOrigin.ECITIZEN);
        doc.setDepositType(DepositType.PC);
        doc.setDocumentType(iDocumentTypeService.getDocumentTypeByType(IDocumentTypeService.IDENTITY_RECEIPT_TYPE));
        doc.setHomeFolderId(cb.getHomeFolderId());
        doc.setIndividualId(anIndividual.getId());
        Long docId = iDocumentService.create(doc);

        // add binary data
        DocumentBinary docBin = new DocumentBinary();
        File file = getResourceFile("health_notebook.jpg");
        byte[] data = new byte[(int) file.length()];
        FileInputStream fis = new FileInputStream(file);
        fis.read(data);
        docBin.setData(data);
        iDocumentService.addPage(docId, docBin);

        // and another one ...
        docBin = new DocumentBinary();
        docBin.setData(data);
        iDocumentService.addPage(docId, docBin);

        continueWithNewTransaction();
        
        // check the document and its two binary have been successfully added ...
        // ... to the home folder
        List<Document> documentsList = iDocumentService.getHomeFolderDocuments(cb.getHomeFolderId(), -1);
        assertEquals("Bad number of associated documents on home folder", 1, documentsList.size());
        Set<DocumentBinary> docBinarySet = iDocumentService.getAllPages(docId);
        assertEquals("Bad number of associated data on document", 2, doc.getDatas().size());

        // ... and to the individual
        documentsList = iDocumentService.getIndividualDocuments(anIndividual.getId());
        assertEquals("Bad number of associated documents on individual", 1, documentsList.size());
        try {
            documentsList = iDocumentService.getIndividualDocuments(new Long(0));
            fail("should have thrown an exception");
        } catch (PermissionException pe) {
            // that was expected
        }

        // modify a page
        DocumentBinary docBin1 = docBinarySet.iterator().next();
        file = getResourceFile("family_notebook.jpg");
        data = new byte[(int) file.length()];
        fis = new FileInputStream(file);
        fis.read(data);
        docBin1.setData(data);
        iDocumentService.modifyPage(docId, docBin1);

        // remove a page
        doc.getDatas().remove(1);
        assertEquals("Bad number of associated data on document", 1, doc.getDatas().size());
        docBin1 = doc.getDatas().get(0) ;
        assertNotNull("Could find page", docBin1);

        // try to retrieve the list of identity pieces for home folder
        DocumentType docType =
            iDocumentTypeService.getDocumentTypeByType(IDocumentTypeService.IDENTITY_RECEIPT_TYPE);
        documentsList =
            iDocumentService.getProvidedDocuments(docType, cb.getHomeFolderId(), null);
        assertEquals("Bad number of docs for home folder (1)", 1, documentsList.size());
        // and try other successful and unsuccessful searches among provided documents
        documentsList =
            iDocumentService.getProvidedDocuments(docType, cb.getHomeFolderId(), anIndividual.getId());
        assertEquals("Bad number of docs for home folder and individual", 1, documentsList.size());
        docType =
            iDocumentTypeService.getDocumentTypeByType(IDocumentTypeService.MEDICAL_CERTIFICATE_TYPE);
        documentsList =
            iDocumentService.getProvidedDocuments(docType, cb.getHomeFolderId(), null);
        assertEquals("Bad number of docs for home folder (2)", 0, documentsList.size());

        // test end validity durations by creating different sort of doc types
        // based on example data from $BASE_DIR/db/init_ref_data.sql

        // ... a permanently durable
        doc = new Document();
        doc.setDepositId(anIndividual.getId());
        doc.setDepositOrigin(DepositOrigin.ECITIZEN);
        doc.setDepositType(DepositType.PC);
        doc.setDocumentType(iDocumentTypeService.getDocumentTypeByType(IDocumentTypeService.IDENTITY_RECEIPT_TYPE));
        doc.setHomeFolderId(cb.getHomeFolderId());
        doc.setIndividualId(anIndividual.getId());
        iDocumentService.create(doc);

        // ... a 3-year valid
        doc = new Document();
        doc.setDepositId(anIndividual.getId());
        doc.setDepositOrigin(DepositOrigin.ECITIZEN);
        doc.setDepositType(DepositType.PC);
        doc.setDocumentType(iDocumentTypeService.getDocumentTypeByType(IDocumentTypeService.DOMICILE_RECEIPT_TYPE));
        doc.setHomeFolderId(cb.getHomeFolderId());
        iDocumentService.create(doc);

        // ... a 2-month valid
        doc = new Document();
        doc.setDepositId(anIndividual.getId());
        doc.setDepositOrigin(DepositOrigin.ECITIZEN);
        doc.setDepositType(DepositType.PC);
        doc.setDocumentType(iDocumentTypeService.getDocumentTypeByType(IDocumentTypeService.ID_CARD_LOSS_DECLARATION_TYPE));
        doc.setHomeFolderId(cb.getHomeFolderId());
        Long docId3 = iDocumentService.create(doc);

        // ... an end-of-the-year valid
        doc = new Document();
        doc.setDepositId(anIndividual.getId());
        doc.setDepositOrigin(DepositOrigin.ECITIZEN);
        doc.setDepositType(DepositType.PC);
        doc.setDocumentType(iDocumentTypeService.getDocumentTypeByType(IDocumentTypeService.TAXES_NOTIFICATION_TYPE));
        doc.setHomeFolderId(cb.getHomeFolderId());
        Long docId4 = iDocumentService.create(doc);

        // ... an end-of-the-school-year valid
        doc = new Document();
        doc.setDepositId(anIndividual.getId());
        doc.setDepositOrigin(DepositOrigin.ECITIZEN);
        doc.setDepositType(DepositType.PC);
        doc.setDocumentType(iDocumentTypeService.getDocumentTypeByType(IDocumentTypeService.VACATING_CERTIFICATE_TYPE));
        doc.setHomeFolderId(cb.getHomeFolderId());
        iDocumentService.create(doc);

        // delete a document
        iDocumentService.delete(docId3);
        
        continueWithNewTransaction();

        // test modifications on a document
        Document docToModify = iDocumentService.getById(docId4);
        doc.setDepositType(DepositType.TERMINAL);
        doc.setAgentNote("Quelle belle PJ");
        Calendar calendar = new GregorianCalendar();
        Date currentDate = new Date();
        calendar.setTime(currentDate);
        calendar.add(Calendar.MONTH, 3);
        doc.setEndValidityDate(calendar.getTime());
        iDocumentService.modify(docToModify);
        docToModify = iDocumentService.getById(docId4);
        Assert.assertNotNull("Argh, where my f****** document has gone ??!");
        Assert.assertEquals(doc.getAgentNote(), "Quelle belle PJ");

        // hmm ? just a test :-)
        try {
            iDocumentService.modify(null);
            fail("should have thrown an exception");
        } catch (PermissionException pe) {
            // that was expected
        }
        
        // retrieve all known document types
        allDocumentTypes = iDocumentTypeService.getAllDocumentTypes();
        Assert.assertNotNull(allDocumentTypes);
        
        SecurityContext.setCurrentEcitizen(cb.getLogin());
        int count = iDocumentService.searchCount(null);
        Assert.assertNotSame(count, 0);
        
        List<Document> docs = new ArrayList<Document>();
        Hashtable<String, Object> params = new Hashtable<String, Object>();
        params.put("documentType", iDocumentTypeService.getDocumentTypeByType(
                IDocumentTypeService.TAXES_NOTIFICATION_TYPE));
        
        docs = iDocumentService.search(params,-1,-1);
        Assert.assertNotSame(docs.size(), 0);
        
        params = new Hashtable<String, Object>();
        params.put("homeFolderId", cb.getHomeFolderId());        
        
        count = iDocumentService.searchCount(params);
        docs = iDocumentService.search(params,-1,-1);
        Assert.assertEquals(docs.size(), count);
    }
    
    public void testCreate() throws CvqException {
        
        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.FRONT_OFFICE_CONTEXT);
        CreationBean cb = gimmeAnHomeFolder();
        SecurityContext.setCurrentEcitizen(cb.getLogin());
        
        continueWithNewTransaction();
        
        HomeFolder homeFolder = iHomeFolderService.getById(cb.getHomeFolderId());
        Individual individual = iHomeFolderService.getHomeFolderResponsible(homeFolder.getId());
        DocumentType documentType =
            iDocumentTypeService.getDocumentTypeByType(IDocumentTypeService.ADOPTION_JUDGMENT_TYPE);
        
        Document document = new Document();
        document.setDocumentType(documentType);
        document.setHomeFolderId(homeFolder.getId());
        document.setIndividualId(new Long(individual.getId().longValue()));
        iDocumentService.create(document);
        Long documentId = document.getId();
   
        try {
            iDocumentService.check(documentId, null);
            fail("should have thrown an exception");
        } catch (PermissionException pe) {
            // that was expected
        }

        document = new Document();
        document.setDocumentType(documentType);
        document.setHomeFolderId(Long.valueOf("0"));
        try {
            iDocumentService.create(document);
            fail("should have thrown an exception");
        } catch (PermissionException pe) {
            // that was expected
        }

        continueWithNewTransaction();

        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.BACK_OFFICE_CONTEXT);
        SecurityContext.setCurrentAgent(agentNameWithCategoriesRoles);
        
        iDocumentService.check(documentId, null);
        iDocumentService.getById(documentId);
    }

    public void testHomeFolderDeleteEvent() throws CvqException {
        
        CreationBean cb = gimmeMinimalHomeFolder();
        
        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.FRONT_OFFICE_CONTEXT);
        SecurityContext.setCurrentEcitizen(cb.getLogin());

        DocumentType documentType =
            iDocumentTypeService.getDocumentTypeByType(IDocumentTypeService.ADOPTION_JUDGMENT_TYPE);
        
        Document document = new Document();
        document.setDocumentType(documentType);
        document.setHomeFolderId(cb.getHomeFolderId());
        iDocumentService.create(document);
   
        continueWithNewTransaction();

        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.BACK_OFFICE_CONTEXT);
        SecurityContext.setCurrentAgent(agentNameWithCategoriesRoles);
        
        iHomeFolderService.delete(cb.getHomeFolderId());
        homeFolderIds.remove(cb.getHomeFolderId());
        
        continueWithNewTransaction();
        
        List<Document> documents = 
            iDocumentService.getHomeFolderDocuments(cb.getHomeFolderId(), -1);
        assertTrue(documents.isEmpty());
    }

    public void testIndividualDeleteEvent() throws CvqException {

        CreationBean cb = gimmeAnHomeFolder();
        
        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.FRONT_OFFICE_CONTEXT);
        SecurityContext.setCurrentEcitizen(cb.getLogin());

        DocumentType documentType =
            iDocumentTypeService.getDocumentTypeByType(IDocumentTypeService.ADOPTION_JUDGMENT_TYPE);
        
        Document document = new Document();
        document.setDocumentType(documentType);
        document.setHomeFolderId(cb.getHomeFolderId());
        document.setIndividualId(homeFolderWoman.getId());
        iDocumentService.create(document);
   
        continueWithNewTransaction();

        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.BACK_OFFICE_CONTEXT);
        SecurityContext.setCurrentAgent(agentNameWithCategoriesRoles);
        
        iHomeFolderService.deleteIndividual(cb.getHomeFolderId(), homeFolderWoman.getId());
        
        continueWithNewTransaction();
        
        List<Document> documents = 
            iDocumentService.getIndividualDocuments(homeFolderWoman.getId());
        assertTrue(documents.isEmpty());
    }
}
