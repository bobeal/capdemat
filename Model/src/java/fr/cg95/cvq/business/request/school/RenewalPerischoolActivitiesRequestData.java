

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
@Table(name="renewal_perischool_activities_request")
public class RenewalPerischoolActivitiesRequestData implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final Map<String, IConditionChecker> conditions =
        new HashMap<String, IConditionChecker>(RequestData.conditions);

    private Long id;

    public RenewalPerischoolActivitiesRequestData() {
      
        acceptationReglementInterieur = Boolean.valueOf(false);
      
        estPeriscolaire = Boolean.valueOf(false);
      
        estRestauration = Boolean.valueOf(false);
      
    }

    @Override
    public RenewalPerischoolActivitiesRequestData clone() {
        RenewalPerischoolActivitiesRequestData result = new RenewalPerischoolActivitiesRequestData();
        
          
            
        result.setAcceptationReglementInterieur(acceptationReglementInterieur);
      
          
        
          
            
        result.setEstPeriscolaire(estPeriscolaire);
      
          
        
          
            
        result.setEstRestauration(estRestauration);
      
          
        
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

  
    
    private Boolean acceptationReglementInterieur;

    public void setAcceptationReglementInterieur(final Boolean acceptationReglementInterieur) {
        this.acceptationReglementInterieur = acceptationReglementInterieur;
    }

 
    @Column(name="acceptation_reglement_interieur"  )
      
    public Boolean getAcceptationReglementInterieur() {
        return this.acceptationReglementInterieur;
    }
  
    
      @NotNull(
        
        
        profiles = {"enfant"},
        message = "estPeriscolaire"
      )
    
    private Boolean estPeriscolaire;

    public void setEstPeriscolaire(final Boolean estPeriscolaire) {
        this.estPeriscolaire = estPeriscolaire;
    }

 
    @Column(name="est_periscolaire"  )
      
    public Boolean getEstPeriscolaire() {
        return this.estPeriscolaire;
    }
  
    
      @NotNull(
        
        
        profiles = {"enfant"},
        message = "estRestauration"
      )
    
    private Boolean estRestauration;

    public void setEstRestauration(final Boolean estRestauration) {
        this.estRestauration = estRestauration;
    }

 
    @Column(name="est_restauration"  )
      
    public Boolean getEstRestauration() {
        return this.estRestauration;
    }
  
}
