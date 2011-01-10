
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
 *  table="home_emergency_registration_request"
 *  lazy="false"
 */
public class HomeEmergencyRegistrationRequestData implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final Map<String, IConditionChecker> conditions =
        new HashMap<String, IConditionChecker>(RequestData.conditions);

    private Long id;

    public HomeEmergencyRegistrationRequestData() {
      
    }

    @Override
    public HomeEmergencyRegistrationRequestData clone() {
        HomeEmergencyRegistrationRequestData result = new HomeEmergencyRegistrationRequestData();
        
          
            
        result.setTelephone(telephone);
      
          
        
          
            
        result.setDuree(duree);
      
          
        
          
            
        result.setDateDepart(dateDepart);
      
          
        
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

  
    
      @MaxLength(
        
          value = 10,
        
        
        profiles = {"subject"},
        message = "telephone"
      )
    
      @NotNull(
        
        
        profiles = {"subject"},
        message = "telephone"
      )
    
      @NotBlank(
        
        
        profiles = {"subject"},
        message = "telephone"
      )
    
    private String telephone;

    public final void setTelephone(final String telephone) {
        this.telephone = telephone;
    }

    /**
 
        * @hibernate.property
        *  column="telephone"
        *  length="10"
      
    */
    public final String getTelephone() {
        return this.telephone;
    }
  
    
      @MaxLength(
        
          value = 2,
        
        
        profiles = {"subject"},
        message = "duree"
      )
    
      @NotNull(
        
        
        profiles = {"subject"},
        message = "duree"
      )
    
      @MatchPattern(
        
          pattern = "[0-9]{1,2}$",
        
        
        profiles = {"subject"},
        message = "duree"
      )
    
      @NotBlank(
        
        
        profiles = {"subject"},
        message = "duree"
      )
    
    private String duree;

    public final void setDuree(final String duree) {
        this.duree = duree;
    }

    /**
 
        * @hibernate.property
        *  column="duree"
        *  length="2"
      
    */
    public final String getDuree() {
        return this.duree;
    }
  
    
      @NotNull(
        
        
        profiles = {"subject"},
        message = "dateDepart"
      )
    
    private java.util.Date dateDepart;

    public final void setDateDepart(final java.util.Date dateDepart) {
        this.dateDepart = dateDepart;
    }

    /**
 
        * @hibernate.property
        *  column="date_depart"
        
      
    */
    public final java.util.Date getDateDepart() {
        return this.dateDepart;
    }
  
}
