

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
@Table(name="school_transport_registration_request")
public class SchoolTransportRegistrationRequestData implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final Map<String, IConditionChecker> conditions =
        new HashMap<String, IConditionChecker>(RequestData.conditions);

    private Long id;

    public SchoolTransportRegistrationRequestData() {
      
        acceptationReglementInterieur = Boolean.valueOf(false);
      
        estMaternelleElementaireAutorisations = Boolean.valueOf(false);
      
    }

    @Override
    public SchoolTransportRegistrationRequestData clone() {
        SchoolTransportRegistrationRequestData result = new SchoolTransportRegistrationRequestData();
        
          
            
        result.setAcceptationReglementInterieur(acceptationReglementInterieur);
      
          
        
          
            
        if (autorisation != null)
            result.setAutorisation(autorisation);
        else
            result.setAutorisation(fr.cg95.cvq.business.request.school.AutorisationType.getDefaultAutorisationType());
      
          
        
          
            
        result.setEstMaternelleElementaireAutorisations(estMaternelleElementaireAutorisations);
      
          
        
          
            
        result.setFrereOuSoeurClasse(frereOuSoeurClasse);
      
          
        
          
            
        result.setFrereOuSoeurEcole(frereOuSoeurEcole);
      
          
        
          
            
        result.setFrereOuSoeurNom(frereOuSoeurNom);
      
          
        
          
            
        result.setFrereOuSoeurPrenom(frereOuSoeurPrenom);
      
          
        
          
            
        result.setIdArret(idArret);
      
          
        
          
            
        result.setIdLigne(idLigne);
      
          
        
          
            
        result.setLabelArret(labelArret);
      
          
        
          
            
        result.setLabelLigne(labelLigne);
      
          
        
          
            
        List<fr.cg95.cvq.business.request.school.TiersInformations> tiersAutorisesList = new ArrayList<fr.cg95.cvq.business.request.school.TiersInformations>();
        for (TiersInformations object : tiersAutorises) {
            tiersAutorisesList.add(object.clone());
        }
        result.setTiersAutorises(tiersAutorisesList);
      
          
        
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

  
    
      @NotNull(
        
        
        profiles = {"reglements"},
        message = "acceptationReglementInterieur"
      )
    
    private Boolean acceptationReglementInterieur;

    public void setAcceptationReglementInterieur(final Boolean acceptationReglementInterieur) {
        this.acceptationReglementInterieur = acceptationReglementInterieur;
    }

 
    @Column(name="acceptation_reglement_interieur"  )
      
    public Boolean getAcceptationReglementInterieur() {
        return this.acceptationReglementInterieur;
    }
  
    
      @NotNull(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['estMaternelleElementaireAutorisations'].test(_this.estMaternelleElementaireAutorisations.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"autorisations"},
        message = "autorisation"
      )
    
    private fr.cg95.cvq.business.request.school.AutorisationType autorisation;

    public void setAutorisation(final fr.cg95.cvq.business.request.school.AutorisationType autorisation) {
        this.autorisation = autorisation;
    }

 
    @Enumerated(EnumType.STRING)
    @Column(name="autorisation"  )
      
    public fr.cg95.cvq.business.request.school.AutorisationType getAutorisation() {
        return this.autorisation;
    }
  
    
      @NotNull(
        
        
        profiles = {"autorisations"},
        message = "estMaternelleElementaireAutorisations"
      )
    
    private Boolean estMaternelleElementaireAutorisations;

    public void setEstMaternelleElementaireAutorisations(final Boolean estMaternelleElementaireAutorisations) {
        this.estMaternelleElementaireAutorisations = estMaternelleElementaireAutorisations;
    }

 
    @Column(name="est_maternelle_elementaire_autorisations"  )
      
    public Boolean getEstMaternelleElementaireAutorisations() {
        return this.estMaternelleElementaireAutorisations;
    }
  
    
      @NotNull(
        
        
          when = "groovy:def active = true;" +
          
            
            "active &= _this.conditions['autorisation'].test(_this.autorisation.toString());" +
                
              
            
            "return active",
        
        profiles = {"autorisations"},
        message = "frereOuSoeurClasse"
      )
    
      @NotBlank(
        
        
          when = "groovy:def active = true;" +
          
            
            "active &= _this.conditions['autorisation'].test(_this.autorisation.toString());" +
                
              
            
            "return active",
        
        profiles = {"autorisations"},
        message = "frereOuSoeurClasse"
      )
    
    private String frereOuSoeurClasse;

    public void setFrereOuSoeurClasse(final String frereOuSoeurClasse) {
        this.frereOuSoeurClasse = frereOuSoeurClasse;
    }

 
    @Column(name="frere_ou_soeur_classe"  )
      
    public String getFrereOuSoeurClasse() {
        return this.frereOuSoeurClasse;
    }
  
    
      @NotNull(
        
        
          when = "groovy:def active = true;" +
          
            
            "active &= _this.conditions['autorisation'].test(_this.autorisation.toString());" +
                
              
            
            "return active",
        
        profiles = {"autorisations"},
        message = "frereOuSoeurEcole"
      )
    
      @NotBlank(
        
        
          when = "groovy:def active = true;" +
          
            
            "active &= _this.conditions['autorisation'].test(_this.autorisation.toString());" +
                
              
            
            "return active",
        
        profiles = {"autorisations"},
        message = "frereOuSoeurEcole"
      )
    
    private String frereOuSoeurEcole;

    public void setFrereOuSoeurEcole(final String frereOuSoeurEcole) {
        this.frereOuSoeurEcole = frereOuSoeurEcole;
    }

 
    @Column(name="frere_ou_soeur_ecole"  )
      
    public String getFrereOuSoeurEcole() {
        return this.frereOuSoeurEcole;
    }
  
    
      @MaxLength(
        
          value = 38,
        
        
          when = "groovy:def active = true;" +
          
            
            "active &= _this.conditions['autorisation'].test(_this.autorisation.toString());" +
                
              
            
            "return active",
        
        profiles = {"autorisations"},
        message = "frereOuSoeurNom"
      )
    
      @NotNull(
        
        
          when = "groovy:def active = true;" +
          
            
            "active &= _this.conditions['autorisation'].test(_this.autorisation.toString());" +
                
              
            
            "return active",
        
        profiles = {"autorisations"},
        message = "frereOuSoeurNom"
      )
    
      @NotBlank(
        
        
          when = "groovy:def active = true;" +
          
            
            "active &= _this.conditions['autorisation'].test(_this.autorisation.toString());" +
                
              
            
            "return active",
        
        profiles = {"autorisations"},
        message = "frereOuSoeurNom"
      )
    
    private String frereOuSoeurNom;

    public void setFrereOuSoeurNom(final String frereOuSoeurNom) {
        this.frereOuSoeurNom = frereOuSoeurNom;
    }

 
    @Column(name="frere_ou_soeur_nom" , length=38 )
      
    public String getFrereOuSoeurNom() {
        return this.frereOuSoeurNom;
    }
  
    
      @MaxLength(
        
          value = 38,
        
        
          when = "groovy:def active = true;" +
          
            
            "active &= _this.conditions['autorisation'].test(_this.autorisation.toString());" +
                
              
            
            "return active",
        
        profiles = {"autorisations"},
        message = "frereOuSoeurPrenom"
      )
    
      @NotNull(
        
        
          when = "groovy:def active = true;" +
          
            
            "active &= _this.conditions['autorisation'].test(_this.autorisation.toString());" +
                
              
            
            "return active",
        
        profiles = {"autorisations"},
        message = "frereOuSoeurPrenom"
      )
    
      @NotBlank(
        
        
          when = "groovy:def active = true;" +
          
            
            "active &= _this.conditions['autorisation'].test(_this.autorisation.toString());" +
                
              
            
            "return active",
        
        profiles = {"autorisations"},
        message = "frereOuSoeurPrenom"
      )
    
    private String frereOuSoeurPrenom;

    public void setFrereOuSoeurPrenom(final String frereOuSoeurPrenom) {
        this.frereOuSoeurPrenom = frereOuSoeurPrenom;
    }

 
    @Column(name="frere_ou_soeur_prenom" , length=38 )
      
    public String getFrereOuSoeurPrenom() {
        return this.frereOuSoeurPrenom;
    }
  
    
      @NotNull(
        
        
        profiles = {"enfant"},
        message = "idArret"
      )
    
      @NotBlank(
        
        
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
        message = "idLigne"
      )
    
      @NotBlank(
        
        
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
        
        
        profiles = {"enfant"},
        message = "labelArret"
      )
    
      @NotBlank(
        
        
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
        message = "labelLigne"
      )
    
      @NotBlank(
        
        
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
  
    
      @AssertValid(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['autorisation'].test(_this.autorisation.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"autorisations"},
        message = "tiersAutorises"
      )
    
      @MinSize(
        
          value = 1,
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['autorisation'].test(_this.autorisation.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"autorisations"},
        message = "tiersAutorises"
      )
    
    private List<fr.cg95.cvq.business.request.school.TiersInformations> tiersAutorises;

    public void setTiersAutorises(final List<fr.cg95.cvq.business.request.school.TiersInformations> tiersAutorises) {
        this.tiersAutorises = tiersAutorises;
    }

 
    @OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
    @OrderColumn(name="tiers_autorises_index")
    @JoinColumn(name="school_transport_registration_request_id")
      
    public List<fr.cg95.cvq.business.request.school.TiersInformations> getTiersAutorises() {
        return this.tiersAutorises;
    }
  
}
