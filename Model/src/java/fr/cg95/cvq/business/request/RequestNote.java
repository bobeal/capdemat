package fr.cg95.cvq.business.request;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;


/** 
 * @hibernate.class
 *  table="request_note"
 *  lazy="false"
 *
 * @author bor@zenexity.fr
 */
public class RequestNote implements Serializable {

	private static final long serialVersionUID = 1L;

	/** identifier field */
    private Long id;
    private Long agentId;
    private RequestNoteType type;
    private String note;

    /** default constructor */
    public RequestNote() {
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
     *  column="type"
     *  length="32"
     */
    public RequestNoteType getType() {
        return this.type;
    }

    public void setType(RequestNoteType type) {
        this.type = type;
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

    public String toString() {
        return new ToStringBuilder(this)
            .append("id", getId())
            .toString();
    }

}
