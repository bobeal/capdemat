
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
 *  table="learning_activities_discovery_registration_request"
 *  lazy="false"
 */
public class LearningActivitiesDiscoveryRegistrationRequestData implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final Map<String, IConditionChecker> conditions =
        new HashMap<String, IConditionChecker>(RequestData.conditions);

    private Long id;

    public LearningActivitiesDiscoveryRegistrationRequestData() {
      
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

  
    
      @LocalReferential(
        
        
        profiles = {"subject"},
        message = "atelierEveil"
      )
    
      @MinSize(
        
          value = 1,
        
        
        profiles = {"subject"},
        message = "atelierEveil"
      )
    
    private List<fr.cg95.cvq.business.request.LocalReferentialData> atelierEveil;

    public final void setAtelierEveil(final List<fr.cg95.cvq.business.request.LocalReferentialData> atelierEveil) {
        this.atelierEveil = atelierEveil;
    }

    /**
 
        * @hibernate.list
        *  inverse="false"
        *  lazy="false"
        *  cascade="all"
        *  table="learning_activities_discovery_registration_request_atelier_eveil"
        * @hibernate.key
        *  column="learning_activities_discovery_registration_request_id"
        * @hibernate.list-index
        *  column="atelier_eveil_index"
        * @hibernate.many-to-many
        *  column="atelier_eveil_id"
        *  class="fr.cg95.cvq.business.request.LocalReferentialData"
      
    */
    public final List<fr.cg95.cvq.business.request.LocalReferentialData> getAtelierEveil() {
        return this.atelierEveil;
    }
  
}
