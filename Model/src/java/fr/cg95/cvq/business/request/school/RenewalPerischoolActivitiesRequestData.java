
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
 *  table="renewal_perischool_activities_request"
 *  lazy="false"
 */
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
      
          
        
          
            
        List<fr.cg95.cvq.business.request.LocalReferentialData> regimeAlimentaireRenouvellementList = new ArrayList<fr.cg95.cvq.business.request.LocalReferentialData>();
        for (LocalReferentialData object : regimeAlimentaireRenouvellement) {
            regimeAlimentaireRenouvellementList.add(object.clone());
        }
        result.setRegimeAlimentaireRenouvellement(regimeAlimentaireRenouvellementList);
      
          
        
        return result;
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
        
        
        profiles = {"reglements"},
        message = "acceptationReglementInterieur"
      )
    
    private Boolean acceptationReglementInterieur;

    public final void setAcceptationReglementInterieur(final Boolean acceptationReglementInterieur) {
        this.acceptationReglementInterieur = acceptationReglementInterieur;
    }

    /**
 
        * @hibernate.property
        *  column="acceptation_reglement_interieur"
        
      
    */
    public final Boolean getAcceptationReglementInterieur() {
        return this.acceptationReglementInterieur;
    }
  
    
      @NotNull(
        
        
        profiles = {"enfant"},
        message = "estPeriscolaire"
      )
    
    private Boolean estPeriscolaire;

    public final void setEstPeriscolaire(final Boolean estPeriscolaire) {
        this.estPeriscolaire = estPeriscolaire;
    }

    /**
 
        * @hibernate.property
        *  column="est_periscolaire"
        
      
    */
    public final Boolean getEstPeriscolaire() {
        return this.estPeriscolaire;
    }
  
    
      @NotNull(
        
        
        profiles = {"enfant"},
        message = "estRestauration"
      )
    
    private Boolean estRestauration;

    public final void setEstRestauration(final Boolean estRestauration) {
        this.estRestauration = estRestauration;
    }

    /**
 
        * @hibernate.property
        *  column="est_restauration"
        
      
    */
    public final Boolean getEstRestauration() {
        return this.estRestauration;
    }
  
    
      @LocalReferential(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['estRestauration'].test(_this.estRestauration.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"enfant"},
        message = "regimeAlimentaireRenouvellement"
      )
    
      @MinSize(
        
          value = 1,
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['estRestauration'].test(_this.estRestauration.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"enfant"},
        message = "regimeAlimentaireRenouvellement"
      )
    
    private List<fr.cg95.cvq.business.request.LocalReferentialData> regimeAlimentaireRenouvellement;

    public final void setRegimeAlimentaireRenouvellement(final List<fr.cg95.cvq.business.request.LocalReferentialData> regimeAlimentaireRenouvellement) {
        this.regimeAlimentaireRenouvellement = regimeAlimentaireRenouvellement;
    }

    /**
 
        * @hibernate.list
        *  inverse="false"
        *  lazy="false"
        *  cascade="all"
        *  table="renewal_perischool_activities_request_regime_alimentaire_renouvellement"
        * @hibernate.key
        *  column="renewal_perischool_activities_request_id"
        * @hibernate.list-index
        *  column="regime_alimentaire_renouvellement_index"
        * @hibernate.many-to-many
        *  column="regime_alimentaire_renouvellement_id"
        *  class="fr.cg95.cvq.business.request.LocalReferentialData"
      
    */
    public final List<fr.cg95.cvq.business.request.LocalReferentialData> getRegimeAlimentaireRenouvellement() {
        return this.regimeAlimentaireRenouvellement;
    }
  
}
