

package fr.cg95.cvq.business.request.social;

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
@Table(name="sports_associations_grant_request")
public class SportsAssociationsGrantRequestData implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final Map<String, IConditionChecker> conditions =
        new HashMap<String, IConditionChecker>(RequestData.conditions);

    private Long id;

    public SportsAssociationsGrantRequestData() {
      
        estAdresseCorrespondantPrincipal = Boolean.valueOf(true);
      
        roleDemandeur = fr.cg95.cvq.business.request.social.SagrRoleAssociationType.PRESIDENT;
      
    }

    @Override
    public SportsAssociationsGrantRequestData clone() {
        SportsAssociationsGrantRequestData result = new SportsAssociationsGrantRequestData();
        
          
            
        List<fr.cg95.cvq.business.request.social.SagrActiviteAssociation> activiteAssociationList = new ArrayList<fr.cg95.cvq.business.request.social.SagrActiviteAssociation>();
        for (SagrActiviteAssociation object : activiteAssociation) {
            activiteAssociationList.add(object.clone());
        }
        result.setActiviteAssociation(activiteAssociationList);
      
          
        
          
            
        if (adresseCorrespondantPrincipal != null)
            result.setAdresseCorrespondantPrincipal(adresseCorrespondantPrincipal.clone());
      
          
        
          
            
        List<fr.cg95.cvq.business.request.social.SagrMembreBureau> autreMembreBureauList = new ArrayList<fr.cg95.cvq.business.request.social.SagrMembreBureau>();
        for (SagrMembreBureau object : autreMembreBureau) {
            autreMembreBureauList.add(object.clone());
        }
        result.setAutreMembreBureau(autreMembreBureauList);
      
          
        
          
            
        result.setBudgetSaisonEcouleeDepenses(budgetSaisonEcouleeDepenses);
      
          
        
          
            
        result.setBudgetSaisonEcouleeRecette(budgetSaisonEcouleeRecette);
      
          
        
          
            
        result.setCommuneAnneeN(communeAnneeN);
      
          
        
          
            
        result.setCommuneAnneeNPlusUn(communeAnneeNPlusUn);
      
          
        
          
            
        if (compteBancaire != null)
            result.setCompteBancaire(compteBancaire.clone());
      
          
        
          
            
        result.setEmailClubOuCorrespondant(emailClubOuCorrespondant);
      
          
        
          
            
        result.setEmailPresident(emailPresident);
      
          
        
          
            
        result.setEstAdresseCorrespondantPrincipal(estAdresseCorrespondantPrincipal);
      
          
        
          
            
        result.setMontantSubvention(montantSubvention);
      
          
        
          
            
        result.setNomAssociation(nomAssociation);
      
          
        
          
            
        result.setNomCompletCorrespondantPrincipal(nomCompletCorrespondantPrincipal);
      
          
        
          
            
        result.setNomPresident(nomPresident);
      
          
        
          
            
        result.setNombreLicencieMoinsDixHuitSaisonEcoulee(nombreLicencieMoinsDixHuitSaisonEcoulee);
      
          
        
          
            
        result.setNombreLicenciePlusDixHuitSaisonEcoulee(nombreLicenciePlusDixHuitSaisonEcoulee);
      
          
        
          
            
        result.setNumeroEnregistrementAssociation(numeroEnregistrementAssociation);
      
          
        
          
            
        result.setNumeroEnregistrementPrefectureAssociation(numeroEnregistrementPrefectureAssociation);
      
          
        
          
            
        result.setNumeroSiretAssociation(numeroSiretAssociation);
      
          
        
          
            
        result.setPrenomPresident(prenomPresident);
      
          
        
          
            
        if (roleDemandeur != null)
            result.setRoleDemandeur(roleDemandeur);
        else
            result.setRoleDemandeur(fr.cg95.cvq.business.request.social.SagrRoleAssociationType.getDefaultSagrRoleAssociationType());
      
          
        
          
            
        if (siegeSocialAssociation != null)
            result.setSiegeSocialAssociation(siegeSocialAssociation.clone());
      
          
        
          
            
        result.setSubventionObtenueConseilGeneralSaisonEcoulee(subventionObtenueConseilGeneralSaisonEcoulee);
      
          
        
          
            
        result.setSubventionSolliciteConseilGeneral(subventionSolliciteConseilGeneral);
      
          
        
          
            
        result.setTelephonePresident(telephonePresident);
      
          
        
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

  
    
      @AssertValid(
        
        
        profiles = {"activites"},
        message = "activiteAssociation"
      )
    
      @MinSize(
        
          value = 1,
        
        
        profiles = {"activites"},
        message = "activiteAssociation"
      )
    
    private List<fr.cg95.cvq.business.request.social.SagrActiviteAssociation> activiteAssociation;

    public void setActiviteAssociation(final List<fr.cg95.cvq.business.request.social.SagrActiviteAssociation> activiteAssociation) {
        this.activiteAssociation = activiteAssociation;
    }

 
    @OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
    @OrderColumn(name="activite_association_index")
    @JoinColumn(name="sports_associations_grant_request_id")
      
    public List<fr.cg95.cvq.business.request.social.SagrActiviteAssociation> getActiviteAssociation() {
        return this.activiteAssociation;
    }
  
    
      @NotNull(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['estAdresseCorrespondantPrincipal'].test(_this.estAdresseCorrespondantPrincipal.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"association"},
        message = "adresseCorrespondantPrincipal"
      )
    
      @AssertValid(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['estAdresseCorrespondantPrincipal'].test(_this.estAdresseCorrespondantPrincipal.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"association"},
        message = "adresseCorrespondantPrincipal"
      )
    
    private fr.cg95.cvq.business.users.Address adresseCorrespondantPrincipal;

    public void setAdresseCorrespondantPrincipal(final fr.cg95.cvq.business.users.Address adresseCorrespondantPrincipal) {
        this.adresseCorrespondantPrincipal = adresseCorrespondantPrincipal;
    }

 
    @ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinColumn(name="adresse_correspondant_principal_id")
      
    public fr.cg95.cvq.business.users.Address getAdresseCorrespondantPrincipal() {
        return this.adresseCorrespondantPrincipal;
    }
  
    
      @AssertValid(
        
        
        profiles = {"bureau"},
        message = "autreMembreBureau"
      )
    
    private List<fr.cg95.cvq.business.request.social.SagrMembreBureau> autreMembreBureau;

    public void setAutreMembreBureau(final List<fr.cg95.cvq.business.request.social.SagrMembreBureau> autreMembreBureau) {
        this.autreMembreBureau = autreMembreBureau;
    }

 
    @OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
    @OrderColumn(name="autre_membre_bureau_index")
    @JoinColumn(name="sports_associations_grant_request_id")
      
    public List<fr.cg95.cvq.business.request.social.SagrMembreBureau> getAutreMembreBureau() {
        return this.autreMembreBureau;
    }
  
    
    private String budgetSaisonEcouleeDepenses;

    public void setBudgetSaisonEcouleeDepenses(final String budgetSaisonEcouleeDepenses) {
        this.budgetSaisonEcouleeDepenses = budgetSaisonEcouleeDepenses;
    }

 
    @Column(name="budget_saison_ecoulee_depenses"  )
      
    public String getBudgetSaisonEcouleeDepenses() {
        return this.budgetSaisonEcouleeDepenses;
    }
  
    
    private String budgetSaisonEcouleeRecette;

    public void setBudgetSaisonEcouleeRecette(final String budgetSaisonEcouleeRecette) {
        this.budgetSaisonEcouleeRecette = budgetSaisonEcouleeRecette;
    }

 
    @Column(name="budget_saison_ecoulee_recette"  )
      
    public String getBudgetSaisonEcouleeRecette() {
        return this.budgetSaisonEcouleeRecette;
    }
  
    
    private String communeAnneeN;

    public void setCommuneAnneeN(final String communeAnneeN) {
        this.communeAnneeN = communeAnneeN;
    }

 
    @Column(name="commune_annee_n"  )
      
    public String getCommuneAnneeN() {
        return this.communeAnneeN;
    }
  
    
    private String communeAnneeNPlusUn;

    public void setCommuneAnneeNPlusUn(final String communeAnneeNPlusUn) {
        this.communeAnneeNPlusUn = communeAnneeNPlusUn;
    }

 
    @Column(name="commune_annee_n_plus_un"  )
      
    public String getCommuneAnneeNPlusUn() {
        return this.communeAnneeNPlusUn;
    }
  
    
      @NotNull(
        
        
        profiles = {"subvention"},
        message = "compteBancaire"
      )
    
      @AssertValid(
        
        
        profiles = {"subvention"},
        message = "compteBancaire"
      )
    
    private fr.cg95.cvq.business.users.BankAccount compteBancaire;

    public void setCompteBancaire(final fr.cg95.cvq.business.users.BankAccount compteBancaire) {
        this.compteBancaire = compteBancaire;
    }

 
    @ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinColumn(name="compte_bancaire_id")
      
    public fr.cg95.cvq.business.users.BankAccount getCompteBancaire() {
        return this.compteBancaire;
    }
  
    
    private String emailClubOuCorrespondant;

    public void setEmailClubOuCorrespondant(final String emailClubOuCorrespondant) {
        this.emailClubOuCorrespondant = emailClubOuCorrespondant;
    }

 
    @Column(name="email_club_ou_correspondant"  )
      
    public String getEmailClubOuCorrespondant() {
        return this.emailClubOuCorrespondant;
    }
  
    
    private String emailPresident;

    public void setEmailPresident(final String emailPresident) {
        this.emailPresident = emailPresident;
    }

 
    @Column(name="email_president"  )
      
    public String getEmailPresident() {
        return this.emailPresident;
    }
  
    
      @NotNull(
        
        
        profiles = {"association"},
        message = "estAdresseCorrespondantPrincipal"
      )
    
    private Boolean estAdresseCorrespondantPrincipal;

    public void setEstAdresseCorrespondantPrincipal(final Boolean estAdresseCorrespondantPrincipal) {
        this.estAdresseCorrespondantPrincipal = estAdresseCorrespondantPrincipal;
    }

 
    @Column(name="est_adresse_correspondant_principal"  )
      
    public Boolean getEstAdresseCorrespondantPrincipal() {
        return this.estAdresseCorrespondantPrincipal;
    }
  
    
      @NotNull(
        
        
        profiles = {"administration"},
        message = "montantSubvention"
      )
    
      @NotBlank(
        
        
        profiles = {"administration"},
        message = "montantSubvention"
      )
    
    private String montantSubvention;

    public void setMontantSubvention(final String montantSubvention) {
        this.montantSubvention = montantSubvention;
    }

 
    @Column(name="montant_subvention"  )
      
    public String getMontantSubvention() {
        return this.montantSubvention;
    }
  
    
      @NotNull(
        
        
        profiles = {"association"},
        message = "nomAssociation"
      )
    
      @NotBlank(
        
        
        profiles = {"association"},
        message = "nomAssociation"
      )
    
    private String nomAssociation;

    public void setNomAssociation(final String nomAssociation) {
        this.nomAssociation = nomAssociation;
    }

 
    @Column(name="nom_association"  )
      
    public String getNomAssociation() {
        return this.nomAssociation;
    }
  
    
      @NotNull(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['estAdresseCorrespondantPrincipal'].test(_this.estAdresseCorrespondantPrincipal.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"association"},
        message = "nomCompletCorrespondantPrincipal"
      )
    
      @NotBlank(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['estAdresseCorrespondantPrincipal'].test(_this.estAdresseCorrespondantPrincipal.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"association"},
        message = "nomCompletCorrespondantPrincipal"
      )
    
    private String nomCompletCorrespondantPrincipal;

    public void setNomCompletCorrespondantPrincipal(final String nomCompletCorrespondantPrincipal) {
        this.nomCompletCorrespondantPrincipal = nomCompletCorrespondantPrincipal;
    }

 
    @Column(name="nom_complet_correspondant_principal"  )
      
    public String getNomCompletCorrespondantPrincipal() {
        return this.nomCompletCorrespondantPrincipal;
    }
  
    
      @MaxLength(
        
          value = 38,
        
        
          when = "groovy:def active = true;" +
          
            
            "active &= !_this.conditions['roleDemandeur'].test(_this.roleDemandeur.toString());" +
                
              
            
            "return active",
        
        profiles = {"bureau"},
        message = "nomPresident"
      )
    
      @NotNull(
        
        
          when = "groovy:def active = true;" +
          
            
            "active &= !_this.conditions['roleDemandeur'].test(_this.roleDemandeur.toString());" +
                
              
            
            "return active",
        
        profiles = {"bureau"},
        message = "nomPresident"
      )
    
      @NotBlank(
        
        
          when = "groovy:def active = true;" +
          
            
            "active &= !_this.conditions['roleDemandeur'].test(_this.roleDemandeur.toString());" +
                
              
            
            "return active",
        
        profiles = {"bureau"},
        message = "nomPresident"
      )
    
    private String nomPresident;

    public void setNomPresident(final String nomPresident) {
        this.nomPresident = nomPresident;
    }

 
    @Column(name="nom_president" , length=38 )
      
    public String getNomPresident() {
        return this.nomPresident;
    }
  
    
    private String nombreLicencieMoinsDixHuitSaisonEcoulee;

    public void setNombreLicencieMoinsDixHuitSaisonEcoulee(final String nombreLicencieMoinsDixHuitSaisonEcoulee) {
        this.nombreLicencieMoinsDixHuitSaisonEcoulee = nombreLicencieMoinsDixHuitSaisonEcoulee;
    }

 
    @Column(name="nombre_licencie_moins_dix_huit_saison_ecoulee"  )
      
    public String getNombreLicencieMoinsDixHuitSaisonEcoulee() {
        return this.nombreLicencieMoinsDixHuitSaisonEcoulee;
    }
  
    
    private String nombreLicenciePlusDixHuitSaisonEcoulee;

    public void setNombreLicenciePlusDixHuitSaisonEcoulee(final String nombreLicenciePlusDixHuitSaisonEcoulee) {
        this.nombreLicenciePlusDixHuitSaisonEcoulee = nombreLicenciePlusDixHuitSaisonEcoulee;
    }

 
    @Column(name="nombre_licencie_plus_dix_huit_saison_ecoulee"  )
      
    public String getNombreLicenciePlusDixHuitSaisonEcoulee() {
        return this.nombreLicenciePlusDixHuitSaisonEcoulee;
    }
  
    
      @NotNull(
        
        
        profiles = {"administration"},
        message = "numeroEnregistrementAssociation"
      )
    
      @NotBlank(
        
        
        profiles = {"administration"},
        message = "numeroEnregistrementAssociation"
      )
    
    private String numeroEnregistrementAssociation;

    public void setNumeroEnregistrementAssociation(final String numeroEnregistrementAssociation) {
        this.numeroEnregistrementAssociation = numeroEnregistrementAssociation;
    }

 
    @Column(name="numero_enregistrement_association"  )
      
    public String getNumeroEnregistrementAssociation() {
        return this.numeroEnregistrementAssociation;
    }
  
    
      @MaxLength(
        
          value = 9,
        
        
        profiles = {"association"},
        message = "numeroEnregistrementPrefectureAssociation"
      )
    
      @NotNull(
        
        
        profiles = {"association"},
        message = "numeroEnregistrementPrefectureAssociation"
      )
    
      @MatchPattern(
        
          pattern = "^[\\w\\W]{0,9}$",
        
        
        profiles = {"association"},
        message = "numeroEnregistrementPrefectureAssociation"
      )
    
      @NotBlank(
        
        
        profiles = {"association"},
        message = "numeroEnregistrementPrefectureAssociation"
      )
    
    private String numeroEnregistrementPrefectureAssociation;

    public void setNumeroEnregistrementPrefectureAssociation(final String numeroEnregistrementPrefectureAssociation) {
        this.numeroEnregistrementPrefectureAssociation = numeroEnregistrementPrefectureAssociation;
    }

 
    @Column(name="numero_enregistrement_prefecture_association" , length=9 )
      
    public String getNumeroEnregistrementPrefectureAssociation() {
        return this.numeroEnregistrementPrefectureAssociation;
    }
  
    
      @MaxLength(
        
          value = 14,
        
        
        profiles = {"association"},
        message = "numeroSiretAssociation"
      )
    
      @NotNull(
        
        
        profiles = {"association"},
        message = "numeroSiretAssociation"
      )
    
      @MatchPattern(
        
          pattern = "^[\\w\\W]{0,14}$",
        
        
        profiles = {"association"},
        message = "numeroSiretAssociation"
      )
    
      @NotBlank(
        
        
        profiles = {"association"},
        message = "numeroSiretAssociation"
      )
    
    private String numeroSiretAssociation;

    public void setNumeroSiretAssociation(final String numeroSiretAssociation) {
        this.numeroSiretAssociation = numeroSiretAssociation;
    }

 
    @Column(name="numero_siret_association" , length=14 )
      
    public String getNumeroSiretAssociation() {
        return this.numeroSiretAssociation;
    }
  
    
      @MaxLength(
        
          value = 38,
        
        
          when = "groovy:def active = true;" +
          
            
            "active &= !_this.conditions['roleDemandeur'].test(_this.roleDemandeur.toString());" +
                
              
            
            "return active",
        
        profiles = {"bureau"},
        message = "prenomPresident"
      )
    
      @NotNull(
        
        
          when = "groovy:def active = true;" +
          
            
            "active &= !_this.conditions['roleDemandeur'].test(_this.roleDemandeur.toString());" +
                
              
            
            "return active",
        
        profiles = {"bureau"},
        message = "prenomPresident"
      )
    
      @NotBlank(
        
        
          when = "groovy:def active = true;" +
          
            
            "active &= !_this.conditions['roleDemandeur'].test(_this.roleDemandeur.toString());" +
                
              
            
            "return active",
        
        profiles = {"bureau"},
        message = "prenomPresident"
      )
    
    private String prenomPresident;

    public void setPrenomPresident(final String prenomPresident) {
        this.prenomPresident = prenomPresident;
    }

 
    @Column(name="prenom_president" , length=38 )
      
    public String getPrenomPresident() {
        return this.prenomPresident;
    }
  
    
      @NotNull(
        
        
        profiles = {"bureau"},
        message = "roleDemandeur"
      )
    
    private fr.cg95.cvq.business.request.social.SagrRoleAssociationType roleDemandeur;

    public void setRoleDemandeur(final fr.cg95.cvq.business.request.social.SagrRoleAssociationType roleDemandeur) {
        this.roleDemandeur = roleDemandeur;
    }

 
    @Enumerated(EnumType.STRING)
    @Column(name="role_demandeur"  )
      
    public fr.cg95.cvq.business.request.social.SagrRoleAssociationType getRoleDemandeur() {
        return this.roleDemandeur;
    }
  
    
      @NotNull(
        
        
        profiles = {"association"},
        message = "siegeSocialAssociation"
      )
    
      @AssertValid(
        
        
        profiles = {"association"},
        message = "siegeSocialAssociation"
      )
    
    private fr.cg95.cvq.business.users.Address siegeSocialAssociation;

    public void setSiegeSocialAssociation(final fr.cg95.cvq.business.users.Address siegeSocialAssociation) {
        this.siegeSocialAssociation = siegeSocialAssociation;
    }

 
    @ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinColumn(name="siege_social_association_id")
      
    public fr.cg95.cvq.business.users.Address getSiegeSocialAssociation() {
        return this.siegeSocialAssociation;
    }
  
    
    private String subventionObtenueConseilGeneralSaisonEcoulee;

    public void setSubventionObtenueConseilGeneralSaisonEcoulee(final String subventionObtenueConseilGeneralSaisonEcoulee) {
        this.subventionObtenueConseilGeneralSaisonEcoulee = subventionObtenueConseilGeneralSaisonEcoulee;
    }

 
    @Column(name="subvention_obtenue_conseil_general_saison_ecoulee"  )
      
    public String getSubventionObtenueConseilGeneralSaisonEcoulee() {
        return this.subventionObtenueConseilGeneralSaisonEcoulee;
    }
  
    
      @NotNull(
        
        
        profiles = {"subvention"},
        message = "subventionSolliciteConseilGeneral"
      )
    
      @NotBlank(
        
        
        profiles = {"subvention"},
        message = "subventionSolliciteConseilGeneral"
      )
    
    private String subventionSolliciteConseilGeneral;

    public void setSubventionSolliciteConseilGeneral(final String subventionSolliciteConseilGeneral) {
        this.subventionSolliciteConseilGeneral = subventionSolliciteConseilGeneral;
    }

 
    @Column(name="subvention_sollicite_conseil_general"  )
      
    public String getSubventionSolliciteConseilGeneral() {
        return this.subventionSolliciteConseilGeneral;
    }
  
    
      @MaxLength(
        
          value = 10,
        
        
          when = "groovy:def active = true;" +
          
            
            "active &= !_this.conditions['roleDemandeur'].test(_this.roleDemandeur.toString());" +
                
              
            
            "return active",
        
        profiles = {"bureau"},
        message = "telephonePresident"
      )
    
    private String telephonePresident;

    public void setTelephonePresident(final String telephonePresident) {
        this.telephonePresident = telephonePresident;
    }

 
    @Column(name="telephone_president" , length=10 )
      
    public String getTelephonePresident() {
        return this.telephonePresident;
    }
  
}
