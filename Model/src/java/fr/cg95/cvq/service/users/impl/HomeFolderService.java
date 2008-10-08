package fr.cg95.cvq.service.users.impl;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;

import fr.cg95.cvq.business.request.Request;
import fr.cg95.cvq.business.users.ActorState;
import fr.cg95.cvq.business.users.Address;
import fr.cg95.cvq.business.users.Adult;
import fr.cg95.cvq.business.users.Child;
import fr.cg95.cvq.business.users.HomeFolder;
import fr.cg95.cvq.business.users.Individual;
import fr.cg95.cvq.business.users.payment.ExternalAccountItem;
import fr.cg95.cvq.business.users.payment.ExternalDepositAccountItem;
import fr.cg95.cvq.business.users.payment.ExternalInvoiceItem;
import fr.cg95.cvq.business.users.payment.Payment;
import fr.cg95.cvq.dao.IGenericDAO;
import fr.cg95.cvq.dao.document.IDocumentDAO;
import fr.cg95.cvq.dao.users.IAdultDAO;
import fr.cg95.cvq.dao.users.IChildDAO;
import fr.cg95.cvq.dao.users.IHomeFolderDAO;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.exception.CvqModelException;
import fr.cg95.cvq.exception.CvqObjectNotFoundException;
import fr.cg95.cvq.external.IExternalService;
import fr.cg95.cvq.payment.IPaymentService;
import fr.cg95.cvq.security.SecurityContext;
import fr.cg95.cvq.service.authority.ILocalAuthorityRegistry;
import fr.cg95.cvq.service.authority.LocalAuthorityConfigurationBean;
import fr.cg95.cvq.service.request.IRequestService;
import fr.cg95.cvq.service.users.IAdultService;
import fr.cg95.cvq.service.users.IChildService;
import fr.cg95.cvq.service.users.IHomeFolderService;
import fr.cg95.cvq.service.users.IIndividualService;
import fr.cg95.cvq.util.mail.IMailService;

/**
 * Implementation of the home folder service.
 *
 * @author Benoit Orihuela (bor@zenexity.fr)
 */
public class HomeFolderService implements IHomeFolderService {

    private static Logger logger = Logger.getLogger(HomeFolderService.class);

    protected ILocalAuthorityRegistry localAuthorityRegistry;
    protected IMailService mailService;
    protected IIndividualService individualService;
    protected IAdultService adultService;
    protected IChildService childService;
    protected IRequestService requestService;
    protected IGenericDAO genericDAO;
    protected IHomeFolderDAO homeFolderDAO;
    protected IDocumentDAO documentDAO;
    protected IChildDAO childDAO;
    protected IAdultDAO adultDAO;
    protected IPaymentService paymentService;
    protected IExternalService externalService;
    
	public HomeFolderService() {
        super();
    }

    public final HomeFolder getById(final Long id)
        throws CvqException, CvqObjectNotFoundException {

        return (HomeFolder) homeFolderDAO.findById(HomeFolder.class, id);
    }

    // TODO : to be removed
    public final HomeFolder getByRequestId(final Long requestId)
        throws CvqException {

        Request request = requestService.getById(requestId);
    	if (request == null)
    		return null;
    	else
    		return request.getHomeFolder();
    }

    public final Set<HomeFolder> getAll()
        throws CvqException {

        List homeFolders = homeFolderDAO.listAll();
        return new LinkedHashSet<HomeFolder>(homeFolders);
    }

    public final Set<Child> getChildren(final Long homeFolderId)
        throws CvqException {

        List childList = childDAO.listByHomeFolder(homeFolderId);
        return new LinkedHashSet(childList);
    }

    public final Set<Adult> getAdults(final Long homeFolderId)
        throws CvqException {

        List adultList = adultDAO.listByHomeFolder(homeFolderId);
        return new LinkedHashSet(adultList);
    }

    // TODO : use document service instead
    public final Set getAssociatedDocuments(final Long homeFolderId)
        throws CvqException {

        logger.debug("getAssociatedDocuments() searching documents for home folder id : "
                     + homeFolderId);

        List documentsList = documentDAO.listByHomeFolder(homeFolderId);
        return new LinkedHashSet(documentsList);
    }

    public HomeFolder create(final Adult adult) throws CvqException {

        Address adress = adult.getAdress();
		genericDAO.create(adress);
		
		// create the home folder
        HomeFolder homeFolder = new HomeFolder();
        initializeCommonAttributes(homeFolder);
        homeFolder.setAdress(adress);
		
        adult.addHomeFolderResponsibleRole();
        adultService.create(adult, homeFolder, null, true);

        Set<Adult> allIndividuals = new HashSet<Adult>();
        allIndividuals.add(adult);

        homeFolder.setIndividuals(allIndividuals);
        
        genericDAO.create(homeFolder);
        return homeFolder;
    }

    public HomeFolder create(Set<Adult> adults, Set<Child> children, Address address)
        throws  CvqException, CvqModelException {
        
        // create the home folder
        HomeFolder homeFolder = new HomeFolder();
        initializeCommonAttributes(homeFolder);
        homeFolder.setAdress(address);
        homeFolder.setBoundToRequest(Boolean.valueOf(false));

        Set<Individual> allIndividuals = new HashSet<Individual>();
        allIndividuals.addAll(adults);
        allIndividuals.addAll(children);
        homeFolder.setIndividuals(allIndividuals);
        
        // create children belonging to this home folder
        if (children != null) {
            for (Child child : children) {
                childService.create(child, homeFolder, address, false);
                allIndividuals.add(child);
            }
        }

        // create the other adults belonging to this home folder
        for (Adult adult : adults) {
            adultService.create(adult, homeFolder, address, false);
            allIndividuals.add(adult);
        }

        homeFolderDAO.create(homeFolder);
        
        for (Adult adult : adults) {
            adultService.assignLogin(adult);
        }
        
        return homeFolder;
    }

    public void initializeCommonAttributes(HomeFolder homeFolder) 
        throws CvqException {

        homeFolder.setState(ActorState.PENDING);
        homeFolder.setEnabled(Boolean.TRUE);
    }

    public final void modify(final HomeFolder homeFolder)
        throws CvqException {

        if (homeFolder != null)
            homeFolderDAO.update(homeFolder);
    }

    public final void delete(final Long id)
        throws CvqException {

        HomeFolder homeFolder = getById(id);
        delete(homeFolder);
    }

    public final void delete(final HomeFolder homeFolder)
        throws CvqException {

        logger.debug("delete() deleting home folder " + homeFolder.getId());
    	
        // payments need to be deleted first because adults are requesters for them
        if (homeFolder.getPayments() != null) {
            for (Object object : homeFolder.getPayments()) {
                Payment payment = (Payment) object;
                paymentService.delete(payment);
            }
        }

        Set individuals = homeFolder.getIndividuals();
        Set<Adult> adults = new HashSet<Adult>();
        Set<Child> children = new HashSet<Child>();
        Iterator individualsIt = individuals.iterator();
        while (individualsIt.hasNext()) {
            Individual individual = (Individual) individualsIt.next();
            if (individual instanceof Adult)
                adults.add((Adult)individual);
            else if (individual instanceof Child)
                children.add((Child) individual);
        }
        
        for (Adult adult : adults) {
            adultService.delete(adult, true);
        }
        
        for (Child child : children) {
            childService.delete(child, true);
        }
        
        // then home folder itself
        if (homeFolder.getDocuments() != null)
            homeFolder.getDocuments().clear();

        homeFolderDAO.delete(homeFolder);
    }
    
    public Set<ExternalAccountItem> getExternalAccounts(Long homeFolderId, String type) 
        throws CvqException {
        
        logger.debug("getExternalAccounts() Home folder : " + homeFolderId);

        Set<Request> requests = requestService.getByHomeFolderId(homeFolderId);
        Set<String> homeFolderRequestsTypes = new HashSet<String>();
        for (Request request : requests) {
            homeFolderRequestsTypes.add(request.getRequestType().getLabel());
        }

        return externalService.getExternalAccounts(homeFolderId, 
                homeFolderRequestsTypes, type);
    }

    public Map<Individual, Map<String, String>> getIndividualExternalAccountsInformation(Long homeFolderId) 
        throws CvqException {

        Set<Request> requests = requestService.getByHomeFolderId(homeFolderId);
        Set<String> homeFolderRequestsTypes = new HashSet<String>();
        for (Request request : requests) {
            homeFolderRequestsTypes.add(request.getRequestType().getLabel());
        }

        return externalService.getIndividualAccountsInformation(homeFolderId, 
                homeFolderRequestsTypes);
    }

    public void loadExternalDepositAccountDetails(ExternalDepositAccountItem edai) 
        throws CvqException {
        
        externalService.loadDepositAccountDetails(edai);
    }

    public void loadExternalInvoiceDetails(ExternalInvoiceItem eii) 
        throws CvqException {

        externalService.loadInvoiceDetails(eii);
    }

    @SuppressWarnings("unchecked")
    private void updateHomeFolderState(HomeFolder homeFolder, ActorState newState) 
		throws CvqException {

		logger.debug("Gonna update state of home folder : " + homeFolder.getId());
		homeFolder.setState(newState);
		homeFolderDAO.update(homeFolder);

		// retrieve individuals and validate them
		Set<Individual> homeFolderIndividuals = homeFolder.getIndividuals();
		for (Individual individual : homeFolderIndividuals) {
			individualService.updateIndividualState(individual, newState);
		}
    }
    
    /* FIXME : security checks */
    public final void validate(final Long id)
        throws CvqException, CvqObjectNotFoundException {

        HomeFolder homeFolder = getById(id);
        validate(homeFolder);
    }

    public final void validate(HomeFolder homeFolder)
        throws CvqException, CvqObjectNotFoundException {

        logger.debug("Gonna validate home folder : " + homeFolder.getId());
        updateHomeFolderState(homeFolder, ActorState.VALID);
    }
    
    /* FIXME : security checks */
    public final void invalidate(final Long id)
        throws CvqException, CvqObjectNotFoundException {

        HomeFolder homeFolder = getById(id);
        invalidate(homeFolder);
    }

    public final void invalidate(HomeFolder homeFolder) 
        throws CvqException, CvqObjectNotFoundException {

		logger.debug("Gonna invalidate home folder : " + homeFolder.getId());
		updateHomeFolderState(homeFolder, ActorState.INVALID);
	}

    public final void archive(final Long id) 
        throws CvqException, CvqObjectNotFoundException {
        
        HomeFolder homeFolder = getById(id);
        archive(homeFolder);
    }

    public final void archive(HomeFolder homeFolder) 
        throws CvqException, CvqObjectNotFoundException {
        
        logger.debug("Gonna archive home folder : " + homeFolder.getId());
        updateHomeFolderState(homeFolder, ActorState.ARCHIVED);
        
        requestService.archiveHomeFolderRequests(homeFolder);
    }

    public void notifyPaymentByMail(Payment payment) throws CvqException {
    	
        String mailSendTo = payment.getHomeFolder().getHomeFolderResponsible().getEmail();
        if (mailSendTo == null || mailSendTo.equals("")) {
            logger.debug("notifyPaymentByMail() e-citizen has no email adress, returning");
            return;
        }
        
        LocalAuthorityConfigurationBean lacb = SecurityContext.getCurrentConfigurationBean();
        Map<String, String> mailMap = 
            lacb.getMailAsMap("hasPaymentNotification", "getPaymentNotificationData", 
                    "CommitPaymentConfirmation");
        
		if (mailMap != null) {
			String mailSubject = mailMap.get("mailSubject") != null ? mailMap.get("mailSubject") : "";
			String mailBodyFilename = mailMap.get("mailData") != null ? mailMap.get("mailData") : "";
            String mailBody = 
                localAuthorityRegistry.getBufferedCurrentLocalAuthorityResource(
                        ILocalAuthorityRegistry.TXT_ASSETS_RESOURCE_TYPE, mailBodyFilename, false);
			
            if (mailBody == null) {
                logger.warn("notifyPaymentByMail() did not find mail template "
                        + mailBodyFilename + " for local authority " 
                        + SecurityContext.getCurrentSite().getName());
                return;
            }
            
			//	Mail body variable
			mailBody = mailBody.replace("${broker}",
					payment.getBroker() != null ? payment.getBroker() : "" );
			mailBody = mailBody.replace("${cvqReference}",
					payment.getCvqReference() != null ? payment.getCvqReference() : "" );
			mailBody = mailBody.replace("${paymentMode}",
					payment.getPaymentMode() !=  null ? payment.getPaymentMode().toString() : "");
			mailBody = mailBody.replace("${commitDate}",
					payment.getCommitDate().toString());
			
			mailService.send(null, mailSendTo, null, mailSubject, mailBody);
		}
	}
    
	public void setLocalAuthorityRegistry(ILocalAuthorityRegistry localAuthorityRegistry) {
        this.localAuthorityRegistry = localAuthorityRegistry;
    }

    public void setMailService(IMailService mailService) {
		this.mailService = mailService;
	}
    public void setIndividualService(final IIndividualService individualService) {
		this.individualService = individualService;
	}

    public void setRequestService(final IRequestService requestService) {
        this.requestService = requestService;
    }
    
    public final void setHomeFolderDAO(final IHomeFolderDAO homeFolderDAO) {
        this.homeFolderDAO = homeFolderDAO;
    }

   public final void setDocumentDAO(final IDocumentDAO documentDAO) {
        this.documentDAO = documentDAO;
    }

    public final void setChildDAO(final IChildDAO childDAO) {
        this.childDAO = childDAO;
    }

    public final void setAdultDAO(final IAdultDAO adultDAO) {
        this.adultDAO = adultDAO;
    }

	public void setGenericDAO(IGenericDAO genericDAO) {
		this.genericDAO = genericDAO;
	}

    public void setPaymentService(IPaymentService paymentService) {
        this.paymentService = paymentService;
    }

    public void setAdultService(IAdultService adultService) {
        this.adultService = adultService;
    }

    public void setChildService(IChildService childService) {
        this.childService = childService;
    }

    public void setExternalService(IExternalService externalService) {
        this.externalService = externalService;
    }
}

