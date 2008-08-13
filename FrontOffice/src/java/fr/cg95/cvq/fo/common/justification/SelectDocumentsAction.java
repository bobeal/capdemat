package fr.cg95.cvq.fo.common.justification;

import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import fr.cg95.cvq.fo.common.Request;
import fr.cg95.cvq.fo.common.action.BaseAction;
import fr.cg95.cvq.fo.common.form.DocumentForm;
import fr.cg95.cvq.wizard.process.ProcessWizardState;

public class SelectDocumentsAction extends BaseAction {

    protected ActionForward doExecute(ActionMapping pMapping, ActionForm pForm, HttpServletRequest pRequest,
            HttpServletResponse pResponse) throws Exception {

        ProcessWizardState wizardState = getWizardState(pRequest);

        int index = wizardState.getIndex();
        String action = pRequest.getParameter("action");
        if ((index >= 0) && (action != null)) {
            if (action.equals("previous"))
                index--;
            else if (action.equals("next"))
                index++;
            else if (action.equals("cancel"))
                index = -1;
        } else if (action == null) {
            index = 0;
        }
        Request cvqRequest = (Request)pRequest.getSession().getAttribute(Request.class.getName());
        ArrayList<DocumentForm> missingDocuments = null;
        
        if (action.equals("select")) {
            missingDocuments = new ArrayList<DocumentForm>();
            cvqRequest.resetSelectedDocuments();
            Enumeration params = pRequest.getParameterNames();
            while (params.hasMoreElements()) {
                try {
                    DocumentForm document = cvqRequest.getDocument(new Integer((String)params.nextElement()));
                    document.setSelected(true);
                    if (document.isAvailable())
                        document.setSupplied(true);
                    
                    else if (!document.isSupplied())
                        missingDocuments.add(document);
    
                } catch(NumberFormatException nfe) {
                }
            }
            index = 0;

            pRequest.getSession().setAttribute(SelectDocumentsAction.class.getName(), missingDocuments);
        } else {
            missingDocuments =  
                (ArrayList<DocumentForm>)pRequest.getSession().getAttribute(SelectDocumentsAction.class.getName());
            
            if (missingDocuments == null)
                missingDocuments = new ArrayList<DocumentForm>();
        }
        if ((index >= 0) && (index < missingDocuments.size()) ) {
            DocumentForm currentDocument = missingDocuments.get(index);
            cvqRequest.setCurrentDocumentType(currentDocument.getTypeId());
            pRequest.setAttribute(DOCUMENT_FORM, currentDocument);
            if (currentDocument.getNumberOfPages() > 0)
                wizardState.setTransition("display");
            else
                wizardState.setTransition("add");
        } else {
            index = -1;
            if (!missingDocuments.isEmpty() && 
                    (action != null) && (action.equals("previous") || action.equals("cancel"))) {
                wizardState.setTransition("explication");
            } else {
                cvqRequest.resetSelectedDocuments();
                pRequest.setAttribute(ProcessWizardState.STAGE_REQUEST_PARAMETER, "end");
                pRequest.getSession().removeAttribute(SelectDocumentsAction.class.getName());
                if ((action != null) && action.equals("next"))
                    wizardState.setStageSaved(pRequest, "Documents");
            }
        }
        wizardState.setIndex(index);
        return null;
    }

}
