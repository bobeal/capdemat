package fr.cg95.cvq.business.users;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang.builder.ToStringBuilder;

import fr.cg95.cvq.xml.common.MeansOfContactEnumType;
import fr.cg95.cvq.xml.common.MeansOfContactType;

/**
 * @author rdj@zenexity.fr
 */
@Entity
@Table(name="means_of_contact")
public class MeansOfContact implements Serializable, Comparable<MeansOfContact>  {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Long id;

    @Enumerated(EnumType.STRING)
    private MeansOfContactEnum type;

    private boolean enabled;

    public MeansOfContact() {}

    public MeansOfContact(MeansOfContactEnum type) {
        this.type = type;
    }

    public static MeansOfContact xmlToModel(MeansOfContactType meansOfContactType) {
        MeansOfContact meansOfContact = new MeansOfContact();
        if(meansOfContactType.getId() != 0)
            meansOfContact.setId(meansOfContactType.getId());
        if (meansOfContactType.getType() != null)
            meansOfContact.setType(
                    MeansOfContactEnum.forString(meansOfContactType.getType().toString()));
        if (meansOfContactType.getEnabled())
            meansOfContact.setEnabled(true);
        else
            meansOfContact.setEnabled(false);
        return meansOfContact;
    }

    public static MeansOfContactType modelToXml(MeansOfContact meansOfContact) {
        MeansOfContactType meansOfContactType = MeansOfContactType.Factory.newInstance();
        if(meansOfContact.getId() != null)
            meansOfContactType.setId(meansOfContact.getId().longValue());
        if (meansOfContact.getType() != null)
            meansOfContactType.setType(
                    MeansOfContactEnumType.Enum.forString(meansOfContact.getType().getLegacyLabel()));
        if (meansOfContact.isEnabled())
            meansOfContactType.setEnabled(true);
        else
            meansOfContactType.setEnabled(false);
        return meansOfContactType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public MeansOfContactEnum getType() {
        return type;
    }

    public void setType(MeansOfContactEnum type) {
        this.type = type;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
            .append("id", getId())
            .toString();
    }

    @Override
    public int compareTo(MeansOfContact o) {
        if (o == null || o.getType() == null) {
            return 1;
        }
        return this.type.toString().compareTo(o.getType().toString());
    }
}
