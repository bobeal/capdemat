package fr.cg95.cvq.business.document;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

import org.apache.commons.lang.builder.ToStringBuilder;

@Entity
@Table(name="document")
public class Document implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Long id;

    /** creation date of the document in the system, set by the model */
    @Column(name="creation_date")
    private Date creationDate;

    @Column(name="validation_date")
    private Date validationDate;

    /** end validity date of the document, set by the agent at validation time */
    @Column(name="end_validity_date")
    private Date endValidityDate;

    @Column(name="ecitizen_note")
    private String ecitizenNote;

    @Column(name="agent_note")
    private String agentNote;

    @Column(name="state", length=16)
    @Enumerated(EnumType.STRING)
    private DocumentState state = DocumentState.PENDING;

    @Column(name="deposit_type",length=24)
    @Enumerated(EnumType.STRING)
    private DepositType depositType = DepositType.P_C;

    @Column(name="deposit_origin",length=10)
    @Enumerated(EnumType.STRING)
    private DepositOrigin depositOrigin = DepositOrigin.E_CITIZEN;

    @Column(name="deposit_id")
    private Long depositId;

    @Column(name="home_folder_id")
    private Long homeFolderId;

    @Column(name="individual_id")
    private Long individualId;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="document_type_id")
    private DocumentType documentType;

    @Column(name="certified")
    private boolean certified = false;

    @OneToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
    @JoinColumn(name="document_id")
    @OrderColumn(name="document_binary_index")
    private List<DocumentBinary> datas = new ArrayList<DocumentBinary>();

    @OneToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
    @JoinColumn(name="document_id")
    @OrderBy("id")
    private Set<DocumentAction> actions;

    /** default constructor */
    public Document() {
    }

    public Document(Long homeFolderId, String ecitizenNote, DocumentType documentType,
        DocumentState state) {
        this.homeFolderId = homeFolderId;
        this.ecitizenNote = ecitizenNote;
        this.documentType = documentType;
        this.state = state;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreationDate() {
        return this.creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getValidationDate() {
        return this.validationDate;
    }

    public void setValidationDate(Date validationDate) {
        this.validationDate = validationDate;
    }

    public Date getEndValidityDate() {
        return this.endValidityDate;
    }

    public void setEndValidityDate(Date endValidityDate) {
        this.endValidityDate = endValidityDate;
    }

    public String getEcitizenNote() {
        return this.ecitizenNote;
    }

    public void setEcitizenNote(String ecitizenNote) {
        this.ecitizenNote = ecitizenNote;
    }

    public String getAgentNote() {
        return this.agentNote;
    }

    public void setAgentNote(String agentNote) {
        this.agentNote = agentNote;
    }

    public DocumentState getState() {
        return this.state;
    }

    public void setState(DocumentState state) {
        this.state = state;
    }

    public DepositType getDepositType() {
        return this.depositType;
    }

    public void setDepositType(DepositType depositType) {
        this.depositType = depositType;
    }

    public DepositOrigin getDepositOrigin() {
        return this.depositOrigin;
    }

    public void setDepositOrigin(DepositOrigin depositOrigin) {
        this.depositOrigin = depositOrigin;
    }

    public Long getDepositId() {
        return this.depositId;
    }

    public void setDepositId(Long depositId) {
        this.depositId = depositId;
    }

   public Long getHomeFolderId() {
        return this.homeFolderId;
    }

    public void setHomeFolderId(Long homeFolderId) {
        this.homeFolderId = homeFolderId;
    }

    public Long getIndividualId() {
        return this.individualId;
    }

    public void setIndividualId(Long individualId) {
        this.individualId = individualId;
    }

    public DocumentType getDocumentType() {
        return this.documentType;
    }

    public void setDocumentType(DocumentType documentType) {
        this.documentType = documentType;
    }

    public boolean getCertified() {
        return certified;
    }

    public void setCertified(boolean certified) {
        this.certified = certified;
    }

    public List<DocumentBinary> getDatas() {
        return this.datas;
    }

    public void setDatas(List<DocumentBinary> datas) {
        this.datas = datas;
    }

    public Set<DocumentAction> getActions() {
        return this.actions;
    }

    public void setActions(Set<DocumentAction> actions) {
        this.actions = actions;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("id", getId()).toString();
    }
}
