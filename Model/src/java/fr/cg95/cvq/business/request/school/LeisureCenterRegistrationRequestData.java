

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
@Table(name="leisure_center_registration_request")
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
        message = "estDerogation"
      )
    
    private Boolean estDerogation;

    public void setEstDerogation(final Boolean estDerogation) {
        this.estDerogation = estDerogation;
    }

 
    @Column(name="est_derogation"  )
      
    public Boolean getEstDerogation() {
        return this.estDerogation;
    }
  
    
      @NotNull(
        
        
        profiles = {"enfant"},
        message = "estTransport"
      )
    
    private Boolean estTransport;

    public void setEstTransport(final Boolean estTransport) {
        this.estTransport = estTransport;
    }

 
    @Column(name="est_transport"  )
      
    public Boolean getEstTransport() {
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

    public void setIdArret(final String idArret) {
        this.idArret = idArret;
    }

 
    @Column(name="id_arret"  )
      
    public String getIdArret() {
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

    public void setIdCentreLoisirs(final String idCentreLoisirs) {
        this.idCentreLoisirs = idCentreLoisirs;
    }

 
    @Column(name="id_centre_loisirs"  )
      
    public String getIdCentreLoisirs() {
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

    public void setIdLigne(final String idLigne) {
        this.idLigne = idLigne;
    }

 
    @Column(name="id_ligne"  )
      
    public String getIdLigne() {
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

    public void setLabelArret(final String labelArret) {
        this.labelArret = labelArret;
    }

 
    @Column(name="label_arret"  )
      
    public String getLabelArret() {
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

    public void setLabelCentreLoisirs(final String labelCentreLoisirs) {
        this.labelCentreLoisirs = labelCentreLoisirs;
    }

 
    @Column(name="label_centre_loisirs"  )
      
    public String getLabelCentreLoisirs() {
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

    public void setLabelLigne(final String labelLigne) {
        this.labelLigne = labelLigne;
    }

 
    @Column(name="label_ligne"  )
      
    public String getLabelLigne() {
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

    public void setMotifsDerogationCentreLoisirs(final List<fr.cg95.cvq.business.request.LocalReferentialData> motifsDerogationCentreLoisirs) {
        this.motifsDerogationCentreLoisirs = motifsDerogationCentreLoisirs;
    }

 
    @ManyToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinTable(name="leisure_center_registration_request_motifs_derogation_centre_loisirs",
            joinColumns=
                @JoinColumn(name="leisure_center_registration_request_id"),
            inverseJoinColumns=
                @JoinColumn(name="motifs_derogation_centre_loisirs_id"))
    @OrderColumn(name="motifs_derogation_centre_loisirs_index")
      
    public List<fr.cg95.cvq.business.request.LocalReferentialData> getMotifsDerogationCentreLoisirs() {
        return this.motifsDerogationCentreLoisirs;
    }
  
}
