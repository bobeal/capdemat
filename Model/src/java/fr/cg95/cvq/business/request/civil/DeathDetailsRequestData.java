
package fr.cg95.cvq.business.request.civil;

import java.io.Serializable;
import java.math.BigInteger;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import fr.cg95.cvq.business.authority.*;
import fr.cg95.cvq.business.request.*;
import fr.cg95.cvq.business.users.*;

/**
 * Generated class file, do not edit !
 *
 * @hibernate.class
 *  table="death_details_request"
 *  lazy="false"
 */
public class DeathDetailsRequestData implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    public DeathDetailsRequestData() {
      
        format = fr.cg95.cvq.business.request.civil.DeathCertificateFormatType.FULL_COPY;
      
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
  
}
