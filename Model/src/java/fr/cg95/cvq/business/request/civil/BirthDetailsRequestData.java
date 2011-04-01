
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

import net.sf.oval.constraint.*;
import fr.cg95.cvq.business.authority.*;
import fr.cg95.cvq.business.request.*;
import fr.cg95.cvq.business.users.*;
import fr.cg95.cvq.service.request.LocalReferential;
import fr.cg95.cvq.service.request.condition.IConditionChecker;

/**
 * Generated class file, do not edit !
 *
 * @hibernate.class
 *  table="birth_details_request"
 *  lazy="false"
 */
public class BirthDetailsRequestData implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final Map<String, IConditionChecker> conditions =
        new HashMap<String, IConditionChecker>(RequestData.conditions);

    private Long id;

    public BirthDetailsRequestData() {
      
        format = fr.cg95.cvq.business.request.civil.BirthCertificateFormatType.FULL_COPY;
      
    }

    @Override
    public BirthDetailsRequestData clone() {
        BirthDetailsRequestData result = new BirthDetailsRequestData();
        
          
            
        if (format != null)
            result.setFormat(format);
        else
            result.setFormat(fr.cg95.cvq.business.request.civil.BirthCertificateFormatType.getDefaultBirthCertificateFormatType());
      
          
        
          
            
        result.setCopies(copies);
      
          
        
          
            
        result.setBirthPostalCode(birthPostalCode);
      
          
        
          
            
        result.setComment(comment);
      
          
        
          
            
        result.setBirthFirstNames(birthFirstNames);
      
          
        
          
            
        if (motive != null)
            result.setMotive(motive);
        else
            result.setMotive(fr.cg95.cvq.business.request.civil.BirthCertificateMotiveType.getDefaultBirthCertificateMotiveType());
      
          
        
          
            
        result.setBirthDate(birthDate);
      
          
        
          
            
        result.setRequesterQualityPrecision(requesterQualityPrecision);
      
          
        
          
            
        result.setBirthCity(birthCity);
      
          
        
          
            
        if (requesterQuality != null)
            result.setRequesterQuality(requesterQuality);
        else
            result.setRequesterQuality(fr.cg95.cvq.business.request.civil.BirthRequesterQualityType.getDefaultBirthRequesterQualityType());
      
          
        
          
            
        result.setFatherLastName(fatherLastName);
      
          
        
          
            
        result.setBirthMarriageName(birthMarriageName);
      
          
        
          
            
        result.setMotherFirstNames(motherFirstNames);
      
          
        
          
            
        result.setFatherFirstNames(fatherFirstNames);
      
          
        
          
            
        result.setMotherMaidenName(motherMaidenName);
      
          
        
          
            
        result.setBirthLastName(birthLastName);
      
          
        
        return result;
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
    
    private fr.cg95.cvq.business.request.civil.BirthCertificateFormatType format;

    public final void setFormat(final fr.cg95.cvq.business.request.civil.BirthCertificateFormatType format) {
        this.format = format;
    }

    /**
 
        * @hibernate.property
        *  column="format"
        
      
    */
    public final fr.cg95.cvq.business.request.civil.BirthCertificateFormatType getFormat() {
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
        
          value = 2,
        
        
        profiles = {"nature"},
        message = "birthPostalCode"
      )
    
      @NotNull(
        
        
        profiles = {"nature"},
        message = "birthPostalCode"
      )
    
      @NotBlank(
        
        
        profiles = {"nature"},
        message = "birthPostalCode"
      )
    
    private String birthPostalCode;

    public final void setBirthPostalCode(final String birthPostalCode) {
        this.birthPostalCode = birthPostalCode;
    }

    /**
 
        * @hibernate.property
        *  column="birth_postal_code"
        *  length="2"
      
    */
    public final String getBirthPostalCode() {
        return this.birthPostalCode;
    }
  
    
      @MaxLength(
        
          value = 255,
        
        
        profiles = {"type"},
        message = "comment"
      )
    
      @MatchPattern(
        
          pattern = "^[\\w\\W]{0,255}$",
        
        
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
        *  length="255"
      
    */
    public final String getComment() {
        return this.comment;
    }
  
    
      @NotNull(
        
        
        profiles = {"nature"},
        message = "birthFirstNames"
      )
    
      @NotBlank(
        
        
        profiles = {"nature"},
        message = "birthFirstNames"
      )
    
    private String birthFirstNames;

    public final void setBirthFirstNames(final String birthFirstNames) {
        this.birthFirstNames = birthFirstNames;
    }

    /**
 
        * @hibernate.property
        *  column="birth_first_names"
        
      
    */
    public final String getBirthFirstNames() {
        return this.birthFirstNames;
    }
  
    
      @NotNull(
        
        
        profiles = {"type"},
        message = "motive"
      )
    
    private fr.cg95.cvq.business.request.civil.BirthCertificateMotiveType motive;

    public final void setMotive(final fr.cg95.cvq.business.request.civil.BirthCertificateMotiveType motive) {
        this.motive = motive;
    }

    /**
 
        * @hibernate.property
        *  column="motive"
        
      
    */
    public final fr.cg95.cvq.business.request.civil.BirthCertificateMotiveType getMotive() {
        return this.motive;
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
        
        
        profiles = {"nature"},
        message = "birthDate"
      )
    
    private java.util.Date birthDate;

    public final void setBirthDate(final java.util.Date birthDate) {
        this.birthDate = birthDate;
    }

    /**
 
        * @hibernate.property
        *  column="birth_date"
        
      
    */
    public final java.util.Date getBirthDate() {
        return this.birthDate;
    }
  
    
      @NotNull(
        
        
        profiles = {"nature"},
        message = "requesterQuality"
      )
    
    private fr.cg95.cvq.business.request.civil.BirthRequesterQualityType requesterQuality;

    public final void setRequesterQuality(final fr.cg95.cvq.business.request.civil.BirthRequesterQualityType requesterQuality) {
        this.requesterQuality = requesterQuality;
    }

    /**
 
        * @hibernate.property
        *  column="requester_quality"
        
      
    */
    public final fr.cg95.cvq.business.request.civil.BirthRequesterQualityType getRequesterQuality() {
        return this.requesterQuality;
    }
  
    
      @MaxLength(
        
          value = 32,
        
        
        profiles = {"nature"},
        message = "birthCity"
      )
    
      @NotNull(
        
        
        profiles = {"nature"},
        message = "birthCity"
      )
    
      @NotBlank(
        
        
        profiles = {"nature"},
        message = "birthCity"
      )
    
    private String birthCity;

    public final void setBirthCity(final String birthCity) {
        this.birthCity = birthCity;
    }

    /**
 
        * @hibernate.property
        *  column="birth_city"
        *  length="32"
      
    */
    public final String getBirthCity() {
        return this.birthCity;
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
  
    
      @MaxLength(
        
          value = 38,
        
        
        profiles = {"nature"},
        message = "birthMarriageName"
      )
    
    private String birthMarriageName;

    public final void setBirthMarriageName(final String birthMarriageName) {
        this.birthMarriageName = birthMarriageName;
    }

    /**
 
        * @hibernate.property
        *  column="birth_marriage_name"
        *  length="38"
      
    */
    public final String getBirthMarriageName() {
        return this.birthMarriageName;
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
  
    
      @MaxLength(
        
          value = 38,
        
        
        profiles = {"nature"},
        message = "birthLastName"
      )
    
      @NotNull(
        
        
        profiles = {"nature"},
        message = "birthLastName"
      )
    
      @NotBlank(
        
        
        profiles = {"nature"},
        message = "birthLastName"
      )
    
    private String birthLastName;

    public final void setBirthLastName(final String birthLastName) {
        this.birthLastName = birthLastName;
    }

    /**
 
        * @hibernate.property
        *  column="birth_last_name"
        *  length="38"
      
    */
    public final String getBirthLastName() {
        return this.birthLastName;
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
  
}
