package fr.cg95.cvq.permission;

import java.io.Serializable;

import fr.cg95.cvq.security.annotation.ContextPrivilege;

/**
 * Describes a privilege that can be granted or checked.
 *
 * @author bor@zenexity.fr
 * 
 * @deprecated
 * @see ContextPrivilege
 */
public class PrivilegeDescriptor implements Serializable {

    private static final long serialVersionUID = 1L;

    protected String name;

    /**
     * The PrivilegeDescriptor corresponding to the primitive admin privilege
     */
    public static final PrivilegeDescriptor ADMIN = 
        new PrivilegeDescriptor("admin");

    /**
     * The PrivilegeDescriptor corresponding to the primitive manager privilege
     */
    public static final PrivilegeDescriptor MANAGE = 
        new PrivilegeDescriptor("manage");

    /**
     * The PrivilegeDescriptor corresponding to the primitive read privilege
     */
    public static final PrivilegeDescriptor READ =
        new PrivilegeDescriptor("read");

    /**
     * The PrivilegeDescriptor corresponding to the primitive write privilege
     */
    public static final PrivilegeDescriptor WRITE =
        new PrivilegeDescriptor("write");


    protected PrivilegeDescriptor(String name) {
        this.name = name;
    }

    /**
     * Return a tab of all privilege descriptors in the system.
     */
    public static final PrivilegeDescriptor[] allPrivileges = {
        ADMIN,
        MANAGE,
        READ,
        WRITE
    };

    /**
     * Return the privilege name.
     */
    public final String getName() {
        return name;
    }

    /**
     * Equivalent to getName().
     */
    public String toString() {
        return getName();
    }

    /**
     * Determines whether this PrivilegeDescriptor is equal to some other
     * PrivilegeDescriptor. Equality is based on privilege name.
     * 
     * @return <code>true</code> if the privilege descriptors are equal;
     * <code>false</code> otherwise.
     */
    public boolean equals(Object o) {
        if (! (o instanceof PrivilegeDescriptor))  {
            return false;
        }
        if (name == null) {
            return false;
        }
        PrivilegeDescriptor p = (PrivilegeDescriptor) o;

        return name.equals(p.getName());
    }
    
    public int hashCode() {
        return 42 * name.hashCode();
    }
}
