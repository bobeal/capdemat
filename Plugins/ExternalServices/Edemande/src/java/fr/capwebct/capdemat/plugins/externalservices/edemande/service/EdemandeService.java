package fr.capwebct.capdemat.plugins.externalservices.edemande.service;

import java.io.IOException;
import java.io.StringReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.xmlbeans.XmlObject;
import org.jaxen.JaxenException;
import org.jaxen.dom.DOMXPath;
import org.springframework.util.StringUtils;
import org.springframework.web.util.HtmlUtils;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import com.unilog.gda.edem.service.AjouterPiecesJointesResponseDocument;
import com.unilog.gda.edem.service.EnregistrerValiderFormulaireResponseDocument;
import com.unilog.gda.glob.service.GestionCompteResponseDocument;

import fr.capwebct.capdemat.plugins.externalservices.edemande.webservice.client.IEdemandeClient;
import fr.cg95.cvq.business.document.Document;
import fr.cg95.cvq.business.external.ExternalServiceTrace;
import fr.cg95.cvq.business.external.TraceStatusEnum;
import fr.cg95.cvq.business.request.Request;
import fr.cg95.cvq.business.request.RequestDocument;
import fr.cg95.cvq.business.request.RequestState;
import fr.cg95.cvq.business.users.Individual;
import fr.cg95.cvq.business.users.SexType;
import fr.cg95.cvq.business.users.payment.ExternalAccountItem;
import fr.cg95.cvq.business.users.payment.ExternalDepositAccountItem;
import fr.cg95.cvq.business.users.payment.ExternalInvoiceItem;
import fr.cg95.cvq.business.users.payment.PurchaseItem;
import fr.cg95.cvq.exception.CvqConfigurationException;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.exception.CvqInvalidTransitionException;
import fr.cg95.cvq.exception.CvqObjectNotFoundException;
import fr.cg95.cvq.external.ExternalServiceBean;
import fr.cg95.cvq.external.IExternalProviderService;
import fr.cg95.cvq.external.IExternalService;
import fr.cg95.cvq.permission.CvqPermissionException;
import fr.cg95.cvq.service.document.IDocumentService;
import fr.cg95.cvq.service.request.IRequestService;
import fr.cg95.cvq.service.request.IRequestWorkflowService;
import fr.cg95.cvq.xml.request.school.StudyGrantRequestDocument;
import fr.cg95.cvq.xml.request.school.StudyGrantRequestDocument.StudyGrantRequest;

public class EdemandeService implements IExternalProviderService {

    private String label;
    private IEdemandeClient edemandeClient;
    private IExternalService externalService;
    private IRequestService requestService;
    private IDocumentService documentService;
    private IRequestWorkflowService requestWorkflowService;

    private static final String ADDRESS_FIELDS[] = {
        "miCode", "moNature/miCode", "msVoie", "miBoitePostale", "msCodePostal", "msVille",
        "miCedex", "msPays", "msTel", "msFax", "msMail", "mbUsuel"
    };
    //private static final String PS_CODE_TIERS = "89837";

    @Override
    public String sendRequest(XmlObject requestXml) {
        StudyGrantRequest sgr = ((StudyGrantRequestDocument) requestXml).getStudyGrantRequest();
        ExternalServiceTrace lastTrace = externalService.getLastTrace(sgr.getId(), label);
        String psCodeTiers = sgr.getSubject().getIndividual().getExternalId();
        if (psCodeTiers == null || psCodeTiers.trim().isEmpty()) {
            // external id (code tiers) not known locally : 
            //     either check if tiers has been created in eDemande
            //     either ask for its creation in eDemande
            psCodeTiers = searchIndividual(sgr);
            if (psCodeTiers == null || psCodeTiers.trim().isEmpty()) {
                // tiers has not been created in eDemande ...
                if (!externalService.hasTraceWithStatus(sgr.getId(), label, 
                        TraceStatusEnum.IN_PROGRESS)) {
                    // ... and no request in progress so ask for its creation
                    createIndividual(sgr);
                } else if (psCodeTiers != null) {
                    // FIXME BOR : i don't get this one ...
                    addTrace(sgr.getId(), TraceStatusEnum.IN_PROGRESS, 
                            "Le tiers n'est pas encore créé");
                }
                return null;
            } else {
                // tiers has been created in eDemande, store its code locally
                sgr.getSubject().getIndividual().setExternalId(psCodeTiers);
                externalService.setExternalId(label, sgr.getHomeFolder().getId(), 
                        sgr.getSubject().getIndividual().getId(), psCodeTiers);
            }
        }
        if (lastTrace == null || !lastTrace.getStatus().equals(TraceStatusEnum.SENT)) {
            submitRequest(sgr, psCodeTiers);
            return null;
        } else {
            return checkRequest(sgr, psCodeTiers);
        }
    }

    private void addTrace(Long requestId, TraceStatusEnum status, String message) {
        ExternalServiceTrace est = new ExternalServiceTrace();
        est.setDate(new Date());
        est.setKey(requestId);
        est.setKeyOwner("capdemat");
        est.setMessage(message);
        est.setName(label);
        est.setStatus(status);
        try {
            externalService.create(est);
        } catch (CvqPermissionException e) {
            // should never happen
            e.printStackTrace();
        }
        if (TraceStatusEnum.ERROR.equals(status)) {
            try {
                requestWorkflowService.updateRequestState(requestId, RequestState.UNCOMPLETE, message);
            } catch (CvqObjectNotFoundException e) {
                // TODO
            } catch (CvqInvalidTransitionException e) {
                // TODO
            } catch (CvqException e) {
                // TODO
            }
        }
    }

    /**
     * Search for this request's subject in eDemande.
     * 
     * @return the subject's code in eDemande or null if not found
     */
    private String searchIndividual(StudyGrantRequest sgr) {
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("lastName", sgr.getSubject().getIndividual().getLastName());
        model.put("bankCode", sgr.getBankCode());
        model.put("counterCode", sgr.getCounterCode());
        model.put("accountNumber", sgr.getAccountNumber());
        model.put("accountKey", sgr.getAccountKey());
        try {
            return parseData(edemandeClient.rechercherTiers(model).getRechercherTiersResponse().getReturn(), 
                    "//resultatRechTiers/listeTiers/tiers/codeTiers");
        } catch (CvqException e) {
            addTrace(sgr.getId(), TraceStatusEnum.NOT_SENT, e.getMessage());
            return null;
        }
    }

    private void createIndividual(StudyGrantRequest sgr) {
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("lastName", sgr.getSubject().getIndividual().getLastName());
        model.put("address", sgr.getSubjectInformations().getSubjectAddress());
        if (sgr.getSubjectInformations().getSubjectPhone() != null && !sgr.getSubjectInformations().getSubjectPhone().trim().isEmpty()) {
            model.put("phone", sgr.getSubjectInformations().getSubjectPhone());
        } else if (sgr.getSubjectInformations().getSubjectMobilePhone() != null && !sgr.getSubjectInformations().getSubjectMobilePhone().trim().isEmpty()) {
            model.put("phone", sgr.getSubjectInformations().getSubjectMobilePhone());
        }
        model.put("email", sgr.getSubjectInformations().getSubjectEmail());
        if (sgr.getSubject().getAdult() != null) {
            model.put("title", sgr.getSubject().getAdult().getTitle());
        } else {
            if (SexType.MALE.toString().equals(sgr.getSubject().getIndividual().getSex().toString())) {
                model.put("title", "Monsieur");
            } else if (SexType.FEMALE.toString().equals(sgr.getSubject().getIndividual().getSex().toString())) {
                model.put("title", "Mademoiselle");
            } else {
                model.put("title", "Inconnu");
            }
        }
        model.put("firstName", sgr.getSubject().getIndividual().getFirstName());
        model.put("birthPlace", sgr.getSubject().getIndividual().getBirthPlace().getCity());
        model.put("birthDate", sgr.getSubject().getIndividual().getBirthDate());
        model.put("bankCode", sgr.getBankCode());
        model.put("counterCode", sgr.getCounterCode());
        model.put("accountNumber", sgr.getAccountNumber());
        model.put("accountKey", sgr.getAccountKey());
        try {
            GestionCompteResponseDocument response = edemandeClient.creerTiers(model);
            if (!"0".equals(parseData(response.getGestionCompteResponse().getReturn(), "//Retour/codeRetour"))) {
                addTrace(sgr.getId(), TraceStatusEnum.ERROR, parseData(response.getGestionCompteResponse().getReturn(), "//Retour/messageRetour"));
            } else {
                addTrace(sgr.getId(), TraceStatusEnum.IN_PROGRESS, "Demande de création du tiers");
            }
        } catch (CvqException e) {
            e.printStackTrace();
            addTrace(sgr.getId(), TraceStatusEnum.NOT_SENT, e.getMessage());
        }
    }

    private void submitRequest(StudyGrantRequest sgr, String psCodeTiers) {
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("date", new SimpleDateFormat("yyyyMMdd").format(new Date(sgr.getCreationDate().getTimeInMillis())));
        model.put("firstName", sgr.getSubject().getIndividual().getFirstName());
        model.put("lastName", sgr.getSubject().getIndividual().getLastName());
        model.put("postalCode", sgr.getSubject().getIndividual().getAddress().getPostalCode());
        model.put("city", sgr.getSubject().getIndividual().getAddress().getCity());
        model.put("id", sgr.getId());
        model.put("bankCode", sgr.getBankCode());
        model.put("counterCode", sgr.getCounterCode());
        model.put("accountNumber", sgr.getAccountNumber());
        model.put("accountKey", sgr.getAccountKey());
        try {
            model.put("requestTypeCode", parseData(edemandeClient.chargerTypeDemande(null).getChargerTypeDemandeResponse().getReturn(), "//typeDemande/code"));
            model.put("psCodeTiers", psCodeTiers);
            model.put("address", parseAddress((String)model.get("psCodeTiers")));
            EnregistrerValiderFormulaireResponseDocument enregistrerValiderFormulaireResponseDocument = edemandeClient.enregistrerValiderFormulaire(model);
            if (!"0".equals(parseData(enregistrerValiderFormulaireResponseDocument.getEnregistrerValiderFormulaireResponse().getReturn(), "//Retour/codeRetour"))) {
                addTrace(sgr.getId(), TraceStatusEnum.ERROR, parseData(enregistrerValiderFormulaireResponseDocument.getEnregistrerValiderFormulaireResponse().getReturn(), "//Retour/messageRetour"));
            } else {
                boolean errorOnDocument = false;
                for (RequestDocument requestDoc : requestService.getAssociatedDocuments(sgr.getId())) {
                    Document doc = documentService.getById(requestDoc.getDocumentId());
                    // put the file on the remote ftp server
                    ;
                    // send it to edemande
                    model.put("filename", StringUtils.arrayToDelimitedString(new String[]{"CapDemat", doc.getDocumentType().getName(), String.valueOf(sgr.getId())}, "-"));
                    //model.put("remotePath", );
                    model.put("description", doc.getDocumentType().getName());
                    //model.put("binaryData", new String(Base64.encodeBase64Chunked(doc.getDatas().get(0).getData())));
                    AjouterPiecesJointesResponseDocument response = edemandeClient.ajouterPiecesJointes(model);
                    if (!"0".equals(parseData(response.getAjouterPiecesJointesResponse().getReturn(), "//Retour/codeRetour"))) {
                        addTrace(sgr.getId(), TraceStatusEnum.ERROR, parseData(response.getAjouterPiecesJointesResponse().getReturn(), "//Retour/messageRetour"));
                        errorOnDocument = true;
                        break;
                    }
                }
                if (!errorOnDocument) {
                    addTrace(sgr.getId(), TraceStatusEnum.SENT, "Demande transmise");
                }
            }
        } catch (CvqException e) {
            e.printStackTrace();
            addTrace(sgr.getId(), TraceStatusEnum.NOT_SENT, e.getMessage());
        }
    }

    private String checkRequest(StudyGrantRequest sgr, String psCodeTiers) {
        //TODO
        try {
            String requestCode = parseRequestCode(sgr, psCodeTiers);
            String toto = edemandeClient.chargerDemande(psCodeTiers, requestCode).getChargerDemandeResponse().getReturn();
            return toto;
        } catch (CvqException e) {
        return null;}
    }

    public List<String> checkExternalReferential(final XmlObject requestXml) {
        StudyGrantRequest sgr = ((StudyGrantRequestDocument) requestXml).getStudyGrantRequest();
        List<String> result = new ArrayList<String>();
        try {
            String postalCodeAndCityCheck = edemandeClient.existenceCommunePostale(sgr.getSubjectInformations().getSubjectAddress().getPostalCode(), sgr.getSubjectInformations().getSubjectAddress().getCity()).getExistenceCommunePostaleResponse().getReturn();
            if (!"0".equals(parseData(postalCodeAndCityCheck, "//FluxWebService/msCodeRet"))) {
                result.add(parseData(postalCodeAndCityCheck, "//FluxWebService/erreur/message"));
            }
            String bankInformationsCheck = edemandeClient.verifierRIB(sgr.getBankCode(), sgr.getCounterCode(), sgr.getAccountNumber(), sgr.getAccountKey()).getVerifierRIBResponse().getReturn();
            if (!"0".equals(parseData(bankInformationsCheck, "//FluxWebService/msCodeRet"))) {
                result.add(parseData(bankInformationsCheck, "//FluxWebService/erreur/message"));
            }
        } catch (CvqException e) {
            result.add("Error contacting Edemande");
        }
        return result;
    }

    private String parseRequestCode(StudyGrantRequest sgr, String psCodeTiers) {
        String requestId =
            StringUtils.arrayToDelimitedString(
                new String[] {
                    "CapDemat",
                    new SimpleDateFormat("yyyyMMdd").format(new Date(sgr.getCreationDate().getTimeInMillis())),
                    sgr.getSubject().getIndividual().getFirstName(),
                    sgr.getSubject().getIndividual().getLastName(),
                    String.valueOf(sgr.getId())
                },
            "-");
        try {
            return parseData(edemandeClient.rechercheDemandesTiers(psCodeTiers).getRechercheDemandesTiersResponse().getReturn(),
                    "//resultatRechDemandes/listeDemandes/Demande/moOrigineApsect[msIdentifiant ='" + HtmlUtils.htmlEscape(requestId) + "']/../miCode");
        } catch (CvqException e) {
            return null;
        }
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public void setEdemandeClient(IEdemandeClient edemandeClient) {
        this.edemandeClient = edemandeClient;
    }

    public boolean supportsConsumptions() {
        return false;
    }

    public boolean handlesTraces() {
        return true;
    }

    private Map<String, String> parseAddress(String psCodeTiers)
        throws CvqException {
        String tiers = edemandeClient.initialiserSuiviDemande(psCodeTiers).getInitialiserSuiviDemandeResponse().getReturn();
        Map<String, String> address = new HashMap<String, String>();
        for (String addressField : ADDRESS_FIELDS) {
            address.put(addressField, parseData(tiers, "//donneesTiers/tiers/mvAdresses/CTierAdresseVO/" + addressField));
        }
        return address;
    }

    private String parseData(String returnElement, String path)
        throws CvqException {
        try {
            return new DOMXPath(path)
                .stringValueOf(
                    DocumentBuilderFactory.newInstance().newDocumentBuilder()
                        .parse(new InputSource(new StringReader(returnElement)))
                        .getDocumentElement());
        } catch (JaxenException e) {
            e.printStackTrace();
            throw new CvqException("Erreur lors de la lecture de la réponse du service externe");
        } catch (SAXException e) {
            e.printStackTrace();
            throw new CvqException("Erreur lors de la lecture de la réponse du service externe");
        } catch (IOException e) {
            e.printStackTrace();
            throw new CvqException("Erreur lors de la lecture de la réponse du service externe");
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
            throw new CvqException("Erreur lors de la lecture de la réponse du service externe");
        }
    }

    @Override
    public void checkConfiguration(ExternalServiceBean externalServiceBean)
        throws CvqConfigurationException {
    }

    @Override
    public void creditHomeFolderAccounts(Collection<PurchaseItem> purchaseItems,
            String cvqReference, String bankReference, Long homeFolderId,
            String externalHomeFolderId, String externalId, Date validationDate)
            throws CvqException {
    }

    @Override
    public Map<String, List<ExternalAccountItem>> getAccountsByHomeFolder(Long homeFolderId,
            String externalHomeFolderId, String externalId) throws CvqException {
        return null;
    }

    @Override
    public Map<Date, String> getConsumptionsByRequest(Request request, Date dateFrom, Date dateTo)
            throws CvqException {
        return null;
    }

    @Override
    public Map<Individual, Map<String, String>> getIndividualAccountsInformation(Long homeFolderId,
            String externalHomeFolderId, String externalId) throws CvqException {
        return null;
    }

    @Override
    public String getLabel() {
        return label;
    }

    @Override
    public String helloWorld() throws CvqException {
        return null;
    }

    @Override
    public void loadDepositAccountDetails(ExternalDepositAccountItem edai) throws CvqException {
    }

    @Override
    public void loadInvoiceDetails(ExternalInvoiceItem eii) throws CvqException {
    }

    public void setRequestService(IRequestService requestService) {
        this.requestService = requestService;
    }

    public void setDocumentService(IDocumentService documentService) {
        this.documentService = documentService;
    }

    public void setExternalService(IExternalService externalService) {
        this.externalService = externalService;
    }

    public void setRequestWorkflowService(IRequestWorkflowService requestWorkflowService) {
        this.requestWorkflowService = requestWorkflowService;
    }
}
