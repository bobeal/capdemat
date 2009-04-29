package fr.capwebct.capdemat.plugins.externalservices.edemande.webservice.client;

import org.apache.log4j.Logger;
import org.apache.xmlbeans.XmlObject;
import org.springframework.ws.client.core.WebServiceTemplate;

import com.unilog.gda.edem.service.ChargerTypeDemandeDocument;
import com.unilog.gda.edem.service.ChargerTypeDemandeDocument.ChargerTypeDemande;

public class EdemandeClient implements IEdemandeClient {

    private static Logger logger = Logger.getLogger(EdemandeClient.class);
    
    private WebServiceTemplate edemandeConnexionService;
    private WebServiceTemplate edemandeFormulaireService;
    private WebServiceTemplate edemandeSuiviDemandeService;

    @Override
    public Object chargerTypeDemande(Object requestPayload) {
        ChargerTypeDemandeDocument chargerTypeDemandeDocument = ChargerTypeDemandeDocument.Factory.newInstance();
        ChargerTypeDemande chargerTypeDemande = chargerTypeDemandeDocument.addNewChargerTypeDemande();
        chargerTypeDemande.setPsCodeTypeDemande("Mobil_Etudes_Extranet");
//        String payload = "<ser:chargerTypeDemande><ser:psCodeTypeDemande>Mobil_Etudes_Extranet</ser:psCodeTypeDemande></ser:chargerTypeDemande>";
        logger.debug("chargerTypeDemande() got payload : " + chargerTypeDemande.xmlText());
        XmlObject result = (XmlObject) edemandeFormulaireService.marshalSendAndReceive(chargerTypeDemande);
        logger.debug("chargerTypeDemande() got result : " + result.xmlText());
        return null;
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

}
