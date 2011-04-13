package fr.cg95.cvq.business.payment.external;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="external_individual")
public class ExternalIndividual {

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Long id;

    @Column(name="external_id")
    private String externalId;

    @Column(name="last_name")
    private String lastName;

    @Column(name="first_name")
    private String firstName;

    private String email;

    @Column(name="home_phone")
    private String homePhone;

    @Column(name="responsible")
    private boolean responsible;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="external_home_folder_id", insertable=false, updatable=false)
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getExternalId() {
        return externalId;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }

    public boolean isResponsible() {
        return responsible;
    }

    public void setResponsible(boolean responsible) {
        this.responsible = responsible;
    }

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
