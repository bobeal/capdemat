
package fr.cg95.cvq.business.request.technical;

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
 *  table="technical_intervention_request"
 *  lazy="false"
 */
public class TechnicalInterventionRequestData implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final Map<String, IConditionChecker> conditions =
        new HashMap<String, IConditionChecker>(RequestData.conditions);

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

  
    
      @NotNull(
        
        
        profiles = {"intervention"},
        message = "interventionDescription"
      )
    
      @NotBlank(
        
        
        profiles = {"intervention"},
        message = "interventionDescription"
      )
    
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
  
    
      @NotNull(
        
        
        profiles = {"intervention"},
        message = "interventionPlace"
      )
    
      @AssertValid(
        
        
        profiles = {"intervention"},
        message = "interventionPlace"
      )
    
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
  
    
      @LocalReferential(
        
        
        profiles = {"intervention"},
        message = "interventionType"
      )
    
      @MinSize(
        
          value = 1,
        
        
        profiles = {"intervention"},
        message = "interventionType"
      )
    
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
  
    
      @NotNull(
        
        
          when = "groovy:def active = true;" +
          
            "if (_this.interventionType == null || _this.interventionType.isEmpty()) return false; _this.interventionType.each { active &= _this.conditions['interventionType'].test(it.name) };" +
                
              
            
            
            "return active",
        
        profiles = {"intervention"},
        message = "otherInterventionLabel"
      )
    
      @NotBlank(
        
        
          when = "groovy:def active = true;" +
          
            "if (_this.interventionType == null || _this.interventionType.isEmpty()) return false; _this.interventionType.each { active &= _this.conditions['interventionType'].test(it.name) };" +
                
              
            
            
            "return active",
        
        profiles = {"intervention"},
        message = "otherInterventionLabel"
      )
    
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
  
}
