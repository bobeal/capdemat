

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
@Table(name="recreation_activity_registration_request")
public class RecreationActivityRegistrationRequestData implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final Map<String, IConditionChecker> conditions =
        new HashMap<String, IConditionChecker>(RequestData.conditions);

    private Long id;

    public RecreationActivityRegistrationRequestData() {
      
        childPhotoExploitationPermission = Boolean.valueOf(false);
      
        classTripPermission = Boolean.valueOf(false);
      
        hospitalizationPermission = Boolean.valueOf(false);
      
        rulesAndRegulationsAcceptance = Boolean.valueOf(false);
      
    }

    @Override
    public RecreationActivityRegistrationRequestData clone() {
        RecreationActivityRegistrationRequestData result = new RecreationActivityRegistrationRequestData();
        
          
            
        List<fr.cg95.cvq.business.request.school.RecreationAuthorizedIndividual> authorizedIndividualsList = new ArrayList<fr.cg95.cvq.business.request.school.RecreationAuthorizedIndividual>();
        for (RecreationAuthorizedIndividual object : authorizedIndividuals) {
            authorizedIndividualsList.add(object.clone());
        }
        result.setAuthorizedIndividuals(authorizedIndividualsList);
      
          
        
          
            
        result.setChildPhotoExploitationPermission(childPhotoExploitationPermission);
      
          
        
          
            
        result.setClassTripPermission(classTripPermission);
      
          
        
          
            
        List<fr.cg95.cvq.business.request.school.RecreationContactIndividual> contactIndividualsList = new ArrayList<fr.cg95.cvq.business.request.school.RecreationContactIndividual>();
        for (RecreationContactIndividual object : contactIndividuals) {
            contactIndividualsList.add(object.clone());
        }
        result.setContactIndividuals(contactIndividualsList);
      
          
        
          
            
        result.setHospitalizationPermission(hospitalizationPermission);
      
          
        
          
            
        List<fr.cg95.cvq.business.request.LocalReferentialData> recreationActivityList = new ArrayList<fr.cg95.cvq.business.request.LocalReferentialData>();
        for (LocalReferentialData object : recreationActivity) {
            recreationActivityList.add(object.clone());
        }
        result.setRecreationActivity(recreationActivityList);
      
          
        
          
            result.setRecreationCenter(recreationCenter);
          
        
          
            
        result.setRulesAndRegulationsAcceptance(rulesAndRegulationsAcceptance);
      
          
        
          
            
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
    
    private List<fr.cg95.cvq.business.request.school.RecreationAuthorizedIndividual> authorizedIndividuals;

    public void setAuthorizedIndividuals(final List<fr.cg95.cvq.business.request.school.RecreationAuthorizedIndividual> authorizedIndividuals) {
        this.authorizedIndividuals = authorizedIndividuals;
    }

 
    @OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
    @OrderColumn(name="authorized_individuals_index")
    @JoinColumn(name="recreation_activity_registration_request_id")
      
    public List<fr.cg95.cvq.business.request.school.RecreationAuthorizedIndividual> getAuthorizedIndividuals() {
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
    
    private List<fr.cg95.cvq.business.request.school.RecreationContactIndividual> contactIndividuals;

    public void setContactIndividuals(final List<fr.cg95.cvq.business.request.school.RecreationContactIndividual> contactIndividuals) {
        this.contactIndividuals = contactIndividuals;
    }

 
    @OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
    @OrderColumn(name="contact_individuals_index")
    @JoinColumn(name="recreation_activity_registration_request_id")
      
    public List<fr.cg95.cvq.business.request.school.RecreationContactIndividual> getContactIndividuals() {
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
        message = "recreationActivity"
      )
    
      @MinSize(
        
          value = 1,
        
        
        profiles = {"registration"},
        message = "recreationActivity"
      )
    
    private List<fr.cg95.cvq.business.request.LocalReferentialData> recreationActivity;

    public void setRecreationActivity(final List<fr.cg95.cvq.business.request.LocalReferentialData> recreationActivity) {
        this.recreationActivity = recreationActivity;
    }

 
    @ManyToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinTable(name="recreation_activity_registration_request_recreation_activity",
            joinColumns=
                @JoinColumn(name="recreation_activity_registration_request_id"),
            inverseJoinColumns=
                @JoinColumn(name="recreation_activity_id"))
    @OrderColumn(name="recreation_activity_index")
      
    public List<fr.cg95.cvq.business.request.LocalReferentialData> getRecreationActivity() {
        return this.recreationActivity;
    }
  
    
      @AssertValid(
        
        
        profiles = {"administration"},
        message = "recreationCenter"
      )
    
    private fr.cg95.cvq.business.authority.RecreationCenter recreationCenter;

    public void setRecreationCenter(final fr.cg95.cvq.business.authority.RecreationCenter recreationCenter) {
        this.recreationCenter = recreationCenter;
    }

 
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="recreation_center_id")
      
    public fr.cg95.cvq.business.authority.RecreationCenter getRecreationCenter() {
        return this.recreationCenter;
    }
  
    
    private Boolean rulesAndRegulationsAcceptance;

    public void setRulesAndRegulationsAcceptance(final Boolean rulesAndRegulationsAcceptance) {
        this.rulesAndRegulationsAcceptance = rulesAndRegulationsAcceptance;
    }

 
    @Column(name="rules_and_regulations_acceptance"  )
      
    public Boolean getRulesAndRegulationsAcceptance() {
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

    public void setUrgencyPhone(final String urgencyPhone) {
        this.urgencyPhone = urgencyPhone;
    }

 
    @Column(name="urgency_phone" , length=10 )
      
    public String getUrgencyPhone() {
        return this.urgencyPhone;
    }
  
}
