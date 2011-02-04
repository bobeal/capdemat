package fr.capwebct.capdemat.plugins.externalservices.horanet.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.Assert.*;

import fr.cg95.cvq.business.payment.ExternalAccountItem;
import fr.cg95.cvq.business.payment.ExternalDepositAccountItem;
import fr.cg95.cvq.business.payment.ExternalDepositAccountItemDetail;
import fr.cg95.cvq.business.payment.ExternalInvoiceItem;
import fr.cg95.cvq.business.payment.ExternalInvoiceItemDetail;
import fr.cg95.cvq.business.payment.ExternalTicketingContractItem;
import fr.cg95.cvq.business.payment.PurchaseItem;
import fr.cg95.cvq.business.request.LocalReferentialData;
import fr.cg95.cvq.business.request.RequestState;
import fr.cg95.cvq.business.request.ecitizen.HomeFolderModificationRequest;
import fr.cg95.cvq.business.request.school.PerischoolActivityRegistrationRequest;
import fr.cg95.cvq.business.request.school.SchoolCanteenRegistrationRequest;
import fr.cg95.cvq.business.request.school.SchoolRegistrationRequest;
import fr.cg95.cvq.business.users.Address;
import fr.cg95.cvq.business.users.CreationBean;
import fr.cg95.cvq.business.users.HomeFolder;
import fr.cg95.cvq.business.users.MeansOfContact;
import fr.cg95.cvq.business.users.MeansOfContactEnum;
import fr.cg95.cvq.business.users.SectionType;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.external.IExternalProviderService;
import fr.cg95.cvq.security.SecurityContext;
import fr.cg95.cvq.service.payment.IPaymentService;
import fr.cg95.cvq.service.request.RequestTestCase;

/**
 * @author Benoit Orihuela (bor@zenexity.fr)
 */
public class HoranetServiceTest extends RequestTestCase {

	private IExternalProviderService externalProviderService;
	
	private void setServices() throws CvqException{
	    externalProviderService = getApplicationBean("horanetExternalService");
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
        CreationBean cb = gimmeAnHomeFolderWithRequest();

        Long requestId = cb.getRequestId();
        String proposedLogin = cb.getLogin();
        
        continueWithNewTransaction();
        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.BACK_OFFICE_CONTEXT);
        SecurityContext.setCurrentAgent(agentNameWithCategoriesRoles);

        requestWorkflowService.updateRequestState(requestId, RequestState.COMPLETE, null);
        requestWorkflowService.updateRequestState(requestId, RequestState.VALIDATED, null);

        continueWithNewTransaction();
        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.FRONT_OFFICE_CONTEXT);
        SecurityContext.setCurrentEcitizen(proposedLogin);

        HomeFolder homeFolder = homeFolderService.getById(cb.getHomeFolderId());
        homeFolder.setFamilyQuotient("354,44");
        homeFolderService.modify(homeFolder);
        
        // create and validate a school registration request to be able to issue
        // a school canteen registration request
        /////////////////////////////////////////////////////////////////////////
        
        SchoolRegistrationRequest srrRequest = new SchoolRegistrationRequest();
        srrRequest.setSection(SectionType.FIRST_SECTION);
        srrRequest.setRulesAndRegulationsAcceptance(Boolean.valueOf(true));
        srrRequest.setSchool(schoolService.getAll().get(0));
        srrRequest.setUrgencyPhone("0102030405");
        srrRequest.setCurrentSection(SectionType.FIRST_SECTION);
        srrRequest.setCurrentSchoolAddress("CurrentSchoolAddress");
        srrRequest.setCurrentSchoolName("CurrentSchoolName");
        srrRequest.setSubjectId(child1.getId());
        srrRequest.setSubjectLastName(child1.getLastName());
        MeansOfContact meansOfContact = meansOfContactService.getMeansOfContactByType(MeansOfContactEnum.MAIL);
        srrRequest.setMeansOfContact(meansOfContact);
        requestWorkflowService.create(srrRequest, null, null, null);
     
		continueWithNewTransaction();
		SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.BACK_OFFICE_CONTEXT);
		SecurityContext.setCurrentAgent(agentNameWithCategoriesRoles);

        requestWorkflowService.updateRequestState(srrRequest.getId(), RequestState.COMPLETE, null);
        requestWorkflowService.updateRequestState(srrRequest.getId(), RequestState.VALIDATED, null);

        // create and validate a school canteen registration request and check 
        // that data is correctly sent
        /////////////////////////////////////////////////////////////////////////

		continueWithNewTransaction();
        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.FRONT_OFFICE_CONTEXT);
        SecurityContext.setCurrentEcitizen(proposedLogin);

        SchoolCanteenRegistrationRequest scrrRequest = new SchoolCanteenRegistrationRequest();
        scrrRequest.setSection(SectionType.FIRST_SECTION);
        scrrRequest.setRulesAndRegulationsAcceptance(Boolean.valueOf(true));
        scrrRequest.setSchool(schoolService.getAll().get(0));
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
        requestWorkflowService.create(scrrRequest, null, null, null);
        
		continueWithNewTransaction();
		SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.BACK_OFFICE_CONTEXT);
		SecurityContext.setCurrentAgent(agentNameWithCategoriesRoles);

        requestWorkflowService.updateRequestState(scrrRequest.getId(), RequestState.COMPLETE, null);
        requestWorkflowService.updateRequestState(scrrRequest.getId(), RequestState.VALIDATED, null);

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
        requestWorkflowService.create(parrRequest, null, null, null);

		continueWithNewTransaction();
		SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.BACK_OFFICE_CONTEXT);
		SecurityContext.setCurrentAgent(agentNameWithCategoriesRoles);

        requestWorkflowService.updateRequestState(parrRequest.getId(), RequestState.COMPLETE, null);
        requestWorkflowService.updateRequestState(parrRequest.getId(), RequestState.VALIDATED, null);

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
        	externalProviderService.getConsumptions(scrrRequest.getId(), dateFrom, dateTo);
        for (Date date : consumptions.keySet()) {
        	logger.debug("on date " + date + ", got consumption : " + consumptions.get(date));
        }

        // send an home folder modification request
        /////////////////////////////////////////////

        HomeFolderModificationRequest hfmr = new HomeFolderModificationRequest();
        Address address = homeFolder.getAddress();
        address.setStreetName("Ma nouvelle adresse");
        requestWorkflowService.createAccountModificationRequest(hfmr, 
                homeFolderService.getAdults(homeFolder.getId()), 
                homeFolderService.getChildren(homeFolder.getId()), null, address, null, null);
        
        continueWithNewTransaction();
        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.BACK_OFFICE_CONTEXT);
        SecurityContext.setCurrentAgent(agentNameWithCategoriesRoles);

        requestWorkflowService.updateRequestState(hfmr.getId(), RequestState.COMPLETE, null);
        requestWorkflowService.updateRequestState(hfmr.getId(), RequestState.VALIDATED, null);
	}
}
