package fr.cg95.cvq.fo.schoolcanteen;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;

import fr.cg95.cvq.business.school.SchoolRegistrationRequest;
import fr.cg95.cvq.fo.business.BusinessManager;
import fr.cg95.cvq.fo.common.FamilyHome;
import fr.cg95.cvq.fo.common.IPersistence;
import fr.cg95.cvq.fo.common.Request;
import fr.cg95.cvq.fo.common.form.ChildForm;
import fr.cg95.cvq.fo.dispatcher.SessionManager;
import fr.cg95.cvq.service.school.ISchoolCanteenRegistrationRequestService;
import fr.cg95.cvq.wizard.process.ProcessWizardState;
import fr.cg95.cvq.xml.common.RequestType;
import fr.cg95.cvq.xml.common.SectionType;
import fr.cg95.cvq.xml.school.SchoolCanteenRegistrationRequestDocument;
import fr.cg95.cvq.xml.school.SchoolCanteenRegistrationRequestDocument.SchoolCanteenRegistrationRequest;

public class SchoolCanteenPersistence extends IPersistence {

    public String getServiceName(String definitionName) {
        return ISchoolCanteenRegistrationRequestService.SERVICE_NAME;
    }

    public RequestType createRequest(HttpServletRequest request, Request cvqRequest) {
        FamilyHome familyHome = SessionManager.getFamilyHome(request);
        if (!cvqRequest.isInitialised()) {
            Collection dietList = BusinessManager.getReferentialList("FoodDiet");
            Collection canteenAttendingDaysList = BusinessManager.getReferentialList("CanteenAttendingDays");

            request.getSession().setAttribute("FoodDiet", dietList);
            request.getSession().setAttribute("CanteenAttendingDays", canteenAttendingDaysList);

            setAuthorizedSubjects(familyHome);
        }
        if (request.getParameter(ProcessWizardState.INDEX_REQUEST_PARAMETER) == null) {
            request.setAttribute(ProcessWizardState.NAME_REQUEST_PARAMETER, "eSchoolCanteen");

        } else {
            // get the index of the element from the unregistred children list from the HTTP request
            int index = Integer.parseInt(request.getParameter(ProcessWizardState.INDEX_REQUEST_PARAMETER));

            // get the child form from the unregistred children list
            ChildForm child = (ChildForm) familyHome.getSelectionListWithoutCurrent().toArray()[index];

            familyHome.setIndividualToRegister(child);

            SchoolCanteenRegistrationRequest scrr = SchoolCanteenRegistrationRequest.Factory.newInstance();

            initializeSubject(scrr, child.getId());

            SchoolRegistrationRequest srr = 
                BusinessManager.getInstance().getChildSchoolRegistration(child.getId());

            scrr.setUrgencyPhone("");
            if (srr != null) {
                if (srr.getSection() != null)
                    scrr.setSection(SectionType.Enum.forString(srr.getSection().toString()));

                if (srr.getUrgencyPhone() != null)
                    scrr.setUrgencyPhone(srr.getUrgencyPhone());
            }
            scrr.setDoctorPhone("");

            return scrr;
        }
        return null;
    }

    public Long validateRequest(HttpServletRequest request, Request cvqRequest, Object xmlRequestData)
            throws Exception {

        SchoolCanteenRegistrationRequestDocument.SchoolCanteenRegistrationRequest xmlRequest = 
            (SchoolCanteenRegistrationRequestDocument.SchoolCanteenRegistrationRequest) xmlRequestData;

        SchoolCanteenRegistrationRequestDocument document = 
            SchoolCanteenRegistrationRequestDocument.Factory.newInstance();
        document.setSchoolCanteenRegistrationRequest(xmlRequest);

        ISchoolCanteenRegistrationRequestService service = (ISchoolCanteenRegistrationRequestService) BusinessManager
                .getAc().getBean(ISchoolCanteenRegistrationRequestService.SERVICE_NAME);
        return service.create(document.getDomNode());
    }

}
