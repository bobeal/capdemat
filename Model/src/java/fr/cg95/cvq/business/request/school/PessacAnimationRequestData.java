

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
@Table(name="pessac_animation_request")
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
  
    
    private String emailSujet;

    public void setEmailSujet(final String emailSujet) {
        this.emailSujet = emailSujet;
    }

 
    @Column(name="email_sujet"  )
      
    public String getEmailSujet() {
        return this.emailSujet;
    }
  
    
      @MaxLength(
        
          value = 10,
        
        
        profiles = {"enfant"},
        message = "telephoneSujet"
      )
    
    private String telephoneSujet;

    public void setTelephoneSujet(final String telephoneSujet) {
        this.telephoneSujet = telephoneSujet;
    }

 
    @Column(name="telephone_sujet" , length=10 )
      
    public String getTelephoneSujet() {
        return this.telephoneSujet;
    }
  
}
