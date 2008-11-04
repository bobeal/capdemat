package fr.cg95.cvq.security;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

import org.apache.log4j.Logger;

import fr.cg95.cvq.business.authority.Agent;
import fr.cg95.cvq.business.authority.Category;
import fr.cg95.cvq.business.authority.CategoryProfile;
import fr.cg95.cvq.business.authority.CategoryRoles;
import fr.cg95.cvq.business.authority.LocalAuthority;
import fr.cg95.cvq.business.authority.SiteRoles;
import fr.cg95.cvq.business.users.Adult;
import fr.cg95.cvq.business.users.Individual;

/**
 * A data structure / cache that stores all the credentials necessary when
 * computing access privileges against a given User. This CredentialBean
 * is passed around across all access checks done for a given user.
 * Most of the methods here memorize (cache) their results for speed, and
 * also in order to break some possible loops.
 *
 * In order to speed up the security computations even more, as
 * well as allowing sophisticated use-cases (bypassing privileges,
 * allowing saving then reloading an object to the database without
 * having to enforce extra checks, etc.), the CredentialBean maintains
 * an <strong>ObjectBean cache</strong> that has the same lifetime as
 * the CredentialBean itself (typically, one transaction).
 *
 * @author dom@idealx.com
 */
public class CredentialBean {

    private static Logger logger = Logger.getLogger(CredentialBean.class);

    private Agent agent;
    private Adult adult;
    private String externalService;

    private LocalAuthority localAuthority;

    private Locale locale;
    
    private boolean boContext;
    private boolean foContext;
    private boolean adminContext;

    /**
     * Used to keep trace of current agent's site roles.
     */
    private SiteRoles[] siteRoles = null;

    /**
     * Used to keep trace of current agent's category roles.
     */
    private CategoryRoles[] categoryRoles = null;

    /**
     * Used to keep trace of current citizen's "managed" individuals.
     */
    private Set<Long> managedIndividualsIds = null;
    
    public CredentialBean(LocalAuthority localAuthority, String context) {
        logger.debug("CredentialBean() setting local authority " + localAuthority
                + " and context " + context);

        this.localAuthority = localAuthority;
        if (context.equals(SecurityContext.BACK_OFFICE_CONTEXT)) {
            boContext = true;
            foContext = false;
            adminContext = false;
        } else if (context.equals(SecurityContext.FRONT_OFFICE_CONTEXT)) {
            boContext = false;
            foContext = true;
            adminContext = false;
        } else if (context.equals(SecurityContext.ADMIN_CONTEXT)) {
            boContext = false;
            foContext = false;
            adminContext = true;
        }
    }
    
    public boolean isFoContext() {
        return foContext;
    }

    public boolean isBoContext() {
        return boContext;
    }

    public boolean isAdminContext() {
        return adminContext;
    }
    
    public void setContext(final String context) {
		if (context.equals(SecurityContext.BACK_OFFICE_CONTEXT)) {
			boContext = true;
			foContext = false;
			adminContext = false;
		} else if (context.equals(SecurityContext.FRONT_OFFICE_CONTEXT)) {
			boContext = false;
			foContext = true;
			adminContext = false;
		} else {
			boContext = false;
			foContext = false;
			adminContext = true;
		}
    }
    
    private void resetCaches() {
		objectBeanCache.clear();
		siteRoles = null;
		categoryRoles = null;
    }
    
    public Agent getAgent() {
        return agent;
    }

    public void setAgent(Agent agent) {
		this.agent = agent;

		// in case we are changing of user inside a transaction, reset the cache
		// (only happens during unit tests)
		resetCaches();
    }

	public Adult getEcitizen() {
        return adult;
    }

	public void setEcitizen(Adult adult) {
		this.adult = adult;

		// in case we are changing of user inside a transaction, reset the cache
		resetCaches();
	}
	
    public String getExternalService() {
        return externalService;
    }

    public void setExternalService(String externalService) {
        this.externalService = externalService;
        
        // in case we are changing of user inside a transaction, reset the cache
        resetCaches();        
    }

    public LocalAuthority getSite() {
        return localAuthority;
    }

    /**
     * Return the locale for the current thread. Defaults to Locale.FRANCE if none set.
     */
    public final Locale getLocale() {
        if (locale != null)
            return locale;
        else
            return Locale.FRANCE;
    }

    public final void setLocale(Locale locale) {
        this.locale = locale;
    }

    /**
     * Returns the array of site-scoped roles the user in the bean belongs to.
     */
    public SiteRoles[] getSiteRoles() {
        if (agent == null) {
            logger.info("getSiteRoles() no agent");
            return new SiteRoles[0];
        }

        if (siteRoles == null) {
            Set<SiteRoles> siteRolesSet = agent.getSitesRoles();
            siteRoles = new SiteRoles[siteRolesSet.size()];
            int i = 0;
            for (SiteRoles sr : siteRolesSet) {
                siteRoles[i] = sr;
                i++;
            }
        }

        return siteRoles;
    }

    /**
     * Returns the array of category-scoped roles the user in the bean
     * belongs to.
     */
    public CategoryRoles[] getCategoryRoles() {
        if (agent == null) {
            logger.info("getCategoryRoles() no agent");
            return new CategoryRoles[0];
        }

        if (categoryRoles == null) {
            Set<CategoryRoles> categoryRolesSet = agent.getCategoriesRoles();
            categoryRoles = new CategoryRoles[categoryRolesSet.size()];
            int i = 0;
            for (CategoryRoles cr : categoryRolesSet) {
                categoryRoles[i] = cr;
                i++;
            }
        }

        return categoryRoles;
    }

    public CategoryProfile getProfileForCategory(Category category) {
        CategoryRoles[] categoryRoles = getCategoryRoles();
        for (CategoryRoles cr : categoryRoles) {
            if (cr.getCategory().getId().equals(category.getId()))
                return cr.getProfile();
        }
        return null;
    }

    public Set<Long> getManagedIndividualsIds() {
        return managedIndividualsIds;
    }

    public void setManagedIndividualsIds(Set<Long> managedIndividualsIds) {
        this.managedIndividualsIds = managedIndividualsIds;
    }

    public void setManagedIndividuals(Set<Individual> managedIndividuals) {
        managedIndividualsIds = new HashSet<Long>();
        for (Individual individual : managedIndividuals) {
            managedIndividualsIds.add(individual.getId());
        }
    }

    /* ==================== Grants cache API =========================== */

    private ArrayList<ObjectBean> objectBeanCache = new ArrayList<ObjectBean>();

    /**
     * Returns a fresh {@link ObjectBean}, passing parameters
     * <code>object</code> and <code>baseClass</code> to the
     * constructor of this class, or a not-so-fresh ObjectBean from the cache
     * (if <code>getObjectBean()</code> was previously called with the
     * same object and base class).
     */
    public ObjectBean getObjectBean(Object object, Class<?> baseClass) {

        for (ObjectBean bean : objectBeanCache) {

            if (object.equals(bean.getObject()) &&
                baseClass.equals(bean.getBaseClass())) {
            		logger.debug("getObjectBean() returning cached object bean");
            		return bean;
            }
        }

        ObjectBean bean = new ObjectBean(object, baseClass);
        objectBeanCache.add(bean);
        return bean;
    }
}
