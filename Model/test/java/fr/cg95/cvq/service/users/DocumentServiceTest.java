package fr.cg95.cvq.service.users;

import java.io.File;
import java.io.FileInputStream;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import junit.framework.Assert;
import fr.cg95.cvq.business.authority.DocumentType;
import fr.cg95.cvq.business.users.CreationBean;
import fr.cg95.cvq.business.users.DepositOrigin;
import fr.cg95.cvq.business.users.DepositType;
import fr.cg95.cvq.business.users.Document;
import fr.cg95.cvq.business.users.DocumentBinary;
import fr.cg95.cvq.business.users.HomeFolder;
import fr.cg95.cvq.business.users.Individual;
import fr.cg95.cvq.exception.CvqBadPageNumberException;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.exception.CvqObjectNotFoundException;
import fr.cg95.cvq.security.SecurityContext;
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
        Set allDocumentTypes = iDocumentService.getAllDocumentTypes();
        Assert.assertEquals(allDocumentTypes.size(), 33);
        
        // create background data
        CreationBean cb = gimmeAnHomeFolder();
        Long requestId = cb.getRequestId();
        String responsibleLogin = cb.getLogin();

        SecurityContext.setCurrentEcitizen(responsibleLogin);

        // get home folder id from request id
        HomeFolder homeFolder = iHomeFolderService.getByRequestId(requestId);
        Long homeFolderId = homeFolder.getId();
        Assert.assertNotNull(homeFolderId);

        // get individuals from home folder id
        Critere crit = new Critere();
        crit.setAttribut(Individual.SEARCH_BY_HOME_FOLDER_ID);
        crit.setComparatif(Critere.EQUALS);
        crit.setValue(String.valueOf(homeFolderId));
        Set<Critere> criteriaSet = new HashSet<Critere>();
        criteriaSet.add(crit);
        Set individualsSet = iIndividualService.get(criteriaSet, null, false, false);
        Assert.assertEquals(individualsSet.size(), 5);

        Individual anIndividual = (Individual) individualsSet.iterator().next();

        // create a document
        Document doc = new Document();
        doc.setDepositId(anIndividual.getId());
        doc.setDepositOrigin(DepositOrigin.ECITIZEN);
        doc.setDepositType(DepositType.PC);
        doc.setDocumentType(iDocumentService.getDocumentTypeById(IDocumentService.IDENTITY_RECEIPT_TYPE));

        Long docId = iDocumentService.create(doc, homeFolderId, anIndividual.getId());

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
        Set documentsSet = iHomeFolderService.getAssociatedDocuments(homeFolderId);
        Assert.assertEquals("Bad number of associated documents on home folder", documentsSet.size(), 1);
        Set docBinarySet = iDocumentService.getAllPages(docId);
        Assert.assertEquals("Bad number of associated data on document", docBinarySet.size(), 2);
        Integer pagesNumber = iDocumentService.getPagesNumber(docId);
        Assert.assertEquals("Bad number of associated pages on document", pagesNumber.intValue(), 2);

        // ... and to the individual
        documentsSet = iIndividualService.getAssociatedDocuments(anIndividual.getId());
        Assert.assertEquals("Bad number of associated documents on individual", documentsSet.size(), 1);
        documentsSet = iIndividualService.getAssociatedDocuments(new Long(0));
        Assert.assertEquals("Bad number of associated documents on individual", documentsSet.size(), 0);

        // modify a page
        Iterator docBinaryIt = docBinarySet.iterator();
        DocumentBinary docBin1 = (DocumentBinary) docBinaryIt.next();
        file = getResourceFile("family_notebook.jpg");
        data = new byte[(int) file.length()];
        fis = new FileInputStream(file);
        fis.read(data);
        docBin1.setData(data);
        iDocumentService.modifyPage(docId, docBin1);

        // remove a page
        iDocumentService.deletePage(docId, new Integer(2));
        docBinarySet = iDocumentService.getAllPages(doc.getId());
        Assert.assertEquals("Bad number of associated data on document", docBinarySet.size(), 1);
        docBin1 = iDocumentService.getPage(docId, new Integer(1));
        Assert.assertNotNull("Could find page", docBin1);

        try {
            docBin1 = iDocumentService.getPage(docId, new Integer(2));
            fail("Should have thrown an exception");
        } catch (CvqObjectNotFoundException confe) {
            // this is good
        }

        // try to retrieve the list of identity pieces for home folder
        DocumentType docType =
            iDocumentService.getDocumentTypeById(IDocumentService.IDENTITY_RECEIPT_TYPE);
        documentsSet =
            iDocumentService.getProvidedDocuments(docType, homeFolderId, null);
        Assert.assertEquals("Bad number of docs for home folder (1)", documentsSet.size(), 1);
        // and try other successful and unsuccessful searches among provided documents
        documentsSet =
            iDocumentService.getProvidedDocuments(docType, homeFolderId, anIndividual.getId());
        Assert.assertEquals("Bad number of docs for home folder and individual", documentsSet.size(), 1);
        docType =
            iDocumentService.getDocumentTypeById(IDocumentService.MEDICAL_CERTIFICATE_TYPE);
        documentsSet =
            iDocumentService.getProvidedDocuments(docType, homeFolderId, null);
        Assert.assertEquals("Bad number of docs for home folder (2)", documentsSet.size(), 0);

        // test end validity durations by creating different sort of doc types
        // based on example data from $BASE_DIR/db/init_ref_data.sql

        // ... a permanently durable
        doc = new Document();
        doc.setDepositId(anIndividual.getId());
        doc.setDepositOrigin(DepositOrigin.ECITIZEN);
        doc.setDepositType(DepositType.PC);
        doc.setDocumentType(iDocumentService.getDocumentTypeById(IDocumentService.IDENTITY_RECEIPT_TYPE));
        iDocumentService.create(doc, homeFolderId, anIndividual.getId());

        // ... a 3-year valid
        doc = new Document();
        doc.setDepositId(anIndividual.getId());
        doc.setDepositOrigin(DepositOrigin.ECITIZEN);
        doc.setDepositType(DepositType.PC);
        doc.setDocumentType(iDocumentService.getDocumentTypeById(IDocumentService.DOMICILE_RECEIPT_TYPE));
        iDocumentService.create(doc, homeFolderId, null);

        // ... a 2-month valid
        doc = new Document();
        doc.setDepositId(anIndividual.getId());
        doc.setDepositOrigin(DepositOrigin.ECITIZEN);
        doc.setDepositType(DepositType.PC);
        doc.setDocumentType(iDocumentService.getDocumentTypeById(IDocumentService.ID_CARD_LOSS_DECLARATION_TYPE));
        Long docId3 = iDocumentService.create(doc, homeFolderId, null);

        // ... an end-of-the-year valid
        doc = new Document();
        doc.setDepositId(anIndividual.getId());
        doc.setDepositOrigin(DepositOrigin.ECITIZEN);
        doc.setDepositType(DepositType.PC);
        doc.setDocumentType(iDocumentService.getDocumentTypeById(IDocumentService.TAXES_NOTIFICATION_TYPE));
        Long docId4 = iDocumentService.create(doc, homeFolderId, null);

        // ... an end-of-the-school-year valid
        doc = new Document();
        doc.setDepositId(anIndividual.getId());
        doc.setDepositOrigin(DepositOrigin.ECITIZEN);
        doc.setDepositType(DepositType.PC);
        doc.setDocumentType(iDocumentService.getDocumentTypeById(IDocumentService.VACATING_CERTIFICATE_TYPE));
        iDocumentService.create(doc, homeFolderId, null);

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
        iDocumentService.modify(null);

        // retrieve all known document types
        allDocumentTypes = iDocumentService.getAllDocumentTypes();
        Assert.assertNotNull(allDocumentTypes);
        
        SecurityContext.resetCurrentSite();
    }
    
    public void testSearch() throws CvqException {
        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.FRONT_OFFICE_CONTEXT);
        CreationBean cb = gimmeAnHomeFolder();
        SecurityContext.setCurrentEcitizen(cb.getLogin());
        
        HomeFolder homeFolder = iHomeFolderService.getByRequestId(voCardRequestId);
        Individual individual = homeFolder.getHomeFolderResponsible();
        
        Document doc = new Document();
        doc.setDocumentType(iDocumentService.getDocumentTypeById(IDocumentService.ADOPTION_JUDGMENT_TYPE));
        iDocumentService.create(doc, homeFolder.getId(), individual.getId());
        
        doc = new Document();
        doc.setDocumentType(iDocumentService.getDocumentTypeById(IDocumentService.BANK_IDENTITY_RECEIPT_TYPE));
        iDocumentService.create(doc, null, individual.getId());
        
        doc = new Document();
        doc.setDocumentType(iDocumentService.getDocumentTypeById(IDocumentService.BANK_STATEMENT_TYPE));
        iDocumentService.create(doc, homeFolder.getId(), null);
        
        commitTransaction();
        
        Set fetchDocuments = iDocumentService.getAll();
        Assert.assertEquals(fetchDocuments.size(), 3);

    }
}
