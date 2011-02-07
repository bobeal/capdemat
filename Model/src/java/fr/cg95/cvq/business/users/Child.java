package fr.cg95.cvq.business.users;

import net.sf.oval.constraint.NotNull;
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
public class Child extends Individual {

    private static final long serialVersionUID = 1L;

    public static Child xmlToModel(ChildType childType) {
        if (childType == null) return null;
        Child child = new Child();
        child.fillCommonModelInfo(childType);
        child.setBorn(childType.getBorn());
        if (childType.getSex() != null)
            child.setSex(SexType.forString(childType.getSex().toString()));
        return child;
    }

    private boolean born = true;

    @NotNull(message = "sex", when = "groovy:_this.born")
    private SexType sex;

    public ChildType modelToXml() {
        ChildType childType = ChildType.Factory.newInstance();
        fillCommonXmlInfo(childType);
        childType.setBorn(born);
        if (sex != null)
            childType.setSex(fr.cg95.cvq.xml.common.SexType.Enum.forString(sex.toString()));
        return childType;
    }

    /**
     * @hibernate.property
     *  column="born"
     */
    public boolean isBorn() {
        return born;
    }

    public void setBorn(boolean born) {
        this.born = born;
    }

    /**
     * @hibernate.property
     *  column="sex"
     *  length="8"
     */
    public SexType getSex() {
        return this.sex;
    }

    public void setSex(SexType sex) {
        this.sex = sex;
    }
}
