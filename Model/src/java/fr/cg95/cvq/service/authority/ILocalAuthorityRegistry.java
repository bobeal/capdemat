package fr.cg95.cvq.service.authority;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import org.springframework.core.io.Resource;

import fr.cg95.cvq.business.authority.LocalAuthority;
import fr.cg95.cvq.business.authority.LocalAuthorityResource;
import fr.cg95.cvq.business.authority.LocalAuthorityResource.Version;
import fr.cg95.cvq.exception.CvqConfigurationException;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.permission.CvqPermissionException;

/**
 * Registry for registered local authorities.
 *
 * @author bor@zenexity.fr
 */
public interface ILocalAuthorityRegistry {

    String XSL_RESOURCE_TYPE = "xsl";
    String LOCAL_REFERENTIAL_RESOURCE_TYPE = "local_referential";
    String EXTERNAL_REFERENTIAL_RESOURCE_TYPE = "external_referential";
    String REQUEST_XML_RESOURCE_TYPE = "xml_request";
    
    String CSS_ASSETS_RESOURCE_TYPE = "css";
    String IMAGE_ASSETS_RESOURCE_TYPE = "img";
    String TXT_ASSETS_RESOURCE_TYPE = "txt";
    String PDF_ASSETS_RESOURCE_TYPE = "pdf";
    
    String HTML_RESOURCE_TYPE = "html";
    String MAIL_TEMPLATES_TYPE = "html/templates/mails";
    
    LocalAuthorityConfigurationBean getLocalAuthorityBeanByName(final String name);
    LocalAuthorityConfigurationBean getLocalAuthorityBean(final LocalAuthority localAuthority);

    LocalAuthority getLocalAuthorityByName(final String name);

    /**
     * Retrieve the local authority which has registered this server name
     * or null if none have registered it
     */
    LocalAuthority getLocalAuthorityByServerName(final String serverName);

    /**
     * Add the server name to the ones the current local authority listens to,
     * and register it in the mapping
     */
    void addLocalAuthorityServerName(final String serverName)
        throws CvqPermissionException;

    /**
     * Register this serverName for current local authority in the mapping
     */
    void registerLocalAuthorityServerName(final String serverName);

    /**
     * Remove and unregister this serverName for current local authority
     */
    void removeLocalAuthorityServerName(final String serverName)
        throws CvqPermissionException;

    /**
     * Unregister this serverName for current local authority in the mapping
     */
    void unregisterLocalAuthorityServerName(final String serverName);

    /**
     * Return true if the server name isn't used or if it is used by current local authority.
     */
    boolean isAvailableLocalAuthorityServerName(final String serverName);

    /**
     * Replace existing serverNames with these new ones for current local authority,
     * and update mapping
     */
    void setLocalAuthorityServerNames(final TreeSet<String> serverNames)
        throws CvqException ;

    Set<String> getAllLocalAuthoritiesNames();

    /**
     * Return a common referential resource located in the referential repository.
     * 
     * @param resourceType one of {@link #XSL_RESOURCE_TYPE},
     *                            {@link #LOCAL_REFERENTIAL_RESOURCE_TYPE}
     *                         or {@link #EXTERNAL_REFERENTIAL_RESOURCE_TYPE}
     * @param filename name of the file to retrieve
     */
    File getReferentialResource(final String resourceType, final String filename);
    
    /**
     * Get resource pointed to by filename for the current local authority.
     *
     * @param resourceType one of {@link #IMAGE_ASSETS_RESOURCE_TYPE},
     *                            {@link #LOCAL_REFERENTIAL_RESOURCE_TYPE}
     *                         or {@link #EXTERNAL_REFERENTIAL_RESOURCE_TYPE}
     * @param filename file name of the resource to load
     * @param fallbackToDefault whether or not we fall back to default directory if resource is not
     *        in current local authority's directory
     */
    @Deprecated
    File getCurrentLocalAuthorityResource(final String resourceType, final String filename, 
            final boolean fallbackToDefault);

    /**
     * Same as {@link #getCurrentLocalAuthorityResource(String, String, boolean)} but
     * with file content returned in a string.
     */
    @Deprecated
    String getBufferedCurrentLocalAuthorityResource(final String resourceType, 
            final String filename, final boolean fallbackToDefault);

    /**
     * Same as {@link #getLocalAuthorityResourceFile(String, boolean)} but
     * with file content returned in a string.
     */
    String getBufferedLocalAuthorityResource(String id, boolean fallbackToDefault)
        throws CvqException;

    /**
     * Get the helps data for the given request type as a Map<v=stepName,k=helpDataAsString>.
     */
    Map<String,String> getBufferedCurrentLocalAuthorityRequestHelpMap(final String requestLabel);

    /**
     * Get the rules data for the given request type.
     */
    List<String> getLocalAuthorityRules(String requestTypeLabel);

    /**
     * Get resource pointed to by filename for the given local authority.
     *
     * @see #getCurrentLocalAuthorityResource
     */
    @Deprecated
    File getLocalAuthorityResource(final String localAuthorityName, final String resourceType,
            final String filename, final boolean fallbackToDefault);

    /**
     * Same as {@link #getLocalAuthorityResourceFile(String, LocalAuthorityResource.Version, boolean)}
     * for current version.
     */
    File getLocalAuthorityResourceFile(String id, boolean fallbackToDefault)
        throws CvqException;

    /**
     * Get the file for this local authority resource id and version in the current local authority assets.
     */
    File getLocalAuthorityResourceFile(String id, LocalAuthorityResource.Version version, boolean fallbackToDefault)
        throws CvqException;

    File getRequestXmlResource(Long id);
    
    void registerLocalAuthorities(Resource[] localAuthoritiesFiles)
        throws CvqConfigurationException;

    /**
     * The same as {@link browseAndCallback} but for a specific local authority.
     *
     * @see browseAndCallback
     */
    void callback(String localAuthority, Object object, String callbackMethodName, 
            Object[] methodArgs);

    /**
     * Browse all known local authorities and invoke the given callback method for
     * each of them.
     *
     * This method handles all of the context tasks : setting of the security
     * context, transaction management, ... callback methods only have to deal
     * with their business tasks.
     *
     * @param object the instance object to which belongs the callback method
     * @param callbackMethodName the name of the callback method to be called
     * @param methodArgs optional String arguments to be passed to the callback method
     */
    void browseAndCallback(Object object, String callbackMethodName, Object[] methodArgs);
    
    /**
     * Generate a list of deployed local authorities in directory {@link #getAssetsBase()}.
     *
     * Filename is specified in the configuration of this service.
     * This method is called by a Quartz scheduled job and the generated list can be used
     * for various tasks, like databases dumps.
     */
    void generateLocalAuthoritiesList();
    
    String getReferentialBase();
    
    String getAssetsBase();
    
    @Deprecated
    void saveLocalAuthorityResource(String resourceType, String filename, byte[] data)
        throws CvqException;

    /**
     * Save the data as the current version of this local authority resource in current local authority assets.
     */
    void saveLocalAuthorityResource(String id, byte[] data)
        throws CvqException;

    @Deprecated
    void renameLocalAuthorityResource(String resourceType, String filename, String newFilename)
        throws CvqException;

    /**
     * Move the file for this local authority resource from oldVersion to newVersion in current local authority assets.
     */
    void renameLocalAuthorityResource(String id, Version oldVersion, Version newVersion)
        throws CvqException;
    
    /**
     * Save the data as the current version of this local authority resource in current local authority assets,
     * and backup former current version as old version if it exists.
     */
    void replaceLocalAuthorityResource(String id, byte[] data)
        throws CvqException;

    /**
     * Switch current version and old version of this local authority resource in current local authority assets.
     */
    void rollbackLocalAuthorityResource(String id)
        throws CvqException;

    /**
     * Checks if this local authority resource has a file for this version in current local authority assets.
     */
    boolean hasLocalAuthorityResource(String id, Version version)
        throws CvqException;

    @Deprecated
    void removeLocalAuthorityResource(String resourceType, String filename);

    /**
     * Deletes all versions of this local authority resource in current local authority assets.
     */
    void removeLocalAuthorityResource(String id)
        throws CvqException;

    /**
     * Hack to regenerate the JPEG version of the logo for PDF files
     */
    void generateJPEGLogo();

    List<File> getLocalResourceContent(String resourceType) throws CvqException;
    List<File> getLocalResourceContent(String resourceType, String pattern) throws CvqException;

    /**
     * Updates local authority draft settings.
     * 
     * @param liveDuration the duration the draft will be kept in DB
     * @param notificationBeforeDelete notification before draft removal
     */
    @Deprecated
    void updateDraftSettings(Integer liveDuration, Integer notificationBeforeDelete) 
        throws CvqException;

    /**
     * Indicates if payments are enabled or disabled for current local authority
     */
    boolean isPaymentEnabled();
}
