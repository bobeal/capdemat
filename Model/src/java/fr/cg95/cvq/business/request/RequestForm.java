package fr.cg95.cvq.business.request;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.commons.lang.builder.ToStringBuilder;

@Entity
@Table(name="request_form")
public class RequestForm implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Long id;

    /* Template personalized data */
    @Column(name="personalized_data")
    private byte[] personalizedData;

    /* Template file name */
    @Column(name="template_name")
    private String templateName;

    @Enumerated(EnumType.STRING)
    @Column(nullable=false)
    private RequestFormType type;

    /**
     * user friendly name of the form inputed by an administrator
     */
    private String label;

    /**
     * Short name, used to display requestForm name in little space (like in a drop down list)
     */
    @Column(name="short_label")
    private String shortLabel;

    /** the request types that use this form */
    @ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(name="forms",
            joinColumns={
                @JoinColumn(name="request_form_id")},
            inverseJoinColumns={
                @JoinColumn(name="request_type_id")})
    private Set<RequestType> requestTypes;

    /** default constructor */
    public RequestForm() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public RequestFormType getType() {
        return this.type;
    }

    public void setType(RequestFormType type) {
        this.type = type;
    }

    public Set<RequestType> getRequestTypes() {
        return this.requestTypes;
    }

    public void setRequestTypes(Set<RequestType> requestTypes) {
        this.requestTypes = requestTypes;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getShortLabel() {
        return shortLabel;
    }

    public void setShortLabel(String shortLabel) {
        this.shortLabel = shortLabel;
    }

    public byte[] getPersonalizedData() {
        return this.personalizedData;
    }

    public String getTemplateName() {
        return this.templateName;
    }

    public void setPersonalizedData(byte[] personalizedData) {
        this.personalizedData = personalizedData;
    }

    public void setTemplateName(String templateName) {
        this.templateName = templateName;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
            .append("id", getId())
            .toString();
    }

}
