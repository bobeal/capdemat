
package fr.cg95.cvq.business.request.school;

import java.io.Serializable;
import java.math.BigInteger;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import fr.cg95.cvq.business.authority.*;
import fr.cg95.cvq.business.request.*;
import fr.cg95.cvq.business.users.*;

/**
 * Generated class file, do not edit !
 *
 * @hibernate.class
 *  table="recreation_activity_registration_request"
 *  lazy="false"
 */
public class RecreationActivityRegistrationRequestData implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    public RecreationActivityRegistrationRequestData() {
      
        classTripPermission = Boolean.valueOf(false);
      
        childPhotoExploitationPermission = Boolean.valueOf(false);
      
        hospitalizationPermission = Boolean.valueOf(false);
      
        rulesAndRegulationsAcceptance = Boolean.valueOf(false);
      
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

  
    private fr.cg95.cvq.business.authority.RecreationCenter recreationCenter;

    public final void setRecreationCenter(final fr.cg95.cvq.business.authority.RecreationCenter recreationCenter) {
        this.recreationCenter = recreationCenter;
    }

    /**
 
        * @hibernate.many-to-one
        
        *  column="recreation_center_id"
        *  class="fr.cg95.cvq.business.authority.RecreationCenter"
      
    */
    public final fr.cg95.cvq.business.authority.RecreationCenter getRecreationCenter() {
        return this.recreationCenter;
    }
  
    private List<fr.cg95.cvq.business.request.school.RecreationAuthorizedIndividual> authorizedIndividuals;

    public final void setAuthorizedIndividuals(final List<fr.cg95.cvq.business.request.school.RecreationAuthorizedIndividual> authorizedIndividuals) {
        this.authorizedIndividuals = authorizedIndividuals;
    }

    /**
 
        * @hibernate.list
        *  inverse="false"
        *  lazy="false"
        *  cascade="all"
        * @hibernate.key
        *  column="recreation_activity_registration_request_id"
        * @hibernate.list-index
        *  column="authorized_individuals_index"
        * @hibernate.one-to-many
        *  class="fr.cg95.cvq.business.request.school.RecreationAuthorizedIndividual"
      
    */
    public final List<fr.cg95.cvq.business.request.school.RecreationAuthorizedIndividual> getAuthorizedIndividuals() {
        return this.authorizedIndividuals;
    }
  
    private List<fr.cg95.cvq.business.request.school.RecreationContactIndividual> contactIndividuals;

    public final void setContactIndividuals(final List<fr.cg95.cvq.business.request.school.RecreationContactIndividual> contactIndividuals) {
        this.contactIndividuals = contactIndividuals;
    }

    /**
 
        * @hibernate.list
        *  inverse="false"
        *  lazy="false"
        *  cascade="all"
        * @hibernate.key
        *  column="recreation_activity_registration_request_id"
        * @hibernate.list-index
        *  column="contact_individuals_index"
        * @hibernate.one-to-many
        *  class="fr.cg95.cvq.business.request.school.RecreationContactIndividual"
      
    */
    public final List<fr.cg95.cvq.business.request.school.RecreationContactIndividual> getContactIndividuals() {
        return this.contactIndividuals;
    }
  
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
  
    private List<fr.cg95.cvq.business.request.LocalReferentialData> recreationActivity;

    public final void setRecreationActivity(final List<fr.cg95.cvq.business.request.LocalReferentialData> recreationActivity) {
        this.recreationActivity = recreationActivity;
    }

    /**
 
        * @hibernate.list
        *  inverse="false"
        *  lazy="false"
        *  cascade="all"
        *  table="recreation_activity_registration_request_recreation_activity"
        * @hibernate.key
        *  column="recreation_activity_registration_request_id"
        * @hibernate.list-index
        *  column="recreation_activity_index"
        * @hibernate.many-to-many
        *  column="recreation_activity_id"
        *  class="fr.cg95.cvq.business.request.LocalReferentialData"
      
    */
    public final List<fr.cg95.cvq.business.request.LocalReferentialData> getRecreationActivity() {
        return this.recreationActivity;
    }
  
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
  
}
