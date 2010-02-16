
package fr.cg95.cvq.business.request.civil;

import java.io.Serializable;
import java.math.BigInteger;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.xmlbeans.XmlOptions;

import fr.cg95.cvq.business.authority.*;
import fr.cg95.cvq.business.request.*;
import fr.cg95.cvq.business.users.*;
import fr.cg95.cvq.xml.common.*;
import fr.cg95.cvq.xml.request.civil.*;

/**
 * Generated class file, do not edit !
 */
public class DeathDetailsRequest extends Request implements Serializable {

    private static final long serialVersionUID = 1L;

    private DeathDetailsRequestData deathDetailsRequestData;

    public DeathDetailsRequest(RequestData requestData, DeathDetailsRequestData deathDetailsRequestData) {
        super(requestData);
        this.deathDetailsRequestData = deathDetailsRequestData;
    }

    public DeathDetailsRequest() {
        super();
        this.deathDetailsRequestData = new DeathDetailsRequestData();
    }

    /**
     * Reserved for RequestDAO !
     */
    @Override
    public DeathDetailsRequestData getSpecificData() {
        return deathDetailsRequestData;
    }

    /**
     * Reserved for RequestDAO !
     */
    public void setSpecificData(DeathDetailsRequestData deathDetailsRequestData) {
        this.deathDetailsRequestData = deathDetailsRequestData;
    }

    @Override
    public final String modelToXmlString() {
        DeathDetailsRequestDocument object = this.modelToXml();
        XmlOptions opts = new XmlOptions();
        opts.setSavePrettyPrint();
        opts.setSavePrettyPrintIndent(4);
        opts.setUseDefaultNamespace();
        opts.setCharacterEncoding("UTF-8");
        return object.xmlText(opts);
    }

    @Override
    public final DeathDetailsRequestDocument modelToXml() {
        
        Calendar calendar = Calendar.getInstance();
        Date date = null;
        DeathDetailsRequestDocument deathDetailsRequestDoc = DeathDetailsRequestDocument.Factory.newInstance();
        DeathDetailsRequestDocument.DeathDetailsRequest deathDetailsRequest = deathDetailsRequestDoc.addNewDeathDetailsRequest();
        super.fillCommonXmlInfo(deathDetailsRequest);
        int i = 0;
        
        deathDetailsRequest.setDeathFirstNames(getDeathFirstNames());
      
        deathDetailsRequest.setDeathCity(getDeathCity());
      
        if (getFormat() != null)
            deathDetailsRequest.setFormat(fr.cg95.cvq.xml.request.civil.DeathCertificateFormatType.Enum.forString(getFormat().toString()));
      
        if (getCopies() != null)
            deathDetailsRequest.setCopies(new BigInteger(getCopies().toString()));
      
        deathDetailsRequest.setComment(getComment());
      
        if (getMotive() != null)
            deathDetailsRequest.setMotive(fr.cg95.cvq.xml.request.civil.DeathCertificateMotiveType.Enum.forString(getMotive().toString()));
      
        deathDetailsRequest.setDeathPostalCode(getDeathPostalCode());
      
        deathDetailsRequest.setDeathLastName(getDeathLastName());
      
        date = getDeathDate();
        if (date != null) {
            calendar.setTime(date);
            deathDetailsRequest.setDeathDate(calendar);
        }
      
        return deathDetailsRequestDoc;
    }

    @Override
    public final DeathDetailsRequestDocument.DeathDetailsRequest modelToXmlRequest() {
        return modelToXml().getDeathDetailsRequest();
    }

    public static DeathDetailsRequest xmlToModel(DeathDetailsRequestDocument deathDetailsRequestDoc) {
        DeathDetailsRequestDocument.DeathDetailsRequest deathDetailsRequestXml = deathDetailsRequestDoc.getDeathDetailsRequest();
        Calendar calendar = Calendar.getInstance();
        List list = new ArrayList();
        DeathDetailsRequest deathDetailsRequest = new DeathDetailsRequest();
        deathDetailsRequest.fillCommonModelInfo(deathDetailsRequest, deathDetailsRequestXml);
        
        deathDetailsRequest.setDeathFirstNames(deathDetailsRequestXml.getDeathFirstNames());
      
        deathDetailsRequest.setDeathCity(deathDetailsRequestXml.getDeathCity());
      
        if (deathDetailsRequestXml.getFormat() != null)
            deathDetailsRequest.setFormat(fr.cg95.cvq.business.request.civil.DeathCertificateFormatType.forString(deathDetailsRequestXml.getFormat().toString()));
        else
            deathDetailsRequest.setFormat(fr.cg95.cvq.business.request.civil.DeathCertificateFormatType.getDefaultDeathCertificateFormatType());
      
        deathDetailsRequest.setCopies(deathDetailsRequestXml.getCopies());
      
        deathDetailsRequest.setComment(deathDetailsRequestXml.getComment());
      
        if (deathDetailsRequestXml.getMotive() != null)
            deathDetailsRequest.setMotive(fr.cg95.cvq.business.request.civil.DeathCertificateMotiveType.forString(deathDetailsRequestXml.getMotive().toString()));
        else
            deathDetailsRequest.setMotive(fr.cg95.cvq.business.request.civil.DeathCertificateMotiveType.getDefaultDeathCertificateMotiveType());
      
        deathDetailsRequest.setDeathPostalCode(deathDetailsRequestXml.getDeathPostalCode());
      
        deathDetailsRequest.setDeathLastName(deathDetailsRequestXml.getDeathLastName());
      
        calendar = deathDetailsRequestXml.getDeathDate();
        if (calendar != null) {
            deathDetailsRequest.setDeathDate(calendar.getTime());
        }
      
        return deathDetailsRequest;
    }

  
    public final void setDeathFirstNames(final String deathFirstNames) {
        deathDetailsRequestData.setDeathFirstNames(deathFirstNames);
    }

    public final String getDeathFirstNames() {
        return deathDetailsRequestData.getDeathFirstNames();
    }
  
    public final void setDeathCity(final String deathCity) {
        deathDetailsRequestData.setDeathCity(deathCity);
    }

    public final String getDeathCity() {
        return deathDetailsRequestData.getDeathCity();
    }
  
    public final void setFormat(final fr.cg95.cvq.business.request.civil.DeathCertificateFormatType format) {
        deathDetailsRequestData.setFormat(format);
    }

    public final fr.cg95.cvq.business.request.civil.DeathCertificateFormatType getFormat() {
        return deathDetailsRequestData.getFormat();
    }
  
    public final void setCopies(final java.math.BigInteger copies) {
        deathDetailsRequestData.setCopies(copies);
    }

    public final java.math.BigInteger getCopies() {
        return deathDetailsRequestData.getCopies();
    }
  
    public final void setComment(final String comment) {
        deathDetailsRequestData.setComment(comment);
    }

    public final String getComment() {
        return deathDetailsRequestData.getComment();
    }
  
    public final void setMotive(final fr.cg95.cvq.business.request.civil.DeathCertificateMotiveType motive) {
        deathDetailsRequestData.setMotive(motive);
    }

    public final fr.cg95.cvq.business.request.civil.DeathCertificateMotiveType getMotive() {
        return deathDetailsRequestData.getMotive();
    }
  
    public final void setDeathPostalCode(final String deathPostalCode) {
        deathDetailsRequestData.setDeathPostalCode(deathPostalCode);
    }

    public final String getDeathPostalCode() {
        return deathDetailsRequestData.getDeathPostalCode();
    }
  
    public final void setDeathLastName(final String deathLastName) {
        deathDetailsRequestData.setDeathLastName(deathLastName);
    }

    public final String getDeathLastName() {
        return deathDetailsRequestData.getDeathLastName();
    }
  
    public final void setDeathDate(final java.util.Date deathDate) {
        deathDetailsRequestData.setDeathDate(deathDate);
    }

    public final java.util.Date getDeathDate() {
        return deathDetailsRequestData.getDeathDate();
    }
  
}
