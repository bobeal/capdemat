package fr.cg95.cvq.fo.cultural;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;

import fr.cg95.cvq.fo.business.BusinessManager;
import fr.cg95.cvq.fo.common.FamilyHome;
import fr.cg95.cvq.fo.common.IPersistence;
import fr.cg95.cvq.fo.common.Request;
import fr.cg95.cvq.fo.common.form.IndividualForm;
import fr.cg95.cvq.fo.dispatcher.SessionManager;
import fr.cg95.cvq.service.leisure.culture.ILibraryRegistrationRequestService;
import fr.cg95.cvq.wizard.process.ProcessWizardState;
import fr.cg95.cvq.xml.common.RequestType;
import fr.cg95.cvq.xml.leisure.culture.LibraryRegistrationRequestDocument;
import fr.cg95.cvq.xml.leisure.culture.LibraryRegistrationRequestDocument.LibraryRegistrationRequest;

public class LibraryRegistrationPersistence extends IPersistence {

    public String getServiceName(String definitionName) {
        return ILibraryRegistrationRequestService.SERVICE_NAME;
    }

    public RequestType createRequest(HttpServletRequest request, Request cvqRequest) {
        FamilyHome familyHome = SessionManager.getFamilyHome(request);
        if (!cvqRequest.isInitialised()) {
            Collection subscription = BusinessManager.getReferentialList("Subscription");

            request.getSession().setAttribute("Subscription", subscription);

            setAuthorizedSubjects(familyHome);
        }
        if (request.getParameter(ProcessWizardState.INDEX_REQUEST_PARAMETER) == null) {
            request.setAttribute(ProcessWizardState.NAME_REQUEST_PARAMETER, "eLibrary");

        } else {
            LibraryRegistrationRequest lrr = LibraryRegistrationRequest.Factory.newInstance();

            // get the index of the element from the selection list from the HTTP request
            int index = Integer.parseInt(request.getParameter(ProcessWizardState.INDEX_REQUEST_PARAMETER));
            IndividualForm individual = (IndividualForm) familyHome.getSelectionListWithoutCurrent()
                    .toArray()[index];

            familyHome.setIndividualToRegister(individual);

            initializeSubject(lrr, individual.getId());

            return lrr;
        }
        return null;
    }

    public Long validateRequest(HttpServletRequest request, Request cvqRequest, Object xmlRequestData)
            throws Exception {

        LibraryRegistrationRequestDocument.LibraryRegistrationRequest xmlRequest = 
            (LibraryRegistrationRequestDocument.LibraryRegistrationRequest) xmlRequestData;

        LibraryRegistrationRequestDocument document = 
            LibraryRegistrationRequestDocument.Factory.newInstance();
        document.setLibraryRegistrationRequest(xmlRequest);

        ILibraryRegistrationRequestService service = (ILibraryRegistrationRequestService) BusinessManager
                .getAc().getBean(ILibraryRegistrationRequestService.SERVICE_NAME);
        return service.create(document.getDomNode());
    }

}
