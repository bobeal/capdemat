package fr.cg95.cvq.exporter.service.bo.impl;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import org.apache.log4j.Logger;

import fr.cg95.cvq.business.authority.Agent;
import fr.cg95.cvq.business.authority.RecreationCenter;
import fr.cg95.cvq.business.authority.School;
import fr.cg95.cvq.business.authority.SiteProfile;
import fr.cg95.cvq.business.authority.SiteRoles;
import fr.cg95.cvq.dao.authority.IRecreationCenterDAO;
import fr.cg95.cvq.dao.authority.ISchoolDAO;
import fr.cg95.cvq.dao.hibernate.HibernateUtil;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.exception.CvqObjectAlreadyExistsException;
import fr.cg95.cvq.exception.CvqObjectNotFoundException;
import fr.cg95.cvq.exception.CvqUnknownUserException;
import fr.cg95.cvq.exception.CvqUserAlreadyExistsException;
import fr.cg95.cvq.exporter.service.bo.IProvisioningService;
import fr.cg95.cvq.security.SecurityContext;
import fr.cg95.cvq.service.authority.IAgentService;
import fr.cg95.cvq.service.authority.ILocalAuthorityRegistry;
import fr.cg95.cvq.service.authority.LocalAuthorityConfigurationBean;
import fr.cg95.cvq.service.authority.impl.LocalAuthorityRegistry;

/**
 * @author bor@zenexity.fr
 */
public final class ProvisioningService implements IProvisioningService {

    static Logger logger = Logger.getLogger(ProvisioningService.class);

    private ILocalAuthorityRegistry localAuthorityRegistry;
    private IAgentService agentService;
    private ISchoolDAO schoolDAO;
    private IRecreationCenterDAO recreationCenterDAO;
    private Boolean authorizeAlreadyCreated;
    
    private void setSecurityContext(final String localAuthorityName) 
        throws CvqObjectNotFoundException {

        logger.debug("setSecurityContext() switching on local authority : " + localAuthorityName);
        LocalAuthorityConfigurationBean lacb =
            localAuthorityRegistry.getLocalAuthorityBeanByName(localAuthorityName);
        if (lacb == null) {
            logger.error("setSecurityContext() did not find configuration bean for " 
                    + localAuthorityName);
            throw new CvqObjectNotFoundException();
        }
        SessionFactory sessionFactory = lacb.getSessionFactory();
        HibernateUtil.setSessionFactory(sessionFactory);
        HibernateUtil.beginTransaction();
        SecurityContext.setCurrentSite(lacb.getName(), SecurityContext.ADMIN_CONTEXT);
    }

    private void resetSecurityContext(boolean rollback) {
        
        if (rollback) {
            HibernateUtil.rollbackTransaction();
        } else {
            HibernateUtil.commitTransaction();
        }
        HibernateUtil.closeSession();
        SecurityContext.resetCurrentSite();
    }
    
    public void createAgent(final String localAuthorityName, final String agentLogin, 
            final String firstName, final String lastName, final String[] groups)
        throws CvqUserAlreadyExistsException, CvqException {

        if (groups == null) {
            logger.info("createAgent() Agent does not belong to any group, ignoring");
            return;
        }

        setSecurityContext(localAuthorityName);

        List<String> agentGroups = Arrays.asList(groups);
        boolean isAdmin = SecurityContext.isOfAnAdminGroup(agentGroups);
        boolean isContributor = false;
        if (!isAdmin) {
            isContributor = SecurityContext.isOfAnAgentGroup(agentGroups);
        }

        if (!isAdmin && !isContributor) {
            logger.info("createAgent() Agent does not belong to one of recognized groups, ignoring");
            resetSecurityContext(true);
            return;
        }
        
        // check an agent with the same login does not already exist
        boolean existedAlready = false;
        Agent agent = null;
        try {
            agent = agentService.getByLogin(agentLogin);
            existedAlready = true;
        } catch (CvqObjectNotFoundException confe) {
            // that was expected
        }

        if (existedAlready && !authorizeAlreadyCreated) {
            resetSecurityContext(true);
            throw new CvqUserAlreadyExistsException();
        } else if (!existedAlready) {
            agent = new Agent();
            agent.setLogin(agentLogin);
        }
        agent.setFirstName(firstName);
        agent.setLastName(lastName);
        agent.setActive(Boolean.TRUE);
        Set<SiteRoles> sitesRolesSet = new LinkedHashSet<SiteRoles>();
        SiteRoles sr = new SiteRoles();
        // give it the default profile
        sr.setAgent(agent);
        if (isAdmin)
            sr.setProfile(SiteProfile.ADMIN);
        else
            sr.setProfile(SiteProfile.AGENT);
        sitesRolesSet.add(sr);
        agent.setSitesRoles(sitesRolesSet);
        try {
            if (existedAlready)
                agentService.modify(agent);
            else
                agentService.create(agent);
            resetSecurityContext(false);
        } catch (CvqException e) {
            resetSecurityContext(true);
            throw e;
        } 
    }

    public void modifyAgent(final String localAuthorityName, final String oldLogin, 
            final String newLogin, final String firstName, final String lastName,  
            final String[] newGroups)
        throws CvqException {

        setSecurityContext(localAuthorityName);

        Agent agent = null;
        try {
            agent = agentService.getByLogin(oldLogin);
        } catch (CvqObjectNotFoundException confe) {
            try {
                resetSecurityContext(true);
                createAgent(localAuthorityName, newLogin, firstName, lastName, newGroups);
            } catch (CvqUserAlreadyExistsException cuaee) {
                // it seems difficul, isn't it ?
            }
            return;
        } catch (RuntimeException e) {
            resetSecurityContext(true);
            throw e;
        }

        boolean deactivateAgent = false;
        if (newGroups == null || newGroups.length == 0)
            deactivateAgent = true;
        
        List<String> newGroupsList = Arrays.asList(newGroups);
        if (!SecurityContext.isAuthorizedGroup(newGroupsList))
            deactivateAgent = true;
        
        if (deactivateAgent) {
            try {
                agent.setActive(Boolean.FALSE);
                agentService.modify(agent);
                resetSecurityContext(false);
            } catch (RuntimeException e) {
                resetSecurityContext(true);
                throw e;
            }
            
            return;
        }
        
        try {
            agentService.modifyProfiles(agent, newGroupsList, 
                SecurityContext.getAdministratorGroups(), SecurityContext.getAgentGroups());
            agent.setLogin(newLogin);
            agent.setFirstName(firstName);
            agent.setLastName(lastName);
            agent.setActive(Boolean.TRUE);
            agentService.modify(agent);
            resetSecurityContext(false);
        } catch (RuntimeException e) {
            resetSecurityContext(true);
            throw e;
        }
    }

    public void deleteAgent(final String localAuthorityName, final String agentLogin)
        throws CvqUnknownUserException, CvqException {

        setSecurityContext(localAuthorityName);

        Agent agent = null;
        try {
            agent = agentService.getByLogin(agentLogin);
        } catch (CvqObjectNotFoundException confe) {
            logger.info("deleteAgent() Did not find agent : " + agentLogin);
            resetSecurityContext(true);
            return;
        } catch (RuntimeException e) {
            resetSecurityContext(true);
            throw e;
        }
        
        agent.setActive(Boolean.FALSE);
        try {
            agentService.modify(agent);
            resetSecurityContext(false);
        } catch (RuntimeException e) {
            resetSecurityContext(true);
            throw e;
        }
    }

    public boolean agentExists(final String localAuthorityName, final String agentLogin)
        throws CvqException {

        logger.debug("agentExists() searching for login " + agentLogin);
        setSecurityContext(localAuthorityName);

        try {
            agentService.getByLogin(agentLogin);
        } catch (CvqObjectNotFoundException confe) {
            resetSecurityContext(true);
            return false;
        } catch (RuntimeException e) {
            resetSecurityContext(true);
            throw e;
        }

        resetSecurityContext(true);
        return true;
    }

    public void createSchool(final String localAuthorityName, final String schoolName, 
            final String address) 
        throws CvqObjectAlreadyExistsException, CvqException {
        
        setSecurityContext(localAuthorityName);

        boolean alreadyExisted = false;
        School school = schoolDAO.findByName(schoolName);
        if (school != null) {
            if (!authorizeAlreadyCreated.booleanValue()) {
                resetSecurityContext(true);
                throw new CvqObjectAlreadyExistsException();
            } else {
                alreadyExisted = true;
            }
                
        } else {
            school = new School();
            school.setName(schoolName);
        }
        school.setAdress(address);
        school.setActive(Boolean.TRUE);
        
        try {
            if (alreadyExisted)
                schoolDAO.update(school);
            else
                schoolDAO.create(school);
            resetSecurityContext(false);
        } catch (RuntimeException e) {
            resetSecurityContext(true);
            throw e;
        }
    }

    public void modifySchool(final String localAuthorityName, final String oldSchoolName, 
            final String newSchoolName, final String newAddress)
        throws CvqObjectNotFoundException, CvqException {

        setSecurityContext(localAuthorityName);

        School school = schoolDAO.findByName(oldSchoolName);
        if (school == null) {
            resetSecurityContext(true);
            throw new CvqObjectNotFoundException();
        }
        
        school.setName(newSchoolName);
        school.setAdress(newAddress);
        
        try {
            schoolDAO.update(school);
            resetSecurityContext(false);
        } catch (RuntimeException e) {
            resetSecurityContext(true);
            throw e;
        }
    }

    public void deleteSchool(final String localAuthorityName, final String schoolName) 
        throws CvqObjectNotFoundException, CvqException {

        setSecurityContext(localAuthorityName);

        School school = schoolDAO.findByName(schoolName);
        if (school == null) {
            resetSecurityContext(true);
            throw new CvqObjectNotFoundException();
        }
        
        school.setActive(Boolean.FALSE);
        
        try {
            schoolDAO.update(school);
            resetSecurityContext(false);
        } catch (RuntimeException e) {
            resetSecurityContext(true);
            throw e;
        }
    }

    public void createRecreationCenter(final String localAuthorityName, 
            final String recreationCenterName, final String address)
        throws CvqObjectAlreadyExistsException, CvqException {

        setSecurityContext(localAuthorityName);

        boolean alreadyExisted = false;
        RecreationCenter recreationCenter = recreationCenterDAO.findByName(recreationCenterName);
        if (recreationCenter != null) {
            if (!authorizeAlreadyCreated.booleanValue()) {
                resetSecurityContext(true);
                throw new CvqObjectAlreadyExistsException();
            } else {
                alreadyExisted = true;
            }
        } else {
            recreationCenter = new RecreationCenter();
            recreationCenter.setName(recreationCenterName);
        }
        
        recreationCenter.setAddress(address);
        recreationCenter.setActive(Boolean.TRUE);
        
        try {
            if (alreadyExisted)
                recreationCenterDAO.update(recreationCenter);
            else
                recreationCenterDAO.create(recreationCenter);
            resetSecurityContext(false);
        } catch (RuntimeException e) {
            resetSecurityContext(true);
            throw e;
        }
    }

    public void modifyRecreationCenter(final String localAuthorityName, 
            final String oldRecreationCenterName, final String newRecreationCenterName, 
            final String newAddress) 
        throws CvqObjectNotFoundException, CvqException {

        setSecurityContext(localAuthorityName);

        RecreationCenter recreationCenter = recreationCenterDAO.findByName(oldRecreationCenterName);
        if (recreationCenter == null) {
            resetSecurityContext(true);
            throw new CvqObjectNotFoundException();
        }
        
        recreationCenter.setName(newRecreationCenterName);
        recreationCenter.setAddress(newAddress);
        
        try {
            recreationCenterDAO.update(recreationCenter);
            resetSecurityContext(false);
        } catch (RuntimeException e) {
            resetSecurityContext(true);
            throw e;
        }
    }

    public void deleteRecreationCenter(final String localAuthorityName, 
            final String recreationCenterName) 
        throws CvqObjectNotFoundException, CvqException {
        
        setSecurityContext(localAuthorityName);

        RecreationCenter recreationCenter = recreationCenterDAO.findByName(recreationCenterName);
        if (recreationCenter == null) {
            resetSecurityContext(true);
            throw new CvqObjectNotFoundException();
        }
        
        recreationCenter.setActive(Boolean.FALSE);
        
        try {
            recreationCenterDAO.update(recreationCenter);
            resetSecurityContext(false);
        } catch (RuntimeException e) {
            resetSecurityContext(true);
            throw e;
        }
    }

    class TransactionAndSessionInformation {
        private Session session;
        private Transaction transaction;
        private SessionFactory sessionFactory;
        
        public TransactionAndSessionInformation(Session session, Transaction transaction,
                SessionFactory sessionFactory) {
            this.session = session;
            this.transaction = transaction;
            this.sessionFactory = sessionFactory;
        }
        
        public Session getSession() {
            return session;
        }
        
        public void setSession(Session session) {
            this.session = session;
        }
        
        public SessionFactory getSessionFactory() {
            return sessionFactory;
        }
        
        public void setSessionFactory(SessionFactory sessionFactory) {
            this.sessionFactory = sessionFactory;
        }
        
        public Transaction getTransaction() {
            return transaction;
        }

        public void setTransaction(Transaction transaction) {
            this.transaction = transaction;
        }
    }

    public void setAgentService(IAgentService agentService) {
        this.agentService = agentService;
    }

    public void setRecreationCenterDAO(IRecreationCenterDAO recreationCenterDAO) {
        this.recreationCenterDAO = recreationCenterDAO;
    }

    public void setSchoolDAO(ISchoolDAO schoolDAO) {
        this.schoolDAO = schoolDAO;
    }

    public void setAuthorizeAlreadyCreated(Boolean authorizeAlreadyCreated) {
        this.authorizeAlreadyCreated = authorizeAlreadyCreated;
    }

    public void setLocalAuthorityRegistry(LocalAuthorityRegistry localAuthorityRegistry) {
        this.localAuthorityRegistry = localAuthorityRegistry;
    }
}
