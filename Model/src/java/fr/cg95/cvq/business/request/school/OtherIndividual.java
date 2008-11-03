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

    public static fr.cg95.cvq.xml.request.school.OtherIndividualType modelToXml(OtherIndividual otherIndividual) {

        fr.cg95.cvq.xml.request.school.OtherIndividualType otherIndividualType =
            fr.cg95.cvq.xml.request.school.OtherIndividualType.Factory.newInstance();

        if (otherIndividual.getId() != null)
            otherIndividualType.setId(otherIndividual.getId().longValue());
        otherIndividualType.setLastName(otherIndividual.getLastName());
        otherIndividualType.setFirstName(otherIndividual.getFirstName());
        otherIndividualType.setAddress(otherIndividual.getAddress());
        otherIndividualType.setHomePhone(otherIndividual.getHomePhone());
        otherIndividualType.setOfficePhone(otherIndividual.getOfficePhone());
        otherIndividualType.setType(fr.cg95.cvq.xml.request.school.SchoolOtherIndividualType.Enum.forString(otherIndividual.getType().toString()));

        return otherIndividualType;
    }

    public static OtherIndividual xmlToModel(fr.cg95.cvq.xml.request.school.OtherIndividualType otherIndividualType) {
        OtherIndividual otherIndividual = new OtherIndividual();
        if (otherIndividualType.getId() != 0)
            otherIndividual.setId(new Long(otherIndividualType.getId()));
        otherIndividual.setLastName(otherIndividualType.getLastName());
        otherIndividual.setFirstName(otherIndividualType.getFirstName());
        otherIndividual.setAddress(otherIndividualType.getAddress());
        otherIndividual.setHomePhone(otherIndividualType.getHomePhone());
        otherIndividual.setOfficePhone(otherIndividualType.getOfficePhone());
        if (otherIndividualType.getType() != null)
            otherIndividual.setType(OtherIndividualType.forString(otherIndividualType.getType().toString()));
        else
            otherIndividual.setType(OtherIndividualType.CONTACT_PERSON);

        return otherIndividual;
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
