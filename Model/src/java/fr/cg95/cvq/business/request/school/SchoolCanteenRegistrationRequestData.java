
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
 *  table="school_canteen_registration_request"
 *  lazy="false"
 */
public class SchoolCanteenRegistrationRequestData implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final Map<String, IConditionChecker> conditions =
        new HashMap<String, IConditionChecker>(RequestData.conditions);

    private Long id;

    public SchoolCanteenRegistrationRequestData() {
      
        foodAllergy = Boolean.valueOf(false);
      
        hospitalizationPermission = Boolean.valueOf(false);
      
        rulesAndRegulationsAcceptance = Boolean.valueOf(false);
      
        section = fr.cg95.cvq.business.users.SectionType.UNKNOWN;
      
    }

    @Override
    public SchoolCanteenRegistrationRequestData clone() {
        SchoolCanteenRegistrationRequestData result = new SchoolCanteenRegistrationRequestData();
        
          
            
        List<fr.cg95.cvq.business.request.LocalReferentialData> foodDietList = new ArrayList<fr.cg95.cvq.business.request.LocalReferentialData>();
        for (LocalReferentialData object : foodDiet) {
            foodDietList.add(object.clone());
        }
        result.setFoodDiet(foodDietList);
      
          
        
          
            
        result.setFoodAllergy(foodAllergy);
      
          
        
          
            
        result.setDoctorPhone(doctorPhone);
      
          
        
          
            
        result.setDoctorName(doctorName);
      
          
        
          
            
        List<fr.cg95.cvq.business.request.LocalReferentialData> canteenAttendingDaysList = new ArrayList<fr.cg95.cvq.business.request.LocalReferentialData>();
        for (LocalReferentialData object : canteenAttendingDays) {
            canteenAttendingDaysList.add(object.clone());
        }
        result.setCanteenAttendingDays(canteenAttendingDaysList);
      
          
        
          
            result.setSchool(school);
          
        
          
            
        result.setHospitalizationPermission(hospitalizationPermission);
      
          
        
          
            
        result.setRulesAndRegulationsAcceptance(rulesAndRegulationsAcceptance);
      
          
        
          
            
        result.setUrgencyPhone(urgencyPhone);
      
          
        
          
            
        if (section != null)
            result.setSection(section);
        else
            result.setSection(fr.cg95.cvq.business.users.SectionType.getDefaultSectionType());
      
          
        
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

  
    
      @LocalReferential(
        
        
        profiles = {"registration"},
        message = "foodDiet"
      )
    
      @MinSize(
        
          value = 1,
        
        
        profiles = {"registration"},
        message = "foodDiet"
      )
    
    private List<fr.cg95.cvq.business.request.LocalReferentialData> foodDiet;

    public final void setFoodDiet(final List<fr.cg95.cvq.business.request.LocalReferentialData> foodDiet) {
        this.foodDiet = foodDiet;
    }

    /**
 
        * @hibernate.list
        *  inverse="false"
        *  lazy="false"
        *  cascade="all"
        *  table="school_canteen_registration_request_food_diet"
        * @hibernate.key
        *  column="school_canteen_registration_request_id"
        * @hibernate.list-index
        *  column="food_diet_index"
        * @hibernate.many-to-many
        *  column="food_diet_id"
        *  class="fr.cg95.cvq.business.request.LocalReferentialData"
      
    */
    public final List<fr.cg95.cvq.business.request.LocalReferentialData> getFoodDiet() {
        return this.foodDiet;
    }
  
    
      @NotNull(
        
        
        profiles = {"registration"},
        message = "foodAllergy"
      )
    
    private Boolean foodAllergy;

    public final void setFoodAllergy(final Boolean foodAllergy) {
        this.foodAllergy = foodAllergy;
    }

    /**
 
        * @hibernate.property
        *  column="food_allergy"
        
      
    */
    public final Boolean getFoodAllergy() {
        return this.foodAllergy;
    }
  
    
      @MaxLength(
        
          value = 10,
        
        
        profiles = {"registration"},
        message = "doctorPhone"
      )
    
    private String doctorPhone;

    public final void setDoctorPhone(final String doctorPhone) {
        this.doctorPhone = doctorPhone;
    }

    /**
 
        * @hibernate.property
        *  column="doctor_phone"
        *  length="10"
      
    */
    public final String getDoctorPhone() {
        return this.doctorPhone;
    }
  
    
    private String doctorName;

    public final void setDoctorName(final String doctorName) {
        this.doctorName = doctorName;
    }

    /**
 
        * @hibernate.property
        *  column="doctor_name"
        
      
    */
    public final String getDoctorName() {
        return this.doctorName;
    }
  
    
      @LocalReferential(
        
        
        profiles = {"registration"},
        message = "canteenAttendingDays"
      )
    
      @MinSize(
        
          value = 1,
        
        
        profiles = {"registration"},
        message = "canteenAttendingDays"
      )
    
    private List<fr.cg95.cvq.business.request.LocalReferentialData> canteenAttendingDays;

    public final void setCanteenAttendingDays(final List<fr.cg95.cvq.business.request.LocalReferentialData> canteenAttendingDays) {
        this.canteenAttendingDays = canteenAttendingDays;
    }

    /**
 
        * @hibernate.list
        *  inverse="false"
        *  lazy="false"
        *  cascade="all"
        *  table="school_canteen_registration_request_canteen_attending_days"
        * @hibernate.key
        *  column="school_canteen_registration_request_id"
        * @hibernate.list-index
        *  column="canteen_attending_days_index"
        * @hibernate.many-to-many
        *  column="canteen_attending_days_id"
        *  class="fr.cg95.cvq.business.request.LocalReferentialData"
      
    */
    public final List<fr.cg95.cvq.business.request.LocalReferentialData> getCanteenAttendingDays() {
        return this.canteenAttendingDays;
    }
  
    
      @AssertValid(
        
        
        profiles = {"administration"},
        message = "school"
      )
    
    private fr.cg95.cvq.business.authority.School school;

    public final void setSchool(final fr.cg95.cvq.business.authority.School school) {
        this.school = school;
    }

    /**
 
        * @hibernate.many-to-one
        
        *  column="school_id"
        *  class="fr.cg95.cvq.business.authority.School"
      
    */
    public final fr.cg95.cvq.business.authority.School getSchool() {
        return this.school;
    }
  
    
      @NotNull(
        
        
        profiles = {"rules"},
        message = "hospitalizationPermission"
      )
    
    private Boolean hospitalizationPermission;

    public final void setHospitalizationPermission(final Boolean hospitalizationPermission) {
        this.hospitalizationPermission = hospitalizationPermission;
    }

    /**
 
        * @hibernate.property
        *  column="hospitalization_permission"
        
      
    */
    public final Boolean getHospitalizationPermission() {
        return this.hospitalizationPermission;
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
  
    
      @MaxLength(
        
          value = 10,
        
        
        profiles = {"registration"},
        message = "urgencyPhone"
      )
    
      @NotNull(
        
        
        profiles = {"registration"},
        message = "urgencyPhone"
      )
    
      @NotBlank(
        
        
        profiles = {"registration"},
        message = "urgencyPhone"
      )
    
    private String urgencyPhone;

    public final void setUrgencyPhone(final String urgencyPhone) {
        this.urgencyPhone = urgencyPhone;
    }

    /**
 
        * @hibernate.property
        *  column="urgency_phone"
        *  length="10"
      
    */
    public final String getUrgencyPhone() {
        return this.urgencyPhone;
    }
  
    
      @NotNull(
        
        
        profiles = {"administration"},
        message = "section"
      )
    
    private fr.cg95.cvq.business.users.SectionType section;

    public final void setSection(final fr.cg95.cvq.business.users.SectionType section) {
        this.section = section;
    }

    /**
 
        * @hibernate.property
        *  column="section"
        *  length="32"
      
    */
    public final fr.cg95.cvq.business.users.SectionType getSection() {
        return this.section;
    }
  
}
