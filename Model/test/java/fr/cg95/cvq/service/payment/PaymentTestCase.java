package fr.cg95.cvq.service.payment;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;

import fr.cg95.cvq.testtool.ServiceTestCase;

public class PaymentTestCase extends ServiceTestCase {

    @Autowired
    protected IPaymentService paymentService;
    @Resource(name="fakePaymentProviderService")
    protected IPaymentProviderService fakePaymentProviderService;
}
