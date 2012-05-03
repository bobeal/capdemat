
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
 *  table="recreation_activity_poly_registration_request"
 *  lazy="false"
 */
public class RecreationActivityPolyRegistrationRequestData implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final Map<String, IConditionChecker> conditions =
        new HashMap<String, IConditionChecker>(RequestData.conditions);

    private Long id;

    public RecreationActivityPolyRegistrationRequestData() {
      
        hospitalizationPolyPermission = Boolean.valueOf(false);
      
        rulesAndRegulationsPolyAcceptance = Boolean.valueOf(false);
      
        childPhotoExploitationPolyPermission = Boolean.valueOf(false);
      
        classTripPolyPermission = Boolean.valueOf(false);
      
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
        message = "authorizedPolyIndividuals"
      )
    
    private List<fr.cg95.cvq.business.request.school.RecreationAuthorizedPolyIndividual> authorizedPolyIndividuals;

    public final void setAuthorizedPolyIndividuals(final List<fr.cg95.cvq.business.request.school.RecreationAuthorizedPolyIndividual> authorizedPolyIndividuals) {
        this.authorizedPolyIndividuals = authorizedPolyIndividuals;
    }

    /**
 
        * @hibernate.list
        *  inverse="false"
        *  lazy="false"
        *  cascade="all"
        * @hibernate.key
        *  column="recreation_activity_poly_registration_request_id"
        * @hibernate.list-index
        *  column="authorized_poly_individuals_index"
        * @hibernate.one-to-many
        *  class="fr.cg95.cvq.business.request.school.RecreationAuthorizedPolyIndividual"
      
    */
    public final List<fr.cg95.cvq.business.request.school.RecreationAuthorizedPolyIndividual> getAuthorizedPolyIndividuals() {
        return this.authorizedPolyIndividuals;
    }
  
    
      @MaxLength(
        
          value = 10,
        
        
        profiles = {"requester"},
        message = "urgencyPolyPhone"
      )
    
      @NotNull(
        
        
        profiles = {"requester"},
        message = "urgencyPolyPhone"
      )
    
      @NotBlank(
        
        
        profiles = {"requester"},
        message = "urgencyPolyPhone"
      )
    
    private String urgencyPolyPhone;

    public final void setUrgencyPolyPhone(final String urgencyPolyPhone) {
        this.urgencyPolyPhone = urgencyPolyPhone;
    }

    /**
 
        * @hibernate.property
        *  column="urgency_poly_phone"
        *  length="10"
      
    */
    public final String getUrgencyPolyPhone() {
        return this.urgencyPolyPhone;
    }
  
    
      @AssertValid(
        
        
        profiles = {"requester"},
        message = "recreationPolyCenter"
      )
    
    private fr.cg95.cvq.business.authority.RecreationCenter recreationPolyCenter;

    public final void setRecreationPolyCenter(final fr.cg95.cvq.business.authority.RecreationCenter recreationPolyCenter) {
        this.recreationPolyCenter = recreationPolyCenter;
    }

    /**
 
        * @hibernate.many-to-one
        
        *  column="recreation_poly_center_id"
        *  class="fr.cg95.cvq.business.authority.RecreationCenter"
      
    */
    public final fr.cg95.cvq.business.authority.RecreationCenter getRecreationPolyCenter() {
        return this.recreationPolyCenter;
    }
  
    
      @NotNull(
        
        
        profiles = {"rules"},
        message = "hospitalizationPolyPermission"
      )
    
    private Boolean hospitalizationPolyPermission;

    public final void setHospitalizationPolyPermission(final Boolean hospitalizationPolyPermission) {
        this.hospitalizationPolyPermission = hospitalizationPolyPermission;
    }

    /**
 
        * @hibernate.property
        *  column="hospitalization_poly_permission"
        
      
    */
    public final Boolean getHospitalizationPolyPermission() {
        return this.hospitalizationPolyPermission;
    }
  
    
      @NotNull(
        
        
        profiles = {"rules"},
        message = "rulesAndRegulationsPolyAcceptance"
      )
    
    private Boolean rulesAndRegulationsPolyAcceptance;

    public final void setRulesAndRegulationsPolyAcceptance(final Boolean rulesAndRegulationsPolyAcceptance) {
        this.rulesAndRegulationsPolyAcceptance = rulesAndRegulationsPolyAcceptance;
    }

    /**
 
        * @hibernate.property
        *  column="rules_and_regulations_poly_acceptance"
        
      
    */
    public final Boolean getRulesAndRegulationsPolyAcceptance() {
        return this.rulesAndRegulationsPolyAcceptance;
    }
  
    
      @NotNull(
        
        
        profiles = {"rules"},
        message = "childPhotoExploitationPolyPermission"
      )
    
    private Boolean childPhotoExploitationPolyPermission;

    public final void setChildPhotoExploitationPolyPermission(final Boolean childPhotoExploitationPolyPermission) {
        this.childPhotoExploitationPolyPermission = childPhotoExploitationPolyPermission;
    }

    /**
 
        * @hibernate.property
        *  column="child_photo_exploitation_poly_permission"
        
      
    */
    public final Boolean getChildPhotoExploitationPolyPermission() {
        return this.childPhotoExploitationPolyPermission;
    }
  
    
      @NotNull(
        
        
        profiles = {"rules"},
        message = "classTripPolyPermission"
      )
    
    private Boolean classTripPolyPermission;

    public final void setClassTripPolyPermission(final Boolean classTripPolyPermission) {
        this.classTripPolyPermission = classTripPolyPermission;
    }

    /**
 
        * @hibernate.property
        *  column="class_trip_poly_permission"
        
      
    */
    public final Boolean getClassTripPolyPermission() {
        return this.classTripPolyPermission;
    }
  
    
      @AssertValid(
        
        
        profiles = {"contact"},
        message = "contactPolyIndividuals"
      )
    
    private List<fr.cg95.cvq.business.request.school.RecreationContactPolyIndividual> contactPolyIndividuals;

    public final void setContactPolyIndividuals(final List<fr.cg95.cvq.business.request.school.RecreationContactPolyIndividual> contactPolyIndividuals) {
        this.contactPolyIndividuals = contactPolyIndividuals;
    }

    /**
 
        * @hibernate.list
        *  inverse="false"
        *  lazy="false"
        *  cascade="all"
        * @hibernate.key
        *  column="recreation_activity_poly_registration_request_id"
        * @hibernate.list-index
        *  column="contact_poly_individuals_index"
        * @hibernate.one-to-many
        *  class="fr.cg95.cvq.business.request.school.RecreationContactPolyIndividual"
      
    */
    public final List<fr.cg95.cvq.business.request.school.RecreationContactPolyIndividual> getContactPolyIndividuals() {
        return this.contactPolyIndividuals;
    }
  
    
      @LocalReferential(
        
        
        profiles = {"requester"},
        message = "recreationPolyActivity"
      )
    
      @MinSize(
        
          value = 1,
        
        
        profiles = {"requester"},
        message = "recreationPolyActivity"
      )
    
    private List<fr.cg95.cvq.business.request.LocalReferentialData> recreationPolyActivity;

    public final void setRecreationPolyActivity(final List<fr.cg95.cvq.business.request.LocalReferentialData> recreationPolyActivity) {
        this.recreationPolyActivity = recreationPolyActivity;
    }

    /**
 
        * @hibernate.list
        *  inverse="false"
        *  lazy="false"
        *  cascade="all"
        *  table="recreation_activity_poly_registration_request_recreation_poly_activity"
        * @hibernate.key
        *  column="recreation_activity_poly_registration_request_id"
        * @hibernate.list-index
        *  column="recreation_poly_activity_index"
        * @hibernate.many-to-many
        *  column="recreation_poly_activity_id"
        *  class="fr.cg95.cvq.business.request.LocalReferentialData"
      
    */
    public final List<fr.cg95.cvq.business.request.LocalReferentialData> getRecreationPolyActivity() {
        return this.recreationPolyActivity;
    }
  
}
