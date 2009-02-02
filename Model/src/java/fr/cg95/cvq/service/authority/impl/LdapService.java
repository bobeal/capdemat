package fr.cg95.cvq.service.authority.impl;

import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attributes;
import javax.naming.directory.DirContext;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;

import org.apache.log4j.Logger;

import fr.cg95.cvq.business.authority.Agent;
import fr.cg95.cvq.business.authority.LocalAuthority;
import fr.cg95.cvq.business.authority.RecreationCenter;
import fr.cg95.cvq.business.authority.School;
import fr.cg95.cvq.dao.authority.ILocalAuthorityDAO;
import fr.cg95.cvq.dao.authority.IRecreationCenterDAO;
import fr.cg95.cvq.dao.authority.ISchoolDAO;
import fr.cg95.cvq.exception.CvqConfigurationException;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.security.SecurityContext;
import fr.cg95.cvq.service.authority.ILdapService;
import fr.cg95.cvq.service.authority.ILocalAuthorityRegistry;

/**
 * @deprecated
 */
public class LdapService implements ILdapService {

    private ILocalAuthorityDAO iLocalAuthorityDAO;
    private ISchoolDAO iSchoolDAO;
    private IRecreationCenterDAO iRecreationCenterDAO;
    private ILocalAuthorityRegistry localAuthorityRegistry;

    private Boolean enabled;

    private String host;
    private int port;

    private String securityPrincipal;
    private String securityCredentials;
    private String securityAuthentication = "simple";
    private String ditRoot;
    private String peopleBranch;
    private String peopleFirstName;
    private String peopleLastName;
    private String schoolBranch;
    private String recreationCenterBranch;

    private String providerUrl;

    static Logger logger = Logger.getLogger(LdapService.class);

    public LdapService() {
        super();
    }

    /**
     * Initialize connection with LDAP directory
     */
    public void init() throws CvqConfigurationException {

        if (!enabled.booleanValue()) {
            logger.info("init() LDAP is not activated, nothing to do");
            return;
        }

        logger.debug("init() Initializing LDAP context to host " + host + " and port " + port);

        // calculate LDAP context
        providerUrl = new StringBuffer("ldap://").append(host).append(":").append(port).append("/")
                .toString();

        // just a lookup test to ensure object is bound
        DirContext ctx = null;
        try {
            InitialContext iCtx = new InitialContext();
            ctx = (DirContext) iCtx.lookup(providerUrl);
            ctx.addToEnvironment(Context.SECURITY_PRINCIPAL, securityPrincipal);
            ctx.addToEnvironment(Context.SECURITY_CREDENTIALS, securityCredentials);
            ctx.addToEnvironment(Context.SECURITY_AUTHENTICATION, securityAuthentication);
        } catch (NamingException ne) {
            ne.printStackTrace();
            throw new CvqConfigurationException("Unable to initialize LDAP context");
        }
    }

    private DirContext gimmeAContext() {

        DirContext ctx = null;
        try {
            InitialContext iCtx = new InitialContext();
            ctx = (DirContext) iCtx.lookup(providerUrl);
            ctx.addToEnvironment(Context.SECURITY_PRINCIPAL, securityPrincipal);
            ctx.addToEnvironment(Context.SECURITY_CREDENTIALS, securityCredentials);
            ctx.addToEnvironment(Context.SECURITY_AUTHENTICATION, securityAuthentication);
        } catch (NamingException ne) {
            ne.printStackTrace();
            throw new RuntimeException("Unable to initialize LDAP context");
        }

        return ctx;
    }

    private List getAllSchools(final LocalAuthority localAuthority) throws CvqException {

        ArrayList resultsList = new ArrayList();

        try {

            SearchControls controls = new SearchControls();
            controls.setSearchScope(SearchControls.SUBTREE_SCOPE);
            String filter = schoolBranch + "," + ditRoot;
            NamingEnumeration schoolsEnumeration = gimmeAContext()
                    .search(filter, "(o=*)", controls);

            while (schoolsEnumeration.hasMore()) {
                SearchResult result = (SearchResult) schoolsEnumeration.next();
                String name = result.getName();
                String schoolName = name.substring(name.indexOf("o=") + "o=".length());
                logger.debug("getAllSchools() Got object name : " + schoolName);
                School school = new School();
                school.setName(schoolName);
                resultsList.add(school);
            }
        } catch (NamingException ne) {
            ne.printStackTrace();
            throw new CvqException("Error while retrieving schools");
        }

        return resultsList;
    }

    private List getAllRecreationCenters(final LocalAuthority localAuthority) throws CvqException {

        ArrayList resultsList = new ArrayList();

        try {

            SearchControls controls = new SearchControls();
            controls.setSearchScope(SearchControls.SUBTREE_SCOPE);
            String filter = recreationCenterBranch + "," + ditRoot;
            NamingEnumeration recreationCentersEnumeration = gimmeAContext().search(filter,
                    "(o=*)", controls);

            while (recreationCentersEnumeration.hasMore()) {
                SearchResult result = (SearchResult) recreationCentersEnumeration.next();
                String name = result.getName();
                String recreationCenterName = name.substring(name.indexOf("o=") + "o=".length());
                logger.debug("getAllRecreationCenters() Got object name : " + recreationCenterName);
                RecreationCenter recreationCenter = new RecreationCenter();
                recreationCenter.setName(recreationCenterName);
                resultsList.add(recreationCenter);
            }
        } catch (NamingException ne) {
            ne.printStackTrace();
            throw new CvqException("Error while retrieving recreation centers");
        }

        return resultsList;
    }

    public void completeAgentData(Agent agent) throws CvqException {

        if (!enabled.booleanValue())
            return;

        try {

            SearchControls controls = new SearchControls();
            controls.setSearchScope(SearchControls.SUBTREE_SCOPE);

            String dn = "uid=" + agent.getLogin() + "," + peopleBranch + "," + ditRoot;
            Attributes attrs = gimmeAContext().getAttributes(dn);
            if (attrs != null) {
                String lastName = null;
                String firstName = null;
                if (attrs.get(peopleLastName) != null)
                    lastName = (String) attrs.get(peopleLastName).get();
                if (attrs.get(peopleFirstName) != null)
                    firstName = (String) attrs.get(peopleFirstName).get();
                logger.debug("getAgentByLogin() Got last/first name : " + lastName + " / "
                        + firstName);
                agent.setFirstName(firstName);
                agent.setLastName(lastName);
            } else {
                logger.warn("getAgentByLogin() No result found");
            }
        } catch (NamingException ne) {
            ne.printStackTrace();
            throw new CvqException("Error while retrieving agent data");
        }
    }

    public void synchronizeDatabasesWithDirectory() throws CvqException {
        if (enabled.booleanValue())
            localAuthorityRegistry.browseAndCallback(this, "synchronizeDatabaseWithDirectory", null);
    }

    public void synchronizeDatabaseWithDirectory(final String localAuthorityName)
            throws CvqException {

        LocalAuthority localAuthority = getCurrentLocalAuthority();
        if (localAuthority == null) {
            // local authority does not exist in DB, create it
            logger.debug("synchronizeCollectivity() Creating local authority : "
                    + localAuthorityName);
            localAuthority = new LocalAuthority();
            localAuthority.setName(localAuthorityName);
            // localAuthority.setPostalCode(collectivity.getPostalCode());
            iLocalAuthorityDAO.create(localAuthority);
        }

        logger.debug("synchronizeCollectivity() Dealing with local authority : "
                + localAuthority.getName());

        synchronizeSchools(localAuthority);
        synchronizeRecreationCenters(localAuthority);
    }

    private void synchronizeSchools(LocalAuthority localAuthority) throws CvqException {

        List schoolsLdap = getAllSchools(localAuthority);
        List schoolsCvq = iSchoolDAO.listAll();

        logger.debug("synchronizeSchools() got " + schoolsLdap.size() + " schools from LDAP");
        for (int i = 0; i < schoolsLdap.size(); i++) {
            School schoolLdap = (School) schoolsLdap.get(i);
            logger.debug("synchronizeSchools() got school from LDAP : " + schoolLdap.getName());
            // search if this school is in our CVQ list
            School schoolCvq = null;
            boolean foundSchool = false;
            int foundSchoolIndex = 0;
            for (int j = 0; j < schoolsCvq.size(); j++) {
                schoolCvq = (School) schoolsCvq.get(j);
                if (schoolCvq.getName().equals(schoolLdap.getName())) {
                    logger.debug("synchronizeSchools() found school in CVQ");
                    foundSchool = true;
                    foundSchoolIndex = j;
                    break;
                }
            }

            if (!foundSchool) {
                logger.debug("synchronizeSchools() creating school : " + schoolLdap.getName());
                schoolLdap.setActive(Boolean.valueOf(true));
                iSchoolDAO.create(schoolLdap);
            } else {
                // remove from the list of CVQ schools
                // remaining schools will then be desactivated
                schoolsCvq.remove(foundSchoolIndex);
            }
        }

        if (schoolsCvq.size() != 0) {
            for (int i = 0; i < schoolsCvq.size(); i++) {
                School schoolCvq = (School) schoolsCvq.get(i);
                if (schoolCvq.getActive().booleanValue()) {
                    logger
                            .debug("synchronizeSchools() Desactivating school "
                                    + schoolCvq.getName());
                    // desactivate school
                    // don't delete since we may need this information for older
                    // requests
                    schoolCvq.setActive(Boolean.valueOf(false));
                    iSchoolDAO.update(schoolCvq);
                }
            }
        }
    }

    private void synchronizeRecreationCenters(LocalAuthority localAuthority) throws CvqException {

        List recreationCentersLdap = getAllRecreationCenters(localAuthority);
        List recreationCentersCvq = iRecreationCenterDAO.listAll();

        logger.debug("synchronizeRecreationCenters() got " + recreationCentersLdap.size()
                + " recreation centers from LDAP");
        for (int i = 0; i < recreationCentersLdap.size(); i++) {
            RecreationCenter recreationCenterLdap = (RecreationCenter) recreationCentersLdap.get(i);
            logger.debug("synchronizeSchools() got recreation center from LDAP : "
                    + recreationCenterLdap.getName());
            // search if this recreation center is in our CVQ list
            RecreationCenter recreationCenterCvq = null;
            boolean foundRecreationCenter = false;
            int foundRecreationCenterIndex = 0;
            for (int j = 0; j < recreationCentersCvq.size(); j++) {
                recreationCenterCvq = (RecreationCenter) recreationCentersCvq.get(j);
                if (recreationCenterCvq.getName().equals(recreationCenterLdap.getName())) {
                    logger.debug("synchronizeRecreationCenters() found recreation center in CVQ");
                    foundRecreationCenter = true;
                    foundRecreationCenterIndex = j;
                    break;
                }
            }

            if (!foundRecreationCenter) {
                logger.debug("synchronizeRecreationCenters() creating recreation center : "
                        + recreationCenterLdap.getName());
                recreationCenterLdap.setActive(Boolean.valueOf(true));
                iRecreationCenterDAO.create(recreationCenterLdap);
            } else {
                // remove from the list of CVQ recreation centers
                // remaining recreation centers will then be desactivated
                recreationCentersCvq.remove(foundRecreationCenterIndex);
            }
        }

        if (recreationCentersCvq.size() != 0) {
            for (int i = 0; i < recreationCentersCvq.size(); i++) {
                RecreationCenter recreationCenterCvq = (RecreationCenter) recreationCentersCvq
                        .get(i);
                if (recreationCenterCvq.getActive().booleanValue()) {
                    logger.debug("synchronizeRecreationCenters() Desactivating recreation center "
                            + recreationCenterCvq.getName());
                    // desactivate recreation center
                    // don't delete since we may need this information for older
                    // requests
                    recreationCenterCvq.setActive(Boolean.valueOf(false));
                    iRecreationCenterDAO.update(recreationCenterCvq);
                }
            }
        }
    }

    private LocalAuthority getCurrentLocalAuthority() {
        return SecurityContext.getCurrentSite();
    }

    public void setHost(final String host) {
        this.host = host;
    }

    public void setPort(final int port) {
        this.port = port;
    }

    public void setSecurityPrincipal(final String managerDn) {
        this.securityPrincipal = managerDn;
    }

    public void setSecurityCredentials(final String managerPwd) {
        this.securityCredentials = managerPwd;
    }

    public void setSecurityAuthentication(final String securityAuthentication) {
        this.securityAuthentication = securityAuthentication;
    }

    public void setLocalAuthorityDAO(ILocalAuthorityDAO iLocalAuthorityDAO) {
        this.iLocalAuthorityDAO = iLocalAuthorityDAO;
    }

    public void setSchoolDAO(ISchoolDAO iSchoolDAO) {
        this.iSchoolDAO = iSchoolDAO;
    }

    public void setRecreationCenterDAO(IRecreationCenterDAO iRecreationCenterDAO) {
        this.iRecreationCenterDAO = iRecreationCenterDAO;
    }

    public void setDitRoot(String ditRoot) {
        this.ditRoot = ditRoot;
    }

    public void setPeopleBranch(String peopleBranch) {
        this.peopleBranch = peopleBranch;
    }

    public void setRecreationCenterBranch(String recreationCenterBranch) {
        this.recreationCenterBranch = recreationCenterBranch;
    }

    public void setSchoolBranch(String schoolBranch) {
        this.schoolBranch = schoolBranch;
    }

    public void setPeopleFirstName(String peopleFirstName) {
        this.peopleFirstName = peopleFirstName;
    }

    public void setPeopleLastName(String peopleLastName) {
        this.peopleLastName = peopleLastName;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public void setLocalAuthorityRegistry(ILocalAuthorityRegistry localAuthorityRegistry) {
        this.localAuthorityRegistry = localAuthorityRegistry;
    }
}
