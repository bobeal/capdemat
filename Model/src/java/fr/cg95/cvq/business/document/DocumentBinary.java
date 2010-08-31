package fr.cg95.cvq.business.document;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.UUID;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.log4j.Logger;

import fr.cg95.cvq.exception.CvqConcurrentModificationException;
import fr.cg95.cvq.exception.CvqConcurrentModificationException.Target;

import zdb.client.Bucket;
import zdb.client.Document;
import zdb.exceptions.DocumentDoesNotExistException;
import zdb.exceptions.LockedException;
import zdb.ZDB;

/** 
 * @hibernate.class
 *  table="document_binary"
 *  lazy="false"
 *
 * @author bor@zenexity.fr
 */
public class DocumentBinary implements Serializable {

	private static final long serialVersionUID = 1L;

    private static Logger logger = Logger.getLogger(DocumentBinary.class);

	/** identifier field */
    private Long id;
    private String zdbId;

    private ContentType contentType;

    protected DocumentBinary() { /* empty constructor for Hibernate */ }

    public DocumentBinary(ContentType contentType, byte[] data) {
        this.contentType = contentType;
        setData(data);
    }

    private byte[] loadData(String bucketId) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        int read = 0;
        byte[] buffer = new byte[8096];
        Document doc;
        try {
            doc = ZDB.getBucket(bucketId).get(zdbId, false);
        } catch (LockedException e) {
            throw new RuntimeException(new CvqConcurrentModificationException(Target.document, id));
        } catch (DocumentDoesNotExistException e) {
            return null;
        }
        try {
            while ((read = doc.rawContent().read(buffer)) > 0) {
                baos.write(buffer, 0, read);
            }
        } catch (IOException e) {
            return null;
        }
        doc.release();
        return baos.toByteArray();
    }

    public void removeData() {
        try {
            ZDB.getBucket("previews").delete(zdbId);
        } catch (Exception e) {
            logger.error("could not delete preview " + zdbId, e);
        }
        try {
            ZDB.getBucket("documents").delete(zdbId);
        } catch (Exception e) {
            logger.error("could not delete document " + zdbId, e);
        }
    }

    private void storeData(String bucketId, byte[] data) {
        Bucket bucket = ZDB.getBucket(bucketId);
        if (zdbId == null) {
            do {
                zdbId = UUID.randomUUID().toString();
            } while (bucket.exists(zdbId));
        }
        if (data != null) {
            try {
                bucket.put(new Document(zdbId, contentType.toString(), new ByteArrayInputStream(data)));
            } catch (LockedException e) {
                throw new RuntimeException(new CvqConcurrentModificationException(Target.document, id));
            }
        }
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
     *  type="string"
     *  column="zdb_id"
     *  not-null="true"
     *  unique="true"
     */
    public String getZdbId() {
        return zdbId;
    }

    public void setZdbId(String zdbId) {
        this.zdbId = zdbId;
    }

    public byte[] getData() {
        return loadData("documents");
    }

    public void setData(byte[] data) {
        storeData("documents", data);
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

    public byte[] getPreview() {
        return loadData("previews");
    }
    
    public void setPreview(byte[] preview) {
        storeData("previews", preview);
    }
}
