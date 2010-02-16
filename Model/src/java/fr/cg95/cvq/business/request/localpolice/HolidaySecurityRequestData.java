
package fr.cg95.cvq.business.request.localpolice;

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
 *  table="holiday_security_request"
 *  lazy="false"
 */
public class HolidaySecurityRequestData implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    public HolidaySecurityRequestData() {
      
        alarm = Boolean.valueOf(false);
      
        light = Boolean.valueOf(false);
      
        rulesAndRegulationsAcceptance = Boolean.valueOf(false);
      
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
  
}
