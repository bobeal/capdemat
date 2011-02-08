package fr.cg95.cvq.business.document;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;

import fr.cg95.cvq.dao.hibernate.PersistentStringEnum;
import fr.cg95.cvq.security.SecurityContext;

/** 
 * @hibernate.class
 *  table="document_action"
 *  lazy="false"
 *
 * @author bor@zenexity.fr
 */
public class DocumentAction implements Serializable {

    private static final long serialVersionUID = 1L;

    public static class Type extends PersistentStringEnum {
        private static final long serialVersionUID = 1L;
        public static final Type CREATION = new Type("Creation");
        public static final Type STATE_CHANGE = new Type("StateChange");
        public static final Type PAGE_ADDITION = new Type("PageAddition");
        public static final Type PAGE_EDITION = new Type("PageEdition");
        public static final Type PAGE_DELETION = new Type("PageDeletion");
        public static final Type MERGE = new Type("Merge");
        public Type() { /* public constructor for Hibernate */ }
        private Type(String type) { super(type); }
    }

    private Long id;
    private Long userId;
    private Type type;
    private String note;
    private Date date;
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
     *  column="user_id"
     */
    public Long getUserId() {
        return this.userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * @hibernate.property
     *  column="type"
     *  not-null="true"
     */
    public Type getType() {
        return this.type;
    }

    public void setType(Type type) {
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
     *  not-null="false"
     *  length="16"
     */
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
