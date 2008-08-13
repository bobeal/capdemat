package fr.cg95.cvq.fo.leisure;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;

import org.apache.xmlbeans.XmlException;

import fr.cg95.cvq.fo.business.BusinessManager;
import fr.cg95.cvq.fo.common.FamilyHome;
import fr.cg95.cvq.fo.common.IPersistence;
import fr.cg95.cvq.fo.common.Request;
import fr.cg95.cvq.fo.common.form.AdultForm;
import fr.cg95.cvq.fo.dispatcher.SessionManager;
import fr.cg95.cvq.service.leisure.ISmsNotificationRequestService;
import fr.cg95.cvq.wizard.process.ProcessWizardState;
import fr.cg95.cvq.xml.common.RequestType;
import fr.cg95.cvq.xml.leisure.SmsNotificationRequestDocument;
import fr.cg95.cvq.xml.leisure.SmsNotificationRequestDocument.SmsNotificationRequest;

public class SmsNotificationPersistence extends IPersistence {

    public String getServiceName(String definitionName) {
        return ISmsNotificationRequestService.SERVICE_NAME;
    }

    public RequestType createRequest(HttpServletRequest request, Request cvqRequest) {
        FamilyHome familyHome = SessionManager.getFamilyHome(request);
        if (!cvqRequest.isInitialised()) {
            
            Collection interests = BusinessManager.getReferentialList("Interests");
            request.getSession().setAttribute("Interests", interests);
            
            setAuthorizedSubjects(familyHome);  
        }
        if (request.getParameter(ProcessWizardState.INDEX_REQUEST_PARAMETER) == null) {
            request.setAttribute(ProcessWizardState.NAME_REQUEST_PARAMETER, "eSms");

        } else {
            // get the index of the element from the selection list from the HTTP request
            int index = Integer.parseInt(request.getParameter(ProcessWizardState.INDEX_REQUEST_PARAMETER));
            AdultForm adultForm = (AdultForm) familyHome.getSelectionListWithoutCurrent().toArray()[index];
            
            familyHome.setIndividualToRegister(adultForm);
            
            // Clone request for subscriber of SMS News Letter
            try {
                SmsNotificationRequestDocument document = 
                    SmsNotificationRequestDocument.Factory.parse(initializeRequest(request, adultForm));
                SmsNotificationRequest snr = document.getSmsNotificationRequest();
                return snr;
            } catch (XmlException e) {
            }
        }
        return null;
    }

    public Long validateRequest(HttpServletRequest request, Request cvqRequest,
            Object xmlRequestData) throws Exception {

        SmsNotificationRequestDocument.SmsNotificationRequest xmlRequest = 
            (SmsNotificationRequestDocument.SmsNotificationRequest) xmlRequestData;

        SmsNotificationRequestDocument document = 
            SmsNotificationRequestDocument.Factory.newInstance();
        document.setSmsNotificationRequest(xmlRequest);

        ISmsNotificationRequestService service = (ISmsNotificationRequestService) 
            BusinessManager.getAc().getBean(ISmsNotificationRequestService.SERVICE_NAME);
        return service.create(document.getDomNode());
    }

}
