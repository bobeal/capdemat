

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
@Table(name="perischool_activity_registration_request")
public class PerischoolActivityRegistrationRequestData implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final Map<String, IConditionChecker> conditions =
        new HashMap<String, IConditionChecker>(RequestData.conditions);

    private Long id;

    public PerischoolActivityRegistrationRequestData() {
      
        childPhotoExploitationPermission = Boolean.valueOf(false);
      
        classTripPermission = Boolean.valueOf(false);
      
        hospitalizationPermission = Boolean.valueOf(false);
      
        rulesAndRegulationsAcceptance = Boolean.valueOf(false);
      
        section = fr.cg95.cvq.business.users.SectionType.UNKNOWN;
      
    }

    @Override
    public PerischoolActivityRegistrationRequestData clone() {
        PerischoolActivityRegistrationRequestData result = new PerischoolActivityRegistrationRequestData();
        
          
            
        List<fr.cg95.cvq.business.request.school.PerischoolAuthorizedIndividual> authorizedIndividualsList = new ArrayList<fr.cg95.cvq.business.request.school.PerischoolAuthorizedIndividual>();
        for (PerischoolAuthorizedIndividual object : authorizedIndividuals) {
            authorizedIndividualsList.add(object.clone());
        }
        result.setAuthorizedIndividuals(authorizedIndividualsList);
      
          
        
          
            
        result.setChildPhotoExploitationPermission(childPhotoExploitationPermission);
      
          
        
          
            
        result.setClassTripPermission(classTripPermission);
      
          
        
          
            
        List<fr.cg95.cvq.business.request.school.PerischoolContactIndividual> contactIndividualsList = new ArrayList<fr.cg95.cvq.business.request.school.PerischoolContactIndividual>();
        for (PerischoolContactIndividual object : contactIndividuals) {
            contactIndividualsList.add(object.clone());
        }
        result.setContactIndividuals(contactIndividualsList);
      
          
        
          
            
        result.setHospitalizationPermission(hospitalizationPermission);
      
          
        
          
            
        List<fr.cg95.cvq.business.request.LocalReferentialData> perischoolActivityList = new ArrayList<fr.cg95.cvq.business.request.LocalReferentialData>();
        for (LocalReferentialData object : perischoolActivity) {
            perischoolActivityList.add(object.clone());
        }
        result.setPerischoolActivity(perischoolActivityList);
      
          
        
          
            
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

  
    
      @AssertValid(
        
        
        profiles = {"authorization"},
        message = "authorizedIndividuals"
      )
    
    private List<fr.cg95.cvq.business.request.school.PerischoolAuthorizedIndividual> authorizedIndividuals;

    public void setAuthorizedIndividuals(final List<fr.cg95.cvq.business.request.school.PerischoolAuthorizedIndividual> authorizedIndividuals) {
        this.authorizedIndividuals = authorizedIndividuals;
    }

 
    @OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
    @OrderColumn(name="authorized_individuals_index")
    @JoinColumn(name="perischool_activity_registration_request_id")
      
    public List<fr.cg95.cvq.business.request.school.PerischoolAuthorizedIndividual> getAuthorizedIndividuals() {
        return this.authorizedIndividuals;
    }
  
    
    private Boolean childPhotoExploitationPermission;

    public void setChildPhotoExploitationPermission(final Boolean childPhotoExploitationPermission) {
        this.childPhotoExploitationPermission = childPhotoExploitationPermission;
    }

 
    @Column(name="child_photo_exploitation_permission"  )
      
    public Boolean getChildPhotoExploitationPermission() {
        return this.childPhotoExploitationPermission;
    }
  
    
    private Boolean classTripPermission;

    public void setClassTripPermission(final Boolean classTripPermission) {
        this.classTripPermission = classTripPermission;
    }

 
    @Column(name="class_trip_permission"  )
      
    public Boolean getClassTripPermission() {
        return this.classTripPermission;
    }
  
    
      @AssertValid(
        
        
        profiles = {"contact"},
        message = "contactIndividuals"
      )
    
    private List<fr.cg95.cvq.business.request.school.PerischoolContactIndividual> contactIndividuals;

    public void setContactIndividuals(final List<fr.cg95.cvq.business.request.school.PerischoolContactIndividual> contactIndividuals) {
        this.contactIndividuals = contactIndividuals;
    }

 
    @OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
    @OrderColumn(name="contact_individuals_index")
    @JoinColumn(name="perischool_activity_registration_request_id")
      
    public List<fr.cg95.cvq.business.request.school.PerischoolContactIndividual> getContactIndividuals() {
        return this.contactIndividuals;
    }
  
    
    private Boolean hospitalizationPermission;

    public void setHospitalizationPermission(final Boolean hospitalizationPermission) {
        this.hospitalizationPermission = hospitalizationPermission;
    }

 
    @Column(name="hospitalization_permission"  )
      
    public Boolean getHospitalizationPermission() {
        return this.hospitalizationPermission;
    }
  
    
      @LocalReferential(
        
        
        profiles = {"registration"},
        message = "perischoolActivity"
      )
    
      @MinSize(
        
          value = 1,
        
        
        profiles = {"registration"},
        message = "perischoolActivity"
      )
    
    private List<fr.cg95.cvq.business.request.LocalReferentialData> perischoolActivity;

    public void setPerischoolActivity(final List<fr.cg95.cvq.business.request.LocalReferentialData> perischoolActivity) {
        this.perischoolActivity = perischoolActivity;
    }

 
    @ManyToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinTable(name="perischool_activity_registration_request_perischool_activity",
            joinColumns=
                @JoinColumn(name="perischool_activity_registration_request_id"),
            inverseJoinColumns=
                @JoinColumn(name="perischool_activity_id"))
    @OrderColumn(name="perischool_activity_index")
      
    public List<fr.cg95.cvq.business.request.LocalReferentialData> getPerischoolActivity() {
        return this.perischoolActivity;
    }
  
    
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
  
}
