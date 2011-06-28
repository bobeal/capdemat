
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
 *  table="school_registration_simplify_request"
 *  lazy="false"
 */
public class SchoolRegistrationSimplifyRequestData implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final Map<String, IConditionChecker> conditions =
        new HashMap<String, IConditionChecker>(RequestData.conditions);

    private Long id;

    public SchoolRegistrationSimplifyRequestData() {
      
        existRegistration = Boolean.valueOf(false);
      
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
        
        
        profiles = {"registration"},
        message = "emergencyContactName"
      )
    
      @NotBlank(
        
        
        profiles = {"registration"},
        message = "emergencyContactName"
      )
    
    private String emergencyContactName;

    public final void setEmergencyContactName(final String emergencyContactName) {
        this.emergencyContactName = emergencyContactName;
    }

    /**
 
        * @hibernate.property
        *  column="emergency_contact_name"
        
      
    */
    public final String getEmergencyContactName() {
        return this.emergencyContactName;
    }
  
    
      @NotNull(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['existRegistration'].test(_this.existRegistration.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"registration"},
        message = "currentSchoolAddress"
      )
    
      @NotBlank(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['existRegistration'].test(_this.existRegistration.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"registration"},
        message = "currentSchoolAddress"
      )
    
    private String currentSchoolAddress;

    public final void setCurrentSchoolAddress(final String currentSchoolAddress) {
        this.currentSchoolAddress = currentSchoolAddress;
    }

    /**
 
        * @hibernate.property
        *  column="current_school_address"
        
      
    */
    public final String getCurrentSchoolAddress() {
        return this.currentSchoolAddress;
    }
  
    
      @NotNull(
        
        
        profiles = {"registration"},
        message = "emergencyPhone"
      )
    
      @NotBlank(
        
        
        profiles = {"registration"},
        message = "emergencyPhone"
      )
    
    private String emergencyPhone;

    public final void setEmergencyPhone(final String emergencyPhone) {
        this.emergencyPhone = emergencyPhone;
    }

    /**
 
        * @hibernate.property
        *  column="emergency_phone"
        
      
    */
    public final String getEmergencyPhone() {
        return this.emergencyPhone;
    }
  
    
      @NotNull(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['existRegistration'].test(_this.existRegistration.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"registration"},
        message = "currentSchoolName"
      )
    
      @NotBlank(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['existRegistration'].test(_this.existRegistration.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"registration"},
        message = "currentSchoolName"
      )
    
    private String currentSchoolName;

    public final void setCurrentSchoolName(final String currentSchoolName) {
        this.currentSchoolName = currentSchoolName;
    }

    /**
 
        * @hibernate.property
        *  column="current_school_name"
        
      
    */
    public final String getCurrentSchoolName() {
        return this.currentSchoolName;
    }
  
    
      @NotNull(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['existRegistration'].test(_this.existRegistration.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"registration"},
        message = "currentSchoolLevel"
      )
    
      @NotBlank(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['existRegistration'].test(_this.existRegistration.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"registration"},
        message = "currentSchoolLevel"
      )
    
    private String currentSchoolLevel;

    public final void setCurrentSchoolLevel(final String currentSchoolLevel) {
        this.currentSchoolLevel = currentSchoolLevel;
    }

    /**
 
        * @hibernate.property
        *  column="current_school_level"
        
      
    */
    public final String getCurrentSchoolLevel() {
        return this.currentSchoolLevel;
    }
  
    
      @LocalReferential(
        
        
        profiles = {"registration"},
        message = "section"
      )
    
      @MinSize(
        
          value = 1,
        
        
        profiles = {"registration"},
        message = "section"
      )
    
    private List<fr.cg95.cvq.business.request.LocalReferentialData> section;

    public final void setSection(final List<fr.cg95.cvq.business.request.LocalReferentialData> section) {
        this.section = section;
    }

    /**
 
        * @hibernate.list
        *  inverse="false"
        *  lazy="false"
        *  cascade="all"
        *  table="school_registration_simplify_request_section"
        * @hibernate.key
        *  column="school_registration_simplify_request_id"
        * @hibernate.list-index
        *  column="section_index"
        * @hibernate.many-to-many
        *  column="section_id"
        *  class="fr.cg95.cvq.business.request.LocalReferentialData"
      
    */
    public final List<fr.cg95.cvq.business.request.LocalReferentialData> getSection() {
        return this.section;
    }
  
    
      @NotNull(
        
        
        profiles = {"registration"},
        message = "existRegistration"
      )
    
    private Boolean existRegistration;

    public final void setExistRegistration(final Boolean existRegistration) {
        this.existRegistration = existRegistration;
    }

    /**
 
        * @hibernate.property
        *  column="exist_registration"
        
      
    */
    public final Boolean getExistRegistration() {
        return this.existRegistration;
    }
  
}
