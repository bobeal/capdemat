

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

import javax.persistence.*;
import org.hibernate.annotations.Index;
import org.hibernate.annotations.Type;

/**
 * Generated class file, do not edit !
 */
@Entity
@Table(name="birth_details_request")
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
        
          
            
        result.setBirthCity(birthCity);
      
          
        
          
            
        result.setBirthDate(birthDate);
      
          
        
          
            
        result.setBirthFirstNames(birthFirstNames);
      
          
        
          
            
        result.setBirthLastName(birthLastName);
      
          
        
          
            
        result.setBirthMarriageName(birthMarriageName);
      
          
        
          
            
        result.setBirthPostalCode(birthPostalCode);
      
          
        
          
            
        result.setComment(comment);
      
          
        
          
            
        result.setCopies(copies);
      
          
        
          
            
        result.setFatherFirstNames(fatherFirstNames);
      
          
        
          
            
        result.setFatherLastName(fatherLastName);
      
          
        
          
            
        if (format != null)
            result.setFormat(format);
        else
            result.setFormat(fr.cg95.cvq.business.request.civil.BirthCertificateFormatType.getDefaultBirthCertificateFormatType());
      
          
        
          
            
        result.setMotherFirstNames(motherFirstNames);
      
          
        
          
            
        result.setMotherMaidenName(motherMaidenName);
      
          
        
          
            
        if (motive != null)
            result.setMotive(motive);
        else
            result.setMotive(fr.cg95.cvq.business.request.civil.BirthCertificateMotiveType.getDefaultBirthCertificateMotiveType());
      
          
        
          
            
        if (requesterQuality != null)
            result.setRequesterQuality(requesterQuality);
        else
            result.setRequesterQuality(fr.cg95.cvq.business.request.civil.BirthRequesterQualityType.getDefaultBirthRequesterQualityType());
      
          
        
          
            
        result.setRequesterQualityPrecision(requesterQualityPrecision);
      
          
        
        return result;
    }

    public final void setId(final Long id) {
        this.id = id;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    public final Long getId() {
        return this.id;
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

    public void setBirthCity(final String birthCity) {
        this.birthCity = birthCity;
    }

 
    @Column(name="birth_city" , length=32 )
      
    public String getBirthCity() {
        return this.birthCity;
    }
  
    
      @NotNull(
        
        
        profiles = {"nature"},
        message = "birthDate"
      )
    
    private java.util.Date birthDate;

    public void setBirthDate(final java.util.Date birthDate) {
        this.birthDate = birthDate;
    }

 
    @Column(name="birth_date"  )
      
    public java.util.Date getBirthDate() {
        return this.birthDate;
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

    public void setBirthFirstNames(final String birthFirstNames) {
        this.birthFirstNames = birthFirstNames;
    }

 
    @Column(name="birth_first_names"  )
      
    public String getBirthFirstNames() {
        return this.birthFirstNames;
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

    public void setBirthLastName(final String birthLastName) {
        this.birthLastName = birthLastName;
    }

 
    @Column(name="birth_last_name" , length=38 )
      
    public String getBirthLastName() {
        return this.birthLastName;
    }
  
    
      @MaxLength(
        
          value = 38,
        
        
        profiles = {"nature"},
        message = "birthMarriageName"
      )
    
    private String birthMarriageName;

    public void setBirthMarriageName(final String birthMarriageName) {
        this.birthMarriageName = birthMarriageName;
    }

 
    @Column(name="birth_marriage_name" , length=38 )
      
    public String getBirthMarriageName() {
        return this.birthMarriageName;
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

    public void setBirthPostalCode(final String birthPostalCode) {
        this.birthPostalCode = birthPostalCode;
    }

 
    @Column(name="birth_postal_code" , length=2 )
      
    public String getBirthPostalCode() {
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

    public void setComment(final String comment) {
        this.comment = comment;
    }

 
    @Column(name="comment" , length=255 )
      
    public String getComment() {
        return this.comment;
    }
  
    
      @NotNull(
        
        
        profiles = {"type"},
        message = "copies"
      )
    
    private java.math.BigInteger copies;

    public void setCopies(final java.math.BigInteger copies) {
        this.copies = copies;
    }

 
    @Column(name="copies" , columnDefinition="bytea" )
    @Type(type="serializable") //Hack see http://capdemat.capwebct.fr/ticket/338
      
    public java.math.BigInteger getCopies() {
        return this.copies;
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

    public void setFatherFirstNames(final String fatherFirstNames) {
        this.fatherFirstNames = fatherFirstNames;
    }

 
    @Column(name="father_first_names"  )
      
    public String getFatherFirstNames() {
        return this.fatherFirstNames;
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

    public void setFatherLastName(final String fatherLastName) {
        this.fatherLastName = fatherLastName;
    }

 
    @Column(name="father_last_name" , length=38 )
      
    public String getFatherLastName() {
        return this.fatherLastName;
    }
  
    
      @NotNull(
        
        
        profiles = {"type"},
        message = "format"
      )
    
    private fr.cg95.cvq.business.request.civil.BirthCertificateFormatType format;

    public void setFormat(final fr.cg95.cvq.business.request.civil.BirthCertificateFormatType format) {
        this.format = format;
    }

 
    @Enumerated(EnumType.STRING)
    @Column(name="format"  )
      
    public fr.cg95.cvq.business.request.civil.BirthCertificateFormatType getFormat() {
        return this.format;
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

    public void setMotherFirstNames(final String motherFirstNames) {
        this.motherFirstNames = motherFirstNames;
    }

 
    @Column(name="mother_first_names"  )
      
    public String getMotherFirstNames() {
        return this.motherFirstNames;
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

    public void setMotherMaidenName(final String motherMaidenName) {
        this.motherMaidenName = motherMaidenName;
    }

 
    @Column(name="mother_maiden_name" , length=38 )
      
    public String getMotherMaidenName() {
        return this.motherMaidenName;
    }
  
    
      @NotNull(
        
        
        profiles = {"type"},
        message = "motive"
      )
    
    private fr.cg95.cvq.business.request.civil.BirthCertificateMotiveType motive;

    public void setMotive(final fr.cg95.cvq.business.request.civil.BirthCertificateMotiveType motive) {
        this.motive = motive;
    }

 
    @Enumerated(EnumType.STRING)
    @Column(name="motive"  )
      
    public fr.cg95.cvq.business.request.civil.BirthCertificateMotiveType getMotive() {
        return this.motive;
    }
  
    
      @NotNull(
        
        
        profiles = {"nature"},
        message = "requesterQuality"
      )
    
    private fr.cg95.cvq.business.request.civil.BirthRequesterQualityType requesterQuality;

    public void setRequesterQuality(final fr.cg95.cvq.business.request.civil.BirthRequesterQualityType requesterQuality) {
        this.requesterQuality = requesterQuality;
    }

 
    @Enumerated(EnumType.STRING)
    @Column(name="requester_quality"  )
      
    public fr.cg95.cvq.business.request.civil.BirthRequesterQualityType getRequesterQuality() {
        return this.requesterQuality;
    }
  
    
    private String requesterQualityPrecision;

    public void setRequesterQualityPrecision(final String requesterQualityPrecision) {
        this.requesterQualityPrecision = requesterQualityPrecision;
    }

 
    @Column(name="requester_quality_precision"  )
      
    public String getRequesterQualityPrecision() {
        return this.requesterQualityPrecision;
    }
  
}
