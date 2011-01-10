
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
 *  table="school_registration_request"
 *  lazy="false"
 */
public class SchoolRegistrationRequestData implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final Map<String, IConditionChecker> conditions =
        new HashMap<String, IConditionChecker>(RequestData.conditions);

    private Long id;

    public SchoolRegistrationRequestData() {
      
        currentSection = fr.cg95.cvq.business.users.SectionType.UNKNOWN;
      
        rulesAndRegulationsAcceptance = Boolean.valueOf(false);
      
        section = fr.cg95.cvq.business.users.SectionType.UNKNOWN;
      
    }

    @Override
    public SchoolRegistrationRequestData clone() {
        SchoolRegistrationRequestData result = new SchoolRegistrationRequestData();
        
          
            
        result.setCurrentSchoolAddress(currentSchoolAddress);
      
          
        
          
            
        result.setCurrentSchoolName(currentSchoolName);
      
          
        
          
            
        if (currentSection != null)
            result.setCurrentSection(currentSection);
        else
            result.setCurrentSection(fr.cg95.cvq.business.users.SectionType.getDefaultSectionType());
      
          
        
          
            result.setSchool(school);
          
        
          
            
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
  
    
    private fr.cg95.cvq.business.users.SectionType currentSection;

    public final void setCurrentSection(final fr.cg95.cvq.business.users.SectionType currentSection) {
        this.currentSection = currentSection;
    }

    /**
 
        * @hibernate.property
        *  column="current_section"
        *  length="32"
      
    */
    public final fr.cg95.cvq.business.users.SectionType getCurrentSection() {
        return this.currentSection;
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
        
        
        profiles = {"registration"},
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
