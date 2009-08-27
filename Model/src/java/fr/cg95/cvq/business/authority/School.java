package fr.cg95.cvq.business.authority;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;

import fr.cg95.cvq.xml.common.SchoolType;

/**
 * @hibernate.class
 *  table="school"
 *  lazy="false"
 *
 * @author bor@zenexity.fr
 */
public class School implements Serializable {

	private static final long serialVersionUID = 1L;

	/** identifier field */
    private Long id;

    private String name;
    private String adress;
    private Boolean active;


    /** full constructor */
    public School(String name, String adress) {
        this.name = name;
        this.adress = adress;
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
     */
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * @hibernate.property
     *  column="adress"
     */
    public String getAdress() {
        return this.adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
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

    @Override
    public String toString() {
        return new ToStringBuilder(this)
            .append("id", getId())
            .toString();
    }
}
