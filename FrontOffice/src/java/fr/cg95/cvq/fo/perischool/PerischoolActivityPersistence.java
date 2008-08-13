package fr.cg95.cvq.fo.perischool;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;

import fr.cg95.cvq.business.school.SchoolRegistrationRequest;
import fr.cg95.cvq.fo.business.BusinessManager;
import fr.cg95.cvq.fo.common.FamilyHome;
import fr.cg95.cvq.fo.common.IPersistence;
import fr.cg95.cvq.fo.common.Request;
import fr.cg95.cvq.fo.common.form.ChildForm;
import fr.cg95.cvq.fo.dispatcher.SessionManager;
import fr.cg95.cvq.fo.perischool.form.Authorized;
import fr.cg95.cvq.fo.perischool.form.Contact;
import fr.cg95.cvq.service.school.IPerischoolActivityRegistrationRequestService;
import fr.cg95.cvq.wizard.ReferentialData;
import fr.cg95.cvq.wizard.StageFormList;
import fr.cg95.cvq.wizard.process.ProcessWizardState;
import fr.cg95.cvq.xml.common.LocalReferentialDataType;
import fr.cg95.cvq.xml.common.RequestType;
import fr.cg95.cvq.xml.school.OtherIndividualType;
import fr.cg95.cvq.xml.school.PerischoolActivityRegistrationRequestDocument;
import fr.cg95.cvq.xml.school.SchoolOtherIndividualType;
import fr.cg95.cvq.xml.school.PerischoolActivityRegistrationRequestDocument.PerischoolActivityRegistrationRequest;

public class PerischoolActivityPersistence extends IPersistence {

    public String getServiceName(String definitionName) {
        return IPerischoolActivityRegistrationRequestService.SERVICE_NAME;
    }

    public RequestType createRequest(HttpServletRequest request, Request cvqRequest) {
        FamilyHome familyHome = SessionManager.getFamilyHome(request);
        if (!cvqRequest.isInitialised()) {
            cvqRequest.setList("contact", new StageFormList(this, cvqRequest));
            cvqRequest.setList("authorized", new StageFormList(this, cvqRequest));

            Collection activityList = BusinessManager.getReferentialList("PerischoolActivity");
            request.getSession().setAttribute("activityList", activityList);

            setAuthorizedSubjects(familyHome);
        }
        if (request.getParameter(ProcessWizardState.INDEX_REQUEST_PARAMETER) == null) {
            request.setAttribute(ProcessWizardState.NAME_REQUEST_PARAMETER, "ePeriSchool");

        } else {
            // get the index of the element from the unregistred children list from the HTTP request
            int index = Integer.parseInt(request.getParameter(ProcessWizardState.INDEX_REQUEST_PARAMETER));

            // get the child form from the unregistred children list
            ChildForm child = (ChildForm) familyHome.getSelectionListWithoutCurrent().toArray()[index];

            familyHome.setIndividualToRegister(child);

            PerischoolActivityRegistrationRequest parr = PerischoolActivityRegistrationRequest.Factory
                    .newInstance();

            parr.addNewOtherIndividual();
            parr.getOtherIndividualArray(0).setHomePhone("");
            parr.getOtherIndividualArray(0).setOfficePhone("");

            initializeSubject(parr, child.getId());

            SchoolRegistrationRequest srr = BusinessManager.getInstance().getChildSchoolRegistration(
                    child.getId());

            if ((srr != null) && (srr.getUrgencyPhone() != null))
                parr.setUrgencyPhone(srr.getUrgencyPhone());
            else
                parr.setUrgencyPhone("");

            // By default we select all activities
            Collection list = (Collection) request.getSession().getAttribute("activityList");
            LocalReferentialDataType[] activities = new LocalReferentialDataType[list.size()];

            int i = 0;
            Iterator iter = list.iterator();
            while (iter.hasNext()) {
                ReferentialData data = (ReferentialData) iter.next();
                LocalReferentialDataType activity = LocalReferentialDataType.Factory.newInstance();
                activity.setName(data.getKey());
                activities[i++] = activity;
            }
            parr.setPerischoolActivityArray(activities);

            return parr;
        }
        return null;
    }

    public Long validateRequest(HttpServletRequest request, Request cvqRequest, Object xmlRequestData)
            throws Exception {

        PerischoolActivityRegistrationRequestDocument.PerischoolActivityRegistrationRequest xmlRequest = (PerischoolActivityRegistrationRequestDocument.PerischoolActivityRegistrationRequest) xmlRequestData;

        xmlRequest.setOtherIndividualArray(saveContactsAndAuthorized(cvqRequest.getList("contact"),
                cvqRequest.getList("authorized")));
        
        PerischoolActivityRegistrationRequestDocument document = PerischoolActivityRegistrationRequestDocument.Factory
                .newInstance();
        document.setPerischoolActivityRegistrationRequest(xmlRequest);

        IPerischoolActivityRegistrationRequestService service = (IPerischoolActivityRegistrationRequestService) BusinessManager
                .getAc().getBean(IPerischoolActivityRegistrationRequestService.SERVICE_NAME);
        return service.create(document.getDomNode());

    }

    private OtherIndividualType[] saveContactsAndAuthorized(Collection contacts,
            Collection authorized) {
        ArrayList<OtherIndividualType> xmlArray = new ArrayList<OtherIndividualType>();

        Iterator it = authorized.iterator();
        while (it.hasNext()) {
            Authorized person = (Authorized) it.next();
            OtherIndividualType otherIndividual = OtherIndividualType.Factory.newInstance();
            otherIndividual.setLastName(person.getOtherIndividualLastName());
            otherIndividual.setFirstName(person.getOtherIndividualFirstName());
            otherIndividual.setAddress(person.getOtherIndividualAddress());
            otherIndividual.setHomePhone(person.getOtherIndividualHomePhone());
            otherIndividual.setOfficePhone(person.getOtherIndividualOfficePhone());
            otherIndividual.setType(SchoolOtherIndividualType.PICKUP_PERSON);

            xmlArray.add(otherIndividual);
        }
        it = contacts.iterator();
        while (it.hasNext()) {
            Contact person = (Contact) it.next();
            OtherIndividualType otherIndividual = OtherIndividualType.Factory.newInstance();
            otherIndividual.setLastName(person.getOtherIndividualLastName());
            otherIndividual.setFirstName(person.getOtherIndividualFirstName());
            otherIndividual.setAddress(person.getOtherIndividualAddress());
            otherIndividual.setHomePhone(person.getOtherIndividualHomePhone());
            otherIndividual.setOfficePhone(person.getOtherIndividualOfficePhone());
            otherIndividual.setType(SchoolOtherIndividualType.CONTACT_PERSON);

            xmlArray.add(otherIndividual);
        }
        return xmlArray.toArray(new fr.cg95.cvq.xml.school.OtherIndividualType[0]);
    }

}
