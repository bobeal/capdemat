package fr.cg95.cvq.fo.social;

import javax.servlet.http.HttpServletRequest;

import fr.cg95.cvq.fo.business.BusinessManager;
import fr.cg95.cvq.fo.common.FamilyHome;
import fr.cg95.cvq.fo.common.IPersistence;
import fr.cg95.cvq.fo.common.Request;
import fr.cg95.cvq.fo.common.form.IndividualForm;
import fr.cg95.cvq.fo.dispatcher.SessionManager;
import fr.cg95.cvq.service.social.IHandicapAllowanceRequestService;
import fr.cg95.cvq.wizard.process.ProcessWizardState;
import fr.cg95.cvq.xml.common.RequestType;
import fr.cg95.cvq.xml.social.HandicapAllowanceRequestDocument;
import fr.cg95.cvq.xml.social.HandicapAllowanceRequestDocument.HandicapAllowanceRequest;

public class HandicapAllowancePersistence extends IPersistence {

    public String getServiceName(String definitionName) {
        return IHandicapAllowanceRequestService.SERVICE_NAME;
    }

    public RequestType createRequest(HttpServletRequest request, Request cvqRequest) {
        FamilyHome familyHome = SessionManager.getFamilyHome(request);
        if (!cvqRequest.isInitialised()) {
            cvqRequest.setDbRequest(new fr.cg95.cvq.business.social.HandicapAllowanceRequest());

            setAuthorizedSubjects(familyHome);
        }
        if (request.getParameter(ProcessWizardState.INDEX_REQUEST_PARAMETER) == null) {
            request.setAttribute(ProcessWizardState.NAME_REQUEST_PARAMETER, "eHandicapAllowance");

        } else {        
            HandicapAllowanceRequest har = HandicapAllowanceRequest.Factory.newInstance();
            
            // get the index of the element from the selection list from the HTTP request
            int index = Integer.parseInt(request.getParameter(ProcessWizardState.INDEX_REQUEST_PARAMETER));
            IndividualForm individual = (IndividualForm)familyHome.getSelectionListWithoutCurrent().toArray()[index];
            
            familyHome.setIndividualToRegister(individual);
            
            initializeSubject(har, individual.getId());

            har.addNewLegalRepresentativeAddress();

            return har;
        }
        return null;
    }

    public Long validateRequest(HttpServletRequest request, Request cvqRequest,
            Object xmlRequestData) throws Exception {
        HandicapAllowanceRequestDocument.HandicapAllowanceRequest xmlRequest = 
            (HandicapAllowanceRequestDocument.HandicapAllowanceRequest) xmlRequestData;

        HandicapAllowanceRequestDocument document = 
            HandicapAllowanceRequestDocument.Factory.newInstance();
        document.setHandicapAllowanceRequest(xmlRequest);

        IHandicapAllowanceRequestService service = 
            (IHandicapAllowanceRequestService)BusinessManager.getAc().getBean(IHandicapAllowanceRequestService.SERVICE_NAME);
        
        return service.create(document.getDomNode());
    }

}
