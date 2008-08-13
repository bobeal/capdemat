package fr.cg95.cvq.fo.school;

import javax.servlet.http.HttpServletRequest;

import org.apache.xmlbeans.XmlException;

import fr.cg95.cvq.fo.business.BusinessManager;
import fr.cg95.cvq.fo.common.FamilyHome;
import fr.cg95.cvq.fo.common.IPersistence;
import fr.cg95.cvq.fo.common.Request;
import fr.cg95.cvq.fo.common.form.ChildForm;
import fr.cg95.cvq.fo.dispatcher.SessionManager;
import fr.cg95.cvq.service.school.ISchoolRegistrationRequestService;
import fr.cg95.cvq.wizard.process.ProcessWizardState;
import fr.cg95.cvq.xml.common.RequestType;
import fr.cg95.cvq.xml.school.SchoolRegistrationRequestDocument;
import fr.cg95.cvq.xml.school.SchoolRegistrationRequestDocument.SchoolRegistrationRequest;

public class SchoolRegistrationPersistence extends IPersistence {

    public String getServiceName(String definitionName) {
        return ISchoolRegistrationRequestService.SERVICE_NAME;
    }

    public RequestType createRequest(HttpServletRequest request, Request cvqRequest) {
        FamilyHome familyHome = SessionManager.getFamilyHome(request);
        if (!cvqRequest.isInitialised()) {
            setAuthorizedSubjects(familyHome);
        }
        if (request.getParameter(ProcessWizardState.INDEX_REQUEST_PARAMETER) == null) {
            request.setAttribute(ProcessWizardState.NAME_REQUEST_PARAMETER, "eSchool");

        } else {
            // get the index of the element from the unregistred children list from the HTTP request
            int index = Integer.parseInt(request.getParameter(ProcessWizardState.INDEX_REQUEST_PARAMETER));

            // get the child form from the unregistred children list
            ChildForm child = (ChildForm) familyHome.getSelectionListWithoutCurrent().toArray()[index];

            try {
                SchoolRegistrationRequestDocument document = 
                    SchoolRegistrationRequestDocument.Factory.parse(initializeRequest(request, child));

                SchoolRegistrationRequest srr = document.getSchoolRegistrationRequest();

                if (srr.getUrgencyPhone() == null)
                    srr.setUrgencyPhone(familyHome.getEmergencyPhone());
    
                return srr;

            } catch (XmlException e) {
            }
        }
        return null;
    }

    public Long validateRequest(HttpServletRequest request, Request cvqRequest, Object xmlRequestData)
            throws Exception {

        SchoolRegistrationRequestDocument.SchoolRegistrationRequest xmlRequest = 
            (SchoolRegistrationRequestDocument.SchoolRegistrationRequest) xmlRequestData;

        SchoolRegistrationRequestDocument document = 
            SchoolRegistrationRequestDocument.Factory.newInstance();
        document.setSchoolRegistrationRequest(xmlRequest);

        ISchoolRegistrationRequestService service = (ISchoolRegistrationRequestService) BusinessManager
                .getAc().getBean(ISchoolRegistrationRequestService.SERVICE_NAME);
        return service.create(document.getDomNode());
    
    }

}
