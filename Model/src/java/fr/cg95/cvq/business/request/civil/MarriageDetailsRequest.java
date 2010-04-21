
package fr.cg95.cvq.business.request.civil;

import java.io.Serializable;
import java.math.BigInteger;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

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
public class MarriageDetailsRequest extends Request implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final Map<String, IConditionChecker> conditions = MarriageDetailsRequestData.conditions;

    @AssertValid(message = "")
    private MarriageDetailsRequestData marriageDetailsRequestData;

    public MarriageDetailsRequest(RequestData requestData, MarriageDetailsRequestData marriageDetailsRequestData) {
        super(requestData);
        this.marriageDetailsRequestData = marriageDetailsRequestData;
    }

    public MarriageDetailsRequest() {
        super();
        this.marriageDetailsRequestData = new MarriageDetailsRequestData();
    }

    /**
     * Reserved for RequestDAO !
     */
    @Override
    public MarriageDetailsRequestData getSpecificData() {
        return marriageDetailsRequestData;
    }

    /**
     * Reserved for RequestDAO !
     */
    public void setSpecificData(MarriageDetailsRequestData marriageDetailsRequestData) {
        this.marriageDetailsRequestData = marriageDetailsRequestData;
    }

    @Override
    public final String modelToXmlString() {
        MarriageDetailsRequestDocument object = this.modelToXml();
        XmlOptions opts = new XmlOptions();
        opts.setSavePrettyPrint();
        opts.setSavePrettyPrintIndent(4);
        opts.setUseDefaultNamespace();
        opts.setCharacterEncoding("UTF-8");
        return object.xmlText(opts);
    }

    @Override
    public final MarriageDetailsRequestDocument modelToXml() {
        
        Calendar calendar = Calendar.getInstance();
        Date date = null;
        MarriageDetailsRequestDocument marriageDetailsRequestDoc = MarriageDetailsRequestDocument.Factory.newInstance();
        MarriageDetailsRequestDocument.MarriageDetailsRequest marriageDetailsRequest = marriageDetailsRequestDoc.addNewMarriageDetailsRequest();
        super.fillCommonXmlInfo(marriageDetailsRequest);
        int i = 0;
        
        if (getFormat() != null)
            marriageDetailsRequest.setFormat(fr.cg95.cvq.xml.request.civil.MarriageCertificateFormatType.Enum.forString(getFormat().toString()));
      
        if (getCopies() != null)
            marriageDetailsRequest.setCopies(new BigInteger(getCopies().toString()));
        MarriageHusbandInformationType marriageHusbandInformationTypeMarriageHusband = marriageDetailsRequest.addNewMarriageHusband();
        marriageHusbandInformationTypeMarriageHusband.setMarriageHusbandLastName(getMarriageHusbandLastName());
        MarriageWifeInformationType marriageWifeInformationTypeMarriageWife = marriageDetailsRequest.addNewMarriageWife();
        marriageWifeInformationTypeMarriageWife.setMarriageWifeFirstNames(getMarriageWifeFirstNames());
      
        marriageDetailsRequest.setComment(getComment());
      
        marriageDetailsRequest.setRequesterQualityPrecision(getRequesterQualityPrecision());
        MarriageFatherInformationType marriageFatherInformationTypeFatherInformation = marriageDetailsRequest.addNewFatherInformation();
        marriageFatherInformationTypeFatherInformation.setFatherFirstNames(getFatherFirstNames());
        MarriageInformationType marriageInformationTypeMarriage = marriageDetailsRequest.addNewMarriage();
        marriageInformationTypeMarriage.setMarriagePostalCode(getMarriagePostalCode());
        MarriageMotherInformationType marriageMotherInformationTypeMotherInformation = marriageDetailsRequest.addNewMotherInformation();
        marriageMotherInformationTypeMotherInformation.setMotherMaidenName(getMotherMaidenName());
      
        marriageHusbandInformationTypeMarriageHusband.setMarriageHusbandFirstNames(getMarriageHusbandFirstNames());
      
        if (getRequesterQuality() != null)
            marriageDetailsRequest.setRequesterQuality(fr.cg95.cvq.xml.request.civil.MarriageRequesterQualityType.Enum.forString(getRequesterQuality().toString()));
      
        marriageInformationTypeMarriage.setMarriageCity(getMarriageCity());
      
        marriageWifeInformationTypeMarriageWife.setMarriageWifeLastName(getMarriageWifeLastName());
      
        date = getMarriageDate();
        if (date != null) {
            calendar.setTime(date);
            marriageInformationTypeMarriage.setMarriageDate(calendar);
        }
      
        marriageFatherInformationTypeFatherInformation.setFatherLastName(getFatherLastName());
      
        if (getRelationship() != null)
            marriageDetailsRequest.setRelationship(fr.cg95.cvq.xml.request.civil.MarriageRelationshipType.Enum.forString(getRelationship().toString()));
      
        marriageMotherInformationTypeMotherInformation.setMotherFirstNames(getMotherFirstNames());
      
        if (getMotive() != null)
            marriageDetailsRequest.setMotive(fr.cg95.cvq.xml.request.civil.MarriageCertificateMotiveType.Enum.forString(getMotive().toString()));
      
        return marriageDetailsRequestDoc;
    }

    @Override
    public final MarriageDetailsRequestDocument.MarriageDetailsRequest modelToXmlRequest() {
        return modelToXml().getMarriageDetailsRequest();
    }

    public static MarriageDetailsRequest xmlToModel(MarriageDetailsRequestDocument marriageDetailsRequestDoc) {
        MarriageDetailsRequestDocument.MarriageDetailsRequest marriageDetailsRequestXml = marriageDetailsRequestDoc.getMarriageDetailsRequest();
        Calendar calendar = Calendar.getInstance();
        List list = new ArrayList();
        MarriageDetailsRequest marriageDetailsRequest = new MarriageDetailsRequest();
        marriageDetailsRequest.fillCommonModelInfo(marriageDetailsRequest, marriageDetailsRequestXml);
        
        if (marriageDetailsRequestXml.getFormat() != null)
            marriageDetailsRequest.setFormat(fr.cg95.cvq.business.request.civil.MarriageCertificateFormatType.forString(marriageDetailsRequestXml.getFormat().toString()));
        else
            marriageDetailsRequest.setFormat(fr.cg95.cvq.business.request.civil.MarriageCertificateFormatType.getDefaultMarriageCertificateFormatType());
      
        marriageDetailsRequest.setCopies(marriageDetailsRequestXml.getCopies());
      
        marriageDetailsRequest.setMarriageHusbandLastName(marriageDetailsRequestXml.getMarriageHusband().getMarriageHusbandLastName());
      
        marriageDetailsRequest.setMarriageWifeFirstNames(marriageDetailsRequestXml.getMarriageWife().getMarriageWifeFirstNames());
      
        marriageDetailsRequest.setComment(marriageDetailsRequestXml.getComment());
      
        marriageDetailsRequest.setRequesterQualityPrecision(marriageDetailsRequestXml.getRequesterQualityPrecision());
      
        marriageDetailsRequest.setFatherFirstNames(marriageDetailsRequestXml.getFatherInformation().getFatherFirstNames());
      
        marriageDetailsRequest.setMarriagePostalCode(marriageDetailsRequestXml.getMarriage().getMarriagePostalCode());
      
        marriageDetailsRequest.setMotherMaidenName(marriageDetailsRequestXml.getMotherInformation().getMotherMaidenName());
      
        marriageDetailsRequest.setMarriageHusbandFirstNames(marriageDetailsRequestXml.getMarriageHusband().getMarriageHusbandFirstNames());
      
        if (marriageDetailsRequestXml.getRequesterQuality() != null)
            marriageDetailsRequest.setRequesterQuality(fr.cg95.cvq.business.request.civil.MarriageRequesterQualityType.forString(marriageDetailsRequestXml.getRequesterQuality().toString()));
        else
            marriageDetailsRequest.setRequesterQuality(fr.cg95.cvq.business.request.civil.MarriageRequesterQualityType.getDefaultMarriageRequesterQualityType());
      
        marriageDetailsRequest.setMarriageCity(marriageDetailsRequestXml.getMarriage().getMarriageCity());
      
        marriageDetailsRequest.setMarriageWifeLastName(marriageDetailsRequestXml.getMarriageWife().getMarriageWifeLastName());
      
        calendar = marriageDetailsRequestXml.getMarriage().getMarriageDate();
        if (calendar != null) {
            marriageDetailsRequest.setMarriageDate(calendar.getTime());
        }
      
        marriageDetailsRequest.setFatherLastName(marriageDetailsRequestXml.getFatherInformation().getFatherLastName());
      
        if (marriageDetailsRequestXml.getRelationship() != null)
            marriageDetailsRequest.setRelationship(fr.cg95.cvq.business.request.civil.MarriageRelationshipType.forString(marriageDetailsRequestXml.getRelationship().toString()));
        else
            marriageDetailsRequest.setRelationship(fr.cg95.cvq.business.request.civil.MarriageRelationshipType.getDefaultMarriageRelationshipType());
      
        marriageDetailsRequest.setMotherFirstNames(marriageDetailsRequestXml.getMotherInformation().getMotherFirstNames());
      
        if (marriageDetailsRequestXml.getMotive() != null)
            marriageDetailsRequest.setMotive(fr.cg95.cvq.business.request.civil.MarriageCertificateMotiveType.forString(marriageDetailsRequestXml.getMotive().toString()));
        else
            marriageDetailsRequest.setMotive(fr.cg95.cvq.business.request.civil.MarriageCertificateMotiveType.getDefaultMarriageCertificateMotiveType());
      
        return marriageDetailsRequest;
    }

  
    public final void setFormat(final fr.cg95.cvq.business.request.civil.MarriageCertificateFormatType format) {
        marriageDetailsRequestData.setFormat(format);
    }

    
    public final fr.cg95.cvq.business.request.civil.MarriageCertificateFormatType getFormat() {
        return marriageDetailsRequestData.getFormat();
    }
  
    public final void setCopies(final java.math.BigInteger copies) {
        marriageDetailsRequestData.setCopies(copies);
    }

    
    public final java.math.BigInteger getCopies() {
        return marriageDetailsRequestData.getCopies();
    }
  
    public final void setMarriageHusbandLastName(final String marriageHusbandLastName) {
        marriageDetailsRequestData.setMarriageHusbandLastName(marriageHusbandLastName);
    }

    
    public final String getMarriageHusbandLastName() {
        return marriageDetailsRequestData.getMarriageHusbandLastName();
    }
  
    public final void setMarriageWifeFirstNames(final String marriageWifeFirstNames) {
        marriageDetailsRequestData.setMarriageWifeFirstNames(marriageWifeFirstNames);
    }

    
    public final String getMarriageWifeFirstNames() {
        return marriageDetailsRequestData.getMarriageWifeFirstNames();
    }
  
    public final void setComment(final String comment) {
        marriageDetailsRequestData.setComment(comment);
    }

    
    public final String getComment() {
        return marriageDetailsRequestData.getComment();
    }
  
    public final void setRequesterQualityPrecision(final String requesterQualityPrecision) {
        marriageDetailsRequestData.setRequesterQualityPrecision(requesterQualityPrecision);
    }

    
    public final String getRequesterQualityPrecision() {
        return marriageDetailsRequestData.getRequesterQualityPrecision();
    }
  
    public final void setFatherFirstNames(final String fatherFirstNames) {
        marriageDetailsRequestData.setFatherFirstNames(fatherFirstNames);
    }

    
    public final String getFatherFirstNames() {
        return marriageDetailsRequestData.getFatherFirstNames();
    }
  
    public final void setMarriagePostalCode(final String marriagePostalCode) {
        marriageDetailsRequestData.setMarriagePostalCode(marriagePostalCode);
    }

    
    public final String getMarriagePostalCode() {
        return marriageDetailsRequestData.getMarriagePostalCode();
    }
  
    public final void setMotherMaidenName(final String motherMaidenName) {
        marriageDetailsRequestData.setMotherMaidenName(motherMaidenName);
    }

    
    public final String getMotherMaidenName() {
        return marriageDetailsRequestData.getMotherMaidenName();
    }
  
    public final void setMarriageHusbandFirstNames(final String marriageHusbandFirstNames) {
        marriageDetailsRequestData.setMarriageHusbandFirstNames(marriageHusbandFirstNames);
    }

    
    public final String getMarriageHusbandFirstNames() {
        return marriageDetailsRequestData.getMarriageHusbandFirstNames();
    }
  
    public final void setRequesterQuality(final fr.cg95.cvq.business.request.civil.MarriageRequesterQualityType requesterQuality) {
        marriageDetailsRequestData.setRequesterQuality(requesterQuality);
    }

    
    public final fr.cg95.cvq.business.request.civil.MarriageRequesterQualityType getRequesterQuality() {
        return marriageDetailsRequestData.getRequesterQuality();
    }
  
    public final void setMarriageCity(final String marriageCity) {
        marriageDetailsRequestData.setMarriageCity(marriageCity);
    }

    
    public final String getMarriageCity() {
        return marriageDetailsRequestData.getMarriageCity();
    }
  
    public final void setMarriageWifeLastName(final String marriageWifeLastName) {
        marriageDetailsRequestData.setMarriageWifeLastName(marriageWifeLastName);
    }

    
    public final String getMarriageWifeLastName() {
        return marriageDetailsRequestData.getMarriageWifeLastName();
    }
  
    public final void setMarriageDate(final java.util.Date marriageDate) {
        marriageDetailsRequestData.setMarriageDate(marriageDate);
    }

    
    public final java.util.Date getMarriageDate() {
        return marriageDetailsRequestData.getMarriageDate();
    }
  
    public final void setFatherLastName(final String fatherLastName) {
        marriageDetailsRequestData.setFatherLastName(fatherLastName);
    }

    
    public final String getFatherLastName() {
        return marriageDetailsRequestData.getFatherLastName();
    }
  
    public final void setRelationship(final fr.cg95.cvq.business.request.civil.MarriageRelationshipType relationship) {
        marriageDetailsRequestData.setRelationship(relationship);
    }

    
    public final fr.cg95.cvq.business.request.civil.MarriageRelationshipType getRelationship() {
        return marriageDetailsRequestData.getRelationship();
    }
  
    public final void setMotherFirstNames(final String motherFirstNames) {
        marriageDetailsRequestData.setMotherFirstNames(motherFirstNames);
    }

    
    public final String getMotherFirstNames() {
        return marriageDetailsRequestData.getMotherFirstNames();
    }
  
    public final void setMotive(final fr.cg95.cvq.business.request.civil.MarriageCertificateMotiveType motive) {
        marriageDetailsRequestData.setMotive(motive);
    }

    
    public final fr.cg95.cvq.business.request.civil.MarriageCertificateMotiveType getMotive() {
        return marriageDetailsRequestData.getMotive();
    }
  
}
