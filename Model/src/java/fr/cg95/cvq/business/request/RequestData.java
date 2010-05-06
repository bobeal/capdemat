package fr.cg95.cvq.business.request;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import net.sf.oval.constraint.NotNull;

import org.apache.commons.lang.builder.ToStringBuilder;

import fr.cg95.cvq.service.request.SubjectId;
import fr.cg95.cvq.service.request.condition.EqualityChecker;
import fr.cg95.cvq.service.request.condition.IConditionChecker;

/**
 * Real persisted class containing request data
 *
 * @hibernate.class
 *  table="request"
 *  lazy="false"
 *
 * @author bor@zenexity.fr
 */
public class RequestData implements Serializable {

    private static final long serialVersionUID = 1L;


    public static final Map<String, IConditionChecker> conditions =
        new HashMap<String, IConditionChecker>(1);
    static {
        conditions.put("_homeFolderResponsible.activeHomeFolder", new EqualityChecker("true"));
    }

    private Long id;

    private Date creationDate;

    private Date lastModificationDate;

    private Date validationDate;

    private Long lastInterveningUserId;

    private RequestState state;

    private DataState dataState;

    @NotNull(profiles = {"validation"}, message = "meansOfContact")
    private MeansOfContact meansOfContact;

    private RequestStep step;

    private RequestType requestType;

    private RequestSeason requestSeason;

    /** QoS level 1 : instruction delay is expiring soon. */
    private Boolean orangeAlert;

    /** QoS level 2 : instruction delay has expired. */
    private Boolean redAlert;

    private Long homeFolderId;

    private Long requesterId;

    private String requesterLastName;

    private String requesterFirstName;

    @SubjectId
    private Long subjectId;

    private String subjectLastName;

    private String subjectFirstName;

    /** whether it has an home folder with lifecycle tied to request */
    private boolean hasTiedHomeFolder = false;

    private Set<RequestDocument> documents;

    private Set<RequestAction> actions;

    private Set<RequestNote> notes;

    private Map<String,Map<String,String>> stepStates;

    private Class<?> specificDataClass;

    private Long specificDataId;

    /**
     * Hack to store PDF chunk with documents as they are when the request is validated;
     * to be deleted when we have document versioning
     */
    private byte[] documentsArchive;

    public RequestData() {
        this.stepStates = new LinkedHashMap<String, Map<String, String>>();
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
     *  column="home_folder_id"
     */
    public Long getHomeFolderId() {
        return this.homeFolderId;
    }

    public void setHomeFolderId(Long homeFolderId) {
        this.homeFolderId = homeFolderId;
    }

    /**
     * @hibernate.property
     *  column="creation_date"
     */
    public Date getCreationDate() {
        return this.creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    /**
     * @hibernate.property
     *  column="last_modification_date"
     */
    public Date getLastModificationDate() {
        return this.lastModificationDate;
    }

    public void setLastModificationDate(Date lastModificationDate) {
        this.lastModificationDate = lastModificationDate;
    }

    /**
     * @hibernate.property
     *  column="last_intervening_user_id"
     */
    public Long getLastInterveningUserId() {
        return this.lastInterveningUserId;
    }

    public void setLastInterveningUserId(Long lastInterveningUserId) {
        this.lastInterveningUserId = lastInterveningUserId;
    }

    /**
     * @hibernate.property
     *  column="state"
     *  not-null="true"
     *  length="16"
     */
    public RequestState getState() {
        return this.state;
    }

    public void setState(RequestState state) {
        this.state = state;
    }

    /**
     * @hibernate.property
     *  column="data_state"
     *  not-null="true"
     *  length="16"
     */
    public DataState getDataState() {
        return this.dataState;
    }

    public void setDataState(DataState dataState) {
        this.dataState = dataState;
    }

    /** 
     * @hibernate.many-to-one
     *  class="fr.cg95.cvq.business.request.MeansOfContact"
     *  column="means_of_contact_id"
     */
    public MeansOfContact getMeansOfContact() {
        return this.meansOfContact;
    }

    public void setMeansOfContact(MeansOfContact meansOfContact) {
        this.meansOfContact = meansOfContact;
    }

    /**
     * @hibernate.property
     *  column="request_step"
     *  length="16"
     */
    public RequestStep getStep() {
        return this.step;
    }

    public void setStep(RequestStep step) {
        this.step = step;
    }

    /**
     * @hibernate.property
     *  column="requester_id"
     */
    public Long getRequesterId() {
        return this.requesterId;
    }

    public void setRequesterId(Long requesterId) {
        this.requesterId = requesterId;
    }

    /**
     * @hibernate.property
     *  column="requester_last_name"
     */
    public String getRequesterLastName() {
        return requesterLastName;
    }

    public void setRequesterLastName(String requesterLastName) {
        this.requesterLastName = requesterLastName;
    }

    /**
     * @hibernate.property
     *  column="requester_first_name"
     */
    public String getRequesterFirstName() {
        return requesterFirstName;
    }

    public void setRequesterFirstName(String requesterFirstName) {
        this.requesterFirstName = requesterFirstName;
    }

    /**
     * @hibernate.many-to-one
     *  class="fr.cg95.cvq.business.request.RequestType"
     *  column="request_type_id"
     */
    public RequestType getRequestType() {
        return this.requestType;
    }

    public void setRequestType(RequestType requestType) {
        this.requestType = requestType;
    }

    /**
     * @hibernate.many-to-one
     *  class="fr.cg95.cvq.business.request.RequestSeason"
     *  column="request_season_id"
     */
    public RequestSeason getRequestSeason() {
        return requestSeason;
    }

    public void setRequestSeason(RequestSeason requestSeason) {
        this.requestSeason = requestSeason;
    }

    /**
     * @hibernate.set
     *  lazy="true"
     *  cascade="all"
     *  order-by="id asc"
     * @hibernate.key
     *  column="request_id"
     * @hibernate.one-to-many
     *  class="fr.cg95.cvq.business.request.RequestDocument"
     */
    public Set<RequestDocument> getDocuments() {
        return this.documents;
    }

    public void setDocuments(Set<RequestDocument> documents) {
        this.documents = documents;
    }

    /**
     * @hibernate.set
     *  lazy="true"
     *  cascade="all"
     *  order-by="id asc"
     * @hibernate.key
     *  column="request_id"
     * @hibernate.one-to-many
     *  class="fr.cg95.cvq.business.request.RequestAction"
     */
    public Set<RequestAction> getActions() {
        return this.actions;
    }

    public void setActions(Set<RequestAction> actions) {
        this.actions = actions;
    }

    /**
     * @hibernate.set
     *  lazy="true"
     *  cascade="all"
     *  order-by="id asc"
     * @hibernate.key
     *  column="request_id"
     * @hibernate.one-to-many
     *  class="fr.cg95.cvq.business.request.RequestNote"
     */
    public Set<RequestNote> getNotes() {
        return this.notes;
    }

    public void setNotes(Set<RequestNote> notes) {
        this.notes = notes;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("id", getId()).toString();
    }

    /**
     * @hibernate.property
     *  column="orange_alert"
     */
	public Boolean getOrangeAlert() {
		return orangeAlert;
	}

	public void setOrangeAlert(Boolean orangeAlert) {
		this.orangeAlert = orangeAlert;
	}

    /**
     * @hibernate.property
     *  column="red_alert"
     */
	public Boolean getRedAlert() {
		return redAlert;
	}

	public void setRedAlert(Boolean redAlert) {
		this.redAlert = redAlert;
	}

    /**
     * @hibernate.property
     *  column="validation_date"
     */
    public Date getValidationDate() {
        return validationDate;
    }

    public void setValidationDate(Date validationDate) {
        this.validationDate = validationDate;
    }

    /**
     * @hibernate.property
     *  column="subject_id"
     *  update="false"
     */
    public Long getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Long subjectId) {
        this.subjectId = subjectId;
    }

    /**
     * @hibernate.property
     *  column="subject_last_name"
     *  update="false"
     */
    public String getSubjectLastName() {
        return subjectLastName;
    }

    public void setSubjectLastName(String subjectLastName) {
        this.subjectLastName = subjectLastName;
    }

    /**
     * @hibernate.property
     *  column="subject_first_name"
     *  update="false"
     */
    public String getSubjectFirstName() {
        return subjectFirstName;
    }

    public void setSubjectFirstName(String subjectFirstName) {
        this.subjectFirstName = subjectFirstName;
    }

    /**
     * @hibernate.property
     *  column="step_states"
     *  type="serializable"
     */
    public Map<String, Map<String, String>> getStepStates() {
        return stepStates;
    }

    public void setStepStates(Map<String, Map<String, String>> stepStates) {
        this.stepStates = stepStates;
    }

    /**
     * @hibernate.property
     *  column="has_tied_home_folder"
     */
    public boolean getHasTiedHomeFolder() {
        return hasTiedHomeFolder;
    }

    public void setHasTiedHomeFolder(boolean hasTiedHomeFolder) {
        this.hasTiedHomeFolder = hasTiedHomeFolder;
    }

    /**
     * @hibernate.property
     *  column="specific_data_class"
     */
    public Class<?> getSpecificDataClass() {
        return specificDataClass;
    }

    public void setSpecificDataClass(Class<?> specificDataClass) {
        this.specificDataClass = specificDataClass;
    }

    /**
     * @hibernate.property
     *  column="specific_data_id"
     */
    public Long getSpecificDataId() {
        return specificDataId;
    }

    public void setSpecificDataId(Long specificDataId) {
        this.specificDataId = specificDataId;
    }

    /**
     * @hibernate.property
     *  column="documents_archive"
     */
    public byte[] getDocumentsArchive() {
        return documentsArchive;
    }

    public void setDocumentsArchive(byte[] documentsArchive) {
        this.documentsArchive = documentsArchive;
    }
}
