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

    public String toString() {
        return new ToStringBuilder(this)
            .append("id", getId())
            .toString();
    }

}
