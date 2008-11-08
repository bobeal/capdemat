package fr.capwebct.capdemat.plugins.externalservices.horanet.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.context.ConfigurableApplicationContext;

import fr.cg95.cvq.business.authority.School;
import fr.cg95.cvq.business.authority.SectionType;
import fr.cg95.cvq.business.users.Address;
import fr.cg95.cvq.business.users.CreationBean;
import fr.cg95.cvq.business.users.HomeFolder;
import fr.cg95.cvq.business.users.Individual;
import fr.cg95.cvq.business.users.LocalReferentialData;
import fr.cg95.cvq.business.request.MeansOfContact;
import fr.cg95.cvq.business.request.MeansOfContactEnum;
import fr.cg95.cvq.business.request.ecitizen.HomeFolderModificationRequest;
import fr.cg95.cvq.business.request.school.PerischoolActivityRegistrationRequest;
import fr.cg95.cvq.business.request.school.SchoolCanteenRegistrationRequest;
import fr.cg95.cvq.business.request.school.SchoolRegistrationRequest;
import fr.cg95.cvq.business.users.payment.ExternalAccountItem;
import fr.cg95.cvq.business.users.payment.ExternalDepositAccountItem;
import fr.cg95.cvq.business.users.payment.ExternalDepositAccountItemDetail;
import fr.cg95.cvq.business.users.payment.ExternalInvoiceItem;
import fr.cg95.cvq.business.users.payment.ExternalInvoiceItemDetail;
import fr.cg95.cvq.business.users.payment.ExternalTicketingContractItem;
import fr.cg95.cvq.business.users.payment.PurchaseItem;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.external.IExternalProviderService;
import fr.cg95.cvq.payment.IPaymentService;
import fr.cg95.cvq.security.SecurityContext;
import fr.cg95.cvq.service.request.school.IPerischoolActivityRegistrationRequestService;
import fr.cg95.cvq.service.request.school.ISchoolCanteenRegistrationRequestService;
import fr.cg95.cvq.service.request.school.ISchoolRegistrationRequestService;
import fr.cg95.cvq.testtool.ServiceTestCase;

/**
 * @author Benoit Orihuela (bor@zenexity.fr)
 */
public class HoranetServiceTest extends ServiceTestCase {

	private IExternalProviderService externalProviderService;
	private ISchoolRegistrationRequestService srrService;
	private ISchoolCanteenRegistrationRequestService scrrService;
	private IPerischoolActivityRegistrationRequestService parrService;
	
	private void setServices() throws CvqException{
		ConfigurableApplicationContext cac;
        try {
            cac = getContext(getConfigLocations());
    		externalProviderService = (IExternalProviderService) cac.getBean("horanetExternalService");
            srrService =
            	(ISchoolRegistrationRequestService) cac.getBean("schoolRegistrationRequestService");
    		scrrService = 
    			(ISchoolCanteenRegistrationRequestService) cac.getBean("schoolCanteenRegistrationRequestService");
    		parrService = 
    			(IPerischoolActivityRegistrationRequestService) cac.getBean("perischoolActivityRegistrationRequestService");
        } catch (Exception e) {
            throw new CvqException(e.getMessage());
        }
    }

//	public void testHelloWorld() throws CvqException {
//
//		setServices();
//		
//		try {
//			String helloWorldResult = externalProviderService.helloWorld();
//			Assert.assertEquals(helloWorldResult, "Hello World");
//		} catch (CvqException e) {
//			e.printStackTrace();
//			fail("exception while sending hello world");
//		}
//	}
	
	public void testEcitizenFlow() throws Exception {
		
		setServices();
		
        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.FRONT_OFFICE_CONTEXT);

        // create a vo card request (to create home folder and associates)
        CreationBean cb = gimmeAnHomeFolder();

        Long requestId = cb.getRequestId();
        String proposedLogin = cb.getLogin();
        
        continueWithNewTransaction();
        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.BACK_OFFICE_CONTEXT);
        SecurityContext.setCurrentAgent(agentNameWithCategoriesRoles);

        iVoCardRequestService.complete(requestId);
        iVoCardRequestService.validate(requestId);

        continueWithNewTransaction();
        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.FRONT_OFFICE_CONTEXT);
        SecurityContext.setCurrentEcitizen(proposedLogin);

        HomeFolder homeFolder = iHomeFolderService.getById(cb.getHomeFolderId());
        homeFolder.setFamilyQuotient("354,44");
        iHomeFolderService.modify(homeFolder);
        
        // create and validate a school registration request to be able to issue
        // a school canteen registration request
        /////////////////////////////////////////////////////////////////////////
        
        SchoolRegistrationRequest srrRequest = new SchoolRegistrationRequest();
        srrRequest.setSection(SectionType.FIRST_SECTION);
        srrRequest.setRulesAndRegulationsAcceptance(Boolean.valueOf(true));
        srrRequest.setSchool((School) schoolService.getAll().iterator().next());
        srrRequest.setUrgencyPhone("0102030405");
        srrRequest.setCurrentSection(SectionType.FIRST_SECTION);
        srrRequest.setCurrentSchoolAddress("CurrentSchoolAddress");
        srrRequest.setCurrentSchoolName("CurrentSchoolName");
        srrRequest.setSubjectId(child1.getId());
        srrRequest.setSubjectLastName(child1.getLastName());
        MeansOfContact meansOfContact = iMeansOfContactService.getMeansOfContactByType(MeansOfContactEnum.MAIL);
        srrRequest.setMeansOfContact(meansOfContact);
        srrService.create(srrRequest, homeFolderResponsible.getId(), null);
     
		continueWithNewTransaction();
		SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.BACK_OFFICE_CONTEXT);
		SecurityContext.setCurrentAgent(agentNameWithCategoriesRoles);

		srrService.complete(srrRequest);
		srrService.validate(srrRequest);

        // create and validate a school canteen registration request and check 
        // that data is correctly sent
        /////////////////////////////////////////////////////////////////////////

		continueWithNewTransaction();
        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.FRONT_OFFICE_CONTEXT);
        SecurityContext.setCurrentEcitizen(proposedLogin);

        SchoolCanteenRegistrationRequest scrrRequest = new SchoolCanteenRegistrationRequest();
        scrrRequest.setSection(SectionType.FIRST_SECTION);
        scrrRequest.setRulesAndRegulationsAcceptance(Boolean.valueOf(true));
        scrrRequest.setSchool((School) schoolService.getAll().iterator().next());
        scrrRequest.setUrgencyPhone("0102030405");
        scrrRequest.setDoctorPhone("0102030405");
        scrrRequest.setDoctorName("DoctorName");
        scrrRequest.setHospitalizationPermission(Boolean.valueOf(true));
        scrrRequest.setFoodAllergy(Boolean.valueOf(true));
        scrrRequest.setSubjectId(child1.getId());
        scrrRequest.setSubjectLastName(child1.getLastName());
        scrrRequest.setMeansOfContact(meansOfContact);
        LocalReferentialData foodDietLrd = new LocalReferentialData();
        foodDietLrd.setName("NoPork");
        List<LocalReferentialData> foodDiets = new ArrayList<LocalReferentialData>();
        foodDiets.add(foodDietLrd);
        scrrRequest.setFoodDiet(foodDiets);
        scrrService.create(scrrRequest, homeFolderResponsible.getId(), null);
        
		continueWithNewTransaction();
		SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.BACK_OFFICE_CONTEXT);
		SecurityContext.setCurrentAgent(agentNameWithCategoriesRoles);

		scrrService.complete(scrrRequest);
//		logger.debug("gonna send request : ");
//		logger.debug(scrrRequest.modelToXmlString());
		scrrService.validate(scrrRequest);

        // create and validate a perischool activity registration request and check 
        // that data is correctly sent
        ///////////////////////////////////////////////////////////////////////////

		continueWithNewTransaction();
        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.FRONT_OFFICE_CONTEXT);
        SecurityContext.setCurrentEcitizen(proposedLogin);

        PerischoolActivityRegistrationRequest parrRequest = new PerischoolActivityRegistrationRequest();
        parrRequest.setClassTripPermission(Boolean.valueOf(true));
        parrRequest.setChildPhotoExploitationPermission(Boolean.valueOf(true));
        parrRequest.setRulesAndRegulationsAcceptance(Boolean.valueOf(true));
        parrRequest.setUrgencyPhone("0102030405");
        parrRequest.setHospitalizationPermission(Boolean.valueOf(true));
        parrRequest.setSubjectId(child1.getId());
        parrRequest.setSubjectLastName(child1.getLastName());
        parrRequest.setMeansOfContact(meansOfContact);
        LocalReferentialData activityLrd = new LocalReferentialData();
        activityLrd.setName("EveningNursery");
        List<LocalReferentialData> activities = new ArrayList<LocalReferentialData>();
        activities.add(activityLrd);
        parrRequest.setPerischoolActivity(activities);
        parrService.create(parrRequest, homeFolderResponsible.getId(), null);

		continueWithNewTransaction();
		SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.BACK_OFFICE_CONTEXT);
		SecurityContext.setCurrentAgent(agentNameWithCategoriesRoles);

		parrService.complete(parrRequest);
//		logger.debug("gonna send request : ");
//		logger.debug(scrrRequest.modelToXmlString());
		parrService.validate(parrRequest);

		continueWithNewTransaction();
        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.FRONT_OFFICE_CONTEXT);
        SecurityContext.setCurrentEcitizen(proposedLogin);

        // get account details, perform a payment on a deposit account and on a 
        // ticketing contract then load details of those two accounts
        ///////////////////////////////////////////////////////////////////////////

        ExternalDepositAccountItem edai = null;
        ExternalTicketingContractItem etci = null;
        
        // Step 1 : load accounts and choose one deposit and one ticketing
        Map<String, List<ExternalAccountItem>> externalAccounts = 
        	externalProviderService.getAccountsByHomeFolder(homeFolder.getId(), null, null);
        for (String accountType : externalAccounts.keySet()) {
        	logger.debug("inspecting account type " + accountType);
        	List<ExternalAccountItem> accountsByType = externalAccounts.get(accountType);
        	for (ExternalAccountItem eai : accountsByType) {
        		logger.debug("got account " + eai.toString());
                logger.debug("got account " + eai.getFriendlyLabel());
        		if (accountType.equals(IPaymentService.EXTERNAL_DEPOSIT_ACCOUNTS)) {
        			logger.debug("found a test deposit account");
        			edai = (ExternalDepositAccountItem) eai;

                    // load account details
                    externalProviderService.loadDepositAccountDetails(edai);
                    Set<ExternalDepositAccountItemDetail> accountDetails = edai.getAccountDetails();
                    if (accountDetails != null) {
                        for (ExternalDepositAccountItemDetail edaiDetail : accountDetails) {
                            logger.debug("detail - payment id : " + edaiDetail.getPaymentId());
                            logger.debug("detail - payment type : " + edaiDetail.getPaymentType());
                            logger.debug("detail - payment date : " + edaiDetail.getDate());
                            logger.debug("detail - payment value : " + edaiDetail.getValue());
                        }
                    }
        		} else if (accountType.equals(IPaymentService.EXTERNAL_TICKETING_ACCOUNTS)
        				&& etci == null) {
        			logger.debug("found a test ticketing contract account");
        			etci = (ExternalTicketingContractItem) eai;
        		} else if (accountType.equals(IPaymentService.EXTERNAL_INVOICES)) {
        		    logger.debug("found an invoice");
                    ExternalInvoiceItem eii = (ExternalInvoiceItem) eai;
                    
                    // load invoice details
                    externalProviderService.loadInvoiceDetails(eii);
                    Set<ExternalInvoiceItemDetail> eiiDetails = eii.getInvoiceDetails();
                    if (eiiDetails != null) {
                        for (ExternalInvoiceItemDetail eiiDetail : eiiDetails) {
                            logger.debug("detail - label : " + eiiDetail.getLabel());
                            logger.debug("detail - subject name : " + eiiDetail.getSubjectName());
                            logger.debug("detail - subject surname : " + eiiDetail.getSubjectSurname());
                            logger.debug("detail - quantity : " + eiiDetail.getQuantity());
                            logger.debug("detail - unit price : " + eiiDetail.getUnitPrice());
                            logger.debug("detail - value : " + eiiDetail.getValue());
                        }
                    }
                }
        	}
        }

        if (etci == null && edai == null)
        	fail("nothing to pay on");
        
        // Step 2 : perform a payment
        List<PurchaseItem> purchaseItems = new ArrayList<PurchaseItem>();
//        if (etci != null) {
//        	etci.setQuantity(Integer.valueOf("13"));
//            etci.setAmount(etci.getQuantity() * etci.getUnitPrice());
//        	purchaseItems.add(etci);
//        }
        if (edai != null) {
        	edai.setAmount(Double.valueOf("2000"));
        	purchaseItems.add(edai);
        }
        externalProviderService.creditHomeFolderAccounts(purchaseItems, "CVQ_REF_1234", "BANK_REF_1234", 
        		homeFolder.getId(), null, null, new Date());
        
        // TODO : check account credit ... when horanet finished integration !

        // load account details
        externalProviderService.loadDepositAccountDetails(edai);
        Set<ExternalDepositAccountItemDetail> accountDetails = edai.getAccountDetails();
        if (accountDetails != null) {
            for (ExternalDepositAccountItemDetail edaiDetail : accountDetails) {
                logger.debug("detail - payment id : " + edaiDetail.getPaymentId());
                logger.debug("detail - payment type : " + edaiDetail.getPaymentType());
                logger.debug("detail - payment date : " + edaiDetail.getDate());
                logger.debug("detail - payment value : " + edaiDetail.getValue());
            }
        }
        
        // get consumptions for our two registrations
        /////////////////////////////////////////////
        
        Calendar calendar = new GregorianCalendar();
        Date dateTo = calendar.getTime();
        calendar.add(Calendar.MONTH, -3);
        Date dateFrom = calendar.getTime();
        Map<Date, String> consumptions = 
        	externalProviderService.getConsumptionsByRequest(scrrRequest, dateFrom, dateTo);
        for (Date date : consumptions.keySet()) {
        	logger.debug("on date " + date + ", got consumption : " + consumptions.get(date));
        }

        // test loading administrative information for BO display
        Map<Individual, Map<String, String>> accountsInfo = 
            externalProviderService.getIndividualAccountsInformation(homeFolder.getId(), null, null);
        for (Individual individual : accountsInfo.keySet()) {
            logger.debug("account info for individual : " + individual.getFirstName());
            for (String key : accountsInfo.get(individual).keySet()) {
                logger.debug("key : " + key);
                logger.debug("value : " + accountsInfo.get(individual).get(key));
            }
        }

        // send an home folder modification request
        /////////////////////////////////////////////

        HomeFolderModificationRequest hfmr = 
            iHomeFolderModificationRequestService.create(homeFolder.getId(), 
                    homeFolder.getHomeFolderResponsible().getId());
        Address address = homeFolder.getAdress();
        address.setStreetName("Ma nouvelle adresse");
        iHomeFolderModificationRequestService.modify(hfmr, 
                iHomeFolderService.getAdults(homeFolder.getId()), 
                iHomeFolderService.getChildren(homeFolder.getId()), address);
        
        continueWithNewTransaction();
        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.BACK_OFFICE_CONTEXT);
        SecurityContext.setCurrentAgent(agentNameWithCategoriesRoles);

        iHomeFolderModificationRequestService.complete(hfmr);
        iHomeFolderModificationRequestService.validate(hfmr);

	}
}
