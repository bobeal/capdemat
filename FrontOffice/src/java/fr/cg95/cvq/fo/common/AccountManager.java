package fr.cg95.cvq.fo.common;

import java.io.Serializable;

import javax.servlet.http.HttpSession;

import fr.cg95.cvq.business.request.RequestType;
import fr.cg95.cvq.fo.business.RequestManager;
import fr.cg95.cvq.fo.dispatcher.SessionManager;
import fr.cg95.cvq.wizard.IWizardSession;
import fr.cg95.cvq.wizard.manager.ManagerWizardState;

public class AccountManager implements IWizardSession, Serializable {
    
    public static final String SESSION_NAME = "accountManager";
    
    private RequestManager requestManager = null;

    private HttpSession session;
    
    public AccountManager() {
        super();
    }

    public void init(HttpSession session, int wizard) {
        this.session = session;
        requestManager = SessionManager.getRequestManager(session);
    }

    public boolean getActive(String process) {
        return requestManager.getRequestTypeActive(process);
    }
    
    public boolean getPublic(String process) {
        return requestManager.isProcessPublic(process) && 
               requestManager.getRequestTypeActive(process);
    }
    
    public String getVersion() {
        return session.getServletContext().getInitParameter("applicationVersion")
            + "-" + session.getServletContext().getInitParameter("applicationRevision");
    }

    public HttpSession getSession() {
        return session;
    }

    public void setWindowIndex(int wizard) {
    }

    public boolean getDisplayTemplate() {
        ManagerWizardState wizardState = ManagerWizardState.getWizardState(session, 0);
        return (wizardState != null) && wizardState.hasDisplayTemplate();
        
    }
    
    public String getContactMail() {
        RequestType requestType = requestManager.getRequestType("eCitizen");

        return requestType.getCategory().getPrimaryEmail();
    }
    
}
