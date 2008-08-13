package fr.cg95.cvq.bo.dispatcher;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import edu.yale.its.tp.cas.client.filter.CASFilter;

/**
 * <p>A servlet handling logout requests from the current application</p>
 *
 * <p>The following initialization parameter must be declared in 
 * <code>web.xml</code>:</p>
 *
 * <ul>
 *   <li><code>edu.yale.its.tp.cas.client.servlet.logoutUrl</code>: URL to 
 *   logout page on CAS server.</li>
 * </ul>
 *
 * @author Benoit Orihuela (bobeal@zenexity.fr)
 */
public class CASLogoutServlet extends HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1880396783374750393L;

	/**
     * The name of the servlet initialization parameter the value of which
     * should be the URL whereat CAS waits for logout requests. 
     * If this servlet parameter is not set, this servlet will throw an
     * exception.
     */
    public static final String CAS_LOGOUTURL_INIT_PARAM = "edu.yale.its.tp.cas.client.servlet.logoutUrl";

    private static final Log log = LogFactory.getLog(CASLogoutServlet.class);

    /**
     * The URL whereat CAS waits for logout requests.
     */
    private String casLogoutUrl;

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        if (log.isTraceEnabled()) {
            log.trace("entering init(" + config + ")");
        }

        // first try to get the proxy URL as a filter initialization parameter
        this.casLogoutUrl = config.getInitParameter(CAS_LOGOUTURL_INIT_PARAM);

        if (this.casLogoutUrl == null) {
	    throw new ServletException("The servlet initialization parameter "
				       + CAS_LOGOUTURL_INIT_PARAM
				       + " must be set.");
        }
        if (!this.casLogoutUrl.toUpperCase().startsWith("HTTPS:")) {
            throw new ServletException(
                    "Initialization parameter "
                            + CAS_LOGOUTURL_INIT_PARAM
                            + " must specify an https: address; its current, unacceptable value is ["
                            + this.casLogoutUrl + "]");
        }
        if (log.isTraceEnabled()){
            log.trace("returning from init() having configured a logout servlet as [" + this + "]");
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        if (log.isTraceEnabled()){
            log.trace("doGet() removing user's session attributes");
        }
	HttpSession session = request.getSession();
	session.removeAttribute(CASFilter.CAS_FILTER_USER);
	session.removeAttribute(CASFilter.CAS_FILTER_RECEIPT);
    
    session.invalidate();
	// redirect to CAS logout URL
	response.sendRedirect(casLogoutUrl);
    }

    public String toString(){
        StringBuffer sb = new StringBuffer();
        sb.append(this.getClass().getName());
        sb.append(" ");
        sb.append("casLogoutUrl=[");
        sb.append(this.casLogoutUrl);
        sb.append("]");
        return sb.toString();
    }
}
