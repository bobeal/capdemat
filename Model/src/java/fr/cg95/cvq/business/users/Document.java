package fr.cg95.cvq.business.users;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import org.apache.commons.lang.builder.ToStringBuilder;

import fr.cg95.cvq.business.authority.DocumentType;


/** 
 * @hibernate.class
 *  table="document"
 *  lazy="false"
 *
 * @author bor@zenexity.fr
 */
public class Document implements Serializable {

	private static final long serialVersionUID = 1L;

	/** identifier field */
    private Long id;
    /** creation date of the document in the system, set by the model */
    private Date creationDate;
    private Date validationDate;
    /** end validity date of the document, set by the agent at validation time */
    private Date endValidityDate;
    private String ecitizenNote;
    private String agentNote;
    private DocumentState state;
    private DepositType depositType;
    private DepositOrigin depositOrigin;
    private Long depositId;
    private HomeFolder homeFolder;
    private Individual individual;
    private DocumentType documentType;
    private Boolean certified;
    
    private Set datas;
    private Set requests;
    private Set actions;

    /** full constructor */
    public Document(Date creationDate, Date validationDate, Date endValidityDate, String ecitizenNote, String agentNote, fr.cg95.cvq.business.users.DocumentState state, fr.cg95.cvq.business.users.DepositType depositType, fr.cg95.cvq.business.users.DepositOrigin depositOrigin, Long depositId, fr.cg95.cvq.business.users.HomeFolder homeFolder, fr.cg95.cvq.business.users.Individual individual, DocumentType documentType, Set datas, Set requests, Set actions) {
        this.creationDate = creationDate;
        this.validationDate = validationDate;
        this.endValidityDate = endValidityDate;
        this.ecitizenNote = ecitizenNote;
        this.agentNote = agentNote;
        this.state = state;
        this.depositType = depositType;
        this.depositOrigin = depositOrigin;
        this.depositId = depositId;
        this.homeFolder = homeFolder;
        this.individual = individual;
        this.documentType = documentType;
        this.datas = datas;
        this.requests = requests;
        this.actions = actions;
    }

    /** default constructor */
    public Document() {
    }

    /** minimal constructor */
    public Document(Set datas, Set requests, Set actions) {
        this.datas = datas;
        this.requests = requests;
        this.actions = actions;
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
     *  column="validation_date"
     */
    public Date getValidationDate() {
        return this.validationDate;
    }

    public void setValidationDate(Date validationDate) {
        this.validationDate = validationDate;
    }

    /**
     * @hibernate.property
     *  column="end_validity_date"
     */
    public Date getEndValidityDate() {
        return this.endValidityDate;
    }

    public void setEndValidityDate(Date endValidityDate) {
        this.endValidityDate = endValidityDate;
    }

    /**
     * @hibernate.property
     *  column="ecitizen_note"
     */
    public String getEcitizenNote() {
        return this.ecitizenNote;
    }

    public void setEcitizenNote(String ecitizenNote) {
        this.ecitizenNote = ecitizenNote;
    }

    /**
     * @hibernate.property
     *  column="agent_note"
     */
    public String getAgentNote() {
        return this.agentNote;
    }

    public void setAgentNote(String agentNote) {
        this.agentNote = agentNote;
    }

    /**
     * @hibernate.property
     *  column="state"
     *  length="16"
     */
    public DocumentState getState() {
        return this.state;
    }

    public void setState(DocumentState state) {
        this.state = state;
    }

    /**
     * @hibernate.property
     *  column="deposit_type"
     *  length="24"
     */
    public DepositType getDepositType() {
        return this.depositType;
    }

    public void setDepositType(DepositType depositType) {
        this.depositType = depositType;
    }

    /**
     * @hibernate.property
     *  column="deposit_origin"
     *  length="10"
     */
    public DepositOrigin getDepositOrigin() {
        return this.depositOrigin;
    }

    public void setDepositOrigin(DepositOrigin depositOrigin) {
        this.depositOrigin = depositOrigin;
    }

    /**
     * @hibernate.property
     *  column="deposit_from"
     */
    public Long getDepositId() {
        return this.depositId;
    }

    public void setDepositId(Long depositId) {
        this.depositId = depositId;
    }

    /**
     * @hibernate.many-to-one
     *  class="fr.cg95.cvq.business.users.HomeFolder"
     *  column="home_folder_id"
     */
    public HomeFolder getHomeFolder() {
        return this.homeFolder;
    }

    public void setHomeFolder(HomeFolder homeFolder) {
        this.homeFolder = homeFolder;
    }

    /**
     * @hibernate.many-to-one
     *  class="fr.cg95.cvq.business.users.Individual"
     *  column="individual_id"
     */
    public Individual getIndividual() {
        return this.individual;
    }

    public void setIndividual(Individual individual) {
        this.individual = individual;
    }

    /**
     * @hibernate.many-to-one
     *  class="fr.cg95.cvq.business.authority.DocumentType"
     *  column="document_type_id"
     */
    public DocumentType getDocumentType() {
        return this.documentType;
    }

    public void setDocumentType(DocumentType documentType) {
        this.documentType = documentType;
    }

    /**
     * @hibernate.property
     */
	public Boolean getCertified() {
		return certified;
	}

	public void setCertified(Boolean certified) {
		this.certified = certified;
	}

    /**
     * @hibernate.set
     *  inverse="true"
     *  lazy="true"
     *  cascade="delete"
     *  order-by="page_number asc"
     * @hibernate.key
     *  column="document_id"
     * @hibernate.one-to-many
     *  class="fr.cg95.cvq.business.users.DocumentBinary"
     */
    public Set getDatas() {
        return this.datas;
    }

    public void setDatas(Set datas) {
        this.datas = datas;
    }

    /**
     * @hibernate.set
     *  lazy="true"
     *  table="request_document_map"
     * @hibernate.key
     *  column="document_id"
     * @hibernate.many-to-many
     *  class="fr.cg95.cvq.business.users.Request"
     *  column="request_id"
     */
    public Set getRequests() {
        return this.requests;
    }

    public void setRequests(Set requests) {
        this.requests = requests;
    }

    /**
     * @hibernate.set
     *  inverse="true"
     *  lazy="true"
     *  cascade="delete"
     *  order-by="id"
     * @hibernate.key
     *  column="document_id"
     * @hibernate.one-to-many
     *  class="fr.cg95.cvq.business.users.DocumentAction"
     */
    public Set getActions() {
        return this.actions;
    }

    public void setActions(Set actions) {
        this.actions = actions;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("id", getId())
            .toString();
    }
}
