import fr.cg95.cvq.business.authority.LocalAuthority;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.exception.CvqObjectNotFoundException;
import fr.cg95.cvq.security.SecurityContext;
import fr.cg95.cvq.service.authority.IAgentService
import fr.cg95.cvq.service.authority.ILocalAuthorityRegistry
import fr.cg95.cvq.service.authority.LocalAuthorityConfigurationBean
import fr.cg95.cvq.dao.hibernate.HibernateUtil
import fr.cg95.cvq.util.web.filter.CASFilter

import edu.yale.its.tp.cas.client.CASReceipt
import edu.yale.its.tp.cas.client.ProxyTicketValidator
import edu.yale.its.tp.cas.client.CASAuthenticationException

import javax.servlet.ServletException

import org.hibernate.SessionFactory

class SessionFilters {
    
    def filters = {
        
        openSessionInView(controller: '*', action: '*') {
            before = {
                ILocalAuthorityRegistry localAuthorityRegistry =
                applicationContext.getBean("localAuthorityRegistry")
                LocalAuthority la = localAuthorityRegistry.getLocalAuthorityByServerName(request.serverName)
                if (la == null)
                    throw new ServletException("No local authority found !")
                LocalAuthorityConfigurationBean lacb =
                    localAuthorityRegistry.getLocalAuthorityBeanByName(la.name)
                if (lacb == null)
                    throw new ServletException("No local authority found !")
                SessionFactory sessionFactory = lacb.getSessionFactory()
                HibernateUtil.setSessionFactory(sessionFactory)

                HibernateUtil.beginTransaction()

                try {
                    SecurityContext.setCurrentSite(la.name,
                        SecurityContext.BACK_OFFICE_CONTEXT)
                    SecurityContext.setCurrentLocale(request.getLocale())
                } catch (CvqException ce) {
                    ce.printStackTrace()
                    throw new ServletException()
                }

                session.setAttribute("currentSiteName", la.name.toLowerCase())
                session.setAttribute("currentSiteDisplayTitle", la.displayTitle)
                session.setAttribute("supportsActivitiesTab", lacb.supportsActivitiesTab())
                session.setAttribute("supportsPaymentsTab", lacb.supportsPaymentsTab())
                session.setAttribute("doRollback", false)
            }
            after = {
                def doRollback = session.getAttribute("doRollback")
                if (doRollback)
                    HibernateUtil.rollbackTransaction();
                else
                    HibernateUtil.commitTransaction();
                // No matter what happens, close the Session.
                HibernateUtil.closeSession();

                SecurityContext.resetCurrentSite();
            }
        }
        
        setupFrontUser(controller: 'frontoffice*', action: '*') {
            before = {
                def securityService = applicationContext.getBean("securityService")
                def point = securityService.defineAccessPoint(session.frontContext,controllerName,actionName)
                
                try {
                    SecurityContext.setCurrentContext(SecurityContext.FRONT_OFFICE_CONTEXT)
                    
                    if((point.controller == controllerName && point.action != actionName) || 
                        (point.controller != controllerName)) {
                        if(point.action) redirect(controller: point.controller, action: point.action)
                        else redirect(controller: point.controller)
                        return false
                    } else if (session.currentEcitizen) { 
                        SecurityContext.setCurrentEcitizen(session.currentEcitizen)
                    }
                } catch (CvqObjectNotFoundException ce) {
                    session.currentEcitizen = null
                    redirect(controller: 'frontofficeHome', action: 'login')
                    return false
                } catch (CvqException ce) {
                    if (session.currentEcitizen) session.currentEcitizen = null
                    ce.printStackTrace()
                    throw new ServletException()
                }
            }
        }

        userExtraction(controller: 'backoffice*', action: '*') {
            before = {
            		
                CASReceipt receipt = (CASReceipt) session.getAttribute(CASFilter.CAS_FILTER_RECEIPT);
                String ticket = request.getParameter("ticket")

                if (receipt == null && ticket == null) {
                	// TODO : did gateway support
                	
                    if (org.codehaus.groovy.grails.commons.ConfigurationHolder.config.cas_mocking == 'true') {
                    	response.sendRedirect('/BackOfficeNG/cas.gsp')
                    	return false
                    } else {
                    	def redirectUrl =
                    	  "${org.codehaus.groovy.grails.commons.ConfigurationHolder.config.cas_login_url}?localAuthority=${session.getAttribute('currentSiteName')}&service=https://${request.serverName}${request.forwardURI}"
                      	println "non mock configuration : redirecting to ${redirectUrl}"
                      	response.sendRedirect(redirectUrl)
                      	return false
                    }
                }

                if (ticket != null) {
                	try {
                		ProxyTicketValidator pv = null;
                		pv = new ProxyTicketValidator()
                		pv.setCasValidateUrl(org.codehaus.groovy.grails.commons.ConfigurationHolder.config.cas_validate_url)
                		pv.setServiceTicket(ticket)
                		pv.setService("https://${request.serverName}${request.forwardURI}")
                		pv.setRenew(false)
                		receipt = CASReceipt.getReceipt(pv)

                		session.setAttribute(CASFilter.CAS_FILTER_USER, receipt.getUserName())
                		session.setAttribute(CASFilter.CAS_FILTER_RECEIPT, receipt)

                	} catch (CASAuthenticationException e) {
                		throw new ServletException(e)
                	}
                }
                
                String user = (String) session.getAttribute(CASFilter.CAS_FILTER_USER)
                if (user != null && user.indexOf(";") != -1) {

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

                    List groups = (List) id.get("group");
                    if (groups == null || !SecurityContext.isAuthorizedGroup(groups))
                        throw new ServletException("User " + user
                                + " is not authorized to access this resource");

                    Map<String, String> userInformations = new HashMap<String, String>();
                    if (id.get("firstName") != null)
                        userInformations.put("firstName", id.get("firstName").get(0));
                    if (id.get("lastName") != null)
                        userInformations.put("lastName", id.get("lastName").get(0));

                    try {
                        SecurityContext.setCurrentContext(SecurityContext.ADMIN_CONTEXT);
                        IAgentService agentService = applicationContext.getBean("agentService")
                        agentService.updateUserProfiles(user, groups, userInformations);

                        SecurityContext.setCurrentContext(SecurityContext.BACK_OFFICE_CONTEXT)
                        SecurityContext.setCurrentAgent(user)
                        session.setAttribute("currentUser", user)
                        session.setAttribute("currentCredentialBean", SecurityContext.currentCredentialBean)
                        log.debug("setting " + user + " on attribute " + CASFilter.CAS_FILTER_USER)
                        session.setAttribute(CASFilter.CAS_FILTER_USER, user)
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
            }
        }
    }
}
