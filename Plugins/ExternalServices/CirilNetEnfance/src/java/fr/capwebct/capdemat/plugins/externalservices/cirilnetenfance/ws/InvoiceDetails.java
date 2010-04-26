package fr.capwebct.capdemat.plugins.externalservices.cirilnetenfance.ws;

import java.io.ByteArrayOutputStream;
import java.net.URL;

import javax.xml.soap.MessageFactory;
import javax.xml.soap.Name;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPBodyElement;
import javax.xml.soap.SOAPConnection;
import javax.xml.soap.SOAPConnectionFactory;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPMessage;
import javax.xml.soap.SOAPPart;

import org.apache.log4j.Logger;
import org.jdom.Document;
import org.jdom.input.DOMBuilder;

public class InvoiceDetails {

    private static Logger logger = Logger.getLogger(InvoiceDetails.class);
    private String endPoint;
    private String postalCode;
    private String externalApplicationId;
    private String externalId;
    private String invoiceId;
    
    public InvoiceDetails() {
    }
   
    public InvoiceDetails(String endPoint, String postalCode, String externalApplicationId,
            String externalId, String invoiceId) {
        super();
        this.endPoint = endPoint;
        this.postalCode = postalCode;
        this.externalApplicationId = externalApplicationId;
        this.externalId = externalId;
        this.invoiceId = invoiceId;
    }

    public Document getXmlInvoiceDetail() {
        Document doc = new Document();
        try {
            URL url = new URL(endPoint);
            
            // creating connexion object
            SOAPConnectionFactory scFactoryInvoice = SOAPConnectionFactory.newInstance();
            SOAPConnection con = scFactoryInvoice.createConnection();
            
            // creating soap message
            MessageFactory factory = MessageFactory.newInstance();
            SOAPMessage message = factory.createMessage();
            
            // creating soap message part
            SOAPPart soapPart = message.getSOAPPart();
            SOAPEnvelope enveloppe = soapPart.getEnvelope();
            
            // build soap message body
            SOAPHeader header = enveloppe.getHeader();
            header.detachNode();
            SOAPBody body = enveloppe.getBody();
            Name bodyName = enveloppe.createName("invoiceDetails","q1", "Ciril:Enfance:ServicesEnfance");
            SOAPBodyElement gtl = body.addBodyElement(bodyName);
            Name rootElement = enveloppe.createName("invoiceDetailsRequest");
            Name firstElement = enveloppe.createName("LocalAuthority");
            Name secondthElement = enveloppe.createName("ExternalApplicationId");
            Name thirdthElement = enveloppe.createName("ExternalFamilyAccountId");
            Name fourthElement = enveloppe.createName("InvoiceId");
            SOAPElement rt = gtl.addChildElement(rootElement);
            SOAPElement f1 = rt.addChildElement(firstElement);
            SOAPElement f2 = rt.addChildElement(secondthElement);
            SOAPElement f3 = rt.addChildElement(thirdthElement);
            SOAPElement f4 = rt.addChildElement(fourthElement);
            f1.addTextNode(postalCode);
            f2.addTextNode(externalApplicationId);
            f3.addTextNode(externalId);
            f4.addTextNode(invoiceId);
            
            ByteArrayOutputStream outstream = new ByteArrayOutputStream();
            message.writeTo(outstream);
            String envoi = outstream.toString("UTF-8");            
            logger.debug("InvoiceDetails() message envoy� : " + envoi);
            
            SOAPMessage response = con.call(message, url);
            
            ByteArrayOutputStream instream = new ByteArrayOutputStream();
            response.writeTo(instream);
            String reponse = instream.toString("UTF-8");
            logger.debug("InvoiceDetails() message envoy� : " + reponse);
            
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

    public final String getPostalCode() {
        return postalCode;
    }

    public final void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public final String getExternalApplicationId() {
        return externalApplicationId;
    }

    public final void setExternalApplicationId(String externalApplicationId) {
        this.externalApplicationId = externalApplicationId;
    }

    public final String getExternalId() {
        return externalId;
    }

    public final void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    public final String getInvoiceId() {
        return invoiceId;
    }

    public final void setInvoiceId(String invoiceId) {
        this.invoiceId = invoiceId;
    }

    
    
}
