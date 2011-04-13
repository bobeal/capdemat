package fr.cg95.cvq.business.authority;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang.builder.ToStringBuilder;

import fr.cg95.cvq.xml.common.RecreationCenterType;

@Entity
@Table(name="recreation_center")
public class RecreationCenter implements Serializable {

	private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Long id;

    @Column(name="name", nullable=false)
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

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
            .append("id", getId())
            .toString();
    }
}
