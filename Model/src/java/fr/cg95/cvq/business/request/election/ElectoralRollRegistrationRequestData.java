
package fr.cg95.cvq.business.request.election;

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
 *  table="electoral_roll_registration_request"
 *  lazy="false"
 */
public class ElectoralRollRegistrationRequestData implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    public ElectoralRollRegistrationRequestData() {
      
        motive = fr.cg95.cvq.business.request.election.ElectoralMotiveType.NEW_CITY_RESIDENT;
      
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

  
    private fr.cg95.cvq.business.users.NationalityType subjectNationality;

    public final void setSubjectNationality(final fr.cg95.cvq.business.users.NationalityType subjectNationality) {
        this.subjectNationality = subjectNationality;
    }

    /**
 
        * @hibernate.property
        *  column="subject_nationality"
        *  length="32"
      
    */
    public final fr.cg95.cvq.business.users.NationalityType getSubjectNationality() {
        return this.subjectNationality;
    }
  
    private String subjectOldCity;

    public final void setSubjectOldCity(final String subjectOldCity) {
        this.subjectOldCity = subjectOldCity;
    }

    /**
 
        * @hibernate.property
        *  column="subject_old_city"
        *  length="5"
      
    */
    public final String getSubjectOldCity() {
        return this.subjectOldCity;
    }
  
    private fr.cg95.cvq.business.users.Address subjectAddressOutsideCity;

    public final void setSubjectAddressOutsideCity(final fr.cg95.cvq.business.users.Address subjectAddressOutsideCity) {
        this.subjectAddressOutsideCity = subjectAddressOutsideCity;
    }

    /**
 
        * @hibernate.many-to-one
        *  cascade="all"
        *  column="subject_address_outside_city_id"
        *  class="fr.cg95.cvq.business.users.Address"
      
    */
    public final fr.cg95.cvq.business.users.Address getSubjectAddressOutsideCity() {
        return this.subjectAddressOutsideCity;
    }
  
    private Long pollingStation;

    public final void setPollingStation(final Long pollingStation) {
        this.pollingStation = pollingStation;
    }

    /**
 
        * @hibernate.property
        *  column="polling_station"
        
      
    */
    public final Long getPollingStation() {
        return this.pollingStation;
    }
  
    private String pollingSchoolName;

    public final void setPollingSchoolName(final String pollingSchoolName) {
        this.pollingSchoolName = pollingSchoolName;
    }

    /**
 
        * @hibernate.property
        *  column="polling_school_name"
        
      
    */
    public final String getPollingSchoolName() {
        return this.pollingSchoolName;
    }
  
    private fr.cg95.cvq.business.request.election.ElectoralMotiveType motive;

    public final void setMotive(final fr.cg95.cvq.business.request.election.ElectoralMotiveType motive) {
        this.motive = motive;
    }

    /**
 
        * @hibernate.property
        *  column="motive"
        
      
    */
    public final fr.cg95.cvq.business.request.election.ElectoralMotiveType getMotive() {
        return this.motive;
    }
  
    private Long electoralNumber;

    public final void setElectoralNumber(final Long electoralNumber) {
        this.electoralNumber = electoralNumber;
    }

    /**
 
        * @hibernate.property
        *  column="electoral_number"
        
      
    */
    public final Long getElectoralNumber() {
        return this.electoralNumber;
    }
  
}
