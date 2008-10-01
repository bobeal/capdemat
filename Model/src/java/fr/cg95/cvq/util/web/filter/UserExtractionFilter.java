package fr.cg95.cvq.util.web.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.filter.GenericFilterBean;

import edu.yale.its.tp.cas.client.filter.CASFilter;
import fr.cg95.cvq.business.authority.Agent;
import fr.cg95.cvq.business.authority.SiteProfile;
import fr.cg95.cvq.business.authority.SiteRoles;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.exception.CvqObjectNotFoundException;
import fr.cg95.cvq.security.SecurityContext;
import fr.cg95.cvq.service.authority.IAgentService;

@Deprecated
public class UserExtractionFilter extends GenericFilterBean {

    private static Log log = LogFactory.getLog(UserExtractionFilter.class);

    public static final String USER_GROUPS = "user.groups";

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

            if (id.get("localAuthority") != null) {
                String localAuthority = id.get("localAuthority").get(0);
                if (!localAuthority.toLowerCase().equals(SecurityContext.getCurrentConfigurationBean().getName()))
                    throw new ServletException("User is not authorized to access to this local authority");
            } else {
                log.info("authenticate() no local authority information provided, don't checking");
            }
            
            WebApplicationContext wac = 
                WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
            List groups = (List) id.get("group");
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
            } catch (CvqException e) {
                e.printStackTrace();
                throw new ServletException("Error while setting agent in security context");
            }
        } else {
            // set current user in security context for him to be available for using webapps
            try {
                SecurityContext.setCurrentAgent(user);
            } catch (CvqException e) {
                e.printStackTrace();
                throw new ServletException("Error while setting agent in security context");
            }
        }

        fc.doFilter(request, response);
        log.debug("returning from doFilter()");
    }

    private void updateUserProfiles(WebApplicationContext wac, String username, List groups, 
                Map<String, String> informations)
            throws ServletException {

        IAgentService agentService = (IAgentService) wac.getBean("agentService");

        try {
            SecurityContext.setCurrentContext(SecurityContext.ADMIN_CONTEXT);
            
            Agent agent = null;
            try {
                agent = agentService.getByLogin(username);
            } catch (CvqObjectNotFoundException confe) {
                agent = new Agent();
                agent.setLogin(username);
                Set<SiteRoles> agentSiteRoles = new HashSet<SiteRoles>();
                SiteRoles defaultSiteRole = new SiteRoles();
                defaultSiteRole.setProfile(SiteProfile.AGENT);
                defaultSiteRole.setAgent(agent);
                agentSiteRoles.add(defaultSiteRole);
                agent.setSitesRoles(agentSiteRoles);

                agentService.create(agent);
            }

            if (informations.get("firstName") != null)
                agent.setFirstName(informations.get("firstName"));
            if (informations.get("lastName") != null)
                agent.setLastName(informations.get("lastName"));
            agentService.modify(agent);

            agentService.modifyProfiles(agent, groups, SecurityContext.getAdministratorGroups(),
                    SecurityContext.getAgentGroups(), SecurityContext.getCurrentSite());
            
        } catch (CvqException e) {
            logger.error("updateUserProfiles() unexpected CVQ exception while updating user profiles");
            e.printStackTrace();
            throw new ServletException("Unexpected CVQ exception while updating user profiles");
        } finally {
            try {
                SecurityContext.setCurrentContext(SecurityContext.BACK_OFFICE_CONTEXT);
            } catch (CvqException e) {
                // nothing useful we can do here
            }
        }
    }
}
