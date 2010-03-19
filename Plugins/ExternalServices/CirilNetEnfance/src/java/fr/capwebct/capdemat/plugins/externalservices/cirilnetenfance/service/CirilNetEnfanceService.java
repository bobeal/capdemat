package fr.capwebct.capdemat.plugins.externalservices.cirilnetenfance.service;

import java.text.SimpleDateFormat;
import java.util.*;

import org.apache.log4j.Logger;
import org.jdom.Attribute;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.xpath.XPath;

import fr.capwebct.capdemat.plugins.externalservices.cirilnetenfance.ws.CreditAccount;
import fr.capwebct.capdemat.plugins.externalservices.cirilnetenfance.ws.FamilyAccounts;
import fr.capwebct.capdemat.plugins.externalservices.cirilnetenfance.ws.InvoiceDetails;
import fr.capwebct.capdemat.plugins.externalservices.cirilnetenfance.ws.Registration;


import fr.cg95.cvq.business.authority.School;
import fr.cg95.cvq.business.school.PerischoolActivityRegistrationRequest;
import fr.cg95.cvq.business.school.RecreationActivityRegistrationRequest;
import fr.cg95.cvq.business.school.SchoolCanteenRegistrationRequest;
import fr.cg95.cvq.business.school.SchoolRegistrationRequest;
import fr.cg95.cvq.business.users.HomeFolderModificationRequest;
import fr.cg95.cvq.business.users.Individual;
import fr.cg95.cvq.business.users.Request;
import fr.cg95.cvq.business.users.RequestState;
import fr.cg95.cvq.business.users.RequestStep;
import fr.cg95.cvq.business.users.payment.ExternalAccountItem;
import fr.cg95.cvq.business.users.payment.ExternalDepositAccountItem;
import fr.cg95.cvq.business.users.payment.ExternalInvoiceItem;
import fr.cg95.cvq.business.users.payment.ExternalInvoiceItemDetail;
import fr.cg95.cvq.business.users.payment.ExternalTicketingContractItem;
import fr.cg95.cvq.business.users.payment.PurchaseItem;
import fr.cg95.cvq.exception.CvqConfigurationException;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.exception.CvqInvalidTransitionException;
import fr.cg95.cvq.exception.CvqModelException;
import fr.cg95.cvq.external.ExternalServiceBean;
import fr.cg95.cvq.external.IExternalProviderService;
import fr.cg95.cvq.external.IExternalService;
import fr.cg95.cvq.payment.IPaymentService;
import fr.cg95.cvq.security.SecurityContext;
import fr.cg95.cvq.service.authority.ISchoolService;
import fr.cg95.cvq.service.school.IRecreationActivityRegistrationRequestService;
import fr.cg95.cvq.service.school.IPerischoolActivityRegistrationRequestService;
import fr.cg95.cvq.service.school.ISchoolCanteenRegistrationRequestService;
import fr.cg95.cvq.service.school.ISchoolRegistrationRequestService;
import fr.cg95.cvq.service.users.IChildService;
import fr.cg95.cvq.service.users.IHomeFolderModificationRequestService;
import fr.cg95.cvq.service.users.IHomeFolderService;
import fr.cg95.cvq.util.web.struts.CvqExceptionHandler;

public class CirilNetEnfanceService implements IExternalProviderService {

    private static Logger logger = Logger.getLogger(CirilNetEnfanceService.class);
    private static final String END_POINT = "EndPoint";
    private String endPoint;
    private String label;
    
    private String hId;
    private String ExternalId;


    private IHomeFolderService homeFolderService;
    private IChildService childService;
    
    private IExternalService externalService;
    
    private ISchoolService schoolService;
    private IHomeFolderModificationRequestService homeFolderModificationRequestService;
    private ISchoolRegistrationRequestService schoolRegistrationRequestService;
    private ISchoolCanteenRegistrationRequestService schoolCanteenRegistrationRequestService;
    private IPerischoolActivityRegistrationRequestService perischoolActivityRegistrationRequestService;
    private IRecreationActivityRegistrationRequestService recreationActivityRegistrationRequestService;


    public void init(){}

    public void checkConfiguration(ExternalServiceBean externalServiceBean)
    throws CvqConfigurationException {
        setEndPoint((String) externalServiceBean.getProperty(END_POINT));
        if (endPoint==null)
            throw new CvqConfigurationException("Missing " + END_POINT
                    + " configuration parameter");
    }

    public void creditHomeFolderAccounts(Collection<PurchaseItem> purchaseItems,
            String cvqReference, String bankReference, Long homeFolderId,
            String externalHomeFolderId, String externalId, Date validationDate)
    throws CvqException {      
            }

    public Map<String, List<ExternalAccountItem>> getAccountsByHomeFolder(Long homeFolderId,
            String externalHomeFolderId, String externalId) throws CvqException {
        return null;
    }

    public Map<Date,String> getConsumptionsByRequest(Request request, Date dateFrom, Date dateTo) {
        return null;
    };
    
    public Map<Individual, Map<String, String>> getIndividualAccountsInformation(Long homeFolderId,
            String externalHomeFolderId, String externalId) throws CvqException {
        return null;
    }

    public String helloWorld() throws CvqException {
        return null;
    }

    public void loadDepositAccountDetails(ExternalDepositAccountItem edai) throws CvqException {
        try {

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void loadInvoiceDetails(ExternalInvoiceItem eii) throws CvqException {
        try {
            
        } catch (Exception e) {
            e.getMessage();
        }
    }
    
    public String sendRequest(final Request request) throws CvqException {
        logger.debug("sendRequest()" + request.getId());
        logger.debug("sendRequest() externalId :" + request.getHomeFolder().getExternalId());
        String cirilId = request.getHomeFolder().getExternalId();
        if (request instanceof SchoolRegistrationRequest) {                             // school registration request
            SchoolRegistrationRequest srr = (SchoolRegistrationRequest) request;
            Registration schoolReg = new Registration(endPoint, srr.modelToXml(), "SchoolRegistration");
            HashMap<String, Object> repDoc = schoolReg.getReturnRegistration();
            if (repDoc.containsKey("error")){
                String messageError = (String) repDoc.get("error");
                throw new CvqModelException("Retour du logiciel metier : " + messageError);
            } else {
                if(repDoc.containsKey("homeFolderMapping")) {
                    logger.debug("sendRequest() adding mapping External id : " + (String) repDoc.get("homeFolderMapping"));
                    externalService.addHomeFolderMapping(getLabel(), request.getHomeFolder().getId(), (String) repDoc.get("homeFolderMapping"));
                    if(repDoc.containsKey("indMapp")){
                                HashMap<String, String> indmapping = (HashMap<String, String>) repDoc.get("indMapp");
                                for(String individu : indmapping.keySet()){
                                    externalService.addIndividualMapping(getLabel(), 
                                            request.getHomeFolder().getId(), Long.valueOf(individu), indmapping.get(individu));
                                }
                        }
                    }
                    logger.debug("schoolRegistration() getschool : " + repDoc.get("school"));
                    School school = getSchool((String)repDoc.get("school"));
                    srr.setSchool(school);
                    schoolRegistrationRequestService.modify(srr);
            }
        }
        if (request instanceof SchoolCanteenRegistrationRequest){                       // school canteen registration request
            SchoolCanteenRegistrationRequest scrr = (SchoolCanteenRegistrationRequest)request;
            Registration schoolCanteenReg = new Registration(endPoint, scrr.modelToXml(), "SchoolCanteenRegistration");
            HashMap<String, Object> repDoc = schoolCanteenReg.getReturnRegistration();
            if (repDoc.containsKey("error")){
                String messageError = (String) repDoc.get("error");
                throw new CvqModelException("Retour du logiciel metier : " + messageError);
            } else {
                if(repDoc.containsKey("homeFolderMapping")) {
                    logger.debug("sendRequest() adding mapping External id : " + (String) repDoc.get("homeFolderMapping"));
                    externalService.addHomeFolderMapping(getLabel(), request.getHomeFolder().getId(), (String) repDoc.get("homeFolderMapping"));
                    if(repDoc.containsKey("indMapp")){
                                HashMap<String, String> indmapping = (HashMap<String, String>) repDoc.get("indMapp");
                                for(String individu : indmapping.keySet()){
                                    externalService.addIndividualMapping(getLabel(), 
                                            request.getHomeFolder().getId(), Long.valueOf(individu), indmapping.get(individu));
                                }
                    }
                }
            }
        }
        if (request instanceof PerischoolActivityRegistrationRequest) {
            PerischoolActivityRegistrationRequest parr = (PerischoolActivityRegistrationRequest)request;
            Registration periSchooReg = new Registration(endPoint, parr.modelToXml(), "PerischoolActivityRegistration");
            HashMap<String, Object> repDoc = periSchooReg.getReturnRegistration();
            if (repDoc.containsKey("error")){
                String messageError = (String) repDoc.get("error");
                throw new CvqModelException("Retour du logiciel metier : " + messageError);
            } else {
                if(repDoc.containsKey("homeFolderMapping")) {
                    logger.debug("sendRequest() adding mapping External id : " + (String) repDoc.get("homeFolderMapping"));
                    externalService.addHomeFolderMapping(getLabel(), request.getHomeFolder().getId(), (String) repDoc.get("homeFolderMapping"));
                    if(repDoc.containsKey("indMapp")){
                                HashMap<String, String> indmapping = (HashMap<String, String>) repDoc.get("indMapp");
                                for(String individu : indmapping.keySet()){
                                    externalService.addIndividualMapping(getLabel(), 
                                            request.getHomeFolder().getId(), Long.valueOf(individu), indmapping.get(individu));
                                }
                    }
                }
            }
        }
        if (request instanceof RecreationActivityRegistrationRequest) {
            RecreationActivityRegistrationRequest rarr = (RecreationActivityRegistrationRequest)request;
            Registration recreationReg = new Registration(endPoint, rarr.modelToXml(), "RecreationActivityRegistration");
            HashMap<String, Object> repDoc = recreationReg.getReturnRegistration();
            if (repDoc.containsKey("error")){
                String messageError = (String) repDoc.get("error");
                throw new CvqModelException("Retour du logiciel metier : " + messageError);
            } else {
                if(repDoc.containsKey("homeFolderMapping")) {
                    logger.debug("sendRequest() adding mapping External id : " + (String) repDoc.get("homeFolderMapping"));
                    externalService.addHomeFolderMapping(getLabel(), request.getHomeFolder().getId(), (String) repDoc.get("homeFolderMapping"));
                    if(repDoc.containsKey("indMapp")){
                                HashMap<String, String> indmapping = (HashMap<String, String>) repDoc.get("indMapp");
                                for(String individu : indmapping.keySet()){
                                    externalService.addIndividualMapping(getLabel(), 
                                            request.getHomeFolder().getId(), Long.valueOf(individu), indmapping.get(individu));
                                }
                    }
                }
            }
        }
        if (request instanceof HomeFolderModificationRequest) {
            if(cirilId != null ){
                HomeFolderModificationRequest hfmr = (HomeFolderModificationRequest)request;
                Registration homeFoldReg = new Registration(endPoint, hfmr.modelToXml(), "HomeFolderModification");
                HashMap<String, Object> repDoc = homeFoldReg.getReturnRegistration();
                if (repDoc.containsKey("error")){
                    String messageError = (String) repDoc.get("error");
                    throw new CvqModelException("Retour du logiciel metier : " + messageError);
                } else {
                    if(repDoc.containsKey("homeFolderMapping")) {
                        logger.debug("sendRequest() adding mapping External id : " + (String) repDoc.get("homeFolderMapping"));
                        externalService.addHomeFolderMapping(getLabel(), request.getHomeFolder().getId(), (String) repDoc.get("homeFolderMapping"));
                        if(repDoc.containsKey("indMapp")){
                                    HashMap<String, String> indmapping = (HashMap<String, String>) repDoc.get("indMapp");
                                    for(String individu : indmapping.keySet()){
                                        externalService.addIndividualMapping(getLabel(), 
                                                request.getHomeFolder().getId(), Long.valueOf(individu), indmapping.get(individu));
                                    }
                        }
                    }
                }
            }
        }
        return null;
    }

    private School getSchool(String schoolName) throws CvqException {
        School school = schoolService.getByName(schoolName);
        if (school == null) {
            if(schoolName.equals("")||schoolName.equals(null))
                schoolName = "ecole de demo";
            logger.info("getSchool() school " + schoolName + " not found, creating it");
            school = new School();
            school.setActive(true);
            school.setName(schoolName);
            schoolService.create(school);
        }
        return school;
    }

    public void setLabel(String label) {
        this.label = label;
    }
    public String getLabel() {
        return label;
    }

    public void setEndPoint(String endPoint) {
        this.endPoint = endPoint;
    }

    public String getEndPoint() {
        return endPoint;
    }

    public void setExternalService(IExternalService externalService) {
        this.externalService = externalService;
    }

    public void setHomeFolderService(IHomeFolderService homeFolderService) {
        this.homeFolderService = homeFolderService;
    }

    public void setChildService(IChildService childService) {
        this.childService = childService;
    }

    public void setSchoolService(ISchoolService schoolService) {
        this.schoolService = schoolService;
    }

    public void setHomeFolderModificationRequestService(
            IHomeFolderModificationRequestService homeFolderModificationRequestService) {
        this.homeFolderModificationRequestService = homeFolderModificationRequestService;
    }

    public void setRecreationActivityRegistrationRequestService(
            IRecreationActivityRegistrationRequestService recreationActivityRegistrationRequestService) {
        this.recreationActivityRegistrationRequestService = recreationActivityRegistrationRequestService;
    }

    public void setPerischoolActivityRegistrationRequestService(
            IPerischoolActivityRegistrationRequestService perischoolActivityRegistrationRequestService) {
        this.perischoolActivityRegistrationRequestService = perischoolActivityRegistrationRequestService;
    }

    public void setSchoolCanteenRegistrationRequestService(
            ISchoolCanteenRegistrationRequestService schoolCanteenRegistrationRequestService) {
        this.schoolCanteenRegistrationRequestService = schoolCanteenRegistrationRequestService;
    }

    public void setSchoolRegistrationRequestService(
            ISchoolRegistrationRequestService schoolRegistrationRequestService) {
        this.schoolRegistrationRequestService = schoolRegistrationRequestService;
    }


    public void setHId(String id) {
        hId = id;
    }
    public String getHId() {
        return hId;
    }

    public void setExternalId(String externalId) {
        ExternalId = externalId;
    }
    public String getExternalId() {
        return ExternalId;
    }
}
