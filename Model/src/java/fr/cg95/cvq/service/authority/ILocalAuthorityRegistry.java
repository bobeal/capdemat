package fr.cg95.cvq.service.authority;

import java.io.File;
import java.util.Set;

import org.springframework.core.io.Resource;

import fr.cg95.cvq.business.authority.LocalAuthority;
import fr.cg95.cvq.exception.CvqConfigurationException;
import fr.cg95.cvq.exception.CvqException;

/**
 * Registry for registered local authorities.
 *
 * @author bor@zenexity.fr
 */
public interface ILocalAuthorityRegistry {

    String SERVICE_NAME = "localAuthorityRegistry";

    String XSL_RESOURCE_TYPE = "xsl";
    String LOCAL_REFERENTIAL_RESOURCE_TYPE = "local_referential";
    String EXTERNAL_REFERENTIAL_RESOURCE_TYPE = "external_referential";
    
    String IMAGE_ASSETS_RESOURCE_TYPE = "img";
    String TXT_ASSETS_RESOURCE_TYPE = "txt";
    String HTML_RESOURCE_TYPE = "html";
    
    LocalAuthorityConfigurationBean getLocalAuthorityBeanByUrl(final String url);
    LocalAuthorityConfigurationBean getLocalAuthorityBeanByName(final String name);
    LocalAuthorityConfigurationBean getLocalAuthorityBean(final LocalAuthority localAuthority);

    LocalAuthority getLocalAuthorityByName(final String name);
    
    Set getAllLocalAuthoritiesNames();

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
    File getCurrentLocalAuthorityResource(final String resourceType, final String filename, 
            final boolean fallbackToDefault);

    /**
     * Same as {@link #getCurrentLocalAuthorityResource(String, String, boolean)} but
     * with file content returned in a string.
     */
    String getBufferedCurrentLocalAuthorityResource(final String resourceType, 
            final String filename, final boolean fallbackToDefault);
    
    /**
     * Get resource pointed to by filename for the given local authority.
     *
     * @see #getCurrentLocalAuthorityResource
     */
    File getLocalAuthorityResource(final String resourceType, final String localAuthorityName,
            final String filename, final boolean fallbackToDefault);

    String getCurrentLocalAuthorityName();
    LocalAuthorityConfigurationBean getCurrentLocalAuthorityBean();
    
    void registerLocalAuthorities(Resource[] localAuthoritiesFiles)
        throws CvqConfigurationException;

    void callback(String localAuthority, Object object, String callbackMethodName, 
            Object[] methodArgs);
    void browseAndCallback(Object object, String callbackMethodName, Object[] methodArgs);
    
    /**
     * Generate a list of deployed local authorities in directory {@link #getAssetsBase()}.
     * Filename is specified in the configuration of this service.
     * This method is called by a Quartz scheduled job and the generated list can be used
     * for various tasks, like databases dumps.
     */
    void generateLocalAuthoritiesList();
    
    String getReferentialBase();
    String getAssetsBase();
    
    void saveLocalAuthorityResource(String resourceType, String filename, byte[] data) throws CvqException;
    void renameLocalAuthorityResource(String resourceType, String filename, String newFilename) throws CvqException;
    void removeLocalAuthorityResource(String resourceType, String filename);
    
}
