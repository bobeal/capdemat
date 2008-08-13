package fr.capwebct.modules.payment.webservice.client;

import java.util.List;

import fr.capwebct.modules.payment.business.CapwebctFamilyAccount;
import fr.capwebct.modules.payment.exception.CpmWebServiceException;

/**
 * Web service in charge of communications with CapWebCT provided services. 
 */
public interface ICapwebctWebServiceClient {
    
    List<CapwebctFamilyAccount> getCapwebctFamilyAccounts() 
        throws CpmWebServiceException;
}
