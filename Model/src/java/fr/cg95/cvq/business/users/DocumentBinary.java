package fr.cg95.cvq.business.users;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;


/** 
 * @hibernate.class
 *  table="document_binary"
 *  lazy="false"
 *
 * @author bor@zenexity.fr
 */
public class DocumentBinary implements Serializable {

	private static final long serialVersionUID = 1L;

	/** identifier field */
    private Long id;
    private Integer pageNumber;
    private byte[] data;
    private Document document;

    /** full constructor */
    public DocumentBinary(Integer pageNumber, byte[] data, Document document) {
        this.pageNumber = pageNumber;
        this.data = data;
        this.document = document;
    }

    /** default constructor */
    public DocumentBinary() {
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
     *  column="page_number"
     */
    public Integer getPageNumber() {
        return this.pageNumber;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    /**
     * @hibernate.property
     *  type="binary"
     *  access="field"
     * @hibernate.column
     *  name="data"
     */
    public byte[] getData() {
        return this.data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    /**
     * @hibernate.many-to-one
     *  class="fr.cg95.cvq.business.users.Document"
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
