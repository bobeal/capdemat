
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
 *  table="pessac_animation_request"
 *  lazy="false"
 */
public class PessacAnimationRequestData implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final Map<String, IConditionChecker> conditions =
        new HashMap<String, IConditionChecker>(RequestData.conditions);

    private Long id;

    public PessacAnimationRequestData() {
      
        acceptationReglementInterieur = Boolean.valueOf(false);
      
    }

    @Override
    public PessacAnimationRequestData clone() {
        PessacAnimationRequestData result = new PessacAnimationRequestData();
        
          
            
        result.setAcceptationReglementInterieur(acceptationReglementInterieur);
      
          
        
          
            
        result.setEmailSujet(emailSujet);
      
          
        
          
            
        result.setTelephoneSujet(telephoneSujet);
      
          
        
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
        
        
        profiles = {"enfant"},
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
  
    
    private String emailSujet;

    public final void setEmailSujet(final String emailSujet) {
        this.emailSujet = emailSujet;
    }

    /**
 
        * @hibernate.property
        *  column="email_sujet"
        
      
    */
    public final String getEmailSujet() {
        return this.emailSujet;
    }
  
    
      @MaxLength(
        
          value = 10,
        
        
        profiles = {"enfant"},
        message = "telephoneSujet"
      )
    
    private String telephoneSujet;

    public final void setTelephoneSujet(final String telephoneSujet) {
        this.telephoneSujet = telephoneSujet;
    }

    /**
 
        * @hibernate.property
        *  column="telephone_sujet"
        *  length="10"
      
    */
    public final String getTelephoneSujet() {
        return this.telephoneSujet;
    }
  
}
