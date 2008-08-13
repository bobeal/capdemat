package fr.cg95.cvq.fo.leisure;

import javax.servlet.http.HttpServletRequest;

import fr.cg95.cvq.fo.business.BusinessManager;
import fr.cg95.cvq.fo.common.FamilyHome;
import fr.cg95.cvq.fo.common.IPersistence;
import fr.cg95.cvq.fo.common.Request;
import fr.cg95.cvq.fo.common.form.IndividualForm;
import fr.cg95.cvq.fo.dispatcher.SessionManager;
import fr.cg95.cvq.service.leisure.music.IMusicSchoolRegistrationRequestService;
import fr.cg95.cvq.wizard.process.ProcessWizardState;
import fr.cg95.cvq.xml.common.RequestType;
import fr.cg95.cvq.xml.leisure.music.MusicSchoolRegistrationRequestDocument;
import fr.cg95.cvq.xml.leisure.music.MusicSchoolRegistrationRequestDocument.MusicSchoolRegistrationRequest;

public class MusicSchoolPersistence extends IPersistence {

    public String getServiceName(String definitionName) {
        return IMusicSchoolRegistrationRequestService.SERVICE_NAME;
    }

    public RequestType createRequest(HttpServletRequest request, Request cvqRequest) {
        FamilyHome familyHome = SessionManager.getFamilyHome(request);
        if (!cvqRequest.isInitialised()) {
            setAuthorizedSubjects(familyHome);
        }
        if (request.getParameter(ProcessWizardState.INDEX_REQUEST_PARAMETER) == null) {
            request.setAttribute(ProcessWizardState.NAME_REQUEST_PARAMETER, "eMusic");

        } else {
            MusicSchoolRegistrationRequest msrr = MusicSchoolRegistrationRequest.Factory.newInstance();

            // get the index of the element from the selection list from the HTTP request
            int index = Integer.parseInt(request.getParameter(ProcessWizardState.INDEX_REQUEST_PARAMETER));
            IndividualForm individual = (IndividualForm) familyHome.getSelectionListWithoutCurrent()
                    .toArray()[index];

            familyHome.setIndividualToRegister(individual);

            initializeSubject(msrr, individual.getId());

            return msrr;
        }
        return null;
    }

    public Long validateRequest(HttpServletRequest request, Request cvqRequest, Object xmlRequestData)
            throws Exception {
        
        MusicSchoolRegistrationRequestDocument.MusicSchoolRegistrationRequest xmlRequest = 
            (MusicSchoolRegistrationRequestDocument.MusicSchoolRegistrationRequest) xmlRequestData;

        MusicSchoolRegistrationRequestDocument document = MusicSchoolRegistrationRequestDocument.Factory
                .newInstance();
        document.setMusicSchoolRegistrationRequest(xmlRequest);

        IMusicSchoolRegistrationRequestService service = (IMusicSchoolRegistrationRequestService) BusinessManager
                .getAc().getBean(IMusicSchoolRegistrationRequestService.SERVICE_NAME);
        return service.create(document.getDomNode());
    }

}
