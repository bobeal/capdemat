package fr.cg95.cvq.fo.localpolice;

import javax.servlet.http.HttpServletRequest;

import fr.cg95.cvq.fo.business.BusinessManager;
import fr.cg95.cvq.fo.common.FamilyHome;
import fr.cg95.cvq.fo.common.IPersistence;
import fr.cg95.cvq.fo.common.Request;
import fr.cg95.cvq.fo.common.form.IndividualForm;
import fr.cg95.cvq.fo.dispatcher.SessionManager;
import fr.cg95.cvq.service.localpolice.IHolidaySecurityRequestService;
import fr.cg95.cvq.wizard.process.ProcessWizardState;
import fr.cg95.cvq.xml.common.RequestType;
import fr.cg95.cvq.xml.localpolice.HolidaySecurityRequestDocument;
import fr.cg95.cvq.xml.localpolice.HolidaySecurityRequestDocument.HolidaySecurityRequest;

public class HolidaySecurityPersistence extends IPersistence {

    public String getServiceName(String definitionName) {
        return IHolidaySecurityRequestService.SERVICE_NAME;
    }

    public RequestType createRequest(HttpServletRequest request, Request cvqRequest) {
        FamilyHome familyHome = SessionManager.getFamilyHome(request);
        if (!cvqRequest.isInitialised())
            setAuthorizedSubjects(familyHome);
        
        if (request.getParameter(ProcessWizardState.INDEX_REQUEST_PARAMETER) == null) {
            request.setAttribute(ProcessWizardState.NAME_REQUEST_PARAMETER, "eHolidaySecurity");

        } else {
            HolidaySecurityRequest hsr = HolidaySecurityRequest.Factory.newInstance();

            // get the index of the element from the selection list from the HTTP request
            int index = Integer.parseInt(request.getParameter(ProcessWizardState.INDEX_REQUEST_PARAMETER));
            IndividualForm individual = (IndividualForm) familyHome.getSelectionListWithoutCurrent()
                    .toArray()[index];

            familyHome.setIndividualToRegister(individual);

            initializeSubject(hsr, individual.getId());

            return hsr;
        }
        return null;
    }

    public Long validateRequest(HttpServletRequest request, Request cvqRequest, Object xmlRequestData)
            throws Exception {

        HolidaySecurityRequestDocument.HolidaySecurityRequest xmlRequest = 
            (HolidaySecurityRequestDocument.HolidaySecurityRequest) xmlRequestData;

        HolidaySecurityRequestDocument document = 
            HolidaySecurityRequestDocument.Factory.newInstance();
        document.setHolidaySecurityRequest(xmlRequest);

        IHolidaySecurityRequestService service = (IHolidaySecurityRequestService) BusinessManager
                .getAc().getBean(IHolidaySecurityRequestService.SERVICE_NAME);
        return service.create(document.getDomNode());
    }

}
