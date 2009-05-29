package fr.cg95.cvq.service.authority;

import java.io.File;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import fr.cg95.cvq.exception.CvqConfigurationException;

public class LocalAuthoritiesLoader implements ResourceLoaderAware {

    private static Logger logger = Logger.getLogger(LocalAuthoritiesLoader.class);

    private ILocalAuthorityRegistry localAuthorityRegistry;

    private ResourceLoader resourceLoader = new DefaultResourceLoader();
    private PathMatchingResourcePatternResolver pmrpr;

    public void init() throws CvqConfigurationException {
        this.pmrpr = new PathMatchingResourcePatternResolver(resourceLoader);

        try {
        	final String assetsBase = localAuthorityRegistry.getAssetsBase();
        	// ensure assets directory exists, either the path matching resolver
        	// will fail with an error
        	File tempFile = new File(assetsBase);
        	if (!tempFile.exists()) {
        		logger.error("init() no assets directory found, please check the "
                        + "'assets.properties.path' value in your properties file");
        		logger.error("init() it is currently set to " + assetsBase);
        		return;
        	}
            final String pattern = assetsBase + "**/localAuthority-*.xml";
            logger.debug("init() local authority pattern : " + pattern);
            Resource[] localAuthoritiesResources = this.pmrpr.getResources("file:" + pattern);
            if (localAuthoritiesResources == null || localAuthoritiesResources.length == 0) {
                logger.error("init() no local authority found in " 
                        + localAuthorityRegistry.getAssetsBase());
                return;
            }
            logger.debug("init() loaded " + localAuthoritiesResources.length 
                    + " local authorities");

            this.localAuthorityRegistry.registerLocalAuthorities(localAuthoritiesResources);

        } catch (IOException ioe) {
            ioe.printStackTrace();
            throw new CvqConfigurationException("error while loading local authorities !");
        }
    }

    public void setLocalAuthorityRegistry(ILocalAuthorityRegistry localAuthorityRegistry) {
        this.localAuthorityRegistry = localAuthorityRegistry;
    }

    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }
}
