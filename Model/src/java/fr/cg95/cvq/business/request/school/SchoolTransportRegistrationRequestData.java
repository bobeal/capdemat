
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
 *  table="school_transport_registration_request"
 *  lazy="false"
 */
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
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['estMaternelleElementaireAutorisations'].test(_this.estMaternelleElementaireAutorisations.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"autorisations"},
        message = "autorisation"
      )
    
    private fr.cg95.cvq.business.request.school.AutorisationType autorisation;

    public final void setAutorisation(final fr.cg95.cvq.business.request.school.AutorisationType autorisation) {
        this.autorisation = autorisation;
    }

    /**
 
        * @hibernate.property
        *  column="autorisation"
        
      
    */
    public final fr.cg95.cvq.business.request.school.AutorisationType getAutorisation() {
        return this.autorisation;
    }
  
    
      @NotNull(
        
        
        profiles = {"autorisations"},
        message = "estMaternelleElementaireAutorisations"
      )
    
    private Boolean estMaternelleElementaireAutorisations;

    public final void setEstMaternelleElementaireAutorisations(final Boolean estMaternelleElementaireAutorisations) {
        this.estMaternelleElementaireAutorisations = estMaternelleElementaireAutorisations;
    }

    /**
 
        * @hibernate.property
        *  column="est_maternelle_elementaire_autorisations"
        
      
    */
    public final Boolean getEstMaternelleElementaireAutorisations() {
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

    public final void setFrereOuSoeurClasse(final String frereOuSoeurClasse) {
        this.frereOuSoeurClasse = frereOuSoeurClasse;
    }

    /**
 
        * @hibernate.property
        *  column="frere_ou_soeur_classe"
        
      
    */
    public final String getFrereOuSoeurClasse() {
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

    public final void setFrereOuSoeurEcole(final String frereOuSoeurEcole) {
        this.frereOuSoeurEcole = frereOuSoeurEcole;
    }

    /**
 
        * @hibernate.property
        *  column="frere_ou_soeur_ecole"
        
      
    */
    public final String getFrereOuSoeurEcole() {
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

    public final void setFrereOuSoeurNom(final String frereOuSoeurNom) {
        this.frereOuSoeurNom = frereOuSoeurNom;
    }

    /**
 
        * @hibernate.property
        *  column="frere_ou_soeur_nom"
        *  length="38"
      
    */
    public final String getFrereOuSoeurNom() {
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

    public final void setFrereOuSoeurPrenom(final String frereOuSoeurPrenom) {
        this.frereOuSoeurPrenom = frereOuSoeurPrenom;
    }

    /**
 
        * @hibernate.property
        *  column="frere_ou_soeur_prenom"
        *  length="38"
      
    */
    public final String getFrereOuSoeurPrenom() {
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
        message = "idLigne"
      )
    
      @NotBlank(
        
        
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
        
        
        profiles = {"enfant"},
        message = "labelArret"
      )
    
      @NotBlank(
        
        
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
        message = "labelLigne"
      )
    
      @NotBlank(
        
        
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

    public final void setTiersAutorises(final List<fr.cg95.cvq.business.request.school.TiersInformations> tiersAutorises) {
        this.tiersAutorises = tiersAutorises;
    }

    /**
 
        * @hibernate.list
        *  inverse="false"
        *  lazy="false"
        *  cascade="all"
        * @hibernate.key
        *  column="school_transport_registration_request_id"
        * @hibernate.list-index
        *  column="tiers_autorises_index"
        * @hibernate.one-to-many
        *  class="fr.cg95.cvq.business.request.school.TiersInformations"
      
    */
    public final List<fr.cg95.cvq.business.request.school.TiersInformations> getTiersAutorises() {
        return this.tiersAutorises;
    }
  
}
