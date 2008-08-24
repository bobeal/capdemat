package fr.cg95.cvq.business.document;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;


/** 
 * @hibernate.class
 *  table="document_action"
 *  lazy="false"
 *
 * @author bor@zenexity.fr
 */
public class DocumentAction implements Serializable {

	private static final long serialVersionUID = 1L;

	/** identifier field */
    private Long id;
    private Long agentId;
    private String label;
    private String note;
    private Date date;
    /** the document's state resulting of this action */
    private DocumentState resultingState;
    /** the document concerned by this action */
    private Document document;

    /** default constructor */
    public DocumentAction() {
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
     *  column="agent_id"
     */
    public Long getAgentId() {
        return this.agentId;
    }

    public void setAgentId(Long agentId) {
        this.agentId = agentId;
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
     *  column="note"
     */
    public String getNote() {
        return this.note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    /**
     * @hibernate.property
     *  column="date"
     */
    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * @hibernate.property
     *  column="resulting_state"
     *  length="16"
     */
    public DocumentState getResultingState() {
        return this.resultingState;
    }

    public void setResultingState(DocumentState resultingState) {
        this.resultingState = resultingState;
    }

    /**
     * @hibernate.many-to-one
     *  class="fr.cg95.cvq.business.document.Document"
     *  column="document_id"
     */
    public Document getDocument() {
        return this.document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("id", getId())
            .toString();
    }

}
