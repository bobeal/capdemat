package fr.cg95.cvq.business.users;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;

import fr.cg95.cvq.business.Historizable;
import fr.cg95.cvq.xml.common.MeansOfContactEnumType;
import fr.cg95.cvq.xml.common.MeansOfContactType;

/**
 * @hibernate.class
 *  table="means_of_contact"
 *  lazy="false"
 *
 * @author rdj@zenexity.fr
 *
 */
public class MeansOfContact implements Historizable,Serializable {

    private static final long serialVersionUID = 1L;
    
    /** identifier field */
    private Long id;
    
    private MeansOfContactEnum type;
    private boolean enabled;
    
    /** default constructor */
    public MeansOfContact() {
    }
    
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
                    MeansOfContactEnumType.Enum.forString(meansOfContact.getType().toString()));
        if (meansOfContact.isEnabled())
            meansOfContactType.setEnabled(true);
        else
            meansOfContactType.setEnabled(false);
        
        return meansOfContactType;
    }
    
    /**
     * @hibernate.id
     *  generator-class="sequence"
     *  column="id"
     */
    public Long getId() {
        return id;
    }
   
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @hibernate.property
     *  column="type"
     */
    public MeansOfContactEnum getType() {
        return type;
    }
  
    public void setType(MeansOfContactEnum type) {
        this.type = type;
    }

    /**
     * @hibernate.property
     *  column="enabled"
     */
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
}
