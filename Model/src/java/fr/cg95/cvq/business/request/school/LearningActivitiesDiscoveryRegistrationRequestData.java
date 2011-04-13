

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
@Table(name="learning_activities_discovery_registration_request")
public class LearningActivitiesDiscoveryRegistrationRequestData implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final Map<String, IConditionChecker> conditions =
        new HashMap<String, IConditionChecker>(RequestData.conditions);

    private Long id;

    public LearningActivitiesDiscoveryRegistrationRequestData() {
      
    }

    @Override
    public LearningActivitiesDiscoveryRegistrationRequestData clone() {
        LearningActivitiesDiscoveryRegistrationRequestData result = new LearningActivitiesDiscoveryRegistrationRequestData();
        
          
            
        List<fr.cg95.cvq.business.request.LocalReferentialData> atelierEveilList = new ArrayList<fr.cg95.cvq.business.request.LocalReferentialData>();
        for (LocalReferentialData object : atelierEveil) {
            atelierEveilList.add(object.clone());
        }
        result.setAtelierEveil(atelierEveilList);
      
          
        
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

    public void setAtelierEveil(final List<fr.cg95.cvq.business.request.LocalReferentialData> atelierEveil) {
        this.atelierEveil = atelierEveil;
    }

 
    @ManyToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinTable(name="learning_activities_discovery_registration_request_atelier_eveil",
            joinColumns=
                @JoinColumn(name="learning_activities_discovery_registration_request_id"),
            inverseJoinColumns=
                @JoinColumn(name="atelier_eveil_id"))
    @OrderColumn(name="atelier_eveil_index")
      
    public List<fr.cg95.cvq.business.request.LocalReferentialData> getAtelierEveil() {
        return this.atelierEveil;
    }
  
}
