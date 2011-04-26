package fr.cg95.cvq.business.request;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang.builder.ToStringBuilder;

@Entity
@Table(name="request_action")
public class RequestAction implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final String SEARCH_BY_AGENT_ID = "agent_id";
    public static final String SEARCH_BY_TYPE = "type";
    public static final String SEARCH_BY_DATE = "date";
    public static final String SEARCH_BY_RESULTING_STATE = "resultingState";

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Long id;

    @Column(name="agent_id")
    private Long agentId;

    @Enumerated(EnumType.STRING)
    @Column
    private RequestActionType type;

    @Column(name="external_service")
    private String externalService;

    @Column(name="note",length=1024)
    private String note;

    @Column(name="date")
    private Date date;

    @Enumerated(EnumType.STRING)
    @Column(name="resulting_state",length=16)
    private RequestState resultingState;

    @Column(name="message",length=1024)
    private String message;

    @Column(name="file")
    private byte[] file;

    @Column
    private String filename;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAgentId() {
        return this.agentId;
    }

    public void setAgentId(Long agentId) {
        this.agentId = agentId;
    }

    public String getExternalService() {
        return this.externalService;
    }

    public void setExternalService(String externalService) {
        this.externalService = externalService;
    }

    public String getNote() {
        return this.note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public RequestState getResultingState() {
        return this.resultingState;
    }

    public void setResultingState(RequestState resultingState) {
        this.resultingState = resultingState;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getFilename() {
        return filename;
    }
    
    public void setFilename (String filename) {
        this.filename = filename;
    }

    public byte[] getFile() {
        return this.file;
    }

    public void setFile(byte[] file) {
        this.file = file;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("id", getId()).toString();
    }

    public RequestActionType getType() {
        return type;
    }

    public void setType(RequestActionType type) {
        this.type = type;
    }
}
