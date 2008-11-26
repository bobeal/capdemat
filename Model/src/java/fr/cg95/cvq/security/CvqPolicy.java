package fr.cg95.cvq.security;

import java.util.HashMap;

import org.apache.log4j.Logger;

import fr.cg95.cvq.permission.CvqPermissionException;
import fr.cg95.cvq.permission.PrivilegeDescriptor;

/**
 * The CVQ security policy, dictates what can be done by whom.
 * This class sits atop the model and has knowledge of all interfaces
 * of all classes in it. It can look at credentials, walk the
 * dependency graph any way it likes to figure out whether a given
 * object is in the right local authority, etc.</p>
 *
 * <h3>Implementation details</h3>
 *
 * <p>This class in turn delegates to instances of
 * {@link DocumentPolicy}, {@link RequestPolicy}, etc.
 * according to the type of access check being
 * performed (a static hash variable in the source code dictates which
 * class gets which treatment security-wise). Those classes must
 * implement the {@link PartOfPolicy} interface.  </p>
 *
 * @author dom@idealx.com
 * @author bor@zenexity.fr
 */
public class CvqPolicy implements IPolicyDelegate {
    private static Logger logger =  Logger.getLogger(CvqPolicy.class);

    private HashMap<Class, PartOfPolicy> supportedClasses;
    
    public void init() {
    	
		logger.debug("init()");
        
        supportedClasses = new HashMap<Class, PartOfPolicy>();

		PartOfPolicy administratorOnlyPolicy = new AdministratorOnlyPolicy();
        registerPolicy(fr.cg95.cvq.business.authority.LocalAuthority.class,
                administratorOnlyPolicy);
        registerPolicy(fr.cg95.cvq.business.authority.School.class,
                administratorOnlyPolicy);
        registerPolicy(fr.cg95.cvq.business.authority.RecreationCenter.class,
                administratorOnlyPolicy);
//        registerPolicy(fr.cg95.cvq.business.request.RequestType.class,
//                administratorOnlyPolicy);
//        registerPolicy(fr.cg95.cvq.business.document.DocumentType.class,
//                administratorOnlyPolicy);
//        registerPolicy(fr.cg95.cvq.business.request.Requirement.class,
//                administratorOnlyPolicy);
        registerPolicy(fr.cg95.cvq.business.authority.Category.class,
                administratorOnlyPolicy);
//        registerPolicy(fr.cg95.cvq.business.request.RequestForm.class,
//                administratorOnlyPolicy);

        PartOfPolicy cvqReferentialPolicy = new CvqReferentialPolicy();
        registerPolicy(fr.cg95.cvq.business.authority.Agent.class,
                       cvqReferentialPolicy);

//        PartOfPolicy requestPolicy = new RequestPolicy();
//        registerPolicy(fr.cg95.cvq.business.request.Request.class,
//                       requestPolicy);
//        registerPolicy(fr.cg95.cvq.business.request.RequestAction.class,
//                       requestPolicy);
//        registerPolicy(fr.cg95.cvq.business.request.RequestNote.class,
//                       requestPolicy);
     }
    
    /**
     * Registers a new policy for a new kind of object.
     */
    private void registerPolicy(Class c, PartOfPolicy handler) {
        supportedClasses.put(c, handler);
    }

    /**
     * Retrieves the policy to apply for a security check occuring in
     * the context of <code>baseClass</code>. This is to be used by
     * implementations of {@link PartOfPolicy} that want to delegate
     * to another part of the policy.
     *
     * @return null if no policy is defined for <code>baseClass</code>.
     */
    private PartOfPolicy getPolicy(Class baseClass) {
        for(Class visitedClass = baseClass; visitedClass != null;
            visitedClass = visitedClass.getSuperclass()) {
            PartOfPolicy helper = supportedClasses.get(visitedClass);
            if (helper != null) return helper;
        }
        return null;
    }

    /* ===================== Actual permission checks ===================== */

    public void check(Object object, PrivilegeDescriptor privilegeDescriptor) 
        throws CvqPermissionException {
        
        boolean isAllowed = isAllowed(object.getClass(), object, privilegeDescriptor);

        if (!isAllowed) {
            throw new CvqPermissionException(object.getClass(), object,
                                             privilegeDescriptor);
        }
    }

    /**
     * Answers the One Big Question on behalf of the model.
     */
    public boolean isAllowed(Class baseClass, Object object,
            PrivilegeDescriptor privilegeDescriptor) {

        CredentialBean user = SecurityContext.getCurrentCredentialBean();
        // only access to Back Office requires authentication
        if (user == null) {
            logger.info("isAllowed() No user logged in");
            return false;
        } 
        
        if (user.isAdminContext()) {
            logger.info("isAllowed() authorizing access in special admin context");
            return true;
        }

        PartOfPolicy helper = getPolicy(baseClass);
        logger.debug("isAllowed() got helper " + helper);

        if (helper != null) {
            ObjectBean objectBean = user.getObjectBean(object, baseClass);
            if (objectBean.didGrant(privilegeDescriptor)) {
            		logger.debug("isAllowed() already granted access for privilege " 
            				+ privilegeDescriptor + " to " + object);
            		return true;
            }
            boolean status;

            if (privilegeDescriptor.equals(PrivilegeDescriptor.READ)) {
                status = helper.isReadAllowed(user, objectBean);
            } else if (privilegeDescriptor.equals(PrivilegeDescriptor.WRITE)) {
                status = helper.isWriteAllowed(user, objectBean);
            } else if (privilegeDescriptor.equals(PrivilegeDescriptor.ADMIN)) {
                status = helper.isAdminAllowed(user, objectBean);
            } else if (privilegeDescriptor.equals(PrivilegeDescriptor.MANAGE)) {
                status = helper.isManageAllowed(user, objectBean);
            } else {
                throw new IllegalArgumentException
                    ("unknown PrivilegeDescriptor " + privilegeDescriptor);
            }

            if (status) { objectBean.rememberGrant(privilegeDescriptor); }
            return status;
        }

        logger.info("isAllowed() No policy found for base class " + baseClass);
        return false;
    }
}
