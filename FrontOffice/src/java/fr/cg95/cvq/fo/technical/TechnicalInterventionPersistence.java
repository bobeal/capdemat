package fr.cg95.cvq.fo.technical;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;

import fr.cg95.cvq.fo.business.BusinessManager;
import fr.cg95.cvq.fo.common.FamilyHome;
import fr.cg95.cvq.fo.common.IPersistence;
import fr.cg95.cvq.fo.common.Request;
import fr.cg95.cvq.fo.common.form.IndividualForm;
import fr.cg95.cvq.fo.dispatcher.SessionManager;
import fr.cg95.cvq.service.technical.ITechnicalInterventionRequestService;
import fr.cg95.cvq.wizard.process.ProcessWizardState;
import fr.cg95.cvq.xml.common.RequestType;
import fr.cg95.cvq.xml.technical.TechnicalInterventionRequestDocument;
import fr.cg95.cvq.xml.technical.TechnicalInterventionRequestDocument.TechnicalInterventionRequest;

public class TechnicalInterventionPersistence extends IPersistence {

    public String getServiceName(String definitionName) {
        return ITechnicalInterventionRequestService.SERVICE_NAME;
    }

    public RequestType createRequest(HttpServletRequest request, Request cvqRequest) {
        FamilyHome familyHome = SessionManager.getFamilyHome(request);
        if (!cvqRequest.isInitialised()) {
            Collection interventionType = BusinessManager.getReferentialList("InterventionType");

            request.getSession().setAttribute("InterventionType", interventionType);

            setAuthorizedSubjects(familyHome);
        }
        if (request.getParameter(ProcessWizardState.INDEX_REQUEST_PARAMETER) == null) {
            request.setAttribute(ProcessWizardState.NAME_REQUEST_PARAMETER, "eTechnicalIntervention");

        } else {
            TechnicalInterventionRequest tir = TechnicalInterventionRequest.Factory.newInstance();

            // get the index of the element from the selection list from the HTTP request
            int index = Integer.parseInt(request.getParameter(ProcessWizardState.INDEX_REQUEST_PARAMETER));
            IndividualForm individual = (IndividualForm) familyHome.getSelectionListWithoutCurrent()
                    .toArray()[index];

            familyHome.setIndividualToRegister(individual);

            initializeSubject(tir, individual.getId());

            return tir;
        }
        return null;
    }

    public Long validateRequest(HttpServletRequest request, Request cvqRequest, Object xmlRequestData)
            throws Exception {

        TechnicalInterventionRequestDocument.TechnicalInterventionRequest xmlRequest = 
            (TechnicalInterventionRequestDocument.TechnicalInterventionRequest) xmlRequestData;

        TechnicalInterventionRequestDocument document = 
            TechnicalInterventionRequestDocument.Factory.newInstance();
        document.setTechnicalInterventionRequest(xmlRequest);

        ITechnicalInterventionRequestService service = (ITechnicalInterventionRequestService) BusinessManager
                .getAc().getBean(ITechnicalInterventionRequestService.SERVICE_NAME);
        return service.create(document.getDomNode());
    }

}