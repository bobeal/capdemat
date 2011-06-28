
package fr.cg95.cvq.business.request.school;

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
 *  table="child_care_center_registration_request"
 *  lazy="false"
 */
public class ChildCareCenterRegistrationRequestData implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final Map<String, IConditionChecker> conditions =
        new HashMap<String, IConditionChecker>(RequestData.conditions);

    private Long id;

    public ChildCareCenterRegistrationRequestData() {
      
        tuesdayPeriod = fr.cg95.cvq.business.request.school.DayPeriodType.ALL_DAY;
      
        fridayPeriod = fr.cg95.cvq.business.request.school.DayPeriodType.ALL_DAY;
      
        wednesdayPeriod = fr.cg95.cvq.business.request.school.DayPeriodType.ALL_DAY;
      
        mondayPeriod = fr.cg95.cvq.business.request.school.DayPeriodType.ALL_DAY;
      
        thursdayPeriod = fr.cg95.cvq.business.request.school.DayPeriodType.ALL_DAY;
      
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

  
    
    private String thursdaySecondPeriodBegining;

    public final void setThursdaySecondPeriodBegining(final String thursdaySecondPeriodBegining) {
        this.thursdaySecondPeriodBegining = thursdaySecondPeriodBegining;
    }

    /**
 
        * @hibernate.property
        *  column="thursday_second_period_begining"
        
      
    */
    public final String getThursdaySecondPeriodBegining() {
        return this.thursdaySecondPeriodBegining;
    }
  
    
    private String fridayFirstPeriodEnding;

    public final void setFridayFirstPeriodEnding(final String fridayFirstPeriodEnding) {
        this.fridayFirstPeriodEnding = fridayFirstPeriodEnding;
    }

    /**
 
        * @hibernate.property
        *  column="friday_first_period_ending"
        
      
    */
    public final String getFridayFirstPeriodEnding() {
        return this.fridayFirstPeriodEnding;
    }
  
    
      @LocalReferential(
        
        
        profiles = {"welcoming"},
        message = "welcomingChoice"
      )
    
      @MinSize(
        
          value = 1,
        
        
        profiles = {"welcoming"},
        message = "welcomingChoice"
      )
    
    private List<fr.cg95.cvq.business.request.LocalReferentialData> welcomingChoice;

    public final void setWelcomingChoice(final List<fr.cg95.cvq.business.request.LocalReferentialData> welcomingChoice) {
        this.welcomingChoice = welcomingChoice;
    }

    /**
 
        * @hibernate.list
        *  inverse="false"
        *  lazy="false"
        *  cascade="all"
        *  table="child_care_center_registration_request_welcoming_choice"
        * @hibernate.key
        *  column="child_care_center_registration_request_id"
        * @hibernate.list-index
        *  column="welcoming_choice_index"
        * @hibernate.many-to-many
        *  column="welcoming_choice_id"
        *  class="fr.cg95.cvq.business.request.LocalReferentialData"
      
    */
    public final List<fr.cg95.cvq.business.request.LocalReferentialData> getWelcomingChoice() {
        return this.welcomingChoice;
    }
  
    
    private String wednesdayFirstPeriodBegining;

    public final void setWednesdayFirstPeriodBegining(final String wednesdayFirstPeriodBegining) {
        this.wednesdayFirstPeriodBegining = wednesdayFirstPeriodBegining;
    }

    /**
 
        * @hibernate.property
        *  column="wednesday_first_period_begining"
        
      
    */
    public final String getWednesdayFirstPeriodBegining() {
        return this.wednesdayFirstPeriodBegining;
    }
  
    
    private String fridayFirstPeriodBegining;

    public final void setFridayFirstPeriodBegining(final String fridayFirstPeriodBegining) {
        this.fridayFirstPeriodBegining = fridayFirstPeriodBegining;
    }

    /**
 
        * @hibernate.property
        *  column="friday_first_period_begining"
        
      
    */
    public final String getFridayFirstPeriodBegining() {
        return this.fridayFirstPeriodBegining;
    }
  
    
    private String mondayFirstPeriodBegining;

    public final void setMondayFirstPeriodBegining(final String mondayFirstPeriodBegining) {
        this.mondayFirstPeriodBegining = mondayFirstPeriodBegining;
    }

    /**
 
        * @hibernate.property
        *  column="monday_first_period_begining"
        
      
    */
    public final String getMondayFirstPeriodBegining() {
        return this.mondayFirstPeriodBegining;
    }
  
    
    private String tuesdaySecondPeriodBegining;

    public final void setTuesdaySecondPeriodBegining(final String tuesdaySecondPeriodBegining) {
        this.tuesdaySecondPeriodBegining = tuesdaySecondPeriodBegining;
    }

    /**
 
        * @hibernate.property
        *  column="tuesday_second_period_begining"
        
      
    */
    public final String getTuesdaySecondPeriodBegining() {
        return this.tuesdaySecondPeriodBegining;
    }
  
    
    private String tuesdaySecondPeriodEnding;

    public final void setTuesdaySecondPeriodEnding(final String tuesdaySecondPeriodEnding) {
        this.tuesdaySecondPeriodEnding = tuesdaySecondPeriodEnding;
    }

    /**
 
        * @hibernate.property
        *  column="tuesday_second_period_ending"
        
      
    */
    public final String getTuesdaySecondPeriodEnding() {
        return this.tuesdaySecondPeriodEnding;
    }
  
    
    private String thursdayFirstPeriodEnding;

    public final void setThursdayFirstPeriodEnding(final String thursdayFirstPeriodEnding) {
        this.thursdayFirstPeriodEnding = thursdayFirstPeriodEnding;
    }

    /**
 
        * @hibernate.property
        *  column="thursday_first_period_ending"
        
      
    */
    public final String getThursdayFirstPeriodEnding() {
        return this.thursdayFirstPeriodEnding;
    }
  
    
    private String thursdaySecondPeriodEnding;

    public final void setThursdaySecondPeriodEnding(final String thursdaySecondPeriodEnding) {
        this.thursdaySecondPeriodEnding = thursdaySecondPeriodEnding;
    }

    /**
 
        * @hibernate.property
        *  column="thursday_second_period_ending"
        
      
    */
    public final String getThursdaySecondPeriodEnding() {
        return this.thursdaySecondPeriodEnding;
    }
  
    
    private String tuesdayFirstPeriodEnding;

    public final void setTuesdayFirstPeriodEnding(final String tuesdayFirstPeriodEnding) {
        this.tuesdayFirstPeriodEnding = tuesdayFirstPeriodEnding;
    }

    /**
 
        * @hibernate.property
        *  column="tuesday_first_period_ending"
        
      
    */
    public final String getTuesdayFirstPeriodEnding() {
        return this.tuesdayFirstPeriodEnding;
    }
  
    
    private fr.cg95.cvq.business.request.school.DayPeriodType tuesdayPeriod;

    public final void setTuesdayPeriod(final fr.cg95.cvq.business.request.school.DayPeriodType tuesdayPeriod) {
        this.tuesdayPeriod = tuesdayPeriod;
    }

    /**
 
        * @hibernate.property
        *  column="tuesday_period"
        
      
    */
    public final fr.cg95.cvq.business.request.school.DayPeriodType getTuesdayPeriod() {
        return this.tuesdayPeriod;
    }
  
    
    private java.util.Date subjectChoiceBirthDate;

    public final void setSubjectChoiceBirthDate(final java.util.Date subjectChoiceBirthDate) {
        this.subjectChoiceBirthDate = subjectChoiceBirthDate;
    }

    /**
 
        * @hibernate.property
        *  column="subject_choice_birth_date"
        
      
    */
    public final java.util.Date getSubjectChoiceBirthDate() {
        return this.subjectChoiceBirthDate;
    }
  
    
    private String tuesdayFirstPeriodBegining;

    public final void setTuesdayFirstPeriodBegining(final String tuesdayFirstPeriodBegining) {
        this.tuesdayFirstPeriodBegining = tuesdayFirstPeriodBegining;
    }

    /**
 
        * @hibernate.property
        *  column="tuesday_first_period_begining"
        
      
    */
    public final String getTuesdayFirstPeriodBegining() {
        return this.tuesdayFirstPeriodBegining;
    }
  
    
    private String wednesdayFirstPeriodEnding;

    public final void setWednesdayFirstPeriodEnding(final String wednesdayFirstPeriodEnding) {
        this.wednesdayFirstPeriodEnding = wednesdayFirstPeriodEnding;
    }

    /**
 
        * @hibernate.property
        *  column="wednesday_first_period_ending"
        
      
    */
    public final String getWednesdayFirstPeriodEnding() {
        return this.wednesdayFirstPeriodEnding;
    }
  
    
    private String wednesdaySecondPeriodEnding;

    public final void setWednesdaySecondPeriodEnding(final String wednesdaySecondPeriodEnding) {
        this.wednesdaySecondPeriodEnding = wednesdaySecondPeriodEnding;
    }

    /**
 
        * @hibernate.property
        *  column="wednesday_second_period_ending"
        
      
    */
    public final String getWednesdaySecondPeriodEnding() {
        return this.wednesdaySecondPeriodEnding;
    }
  
    
    private fr.cg95.cvq.business.request.school.DayPeriodType fridayPeriod;

    public final void setFridayPeriod(final fr.cg95.cvq.business.request.school.DayPeriodType fridayPeriod) {
        this.fridayPeriod = fridayPeriod;
    }

    /**
 
        * @hibernate.property
        *  column="friday_period"
        
      
    */
    public final fr.cg95.cvq.business.request.school.DayPeriodType getFridayPeriod() {
        return this.fridayPeriod;
    }
  
    
    private fr.cg95.cvq.business.request.school.DayPeriodType wednesdayPeriod;

    public final void setWednesdayPeriod(final fr.cg95.cvq.business.request.school.DayPeriodType wednesdayPeriod) {
        this.wednesdayPeriod = wednesdayPeriod;
    }

    /**
 
        * @hibernate.property
        *  column="wednesday_period"
        
      
    */
    public final fr.cg95.cvq.business.request.school.DayPeriodType getWednesdayPeriod() {
        return this.wednesdayPeriod;
    }
  
    
    private String mondaySecondPeriodEnding;

    public final void setMondaySecondPeriodEnding(final String mondaySecondPeriodEnding) {
        this.mondaySecondPeriodEnding = mondaySecondPeriodEnding;
    }

    /**
 
        * @hibernate.property
        *  column="monday_second_period_ending"
        
      
    */
    public final String getMondaySecondPeriodEnding() {
        return this.mondaySecondPeriodEnding;
    }
  
    
    private String mondayFirstPeriodEnding;

    public final void setMondayFirstPeriodEnding(final String mondayFirstPeriodEnding) {
        this.mondayFirstPeriodEnding = mondayFirstPeriodEnding;
    }

    /**
 
        * @hibernate.property
        *  column="monday_first_period_ending"
        
      
    */
    public final String getMondayFirstPeriodEnding() {
        return this.mondayFirstPeriodEnding;
    }
  
    
    private String fridaySecondPeriodBegining;

    public final void setFridaySecondPeriodBegining(final String fridaySecondPeriodBegining) {
        this.fridaySecondPeriodBegining = fridaySecondPeriodBegining;
    }

    /**
 
        * @hibernate.property
        *  column="friday_second_period_begining"
        
      
    */
    public final String getFridaySecondPeriodBegining() {
        return this.fridaySecondPeriodBegining;
    }
  
    
    private String fridaySecondPeriodEnding;

    public final void setFridaySecondPeriodEnding(final String fridaySecondPeriodEnding) {
        this.fridaySecondPeriodEnding = fridaySecondPeriodEnding;
    }

    /**
 
        * @hibernate.property
        *  column="friday_second_period_ending"
        
      
    */
    public final String getFridaySecondPeriodEnding() {
        return this.fridaySecondPeriodEnding;
    }
  
    
    private String mondaySecondPeriodBegining;

    public final void setMondaySecondPeriodBegining(final String mondaySecondPeriodBegining) {
        this.mondaySecondPeriodBegining = mondaySecondPeriodBegining;
    }

    /**
 
        * @hibernate.property
        *  column="monday_second_period_begining"
        
      
    */
    public final String getMondaySecondPeriodBegining() {
        return this.mondaySecondPeriodBegining;
    }
  
    
    private fr.cg95.cvq.business.request.school.DayPeriodType mondayPeriod;

    public final void setMondayPeriod(final fr.cg95.cvq.business.request.school.DayPeriodType mondayPeriod) {
        this.mondayPeriod = mondayPeriod;
    }

    /**
 
        * @hibernate.property
        *  column="monday_period"
        
      
    */
    public final fr.cg95.cvq.business.request.school.DayPeriodType getMondayPeriod() {
        return this.mondayPeriod;
    }
  
    
      @NotNull(
        
        
        profiles = {"registrationParams"},
        message = "registrationDate"
      )
    
    private java.util.Date registrationDate;

    public final void setRegistrationDate(final java.util.Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    /**
 
        * @hibernate.property
        *  column="registration_date"
        
      
    */
    public final java.util.Date getRegistrationDate() {
        return this.registrationDate;
    }
  
    
    private String wednesdaySecondPeriodBegining;

    public final void setWednesdaySecondPeriodBegining(final String wednesdaySecondPeriodBegining) {
        this.wednesdaySecondPeriodBegining = wednesdaySecondPeriodBegining;
    }

    /**
 
        * @hibernate.property
        *  column="wednesday_second_period_begining"
        
      
    */
    public final String getWednesdaySecondPeriodBegining() {
        return this.wednesdaySecondPeriodBegining;
    }
  
    
    private fr.cg95.cvq.business.users.SexType subjectChoiceGender;

    public final void setSubjectChoiceGender(final fr.cg95.cvq.business.users.SexType subjectChoiceGender) {
        this.subjectChoiceGender = subjectChoiceGender;
    }

    /**
 
        * @hibernate.property
        *  column="subject_choice_gender"
        
      
    */
    public final fr.cg95.cvq.business.users.SexType getSubjectChoiceGender() {
        return this.subjectChoiceGender;
    }
  
    
    private String thursdayFirstPeriodBegining;

    public final void setThursdayFirstPeriodBegining(final String thursdayFirstPeriodBegining) {
        this.thursdayFirstPeriodBegining = thursdayFirstPeriodBegining;
    }

    /**
 
        * @hibernate.property
        *  column="thursday_first_period_begining"
        
      
    */
    public final String getThursdayFirstPeriodBegining() {
        return this.thursdayFirstPeriodBegining;
    }
  
    
    private fr.cg95.cvq.business.request.school.DayPeriodType thursdayPeriod;

    public final void setThursdayPeriod(final fr.cg95.cvq.business.request.school.DayPeriodType thursdayPeriod) {
        this.thursdayPeriod = thursdayPeriod;
    }

    /**
 
        * @hibernate.property
        *  column="thursday_period"
        
      
    */
    public final fr.cg95.cvq.business.request.school.DayPeriodType getThursdayPeriod() {
        return this.thursdayPeriod;
    }
  
}
