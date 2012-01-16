
package fr.cg95.cvq.business.request.babyhood;

import java.io.Serializable;
import java.math.BigInteger;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.joda.time.LocalTime;

import net.sf.oval.constraint.AssertValid;
import org.apache.xmlbeans.XmlOptions;
import fr.cg95.cvq.business.authority.*;
import fr.cg95.cvq.business.request.*;
import fr.cg95.cvq.business.request.annotation.*;
import fr.cg95.cvq.business.users.*;
import fr.cg95.cvq.xml.common.*;
import fr.cg95.cvq.xml.request.babyhood.*;
import fr.cg95.cvq.service.request.condition.IConditionChecker;

/**
 * Generated class file, do not edit !
 */
public class SaintouenDayCareCenterRegistrationRequest extends Request implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final Map<String, IConditionChecker> conditions = SaintouenDayCareCenterRegistrationRequestData.conditions;

    @AssertValid(message = "")
    private SaintouenDayCareCenterRegistrationRequestData saintouenDayCareCenterRegistrationRequestData;

    public SaintouenDayCareCenterRegistrationRequest(RequestData requestData, SaintouenDayCareCenterRegistrationRequestData saintouenDayCareCenterRegistrationRequestData) {
        super(requestData);
        this.saintouenDayCareCenterRegistrationRequestData = saintouenDayCareCenterRegistrationRequestData;
    }

    public SaintouenDayCareCenterRegistrationRequest() {
        super();
        this.saintouenDayCareCenterRegistrationRequestData = new SaintouenDayCareCenterRegistrationRequestData();
        Map<String, Object> stepState;
        
          stepState = new HashMap<String, Object>(4);
          stepState.put("state", "uncomplete");
          stepState.put("required", false);
          stepState.put("errorMsg", null);
          stepState.put("invalidFields", new ArrayList<String>());
          getStepStates().put("homeFolder", stepState);
        
          stepState = new HashMap<String, Object>(4);
          stepState.put("state", "unavailable");
          stepState.put("required", true);
          stepState.put("errorMsg", null);
          stepState.put("invalidFields", new ArrayList<String>());
          getStepStates().put("subject", stepState);
        
          stepState = new HashMap<String, Object>(4);
          stepState.put("state", "unavailable");
          stepState.put("required", true);
          stepState.put("errorMsg", null);
          stepState.put("invalidFields", new ArrayList<String>());
          getStepStates().put("accueil", stepState);
        
          stepState = new HashMap<String, Object>(4);
          stepState.put("state", "unavailable");
          stepState.put("required", true);
          stepState.put("errorMsg", null);
          stepState.put("invalidFields", new ArrayList<String>());
          getStepStates().put("rendezVous", stepState);
        
          stepState = new HashMap<String, Object>(4);
          stepState.put("state", "unavailable");
          stepState.put("required", false);
          stepState.put("errorMsg", null);
          stepState.put("invalidFields", new ArrayList<String>());
          getStepStates().put("document", stepState);
        
          stepState = new HashMap<String, Object>(4);
          stepState.put("state", "unavailable");
          stepState.put("required", true);
          stepState.put("errorMsg", null);
          stepState.put("invalidFields", new ArrayList<String>());
          getStepStates().put("validation", stepState);
        
    }

    /**
     * Reserved for RequestDAO !
     */
    @Override
    public SaintouenDayCareCenterRegistrationRequestData getSpecificData() {
        return saintouenDayCareCenterRegistrationRequestData;
    }

    /**
     * Reserved for RequestDAO !
     */
    public void setSpecificData(SaintouenDayCareCenterRegistrationRequestData saintouenDayCareCenterRegistrationRequestData) {
        this.saintouenDayCareCenterRegistrationRequestData = saintouenDayCareCenterRegistrationRequestData;
    }

    @Override
    public final String modelToXmlString() {
        SaintouenDayCareCenterRegistrationRequestDocument object = this.modelToXml();
        XmlOptions opts = new XmlOptions();
        opts.setSavePrettyPrint();
        opts.setSavePrettyPrintIndent(4);
        opts.setUseDefaultNamespace();
        opts.setCharacterEncoding("UTF-8");
        return object.xmlText(opts);
    }

    @Override
    public final SaintouenDayCareCenterRegistrationRequestDocument modelToXml() {
        
        Calendar calendar = Calendar.getInstance();
        LocalTime localTime = new LocalTime();
        Date date = null;
        SaintouenDayCareCenterRegistrationRequestDocument saintouenDayCareCenterRegistrationRequestDoc = SaintouenDayCareCenterRegistrationRequestDocument.Factory.newInstance();
        SaintouenDayCareCenterRegistrationRequestDocument.SaintouenDayCareCenterRegistrationRequest saintouenDayCareCenterRegistrationRequest = saintouenDayCareCenterRegistrationRequestDoc.addNewSaintouenDayCareCenterRegistrationRequest();
        super.fillCommonXmlInfo(saintouenDayCareCenterRegistrationRequest);
        int i = 0;
        
        if (getChoixHorairesAccueil() != null)
            saintouenDayCareCenterRegistrationRequest.setChoixHorairesAccueil(fr.cg95.cvq.xml.request.babyhood.SdccrrChoixHorairesAccueilType.Enum.forString(getChoixHorairesAccueil().getLegacyLabel()));
        SdccrrDatesPlacementType sdccrrDatesPlacementTypeDatePlacementAccueilRegulier = saintouenDayCareCenterRegistrationRequest.addNewDatePlacementAccueilRegulier();
        if (getChoixTypeDatePlacementAccueilRegulier() != null)
            sdccrrDatesPlacementTypeDatePlacementAccueilRegulier.setChoixTypeDatePlacementAccueilRegulier(fr.cg95.cvq.xml.request.babyhood.SdccrrChoixDatePlacement.Enum.forString(getChoixTypeDatePlacementAccueilRegulier().getLegacyLabel()));
      
        if (getChoixTypeRendezVous() != null)
            saintouenDayCareCenterRegistrationRequest.setChoixTypeRendezVous(fr.cg95.cvq.xml.request.babyhood.SdccrrRendezVousType.Enum.forString(getChoixTypeRendezVous().getLegacyLabel()));
      
        saintouenDayCareCenterRegistrationRequest.setCommentaireCitoyen(getCommentaireCitoyen());
        SdccrrMereType sdccrrMereTypeInformationMere = saintouenDayCareCenterRegistrationRequest.addNewInformationMere();
        sdccrrMereTypeInformationMere.setCommuneLieuTravailMere(getCommuneLieuTravailMere());
        SdccrrPereType sdccrrPereTypeInformationPere = saintouenDayCareCenterRegistrationRequest.addNewInformationPere();
        sdccrrPereTypeInformationPere.setCommuneLieuTravailPere(getCommuneLieuTravailPere());
      
        date = getDatePlacementDebut();
        if (date != null) {
            calendar.setTime(date);
            sdccrrDatesPlacementTypeDatePlacementAccueilRegulier.setDatePlacementDebut(calendar);
        }
      
        date = getDatePlacementFin();
        if (date != null) {
            calendar.setTime(date);
            sdccrrDatesPlacementTypeDatePlacementAccueilRegulier.setDatePlacementFin(calendar);
        }
      
        date = getDixHuitMoisEnfant();
        if (date != null) {
            calendar.setTime(date);
            saintouenDayCareCenterRegistrationRequest.setDixHuitMoisEnfant(calendar);
        }
      
        sdccrrMereTypeInformationMere.setEmployeurMere(getEmployeurMere());
      
        sdccrrPereTypeInformationPere.setEmployeurPere(getEmployeurPere());
      
        if (getEstHorairesReguliersMere() != null)
            sdccrrMereTypeInformationMere.setEstHorairesReguliersMere(getEstHorairesReguliersMere().booleanValue());
      
        if (getEstHorairesReguliersPere() != null)
            sdccrrPereTypeInformationPere.setEstHorairesReguliersPere(getEstHorairesReguliersPere().booleanValue());
        SdccrrPlageHoraireType sdccrrPlageHoraireTypePlageHoraireAccueilReguliere = saintouenDayCareCenterRegistrationRequest.addNewPlageHoraireAccueilReguliere();
        localTime = getHorairePlacementApresMidiDebut();
        if (localTime != null) {
            calendar.set(Calendar.HOUR_OF_DAY,localTime.getHourOfDay());
            calendar.set(Calendar.MINUTE, localTime.getMinuteOfHour());
            sdccrrPlageHoraireTypePlageHoraireAccueilReguliere.setHorairePlacementApresMidiDebut(calendar);
        }
        SdccrrPlageHoraireJeudiType sdccrrPlageHoraireJeudiTypeJeudi = saintouenDayCareCenterRegistrationRequest.addNewJeudi();
        localTime = getHorairePlacementApresMidiDebutJeudi();
        if (localTime != null) {
            calendar.set(Calendar.HOUR_OF_DAY,localTime.getHourOfDay());
            calendar.set(Calendar.MINUTE, localTime.getMinuteOfHour());
            sdccrrPlageHoraireJeudiTypeJeudi.setHorairePlacementApresMidiDebutJeudi(calendar);
        }
        SdccrrPlageHoraireLundiType sdccrrPlageHoraireLundiTypeLundi = saintouenDayCareCenterRegistrationRequest.addNewLundi();
        localTime = getHorairePlacementApresMidiDebutLundi();
        if (localTime != null) {
            calendar.set(Calendar.HOUR_OF_DAY,localTime.getHourOfDay());
            calendar.set(Calendar.MINUTE, localTime.getMinuteOfHour());
            sdccrrPlageHoraireLundiTypeLundi.setHorairePlacementApresMidiDebutLundi(calendar);
        }
        SdccrrPlageHoraireMardiType sdccrrPlageHoraireMardiTypeMardi = saintouenDayCareCenterRegistrationRequest.addNewMardi();
        localTime = getHorairePlacementApresMidiDebutMardi();
        if (localTime != null) {
            calendar.set(Calendar.HOUR_OF_DAY,localTime.getHourOfDay());
            calendar.set(Calendar.MINUTE, localTime.getMinuteOfHour());
            sdccrrPlageHoraireMardiTypeMardi.setHorairePlacementApresMidiDebutMardi(calendar);
        }
        SdccrrPlageHoraireMercrediType sdccrrPlageHoraireMercrediTypeMercredi = saintouenDayCareCenterRegistrationRequest.addNewMercredi();
        localTime = getHorairePlacementApresMidiDebutMercredi();
        if (localTime != null) {
            calendar.set(Calendar.HOUR_OF_DAY,localTime.getHourOfDay());
            calendar.set(Calendar.MINUTE, localTime.getMinuteOfHour());
            sdccrrPlageHoraireMercrediTypeMercredi.setHorairePlacementApresMidiDebutMercredi(calendar);
        }
        SdccrrPlageHoraireVendrediType sdccrrPlageHoraireVendrediTypeVendredi = saintouenDayCareCenterRegistrationRequest.addNewVendredi();
        localTime = getHorairePlacementApresMidiDebutVendredi();
        if (localTime != null) {
            calendar.set(Calendar.HOUR_OF_DAY,localTime.getHourOfDay());
            calendar.set(Calendar.MINUTE, localTime.getMinuteOfHour());
            sdccrrPlageHoraireVendrediTypeVendredi.setHorairePlacementApresMidiDebutVendredi(calendar);
        }
      
        localTime = getHorairePlacementApresMidiFin();
        if (localTime != null) {
            calendar.set(Calendar.HOUR_OF_DAY,localTime.getHourOfDay());
            calendar.set(Calendar.MINUTE, localTime.getMinuteOfHour());
            sdccrrPlageHoraireTypePlageHoraireAccueilReguliere.setHorairePlacementApresMidiFin(calendar);
        }
      
        localTime = getHorairePlacementApresMidiFinJeudi();
        if (localTime != null) {
            calendar.set(Calendar.HOUR_OF_DAY,localTime.getHourOfDay());
            calendar.set(Calendar.MINUTE, localTime.getMinuteOfHour());
            sdccrrPlageHoraireJeudiTypeJeudi.setHorairePlacementApresMidiFinJeudi(calendar);
        }
      
        localTime = getHorairePlacementApresMidiFinLundi();
        if (localTime != null) {
            calendar.set(Calendar.HOUR_OF_DAY,localTime.getHourOfDay());
            calendar.set(Calendar.MINUTE, localTime.getMinuteOfHour());
            sdccrrPlageHoraireLundiTypeLundi.setHorairePlacementApresMidiFinLundi(calendar);
        }
      
        localTime = getHorairePlacementApresMidiFinMardi();
        if (localTime != null) {
            calendar.set(Calendar.HOUR_OF_DAY,localTime.getHourOfDay());
            calendar.set(Calendar.MINUTE, localTime.getMinuteOfHour());
            sdccrrPlageHoraireMardiTypeMardi.setHorairePlacementApresMidiFinMardi(calendar);
        }
      
        localTime = getHorairePlacementApresMidiFinMercredi();
        if (localTime != null) {
            calendar.set(Calendar.HOUR_OF_DAY,localTime.getHourOfDay());
            calendar.set(Calendar.MINUTE, localTime.getMinuteOfHour());
            sdccrrPlageHoraireMercrediTypeMercredi.setHorairePlacementApresMidiFinMercredi(calendar);
        }
      
        localTime = getHorairePlacementApresMidiFinVendredi();
        if (localTime != null) {
            calendar.set(Calendar.HOUR_OF_DAY,localTime.getHourOfDay());
            calendar.set(Calendar.MINUTE, localTime.getMinuteOfHour());
            sdccrrPlageHoraireVendrediTypeVendredi.setHorairePlacementApresMidiFinVendredi(calendar);
        }
      
        localTime = getHorairePlacementMatinDebut();
        if (localTime != null) {
            calendar.set(Calendar.HOUR_OF_DAY,localTime.getHourOfDay());
            calendar.set(Calendar.MINUTE, localTime.getMinuteOfHour());
            sdccrrPlageHoraireTypePlageHoraireAccueilReguliere.setHorairePlacementMatinDebut(calendar);
        }
      
        localTime = getHorairePlacementMatinDebutJeudi();
        if (localTime != null) {
            calendar.set(Calendar.HOUR_OF_DAY,localTime.getHourOfDay());
            calendar.set(Calendar.MINUTE, localTime.getMinuteOfHour());
            sdccrrPlageHoraireJeudiTypeJeudi.setHorairePlacementMatinDebutJeudi(calendar);
        }
      
        localTime = getHorairePlacementMatinDebutLundi();
        if (localTime != null) {
            calendar.set(Calendar.HOUR_OF_DAY,localTime.getHourOfDay());
            calendar.set(Calendar.MINUTE, localTime.getMinuteOfHour());
            sdccrrPlageHoraireLundiTypeLundi.setHorairePlacementMatinDebutLundi(calendar);
        }
      
        localTime = getHorairePlacementMatinDebutMardi();
        if (localTime != null) {
            calendar.set(Calendar.HOUR_OF_DAY,localTime.getHourOfDay());
            calendar.set(Calendar.MINUTE, localTime.getMinuteOfHour());
            sdccrrPlageHoraireMardiTypeMardi.setHorairePlacementMatinDebutMardi(calendar);
        }
      
        localTime = getHorairePlacementMatinDebutMercredi();
        if (localTime != null) {
            calendar.set(Calendar.HOUR_OF_DAY,localTime.getHourOfDay());
            calendar.set(Calendar.MINUTE, localTime.getMinuteOfHour());
            sdccrrPlageHoraireMercrediTypeMercredi.setHorairePlacementMatinDebutMercredi(calendar);
        }
      
        localTime = getHorairePlacementMatinDebutVendredi();
        if (localTime != null) {
            calendar.set(Calendar.HOUR_OF_DAY,localTime.getHourOfDay());
            calendar.set(Calendar.MINUTE, localTime.getMinuteOfHour());
            sdccrrPlageHoraireVendrediTypeVendredi.setHorairePlacementMatinDebutVendredi(calendar);
        }
      
        localTime = getHorairePlacementMatinFin();
        if (localTime != null) {
            calendar.set(Calendar.HOUR_OF_DAY,localTime.getHourOfDay());
            calendar.set(Calendar.MINUTE, localTime.getMinuteOfHour());
            sdccrrPlageHoraireTypePlageHoraireAccueilReguliere.setHorairePlacementMatinFin(calendar);
        }
      
        localTime = getHorairePlacementMatinFinJeudi();
        if (localTime != null) {
            calendar.set(Calendar.HOUR_OF_DAY,localTime.getHourOfDay());
            calendar.set(Calendar.MINUTE, localTime.getMinuteOfHour());
            sdccrrPlageHoraireJeudiTypeJeudi.setHorairePlacementMatinFinJeudi(calendar);
        }
      
        localTime = getHorairePlacementMatinFinLundi();
        if (localTime != null) {
            calendar.set(Calendar.HOUR_OF_DAY,localTime.getHourOfDay());
            calendar.set(Calendar.MINUTE, localTime.getMinuteOfHour());
            sdccrrPlageHoraireLundiTypeLundi.setHorairePlacementMatinFinLundi(calendar);
        }
      
        localTime = getHorairePlacementMatinFinMardi();
        if (localTime != null) {
            calendar.set(Calendar.HOUR_OF_DAY,localTime.getHourOfDay());
            calendar.set(Calendar.MINUTE, localTime.getMinuteOfHour());
            sdccrrPlageHoraireMardiTypeMardi.setHorairePlacementMatinFinMardi(calendar);
        }
      
        localTime = getHorairePlacementMatinFinMercredi();
        if (localTime != null) {
            calendar.set(Calendar.HOUR_OF_DAY,localTime.getHourOfDay());
            calendar.set(Calendar.MINUTE, localTime.getMinuteOfHour());
            sdccrrPlageHoraireMercrediTypeMercredi.setHorairePlacementMatinFinMercredi(calendar);
        }
      
        localTime = getHorairePlacementMatinFinVendredi();
        if (localTime != null) {
            calendar.set(Calendar.HOUR_OF_DAY,localTime.getHourOfDay());
            calendar.set(Calendar.MINUTE, localTime.getMinuteOfHour());
            sdccrrPlageHoraireVendrediTypeVendredi.setHorairePlacementMatinFinVendredi(calendar);
        }
      
        sdccrrMereTypeInformationMere.setHorairesReguliersMere(getHorairesReguliersMere());
      
        sdccrrPereTypeInformationPere.setHorairesReguliersPere(getHorairesReguliersPere());
      
        sdccrrMereTypeInformationMere.setHorairesTravailJeudiMere(getHorairesTravailJeudiMere());
      
        sdccrrPereTypeInformationPere.setHorairesTravailJeudiPere(getHorairesTravailJeudiPere());
      
        sdccrrMereTypeInformationMere.setHorairesTravailLundiMere(getHorairesTravailLundiMere());
      
        sdccrrPereTypeInformationPere.setHorairesTravailLundiPere(getHorairesTravailLundiPere());
      
        sdccrrMereTypeInformationMere.setHorairesTravailMardiMere(getHorairesTravailMardiMere());
      
        sdccrrPereTypeInformationPere.setHorairesTravailMardiPere(getHorairesTravailMardiPere());
      
        sdccrrMereTypeInformationMere.setHorairesTravailMercrediMere(getHorairesTravailMercrediMere());
      
        sdccrrPereTypeInformationPere.setHorairesTravailMercrediPere(getHorairesTravailMercrediPere());
      
        sdccrrMereTypeInformationMere.setHorairesTravailVendrediMere(getHorairesTravailVendrediMere());
      
        sdccrrPereTypeInformationPere.setHorairesTravailVendrediPere(getHorairesTravailVendrediPere());
      
        i = 0;
        if (getPlageHoraireContact() != null) {
            fr.cg95.cvq.xml.common.LocalReferentialDataType[] plageHoraireContactTypeTab = new fr.cg95.cvq.xml.common.LocalReferentialDataType[getPlageHoraireContact().size()];
            for (LocalReferentialData object : getPlageHoraireContact()) {
              plageHoraireContactTypeTab[i++] = LocalReferentialData.modelToXml(object);
            }
            saintouenDayCareCenterRegistrationRequest.setPlageHoraireContactArray(plageHoraireContactTypeTab);
        }
      
        sdccrrMereTypeInformationMere.setPrecisionAutreSituationActuelleMere(getPrecisionAutreSituationActuelleMere());
      
        sdccrrPereTypeInformationPere.setPrecisionAutreSituationActuellePere(getPrecisionAutreSituationActuellePere());
      
        sdccrrMereTypeInformationMere.setProfessionMere(getProfessionMere());
      
        sdccrrPereTypeInformationPere.setProfessionPere(getProfessionPere());
      
        if (getSituationActuelleMere() != null)
            sdccrrMereTypeInformationMere.setSituationActuelleMere(fr.cg95.cvq.xml.request.babyhood.SdccrrChoixSituationActuelle.Enum.forString(getSituationActuelleMere().getLegacyLabel()));
      
        if (getSituationActuellePere() != null)
            sdccrrPereTypeInformationPere.setSituationActuellePere(fr.cg95.cvq.xml.request.babyhood.SdccrrChoixSituationActuelle.Enum.forString(getSituationActuellePere().getLegacyLabel()));
      
        saintouenDayCareCenterRegistrationRequest.setTelephoneContact(getTelephoneContact());
      
        return saintouenDayCareCenterRegistrationRequestDoc;
    }

    @Override
    public final SaintouenDayCareCenterRegistrationRequestDocument.SaintouenDayCareCenterRegistrationRequest modelToXmlRequest() {
        return modelToXml().getSaintouenDayCareCenterRegistrationRequest();
    }

    public static SaintouenDayCareCenterRegistrationRequest xmlToModel(SaintouenDayCareCenterRegistrationRequestDocument saintouenDayCareCenterRegistrationRequestDoc) {
        SaintouenDayCareCenterRegistrationRequestDocument.SaintouenDayCareCenterRegistrationRequest saintouenDayCareCenterRegistrationRequestXml = saintouenDayCareCenterRegistrationRequestDoc.getSaintouenDayCareCenterRegistrationRequest();
        Calendar calendar = Calendar.getInstance();
        LocalTime localTime = new LocalTime();
        List list = new ArrayList();
        SaintouenDayCareCenterRegistrationRequest saintouenDayCareCenterRegistrationRequest = new SaintouenDayCareCenterRegistrationRequest();
        saintouenDayCareCenterRegistrationRequest.fillCommonModelInfo(saintouenDayCareCenterRegistrationRequest, saintouenDayCareCenterRegistrationRequestXml);
        
        if (saintouenDayCareCenterRegistrationRequestXml.getChoixHorairesAccueil() != null)
            saintouenDayCareCenterRegistrationRequest.setChoixHorairesAccueil(fr.cg95.cvq.business.request.babyhood.SdccrrChoixHorairesAccueilType.forString(saintouenDayCareCenterRegistrationRequestXml.getChoixHorairesAccueil().toString()));
        else
            saintouenDayCareCenterRegistrationRequest.setChoixHorairesAccueil(fr.cg95.cvq.business.request.babyhood.SdccrrChoixHorairesAccueilType.getDefaultSdccrrChoixHorairesAccueilType());
      
        if (saintouenDayCareCenterRegistrationRequestXml.getDatePlacementAccueilRegulier().getChoixTypeDatePlacementAccueilRegulier() != null)
            saintouenDayCareCenterRegistrationRequest.setChoixTypeDatePlacementAccueilRegulier(fr.cg95.cvq.business.request.babyhood.SdccrrChoixDatePlacement.forString(saintouenDayCareCenterRegistrationRequestXml.getDatePlacementAccueilRegulier().getChoixTypeDatePlacementAccueilRegulier().toString()));
        else
            saintouenDayCareCenterRegistrationRequest.setChoixTypeDatePlacementAccueilRegulier(fr.cg95.cvq.business.request.babyhood.SdccrrChoixDatePlacement.getDefaultSdccrrChoixDatePlacement());
      
        if (saintouenDayCareCenterRegistrationRequestXml.getChoixTypeRendezVous() != null)
            saintouenDayCareCenterRegistrationRequest.setChoixTypeRendezVous(fr.cg95.cvq.business.request.babyhood.SdccrrRendezVousType.forString(saintouenDayCareCenterRegistrationRequestXml.getChoixTypeRendezVous().toString()));
        else
            saintouenDayCareCenterRegistrationRequest.setChoixTypeRendezVous(fr.cg95.cvq.business.request.babyhood.SdccrrRendezVousType.getDefaultSdccrrRendezVousType());
      
        saintouenDayCareCenterRegistrationRequest.setCommentaireCitoyen(saintouenDayCareCenterRegistrationRequestXml.getCommentaireCitoyen());
      
        saintouenDayCareCenterRegistrationRequest.setCommuneLieuTravailMere(saintouenDayCareCenterRegistrationRequestXml.getInformationMere().getCommuneLieuTravailMere());
      
        saintouenDayCareCenterRegistrationRequest.setCommuneLieuTravailPere(saintouenDayCareCenterRegistrationRequestXml.getInformationPere().getCommuneLieuTravailPere());
      
        calendar = saintouenDayCareCenterRegistrationRequestXml.getDatePlacementAccueilRegulier().getDatePlacementDebut();
        if (calendar != null) {
            saintouenDayCareCenterRegistrationRequest.setDatePlacementDebut(calendar.getTime());
        }
      
        calendar = saintouenDayCareCenterRegistrationRequestXml.getDatePlacementAccueilRegulier().getDatePlacementFin();
        if (calendar != null) {
            saintouenDayCareCenterRegistrationRequest.setDatePlacementFin(calendar.getTime());
        }
      
        calendar = saintouenDayCareCenterRegistrationRequestXml.getDixHuitMoisEnfant();
        if (calendar != null) {
            saintouenDayCareCenterRegistrationRequest.setDixHuitMoisEnfant(calendar.getTime());
        }
      
        saintouenDayCareCenterRegistrationRequest.setEmployeurMere(saintouenDayCareCenterRegistrationRequestXml.getInformationMere().getEmployeurMere());
      
        saintouenDayCareCenterRegistrationRequest.setEmployeurPere(saintouenDayCareCenterRegistrationRequestXml.getInformationPere().getEmployeurPere());
      
        saintouenDayCareCenterRegistrationRequest.setEstHorairesReguliersMere(Boolean.valueOf(saintouenDayCareCenterRegistrationRequestXml.getInformationMere().getEstHorairesReguliersMere()));
      
        saintouenDayCareCenterRegistrationRequest.setEstHorairesReguliersPere(Boolean.valueOf(saintouenDayCareCenterRegistrationRequestXml.getInformationPere().getEstHorairesReguliersPere()));
      
        calendar = saintouenDayCareCenterRegistrationRequestXml.getPlageHoraireAccueilReguliere().getHorairePlacementApresMidiDebut();
        if (calendar != null) {
            localTime = new LocalTime(calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE));
            saintouenDayCareCenterRegistrationRequest.setHorairePlacementApresMidiDebut(localTime);
        }
      
        calendar = saintouenDayCareCenterRegistrationRequestXml.getJeudi().getHorairePlacementApresMidiDebutJeudi();
        if (calendar != null) {
            localTime = new LocalTime(calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE));
            saintouenDayCareCenterRegistrationRequest.setHorairePlacementApresMidiDebutJeudi(localTime);
        }
      
        calendar = saintouenDayCareCenterRegistrationRequestXml.getLundi().getHorairePlacementApresMidiDebutLundi();
        if (calendar != null) {
            localTime = new LocalTime(calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE));
            saintouenDayCareCenterRegistrationRequest.setHorairePlacementApresMidiDebutLundi(localTime);
        }
      
        calendar = saintouenDayCareCenterRegistrationRequestXml.getMardi().getHorairePlacementApresMidiDebutMardi();
        if (calendar != null) {
            localTime = new LocalTime(calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE));
            saintouenDayCareCenterRegistrationRequest.setHorairePlacementApresMidiDebutMardi(localTime);
        }
      
        calendar = saintouenDayCareCenterRegistrationRequestXml.getMercredi().getHorairePlacementApresMidiDebutMercredi();
        if (calendar != null) {
            localTime = new LocalTime(calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE));
            saintouenDayCareCenterRegistrationRequest.setHorairePlacementApresMidiDebutMercredi(localTime);
        }
      
        calendar = saintouenDayCareCenterRegistrationRequestXml.getVendredi().getHorairePlacementApresMidiDebutVendredi();
        if (calendar != null) {
            localTime = new LocalTime(calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE));
            saintouenDayCareCenterRegistrationRequest.setHorairePlacementApresMidiDebutVendredi(localTime);
        }
      
        calendar = saintouenDayCareCenterRegistrationRequestXml.getPlageHoraireAccueilReguliere().getHorairePlacementApresMidiFin();
        if (calendar != null) {
            localTime = new LocalTime(calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE));
            saintouenDayCareCenterRegistrationRequest.setHorairePlacementApresMidiFin(localTime);
        }
      
        calendar = saintouenDayCareCenterRegistrationRequestXml.getJeudi().getHorairePlacementApresMidiFinJeudi();
        if (calendar != null) {
            localTime = new LocalTime(calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE));
            saintouenDayCareCenterRegistrationRequest.setHorairePlacementApresMidiFinJeudi(localTime);
        }
      
        calendar = saintouenDayCareCenterRegistrationRequestXml.getLundi().getHorairePlacementApresMidiFinLundi();
        if (calendar != null) {
            localTime = new LocalTime(calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE));
            saintouenDayCareCenterRegistrationRequest.setHorairePlacementApresMidiFinLundi(localTime);
        }
      
        calendar = saintouenDayCareCenterRegistrationRequestXml.getMardi().getHorairePlacementApresMidiFinMardi();
        if (calendar != null) {
            localTime = new LocalTime(calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE));
            saintouenDayCareCenterRegistrationRequest.setHorairePlacementApresMidiFinMardi(localTime);
        }
      
        calendar = saintouenDayCareCenterRegistrationRequestXml.getMercredi().getHorairePlacementApresMidiFinMercredi();
        if (calendar != null) {
            localTime = new LocalTime(calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE));
            saintouenDayCareCenterRegistrationRequest.setHorairePlacementApresMidiFinMercredi(localTime);
        }
      
        calendar = saintouenDayCareCenterRegistrationRequestXml.getVendredi().getHorairePlacementApresMidiFinVendredi();
        if (calendar != null) {
            localTime = new LocalTime(calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE));
            saintouenDayCareCenterRegistrationRequest.setHorairePlacementApresMidiFinVendredi(localTime);
        }
      
        calendar = saintouenDayCareCenterRegistrationRequestXml.getPlageHoraireAccueilReguliere().getHorairePlacementMatinDebut();
        if (calendar != null) {
            localTime = new LocalTime(calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE));
            saintouenDayCareCenterRegistrationRequest.setHorairePlacementMatinDebut(localTime);
        }
      
        calendar = saintouenDayCareCenterRegistrationRequestXml.getJeudi().getHorairePlacementMatinDebutJeudi();
        if (calendar != null) {
            localTime = new LocalTime(calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE));
            saintouenDayCareCenterRegistrationRequest.setHorairePlacementMatinDebutJeudi(localTime);
        }
      
        calendar = saintouenDayCareCenterRegistrationRequestXml.getLundi().getHorairePlacementMatinDebutLundi();
        if (calendar != null) {
            localTime = new LocalTime(calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE));
            saintouenDayCareCenterRegistrationRequest.setHorairePlacementMatinDebutLundi(localTime);
        }
      
        calendar = saintouenDayCareCenterRegistrationRequestXml.getMardi().getHorairePlacementMatinDebutMardi();
        if (calendar != null) {
            localTime = new LocalTime(calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE));
            saintouenDayCareCenterRegistrationRequest.setHorairePlacementMatinDebutMardi(localTime);
        }
      
        calendar = saintouenDayCareCenterRegistrationRequestXml.getMercredi().getHorairePlacementMatinDebutMercredi();
        if (calendar != null) {
            localTime = new LocalTime(calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE));
            saintouenDayCareCenterRegistrationRequest.setHorairePlacementMatinDebutMercredi(localTime);
        }
      
        calendar = saintouenDayCareCenterRegistrationRequestXml.getVendredi().getHorairePlacementMatinDebutVendredi();
        if (calendar != null) {
            localTime = new LocalTime(calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE));
            saintouenDayCareCenterRegistrationRequest.setHorairePlacementMatinDebutVendredi(localTime);
        }
      
        calendar = saintouenDayCareCenterRegistrationRequestXml.getPlageHoraireAccueilReguliere().getHorairePlacementMatinFin();
        if (calendar != null) {
            localTime = new LocalTime(calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE));
            saintouenDayCareCenterRegistrationRequest.setHorairePlacementMatinFin(localTime);
        }
      
        calendar = saintouenDayCareCenterRegistrationRequestXml.getJeudi().getHorairePlacementMatinFinJeudi();
        if (calendar != null) {
            localTime = new LocalTime(calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE));
            saintouenDayCareCenterRegistrationRequest.setHorairePlacementMatinFinJeudi(localTime);
        }
      
        calendar = saintouenDayCareCenterRegistrationRequestXml.getLundi().getHorairePlacementMatinFinLundi();
        if (calendar != null) {
            localTime = new LocalTime(calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE));
            saintouenDayCareCenterRegistrationRequest.setHorairePlacementMatinFinLundi(localTime);
        }
      
        calendar = saintouenDayCareCenterRegistrationRequestXml.getMardi().getHorairePlacementMatinFinMardi();
        if (calendar != null) {
            localTime = new LocalTime(calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE));
            saintouenDayCareCenterRegistrationRequest.setHorairePlacementMatinFinMardi(localTime);
        }
      
        calendar = saintouenDayCareCenterRegistrationRequestXml.getMercredi().getHorairePlacementMatinFinMercredi();
        if (calendar != null) {
            localTime = new LocalTime(calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE));
            saintouenDayCareCenterRegistrationRequest.setHorairePlacementMatinFinMercredi(localTime);
        }
      
        calendar = saintouenDayCareCenterRegistrationRequestXml.getVendredi().getHorairePlacementMatinFinVendredi();
        if (calendar != null) {
            localTime = new LocalTime(calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE));
            saintouenDayCareCenterRegistrationRequest.setHorairePlacementMatinFinVendredi(localTime);
        }
      
        saintouenDayCareCenterRegistrationRequest.setHorairesReguliersMere(saintouenDayCareCenterRegistrationRequestXml.getInformationMere().getHorairesReguliersMere());
      
        saintouenDayCareCenterRegistrationRequest.setHorairesReguliersPere(saintouenDayCareCenterRegistrationRequestXml.getInformationPere().getHorairesReguliersPere());
      
        saintouenDayCareCenterRegistrationRequest.setHorairesTravailJeudiMere(saintouenDayCareCenterRegistrationRequestXml.getInformationMere().getHorairesTravailJeudiMere());
      
        saintouenDayCareCenterRegistrationRequest.setHorairesTravailJeudiPere(saintouenDayCareCenterRegistrationRequestXml.getInformationPere().getHorairesTravailJeudiPere());
      
        saintouenDayCareCenterRegistrationRequest.setHorairesTravailLundiMere(saintouenDayCareCenterRegistrationRequestXml.getInformationMere().getHorairesTravailLundiMere());
      
        saintouenDayCareCenterRegistrationRequest.setHorairesTravailLundiPere(saintouenDayCareCenterRegistrationRequestXml.getInformationPere().getHorairesTravailLundiPere());
      
        saintouenDayCareCenterRegistrationRequest.setHorairesTravailMardiMere(saintouenDayCareCenterRegistrationRequestXml.getInformationMere().getHorairesTravailMardiMere());
      
        saintouenDayCareCenterRegistrationRequest.setHorairesTravailMardiPere(saintouenDayCareCenterRegistrationRequestXml.getInformationPere().getHorairesTravailMardiPere());
      
        saintouenDayCareCenterRegistrationRequest.setHorairesTravailMercrediMere(saintouenDayCareCenterRegistrationRequestXml.getInformationMere().getHorairesTravailMercrediMere());
      
        saintouenDayCareCenterRegistrationRequest.setHorairesTravailMercrediPere(saintouenDayCareCenterRegistrationRequestXml.getInformationPere().getHorairesTravailMercrediPere());
      
        saintouenDayCareCenterRegistrationRequest.setHorairesTravailVendrediMere(saintouenDayCareCenterRegistrationRequestXml.getInformationMere().getHorairesTravailVendrediMere());
      
        saintouenDayCareCenterRegistrationRequest.setHorairesTravailVendrediPere(saintouenDayCareCenterRegistrationRequestXml.getInformationPere().getHorairesTravailVendrediPere());
      
        List<fr.cg95.cvq.business.request.LocalReferentialData> plageHoraireContactList = new ArrayList<fr.cg95.cvq.business.request.LocalReferentialData>(saintouenDayCareCenterRegistrationRequestXml.sizeOfPlageHoraireContactArray());
        for (LocalReferentialDataType object : saintouenDayCareCenterRegistrationRequestXml.getPlageHoraireContactArray()) {
            plageHoraireContactList.add(fr.cg95.cvq.business.request.LocalReferentialData.xmlToModel(object));
        }
        saintouenDayCareCenterRegistrationRequest.setPlageHoraireContact(plageHoraireContactList);
      
        saintouenDayCareCenterRegistrationRequest.setPrecisionAutreSituationActuelleMere(saintouenDayCareCenterRegistrationRequestXml.getInformationMere().getPrecisionAutreSituationActuelleMere());
      
        saintouenDayCareCenterRegistrationRequest.setPrecisionAutreSituationActuellePere(saintouenDayCareCenterRegistrationRequestXml.getInformationPere().getPrecisionAutreSituationActuellePere());
      
        saintouenDayCareCenterRegistrationRequest.setProfessionMere(saintouenDayCareCenterRegistrationRequestXml.getInformationMere().getProfessionMere());
      
        saintouenDayCareCenterRegistrationRequest.setProfessionPere(saintouenDayCareCenterRegistrationRequestXml.getInformationPere().getProfessionPere());
      
        if (saintouenDayCareCenterRegistrationRequestXml.getInformationMere().getSituationActuelleMere() != null)
            saintouenDayCareCenterRegistrationRequest.setSituationActuelleMere(fr.cg95.cvq.business.request.babyhood.SdccrrChoixSituationActuelle.forString(saintouenDayCareCenterRegistrationRequestXml.getInformationMere().getSituationActuelleMere().toString()));
        else
            saintouenDayCareCenterRegistrationRequest.setSituationActuelleMere(fr.cg95.cvq.business.request.babyhood.SdccrrChoixSituationActuelle.getDefaultSdccrrChoixSituationActuelle());
      
        if (saintouenDayCareCenterRegistrationRequestXml.getInformationPere().getSituationActuellePere() != null)
            saintouenDayCareCenterRegistrationRequest.setSituationActuellePere(fr.cg95.cvq.business.request.babyhood.SdccrrChoixSituationActuelle.forString(saintouenDayCareCenterRegistrationRequestXml.getInformationPere().getSituationActuellePere().toString()));
        else
            saintouenDayCareCenterRegistrationRequest.setSituationActuellePere(fr.cg95.cvq.business.request.babyhood.SdccrrChoixSituationActuelle.getDefaultSdccrrChoixSituationActuelle());
      
        saintouenDayCareCenterRegistrationRequest.setTelephoneContact(saintouenDayCareCenterRegistrationRequestXml.getTelephoneContact());
      
        return saintouenDayCareCenterRegistrationRequest;
    }

    @Override
    public SaintouenDayCareCenterRegistrationRequest clone() {
        SaintouenDayCareCenterRegistrationRequest clone = new SaintouenDayCareCenterRegistrationRequest(getRequestData().clone(), saintouenDayCareCenterRegistrationRequestData.clone());
        Map<String, Object> stepState;
        
          stepState = new HashMap<String, Object>(4);
          stepState.put("state", "uncomplete");
          stepState.put("required", false);
          stepState.put("errorMsg", null);
          stepState.put("invalidFields", new ArrayList<String>());
          clone.getStepStates().put("homeFolder", stepState);
        
          stepState = new HashMap<String, Object>(4);
          stepState.put("state", "unavailable");
          stepState.put("required", true);
          stepState.put("errorMsg", null);
          stepState.put("invalidFields", new ArrayList<String>());
          clone.getStepStates().put("subject", stepState);
        
          stepState = new HashMap<String, Object>(4);
          stepState.put("state", "unavailable");
          stepState.put("required", true);
          stepState.put("errorMsg", null);
          stepState.put("invalidFields", new ArrayList<String>());
          clone.getStepStates().put("accueil", stepState);
        
          stepState = new HashMap<String, Object>(4);
          stepState.put("state", "unavailable");
          stepState.put("required", true);
          stepState.put("errorMsg", null);
          stepState.put("invalidFields", new ArrayList<String>());
          clone.getStepStates().put("rendezVous", stepState);
        
          stepState = new HashMap<String, Object>(4);
          stepState.put("state", "unavailable");
          stepState.put("required", false);
          stepState.put("errorMsg", null);
          stepState.put("invalidFields", new ArrayList<String>());
          clone.getStepStates().put("document", stepState);
        
          stepState = new HashMap<String, Object>(4);
          stepState.put("state", "unavailable");
          stepState.put("required", true);
          stepState.put("errorMsg", null);
          stepState.put("invalidFields", new ArrayList<String>());
          clone.getStepStates().put("validation", stepState);
        
        return clone;
    }

  
    public final void setChoixHorairesAccueil(final fr.cg95.cvq.business.request.babyhood.SdccrrChoixHorairesAccueilType choixHorairesAccueil) {
        saintouenDayCareCenterRegistrationRequestData.setChoixHorairesAccueil(choixHorairesAccueil);
    }

    
    public final fr.cg95.cvq.business.request.babyhood.SdccrrChoixHorairesAccueilType getChoixHorairesAccueil() {
        return saintouenDayCareCenterRegistrationRequestData.getChoixHorairesAccueil();
    }
  
    public final void setChoixTypeDatePlacementAccueilRegulier(final fr.cg95.cvq.business.request.babyhood.SdccrrChoixDatePlacement choixTypeDatePlacementAccueilRegulier) {
        saintouenDayCareCenterRegistrationRequestData.setChoixTypeDatePlacementAccueilRegulier(choixTypeDatePlacementAccueilRegulier);
    }

    
    public final fr.cg95.cvq.business.request.babyhood.SdccrrChoixDatePlacement getChoixTypeDatePlacementAccueilRegulier() {
        return saintouenDayCareCenterRegistrationRequestData.getChoixTypeDatePlacementAccueilRegulier();
    }
  
    public final void setChoixTypeRendezVous(final fr.cg95.cvq.business.request.babyhood.SdccrrRendezVousType choixTypeRendezVous) {
        saintouenDayCareCenterRegistrationRequestData.setChoixTypeRendezVous(choixTypeRendezVous);
    }

    
    public final fr.cg95.cvq.business.request.babyhood.SdccrrRendezVousType getChoixTypeRendezVous() {
        return saintouenDayCareCenterRegistrationRequestData.getChoixTypeRendezVous();
    }
  
    public final void setCommentaireCitoyen(final String commentaireCitoyen) {
        saintouenDayCareCenterRegistrationRequestData.setCommentaireCitoyen(commentaireCitoyen);
    }

    
    public final String getCommentaireCitoyen() {
        return saintouenDayCareCenterRegistrationRequestData.getCommentaireCitoyen();
    }
  
    public final void setCommuneLieuTravailMere(final String communeLieuTravailMere) {
        saintouenDayCareCenterRegistrationRequestData.setCommuneLieuTravailMere(communeLieuTravailMere);
    }

    
    public final String getCommuneLieuTravailMere() {
        return saintouenDayCareCenterRegistrationRequestData.getCommuneLieuTravailMere();
    }
  
    public final void setCommuneLieuTravailPere(final String communeLieuTravailPere) {
        saintouenDayCareCenterRegistrationRequestData.setCommuneLieuTravailPere(communeLieuTravailPere);
    }

    
    public final String getCommuneLieuTravailPere() {
        return saintouenDayCareCenterRegistrationRequestData.getCommuneLieuTravailPere();
    }
  
    public final void setDatePlacementDebut(final java.util.Date datePlacementDebut) {
        saintouenDayCareCenterRegistrationRequestData.setDatePlacementDebut(datePlacementDebut);
    }

    
    public final java.util.Date getDatePlacementDebut() {
        return saintouenDayCareCenterRegistrationRequestData.getDatePlacementDebut();
    }
  
    public final void setDatePlacementFin(final java.util.Date datePlacementFin) {
        saintouenDayCareCenterRegistrationRequestData.setDatePlacementFin(datePlacementFin);
    }

    
    public final java.util.Date getDatePlacementFin() {
        return saintouenDayCareCenterRegistrationRequestData.getDatePlacementFin();
    }
  
    public final void setDixHuitMoisEnfant(final java.util.Date dixHuitMoisEnfant) {
        saintouenDayCareCenterRegistrationRequestData.setDixHuitMoisEnfant(dixHuitMoisEnfant);
    }

    
    public final java.util.Date getDixHuitMoisEnfant() {
        return saintouenDayCareCenterRegistrationRequestData.getDixHuitMoisEnfant();
    }
  
    public final void setEmployeurMere(final String employeurMere) {
        saintouenDayCareCenterRegistrationRequestData.setEmployeurMere(employeurMere);
    }

    
    public final String getEmployeurMere() {
        return saintouenDayCareCenterRegistrationRequestData.getEmployeurMere();
    }
  
    public final void setEmployeurPere(final String employeurPere) {
        saintouenDayCareCenterRegistrationRequestData.setEmployeurPere(employeurPere);
    }

    
    public final String getEmployeurPere() {
        return saintouenDayCareCenterRegistrationRequestData.getEmployeurPere();
    }
  
    public final void setEstHorairesReguliersMere(final Boolean estHorairesReguliersMere) {
        saintouenDayCareCenterRegistrationRequestData.setEstHorairesReguliersMere(estHorairesReguliersMere);
    }

    
    public final Boolean getEstHorairesReguliersMere() {
        return saintouenDayCareCenterRegistrationRequestData.getEstHorairesReguliersMere();
    }
  
    public final void setEstHorairesReguliersPere(final Boolean estHorairesReguliersPere) {
        saintouenDayCareCenterRegistrationRequestData.setEstHorairesReguliersPere(estHorairesReguliersPere);
    }

    
    public final Boolean getEstHorairesReguliersPere() {
        return saintouenDayCareCenterRegistrationRequestData.getEstHorairesReguliersPere();
    }
  
    public final void setHorairePlacementApresMidiDebut(final org.joda.time.LocalTime horairePlacementApresMidiDebut) {
        saintouenDayCareCenterRegistrationRequestData.setHorairePlacementApresMidiDebut(horairePlacementApresMidiDebut);
    }

    
    public final org.joda.time.LocalTime getHorairePlacementApresMidiDebut() {
        return saintouenDayCareCenterRegistrationRequestData.getHorairePlacementApresMidiDebut();
    }
  
    public final void setHorairePlacementApresMidiDebutJeudi(final org.joda.time.LocalTime horairePlacementApresMidiDebutJeudi) {
        saintouenDayCareCenterRegistrationRequestData.setHorairePlacementApresMidiDebutJeudi(horairePlacementApresMidiDebutJeudi);
    }

    
    public final org.joda.time.LocalTime getHorairePlacementApresMidiDebutJeudi() {
        return saintouenDayCareCenterRegistrationRequestData.getHorairePlacementApresMidiDebutJeudi();
    }
  
    public final void setHorairePlacementApresMidiDebutLundi(final org.joda.time.LocalTime horairePlacementApresMidiDebutLundi) {
        saintouenDayCareCenterRegistrationRequestData.setHorairePlacementApresMidiDebutLundi(horairePlacementApresMidiDebutLundi);
    }

    
    public final org.joda.time.LocalTime getHorairePlacementApresMidiDebutLundi() {
        return saintouenDayCareCenterRegistrationRequestData.getHorairePlacementApresMidiDebutLundi();
    }
  
    public final void setHorairePlacementApresMidiDebutMardi(final org.joda.time.LocalTime horairePlacementApresMidiDebutMardi) {
        saintouenDayCareCenterRegistrationRequestData.setHorairePlacementApresMidiDebutMardi(horairePlacementApresMidiDebutMardi);
    }

    
    public final org.joda.time.LocalTime getHorairePlacementApresMidiDebutMardi() {
        return saintouenDayCareCenterRegistrationRequestData.getHorairePlacementApresMidiDebutMardi();
    }
  
    public final void setHorairePlacementApresMidiDebutMercredi(final org.joda.time.LocalTime horairePlacementApresMidiDebutMercredi) {
        saintouenDayCareCenterRegistrationRequestData.setHorairePlacementApresMidiDebutMercredi(horairePlacementApresMidiDebutMercredi);
    }

    
    public final org.joda.time.LocalTime getHorairePlacementApresMidiDebutMercredi() {
        return saintouenDayCareCenterRegistrationRequestData.getHorairePlacementApresMidiDebutMercredi();
    }
  
    public final void setHorairePlacementApresMidiDebutVendredi(final org.joda.time.LocalTime horairePlacementApresMidiDebutVendredi) {
        saintouenDayCareCenterRegistrationRequestData.setHorairePlacementApresMidiDebutVendredi(horairePlacementApresMidiDebutVendredi);
    }

    
    public final org.joda.time.LocalTime getHorairePlacementApresMidiDebutVendredi() {
        return saintouenDayCareCenterRegistrationRequestData.getHorairePlacementApresMidiDebutVendredi();
    }
  
    public final void setHorairePlacementApresMidiFin(final org.joda.time.LocalTime horairePlacementApresMidiFin) {
        saintouenDayCareCenterRegistrationRequestData.setHorairePlacementApresMidiFin(horairePlacementApresMidiFin);
    }

    
    public final org.joda.time.LocalTime getHorairePlacementApresMidiFin() {
        return saintouenDayCareCenterRegistrationRequestData.getHorairePlacementApresMidiFin();
    }
  
    public final void setHorairePlacementApresMidiFinJeudi(final org.joda.time.LocalTime horairePlacementApresMidiFinJeudi) {
        saintouenDayCareCenterRegistrationRequestData.setHorairePlacementApresMidiFinJeudi(horairePlacementApresMidiFinJeudi);
    }

    
    public final org.joda.time.LocalTime getHorairePlacementApresMidiFinJeudi() {
        return saintouenDayCareCenterRegistrationRequestData.getHorairePlacementApresMidiFinJeudi();
    }
  
    public final void setHorairePlacementApresMidiFinLundi(final org.joda.time.LocalTime horairePlacementApresMidiFinLundi) {
        saintouenDayCareCenterRegistrationRequestData.setHorairePlacementApresMidiFinLundi(horairePlacementApresMidiFinLundi);
    }

    
    public final org.joda.time.LocalTime getHorairePlacementApresMidiFinLundi() {
        return saintouenDayCareCenterRegistrationRequestData.getHorairePlacementApresMidiFinLundi();
    }
  
    public final void setHorairePlacementApresMidiFinMardi(final org.joda.time.LocalTime horairePlacementApresMidiFinMardi) {
        saintouenDayCareCenterRegistrationRequestData.setHorairePlacementApresMidiFinMardi(horairePlacementApresMidiFinMardi);
    }

    
    public final org.joda.time.LocalTime getHorairePlacementApresMidiFinMardi() {
        return saintouenDayCareCenterRegistrationRequestData.getHorairePlacementApresMidiFinMardi();
    }
  
    public final void setHorairePlacementApresMidiFinMercredi(final org.joda.time.LocalTime horairePlacementApresMidiFinMercredi) {
        saintouenDayCareCenterRegistrationRequestData.setHorairePlacementApresMidiFinMercredi(horairePlacementApresMidiFinMercredi);
    }

    
    public final org.joda.time.LocalTime getHorairePlacementApresMidiFinMercredi() {
        return saintouenDayCareCenterRegistrationRequestData.getHorairePlacementApresMidiFinMercredi();
    }
  
    public final void setHorairePlacementApresMidiFinVendredi(final org.joda.time.LocalTime horairePlacementApresMidiFinVendredi) {
        saintouenDayCareCenterRegistrationRequestData.setHorairePlacementApresMidiFinVendredi(horairePlacementApresMidiFinVendredi);
    }

    
    public final org.joda.time.LocalTime getHorairePlacementApresMidiFinVendredi() {
        return saintouenDayCareCenterRegistrationRequestData.getHorairePlacementApresMidiFinVendredi();
    }
  
    public final void setHorairePlacementMatinDebut(final org.joda.time.LocalTime horairePlacementMatinDebut) {
        saintouenDayCareCenterRegistrationRequestData.setHorairePlacementMatinDebut(horairePlacementMatinDebut);
    }

    
    public final org.joda.time.LocalTime getHorairePlacementMatinDebut() {
        return saintouenDayCareCenterRegistrationRequestData.getHorairePlacementMatinDebut();
    }
  
    public final void setHorairePlacementMatinDebutJeudi(final org.joda.time.LocalTime horairePlacementMatinDebutJeudi) {
        saintouenDayCareCenterRegistrationRequestData.setHorairePlacementMatinDebutJeudi(horairePlacementMatinDebutJeudi);
    }

    
    public final org.joda.time.LocalTime getHorairePlacementMatinDebutJeudi() {
        return saintouenDayCareCenterRegistrationRequestData.getHorairePlacementMatinDebutJeudi();
    }
  
    public final void setHorairePlacementMatinDebutLundi(final org.joda.time.LocalTime horairePlacementMatinDebutLundi) {
        saintouenDayCareCenterRegistrationRequestData.setHorairePlacementMatinDebutLundi(horairePlacementMatinDebutLundi);
    }

    
    public final org.joda.time.LocalTime getHorairePlacementMatinDebutLundi() {
        return saintouenDayCareCenterRegistrationRequestData.getHorairePlacementMatinDebutLundi();
    }
  
    public final void setHorairePlacementMatinDebutMardi(final org.joda.time.LocalTime horairePlacementMatinDebutMardi) {
        saintouenDayCareCenterRegistrationRequestData.setHorairePlacementMatinDebutMardi(horairePlacementMatinDebutMardi);
    }

    
    public final org.joda.time.LocalTime getHorairePlacementMatinDebutMardi() {
        return saintouenDayCareCenterRegistrationRequestData.getHorairePlacementMatinDebutMardi();
    }
  
    public final void setHorairePlacementMatinDebutMercredi(final org.joda.time.LocalTime horairePlacementMatinDebutMercredi) {
        saintouenDayCareCenterRegistrationRequestData.setHorairePlacementMatinDebutMercredi(horairePlacementMatinDebutMercredi);
    }

    
    public final org.joda.time.LocalTime getHorairePlacementMatinDebutMercredi() {
        return saintouenDayCareCenterRegistrationRequestData.getHorairePlacementMatinDebutMercredi();
    }
  
    public final void setHorairePlacementMatinDebutVendredi(final org.joda.time.LocalTime horairePlacementMatinDebutVendredi) {
        saintouenDayCareCenterRegistrationRequestData.setHorairePlacementMatinDebutVendredi(horairePlacementMatinDebutVendredi);
    }

    
    public final org.joda.time.LocalTime getHorairePlacementMatinDebutVendredi() {
        return saintouenDayCareCenterRegistrationRequestData.getHorairePlacementMatinDebutVendredi();
    }
  
    public final void setHorairePlacementMatinFin(final org.joda.time.LocalTime horairePlacementMatinFin) {
        saintouenDayCareCenterRegistrationRequestData.setHorairePlacementMatinFin(horairePlacementMatinFin);
    }

    
    public final org.joda.time.LocalTime getHorairePlacementMatinFin() {
        return saintouenDayCareCenterRegistrationRequestData.getHorairePlacementMatinFin();
    }
  
    public final void setHorairePlacementMatinFinJeudi(final org.joda.time.LocalTime horairePlacementMatinFinJeudi) {
        saintouenDayCareCenterRegistrationRequestData.setHorairePlacementMatinFinJeudi(horairePlacementMatinFinJeudi);
    }

    
    public final org.joda.time.LocalTime getHorairePlacementMatinFinJeudi() {
        return saintouenDayCareCenterRegistrationRequestData.getHorairePlacementMatinFinJeudi();
    }
  
    public final void setHorairePlacementMatinFinLundi(final org.joda.time.LocalTime horairePlacementMatinFinLundi) {
        saintouenDayCareCenterRegistrationRequestData.setHorairePlacementMatinFinLundi(horairePlacementMatinFinLundi);
    }

    
    public final org.joda.time.LocalTime getHorairePlacementMatinFinLundi() {
        return saintouenDayCareCenterRegistrationRequestData.getHorairePlacementMatinFinLundi();
    }
  
    public final void setHorairePlacementMatinFinMardi(final org.joda.time.LocalTime horairePlacementMatinFinMardi) {
        saintouenDayCareCenterRegistrationRequestData.setHorairePlacementMatinFinMardi(horairePlacementMatinFinMardi);
    }

    
    public final org.joda.time.LocalTime getHorairePlacementMatinFinMardi() {
        return saintouenDayCareCenterRegistrationRequestData.getHorairePlacementMatinFinMardi();
    }
  
    public final void setHorairePlacementMatinFinMercredi(final org.joda.time.LocalTime horairePlacementMatinFinMercredi) {
        saintouenDayCareCenterRegistrationRequestData.setHorairePlacementMatinFinMercredi(horairePlacementMatinFinMercredi);
    }

    
    public final org.joda.time.LocalTime getHorairePlacementMatinFinMercredi() {
        return saintouenDayCareCenterRegistrationRequestData.getHorairePlacementMatinFinMercredi();
    }
  
    public final void setHorairePlacementMatinFinVendredi(final org.joda.time.LocalTime horairePlacementMatinFinVendredi) {
        saintouenDayCareCenterRegistrationRequestData.setHorairePlacementMatinFinVendredi(horairePlacementMatinFinVendredi);
    }

    
    public final org.joda.time.LocalTime getHorairePlacementMatinFinVendredi() {
        return saintouenDayCareCenterRegistrationRequestData.getHorairePlacementMatinFinVendredi();
    }
  
    public final void setHorairesReguliersMere(final String horairesReguliersMere) {
        saintouenDayCareCenterRegistrationRequestData.setHorairesReguliersMere(horairesReguliersMere);
    }

    
    public final String getHorairesReguliersMere() {
        return saintouenDayCareCenterRegistrationRequestData.getHorairesReguliersMere();
    }
  
    public final void setHorairesReguliersPere(final String horairesReguliersPere) {
        saintouenDayCareCenterRegistrationRequestData.setHorairesReguliersPere(horairesReguliersPere);
    }

    
    public final String getHorairesReguliersPere() {
        return saintouenDayCareCenterRegistrationRequestData.getHorairesReguliersPere();
    }
  
    public final void setHorairesTravailJeudiMere(final String horairesTravailJeudiMere) {
        saintouenDayCareCenterRegistrationRequestData.setHorairesTravailJeudiMere(horairesTravailJeudiMere);
    }

    
    public final String getHorairesTravailJeudiMere() {
        return saintouenDayCareCenterRegistrationRequestData.getHorairesTravailJeudiMere();
    }
  
    public final void setHorairesTravailJeudiPere(final String horairesTravailJeudiPere) {
        saintouenDayCareCenterRegistrationRequestData.setHorairesTravailJeudiPere(horairesTravailJeudiPere);
    }

    
    public final String getHorairesTravailJeudiPere() {
        return saintouenDayCareCenterRegistrationRequestData.getHorairesTravailJeudiPere();
    }
  
    public final void setHorairesTravailLundiMere(final String horairesTravailLundiMere) {
        saintouenDayCareCenterRegistrationRequestData.setHorairesTravailLundiMere(horairesTravailLundiMere);
    }

    
    public final String getHorairesTravailLundiMere() {
        return saintouenDayCareCenterRegistrationRequestData.getHorairesTravailLundiMere();
    }
  
    public final void setHorairesTravailLundiPere(final String horairesTravailLundiPere) {
        saintouenDayCareCenterRegistrationRequestData.setHorairesTravailLundiPere(horairesTravailLundiPere);
    }

    
    public final String getHorairesTravailLundiPere() {
        return saintouenDayCareCenterRegistrationRequestData.getHorairesTravailLundiPere();
    }
  
    public final void setHorairesTravailMardiMere(final String horairesTravailMardiMere) {
        saintouenDayCareCenterRegistrationRequestData.setHorairesTravailMardiMere(horairesTravailMardiMere);
    }

    
    public final String getHorairesTravailMardiMere() {
        return saintouenDayCareCenterRegistrationRequestData.getHorairesTravailMardiMere();
    }
  
    public final void setHorairesTravailMardiPere(final String horairesTravailMardiPere) {
        saintouenDayCareCenterRegistrationRequestData.setHorairesTravailMardiPere(horairesTravailMardiPere);
    }

    
    public final String getHorairesTravailMardiPere() {
        return saintouenDayCareCenterRegistrationRequestData.getHorairesTravailMardiPere();
    }
  
    public final void setHorairesTravailMercrediMere(final String horairesTravailMercrediMere) {
        saintouenDayCareCenterRegistrationRequestData.setHorairesTravailMercrediMere(horairesTravailMercrediMere);
    }

    
    public final String getHorairesTravailMercrediMere() {
        return saintouenDayCareCenterRegistrationRequestData.getHorairesTravailMercrediMere();
    }
  
    public final void setHorairesTravailMercrediPere(final String horairesTravailMercrediPere) {
        saintouenDayCareCenterRegistrationRequestData.setHorairesTravailMercrediPere(horairesTravailMercrediPere);
    }

    
    public final String getHorairesTravailMercrediPere() {
        return saintouenDayCareCenterRegistrationRequestData.getHorairesTravailMercrediPere();
    }
  
    public final void setHorairesTravailVendrediMere(final String horairesTravailVendrediMere) {
        saintouenDayCareCenterRegistrationRequestData.setHorairesTravailVendrediMere(horairesTravailVendrediMere);
    }

    
    public final String getHorairesTravailVendrediMere() {
        return saintouenDayCareCenterRegistrationRequestData.getHorairesTravailVendrediMere();
    }
  
    public final void setHorairesTravailVendrediPere(final String horairesTravailVendrediPere) {
        saintouenDayCareCenterRegistrationRequestData.setHorairesTravailVendrediPere(horairesTravailVendrediPere);
    }

    
    public final String getHorairesTravailVendrediPere() {
        return saintouenDayCareCenterRegistrationRequestData.getHorairesTravailVendrediPere();
    }
  
    public final void setPlageHoraireContact(final List<fr.cg95.cvq.business.request.LocalReferentialData> plageHoraireContact) {
        saintouenDayCareCenterRegistrationRequestData.setPlageHoraireContact(plageHoraireContact);
    }

    
    public final List<fr.cg95.cvq.business.request.LocalReferentialData> getPlageHoraireContact() {
        return saintouenDayCareCenterRegistrationRequestData.getPlageHoraireContact();
    }
  
    public final void setPrecisionAutreSituationActuelleMere(final String precisionAutreSituationActuelleMere) {
        saintouenDayCareCenterRegistrationRequestData.setPrecisionAutreSituationActuelleMere(precisionAutreSituationActuelleMere);
    }

    
    public final String getPrecisionAutreSituationActuelleMere() {
        return saintouenDayCareCenterRegistrationRequestData.getPrecisionAutreSituationActuelleMere();
    }
  
    public final void setPrecisionAutreSituationActuellePere(final String precisionAutreSituationActuellePere) {
        saintouenDayCareCenterRegistrationRequestData.setPrecisionAutreSituationActuellePere(precisionAutreSituationActuellePere);
    }

    
    public final String getPrecisionAutreSituationActuellePere() {
        return saintouenDayCareCenterRegistrationRequestData.getPrecisionAutreSituationActuellePere();
    }
  
    public final void setProfessionMere(final String professionMere) {
        saintouenDayCareCenterRegistrationRequestData.setProfessionMere(professionMere);
    }

    
    public final String getProfessionMere() {
        return saintouenDayCareCenterRegistrationRequestData.getProfessionMere();
    }
  
    public final void setProfessionPere(final String professionPere) {
        saintouenDayCareCenterRegistrationRequestData.setProfessionPere(professionPere);
    }

    
    public final String getProfessionPere() {
        return saintouenDayCareCenterRegistrationRequestData.getProfessionPere();
    }
  
    public final void setSituationActuelleMere(final fr.cg95.cvq.business.request.babyhood.SdccrrChoixSituationActuelle situationActuelleMere) {
        saintouenDayCareCenterRegistrationRequestData.setSituationActuelleMere(situationActuelleMere);
    }

    
    public final fr.cg95.cvq.business.request.babyhood.SdccrrChoixSituationActuelle getSituationActuelleMere() {
        return saintouenDayCareCenterRegistrationRequestData.getSituationActuelleMere();
    }
  
    public final void setSituationActuellePere(final fr.cg95.cvq.business.request.babyhood.SdccrrChoixSituationActuelle situationActuellePere) {
        saintouenDayCareCenterRegistrationRequestData.setSituationActuellePere(situationActuellePere);
    }

    
    public final fr.cg95.cvq.business.request.babyhood.SdccrrChoixSituationActuelle getSituationActuellePere() {
        return saintouenDayCareCenterRegistrationRequestData.getSituationActuellePere();
    }
  
    public final void setTelephoneContact(final String telephoneContact) {
        saintouenDayCareCenterRegistrationRequestData.setTelephoneContact(telephoneContact);
    }

    
    public final String getTelephoneContact() {
        return saintouenDayCareCenterRegistrationRequestData.getTelephoneContact();
    }
  
}
