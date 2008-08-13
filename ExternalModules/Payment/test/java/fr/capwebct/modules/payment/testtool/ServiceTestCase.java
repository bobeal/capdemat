package fr.capwebct.modules.payment.testtool;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ConfigurableApplicationContext;

import fr.capwebct.modules.payment.business.CapwebctFamilyAccount;
import fr.capwebct.modules.payment.business.ExternalApplication;
import fr.capwebct.modules.payment.business.ExternalFamilyAccount;
import fr.capwebct.modules.payment.exception.CpmBusinessException;
import fr.capwebct.modules.payment.service.IAccountService;
import fr.capwebct.modules.payment.service.IContractService;
import fr.capwebct.modules.payment.service.IExternalApplicationService;
import fr.capwebct.modules.payment.service.IFamilyAccountService;
import fr.capwebct.modules.payment.service.IInvoiceService;
import fr.capwebct.modules.payment.service.IPaymentService;
import fr.capwebct.modules.payment.webservice.support.IWebServiceClient;
import fr.capwebct.modules.payment.webservice.support.WebServiceClient;

public class ServiceTestCase extends MyAbstractDependencyInjectionSpringContextTests {

    protected static Log logger = LogFactory.getLog(ServiceTestCase.class);
    
    protected static IInvoiceService invoiceService;
    protected static IAccountService accountService;
    protected static IContractService contractService;
    protected static IFamilyAccountService familyAccountService;
    protected static IExternalApplicationService externalApplicationService;
    protected static IPaymentService paymentService;
    
    protected static IWebServiceClient webServiceClient;
    
    protected static ExternalApplication externalApplication;
    
    private static Boolean isInitialized = Boolean.FALSE;

    protected String[] getConfigLocations() {
        return new String[] { "classpath:applicationContext.xml",
                "classpath:applicationContext-test.xml" };
    }

    protected void onSetUp() throws Exception {
        ConfigurableApplicationContext cac = getContext(getConfigLocations());
        
        synchronized(isInitialized) {
            if (!isInitialized.booleanValue()) {
            	
            	invoiceService = (IInvoiceService) cac.getBean("invoiceService");
            	accountService = (IAccountService) cac.getBean("accountService");
            	contractService = (IContractService) cac.getBean("contractService");
            	familyAccountService = (IFamilyAccountService) cac.getBean("familyAccountService");
                paymentService = (IPaymentService) cac.getBean("paymentService");
                externalApplicationService = 
                    (IExternalApplicationService) cac.getBean("externalApplicationService");
            	
            	webServiceClient = (WebServiceClient)cac.getBean("webServiceClient");
            	
                // create an external application to be used by tests cases
                try {
                    externalApplication = 
                        BusinessObjectsFactory.gimmeExternalApplication("ExternalApplication");
                    externalApplicationService.create(externalApplication);
                } catch (CpmBusinessException e) {
                    // can't happen
                }

                logger.debug("onSetUp() starting");
                isInitialized = Boolean.TRUE;
            }
        }
    }

	@Override
	protected void onTearDown() throws Exception {
		super.onTearDown();
	}
    
    protected void deleteData(boolean deleteExternalAccount, boolean deleteCapwebctAccount,
            boolean deleteFamilyAccount) {
       
        if (deleteExternalAccount) {
            List<ExternalFamilyAccount> externalFamilyAccountList =
                familyAccountService.getAllExternalFamilyAccounts();
            for (ExternalFamilyAccount externalFamilyAccount : externalFamilyAccountList)
                familyAccountService.deleteExternalFamilyAccount(externalFamilyAccount);
        }
        if (deleteCapwebctAccount) {
            List<CapwebctFamilyAccount> capwebctList = 
                familyAccountService.getAllCapwebctFamilyAccounts();
            for (CapwebctFamilyAccount account : capwebctList)
                familyAccountService.deleteCapwebctFamilyAccount(account);
        }
        if (deleteFamilyAccount) {
            invoiceService.deleteAllInvoices();
            accountService.deleteAllAccounts();
            contractService.deleteAllContracts();
        }
    }
}
