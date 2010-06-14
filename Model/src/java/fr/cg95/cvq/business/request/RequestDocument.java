package fr.cg95.cvq.business.request;

import java.io.Serializable;

/**
 * @hibernate.class
 *  table="request_document"
 *  lazy="false"
 *
 * @author bor@zenexity.fr
 */
public class RequestDocument implements Serializable {

    private static final long serialVersionUID = 1L;

    /** identifier field */
    private Long id;
    private Long documentId;

    public RequestDocument() {
    }

    public RequestDocument(Long documentId) {
        super();
        this.documentId = documentId;
    }

    /**
     * @hibernate.id
     *  generator-class="sequence"
     *  column="id"
     */
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @hibernate.property
     *  column="document_id"
     */
    public Long getDocumentId() {
        return documentId;
    }

    public void setDocumentId(Long documentId) {
        this.documentId = documentId;
    }
}
