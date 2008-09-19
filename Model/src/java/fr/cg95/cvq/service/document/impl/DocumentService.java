package fr.cg95.cvq.service.document.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;

import fr.cg95.cvq.business.document.DepositOrigin;
import fr.cg95.cvq.business.document.DepositType;
import fr.cg95.cvq.business.document.Document;
import fr.cg95.cvq.business.document.DocumentAction;
import fr.cg95.cvq.business.document.DocumentBinary;
import fr.cg95.cvq.business.document.DocumentState;
import fr.cg95.cvq.business.document.DocumentType;
import fr.cg95.cvq.business.document.DocumentTypeValidity;
import fr.cg95.cvq.business.request.RequestState;
import fr.cg95.cvq.business.users.HomeFolder;
import fr.cg95.cvq.business.users.Individual;
import fr.cg95.cvq.dao.IGenericDAO;
import fr.cg95.cvq.dao.document.IDocumentBinaryDAO;
import fr.cg95.cvq.dao.document.IDocumentDAO;
import fr.cg95.cvq.dao.document.IDocumentTypeDAO;
import fr.cg95.cvq.dao.users.IHomeFolderDAO;
import fr.cg95.cvq.dao.users.IIndividualDAO;
import fr.cg95.cvq.exception.CvqBadPageNumberException;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.exception.CvqInvalidTransitionException;
import fr.cg95.cvq.exception.CvqObjectNotFoundException;
import fr.cg95.cvq.permission.PrivilegeDescriptor;
import fr.cg95.cvq.security.IPolicyDelegate;
import fr.cg95.cvq.security.SecurityContext;
import fr.cg95.cvq.service.authority.ILocalAuthorityLifecycleAware;
import fr.cg95.cvq.service.authority.ILocalAuthorityRegistry;
import fr.cg95.cvq.service.document.IDocumentService;

/**
 * Implementation of the {@link IDocumentService} service.
 *
 * @author bor@zenexity.fr
 */
public class DocumentService implements IDocumentService, ILocalAuthorityLifecycleAware {

    static Logger logger = Logger.getLogger(DocumentService.class);

    protected ILocalAuthorityRegistry localAuthorityRegistry;
    
    protected IPolicyDelegate cvqPolicy;
    
    protected IDocumentDAO documentDAO;
    protected IDocumentTypeDAO documentTypeDAO;
    protected IDocumentBinaryDAO documentBinaryDAO;
    protected IGenericDAO genericDAO;
    protected IHomeFolderDAO homeFolderDAO;
    protected IIndividualDAO individualDAO;
    
    private Boolean performDbUpdates;
    private DocumentBootstrapper documentBootstrapper;
    
    public DocumentService() {
        super();
    }

    public void initSampleDocumentTypes(final String localAuthorityName) 
        throws CvqException {
        logger.debug("initSampleDocumentTypes() init for " + localAuthorityName);
        documentBootstrapper.bootstrapForCurrentLocalAuthority();
    }
    
    public void addLocalAuthority(String localAuthorityName) {
        if (performDbUpdates)
            localAuthorityRegistry.callback(localAuthorityName, this, "initSampleDocumentTypes", null);
    }

    public void removeLocalAuthority(String localAuthorityName) {
    }

    public Set get(final Set criteriaSet)
        throws CvqException {

        List results = null;
        results = documentDAO.search(criteriaSet);
        return new LinkedHashSet(results);
    }

    public Set getAll()
        throws CvqException {

        List documents = null;
        documents = documentDAO.listAll();
        return new LinkedHashSet(documents);
    }

    public Document getById(final Long id)
        throws CvqException, CvqObjectNotFoundException {
        return (Document) documentDAO.findById(Document.class, id, PrivilegeDescriptor.READ);
    }

    public DocumentType getDocumentTypeById(final Integer id)
        throws CvqException, CvqObjectNotFoundException {

        DocumentType dt = null;
        dt = documentTypeDAO.findByType(id);
        return dt;
    }

    public Set getAllDocumentTypes()
        throws CvqException {

        List documentTypes = null;
        documentTypes = documentTypeDAO.listAll();
        return new LinkedHashSet(documentTypes);
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

    public void checkDocumentsValidity()
        throws CvqException {

        localAuthorityRegistry.browseAndCallback(this, "checkLocalAuthDocumentsValidity", null);
    }
    
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

    public Long create(final Document document, final Long homeFolderId,
                       final Long individualId)
        throws CvqException, CvqObjectNotFoundException {

        if (document == null)
            throw new CvqException("No document object provided");
        if (document.getDocumentType() == null)
            throw new CvqException("You must provide a type for your document");
        if (homeFolderId == null && individualId == null)
            throw new CvqException("You must provide an home folder id or an individual id for the document");

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

        // eventually create association with the home folder
        if (homeFolderId != null) {
            HomeFolder homeFolder = 
                (HomeFolder) homeFolderDAO.findById(HomeFolder.class, homeFolderId);
            document.setHomeFolder(homeFolder);
            if (homeFolder.getDocuments() == null) {
                Set<Document> documentsSet = new HashSet<Document>();
                documentsSet.add(document);
                homeFolder.setDocuments(documentsSet);
            } else {
                homeFolder.getDocuments().add(document);
            }
        }

        // eventually create association with the individual
        if (individualId != null) {
            Individual individual = 
                (Individual) individualDAO.findById(Individual.class, individualId);
            document.setIndividual(individual);
            if (individual.getDocuments() == null) {
                Set<Document> documentsSet = new HashSet<Document>();
                documentsSet.add(document);
                individual.setDocuments(documentsSet);
            } else {
                individual.getDocuments().add(document);
            }
        }

        Long documentId = null;
            documentId = documentDAO.create(document);

        logger.debug("Created document object with id : " + documentId);

        addActionTrace(CREATION_ACTION, DocumentState.PENDING, document);

        return documentId;
    }

    public Long addPage(final Long documentId, final DocumentBinary documentBinary)
        throws CvqException, CvqObjectNotFoundException,
               CvqBadPageNumberException {

        Document document = getById(documentId);
        documentBinary.setDocument(document);

        Integer pageNumber = documentBinary.getPageNumber();
        if (pageNumber != null && documentBinaryDAO.hasPage(documentId, pageNumber)) {
            logger.debug("Document " + documentId + " already has a page " + pageNumber);
            throw new CvqBadPageNumberException("Document " + documentId + " already has a page " + pageNumber);
        } else if (pageNumber == null) {
            pageNumber = (Integer)documentBinaryDAO.getNextPageNumber(documentId).intValue();
            documentBinary.setPageNumber(pageNumber);
        }

        Long docBinId = null;
        docBinId = documentBinaryDAO.create(documentBinary);

        logger.debug("Created document binary with id : " + docBinId);

        // ??? required when unit testing, either we are unable to retrieve
        // document's datas ...
        // also required in normal deployment configuration ??
        // FIXME : a cache side effect ??
        if (document.getDatas() == null) {
            Set<DocumentBinary> datasSet = new HashSet<DocumentBinary>();
            datasSet.add(documentBinary);
            document.setDatas(datasSet);
        } else {
            document.getDatas().add(documentBinary);
        }

        return docBinId;
    }

    public void modifyPage(final Long documentId,
                           final DocumentBinary documentBinary)
        throws CvqException, CvqBadPageNumberException {

        // a piece of page management, to be c'ted if really necessary
        // (but is it ??)
        Integer newPageNumber = documentBinary.getPageNumber();
        if (newPageNumber == null) {
            newPageNumber = (Integer)documentBinaryDAO.getNextPageNumber(documentId).intValue();
            documentBinary.setPageNumber(newPageNumber);
        } else {
            // if page number has changed, check it does not conflict
            // with an existing one
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

    public void deletePage(final Long documentId,
                           final Integer pageId)
        throws CvqException, CvqObjectNotFoundException {

        DocumentBinary docBin =
            documentBinaryDAO.findByDocumentAndPageId(documentId, pageId);
        if (docBin == null)
            throw new CvqObjectNotFoundException("Could not find page " + pageId + " of document " + documentId);

        // ??? required when unit testing, either we are unable to retrieve
        // document's datas ...
        // also required in normal deployment configuration ??
        // FIXME : a cache side effect ??
        Document document = getById(documentId);
        document.getDatas().remove(docBin);
        documentBinaryDAO.delete(docBin);

        logger.debug("Deleted document binary with id : " + docBin.getId());
    }

    public DocumentBinary getPage(final Long documentId,
                                  final Integer pageId)
        throws CvqException, CvqObjectNotFoundException {

        DocumentBinary docBin =
            documentBinaryDAO.findByDocumentAndPageId(documentId, pageId);
        if (docBin == null)
            throw new CvqObjectNotFoundException("Could not find page " + pageId + " of document " + documentId);

        return docBin;
    }

    public Integer getPagesNumber(final Long documentId)
        throws CvqException {

        return documentBinaryDAO.getPagesNumber(documentId).intValue();
    }

    public Set getAllPages(final Long documentId)
        throws CvqException {

        Document document = getById(documentId);

        if (document.getDatas() == null)
            return new LinkedHashSet();
        else
            return new LinkedHashSet(document.getDatas());
    }

    public void modify(final Document document)
        throws CvqException {

        if (document == null)
            return;
        documentDAO.update(document);
    }
 	
 	public void delete(final Long id)
        throws CvqException, CvqObjectNotFoundException {

        logger.debug("Gonna delete document object with id : " + id);

        Document document = getById(id);
        if (document.getHomeFolder() != null)
        	document.getHomeFolder().getDocuments().remove(document);
        if (document.getIndividual() != null)
        	document.getIndividual().getDocuments().remove(document);
        documentDAO.delete(document);
    }
    
    public Set getProvidedDocuments(final DocumentType docType,
                                    final Long homeFolderId,
                                    final Long individualId)
        throws CvqException {

        if (docType == null)
            throw new CvqException("No document type provided");
        if (homeFolderId == null)
            throw new CvqException("No home folder id provided");

        List providedDocSet = documentDAO.listProvidedDocuments(docType.getId(),
                                                             homeFolderId,
                                                             individualId);

        return new LinkedHashSet(providedDocSet);
    }
    
    
    // Document Workflow related methods
    // TODO : make workflow method private - migrate unit tests
    //////////////////////////////////////////////////////////
    
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

    public void validate(final Long id, final Date validityDate,
                         final String message)
        throws CvqException, CvqObjectNotFoundException, CvqInvalidTransitionException {

        logger.debug("Gonna validate document object with id : " + id);

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

    public void check(final Long id, final String message)
        throws CvqException, CvqObjectNotFoundException, CvqInvalidTransitionException {

        logger.debug("Gonna check document object with id : " + id);

        Document document = getById(id);
        if (document.getState().equals(DocumentState.CHECKED))
            return;

        if (!document.getState().equals(DocumentState.PENDING))
            throw new CvqInvalidTransitionException();

        document.setState(DocumentState.CHECKED);
        documentDAO.update(document);
        addActionTrace(STATE_CHANGE_ACTION, DocumentState.CHECKED, document);
    }

    public void refuse(final Long id, final String message)
        throws CvqException, CvqObjectNotFoundException, CvqInvalidTransitionException {

        logger.debug("Gonna refuse document object with id : " + id);

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

    public void outDated(final Long id)
        throws CvqException, CvqObjectNotFoundException, CvqInvalidTransitionException {

        logger.debug("Gonna set document object with id : " + id + " out of date");

        Document document = getById(id);
        if (document.getState().equals(DocumentState.OUTDATED))
            return;

        if (document.getState().equals(DocumentState.REFUSED))
            throw new CvqInvalidTransitionException();

        document.setState(DocumentState.OUTDATED);
        documentDAO.update(document);

        addActionTrace(STATE_CHANGE_ACTION, DocumentState.OUTDATED, document);
    }


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

    protected void addActionTrace(final String label,
                                  final DocumentState resultingState,
                                  final Document document)
        throws CvqException {

        cvqPolicy.check(document, PrivilegeDescriptor.WRITE);

        Long userId = SecurityContext.getCurrentUserId();
        if (userId == null)
            throw new CvqException("No logged in user !");

        DocumentAction documentAction = new DocumentAction();
        documentAction.setAgentId(userId);
        documentAction.setLabel(label);
        documentAction.setDate(new Date());
        documentAction.setResultingState(resultingState);
        documentAction.setDocument(document);

        genericDAO.create(documentAction);

        // FIXME : a side effect of first-level cache and lazy initialiszation ?
        //         or is it a normal behavior ?
        if (document.getActions() == null) {
            Set<DocumentAction> actionsSet = new HashSet<DocumentAction>();
            actionsSet.add(documentAction);
            document.setActions(actionsSet);
        } else {
            document.getActions().add(documentAction);
        }
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

    public void setHomeFolderDAO(final IHomeFolderDAO homeFolderDAO) {
        this.homeFolderDAO = homeFolderDAO;
    }

    public void setIndividualDAO(final IIndividualDAO individualDAO) {
        this.individualDAO = individualDAO;
    }

    public void setLocalAuthorityRegistry(ILocalAuthorityRegistry localAuthorityRegistry) {
        this.localAuthorityRegistry = localAuthorityRegistry;
    }
    
    public void setPerformDbUpdates(Boolean performDbUpdates) {
        if (performDbUpdates != null)
            this.performDbUpdates = performDbUpdates;
        else
            this.performDbUpdates = Boolean.FALSE;
    }

    public void setDocumentBootstrapper(DocumentBootstrapper documentBootstrapper) {
        this.documentBootstrapper = documentBootstrapper;
    }

    public void setCvqPolicy(IPolicyDelegate cvqPolicy) {
        this.cvqPolicy = cvqPolicy;
    }
}

