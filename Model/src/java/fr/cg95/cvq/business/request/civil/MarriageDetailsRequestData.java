
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

import fr.cg95.cvq.business.authority.*;
import fr.cg95.cvq.business.request.*;
import fr.cg95.cvq.business.users.*;

import net.sf.oval.constraint.*;
import fr.cg95.cvq.service.request.LocalReferential;
import fr.cg95.cvq.service.request.condition.IConditionChecker;

/**
 * Generated class file, do not edit !
 *
 * @hibernate.class
 *  table="marriage_details_request"
 *  lazy="false"
 */
public class MarriageDetailsRequestData implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final Map<String, IConditionChecker> conditions =
        new HashMap<String, IConditionChecker>(RequestData.conditions);

    private Long id;

    public MarriageDetailsRequestData() {
      
        format = fr.cg95.cvq.business.request.civil.MarriageCertificateFormatType.FULL_COPY;
      
    }

    public final void setId(final Long id) {
        this.id = id;
    }

    /**
     * @hibernate.id
     *  column="id"
     *  generator-class="sequence"
     */
    public final Long getId() {
        return this.id;
    }

  
    
      @NotNull(
        
        
        profiles = {"type"},
        message = "format"
      )
    
    private fr.cg95.cvq.business.request.civil.MarriageCertificateFormatType format;

    public final void setFormat(final fr.cg95.cvq.business.request.civil.MarriageCertificateFormatType format) {
        this.format = format;
    }

    /**
 
        * @hibernate.property
        *  column="format"
        
      
    */
    public final fr.cg95.cvq.business.request.civil.MarriageCertificateFormatType getFormat() {
        return this.format;
    }
  
    
      @NotNull(
        
        
        profiles = {"type"},
        message = "copies"
      )
    
    private java.math.BigInteger copies;

    public final void setCopies(final java.math.BigInteger copies) {
        this.copies = copies;
    }

    /**
 
        * @hibernate.property
        *  column="copies"
        *  type="serializable"
        
      
    */
    public final java.math.BigInteger getCopies() {
        return this.copies;
    }
  
    
      @MaxLength(
        
          value = 38,
        
        
        profiles = {"nature"},
        message = "marriageHusbandLastName"
      )
    
      @NotNull(
        
        
        profiles = {"nature"},
        message = "marriageHusbandLastName"
      )
    
      @NotBlank(
        
        
        profiles = {"nature"},
        message = "marriageHusbandLastName"
      )
    
    private String marriageHusbandLastName;

    public final void setMarriageHusbandLastName(final String marriageHusbandLastName) {
        this.marriageHusbandLastName = marriageHusbandLastName;
    }

    /**
 
        * @hibernate.property
        *  column="marriage_husband_last_name"
        *  length="38"
      
    */
    public final String getMarriageHusbandLastName() {
        return this.marriageHusbandLastName;
    }
  
    
      @NotNull(
        
        
        profiles = {"nature"},
        message = "marriageWifeFirstNames"
      )
    
      @NotBlank(
        
        
        profiles = {"nature"},
        message = "marriageWifeFirstNames"
      )
    
    private String marriageWifeFirstNames;

    public final void setMarriageWifeFirstNames(final String marriageWifeFirstNames) {
        this.marriageWifeFirstNames = marriageWifeFirstNames;
    }

    /**
 
        * @hibernate.property
        *  column="marriage_wife_first_names"
        
      
    */
    public final String getMarriageWifeFirstNames() {
        return this.marriageWifeFirstNames;
    }
  
    
      @MatchPattern(
        
          pattern = "^.{0,255}$",
        
        
        profiles = {"type"},
        message = "comment"
      )
    
    private String comment;

    public final void setComment(final String comment) {
        this.comment = comment;
    }

    /**
 
        * @hibernate.property
        *  column="comment"
        
      
    */
    public final String getComment() {
        return this.comment;
    }
  
    
    private String requesterQualityPrecision;

    public final void setRequesterQualityPrecision(final String requesterQualityPrecision) {
        this.requesterQualityPrecision = requesterQualityPrecision;
    }

    /**
 
        * @hibernate.property
        *  column="requester_quality_precision"
        
      
    */
    public final String getRequesterQualityPrecision() {
        return this.requesterQualityPrecision;
    }
  
    
      @NotNull(
        
        
          when = "groovy:def active = true;" +
          
            
            "active &= _this.conditions['format'].test(_this.format.toString());" +
                
              
            
            "return active",
        
        profiles = {"type"},
        message = "fatherFirstNames"
      )
    
      @NotBlank(
        
        
          when = "groovy:def active = true;" +
          
            
            "active &= _this.conditions['format'].test(_this.format.toString());" +
                
              
            
            "return active",
        
        profiles = {"type"},
        message = "fatherFirstNames"
      )
    
    private String fatherFirstNames;

    public final void setFatherFirstNames(final String fatherFirstNames) {
        this.fatherFirstNames = fatherFirstNames;
    }

    /**
 
        * @hibernate.property
        *  column="father_first_names"
        
      
    */
    public final String getFatherFirstNames() {
        return this.fatherFirstNames;
    }
  
    
      @MaxLength(
        
          value = 2,
        
        
        profiles = {"nature"},
        message = "marriagePostalCode"
      )
    
      @NotNull(
        
        
        profiles = {"nature"},
        message = "marriagePostalCode"
      )
    
      @NotBlank(
        
        
        profiles = {"nature"},
        message = "marriagePostalCode"
      )
    
    private String marriagePostalCode;

    public final void setMarriagePostalCode(final String marriagePostalCode) {
        this.marriagePostalCode = marriagePostalCode;
    }

    /**
 
        * @hibernate.property
        *  column="marriage_postal_code"
        *  length="2"
      
    */
    public final String getMarriagePostalCode() {
        return this.marriagePostalCode;
    }
  
    
      @MaxLength(
        
          value = 38,
        
        
          when = "groovy:def active = true;" +
          
            
            "active &= _this.conditions['format'].test(_this.format.toString());" +
                
              
            
            "return active",
        
        profiles = {"type"},
        message = "motherMaidenName"
      )
    
      @NotNull(
        
        
          when = "groovy:def active = true;" +
          
            
            "active &= _this.conditions['format'].test(_this.format.toString());" +
                
              
            
            "return active",
        
        profiles = {"type"},
        message = "motherMaidenName"
      )
    
      @NotBlank(
        
        
          when = "groovy:def active = true;" +
          
            
            "active &= _this.conditions['format'].test(_this.format.toString());" +
                
              
            
            "return active",
        
        profiles = {"type"},
        message = "motherMaidenName"
      )
    
    private String motherMaidenName;

    public final void setMotherMaidenName(final String motherMaidenName) {
        this.motherMaidenName = motherMaidenName;
    }

    /**
 
        * @hibernate.property
        *  column="mother_maiden_name"
        *  length="38"
      
    */
    public final String getMotherMaidenName() {
        return this.motherMaidenName;
    }
  
    
      @NotNull(
        
        
        profiles = {"nature"},
        message = "marriageHusbandFirstNames"
      )
    
      @NotBlank(
        
        
        profiles = {"nature"},
        message = "marriageHusbandFirstNames"
      )
    
    private String marriageHusbandFirstNames;

    public final void setMarriageHusbandFirstNames(final String marriageHusbandFirstNames) {
        this.marriageHusbandFirstNames = marriageHusbandFirstNames;
    }

    /**
 
        * @hibernate.property
        *  column="marriage_husband_first_names"
        
      
    */
    public final String getMarriageHusbandFirstNames() {
        return this.marriageHusbandFirstNames;
    }
  
    
    private fr.cg95.cvq.business.request.civil.MarriageRequesterQualityType requesterQuality;

    public final void setRequesterQuality(final fr.cg95.cvq.business.request.civil.MarriageRequesterQualityType requesterQuality) {
        this.requesterQuality = requesterQuality;
    }

    /**
 
        * @hibernate.property
        *  column="requester_quality"
        
      
    */
    public final fr.cg95.cvq.business.request.civil.MarriageRequesterQualityType getRequesterQuality() {
        return this.requesterQuality;
    }
  
    
      @MaxLength(
        
          value = 32,
        
        
        profiles = {"nature"},
        message = "marriageCity"
      )
    
      @NotNull(
        
        
        profiles = {"nature"},
        message = "marriageCity"
      )
    
      @NotBlank(
        
        
        profiles = {"nature"},
        message = "marriageCity"
      )
    
    private String marriageCity;

    public final void setMarriageCity(final String marriageCity) {
        this.marriageCity = marriageCity;
    }

    /**
 
        * @hibernate.property
        *  column="marriage_city"
        *  length="32"
      
    */
    public final String getMarriageCity() {
        return this.marriageCity;
    }
  
    
      @MaxLength(
        
          value = 38,
        
        
        profiles = {"nature"},
        message = "marriageWifeLastName"
      )
    
      @NotNull(
        
        
        profiles = {"nature"},
        message = "marriageWifeLastName"
      )
    
      @NotBlank(
        
        
        profiles = {"nature"},
        message = "marriageWifeLastName"
      )
    
    private String marriageWifeLastName;

    public final void setMarriageWifeLastName(final String marriageWifeLastName) {
        this.marriageWifeLastName = marriageWifeLastName;
    }

    /**
 
        * @hibernate.property
        *  column="marriage_wife_last_name"
        *  length="38"
      
    */
    public final String getMarriageWifeLastName() {
        return this.marriageWifeLastName;
    }
  
    
      @NotNull(
        
        
        profiles = {"nature"},
        message = "marriageDate"
      )
    
    private java.util.Date marriageDate;

    public final void setMarriageDate(final java.util.Date marriageDate) {
        this.marriageDate = marriageDate;
    }

    /**
 
        * @hibernate.property
        *  column="marriage_date"
        
      
    */
    public final java.util.Date getMarriageDate() {
        return this.marriageDate;
    }
  
    
      @MaxLength(
        
          value = 38,
        
        
          when = "groovy:def active = true;" +
          
            
            "active &= _this.conditions['format'].test(_this.format.toString());" +
                
              
            
            "return active",
        
        profiles = {"type"},
        message = "fatherLastName"
      )
    
      @NotNull(
        
        
          when = "groovy:def active = true;" +
          
            
            "active &= _this.conditions['format'].test(_this.format.toString());" +
                
              
            
            "return active",
        
        profiles = {"type"},
        message = "fatherLastName"
      )
    
      @NotBlank(
        
        
          when = "groovy:def active = true;" +
          
            
            "active &= _this.conditions['format'].test(_this.format.toString());" +
                
              
            
            "return active",
        
        profiles = {"type"},
        message = "fatherLastName"
      )
    
    private String fatherLastName;

    public final void setFatherLastName(final String fatherLastName) {
        this.fatherLastName = fatherLastName;
    }

    /**
 
        * @hibernate.property
        *  column="father_last_name"
        *  length="38"
      
    */
    public final String getFatherLastName() {
        return this.fatherLastName;
    }
  
    
      @NotNull(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['format'].test(_this.format.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"type"},
        message = "relationship"
      )
    
    private fr.cg95.cvq.business.request.civil.MarriageRelationshipType relationship;

    public final void setRelationship(final fr.cg95.cvq.business.request.civil.MarriageRelationshipType relationship) {
        this.relationship = relationship;
    }

    /**
 
        * @hibernate.property
        *  column="relationship"
        
      
    */
    public final fr.cg95.cvq.business.request.civil.MarriageRelationshipType getRelationship() {
        return this.relationship;
    }
  
    
      @NotNull(
        
        
          when = "groovy:def active = true;" +
          
            
            "active &= _this.conditions['format'].test(_this.format.toString());" +
                
              
            
            "return active",
        
        profiles = {"type"},
        message = "motherFirstNames"
      )
    
      @NotBlank(
        
        
          when = "groovy:def active = true;" +
          
            
            "active &= _this.conditions['format'].test(_this.format.toString());" +
                
              
            
            "return active",
        
        profiles = {"type"},
        message = "motherFirstNames"
      )
    
    private String motherFirstNames;

    public final void setMotherFirstNames(final String motherFirstNames) {
        this.motherFirstNames = motherFirstNames;
    }

    /**
 
        * @hibernate.property
        *  column="mother_first_names"
        
      
    */
    public final String getMotherFirstNames() {
        return this.motherFirstNames;
    }
  
    
    private fr.cg95.cvq.business.request.civil.MarriageCertificateMotiveType motive;

    public final void setMotive(final fr.cg95.cvq.business.request.civil.MarriageCertificateMotiveType motive) {
        this.motive = motive;
    }

    /**
 
        * @hibernate.property
        *  column="motive"
        
      
    */
    public final fr.cg95.cvq.business.request.civil.MarriageCertificateMotiveType getMotive() {
        return this.motive;
    }
  
}
