
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
 *  table="day_care_center_registration_request"
 *  lazy="false"
 */
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
      
          
        
          
            
        result.setDatePlacementFin(datePlacementFin);
      
          
        
          
            
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

    /**
     * @hibernate.id
     *  column="id"
     *  generator-class="sequence"
     */
    public final Long getId() {
        return this.id;
    }

  
    
    private String accueilAnterieur;

    public final void setAccueilAnterieur(final String accueilAnterieur) {
        this.accueilAnterieur = accueilAnterieur;
    }

    /**
 
        * @hibernate.property
        *  column="accueil_anterieur"
        
      
    */
    public final String getAccueilAnterieur() {
        return this.accueilAnterieur;
    }
  
    
      @NotNull(
        
        
        profiles = {"accueil"},
        message = "choixHorairesAccueil"
      )
    
    private fr.cg95.cvq.business.request.school.ChoixHorairesAccueilType choixHorairesAccueil;

    public final void setChoixHorairesAccueil(final fr.cg95.cvq.business.request.school.ChoixHorairesAccueilType choixHorairesAccueil) {
        this.choixHorairesAccueil = choixHorairesAccueil;
    }

    /**
 
        * @hibernate.property
        *  column="choix_horaires_accueil"
        
      
    */
    public final fr.cg95.cvq.business.request.school.ChoixHorairesAccueilType getChoixHorairesAccueil() {
        return this.choixHorairesAccueil;
    }
  
    
      @NotNull(
        
        
        profiles = {"accueil"},
        message = "choixTypeDatePlacementAccueilRegulier"
      )
    
    private fr.cg95.cvq.business.request.school.ChoixDatePlacement choixTypeDatePlacementAccueilRegulier;

    public final void setChoixTypeDatePlacementAccueilRegulier(final fr.cg95.cvq.business.request.school.ChoixDatePlacement choixTypeDatePlacementAccueilRegulier) {
        this.choixTypeDatePlacementAccueilRegulier = choixTypeDatePlacementAccueilRegulier;
    }

    /**
 
        * @hibernate.property
        *  column="choix_type_date_placement_accueil_regulier"
        
      
    */
    public final fr.cg95.cvq.business.request.school.ChoixDatePlacement getChoixTypeDatePlacementAccueilRegulier() {
        return this.choixTypeDatePlacementAccueilRegulier;
    }
  
    
      @NotNull(
        
        
        profiles = {"rendezVous"},
        message = "choixTypeRendezVous"
      )
    
    private fr.cg95.cvq.business.request.school.RendezVousType choixTypeRendezVous;

    public final void setChoixTypeRendezVous(final fr.cg95.cvq.business.request.school.RendezVousType choixTypeRendezVous) {
        this.choixTypeRendezVous = choixTypeRendezVous;
    }

    /**
 
        * @hibernate.property
        *  column="choix_type_rendez_vous"
        
      
    */
    public final fr.cg95.cvq.business.request.school.RendezVousType getChoixTypeRendezVous() {
        return this.choixTypeRendezVous;
    }
  
    
      @MaxLength(
        
          value = 600,
        
        
        profiles = {"rendezVous"},
        message = "commentaireCitoyen"
      )
    
    private String commentaireCitoyen;

    public final void setCommentaireCitoyen(final String commentaireCitoyen) {
        this.commentaireCitoyen = commentaireCitoyen;
    }

    /**
 
        * @hibernate.property
        *  column="commentaire_citoyen"
        *  length="600"
      
    */
    public final String getCommentaireCitoyen() {
        return this.commentaireCitoyen;
    }
  
    
    private String communeLieuTravailMere;

    public final void setCommuneLieuTravailMere(final String communeLieuTravailMere) {
        this.communeLieuTravailMere = communeLieuTravailMere;
    }

    /**
 
        * @hibernate.property
        *  column="commune_lieu_travail_mere"
        
      
    */
    public final String getCommuneLieuTravailMere() {
        return this.communeLieuTravailMere;
    }
  
    
    private String communeLieuTravailPere;

    public final void setCommuneLieuTravailPere(final String communeLieuTravailPere) {
        this.communeLieuTravailPere = communeLieuTravailPere;
    }

    /**
 
        * @hibernate.property
        *  column="commune_lieu_travail_pere"
        
      
    */
    public final String getCommuneLieuTravailPere() {
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

    public final void setDatePlacementDebut(final java.util.Date datePlacementDebut) {
        this.datePlacementDebut = datePlacementDebut;
    }

    /**
 
        * @hibernate.property
        *  column="date_placement_debut"
        
      
    */
    public final java.util.Date getDatePlacementDebut() {
        return this.datePlacementDebut;
    }
  
    
    private java.util.Date datePlacementFin;

    public final void setDatePlacementFin(final java.util.Date datePlacementFin) {
        this.datePlacementFin = datePlacementFin;
    }

    /**
 
        * @hibernate.property
        *  column="date_placement_fin"
        
      
    */
    public final java.util.Date getDatePlacementFin() {
        return this.datePlacementFin;
    }
  
    
    private java.util.Date dixHuitMoisEnfant;

    public final void setDixHuitMoisEnfant(final java.util.Date dixHuitMoisEnfant) {
        this.dixHuitMoisEnfant = dixHuitMoisEnfant;
    }

    /**
 
        * @hibernate.property
        *  column="dix_huit_mois_enfant"
        
      
    */
    public final java.util.Date getDixHuitMoisEnfant() {
        return this.dixHuitMoisEnfant;
    }
  
    
    private Boolean estHorairesReguliersMere;

    public final void setEstHorairesReguliersMere(final Boolean estHorairesReguliersMere) {
        this.estHorairesReguliersMere = estHorairesReguliersMere;
    }

    /**
 
        * @hibernate.property
        *  column="est_horaires_reguliers_mere"
        
      
    */
    public final Boolean getEstHorairesReguliersMere() {
        return this.estHorairesReguliersMere;
    }
  
    
    private Boolean estHorairesReguliersPere;

    public final void setEstHorairesReguliersPere(final Boolean estHorairesReguliersPere) {
        this.estHorairesReguliersPere = estHorairesReguliersPere;
    }

    /**
 
        * @hibernate.property
        *  column="est_horaires_reguliers_pere"
        
      
    */
    public final Boolean getEstHorairesReguliersPere() {
        return this.estHorairesReguliersPere;
    }
  
    
    private org.joda.time.LocalTime horairePlacementApresMidiDebut;

    public final void setHorairePlacementApresMidiDebut(final org.joda.time.LocalTime horairePlacementApresMidiDebut) {
        this.horairePlacementApresMidiDebut = horairePlacementApresMidiDebut;
    }

    /**
 
        * @hibernate.property
        *  column="horaire_placement_apres_midi_debut"
        
      
    */
    public final org.joda.time.LocalTime getHorairePlacementApresMidiDebut() {
        return this.horairePlacementApresMidiDebut;
    }
  
    
    private org.joda.time.LocalTime horairePlacementApresMidiDebutJeudi;

    public final void setHorairePlacementApresMidiDebutJeudi(final org.joda.time.LocalTime horairePlacementApresMidiDebutJeudi) {
        this.horairePlacementApresMidiDebutJeudi = horairePlacementApresMidiDebutJeudi;
    }

    /**
 
        * @hibernate.property
        *  column="horaire_placement_apres_midi_debut_jeudi"
        
      
    */
    public final org.joda.time.LocalTime getHorairePlacementApresMidiDebutJeudi() {
        return this.horairePlacementApresMidiDebutJeudi;
    }
  
    
    private org.joda.time.LocalTime horairePlacementApresMidiDebutLundi;

    public final void setHorairePlacementApresMidiDebutLundi(final org.joda.time.LocalTime horairePlacementApresMidiDebutLundi) {
        this.horairePlacementApresMidiDebutLundi = horairePlacementApresMidiDebutLundi;
    }

    /**
 
        * @hibernate.property
        *  column="horaire_placement_apres_midi_debut_lundi"
        
      
    */
    public final org.joda.time.LocalTime getHorairePlacementApresMidiDebutLundi() {
        return this.horairePlacementApresMidiDebutLundi;
    }
  
    
    private org.joda.time.LocalTime horairePlacementApresMidiDebutMardi;

    public final void setHorairePlacementApresMidiDebutMardi(final org.joda.time.LocalTime horairePlacementApresMidiDebutMardi) {
        this.horairePlacementApresMidiDebutMardi = horairePlacementApresMidiDebutMardi;
    }

    /**
 
        * @hibernate.property
        *  column="horaire_placement_apres_midi_debut_mardi"
        
      
    */
    public final org.joda.time.LocalTime getHorairePlacementApresMidiDebutMardi() {
        return this.horairePlacementApresMidiDebutMardi;
    }
  
    
    private org.joda.time.LocalTime horairePlacementApresMidiDebutMercredi;

    public final void setHorairePlacementApresMidiDebutMercredi(final org.joda.time.LocalTime horairePlacementApresMidiDebutMercredi) {
        this.horairePlacementApresMidiDebutMercredi = horairePlacementApresMidiDebutMercredi;
    }

    /**
 
        * @hibernate.property
        *  column="horaire_placement_apres_midi_debut_mercredi"
        
      
    */
    public final org.joda.time.LocalTime getHorairePlacementApresMidiDebutMercredi() {
        return this.horairePlacementApresMidiDebutMercredi;
    }
  
    
    private org.joda.time.LocalTime horairePlacementApresMidiDebutVendredi;

    public final void setHorairePlacementApresMidiDebutVendredi(final org.joda.time.LocalTime horairePlacementApresMidiDebutVendredi) {
        this.horairePlacementApresMidiDebutVendredi = horairePlacementApresMidiDebutVendredi;
    }

    /**
 
        * @hibernate.property
        *  column="horaire_placement_apres_midi_debut_vendredi"
        
      
    */
    public final org.joda.time.LocalTime getHorairePlacementApresMidiDebutVendredi() {
        return this.horairePlacementApresMidiDebutVendredi;
    }
  
    
    private org.joda.time.LocalTime horairePlacementApresMidiFin;

    public final void setHorairePlacementApresMidiFin(final org.joda.time.LocalTime horairePlacementApresMidiFin) {
        this.horairePlacementApresMidiFin = horairePlacementApresMidiFin;
    }

    /**
 
        * @hibernate.property
        *  column="horaire_placement_apres_midi_fin"
        
      
    */
    public final org.joda.time.LocalTime getHorairePlacementApresMidiFin() {
        return this.horairePlacementApresMidiFin;
    }
  
    
    private org.joda.time.LocalTime horairePlacementApresMidiFinJeudi;

    public final void setHorairePlacementApresMidiFinJeudi(final org.joda.time.LocalTime horairePlacementApresMidiFinJeudi) {
        this.horairePlacementApresMidiFinJeudi = horairePlacementApresMidiFinJeudi;
    }

    /**
 
        * @hibernate.property
        *  column="horaire_placement_apres_midi_fin_jeudi"
        
      
    */
    public final org.joda.time.LocalTime getHorairePlacementApresMidiFinJeudi() {
        return this.horairePlacementApresMidiFinJeudi;
    }
  
    
    private org.joda.time.LocalTime horairePlacementApresMidiFinLundi;

    public final void setHorairePlacementApresMidiFinLundi(final org.joda.time.LocalTime horairePlacementApresMidiFinLundi) {
        this.horairePlacementApresMidiFinLundi = horairePlacementApresMidiFinLundi;
    }

    /**
 
        * @hibernate.property
        *  column="horaire_placement_apres_midi_fin_lundi"
        
      
    */
    public final org.joda.time.LocalTime getHorairePlacementApresMidiFinLundi() {
        return this.horairePlacementApresMidiFinLundi;
    }
  
    
    private org.joda.time.LocalTime horairePlacementApresMidiFinMardi;

    public final void setHorairePlacementApresMidiFinMardi(final org.joda.time.LocalTime horairePlacementApresMidiFinMardi) {
        this.horairePlacementApresMidiFinMardi = horairePlacementApresMidiFinMardi;
    }

    /**
 
        * @hibernate.property
        *  column="horaire_placement_apres_midi_fin_mardi"
        
      
    */
    public final org.joda.time.LocalTime getHorairePlacementApresMidiFinMardi() {
        return this.horairePlacementApresMidiFinMardi;
    }
  
    
    private org.joda.time.LocalTime horairePlacementApresMidiFinMercredi;

    public final void setHorairePlacementApresMidiFinMercredi(final org.joda.time.LocalTime horairePlacementApresMidiFinMercredi) {
        this.horairePlacementApresMidiFinMercredi = horairePlacementApresMidiFinMercredi;
    }

    /**
 
        * @hibernate.property
        *  column="horaire_placement_apres_midi_fin_mercredi"
        
      
    */
    public final org.joda.time.LocalTime getHorairePlacementApresMidiFinMercredi() {
        return this.horairePlacementApresMidiFinMercredi;
    }
  
    
    private org.joda.time.LocalTime horairePlacementApresMidiFinVendredi;

    public final void setHorairePlacementApresMidiFinVendredi(final org.joda.time.LocalTime horairePlacementApresMidiFinVendredi) {
        this.horairePlacementApresMidiFinVendredi = horairePlacementApresMidiFinVendredi;
    }

    /**
 
        * @hibernate.property
        *  column="horaire_placement_apres_midi_fin_vendredi"
        
      
    */
    public final org.joda.time.LocalTime getHorairePlacementApresMidiFinVendredi() {
        return this.horairePlacementApresMidiFinVendredi;
    }
  
    
    private org.joda.time.LocalTime horairePlacementMatinDebut;

    public final void setHorairePlacementMatinDebut(final org.joda.time.LocalTime horairePlacementMatinDebut) {
        this.horairePlacementMatinDebut = horairePlacementMatinDebut;
    }

    /**
 
        * @hibernate.property
        *  column="horaire_placement_matin_debut"
        
      
    */
    public final org.joda.time.LocalTime getHorairePlacementMatinDebut() {
        return this.horairePlacementMatinDebut;
    }
  
    
    private org.joda.time.LocalTime horairePlacementMatinDebutJeudi;

    public final void setHorairePlacementMatinDebutJeudi(final org.joda.time.LocalTime horairePlacementMatinDebutJeudi) {
        this.horairePlacementMatinDebutJeudi = horairePlacementMatinDebutJeudi;
    }

    /**
 
        * @hibernate.property
        *  column="horaire_placement_matin_debut_jeudi"
        
      
    */
    public final org.joda.time.LocalTime getHorairePlacementMatinDebutJeudi() {
        return this.horairePlacementMatinDebutJeudi;
    }
  
    
    private org.joda.time.LocalTime horairePlacementMatinDebutLundi;

    public final void setHorairePlacementMatinDebutLundi(final org.joda.time.LocalTime horairePlacementMatinDebutLundi) {
        this.horairePlacementMatinDebutLundi = horairePlacementMatinDebutLundi;
    }

    /**
 
        * @hibernate.property
        *  column="horaire_placement_matin_debut_lundi"
        
      
    */
    public final org.joda.time.LocalTime getHorairePlacementMatinDebutLundi() {
        return this.horairePlacementMatinDebutLundi;
    }
  
    
    private org.joda.time.LocalTime horairePlacementMatinDebutMardi;

    public final void setHorairePlacementMatinDebutMardi(final org.joda.time.LocalTime horairePlacementMatinDebutMardi) {
        this.horairePlacementMatinDebutMardi = horairePlacementMatinDebutMardi;
    }

    /**
 
        * @hibernate.property
        *  column="horaire_placement_matin_debut_mardi"
        
      
    */
    public final org.joda.time.LocalTime getHorairePlacementMatinDebutMardi() {
        return this.horairePlacementMatinDebutMardi;
    }
  
    
    private org.joda.time.LocalTime horairePlacementMatinDebutMercredi;

    public final void setHorairePlacementMatinDebutMercredi(final org.joda.time.LocalTime horairePlacementMatinDebutMercredi) {
        this.horairePlacementMatinDebutMercredi = horairePlacementMatinDebutMercredi;
    }

    /**
 
        * @hibernate.property
        *  column="horaire_placement_matin_debut_mercredi"
        
      
    */
    public final org.joda.time.LocalTime getHorairePlacementMatinDebutMercredi() {
        return this.horairePlacementMatinDebutMercredi;
    }
  
    
    private org.joda.time.LocalTime horairePlacementMatinDebutVendredi;

    public final void setHorairePlacementMatinDebutVendredi(final org.joda.time.LocalTime horairePlacementMatinDebutVendredi) {
        this.horairePlacementMatinDebutVendredi = horairePlacementMatinDebutVendredi;
    }

    /**
 
        * @hibernate.property
        *  column="horaire_placement_matin_debut_vendredi"
        
      
    */
    public final org.joda.time.LocalTime getHorairePlacementMatinDebutVendredi() {
        return this.horairePlacementMatinDebutVendredi;
    }
  
    
    private org.joda.time.LocalTime horairePlacementMatinFin;

    public final void setHorairePlacementMatinFin(final org.joda.time.LocalTime horairePlacementMatinFin) {
        this.horairePlacementMatinFin = horairePlacementMatinFin;
    }

    /**
 
        * @hibernate.property
        *  column="horaire_placement_matin_fin"
        
      
    */
    public final org.joda.time.LocalTime getHorairePlacementMatinFin() {
        return this.horairePlacementMatinFin;
    }
  
    
    private org.joda.time.LocalTime horairePlacementMatinFinJeudi;

    public final void setHorairePlacementMatinFinJeudi(final org.joda.time.LocalTime horairePlacementMatinFinJeudi) {
        this.horairePlacementMatinFinJeudi = horairePlacementMatinFinJeudi;
    }

    /**
 
        * @hibernate.property
        *  column="horaire_placement_matin_fin_jeudi"
        
      
    */
    public final org.joda.time.LocalTime getHorairePlacementMatinFinJeudi() {
        return this.horairePlacementMatinFinJeudi;
    }
  
    
    private org.joda.time.LocalTime horairePlacementMatinFinLundi;

    public final void setHorairePlacementMatinFinLundi(final org.joda.time.LocalTime horairePlacementMatinFinLundi) {
        this.horairePlacementMatinFinLundi = horairePlacementMatinFinLundi;
    }

    /**
 
        * @hibernate.property
        *  column="horaire_placement_matin_fin_lundi"
        
      
    */
    public final org.joda.time.LocalTime getHorairePlacementMatinFinLundi() {
        return this.horairePlacementMatinFinLundi;
    }
  
    
    private org.joda.time.LocalTime horairePlacementMatinFinMardi;

    public final void setHorairePlacementMatinFinMardi(final org.joda.time.LocalTime horairePlacementMatinFinMardi) {
        this.horairePlacementMatinFinMardi = horairePlacementMatinFinMardi;
    }

    /**
 
        * @hibernate.property
        *  column="horaire_placement_matin_fin_mardi"
        
      
    */
    public final org.joda.time.LocalTime getHorairePlacementMatinFinMardi() {
        return this.horairePlacementMatinFinMardi;
    }
  
    
    private org.joda.time.LocalTime horairePlacementMatinFinMercredi;

    public final void setHorairePlacementMatinFinMercredi(final org.joda.time.LocalTime horairePlacementMatinFinMercredi) {
        this.horairePlacementMatinFinMercredi = horairePlacementMatinFinMercredi;
    }

    /**
 
        * @hibernate.property
        *  column="horaire_placement_matin_fin_mercredi"
        
      
    */
    public final org.joda.time.LocalTime getHorairePlacementMatinFinMercredi() {
        return this.horairePlacementMatinFinMercredi;
    }
  
    
    private org.joda.time.LocalTime horairePlacementMatinFinVendredi;

    public final void setHorairePlacementMatinFinVendredi(final org.joda.time.LocalTime horairePlacementMatinFinVendredi) {
        this.horairePlacementMatinFinVendredi = horairePlacementMatinFinVendredi;
    }

    /**
 
        * @hibernate.property
        *  column="horaire_placement_matin_fin_vendredi"
        
      
    */
    public final org.joda.time.LocalTime getHorairePlacementMatinFinVendredi() {
        return this.horairePlacementMatinFinVendredi;
    }
  
    
    private String horairesReguliersMere;

    public final void setHorairesReguliersMere(final String horairesReguliersMere) {
        this.horairesReguliersMere = horairesReguliersMere;
    }

    /**
 
        * @hibernate.property
        *  column="horaires_reguliers_mere"
        
      
    */
    public final String getHorairesReguliersMere() {
        return this.horairesReguliersMere;
    }
  
    
    private String horairesReguliersPere;

    public final void setHorairesReguliersPere(final String horairesReguliersPere) {
        this.horairesReguliersPere = horairesReguliersPere;
    }

    /**
 
        * @hibernate.property
        *  column="horaires_reguliers_pere"
        
      
    */
    public final String getHorairesReguliersPere() {
        return this.horairesReguliersPere;
    }
  
    
    private String horairesTravailJeudiMere;

    public final void setHorairesTravailJeudiMere(final String horairesTravailJeudiMere) {
        this.horairesTravailJeudiMere = horairesTravailJeudiMere;
    }

    /**
 
        * @hibernate.property
        *  column="horaires_travail_jeudi_mere"
        
      
    */
    public final String getHorairesTravailJeudiMere() {
        return this.horairesTravailJeudiMere;
    }
  
    
    private String horairesTravailJeudiPere;

    public final void setHorairesTravailJeudiPere(final String horairesTravailJeudiPere) {
        this.horairesTravailJeudiPere = horairesTravailJeudiPere;
    }

    /**
 
        * @hibernate.property
        *  column="horaires_travail_jeudi_pere"
        
      
    */
    public final String getHorairesTravailJeudiPere() {
        return this.horairesTravailJeudiPere;
    }
  
    
    private String horairesTravailLundiMere;

    public final void setHorairesTravailLundiMere(final String horairesTravailLundiMere) {
        this.horairesTravailLundiMere = horairesTravailLundiMere;
    }

    /**
 
        * @hibernate.property
        *  column="horaires_travail_lundi_mere"
        
      
    */
    public final String getHorairesTravailLundiMere() {
        return this.horairesTravailLundiMere;
    }
  
    
    private String horairesTravailLundiPere;

    public final void setHorairesTravailLundiPere(final String horairesTravailLundiPere) {
        this.horairesTravailLundiPere = horairesTravailLundiPere;
    }

    /**
 
        * @hibernate.property
        *  column="horaires_travail_lundi_pere"
        
      
    */
    public final String getHorairesTravailLundiPere() {
        return this.horairesTravailLundiPere;
    }
  
    
    private String horairesTravailMardiMere;

    public final void setHorairesTravailMardiMere(final String horairesTravailMardiMere) {
        this.horairesTravailMardiMere = horairesTravailMardiMere;
    }

    /**
 
        * @hibernate.property
        *  column="horaires_travail_mardi_mere"
        
      
    */
    public final String getHorairesTravailMardiMere() {
        return this.horairesTravailMardiMere;
    }
  
    
    private String horairesTravailMardiPere;

    public final void setHorairesTravailMardiPere(final String horairesTravailMardiPere) {
        this.horairesTravailMardiPere = horairesTravailMardiPere;
    }

    /**
 
        * @hibernate.property
        *  column="horaires_travail_mardi_pere"
        
      
    */
    public final String getHorairesTravailMardiPere() {
        return this.horairesTravailMardiPere;
    }
  
    
    private String horairesTravailMercrediMere;

    public final void setHorairesTravailMercrediMere(final String horairesTravailMercrediMere) {
        this.horairesTravailMercrediMere = horairesTravailMercrediMere;
    }

    /**
 
        * @hibernate.property
        *  column="horaires_travail_mercredi_mere"
        
      
    */
    public final String getHorairesTravailMercrediMere() {
        return this.horairesTravailMercrediMere;
    }
  
    
    private String horairesTravailMercrediPere;

    public final void setHorairesTravailMercrediPere(final String horairesTravailMercrediPere) {
        this.horairesTravailMercrediPere = horairesTravailMercrediPere;
    }

    /**
 
        * @hibernate.property
        *  column="horaires_travail_mercredi_pere"
        
      
    */
    public final String getHorairesTravailMercrediPere() {
        return this.horairesTravailMercrediPere;
    }
  
    
    private String horairesTravailVendrediMere;

    public final void setHorairesTravailVendrediMere(final String horairesTravailVendrediMere) {
        this.horairesTravailVendrediMere = horairesTravailVendrediMere;
    }

    /**
 
        * @hibernate.property
        *  column="horaires_travail_vendredi_mere"
        
      
    */
    public final String getHorairesTravailVendrediMere() {
        return this.horairesTravailVendrediMere;
    }
  
    
    private String horairesTravailVendrediPere;

    public final void setHorairesTravailVendrediPere(final String horairesTravailVendrediPere) {
        this.horairesTravailVendrediPere = horairesTravailVendrediPere;
    }

    /**
 
        * @hibernate.property
        *  column="horaires_travail_vendredi_pere"
        
      
    */
    public final String getHorairesTravailVendrediPere() {
        return this.horairesTravailVendrediPere;
    }
  
    
      @NotNull(
        
        
        profiles = {"accueil"},
        message = "modeAccueil"
      )
    
    private Boolean modeAccueil;

    public final void setModeAccueil(final Boolean modeAccueil) {
        this.modeAccueil = modeAccueil;
    }

    /**
 
        * @hibernate.property
        *  column="mode_accueil"
        
      
    */
    public final Boolean getModeAccueil() {
        return this.modeAccueil;
    }
  
    
    private fr.cg95.cvq.business.request.school.ModeAccueilType modeAccueilChoixDeux;

    public final void setModeAccueilChoixDeux(final fr.cg95.cvq.business.request.school.ModeAccueilType modeAccueilChoixDeux) {
        this.modeAccueilChoixDeux = modeAccueilChoixDeux;
    }

    /**
 
        * @hibernate.property
        *  column="mode_accueil_choix_deux"
        
      
    */
    public final fr.cg95.cvq.business.request.school.ModeAccueilType getModeAccueilChoixDeux() {
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

    public final void setModeAccueilChoixUn(final fr.cg95.cvq.business.request.school.ModeAccueilType modeAccueilChoixUn) {
        this.modeAccueilChoixUn = modeAccueilChoixUn;
    }

    /**
 
        * @hibernate.property
        *  column="mode_accueil_choix_un"
        
      
    */
    public final fr.cg95.cvq.business.request.school.ModeAccueilType getModeAccueilChoixUn() {
        return this.modeAccueilChoixUn;
    }
  
    
      @NotNull(
        
        
        profiles = {"rendezVous"},
        message = "plageHoraireContact"
      )
    
    private fr.cg95.cvq.business.request.school.PlageHoraireContactType plageHoraireContact;

    public final void setPlageHoraireContact(final fr.cg95.cvq.business.request.school.PlageHoraireContactType plageHoraireContact) {
        this.plageHoraireContact = plageHoraireContact;
    }

    /**
 
        * @hibernate.property
        *  column="plage_horaire_contact"
        
      
    */
    public final fr.cg95.cvq.business.request.school.PlageHoraireContactType getPlageHoraireContact() {
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

    public final void setPrecisionAutreSituationActuelleMere(final String precisionAutreSituationActuelleMere) {
        this.precisionAutreSituationActuelleMere = precisionAutreSituationActuelleMere;
    }

    /**
 
        * @hibernate.property
        *  column="precision_autre_situation_actuelle_mere"
        
      
    */
    public final String getPrecisionAutreSituationActuelleMere() {
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

    public final void setPrecisionAutreSituationActuellePere(final String precisionAutreSituationActuellePere) {
        this.precisionAutreSituationActuellePere = precisionAutreSituationActuellePere;
    }

    /**
 
        * @hibernate.property
        *  column="precision_autre_situation_actuelle_pere"
        
      
    */
    public final String getPrecisionAutreSituationActuellePere() {
        return this.precisionAutreSituationActuellePere;
    }
  
    
    private String professionMere;

    public final void setProfessionMere(final String professionMere) {
        this.professionMere = professionMere;
    }

    /**
 
        * @hibernate.property
        *  column="profession_mere"
        
      
    */
    public final String getProfessionMere() {
        return this.professionMere;
    }
  
    
    private String professionPere;

    public final void setProfessionPere(final String professionPere) {
        this.professionPere = professionPere;
    }

    /**
 
        * @hibernate.property
        *  column="profession_pere"
        
      
    */
    public final String getProfessionPere() {
        return this.professionPere;
    }
  
    
    private fr.cg95.cvq.business.request.school.ChoixSituationActuelle situationActuelleMere;

    public final void setSituationActuelleMere(final fr.cg95.cvq.business.request.school.ChoixSituationActuelle situationActuelleMere) {
        this.situationActuelleMere = situationActuelleMere;
    }

    /**
 
        * @hibernate.property
        *  column="situation_actuelle_mere"
        
      
    */
    public final fr.cg95.cvq.business.request.school.ChoixSituationActuelle getSituationActuelleMere() {
        return this.situationActuelleMere;
    }
  
    
    private fr.cg95.cvq.business.request.school.ChoixSituationActuelle situationActuellePere;

    public final void setSituationActuellePere(final fr.cg95.cvq.business.request.school.ChoixSituationActuelle situationActuellePere) {
        this.situationActuellePere = situationActuellePere;
    }

    /**
 
        * @hibernate.property
        *  column="situation_actuelle_pere"
        
      
    */
    public final fr.cg95.cvq.business.request.school.ChoixSituationActuelle getSituationActuellePere() {
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

    public final void setTelephoneContact(final String telephoneContact) {
        this.telephoneContact = telephoneContact;
    }

    /**
 
        * @hibernate.property
        *  column="telephone_contact"
        *  length="10"
      
    */
    public final String getTelephoneContact() {
        return this.telephoneContact;
    }
  
}
