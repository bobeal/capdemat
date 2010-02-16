
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
 *  table="birth_details_request"
 *  lazy="false"
 */
public class BirthDetailsRequestData implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    public BirthDetailsRequestData() {
      
        format = fr.cg95.cvq.business.request.civil.BirthCertificateFormatType.FULL_COPY;
      
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
  
}
