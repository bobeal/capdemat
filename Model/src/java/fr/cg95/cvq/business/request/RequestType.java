package fr.cg95.cvq.business.request;

import java.io.Serializable;
import java.util.Set;
import java.util.TreeSet;

import org.apache.commons.lang.builder.ToStringBuilder;

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

    public static final String SEARCH_BY_CATEGORY_ID = "categoryId";
    public static final String SEARCH_BY_STATE = "active";

    /** identifier field */
    private Long id;

    private String label;

    /** whether or not this request type is activated for the current local authority */
    private Boolean active;
    /** the category which is in charge of this request type */
    private Category category;
    /** this group in which request type will be display */
    private DisplayGroup displayGroup;

    /** the set of requirements to fulfill this request type */
    private Set<Requirement> requirements;
    /** the set of forms associated with this request type */
    private Set<RequestForm> forms;
    /** the set of seasons associated with this request type */
    private Set<RequestSeason> seasons;
    /** 
     * whether or not an user can issue multiple registration requests for a given season.
     * only applicable to request types that have seasons defined. 
     */
    private Boolean authorizeMultipleRegistrationsPerSeason;

    /** the maximum delay (in days) to deal with a request's instruction */
    private Integer instructionMaxDelay;
    /** the number of days before the maximum delay timeout where we send an alert email */
    private Integer instructionAlertDelay;

    public RequestType() {
        setSeasons(new TreeSet<RequestSeason>());
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
     *  class="fr.cg95.cvq.business.request.Category"
     */
    public Category getCategory() {
        return this.category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    /**
     * @hibernate.many-to-one
     *  column="display_group_id"
     *  class="fr.cg95.cvq.business.request.DisplayGroup"
     */
    public DisplayGroup getDisplayGroup() {
        return displayGroup;
    }

    public void setDisplayGroup(DisplayGroup displayGroup) {
        this.displayGroup = displayGroup;
    }

    /**
     * @hibernate.set
     *  table="requirement"
     *  lazy="true"
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
    public Set<RequestForm> getForms() {
        return this.forms;
    }

    public void setForms(Set<RequestForm> forms) {
        this.forms = forms;
    }

    /**
     * @hibernate.set
     *  inverse="true"
     *  cascade="all"
     * @hibernate.key
     *  column="request_type_id"
     * @hibernate.one-to-many
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

    @Override
    public String toString() {
        return new ToStringBuilder(this)
            .append("id", getId())
            .toString();
    }
}
