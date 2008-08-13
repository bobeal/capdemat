package fr.cg95.cvq.business.users;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;

import fr.cg95.cvq.xml.common.LegalResponsibleType;


/**
 * @hibernate.class
 *  table="child_legal_responsible_map"
 *  lazy="false"
 *
 * @author bor@zenexity.fr
 */
public class ChildLegalResponsible implements fr.cg95.cvq.business.Historizable,Serializable {

	private static final long serialVersionUID = 1L;

	/** identifier field */
    private Long id;
    private LegalResponsibleRole role;
    private Child child;
    private Adult legalResponsible;

    /** full constructor */
    public ChildLegalResponsible(LegalResponsibleRole role, Child child, Adult legalResponsible) {
        this.role = role;
        this.child = child;
        this.legalResponsible = legalResponsible;
    }

    /** default constructor */
    public ChildLegalResponsible() {
    }

    public static LegalResponsibleType modelToXml(ChildLegalResponsible clr) {

        LegalResponsibleType lrt = LegalResponsibleType.Factory.newInstance();
        if (clr.getId() != null)
            lrt.setId(clr.getId().longValue());
        lrt.setRole(fr.cg95.cvq.xml.common.LegalResponsibleRoleType.Enum.forString(clr.getRole().toString()));
        lrt.setLegalResponsible(Adult.modelToXml(clr.getLegalResponsible()));

        return lrt;
    }

    public static ChildLegalResponsible xmlToModel(LegalResponsibleType lrt) {

        ChildLegalResponsible clr = new ChildLegalResponsible();
        clr.setId(new Long(lrt.getId()));
        clr.setRole(LegalResponsibleRole.forString(lrt.getRole().toString()));
        clr.setLegalResponsible(Adult.xmlToModel(lrt.getLegalResponsible()));

        return clr;
    }

    /**
     * @hibernate.id
     *  generator-class="sequence"
     *  column="id"
     */
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @hibernate.property
     *  column="role"
     *  length="8"
     */
    public LegalResponsibleRole getRole() {
        return this.role;
    }

    public void setRole(LegalResponsibleRole role) {
        this.role = role;
    }

    public void setRole(String role) {
        LegalResponsibleRole[] allLegalResponsibleRoleTypes =
            LegalResponsibleRole.allLegalResponsibleRoleTypes;
        for (int i=0; i < allLegalResponsibleRoleTypes.length; i++) {
            LegalResponsibleRole lrr = allLegalResponsibleRoleTypes[i];
            if (lrr.toString().equals(role))
                this.role = lrr;
        }
    }

    /**
     * @hibernate.many-to-one
     *  class="fr.cg95.cvq.business.users.Child"
     *  column="child_id"
     */
    public Child getChild() {
        return this.child;
    }

    public void setChild(Child child) {
        this.child = child;
    }

    /**
     * @hibernate.many-to-one
     *  class="fr.cg95.cvq.business.users.Adult"
     *  column="legal_responsible_id"
     */
    public Adult getLegalResponsible() {
        return this.legalResponsible;
    }

    public void setLegalResponsible(Adult legalResponsible) {
        this.legalResponsible = legalResponsible;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("id", getId())
            .toString();
    }

}
