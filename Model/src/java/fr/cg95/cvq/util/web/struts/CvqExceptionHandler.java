package fr.cg95.cvq.util.web.struts;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.Globals;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ExceptionHandler;
import org.apache.struts.config.ExceptionConfig;
import org.apache.struts.util.ModuleException;

import fr.cg95.cvq.util.web.filter.CvqOpenSessionInViewFilter;

/**
 * @deprecated was used by existing Struts applications.
 *
 */
public class CvqExceptionHandler
    extends ExceptionHandler {

    static Logger logger = Logger.getLogger(CvqExceptionHandler.class);

    public ActionForward execute(Exception ex,
                                 ExceptionConfig ae,
                                 ActionMapping mapping,
                                 ActionForm formInstance,
                                 HttpServletRequest request,
                                 HttpServletResponse response)
        throws ServletException {

        logger.debug("execute() Got an exception to deal with : " + ex.getMessage());

        // TEMP
        ex.printStackTrace();

        ActionForward forward = null;
        ActionError error = null;
        String property = null;

        // Build the forward from the exception mapping if it exists
        // or from the form input
        if (ae.getPath() != null) {
            forward = new ActionForward(ae.getPath());
        } else {
            forward = mapping.getInputForward();
        }

        // Figure out the error
        if (ex instanceof ModuleException) {
            error = ((ModuleException) ex).getError();
            property = ((ModuleException) ex).getProperty();
        } else {
            error = new ActionError(ae.getKey(), ex.getMessage());
            property = error.getKey();
        }

        CvqOpenSessionInViewFilter.setRollbackTx(true);

        // Store the exception
        request.setAttribute(Globals.EXCEPTION_KEY, ex);
        storeException(request, property, error, forward, ae.getScope());

        logger.debug("execute() Forwarding to path : " + forward);
        return forward;
    }

}
