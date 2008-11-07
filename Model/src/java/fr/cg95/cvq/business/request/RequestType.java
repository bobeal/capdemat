package fr.cg95.cvq.business.request;

import java.io.Serializable;
import java.util.Set;

import org.apache.commons.lang.builder.ToStringBuilder;

import fr.cg95.cvq.business.authority.Category;
import fr.cg95.cvq.service.request.IRequestService;


/**
 * @hibernate.class
 *  table="request_type"
 *  lazy="false"
 *
 * @author Benoit Orihuela (bor@zenexity.fr)
 */
public class RequestType implements Serializable {

	private static final long serialVersionUID = 1L;

	/** identifier field */
    private Long id;

    private String label;

    /** whether or not this request type is activated for the current local authority */
    private Boolean active;
    /** the category which is in charge of this request type */
    private Category category;

    /** the set of requirements to fulfill this request type */
    private Set<Requirement> requirements;
    /** the set of forms associated with this request type */
    private Set forms;
    /** the set of seasons associated with this request type */
    private Set<RequestSeason> seasons;
    /** 
     * whether or not an user can issue multiple registration requests for a given season.
     * only applicable to request types that have seasons defined. 
     */
    private Boolean authorizeMultipleRegistrationsPerSeason;
    /**
     * whether this request type automatically switches to "Active" state when notified. 
     * only applicable to request types of registration kind
     * 
     * @see IRequestService#isOfRegistrationKind()
     * @see RequestState
     */
    private Boolean hasAutomaticActivation;
    
    /** the maximum delay (in days) to deal with a request's instruction */
    private Integer instructionMaxDelay;
    /** the number of days before the maximum delay timeout where we send an alert email */
    private Integer instructionAlertDelay;

    public RequestType() {
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
     *  column="label"
     */
    public String getLabel() {
        return this.label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    /**
     * @hibernate.property
     *  column="active"
     */
    public Boolean getActive() {
        return this.active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    /**
     * @hibernate.many-to-one
     *  column="category_id"
     *  class="fr.cg95.cvq.business.authority.Category"
     */
    public Category getCategory() {
        return this.category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    /**
     * @hibernate.set
     *  table="requirement"
     *  lazy="true"
     *  order-by="document_type_id asc"
     *  cascade="all"
     * @hibernate.key
     *  column="request_type_id"
     * @hibernate.composite-element
     *  class="fr.cg95.cvq.business.request.Requirement"
     */
    public Set<Requirement> getRequirements() {
        return this.requirements;
    }

    public void setRequirements(Set<Requirement> requirements) {
        this.requirements = requirements;
    }

    /**
     * @hibernate.set
     *  table="forms"
     *  inverse="true"
     *  lazy="true"
     * @hibernate.key
     *  column="request_type_id"
     * @hibernate.many-to-many
     *  class="fr.cg95.cvq.business.request.RequestForm"
     *  column="request_form_id"
     */
    public Set getForms() {
        return this.forms;
    }

    public void setForms(Set forms) {
        this.forms = forms;
    }

    /**
     * @hibernate.set
     *  table="seasons"
     *  lazy="true"
     *  order-by="effect_start asc"
     *  cascade="all"
     * @hibernate.key
     *  column="request_type_id"
     * @hibernate.composite-element
     *  class="fr.cg95.cvq.business.request.RequestSeason"
     */
    public final Set<RequestSeason> getSeasons() {
        return seasons;
    }

    public final void setSeasons(Set<RequestSeason> seasons) {
        this.seasons = seasons;
    }

    /**
     * @hibernate.property
     *  column="authorize_multiple_registrations_per_season"
     */
    public final Boolean getAuthorizeMultipleRegistrationsPerSeason() {
        return authorizeMultipleRegistrationsPerSeason;
    }

    public final void setAuthorizeMultipleRegistrationsPerSeason(
            Boolean authorizeMultipleRegistrationPerSeason) {
        this.authorizeMultipleRegistrationsPerSeason = authorizeMultipleRegistrationPerSeason;
    }

    /**
     * @hibernate.property
     *  column="instruction_alert_delay"
     */
	public Integer getInstructionAlertDelay() {
		return instructionAlertDelay;
	}

	public void setInstructionAlertDelay(Integer instructionAlertDelay) {
		this.instructionAlertDelay = instructionAlertDelay;
	}

    /**
     * @hibernate.property
     *  column="instruction_max_delay"
     */
	public Integer getInstructionMaxDelay() {
		return instructionMaxDelay;
	}

	public void setInstructionMaxDelay(Integer instructionMaxDelay) {
		this.instructionMaxDelay = instructionMaxDelay;
	}

    /**
     * @hibernate.property
     *  column="has_automatic_activation"
     */
    public Boolean getHasAutomaticActivation() {
        return hasAutomaticActivation;
    }

    public void setHasAutomaticActivation(Boolean hasAutomaticActivation) {
        this.hasAutomaticActivation = hasAutomaticActivation;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("id", getId())
            .toString();
    }
}
