
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
 *  table="holiday_camp_registration_request"
 *  lazy="false"
 */
public class HolidayCampRegistrationRequestData implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final Map<String, IConditionChecker> conditions =
        new HashMap<String, IConditionChecker>(RequestData.conditions);

    private Long id;

    public HolidayCampRegistrationRequestData() {
      
        acceptationReglementInterieur = Boolean.valueOf(false);
      
    }

    @Override
    public HolidayCampRegistrationRequestData clone() {
        HolidayCampRegistrationRequestData result = new HolidayCampRegistrationRequestData();
        
          
            
        result.setAcceptationReglementInterieur(acceptationReglementInterieur);
      
          
        
          
            
        result.setIdCentreSejours(idCentreSejours);
      
          
        
          
            
        result.setLabelCentreSejours(labelCentreSejours);
      
          
        
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
        message = "idCentreSejours"
      )
    
      @NotBlank(
        
        
        profiles = {"enfant"},
        message = "idCentreSejours"
      )
    
    private String idCentreSejours;

    public final void setIdCentreSejours(final String idCentreSejours) {
        this.idCentreSejours = idCentreSejours;
    }

    /**
 
        * @hibernate.property
        *  column="id_centre_sejours"
        
      
    */
    public final String getIdCentreSejours() {
        return this.idCentreSejours;
    }
  
    
      @NotNull(
        
        
        profiles = {"enfant"},
        message = "labelCentreSejours"
      )
    
      @NotBlank(
        
        
        profiles = {"enfant"},
        message = "labelCentreSejours"
      )
    
    private String labelCentreSejours;

    public final void setLabelCentreSejours(final String labelCentreSejours) {
        this.labelCentreSejours = labelCentreSejours;
    }

    /**
 
        * @hibernate.property
        *  column="label_centre_sejours"
        
      
    */
    public final String getLabelCentreSejours() {
        return this.labelCentreSejours;
    }
  
}
