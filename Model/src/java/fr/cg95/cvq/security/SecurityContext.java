package fr.cg95.cvq.security;

import java.util.List;
import java.util.Locale;

import org.apache.log4j.Logger;

import fr.cg95.cvq.business.authority.Agent;
import fr.cg95.cvq.business.authority.LocalAuthority;
import fr.cg95.cvq.business.users.Adult;
import fr.cg95.cvq.business.users.Child;
import fr.cg95.cvq.business.users.Individual;
import fr.cg95.cvq.dao.authority.IAgentDAO;
import fr.cg95.cvq.dao.users.IAdultDAO;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.exception.CvqObjectNotFoundException;
import fr.cg95.cvq.service.authority.ILocalAuthorityRegistry;
import fr.cg95.cvq.service.authority.LocalAuthorityConfigurationBean;

/**
 * A manager for the notions of "current everything" that
 * pertain to security. Here we store the current
 * {@link fr.cg95.cvq.business.authority.Agent}, the
 * current {@link fr.cg95.cvq.business.authority.LocalAuthority}, etc.
 *
 * @author dom@idealx.com
 * @author bor@zenexity.fr
 */
public class SecurityContext {

    private static Logger logger = Logger.getLogger(SecurityContext.class);

    public static final String BACK_OFFICE_CONTEXT = "backOffice";
    public static final String FRONT_OFFICE_CONTEXT = "frontOffice";
    public static final String ADMIN_CONTEXT = "adminContext";

    private static ILocalAuthorityRegistry localAuthorityRegistry;
    private static IAgentDAO agentDAO;
    private static IAdultDAO adultDAO;
    private static List administratorGroups;
    private static List agentGroups;

    private static ThreadLocal<CredentialBean> currentContextThreadLocal = 
        new ThreadLocal<CredentialBean>();
    
    /**
     * Return whether one of the group in the given list permits access to the Back Office.
     */
    public static boolean isAuthorizedGroup(List groupList) {
        for (int i = 0; i < groupList.size(); i++) {
            String group = (String) groupList.get(i);
            if (administratorGroups.contains(group) || agentGroups.contains(group))
                return true;
        }

        return false;
    }

    /**
     * Return whether at least one of the provided group is within the list of administrator
     * groups. 
     */
    public static boolean isOfAnAdminGroup(List groupList) {
        
        if (administratorGroups != null && administratorGroups.size() > 0) {
            for (int i = 0; i < groupList.size(); i++) {
                String group = (String) groupList.get(i);
                if (administratorGroups.contains(group)) {
                    return true;
                }
            }
        }

        return false;
    }
    
    /**
     * Return whether at least one of the provided group is within the list of agent
     * groups.
     */
    public static boolean isOfAnAgentGroup(List groupList) {
        
        if (agentGroups != null && agentGroups.size() > 0) {
            for (int i = 0; i < groupList.size(); i++) {
                String group = (String) groupList.get(i);
                if (agentGroups.contains(group)) {
                    return true;
                }
            }
        }

        return false;
    }
    
    public static List getAdministratorGroups() {
        return administratorGroups;
    }
    
    public static List getAgentGroups() {
        return agentGroups;
    }
    

    /**
     * Return the user we are talking to (from the WWW session), or
     * null if we are not in a WWW or other user-driven context.
     *
     * @throws CvqException if security context is not initialized or if no agent is set in it
     *  or if it is not in the {@link #BACK_OFFICE_CONTEXT back office context}.
     */
    public static Agent getCurrentAgent() throws CvqException {
		CredentialBean credentialBean = (CredentialBean) currentContextThreadLocal.get();
		if (credentialBean == null)
            throw new CvqException("No user yet in security context");

        if (!credentialBean.isBoContext())
            throw new CvqException("Agent only exists in Back Office context");

        return credentialBean.getAgent();
    }

    /**
     * Set the current agent. Can only be called after the current
     * local authority is set with {@link #setCurrentSite}.
     */
    public static void setCurrentAgent(Agent agent)
        throws CvqException {

        logger.debug("setCurrentAgent() agent = " + agent);

		CredentialBean credentialBean = (CredentialBean) currentContextThreadLocal.get();
		if (credentialBean == null)
			throw new CvqException("setCurrentSite() has to be called before setCurrentAgent()");

        if (!credentialBean.isBoContext())
            throw new CvqException("Agent can only be set in Back Office context");

        credentialBean.setAgent(agent);
    }

    /**
     * @see #setCurrentAgent(Agent)
     */
    public static void setCurrentAgent(String agentLogin)
        throws CvqException, CvqObjectNotFoundException {

        logger.debug("setCurrentAgent() agent = " + agentLogin);
        Agent agent = agentDAO.findByLogin(agentLogin);
        if (agent == null)
            throw new CvqObjectNotFoundException("Agent not found !");
        setCurrentAgent(agent);
    }

    /**
     * Return the user we are talking to (from the WWW session), or
     * null if we are not in a WWW or other user-driven context.
     *
     * @throws CvqException if security context is not initialized or if no ecitizen is set in it
     *  or if it is not in the {@link #FRONT_OFFICE_CONTEXT front office context}.
     */
    public static Adult getCurrentEcitizen() throws CvqException {
		CredentialBean credentialBean = (CredentialBean) currentContextThreadLocal.get();
		if (credentialBean == null)
            throw new CvqException("No user yet in security context");

		if (!credentialBean.isFoContext())
			throw new CvqException("E-citizen only exists in Front Office context");

		return credentialBean.getEcitizen();
    }

    /**
     * Set the current ecitizen. Can only be called after the current
     * local authority is set with {@link #setCurrentSite}.
     */
    public static void setCurrentEcitizen(Adult adult)
        throws CvqException {

        logger.debug("setCurrentEcitizen() adult = " + adult);
        
		CredentialBean credentialBean = (CredentialBean) currentContextThreadLocal.get();
		if (credentialBean == null)
            throw new CvqException("setCurrentSite() has to be called before setCurrentEcitizen()");

        if (!credentialBean.isFoContext())
            throw new CvqException("Adult can only be set in Front Office context");
        
        credentialBean.setEcitizen(adult);
    }

    /**
     * @see #setCurrentEcitizen(Adult)
     */
    public static void setCurrentEcitizen(String ecitizenLogin)
        throws CvqException, CvqObjectNotFoundException {

        logger.debug("setCurrentEcitizen() ecitizen = " + ecitizenLogin);
        Individual individual = adultDAO.findByLogin(ecitizenLogin);
        if (individual instanceof Child || individual == null)
            throw new CvqObjectNotFoundException("Adult not found !");
        setCurrentEcitizen((Adult) individual);
    }

    public static String getCurrentExternalService() throws CvqException {
        CredentialBean credentialBean = (CredentialBean) currentContextThreadLocal.get();
        if (credentialBean == null)
            throw new CvqException("No user yet in security context");

        if (!credentialBean.isBoContext())
            throw new CvqException("External service only exists in Back Office context");

        return credentialBean.getExternalService();
    }

    public static void setCurrentExternalService(String externalService) throws CvqException {
        CredentialBean credentialBean = (CredentialBean) currentContextThreadLocal.get();
        if (credentialBean == null)
            throw new CvqException("setCurrentSite() has to be called before setCurrentEcitizen()");

        if (!credentialBean.isBoContext())
            throw new CvqException("External service can only be set in Back Office context");
        
        credentialBean.setExternalService(externalService);
    }

    /**
     * Return the login of the current user ("administrator" if admin context, 
     * whether it is an agent or an e-citizen.
     *
     * @throws CvqException if security context is not initialized
     */
    public static String getCurrentUserLogin() throws CvqException {

        CredentialBean credentialBean = (CredentialBean) currentContextThreadLocal.get();
        if (credentialBean == null)
            throw new CvqException("No user yet in security context");

        if (credentialBean.isFoContext()) {
            return credentialBean.getEcitizen() == null ? "" : credentialBean.getEcitizen().getLogin();
        } else if (credentialBean.isBoContext()) {
            return credentialBean.getAgent() == null ? "" : credentialBean.getAgent().getLogin();
        } else {
            return "administrator";
        }
    }

    /**
     * Return the id of the current user (-1 if admin context), whether it is an agent 
     * or an e-citizen.
     *
     * @throws CvqException if security context is not initialized
     */
    public static Long getCurrentUserId() throws CvqException {

        CredentialBean credentialBean = (CredentialBean) currentContextThreadLocal.get();
        if (credentialBean == null)
            throw new CvqException("No user yet in security context");

        if (credentialBean.isFoContext()) {
            return credentialBean.getEcitizen() == null ? null : credentialBean.getEcitizen().getId();
        } else if (credentialBean.isBoContext()) {
            return credentialBean.getAgent() == null ? null : credentialBean.getAgent().getId();
        } else {
            return Long.valueOf("-1");
        }
    }
    
    /**
     * Return the current context for this thread or null if security context is not set.
     *
     * @see #BACK_OFFICE_CONTEXT
     * @see #FRONT_OFFICE_CONTEXT
     * @see #ADMIN_CONTEXT
     */
    public static String getCurrentContext() {
		CredentialBean credentialBean = (CredentialBean) currentContextThreadLocal.get();
		if (credentialBean == null)
			return null;
		else if (credentialBean.isBoContext())
			return BACK_OFFICE_CONTEXT;
		else if (credentialBean.isFoContext())
			return FRONT_OFFICE_CONTEXT;
		else if (credentialBean.isAdminContext())
			return ADMIN_CONTEXT;
		
		return null;
    }

    public static void setCurrentContext(final String context)
    		throws CvqException {
		CredentialBean credentialBean = (CredentialBean) currentContextThreadLocal.get();
		if (credentialBean == null)
			throw new CvqException("Context cannot be changed if not set");
		else
			credentialBean.setContext(context);
    }
    
    
    /**
     * Return the current local authority for this thread or null if security context is not set.
     */
    public static LocalAuthority getCurrentSite() {
		CredentialBean credentialBean = (CredentialBean) currentContextThreadLocal.get();
		if (credentialBean == null)
			return null;
		else
			return credentialBean.getSite();
    }

    /**
     * Set the current local authority. To be called by a sort of multi-site listener.
     *
     * @param context the context to set, as defined by
     *  {@link #BACK_OFFICE_CONTEXT}, {@link #FRONT_OFFICE_CONTEXT} and {@link #ADMIN_CONTEXT}
     */
    public static void setCurrentSite(String localAuthorityName, String context)
        throws CvqObjectNotFoundException {

        logger.debug("setCurrentSite() site name = [" + localAuthorityName + "]");

        LocalAuthority localAuthority = 
            localAuthorityRegistry.getLocalAuthorityByName(localAuthorityName);
        if (localAuthority == null) {
            logger.error("setCurrentSite() local authority " + localAuthorityName + " not found in DB");
            throw new CvqObjectNotFoundException("local authority " + localAuthorityName + " not found in DB");
        }
        CredentialBean credentialBean = new CredentialBean(localAuthority, context);
        currentContextThreadLocal.set(credentialBean);
    }

    /**
     * Reset the current security context. To be called at the end of the transaction.
     */
    public static void resetCurrentSite() {
        logger.debug("resetCurrentSite()");
        currentContextThreadLocal.set(null);
    }

    public static void setCurrentLocale(Locale locale) throws CvqException {
        logger.debug("setCurrentLocale() locale = " + locale);
        
        CredentialBean credentialBean = (CredentialBean) currentContextThreadLocal.get();
        if (credentialBean == null)
            throw new CvqException("setCurrentSite() has to be called before setCurrentLocale()");

        credentialBean.setLocale(locale);
    }

    /**
     * Return the locale for the current thread.
     */
    public static Locale getCurrentLocale() throws CvqException {

        CredentialBean credentialBean = (CredentialBean) currentContextThreadLocal.get();
        if (credentialBean == null)
            throw new CvqException("No locale yet in security context");

        return credentialBean.getLocale();
    }
    
    /**
     * Return the configuration bean for the current thread.
     */
    public static LocalAuthorityConfigurationBean getCurrentConfigurationBean() {
        CredentialBean credentialBean = (CredentialBean) currentContextThreadLocal.get();
        if (credentialBean == null)
            return null;
        String localAuthorityName = credentialBean.getSite().getName();
        return (LocalAuthorityConfigurationBean) localAuthorityRegistry.getLocalAuthorityBeanByName(localAuthorityName);
    }

    /**
     * Returns the current CredentialBean. Only available to the
     * {@link fr.cg95.cvq.security} package, and then only when both
     * {@link #setCurrentSite} and {@link #setCurrentEcitizen} have been
     * called first.
     *
     * @return null if any of the above two conditions is not met. In this
     * mode, the only accesses the security package will allow is read
     * access on the Users and Sites themselves (in order to bootstrap
     * the CredentialBean).
     */
    public static CredentialBean getCurrentCredentialBean() {
		CredentialBean credentialBean = (CredentialBean) currentContextThreadLocal.get();
		if (credentialBean == null)
			return null;
		else
			return credentialBean;
    }

    public static boolean isBackOfficeContext() {
        CredentialBean credentialBean = (CredentialBean) currentContextThreadLocal.get();
        if (credentialBean == null)
            return false;
        else if (credentialBean.isBoContext())
            return true;
        else 
            return false;
    }

    public static boolean isAdminContext() {
        CredentialBean credentialBean = (CredentialBean) currentContextThreadLocal.get();
        if (credentialBean == null)
            return false;
        else if (credentialBean.isAdminContext())
            return true;
        else 
            return false;
    }

    public static boolean isFrontOfficeContext() {
        CredentialBean credentialBean = (CredentialBean) currentContextThreadLocal.get();
        if (credentialBean == null)
            return false;
        else if (credentialBean.isFoContext())
            return true;
        else 
            return false;        
    }
    
    public void setLocalAuthorityRegistry(ILocalAuthorityRegistry iLocalAuthorityRegistry) {
        localAuthorityRegistry = iLocalAuthorityRegistry;
    }

    public void setAgentDAO(IAgentDAO iAgentDAO) {
        agentDAO = iAgentDAO;
    }

    public void setAdultDAO(IAdultDAO iAdultDAO) {
        adultDAO = iAdultDAO;
    }

	public void setAdministratorGroups(List administratorGroupsToSet) {
		administratorGroups = administratorGroupsToSet;
	}

	public void setAgentGroups(List agentGroupsToSet) {
		agentGroups = agentGroupsToSet;
	}
}
