package fr.cg95.cvq.business.request.school;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * @hibernate.class
 *  table="other_individual"
 *
 * @author bor@zenexity.fr
 */
public class OtherIndividual implements Serializable {

    private static final long serialVersionUID = 1L;

    /** identifier field */
    private Long id;
    private String lastName;
    private String firstName;
    private String address;
    private String homePhone;
    private String officePhone;
    private OtherIndividualType type = OtherIndividualType.CONTACT_PERSON;

    public OtherIndividual() {
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
     *  column="last_name"
     */
    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @hibernate.property
     *  column="first_name"
     */
    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @hibernate.property
     *  column="address"
     */
    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @hibernate.property
     *  column="home_phone"
     *  length="32"
     */
    public String getHomePhone() {
        return this.homePhone;
    }

    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }

    /**
     * @hibernate.property
     *  column="office_phone"
     *  length="32"
     */
    public String getOfficePhone() {
        return this.officePhone;
    }

    public void setOfficePhone(String officePhone) {
        this.officePhone = officePhone;
    }

    /**
     * @hibernate.property
     *  column="type"
     *  length="16"
     */
    public OtherIndividualType getType() {
        return this.type;
    }

    public void setType(OtherIndividualType type) {
        this.type = type;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("id", getId())
            .toString();
    }

}