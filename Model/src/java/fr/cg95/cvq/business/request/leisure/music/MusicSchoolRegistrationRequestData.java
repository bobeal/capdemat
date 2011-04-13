

package fr.cg95.cvq.business.request.leisure.music;

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
@Table(name="music_school_registration_request")
public class MusicSchoolRegistrationRequestData implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final Map<String, IConditionChecker> conditions =
        new HashMap<String, IConditionChecker>(RequestData.conditions);

    private Long id;

    public MusicSchoolRegistrationRequestData() {
      
    }

    @Override
    public MusicSchoolRegistrationRequestData clone() {
        MusicSchoolRegistrationRequestData result = new MusicSchoolRegistrationRequestData();
        
          
            
        List<fr.cg95.cvq.business.request.LocalReferentialData> activityList = new ArrayList<fr.cg95.cvq.business.request.LocalReferentialData>();
        for (LocalReferentialData object : activity) {
            activityList.add(object.clone());
        }
        result.setActivity(activityList);
      
          
        
          
            
        result.setRulesAndRegulationsAcceptance(rulesAndRegulationsAcceptance);
      
          
        
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
        
        
        profiles = {"registration"},
        message = "activity"
      )
    
      @MinSize(
        
          value = 1,
        
        
        profiles = {"registration"},
        message = "activity"
      )
    
    private List<fr.cg95.cvq.business.request.LocalReferentialData> activity;

    public void setActivity(final List<fr.cg95.cvq.business.request.LocalReferentialData> activity) {
        this.activity = activity;
    }

 
    @ManyToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinTable(name="music_school_registration_request_activity",
            joinColumns=
                @JoinColumn(name="music_school_registration_request_id"),
            inverseJoinColumns=
                @JoinColumn(name="activity_id"))
    @OrderColumn(name="activity_index")
      
    public List<fr.cg95.cvq.business.request.LocalReferentialData> getActivity() {
        return this.activity;
    }
  
    
    private Boolean rulesAndRegulationsAcceptance;

    public void setRulesAndRegulationsAcceptance(final Boolean rulesAndRegulationsAcceptance) {
        this.rulesAndRegulationsAcceptance = rulesAndRegulationsAcceptance;
    }

 
    @Column(name="rules_and_regulations_acceptance"  )
      
    public Boolean getRulesAndRegulationsAcceptance() {
        return this.rulesAndRegulationsAcceptance;
    }
  
}
