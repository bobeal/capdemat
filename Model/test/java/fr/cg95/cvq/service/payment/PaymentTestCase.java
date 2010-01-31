package fr.cg95.cvq.service.payment;

import org.springframework.context.ConfigurableApplicationContext;

import fr.cg95.cvq.testtool.ServiceTestCase;

public class PaymentTestCase extends ServiceTestCase {

    protected static IPaymentService iPaymentService;
    protected static IPaymentProviderService iFakePaymentProviderService;

    @Override
    protected void onSetUp() throws Exception {
        super.onSetUp();
        ConfigurableApplicationContext cac = getContext(getConfigLocations());
        iFakePaymentProviderService = 
            (IPaymentProviderService) cac.getBean("fakePaymentProviderService");
    }
    
    public void setPaymentService(IPaymentService paymentService) {
        iPaymentService = paymentService;
    }
}
