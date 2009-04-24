/**
 * 
 */
package fr.cg95.cvq.business.authority;

import java.util.Hashtable;

import fr.cg95.cvq.service.authority.ILocalAuthorityRegistry;

/**
 * Represents a file that can be customized on a local authority basis
 *
 * @author jsb
 *
 */
public class LocalAuthorityResource {

    public static enum Version {
        CURRENT,
        OLD,
        TEMP
    }

    public static final Hashtable<Version, String> versionExtensions = new Hashtable<Version, String>(3);
    static {
        versionExtensions.put(Version.CURRENT, "");
        versionExtensions.put(Version.OLD, ".old");
        versionExtensions.put(Version.TEMP, ".tmp");
    }

    public static final Hashtable<String, LocalAuthorityResource> localAuthorityResources = new Hashtable<String, LocalAuthorityResource>(10);
    public static final LocalAuthorityResource CSS_FO = new LocalAuthorityResource("cssFO", "fo", ".css", ILocalAuthorityRegistry.CSS_ASSETS_RESOURCE_TYPE);
    public static final LocalAuthorityResource LOGO_FO = new LocalAuthorityResource("logoFO", "logoFo", ".png", ILocalAuthorityRegistry.IMAGE_ASSETS_RESOURCE_TYPE);
    public static final LocalAuthorityResource LOGO_BO = new LocalAuthorityResource("logoBO", "logoBO", ".png", ILocalAuthorityRegistry.IMAGE_ASSETS_RESOURCE_TYPE);
    public static final LocalAuthorityResource BANNER = new LocalAuthorityResource("banner", "banner", ".png", ILocalAuthorityRegistry.IMAGE_ASSETS_RESOURCE_TYPE);
    public static final LocalAuthorityResource LOGO_PDF = new LocalAuthorityResource("logoPDF", "logoPdf", ".png", ILocalAuthorityRegistry.IMAGE_ASSETS_RESOURCE_TYPE);
    public static final LocalAuthorityResource FAQ_FO = new LocalAuthorityResource("faqFO", "faqFo", ".pdf", ILocalAuthorityRegistry.PDF_ASSETS_RESOURCE_TYPE);
    public static final LocalAuthorityResource HELP_BO = new LocalAuthorityResource("helpBO", "helpBo", ".pdf", ILocalAuthorityRegistry.PDF_ASSETS_RESOURCE_TYPE);
    public static final LocalAuthorityResource HELP_FO = new LocalAuthorityResource("helpFO", "helpFo", ".pdf", ILocalAuthorityRegistry.PDF_ASSETS_RESOURCE_TYPE);
    public static final LocalAuthorityResource LEGAL = new LocalAuthorityResource("legal", "legal", ".pdf", ILocalAuthorityRegistry.PDF_ASSETS_RESOURCE_TYPE);
    public static final LocalAuthorityResource USE = new LocalAuthorityResource("use", "use", ".pdf", ILocalAuthorityRegistry.PDF_ASSETS_RESOURCE_TYPE);

    private String id;
    private String filename;
    private String extension;
    private String resourceType;

    private LocalAuthorityResource() {}

    private LocalAuthorityResource(String id, String filename, String extension, String resourceType) {
        this.id = id;
        this.filename = filename;
        this.extension = extension;
        this.resourceType = resourceType;
        localAuthorityResources.put(id, this);
    }

    public String getId() {
        return id;
    }

    public String getFilename() {
        return filename;
    }

    public String getExtension() {
        return extension;
    }

    public String getResourceType() {
        return resourceType;
    }
}
