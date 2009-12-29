package fr.cg95.cvq.service.payment;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import fr.cg95.cvq.business.payment.Payment;
import fr.cg95.cvq.business.payment.PaymentMode;
import fr.cg95.cvq.business.payment.PaymentState;
import fr.cg95.cvq.business.users.CreationBean;
import fr.cg95.cvq.dao.payment.IPaymentDAO;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.security.SecurityContext;
import fr.cg95.cvq.service.payment.job.PaymentInitializationDateCheckerJob;
import fr.cg95.cvq.util.DateUtils;

public class PaymentServiceJobTest extends PaymentTestCase {
	       
	private IPaymentDAO paymentDAO;
	private PaymentInitializationDateCheckerJob paymentInitilizationDateCheckerJob;
	
    @Override
    public void onSetUp() throws Exception {
        super.onSetUp();

        paymentDAO = super.<IPaymentDAO>getApplicationBean("paymentDAO");
        paymentInitilizationDateCheckerJob = 
            super.<PaymentInitializationDateCheckerJob>getApplicationBean("paymentInitializationCheckerJob");
    }
	
	private Payment createPayment(int timeShifting, PaymentState paymentState, boolean commitAlert, 
			String broker, String cvqReference , PaymentMode paymentMode) throws CvqException {
       
		SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.FRONT_OFFICE_CONTEXT);

		CreationBean cb = gimmeAnHomeFolder();
        
		SecurityContext.setCurrentEcitizen(cb.getLogin());
		
		Payment payment = new Payment();
		
		Date dateTest = DateUtils.getShiftedDate(Calendar.HOUR, timeShifting);
		
		payment.setInitializationDate(dateTest);
		payment.setState(paymentState);
		payment.setCommitAlert(commitAlert);
		payment.setBroker(broker);
		payment.setCvqReference(cvqReference);
		payment.setPaymentMode(paymentMode);
		
		payment.setHomeFolderId(SecurityContext.getCurrentEcitizen().getHomeFolder().getId());
		payment.setRequesterId(SecurityContext.getCurrentUserId());
		payment.setRequesterLastName(SecurityContext.getCurrentEcitizen().getLastName());
		payment.setRequesterFirstName(SecurityContext.getCurrentEcitizen().getFirstName());
		
		paymentDAO.create(payment);
		
		return payment;
    }
	
	public void testPaymentDAOSearchNotCommited() throws CvqException {
    	
    	Payment payment = 
    	    createPayment(-4, PaymentState.INITIALIZED, false, "BOKER", "CVQR", PaymentMode.CARD);
    	Payment payment2 = 
    	    createPayment(-5, PaymentState.INITIALIZED, false, "BOKER", "CVQR", PaymentMode.CARD);
    	Payment payment3 = 
    	    createPayment(-6, PaymentState.INITIALIZED, false, "BOKER", "CVQR", PaymentMode.CARD);
    	
    	continueWithNewTransaction();
    	
    	List<Payment> listPayment = paymentDAO.searchNotCommited();
    	assertEquals(3, listPayment.size());
    	
    	// Drop testing datas
    	paymentDAO.delete(paymentDAO.findById(Payment.class, payment.getId()));
    	paymentDAO.delete(paymentDAO.findById(Payment.class, payment2.getId()));
    	paymentDAO.delete(paymentDAO.findById(Payment.class, payment3.getId()));
    	
        continueWithNewTransaction();

        listPayment = paymentDAO.searchNotCommited();
        assertEquals(0, listPayment.size());
    }
	
    public void testPaymentInitialization() throws CvqException {
    	
    	Payment payment = 
    	    createPayment(0, PaymentState.INITIALIZED, false, "BOKER", "CVQR", PaymentMode.CARD);
    	Payment payment2 = 
    	    createPayment(-4, PaymentState.CANCELLED, false, "BOKER", "CVQR", PaymentMode.CARD);
    	Payment payment3 = 
    	    createPayment(-4, PaymentState.CANCELLED, true, "BOKER", "CVQR", PaymentMode.CARD);
    	
    	Payment payment4 = 
    	    createPayment(-4, PaymentState.INITIALIZED, false, "BOKER", "CVQR", PaymentMode.CARD);
    	Payment payment5 = 
    	    createPayment(-5, PaymentState.INITIALIZED, false, "BOKER", "CVQR", PaymentMode.CARD);
    	Payment payment6 = 
    	    createPayment(-6, PaymentState.INITIALIZED, false, "BOKER", "CVQR", PaymentMode.CARD);
    	
    	continueWithNewTransaction();
    	
    	// Do not forget that the job comits the transaction and closed the session
    	paymentInitilizationDateCheckerJob.launchJob();
    	
    	startTransaction();
        
        // set the current site and citizen after launching the job since it resets them after running
        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.FRONT_OFFICE_CONTEXT);
        SecurityContext.setCurrentEcitizen(homeFolderResponsible.getLogin());

    	List<Payment> listPayment = paymentDAO.searchNotCommited();
    	assertTrue(listPayment.isEmpty());
    	
    	// Drop testing datas
    	paymentDAO.delete(paymentDAO.findById(Payment.class, payment.getId()));
    	paymentDAO.delete(paymentDAO.findById(Payment.class, payment2.getId()));
    	paymentDAO.delete(paymentDAO.findById(Payment.class, payment3.getId()));
    	paymentDAO.delete(paymentDAO.findById(Payment.class, payment4.getId()));
    	paymentDAO.delete(paymentDAO.findById(Payment.class, payment5.getId()));
    	paymentDAO.delete(paymentDAO.findById(Payment.class, payment6.getId()));
    	
        continueWithNewTransaction();

        listPayment = paymentDAO.searchNotCommited();
        assertTrue(listPayment.isEmpty());
    }
}