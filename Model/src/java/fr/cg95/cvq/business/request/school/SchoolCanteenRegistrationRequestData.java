

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

import javax.persistence.*;
import org.hibernate.annotations.Index;
import org.hibernate.annotations.Type;

/**
 * Generated class file, do not edit !
 */
@Entity
@Table(name="school_canteen_registration_request")
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
        
          
            
        List<fr.cg95.cvq.business.request.LocalReferentialData> canteenAttendingDaysList = new ArrayList<fr.cg95.cvq.business.request.LocalReferentialData>();
        for (LocalReferentialData object : canteenAttendingDays) {
            canteenAttendingDaysList.add(object.clone());
        }
        result.setCanteenAttendingDays(canteenAttendingDaysList);
      
          
        
          
            
        result.setDoctorName(doctorName);
      
          
        
          
            
        result.setDoctorPhone(doctorPhone);
      
          
        
          
            
        result.setFoodAllergy(foodAllergy);
      
          
        
          
            
        List<fr.cg95.cvq.business.request.LocalReferentialData> foodDietList = new ArrayList<fr.cg95.cvq.business.request.LocalReferentialData>();
        for (LocalReferentialData object : foodDiet) {
            foodDietList.add(object.clone());
        }
        result.setFoodDiet(foodDietList);
      
          
        
          
            
        result.setHospitalizationPermission(hospitalizationPermission);
      
          
        
          
            
        result.setRulesAndRegulationsAcceptance(rulesAndRegulationsAcceptance);
      
          
        
          
            result.setSchool(school);
          
        
          
            
        if (section != null)
            result.setSection(section);
        else
            result.setSection(fr.cg95.cvq.business.users.SectionType.getDefaultSectionType());
      
          
        
          
            
        result.setUrgencyPhone(urgencyPhone);
      
          
        
          
            
        result.setWhichFoodAllergy(whichFoodAllergy);
      
          
        
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

    public void setCanteenAttendingDays(final List<fr.cg95.cvq.business.request.LocalReferentialData> canteenAttendingDays) {
        this.canteenAttendingDays = canteenAttendingDays;
    }

 
    @ManyToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinTable(name="school_canteen_registration_request_canteen_attending_days",
            joinColumns=
                @JoinColumn(name="school_canteen_registration_request_id"),
            inverseJoinColumns=
                @JoinColumn(name="canteen_attending_days_id"))
    @OrderColumn(name="canteen_attending_days_index")
      
    public List<fr.cg95.cvq.business.request.LocalReferentialData> getCanteenAttendingDays() {
        return this.canteenAttendingDays;
    }
  
    
    private String doctorName;

    public void setDoctorName(final String doctorName) {
        this.doctorName = doctorName;
    }

 
    @Column(name="doctor_name"  )
      
    public String getDoctorName() {
        return this.doctorName;
    }
  
    
      @MaxLength(
        
          value = 10,
        
        
        profiles = {"registration"},
        message = "doctorPhone"
      )
    
    private String doctorPhone;

    public void setDoctorPhone(final String doctorPhone) {
        this.doctorPhone = doctorPhone;
    }

 
    @Column(name="doctor_phone" , length=10 )
      
    public String getDoctorPhone() {
        return this.doctorPhone;
    }
  
    
      @NotNull(
        
        
        profiles = {"registration"},
        message = "foodAllergy"
      )
    
    private Boolean foodAllergy;

    public void setFoodAllergy(final Boolean foodAllergy) {
        this.foodAllergy = foodAllergy;
    }

 
    @Column(name="food_allergy"  )
      
    public Boolean getFoodAllergy() {
        return this.foodAllergy;
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

    public void setFoodDiet(final List<fr.cg95.cvq.business.request.LocalReferentialData> foodDiet) {
        this.foodDiet = foodDiet;
    }

 
    @ManyToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinTable(name="school_canteen_registration_request_food_diet",
            joinColumns=
                @JoinColumn(name="school_canteen_registration_request_id"),
            inverseJoinColumns=
                @JoinColumn(name="food_diet_id"))
    @OrderColumn(name="food_diet_index")
      
    public List<fr.cg95.cvq.business.request.LocalReferentialData> getFoodDiet() {
        return this.foodDiet;
    }
  
    
      @NotNull(
        
        
        profiles = {"rules"},
        message = "hospitalizationPermission"
      )
    
    private Boolean hospitalizationPermission;

    public void setHospitalizationPermission(final Boolean hospitalizationPermission) {
        this.hospitalizationPermission = hospitalizationPermission;
    }

 
    @Column(name="hospitalization_permission"  )
      
    public Boolean getHospitalizationPermission() {
        return this.hospitalizationPermission;
    }
  
    
      @NotNull(
        
        
        profiles = {"rules"},
        message = "rulesAndRegulationsAcceptance"
      )
    
    private Boolean rulesAndRegulationsAcceptance;

    public void setRulesAndRegulationsAcceptance(final Boolean rulesAndRegulationsAcceptance) {
        this.rulesAndRegulationsAcceptance = rulesAndRegulationsAcceptance;
    }

 
    @Column(name="rules_and_regulations_acceptance"  )
      
    public Boolean getRulesAndRegulationsAcceptance() {
        return this.rulesAndRegulationsAcceptance;
    }
  
    
      @AssertValid(
        
        
        profiles = {"administration"},
        message = "school"
      )
    
    private fr.cg95.cvq.business.authority.School school;

    public void setSchool(final fr.cg95.cvq.business.authority.School school) {
        this.school = school;
    }

 
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="school_id")
      
    public fr.cg95.cvq.business.authority.School getSchool() {
        return this.school;
    }
  
    
      @NotNull(
        
        
        profiles = {"administration"},
        message = "section"
      )
    
    private fr.cg95.cvq.business.users.SectionType section;

    public void setSection(final fr.cg95.cvq.business.users.SectionType section) {
        this.section = section;
    }

 
    @Enumerated(EnumType.STRING)
    @Column(name="section" , length=32 )
      
    public fr.cg95.cvq.business.users.SectionType getSection() {
        return this.section;
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

    public void setUrgencyPhone(final String urgencyPhone) {
        this.urgencyPhone = urgencyPhone;
    }

 
    @Column(name="urgency_phone" , length=10 )
      
    public String getUrgencyPhone() {
        return this.urgencyPhone;
    }
  
    
      @NotNull(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['foodAllergy'].test(_this.foodAllergy.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"registration"},
        message = "whichFoodAllergy"
      )
    
      @NotBlank(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['foodAllergy'].test(_this.foodAllergy.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"registration"},
        message = "whichFoodAllergy"
      )
    
    private String whichFoodAllergy;

    public void setWhichFoodAllergy(final String whichFoodAllergy) {
        this.whichFoodAllergy = whichFoodAllergy;
    }

 
    @Column(name="which_food_allergy"  )
      
    public String getWhichFoodAllergy() {
        return this.whichFoodAllergy;
    }
  
}
