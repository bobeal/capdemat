package fr.cg95.cvq.service.request;

import org.apache.xmlbeans.XmlObject;

import fr.cg95.cvq.business.request.Request;
import fr.cg95.cvq.exception.CvqException;

public interface IRequestExportService {
    
    XmlObject fillRequestXml(Request request) throws CvqException;
}
