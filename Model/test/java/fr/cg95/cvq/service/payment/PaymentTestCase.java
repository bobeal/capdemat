package fr.cg95.cvq.service.payment;

import fr.cg95.cvq.testtool.ServiceTestCase;

public class PaymentTestCase extends ServiceTestCase {

    protected IPaymentService paymentService;
    protected IPaymentProviderService fakePaymentProviderService;

    @Override
    public void onSetUp() throws Exception {
        super.onSetUp();
        fakePaymentProviderService = getApplicationBean("fakePaymentProviderService");
    }
    
    public void setPaymentService(IPaymentService paymentService) {
        this.paymentService = paymentService;
    }
}
