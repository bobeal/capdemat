package fr.cg95.cvq.security;

import java.util.ArrayList;

import fr.cg95.cvq.permission.PrivilegeDescriptor;


/**
 * A data structure / cache that stores all the data necessary when
 * computing access privileges against a given object. This ObjectBean
 * is passed around across all access checks done for a given user on a
 * given object.
 *
 * @author dom@idealx.com
 */
public class ObjectBean {

    private Object object;
    private Class baseClass;

    /**
     * Public constructor. Please consider using {@link
     * CredentialBean#getObjectBean} instead, which provides an
     * appropriately-scoped cache.
     *
     * @param object the object being checked.
     * @param baseClass the class the security check is against (see
     * {@link CvqPolicy} for details about why this is not the
     * same as <code>object.getClass()</code>)
     *
     */
    public ObjectBean(Object object, Class baseClass) {
        this.object = object; 
        this.baseClass = baseClass;
    }

    /**
     * Merely returns the Object that was passed at construction time.
     */
    public Object getObject() { return object; }

    /**
     * Merely returns the base Clsss that was passed at construction time.
     */
    public Class getBaseClass() { return baseClass; }

    /* ==================== Grants cache API =========================== */

    private ArrayList<PrivilegeDescriptor> rememberedGrants = new ArrayList<PrivilegeDescriptor>();

    /**
     * Remember that <code>priv</code> was granted to this ObjectBean.
     * To be called from {@link CvqPolicy} upon successful access
     * check - used in conjunction with {@link #didGrant} and the
     * ObjectBean cache in {@link CredentialBean}, this allows
     * implementing sophisticated privilege bypasses where being
     * granted some privilege dispenses from checking a range of
     * lesser, dependent privileges.
     */
    public void rememberGrant(PrivilegeDescriptor priv) {
        rememberedGrants.add(priv);
    }

    
    /**
     * True iff <code>priv</code> was once granted to this ObjectBean.
     * When used in conjunction with {@link #rememberGrant} and the
     * ObjectBean cache in {@link CredentialBean}, this allows
     * implementing sophisticated privilege bypasses where being
     * granted some privilege dispenses from checking a range of
     * lesser, dependent privileges.
     */
    public boolean didGrant(PrivilegeDescriptor priv) {
        for (PrivilegeDescriptor privilegeDescriptor : rememberedGrants) {
            if (priv.equals(privilegeDescriptor))
                return true;
        }

        return false;
    }
}
