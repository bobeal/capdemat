
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
 *  table="death_details_request"
 *  lazy="false"
 */
public class DeathDetailsRequestData implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final Map<String, IConditionChecker> conditions =
        new HashMap<String, IConditionChecker>(RequestData.conditions);

    private Long id;

    public DeathDetailsRequestData() {
      
        format = fr.cg95.cvq.business.request.civil.DeathCertificateFormatType.FULL_COPY;
      
    }

    @Override
    public DeathDetailsRequestData clone() {
        DeathDetailsRequestData result = new DeathDetailsRequestData();
        
          
            
        result.setComment(comment);
      
          
        
          
            
        result.setCopies(copies);
      
          
        
          
            
        result.setDeathCity(deathCity);
      
          
        
          
            
        result.setDeathDate(deathDate);
      
          
        
          
            
        result.setDeathFirstNames(deathFirstNames);
      
          
        
          
            
        result.setDeathLastName(deathLastName);
      
          
        
          
            
        result.setDeathPostalCode(deathPostalCode);
      
          
        
          
            
        if (format != null)
            result.setFormat(format);
        else
            result.setFormat(fr.cg95.cvq.business.request.civil.DeathCertificateFormatType.getDefaultDeathCertificateFormatType());
      
          
        
          
            
        if (motive != null)
            result.setMotive(motive);
        else
            result.setMotive(fr.cg95.cvq.business.request.civil.DeathCertificateMotiveType.getDefaultDeathCertificateMotiveType());
      
          
        
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
        
          value = 32,
        
        
        profiles = {"nature"},
        message = "deathCity"
      )
    
      @NotNull(
        
        
        profiles = {"nature"},
        message = "deathCity"
      )
    
      @NotBlank(
        
        
        profiles = {"nature"},
        message = "deathCity"
      )
    
    private String deathCity;

    public final void setDeathCity(final String deathCity) {
        this.deathCity = deathCity;
    }

    /**
 
        * @hibernate.property
        *  column="death_city"
        *  length="32"
      
    */
    public final String getDeathCity() {
        return this.deathCity;
    }
  
    
      @NotNull(
        
        
        profiles = {"nature"},
        message = "deathDate"
      )
    
    private java.util.Date deathDate;

    public final void setDeathDate(final java.util.Date deathDate) {
        this.deathDate = deathDate;
    }

    /**
 
        * @hibernate.property
        *  column="death_date"
        
      
    */
    public final java.util.Date getDeathDate() {
        return this.deathDate;
    }
  
    
      @NotNull(
        
        
        profiles = {"nature"},
        message = "deathFirstNames"
      )
    
      @NotBlank(
        
        
        profiles = {"nature"},
        message = "deathFirstNames"
      )
    
    private String deathFirstNames;

    public final void setDeathFirstNames(final String deathFirstNames) {
        this.deathFirstNames = deathFirstNames;
    }

    /**
 
        * @hibernate.property
        *  column="death_first_names"
        
      
    */
    public final String getDeathFirstNames() {
        return this.deathFirstNames;
    }
  
    
      @MaxLength(
        
          value = 38,
        
        
        profiles = {"nature"},
        message = "deathLastName"
      )
    
      @NotNull(
        
        
        profiles = {"nature"},
        message = "deathLastName"
      )
    
      @NotBlank(
        
        
        profiles = {"nature"},
        message = "deathLastName"
      )
    
    private String deathLastName;

    public final void setDeathLastName(final String deathLastName) {
        this.deathLastName = deathLastName;
    }

    /**
 
        * @hibernate.property
        *  column="death_last_name"
        *  length="38"
      
    */
    public final String getDeathLastName() {
        return this.deathLastName;
    }
  
    
      @MaxLength(
        
          value = 2,
        
        
        profiles = {"nature"},
        message = "deathPostalCode"
      )
    
      @NotNull(
        
        
        profiles = {"nature"},
        message = "deathPostalCode"
      )
    
      @NotBlank(
        
        
        profiles = {"nature"},
        message = "deathPostalCode"
      )
    
    private String deathPostalCode;

    public final void setDeathPostalCode(final String deathPostalCode) {
        this.deathPostalCode = deathPostalCode;
    }

    /**
 
        * @hibernate.property
        *  column="death_postal_code"
        *  length="2"
      
    */
    public final String getDeathPostalCode() {
        return this.deathPostalCode;
    }
  
    
      @NotNull(
        
        
        profiles = {"type"},
        message = "format"
      )
    
    private fr.cg95.cvq.business.request.civil.DeathCertificateFormatType format;

    public final void setFormat(final fr.cg95.cvq.business.request.civil.DeathCertificateFormatType format) {
        this.format = format;
    }

    /**
 
        * @hibernate.property
        *  column="format"
        
      
    */
    public final fr.cg95.cvq.business.request.civil.DeathCertificateFormatType getFormat() {
        return this.format;
    }
  
    
    private fr.cg95.cvq.business.request.civil.DeathCertificateMotiveType motive;

    public final void setMotive(final fr.cg95.cvq.business.request.civil.DeathCertificateMotiveType motive) {
        this.motive = motive;
    }

    /**
 
        * @hibernate.property
        *  column="motive"
        
      
    */
    public final fr.cg95.cvq.business.request.civil.DeathCertificateMotiveType getMotive() {
        return this.motive;
    }
  
}
