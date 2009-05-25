package fr.capwebct.capdemat.plugins.externalservices.edemande.service;

import java.io.IOException;
import java.io.StringReader;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.xmlbeans.XmlObject;
import org.jaxen.JaxenException;
import org.jaxen.dom.DOMXPath;
import org.springframework.util.StringUtils;
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
import fr.cg95.cvq.business.users.Individual;
import fr.cg95.cvq.business.users.SexType;
import fr.cg95.cvq.business.users.payment.ExternalAccountItem;
import fr.cg95.cvq.business.users.payment.ExternalDepositAccountItem;
import fr.cg95.cvq.business.users.payment.ExternalInvoiceItem;
import fr.cg95.cvq.business.users.payment.PurchaseItem;
import fr.cg95.cvq.dao.external.IExternalServiceTraceDAO;
import fr.cg95.cvq.exception.CvqConfigurationException;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.external.ExternalServiceBean;
import fr.cg95.cvq.external.IExternalProviderService;
import fr.cg95.cvq.permission.CvqPermissionException;
import fr.cg95.cvq.service.document.IDocumentService;
import fr.cg95.cvq.service.request.IRequestService;
import fr.cg95.cvq.util.quering.BaseOperator;
import fr.cg95.cvq.util.quering.CriteriasDescriptor;
import fr.cg95.cvq.util.quering.criterias.SimpleCriteria;
import fr.cg95.cvq.util.quering.sort.SortCriteria;
import fr.cg95.cvq.util.quering.sort.SortDirection;
import fr.cg95.cvq.xml.request.school.StudyGrantRequestDocument;
import fr.cg95.cvq.xml.request.school.StudyGrantRequestDocument.StudyGrantRequest;

public class EdemandeService implements IExternalProviderService {

    private String label;
    private IEdemandeClient edemandeClient;
    private static final String ADDRESS_FIELDS[] = {
        "miCode", "moNature/miCode", "msVoie", "miBoitePostale", "msCodePostal", "msVille",
        "miCedex", "msPays", "msTel", "msFax", "msMail", "mbUsuel"
    };
    //private static final String PS_CODE_TIERS = "89837";
    private IExternalServiceTraceDAO externalServiceTraceDAO;
    private IRequestService requestService;
    private IDocumentService documentService;

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

    @Override
    public String sendRequest(XmlObject requestXml)
        throws CvqException {
        StudyGrantRequest sgr = ((StudyGrantRequestDocument) requestXml).getStudyGrantRequest();
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("lastName", sgr.getSubject().getIndividual().getLastName());
        model.put("bankCode", sgr.getBankCode());
        model.put("counterCode", sgr.getCounterCode());
        model.put("accountNumber", sgr.getAccountNumber());
        model.put("accountKey", sgr.getAccountKey());
        CriteriasDescriptor criteriasDescriptor = new CriteriasDescriptor();
        criteriasDescriptor.setMax(1);
        criteriasDescriptor.addSort(new SortCriteria(ExternalServiceTrace.class, "date", SortDirection.DESC));
        criteriasDescriptor.addSearch(new SimpleCriteria("key", BaseOperator.EQUALS, sgr.getId()));
        criteriasDescriptor.addSearch(new SimpleCriteria("keyOwner", BaseOperator.EQUALS, "capdemat"));
        criteriasDescriptor.addSearch(new SimpleCriteria("name", BaseOperator.EQUALS, label));
        Set<ExternalServiceTrace> traces = externalServiceTraceDAO.<ExternalServiceTrace, ExternalServiceTrace>get(criteriasDescriptor, ExternalServiceTrace.class);
        ExternalServiceTrace lastTrace = null;
        String psCodeTiers = null;
        if (!traces.isEmpty()) {
            lastTrace = traces.toArray(new ExternalServiceTrace[]{})[0];
        }
        if (lastTrace == null || lastTrace.getStatus().equals(TraceStatusEnum.IN_PROGRESS)) {
            psCodeTiers = parseData(edemandeClient.rechercherTiers(model).getRechercherTiersResponse().getReturn(), "//resultatRechTiers/listeTiers/tiers/codeTiers");
            if (psCodeTiers == null || psCodeTiers.trim().isEmpty()) {
                if (lastTrace == null) {
                    createIndividual(sgr);
                }
                return null;
            }
        }
        submitRequest(sgr, psCodeTiers);
        return null;
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
        ExternalServiceTrace est = new ExternalServiceTrace();
        est.setDate(new Date());
        est.setKeyOwner("capdemat");
        est.setKey(sgr.getId());
        est.setName(label);
        try {
            GestionCompteResponseDocument response = edemandeClient.creerTiers(model);
            if (!"0".equals(parseData(response.getGestionCompteResponse().getReturn(), "//Retour/codeRetour"))) {
                est.setStatus(TraceStatusEnum.ERROR);
                est.setMessage(parseData(response.getGestionCompteResponse().getReturn(), "//Retour/messageRetour"));
            } else {
                est.setStatus(TraceStatusEnum.IN_PROGRESS);
            }
        } catch (CvqException e) {
            e.printStackTrace();
            est.setStatus(TraceStatusEnum.NOT_SENT);
            est.setMessage(e.getMessage());
        } finally {
            try {
                externalServiceTraceDAO.create(est);
            } catch (CvqPermissionException e) {
                // should never happen
            }
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
        ExternalServiceTrace est = new ExternalServiceTrace();
        est.setDate(new Date());
        est.setKeyOwner("capdemat");
        est.setKey(sgr.getId());
        est.setName(label);
        try {
            model.put("requestTypeCode", parseData(edemandeClient.chargerTypeDemande(null).getChargerTypeDemandeResponse().getReturn(), "//typeDemande/code"));
            model.put("psCodeTiers", psCodeTiers);
            model.put("address", parseAddress((String)model.get("psCodeTiers")));
            EnregistrerValiderFormulaireResponseDocument enregistrerValiderFormulaireResponseDocument = edemandeClient.enregistrerValiderFormulaire(model);
            if (!"0".equals(parseData(enregistrerValiderFormulaireResponseDocument.getEnregistrerValiderFormulaireResponse().getReturn(), "//Retour/codeRetour"))) {
                est.setStatus(TraceStatusEnum.ERROR);
                est.setMessage(parseData(enregistrerValiderFormulaireResponseDocument.getEnregistrerValiderFormulaireResponse().getReturn(), "//Retour/messageRetour"));
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
                        est.setStatus(TraceStatusEnum.ERROR);
                        est.setMessage(parseData(response.getAjouterPiecesJointesResponse().getReturn(), "//Retour/messageRetour"));
                        errorOnDocument = true;
                        break;
                    }
                }
                if (!errorOnDocument) {
                    est.setStatus(TraceStatusEnum.SENT);
                }
            }
        } catch (CvqException e) {
            e.printStackTrace();
            est.setStatus(TraceStatusEnum.NOT_SENT);
            est.setMessage(e.getMessage());
        } finally {
            try {
                externalServiceTraceDAO.create(est);
            } catch (CvqPermissionException e) {
                // should never happen
            }
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
            throw new CvqException("plugins.externalservices.error.reading.response");
        } catch (SAXException e) {
            e.printStackTrace();
            throw new CvqException("plugins.externalservices.error.reading.response");
        } catch (IOException e) {
            e.printStackTrace();
            throw new CvqException("plugins.externalservices.error.reading.response");
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
            throw new CvqException("plugins.externalservices.error.reading.response");
        }
    }

    public void setExternalServiceTraceDAO(IExternalServiceTraceDAO externalServiceTraceDAO) {
        this.externalServiceTraceDAO = externalServiceTraceDAO;
    }

    public void setRequestService(IRequestService requestService) {
        this.requestService = requestService;
    }

    public void setDocumentService(IDocumentService documentService) {
        this.documentService = documentService;
    }
}
