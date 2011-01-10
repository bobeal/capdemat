
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
import org.joda.time.LocalTime;

import net.sf.oval.constraint.AssertValid;
import org.apache.xmlbeans.XmlOptions;
import fr.cg95.cvq.business.authority.*;
import fr.cg95.cvq.business.request.*;
import fr.cg95.cvq.business.request.annotation.*;
import fr.cg95.cvq.business.users.*;
import fr.cg95.cvq.xml.common.*;
import fr.cg95.cvq.xml.request.school.*;
import fr.cg95.cvq.service.request.condition.IConditionChecker;

/**
 * Generated class file, do not edit !
 */
public class DayCareCenterRegistrationRequest extends Request implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final Map<String, IConditionChecker> conditions = DayCareCenterRegistrationRequestData.conditions;

    @AssertValid(message = "")
    private DayCareCenterRegistrationRequestData dayCareCenterRegistrationRequestData;

    public DayCareCenterRegistrationRequest(RequestData requestData, DayCareCenterRegistrationRequestData dayCareCenterRegistrationRequestData) {
        super(requestData);
        this.dayCareCenterRegistrationRequestData = dayCareCenterRegistrationRequestData;
    }

    public DayCareCenterRegistrationRequest() {
        super();
        this.dayCareCenterRegistrationRequestData = new DayCareCenterRegistrationRequestData();
        Map<String, Object> stepState;
        
          stepState = new HashMap<String, Object>(4);
          stepState.put("state", "uncomplete");
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
    public DayCareCenterRegistrationRequestData getSpecificData() {
        return dayCareCenterRegistrationRequestData;
    }

    /**
     * Reserved for RequestDAO !
     */
    public void setSpecificData(DayCareCenterRegistrationRequestData dayCareCenterRegistrationRequestData) {
        this.dayCareCenterRegistrationRequestData = dayCareCenterRegistrationRequestData;
    }

    @Override
    public final String modelToXmlString() {
        DayCareCenterRegistrationRequestDocument object = this.modelToXml();
        XmlOptions opts = new XmlOptions();
        opts.setSavePrettyPrint();
        opts.setSavePrettyPrintIndent(4);
        opts.setUseDefaultNamespace();
        opts.setCharacterEncoding("UTF-8");
        return object.xmlText(opts);
    }

    @Override
    public final DayCareCenterRegistrationRequestDocument modelToXml() {
        
        Calendar calendar = Calendar.getInstance();
        LocalTime localTime = new LocalTime();
        Date date = null;
        DayCareCenterRegistrationRequestDocument dayCareCenterRegistrationRequestDoc = DayCareCenterRegistrationRequestDocument.Factory.newInstance();
        DayCareCenterRegistrationRequestDocument.DayCareCenterRegistrationRequest dayCareCenterRegistrationRequest = dayCareCenterRegistrationRequestDoc.addNewDayCareCenterRegistrationRequest();
        super.fillCommonXmlInfo(dayCareCenterRegistrationRequest);
        int i = 0;
          DccrrMereType dccrrMereTypeInformationMere = dayCareCenterRegistrationRequest.addNewInformationMere();
        if (getEstHorairesReguliersMere() != null)
            dccrrMereTypeInformationMere.setEstHorairesReguliersMere(getEstHorairesReguliersMere().booleanValue());
        DccrrPereType dccrrPereTypeInformationPere = dayCareCenterRegistrationRequest.addNewInformationPere();
        if (getEstHorairesReguliersPere() != null)
            dccrrPereTypeInformationPere.setEstHorairesReguliersPere(getEstHorairesReguliersPere().booleanValue());
      
        dccrrPereTypeInformationPere.setProfessionPere(getProfessionPere());
        DccrrPlageHoraireJeudiType dccrrPlageHoraireJeudiTypeJeudi = dayCareCenterRegistrationRequest.addNewJeudi();
        localTime = getHorairePlacementMatinDebutJeudi();
        if (localTime != null) {
            calendar.set(Calendar.HOUR_OF_DAY,localTime.getHourOfDay());
            calendar.set(Calendar.MINUTE, localTime.getMinuteOfHour());
            dccrrPlageHoraireJeudiTypeJeudi.setHorairePlacementMatinDebutJeudi(calendar);
        }
      
        dccrrPereTypeInformationPere.setHorairesTravailVendrediPere(getHorairesTravailVendrediPere());
      
        dccrrPereTypeInformationPere.setHorairesReguliersPere(getHorairesReguliersPere());
      
        dccrrMereTypeInformationMere.setHorairesTravailMercrediMere(getHorairesTravailMercrediMere());
      
        if (getSituationActuellePere() != null)
            dccrrPereTypeInformationPere.setSituationActuellePere(fr.cg95.cvq.xml.request.school.ChoixSituationActuelle.Enum.forString(getSituationActuellePere().toString()));
      
        if (getPlageHoraireContact() != null)
            dayCareCenterRegistrationRequest.setPlageHoraireContact(fr.cg95.cvq.xml.request.school.PlageHoraireContactType.Enum.forString(getPlageHoraireContact().toString()));
      
        dccrrMereTypeInformationMere.setHorairesTravailLundiMere(getHorairesTravailLundiMere());
        DccrrPlageHoraireType dccrrPlageHoraireTypePlageHoraireAccueilReguliere = dayCareCenterRegistrationRequest.addNewPlageHoraireAccueilReguliere();
        localTime = getHorairePlacementMatinFin();
        if (localTime != null) {
            calendar.set(Calendar.HOUR_OF_DAY,localTime.getHourOfDay());
            calendar.set(Calendar.MINUTE, localTime.getMinuteOfHour());
            dccrrPlageHoraireTypePlageHoraireAccueilReguliere.setHorairePlacementMatinFin(calendar);
        }
        DccrrPlageHoraireMercrediType dccrrPlageHoraireMercrediTypeMercredi = dayCareCenterRegistrationRequest.addNewMercredi();
        localTime = getHorairePlacementApresMidiDebutMercredi();
        if (localTime != null) {
            calendar.set(Calendar.HOUR_OF_DAY,localTime.getHourOfDay());
            calendar.set(Calendar.MINUTE, localTime.getMinuteOfHour());
            dccrrPlageHoraireMercrediTypeMercredi.setHorairePlacementApresMidiDebutMercredi(calendar);
        }
      
        dccrrMereTypeInformationMere.setHorairesTravailVendrediMere(getHorairesTravailVendrediMere());
      
        dccrrMereTypeInformationMere.setPrecisionAutreSituationActuelleMere(getPrecisionAutreSituationActuelleMere());
        DccrrPlageHoraireVendrediType dccrrPlageHoraireVendrediTypeVendredi = dayCareCenterRegistrationRequest.addNewVendredi();
        localTime = getHorairePlacementApresMidiDebutVendredi();
        if (localTime != null) {
            calendar.set(Calendar.HOUR_OF_DAY,localTime.getHourOfDay());
            calendar.set(Calendar.MINUTE, localTime.getMinuteOfHour());
            dccrrPlageHoraireVendrediTypeVendredi.setHorairePlacementApresMidiDebutVendredi(calendar);
        }
      
        localTime = getHorairePlacementMatinDebutMercredi();
        if (localTime != null) {
            calendar.set(Calendar.HOUR_OF_DAY,localTime.getHourOfDay());
            calendar.set(Calendar.MINUTE, localTime.getMinuteOfHour());
            dccrrPlageHoraireMercrediTypeMercredi.setHorairePlacementMatinDebutMercredi(calendar);
        }
      
        localTime = getHorairePlacementMatinFinJeudi();
        if (localTime != null) {
            calendar.set(Calendar.HOUR_OF_DAY,localTime.getHourOfDay());
            calendar.set(Calendar.MINUTE, localTime.getMinuteOfHour());
            dccrrPlageHoraireJeudiTypeJeudi.setHorairePlacementMatinFinJeudi(calendar);
        }
      
        dccrrPereTypeInformationPere.setPrecisionAutreSituationActuellePere(getPrecisionAutreSituationActuellePere());
        DccrrDatesPlacementType dccrrDatesPlacementTypeDatePlacementAccueilRegulier = dayCareCenterRegistrationRequest.addNewDatePlacementAccueilRegulier();
        date = getDatePlacementFin();
        if (date != null) {
            calendar.setTime(date);
            dccrrDatesPlacementTypeDatePlacementAccueilRegulier.setDatePlacementFin(calendar);
        }
      
        localTime = getHorairePlacementApresMidiFinJeudi();
        if (localTime != null) {
            calendar.set(Calendar.HOUR_OF_DAY,localTime.getHourOfDay());
            calendar.set(Calendar.MINUTE, localTime.getMinuteOfHour());
            dccrrPlageHoraireJeudiTypeJeudi.setHorairePlacementApresMidiFinJeudi(calendar);
        }
      
        localTime = getHorairePlacementApresMidiFinVendredi();
        if (localTime != null) {
            calendar.set(Calendar.HOUR_OF_DAY,localTime.getHourOfDay());
            calendar.set(Calendar.MINUTE, localTime.getMinuteOfHour());
            dccrrPlageHoraireVendrediTypeVendredi.setHorairePlacementApresMidiFinVendredi(calendar);
        }
      
        if (getModeAccueilChoixDeux() != null)
            dayCareCenterRegistrationRequest.setModeAccueilChoixDeux(fr.cg95.cvq.xml.request.school.ModeAccueilType.Enum.forString(getModeAccueilChoixDeux().toString()));
      
        dccrrPereTypeInformationPere.setHorairesTravailMardiPere(getHorairesTravailMardiPere());
      
        if (getChoixHorairesAccueil() != null)
            dayCareCenterRegistrationRequest.setChoixHorairesAccueil(fr.cg95.cvq.xml.request.school.ChoixHorairesAccueilType.Enum.forString(getChoixHorairesAccueil().toString()));
      
        localTime = getHorairePlacementMatinDebut();
        if (localTime != null) {
            calendar.set(Calendar.HOUR_OF_DAY,localTime.getHourOfDay());
            calendar.set(Calendar.MINUTE, localTime.getMinuteOfHour());
            dccrrPlageHoraireTypePlageHoraireAccueilReguliere.setHorairePlacementMatinDebut(calendar);
        }
      
        dccrrPereTypeInformationPere.setCommuneLieuTravailPere(getCommuneLieuTravailPere());
        DccrrPlageHoraireLundiType dccrrPlageHoraireLundiTypeLundi = dayCareCenterRegistrationRequest.addNewLundi();
        localTime = getHorairePlacementMatinDebutLundi();
        if (localTime != null) {
            calendar.set(Calendar.HOUR_OF_DAY,localTime.getHourOfDay());
            calendar.set(Calendar.MINUTE, localTime.getMinuteOfHour());
            dccrrPlageHoraireLundiTypeLundi.setHorairePlacementMatinDebutLundi(calendar);
        }
      
        if (getChoixTypeDatePlacementAccueilRegulier() != null)
            dccrrDatesPlacementTypeDatePlacementAccueilRegulier.setChoixTypeDatePlacementAccueilRegulier(fr.cg95.cvq.xml.request.school.ChoixDatePlacement.Enum.forString(getChoixTypeDatePlacementAccueilRegulier().toString()));
      
        if (getModeAccueil() != null)
            dayCareCenterRegistrationRequest.setModeAccueil(getModeAccueil().booleanValue());
      
        dccrrMereTypeInformationMere.setHorairesReguliersMere(getHorairesReguliersMere());
        DccrrPlageHoraireMardiType dccrrPlageHoraireMardiTypeMardi = dayCareCenterRegistrationRequest.addNewMardi();
        localTime = getHorairePlacementApresMidiFinMardi();
        if (localTime != null) {
            calendar.set(Calendar.HOUR_OF_DAY,localTime.getHourOfDay());
            calendar.set(Calendar.MINUTE, localTime.getMinuteOfHour());
            dccrrPlageHoraireMardiTypeMardi.setHorairePlacementApresMidiFinMardi(calendar);
        }
      
        localTime = getHorairePlacementApresMidiFinLundi();
        if (localTime != null) {
            calendar.set(Calendar.HOUR_OF_DAY,localTime.getHourOfDay());
            calendar.set(Calendar.MINUTE, localTime.getMinuteOfHour());
            dccrrPlageHoraireLundiTypeLundi.setHorairePlacementApresMidiFinLundi(calendar);
        }
      
        localTime = getHorairePlacementMatinFinLundi();
        if (localTime != null) {
            calendar.set(Calendar.HOUR_OF_DAY,localTime.getHourOfDay());
            calendar.set(Calendar.MINUTE, localTime.getMinuteOfHour());
            dccrrPlageHoraireLundiTypeLundi.setHorairePlacementMatinFinLundi(calendar);
        }
      
        if (getChoixTypeRendezVous() != null)
            dayCareCenterRegistrationRequest.setChoixTypeRendezVous(fr.cg95.cvq.xml.request.school.RendezVousType.Enum.forString(getChoixTypeRendezVous().toString()));
      
        if (getSituationActuelleMere() != null)
            dccrrMereTypeInformationMere.setSituationActuelleMere(fr.cg95.cvq.xml.request.school.ChoixSituationActuelle.Enum.forString(getSituationActuelleMere().toString()));
      
        date = getDixHuitMoisEnfant();
        if (date != null) {
            calendar.setTime(date);
            dayCareCenterRegistrationRequest.setDixHuitMoisEnfant(calendar);
        }
      
        localTime = getHorairePlacementMatinFinVendredi();
        if (localTime != null) {
            calendar.set(Calendar.HOUR_OF_DAY,localTime.getHourOfDay());
            calendar.set(Calendar.MINUTE, localTime.getMinuteOfHour());
            dccrrPlageHoraireVendrediTypeVendredi.setHorairePlacementMatinFinVendredi(calendar);
        }
      
        date = getDatePlacementDebut();
        if (date != null) {
            calendar.setTime(date);
            dccrrDatesPlacementTypeDatePlacementAccueilRegulier.setDatePlacementDebut(calendar);
        }
      
        localTime = getHorairePlacementMatinDebutVendredi();
        if (localTime != null) {
            calendar.set(Calendar.HOUR_OF_DAY,localTime.getHourOfDay());
            calendar.set(Calendar.MINUTE, localTime.getMinuteOfHour());
            dccrrPlageHoraireVendrediTypeVendredi.setHorairePlacementMatinDebutVendredi(calendar);
        }
      
        localTime = getHorairePlacementApresMidiDebutLundi();
        if (localTime != null) {
            calendar.set(Calendar.HOUR_OF_DAY,localTime.getHourOfDay());
            calendar.set(Calendar.MINUTE, localTime.getMinuteOfHour());
            dccrrPlageHoraireLundiTypeLundi.setHorairePlacementApresMidiDebutLundi(calendar);
        }
      
        dccrrPereTypeInformationPere.setHorairesTravailMercrediPere(getHorairesTravailMercrediPere());
      
        localTime = getHorairePlacementApresMidiDebutMardi();
        if (localTime != null) {
            calendar.set(Calendar.HOUR_OF_DAY,localTime.getHourOfDay());
            calendar.set(Calendar.MINUTE, localTime.getMinuteOfHour());
            dccrrPlageHoraireMardiTypeMardi.setHorairePlacementApresMidiDebutMardi(calendar);
        }
      
        dccrrPereTypeInformationPere.setHorairesTravailLundiPere(getHorairesTravailLundiPere());
      
        localTime = getHorairePlacementApresMidiFin();
        if (localTime != null) {
            calendar.set(Calendar.HOUR_OF_DAY,localTime.getHourOfDay());
            calendar.set(Calendar.MINUTE, localTime.getMinuteOfHour());
            dccrrPlageHoraireTypePlageHoraireAccueilReguliere.setHorairePlacementApresMidiFin(calendar);
        }
      
        dccrrMereTypeInformationMere.setCommuneLieuTravailMere(getCommuneLieuTravailMere());
      
        dccrrPereTypeInformationPere.setHorairesTravailJeudiPere(getHorairesTravailJeudiPere());
      
        dccrrMereTypeInformationMere.setHorairesTravailJeudiMere(getHorairesTravailJeudiMere());
      
        dayCareCenterRegistrationRequest.setTelephoneContact(getTelephoneContact());
      
        dccrrMereTypeInformationMere.setHorairesTravailMardiMere(getHorairesTravailMardiMere());
      
        dayCareCenterRegistrationRequest.setAccueilAnterieur(getAccueilAnterieur());
      
        localTime = getHorairePlacementApresMidiFinMercredi();
        if (localTime != null) {
            calendar.set(Calendar.HOUR_OF_DAY,localTime.getHourOfDay());
            calendar.set(Calendar.MINUTE, localTime.getMinuteOfHour());
            dccrrPlageHoraireMercrediTypeMercredi.setHorairePlacementApresMidiFinMercredi(calendar);
        }
      
        localTime = getHorairePlacementMatinDebutMardi();
        if (localTime != null) {
            calendar.set(Calendar.HOUR_OF_DAY,localTime.getHourOfDay());
            calendar.set(Calendar.MINUTE, localTime.getMinuteOfHour());
            dccrrPlageHoraireMardiTypeMardi.setHorairePlacementMatinDebutMardi(calendar);
        }
      
        localTime = getHorairePlacementMatinFinMercredi();
        if (localTime != null) {
            calendar.set(Calendar.HOUR_OF_DAY,localTime.getHourOfDay());
            calendar.set(Calendar.MINUTE, localTime.getMinuteOfHour());
            dccrrPlageHoraireMercrediTypeMercredi.setHorairePlacementMatinFinMercredi(calendar);
        }
      
        localTime = getHorairePlacementMatinFinMardi();
        if (localTime != null) {
            calendar.set(Calendar.HOUR_OF_DAY,localTime.getHourOfDay());
            calendar.set(Calendar.MINUTE, localTime.getMinuteOfHour());
            dccrrPlageHoraireMardiTypeMardi.setHorairePlacementMatinFinMardi(calendar);
        }
      
        localTime = getHorairePlacementApresMidiDebutJeudi();
        if (localTime != null) {
            calendar.set(Calendar.HOUR_OF_DAY,localTime.getHourOfDay());
            calendar.set(Calendar.MINUTE, localTime.getMinuteOfHour());
            dccrrPlageHoraireJeudiTypeJeudi.setHorairePlacementApresMidiDebutJeudi(calendar);
        }
      
        dccrrMereTypeInformationMere.setProfessionMere(getProfessionMere());
      
        if (getModeAccueilChoixUn() != null)
            dayCareCenterRegistrationRequest.setModeAccueilChoixUn(fr.cg95.cvq.xml.request.school.ModeAccueilType.Enum.forString(getModeAccueilChoixUn().toString()));
      
        dayCareCenterRegistrationRequest.setCommentaireCitoyen(getCommentaireCitoyen());
      
        localTime = getHorairePlacementApresMidiDebut();
        if (localTime != null) {
            calendar.set(Calendar.HOUR_OF_DAY,localTime.getHourOfDay());
            calendar.set(Calendar.MINUTE, localTime.getMinuteOfHour());
            dccrrPlageHoraireTypePlageHoraireAccueilReguliere.setHorairePlacementApresMidiDebut(calendar);
        }
      
        return dayCareCenterRegistrationRequestDoc;
    }

    @Override
    public final DayCareCenterRegistrationRequestDocument.DayCareCenterRegistrationRequest modelToXmlRequest() {
        return modelToXml().getDayCareCenterRegistrationRequest();
    }

    public static DayCareCenterRegistrationRequest xmlToModel(DayCareCenterRegistrationRequestDocument dayCareCenterRegistrationRequestDoc) {
        DayCareCenterRegistrationRequestDocument.DayCareCenterRegistrationRequest dayCareCenterRegistrationRequestXml = dayCareCenterRegistrationRequestDoc.getDayCareCenterRegistrationRequest();
        Calendar calendar = Calendar.getInstance();
        LocalTime localTime = new LocalTime();
        List list = new ArrayList();
        DayCareCenterRegistrationRequest dayCareCenterRegistrationRequest = new DayCareCenterRegistrationRequest();
        dayCareCenterRegistrationRequest.fillCommonModelInfo(dayCareCenterRegistrationRequest, dayCareCenterRegistrationRequestXml);
        
        dayCareCenterRegistrationRequest.setEstHorairesReguliersMere(Boolean.valueOf(dayCareCenterRegistrationRequestXml.getInformationMere().getEstHorairesReguliersMere()));
      
        dayCareCenterRegistrationRequest.setEstHorairesReguliersPere(Boolean.valueOf(dayCareCenterRegistrationRequestXml.getInformationPere().getEstHorairesReguliersPere()));
      
        dayCareCenterRegistrationRequest.setProfessionPere(dayCareCenterRegistrationRequestXml.getInformationPere().getProfessionPere());
      
        calendar = dayCareCenterRegistrationRequestXml.getJeudi().getHorairePlacementMatinDebutJeudi();
        if (calendar != null) {
            localTime = new LocalTime(calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE));
            dayCareCenterRegistrationRequest.setHorairePlacementMatinDebutJeudi(localTime);
        }
      
        dayCareCenterRegistrationRequest.setHorairesTravailVendrediPere(dayCareCenterRegistrationRequestXml.getInformationPere().getHorairesTravailVendrediPere());
      
        dayCareCenterRegistrationRequest.setHorairesReguliersPere(dayCareCenterRegistrationRequestXml.getInformationPere().getHorairesReguliersPere());
      
        dayCareCenterRegistrationRequest.setHorairesTravailMercrediMere(dayCareCenterRegistrationRequestXml.getInformationMere().getHorairesTravailMercrediMere());
      
        if (dayCareCenterRegistrationRequestXml.getInformationPere().getSituationActuellePere() != null)
            dayCareCenterRegistrationRequest.setSituationActuellePere(fr.cg95.cvq.business.request.school.ChoixSituationActuelle.forString(dayCareCenterRegistrationRequestXml.getInformationPere().getSituationActuellePere().toString()));
        else
            dayCareCenterRegistrationRequest.setSituationActuellePere(fr.cg95.cvq.business.request.school.ChoixSituationActuelle.getDefaultChoixSituationActuelle());
      
        if (dayCareCenterRegistrationRequestXml.getPlageHoraireContact() != null)
            dayCareCenterRegistrationRequest.setPlageHoraireContact(fr.cg95.cvq.business.request.school.PlageHoraireContactType.forString(dayCareCenterRegistrationRequestXml.getPlageHoraireContact().toString()));
        else
            dayCareCenterRegistrationRequest.setPlageHoraireContact(fr.cg95.cvq.business.request.school.PlageHoraireContactType.getDefaultPlageHoraireContactType());
      
        dayCareCenterRegistrationRequest.setHorairesTravailLundiMere(dayCareCenterRegistrationRequestXml.getInformationMere().getHorairesTravailLundiMere());
      
        calendar = dayCareCenterRegistrationRequestXml.getPlageHoraireAccueilReguliere().getHorairePlacementMatinFin();
        if (calendar != null) {
            localTime = new LocalTime(calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE));
            dayCareCenterRegistrationRequest.setHorairePlacementMatinFin(localTime);
        }
      
        calendar = dayCareCenterRegistrationRequestXml.getMercredi().getHorairePlacementApresMidiDebutMercredi();
        if (calendar != null) {
            localTime = new LocalTime(calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE));
            dayCareCenterRegistrationRequest.setHorairePlacementApresMidiDebutMercredi(localTime);
        }
      
        dayCareCenterRegistrationRequest.setHorairesTravailVendrediMere(dayCareCenterRegistrationRequestXml.getInformationMere().getHorairesTravailVendrediMere());
      
        dayCareCenterRegistrationRequest.setPrecisionAutreSituationActuelleMere(dayCareCenterRegistrationRequestXml.getInformationMere().getPrecisionAutreSituationActuelleMere());
      
        calendar = dayCareCenterRegistrationRequestXml.getVendredi().getHorairePlacementApresMidiDebutVendredi();
        if (calendar != null) {
            localTime = new LocalTime(calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE));
            dayCareCenterRegistrationRequest.setHorairePlacementApresMidiDebutVendredi(localTime);
        }
      
        calendar = dayCareCenterRegistrationRequestXml.getMercredi().getHorairePlacementMatinDebutMercredi();
        if (calendar != null) {
            localTime = new LocalTime(calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE));
            dayCareCenterRegistrationRequest.setHorairePlacementMatinDebutMercredi(localTime);
        }
      
        calendar = dayCareCenterRegistrationRequestXml.getJeudi().getHorairePlacementMatinFinJeudi();
        if (calendar != null) {
            localTime = new LocalTime(calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE));
            dayCareCenterRegistrationRequest.setHorairePlacementMatinFinJeudi(localTime);
        }
      
        dayCareCenterRegistrationRequest.setPrecisionAutreSituationActuellePere(dayCareCenterRegistrationRequestXml.getInformationPere().getPrecisionAutreSituationActuellePere());
      
        calendar = dayCareCenterRegistrationRequestXml.getDatePlacementAccueilRegulier().getDatePlacementFin();
        if (calendar != null) {
            dayCareCenterRegistrationRequest.setDatePlacementFin(calendar.getTime());
        }
      
        calendar = dayCareCenterRegistrationRequestXml.getJeudi().getHorairePlacementApresMidiFinJeudi();
        if (calendar != null) {
            localTime = new LocalTime(calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE));
            dayCareCenterRegistrationRequest.setHorairePlacementApresMidiFinJeudi(localTime);
        }
      
        calendar = dayCareCenterRegistrationRequestXml.getVendredi().getHorairePlacementApresMidiFinVendredi();
        if (calendar != null) {
            localTime = new LocalTime(calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE));
            dayCareCenterRegistrationRequest.setHorairePlacementApresMidiFinVendredi(localTime);
        }
      
        if (dayCareCenterRegistrationRequestXml.getModeAccueilChoixDeux() != null)
            dayCareCenterRegistrationRequest.setModeAccueilChoixDeux(fr.cg95.cvq.business.request.school.ModeAccueilType.forString(dayCareCenterRegistrationRequestXml.getModeAccueilChoixDeux().toString()));
        else
            dayCareCenterRegistrationRequest.setModeAccueilChoixDeux(fr.cg95.cvq.business.request.school.ModeAccueilType.getDefaultModeAccueilType());
      
        dayCareCenterRegistrationRequest.setHorairesTravailMardiPere(dayCareCenterRegistrationRequestXml.getInformationPere().getHorairesTravailMardiPere());
      
        if (dayCareCenterRegistrationRequestXml.getChoixHorairesAccueil() != null)
            dayCareCenterRegistrationRequest.setChoixHorairesAccueil(fr.cg95.cvq.business.request.school.ChoixHorairesAccueilType.forString(dayCareCenterRegistrationRequestXml.getChoixHorairesAccueil().toString()));
        else
            dayCareCenterRegistrationRequest.setChoixHorairesAccueil(fr.cg95.cvq.business.request.school.ChoixHorairesAccueilType.getDefaultChoixHorairesAccueilType());
      
        calendar = dayCareCenterRegistrationRequestXml.getPlageHoraireAccueilReguliere().getHorairePlacementMatinDebut();
        if (calendar != null) {
            localTime = new LocalTime(calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE));
            dayCareCenterRegistrationRequest.setHorairePlacementMatinDebut(localTime);
        }
      
        dayCareCenterRegistrationRequest.setCommuneLieuTravailPere(dayCareCenterRegistrationRequestXml.getInformationPere().getCommuneLieuTravailPere());
      
        calendar = dayCareCenterRegistrationRequestXml.getLundi().getHorairePlacementMatinDebutLundi();
        if (calendar != null) {
            localTime = new LocalTime(calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE));
            dayCareCenterRegistrationRequest.setHorairePlacementMatinDebutLundi(localTime);
        }
      
        if (dayCareCenterRegistrationRequestXml.getDatePlacementAccueilRegulier().getChoixTypeDatePlacementAccueilRegulier() != null)
            dayCareCenterRegistrationRequest.setChoixTypeDatePlacementAccueilRegulier(fr.cg95.cvq.business.request.school.ChoixDatePlacement.forString(dayCareCenterRegistrationRequestXml.getDatePlacementAccueilRegulier().getChoixTypeDatePlacementAccueilRegulier().toString()));
        else
            dayCareCenterRegistrationRequest.setChoixTypeDatePlacementAccueilRegulier(fr.cg95.cvq.business.request.school.ChoixDatePlacement.getDefaultChoixDatePlacement());
      
        dayCareCenterRegistrationRequest.setModeAccueil(Boolean.valueOf(dayCareCenterRegistrationRequestXml.getModeAccueil()));
      
        dayCareCenterRegistrationRequest.setHorairesReguliersMere(dayCareCenterRegistrationRequestXml.getInformationMere().getHorairesReguliersMere());
      
        calendar = dayCareCenterRegistrationRequestXml.getMardi().getHorairePlacementApresMidiFinMardi();
        if (calendar != null) {
            localTime = new LocalTime(calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE));
            dayCareCenterRegistrationRequest.setHorairePlacementApresMidiFinMardi(localTime);
        }
      
        calendar = dayCareCenterRegistrationRequestXml.getLundi().getHorairePlacementApresMidiFinLundi();
        if (calendar != null) {
            localTime = new LocalTime(calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE));
            dayCareCenterRegistrationRequest.setHorairePlacementApresMidiFinLundi(localTime);
        }
      
        calendar = dayCareCenterRegistrationRequestXml.getLundi().getHorairePlacementMatinFinLundi();
        if (calendar != null) {
            localTime = new LocalTime(calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE));
            dayCareCenterRegistrationRequest.setHorairePlacementMatinFinLundi(localTime);
        }
      
        if (dayCareCenterRegistrationRequestXml.getChoixTypeRendezVous() != null)
            dayCareCenterRegistrationRequest.setChoixTypeRendezVous(fr.cg95.cvq.business.request.school.RendezVousType.forString(dayCareCenterRegistrationRequestXml.getChoixTypeRendezVous().toString()));
        else
            dayCareCenterRegistrationRequest.setChoixTypeRendezVous(fr.cg95.cvq.business.request.school.RendezVousType.getDefaultRendezVousType());
      
        if (dayCareCenterRegistrationRequestXml.getInformationMere().getSituationActuelleMere() != null)
            dayCareCenterRegistrationRequest.setSituationActuelleMere(fr.cg95.cvq.business.request.school.ChoixSituationActuelle.forString(dayCareCenterRegistrationRequestXml.getInformationMere().getSituationActuelleMere().toString()));
        else
            dayCareCenterRegistrationRequest.setSituationActuelleMere(fr.cg95.cvq.business.request.school.ChoixSituationActuelle.getDefaultChoixSituationActuelle());
      
        calendar = dayCareCenterRegistrationRequestXml.getDixHuitMoisEnfant();
        if (calendar != null) {
            dayCareCenterRegistrationRequest.setDixHuitMoisEnfant(calendar.getTime());
        }
      
        calendar = dayCareCenterRegistrationRequestXml.getVendredi().getHorairePlacementMatinFinVendredi();
        if (calendar != null) {
            localTime = new LocalTime(calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE));
            dayCareCenterRegistrationRequest.setHorairePlacementMatinFinVendredi(localTime);
        }
      
        calendar = dayCareCenterRegistrationRequestXml.getDatePlacementAccueilRegulier().getDatePlacementDebut();
        if (calendar != null) {
            dayCareCenterRegistrationRequest.setDatePlacementDebut(calendar.getTime());
        }
      
        calendar = dayCareCenterRegistrationRequestXml.getVendredi().getHorairePlacementMatinDebutVendredi();
        if (calendar != null) {
            localTime = new LocalTime(calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE));
            dayCareCenterRegistrationRequest.setHorairePlacementMatinDebutVendredi(localTime);
        }
      
        calendar = dayCareCenterRegistrationRequestXml.getLundi().getHorairePlacementApresMidiDebutLundi();
        if (calendar != null) {
            localTime = new LocalTime(calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE));
            dayCareCenterRegistrationRequest.setHorairePlacementApresMidiDebutLundi(localTime);
        }
      
        dayCareCenterRegistrationRequest.setHorairesTravailMercrediPere(dayCareCenterRegistrationRequestXml.getInformationPere().getHorairesTravailMercrediPere());
      
        calendar = dayCareCenterRegistrationRequestXml.getMardi().getHorairePlacementApresMidiDebutMardi();
        if (calendar != null) {
            localTime = new LocalTime(calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE));
            dayCareCenterRegistrationRequest.setHorairePlacementApresMidiDebutMardi(localTime);
        }
      
        dayCareCenterRegistrationRequest.setHorairesTravailLundiPere(dayCareCenterRegistrationRequestXml.getInformationPere().getHorairesTravailLundiPere());
      
        calendar = dayCareCenterRegistrationRequestXml.getPlageHoraireAccueilReguliere().getHorairePlacementApresMidiFin();
        if (calendar != null) {
            localTime = new LocalTime(calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE));
            dayCareCenterRegistrationRequest.setHorairePlacementApresMidiFin(localTime);
        }
      
        dayCareCenterRegistrationRequest.setCommuneLieuTravailMere(dayCareCenterRegistrationRequestXml.getInformationMere().getCommuneLieuTravailMere());
      
        dayCareCenterRegistrationRequest.setHorairesTravailJeudiPere(dayCareCenterRegistrationRequestXml.getInformationPere().getHorairesTravailJeudiPere());
      
        dayCareCenterRegistrationRequest.setHorairesTravailJeudiMere(dayCareCenterRegistrationRequestXml.getInformationMere().getHorairesTravailJeudiMere());
      
        dayCareCenterRegistrationRequest.setTelephoneContact(dayCareCenterRegistrationRequestXml.getTelephoneContact());
      
        dayCareCenterRegistrationRequest.setHorairesTravailMardiMere(dayCareCenterRegistrationRequestXml.getInformationMere().getHorairesTravailMardiMere());
      
        dayCareCenterRegistrationRequest.setAccueilAnterieur(dayCareCenterRegistrationRequestXml.getAccueilAnterieur());
      
        calendar = dayCareCenterRegistrationRequestXml.getMercredi().getHorairePlacementApresMidiFinMercredi();
        if (calendar != null) {
            localTime = new LocalTime(calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE));
            dayCareCenterRegistrationRequest.setHorairePlacementApresMidiFinMercredi(localTime);
        }
      
        calendar = dayCareCenterRegistrationRequestXml.getMardi().getHorairePlacementMatinDebutMardi();
        if (calendar != null) {
            localTime = new LocalTime(calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE));
            dayCareCenterRegistrationRequest.setHorairePlacementMatinDebutMardi(localTime);
        }
      
        calendar = dayCareCenterRegistrationRequestXml.getMercredi().getHorairePlacementMatinFinMercredi();
        if (calendar != null) {
            localTime = new LocalTime(calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE));
            dayCareCenterRegistrationRequest.setHorairePlacementMatinFinMercredi(localTime);
        }
      
        calendar = dayCareCenterRegistrationRequestXml.getMardi().getHorairePlacementMatinFinMardi();
        if (calendar != null) {
            localTime = new LocalTime(calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE));
            dayCareCenterRegistrationRequest.setHorairePlacementMatinFinMardi(localTime);
        }
      
        calendar = dayCareCenterRegistrationRequestXml.getJeudi().getHorairePlacementApresMidiDebutJeudi();
        if (calendar != null) {
            localTime = new LocalTime(calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE));
            dayCareCenterRegistrationRequest.setHorairePlacementApresMidiDebutJeudi(localTime);
        }
      
        dayCareCenterRegistrationRequest.setProfessionMere(dayCareCenterRegistrationRequestXml.getInformationMere().getProfessionMere());
      
        if (dayCareCenterRegistrationRequestXml.getModeAccueilChoixUn() != null)
            dayCareCenterRegistrationRequest.setModeAccueilChoixUn(fr.cg95.cvq.business.request.school.ModeAccueilType.forString(dayCareCenterRegistrationRequestXml.getModeAccueilChoixUn().toString()));
        else
            dayCareCenterRegistrationRequest.setModeAccueilChoixUn(fr.cg95.cvq.business.request.school.ModeAccueilType.getDefaultModeAccueilType());
      
        dayCareCenterRegistrationRequest.setCommentaireCitoyen(dayCareCenterRegistrationRequestXml.getCommentaireCitoyen());
      
        calendar = dayCareCenterRegistrationRequestXml.getPlageHoraireAccueilReguliere().getHorairePlacementApresMidiDebut();
        if (calendar != null) {
            localTime = new LocalTime(calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE));
            dayCareCenterRegistrationRequest.setHorairePlacementApresMidiDebut(localTime);
        }
      
        return dayCareCenterRegistrationRequest;
    }

  
    public final void setEstHorairesReguliersMere(final Boolean estHorairesReguliersMere) {
        dayCareCenterRegistrationRequestData.setEstHorairesReguliersMere(estHorairesReguliersMere);
    }

    
    public final Boolean getEstHorairesReguliersMere() {
        return dayCareCenterRegistrationRequestData.getEstHorairesReguliersMere();
    }
  
    public final void setEstHorairesReguliersPere(final Boolean estHorairesReguliersPere) {
        dayCareCenterRegistrationRequestData.setEstHorairesReguliersPere(estHorairesReguliersPere);
    }

    
    public final Boolean getEstHorairesReguliersPere() {
        return dayCareCenterRegistrationRequestData.getEstHorairesReguliersPere();
    }
  
    public final void setProfessionPere(final String professionPere) {
        dayCareCenterRegistrationRequestData.setProfessionPere(professionPere);
    }

    
    public final String getProfessionPere() {
        return dayCareCenterRegistrationRequestData.getProfessionPere();
    }
  
    public final void setHorairePlacementMatinDebutJeudi(final org.joda.time.LocalTime horairePlacementMatinDebutJeudi) {
        dayCareCenterRegistrationRequestData.setHorairePlacementMatinDebutJeudi(horairePlacementMatinDebutJeudi);
    }

    
    public final org.joda.time.LocalTime getHorairePlacementMatinDebutJeudi() {
        return dayCareCenterRegistrationRequestData.getHorairePlacementMatinDebutJeudi();
    }
  
    public final void setHorairesTravailVendrediPere(final String horairesTravailVendrediPere) {
        dayCareCenterRegistrationRequestData.setHorairesTravailVendrediPere(horairesTravailVendrediPere);
    }

    
    public final String getHorairesTravailVendrediPere() {
        return dayCareCenterRegistrationRequestData.getHorairesTravailVendrediPere();
    }
  
    public final void setHorairesReguliersPere(final String horairesReguliersPere) {
        dayCareCenterRegistrationRequestData.setHorairesReguliersPere(horairesReguliersPere);
    }

    
    public final String getHorairesReguliersPere() {
        return dayCareCenterRegistrationRequestData.getHorairesReguliersPere();
    }
  
    public final void setHorairesTravailMercrediMere(final String horairesTravailMercrediMere) {
        dayCareCenterRegistrationRequestData.setHorairesTravailMercrediMere(horairesTravailMercrediMere);
    }

    
    public final String getHorairesTravailMercrediMere() {
        return dayCareCenterRegistrationRequestData.getHorairesTravailMercrediMere();
    }
  
    public final void setSituationActuellePere(final fr.cg95.cvq.business.request.school.ChoixSituationActuelle situationActuellePere) {
        dayCareCenterRegistrationRequestData.setSituationActuellePere(situationActuellePere);
    }

    
    public final fr.cg95.cvq.business.request.school.ChoixSituationActuelle getSituationActuellePere() {
        return dayCareCenterRegistrationRequestData.getSituationActuellePere();
    }
  
    public final void setPlageHoraireContact(final fr.cg95.cvq.business.request.school.PlageHoraireContactType plageHoraireContact) {
        dayCareCenterRegistrationRequestData.setPlageHoraireContact(plageHoraireContact);
    }

    
    public final fr.cg95.cvq.business.request.school.PlageHoraireContactType getPlageHoraireContact() {
        return dayCareCenterRegistrationRequestData.getPlageHoraireContact();
    }
  
    public final void setHorairesTravailLundiMere(final String horairesTravailLundiMere) {
        dayCareCenterRegistrationRequestData.setHorairesTravailLundiMere(horairesTravailLundiMere);
    }

    
    public final String getHorairesTravailLundiMere() {
        return dayCareCenterRegistrationRequestData.getHorairesTravailLundiMere();
    }
  
    public final void setHorairePlacementMatinFin(final org.joda.time.LocalTime horairePlacementMatinFin) {
        dayCareCenterRegistrationRequestData.setHorairePlacementMatinFin(horairePlacementMatinFin);
    }

    
    public final org.joda.time.LocalTime getHorairePlacementMatinFin() {
        return dayCareCenterRegistrationRequestData.getHorairePlacementMatinFin();
    }
  
    public final void setHorairePlacementApresMidiDebutMercredi(final org.joda.time.LocalTime horairePlacementApresMidiDebutMercredi) {
        dayCareCenterRegistrationRequestData.setHorairePlacementApresMidiDebutMercredi(horairePlacementApresMidiDebutMercredi);
    }

    
    public final org.joda.time.LocalTime getHorairePlacementApresMidiDebutMercredi() {
        return dayCareCenterRegistrationRequestData.getHorairePlacementApresMidiDebutMercredi();
    }
  
    public final void setHorairesTravailVendrediMere(final String horairesTravailVendrediMere) {
        dayCareCenterRegistrationRequestData.setHorairesTravailVendrediMere(horairesTravailVendrediMere);
    }

    
    public final String getHorairesTravailVendrediMere() {
        return dayCareCenterRegistrationRequestData.getHorairesTravailVendrediMere();
    }
  
    public final void setPrecisionAutreSituationActuelleMere(final String precisionAutreSituationActuelleMere) {
        dayCareCenterRegistrationRequestData.setPrecisionAutreSituationActuelleMere(precisionAutreSituationActuelleMere);
    }

    
    public final String getPrecisionAutreSituationActuelleMere() {
        return dayCareCenterRegistrationRequestData.getPrecisionAutreSituationActuelleMere();
    }
  
    public final void setHorairePlacementApresMidiDebutVendredi(final org.joda.time.LocalTime horairePlacementApresMidiDebutVendredi) {
        dayCareCenterRegistrationRequestData.setHorairePlacementApresMidiDebutVendredi(horairePlacementApresMidiDebutVendredi);
    }

    
    public final org.joda.time.LocalTime getHorairePlacementApresMidiDebutVendredi() {
        return dayCareCenterRegistrationRequestData.getHorairePlacementApresMidiDebutVendredi();
    }
  
    public final void setHorairePlacementMatinDebutMercredi(final org.joda.time.LocalTime horairePlacementMatinDebutMercredi) {
        dayCareCenterRegistrationRequestData.setHorairePlacementMatinDebutMercredi(horairePlacementMatinDebutMercredi);
    }

    
    public final org.joda.time.LocalTime getHorairePlacementMatinDebutMercredi() {
        return dayCareCenterRegistrationRequestData.getHorairePlacementMatinDebutMercredi();
    }
  
    public final void setHorairePlacementMatinFinJeudi(final org.joda.time.LocalTime horairePlacementMatinFinJeudi) {
        dayCareCenterRegistrationRequestData.setHorairePlacementMatinFinJeudi(horairePlacementMatinFinJeudi);
    }

    
    public final org.joda.time.LocalTime getHorairePlacementMatinFinJeudi() {
        return dayCareCenterRegistrationRequestData.getHorairePlacementMatinFinJeudi();
    }
  
    public final void setPrecisionAutreSituationActuellePere(final String precisionAutreSituationActuellePere) {
        dayCareCenterRegistrationRequestData.setPrecisionAutreSituationActuellePere(precisionAutreSituationActuellePere);
    }

    
    public final String getPrecisionAutreSituationActuellePere() {
        return dayCareCenterRegistrationRequestData.getPrecisionAutreSituationActuellePere();
    }
  
    public final void setDatePlacementFin(final java.util.Date datePlacementFin) {
        dayCareCenterRegistrationRequestData.setDatePlacementFin(datePlacementFin);
    }

    
    public final java.util.Date getDatePlacementFin() {
        return dayCareCenterRegistrationRequestData.getDatePlacementFin();
    }
  
    public final void setHorairePlacementApresMidiFinJeudi(final org.joda.time.LocalTime horairePlacementApresMidiFinJeudi) {
        dayCareCenterRegistrationRequestData.setHorairePlacementApresMidiFinJeudi(horairePlacementApresMidiFinJeudi);
    }

    
    public final org.joda.time.LocalTime getHorairePlacementApresMidiFinJeudi() {
        return dayCareCenterRegistrationRequestData.getHorairePlacementApresMidiFinJeudi();
    }
  
    public final void setHorairePlacementApresMidiFinVendredi(final org.joda.time.LocalTime horairePlacementApresMidiFinVendredi) {
        dayCareCenterRegistrationRequestData.setHorairePlacementApresMidiFinVendredi(horairePlacementApresMidiFinVendredi);
    }

    
    public final org.joda.time.LocalTime getHorairePlacementApresMidiFinVendredi() {
        return dayCareCenterRegistrationRequestData.getHorairePlacementApresMidiFinVendredi();
    }
  
    public final void setModeAccueilChoixDeux(final fr.cg95.cvq.business.request.school.ModeAccueilType modeAccueilChoixDeux) {
        dayCareCenterRegistrationRequestData.setModeAccueilChoixDeux(modeAccueilChoixDeux);
    }

    
    public final fr.cg95.cvq.business.request.school.ModeAccueilType getModeAccueilChoixDeux() {
        return dayCareCenterRegistrationRequestData.getModeAccueilChoixDeux();
    }
  
    public final void setHorairesTravailMardiPere(final String horairesTravailMardiPere) {
        dayCareCenterRegistrationRequestData.setHorairesTravailMardiPere(horairesTravailMardiPere);
    }

    
    public final String getHorairesTravailMardiPere() {
        return dayCareCenterRegistrationRequestData.getHorairesTravailMardiPere();
    }
  
    public final void setChoixHorairesAccueil(final fr.cg95.cvq.business.request.school.ChoixHorairesAccueilType choixHorairesAccueil) {
        dayCareCenterRegistrationRequestData.setChoixHorairesAccueil(choixHorairesAccueil);
    }

    
    public final fr.cg95.cvq.business.request.school.ChoixHorairesAccueilType getChoixHorairesAccueil() {
        return dayCareCenterRegistrationRequestData.getChoixHorairesAccueil();
    }
  
    public final void setHorairePlacementMatinDebut(final org.joda.time.LocalTime horairePlacementMatinDebut) {
        dayCareCenterRegistrationRequestData.setHorairePlacementMatinDebut(horairePlacementMatinDebut);
    }

    
    public final org.joda.time.LocalTime getHorairePlacementMatinDebut() {
        return dayCareCenterRegistrationRequestData.getHorairePlacementMatinDebut();
    }
  
    public final void setCommuneLieuTravailPere(final String communeLieuTravailPere) {
        dayCareCenterRegistrationRequestData.setCommuneLieuTravailPere(communeLieuTravailPere);
    }

    
    public final String getCommuneLieuTravailPere() {
        return dayCareCenterRegistrationRequestData.getCommuneLieuTravailPere();
    }
  
    public final void setHorairePlacementMatinDebutLundi(final org.joda.time.LocalTime horairePlacementMatinDebutLundi) {
        dayCareCenterRegistrationRequestData.setHorairePlacementMatinDebutLundi(horairePlacementMatinDebutLundi);
    }

    
    public final org.joda.time.LocalTime getHorairePlacementMatinDebutLundi() {
        return dayCareCenterRegistrationRequestData.getHorairePlacementMatinDebutLundi();
    }
  
    public final void setChoixTypeDatePlacementAccueilRegulier(final fr.cg95.cvq.business.request.school.ChoixDatePlacement choixTypeDatePlacementAccueilRegulier) {
        dayCareCenterRegistrationRequestData.setChoixTypeDatePlacementAccueilRegulier(choixTypeDatePlacementAccueilRegulier);
    }

    
    public final fr.cg95.cvq.business.request.school.ChoixDatePlacement getChoixTypeDatePlacementAccueilRegulier() {
        return dayCareCenterRegistrationRequestData.getChoixTypeDatePlacementAccueilRegulier();
    }
  
    public final void setModeAccueil(final Boolean modeAccueil) {
        dayCareCenterRegistrationRequestData.setModeAccueil(modeAccueil);
    }

    
    public final Boolean getModeAccueil() {
        return dayCareCenterRegistrationRequestData.getModeAccueil();
    }
  
    public final void setHorairesReguliersMere(final String horairesReguliersMere) {
        dayCareCenterRegistrationRequestData.setHorairesReguliersMere(horairesReguliersMere);
    }

    
    public final String getHorairesReguliersMere() {
        return dayCareCenterRegistrationRequestData.getHorairesReguliersMere();
    }
  
    public final void setHorairePlacementApresMidiFinMardi(final org.joda.time.LocalTime horairePlacementApresMidiFinMardi) {
        dayCareCenterRegistrationRequestData.setHorairePlacementApresMidiFinMardi(horairePlacementApresMidiFinMardi);
    }

    
    public final org.joda.time.LocalTime getHorairePlacementApresMidiFinMardi() {
        return dayCareCenterRegistrationRequestData.getHorairePlacementApresMidiFinMardi();
    }
  
    public final void setHorairePlacementApresMidiFinLundi(final org.joda.time.LocalTime horairePlacementApresMidiFinLundi) {
        dayCareCenterRegistrationRequestData.setHorairePlacementApresMidiFinLundi(horairePlacementApresMidiFinLundi);
    }

    
    public final org.joda.time.LocalTime getHorairePlacementApresMidiFinLundi() {
        return dayCareCenterRegistrationRequestData.getHorairePlacementApresMidiFinLundi();
    }
  
    public final void setHorairePlacementMatinFinLundi(final org.joda.time.LocalTime horairePlacementMatinFinLundi) {
        dayCareCenterRegistrationRequestData.setHorairePlacementMatinFinLundi(horairePlacementMatinFinLundi);
    }

    
    public final org.joda.time.LocalTime getHorairePlacementMatinFinLundi() {
        return dayCareCenterRegistrationRequestData.getHorairePlacementMatinFinLundi();
    }
  
    public final void setChoixTypeRendezVous(final fr.cg95.cvq.business.request.school.RendezVousType choixTypeRendezVous) {
        dayCareCenterRegistrationRequestData.setChoixTypeRendezVous(choixTypeRendezVous);
    }

    
    public final fr.cg95.cvq.business.request.school.RendezVousType getChoixTypeRendezVous() {
        return dayCareCenterRegistrationRequestData.getChoixTypeRendezVous();
    }
  
    public final void setSituationActuelleMere(final fr.cg95.cvq.business.request.school.ChoixSituationActuelle situationActuelleMere) {
        dayCareCenterRegistrationRequestData.setSituationActuelleMere(situationActuelleMere);
    }

    
    public final fr.cg95.cvq.business.request.school.ChoixSituationActuelle getSituationActuelleMere() {
        return dayCareCenterRegistrationRequestData.getSituationActuelleMere();
    }
  
    public final void setDixHuitMoisEnfant(final java.util.Date dixHuitMoisEnfant) {
        dayCareCenterRegistrationRequestData.setDixHuitMoisEnfant(dixHuitMoisEnfant);
    }

    
    public final java.util.Date getDixHuitMoisEnfant() {
        return dayCareCenterRegistrationRequestData.getDixHuitMoisEnfant();
    }
  
    public final void setHorairePlacementMatinFinVendredi(final org.joda.time.LocalTime horairePlacementMatinFinVendredi) {
        dayCareCenterRegistrationRequestData.setHorairePlacementMatinFinVendredi(horairePlacementMatinFinVendredi);
    }

    
    public final org.joda.time.LocalTime getHorairePlacementMatinFinVendredi() {
        return dayCareCenterRegistrationRequestData.getHorairePlacementMatinFinVendredi();
    }
  
    public final void setDatePlacementDebut(final java.util.Date datePlacementDebut) {
        dayCareCenterRegistrationRequestData.setDatePlacementDebut(datePlacementDebut);
    }

    
    public final java.util.Date getDatePlacementDebut() {
        return dayCareCenterRegistrationRequestData.getDatePlacementDebut();
    }
  
    public final void setHorairePlacementMatinDebutVendredi(final org.joda.time.LocalTime horairePlacementMatinDebutVendredi) {
        dayCareCenterRegistrationRequestData.setHorairePlacementMatinDebutVendredi(horairePlacementMatinDebutVendredi);
    }

    
    public final org.joda.time.LocalTime getHorairePlacementMatinDebutVendredi() {
        return dayCareCenterRegistrationRequestData.getHorairePlacementMatinDebutVendredi();
    }
  
    public final void setHorairePlacementApresMidiDebutLundi(final org.joda.time.LocalTime horairePlacementApresMidiDebutLundi) {
        dayCareCenterRegistrationRequestData.setHorairePlacementApresMidiDebutLundi(horairePlacementApresMidiDebutLundi);
    }

    
    public final org.joda.time.LocalTime getHorairePlacementApresMidiDebutLundi() {
        return dayCareCenterRegistrationRequestData.getHorairePlacementApresMidiDebutLundi();
    }
  
    public final void setHorairesTravailMercrediPere(final String horairesTravailMercrediPere) {
        dayCareCenterRegistrationRequestData.setHorairesTravailMercrediPere(horairesTravailMercrediPere);
    }

    
    public final String getHorairesTravailMercrediPere() {
        return dayCareCenterRegistrationRequestData.getHorairesTravailMercrediPere();
    }
  
    public final void setHorairePlacementApresMidiDebutMardi(final org.joda.time.LocalTime horairePlacementApresMidiDebutMardi) {
        dayCareCenterRegistrationRequestData.setHorairePlacementApresMidiDebutMardi(horairePlacementApresMidiDebutMardi);
    }

    
    public final org.joda.time.LocalTime getHorairePlacementApresMidiDebutMardi() {
        return dayCareCenterRegistrationRequestData.getHorairePlacementApresMidiDebutMardi();
    }
  
    public final void setHorairesTravailLundiPere(final String horairesTravailLundiPere) {
        dayCareCenterRegistrationRequestData.setHorairesTravailLundiPere(horairesTravailLundiPere);
    }

    
    public final String getHorairesTravailLundiPere() {
        return dayCareCenterRegistrationRequestData.getHorairesTravailLundiPere();
    }
  
    public final void setHorairePlacementApresMidiFin(final org.joda.time.LocalTime horairePlacementApresMidiFin) {
        dayCareCenterRegistrationRequestData.setHorairePlacementApresMidiFin(horairePlacementApresMidiFin);
    }

    
    public final org.joda.time.LocalTime getHorairePlacementApresMidiFin() {
        return dayCareCenterRegistrationRequestData.getHorairePlacementApresMidiFin();
    }
  
    public final void setCommuneLieuTravailMere(final String communeLieuTravailMere) {
        dayCareCenterRegistrationRequestData.setCommuneLieuTravailMere(communeLieuTravailMere);
    }

    
    public final String getCommuneLieuTravailMere() {
        return dayCareCenterRegistrationRequestData.getCommuneLieuTravailMere();
    }
  
    public final void setHorairesTravailJeudiPere(final String horairesTravailJeudiPere) {
        dayCareCenterRegistrationRequestData.setHorairesTravailJeudiPere(horairesTravailJeudiPere);
    }

    
    public final String getHorairesTravailJeudiPere() {
        return dayCareCenterRegistrationRequestData.getHorairesTravailJeudiPere();
    }
  
    public final void setHorairesTravailJeudiMere(final String horairesTravailJeudiMere) {
        dayCareCenterRegistrationRequestData.setHorairesTravailJeudiMere(horairesTravailJeudiMere);
    }

    
    public final String getHorairesTravailJeudiMere() {
        return dayCareCenterRegistrationRequestData.getHorairesTravailJeudiMere();
    }
  
    public final void setTelephoneContact(final String telephoneContact) {
        dayCareCenterRegistrationRequestData.setTelephoneContact(telephoneContact);
    }

    
    public final String getTelephoneContact() {
        return dayCareCenterRegistrationRequestData.getTelephoneContact();
    }
  
    public final void setHorairesTravailMardiMere(final String horairesTravailMardiMere) {
        dayCareCenterRegistrationRequestData.setHorairesTravailMardiMere(horairesTravailMardiMere);
    }

    
    public final String getHorairesTravailMardiMere() {
        return dayCareCenterRegistrationRequestData.getHorairesTravailMardiMere();
    }
  
    public final void setAccueilAnterieur(final String accueilAnterieur) {
        dayCareCenterRegistrationRequestData.setAccueilAnterieur(accueilAnterieur);
    }

    
    public final String getAccueilAnterieur() {
        return dayCareCenterRegistrationRequestData.getAccueilAnterieur();
    }
  
    public final void setHorairePlacementApresMidiFinMercredi(final org.joda.time.LocalTime horairePlacementApresMidiFinMercredi) {
        dayCareCenterRegistrationRequestData.setHorairePlacementApresMidiFinMercredi(horairePlacementApresMidiFinMercredi);
    }

    
    public final org.joda.time.LocalTime getHorairePlacementApresMidiFinMercredi() {
        return dayCareCenterRegistrationRequestData.getHorairePlacementApresMidiFinMercredi();
    }
  
    public final void setHorairePlacementMatinDebutMardi(final org.joda.time.LocalTime horairePlacementMatinDebutMardi) {
        dayCareCenterRegistrationRequestData.setHorairePlacementMatinDebutMardi(horairePlacementMatinDebutMardi);
    }

    
    public final org.joda.time.LocalTime getHorairePlacementMatinDebutMardi() {
        return dayCareCenterRegistrationRequestData.getHorairePlacementMatinDebutMardi();
    }
  
    public final void setHorairePlacementMatinFinMercredi(final org.joda.time.LocalTime horairePlacementMatinFinMercredi) {
        dayCareCenterRegistrationRequestData.setHorairePlacementMatinFinMercredi(horairePlacementMatinFinMercredi);
    }

    
    public final org.joda.time.LocalTime getHorairePlacementMatinFinMercredi() {
        return dayCareCenterRegistrationRequestData.getHorairePlacementMatinFinMercredi();
    }
  
    public final void setHorairePlacementMatinFinMardi(final org.joda.time.LocalTime horairePlacementMatinFinMardi) {
        dayCareCenterRegistrationRequestData.setHorairePlacementMatinFinMardi(horairePlacementMatinFinMardi);
    }

    
    public final org.joda.time.LocalTime getHorairePlacementMatinFinMardi() {
        return dayCareCenterRegistrationRequestData.getHorairePlacementMatinFinMardi();
    }
  
    public final void setHorairePlacementApresMidiDebutJeudi(final org.joda.time.LocalTime horairePlacementApresMidiDebutJeudi) {
        dayCareCenterRegistrationRequestData.setHorairePlacementApresMidiDebutJeudi(horairePlacementApresMidiDebutJeudi);
    }

    
    public final org.joda.time.LocalTime getHorairePlacementApresMidiDebutJeudi() {
        return dayCareCenterRegistrationRequestData.getHorairePlacementApresMidiDebutJeudi();
    }
  
    public final void setProfessionMere(final String professionMere) {
        dayCareCenterRegistrationRequestData.setProfessionMere(professionMere);
    }

    
    public final String getProfessionMere() {
        return dayCareCenterRegistrationRequestData.getProfessionMere();
    }
  
    public final void setModeAccueilChoixUn(final fr.cg95.cvq.business.request.school.ModeAccueilType modeAccueilChoixUn) {
        dayCareCenterRegistrationRequestData.setModeAccueilChoixUn(modeAccueilChoixUn);
    }

    
    public final fr.cg95.cvq.business.request.school.ModeAccueilType getModeAccueilChoixUn() {
        return dayCareCenterRegistrationRequestData.getModeAccueilChoixUn();
    }
  
    public final void setCommentaireCitoyen(final String commentaireCitoyen) {
        dayCareCenterRegistrationRequestData.setCommentaireCitoyen(commentaireCitoyen);
    }

    
    public final String getCommentaireCitoyen() {
        return dayCareCenterRegistrationRequestData.getCommentaireCitoyen();
    }
  
    public final void setHorairePlacementApresMidiDebut(final org.joda.time.LocalTime horairePlacementApresMidiDebut) {
        dayCareCenterRegistrationRequestData.setHorairePlacementApresMidiDebut(horairePlacementApresMidiDebut);
    }

    
    public final org.joda.time.LocalTime getHorairePlacementApresMidiDebut() {
        return dayCareCenterRegistrationRequestData.getHorairePlacementApresMidiDebut();
    }
  
}
