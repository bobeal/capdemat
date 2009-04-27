package fr.capwebct.capdemat.plugins.externalservices.edemande.webservice.client;

import org.springframework.ws.client.core.WebServiceTemplate;

public class EDemandeClient implements IEdemandeClient {

    private WebServiceTemplate edemandeConnexionService;
    private WebServiceTemplate edemandeFormulaireService;
    private WebServiceTemplate edemandeSuiviDemandeService;

    @Override
    public Object chargerTypeDemande(Object requestPayload) {
        return edemandeFormulaireService.marshalSendAndReceive(requestPayload);
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
