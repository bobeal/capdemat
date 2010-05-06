package fr.cg95.cvq.business.document;

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
    private byte[] data;
    private ContentType contentType;

    /** default constructor */
    public DocumentBinary() {
    }

    public DocumentBinary(byte[] data) {
        this.data = data;
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
     * @hibernate.property
     * column="content_type"
     */
    public ContentType getContentType() {
        return this.contentType;
    }
    
    public void setContentType(ContentType contentType) {
        this.contentType = contentType;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
            .append("id", getId())
            .toString();
    }

}
