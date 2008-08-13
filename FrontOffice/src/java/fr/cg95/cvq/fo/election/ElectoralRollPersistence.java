package fr.cg95.cvq.fo.election;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;

import fr.cg95.cvq.fo.business.BusinessManager;
import fr.cg95.cvq.fo.common.FamilyHome;
import fr.cg95.cvq.fo.common.IPersistence;
import fr.cg95.cvq.fo.common.Request;
import fr.cg95.cvq.fo.common.form.AdultForm;
import fr.cg95.cvq.fo.dispatcher.SessionManager;
import fr.cg95.cvq.fo.util.LabelValueManager;
import fr.cg95.cvq.service.election.IElectoralRollRegistrationRequestService;
import fr.cg95.cvq.wizard.process.ProcessWizardState;
import fr.cg95.cvq.xml.common.RequestType;
import fr.cg95.cvq.xml.election.ElectoralRollRegistrationRequestDocument;
import fr.cg95.cvq.xml.election.ElectoralRollRegistrationRequestDocument.ElectoralRollRegistrationRequest;

public class ElectoralRollPersistence extends IPersistence {

    public String getServiceName(String definitionName) {
        return IElectoralRollRegistrationRequestService.SERVICE_NAME;
    }

    public RequestType createRequest(HttpServletRequest request, Request cvqRequest) {
        FamilyHome familyHome = SessionManager.getFamilyHome(request);
        if (!cvqRequest.isInitialised()) {
            Collection nationalityList = LabelValueManager.getInstance().getNationalities(false);
            
            request.getSession().setAttribute("Nationality", nationalityList);
            
            setAuthorizedSubjects(familyHome);
        }
        if (request.getParameter(ProcessWizardState.INDEX_REQUEST_PARAMETER) == null) {
            request.setAttribute(ProcessWizardState.NAME_REQUEST_PARAMETER, "eElection");

        } else {        
            ElectoralRollRegistrationRequest errr = ElectoralRollRegistrationRequest.Factory.newInstance();
            
            // get the index of the element from the selection list from the HTTP request
            int index = Integer.parseInt(request.getParameter(ProcessWizardState.INDEX_REQUEST_PARAMETER));
            AdultForm adult = (AdultForm)familyHome.getSelectionListWithoutCurrent().toArray()[index];
            
            familyHome.setIndividualToRegister(adult);
            
            initializeSubject(errr, adult.getId());

            // Subject address  outside city is not required, so not created by the system, we'll have to add it manualy
            errr.addNewSubjectAddressOutsideCity();
            
            return errr;
        }
        return null;
    }

    public Long validateRequest(HttpServletRequest request, Request cvqRequest, Object xmlRequestData)
            throws Exception {

        ElectoralRollRegistrationRequestDocument.ElectoralRollRegistrationRequest xmlRequest =
                (ElectoralRollRegistrationRequestDocument.ElectoralRollRegistrationRequest) xmlRequestData;

        ElectoralRollRegistrationRequestDocument document = 
            ElectoralRollRegistrationRequestDocument.Factory.newInstance();
        document.setElectoralRollRegistrationRequest(xmlRequest);

        IElectoralRollRegistrationRequestService service = 
            (IElectoralRollRegistrationRequestService)BusinessManager.getAc().getBean(IElectoralRollRegistrationRequestService.SERVICE_NAME);
        return service.create(document.getDomNode());
    }

}
