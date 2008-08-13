package fr.cg95.cvq.fo.personal.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import fr.cg95.cvq.business.users.HomeFolder;
import fr.cg95.cvq.fo.business.BusinessManager;
import fr.cg95.cvq.fo.common.FamilyHome;
import fr.cg95.cvq.fo.common.action.BasePersonalAction;
import fr.cg95.cvq.fo.dispatcher.SessionManager;
import fr.cg95.cvq.service.users.IHomeFolderService;

public class KeepFolderAction extends BasePersonalAction {

    protected ActionForward doExecute(ActionMapping pMapping, ActionForm pForm, HttpServletRequest pRequest,
            HttpServletResponse pResponse) throws Exception {

        FamilyHome familyHome = SessionManager.getFamilyHome(pRequest);
        IHomeFolderService service = BusinessManager.getInstance().getHomeFolderService();
        
        HomeFolder folder = service.getById(familyHome.getId());
        folder.setBoundToRequest(new Boolean(false));
        service.modify(folder);
        
        familyHome.setBoundToRequest(false);
        
        return null;
    }

}
