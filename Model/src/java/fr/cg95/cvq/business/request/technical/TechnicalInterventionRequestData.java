
package fr.cg95.cvq.business.request.technical;

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
 *  table="technical_intervention_request"
 *  lazy="false"
 */
public class TechnicalInterventionRequestData implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    public TechnicalInterventionRequestData() {
      
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

  
    private String otherInterventionLabel;

    public final void setOtherInterventionLabel(final String otherInterventionLabel) {
        this.otherInterventionLabel = otherInterventionLabel;
    }

    /**
 
        * @hibernate.property
        *  column="other_intervention_label"
        
      
    */
    public final String getOtherInterventionLabel() {
        return this.otherInterventionLabel;
    }
  
    private String interventionDescription;

    public final void setInterventionDescription(final String interventionDescription) {
        this.interventionDescription = interventionDescription;
    }

    /**
 
        * @hibernate.property
        *  column="intervention_description"
        
      
    */
    public final String getInterventionDescription() {
        return this.interventionDescription;
    }
  
    private fr.cg95.cvq.business.users.Address interventionPlace;

    public final void setInterventionPlace(final fr.cg95.cvq.business.users.Address interventionPlace) {
        this.interventionPlace = interventionPlace;
    }

    /**
 
        * @hibernate.many-to-one
        *  cascade="all"
        *  column="intervention_place_id"
        *  class="fr.cg95.cvq.business.users.Address"
      
    */
    public final fr.cg95.cvq.business.users.Address getInterventionPlace() {
        return this.interventionPlace;
    }
  
    private List<fr.cg95.cvq.business.request.LocalReferentialData> interventionType;

    public final void setInterventionType(final List<fr.cg95.cvq.business.request.LocalReferentialData> interventionType) {
        this.interventionType = interventionType;
    }

    /**
 
        * @hibernate.list
        *  inverse="false"
        *  lazy="false"
        *  cascade="all"
        *  table="technical_intervention_request_intervention_type"
        * @hibernate.key
        *  column="technical_intervention_request_id"
        * @hibernate.list-index
        *  column="intervention_type_index"
        * @hibernate.many-to-many
        *  column="intervention_type_id"
        *  class="fr.cg95.cvq.business.request.LocalReferentialData"
      
    */
    public final List<fr.cg95.cvq.business.request.LocalReferentialData> getInterventionType() {
        return this.interventionType;
    }
  
}
