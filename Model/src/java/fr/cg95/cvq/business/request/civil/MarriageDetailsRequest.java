
package fr.cg95.cvq.business.request.civil;

import java.io.Serializable;
import java.math.BigInteger;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
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
        Map<String, Object> stepState;
        
          stepState = new HashMap<String, Object>(4);
          stepState.put("state", "uncomplete");
          stepState.put("required", true);
          stepState.put("errorMsg", null);
          stepState.put("invalidFields", new ArrayList<String>());
          getStepStates().put("nature", stepState);
        
          stepState = new HashMap<String, Object>(4);
          stepState.put("state", "unavailable");
          stepState.put("required", true);
          stepState.put("errorMsg", null);
          stepState.put("invalidFields", new ArrayList<String>());
          getStepStates().put("type", stepState);
        
          stepState = new HashMap<String, Object>(4);
          stepState.put("state", "unavailable");
          stepState.put("required", false);
          stepState.put("errorMsg", null);
          stepState.put("invalidFields", new ArrayList<String>());
          getStepStates().put("document", stepState);
        
          stepState = new HashMap<String, Object>(4);
          stepState.put("state", "unavailable");
          stepState.put("required", true);
          stepState.put("errorMsg", null);
          stepState.put("invalidFields", new ArrayList<String>());
          getStepStates().put("validation", stepState);
        
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
        LocalTime localTime = new LocalTime();
        Date date = null;
        MarriageDetailsRequestDocument marriageDetailsRequestDoc = MarriageDetailsRequestDocument.Factory.newInstance();
        MarriageDetailsRequestDocument.MarriageDetailsRequest marriageDetailsRequest = marriageDetailsRequestDoc.addNewMarriageDetailsRequest();
        super.fillCommonXmlInfo(marriageDetailsRequest);
        int i = 0;
        
        marriageDetailsRequest.setComment(getComment());
      
        if (getCopies() != null)
            marriageDetailsRequest.setCopies(new BigInteger(getCopies().toString()));
        MarriageFatherInformationType marriageFatherInformationTypeFatherInformation = marriageDetailsRequest.addNewFatherInformation();
        marriageFatherInformationTypeFatherInformation.setFatherFirstNames(getFatherFirstNames());
      
        marriageFatherInformationTypeFatherInformation.setFatherLastName(getFatherLastName());
      
        if (getFormat() != null)
            marriageDetailsRequest.setFormat(fr.cg95.cvq.xml.request.civil.MarriageCertificateFormatType.Enum.forString(getFormat().getLegacyLabel()));
        MarriageInformationType marriageInformationTypeMarriage = marriageDetailsRequest.addNewMarriage();
        marriageInformationTypeMarriage.setMarriageCity(getMarriageCity());
      
        date = getMarriageDate();
        if (date != null) {
            calendar.setTime(date);
            marriageInformationTypeMarriage.setMarriageDate(calendar);
        }
        MarriageHusbandInformationType marriageHusbandInformationTypeMarriageHusband = marriageDetailsRequest.addNewMarriageHusband();
        marriageHusbandInformationTypeMarriageHusband.setMarriageHusbandFirstNames(getMarriageHusbandFirstNames());
      
        marriageHusbandInformationTypeMarriageHusband.setMarriageHusbandLastName(getMarriageHusbandLastName());
      
        marriageInformationTypeMarriage.setMarriagePostalCode(getMarriagePostalCode());
        MarriageWifeInformationType marriageWifeInformationTypeMarriageWife = marriageDetailsRequest.addNewMarriageWife();
        marriageWifeInformationTypeMarriageWife.setMarriageWifeFirstNames(getMarriageWifeFirstNames());
      
        marriageWifeInformationTypeMarriageWife.setMarriageWifeLastName(getMarriageWifeLastName());
        MarriageMotherInformationType marriageMotherInformationTypeMotherInformation = marriageDetailsRequest.addNewMotherInformation();
        marriageMotherInformationTypeMotherInformation.setMotherFirstNames(getMotherFirstNames());
      
        marriageMotherInformationTypeMotherInformation.setMotherMaidenName(getMotherMaidenName());
      
        if (getMotive() != null)
            marriageDetailsRequest.setMotive(fr.cg95.cvq.xml.request.civil.MarriageCertificateMotiveType.Enum.forString(getMotive().getLegacyLabel()));
      
        if (getRelationship() != null)
            marriageDetailsRequest.setRelationship(fr.cg95.cvq.xml.request.civil.MarriageRelationshipType.Enum.forString(getRelationship().getLegacyLabel()));
      
        if (getRequesterQuality() != null)
            marriageDetailsRequest.setRequesterQuality(fr.cg95.cvq.xml.request.civil.MarriageRequesterQualityType.Enum.forString(getRequesterQuality().getLegacyLabel()));
      
        marriageDetailsRequest.setRequesterQualityPrecision(getRequesterQualityPrecision());
      
        return marriageDetailsRequestDoc;
    }

    @Override
    public final MarriageDetailsRequestDocument.MarriageDetailsRequest modelToXmlRequest() {
        return modelToXml().getMarriageDetailsRequest();
    }

    public static MarriageDetailsRequest xmlToModel(MarriageDetailsRequestDocument marriageDetailsRequestDoc) {
        MarriageDetailsRequestDocument.MarriageDetailsRequest marriageDetailsRequestXml = marriageDetailsRequestDoc.getMarriageDetailsRequest();
        Calendar calendar = Calendar.getInstance();
        LocalTime localTime = new LocalTime();
        List list = new ArrayList();
        MarriageDetailsRequest marriageDetailsRequest = new MarriageDetailsRequest();
        marriageDetailsRequest.fillCommonModelInfo(marriageDetailsRequest, marriageDetailsRequestXml);
        
        marriageDetailsRequest.setComment(marriageDetailsRequestXml.getComment());
      
        marriageDetailsRequest.setCopies(marriageDetailsRequestXml.getCopies());
      
        marriageDetailsRequest.setFatherFirstNames(marriageDetailsRequestXml.getFatherInformation().getFatherFirstNames());
      
        marriageDetailsRequest.setFatherLastName(marriageDetailsRequestXml.getFatherInformation().getFatherLastName());
      
        if (marriageDetailsRequestXml.getFormat() != null)
            marriageDetailsRequest.setFormat(fr.cg95.cvq.business.request.civil.MarriageCertificateFormatType.forString(marriageDetailsRequestXml.getFormat().toString()));
        else
            marriageDetailsRequest.setFormat(fr.cg95.cvq.business.request.civil.MarriageCertificateFormatType.getDefaultMarriageCertificateFormatType());
      
        marriageDetailsRequest.setMarriageCity(marriageDetailsRequestXml.getMarriage().getMarriageCity());
      
        calendar = marriageDetailsRequestXml.getMarriage().getMarriageDate();
        if (calendar != null) {
            marriageDetailsRequest.setMarriageDate(calendar.getTime());
        }
      
        marriageDetailsRequest.setMarriageHusbandFirstNames(marriageDetailsRequestXml.getMarriageHusband().getMarriageHusbandFirstNames());
      
        marriageDetailsRequest.setMarriageHusbandLastName(marriageDetailsRequestXml.getMarriageHusband().getMarriageHusbandLastName());
      
        marriageDetailsRequest.setMarriagePostalCode(marriageDetailsRequestXml.getMarriage().getMarriagePostalCode());
      
        marriageDetailsRequest.setMarriageWifeFirstNames(marriageDetailsRequestXml.getMarriageWife().getMarriageWifeFirstNames());
      
        marriageDetailsRequest.setMarriageWifeLastName(marriageDetailsRequestXml.getMarriageWife().getMarriageWifeLastName());
      
        marriageDetailsRequest.setMotherFirstNames(marriageDetailsRequestXml.getMotherInformation().getMotherFirstNames());
      
        marriageDetailsRequest.setMotherMaidenName(marriageDetailsRequestXml.getMotherInformation().getMotherMaidenName());
      
        if (marriageDetailsRequestXml.getMotive() != null)
            marriageDetailsRequest.setMotive(fr.cg95.cvq.business.request.civil.MarriageCertificateMotiveType.forString(marriageDetailsRequestXml.getMotive().toString()));
        else
            marriageDetailsRequest.setMotive(fr.cg95.cvq.business.request.civil.MarriageCertificateMotiveType.getDefaultMarriageCertificateMotiveType());
      
        if (marriageDetailsRequestXml.getRelationship() != null)
            marriageDetailsRequest.setRelationship(fr.cg95.cvq.business.request.civil.MarriageRelationshipType.forString(marriageDetailsRequestXml.getRelationship().toString()));
        else
            marriageDetailsRequest.setRelationship(fr.cg95.cvq.business.request.civil.MarriageRelationshipType.getDefaultMarriageRelationshipType());
      
        if (marriageDetailsRequestXml.getRequesterQuality() != null)
            marriageDetailsRequest.setRequesterQuality(fr.cg95.cvq.business.request.civil.MarriageRequesterQualityType.forString(marriageDetailsRequestXml.getRequesterQuality().toString()));
        else
            marriageDetailsRequest.setRequesterQuality(fr.cg95.cvq.business.request.civil.MarriageRequesterQualityType.getDefaultMarriageRequesterQualityType());
      
        marriageDetailsRequest.setRequesterQualityPrecision(marriageDetailsRequestXml.getRequesterQualityPrecision());
      
        return marriageDetailsRequest;
    }

    @Override
    public MarriageDetailsRequest clone() {
        MarriageDetailsRequest clone = new MarriageDetailsRequest(getRequestData().clone(), marriageDetailsRequestData.clone());
        Map<String, Object> stepState;
        
          stepState = new HashMap<String, Object>(4);
          stepState.put("state", "uncomplete");
          stepState.put("required", true);
          stepState.put("errorMsg", null);
          stepState.put("invalidFields", new ArrayList<String>());
          clone.getStepStates().put("nature", stepState);
        
          stepState = new HashMap<String, Object>(4);
          stepState.put("state", "unavailable");
          stepState.put("required", true);
          stepState.put("errorMsg", null);
          stepState.put("invalidFields", new ArrayList<String>());
          clone.getStepStates().put("type", stepState);
        
          stepState = new HashMap<String, Object>(4);
          stepState.put("state", "unavailable");
          stepState.put("required", false);
          stepState.put("errorMsg", null);
          stepState.put("invalidFields", new ArrayList<String>());
          clone.getStepStates().put("document", stepState);
        
          stepState = new HashMap<String, Object>(4);
          stepState.put("state", "unavailable");
          stepState.put("required", true);
          stepState.put("errorMsg", null);
          stepState.put("invalidFields", new ArrayList<String>());
          clone.getStepStates().put("validation", stepState);
        
        return clone;
    }

  
    public final void setComment(final String comment) {
        marriageDetailsRequestData.setComment(comment);
    }

    
    public final String getComment() {
        return marriageDetailsRequestData.getComment();
    }
  
    public final void setCopies(final java.math.BigInteger copies) {
        marriageDetailsRequestData.setCopies(copies);
    }

    
    public final java.math.BigInteger getCopies() {
        return marriageDetailsRequestData.getCopies();
    }
  
    public final void setFatherFirstNames(final String fatherFirstNames) {
        marriageDetailsRequestData.setFatherFirstNames(fatherFirstNames);
    }

    
    public final String getFatherFirstNames() {
        return marriageDetailsRequestData.getFatherFirstNames();
    }
  
    public final void setFatherLastName(final String fatherLastName) {
        marriageDetailsRequestData.setFatherLastName(fatherLastName);
    }

    
    public final String getFatherLastName() {
        return marriageDetailsRequestData.getFatherLastName();
    }
  
    public final void setFormat(final fr.cg95.cvq.business.request.civil.MarriageCertificateFormatType format) {
        marriageDetailsRequestData.setFormat(format);
    }

    
    public final fr.cg95.cvq.business.request.civil.MarriageCertificateFormatType getFormat() {
        return marriageDetailsRequestData.getFormat();
    }
  
    public final void setMarriageCity(final String marriageCity) {
        marriageDetailsRequestData.setMarriageCity(marriageCity);
    }

    
    public final String getMarriageCity() {
        return marriageDetailsRequestData.getMarriageCity();
    }
  
    public final void setMarriageDate(final java.util.Date marriageDate) {
        marriageDetailsRequestData.setMarriageDate(marriageDate);
    }

    
    public final java.util.Date getMarriageDate() {
        return marriageDetailsRequestData.getMarriageDate();
    }
  
    public final void setMarriageHusbandFirstNames(final String marriageHusbandFirstNames) {
        marriageDetailsRequestData.setMarriageHusbandFirstNames(marriageHusbandFirstNames);
    }

    
    public final String getMarriageHusbandFirstNames() {
        return marriageDetailsRequestData.getMarriageHusbandFirstNames();
    }
  
    public final void setMarriageHusbandLastName(final String marriageHusbandLastName) {
        marriageDetailsRequestData.setMarriageHusbandLastName(marriageHusbandLastName);
    }

    
    public final String getMarriageHusbandLastName() {
        return marriageDetailsRequestData.getMarriageHusbandLastName();
    }
  
    public final void setMarriagePostalCode(final String marriagePostalCode) {
        marriageDetailsRequestData.setMarriagePostalCode(marriagePostalCode);
    }

    
    public final String getMarriagePostalCode() {
        return marriageDetailsRequestData.getMarriagePostalCode();
    }
  
    public final void setMarriageWifeFirstNames(final String marriageWifeFirstNames) {
        marriageDetailsRequestData.setMarriageWifeFirstNames(marriageWifeFirstNames);
    }

    
    public final String getMarriageWifeFirstNames() {
        return marriageDetailsRequestData.getMarriageWifeFirstNames();
    }
  
    public final void setMarriageWifeLastName(final String marriageWifeLastName) {
        marriageDetailsRequestData.setMarriageWifeLastName(marriageWifeLastName);
    }

    
    public final String getMarriageWifeLastName() {
        return marriageDetailsRequestData.getMarriageWifeLastName();
    }
  
    public final void setMotherFirstNames(final String motherFirstNames) {
        marriageDetailsRequestData.setMotherFirstNames(motherFirstNames);
    }

    
    public final String getMotherFirstNames() {
        return marriageDetailsRequestData.getMotherFirstNames();
    }
  
    public final void setMotherMaidenName(final String motherMaidenName) {
        marriageDetailsRequestData.setMotherMaidenName(motherMaidenName);
    }

    
    public final String getMotherMaidenName() {
        return marriageDetailsRequestData.getMotherMaidenName();
    }
  
    public final void setMotive(final fr.cg95.cvq.business.request.civil.MarriageCertificateMotiveType motive) {
        marriageDetailsRequestData.setMotive(motive);
    }

    
    public final fr.cg95.cvq.business.request.civil.MarriageCertificateMotiveType getMotive() {
        return marriageDetailsRequestData.getMotive();
    }
  
    public final void setRelationship(final fr.cg95.cvq.business.request.civil.MarriageRelationshipType relationship) {
        marriageDetailsRequestData.setRelationship(relationship);
    }

    
    public final fr.cg95.cvq.business.request.civil.MarriageRelationshipType getRelationship() {
        return marriageDetailsRequestData.getRelationship();
    }
  
    public final void setRequesterQuality(final fr.cg95.cvq.business.request.civil.MarriageRequesterQualityType requesterQuality) {
        marriageDetailsRequestData.setRequesterQuality(requesterQuality);
    }

    
    public final fr.cg95.cvq.business.request.civil.MarriageRequesterQualityType getRequesterQuality() {
        return marriageDetailsRequestData.getRequesterQuality();
    }
  
    public final void setRequesterQualityPrecision(final String requesterQualityPrecision) {
        marriageDetailsRequestData.setRequesterQualityPrecision(requesterQualityPrecision);
    }

    
    public final String getRequesterQualityPrecision() {
        return marriageDetailsRequestData.getRequesterQualityPrecision();
    }
  
}
