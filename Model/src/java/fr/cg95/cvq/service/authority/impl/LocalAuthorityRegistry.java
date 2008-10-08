package fr.cg95.cvq.service.authority.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.hibernate.SessionFactory;

import org.apache.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.core.io.Resource;

import fr.cg95.cvq.business.authority.LocalAuthority;
import fr.cg95.cvq.dao.authority.ILocalAuthorityDAO;
import fr.cg95.cvq.dao.hibernate.HibernateUtil;
import fr.cg95.cvq.exception.CvqConfigurationException;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.exception.CvqObjectNotFoundException;
import fr.cg95.cvq.permission.CvqPermissionException;
import fr.cg95.cvq.security.SecurityContext;
import fr.cg95.cvq.service.authority.ILocalAuthorityLifecycleAware;
import fr.cg95.cvq.service.authority.ILocalAuthorityRegistry;
import fr.cg95.cvq.service.authority.LocalAuthorityConfigurationBean;

/**
 * Implementation of the local authority registry.
 *
 * @author bor@zenexity.fr
 */
public class LocalAuthorityRegistry
    implements ILocalAuthorityRegistry, ApplicationContextAware, BeanFactoryAware {

    private static Logger logger = Logger.getLogger(LocalAuthorityRegistry.class);

    /** Used to store the currently deployed local authorities. */
    private Map<String, LocalAuthorityConfigurationBean> configurationBeansMap = 
        new HashMap<String, LocalAuthorityConfigurationBean>();

    /** The parent application context in which the application runs. */
    private ApplicationContext parentApplicationContext;

    /** Keep a map of all services interested in local authorities lifecycle */
    protected Collection allListenerServices;

    private ILocalAuthorityDAO localAuthorityDAO;
    
    private ListableBeanFactory beanFactory;

    private Boolean performDbUpdates;
    
    private String referentialBase;
    private String assetsBase;
    private String[] includedLocalAuthorities;
    private String localAuthoritiesListFilename;
    
    public void init() {
        Map services = beanFactory.getBeansOfType(ILocalAuthorityLifecycleAware.class, true, true);
        if (!services.isEmpty()) {
            allListenerServices = services.values();
        }
    }

    public LocalAuthorityConfigurationBean getLocalAuthorityBeanByUrl(final String url) {
        Iterator lacbIt = configurationBeansMap.values().iterator();
        while (lacbIt.hasNext()) {
            LocalAuthorityConfigurationBean lacb =
                (LocalAuthorityConfigurationBean) lacbIt.next();
            if (lacb.supportUrl(url))
                return lacb;
        }

        return null;
    }

    public LocalAuthorityConfigurationBean getLocalAuthorityBeanByName(final String name) {
        if (name == null)
            return null;

        return (LocalAuthorityConfigurationBean) configurationBeansMap.get(name.toLowerCase());
    }

    public LocalAuthorityConfigurationBean getLocalAuthorityBean(final LocalAuthority localAuthority) {
        if (localAuthority == null)
            return null;

        return (LocalAuthorityConfigurationBean)
            configurationBeansMap.get(localAuthority.getName().toLowerCase());
    }

    public LocalAuthority getLocalAuthorityByName(String name) {
        return localAuthorityDAO.findByName(name);
    }

    public Set getAllLocalAuthoritiesNames() {
        return configurationBeansMap.keySet();
    }

    public String getCurrentLocalAuthorityName() {
        return SecurityContext.getCurrentSite().getName();
    }
    
    public LocalAuthorityConfigurationBean getCurrentLocalAuthorityBean() {
        return SecurityContext.getCurrentConfigurationBean();
    }

    private File getAssetsFile(final String resourceType, final String localAuthorityName,
            final String filename, final boolean fallbackToDefault) {

        StringBuffer filePath = new StringBuffer().append(assetsBase)
            .append(localAuthorityName.toLowerCase()).append("/");
        
        if (resourceType.equals(IMAGE_ASSETS_RESOURCE_TYPE)) {
            filePath.append(IMAGE_ASSETS_RESOURCE_TYPE).append("/");
        } else if (resourceType.equals(LOCAL_REFERENTIAL_RESOURCE_TYPE)) {
            filePath.append(LOCAL_REFERENTIAL_RESOURCE_TYPE).append("/");
        } else if (resourceType.equals(EXTERNAL_REFERENTIAL_RESOURCE_TYPE)) {
            filePath.append(EXTERNAL_REFERENTIAL_RESOURCE_TYPE).append("/");
        } else if (resourceType.equals(TXT_ASSETS_RESOURCE_TYPE)) {
            filePath.append(TXT_ASSETS_RESOURCE_TYPE).append("/");
        } else if (resourceType.equals(XSL_RESOURCE_TYPE)) {
            filePath.append(XSL_RESOURCE_TYPE).append("/");
        } else if (resourceType.equals(HTML_RESOURCE_TYPE)) {
            filePath.append(HTML_RESOURCE_TYPE).append("/");
        } else {
            logger.warn("getAssetsFile() unrecognized resource type : " + resourceType);
            return null;
        }

        filePath.append(filename);
        logger.debug("getAssetsFile() searching file : " + filePath.toString());
        
        File resourceFile = new File(filePath.toString());
        if (!resourceFile.exists() && fallbackToDefault) {
            logger.warn("getAssetsFile() did not find " + filePath.toString() + ", trying default");
            return getReferentialResource(resourceType, filename);
        }

        return resourceFile;
    }

    public File getReferentialResource(final String resourceType, final String filename) {

        StringBuffer filePath = new StringBuffer().append(referentialBase);

        if (resourceType.equals(XSL_RESOURCE_TYPE)) {
            filePath.append("xsl/");
        } else if (resourceType.equals(LOCAL_REFERENTIAL_RESOURCE_TYPE)) {
            filePath.append("local_referential/");
        } else if (resourceType.equals(HTML_RESOURCE_TYPE)) {
            filePath.append("html/");
        } else if (resourceType.equals(EXTERNAL_REFERENTIAL_RESOURCE_TYPE)) {
            filePath.append("external_referential/");            
        } else {
            logger.warn("getReferentialResource() unrecognized resource type : " + resourceType);
            return null;
        }

        filePath.append(filename);
        
        logger.debug("getReferentialResource() searching file : " + filePath.toString());
        File resourceFile = new File(filePath.toString());
        if (!resourceFile.exists()) {
            logger.warn("getReferentialResource() did not find resource file : " + filename
                    + " of type " + resourceType);
            return null;
        }
        
        return resourceFile;
    }
    
    public File getCurrentLocalAuthorityResource(final String resourceType, final String filename,
                                                 final boolean fallbackToDefault) {

        String currentSiteName = SecurityContext.getCurrentSite().getName();
        return getAssetsFile(resourceType, currentSiteName, filename, fallbackToDefault);
    }


    public String getBufferedCurrentLocalAuthorityResource(final String resourceType, 
            final String filename, final boolean fallbackToDefault) {

        File resourceFile = 
            getCurrentLocalAuthorityResource(resourceType, filename, fallbackToDefault);
        if (resourceFile == null || !resourceFile.exists())
            return null;
        
        FileReader fileReader = null;
        String result = null;
        try {
            fileReader = new FileReader(resourceFile);
            char[] data = new char[(int) resourceFile.length()];
            fileReader.read(data);
            result = new String(data);
        } catch (FileNotFoundException e) {
            // unlikely to happen since we already checked just above
        } catch (IOException ioe) {
            logger.error("getBufferedCurrentLocalAuthorityResource() error while reading file " 
                    + resourceFile);
            logger.error("getBufferedCurrentLocalAuthorityResource() error : " + ioe);
            return null;
        } finally {
            if (fileReader != null)
                try {
                    fileReader.close();
                } catch (IOException e) {
                    logger.error("getBufferedCurrentLocalAuthorityResource() failed to close file reader stream !");
                    e.printStackTrace();
                }
        }

        return result;
    }

    public File getLocalAuthorityResource(final String resourceType, 
            final String localAuthorityName, final String filename, 
            final boolean fallbackToDefault) {

        return getAssetsFile(resourceType, localAuthorityName, filename, fallbackToDefault);
    }
    
    public void saveLocalAuthorityResource(String resourceType, String filename, byte[] data) throws CvqException{
        if (data == null) {
            logger.warn("saveLocalAuthorityResource() received empty data to save");
            return;
        }
        String currentSiteName = SecurityContext.getCurrentSite().getName();
        File assetsFile = getAssetsFile(resourceType, currentSiteName, filename, false);
        try {
            if (!assetsFile.exists())
                assetsFile.createNewFile();
            FileOutputStream fos = new FileOutputStream(assetsFile);
            fos.write(data);
            fos.flush();
            fos.close();
        } catch (FileNotFoundException e) {
            logger.error("saveLocalAuthorityResource() failel !" + e.getMessage());
            throw new CvqException(e.getMessage());
        } catch (IOException ioe) {
            logger.error("saveLocalAuthorityResource() failel !" + ioe.getMessage());
            throw new CvqException(ioe.getMessage());
        }
    }
    
    public void renameLocalAuthorityResource(String resourceType, String filename, String newFilename) 
        throws CvqException {
        
        String currentSiteName = SecurityContext.getCurrentSite().getName();
        File assetsFile = getAssetsFile(resourceType, currentSiteName, filename, false);

        if (!assetsFile.exists())
            throw new CvqException("File "+ assetsFile.getPath() + "/" + filename + " do not exists !");
        
       boolean succeed = 
           assetsFile.renameTo(getAssetsFile(resourceType, currentSiteName, newFilename, false));
       if (!succeed)
           throw new CvqException("Can't rename "
                   + assetsFile.getPath() + "/" + assetsFile.getName()
                   + " to "
                   + assetsFile.getPath() + "/" + newFilename);
    }
    
    public void removeLocalAuthorityResource(String resourceType, String filename) {
        String currentSiteName = SecurityContext.getCurrentSite().getName();
        File assetsFile = getAssetsFile(resourceType, currentSiteName, filename, false);
        if (!assetsFile.exists())
            return;
        if (!assetsFile.delete())
            logger.warn("removeLocalAuthorityResource() can't delete " + getAssetsBase() + filename );
    }

    public void registerLocalAuthorities(Resource[] localAuthoritiesFiles)
        throws CvqConfigurationException {

        GenericApplicationContext gac = new GenericApplicationContext(parentApplicationContext);
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(gac);
        if (includedLocalAuthorities == null) {
            xmlBeanDefinitionReader.loadBeanDefinitions(localAuthoritiesFiles);
        } else {
            for (int i = 0; i < localAuthoritiesFiles.length; i++) {
                String localAuthorityName =
                    localAuthoritiesFiles[i].getFilename().replaceFirst("localAuthority-", "")
                    .replaceFirst(".xml", "");
                logger.debug("registerLocalAuthorities() extracted " + localAuthorityName);
                for (int j = 0; j < includedLocalAuthorities.length; j++) {
                    if (includedLocalAuthorities[j].equals(localAuthorityName)) {
                        logger.debug("registerLocalAuthorities() loading " + localAuthorityName);
                        xmlBeanDefinitionReader.loadBeanDefinitions(localAuthoritiesFiles[i]);
                        break;
                    }
                }
            }
        }

        Map beansMap = gac.getBeansOfType(LocalAuthorityConfigurationBean.class, true, true);
        if (beansMap.isEmpty()) {
            logger.warn("registerLocalAuthorities() no local authority configuration bean found !");
            return;
        }

        Iterator localAuthoritiesIt = beansMap.values().iterator();
        while (localAuthoritiesIt.hasNext()) {
            LocalAuthorityConfigurationBean lacb =
                (LocalAuthorityConfigurationBean) localAuthoritiesIt.next();
            logger.debug("registerLocalAuthorities() adding [" + lacb.getName()
                         + "] to the list of known local authorities (" + lacb + ")");
            configurationBeansMap.put(lacb.getName().toLowerCase(), lacb);

            if (performDbUpdates.booleanValue()) {
                callback(lacb.getName(), this, "instantiateLocalAuthority", null);
                
                String externalReferentialDirBase = assetsBase + lacb.getName() + "/"
                    + EXTERNAL_REFERENTIAL_RESOURCE_TYPE;
                File file = new File(externalReferentialDirBase);
                if (!file.exists())
                    file.mkdir();
                
                String requestXmlDirBase = assetsBase + lacb.getName() + "/"
                + HTML_RESOURCE_TYPE;
                file = new File(requestXmlDirBase);
                if (!file.exists())
                    file.mkdir(); 
                
            }
            
            // notify listener services of the new local authority
            Iterator listenerIt = allListenerServices.iterator();
            while (listenerIt.hasNext()) {
                ILocalAuthorityLifecycleAware service =
                    (ILocalAuthorityLifecycleAware) listenerIt.next();
                service.addLocalAuthority(lacb.getName().toLowerCase());
            }
        }
        
        generateLocalAuthoritiesList();
    }

    protected void instantiateLocalAuthority(final String localAuthorityName) 
        throws CvqConfigurationException {
        
        LocalAuthorityConfigurationBean lacb =
            (LocalAuthorityConfigurationBean) configurationBeansMap.get(localAuthorityName);
        
        // create local authority entry in DB if it does not exist yet
        if (localAuthorityDAO.findByName(lacb.getName()) == null) {
            logger.debug("instantiateLocalAuthority() creating " + localAuthorityName);
            try {
                LocalAuthority localAuthority = new LocalAuthority();
                localAuthority.setName(lacb.getName().toLowerCase());
                localAuthority.setPostalCode(lacb.getPostalCode());
                localAuthorityDAO.create(localAuthority);
            } catch (CvqPermissionException cpe) {
                // can't happen, we are admin here
            } catch (Exception e) {
                throw new CvqConfigurationException("unable to create local authority " 
                        + localAuthorityName);
            }
        }
    }
    
    public void callback(String localAuthority, Object object, String callbackMethodName, 
            Object[] args) {
        
        LocalAuthorityConfigurationBean lacb =
            (LocalAuthorityConfigurationBean) configurationBeansMap.get(localAuthority);
        SessionFactory sessionFactory = lacb.getSessionFactory();
        HibernateUtil.setSessionFactory(sessionFactory);
        try {
            SecurityContext.setCurrentSite(lacb.getName(), SecurityContext.ADMIN_CONTEXT);
        } catch (CvqObjectNotFoundException confe) {
            // unlikely to happen
        }

        try {
            
            HibernateUtil.beginTransaction();

            if (args == null || args.length == 0) {
                Method method = 
                    object.getClass().getDeclaredMethod(callbackMethodName, new Class[] { String.class } );
                method.invoke(object, new Object[] { lacb.getName() } );
            } else {
                Object[] methArgs = new Object[args.length + 1];
                Class[] methDefArgs = new Class[args.length + 1];
                methArgs[0] = lacb.getName();
                methDefArgs[0] = String.class;
                for (int i=0; i < args.length; i++) {
                    methArgs[i + 1] = args[i];
                    methDefArgs[i + 1] = String.class;
                }
                Method method = 
                    object.getClass().getDeclaredMethod(callbackMethodName, methDefArgs);
                method.invoke(object, methArgs);
            }

            HibernateUtil.commitTransaction();

        } catch (Exception e) {
            logger.error("callback() got an exception, rollbacking");
//            e.printStackTrace();
            HibernateUtil.rollbackTransaction();
        } finally {
            HibernateUtil.closeSession();
            SecurityContext.resetCurrentSite();
        }
    }
    
	public void browseAndCallback(Object object, String callbackMethodName, 
            Object[] methodArgs) {
		Iterator localAuthoritiesIt = configurationBeansMap.keySet().iterator();
		while (localAuthoritiesIt.hasNext()) {
			String localAuthorityName = (String) localAuthoritiesIt.next();
            logger.debug("browseAndCallback() calling " + callbackMethodName
                    + " for " + localAuthorityName);
			callback(localAuthorityName, object, callbackMethodName, methodArgs);
        }
	}

    public void generateLocalAuthoritiesList() {
        Set allLocalAuthoriesNames = getAllLocalAuthoritiesNames();
        Iterator it = allLocalAuthoriesNames.iterator();

        try {
            String filename = getAssetsBase() + localAuthoritiesListFilename;
            logger.debug("generateLocalAuthoritiesList() writing list in " + filename);
            FileOutputStream fos = new FileOutputStream(filename);
            while (it.hasNext()) {
                String localAuth = (String) it.next();
                fos.write(localAuth.getBytes());
                fos.write('\n');
            }
            fos.close();
        } catch (Exception e) {
            logger.error("generateLocalAuthoritiesList() got exception while writing local authorities list");
            e.printStackTrace();
        }
    }

    public void setApplicationContext(final ApplicationContext applicationContext) {
        this.parentApplicationContext = applicationContext;
    }

    public void setBeanFactory(final BeanFactory beanFactory) throws BeansException {
        this.beanFactory = (ListableBeanFactory) beanFactory;
    }

    public void setReferentialBase(final String referentialBase) {
        if (!referentialBase.endsWith("/"))
            this.referentialBase = referentialBase + "/";
        else
            this.referentialBase = referentialBase;
    }

    public String getReferentialBase() {
        return this.referentialBase;
    }

    public String getAssetsBase() {
        return assetsBase;
    }

    public void setAssetsBase(String assetsBase) {
        if (!assetsBase.endsWith("/")) 
            this.assetsBase = assetsBase + "/";
        else
            this.assetsBase = assetsBase;
    }

    public void setLocalAuthorityDAO(ILocalAuthorityDAO localAuthorityDAO) {
        this.localAuthorityDAO = localAuthorityDAO;
    }

    public void setPerformDbUpdates(Boolean performDbUpdates) {
        if (performDbUpdates != null)
            this.performDbUpdates = performDbUpdates;
        else
            this.performDbUpdates = Boolean.FALSE;
    }

    public void setIncludes(final String includes) {
        if (!includes.equals("") && !includes.equals("**"))
            includedLocalAuthorities = includes.split(",");
    }
    
    public void setLocalAuthoritiesListFilename(final String localAuthoritiesListFilename) {
        this.localAuthoritiesListFilename = localAuthoritiesListFilename;
    }
}
