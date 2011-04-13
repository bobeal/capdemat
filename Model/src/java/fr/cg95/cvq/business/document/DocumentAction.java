package fr.cg95.cvq.business.document;

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

import fr.cg95.cvq.security.SecurityContext;

@Entity
@Table(name="document_action")
public class DocumentAction implements Serializable {

    private static final long serialVersionUID = 1L;

    public enum Type {
        CREATION("Creation"),
        STATE_CHANGE("StateChange"),
        PAGE_ADDITION("PageAddition"),
        PAGE_EDITION("PageEdition"),
        PAGE_DELETION("PageDeletion"),
        MERGE("Merge");

        private String name;

        private Type(String type) { this.name = type; }

        @Override
        public String toString() {
            return name;
        }
    }

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Long id;

    @Column(name="user_id")
    private Long userId;

    @Enumerated(EnumType.STRING)
    @Column(name="type", nullable=false)
    private Type type;

    @Column(name="note")
    private String note;

    @Column(name="date")
    private Date date;

    @Column(name="resulting_state",length=16)
    @Enumerated(EnumType.STRING)
    private DocumentState resultingState;

    @SuppressWarnings("unused")
    private DocumentAction() { /* empty constructor for Hibernate */ }

    public DocumentAction(Type type, DocumentState resultingState) {
        this(type, resultingState, null);
    }

    public DocumentAction(Type type, DocumentState resultingState, String note) {
        this.userId = SecurityContext.getCurrentUserId();
        this.date = new Date();
        this.type = type;
        this.resultingState = resultingState;
        this.note = note;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return this.userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Type getType() {
        return this.type;
    }

    public void setType(Type type) {
        this.type = type;
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

    public DocumentState getResultingState() {
        return this.resultingState;
    }

    public void setResultingState(DocumentState resultingState) {
        this.resultingState = resultingState;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
            .append("id", getId())
            .toString();
    }

}
