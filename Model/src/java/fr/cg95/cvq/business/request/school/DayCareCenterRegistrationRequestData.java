

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
@Table(name="day_care_center_registration_request")
public class DayCareCenterRegistrationRequestData implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final Map<String, IConditionChecker> conditions =
        new HashMap<String, IConditionChecker>(RequestData.conditions);

    private Long id;

    public DayCareCenterRegistrationRequestData() {
      
        estHorairesReguliersMere = Boolean.valueOf(true);
      
        estHorairesReguliersPere = Boolean.valueOf(true);
      
        modeAccueil = Boolean.valueOf(true);
      
    }

    @Override
    public DayCareCenterRegistrationRequestData clone() {
        DayCareCenterRegistrationRequestData result = new DayCareCenterRegistrationRequestData();
        
          
            
        result.setAccueilAnterieur(accueilAnterieur);
      
          
        
          
            
        if (choixHorairesAccueil != null)
            result.setChoixHorairesAccueil(choixHorairesAccueil);
        else
            result.setChoixHorairesAccueil(fr.cg95.cvq.business.request.school.ChoixHorairesAccueilType.getDefaultChoixHorairesAccueilType());
      
          
        
          
            
        if (choixTypeDatePlacementAccueilRegulier != null)
            result.setChoixTypeDatePlacementAccueilRegulier(choixTypeDatePlacementAccueilRegulier);
        else
            result.setChoixTypeDatePlacementAccueilRegulier(fr.cg95.cvq.business.request.school.ChoixDatePlacement.getDefaultChoixDatePlacement());
      
          
        
          
            
        if (choixTypeRendezVous != null)
            result.setChoixTypeRendezVous(choixTypeRendezVous);
        else
            result.setChoixTypeRendezVous(fr.cg95.cvq.business.request.school.RendezVousType.getDefaultRendezVousType());
      
          
        
          
            
        result.setCommentaireCitoyen(commentaireCitoyen);
      
          
        
          
            
        result.setCommuneLieuTravailMere(communeLieuTravailMere);
      
          
        
          
            
        result.setCommuneLieuTravailPere(communeLieuTravailPere);
      
          
        
          
            
        result.setDatePlacementDebut(datePlacementDebut);
      
          
        
          
            
        result.setDixHuitMoisEnfant(dixHuitMoisEnfant);
      
          
        
          
            
        result.setEstHorairesReguliersMere(estHorairesReguliersMere);
      
          
        
          
            
        result.setEstHorairesReguliersPere(estHorairesReguliersPere);
      
          
        
          
            
        result.setHorairePlacementApresMidiDebut(horairePlacementApresMidiDebut);
      
          
        
          
            
        result.setHorairePlacementApresMidiDebutJeudi(horairePlacementApresMidiDebutJeudi);
      
          
        
          
            
        result.setHorairePlacementApresMidiDebutLundi(horairePlacementApresMidiDebutLundi);
      
          
        
          
            
        result.setHorairePlacementApresMidiDebutMardi(horairePlacementApresMidiDebutMardi);
      
          
        
          
            
        result.setHorairePlacementApresMidiDebutMercredi(horairePlacementApresMidiDebutMercredi);
      
          
        
          
            
        result.setHorairePlacementApresMidiDebutVendredi(horairePlacementApresMidiDebutVendredi);
      
          
        
          
            
        result.setHorairePlacementApresMidiFin(horairePlacementApresMidiFin);
      
          
        
          
            
        result.setHorairePlacementApresMidiFinJeudi(horairePlacementApresMidiFinJeudi);
      
          
        
          
            
        result.setHorairePlacementApresMidiFinLundi(horairePlacementApresMidiFinLundi);
      
          
        
          
            
        result.setHorairePlacementApresMidiFinMardi(horairePlacementApresMidiFinMardi);
      
          
        
          
            
        result.setHorairePlacementApresMidiFinMercredi(horairePlacementApresMidiFinMercredi);
      
          
        
          
            
        result.setHorairePlacementApresMidiFinVendredi(horairePlacementApresMidiFinVendredi);
      
          
        
          
            
        result.setHorairePlacementMatinDebut(horairePlacementMatinDebut);
      
          
        
          
            
        result.setHorairePlacementMatinDebutJeudi(horairePlacementMatinDebutJeudi);
      
          
        
          
            
        result.setHorairePlacementMatinDebutLundi(horairePlacementMatinDebutLundi);
      
          
        
          
            
        result.setHorairePlacementMatinDebutMardi(horairePlacementMatinDebutMardi);
      
          
        
          
            
        result.setHorairePlacementMatinDebutMercredi(horairePlacementMatinDebutMercredi);
      
          
        
          
            
        result.setHorairePlacementMatinDebutVendredi(horairePlacementMatinDebutVendredi);
      
          
        
          
            
        result.setHorairePlacementMatinFin(horairePlacementMatinFin);
      
          
        
          
            
        result.setHorairePlacementMatinFinJeudi(horairePlacementMatinFinJeudi);
      
          
        
          
            
        result.setHorairePlacementMatinFinLundi(horairePlacementMatinFinLundi);
      
          
        
          
            
        result.setHorairePlacementMatinFinMardi(horairePlacementMatinFinMardi);
      
          
        
          
            
        result.setHorairePlacementMatinFinMercredi(horairePlacementMatinFinMercredi);
      
          
        
          
            
        result.setHorairePlacementMatinFinVendredi(horairePlacementMatinFinVendredi);
      
          
        
          
            
        result.setHorairesReguliersMere(horairesReguliersMere);
      
          
        
          
            
        result.setHorairesReguliersPere(horairesReguliersPere);
      
          
        
          
            
        result.setHorairesTravailJeudiMere(horairesTravailJeudiMere);
      
          
        
          
            
        result.setHorairesTravailJeudiPere(horairesTravailJeudiPere);
      
          
        
          
            
        result.setHorairesTravailLundiMere(horairesTravailLundiMere);
      
          
        
          
            
        result.setHorairesTravailLundiPere(horairesTravailLundiPere);
      
          
        
          
            
        result.setHorairesTravailMardiMere(horairesTravailMardiMere);
      
          
        
          
            
        result.setHorairesTravailMardiPere(horairesTravailMardiPere);
      
          
        
          
            
        result.setHorairesTravailMercrediMere(horairesTravailMercrediMere);
      
          
        
          
            
        result.setHorairesTravailMercrediPere(horairesTravailMercrediPere);
      
          
        
          
            
        result.setHorairesTravailVendrediMere(horairesTravailVendrediMere);
      
          
        
          
            
        result.setHorairesTravailVendrediPere(horairesTravailVendrediPere);
      
          
        
          
            
        result.setModeAccueil(modeAccueil);
      
          
        
          
            
        if (modeAccueilChoixDeux != null)
            result.setModeAccueilChoixDeux(modeAccueilChoixDeux);
        else
            result.setModeAccueilChoixDeux(fr.cg95.cvq.business.request.school.ModeAccueilType.getDefaultModeAccueilType());
      
          
        
          
            
        if (modeAccueilChoixUn != null)
            result.setModeAccueilChoixUn(modeAccueilChoixUn);
        else
            result.setModeAccueilChoixUn(fr.cg95.cvq.business.request.school.ModeAccueilType.getDefaultModeAccueilType());
      
          
        
          
            
        if (plageHoraireContact != null)
            result.setPlageHoraireContact(plageHoraireContact);
        else
            result.setPlageHoraireContact(fr.cg95.cvq.business.request.school.PlageHoraireContactType.getDefaultPlageHoraireContactType());
      
          
        
          
            
        result.setPrecisionAutreSituationActuelleMere(precisionAutreSituationActuelleMere);
      
          
        
          
            
        result.setPrecisionAutreSituationActuellePere(precisionAutreSituationActuellePere);
      
          
        
          
            
        result.setProfessionMere(professionMere);
      
          
        
          
            
        result.setProfessionPere(professionPere);
      
          
        
          
            
        if (situationActuelleMere != null)
            result.setSituationActuelleMere(situationActuelleMere);
        else
            result.setSituationActuelleMere(fr.cg95.cvq.business.request.school.ChoixSituationActuelle.getDefaultChoixSituationActuelle());
      
          
        
          
            
        if (situationActuellePere != null)
            result.setSituationActuellePere(situationActuellePere);
        else
            result.setSituationActuellePere(fr.cg95.cvq.business.request.school.ChoixSituationActuelle.getDefaultChoixSituationActuelle());
      
          
        
          
            
        result.setTelephoneContact(telephoneContact);
      
          
        
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

  
    
    private String accueilAnterieur;

    public void setAccueilAnterieur(final String accueilAnterieur) {
        this.accueilAnterieur = accueilAnterieur;
    }

 
    @Column(name="accueil_anterieur"  )
      
    public String getAccueilAnterieur() {
        return this.accueilAnterieur;
    }
  
    
      @NotNull(
        
        
        profiles = {"accueil"},
        message = "choixHorairesAccueil"
      )
    
    private fr.cg95.cvq.business.request.school.ChoixHorairesAccueilType choixHorairesAccueil;

    public void setChoixHorairesAccueil(final fr.cg95.cvq.business.request.school.ChoixHorairesAccueilType choixHorairesAccueil) {
        this.choixHorairesAccueil = choixHorairesAccueil;
    }

 
    @Enumerated(EnumType.STRING)
    @Column(name="choix_horaires_accueil"  )
      
    public fr.cg95.cvq.business.request.school.ChoixHorairesAccueilType getChoixHorairesAccueil() {
        return this.choixHorairesAccueil;
    }
  
    
      @NotNull(
        
        
        profiles = {"accueil"},
        message = "choixTypeDatePlacementAccueilRegulier"
      )
    
    private fr.cg95.cvq.business.request.school.ChoixDatePlacement choixTypeDatePlacementAccueilRegulier;

    public void setChoixTypeDatePlacementAccueilRegulier(final fr.cg95.cvq.business.request.school.ChoixDatePlacement choixTypeDatePlacementAccueilRegulier) {
        this.choixTypeDatePlacementAccueilRegulier = choixTypeDatePlacementAccueilRegulier;
    }

 
    @Enumerated(EnumType.STRING)
    @Column(name="choix_type_date_placement_accueil_regulier"  )
      
    public fr.cg95.cvq.business.request.school.ChoixDatePlacement getChoixTypeDatePlacementAccueilRegulier() {
        return this.choixTypeDatePlacementAccueilRegulier;
    }
  
    
      @NotNull(
        
        
        profiles = {"rendezVous"},
        message = "choixTypeRendezVous"
      )
    
    private fr.cg95.cvq.business.request.school.RendezVousType choixTypeRendezVous;

    public void setChoixTypeRendezVous(final fr.cg95.cvq.business.request.school.RendezVousType choixTypeRendezVous) {
        this.choixTypeRendezVous = choixTypeRendezVous;
    }

 
    @Enumerated(EnumType.STRING)
    @Column(name="choix_type_rendez_vous"  )
      
    public fr.cg95.cvq.business.request.school.RendezVousType getChoixTypeRendezVous() {
        return this.choixTypeRendezVous;
    }
  
    
      @MaxLength(
        
          value = 600,
        
        
        profiles = {"rendezVous"},
        message = "commentaireCitoyen"
      )
    
    private String commentaireCitoyen;

    public void setCommentaireCitoyen(final String commentaireCitoyen) {
        this.commentaireCitoyen = commentaireCitoyen;
    }

 
    @Column(name="commentaire_citoyen" , length=600 )
      
    public String getCommentaireCitoyen() {
        return this.commentaireCitoyen;
    }
  
    
    private String communeLieuTravailMere;

    public void setCommuneLieuTravailMere(final String communeLieuTravailMere) {
        this.communeLieuTravailMere = communeLieuTravailMere;
    }

 
    @Column(name="commune_lieu_travail_mere"  )
      
    public String getCommuneLieuTravailMere() {
        return this.communeLieuTravailMere;
    }
  
    
    private String communeLieuTravailPere;

    public void setCommuneLieuTravailPere(final String communeLieuTravailPere) {
        this.communeLieuTravailPere = communeLieuTravailPere;
    }

 
    @Column(name="commune_lieu_travail_pere"  )
      
    public String getCommuneLieuTravailPere() {
        return this.communeLieuTravailPere;
    }
  
    
      @NotNull(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['choixTypeDatePlacementAccueilRegulier'].test(_this.choixTypeDatePlacementAccueilRegulier.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"accueil"},
        message = "datePlacementDebut"
      )
    
    private java.util.Date datePlacementDebut;

    public void setDatePlacementDebut(final java.util.Date datePlacementDebut) {
        this.datePlacementDebut = datePlacementDebut;
    }

 
    @Column(name="date_placement_debut"  )
      
    public java.util.Date getDatePlacementDebut() {
        return this.datePlacementDebut;
    }
  
    
    private java.util.Date dixHuitMoisEnfant;

    public void setDixHuitMoisEnfant(final java.util.Date dixHuitMoisEnfant) {
        this.dixHuitMoisEnfant = dixHuitMoisEnfant;
    }

 
    @Column(name="dix_huit_mois_enfant"  )
      
    public java.util.Date getDixHuitMoisEnfant() {
        return this.dixHuitMoisEnfant;
    }
  
    
    private Boolean estHorairesReguliersMere;

    public void setEstHorairesReguliersMere(final Boolean estHorairesReguliersMere) {
        this.estHorairesReguliersMere = estHorairesReguliersMere;
    }

 
    @Column(name="est_horaires_reguliers_mere"  )
      
    public Boolean getEstHorairesReguliersMere() {
        return this.estHorairesReguliersMere;
    }
  
    
    private Boolean estHorairesReguliersPere;

    public void setEstHorairesReguliersPere(final Boolean estHorairesReguliersPere) {
        this.estHorairesReguliersPere = estHorairesReguliersPere;
    }

 
    @Column(name="est_horaires_reguliers_pere"  )
      
    public Boolean getEstHorairesReguliersPere() {
        return this.estHorairesReguliersPere;
    }
  
    
    private org.joda.time.LocalTime horairePlacementApresMidiDebut;

    public void setHorairePlacementApresMidiDebut(final org.joda.time.LocalTime horairePlacementApresMidiDebut) {
        this.horairePlacementApresMidiDebut = horairePlacementApresMidiDebut;
    }

 
    @Column(name="horaire_placement_apres_midi_debut"  )
      
    public org.joda.time.LocalTime getHorairePlacementApresMidiDebut() {
        return this.horairePlacementApresMidiDebut;
    }
  
    
    private org.joda.time.LocalTime horairePlacementApresMidiDebutJeudi;

    public void setHorairePlacementApresMidiDebutJeudi(final org.joda.time.LocalTime horairePlacementApresMidiDebutJeudi) {
        this.horairePlacementApresMidiDebutJeudi = horairePlacementApresMidiDebutJeudi;
    }

 
    @Column(name="horaire_placement_apres_midi_debut_jeudi"  )
      
    public org.joda.time.LocalTime getHorairePlacementApresMidiDebutJeudi() {
        return this.horairePlacementApresMidiDebutJeudi;
    }
  
    
    private org.joda.time.LocalTime horairePlacementApresMidiDebutLundi;

    public void setHorairePlacementApresMidiDebutLundi(final org.joda.time.LocalTime horairePlacementApresMidiDebutLundi) {
        this.horairePlacementApresMidiDebutLundi = horairePlacementApresMidiDebutLundi;
    }

 
    @Column(name="horaire_placement_apres_midi_debut_lundi"  )
      
    public org.joda.time.LocalTime getHorairePlacementApresMidiDebutLundi() {
        return this.horairePlacementApresMidiDebutLundi;
    }
  
    
    private org.joda.time.LocalTime horairePlacementApresMidiDebutMardi;

    public void setHorairePlacementApresMidiDebutMardi(final org.joda.time.LocalTime horairePlacementApresMidiDebutMardi) {
        this.horairePlacementApresMidiDebutMardi = horairePlacementApresMidiDebutMardi;
    }

 
    @Column(name="horaire_placement_apres_midi_debut_mardi"  )
      
    public org.joda.time.LocalTime getHorairePlacementApresMidiDebutMardi() {
        return this.horairePlacementApresMidiDebutMardi;
    }
  
    
    private org.joda.time.LocalTime horairePlacementApresMidiDebutMercredi;

    public void setHorairePlacementApresMidiDebutMercredi(final org.joda.time.LocalTime horairePlacementApresMidiDebutMercredi) {
        this.horairePlacementApresMidiDebutMercredi = horairePlacementApresMidiDebutMercredi;
    }

 
    @Column(name="horaire_placement_apres_midi_debut_mercredi"  )
      
    public org.joda.time.LocalTime getHorairePlacementApresMidiDebutMercredi() {
        return this.horairePlacementApresMidiDebutMercredi;
    }
  
    
    private org.joda.time.LocalTime horairePlacementApresMidiDebutVendredi;

    public void setHorairePlacementApresMidiDebutVendredi(final org.joda.time.LocalTime horairePlacementApresMidiDebutVendredi) {
        this.horairePlacementApresMidiDebutVendredi = horairePlacementApresMidiDebutVendredi;
    }

 
    @Column(name="horaire_placement_apres_midi_debut_vendredi"  )
      
    public org.joda.time.LocalTime getHorairePlacementApresMidiDebutVendredi() {
        return this.horairePlacementApresMidiDebutVendredi;
    }
  
    
    private org.joda.time.LocalTime horairePlacementApresMidiFin;

    public void setHorairePlacementApresMidiFin(final org.joda.time.LocalTime horairePlacementApresMidiFin) {
        this.horairePlacementApresMidiFin = horairePlacementApresMidiFin;
    }

 
    @Column(name="horaire_placement_apres_midi_fin"  )
      
    public org.joda.time.LocalTime getHorairePlacementApresMidiFin() {
        return this.horairePlacementApresMidiFin;
    }
  
    
    private org.joda.time.LocalTime horairePlacementApresMidiFinJeudi;

    public void setHorairePlacementApresMidiFinJeudi(final org.joda.time.LocalTime horairePlacementApresMidiFinJeudi) {
        this.horairePlacementApresMidiFinJeudi = horairePlacementApresMidiFinJeudi;
    }

 
    @Column(name="horaire_placement_apres_midi_fin_jeudi"  )
      
    public org.joda.time.LocalTime getHorairePlacementApresMidiFinJeudi() {
        return this.horairePlacementApresMidiFinJeudi;
    }
  
    
    private org.joda.time.LocalTime horairePlacementApresMidiFinLundi;

    public void setHorairePlacementApresMidiFinLundi(final org.joda.time.LocalTime horairePlacementApresMidiFinLundi) {
        this.horairePlacementApresMidiFinLundi = horairePlacementApresMidiFinLundi;
    }

 
    @Column(name="horaire_placement_apres_midi_fin_lundi"  )
      
    public org.joda.time.LocalTime getHorairePlacementApresMidiFinLundi() {
        return this.horairePlacementApresMidiFinLundi;
    }
  
    
    private org.joda.time.LocalTime horairePlacementApresMidiFinMardi;

    public void setHorairePlacementApresMidiFinMardi(final org.joda.time.LocalTime horairePlacementApresMidiFinMardi) {
        this.horairePlacementApresMidiFinMardi = horairePlacementApresMidiFinMardi;
    }

 
    @Column(name="horaire_placement_apres_midi_fin_mardi"  )
      
    public org.joda.time.LocalTime getHorairePlacementApresMidiFinMardi() {
        return this.horairePlacementApresMidiFinMardi;
    }
  
    
    private org.joda.time.LocalTime horairePlacementApresMidiFinMercredi;

    public void setHorairePlacementApresMidiFinMercredi(final org.joda.time.LocalTime horairePlacementApresMidiFinMercredi) {
        this.horairePlacementApresMidiFinMercredi = horairePlacementApresMidiFinMercredi;
    }

 
    @Column(name="horaire_placement_apres_midi_fin_mercredi"  )
      
    public org.joda.time.LocalTime getHorairePlacementApresMidiFinMercredi() {
        return this.horairePlacementApresMidiFinMercredi;
    }
  
    
    private org.joda.time.LocalTime horairePlacementApresMidiFinVendredi;

    public void setHorairePlacementApresMidiFinVendredi(final org.joda.time.LocalTime horairePlacementApresMidiFinVendredi) {
        this.horairePlacementApresMidiFinVendredi = horairePlacementApresMidiFinVendredi;
    }

 
    @Column(name="horaire_placement_apres_midi_fin_vendredi"  )
      
    public org.joda.time.LocalTime getHorairePlacementApresMidiFinVendredi() {
        return this.horairePlacementApresMidiFinVendredi;
    }
  
    
    private org.joda.time.LocalTime horairePlacementMatinDebut;

    public void setHorairePlacementMatinDebut(final org.joda.time.LocalTime horairePlacementMatinDebut) {
        this.horairePlacementMatinDebut = horairePlacementMatinDebut;
    }

 
    @Column(name="horaire_placement_matin_debut"  )
      
    public org.joda.time.LocalTime getHorairePlacementMatinDebut() {
        return this.horairePlacementMatinDebut;
    }
  
    
    private org.joda.time.LocalTime horairePlacementMatinDebutJeudi;

    public void setHorairePlacementMatinDebutJeudi(final org.joda.time.LocalTime horairePlacementMatinDebutJeudi) {
        this.horairePlacementMatinDebutJeudi = horairePlacementMatinDebutJeudi;
    }

 
    @Column(name="horaire_placement_matin_debut_jeudi"  )
      
    public org.joda.time.LocalTime getHorairePlacementMatinDebutJeudi() {
        return this.horairePlacementMatinDebutJeudi;
    }
  
    
    private org.joda.time.LocalTime horairePlacementMatinDebutLundi;

    public void setHorairePlacementMatinDebutLundi(final org.joda.time.LocalTime horairePlacementMatinDebutLundi) {
        this.horairePlacementMatinDebutLundi = horairePlacementMatinDebutLundi;
    }

 
    @Column(name="horaire_placement_matin_debut_lundi"  )
      
    public org.joda.time.LocalTime getHorairePlacementMatinDebutLundi() {
        return this.horairePlacementMatinDebutLundi;
    }
  
    
    private org.joda.time.LocalTime horairePlacementMatinDebutMardi;

    public void setHorairePlacementMatinDebutMardi(final org.joda.time.LocalTime horairePlacementMatinDebutMardi) {
        this.horairePlacementMatinDebutMardi = horairePlacementMatinDebutMardi;
    }

 
    @Column(name="horaire_placement_matin_debut_mardi"  )
      
    public org.joda.time.LocalTime getHorairePlacementMatinDebutMardi() {
        return this.horairePlacementMatinDebutMardi;
    }
  
    
    private org.joda.time.LocalTime horairePlacementMatinDebutMercredi;

    public void setHorairePlacementMatinDebutMercredi(final org.joda.time.LocalTime horairePlacementMatinDebutMercredi) {
        this.horairePlacementMatinDebutMercredi = horairePlacementMatinDebutMercredi;
    }

 
    @Column(name="horaire_placement_matin_debut_mercredi"  )
      
    public org.joda.time.LocalTime getHorairePlacementMatinDebutMercredi() {
        return this.horairePlacementMatinDebutMercredi;
    }
  
    
    private org.joda.time.LocalTime horairePlacementMatinDebutVendredi;

    public void setHorairePlacementMatinDebutVendredi(final org.joda.time.LocalTime horairePlacementMatinDebutVendredi) {
        this.horairePlacementMatinDebutVendredi = horairePlacementMatinDebutVendredi;
    }

 
    @Column(name="horaire_placement_matin_debut_vendredi"  )
      
    public org.joda.time.LocalTime getHorairePlacementMatinDebutVendredi() {
        return this.horairePlacementMatinDebutVendredi;
    }
  
    
    private org.joda.time.LocalTime horairePlacementMatinFin;

    public void setHorairePlacementMatinFin(final org.joda.time.LocalTime horairePlacementMatinFin) {
        this.horairePlacementMatinFin = horairePlacementMatinFin;
    }

 
    @Column(name="horaire_placement_matin_fin"  )
      
    public org.joda.time.LocalTime getHorairePlacementMatinFin() {
        return this.horairePlacementMatinFin;
    }
  
    
    private org.joda.time.LocalTime horairePlacementMatinFinJeudi;

    public void setHorairePlacementMatinFinJeudi(final org.joda.time.LocalTime horairePlacementMatinFinJeudi) {
        this.horairePlacementMatinFinJeudi = horairePlacementMatinFinJeudi;
    }

 
    @Column(name="horaire_placement_matin_fin_jeudi"  )
      
    public org.joda.time.LocalTime getHorairePlacementMatinFinJeudi() {
        return this.horairePlacementMatinFinJeudi;
    }
  
    
    private org.joda.time.LocalTime horairePlacementMatinFinLundi;

    public void setHorairePlacementMatinFinLundi(final org.joda.time.LocalTime horairePlacementMatinFinLundi) {
        this.horairePlacementMatinFinLundi = horairePlacementMatinFinLundi;
    }

 
    @Column(name="horaire_placement_matin_fin_lundi"  )
      
    public org.joda.time.LocalTime getHorairePlacementMatinFinLundi() {
        return this.horairePlacementMatinFinLundi;
    }
  
    
    private org.joda.time.LocalTime horairePlacementMatinFinMardi;

    public void setHorairePlacementMatinFinMardi(final org.joda.time.LocalTime horairePlacementMatinFinMardi) {
        this.horairePlacementMatinFinMardi = horairePlacementMatinFinMardi;
    }

 
    @Column(name="horaire_placement_matin_fin_mardi"  )
      
    public org.joda.time.LocalTime getHorairePlacementMatinFinMardi() {
        return this.horairePlacementMatinFinMardi;
    }
  
    
    private org.joda.time.LocalTime horairePlacementMatinFinMercredi;

    public void setHorairePlacementMatinFinMercredi(final org.joda.time.LocalTime horairePlacementMatinFinMercredi) {
        this.horairePlacementMatinFinMercredi = horairePlacementMatinFinMercredi;
    }

 
    @Column(name="horaire_placement_matin_fin_mercredi"  )
      
    public org.joda.time.LocalTime getHorairePlacementMatinFinMercredi() {
        return this.horairePlacementMatinFinMercredi;
    }
  
    
    private org.joda.time.LocalTime horairePlacementMatinFinVendredi;

    public void setHorairePlacementMatinFinVendredi(final org.joda.time.LocalTime horairePlacementMatinFinVendredi) {
        this.horairePlacementMatinFinVendredi = horairePlacementMatinFinVendredi;
    }

 
    @Column(name="horaire_placement_matin_fin_vendredi"  )
      
    public org.joda.time.LocalTime getHorairePlacementMatinFinVendredi() {
        return this.horairePlacementMatinFinVendredi;
    }
  
    
    private String horairesReguliersMere;

    public void setHorairesReguliersMere(final String horairesReguliersMere) {
        this.horairesReguliersMere = horairesReguliersMere;
    }

 
    @Column(name="horaires_reguliers_mere"  )
      
    public String getHorairesReguliersMere() {
        return this.horairesReguliersMere;
    }
  
    
    private String horairesReguliersPere;

    public void setHorairesReguliersPere(final String horairesReguliersPere) {
        this.horairesReguliersPere = horairesReguliersPere;
    }

 
    @Column(name="horaires_reguliers_pere"  )
      
    public String getHorairesReguliersPere() {
        return this.horairesReguliersPere;
    }
  
    
    private String horairesTravailJeudiMere;

    public void setHorairesTravailJeudiMere(final String horairesTravailJeudiMere) {
        this.horairesTravailJeudiMere = horairesTravailJeudiMere;
    }

 
    @Column(name="horaires_travail_jeudi_mere"  )
      
    public String getHorairesTravailJeudiMere() {
        return this.horairesTravailJeudiMere;
    }
  
    
    private String horairesTravailJeudiPere;

    public void setHorairesTravailJeudiPere(final String horairesTravailJeudiPere) {
        this.horairesTravailJeudiPere = horairesTravailJeudiPere;
    }

 
    @Column(name="horaires_travail_jeudi_pere"  )
      
    public String getHorairesTravailJeudiPere() {
        return this.horairesTravailJeudiPere;
    }
  
    
    private String horairesTravailLundiMere;

    public void setHorairesTravailLundiMere(final String horairesTravailLundiMere) {
        this.horairesTravailLundiMere = horairesTravailLundiMere;
    }

 
    @Column(name="horaires_travail_lundi_mere"  )
      
    public String getHorairesTravailLundiMere() {
        return this.horairesTravailLundiMere;
    }
  
    
    private String horairesTravailLundiPere;

    public void setHorairesTravailLundiPere(final String horairesTravailLundiPere) {
        this.horairesTravailLundiPere = horairesTravailLundiPere;
    }

 
    @Column(name="horaires_travail_lundi_pere"  )
      
    public String getHorairesTravailLundiPere() {
        return this.horairesTravailLundiPere;
    }
  
    
    private String horairesTravailMardiMere;

    public void setHorairesTravailMardiMere(final String horairesTravailMardiMere) {
        this.horairesTravailMardiMere = horairesTravailMardiMere;
    }

 
    @Column(name="horaires_travail_mardi_mere"  )
      
    public String getHorairesTravailMardiMere() {
        return this.horairesTravailMardiMere;
    }
  
    
    private String horairesTravailMardiPere;

    public void setHorairesTravailMardiPere(final String horairesTravailMardiPere) {
        this.horairesTravailMardiPere = horairesTravailMardiPere;
    }

 
    @Column(name="horaires_travail_mardi_pere"  )
      
    public String getHorairesTravailMardiPere() {
        return this.horairesTravailMardiPere;
    }
  
    
    private String horairesTravailMercrediMere;

    public void setHorairesTravailMercrediMere(final String horairesTravailMercrediMere) {
        this.horairesTravailMercrediMere = horairesTravailMercrediMere;
    }

 
    @Column(name="horaires_travail_mercredi_mere"  )
      
    public String getHorairesTravailMercrediMere() {
        return this.horairesTravailMercrediMere;
    }
  
    
    private String horairesTravailMercrediPere;

    public void setHorairesTravailMercrediPere(final String horairesTravailMercrediPere) {
        this.horairesTravailMercrediPere = horairesTravailMercrediPere;
    }

 
    @Column(name="horaires_travail_mercredi_pere"  )
      
    public String getHorairesTravailMercrediPere() {
        return this.horairesTravailMercrediPere;
    }
  
    
    private String horairesTravailVendrediMere;

    public void setHorairesTravailVendrediMere(final String horairesTravailVendrediMere) {
        this.horairesTravailVendrediMere = horairesTravailVendrediMere;
    }

 
    @Column(name="horaires_travail_vendredi_mere"  )
      
    public String getHorairesTravailVendrediMere() {
        return this.horairesTravailVendrediMere;
    }
  
    
    private String horairesTravailVendrediPere;

    public void setHorairesTravailVendrediPere(final String horairesTravailVendrediPere) {
        this.horairesTravailVendrediPere = horairesTravailVendrediPere;
    }

 
    @Column(name="horaires_travail_vendredi_pere"  )
      
    public String getHorairesTravailVendrediPere() {
        return this.horairesTravailVendrediPere;
    }
  
    
      @NotNull(
        
        
        profiles = {"accueil"},
        message = "modeAccueil"
      )
    
    private Boolean modeAccueil;

    public void setModeAccueil(final Boolean modeAccueil) {
        this.modeAccueil = modeAccueil;
    }

 
    @Column(name="mode_accueil"  )
      
    public Boolean getModeAccueil() {
        return this.modeAccueil;
    }
  
    
    private fr.cg95.cvq.business.request.school.ModeAccueilType modeAccueilChoixDeux;

    public void setModeAccueilChoixDeux(final fr.cg95.cvq.business.request.school.ModeAccueilType modeAccueilChoixDeux) {
        this.modeAccueilChoixDeux = modeAccueilChoixDeux;
    }

 
    @Enumerated(EnumType.STRING)
    @Column(name="mode_accueil_choix_deux"  )
      
    public fr.cg95.cvq.business.request.school.ModeAccueilType getModeAccueilChoixDeux() {
        return this.modeAccueilChoixDeux;
    }
  
    
      @NotNull(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['modeAccueil'].test(_this.modeAccueil.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"accueil"},
        message = "modeAccueilChoixUn"
      )
    
    private fr.cg95.cvq.business.request.school.ModeAccueilType modeAccueilChoixUn;

    public void setModeAccueilChoixUn(final fr.cg95.cvq.business.request.school.ModeAccueilType modeAccueilChoixUn) {
        this.modeAccueilChoixUn = modeAccueilChoixUn;
    }

 
    @Enumerated(EnumType.STRING)
    @Column(name="mode_accueil_choix_un"  )
      
    public fr.cg95.cvq.business.request.school.ModeAccueilType getModeAccueilChoixUn() {
        return this.modeAccueilChoixUn;
    }
  
    
      @NotNull(
        
        
        profiles = {"rendezVous"},
        message = "plageHoraireContact"
      )
    
    private fr.cg95.cvq.business.request.school.PlageHoraireContactType plageHoraireContact;

    public void setPlageHoraireContact(final fr.cg95.cvq.business.request.school.PlageHoraireContactType plageHoraireContact) {
        this.plageHoraireContact = plageHoraireContact;
    }

 
    @Enumerated(EnumType.STRING)
    @Column(name="plage_horaire_contact"  )
      
    public fr.cg95.cvq.business.request.school.PlageHoraireContactType getPlageHoraireContact() {
        return this.plageHoraireContact;
    }
  
    
      @NotNull(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['situationActuelleMere'].test(_this.situationActuelleMere.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"subject"},
        message = "precisionAutreSituationActuelleMere"
      )
    
      @NotBlank(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['situationActuelleMere'].test(_this.situationActuelleMere.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"subject"},
        message = "precisionAutreSituationActuelleMere"
      )
    
    private String precisionAutreSituationActuelleMere;

    public void setPrecisionAutreSituationActuelleMere(final String precisionAutreSituationActuelleMere) {
        this.precisionAutreSituationActuelleMere = precisionAutreSituationActuelleMere;
    }

 
    @Column(name="precision_autre_situation_actuelle_mere"  )
      
    public String getPrecisionAutreSituationActuelleMere() {
        return this.precisionAutreSituationActuelleMere;
    }
  
    
      @NotNull(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['situationActuellePere'].test(_this.situationActuellePere.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"subject"},
        message = "precisionAutreSituationActuellePere"
      )
    
      @NotBlank(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['situationActuellePere'].test(_this.situationActuellePere.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"subject"},
        message = "precisionAutreSituationActuellePere"
      )
    
    private String precisionAutreSituationActuellePere;

    public void setPrecisionAutreSituationActuellePere(final String precisionAutreSituationActuellePere) {
        this.precisionAutreSituationActuellePere = precisionAutreSituationActuellePere;
    }

 
    @Column(name="precision_autre_situation_actuelle_pere"  )
      
    public String getPrecisionAutreSituationActuellePere() {
        return this.precisionAutreSituationActuellePere;
    }
  
    
    private String professionMere;

    public void setProfessionMere(final String professionMere) {
        this.professionMere = professionMere;
    }

 
    @Column(name="profession_mere"  )
      
    public String getProfessionMere() {
        return this.professionMere;
    }
  
    
    private String professionPere;

    public void setProfessionPere(final String professionPere) {
        this.professionPere = professionPere;
    }

 
    @Column(name="profession_pere"  )
      
    public String getProfessionPere() {
        return this.professionPere;
    }
  
    
    private fr.cg95.cvq.business.request.school.ChoixSituationActuelle situationActuelleMere;

    public void setSituationActuelleMere(final fr.cg95.cvq.business.request.school.ChoixSituationActuelle situationActuelleMere) {
        this.situationActuelleMere = situationActuelleMere;
    }

 
    @Enumerated(EnumType.STRING)
    @Column(name="situation_actuelle_mere"  )
      
    public fr.cg95.cvq.business.request.school.ChoixSituationActuelle getSituationActuelleMere() {
        return this.situationActuelleMere;
    }
  
    
    private fr.cg95.cvq.business.request.school.ChoixSituationActuelle situationActuellePere;

    public void setSituationActuellePere(final fr.cg95.cvq.business.request.school.ChoixSituationActuelle situationActuellePere) {
        this.situationActuellePere = situationActuellePere;
    }

 
    @Enumerated(EnumType.STRING)
    @Column(name="situation_actuelle_pere"  )
      
    public fr.cg95.cvq.business.request.school.ChoixSituationActuelle getSituationActuellePere() {
        return this.situationActuellePere;
    }
  
    
      @MaxLength(
        
          value = 10,
        
        
        profiles = {"rendezVous"},
        message = "telephoneContact"
      )
    
      @NotNull(
        
        
        profiles = {"rendezVous"},
        message = "telephoneContact"
      )
    
      @NotBlank(
        
        
        profiles = {"rendezVous"},
        message = "telephoneContact"
      )
    
    private String telephoneContact;

    public void setTelephoneContact(final String telephoneContact) {
        this.telephoneContact = telephoneContact;
    }

 
    @Column(name="telephone_contact" , length=10 )
      
    public String getTelephoneContact() {
        return this.telephoneContact;
    }
  
}
