package fr.cg95.cvq.business.payment.external;


/**
 * @hibernate.class
 *  table="external_individual"
 *  lazy="false"
 */
public class ExternalIndividual {

    /** identifier field */
    private Long id;

    private String externalId;
    private String lastName;
    private String firstName;
    private String email;
    private String homePhone;
    private boolean responsible;
    private ExternalHomeFolder externalHomeFolder;

    public ExternalIndividual() {
    }

    public ExternalIndividual(String externalId, String lastName, String firstName, String email, String homePhone,
            boolean responsible) {
        super();
        this.externalId = externalId;
        this.lastName = lastName;
        this.firstName = firstName;
        this.email = email;
        this.homePhone = homePhone;
        this.responsible = responsible;
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
     *  column="first_name"
     */
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @hibernate.property
     *  column="external_id"
     */
    public String getExternalId() {
        return externalId;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    /**
     * @hibernate.property
     *  column="last_name"
     */
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @hibernate.property
     *  column="email"
     */
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @hibernate.property
     *  column="home_phone"
     */
    public String getHomePhone() {
        return homePhone;
    }

    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }

    /**
     * @hibernate.property
     *  column="responsible"
     */
    public boolean isResponsible() {
        return responsible;
    }

    public void setResponsible(boolean responsible) {
        this.responsible = responsible;
    }

    /**
     * @hibernate.many-to-one
     *  class="fr.cg95.cvq.business.payment.external.ExternalHomeFolder"
     *  column="external_home_folder_id"
     */
    public ExternalHomeFolder getExternalHomeFolder() {
        return externalHomeFolder;
    }

    public void setExternalHomeFolder(ExternalHomeFolder externalHomeFolder) {
        this.externalHomeFolder = externalHomeFolder;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object)
            return true;
        if (!(object instanceof ExternalIndividual))
            return false;
        ExternalIndividual externalIndividual = (ExternalIndividual) object;
        if (this.id == 0 && externalIndividual.id == 0)
            return (this.externalId.equals(externalIndividual.externalId));
        else
            return this.id == externalIndividual.id;
    }

    @Override
    public int hashCode() {
        return id == null ? System.identityHashCode(this) : id.hashCode();
    }
}
