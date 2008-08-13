package fr.cg95.cvq.business.users;

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
    private Request request;

    /** full constructor */
    public RequestNote(Long agentId, fr.cg95.cvq.business.users.RequestNoteType type, String note, fr.cg95.cvq.business.users.Request request) {
        this.agentId = agentId;
        this.type = type;
        this.note = note;
        this.request = request;
    }

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

    /**
     * @hibernate.many-to-one
     *  class="fr.cg95.cvq.business.users.Request"
     *  column="request_id"
     */
    public Request getRequest() {
        return this.request;
    }

    public void setRequest(Request request) {
        this.request = request;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("id", getId())
            .toString();
    }

}
