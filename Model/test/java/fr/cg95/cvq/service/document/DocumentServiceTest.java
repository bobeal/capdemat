package fr.cg95.cvq.service.document;

import java.io.File;
import java.io.FileInputStream;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;
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
import fr.cg95.cvq.exception.CvqBadPageNumberException;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.exception.CvqObjectNotFoundException;
import fr.cg95.cvq.security.PermissionException;
import fr.cg95.cvq.security.SecurityContext;
import fr.cg95.cvq.service.document.IDocumentService;
import fr.cg95.cvq.testtool.ServiceTestCase;
import fr.cg95.cvq.util.Critere;

/**
 * The tests for the {@link IDocumentService document service}.
 *
 * @author bor@zenexity.fr
 */
public class DocumentServiceTest extends ServiceTestCase {

    public void testAll()
        throws CvqException, java.io.IOException, java.io.FileNotFoundException {

        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.FRONT_OFFICE_CONTEXT);

        // ensure all document types have been bootstrapped
        List<DocumentType> allDocumentTypes = iDocumentTypeService.getAllDocumentTypes();
        assertEquals(34, allDocumentTypes.size());
        
        // create background data
        CreationBean cb = gimmeAnHomeFolder();
        String responsibleLogin = cb.getLogin();

        SecurityContext.setCurrentEcitizen(responsibleLogin);

        // get home folder id from request id
        HomeFolder homeFolder = iHomeFolderService.getById(cb.getHomeFolderId());
        Long homeFolderId = homeFolder.getId();

        // get individuals from home folder id
        Critere crit = new Critere();
        crit.setAttribut(Individual.SEARCH_BY_HOME_FOLDER_ID);
        crit.setComparatif(Critere.EQUALS);
        crit.setValue(String.valueOf(homeFolderId));
        Set<Critere> criteriaSet = new HashSet<Critere>();
        criteriaSet.add(crit);
        List<Individual> individuals = iIndividualService.get(criteriaSet, null, false);
        Assert.assertEquals(5, individuals.size());

        Individual anIndividual = individuals.get(0);

        // create a document
        Document doc = new Document();
        doc.setDepositId(anIndividual.getId());
        doc.setDepositOrigin(DepositOrigin.ECITIZEN);
        doc.setDepositType(DepositType.PC);
        doc.setDocumentType(iDocumentTypeService.getDocumentTypeById(IDocumentTypeService.IDENTITY_RECEIPT_TYPE));
        doc.setHomeFolderId(homeFolderId);
        doc.setIndividualId(anIndividual.getId());
        Long docId = iDocumentService.create(doc);

        // add binary data
        DocumentBinary docBin = new DocumentBinary();
        docBin.setPageNumber(new Integer(1));
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

        // and a third one with a bad page number
        docBin = new DocumentBinary();
        docBin.setPageNumber(new Integer(2));
        docBin.setData(data);
        try {
            iDocumentService.addPage(docId, docBin);
            fail("Should have thrown a bad page exception");
        } catch (CvqBadPageNumberException cbpne) {
            // cool :-)
        }

        // check the document and its two binary have been successfully added ...
        // ... to the home folder
        List<Document> documentsList = iDocumentService.getHomeFolderDocuments(homeFolderId);
        assertEquals("Bad number of associated documents on home folder", 1, documentsList.size());
        Set<DocumentBinary> docBinarySet = iDocumentService.getAllPages(docId);
        assertEquals("Bad number of associated data on document", 2, docBinarySet.size());
        Integer pagesNumber = iDocumentService.getPagesNumber(docId);
        assertEquals("Bad number of associated pages on document", 2, pagesNumber.intValue());

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
        iDocumentService.deletePage(docId, new Integer(2));
        docBinarySet = iDocumentService.getAllPages(doc.getId());
        assertEquals("Bad number of associated data on document", 1, docBinarySet.size());
        docBin1 = iDocumentService.getPage(docId, new Integer(1));
        assertNotNull("Could find page", docBin1);

        try {
            docBin1 = iDocumentService.getPage(docId, new Integer(2));
            fail("Should have thrown an exception");
        } catch (CvqObjectNotFoundException confe) {
            // this is good
        }

        // try to retrieve the list of identity pieces for home folder
        DocumentType docType =
            iDocumentTypeService.getDocumentTypeById(IDocumentTypeService.IDENTITY_RECEIPT_TYPE);
        documentsList =
            iDocumentService.getProvidedDocuments(docType, homeFolderId, null);
        assertEquals("Bad number of docs for home folder (1)", 1, documentsList.size());
        // and try other successful and unsuccessful searches among provided documents
        documentsList =
            iDocumentService.getProvidedDocuments(docType, homeFolderId, anIndividual.getId());
        assertEquals("Bad number of docs for home folder and individual", 1, documentsList.size());
        docType =
            iDocumentTypeService.getDocumentTypeById(IDocumentTypeService.MEDICAL_CERTIFICATE_TYPE);
        documentsList =
            iDocumentService.getProvidedDocuments(docType, homeFolderId, null);
        assertEquals("Bad number of docs for home folder (2)", 0, documentsList.size());

        // test end validity durations by creating different sort of doc types
        // based on example data from $BASE_DIR/db/init_ref_data.sql

        // ... a permanently durable
        doc = new Document();
        doc.setDepositId(anIndividual.getId());
        doc.setDepositOrigin(DepositOrigin.ECITIZEN);
        doc.setDepositType(DepositType.PC);
        doc.setDocumentType(iDocumentTypeService.getDocumentTypeById(IDocumentTypeService.IDENTITY_RECEIPT_TYPE));
        doc.setHomeFolderId(homeFolderId);
        doc.setIndividualId(anIndividual.getId());
        iDocumentService.create(doc);

        // ... a 3-year valid
        doc = new Document();
        doc.setDepositId(anIndividual.getId());
        doc.setDepositOrigin(DepositOrigin.ECITIZEN);
        doc.setDepositType(DepositType.PC);
        doc.setDocumentType(iDocumentTypeService.getDocumentTypeById(IDocumentTypeService.DOMICILE_RECEIPT_TYPE));
        doc.setHomeFolderId(homeFolderId);
        iDocumentService.create(doc);

        // ... a 2-month valid
        doc = new Document();
        doc.setDepositId(anIndividual.getId());
        doc.setDepositOrigin(DepositOrigin.ECITIZEN);
        doc.setDepositType(DepositType.PC);
        doc.setDocumentType(iDocumentTypeService.getDocumentTypeById(IDocumentTypeService.ID_CARD_LOSS_DECLARATION_TYPE));
        doc.setHomeFolderId(homeFolderId);
        Long docId3 = iDocumentService.create(doc);

        // ... an end-of-the-year valid
        doc = new Document();
        doc.setDepositId(anIndividual.getId());
        doc.setDepositOrigin(DepositOrigin.ECITIZEN);
        doc.setDepositType(DepositType.PC);
        doc.setDocumentType(iDocumentTypeService.getDocumentTypeById(IDocumentTypeService.TAXES_NOTIFICATION_TYPE));
        doc.setHomeFolderId(homeFolderId);
        Long docId4 = iDocumentService.create(doc);

        // ... an end-of-the-school-year valid
        doc = new Document();
        doc.setDepositId(anIndividual.getId());
        doc.setDepositOrigin(DepositOrigin.ECITIZEN);
        doc.setDepositType(DepositType.PC);
        doc.setDocumentType(iDocumentTypeService.getDocumentTypeById(IDocumentTypeService.VACATING_CERTIFICATE_TYPE));
        doc.setHomeFolderId(homeFolderId);
        iDocumentService.create(doc);

        // delete a document
        iDocumentService.delete(docId3);

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
        logger.debug("Doc end validity date : " + doc.getEndValidityDate());

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
    }
    
    public void testCreate() throws CvqException {
        
        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.FRONT_OFFICE_CONTEXT);
        CreationBean cb = gimmeAnHomeFolder();
        SecurityContext.setCurrentEcitizen(cb.getLogin());
        
        continueWithNewTransaction();
        
        HomeFolder homeFolder = iHomeFolderService.getById(cb.getHomeFolderId());
        Individual individual = iHomeFolderService.getHomeFolderResponsible(homeFolder.getId());
        DocumentType documentType =
            iDocumentTypeService.getDocumentTypeById(IDocumentTypeService.ADOPTION_JUDGMENT_TYPE);
        
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
}
