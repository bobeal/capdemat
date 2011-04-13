

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
@Table(name="marriage_details_request")
public class MarriageDetailsRequestData implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final Map<String, IConditionChecker> conditions =
        new HashMap<String, IConditionChecker>(RequestData.conditions);

    private Long id;

    public MarriageDetailsRequestData() {
      
        format = fr.cg95.cvq.business.request.civil.MarriageCertificateFormatType.FULL_COPY;
      
    }

    @Override
    public MarriageDetailsRequestData clone() {
        MarriageDetailsRequestData result = new MarriageDetailsRequestData();
        
          
            
        result.setComment(comment);
      
          
        
          
            
        result.setCopies(copies);
      
          
        
          
            
        result.setFatherFirstNames(fatherFirstNames);
      
          
        
          
            
        result.setFatherLastName(fatherLastName);
      
          
        
          
            
        if (format != null)
            result.setFormat(format);
        else
            result.setFormat(fr.cg95.cvq.business.request.civil.MarriageCertificateFormatType.getDefaultMarriageCertificateFormatType());
      
          
        
          
            
        result.setMarriageCity(marriageCity);
      
          
        
          
            
        result.setMarriageDate(marriageDate);
      
          
        
          
            
        result.setMarriageHusbandFirstNames(marriageHusbandFirstNames);
      
          
        
          
            
        result.setMarriageHusbandLastName(marriageHusbandLastName);
      
          
        
          
            
        result.setMarriagePostalCode(marriagePostalCode);
      
          
        
          
            
        result.setMarriageWifeFirstNames(marriageWifeFirstNames);
      
          
        
          
            
        result.setMarriageWifeLastName(marriageWifeLastName);
      
          
        
          
            
        result.setMotherFirstNames(motherFirstNames);
      
          
        
          
            
        result.setMotherMaidenName(motherMaidenName);
      
          
        
          
            
        if (motive != null)
            result.setMotive(motive);
        else
            result.setMotive(fr.cg95.cvq.business.request.civil.MarriageCertificateMotiveType.getDefaultMarriageCertificateMotiveType());
      
          
        
          
            
        if (relationship != null)
            result.setRelationship(relationship);
        else
            result.setRelationship(fr.cg95.cvq.business.request.civil.MarriageRelationshipType.getDefaultMarriageRelationshipType());
      
          
        
          
            
        if (requesterQuality != null)
            result.setRequesterQuality(requesterQuality);
        else
            result.setRequesterQuality(fr.cg95.cvq.business.request.civil.MarriageRequesterQualityType.getDefaultMarriageRequesterQualityType());
      
          
        
          
            
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
        
          value = 255,
        
        
        profiles = {"type"},
        message = "comment"
      )
    
      @MatchPattern(
        
          pattern = "[\\w\\W]{0,255}$",
        
        
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
    
    private fr.cg95.cvq.business.request.civil.MarriageCertificateFormatType format;

    public void setFormat(final fr.cg95.cvq.business.request.civil.MarriageCertificateFormatType format) {
        this.format = format;
    }

 
    @Enumerated(EnumType.STRING)
    @Column(name="format"  )
      
    public fr.cg95.cvq.business.request.civil.MarriageCertificateFormatType getFormat() {
        return this.format;
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

    public void setMarriageCity(final String marriageCity) {
        this.marriageCity = marriageCity;
    }

 
    @Column(name="marriage_city" , length=32 )
      
    public String getMarriageCity() {
        return this.marriageCity;
    }
  
    
      @NotNull(
        
        
        profiles = {"nature"},
        message = "marriageDate"
      )
    
    private java.util.Date marriageDate;

    public void setMarriageDate(final java.util.Date marriageDate) {
        this.marriageDate = marriageDate;
    }

 
    @Column(name="marriage_date"  )
      
    public java.util.Date getMarriageDate() {
        return this.marriageDate;
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

    public void setMarriageHusbandFirstNames(final String marriageHusbandFirstNames) {
        this.marriageHusbandFirstNames = marriageHusbandFirstNames;
    }

 
    @Column(name="marriage_husband_first_names"  )
      
    public String getMarriageHusbandFirstNames() {
        return this.marriageHusbandFirstNames;
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

    public void setMarriageHusbandLastName(final String marriageHusbandLastName) {
        this.marriageHusbandLastName = marriageHusbandLastName;
    }

 
    @Column(name="marriage_husband_last_name" , length=38 )
      
    public String getMarriageHusbandLastName() {
        return this.marriageHusbandLastName;
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

    public void setMarriagePostalCode(final String marriagePostalCode) {
        this.marriagePostalCode = marriagePostalCode;
    }

 
    @Column(name="marriage_postal_code" , length=2 )
      
    public String getMarriagePostalCode() {
        return this.marriagePostalCode;
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

    public void setMarriageWifeFirstNames(final String marriageWifeFirstNames) {
        this.marriageWifeFirstNames = marriageWifeFirstNames;
    }

 
    @Column(name="marriage_wife_first_names"  )
      
    public String getMarriageWifeFirstNames() {
        return this.marriageWifeFirstNames;
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

    public void setMarriageWifeLastName(final String marriageWifeLastName) {
        this.marriageWifeLastName = marriageWifeLastName;
    }

 
    @Column(name="marriage_wife_last_name" , length=38 )
      
    public String getMarriageWifeLastName() {
        return this.marriageWifeLastName;
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
  
    
    private fr.cg95.cvq.business.request.civil.MarriageCertificateMotiveType motive;

    public void setMotive(final fr.cg95.cvq.business.request.civil.MarriageCertificateMotiveType motive) {
        this.motive = motive;
    }

 
    @Enumerated(EnumType.STRING)
    @Column(name="motive"  )
      
    public fr.cg95.cvq.business.request.civil.MarriageCertificateMotiveType getMotive() {
        return this.motive;
    }
  
    
      @NotNull(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['format'].test(_this.format.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"type"},
        message = "relationship"
      )
    
    private fr.cg95.cvq.business.request.civil.MarriageRelationshipType relationship;

    public void setRelationship(final fr.cg95.cvq.business.request.civil.MarriageRelationshipType relationship) {
        this.relationship = relationship;
    }

 
    @Enumerated(EnumType.STRING)
    @Column(name="relationship"  )
      
    public fr.cg95.cvq.business.request.civil.MarriageRelationshipType getRelationship() {
        return this.relationship;
    }
  
    
    private fr.cg95.cvq.business.request.civil.MarriageRequesterQualityType requesterQuality;

    public void setRequesterQuality(final fr.cg95.cvq.business.request.civil.MarriageRequesterQualityType requesterQuality) {
        this.requesterQuality = requesterQuality;
    }

 
    @Enumerated(EnumType.STRING)
    @Column(name="requester_quality"  )
      
    public fr.cg95.cvq.business.request.civil.MarriageRequesterQualityType getRequesterQuality() {
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
