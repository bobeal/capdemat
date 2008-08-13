package fr.cg95.cvq.service.users.impl;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;

import fr.cg95.cvq.business.users.ActorState;
import fr.cg95.cvq.business.users.Address;
import fr.cg95.cvq.business.users.Adult;
import fr.cg95.cvq.business.users.Child;
import fr.cg95.cvq.business.users.HomeFolder;
import fr.cg95.cvq.business.users.Individual;
import fr.cg95.cvq.business.users.Request;
import fr.cg95.cvq.business.users.payment.ExternalAccountItem;
import fr.cg95.cvq.business.users.payment.ExternalDepositAccountItem;
import fr.cg95.cvq.business.users.payment.ExternalInvoiceItem;
import fr.cg95.cvq.business.users.payment.Payment;
import fr.cg95.cvq.dao.IGenericDAO;
import fr.cg95.cvq.dao.users.IAdultDAO;
import fr.cg95.cvq.dao.users.IChildDAO;
import fr.cg95.cvq.dao.users.IDocumentDAO;
import fr.cg95.cvq.dao.users.IHomeFolderDAO;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.exception.CvqModelException;
import fr.cg95.cvq.exception.CvqObjectNotFoundException;
import fr.cg95.cvq.external.ExternalServiceBean;
import fr.cg95.cvq.external.IExternalService;
import fr.cg95.cvq.payment.IPaymentService;
import fr.cg95.cvq.security.SecurityContext;
import fr.cg95.cvq.service.authority.ILocalAuthorityRegistry;
import fr.cg95.cvq.service.authority.LocalAuthorityConfigurationBean;
import fr.cg95.cvq.service.users.IAdultService;
import fr.cg95.cvq.service.users.IChildService;
import fr.cg95.cvq.service.users.IHomeFolderService;
import fr.cg95.cvq.service.users.IIndividualService;
import fr.cg95.cvq.service.users.IRequestService;
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
    
	public HomeFolderService() {
        super();
    }

    public final HomeFolder getById(final Long id)
        throws CvqException, CvqObjectNotFoundException {

        return (HomeFolder) homeFolderDAO.findById(HomeFolder.class, id);
    }

    public final HomeFolder getByRequestId(final Long requestId)
        throws CvqException {

        // TODO : use homeFolderDAO instead
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

    // TODO : move to document service
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

        Set<ExternalAccountItem> accountsInfoSet = new HashSet<ExternalAccountItem>();

        LocalAuthorityConfigurationBean lacb = SecurityContext.getCurrentConfigurationBean();
        Set<IExternalService> externalServices = lacb.getExternalServicesObjects();

        if (externalServices != null && externalServices.size() > 0) {

            Set<Request> requests = requestService.getByHomeFolderId(homeFolderId);

            for (IExternalService service : externalServices) {
                ExternalServiceBean esb = lacb.getExternalServiceBean(service);
                // ask accounts information by home folder or by request
                // according to what the external service supports
                if (esb.supportAccountsByHomeFolder()) {
                    // check service supports at least one of the home folder current requests
                    boolean supportAtLeastOne = false;
                    if (requests != null) {
                        for (Request request : requests) {
                            if (esb.supportRequestType(request.getRequestType().getLabel())) {
                                supportAtLeastOne = true;
                                break;
                            }
                        }
                    }
                    if (supportAtLeastOne) {
                        Map<String, List<ExternalAccountItem>> homeFolderAccounts = 
                                service.getAccountsByHomeFolder(homeFolderId);
                        if (homeFolderAccounts != null && homeFolderAccounts.get(type) != null) {
                                accountsInfoSet.addAll(homeFolderAccounts.get(type));
                        }
                    }
                } else {
                    for (Request request : requests) {
                        if (esb.supportRequestType(request.getRequestType().getLabel())) {
                            Map<String, List<ExternalAccountItem>> requestAccounts = 
                                service.getAccountsByRequest(request.getId());
                            if (requestAccounts != null && requestAccounts.get(type) != null)
                                accountsInfoSet.addAll(requestAccounts.get(type));
                        }
                    }
                }
            }
        } else {
            logger.info("getExternalAccounts() No external service defined for this local authority");
        }

        return accountsInfoSet;
    }

    /**
     * Get the list of external services for which the given home folder has a relation
     * (ie an account).
     */
    private Set<IExternalService> getRelatedExternalServices(Long homeFolderId) 
        throws CvqException {
    
        logger.debug("getRelatedExternalServices() Home folder : " + homeFolderId);

        Set<IExternalService> relatedExternalServices = new HashSet<IExternalService>();

        LocalAuthorityConfigurationBean lacb = SecurityContext.getCurrentConfigurationBean();
        Set externalServices = lacb.getExternalServicesObjects();

        if (externalServices != null && externalServices.size() > 0) {
            Iterator externalServicesIt = externalServices.iterator();

            Set requests = requestService.getByHomeFolderId(homeFolderId);

            while (externalServicesIt.hasNext()) {
                IExternalService service = (IExternalService) externalServicesIt.next();
                ExternalServiceBean esb = lacb.getExternalServiceBean(service);

                if (esb.supportAccountsByHomeFolder()) {
                    // check service supports at least one of the home folder current requests
                    if (requests != null) {
                        Iterator requestsIt = requests.iterator();
                        while (requestsIt.hasNext()) {
                            Request request = (Request) requestsIt.next();
                            if (esb.supportRequestType(request.getRequestType().getLabel())) {
                                relatedExternalServices.add(service);
                                break;
                            }
                        }
                    }
                } else {
                    Iterator requestsIt = requests.iterator();
                    while (requestsIt.hasNext()) {
                        Request request = (Request) requestsIt.next();
                        if (esb.supportRequestType(request.getRequestType().getLabel())) {
                            relatedExternalServices.add(service);
                        }
                    }
                }
            }
        } else {
            logger.info("getRelatedExternalServices() No external service defined for this local authority");
        }

        return relatedExternalServices;
    }
    
    public Map<Individual, Map<String, String>> getIndividualExternalAccountsInformation(Long homeFolderId) throws CvqException {

        Map<Individual, Map<String, String>> result = new HashMap<Individual, Map<String,String>>();
        Set<IExternalService> relatedExternalServices = getRelatedExternalServices(homeFolderId);
        for (IExternalService externalService : relatedExternalServices) {
            Map<Individual, Map<String, String> > serviceResults =
                externalService.getIndividualAccountsInformation(homeFolderId);
            for (Individual individual : serviceResults.keySet()) {
                if (result.get(individual) == null) {
                    result.put(individual, serviceResults.get(individual));
                } else {
                    Map<String, String> currentIndividualInfo = result.get(individual);
                    currentIndividualInfo.putAll(serviceResults.get(individual));
                }
            }
        }
        
        return result;
    }

    public void loadExternalDepositAccountDetails(ExternalDepositAccountItem edai) 
        throws CvqException {
        
        LocalAuthorityConfigurationBean lacb = SecurityContext.getCurrentConfigurationBean();
        Set externalServices = lacb.getExternalServicesObjects();

        if (externalServices != null && externalServices.size() > 0) {
            Iterator externalServicesIt = externalServices.iterator();

            while (externalServicesIt.hasNext()) {
                IExternalService service = (IExternalService) externalServicesIt.next();
                if (service.getLabel().equals(edai.getExternalServiceLabel())) {
                    service.loadDepositAccountDetails(edai);
                    return;
                }
            }
        }
    }

    public void loadExternalInvoiceDetails(ExternalInvoiceItem eii) 
        throws CvqException {
    
        LocalAuthorityConfigurationBean lacb = SecurityContext.getCurrentConfigurationBean();
        Set externalServices = lacb.getExternalServicesObjects();

        if (externalServices != null && externalServices.size() > 0) {
            Iterator externalServicesIt = externalServices.iterator();

            while (externalServicesIt.hasNext()) {
                IExternalService service = (IExternalService) externalServicesIt.next();
                if (service.getLabel().equals(eii.getExternalServiceLabel())) {
                    service.loadInvoiceDetails(eii);
                    return;
                }
            }
        }
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
}

