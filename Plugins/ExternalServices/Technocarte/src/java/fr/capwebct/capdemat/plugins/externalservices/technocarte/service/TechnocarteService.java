package fr.capwebct.capdemat.plugins.externalservices.technocarte.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

import java.net.MalformedURLException;

import org.apache.log4j.Logger;
import org.apache.xmlbeans.XmlObject;

import org.apache.soap.*;
import org.apache.soap.rpc.*;

import fr.cg95.cvq.business.payment.ExternalAccountItem;
import fr.cg95.cvq.business.payment.ExternalDepositAccountItem;
import fr.cg95.cvq.business.payment.ExternalInvoiceItem;
import fr.cg95.cvq.business.request.LocalReferentialEntry;
import fr.cg95.cvq.business.request.LocalReferentialType;
import fr.cg95.cvq.business.users.Adult;
import fr.cg95.cvq.exception.CvqConfigurationException;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.external.ExternalServiceBean;
import fr.cg95.cvq.external.IExternalProviderService;
import fr.cg95.cvq.service.request.ILocalReferentialService;
import fr.cg95.cvq.service.users.IIndividualService;
import fr.cg95.cvq.xml.common.LocalReferentialDataType;
import fr.cg95.cvq.xml.common.RequestType;
import fr.cg95.cvq.xml.request.school.SchoolCanteenRegistrationRequestDocument.SchoolCanteenRegistrationRequest;
import fr.cg95.cvq.xml.request.school.PerischoolActivityRegistrationRequestDocument.PerischoolActivityRegistrationRequest;
import fr.cg95.cvq.xml.request.school.RecreationActivityRegistrationRequestDocument.RecreationActivityRegistrationRequest;
import fr.cg95.cvq.xml.request.school.SchoolRegistrationRequestDocument.SchoolRegistrationRequest;
import fr.cg95.cvq.xml.request.ecitizen.HomeFolderModificationRequestDocument.HomeFolderModificationRequest;
import fr.cg95.cvq.xml.request.school.DayCareCenterRegistrationRequestDocument.DayCareCenterRegistrationRequest;
import fr.cg95.cvq.xml.request.school.LearningActivitiesDiscoveryRegistrationRequestDocument.LearningActivitiesDiscoveryRegistrationRequest;



public class TechnocarteService implements IExternalProviderService {
    private static Logger logger = Logger.getLogger(TechnocarteService.class);
    
    private String label;

    private IIndividualService individualService;

    private String endportpath;
    private String username;
    private String password;
    private String urlkiosque;

    private void CallMethodeTechno(String Method, String Params[][], int Nbparams) throws MalformedURLException, SOAPException{
    	Call call = new Call();
    	String encodingStyleURI = org.apache.soap.Constants.NS_URI_SOAP_ENC;
    	call.setEncodingStyleURI(encodingStyleURI);
    	call.setTargetObjectURI ("urn:WSPocketTechno2" );
    	call.setMethodName(Method);
    		
    	Vector parameters = new Vector();
    	for (int i = 0; i< Nbparams;i++){
    	    parameters.addElement(new Parameter(Params[i][0], String.class, Params[i][1], null));
    	}
    	call.setParams(parameters);
    	Response soap_response = call.invoke(new java.net.URL("http://serveur.technocarte.fr/KIOSQUEDEMO/kiosque/web_methode/web_methode.php" ), "" );
    		 
    	if ( soap_response.generatedFault() ) {
    		     
    	    Fault fault = soap_response.getFault ();
    	    logger.debug("The call failed: " );
    	    logger.debug("Fault Code   = " + fault.getFaultCode());
    	    logger.debug("Fault Entrie   = " + fault.getFaultEntries());
    	    logger.debug("Fault String = " + fault.getFaultString());
    	    logger.debug("Detail Entrie   = " + fault.getDetailEntries());
    	    logger.debug("Fault Actor URI   = " + fault.getFaultActorURI());
    	    
    	} else {
    	    Parameter soap_result = soap_response.getReturnValue();
    	    logger.debug(soap_result.getName());
    	    logger.debug(soap_result.getValue());
    	    logger.debug("J'ai une réponse !!!" );
    	}
    }

    public String sendRequest(XmlObject requestXml) throws  CvqException {
    	
    	String Method = "ReceptionCapdemat";
    	String Params[][]  = new String[2][2]; 
    
        RequestType request = (RequestType) requestXml;
        Vector parameters = new Vector();
        //checkConfiguration(externalServiceBean);
        
        parameters.addElement(new Parameter("var", String.class, requestXml, null));
    	/*if (request instanceof SchoolRegistrationRequest) {
    	    SchoolRegistrationRequest scrr = (SchoolRegistrationRequest) request;
            parameters.addElement(new Parameter("var", String.class, requestXml, null));
    	} else if (request instanceof SchoolCanteenRegistrationRequest) {
            SchoolCanteenRegistrationRequest scrr = (SchoolCanteenRegistrationRequest) request;
            parameters.addElement(new Parameter("var", String.class, requestXml, null));
        } else if (request instanceof PerischoolActivityRegistrationRequest) {
            PerischoolActivityRegistrationRequest scrr = (PerischoolActivityRegistrationRequest) request;
            parameters.addElement(new Parameter("var", String.class, requestXml, null));
        } else if (request instanceof RecreationActivityRegistrationRequest) {
            RecreationActivityRegistrationRequest scrr = (RecreationActivityRegistrationRequest) request;
            parameters.addElement(new Parameter("var", String.class, requestXml, null));
        } else if (request instanceof HomeFolderModificationRequest) {
        	HomeFolderModificationRequest scrr = (HomeFolderModificationRequest) request;
            parameters.addElement(new Parameter("var", String.class, requestXml, null));
        } else if (request instanceof DayCareCenterRegistrationRequest) {
        	DayCareCenterRegistrationRequest scrr = (DayCareCenterRegistrationRequest) request;
            parameters.addElement(new Parameter("var", String.class, requestXml, null));
        } else if (request instanceof LearningActivitiesDiscoveryRegistrationRequest) {
        	LearningActivitiesDiscoveryRegistrationRequest scrr = (LearningActivitiesDiscoveryRegistrationRequest) request;
            parameters.addElement(new Parameter("var", String.class, requestXml, null));
    	} else {
    	    parameters.addElement(new Parameter("var", String.class, "Fault", null));
    	}*/
        parameters.addElement(new Parameter("code_appli", String.class, "Capdemat", null));    	
    	try {
            Call call = new Call();
            String encodingStyleURI = org.apache.soap.Constants.NS_URI_SOAP_ENC;
            call.setEncodingStyleURI(encodingStyleURI);
            call.setTargetObjectURI ("urn:WSPocketTechno2" );
            call.setMethodName(Method);
                
           
            call.setParams(parameters);
            Response soap_response = call.invoke(new java.net.URL(urlkiosque), "" );
                 
            if ( soap_response.generatedFault() ) {
                     
                Fault fault = soap_response.getFault ();
                logger.debug("The call failed: " );
                logger.debug("Fault Code   = " + fault.getFaultCode());
                logger.debug("Fault Entrie   = " + fault.getFaultEntries());
                logger.debug("Fault String = " + fault.getFaultString());
                logger.debug("Detail Entrie   = " + fault.getDetailEntries());
                logger.debug("Fault Actor URI   = " + fault.getFaultActorURI());
                
            } else {
                Parameter soap_result = soap_response.getReturnValue();
                logger.debug(urlkiosque);
                logger.debug("J'ai une réponse !!!" );
            }

    	} catch (Exception e) {
    	    e.printStackTrace();
    	    throw new CvqException();
    	}
    	return null;
    }

    public void checkConfiguration(ExternalServiceBean externalServiceBean, String localAuthorityName)
            throws CvqConfigurationException {
    	  logger.debug("url kiosque = " + externalServiceBean.getProperty("urlkiosque"));
    	  setUrlKiosque((String) externalServiceBean.getProperty("urlkiosque"));
    }

    public void creditHomeFolderAccounts(Collection purchaseItems, String cvqReference,
            String bankReference, Long homeFolderId, String externalHomeFolderId, String externalId, Date validationDate) throws CvqException {
        logger.info("creditHomeFolderAccounts() no action associated");
    }

    public Map<String, List<ExternalAccountItem>> getAccountsByHomeFolder(Long homeFolderId, String externalHomeFolderId, String externalId)
            throws CvqException {
        logger.info("getAccountsByHomeFolder() no action associated");
        return null;
    }

    public Map<Date, String> getConsumptions(Long key, Date dateFrom, Date dateTo)
            throws CvqException {
        logger.info("getConsumptionsByRequest() no action associated");
        return null;
    }

    public void loadDepositAccountDetails(ExternalDepositAccountItem edai) throws CvqException {
        logger.info("loadDepositAccountDetails() no action associated");
    }

    public void loadInvoiceDetails(ExternalInvoiceItem eii) throws CvqException {
        logger.info("loadInvoiceDetails() no action associated");
    }

    public String helloWorld() throws CvqException {
        return null;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public void setEndportpath(String endportpath) {
        this.endportpath = endportpath;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setIndividualService(IIndividualService individualService) {
        this.individualService = individualService;
    }

    public boolean supportsConsumptions() {
        return false;
    }

    public boolean handlesTraces() {
        return false;
    }

    public List<String> checkExternalReferential(final XmlObject requestXml) {
        return new ArrayList<String>(0);
    }

    public Map<String, Object> loadExternalInformations(XmlObject requestXml)
        throws CvqException {
        return Collections.emptyMap();
    }
    public void setUrlKiosque(String url) {
        this.urlkiosque = url;
    }    
}

