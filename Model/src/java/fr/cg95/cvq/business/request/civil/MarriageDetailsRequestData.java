
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
 *  table="marriage_details_request"
 *  lazy="false"
 */
public class MarriageDetailsRequestData implements Serializable {

    private static final long serialVersionUID = 1L;

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
