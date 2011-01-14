package fr.cg95.cvq.business.users;

import java.io.Serializable;

import fr.cg95.cvq.service.users.HasLegalResponsibles;
import fr.cg95.cvq.xml.common.ChildType;


/**
 * @hibernate.joined-subclass
 *  table="child"
 *  lazy="false"
 * @hibernate.joined-subclass-key
 *  column="id"
 *
 * @author bor@zenexity.fr
 */
@HasLegalResponsibles
public class Child extends Individual
    implements fr.cg95.cvq.business.Historizable,Serializable {

	private static final long serialVersionUID = 1L;

	private String note;
    private String badgeNumber;
    private boolean isChildBorn = true;

    /** default constructor */
    public Child() {
    }

    public static ChildType modelToXml(Child child) {

        ChildType childType = ChildType.Factory.newInstance();
        child.fillCommonXmlInfo(childType);

        childType.setNote(child.getNote());

        return childType;
    }

    public static Child xmlToModel(ChildType childType) {

        Child child = new Child();
        child.fillCommonModelInfo(childType);

        child.setNote(childType.getNote());

        return child;
    }

    /**
     * @hibernate.property
     *  column="note"
     */
    public String getNote() {
        return this.note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    /**
     * @hibernate.property
     *  column="badge_number"
     */
    public String getBadgeNumber() {
        return this.badgeNumber;
    }

    public void setBadgeNumber(String badgeNumber) {
        this.badgeNumber = badgeNumber;
    }

    /**
     * @hibernate.property
     *  column="child_born"
     */
    public boolean getIsChildBorn() {
        return isChildBorn;
    }

    public void setIsChildBorn(boolean isChildBorn) {
        this.isChildBorn = isChildBorn;
    }
}
