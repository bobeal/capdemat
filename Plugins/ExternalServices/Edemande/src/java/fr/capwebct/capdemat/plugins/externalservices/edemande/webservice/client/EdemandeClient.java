package fr.capwebct.capdemat.plugins.externalservices.edemande.webservice.client;

import fr.capwebct.capdemat.plugins.externalservices.edemande.adapters.EdemandeRequest.Config;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.xml.common.FrenchRIBType;
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
import com.unilog.gda.edem.service.ChargerDemandeDocument.ChargerDemande;
import com.unilog.gda.edem.service.ChargerDemandeResponseDocument;
import com.unilog.gda.edem.service.ChargerTypeDemandeDocument;
import com.unilog.gda.edem.service.ChargerTypeDemandeDocument.ChargerTypeDemande;
import com.unilog.gda.edem.service.ChargerTypeDemandeResponseDocument;
import com.unilog.gda.edem.service.EnregistrerValiderFormulaireDocument;
import com.unilog.gda.edem.service.EnregistrerValiderFormulaireDocument.EnregistrerValiderFormulaire;
import com.unilog.gda.edem.service.EnregistrerValiderFormulaireResponseDocument;
import com.unilog.gda.edem.service.ExistenceCommunePostaleDocument;
import com.unilog.gda.edem.service.ExistenceCommunePostaleDocument.ExistenceCommunePostale;
import com.unilog.gda.edem.service.ExistenceCommunePostaleResponseDocument;
import com.unilog.gda.edem.service.InitialiserFormulaireDocument;
import com.unilog.gda.edem.service.InitialiserFormulaireDocument.InitialiserFormulaire;
import com.unilog.gda.edem.service.InitialiserFormulaireResponseDocument;
import com.unilog.gda.edem.service.InitialiserSuiviDemandeDocument;
import com.unilog.gda.edem.service.InitialiserSuiviDemandeDocument.InitialiserSuiviDemande;
import com.unilog.gda.edem.service.InitialiserSuiviDemandeResponseDocument;
import com.unilog.gda.edem.service.RechercheDemandesTiersDocument;
import com.unilog.gda.edem.service.RechercheDemandesTiersDocument.RechercheDemandesTiers;
import com.unilog.gda.edem.service.RechercheDemandesTiersResponseDocument;
import com.unilog.gda.edem.service.RechercherTiersDocument;
import com.unilog.gda.edem.service.RechercherTiersDocument.RechercherTiers;
import com.unilog.gda.edem.service.RechercherTiersResponseDocument;
import com.unilog.gda.edem.service.VerifierRIBDocument;
import com.unilog.gda.edem.service.VerifierRIBDocument.VerifierRIB;
import com.unilog.gda.edem.service.VerifierRIBResponseDocument;
import com.unilog.gda.glob.service.GestionCompteDocument;
import com.unilog.gda.glob.service.GestionCompteDocument.GestionCompte;
import com.unilog.gda.glob.service.GestionCompteResponseDocument;

public class EdemandeClient implements IEdemandeClient {

    private static Logger logger = Logger.getLogger(EdemandeClient.class);
    
    private WebServiceTemplate edemandeConnexionService;
    private WebServiceTemplate edemandeFormulaireService;
    private WebServiceTemplate edemandeSuiviDemandeService;
    private TemplateEngine templateEngine;
    private ClassPathResource templateDirectory;

    @Override
    public ChargerTypeDemandeResponseDocument chargerTypeDemande(String psCodeTypeDemande)
        throws CvqException {
        ChargerTypeDemandeDocument chargerTypeDemandeDocument = ChargerTypeDemandeDocument.Factory.newInstance();
        ChargerTypeDemande chargerTypeDemande = chargerTypeDemandeDocument.addNewChargerTypeDemande();
        chargerTypeDemande.setPsCodeTypeDemande(psCodeTypeDemande);
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

    @Override
    public InitialiserFormulaireResponseDocument initialiserFormulaire(String psCodeTypeDemande, String psCodeTiers)
        throws CvqException {
        InitialiserFormulaireDocument initialiserFormulaireDocument = InitialiserFormulaireDocument.Factory.newInstance();
        InitialiserFormulaire initialiserFormulaire = initialiserFormulaireDocument.addNewInitialiserFormulaire();
        initialiserFormulaire.setPsCodeTiers(psCodeTiers);
        initialiserFormulaire.setPsCodeTypeDemande(psCodeTypeDemande);
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

    @Override
    public EnregistrerValiderFormulaireResponseDocument enregistrerValiderFormulaire(Map<String, Object> model)
        throws CvqException {
        StringWriter form = new StringWriter();
        try {
            templateEngine.createTemplate(templateDirectory.createRelative("Formulaire_" + ((Config)model.get("config")).name() + ".groovy").getURL()).make(model).writeTo(form);
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
        model.put("form", form.toString());
        StringWriter request = new StringWriter();
        try {
            templateEngine.createTemplate(templateDirectory.createRelative("enregistrerValiderFormulaire.groovy").getURL()).make(model).writeTo(request);
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

    @Override
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

    @Override
    public RechercherTiersResponseDocument rechercherTiers(Map<String, Object> model)
        throws CvqException {
        StringWriter request = new StringWriter();
        try {
            templateEngine.createTemplate(templateDirectory.createRelative("rechercherTiers.groovy").getURL()).make(model).writeTo(request);
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

    @Override
    public GestionCompteResponseDocument creerTiers(Map<String, Object> model)
        throws CvqException {
        StringWriter request = new StringWriter();
        try {
            templateEngine.createTemplate(templateDirectory.createRelative("creerTiers.groovy").getURL()).make(model).writeTo(request);
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

    @Override
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

    @Override
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

    @Override
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

    @Override
    public VerifierRIBResponseDocument verifierRIB(FrenchRIBType frenchRIB)
        throws CvqException {
        VerifierRIBDocument verifierRIBDocument = VerifierRIBDocument.Factory.newInstance();
        VerifierRIB verifierRIB = verifierRIBDocument.addNewVerifierRIB();
        verifierRIB.setPsBanque(new Integer(frenchRIB.getBankCode()).toString());
        verifierRIB.setPsAgence(new Integer(frenchRIB.getCounterCode()).toString());
        verifierRIB.setPsCompte(frenchRIB.getAccountNumber());
        verifierRIB.setPsCle(new Integer(frenchRIB.getAccountKey()).toString());
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

    public void setTemplateDirectory(ClassPathResource templateDirectory) {
        this.templateDirectory = templateDirectory;
    }
}
