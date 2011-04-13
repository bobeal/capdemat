

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
@Table(name="school_registration_request")
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
      
          
        
          
            
        result.setRulesAndRegulationsAcceptance(rulesAndRegulationsAcceptance);
      
          
        
          
            result.setSchool(school);
          
        
          
            
        if (section != null)
            result.setSection(section);
        else
            result.setSection(fr.cg95.cvq.business.users.SectionType.getDefaultSectionType());
      
          
        
          
            
        result.setUrgencyPhone(urgencyPhone);
      
          
        
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

  
    
    private String currentSchoolAddress;

    public void setCurrentSchoolAddress(final String currentSchoolAddress) {
        this.currentSchoolAddress = currentSchoolAddress;
    }

 
    @Column(name="current_school_address"  )
      
    public String getCurrentSchoolAddress() {
        return this.currentSchoolAddress;
    }
  
    
    private String currentSchoolName;

    public void setCurrentSchoolName(final String currentSchoolName) {
        this.currentSchoolName = currentSchoolName;
    }

 
    @Column(name="current_school_name"  )
      
    public String getCurrentSchoolName() {
        return this.currentSchoolName;
    }
  
    
    private fr.cg95.cvq.business.users.SectionType currentSection;

    public void setCurrentSection(final fr.cg95.cvq.business.users.SectionType currentSection) {
        this.currentSection = currentSection;
    }

 
    @Enumerated(EnumType.STRING)
    @Column(name="current_section" , length=32 )
      
    public fr.cg95.cvq.business.users.SectionType getCurrentSection() {
        return this.currentSection;
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
        
        
        profiles = {"registration"},
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
  
}
