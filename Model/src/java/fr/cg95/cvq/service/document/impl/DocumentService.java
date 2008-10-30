package fr.cg95.cvq.service.document.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import net.sourceforge.safr.core.annotation.Secure;
import net.sourceforge.safr.core.annotation.SecureAction;

import org.apache.log4j.Logger;

import fr.cg95.cvq.business.document.DepositOrigin;
import fr.cg95.cvq.business.document.DepositType;
import fr.cg95.cvq.business.document.Document;
import fr.cg95.cvq.business.document.DocumentAction;
import fr.cg95.cvq.business.document.DocumentBinary;
import fr.cg95.cvq.business.document.DocumentState;
import fr.cg95.cvq.business.document.DocumentType;
import fr.cg95.cvq.business.document.DocumentTypeValidity;
import fr.cg95.cvq.dao.IGenericDAO;
import fr.cg95.cvq.dao.document.IDocumentBinaryDAO;
import fr.cg95.cvq.dao.document.IDocumentDAO;
import fr.cg95.cvq.dao.document.IDocumentTypeDAO;
import fr.cg95.cvq.exception.CvqBadPageNumberException;
import fr.cg95.cvq.exception.CvqDisabledFunctionalityException;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.exception.CvqInvalidTransitionException;
import fr.cg95.cvq.exception.CvqObjectNotFoundException;
import fr.cg95.cvq.security.SecurityContext;
import fr.cg95.cvq.security.annotation.ContextType;
import fr.cg95.cvq.security.annotation.Context;
import fr.cg95.cvq.service.authority.ILocalAuthorityRegistry;
import fr.cg95.cvq.service.authority.LocalAuthorityConfigurationBean;
import fr.cg95.cvq.service.document.IDocumentService;

/**
 * Implementation of the {@link IDocumentService} service.
 *
 * @author bor@zenexity.fr
 */
public class DocumentService implements IDocumentService {

    static Logger logger = Logger.getLogger(DocumentService.class);

    protected ILocalAuthorityRegistry localAuthorityRegistry;
    
    protected IDocumentDAO documentDAO;
    protected IDocumentTypeDAO documentTypeDAO;
    protected IDocumentBinaryDAO documentBinaryDAO;
    protected IGenericDAO genericDAO;
    
    public DocumentService() {
        super();
    }

    public Document getById(@Secure(SecureAction.READ) final Long id)
        throws CvqException, CvqObjectNotFoundException {
        return (Document) documentDAO.findById(Document.class, id);
    }

    /**
     * Compute a default end validity date for the given document, according to its
     * type.
     */
    protected void computeEndValidityDate(Document document) {

        DocumentType docType = document.getDocumentType();
        DocumentTypeValidity docTypeValidity = docType.getValidityDurationType();

        Calendar calendar = new GregorianCalendar();
        Date currentDate = new Date();
        calendar.setTime(currentDate);

        if (docTypeValidity.equals(DocumentTypeValidity.UNLIMITED)) {
            document.setEndValidityDate(null);
        } else if (docTypeValidity.equals(DocumentTypeValidity.YEAR)) {
            Integer duration = docType.getValidityDuration();
            calendar.add(Calendar.YEAR, duration.intValue());
            document.setEndValidityDate(calendar.getTime());
            logger.debug("Set default end validity date to "
                         + document.getEndValidityDate());
        } else if (docTypeValidity.equals(DocumentTypeValidity.MONTH)) {
            Integer duration = docType.getValidityDuration();
            calendar.add(Calendar.MONTH, duration.intValue());
            document.setEndValidityDate(calendar.getTime());
            logger.debug("Set default end validity date to "
                         + document.getEndValidityDate());
        } else if (docTypeValidity.equals(DocumentTypeValidity.END_YEAR)) {
            calendar.set(Calendar.MONTH, Calendar.DECEMBER);
            calendar.set(Calendar.DAY_OF_MONTH, 31);
            document.setEndValidityDate(calendar.getTime());
            logger.debug("Set default end validity date to "
                         + document.getEndValidityDate());
        } else if (docTypeValidity.equals(DocumentTypeValidity.END_SCHOOL_YEAR)) {
            if (calendar.get(Calendar.MONTH) > Calendar.JUNE)
                calendar.set(Calendar.YEAR, calendar.get(Calendar.YEAR) + 1);
            calendar.set(Calendar.MONTH, Calendar.JUNE);
            calendar.set(Calendar.DAY_OF_MONTH, 30);
            document.setEndValidityDate(calendar.getTime());
            logger.debug("Set default end validity date to "
                         + document.getEndValidityDate());
        }
    }

    @Context(type=ContextType.ADMIN)
    public void checkDocumentsValidity()
        throws CvqException {

        localAuthorityRegistry.browseAndCallback(this, "checkLocalAuthDocumentsValidity", null);
    }
    
    @Context(type=ContextType.ADMIN)
    public void checkLocalAuthDocumentsValidity(final String localAuthorityName)
        throws CvqException {

        logger.debug("checkLocalAuthDocumentsValidity() dealing with " + localAuthorityName);
        
        Date currentDate = new Date();
        List<Document> wholeList = new ArrayList<Document>();

        // get all documents whose state is PENDING, CHECKED or VALIDATED
        wholeList.addAll(documentDAO.listByState(DocumentState.PENDING));
        wholeList.addAll(documentDAO.listByState(DocumentState.CHECKED));
        wholeList.addAll(documentDAO.listByState(DocumentState.VALIDATED));

        // if end validity date is reached, set them outofdate
        for (Document doc : wholeList) {
            if (doc.getEndValidityDate() != null
                && doc.getEndValidityDate().before(currentDate)) {
                logger.debug("checkLocalAuthDocumentsValidity() document " + doc.getId() 
                        + " has reached its end validity date (" 
                        + doc.getEndValidityDate() + ") !");
                doc.setState(DocumentState.OUTDATED);
                documentDAO.update(doc);

                addActionTrace(STATE_CHANGE_ACTION, DocumentState.OUTDATED, doc);
            }
        }
    }

    public Long create(@Secure(SecureAction.CREATE) Document document)
        throws CvqException, CvqObjectNotFoundException {

        if (document == null)
            throw new CvqException("No document object provided");
        if (document.getDocumentType() == null)
            throw new CvqException("You must provide a type for your document");

        document.setState(DocumentState.PENDING);
        document.setCreationDate(new Date());

        // set required default values
        if (document.getDepositType() == null)
            document.setDepositType(DepositType.PC);
        if (document.getDepositOrigin() == null)
            document.setDepositOrigin(DepositOrigin.ECITIZEN);
        if (document.getCertified() == null)
            document.setCertified(Boolean.FALSE);
        
        computeEndValidityDate(document);

        Long documentId = documentDAO.create(document);

        logger.debug("Created document object with id : " + documentId);

        addActionTrace(CREATION_ACTION, DocumentState.PENDING, document);

        return documentId;
    }

    public void modify(@Secure(SecureAction.UPDATE) final Document document)
        throws CvqException {

        if (document == null)
            return;
        documentDAO.update(document);
    }

    public void delete(@Secure(SecureAction.DELETE) final Long id)
        throws CvqException, CvqObjectNotFoundException {

        Document document = getById(id);
        documentDAO.delete(document);
    }

    public void addPage(@Secure(SecureAction.UPDATE) final Long documentId, 
            final DocumentBinary documentBinary)
        throws CvqException, CvqObjectNotFoundException, CvqBadPageNumberException {

        checkDocumentDigitalizationIsEnabled();
        
        Integer pageNumber = documentBinary.getPageNumber();
        if (pageNumber != null && documentBinaryDAO.hasPage(documentId, pageNumber)) {
            logger.debug("Document " + documentId + " already has a page " + pageNumber);
            throw new CvqBadPageNumberException("Document " + documentId + " already has a page " + pageNumber);
        } else if (pageNumber == null) {
            pageNumber = (Integer)documentBinaryDAO.getNextPageNumber(documentId).intValue();
            documentBinary.setPageNumber(pageNumber);
        }

        Document document = getById(documentId);
        if (document.getDatas() == null) {
            Set<DocumentBinary> datasSet = new HashSet<DocumentBinary>();
            datasSet.add(documentBinary);
            document.setDatas(datasSet);
        } else {
            document.getDatas().add(documentBinary);
        }

        documentDAO.update(document);
    }

    public void modifyPage(@Secure(SecureAction.UPDATE) final Long documentId, 
            final DocumentBinary documentBinary)
        throws CvqException, CvqBadPageNumberException {

        checkDocumentDigitalizationIsEnabled();
        
        // a piece of page management, to be c'ted if really necessary
        // (but is it ??)
        Integer newPageNumber = documentBinary.getPageNumber();
        if (newPageNumber == null) {
            newPageNumber = (Integer)documentBinaryDAO.getNextPageNumber(documentId).intValue();
            documentBinary.setPageNumber(newPageNumber);
        } else {
            // if page number has changed, check it does not conflict with an existing one
            // FIXME : do not retrieve the whole object !
            Integer oldPageNumber = documentBinaryDAO.getPage(documentBinary.getId());
            if (!oldPageNumber.equals(newPageNumber)
                && documentBinaryDAO.hasPage(documentId, newPageNumber)) {
                logger.debug("Document " + documentId + " already has a page " + newPageNumber);
                throw new CvqBadPageNumberException("Document " + documentId + " already has a page " + newPageNumber);
            }
        }
        documentBinaryDAO.update(documentBinary);

        logger.debug("Modified document binary with id : " + documentBinary.getId());
    }

    public void deletePage(@Secure(SecureAction.DELETE) final Long documentId, final Integer pageId)
        throws CvqException, CvqObjectNotFoundException {

        checkDocumentDigitalizationIsEnabled();
        
        DocumentBinary docBin =
            documentBinaryDAO.findByDocumentAndPageId(documentId, pageId);
        if (docBin == null)
            throw new CvqObjectNotFoundException("Could not find page " + pageId + " of document " + documentId);

        Document document = getById(documentId);
        document.getDatas().remove(docBin);
        documentBinaryDAO.delete(docBin);
        documentDAO.update(document);
        
        logger.debug("Deleted document binary with id : " + docBin.getId());
    }

    private void checkDocumentDigitalizationIsEnabled() 
        throws CvqDisabledFunctionalityException {
        
        LocalAuthorityConfigurationBean lacb = SecurityContext.getCurrentConfigurationBean();
        if (!lacb.isDocumentDigitalizationEnabled().booleanValue()) {
            logger.error("checkDocumentDigitalizationIsEnabled() document digitalization is not enabled for site "
                         + lacb.getName());
            throw new CvqDisabledFunctionalityException();
        }
    }
    
    public DocumentBinary getPage(@Secure(SecureAction.READ) final Long documentId, 
            final Integer pageId)
        throws CvqException, CvqObjectNotFoundException {

        DocumentBinary docBin =
            documentBinaryDAO.findByDocumentAndPageId(documentId, pageId);
        if (docBin == null)
            throw new CvqObjectNotFoundException("Could not find page " + pageId + " of document " + documentId);

        return docBin;
    }

    public Integer getPagesNumber(@Secure(SecureAction.READ) final Long documentId)
        throws CvqException {

        return documentBinaryDAO.getPagesNumber(documentId).intValue();
    }

    public Set<DocumentBinary> getAllPages(@Secure(SecureAction.READ) final Long documentId)
        throws CvqException {

        Document document = getById(documentId);

        if (document.getDatas() == null)
            return new LinkedHashSet<DocumentBinary>();
        else
            return new LinkedHashSet<DocumentBinary>(document.getDatas());
    }

    @Secure(SecureAction.CUSTOM_BEFORE)
    public void deleteHomeFolderDocuments(Long homeFolderId) throws CvqException {
        List<Document> documents = getHomeFolderDocuments(homeFolderId);
        for (Document document : documents)
            documentDAO.delete(document);
    }

    @Secure(SecureAction.CUSTOM_BEFORE)
    public void deleteIndividualDocuments(Long individualId) throws CvqException {
        List<Document> documents = getIndividualDocuments(individualId);
        for (Document document : documents)
            documentDAO.delete(document);
    }

    @Secure(SecureAction.CUSTOM_BEFORE)
    public List<Document> getProvidedDocuments(final DocumentType docType,
            final Long homeFolderId, final Long individualId)
        throws CvqException {

        if (docType == null)
            throw new CvqException("No document type provided");
        if (homeFolderId == null)
            throw new CvqException("No home folder id provided");

        return documentDAO.listProvidedDocuments(docType.getId(),
                homeFolderId, individualId);
    }
    
    @Secure(SecureAction.CUSTOM_BEFORE)
    public List<Document> getHomeFolderDocuments(final Long homeFolderId)
        throws CvqException {

        return documentDAO.listByHomeFolder(homeFolderId);
    }

    @Secure(SecureAction.CUSTOM_BEFORE)
    public List<Document> getIndividualDocuments(final Long individualId)
        throws CvqException {

        return documentDAO.listByIndividual(individualId);
    }

    // Document Workflow related methods
    // TODO : make workflow method private - migrate unit tests
    //////////////////////////////////////////////////////////
    
    @Context(type=ContextType.BACK_OFFICE)
    public void updateDocumentState(final Long id, final DocumentState ds, final String message, 
            final Date validityDate)
            throws CvqException, CvqInvalidTransitionException, CvqObjectNotFoundException {
        if (ds.equals(DocumentState.VALIDATED))
            validate(id, validityDate, message);
        else if (ds.equals(DocumentState.CHECKED))
            check(id,message);
        else if (ds.equals(DocumentState.REFUSED))
            refuse(id, message);
        else if (ds.equals(DocumentState.OUTDATED))
            outDated(id);
    }

    @Context(type=ContextType.BACK_OFFICE)
    public void validate(final Long id, final Date validityDate, final String message)
        throws CvqException, CvqObjectNotFoundException, CvqInvalidTransitionException {

        Document document = getById(id);
        if (document.getState().equals(DocumentState.VALIDATED))
            return;

        if (document.getState().equals(DocumentState.PENDING)
            || document.getState().equals(DocumentState.CHECKED)) {
            try {
                document.setState(DocumentState.VALIDATED);
                documentDAO.update(document);
            } catch (RuntimeException e) {
                throw new CvqException("Could not validate document " + e.toString());
            }
        } else {
            throw new CvqInvalidTransitionException();
        }

        addActionTrace(STATE_CHANGE_ACTION, DocumentState.VALIDATED, document);
    }

    @Context(type=ContextType.BACK_OFFICE)
    public void check(final Long id, final String message)
        throws CvqException, CvqObjectNotFoundException, CvqInvalidTransitionException {

        Document document = getById(id);
        if (document.getState().equals(DocumentState.CHECKED))
            return;

        if (!document.getState().equals(DocumentState.PENDING))
            throw new CvqInvalidTransitionException();

        document.setState(DocumentState.CHECKED);
        documentDAO.update(document);
        addActionTrace(STATE_CHANGE_ACTION, DocumentState.CHECKED, document);
    }

    @Context(type=ContextType.BACK_OFFICE)
    public void refuse(final Long id, final String message)
        throws CvqException, CvqObjectNotFoundException, CvqInvalidTransitionException {

        Document document = getById(id);
        if (document.getState().equals(DocumentState.REFUSED))
            return;

        if (!document.getState().equals(DocumentState.CHECKED)
            && !document.getState().equals(DocumentState.PENDING))
            throw new CvqInvalidTransitionException();

        document.setState(DocumentState.REFUSED);
        documentDAO.update(document);
    
        addActionTrace(STATE_CHANGE_ACTION, DocumentState.REFUSED, document);
    }

    @Context(type=ContextType.BACK_OFFICE)
    public void outDated(final Long id)
        throws CvqException, CvqObjectNotFoundException, CvqInvalidTransitionException {

        Document document = getById(id);
        if (document.getState().equals(DocumentState.OUTDATED))
            return;

        if (document.getState().equals(DocumentState.REFUSED))
            throw new CvqInvalidTransitionException();

        document.setState(DocumentState.OUTDATED);
        documentDAO.update(document);

        addActionTrace(STATE_CHANGE_ACTION, DocumentState.OUTDATED, document);
    }

    @Context(type=ContextType.BACK_OFFICE)
    public DocumentState[] getPossibleTransitions(DocumentState ds)
        throws CvqException {

        ArrayList<DocumentState> documentStateList = new ArrayList<DocumentState>();

        if (ds.equals(DocumentState.PENDING)) {
            documentStateList.add(DocumentState.VALIDATED);
            documentStateList.add(DocumentState.CHECKED);
            documentStateList.add(DocumentState.REFUSED);
            documentStateList.add(DocumentState.OUTDATED);
        } else if (ds.equals(DocumentState.VALIDATED)) {
            documentStateList.add(DocumentState.OUTDATED);
        } else if (ds.equals(DocumentState.CHECKED)) {
            documentStateList.add(DocumentState.VALIDATED);
            documentStateList.add(DocumentState.REFUSED);
            documentStateList.add(DocumentState.OUTDATED);
        } else if (ds.equals(DocumentState.REFUSED)) {
            // no more transitions available
        } else if (ds.equals(DocumentState.OUTDATED)) {
            // no more transitions available
        }

        return (DocumentState[]) documentStateList.toArray(new DocumentState[0]);
    }

    protected void addActionTrace(final String label, final DocumentState resultingState,
            final Document document)
        throws CvqException {

        DocumentAction documentAction = new DocumentAction();
        documentAction.setAgentId(SecurityContext.getCurrentUserId());
        documentAction.setLabel(label);
        documentAction.setDate(new Date());
        documentAction.setResultingState(resultingState);

        if (document.getActions() == null) {
            Set<DocumentAction> actionsSet = new HashSet<DocumentAction>();
            actionsSet.add(documentAction);
            document.setActions(actionsSet);
        } else {
            document.getActions().add(documentAction);
        }
        
        documentDAO.update(document);
    }

    public void setDocumentDAO(final IDocumentDAO documentDAO) {
        this.documentDAO = documentDAO;
    }

    public void setDocumentBinaryDAO(final IDocumentBinaryDAO documentBinaryDAO) {
        this.documentBinaryDAO = documentBinaryDAO;
    }

    public void setDocumentTypeDAO(final IDocumentTypeDAO documentTypeDAO) {
        this.documentTypeDAO = documentTypeDAO;
    }

    public void setGenericDAO(final IGenericDAO genericDAO) {
        this.genericDAO = genericDAO;
    }

    public void setLocalAuthorityRegistry(ILocalAuthorityRegistry localAuthorityRegistry) {
        this.localAuthorityRegistry = localAuthorityRegistry;
    }
}

