
package fr.cg95.cvq.business.request.civil;

import java.io.Serializable;
import java.math.BigInteger;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.joda.time.LocalTime;

import net.sf.oval.constraint.AssertValid;
import org.apache.xmlbeans.XmlOptions;
import fr.cg95.cvq.business.authority.*;
import fr.cg95.cvq.business.request.*;
import fr.cg95.cvq.business.request.annotation.*;
import fr.cg95.cvq.business.users.*;
import fr.cg95.cvq.xml.common.*;
import fr.cg95.cvq.xml.request.civil.*;
import fr.cg95.cvq.service.request.condition.IConditionChecker;

/**
 * Generated class file, do not edit !
 */
public class BirthDetailsRequest extends Request implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final Map<String, IConditionChecker> conditions = BirthDetailsRequestData.conditions;

    @AssertValid(message = "")
    private BirthDetailsRequestData birthDetailsRequestData;

    public BirthDetailsRequest(RequestData requestData, BirthDetailsRequestData birthDetailsRequestData) {
        super(requestData);
        this.birthDetailsRequestData = birthDetailsRequestData;
    }

    public BirthDetailsRequest() {
        super();
        this.birthDetailsRequestData = new BirthDetailsRequestData();
    }

    /**
     * Reserved for RequestDAO !
     */
    @Override
    public BirthDetailsRequestData getSpecificData() {
        return birthDetailsRequestData;
    }

    /**
     * Reserved for RequestDAO !
     */
    public void setSpecificData(BirthDetailsRequestData birthDetailsRequestData) {
        this.birthDetailsRequestData = birthDetailsRequestData;
    }

    @Override
    public final String modelToXmlString() {
        BirthDetailsRequestDocument object = this.modelToXml();
        XmlOptions opts = new XmlOptions();
        opts.setSavePrettyPrint();
        opts.setSavePrettyPrintIndent(4);
        opts.setUseDefaultNamespace();
        opts.setCharacterEncoding("UTF-8");
        return object.xmlText(opts);
    }

    @Override
    public final BirthDetailsRequestDocument modelToXml() {
        
        Calendar calendar = Calendar.getInstance();
        LocalTime localTime = new LocalTime();
        Date date = null;
        BirthDetailsRequestDocument birthDetailsRequestDoc = BirthDetailsRequestDocument.Factory.newInstance();
        BirthDetailsRequestDocument.BirthDetailsRequest birthDetailsRequest = birthDetailsRequestDoc.addNewBirthDetailsRequest();
        super.fillCommonXmlInfo(birthDetailsRequest);
        int i = 0;
        
        birthDetailsRequest.setBirthCity(getBirthCity());
      
        date = getBirthDate();
        if (date != null) {
            calendar.setTime(date);
            birthDetailsRequest.setBirthDate(calendar);
        }
      
        birthDetailsRequest.setBirthFirstNames(getBirthFirstNames());
      
        birthDetailsRequest.setBirthLastName(getBirthLastName());
      
        birthDetailsRequest.setBirthMarriageName(getBirthMarriageName());
      
        birthDetailsRequest.setBirthPostalCode(getBirthPostalCode());
      
        birthDetailsRequest.setComment(getComment());
      
        if (getCopies() != null)
            birthDetailsRequest.setCopies(new BigInteger(getCopies().toString()));
        FatherInformationType fatherInformationTypeFatherInformation = birthDetailsRequest.addNewFatherInformation();
        fatherInformationTypeFatherInformation.setFatherFirstNames(getFatherFirstNames());
      
        fatherInformationTypeFatherInformation.setFatherLastName(getFatherLastName());
      
        if (getFormat() != null)
            birthDetailsRequest.setFormat(fr.cg95.cvq.xml.request.civil.BirthCertificateFormatType.Enum.forString(getFormat().toString()));
        MotherInformationType motherInformationTypeMotherInformation = birthDetailsRequest.addNewMotherInformation();
        motherInformationTypeMotherInformation.setMotherFirstNames(getMotherFirstNames());
      
        motherInformationTypeMotherInformation.setMotherMaidenName(getMotherMaidenName());
      
        if (getMotive() != null)
            birthDetailsRequest.setMotive(fr.cg95.cvq.xml.request.civil.BirthCertificateMotiveType.Enum.forString(getMotive().toString()));
      
        if (getRequesterQuality() != null)
            birthDetailsRequest.setRequesterQuality(fr.cg95.cvq.xml.request.civil.BirthRequesterQualityType.Enum.forString(getRequesterQuality().toString()));
      
        birthDetailsRequest.setRequesterQualityPrecision(getRequesterQualityPrecision());
      
        return birthDetailsRequestDoc;
    }

    @Override
    public final BirthDetailsRequestDocument.BirthDetailsRequest modelToXmlRequest() {
        return modelToXml().getBirthDetailsRequest();
    }

    public static BirthDetailsRequest xmlToModel(BirthDetailsRequestDocument birthDetailsRequestDoc) {
        BirthDetailsRequestDocument.BirthDetailsRequest birthDetailsRequestXml = birthDetailsRequestDoc.getBirthDetailsRequest();
        Calendar calendar = Calendar.getInstance();
        LocalTime localTime = new LocalTime();
        List list = new ArrayList();
        BirthDetailsRequest birthDetailsRequest = new BirthDetailsRequest();
        birthDetailsRequest.fillCommonModelInfo(birthDetailsRequest, birthDetailsRequestXml);
        
        birthDetailsRequest.setBirthCity(birthDetailsRequestXml.getBirthCity());
      
        calendar = birthDetailsRequestXml.getBirthDate();
        if (calendar != null) {
            birthDetailsRequest.setBirthDate(calendar.getTime());
        }
      
        birthDetailsRequest.setBirthFirstNames(birthDetailsRequestXml.getBirthFirstNames());
      
        birthDetailsRequest.setBirthLastName(birthDetailsRequestXml.getBirthLastName());
      
        birthDetailsRequest.setBirthMarriageName(birthDetailsRequestXml.getBirthMarriageName());
      
        birthDetailsRequest.setBirthPostalCode(birthDetailsRequestXml.getBirthPostalCode());
      
        birthDetailsRequest.setComment(birthDetailsRequestXml.getComment());
      
        birthDetailsRequest.setCopies(birthDetailsRequestXml.getCopies());
      
        birthDetailsRequest.setFatherFirstNames(birthDetailsRequestXml.getFatherInformation().getFatherFirstNames());
      
        birthDetailsRequest.setFatherLastName(birthDetailsRequestXml.getFatherInformation().getFatherLastName());
      
        if (birthDetailsRequestXml.getFormat() != null)
            birthDetailsRequest.setFormat(fr.cg95.cvq.business.request.civil.BirthCertificateFormatType.forString(birthDetailsRequestXml.getFormat().toString()));
        else
            birthDetailsRequest.setFormat(fr.cg95.cvq.business.request.civil.BirthCertificateFormatType.getDefaultBirthCertificateFormatType());
      
        birthDetailsRequest.setMotherFirstNames(birthDetailsRequestXml.getMotherInformation().getMotherFirstNames());
      
        birthDetailsRequest.setMotherMaidenName(birthDetailsRequestXml.getMotherInformation().getMotherMaidenName());
      
        if (birthDetailsRequestXml.getMotive() != null)
            birthDetailsRequest.setMotive(fr.cg95.cvq.business.request.civil.BirthCertificateMotiveType.forString(birthDetailsRequestXml.getMotive().toString()));
        else
            birthDetailsRequest.setMotive(fr.cg95.cvq.business.request.civil.BirthCertificateMotiveType.getDefaultBirthCertificateMotiveType());
      
        if (birthDetailsRequestXml.getRequesterQuality() != null)
            birthDetailsRequest.setRequesterQuality(fr.cg95.cvq.business.request.civil.BirthRequesterQualityType.forString(birthDetailsRequestXml.getRequesterQuality().toString()));
        else
            birthDetailsRequest.setRequesterQuality(fr.cg95.cvq.business.request.civil.BirthRequesterQualityType.getDefaultBirthRequesterQualityType());
      
        birthDetailsRequest.setRequesterQualityPrecision(birthDetailsRequestXml.getRequesterQualityPrecision());
      
        return birthDetailsRequest;
    }

  
    public final void setBirthCity(final String birthCity) {
        birthDetailsRequestData.setBirthCity(birthCity);
    }

    
    public final String getBirthCity() {
        return birthDetailsRequestData.getBirthCity();
    }
  
    public final void setBirthDate(final java.util.Date birthDate) {
        birthDetailsRequestData.setBirthDate(birthDate);
    }

    
    public final java.util.Date getBirthDate() {
        return birthDetailsRequestData.getBirthDate();
    }
  
    public final void setBirthFirstNames(final String birthFirstNames) {
        birthDetailsRequestData.setBirthFirstNames(birthFirstNames);
    }

    
    public final String getBirthFirstNames() {
        return birthDetailsRequestData.getBirthFirstNames();
    }
  
    public final void setBirthLastName(final String birthLastName) {
        birthDetailsRequestData.setBirthLastName(birthLastName);
    }

    
    public final String getBirthLastName() {
        return birthDetailsRequestData.getBirthLastName();
    }
  
    public final void setBirthMarriageName(final String birthMarriageName) {
        birthDetailsRequestData.setBirthMarriageName(birthMarriageName);
    }

    
    public final String getBirthMarriageName() {
        return birthDetailsRequestData.getBirthMarriageName();
    }
  
    public final void setBirthPostalCode(final String birthPostalCode) {
        birthDetailsRequestData.setBirthPostalCode(birthPostalCode);
    }

    
    public final String getBirthPostalCode() {
        return birthDetailsRequestData.getBirthPostalCode();
    }
  
    public final void setComment(final String comment) {
        birthDetailsRequestData.setComment(comment);
    }

    
    public final String getComment() {
        return birthDetailsRequestData.getComment();
    }
  
    public final void setCopies(final java.math.BigInteger copies) {
        birthDetailsRequestData.setCopies(copies);
    }

    
    public final java.math.BigInteger getCopies() {
        return birthDetailsRequestData.getCopies();
    }
  
    public final void setFatherFirstNames(final String fatherFirstNames) {
        birthDetailsRequestData.setFatherFirstNames(fatherFirstNames);
    }

    
    public final String getFatherFirstNames() {
        return birthDetailsRequestData.getFatherFirstNames();
    }
  
    public final void setFatherLastName(final String fatherLastName) {
        birthDetailsRequestData.setFatherLastName(fatherLastName);
    }

    
    public final String getFatherLastName() {
        return birthDetailsRequestData.getFatherLastName();
    }
  
    public final void setFormat(final fr.cg95.cvq.business.request.civil.BirthCertificateFormatType format) {
        birthDetailsRequestData.setFormat(format);
    }

    
    public final fr.cg95.cvq.business.request.civil.BirthCertificateFormatType getFormat() {
        return birthDetailsRequestData.getFormat();
    }
  
    public final void setMotherFirstNames(final String motherFirstNames) {
        birthDetailsRequestData.setMotherFirstNames(motherFirstNames);
    }

    
    public final String getMotherFirstNames() {
        return birthDetailsRequestData.getMotherFirstNames();
    }
  
    public final void setMotherMaidenName(final String motherMaidenName) {
        birthDetailsRequestData.setMotherMaidenName(motherMaidenName);
    }

    
    public final String getMotherMaidenName() {
        return birthDetailsRequestData.getMotherMaidenName();
    }
  
    public final void setMotive(final fr.cg95.cvq.business.request.civil.BirthCertificateMotiveType motive) {
        birthDetailsRequestData.setMotive(motive);
    }

    
    public final fr.cg95.cvq.business.request.civil.BirthCertificateMotiveType getMotive() {
        return birthDetailsRequestData.getMotive();
    }
  
    public final void setRequesterQuality(final fr.cg95.cvq.business.request.civil.BirthRequesterQualityType requesterQuality) {
        birthDetailsRequestData.setRequesterQuality(requesterQuality);
    }

    
    public final fr.cg95.cvq.business.request.civil.BirthRequesterQualityType getRequesterQuality() {
        return birthDetailsRequestData.getRequesterQuality();
    }
  
    public final void setRequesterQualityPrecision(final String requesterQualityPrecision) {
        birthDetailsRequestData.setRequesterQualityPrecision(requesterQualityPrecision);
    }

    
    public final String getRequesterQualityPrecision() {
        return birthDetailsRequestData.getRequesterQualityPrecision();
    }
  
}
