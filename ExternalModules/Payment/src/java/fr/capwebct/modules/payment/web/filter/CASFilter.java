package fr.capwebct.modules.payment.web.filter;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import edu.yale.its.tp.cas.client.*;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class CASFilter implements Filter {

    private static Log log = LogFactory.getLog(CASFilter.class);

    // Session attributes used by this filter

    /** <p>Session attribute in which the username is stored.</p> */
    public final static String CAS_FILTER_USER = "edu.yale.its.tp.cas.client.filter.user";

    /**
     * Session attribute in which the CASReceipt is stored.
     */
    public final static String CAS_FILTER_RECEIPT = "edu.yale.its.tp.cas.client.filter.receipt";

    /**
     * Session attribute in which internally used gateway
     * attribute is stored.
     */
    private static final String CAS_FILTER_GATEWAYED = "edu.yale.its.tp.cas.client.filter.didGateway";


    //*********************************************************************
    // Configuration state

    /** True if renew parameter should be set on login and validate */
    private boolean casRenew;

    /** True if this filter should wrap requests to expose authenticated user as getRemoteUser(); */
    private boolean wrapRequest;

    /** True if this filter should set gateway=true on login redirect */
    private boolean casGateway = false;

    private String localAuthority;
    private String loginUrl;
    private String logoutUrl;
    private String serverNames;
    private String validateUrl;
    private Set<String> serverNameList;
    
    //*********************************************************************
    // Initialization

    public void init() throws ServletException {
        log.debug("init() initializing filter 'CAS'");
        
        if (serverNames != null) {
               String[] names = serverNames.split("[, ;]+");
               serverNameList = new HashSet<String>();
               for (int i = 0; i < names.length; i++) {
                   serverNameList.add(names[i]);
               }
        }

        if (validateUrl == null){
            throw new ServletException("validateUrl parameter must be set.");
        }
        if (!validateUrl.startsWith("https://")){
            throw new ServletException("validateUrl must start with https://, its current value is [" 
                    + validateUrl + "]");
        }

        log.debug(("CASFilter initialized as: [" + toString() + "]"));
    }
    
    public void init(FilterConfig config) throws ServletException {
    }

    //*********************************************************************
    // Filter processing

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain fc)
        throws ServletException, IOException {

        log.debug("doFilter()");

        // make sure we've got an HTTP request
        if (!(request instanceof HttpServletRequest)
            || !(response instanceof HttpServletResponse)) {
            log.error("doFilter() called on a request or response that was not an HttpServletRequest or response.");
            throw new ServletException("CASFilter protects only HTTP resources");
        }

        HttpSession session = ((HttpServletRequest) request).getSession();

        // if our attribute's already present and valid, pass through the filter chain
        CASReceipt receipt = (CASReceipt) session.getAttribute(CAS_FILTER_RECEIPT);
        if (receipt != null && isReceiptAcceptable(receipt)) {
            log.debug("doFilter() CAS_FILTER_RECEIPT attribute was present and acceptable - passing  request through filter..");
            session.setAttribute("logoutUrl", logoutUrl);
            fc.doFilter(request, response);
            return;
        }

        // otherwise, we need to authenticate via CAS
        
        String ticket = request.getParameter("ticket");

        // no ticket?  abort request processing and redirect
        if (ticket == null || ticket.equals("")) {
            log.trace("CAS ticket was not present on request.");
            // did we go through the gateway already?
            boolean didGateway =
                Boolean.valueOf((String) session.getAttribute(CAS_FILTER_GATEWAYED));

            if (loginUrl == null) {
                //TODO: casLogin should probably be ensured to not be null at filter initialization. -awp9
                log.fatal("casLogin was not set, so filter cannot redirect request for authentication.");
                throw new ServletException(
                    "When CASFilter protects pages that do not receive a 'ticket' "
                        + "parameter, it needs a edu.yale.its.tp.cas.client.filter.loginUrl "
                        + "filter parameter");
            }
            if (!didGateway) {
                log.trace("Did not previously gateway.  Setting session attribute to true.");
                session.setAttribute(CAS_FILTER_GATEWAYED, "true");
                redirectToCAS((HttpServletRequest) request, 
                        (HttpServletResponse) response, localAuthority);
                // abort chain
                return;
            } else {
                log.trace("Previously gatewayed.");
                // if we should be logged in, make sure validation succeeded
                if (casGateway || session.getAttribute(CAS_FILTER_USER) != null) {
                    log.trace("casGateway was true and CAS_FILTER_USER set: passing request along filter chain.");
                    // continue processing the request
                    session.setAttribute("logoutUrl", logoutUrl);
                    fc.doFilter(request, response);
                    return;
                } else {
                    // unknown state... redirect to CAS
                    session.setAttribute(CAS_FILTER_GATEWAYED, "true");
                    redirectToCAS((HttpServletRequest) request, 
                            (HttpServletResponse) response, localAuthority);
                    // abort chain
                    return;
                }
            }
        }

        try {
            receipt = getAuthenticatedUser((HttpServletRequest) request);
        } catch (CASAuthenticationException e) {
            log.error(e);
            throw new ServletException(e);
        }

        if (!isReceiptAcceptable(receipt)){
            throw new ServletException("Authentication was technically successful but rejected as a matter of policy. [" + receipt + "]");
        }

        // Store the authenticated user in the session
        if (session != null) { // probably unnecessary
            session.setAttribute(CAS_FILTER_USER, receipt.getUserName());
            session.setAttribute(CASFilter.CAS_FILTER_RECEIPT, receipt);
            // don't store extra unnecessary session state
            session.removeAttribute(CAS_FILTER_GATEWAYED);
        }
        if (log.isTraceEnabled()){
            log.trace("validated ticket to get authenticated receipt [" + receipt 
                    + "], now passing request along filter chain.");
        }

        // continue processing the request
        session.setAttribute("logoutUrl", logoutUrl);
        fc.doFilter(request, response);
        log.trace("returning from doFilter()");
    }

    /**
     * Is this receipt acceptable as evidence of authentication by
     * credentials that would have been acceptable to this path?
     * Current implementation checks whether from renew and whether proxy
     * was authorized.
     * @param receipt
     * @return true if acceptable, false otherwise
     */
    private boolean isReceiptAcceptable(CASReceipt receipt) {
        if (receipt == null)
            throw new IllegalArgumentException("Cannot evaluate a null receipt.");
        if (this.casRenew && !receipt.isPrimaryAuthentication()){
            return false;
        }
        return true;
    }

    //*********************************************************************
    // Utility methods

    /**
     * Converts a ticket parameter to a CASReceipt, taking into account an
     * optionally configured trusted proxy in the tier immediately in front
     * of us.
     * @throws ServletException - when unable to get service for request
     * @throws CASAuthenticationException - on authentication failure
     */
    private CASReceipt getAuthenticatedUser(HttpServletRequest request)
        throws ServletException, CASAuthenticationException {
        log.trace("entering getAuthenticatedUser()");
        ProxyTicketValidator pv = null;

        pv = new ProxyTicketValidator();
        pv.setCasValidateUrl(validateUrl);
        pv.setServiceTicket(request.getParameter("ticket"));
        pv.setService(getService(request));
        pv.setRenew(Boolean.valueOf(casRenew).booleanValue());
        log.debug("about to validate ProxyTicketValidator: [" + pv + "]");

        return CASReceipt.getReceipt(pv);
    }

    /**
     * Returns either the configured service or figures it out for the current
     * request.  The returned service is URL-encoded.
     */
    private String getService(HttpServletRequest request)
        throws ServletException {

        log.trace("entering getService()");

        if (serverNameList == null)
            throw new ServletException("need the following configuration 'serverNames'");

        String serviceString = Util.getService(request, serverNameList);
        log.debug("getService() returning from getService() with service ["
                + serviceString + "]");
        return serviceString;
    }

    /**
     * Redirects the user to CAS, determining the service from the request.
     */
    private void redirectToCAS(HttpServletRequest request, HttpServletResponse response, 
            String localAuthorityName)
        throws IOException, ServletException {
        
        log.debug("redirectToCAS()");

        String casLoginString =
            loginUrl
                + "?service="
                + getService((HttpServletRequest) request)
                + ((casRenew) ? "&renew=true" : "")
                + (casGateway ? "&gateway=true" : "")
                + "&localAuthority=" + localAuthorityName;

        log.debug("Redirecting browser to [" + casLoginString + ")");
        ((HttpServletResponse) response).sendRedirect(casLoginString);

        log.debug("redirectToCAS() came back from CAS server !");
    }

    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("[CASFilter:");
        sb.append(" casGateway=");
        sb.append(this.casGateway);
        sb.append(" wrapRequest=");
        sb.append(this.wrapRequest);

        if (this.loginUrl != null) {
            sb.append(" loginUrl=[");
            sb.append(this.loginUrl);
            sb.append("]");
        } else {
            sb.append(" loginUrl=NULL!!!!!");
        }

        if (this.casRenew) {
            sb.append(" casRenew=true");
        }

        if (this.serverNames != null) {
            sb.append(" serverNames=[");
            sb.append(serverNames.toString());
            sb.append("]");
        }

        if (this.validateUrl != null) {
            sb.append(" validateUrl=[");
            sb.append(validateUrl);
            sb.append("]");
        } else {
            sb.append(" validateUrl=NULL!!!");
        }

        return sb.toString();
    }

    public void destroy() {
    }

    public void setLocalAuthority(String localAuthority) {
        this.localAuthority = localAuthority;
    }

    public void setLoginUrl(String loginUrl) {
        this.loginUrl = loginUrl;
    }

    public void setLogoutUrl(String logoutUrl) {
        this.logoutUrl = logoutUrl;
    }

    public void setServerNames(String serverNames) {
        this.serverNames = serverNames;
    }

    public void setValidateUrl(String validateUrl) {
        this.validateUrl = validateUrl;
    }
}
