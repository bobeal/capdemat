package fr.cg95.cvq.business.document;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;


/**
 * Represent a type of document.
 *
 * @hibernate.class
 *  table="document_type"
 *  lazy="false"
 *
 * @author bor@zenexity.fr
 */
public class DocumentType implements Serializable {

	private static final long serialVersionUID = 1L;

	/** identifier field */
    private Long id;

    private String name;
    private Integer type;
    /** An expression of the validity duration */
    private DocumentTypeValidity validityDurationType;
    /** An optional validity duration, expressed in the units defined by validityDurationType */
    private Integer validityDuration;
    private DocumentUsageType usageType;

    /** default constructor */
    public DocumentType() {
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
     *  unique="true"
     */
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * @hibernate.property
     *  column="type"
     *  not-null="true"
     *  unique="true"
     */
    public Integer getType() {
        return this.type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * @hibernate.property
     *  column="validity_duration_type"
     *  not-null="true"
     *  length="16"
     */
    public DocumentTypeValidity getValidityDurationType() {
        return this.validityDurationType;
    }

    public void setValidityDurationType(DocumentTypeValidity validityDurationType) {
        this.validityDurationType = validityDurationType;
    }

    /**
     * @hibernate.property
     *  column="validity_duration"
     *  not-null="true"
     */
    public Integer getValidityDuration() {
        return this.validityDuration;
    }

    public void setValidityDuration(Integer validityDuration) {
        this.validityDuration = validityDuration;
    }

    /**
     * @hibernate.property
     *  column="usage_type"
     *  not-null="true"
     *  length="16"
     */
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
