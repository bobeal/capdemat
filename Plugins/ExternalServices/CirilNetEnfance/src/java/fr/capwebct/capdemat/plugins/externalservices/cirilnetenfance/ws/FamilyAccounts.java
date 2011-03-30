package fr.capwebct.capdemat.plugins.externalservices.cirilnetenfance.ws;



import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.soap.MessageFactory;
import javax.xml.soap.Name;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPBodyElement;
import javax.xml.soap.SOAPConnection;
import javax.xml.soap.SOAPConnectionFactory;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPMessage;
import javax.xml.soap.SOAPPart;

import org.apache.log4j.Logger;
import org.jdom.Document;
import org.jdom.input.DOMBuilder;

public class FamilyAccounts {
    
    private static Logger logger = Logger.getLogger(FamilyAccounts.class);
    private String endPoint;
    private String zipCode;
    private Long homeFolderId;
    private String externalCapDematId;
    private String externalId;
    
    public FamilyAccounts() {}
    
    public FamilyAccounts(String endPoint, String zipCode, Long homeFolderId, String externalCapDematId, String externalId){
        super();
        this.endPoint = endPoint;
        this.zipCode = zipCode;
        this.homeFolderId = homeFolderId;
        this.externalCapDematId = externalCapDematId;
        this.externalId = externalId;
    }
    
    public Document getFamilyResponse() throws SOAPException, MalformedURLException {
        
        Document doc = new Document();
        try {
            logger.debug("FamilyAccount() getfamilyresponse get endpoint : " + endPoint);
            URL url = new URL(endPoint);
            
            // creating connection object
            SOAPConnectionFactory scFactory = SOAPConnectionFactory.newInstance();
            SOAPConnection con = scFactory.createConnection();
            
            // creating soap message
            MessageFactory factory = MessageFactory.newInstance();
            SOAPMessage message = factory.createMessage();
            
            SOAPPart soapPart = message.getSOAPPart();
            SOAPEnvelope enveloppe = soapPart.getEnvelope();
            
            SOAPHeader header = enveloppe.getHeader();
            header.detachNode();
            // creating body of soap message
            SOAPBody body = enveloppe.getBody();
            Name bodyName = enveloppe.createName("familyAccounts","tns", "Ciril:Enfance:ServicesEnfance");
            SOAPBodyElement gtl = body.addBodyElement(bodyName);
            Name rootElement = enveloppe.createName("familyAccountsRequest");
            Name firstElement = enveloppe.createName("LocalAuthority");
            Name secondthElement = enveloppe.createName("HomeFolderId");
            Name thirdthElement = enveloppe.createName("ExternalCapDematId");
            Name fourthElement = enveloppe.createName("ExternalId");
            SOAPElement rt = gtl.addChildElement(rootElement);
            SOAPElement f1 = rt.addChildElement(firstElement);
            SOAPElement f2 = rt.addChildElement(secondthElement);
            SOAPElement f3 = rt.addChildElement(thirdthElement);
            SOAPElement f4 = rt.addChildElement(fourthElement);
            f1.addTextNode(zipCode);
            f2.addTextNode(String.valueOf(homeFolderId));
            f3.addTextNode(externalCapDematId);
            f4.addTextNode(externalId);
            
            ByteArrayOutputStream outStream = new ByteArrayOutputStream();
            message.writeTo(outStream);
            String envoi = outStream.toString("UTF-8");
            logger.debug("FamilyAccounts() message envoy� : " + envoi);
            
            // send message
            SOAPMessage response = con.call(message, url);
            
            // get r�ponse
            ByteArrayOutputStream outStream2 = new ByteArrayOutputStream();
            response.writeTo(outStream2);
            String reponse = outStream2.toString("UTF-8");
            logger.debug("FamilyAccounts() message re�u : " + reponse);
            
            SOAPPart sp = response.getSOAPPart();
            SOAPEnvelope env = sp.getEnvelope();
            SOAPBody sb = env.getBody();
            org.w3c.dom.Document result = sb.extractContentAsDocument();
            
            con.close();
            DOMBuilder builder = new DOMBuilder();
            doc = (Document) builder.build(result);
        } catch (Exception e) {
            e.printStackTrace();        
        }
        return doc;
    }
    
    public final String getEndPoint() {
        return endPoint;
    }

    public final void setEndPoint(String endPoint) {
        this.endPoint = endPoint;
    }

    public final String getZipCode() {
        return zipCode;
    }

    public final void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public final Long getHomeFolderId() {
        return homeFolderId;
    }

    public final void setHomeFolderId(Long homeFolderId) {
        this.homeFolderId = homeFolderId;
    }

    public final String getExternalCapDematId() {
        return externalCapDematId;
    }

    public final void setExternalCapDematId(String externalCapDematId) {
        this.externalCapDematId = externalCapDematId;
    }

    public final String getExternalId() {
        return externalId;
    }

    public final void setExternalId(String externalId) {
        this.externalId = externalId;
    }

   

}
