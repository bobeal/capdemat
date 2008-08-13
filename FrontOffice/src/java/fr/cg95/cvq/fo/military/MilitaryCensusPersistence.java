package fr.cg95.cvq.fo.military;

import javax.servlet.http.HttpServletRequest;

import fr.cg95.cvq.fo.business.BusinessManager;
import fr.cg95.cvq.fo.common.FamilyHome;
import fr.cg95.cvq.fo.common.IPersistence;
import fr.cg95.cvq.fo.common.Request;
import fr.cg95.cvq.fo.common.form.ChildForm;
import fr.cg95.cvq.fo.dispatcher.SessionManager;
import fr.cg95.cvq.service.military.IMilitaryCensusRequestService;
import fr.cg95.cvq.wizard.process.ProcessWizardState;
import fr.cg95.cvq.xml.common.RequestType;
import fr.cg95.cvq.xml.military.MilitaryCensusRequestDocument;
import fr.cg95.cvq.xml.military.MilitaryCensusRequestDocument.MilitaryCensusRequest;

public class MilitaryCensusPersistence extends IPersistence {
    
    public String getServiceName(String definitionName) {
        return IMilitaryCensusRequestService.SERVICE_NAME;
    }

    public RequestType createRequest(HttpServletRequest request, Request cvqRequest) {
        FamilyHome familyHome = SessionManager.getFamilyHome(request);
        if (!cvqRequest.isInitialised()) {
            setAuthorizedSubjects(familyHome);
        }

        if (request.getParameter(ProcessWizardState.INDEX_REQUEST_PARAMETER) == null) {
            request.setAttribute(ProcessWizardState.NAME_REQUEST_PARAMETER, "eMilitary");

        } else {
            
            int index = Integer.parseInt(request.getParameter(ProcessWizardState.INDEX_REQUEST_PARAMETER));

            // get the child form from the unregistred children list
            ChildForm child = (ChildForm) familyHome.getSelectionListWithoutCurrent().toArray()[index];
            familyHome.setIndividualToRegister(child);

            MilitaryCensusRequest mcr = MilitaryCensusRequest.Factory.newInstance();

            initializeSubject(mcr, child.getId());
                
            return mcr;
        }
        
        return null;
    }

    public Long validateRequest(HttpServletRequest request, Request cvqRequest, Object xmlRequestData)
            throws Exception {
        
        MilitaryCensusRequestDocument.MilitaryCensusRequest xmlRequest =
            (MilitaryCensusRequestDocument.MilitaryCensusRequest) xmlRequestData;

        MilitaryCensusRequestDocument document = 
            MilitaryCensusRequestDocument.Factory.newInstance();
        document.setMilitaryCensusRequest(xmlRequest);
        
        IMilitaryCensusRequestService service = 
            (IMilitaryCensusRequestService)BusinessManager.getAc().getBean(IMilitaryCensusRequestService.SERVICE_NAME);
        return service.create(document.getDomNode());
    }

}
