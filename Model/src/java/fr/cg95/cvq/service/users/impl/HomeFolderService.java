package fr.cg95.cvq.service.users.impl;

import java.util.HashSet;
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
import fr.cg95.cvq.business.users.IndividualRole;
import fr.cg95.cvq.business.users.RoleEnum;
import fr.cg95.cvq.business.users.payment.ExternalAccountItem;
import fr.cg95.cvq.business.users.payment.ExternalDepositAccountItem;
import fr.cg95.cvq.business.users.payment.ExternalInvoiceItem;
import fr.cg95.cvq.business.users.payment.Payment;
import fr.cg95.cvq.dao.IGenericDAO;
import fr.cg95.cvq.dao.users.IAdultDAO;
import fr.cg95.cvq.dao.users.IChildDAO;
import fr.cg95.cvq.dao.users.IHomeFolderDAO;
import fr.cg95.cvq.dao.users.IIndividualDAO;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.exception.CvqModelException;
import fr.cg95.cvq.exception.CvqObjectNotFoundException;
import fr.cg95.cvq.external.IExternalService;
import fr.cg95.cvq.payment.IPaymentService;
import fr.cg95.cvq.security.SecurityContext;
import fr.cg95.cvq.service.authority.ILocalAuthorityRegistry;
import fr.cg95.cvq.service.authority.LocalAuthorityConfigurationBean;
import fr.cg95.cvq.service.document.IDocumentService;
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

    protected IGenericDAO genericDAO;
    protected IHomeFolderDAO homeFolderDAO;
    protected IIndividualDAO individualDAO;
    protected IChildDAO childDAO;
    protected IAdultDAO adultDAO;

    protected IIndividualService individualService;
    protected IAdultService adultService;
    protected IChildService childService;

    protected ILocalAuthorityRegistry localAuthorityRegistry;
    protected IMailService mailService;
    protected IRequestService requestService;
    protected IDocumentService documentService;
    protected IPaymentService paymentService;
    protected IExternalService externalService;
    
    public final HomeFolder getById(final Long id)
        throws CvqException, CvqObjectNotFoundException {

        return (HomeFolder) homeFolderDAO.findById(HomeFolder.class, id);
    }

    public final Set<HomeFolder> getAll()
        throws CvqException {

        List<HomeFolder> homeFolders = homeFolderDAO.listAll();
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

    public List<Individual> getIndividuals(Long homeFolderId) throws CvqException {
        
        return individualDAO.listByHomeFolder(homeFolderId);
    }

    @Override
    public Adult getHomeFolderResponsible(Long homeFolderId) throws CvqException {
        
        List<Individual> individuals = 
            individualDAO.listByHomeFolderRole(homeFolderId, RoleEnum.HOME_FOLDER_RESPONSIBLE);
        
        // here we can make the assumption that we properly enforced the role
        return (Adult) individuals.get(0);
    }

    public HomeFolder create(final Adult adult) throws CvqException {

        Address adress = adult.getAdress();
		genericDAO.create(adress);
		
		// create the home folder
        HomeFolder homeFolder = new HomeFolder();
        initializeCommonAttributes(homeFolder);
        homeFolder.setAdress(adress);
		
        IndividualRole individualRole = new IndividualRole();
        individualRole.setOwner(adult);
        individualRole.setRole(RoleEnum.HOME_FOLDER_RESPONSIBLE);
        individualRole.setHomeFolderId(homeFolder.getId());
        Set<IndividualRole> individualRoles = new HashSet<IndividualRole>();
        individualRoles.add(individualRole);
        adult.setIndividualRoles(individualRoles);
        adultService.create(adult, homeFolder, null, true);

        Set<Individual> allIndividuals = new HashSet<Individual>();
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
        homeFolderDAO.create(homeFolder);
        genericDAO.create(address);

        Set<Individual> allIndividuals = new HashSet<Individual>();
        allIndividuals.addAll(adults);
        allIndividuals.addAll(children);
        
        for (Individual individual : allIndividuals) {
            if (individual instanceof Child) 
                childService.create((Child) individual, homeFolder, address, false);
            else if (individual instanceof Adult)
                adultService.create((Adult) individual, homeFolder, address, true);                
        }
        
        // now that all individuals are persisted, we can deal with roles
        boolean foundHomeFolderResponsible = false;
        for (Adult adult : adults) {
            if (adult.getIndividualRoles() != null) {
                for (IndividualRole individualRole : adult.getIndividualRoles()) {
                    if (individualRole.getRole().equals(RoleEnum.HOME_FOLDER_RESPONSIBLE)) {
                        if (foundHomeFolderResponsible)
                            throw new CvqModelException("homeFolder.error.onlyOneResponsibleIsAllowed");
                        foundHomeFolderResponsible = true;
                        individualRole.setHomeFolderId(homeFolder.getId());
                        adultService.modify(adult);
                    } else if (individualRole.getRole().equals(RoleEnum.TUTOR)) {
                        String individualName = individualRole.getIndividualName();
                        if (individualName != null) {
                            // individual name is provided, it is the tutor of another individual
                            for (Individual individual : allIndividuals) {
                                String otherAdultName = 
                                    individual.getLastName() + " " + individual.getFirstName();
                                if (otherAdultName.equals(individualName))
                                    individualRole.setIndividualId(individual.getId());
                            }
                        } else {
                            // individual name is not provided, it is the tutor of the home folder
                            individualRole.setHomeFolderId(homeFolder.getId());
                        }
                        adultService.modify(adult);
                    } else if (individualRole.getRole().equals(RoleEnum.CLR_FATHER)
                            || individualRole.getRole().equals(RoleEnum.CLR_MOTHER)
                            || individualRole.getRole().equals(RoleEnum.CLR_TUTOR)) {
                        String childName = individualRole.getIndividualName();
                        for (Child child : children) {
                            if (childName.equals(child.getLastName() + " " + child.getFirstName())) {
                                individualRole.setIndividualId(child.getId());
                            }
                        }
                        adultService.modify(adult);
                    }
                }
            }
        }
        
        // check all children have at least a legal responsible
        for (Child child : children) {
            RoleEnum[] roles = new RoleEnum[3];
            roles[0] = RoleEnum.CLR_FATHER;
            roles[1] = RoleEnum.CLR_MOTHER;
            roles[2] = RoleEnum.CLR_TUTOR;
            List<Individual> legalResponsibles = 
                individualDAO.listBySubjectRoles(child.getId(), roles);
            if (legalResponsibles == null || legalResponsibles.isEmpty())
                throw new CvqModelException("Child must have at least one legal responsible");
            else if (legalResponsibles.size() > 3) 
                throw new CvqModelException("Too many legal responsibles for child : " 
                      + child.getFirstName());
        }
        
        if (!foundHomeFolderResponsible)
            throw new CvqModelException("homeFolder.error.responsibleIsRequired");

        homeFolder.setIndividuals(allIndividuals);
        homeFolderDAO.update(homeFolder);
        
        return homeFolder;
    }

    @Override
    public Long addAdult(Long homeFolderId, Adult adult, Address address) throws CvqException {
        HomeFolder homeFolder = getById(homeFolderId);
        return adultService.create(adult, homeFolder, address, true);
    }

    @Override
    public Long addChild(Long homeFolderId, Child child, Address address) throws CvqException {
        HomeFolder homeFolder = getById(homeFolderId);
        return childService.create(child, homeFolder, address, false);
    }

    private void initializeCommonAttributes(HomeFolder homeFolder) 
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

    private final void delete(final HomeFolder homeFolder)
        throws CvqException {

        // payments need to be deleted first because adults are requesters for them
        if (homeFolder.getPayments() != null) {
            for (Object object : homeFolder.getPayments()) {
                Payment payment = (Payment) object;
                paymentService.delete(payment);
            }
        }

        // delete all documents related to home folder and associated individuals
        
        documentService.deleteHomeFolderDocuments(homeFolder.getId());

        Set<Individual> individuals = homeFolder.getIndividuals();
        for (Individual individual : individuals) {
            documentService.deleteIndividualDocuments(individual.getId());
        }
        
        // need to stack adults and children to ensure that adults are deleted before children
        // because of legal responsibles constraints
        // TODO REFACTORING
        Set<Adult> adults = new HashSet<Adult>();
        Set<Child> children = new HashSet<Child>();
        for (Individual individual : individuals) {
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

        homeFolderDAO.delete(homeFolder);
    }
    
    public Set<ExternalAccountItem> getExternalAccounts(Long homeFolderId, String type) 
        throws CvqException {
        
        // FIXME : at least request optimization or even refactoring ?
        List<Request> requests = requestService.getByHomeFolderId(homeFolderId);
        Set<String> homeFolderRequestsTypes = new HashSet<String>();
        for (Request request : requests) {
            homeFolderRequestsTypes.add(request.getRequestType().getLabel());
        }

        return externalService.getExternalAccounts(homeFolderId, 
                homeFolderRequestsTypes, type);
    }

    public Map<Individual, Map<String, String>> getIndividualExternalAccountsInformation(Long homeFolderId) 
        throws CvqException {

        // FIXME : at least request optimization or even refactoring ?
        List<Request> requests = requestService.getByHomeFolderId(homeFolderId);
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
    
    @Override
    public void onRequestArchived(Long homeFolderId, Long requestId) throws CvqException {
        HomeFolder homeFolder = getById(homeFolderId);
        if (homeFolder.getBoundToRequest() && homeFolder.getOriginRequestId().equals(requestId)) {
            archive(homeFolder);
        }
    }

    @Override
    public void onRequestCancelled(Long homeFolderId, Long requestId) throws CvqException {
        HomeFolder homeFolder = getById(homeFolderId);
        if (homeFolder.getBoundToRequest() && homeFolder.getOriginRequestId().equals(requestId)) {
            invalidate(homeFolder);
        }
    }

    @Override
    public void onRequestRejected(Long homeFolderId, Long requestId) throws CvqException {
        HomeFolder homeFolder = getById(homeFolderId);
        if (homeFolder.getBoundToRequest() && homeFolder.getOriginRequestId().equals(requestId)) {
            invalidate(homeFolder);
        }
    }

    @Override
    public void onRequestValidated(Long homeFolderId, Long requestId) throws CvqException {
        HomeFolder homeFolder = getById(homeFolderId);
        if (homeFolder.getBoundToRequest() && homeFolder.getOriginRequestId().equals(requestId)) {
            validate(homeFolder);
        }
    }

    @Override
    public void onRequestDeleted(final Long homeFolderId, final Long requestId)
        throws CvqException {
        HomeFolder homeFolder = getById(homeFolderId);
        if (homeFolder.getBoundToRequest() && homeFolder.getOriginRequestId().equals(requestId)) {
            logger.debug("onRequestDeleted() Home folder " + homeFolderId 
                    + " belongs to request " + requestId + ", removing it from DB");
            delete(homeFolder);
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
    	
        Adult homeFolderResponsible = getHomeFolderResponsible(payment.getHomeFolder().getId());
        String mailSendTo = homeFolderResponsible.getEmail();
        if (mailSendTo == null || mailSendTo.equals("")) {
            logger.warn("notifyPaymentByMail() e-citizen has no email adress, returning");
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

    public final void setChildDAO(final IChildDAO childDAO) {
        this.childDAO = childDAO;
    }

    public final void setAdultDAO(final IAdultDAO adultDAO) {
        this.adultDAO = adultDAO;
    }

	public void setIndividualDAO(IIndividualDAO individualDAO) {
        this.individualDAO = individualDAO;
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

    public void setDocumentService(IDocumentService documentService) {
        this.documentService = documentService;
    }

    public void setExternalService(IExternalService externalService) {
        this.externalService = externalService;
    }
}

