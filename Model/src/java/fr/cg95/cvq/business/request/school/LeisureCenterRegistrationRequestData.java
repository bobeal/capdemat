
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
 *  table="leisure_center_registration_request"
 *  lazy="false"
 */
public class LeisureCenterRegistrationRequestData implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final Map<String, IConditionChecker> conditions =
        new HashMap<String, IConditionChecker>(RequestData.conditions);

    private Long id;

    public LeisureCenterRegistrationRequestData() {
      
        acceptationReglementInterieur = Boolean.valueOf(false);
      
        estDerogation = Boolean.valueOf(false);
      
        estTransport = Boolean.valueOf(false);
      
    }

    @Override
    public LeisureCenterRegistrationRequestData clone() {
        LeisureCenterRegistrationRequestData result = new LeisureCenterRegistrationRequestData();
        
          
            
        result.setAcceptationReglementInterieur(acceptationReglementInterieur);
      
          
        
          
            
        result.setEstDerogation(estDerogation);
      
          
        
          
            
        result.setEstTransport(estTransport);
      
          
        
          
            
        result.setIdArret(idArret);
      
          
        
          
            
        result.setIdCentreLoisirs(idCentreLoisirs);
      
          
        
          
            
        result.setIdLigne(idLigne);
      
          
        
          
            
        result.setLabelArret(labelArret);
      
          
        
          
            
        result.setLabelCentreLoisirs(labelCentreLoisirs);
      
          
        
          
            
        result.setLabelLigne(labelLigne);
      
          
        
          
            
        List<fr.cg95.cvq.business.request.LocalReferentialData> motifsDerogationCentreLoisirsList = new ArrayList<fr.cg95.cvq.business.request.LocalReferentialData>();
        for (LocalReferentialData object : motifsDerogationCentreLoisirs) {
            motifsDerogationCentreLoisirsList.add(object.clone());
        }
        result.setMotifsDerogationCentreLoisirs(motifsDerogationCentreLoisirsList);
      
          
        
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
        message = "estDerogation"
      )
    
    private Boolean estDerogation;

    public final void setEstDerogation(final Boolean estDerogation) {
        this.estDerogation = estDerogation;
    }

    /**
 
        * @hibernate.property
        *  column="est_derogation"
        
      
    */
    public final Boolean getEstDerogation() {
        return this.estDerogation;
    }
  
    
      @NotNull(
        
        
        profiles = {"enfant"},
        message = "estTransport"
      )
    
    private Boolean estTransport;

    public final void setEstTransport(final Boolean estTransport) {
        this.estTransport = estTransport;
    }

    /**
 
        * @hibernate.property
        *  column="est_transport"
        
      
    */
    public final Boolean getEstTransport() {
        return this.estTransport;
    }
  
    
      @NotNull(
        
        
          when = "groovy:def active = true;" +
          
            
            "active &= _this.conditions['estTransport'].test(_this.estTransport.toString());" +
                
              
            
            "return active",
        
        profiles = {"enfant"},
        message = "idArret"
      )
    
      @NotBlank(
        
        
          when = "groovy:def active = true;" +
          
            
            "active &= _this.conditions['estTransport'].test(_this.estTransport.toString());" +
                
              
            
            "return active",
        
        profiles = {"enfant"},
        message = "idArret"
      )
    
    private String idArret;

    public final void setIdArret(final String idArret) {
        this.idArret = idArret;
    }

    /**
 
        * @hibernate.property
        *  column="id_arret"
        
      
    */
    public final String getIdArret() {
        return this.idArret;
    }
  
    
      @NotNull(
        
        
        profiles = {"enfant"},
        message = "idCentreLoisirs"
      )
    
      @NotBlank(
        
        
        profiles = {"enfant"},
        message = "idCentreLoisirs"
      )
    
    private String idCentreLoisirs;

    public final void setIdCentreLoisirs(final String idCentreLoisirs) {
        this.idCentreLoisirs = idCentreLoisirs;
    }

    /**
 
        * @hibernate.property
        *  column="id_centre_loisirs"
        
      
    */
    public final String getIdCentreLoisirs() {
        return this.idCentreLoisirs;
    }
  
    
      @NotNull(
        
        
          when = "groovy:def active = true;" +
          
            
            "active &= _this.conditions['estTransport'].test(_this.estTransport.toString());" +
                
              
            
            "return active",
        
        profiles = {"enfant"},
        message = "idLigne"
      )
    
      @NotBlank(
        
        
          when = "groovy:def active = true;" +
          
            
            "active &= _this.conditions['estTransport'].test(_this.estTransport.toString());" +
                
              
            
            "return active",
        
        profiles = {"enfant"},
        message = "idLigne"
      )
    
    private String idLigne;

    public final void setIdLigne(final String idLigne) {
        this.idLigne = idLigne;
    }

    /**
 
        * @hibernate.property
        *  column="id_ligne"
        
      
    */
    public final String getIdLigne() {
        return this.idLigne;
    }
  
    
      @NotNull(
        
        
          when = "groovy:def active = true;" +
          
            
            "active &= _this.conditions['estTransport'].test(_this.estTransport.toString());" +
                
              
            
            "return active",
        
        profiles = {"enfant"},
        message = "labelArret"
      )
    
      @NotBlank(
        
        
          when = "groovy:def active = true;" +
          
            
            "active &= _this.conditions['estTransport'].test(_this.estTransport.toString());" +
                
              
            
            "return active",
        
        profiles = {"enfant"},
        message = "labelArret"
      )
    
    private String labelArret;

    public final void setLabelArret(final String labelArret) {
        this.labelArret = labelArret;
    }

    /**
 
        * @hibernate.property
        *  column="label_arret"
        
      
    */
    public final String getLabelArret() {
        return this.labelArret;
    }
  
    
      @NotNull(
        
        
        profiles = {"enfant"},
        message = "labelCentreLoisirs"
      )
    
      @NotBlank(
        
        
        profiles = {"enfant"},
        message = "labelCentreLoisirs"
      )
    
    private String labelCentreLoisirs;

    public final void setLabelCentreLoisirs(final String labelCentreLoisirs) {
        this.labelCentreLoisirs = labelCentreLoisirs;
    }

    /**
 
        * @hibernate.property
        *  column="label_centre_loisirs"
        
      
    */
    public final String getLabelCentreLoisirs() {
        return this.labelCentreLoisirs;
    }
  
    
      @NotNull(
        
        
          when = "groovy:def active = true;" +
          
            
            "active &= _this.conditions['estTransport'].test(_this.estTransport.toString());" +
                
              
            
            "return active",
        
        profiles = {"enfant"},
        message = "labelLigne"
      )
    
      @NotBlank(
        
        
          when = "groovy:def active = true;" +
          
            
            "active &= _this.conditions['estTransport'].test(_this.estTransport.toString());" +
                
              
            
            "return active",
        
        profiles = {"enfant"},
        message = "labelLigne"
      )
    
    private String labelLigne;

    public final void setLabelLigne(final String labelLigne) {
        this.labelLigne = labelLigne;
    }

    /**
 
        * @hibernate.property
        *  column="label_ligne"
        
      
    */
    public final String getLabelLigne() {
        return this.labelLigne;
    }
  
    
      @LocalReferential(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['estDerogation'].test(_this.estDerogation.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"enfant"},
        message = "motifsDerogationCentreLoisirs"
      )
    
      @MinSize(
        
          value = 1,
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['estDerogation'].test(_this.estDerogation.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"enfant"},
        message = "motifsDerogationCentreLoisirs"
      )
    
    private List<fr.cg95.cvq.business.request.LocalReferentialData> motifsDerogationCentreLoisirs;

    public final void setMotifsDerogationCentreLoisirs(final List<fr.cg95.cvq.business.request.LocalReferentialData> motifsDerogationCentreLoisirs) {
        this.motifsDerogationCentreLoisirs = motifsDerogationCentreLoisirs;
    }

    /**
 
        * @hibernate.list
        *  inverse="false"
        *  lazy="false"
        *  cascade="all"
        *  table="leisure_center_registration_request_motifs_derogation_centre_loisirs"
        * @hibernate.key
        *  column="leisure_center_registration_request_id"
        * @hibernate.list-index
        *  column="motifs_derogation_centre_loisirs_index"
        * @hibernate.many-to-many
        *  column="motifs_derogation_centre_loisirs_id"
        *  class="fr.cg95.cvq.business.request.LocalReferentialData"
      
    */
    public final List<fr.cg95.cvq.business.request.LocalReferentialData> getMotifsDerogationCentreLoisirs() {
        return this.motifsDerogationCentreLoisirs;
    }
  
}
