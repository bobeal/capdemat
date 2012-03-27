

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
@Table(name="saintouen_cap_jeunesse_enfant_request")
public class SaintouenCapJeunesseEnfantRequestData implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final Map<String, IConditionChecker> conditions =
        new HashMap<String, IConditionChecker>(RequestData.conditions);

    private Long id;

    public SaintouenCapJeunesseEnfantRequestData() {
      
        acceptationReglement = Boolean.valueOf(false);
      
        autorisationImage = Boolean.valueOf(true);
      
        autorisationMedicale = Boolean.valueOf(true);
      
        typeInscription = fr.cg95.cvq.business.request.school.ScjerTypeInscriptionType.PREMIERE_FOIS;
      
    }

    @Override
    public SaintouenCapJeunesseEnfantRequestData clone() {
        SaintouenCapJeunesseEnfantRequestData result = new SaintouenCapJeunesseEnfantRequestData();
        
          
            
        result.setAcceptationReglement(acceptationReglement);
      
          
        
          
            
        result.setAutorisationImage(autorisationImage);
      
          
        
          
            
        result.setAutorisationMedicale(autorisationMedicale);
      
          
        
          
            
        result.setEmail(email);
      
          
        
          
            
        result.setEtablissementScolaireAutre(etablissementScolaireAutre);
      
          
        
          
            
        if (etablissementScolaireAutreAdresse != null)
            result.setEtablissementScolaireAutreAdresse(etablissementScolaireAutreAdresse.clone());
      
          
        
          
            
        result.setEtablissementScolaireAutreNom(etablissementScolaireAutreNom);
      
          
        
          
            
        List<fr.cg95.cvq.business.request.LocalReferentialData> etablissementScolaireCollegeList = new ArrayList<fr.cg95.cvq.business.request.LocalReferentialData>();
        for (LocalReferentialData object : etablissementScolaireCollege) {
            etablissementScolaireCollegeList.add(object.clone());
        }
        result.setEtablissementScolaireCollege(etablissementScolaireCollegeList);
      
          
        
          
            
        List<fr.cg95.cvq.business.request.LocalReferentialData> etablissementScolaireLyceeList = new ArrayList<fr.cg95.cvq.business.request.LocalReferentialData>();
        for (LocalReferentialData object : etablissementScolaireLycee) {
            etablissementScolaireLyceeList.add(object.clone());
        }
        result.setEtablissementScolaireLycee(etablissementScolaireLyceeList);
      
          
        
          
            
        List<fr.cg95.cvq.business.request.LocalReferentialData> secteurHabitationList = new ArrayList<fr.cg95.cvq.business.request.LocalReferentialData>();
        for (LocalReferentialData object : secteurHabitation) {
            secteurHabitationList.add(object.clone());
        }
        result.setSecteurHabitation(secteurHabitationList);
      
          
        
          
            
        result.setSignatureAdolescent(signatureAdolescent);
      
          
        
          
            
        result.setSignatureElu(signatureElu);
      
          
        
          
            
        result.setSignatureResponsableLegal(signatureResponsableLegal);
      
          
        
          
            
        result.setTelephonePortable(telephonePortable);
      
          
        
          
            
        if (typeEtablissementScolaireFrenquente != null)
            result.setTypeEtablissementScolaireFrenquente(typeEtablissementScolaireFrenquente);
        else
            result.setTypeEtablissementScolaireFrenquente(fr.cg95.cvq.business.request.school.ScjerTypeEtablissementScolaireType.getDefaultScjerTypeEtablissementScolaireType());
      
          
        
          
            
        if (typeInscription != null)
            result.setTypeInscription(typeInscription);
        else
            result.setTypeInscription(fr.cg95.cvq.business.request.school.ScjerTypeInscriptionType.getDefaultScjerTypeInscriptionType());
      
          
        
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
        message = "acceptationReglement"
      )
    
      @AssertTrue(
        
        
        profiles = {"reglements"},
        message = "acceptationReglement"
      )
    
    private Boolean acceptationReglement;

    public void setAcceptationReglement(final Boolean acceptationReglement) {
        this.acceptationReglement = acceptationReglement;
    }

 
    @Column(name="acceptation_reglement"  )
      
    public Boolean getAcceptationReglement() {
        return this.acceptationReglement;
    }
  
    
    private Boolean autorisationImage;

    public void setAutorisationImage(final Boolean autorisationImage) {
        this.autorisationImage = autorisationImage;
    }

 
    @Column(name="autorisation_image"  )
      
    public Boolean getAutorisationImage() {
        return this.autorisationImage;
    }
  
    
    private Boolean autorisationMedicale;

    public void setAutorisationMedicale(final Boolean autorisationMedicale) {
        this.autorisationMedicale = autorisationMedicale;
    }

 
    @Column(name="autorisation_medicale"  )
      
    public Boolean getAutorisationMedicale() {
        return this.autorisationMedicale;
    }
  
    
    private String email;

    public void setEmail(final String email) {
        this.email = email;
    }

 
    @Column(name="email"  )
      
    public String getEmail() {
        return this.email;
    }
  
    
      @NotNull(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['typeEtablissementScolaireFrenquente'].test('estEtablissementFrequenteAutre='+_this.typeEtablissementScolaireFrenquente.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"renseignements"},
        message = "etablissementScolaireAutre"
      )
    
      @NotBlank(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['typeEtablissementScolaireFrenquente'].test('estEtablissementFrequenteAutre='+_this.typeEtablissementScolaireFrenquente.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"renseignements"},
        message = "etablissementScolaireAutre"
      )
    
    private String etablissementScolaireAutre;

    public void setEtablissementScolaireAutre(final String etablissementScolaireAutre) {
        this.etablissementScolaireAutre = etablissementScolaireAutre;
    }

 
    @Column(name="etablissement_scolaire_autre"  )
      
    public String getEtablissementScolaireAutre() {
        return this.etablissementScolaireAutre;
    }
  
    
      @NotNull(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['typeEtablissementScolaireFrenquente'].test('estEtablissementFrequenteAutre='+_this.typeEtablissementScolaireFrenquente.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"renseignements"},
        message = "etablissementScolaireAutreAdresse"
      )
    
      @AssertValid(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['typeEtablissementScolaireFrenquente'].test('estEtablissementFrequenteAutre='+_this.typeEtablissementScolaireFrenquente.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"renseignements"},
        message = "etablissementScolaireAutreAdresse"
      )
    
    private fr.cg95.cvq.business.users.Address etablissementScolaireAutreAdresse;

    public void setEtablissementScolaireAutreAdresse(final fr.cg95.cvq.business.users.Address etablissementScolaireAutreAdresse) {
        this.etablissementScolaireAutreAdresse = etablissementScolaireAutreAdresse;
    }

 
    @ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinColumn(name="etablissement_scolaire_autre_adresse_id")
      
    public fr.cg95.cvq.business.users.Address getEtablissementScolaireAutreAdresse() {
        return this.etablissementScolaireAutreAdresse;
    }
  
    
      @NotNull(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['typeEtablissementScolaireFrenquente'].test('estEtablissementFrequenteAutre='+_this.typeEtablissementScolaireFrenquente.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"renseignements"},
        message = "etablissementScolaireAutreNom"
      )
    
      @NotBlank(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['typeEtablissementScolaireFrenquente'].test('estEtablissementFrequenteAutre='+_this.typeEtablissementScolaireFrenquente.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"renseignements"},
        message = "etablissementScolaireAutreNom"
      )
    
    private String etablissementScolaireAutreNom;

    public void setEtablissementScolaireAutreNom(final String etablissementScolaireAutreNom) {
        this.etablissementScolaireAutreNom = etablissementScolaireAutreNom;
    }

 
    @Column(name="etablissement_scolaire_autre_nom"  )
      
    public String getEtablissementScolaireAutreNom() {
        return this.etablissementScolaireAutreNom;
    }
  
    
      @LocalReferential(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['typeEtablissementScolaireFrenquente'].test('estEtablissementFrequenteCollege='+_this.typeEtablissementScolaireFrenquente.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"renseignements"},
        message = "etablissementScolaireCollege"
      )
    
      @MinSize(
        
          value = 1,
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['typeEtablissementScolaireFrenquente'].test('estEtablissementFrequenteCollege='+_this.typeEtablissementScolaireFrenquente.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"renseignements"},
        message = "etablissementScolaireCollege"
      )
    
    private List<fr.cg95.cvq.business.request.LocalReferentialData> etablissementScolaireCollege;

    public void setEtablissementScolaireCollege(final List<fr.cg95.cvq.business.request.LocalReferentialData> etablissementScolaireCollege) {
        this.etablissementScolaireCollege = etablissementScolaireCollege;
    }

 
    @ManyToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinTable(name="saintouen_cap_jeunesse_enfant_request_etablissement_scolaire_college",
            joinColumns=
                @JoinColumn(name="saintouen_cap_jeunesse_enfant_request_id"),
            inverseJoinColumns=
                @JoinColumn(name="etablissement_scolaire_college_id"))
    @OrderColumn(name="etablissement_scolaire_college_index")
      
    public List<fr.cg95.cvq.business.request.LocalReferentialData> getEtablissementScolaireCollege() {
        return this.etablissementScolaireCollege;
    }
  
    
      @LocalReferential(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['typeEtablissementScolaireFrenquente'].test('estEtablissementFrequenteLycee='+_this.typeEtablissementScolaireFrenquente.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"renseignements"},
        message = "etablissementScolaireLycee"
      )
    
      @MinSize(
        
          value = 1,
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['typeEtablissementScolaireFrenquente'].test('estEtablissementFrequenteLycee='+_this.typeEtablissementScolaireFrenquente.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"renseignements"},
        message = "etablissementScolaireLycee"
      )
    
    private List<fr.cg95.cvq.business.request.LocalReferentialData> etablissementScolaireLycee;

    public void setEtablissementScolaireLycee(final List<fr.cg95.cvq.business.request.LocalReferentialData> etablissementScolaireLycee) {
        this.etablissementScolaireLycee = etablissementScolaireLycee;
    }

 
    @ManyToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinTable(name="saintouen_cap_jeunesse_enfant_request_etablissement_scolaire_lycee",
            joinColumns=
                @JoinColumn(name="saintouen_cap_jeunesse_enfant_request_id"),
            inverseJoinColumns=
                @JoinColumn(name="etablissement_scolaire_lycee_id"))
    @OrderColumn(name="etablissement_scolaire_lycee_index")
      
    public List<fr.cg95.cvq.business.request.LocalReferentialData> getEtablissementScolaireLycee() {
        return this.etablissementScolaireLycee;
    }
  
    
      @LocalReferential(
        
        
        profiles = {"renseignements"},
        message = "secteurHabitation"
      )
    
      @MinSize(
        
          value = 1,
        
        
        profiles = {"renseignements"},
        message = "secteurHabitation"
      )
    
    private List<fr.cg95.cvq.business.request.LocalReferentialData> secteurHabitation;

    public void setSecteurHabitation(final List<fr.cg95.cvq.business.request.LocalReferentialData> secteurHabitation) {
        this.secteurHabitation = secteurHabitation;
    }

 
    @ManyToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinTable(name="saintouen_cap_jeunesse_enfant_request_secteur_habitation",
            joinColumns=
                @JoinColumn(name="saintouen_cap_jeunesse_enfant_request_id"),
            inverseJoinColumns=
                @JoinColumn(name="secteur_habitation_id"))
    @OrderColumn(name="secteur_habitation_index")
      
    public List<fr.cg95.cvq.business.request.LocalReferentialData> getSecteurHabitation() {
        return this.secteurHabitation;
    }
  
    
      @NotNull(
        
        
        profiles = {"administration"},
        message = "signatureAdolescent"
      )
    
      @NotBlank(
        
        
        profiles = {"administration"},
        message = "signatureAdolescent"
      )
    
    private String signatureAdolescent;

    public void setSignatureAdolescent(final String signatureAdolescent) {
        this.signatureAdolescent = signatureAdolescent;
    }

 
    @Column(name="signature_adolescent"  )
      
    public String getSignatureAdolescent() {
        return this.signatureAdolescent;
    }
  
    
      @NotNull(
        
        
        profiles = {"administration"},
        message = "signatureElu"
      )
    
      @NotBlank(
        
        
        profiles = {"administration"},
        message = "signatureElu"
      )
    
    private String signatureElu;

    public void setSignatureElu(final String signatureElu) {
        this.signatureElu = signatureElu;
    }

 
    @Column(name="signature_elu"  )
      
    public String getSignatureElu() {
        return this.signatureElu;
    }
  
    
      @NotNull(
        
        
        profiles = {"administration"},
        message = "signatureResponsableLegal"
      )
    
      @NotBlank(
        
        
        profiles = {"administration"},
        message = "signatureResponsableLegal"
      )
    
    private String signatureResponsableLegal;

    public void setSignatureResponsableLegal(final String signatureResponsableLegal) {
        this.signatureResponsableLegal = signatureResponsableLegal;
    }

 
    @Column(name="signature_responsable_legal"  )
      
    public String getSignatureResponsableLegal() {
        return this.signatureResponsableLegal;
    }
  
    
      @MaxLength(
        
          value = 10,
        
        
        profiles = {"sujet"},
        message = "telephonePortable"
      )
    
      @NotNull(
        
        
        profiles = {"sujet"},
        message = "telephonePortable"
      )
    
      @NotBlank(
        
        
        profiles = {"sujet"},
        message = "telephonePortable"
      )
    
    private String telephonePortable;

    public void setTelephonePortable(final String telephonePortable) {
        this.telephonePortable = telephonePortable;
    }

 
    @Column(name="telephone_portable" , length=10 )
      
    public String getTelephonePortable() {
        return this.telephonePortable;
    }
  
    
      @NotNull(
        
        
        profiles = {"renseignements"},
        message = "typeEtablissementScolaireFrenquente"
      )
    
    private fr.cg95.cvq.business.request.school.ScjerTypeEtablissementScolaireType typeEtablissementScolaireFrenquente;

    public void setTypeEtablissementScolaireFrenquente(final fr.cg95.cvq.business.request.school.ScjerTypeEtablissementScolaireType typeEtablissementScolaireFrenquente) {
        this.typeEtablissementScolaireFrenquente = typeEtablissementScolaireFrenquente;
    }

 
    @Enumerated(EnumType.STRING)
    @Column(name="type_etablissement_scolaire_frenquente"  )
      
    public fr.cg95.cvq.business.request.school.ScjerTypeEtablissementScolaireType getTypeEtablissementScolaireFrenquente() {
        return this.typeEtablissementScolaireFrenquente;
    }
  
    
      @NotNull(
        
        
        profiles = {"renseignements"},
        message = "typeInscription"
      )
    
    private fr.cg95.cvq.business.request.school.ScjerTypeInscriptionType typeInscription;

    public void setTypeInscription(final fr.cg95.cvq.business.request.school.ScjerTypeInscriptionType typeInscription) {
        this.typeInscription = typeInscription;
    }

 
    @Enumerated(EnumType.STRING)
    @Column(name="type_inscription"  )
      
    public fr.cg95.cvq.business.request.school.ScjerTypeInscriptionType getTypeInscription() {
        return this.typeInscription;
    }
  
}
