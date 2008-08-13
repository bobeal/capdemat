package fr.cg95.cvq.fo.personal.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import fr.cg95.cvq.fo.common.FamilyHome;
import fr.cg95.cvq.fo.common.action.BasePersonalAction;
import fr.cg95.cvq.fo.common.form.DocumentForm;
import fr.cg95.cvq.fo.dispatcher.SessionManager;

public class DocumentDisplayAction extends BasePersonalAction {

    protected ActionForward doExecute(ActionMapping pMapping, ActionForm pForm, HttpServletRequest pRequest,
            HttpServletResponse pResponse) throws Exception {

        FamilyHome familyHome = SessionManager.getFamilyHome(pRequest);
        
        DocumentForm documentForm = null;
        String idParam = pRequest.getParameter("id");
        if (idParam != null)
            documentForm = familyHome.getDocumentById(idParam);
        else
            documentForm = familyHome.getCurrentDocument();

        try {    
            Integer index = Integer.valueOf(pRequest.getParameter("documentIndex"));
            if (index != null) {
                documentForm = documentForm.getDocuments().get(index);
            }
        } catch (NumberFormatException nfe) {
        }
        familyHome.setCurrentDocument(documentForm);
        
        if (pRequest.getParameter("download") != null)
            pRequest.setAttribute("url","/FrontOffice/lp7/download");
            
        // set the current document to the request
        pRequest.setAttribute(DOCUMENT_FORM, documentForm);

        return null;
    }

}
