package fr.cg95.cvq.business.authority;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang.builder.ToStringBuilder;

import fr.cg95.cvq.xml.common.SchoolType;

@Entity
@Table(name="school")
public class School implements Serializable {

    private static final long serialVersionUID = 1L;

    /** identifier field */
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Long id;

    @Column(name="name")
    private String name;

    @Column(name="address")
    private String address;

    @Column(name="active")
    private Boolean active;

    /** full constructor */
    public School(String name, String address) {
        this.name = name;
        this.address = address;
    }

    /** default constructor */
    public School() {
    }

    public static SchoolType modelToXml(School school) {

        SchoolType schoolType = SchoolType.Factory.newInstance();
        schoolType.setId(school.getId().longValue());
        schoolType.setName(school.getName());
        return schoolType;
    }

    public static School xmlToModel(SchoolType schoolType) {

        School school = new School();
        school.setId(new Long(schoolType.getId()));
        school.setName(schoolType.getName());

        return school;
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
        return this.address;
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
