
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

import fr.cg95.cvq.business.authority.*;
import fr.cg95.cvq.business.request.*;
import fr.cg95.cvq.business.users.*;

import net.sf.oval.constraint.*;
import fr.cg95.cvq.service.request.LocalReferential;
import fr.cg95.cvq.service.request.condition.IConditionChecker;

/**
 * Generated class file, do not edit !
 *
 * @hibernate.class
 *  table="perischool_activity_registration_request"
 *  lazy="false"
 */
public class PerischoolActivityRegistrationRequestData implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final Map<String, IConditionChecker> conditions =
        new HashMap<String, IConditionChecker>(RequestData.conditions);

    private Long id;

    public PerischoolActivityRegistrationRequestData() {
      
        classTripPermission = Boolean.valueOf(false);
      
        childPhotoExploitationPermission = Boolean.valueOf(false);
      
        hospitalizationPermission = Boolean.valueOf(false);
      
        rulesAndRegulationsAcceptance = Boolean.valueOf(false);
      
        section = fr.cg95.cvq.business.users.SectionType.UNKNOWN;
      
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

  
    
      @AssertValid(
        
        
        profiles = {"authorization"},
        message = "authorizedIndividuals"
      )
    
    private List<fr.cg95.cvq.business.request.school.PerischoolAuthorizedIndividual> authorizedIndividuals;

    public final void setAuthorizedIndividuals(final List<fr.cg95.cvq.business.request.school.PerischoolAuthorizedIndividual> authorizedIndividuals) {
        this.authorizedIndividuals = authorizedIndividuals;
    }

    /**
 
        * @hibernate.list
        *  inverse="false"
        *  lazy="false"
        *  cascade="all"
        * @hibernate.key
        *  column="perischool_activity_registration_request_id"
        * @hibernate.list-index
        *  column="authorized_individuals_index"
        * @hibernate.one-to-many
        *  class="fr.cg95.cvq.business.request.school.PerischoolAuthorizedIndividual"
      
    */
    public final List<fr.cg95.cvq.business.request.school.PerischoolAuthorizedIndividual> getAuthorizedIndividuals() {
        return this.authorizedIndividuals;
    }
  
    
      @AssertValid(
        
        
        profiles = {"contact"},
        message = "contactIndividuals"
      )
    
    private List<fr.cg95.cvq.business.request.school.PerischoolContactIndividual> contactIndividuals;

    public final void setContactIndividuals(final List<fr.cg95.cvq.business.request.school.PerischoolContactIndividual> contactIndividuals) {
        this.contactIndividuals = contactIndividuals;
    }

    /**
 
        * @hibernate.list
        *  inverse="false"
        *  lazy="false"
        *  cascade="all"
        * @hibernate.key
        *  column="perischool_activity_registration_request_id"
        * @hibernate.list-index
        *  column="contact_individuals_index"
        * @hibernate.one-to-many
        *  class="fr.cg95.cvq.business.request.school.PerischoolContactIndividual"
      
    */
    public final List<fr.cg95.cvq.business.request.school.PerischoolContactIndividual> getContactIndividuals() {
        return this.contactIndividuals;
    }
  
    
      @NotNull(
        
        
        profiles = {"rules"},
        message = "classTripPermission"
      )
    
    private Boolean classTripPermission;

    public final void setClassTripPermission(final Boolean classTripPermission) {
        this.classTripPermission = classTripPermission;
    }

    /**
 
        * @hibernate.property
        *  column="class_trip_permission"
        
      
    */
    public final Boolean getClassTripPermission() {
        return this.classTripPermission;
    }
  
    
      @NotNull(
        
        
        profiles = {"rules"},
        message = "childPhotoExploitationPermission"
      )
    
    private Boolean childPhotoExploitationPermission;

    public final void setChildPhotoExploitationPermission(final Boolean childPhotoExploitationPermission) {
        this.childPhotoExploitationPermission = childPhotoExploitationPermission;
    }

    /**
 
        * @hibernate.property
        *  column="child_photo_exploitation_permission"
        
      
    */
    public final Boolean getChildPhotoExploitationPermission() {
        return this.childPhotoExploitationPermission;
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
  
    
      @LocalReferential(
        
        
        profiles = {"registration"},
        message = "perischoolActivity"
      )
    
    private List<fr.cg95.cvq.business.request.LocalReferentialData> perischoolActivity;

    public final void setPerischoolActivity(final List<fr.cg95.cvq.business.request.LocalReferentialData> perischoolActivity) {
        this.perischoolActivity = perischoolActivity;
    }

    /**
 
        * @hibernate.list
        *  inverse="false"
        *  lazy="false"
        *  cascade="all"
        *  table="perischool_activity_registration_request_perischool_activity"
        * @hibernate.key
        *  column="perischool_activity_registration_request_id"
        * @hibernate.list-index
        *  column="perischool_activity_index"
        * @hibernate.many-to-many
        *  column="perischool_activity_id"
        *  class="fr.cg95.cvq.business.request.LocalReferentialData"
      
    */
    public final List<fr.cg95.cvq.business.request.LocalReferentialData> getPerischoolActivity() {
        return this.perischoolActivity;
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
