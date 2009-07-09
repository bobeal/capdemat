package fr.cg95.cvq.service.users;

import java.io.File;

import org.w3c.dom.Node;

import fr.cg95.cvq.business.request.RequestType;
import fr.cg95.cvq.exception.CvqException;

/**
 * Service dedicated to various pdf files generation.
 *
 * @author bor@zenexity.fr
 */
public interface ICertificateService {

    /**
     * Generate a certificate for the given XML node using the given XSL-FO stylesheet file.
     *
     * @param node The XML node for which we want a certificate
     * @param xslFoFile An XSL-FO stylesheet file
     */
    byte[] generateRequestCertificate(Node node, File xslFoFile)
        throws CvqException;
    
    /**
     * Generate a certificate for the given XML node using the given XSL-FO stylesheet filename.
     * The XSL-FO stylesheet file is loaded from the common XSL-FO repository.
     *
     * @param node The XML node for which we want a certificate
     * @param fopConfig An optional FOP configuration file
     * @param xslFoFileName An XSL-FO stylesheet filename
     */
    byte[] generateRequestCertificate(Node node, String xslFoFileName)
        throws CvqException;

    /**
     * Generate a certificate for the given XML node. The XSL-FO file used is the default one
     * for the given request type.
     *
     * @param node The XML node for which we want a certificate
     * @param fopConfig An optional FOP configuration file
     * @param requestType The type of the request corresponding to the XML node
     */
    byte[] generateRequestCertificate(Node node, RequestType requestType)
        throws CvqException;
    
    /**
     * Generate a PDF from xmlNode data and xsl-fo stylesheet contained by requestForm.
     * 
     * @param requestFormId the id of the request form containing xsl-fo stylesheet
     */
    byte[] generatePdf(Node xmlNode, Long requestFormId) throws CvqException;
}
