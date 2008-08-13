package fr.capwebct.modules.payment.web.filter;

import edu.yale.its.tp.cas.client.filter.CASFilter;
import fr.capwebct.modules.payment.business.Agent;
import fr.capwebct.modules.payment.exception.CpmObjectNotFoundException;
import fr.capwebct.modules.payment.security.SecurityContext;
import fr.capwebct.modules.payment.service.IAgentService;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.*;
import javax.servlet.http.*;

import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class UserExtractionFilter extends GenericFilterBean {

    public static String IS_ADMIN = "isAdmin";
    public static String USERNAME = "username";
    
    private static Log log = LogFactory.getLog(UserExtractionFilter.class);

    public UserExtractionFilter() {
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain fc)
            throws ServletException, IOException {

        // make sure we've got an HTTP request
        if (!(request instanceof HttpServletRequest) || !(response instanceof HttpServletResponse)) {
            log.error("doFilter() called on a request or response that was not an HttpServletRequest or response.");
            throw new ServletException("UserExtractionFilter only deals with HTTP resources");
        }

        HttpSession session = ((HttpServletRequest) request).getSession();
        String user = (String) session.getAttribute(CASFilter.CAS_FILTER_USER);
        log.debug("doFilter() received user information : " + user);
        if ((user != null) && (user.indexOf(";") != -1)) {

            // we are receiving a chain with user and groups information
            Map<String, ArrayList<String>> id = new HashMap<String, ArrayList<String>>();
            String[] splitted = user.split(";");
            for (int i = 0; i < splitted.length; i++) {
                String token = splitted[i];
                if (token.indexOf("=") != -1) {
                    String[] keyVal = token.split("=");
                    String key = keyVal[0];
                    String value = keyVal[1];
                    if (!id.containsKey(key))
                        id.put(key, new ArrayList<String>());
                    id.get(key).add(value);
                }
            }
            if (!id.containsKey("username"))
                throw new ServletException("No username parameter found");
            user = id.get("username").get(0);

            WebApplicationContext wac = 
                WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
            List<String> groups = id.get("group");
            if (groups == null || !SecurityContext.isAuthorizedGroup(groups))
                throw new ServletException("User " + user
                        + " is not authorized to access this resource");

            Map<String, String> userInformations = new HashMap<String, String>();
            if (id.get("firstName") != null)
                userInformations.put("firstName", id.get("firstName").get(0));
            if (id.get("lastName") != null)
                userInformations.put("lastName", id.get("lastName").get(0));
            updateUserProfiles(wac, user, groups, userInformations);

            try {
                SecurityContext.setCurrentAgent(user);
                log.debug("setting " + user + " on attribute " + CASFilter.CAS_FILTER_USER);
                session.setAttribute(CASFilter.CAS_FILTER_USER, user);
                if (SecurityContext.isOfAnAdminGroup(groups))
                    session.setAttribute(IS_ADMIN, "true");
                if (id.get("firstName") != null && id.get("lastName") != null)
                    session.setAttribute(USERNAME, 
                            id.get("firstName").get(0) + " " + id.get("lastName").get(0));
                else
                    session.setAttribute("username", user);
            } catch (CpmObjectNotFoundException e) {
                e.printStackTrace();
                throw new ServletException("Error while setting agent in security context");
            }
        } else {
            // set current user in security context for him to be available for using webapps
            try {
                SecurityContext.setCurrentAgent(user);
            } catch (CpmObjectNotFoundException e) {
                e.printStackTrace();
                throw new ServletException("Error while setting agent in security context");
            }
        }

        fc.doFilter(request, response);
        log.debug("returning from doFilter()");
    }

    private void updateUserProfiles(WebApplicationContext wac, String username, 
            List<String> groups, Map<String, String> informations)
            throws ServletException {

        IAgentService agentService = (IAgentService) wac.getBean("agentService");

        Agent agent = agentService.getAgentByLogin(username);
        if (agent == null) {
            agent = new Agent();
            agent.setLogin(username);
            agentService.saveAgent(agent);
        }
        
        if (informations.get("firstName") != null)
            agent.setFirstName(informations.get("firstName"));
        if (informations.get("lastName") != null)
            agent.setLastName(informations.get("lastName"));
        agentService.modifyAgent(agent);

        agentService.updateProfile(agent, groups);
    }
}
