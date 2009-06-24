package fr.capwebct.capdemat.plugins.externalservices.edemande.webservice.client;

import fr.cg95.cvq.exception.CvqException;
import groovy.text.TemplateEngine;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.StringWriter;
import java.util.Map;

import org.apache.log4j.Logger;
import org.codehaus.groovy.control.CompilationFailedException;
import org.springframework.core.io.ClassPathResource;
import org.springframework.oxm.XmlMappingException;
import org.springframework.ws.client.WebServiceClientException;
import org.springframework.ws.client.core.WebServiceTemplate;

import com.unilog.gda.edem.service.ChargerDemandeDocument;
import com.unilog.gda.edem.service.ChargerDemandeResponseDocument;
import com.unilog.gda.edem.service.ChargerTypeDemandeDocument;
import com.unilog.gda.edem.service.ChargerTypeDemandeResponseDocument;
import com.unilog.gda.edem.service.EnregistrerValiderFormulaireDocument;
import com.unilog.gda.edem.service.EnregistrerValiderFormulaireResponseDocument;
import com.unilog.gda.edem.service.ExistenceCommunePostaleDocument;
import com.unilog.gda.edem.service.ExistenceCommunePostaleResponseDocument;
import com.unilog.gda.edem.service.InitialiserFormulaireDocument;
import com.unilog.gda.edem.service.InitialiserFormulaireResponseDocument;
import com.unilog.gda.edem.service.InitialiserSuiviDemandeDocument;
import com.unilog.gda.edem.service.InitialiserSuiviDemandeResponseDocument;
import com.unilog.gda.edem.service.RechercheDemandesTiersDocument;
import com.unilog.gda.edem.service.RechercheDemandesTiersResponseDocument;
import com.unilog.gda.edem.service.RechercherTiersDocument;
import com.unilog.gda.edem.service.RechercherTiersResponseDocument;
import com.unilog.gda.edem.service.VerifierRIBDocument;
import com.unilog.gda.edem.service.VerifierRIBResponseDocument;
import com.unilog.gda.edem.service.ChargerDemandeDocument.ChargerDemande;
import com.unilog.gda.edem.service.ChargerTypeDemandeDocument.ChargerTypeDemande;
import com.unilog.gda.edem.service.EnregistrerValiderFormulaireDocument.EnregistrerValiderFormulaire;
import com.unilog.gda.edem.service.ExistenceCommunePostaleDocument.ExistenceCommunePostale;
import com.unilog.gda.edem.service.InitialiserFormulaireDocument.InitialiserFormulaire;
import com.unilog.gda.edem.service.InitialiserSuiviDemandeDocument.InitialiserSuiviDemande;
import com.unilog.gda.edem.service.RechercheDemandesTiersDocument.RechercheDemandesTiers;
import com.unilog.gda.edem.service.RechercherTiersDocument.RechercherTiers;
import com.unilog.gda.edem.service.VerifierRIBDocument.VerifierRIB;
import com.unilog.gda.glob.service.GestionCompteDocument;
import com.unilog.gda.glob.service.GestionCompteResponseDocument;
import com.unilog.gda.glob.service.GestionCompteDocument.GestionCompte;

public class EdemandeClient implements IEdemandeClient {

    private static Logger logger = Logger.getLogger(EdemandeClient.class);
    
    private WebServiceTemplate edemandeConnexionService;
    private WebServiceTemplate edemandeFormulaireService;
    private WebServiceTemplate edemandeSuiviDemandeService;
    private TemplateEngine templateEngine;
    private ClassPathResource enregistrerValiderFormulaireTemplate;
    private ClassPathResource rechercherTiersTemplate;
    private ClassPathResource creerTiersTemplate;

    public ChargerTypeDemandeResponseDocument chargerTypeDemande(Object requestPayload)
        throws CvqException {
        ChargerTypeDemandeDocument chargerTypeDemandeDocument = ChargerTypeDemandeDocument.Factory.newInstance();
        ChargerTypeDemande chargerTypeDemande = chargerTypeDemandeDocument.addNewChargerTypeDemande();
        chargerTypeDemande.setPsCodeTypeDemande("Mobil_Etudes_Extranet");
        logger.debug("chargerTypeDemande() got payload : " + chargerTypeDemande.xmlText());
        ChargerTypeDemandeResponseDocument result;
        try {
            result = (ChargerTypeDemandeResponseDocument) edemandeFormulaireService.marshalSendAndReceive(chargerTypeDemandeDocument);
        } catch (XmlMappingException e) {
            logger.error("error treating request", e);
            throw new CvqException("Erreur lors du traitement de la demande");
        } catch (WebServiceClientException e) {
            logger.error("error sending request", e);
            throw new CvqException("Erreur lors de l'envoi de la demande au service externe");
        }
        logger.debug("chargerTypeDemande() got result : " + result.xmlText());
        return result;
    }

    public InitialiserFormulaireResponseDocument initialiserFormulaire()
        throws CvqException {
        InitialiserFormulaireDocument initialiserFormulaireDocument = InitialiserFormulaireDocument.Factory.newInstance();
        InitialiserFormulaire initialiserFormulaire = initialiserFormulaireDocument.addNewInitialiserFormulaire();
        initialiserFormulaire.setPsCodeDemande("0");
        logger.debug("initialiserFormulaire() got payload : " + initialiserFormulaire.xmlText());
        InitialiserFormulaireResponseDocument result;
        try {
            result = (InitialiserFormulaireResponseDocument) edemandeFormulaireService.marshalSendAndReceive(initialiserFormulaireDocument);
        } catch (XmlMappingException e) {
            logger.error("error treating request", e);
            throw new CvqException("Erreur lors du traitement de la demande");
        } catch (WebServiceClientException e) {
            logger.error("error sending request", e);
            throw new CvqException("Erreur lors de l'envoi de la demande au service externe");
        }
        logger.debug("initialiserFormulaire() got result : " + result.xmlText());
        return result;
    }

    public EnregistrerValiderFormulaireResponseDocument enregistrerValiderFormulaire(Map<String, Object> model)
        throws CvqException {
        StringWriter request = new StringWriter();
        try {
            templateEngine.createTemplate(enregistrerValiderFormulaireTemplate.getURL()).make(model).writeTo(request);
        } catch (FileNotFoundException e) {
            logger.error("template parsing failed", e);
            throw new CvqException("Erreur lors de la construction de la demande");
        } catch (CompilationFailedException e) {
            logger.error("template parsing failed", e);
            throw new CvqException("Erreur lors de la construction de la demande");
        } catch (ClassNotFoundException e) {
            logger.error("template parsing failed", e);
            throw new CvqException("Erreur lors de la construction de la demande");
        } catch (IOException e) {
            logger.error("template parsing failed", e);
            throw new CvqException("Erreur lors de la construction de la demande");
        }
        EnregistrerValiderFormulaireDocument enregistrerValiderFormulaireDocument = EnregistrerValiderFormulaireDocument.Factory.newInstance();
        EnregistrerValiderFormulaire enregistrerValiderFormulaire = enregistrerValiderFormulaireDocument.addNewEnregistrerValiderFormulaire();
        enregistrerValiderFormulaire.setPsFormulaire(request.toString());
        logger.debug("enregistrerValiderFormulaire() got payload : " + enregistrerValiderFormulaire.xmlText());
        EnregistrerValiderFormulaireResponseDocument result;
        try {
            result = (EnregistrerValiderFormulaireResponseDocument) edemandeFormulaireService.marshalSendAndReceive(enregistrerValiderFormulaireDocument);
        } catch (XmlMappingException e) {
            logger.error("error treating request", e);
            throw new CvqException("Erreur lors du traitement de la demande");
        } catch (WebServiceClientException e) {
            logger.error("error sending request", e);
            throw new CvqException("Erreur lors de l'envoi de la demande au service externe");
        }
        logger.debug("enregistrerValiderFormulaire() got result : " + result.xmlText());
        return result;
    }

    public InitialiserSuiviDemandeResponseDocument initialiserSuiviDemande(String psCodeTiers)
        throws CvqException {
        InitialiserSuiviDemandeDocument initialiserSuiviDemandeDocument = InitialiserSuiviDemandeDocument.Factory.newInstance();
        InitialiserSuiviDemande initialiserSuiviDemande = initialiserSuiviDemandeDocument.addNewInitialiserSuiviDemande();
        initialiserSuiviDemande.setPsCodeTiers(psCodeTiers);
        logger.debug("initialiserSuiviDemande() got payload : " + initialiserSuiviDemande.xmlText());
        InitialiserSuiviDemandeResponseDocument result;
        try {
            result = (InitialiserSuiviDemandeResponseDocument) edemandeSuiviDemandeService.marshalSendAndReceive(initialiserSuiviDemandeDocument);
        } catch (XmlMappingException e) {
            logger.error("error treating request", e);
            throw new CvqException("Erreur lors du traitement de la demande");
        } catch (WebServiceClientException e) {
            logger.error("error sending request", e);
            throw new CvqException("Erreur lors de l'envoi de la demande au service externe");
        }
        logger.debug("initialiserSuiviDemande() got result : " + result.xmlText());
        return result;
    }

    public RechercherTiersResponseDocument rechercherTiers(Map<String, Object> model)
        throws CvqException {
        StringWriter request = new StringWriter();
        try {
            templateEngine.createTemplate(rechercherTiersTemplate.getURL()).make(model).writeTo(request);
        } catch (FileNotFoundException e) {
            logger.error("template parsing failed", e);
            throw new CvqException("Erreur lors de la construction de la demande");
        } catch (CompilationFailedException e) {
            logger.error("template parsing failed", e);
            throw new CvqException("Erreur lors de la construction de la demande");
        } catch (ClassNotFoundException e) {
            logger.error("template parsing failed", e);
            throw new CvqException("Erreur lors de la construction de la demande");
        } catch (IOException e) {
            logger.error("template parsing failed", e);
            throw new CvqException("Erreur lors de la construction de la demande");
        }
        RechercherTiersDocument rechercherTiersDocument = RechercherTiersDocument.Factory.newInstance();
        RechercherTiers rechercherTiers = rechercherTiersDocument.addNewRechercherTiers();
        rechercherTiers.setPsCriteres(request.toString());
        logger.debug("rechercherTiers() got payload : " + rechercherTiers.xmlText());
        RechercherTiersResponseDocument result;
        try {
            result = (RechercherTiersResponseDocument) edemandeSuiviDemandeService.marshalSendAndReceive(rechercherTiersDocument);
        } catch (XmlMappingException e) {
            logger.error("error treating request", e);
            throw new CvqException("Erreur lors du traitement de la demande");
        } catch (WebServiceClientException e) {
            logger.error("error sending request", e);
            throw new CvqException("Erreur lors de l'envoi de la demande au service externe");
        }
        logger.debug("rechercherTiers() got result : " + result.xmlText());
        return result;
    }

    public GestionCompteResponseDocument creerTiers(Map<String, Object> model)
        throws CvqException {
        StringWriter request = new StringWriter();
        try {
            templateEngine.createTemplate(creerTiersTemplate.getURL()).make(model).writeTo(request);
        } catch (FileNotFoundException e) {
            logger.error("template parsing failed", e);
            throw new CvqException("Erreur lors de la construction de la demande");
        } catch (CompilationFailedException e) {
            logger.error("template parsing failed", e);
            throw new CvqException("Erreur lors de la construction de la demande");
        } catch (ClassNotFoundException e) {
            logger.error("template parsing failed", e);
            throw new CvqException("Erreur lors de la construction de la demande");
        } catch (IOException e) {
            logger.error("template parsing failed", e);
            throw new CvqException("Erreur lors de la construction de la demande");
        }
        GestionCompteDocument gestionCompteDocument = GestionCompteDocument.Factory.newInstance();
        GestionCompte gestionCompte = gestionCompteDocument.addNewGestionCompte();
        gestionCompte.setPsCompte(request.toString());
        logger.debug("creerTiers() got payload : " + gestionCompte.xmlText());
        GestionCompteResponseDocument result;
        try {
            result = (GestionCompteResponseDocument)edemandeConnexionService.marshalSendAndReceive(gestionCompteDocument);
        } catch (XmlMappingException e) {
            logger.error("error treating request", e);
            throw new CvqException("Erreur lors du traitement de la demande");
        } catch (WebServiceClientException e) {
            logger.error("error sending request", e);
            throw new CvqException("Erreur lors de l'envoi de la demande au service externe");
        }
        logger.debug("creerTiers() got result : " + result.xmlText());
        return result;
    }

    public RechercheDemandesTiersResponseDocument rechercheDemandesTiers(String psCodeTiers)
        throws CvqException {
        RechercheDemandesTiersDocument rechercheDemandesTiersDocument = RechercheDemandesTiersDocument.Factory.newInstance();
        RechercheDemandesTiers rechercheDemandesTiers = rechercheDemandesTiersDocument.addNewRechercheDemandesTiers();
        rechercheDemandesTiers.setPsCodeTiers(psCodeTiers);
        rechercheDemandesTiers.setPsCriteres("<rechDemandes><typeRecherche>demandeur</typeRecherche></rechDemandes>");
        logger.debug("rechercheDemandesTiers() got payload : " + rechercheDemandesTiers.xmlText());
        RechercheDemandesTiersResponseDocument result;
        try {
            result = (RechercheDemandesTiersResponseDocument)edemandeSuiviDemandeService.marshalSendAndReceive(rechercheDemandesTiersDocument);
        } catch (XmlMappingException e) {
            logger.error("error treating request", e);
            throw new CvqException("Erreur lors du traitement de la demande");
        } catch (WebServiceClientException e) {
            logger.error("error sending request", e);
            throw new CvqException("Erreur lors de l'envoi de la demande au service externe");
        }
        logger.debug("rechercheDemandesTiers() got result : " + result.xmlText());
        return result;
    }

    public ChargerDemandeResponseDocument chargerDemande(String psCodeTiers, String psCodeDemande)
        throws CvqException {
        ChargerDemandeDocument chargerDemandeDocument = ChargerDemandeDocument.Factory.newInstance();
        ChargerDemande chargerDemande = chargerDemandeDocument.addNewChargerDemande();
        chargerDemande.setPsCodeDemande(psCodeDemande);
        chargerDemande.setPsCodeTiers(psCodeTiers);
        chargerDemande.setPsIndicDemande("propre");
        logger.debug("chargerDemande() got payload : " + chargerDemande.xmlText());
        ChargerDemandeResponseDocument result;
        try {
            result = (ChargerDemandeResponseDocument)edemandeSuiviDemandeService.marshalSendAndReceive(chargerDemande);
        } catch (XmlMappingException e) {
            logger.error("error treating request", e);
            throw new CvqException("Erreur lors du traitement de la demande");
        } catch (WebServiceClientException e) {
            logger.error("error sending request", e);
            throw new CvqException("Erreur lors de l'envoi de la demande au service externe");
        }
        logger.debug("chargerDemande() got result : " + result.xmlText());
        return result;
    }

    public ExistenceCommunePostaleResponseDocument existenceCommunePostale(String postalCode, String city)
        throws CvqException {
        ExistenceCommunePostaleDocument existenceCommunePostaleDocument = ExistenceCommunePostaleDocument.Factory.newInstance();
        ExistenceCommunePostale existenceCommunePostale = existenceCommunePostaleDocument.addNewExistenceCommunePostale();
        existenceCommunePostale.setPsCodePostal(postalCode);
        existenceCommunePostale.setPsCommune(city);
        logger.debug("existenceCommunePostale() got payload : " + existenceCommunePostale.xmlText());
        ExistenceCommunePostaleResponseDocument result;
        try {
            result = (ExistenceCommunePostaleResponseDocument)edemandeFormulaireService.marshalSendAndReceive(existenceCommunePostaleDocument);
        } catch (XmlMappingException e) {
            logger.error("error treating request", e);
            throw new CvqException("Erreur lors du traitement de la demande");
        } catch (WebServiceClientException e) {
            logger.error("error sending request", e);
            throw new CvqException("Erreur lors de l'envoi de la demande au service externe");
        }
        logger.debug("existenceCommunePostale() got result : " + result.xmlText());
        return result;
    }

    public VerifierRIBResponseDocument verifierRIB(String bankCode, String counterCode, String accountNumber, String accountKey)
        throws CvqException {
        VerifierRIBDocument verifierRIBDocument = VerifierRIBDocument.Factory.newInstance();
        VerifierRIB verifierRIB = verifierRIBDocument.addNewVerifierRIB();
        verifierRIB.setPsBanque(bankCode);
        verifierRIB.setPsAgence(counterCode);
        verifierRIB.setPsCompte(accountNumber);
        verifierRIB.setPsCle(accountKey);
        logger.debug("verifierRIB() got payload : " + verifierRIB.xmlText());
        VerifierRIBResponseDocument result;
        try {
            result = (VerifierRIBResponseDocument)edemandeFormulaireService.marshalSendAndReceive(verifierRIBDocument);
        } catch (XmlMappingException e) {
            logger.error("error treating request", e);
            throw new CvqException("Erreur lors du traitement de la demande");
        } catch (WebServiceClientException e) {
            logger.error("error sending request", e);
            throw new CvqException("Erreur lors de l'envoi de la demande au service externe");
        }
        logger.debug("verifierRIB() got result : " + result.xmlText());
        return result;
    }

    public void setEdemandeConnexionService(WebServiceTemplate edemandeConnexionService) {
        this.edemandeConnexionService = edemandeConnexionService;
    }

    public void setEdemandeFormulaireService(WebServiceTemplate edemandeFormulaireService) {
        this.edemandeFormulaireService = edemandeFormulaireService;
    }

    public void setEdemandeSuiviDemandeService(WebServiceTemplate edemandeSuiviDemandeService) {
        this.edemandeSuiviDemandeService = edemandeSuiviDemandeService;
    }

    public void setTemplateEngine(TemplateEngine templateEngine) {
        this.templateEngine = templateEngine;
    }

    public void setEnregistrerValiderFormulaireTemplate(
            ClassPathResource enregistrerValiderFormulaireTemplate) {
        this.enregistrerValiderFormulaireTemplate = enregistrerValiderFormulaireTemplate;
    }

    public void setRechercherTiersTemplate(ClassPathResource rechercherTiersTemplate) {
        this.rechercherTiersTemplate = rechercherTiersTemplate;
    }

    public void setCreerTiersTemplate(ClassPathResource creerTiersTemplate) {
        this.creerTiersTemplate = creerTiersTemplate;
    }

}
