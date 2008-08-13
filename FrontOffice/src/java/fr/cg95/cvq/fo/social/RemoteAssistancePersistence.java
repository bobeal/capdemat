package fr.cg95.cvq.fo.social;

import javax.servlet.http.HttpServletRequest;

import fr.cg95.cvq.fo.business.BusinessManager;
import fr.cg95.cvq.fo.common.FamilyHome;
import fr.cg95.cvq.fo.common.IPersistence;
import fr.cg95.cvq.fo.common.Request;
import fr.cg95.cvq.fo.common.form.AdultForm;
import fr.cg95.cvq.fo.dispatcher.SessionManager;
import fr.cg95.cvq.service.social.IRemoteSupportRequestService;
import fr.cg95.cvq.wizard.process.ProcessWizardState;
import fr.cg95.cvq.xml.common.RequestType;
import fr.cg95.cvq.xml.social.RemoteSupportRequestDocument;
import fr.cg95.cvq.xml.social.RsrContactType;
import fr.cg95.cvq.xml.social.TrusteeType;
import fr.cg95.cvq.xml.social.RemoteSupportRequestDocument.RemoteSupportRequest;

public class RemoteAssistancePersistence extends IPersistence {

    public String getServiceName(String definitionName) {
        return IRemoteSupportRequestService.SERVICE_NAME;
    }

    public RequestType createRequest(HttpServletRequest request, Request cvqRequest) {
        FamilyHome familyHome = SessionManager.getFamilyHome(request);
        if (!cvqRequest.isInitialised()) {
            cvqRequest.setDbRequest(new fr.cg95.cvq.business.social.RemoteSupportRequest());

            setAuthorizedSubjects(familyHome);
        }
        if (request.getParameter(ProcessWizardState.INDEX_REQUEST_PARAMETER) == null) {
            request.setAttribute(ProcessWizardState.NAME_REQUEST_PARAMETER, "eAssistance");

        } else {        
            RemoteSupportRequest rsr = RemoteSupportRequest.Factory.newInstance();
            
            // get the index of the element from the selection list from the HTTP request
            int index = Integer.parseInt(request.getParameter(ProcessWizardState.INDEX_REQUEST_PARAMETER));
            AdultForm adult = (AdultForm)familyHome.getSelectionListWithoutCurrent().toArray()[index];
            
            familyHome.setIndividualToRegister(adult);
            
            initializeSubject(rsr, adult.getId());

            rsr.setContact(RsrContactType.REQUESTER);
            rsr.setTrustee(TrusteeType.REQUESTER);
            
            return rsr;
        }
        return null;
    }

    public Long validateRequest(HttpServletRequest request, Request cvqRequest,
            Object xmlRequestData) throws Exception {

        RemoteSupportRequestDocument.RemoteSupportRequest xmlRequest = 
            (RemoteSupportRequestDocument.RemoteSupportRequest) xmlRequestData;

        RemoteSupportRequestDocument document = 
            RemoteSupportRequestDocument.Factory.newInstance();
        document.setRemoteSupportRequest(xmlRequest);

        IRemoteSupportRequestService service = 
            (IRemoteSupportRequestService)BusinessManager.getAc().getBean(IRemoteSupportRequestService.SERVICE_NAME);
        
        return service.create(document.getDomNode());
    }

}
