package fr.cg95.cvq.business.request;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.hibernate.annotations.Parent;

import fr.cg95.cvq.business.document.DocumentType;


/**
 * @author Benoit Orihuela (bor@zenexity.fr)
 */
@Embeddable
public class Requirement implements Serializable {

	private static final long serialVersionUID = 1L;

	/** Number of documents requested for the given document type */
    private Integer multiplicity;
    /** Whether this document is always required (special=false) or only required in particular cases (special=true) */
    private Boolean special;
    /** A message to specifiy why the requirement of this document type is special */
    @Column(name="special_reason")
    private String specialReason;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="document_type_id")
    private DocumentType documentType;

    @Parent
    private RequestType requestType;

    /** full constructor */
    public Requirement(Integer multiplicity, Boolean special, String specialReason,
            DocumentType documentType, RequestType requestType) {
        this.multiplicity = multiplicity;
        this.special = special;
        this.specialReason = specialReason;
        this.documentType = documentType;
        this.requestType = requestType;
    }

    /** default constructor */
    public Requirement() {
    }

    public RequestType getRequestType() {
        return this.requestType;
    }

    public void setRequestType(RequestType requestType) {
        this.requestType = requestType;
    }

    public Integer getMultiplicity() {
        return this.multiplicity;
    }

    public void setMultiplicity(Integer multiplicity) {
        this.multiplicity = multiplicity;
    }

    public Boolean getSpecial() {
        return this.special;
    }

    public void setSpecial(Boolean special) {
        this.special = special;
    }

    public String getSpecialReason() {
        return this.specialReason;
    }

    public void setSpecialReason(String specialReason) {
        this.specialReason = specialReason;
    }

    public DocumentType getDocumentType() {
        return this.documentType;
    }

    public void setDocumentType(DocumentType documentType) {
        this.documentType = documentType;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
            .toString();
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (!(other instanceof Requirement)) return false;

        final Requirement requirement = (Requirement) other;

        if (!getRequestType().getId().equals(requirement.getRequestType().getId()))
            return false;
        if (!getDocumentType().getId().equals(requirement.getDocumentType().getId()))
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        result = getDocumentType().hashCode();
        result = 29 * result;
        if (getRequestType()!= null)
            result += getRequestType().hashCode();
        return result;
    }
}
