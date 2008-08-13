package fr.capwebct.modules.payment.webservice.client.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.ws.client.WebServiceClientException;
import org.springframework.ws.client.core.WebServiceTemplate;

import fr.capwebct.capdemat.GetHomeFoldersRequestDocument;
import fr.capwebct.capdemat.GetHomeFoldersResponseDocument;
import fr.capwebct.capdemat.HomeFolderType;
import fr.capwebct.capdemat.IndividualType;
import fr.capwebct.capdemat.GetHomeFoldersRequestDocument.GetHomeFoldersRequest;
import fr.capwebct.capdemat.GetHomeFoldersResponseDocument.GetHomeFoldersResponse;
import fr.capwebct.modules.payment.business.CapwebctFamilyAccount;
import fr.capwebct.modules.payment.business.CapwebctIndividual;
import fr.capwebct.modules.payment.exception.CpmWebServiceException;
import fr.capwebct.modules.payment.webservice.client.ICapwebctWebServiceClient;

public class CapwebctWebServiceClient implements ICapwebctWebServiceClient {

    private Log logger = LogFactory.getLog(CapwebctWebServiceClient.class);

    private WebServiceTemplate webServiceTemplate;
    private String localAuthority;
    
    public List<CapwebctFamilyAccount> getCapwebctFamilyAccounts() 
        throws CpmWebServiceException {
        
        GetHomeFoldersRequestDocument homeFoldersRequestDocument =
            GetHomeFoldersRequestDocument.Factory.newInstance();
        GetHomeFoldersRequest homeFoldersRequest =
            homeFoldersRequestDocument.addNewGetHomeFoldersRequest();
        homeFoldersRequest.setLocalAuthority(localAuthority);
        homeFoldersRequest.setShortForm(true);

        // Ask family accounts to CapWebCT
        GetHomeFoldersResponseDocument homeFoldersResponseDocument = null;
        try {
            homeFoldersResponseDocument = (GetHomeFoldersResponseDocument) 
                webServiceTemplate.marshalSendAndReceive(homeFoldersRequestDocument);
        } catch (WebServiceClientException wsce) {
            logger.error("getCapwebctFamilyAccounts() error while exchanging with client " 
                    + wsce.getMessage());
            wsce.printStackTrace();
            throw new CpmWebServiceException(wsce.getLocalizedMessage());
        } 
        GetHomeFoldersResponse homeFoldersResponse = 
            homeFoldersResponseDocument.getGetHomeFoldersResponse();
        
        // Transform received accounts into our own model
        HomeFolderType[] homeFolderTypes = homeFoldersResponse.getHomeFolderArray();
        List<CapwebctFamilyAccount> capwebctFamilyAccounts = new ArrayList<CapwebctFamilyAccount>();
        for (HomeFolderType homeFolderType : homeFolderTypes) {
            logger.debug("Got home folder : " + homeFolderType.getId());
            logger.debug("Got individual size : " + homeFolderType.getIndividualArray().length);
            CapwebctFamilyAccount capwebctFamilyAccount = new CapwebctFamilyAccount();
            capwebctFamilyAccount.setCapwebctFamilyAccountId(homeFolderType.getId());
            capwebctFamilyAccount.setAddress(homeFolderType.getAddress());
            for (IndividualType individualType : homeFolderType.getIndividualArray()) {
                CapwebctIndividual capwebctIndividual = new CapwebctIndividual();
                capwebctIndividual.setCapwebctIndividualId(individualType.getId());
                capwebctIndividual.setFirstName(individualType.getFirstName());
                capwebctIndividual.setLastName(individualType.getLastName());
                capwebctIndividual.setChild(individualType.getIsChild());
                capwebctIndividual.setResponsible(individualType.getIsHomeFolderResponsible());
                capwebctFamilyAccount.addIndividual(capwebctIndividual);
                
                if (individualType.getIsHomeFolderResponsible()) {
                    String responsibleFullName = 
                        individualType.getLastName() + " " + individualType.getFirstName();
                    capwebctFamilyAccount.setResponsibleFullName(responsibleFullName);
                }
            }
            capwebctFamilyAccounts.add(capwebctFamilyAccount);
        }
        
        return capwebctFamilyAccounts;
    }

    public void setWebServiceTemplate(WebServiceTemplate webServiceTemplate) {
        this.webServiceTemplate = webServiceTemplate;
    }

    public void setLocalAuthority(String localAuthority) {
        this.localAuthority = localAuthority;
    }
}
