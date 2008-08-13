package fr.cg95.cvq.fo.common.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import fr.cg95.cvq.business.users.Adult;
import fr.cg95.cvq.business.users.HomeFolder;
import fr.cg95.cvq.exception.CvqAuthenticationFailedException;
import fr.cg95.cvq.exception.CvqBadPasswordException;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.exception.CvqUnknownUserException;
import fr.cg95.cvq.fo.business.BusinessManager;
import fr.cg95.cvq.fo.business.BusinessObjectFactory;
import fr.cg95.cvq.fo.common.FamilyHome;
import fr.cg95.cvq.fo.common.Request;
import fr.cg95.cvq.fo.common.form.LoginForm;
import fr.cg95.cvq.fo.dispatcher.SessionManager;
import fr.cg95.cvq.fo.personal.action.login.LoginAction;

public class LoginProcessAction extends BaseXmlAction {

    private static Logger _logger = Logger.getLogger(LoginAction.class);

    public ActionForward doExecute(
        ActionMapping mapping,
        ActionForm form,
        HttpServletRequest request,
        HttpServletResponse response)
        throws Exception {

        // save the process name for future use
        request.setAttribute("name",request.getParameter("name"));

        FamilyHome familyHome = SessionManager.getFamilyHome(request);
        if (familyHome == null) {
            familyHome = new FamilyHome(request.getSession());
            request.getSession().setAttribute(FamilyHome.SESSION_NAME, familyHome);
        }
        LoginForm login = (LoginForm) form;

        _logger.debug("doExecute");

        if ((login.getUserName() != null) && (login.getUserName().length() > 0) &&
            (login.getPassword() != null) && (login.getPassword().length() > 0)) try {
            // get the login from the form
            getLoginContents(login);
            
            if ((login.getMethod() != null) && login.getMethod().equals("reset")) {
                if ((login.getQuestion() == null) || (login.getAcknowledge() == null)) {
                    request.getSession().setAttribute(LOGIN_ERROR_KEY, NOT_ACCOUNT_MANAGER);
                } else {
                    familyHome.setLogin(login);
                    request.setAttribute("loginForm", login);
                    request.setAttribute("ResetPassword", "");
                }
                return mapping.findForward("reset"); 
            }
    
            // remove the session attribute
            request.getSession().removeAttribute(LOGIN_ERROR_KEY);

            HomeFolder authHome = null;

            if (familyHome.getId() != null) {
                authHome = BusinessManager.getInstance().findFamilyHomeById(familyHome.getId());
                
                // get the family home by authentication
            } else {
                authHome =
                    BusinessManager.getInstance().getAuthenticationService().authenticate(
                        login.getUserName(),
                        login.getPassword());
            }

//            SecurityContext.setCurrentEcitizen(login.getUserName());
//
            // set the family home object from the facade
            // into family home form
            BusinessObjectFactory.setFamilyHomeForm(authHome, familyHome);

            // set the login form
            request.getSession().setAttribute(BaseAction.AUTHENTIFICATION, login);

            Request cvqRequest = (Request)request.getSession().getAttribute(Request.class.getName());

            cvqRequest.setNoRequester(false);
            
            request.setAttribute("loginForm", login);
            
            initialiseProcess(servlet, request, response);

        } catch (CvqUnknownUserException e) {

            _logger.debug("Login Exception:" + e.getMessage());
            // set the error login message in the session
            request.getSession().setAttribute(LOGIN_ERROR_KEY, BAD_USER_VALUE);

        } catch (CvqBadPasswordException e) {
            _logger.debug("Login Exception:" + e.getMessage());
            // set the error password message in the session
            request.getSession().setAttribute(LOGIN_ERROR_KEY, WRONG_PASSWORD_VALUE);

        } catch (CvqAuthenticationFailedException e) {
            _logger.debug("Login Exception:" + e.getMessage());
            // set the error password message in the session
            request.getSession().setAttribute(LOGIN_ERROR_KEY, AUTHENTICATION_FAILED_VALUE);

        } catch (CvqException e) {

            _logger.debug("Login Exception:" + e.getMessage());
            // set the error login message in the session
            request.getSession().setAttribute(LOGIN_ERROR_KEY, BAD_USER_VALUE);

            login.setPassword(null);            

        } else {
            request.getSession().setAttribute(LOGIN_ERROR_KEY, AUTHENTICATION_FAILED_VALUE);
        }
        return mapping.findForward("presentation");
    }
    
    private void getLoginContents(LoginForm loginForm) throws CvqException, CvqException {
        if (loginForm.getCertificate() == null) {
            Adult adult = (Adult)BusinessManager.getInstance().getIndividualService().getByLogin(loginForm.getUserName().toLowerCase());
            if (adult == null)
                throw new CvqException();
                 
            loginForm.setQuestion(adult.getQuestion());
            loginForm.setAcknowledge(adult.getAnswer());
            loginForm.setAdultId(adult.getId());
        }           
    }

}
