package fr.cg95.cvq.business.document;

import org.apache.commons.lang3.ArrayUtils;


public enum ContentType {

    BMP("image/x-ms-bmp", "bmp"),
    GIF("image/gif", "gif"),
    JPEG("image/jpeg", "jpg"),
    OCTET_STREAM("application/octet-stream", ""),
    PDF("application/pdf", "pdf"),
    PNG("image/png", "png"),
    TIFF("image/tiff", "tiff");

    private static final long serialVersionUID = 1L;

    public static final ContentType[] allowedContentTypes = {
        BMP, GIF, JPEG, PDF, PNG, TIFF
    };

    /**
     * @deprecated only for backward, use values() instead
     */
    public static final ContentType[] allContentTypes = ContentType.values();

    private String name;
    private String extension;

    /**
     * Prevent instantiation and subclassing with a private constructor.
     */
    private ContentType(final String type, final String extension) {
        this.name = type;
        this.extension = extension;
    }

    public static ContentType forString(String mimeType) {
        for (ContentType contentType : allowedContentTypes) {
            if (contentType.toString().equals(mimeType)) {
                return contentType;
            }
        }
        return OCTET_STREAM;
    }

    public boolean isAllowed() {
        return ArrayUtils.contains(allowedContentTypes, this);
    }

    public String getExtension() {
        return extension;
    }

    @Override
    public String toString() {
        return name;
    }
}
