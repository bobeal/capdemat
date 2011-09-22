

package fr.cg95.cvq.business.request.election;

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
@Table(name="standard_electoral_roll_registration_request")
public class StandardElectoralRollRegistrationRequestData implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final Map<String, IConditionChecker> conditions =
        new HashMap<String, IConditionChecker>(RequestData.conditions);

    private Long id;

    public StandardElectoralRollRegistrationRequestData() {
      
        nationalite = fr.cg95.cvq.business.request.election.SerrrNationaliteType.FRANCAISE;
      
        situation = fr.cg95.cvq.business.request.election.SerrrSituationType.PREMIERE_INSCRIPTION;
      
        typeElection = fr.cg95.cvq.business.request.election.SerrrTypeElectionType.ELECTION_MUNICIPALE;
      
    }

    @Override
    public StandardElectoralRollRegistrationRequestData clone() {
        StandardElectoralRollRegistrationRequestData result = new StandardElectoralRollRegistrationRequestData();
        
          
            
        result.setAmbassadeOuPosteConsulaire(ambassadeOuPosteConsulaire);
      
          
        
          
            
        result.setAncienneCommune(ancienneCommune);
      
          
        
          
            
        result.setCommuneOuLocalitePrecedente(communeOuLocalitePrecedente);
      
          
        
          
            
        result.setDateNaissance(dateNaissance);
      
          
        
          
            
        if (departementAncienneCommune != null)
            result.setDepartementAncienneCommune(departementAncienneCommune);
        else
            result.setDepartementAncienneCommune(fr.cg95.cvq.business.users.InseeDepartementCodeType.getDefaultInseeDepartementCodeType());
      
          
        
          
            
        if (lieuNaissanceDepartement != null)
            result.setLieuNaissanceDepartement(lieuNaissanceDepartement);
        else
            result.setLieuNaissanceDepartement(fr.cg95.cvq.business.users.InseeDepartementCodeType.getDefaultInseeDepartementCodeType());
      
          
        
          
            
        if (lieuNaissancePays != null)
            result.setLieuNaissancePays(lieuNaissancePays);
        else
            result.setLieuNaissancePays(fr.cg95.cvq.business.users.CountryType.getDefaultCountryType());
      
          
        
          
            
        if (nationalite != null)
            result.setNationalite(nationalite);
        else
            result.setNationalite(fr.cg95.cvq.business.request.election.SerrrNationaliteType.getDefaultSerrrNationaliteType());
      
          
        
          
            
        result.setNomJeuneFille(nomJeuneFille);
      
          
        
          
            
        if (paysPrecedent != null)
            result.setPaysPrecedent(paysPrecedent);
        else
            result.setPaysPrecedent(fr.cg95.cvq.business.users.CountryType.getDefaultCountryType());
      
          
        
          
            
        if (paysRadiation != null)
            result.setPaysRadiation(paysRadiation);
        else
            result.setPaysRadiation(fr.cg95.cvq.business.users.CountryType.getDefaultCountryType());
      
          
        
          
            
        if (precisionNationalite != null)
            result.setPrecisionNationalite(precisionNationalite);
        else
            result.setPrecisionNationalite(fr.cg95.cvq.business.request.election.SerrrPrecisionNationaliteType.getDefaultSerrrPrecisionNationaliteType());
      
          
        
          
            
        if (sexe != null)
            result.setSexe(sexe);
        else
            result.setSexe(fr.cg95.cvq.business.request.election.SerrrSexeType.getDefaultSerrrSexeType());
      
          
        
          
            
        if (situation != null)
            result.setSituation(situation);
        else
            result.setSituation(fr.cg95.cvq.business.request.election.SerrrSituationType.getDefaultSerrrSituationType());
      
          
        
          
            
        result.setSubdivisionAdministrativePrecedente(subdivisionAdministrativePrecedente);
      
          
        
          
            
        if (typeElection != null)
            result.setTypeElection(typeElection);
        else
            result.setTypeElection(fr.cg95.cvq.business.request.election.SerrrTypeElectionType.getDefaultSerrrTypeElectionType());
      
          
        
          
            
        if (typeInscription != null)
            result.setTypeInscription(typeInscription);
        else
            result.setTypeInscription(fr.cg95.cvq.business.request.election.SerrrTypeInscriptionType.getDefaultSerrrTypeInscriptionType());
      
          
        
          
            
        result.setVilleNaissanceCodePostal(villeNaissanceCodePostal);
      
          
        
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

  
    
    private String ambassadeOuPosteConsulaire;

    public void setAmbassadeOuPosteConsulaire(final String ambassadeOuPosteConsulaire) {
        this.ambassadeOuPosteConsulaire = ambassadeOuPosteConsulaire;
    }

 
    @Column(name="ambassade_ou_poste_consulaire"  )
      
    public String getAmbassadeOuPosteConsulaire() {
        return this.ambassadeOuPosteConsulaire;
    }
  
    
      @MaxLength(
        
          value = 32,
        
        
          when = "groovy:def active = true;" +
          
            
            "active &= _this.conditions['situation'].test(_this.situation.toString());" +
                
              
            
            "return active",
        
        profiles = {"situation"},
        message = "ancienneCommune"
      )
    
      @NotNull(
        
        
          when = "groovy:def active = true;" +
          
            
            "active &= _this.conditions['situation'].test(_this.situation.toString());" +
                
              
            
            "return active",
        
        profiles = {"situation"},
        message = "ancienneCommune"
      )
    
      @NotBlank(
        
        
          when = "groovy:def active = true;" +
          
            
            "active &= _this.conditions['situation'].test(_this.situation.toString());" +
                
              
            
            "return active",
        
        profiles = {"situation"},
        message = "ancienneCommune"
      )
    
    private String ancienneCommune;

    public void setAncienneCommune(final String ancienneCommune) {
        this.ancienneCommune = ancienneCommune;
    }

 
    @Column(name="ancienne_commune" , length=32 )
      
    public String getAncienneCommune() {
        return this.ancienneCommune;
    }
  
    
      @MaxLength(
        
          value = 32,
        
        
          when = "groovy:def active = true;" +
          
            
            "active &= _this.conditions['typeElection'].test(_this.typeElection.toString());" +
                
              
            
            "return active",
        
        profiles = {"inscription"},
        message = "communeOuLocalitePrecedente"
      )
    
    private String communeOuLocalitePrecedente;

    public void setCommuneOuLocalitePrecedente(final String communeOuLocalitePrecedente) {
        this.communeOuLocalitePrecedente = communeOuLocalitePrecedente;
    }

 
    @Column(name="commune_ou_localite_precedente" , length=32 )
      
    public String getCommuneOuLocalitePrecedente() {
        return this.communeOuLocalitePrecedente;
    }
  
    
      @NotNull(
        
        
        profiles = {"inscription"},
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
          
            
            "active &= _this.conditions['situation'].test(_this.situation.toString());" +
                
              
            
            "return active",
        
        profiles = {"situation"},
        message = "departementAncienneCommune"
      )
    
    private fr.cg95.cvq.business.users.InseeDepartementCodeType departementAncienneCommune;

    public void setDepartementAncienneCommune(final fr.cg95.cvq.business.users.InseeDepartementCodeType departementAncienneCommune) {
        this.departementAncienneCommune = departementAncienneCommune;
    }

 
    @Enumerated(EnumType.STRING)
    @Column(name="departement_ancienne_commune"  )
      
    public fr.cg95.cvq.business.users.InseeDepartementCodeType getDepartementAncienneCommune() {
        return this.departementAncienneCommune;
    }
  
    
    private fr.cg95.cvq.business.users.InseeDepartementCodeType lieuNaissanceDepartement;

    public void setLieuNaissanceDepartement(final fr.cg95.cvq.business.users.InseeDepartementCodeType lieuNaissanceDepartement) {
        this.lieuNaissanceDepartement = lieuNaissanceDepartement;
    }

 
    @Enumerated(EnumType.STRING)
    @Column(name="lieu_naissance_departement"  )
      
    public fr.cg95.cvq.business.users.InseeDepartementCodeType getLieuNaissanceDepartement() {
        return this.lieuNaissanceDepartement;
    }
  
    
    private fr.cg95.cvq.business.users.CountryType lieuNaissancePays;

    public void setLieuNaissancePays(final fr.cg95.cvq.business.users.CountryType lieuNaissancePays) {
        this.lieuNaissancePays = lieuNaissancePays;
    }

 
    @Enumerated(EnumType.STRING)
    @Column(name="lieu_naissance_pays"  )
      
    public fr.cg95.cvq.business.users.CountryType getLieuNaissancePays() {
        return this.lieuNaissancePays;
    }
  
    
      @NotNull(
        
        
        profiles = {"inscription"},
        message = "nationalite"
      )
    
    private fr.cg95.cvq.business.request.election.SerrrNationaliteType nationalite;

    public void setNationalite(final fr.cg95.cvq.business.request.election.SerrrNationaliteType nationalite) {
        this.nationalite = nationalite;
    }

 
    @Enumerated(EnumType.STRING)
    @Column(name="nationalite"  )
      
    public fr.cg95.cvq.business.request.election.SerrrNationaliteType getNationalite() {
        return this.nationalite;
    }
  
    
      @MaxLength(
        
          value = 38,
        
        
        profiles = {"inscription"},
        message = "nomJeuneFille"
      )
    
    private String nomJeuneFille;

    public void setNomJeuneFille(final String nomJeuneFille) {
        this.nomJeuneFille = nomJeuneFille;
    }

 
    @Column(name="nom_jeune_fille" , length=38 )
      
    public String getNomJeuneFille() {
        return this.nomJeuneFille;
    }
  
    
    private fr.cg95.cvq.business.users.CountryType paysPrecedent;

    public void setPaysPrecedent(final fr.cg95.cvq.business.users.CountryType paysPrecedent) {
        this.paysPrecedent = paysPrecedent;
    }

 
    @Enumerated(EnumType.STRING)
    @Column(name="pays_precedent"  )
      
    public fr.cg95.cvq.business.users.CountryType getPaysPrecedent() {
        return this.paysPrecedent;
    }
  
    
    private fr.cg95.cvq.business.users.CountryType paysRadiation;

    public void setPaysRadiation(final fr.cg95.cvq.business.users.CountryType paysRadiation) {
        this.paysRadiation = paysRadiation;
    }

 
    @Enumerated(EnumType.STRING)
    @Column(name="pays_radiation"  )
      
    public fr.cg95.cvq.business.users.CountryType getPaysRadiation() {
        return this.paysRadiation;
    }
  
    
      @NotNull(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['nationalite'].test(_this.nationalite.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"inscription"},
        message = "precisionNationalite"
      )
    
    private fr.cg95.cvq.business.request.election.SerrrPrecisionNationaliteType precisionNationalite;

    public void setPrecisionNationalite(final fr.cg95.cvq.business.request.election.SerrrPrecisionNationaliteType precisionNationalite) {
        this.precisionNationalite = precisionNationalite;
    }

 
    @Enumerated(EnumType.STRING)
    @Column(name="precision_nationalite"  )
      
    public fr.cg95.cvq.business.request.election.SerrrPrecisionNationaliteType getPrecisionNationalite() {
        return this.precisionNationalite;
    }
  
    
      @NotNull(
        
        
        profiles = {"inscription"},
        message = "sexe"
      )
    
    private fr.cg95.cvq.business.request.election.SerrrSexeType sexe;

    public void setSexe(final fr.cg95.cvq.business.request.election.SerrrSexeType sexe) {
        this.sexe = sexe;
    }

 
    @Enumerated(EnumType.STRING)
    @Column(name="sexe"  )
      
    public fr.cg95.cvq.business.request.election.SerrrSexeType getSexe() {
        return this.sexe;
    }
  
    
      @NotNull(
        
        
        profiles = {"situation"},
        message = "situation"
      )
    
    private fr.cg95.cvq.business.request.election.SerrrSituationType situation;

    public void setSituation(final fr.cg95.cvq.business.request.election.SerrrSituationType situation) {
        this.situation = situation;
    }

 
    @Enumerated(EnumType.STRING)
    @Column(name="situation"  )
      
    public fr.cg95.cvq.business.request.election.SerrrSituationType getSituation() {
        return this.situation;
    }
  
    
    private String subdivisionAdministrativePrecedente;

    public void setSubdivisionAdministrativePrecedente(final String subdivisionAdministrativePrecedente) {
        this.subdivisionAdministrativePrecedente = subdivisionAdministrativePrecedente;
    }

 
    @Column(name="subdivision_administrative_precedente"  )
      
    public String getSubdivisionAdministrativePrecedente() {
        return this.subdivisionAdministrativePrecedente;
    }
  
    
      @NotNull(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['nationalite'].test(_this.nationalite.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"inscription"},
        message = "typeElection"
      )
    
    private fr.cg95.cvq.business.request.election.SerrrTypeElectionType typeElection;

    public void setTypeElection(final fr.cg95.cvq.business.request.election.SerrrTypeElectionType typeElection) {
        this.typeElection = typeElection;
    }

 
    @Enumerated(EnumType.STRING)
    @Column(name="type_election"  )
      
    public fr.cg95.cvq.business.request.election.SerrrTypeElectionType getTypeElection() {
        return this.typeElection;
    }
  
    
    private fr.cg95.cvq.business.request.election.SerrrTypeInscriptionType typeInscription;

    public void setTypeInscription(final fr.cg95.cvq.business.request.election.SerrrTypeInscriptionType typeInscription) {
        this.typeInscription = typeInscription;
    }

 
    @Enumerated(EnumType.STRING)
    @Column(name="type_inscription"  )
      
    public fr.cg95.cvq.business.request.election.SerrrTypeInscriptionType getTypeInscription() {
        return this.typeInscription;
    }
  
    
      @MaxLength(
        
          value = 32,
        
        
        profiles = {"inscription"},
        message = "villeNaissanceCodePostal"
      )
    
      @NotNull(
        
        
        profiles = {"inscription"},
        message = "villeNaissanceCodePostal"
      )
    
      @NotBlank(
        
        
        profiles = {"inscription"},
        message = "villeNaissanceCodePostal"
      )
    
    private String villeNaissanceCodePostal;

    public void setVilleNaissanceCodePostal(final String villeNaissanceCodePostal) {
        this.villeNaissanceCodePostal = villeNaissanceCodePostal;
    }

 
    @Column(name="ville_naissance_code_postal" , length=32 )
      
    public String getVilleNaissanceCodePostal() {
        return this.villeNaissanceCodePostal;
    }
  
}
