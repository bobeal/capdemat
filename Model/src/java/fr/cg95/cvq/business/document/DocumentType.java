package fr.cg95.cvq.business.document;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang.builder.ToStringBuilder;

@Entity
@Table(name="document_type")
public class DocumentType implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Long id;

    @Column(name="name",nullable=false,unique=true)
    private String name;

    @Column(name="type",nullable=false,unique=true)
    private Integer type;

    /** An expression of the validity duration */
    @Column(name="validity_duration_type",length=16,nullable=false)
    @Enumerated(EnumType.STRING)
    private DocumentTypeValidity validityDurationType;

    /** An optional validity duration, expressed in the units defined by validityDurationType */
    @Column(name="validity_duration",nullable=false)
    private Integer validityDuration;

    @Column(name="usage_type",length=16,nullable=false)
    @Enumerated(EnumType.STRING)
    private DocumentUsageType usageType;

    /** default constructor */
    public DocumentType() {
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

    public Integer getType() {
        return this.type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public DocumentTypeValidity getValidityDurationType() {
        return this.validityDurationType;
    }

    public void setValidityDurationType(DocumentTypeValidity validityDurationType) {
        this.validityDurationType = validityDurationType;
    }

    public Integer getValidityDuration() {
        return this.validityDuration;
    }

    public void setValidityDuration(Integer validityDuration) {
        this.validityDuration = validityDuration;
    }

    public DocumentUsageType getUsageType() {
        return this.usageType;
    }

    public void setUsageType(DocumentUsageType usageType) {
        this.usageType = usageType;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
            .append("id", getId())
            .toString();
    }

}
