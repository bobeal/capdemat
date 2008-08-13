package fr.cg95.cvq.business.users;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.lang.builder.ToStringBuilder;

import fr.cg95.cvq.xml.common.ChildType;
import fr.cg95.cvq.xml.common.LegalResponsibleType;


/**
 * @hibernate.joined-subclass
 *  table="child"
 *  lazy="false"
 * @hibernate.joined-subclass-key
 *  column="id"
 *
 * @author bor@zenexity.fr
 */
public class Child extends Individual
    implements fr.cg95.cvq.business.Historizable,Serializable {

	private static final long serialVersionUID = 1L;

	private String note;
    private String badgeNumber;
    private Set legalResponsibles;

    /** default constructor */
    public Child() {
    }

    public static ChildType modelToXml(Child child) {

        ChildType childType = ChildType.Factory.newInstance();
        child.fillCommonXmlInfo(childType);

        childType.setNote(child.getNote());
        if (child.getLegalResponsibles() != null && child.getLegalResponsibles().size() > 0) {
            LegalResponsibleType[] legalResponsibleArray
                = new LegalResponsibleType[child.getLegalResponsibles().size()];
            int i = 0;
            Iterator legalResponsiblesIt = child.getLegalResponsibles().iterator();
            while (legalResponsiblesIt.hasNext()) {
                ChildLegalResponsible clr = (ChildLegalResponsible) legalResponsiblesIt.next();
                legalResponsibleArray[i] = ChildLegalResponsible.modelToXml(clr);
                i = i + 1;
            }
            childType.setLegalResponsibleArray(legalResponsibleArray);
        }

        return childType;
    }

    public static Child xmlToModel(ChildType childType) {

        Child child = new Child();
        child.fillCommonModelInfo(childType);

        Set legalResponsiblesSet = new HashSet();
        LegalResponsibleType[] legalResponsibleArray = childType.getLegalResponsibleArray();
        for (int i=0; i < legalResponsibleArray.length; i++) {
            legalResponsiblesSet.add(ChildLegalResponsible.xmlToModel(legalResponsibleArray[i]));
        }
        child.setLegalResponsibles(legalResponsiblesSet);
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
     * @hibernate.set
     *  inverse="false"
     *  lazy="true"
     *  cascade="save-update"
     * @hibernate.key
     *  column="child_id"
     * @hibernate.one-to-many
     *  class="fr.cg95.cvq.business.users.ChildLegalResponsible"
     */
    public Set getLegalResponsibles() {
        return this.legalResponsibles;
    }

    public void setLegalResponsibles(Set legalResponsibles) {
        this.legalResponsibles = legalResponsibles;
    }

    public void addLegalResponsible(ChildLegalResponsible legalResponsible) {
        if (legalResponsibles == null) {
            legalResponsibles = new HashSet();
        }
        legalResponsibles.add(legalResponsible);
    }
    
    public String toString() {
        return new ToStringBuilder(this)
            .append("id", getId())
            .toString();
    }

}
