package fr.cg95.cvq.business.authority;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;

import fr.cg95.cvq.xml.common.RecreationCenterType;


/**
 * @hibernate.class
 *  table="recreation_center"
 *  lazy="false"
 *
 * @author bor@zenexity.fr
 */
public class RecreationCenter implements Serializable {

	private static final long serialVersionUID = 1L;

	/** identifier field */
    private Long id;

    private String name;
    private String address;
    private Boolean active;

    /** full constructor */
    public RecreationCenter(String name) {
        this.name = name;
    }

    /** default constructor */
    public RecreationCenter() {
    }

    public static RecreationCenterType modelToXml(RecreationCenter recreationCenter) {

        RecreationCenterType recreationCenterType =
            RecreationCenterType.Factory.newInstance();
        recreationCenterType.setId(recreationCenter.getId().longValue());
        recreationCenterType.setName(recreationCenter.getName());

        return recreationCenterType;
    }

    public static RecreationCenter xmlToModel(RecreationCenterType recreationCenterType) {

        RecreationCenter recreationCenter = new RecreationCenter();
        recreationCenter.setId(new Long(recreationCenterType.getId()));
        recreationCenter.setName(recreationCenterType.getName());

        return recreationCenter;
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
     *  column="name"
     *  not-null="true"
     */
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * @hibernate.property
     *  column="address"
     */
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @hibernate.property
     *  column="active"
     */
    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("id", getId())
            .toString();
    }
}
