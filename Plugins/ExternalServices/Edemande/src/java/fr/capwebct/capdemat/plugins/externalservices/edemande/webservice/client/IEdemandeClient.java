package fr.capwebct.capdemat.plugins.externalservices.edemande.webservice.client;

import java.util.Map;

import com.unilog.gda.edem.service.AjouterPiecesJointesResponseDocument;
import com.unilog.gda.edem.service.ChargerTypeDemandeResponseDocument;
import com.unilog.gda.edem.service.EnregistrerValiderFormulaireResponseDocument;
import com.unilog.gda.edem.service.InitialiserFormulaireResponseDocument;
import com.unilog.gda.edem.service.InitialiserSuiviDemandeResponseDocument;
import com.unilog.gda.edem.service.RechercherTiersResponseDocument;
import com.unilog.gda.glob.service.GestionCompteResponseDocument;

import fr.cg95.cvq.exception.CvqException;

public interface IEdemandeClient {

    ChargerTypeDemandeResponseDocument chargerTypeDemande(Object requestPayload)
        throws CvqException;

    InitialiserFormulaireResponseDocument initialiserFormulaire()
        throws CvqException;

    EnregistrerValiderFormulaireResponseDocument enregistrerValiderFormulaire(Map<String, Object> model)
        throws CvqException;

    InitialiserSuiviDemandeResponseDocument initialiserSuiviDemande(String psCodeTiers)
        throws CvqException;

    RechercherTiersResponseDocument rechercherTiers(Map<String, Object> model)
        throws CvqException;

    GestionCompteResponseDocument creerTiers(Map<String, Object> model)
        throws CvqException;

    AjouterPiecesJointesResponseDocument ajouterPiecesJointes(Map<String, Object> model)
        throws CvqException;
}
