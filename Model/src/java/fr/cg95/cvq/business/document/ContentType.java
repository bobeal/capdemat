package fr.cg95.cvq.business.document;

import org.apache.commons.lang.StringUtils;

import fr.cg95.cvq.dao.hibernate.PersistentStringEnum;
import fr.cg95.cvq.exception.CvqModelException;


public final class ContentType extends PersistentStringEnum {

    private static final long serialVersionUID = 1L;

    public static final ContentType PDF = new ContentType("application/pdf");
    public static final ContentType JPEG = new ContentType("image/jpeg");
    public static final ContentType GIF = new ContentType("image/gif");
    public static final ContentType PNG = new ContentType("image/png");
    public static final ContentType TIFF = new ContentType("image/tiff");

    /**
     * Prevent instantiation and subclassing with a private constructor.
     */
    private ContentType(final String type) {
        super(type);
    }

    public ContentType() {
    }

    public static boolean isAllowedContentType(String mimeType) throws CvqModelException {
        if (mimeType.equals(GIF.toString()) || mimeType.equals(JPEG.toString()) || mimeType.equals(PDF.toString()) 
                || mimeType.equals(PNG.toString()) || mimeType.equals(TIFF.toString()))
            return true;
        return false;
    }
    
    public static ContentType forString(String mimeType) {
        if (mimeType.equals(PDF.toString()))
            return PDF;
        else if (mimeType.equals(GIF.toString()))
            return GIF;
        else if (mimeType.equals(JPEG.toString()))
            return JPEG;
        else if (mimeType.equals(PNG.toString()))
            return PNG;
        else if (mimeType.equals(TIFF.toString()))
            return TIFF;
        else
            return PDF; //TODO definir une defaultValue (ici PDF pour le moment)
    }

    public static String getShortContentType(ContentType contentType) {
        String shortContentType = StringUtils.substringAfterLast(contentType.toString(), "/");
        return shortContentType;
    }

}
