

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
@Table(name="saintouen_cap_jeunesse_adulte_request")
public class SaintouenCapJeunesseAdulteRequestData implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final Map<String, IConditionChecker> conditions =
        new HashMap<String, IConditionChecker>(RequestData.conditions);

    private Long id;

    public SaintouenCapJeunesseAdulteRequestData() {
      
        acceptationReglement = Boolean.valueOf(false);
      
        autorisationImage = Boolean.valueOf(true);
      
        autorisationMedicale = Boolean.valueOf(true);
      
        participeActivite = Boolean.valueOf(false);
      
        typeActivite = fr.cg95.cvq.business.request.school.ScjarTypeActiviteType.ACCUEIL;
      
        typeInscription = fr.cg95.cvq.business.request.school.ScjarTypeInscriptionType.PREMIERE_FOIS;
      
    }

    @Override
    public SaintouenCapJeunesseAdulteRequestData clone() {
        SaintouenCapJeunesseAdulteRequestData result = new SaintouenCapJeunesseAdulteRequestData();
        
          
            
        result.setAcceptationReglement(acceptationReglement);
      
          
        
          
            
        if (adresseEtablissementScolaireAutre != null)
            result.setAdresseEtablissementScolaireAutre(adresseEtablissementScolaireAutre.clone());
      
          
        
          
            
        result.setAutorisationImage(autorisationImage);
      
          
        
          
            
        result.setAutorisationMedicale(autorisationMedicale);
      
          
        
          
            
        result.setDateNaissance(dateNaissance);
      
          
        
          
            
        if (etudiantTypeEtablissement != null)
            result.setEtudiantTypeEtablissement(etudiantTypeEtablissement);
        else
            result.setEtudiantTypeEtablissement(fr.cg95.cvq.business.request.school.ScjarEtudiantTypeEtablissementType.getDefaultScjarEtudiantTypeEtablissementType());
      
          
        
          
            
        result.setNomEtablissementScolaireAutre(nomEtablissementScolaireAutre);
      
          
        
          
            
        result.setParticipeActivite(participeActivite);
      
          
        
          
            
        result.setPrecisionActivite(precisionActivite);
      
          
        
          
            
        result.setPrecisionEtablissementScolaireAutre(precisionEtablissementScolaireAutre);
      
          
        
          
            
        result.setProfession(profession);
      
          
        
          
            
        List<fr.cg95.cvq.business.request.LocalReferentialData> secteurHabitationList = new ArrayList<fr.cg95.cvq.business.request.LocalReferentialData>();
        for (LocalReferentialData object : secteurHabitation) {
            secteurHabitationList.add(object.clone());
        }
        result.setSecteurHabitation(secteurHabitationList);
      
          
        
          
            
        if (sexe != null)
            result.setSexe(sexe);
        else
            result.setSexe(fr.cg95.cvq.business.request.school.ScjarSexeType.getDefaultScjarSexeType());
      
          
        
          
            
        result.setSignatureAdolescent(signatureAdolescent);
      
          
        
          
            
        result.setSignatureElu(signatureElu);
      
          
        
          
            
        if (situationActuelle != null)
            result.setSituationActuelle(situationActuelle);
        else
            result.setSituationActuelle(fr.cg95.cvq.business.request.school.ScjarSituationActuelleType.getDefaultScjarSituationActuelleType());
      
          
        
          
            
        if (typeActivite != null)
            result.setTypeActivite(typeActivite);
        else
            result.setTypeActivite(fr.cg95.cvq.business.request.school.ScjarTypeActiviteType.getDefaultScjarTypeActiviteType());
      
          
        
          
            
        if (typeInscription != null)
            result.setTypeInscription(typeInscription);
        else
            result.setTypeInscription(fr.cg95.cvq.business.request.school.ScjarTypeInscriptionType.getDefaultScjarTypeInscriptionType());
      
          
        
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
  
    
      @NotNull(
        
        
          when = "groovy:def active = true;" +
          
            
            "active &= _this.conditions['etudiantTypeEtablissement'].test(_this.etudiantTypeEtablissement.toString());" +
                
              
            
            "return active",
        
        profiles = {"renseignements"},
        message = "adresseEtablissementScolaireAutre"
      )
    
      @AssertValid(
        
        
          when = "groovy:def active = true;" +
          
            
            "active &= _this.conditions['etudiantTypeEtablissement'].test(_this.etudiantTypeEtablissement.toString());" +
                
              
            
            "return active",
        
        profiles = {"renseignements"},
        message = "adresseEtablissementScolaireAutre"
      )
    
    private fr.cg95.cvq.business.users.Address adresseEtablissementScolaireAutre;

    public void setAdresseEtablissementScolaireAutre(final fr.cg95.cvq.business.users.Address adresseEtablissementScolaireAutre) {
        this.adresseEtablissementScolaireAutre = adresseEtablissementScolaireAutre;
    }

 
    @ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinColumn(name="adresse_etablissement_scolaire_autre_id")
      
    public fr.cg95.cvq.business.users.Address getAdresseEtablissementScolaireAutre() {
        return this.adresseEtablissementScolaireAutre;
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
  
    
      @NotNull(
        
        
        profiles = {"sujet"},
        message = "dateNaissance"
      )
    
    private java.util.Date dateNaissance;

    public void setDateNaissance(final java.util.Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

 
    @Column(name="date_naissance"  )
      
    public java.util.Date getDateNaissance() {
        return this.dateNaissance;
    }
  
    
      @NotNull(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['situationActuelle'].test('estEtudiant='+_this.situationActuelle.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"renseignements"},
        message = "etudiantTypeEtablissement"
      )
    
    private fr.cg95.cvq.business.request.school.ScjarEtudiantTypeEtablissementType etudiantTypeEtablissement;

    public void setEtudiantTypeEtablissement(final fr.cg95.cvq.business.request.school.ScjarEtudiantTypeEtablissementType etudiantTypeEtablissement) {
        this.etudiantTypeEtablissement = etudiantTypeEtablissement;
    }

 
    @Enumerated(EnumType.STRING)
    @Column(name="etudiant_type_etablissement"  )
      
    public fr.cg95.cvq.business.request.school.ScjarEtudiantTypeEtablissementType getEtudiantTypeEtablissement() {
        return this.etudiantTypeEtablissement;
    }
  
    
      @NotNull(
        
        
          when = "groovy:def active = true;" +
          
            
            "active &= _this.conditions['etudiantTypeEtablissement'].test(_this.etudiantTypeEtablissement.toString());" +
                
              
            
            "return active",
        
        profiles = {"renseignements"},
        message = "nomEtablissementScolaireAutre"
      )
    
      @NotBlank(
        
        
          when = "groovy:def active = true;" +
          
            
            "active &= _this.conditions['etudiantTypeEtablissement'].test(_this.etudiantTypeEtablissement.toString());" +
                
              
            
            "return active",
        
        profiles = {"renseignements"},
        message = "nomEtablissementScolaireAutre"
      )
    
    private String nomEtablissementScolaireAutre;

    public void setNomEtablissementScolaireAutre(final String nomEtablissementScolaireAutre) {
        this.nomEtablissementScolaireAutre = nomEtablissementScolaireAutre;
    }

 
    @Column(name="nom_etablissement_scolaire_autre"  )
      
    public String getNomEtablissementScolaireAutre() {
        return this.nomEtablissementScolaireAutre;
    }
  
    
      @NotNull(
        
        
        profiles = {"renseignements"},
        message = "participeActivite"
      )
    
    private Boolean participeActivite;

    public void setParticipeActivite(final Boolean participeActivite) {
        this.participeActivite = participeActivite;
    }

 
    @Column(name="participe_activite"  )
      
    public Boolean getParticipeActivite() {
        return this.participeActivite;
    }
  
    
      @NotNull(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['participeActivite'].test(_this.participeActivite.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"renseignements"},
        message = "precisionActivite"
      )
    
      @NotBlank(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['participeActivite'].test(_this.participeActivite.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"renseignements"},
        message = "precisionActivite"
      )
    
    private String precisionActivite;

    public void setPrecisionActivite(final String precisionActivite) {
        this.precisionActivite = precisionActivite;
    }

 
    @Column(name="precision_activite"  )
      
    public String getPrecisionActivite() {
        return this.precisionActivite;
    }
  
    
      @NotNull(
        
        
          when = "groovy:def active = true;" +
          
            
            "active &= _this.conditions['etudiantTypeEtablissement'].test(_this.etudiantTypeEtablissement.toString());" +
                
              
            
            "return active",
        
        profiles = {"renseignements"},
        message = "precisionEtablissementScolaireAutre"
      )
    
      @NotBlank(
        
        
          when = "groovy:def active = true;" +
          
            
            "active &= _this.conditions['etudiantTypeEtablissement'].test(_this.etudiantTypeEtablissement.toString());" +
                
              
            
            "return active",
        
        profiles = {"renseignements"},
        message = "precisionEtablissementScolaireAutre"
      )
    
    private String precisionEtablissementScolaireAutre;

    public void setPrecisionEtablissementScolaireAutre(final String precisionEtablissementScolaireAutre) {
        this.precisionEtablissementScolaireAutre = precisionEtablissementScolaireAutre;
    }

 
    @Column(name="precision_etablissement_scolaire_autre"  )
      
    public String getPrecisionEtablissementScolaireAutre() {
        return this.precisionEtablissementScolaireAutre;
    }
  
    
      @NotNull(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['situationActuelle'].test('estSalarie='+_this.situationActuelle.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"renseignements"},
        message = "profession"
      )
    
      @NotBlank(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['situationActuelle'].test('estSalarie='+_this.situationActuelle.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"renseignements"},
        message = "profession"
      )
    
    private String profession;

    public void setProfession(final String profession) {
        this.profession = profession;
    }

 
    @Column(name="profession"  )
      
    public String getProfession() {
        return this.profession;
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
    @JoinTable(name="saintouen_cap_jeunesse_adulte_request_secteur_habitation",
            joinColumns=
                @JoinColumn(name="saintouen_cap_jeunesse_adulte_request_id"),
            inverseJoinColumns=
                @JoinColumn(name="secteur_habitation_id"))
    @OrderColumn(name="secteur_habitation_index")
      
    public List<fr.cg95.cvq.business.request.LocalReferentialData> getSecteurHabitation() {
        return this.secteurHabitation;
    }
  
    
      @NotNull(
        
        
        profiles = {"sujet"},
        message = "sexe"
      )
    
    private fr.cg95.cvq.business.request.school.ScjarSexeType sexe;

    public void setSexe(final fr.cg95.cvq.business.request.school.ScjarSexeType sexe) {
        this.sexe = sexe;
    }

 
    @Enumerated(EnumType.STRING)
    @Column(name="sexe"  )
      
    public fr.cg95.cvq.business.request.school.ScjarSexeType getSexe() {
        return this.sexe;
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
        
        
        profiles = {"renseignements"},
        message = "situationActuelle"
      )
    
    private fr.cg95.cvq.business.request.school.ScjarSituationActuelleType situationActuelle;

    public void setSituationActuelle(final fr.cg95.cvq.business.request.school.ScjarSituationActuelleType situationActuelle) {
        this.situationActuelle = situationActuelle;
    }

 
    @Enumerated(EnumType.STRING)
    @Column(name="situation_actuelle"  )
      
    public fr.cg95.cvq.business.request.school.ScjarSituationActuelleType getSituationActuelle() {
        return this.situationActuelle;
    }
  
    
      @NotNull(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['participeActivite'].test(_this.participeActivite.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"renseignements"},
        message = "typeActivite"
      )
    
    private fr.cg95.cvq.business.request.school.ScjarTypeActiviteType typeActivite;

    public void setTypeActivite(final fr.cg95.cvq.business.request.school.ScjarTypeActiviteType typeActivite) {
        this.typeActivite = typeActivite;
    }

 
    @Enumerated(EnumType.STRING)
    @Column(name="type_activite"  )
      
    public fr.cg95.cvq.business.request.school.ScjarTypeActiviteType getTypeActivite() {
        return this.typeActivite;
    }
  
    
      @NotNull(
        
        
        profiles = {"renseignements"},
        message = "typeInscription"
      )
    
    private fr.cg95.cvq.business.request.school.ScjarTypeInscriptionType typeInscription;

    public void setTypeInscription(final fr.cg95.cvq.business.request.school.ScjarTypeInscriptionType typeInscription) {
        this.typeInscription = typeInscription;
    }

 
    @Enumerated(EnumType.STRING)
    @Column(name="type_inscription"  )
      
    public fr.cg95.cvq.business.request.school.ScjarTypeInscriptionType getTypeInscription() {
        return this.typeInscription;
    }
  
}
