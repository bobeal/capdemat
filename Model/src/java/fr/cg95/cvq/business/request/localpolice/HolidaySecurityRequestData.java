
package fr.cg95.cvq.business.request.localpolice;

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
 *  table="holiday_security_request"
 *  lazy="false"
 */
public class HolidaySecurityRequestData implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final Map<String, IConditionChecker> conditions =
        new HashMap<String, IConditionChecker>(RequestData.conditions);

    private Long id;

    public HolidaySecurityRequestData() {
      
        rulesAndRegulationsAcceptance = Boolean.valueOf(false);
      
        otherContact = Boolean.valueOf(false);
      
        light = Boolean.valueOf(false);
      
        alarm = Boolean.valueOf(false);
      
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
        
        
          when = "groovy:def active = true;" +
          
            
            "active &= _this.conditions['otherContact'].test(_this.otherContact.toString());" +
                
              
            
            "return active",
        
        profiles = {"contact"},
        message = "otherContactAddress"
      )
    
      @AssertValid(
        
        
          when = "groovy:def active = true;" +
          
            
            "active &= _this.conditions['otherContact'].test(_this.otherContact.toString());" +
                
              
            
            "return active",
        
        profiles = {"contact"},
        message = "otherContactAddress"
      )
    
    private fr.cg95.cvq.business.users.Address otherContactAddress;

    public final void setOtherContactAddress(final fr.cg95.cvq.business.users.Address otherContactAddress) {
        this.otherContactAddress = otherContactAddress;
    }

    /**
 
        * @hibernate.many-to-one
        *  cascade="all"
        *  column="other_contact_address_id"
        *  class="fr.cg95.cvq.business.users.Address"
      
    */
    public final fr.cg95.cvq.business.users.Address getOtherContactAddress() {
        return this.otherContactAddress;
    }
  
    
      @NotNull(
        
        
        profiles = {"rules"},
        message = "rulesAndRegulationsAcceptance"
      )
    
    private Boolean rulesAndRegulationsAcceptance;

    public final void setRulesAndRegulationsAcceptance(final Boolean rulesAndRegulationsAcceptance) {
        this.rulesAndRegulationsAcceptance = rulesAndRegulationsAcceptance;
    }

    /**
 
        * @hibernate.property
        *  column="rules_and_regulations_acceptance"
        
      
    */
    public final Boolean getRulesAndRegulationsAcceptance() {
        return this.rulesAndRegulationsAcceptance;
    }
  
    
      @NotNull(
        
        
        profiles = {"contact"},
        message = "otherContact"
      )
    
    private Boolean otherContact;

    public final void setOtherContact(final Boolean otherContact) {
        this.otherContact = otherContact;
    }

    /**
 
        * @hibernate.property
        *  column="other_contact"
        
      
    */
    public final Boolean getOtherContact() {
        return this.otherContact;
    }
  
    
      @NotNull(
        
        
        profiles = {"registration"},
        message = "absenceStartDate"
      )
    
    private java.util.Date absenceStartDate;

    public final void setAbsenceStartDate(final java.util.Date absenceStartDate) {
        this.absenceStartDate = absenceStartDate;
    }

    /**
 
        * @hibernate.property
        *  column="absence_start_date"
        
      
    */
    public final java.util.Date getAbsenceStartDate() {
        return this.absenceStartDate;
    }
  
    
      @MaxLength(
        
          value = 38,
        
        
          when = "groovy:def active = true;" +
          
            
            "active &= _this.conditions['otherContact'].test(_this.otherContact.toString());" +
                
              
            
            "return active",
        
        profiles = {"contact"},
        message = "otherContactFirstName"
      )
    
      @NotNull(
        
        
          when = "groovy:def active = true;" +
          
            
            "active &= _this.conditions['otherContact'].test(_this.otherContact.toString());" +
                
              
            
            "return active",
        
        profiles = {"contact"},
        message = "otherContactFirstName"
      )
    
      @NotBlank(
        
        
          when = "groovy:def active = true;" +
          
            
            "active &= _this.conditions['otherContact'].test(_this.otherContact.toString());" +
                
              
            
            "return active",
        
        profiles = {"contact"},
        message = "otherContactFirstName"
      )
    
    private String otherContactFirstName;

    public final void setOtherContactFirstName(final String otherContactFirstName) {
        this.otherContactFirstName = otherContactFirstName;
    }

    /**
 
        * @hibernate.property
        *  column="other_contact_first_name"
        *  length="38"
      
    */
    public final String getOtherContactFirstName() {
        return this.otherContactFirstName;
    }
  
    
      @MaxLength(
        
          value = 10,
        
        
          when = "groovy:def active = true;" +
          
            
            "active &= _this.conditions['otherContact'].test(_this.otherContact.toString());" +
                
              
            
            "return active",
        
        profiles = {"contact"},
        message = "otherContactPhone"
      )
    
      @NotNull(
        
        
          when = "groovy:def active = true;" +
          
            
            "active &= _this.conditions['otherContact'].test(_this.otherContact.toString());" +
                
              
            
            "return active",
        
        profiles = {"contact"},
        message = "otherContactPhone"
      )
    
      @NotBlank(
        
        
          when = "groovy:def active = true;" +
          
            
            "active &= _this.conditions['otherContact'].test(_this.otherContact.toString());" +
                
              
            
            "return active",
        
        profiles = {"contact"},
        message = "otherContactPhone"
      )
    
    private String otherContactPhone;

    public final void setOtherContactPhone(final String otherContactPhone) {
        this.otherContactPhone = otherContactPhone;
    }

    /**
 
        * @hibernate.property
        *  column="other_contact_phone"
        *  length="10"
      
    */
    public final String getOtherContactPhone() {
        return this.otherContactPhone;
    }
  
    
      @NotNull(
        
        
        profiles = {"additional"},
        message = "light"
      )
    
    private Boolean light;

    public final void setLight(final Boolean light) {
        this.light = light;
    }

    /**
 
        * @hibernate.property
        *  column="light"
        
      
    */
    public final Boolean getLight() {
        return this.light;
    }
  
    
      @MaxLength(
        
          value = 10,
        
        
        profiles = {"contactphone"},
        message = "alertPhone"
      )
    
      @NotNull(
        
        
        profiles = {"contactphone"},
        message = "alertPhone"
      )
    
      @NotBlank(
        
        
        profiles = {"contactphone"},
        message = "alertPhone"
      )
    
    private String alertPhone;

    public final void setAlertPhone(final String alertPhone) {
        this.alertPhone = alertPhone;
    }

    /**
 
        * @hibernate.property
        *  column="alert_phone"
        *  length="10"
      
    */
    public final String getAlertPhone() {
        return this.alertPhone;
    }
  
    
      @MaxLength(
        
          value = 38,
        
        
          when = "groovy:def active = true;" +
          
            
            "active &= _this.conditions['otherContact'].test(_this.otherContact.toString());" +
                
              
            
            "return active",
        
        profiles = {"contact"},
        message = "otherContactLastName"
      )
    
      @NotNull(
        
        
          when = "groovy:def active = true;" +
          
            
            "active &= _this.conditions['otherContact'].test(_this.otherContact.toString());" +
                
              
            
            "return active",
        
        profiles = {"contact"},
        message = "otherContactLastName"
      )
    
      @NotBlank(
        
        
          when = "groovy:def active = true;" +
          
            
            "active &= _this.conditions['otherContact'].test(_this.otherContact.toString());" +
                
              
            
            "return active",
        
        profiles = {"contact"},
        message = "otherContactLastName"
      )
    
    private String otherContactLastName;

    public final void setOtherContactLastName(final String otherContactLastName) {
        this.otherContactLastName = otherContactLastName;
    }

    /**
 
        * @hibernate.property
        *  column="other_contact_last_name"
        *  length="38"
      
    */
    public final String getOtherContactLastName() {
        return this.otherContactLastName;
    }
  
    
      @NotNull(
        
        
        profiles = {"additional"},
        message = "alarm"
      )
    
    private Boolean alarm;

    public final void setAlarm(final Boolean alarm) {
        this.alarm = alarm;
    }

    /**
 
        * @hibernate.property
        *  column="alarm"
        
      
    */
    public final Boolean getAlarm() {
        return this.alarm;
    }
  
    
      @NotNull(
        
        
        profiles = {"registration"},
        message = "absenceEndDate"
      )
    
    private java.util.Date absenceEndDate;

    public final void setAbsenceEndDate(final java.util.Date absenceEndDate) {
        this.absenceEndDate = absenceEndDate;
    }

    /**
 
        * @hibernate.property
        *  column="absence_end_date"
        
      
    */
    public final java.util.Date getAbsenceEndDate() {
        return this.absenceEndDate;
    }
  
}
