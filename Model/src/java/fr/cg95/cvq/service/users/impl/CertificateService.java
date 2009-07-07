package fr.cg95.cvq.service.users.impl;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.apache.avalon.framework.logger.ConsoleLogger;
import org.apache.commons.lang.StringUtils;
import org.apache.fop.apps.Driver;
import org.apache.fop.apps.FOPException;
import org.apache.fop.configuration.Configuration;
import org.apache.fop.messaging.MessageHandler;
import org.apache.log4j.Logger;
import org.springframework.core.io.ClassPathResource;
import org.w3c.dom.Node;
import org.xml.sax.InputSource;

import fr.cg95.cvq.business.request.RequestForm;
import fr.cg95.cvq.business.request.RequestFormType;
import fr.cg95.cvq.business.request.RequestType;
import fr.cg95.cvq.dao.request.IRequestFormDAO;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.security.SecurityContext;
import fr.cg95.cvq.service.authority.ILocalAuthorityRegistry;
import fr.cg95.cvq.service.users.ICertificateService;
import fr.cg95.cvq.util.localization.ILocalizationService;

/**
 * @author bor@zenexity.fr
 *
 * @todo implement a cache mecanism
 */
public class CertificateService implements ICertificateService {

    private static Logger logger = Logger.getLogger(CertificateService.class);

    private String fopConfig;

    protected ILocalAuthorityRegistry localAuthorityRegistry;
    protected ILocalizationService localizationService;
    protected IRequestFormDAO requestFormDAO;
    
    public byte[] generateRequestCertificate(Node node, File xslFoFile)
        throws CvqException {

        if (xslFoFile == null) {
            logger.warn("generateRequestCertificate() No XSL-FO file provided, returning");
            return null;
        }

        return convertXmlSource2PDF(new DOMSource(node), xslFoFile);
    }

    public byte[] generateRequestCertificate(Node node, String xslFoFileName)
        throws CvqException {

        if (xslFoFileName == null) {
            logger.warn("generateRequestCertificate() No XSL-FO filename provided, returning");
            return null;
        }

        File xslFoFile =
            localAuthorityRegistry.getReferentialResource(ILocalAuthorityRegistry.XSL_RESOURCE_TYPE,
                    xslFoFileName);
        if (xslFoFile == null || !xslFoFile.exists()) {
            logger.warn("generateRequestCertificate() XSL-FO file denoted by name " + xslFoFileName 
                    + " does not exist on filesystem");
            return null;
        }

        return convertXmlSource2PDF(new DOMSource(node), xslFoFile);
    }

    public byte[] generateRequestCertificate(Node node, RequestType requestType)
        throws CvqException {

        RequestForm requestForm = 
            requestFormDAO.findByTypeAndRequest(RequestFormType.REQUEST_CERTIFICAT,
                    requestType.getLabel());
        if (requestForm == null) {
            logger.warn("generateRequestCertificate() No XSL files of type " + 
                    RequestFormType.REQUEST_CERTIFICAT + " found for request type " + 
                    requestType.getLabel() + ", returning");
            return null;
        }
        String xslFoFilename = requestForm.getXslFoFilename();

        File requestXslFoFile =
            localAuthorityRegistry.getReferentialResource(ILocalAuthorityRegistry.XSL_RESOURCE_TYPE,
                    xslFoFilename);
        if (requestXslFoFile == null || !requestXslFoFile.exists()) {
            logger.warn("generateRequestCertificate() XSL-FO file denoted by name " + xslFoFilename 
                    + " does not exist on filesystem");
            return null;
        }

        return convertXmlSource2PDF(new DOMSource(node), requestXslFoFile);
    }

    public byte[] generatePdf(Node node, Long requestFormIId) throws CvqException {
        
        RequestForm requestForm = 
            (RequestForm) requestFormDAO.findById(RequestForm.class, requestFormIId);
        
        File xslFoFile =
            localAuthorityRegistry.getReferentialResource(ILocalAuthorityRegistry.XSL_RESOURCE_TYPE,
                    requestForm.getXslFoFilename());
        if (xslFoFile == null || !xslFoFile.exists()) {
            logger.warn("generatePdf() XSL-FO file denoted by name " + xslFoFile 
                    + " does not exist on filesystem");
            return null;
        }
        
        return convertXmlSource2PDF(new DOMSource(node), xslFoFile);
    }
    
    /**
     * Converts a XML source to a PDF file using Saxon and FOP.
     * 
     * Shamelessly copied and adapted from examples within the FOP distribution.
     *
     * @param config the FOP config file
     * @param xmlSource the XML input source for XSLT transformation
     * @param xslFoFile the stylesheet file
     *
     * @throws CvqException
     */
    private byte[] convertXmlSource2PDF(Source xmlSource, File xslFoFile)
        throws CvqException {

        // First, transform XML to FO
        /////////////////////////////

        try {
            byte[] foData = null;
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            try {
                // setup XSLT
                TransformerFactory factory = TransformerFactory.newInstance();
                Transformer transformer = factory.newTransformer(new StreamSource(xslFoFile));

                transformer.setParameter("localAuthorityName",
                        localAuthorityRegistry.getAssetsBase()
                        + SecurityContext.getCurrentConfigurationBean().getName().toLowerCase());
                transformer.setParameter("friendlyLocalAuthorityName",
                        SecurityContext.getCurrentSite().getDisplayTitle());
                transformer.setParameter("localizationService", localizationService);
                
                File logoFile = new File(StringUtils.removeEnd(
                    localAuthorityRegistry.getLocalAuthorityResourceFile("logoPdf", false).getPath(), "png").concat("jpg"));
                if (!logoFile.exists()) {
                    localAuthorityRegistry.generateJPEGLogo();
                }
                transformer.setParameter("logoSource", logoFile.getPath());

                //Resulting SAX events (the generated FO) must be piped through to FOP
                Result res = new StreamResult(out);

                //Start XSLT transformation and FOP processing
                transformer.transform(xmlSource, res);

                foData = out.toByteArray();
            } finally {
                out.close();
            }

            // Then, transform FO to PDF
            ////////////////////////////

            //Construct driver
            Driver driver = new Driver();

            //Setup config
//            Options options = null;
//            if (config != null)
//                options = new Options(config);

            // Set the base dir to the xsl-fo file directory to be able to satisfy image references
            Configuration.put("baseDir", xslFoFile.getParent());

            //Setup logger
            org.apache.avalon.framework.logger.Logger logger =
                new ConsoleLogger(ConsoleLogger.LEVEL_ERROR);
            MessageHandler.setScreenLogger(logger);
            driver.setLogger(logger);

            //Setup Renderer (output format)
            driver.setRenderer(Driver.RENDER_PDF);

            out = new ByteArrayOutputStream();
            try {
                driver.setOutputStream(out);

                //Setup input
                InputStream in = new ByteArrayInputStream(foData);
                try {
                    driver.setInputSource(new InputSource(in));

                    //Process FO
                    driver.run();
                } finally {
                    in.close();
                }
            } finally {
                out.close();
            }

            return out.toByteArray();
        } catch (IOException ioe) {
            ioe.printStackTrace();
            logger.error("convertXmlSource2PDF() IO exception generating PDF");
            throw new CvqException("Unable to generate PDF");
        }
        catch (FOPException foe) {
            foe.printStackTrace();
            logger.error("convertXmlSource2PDF() FOP exception while generating PDF");
            throw new CvqException("Unable to generate PDF");
        } catch (TransformerException te) {
            te.printStackTrace();
            logger.error("convertXmlSource2PDF() Transformer exception while generating PDF");
            throw new CvqException("Error while generating PDF");
        }
    }

    private File gimmeFopConfigFile(String fopConfig) {

        if (fopConfig != null) {
            File config = null;
            try {
                ClassPathResource cpr = new ClassPathResource(fopConfig);
                config = cpr.getFile();
            } catch (FileNotFoundException fnfe) {
                // we can do our job without one
                logger.warn("gimmeFopConfigFile() File " + fopConfig + " not found on classpath");
                return null;
            } catch (IOException ioe) {
                // we can do our job without one
                logger.warn("gimmeFopConfigFile() IO error while loading file " + fopConfig);
                return null;
            }

            return config;
        } else {
            return null;
        }
    }

    public void setLocalAuthorityRegistry(ILocalAuthorityRegistry localAuthorityRegistry) {
        this.localAuthorityRegistry = localAuthorityRegistry;
    }

    public void setLocalizationService(ILocalizationService localizationService) {
        this.localizationService = localizationService;
    }

    public void setRequestFormDAO(IRequestFormDAO requestFormDAO) {
        this.requestFormDAO = requestFormDAO;
    }

    public void setFopConfig(String fopConfig) {
        this.fopConfig = fopConfig;
    }
}
