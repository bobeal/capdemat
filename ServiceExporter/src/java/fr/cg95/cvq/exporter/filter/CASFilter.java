package fr.cg95.cvq.exporter.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.filter.GenericFilterBean;

import edu.yale.its.tp.cas.client.ProxyTicketValidator;

public class CASFilter extends GenericFilterBean {

    private static Log log = LogFactory.getLog(CASFilter.class);

    private String validateUrl;
    private String serverNames;
    private List<String> serverNamesList;
    private List<String> authorizedProxies;

    public CASFilter() {
        addRequiredProperty("validateUrl");
        addRequiredProperty("serverNames");
        addRequiredProperty("authorizedProxies");
    }

    @Override
    protected void initFilterBean() {
        serverNamesList = new ArrayList<String>();
        for (String serverName : serverNames.split(","))
            serverNamesList.add(serverName);
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain fc)
        throws ServletException, IOException {

        log.debug("entering doFilter()");

        // make sure we've got an HTTP request
        if (!(request instanceof HttpServletRequest)
            || !(response instanceof HttpServletResponse)) {
            log.error("doFilter() called on a request or response that was not an HttpServletRequest or response.");
            throw new ServletException("CASFilter protects only HTTP resources");
        }

        ProxyTicketValidator pv = new ProxyTicketValidator();
        pv.setCasValidateUrl(validateUrl);
        // check server name against configured list
        String serverName = request.getServerName() + ":" + request.getServerPort();
        log.debug("doFilter() comparing " + serverName + " with authorized servers");
        if (!serverNamesList.contains(serverName))
            throw new ServletException("Not allowed to validate tickets for server "
                                       + request.getServerName() + ":" + request.getServerPort());
        pv.setService(serverName);
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        String ticketHeader = httpRequest.getHeader("ticket");
        log.debug("doFilter() received ticket header : " + ticketHeader);
        pv.setServiceTicket(ticketHeader);

        // contact CAS and validate
        try {
            pv.validate();
        } catch (Exception e) {
            log.error("Error parsing validation response");
            e.printStackTrace();
            throw new ServletException();
        }

        if (!pv.isAuthenticationSuccesful()) {
            String errorCode = pv.getErrorCode();
            String errorMessage = pv.getErrorMessage();
            log.error("Error code : " + errorCode);
            log.error("Error message : " + errorMessage);
            throw new ServletException();
        }

        // check proxy service is really authorized
        if (!authorizedProxies.contains(pv.getProxyList().get(0)))
            throw new ServletException("Proxy service " + pv.getProxyList().get(0)
                                       + " not allowed to proxy for us");

        String user = pv.getUser();
        httpRequest.getSession().setAttribute(edu.yale.its.tp.cas.client.filter.CASFilter.CAS_FILTER_USER, user);
        
        fc.doFilter(request, response);
        log.debug("returning from doFilter()");
    }


    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("[CASFilter:");

        sb.append(" casAuthorizedProxies=[");
        sb.append(this.authorizedProxies);
        sb.append("]");

        if (this.serverNames != null) {
            sb.append(" casServerNames=[");
            sb.append(serverNames);
            sb.append("]");
        }

        if (this.validateUrl != null) {
            sb.append(" casValidate=[");
            sb.append(validateUrl);
            sb.append("]");
        } else {
            sb.append(" casValidate=NULL!!!");
        }

        return sb.toString();
    }

    public void setValidateUrl(String validateUrl) {
        this.validateUrl = validateUrl;
    }

    public void setServerNames(String serverNames) {
        this.serverNames = serverNames;
    }

    public void setAuthorizedProxies(List<String> authorizedProxies) {
        this.authorizedProxies = authorizedProxies;
    }
}
