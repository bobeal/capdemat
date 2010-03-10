package fr.cg95.cvq.service.request;

import java.io.IOException;
import java.util.Collection;

import org.codehaus.groovy.control.CompilationFailedException;

import com.lowagie.text.DocumentException;

import fr.cg95.cvq.business.request.Request;
import fr.cg95.cvq.business.request.RequestDocument;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.service.request.annotation.IsRequest;

/**
 * Service dedicated to various pdf files generation.
 *
 * @author bor@zenexity.fr
 */
public interface IRequestPdfService {

    /**
     * Generate a PDF representation of a request.
     */
    byte[] generateCertificate(Request request)
        throws CvqException;

    byte[] generateArchive(@IsRequest Long requestId)
        throws CvqException, CompilationFailedException, ClassNotFoundException, IOException,
            DocumentException;

    public byte[] generateDocumentsArchive(Collection<RequestDocument> requestDocuments)
        throws CvqException;
}
