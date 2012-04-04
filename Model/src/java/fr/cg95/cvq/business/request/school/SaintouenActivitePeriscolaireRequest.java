
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
public class SaintouenActivitePeriscolaireRequest extends Request implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final Map<String, IConditionChecker> conditions = SaintouenActivitePeriscolaireRequestData.conditions;

    @AssertValid(message = "")
    private SaintouenActivitePeriscolaireRequestData saintouenActivitePeriscolaireRequestData;

    public SaintouenActivitePeriscolaireRequest(RequestData requestData, SaintouenActivitePeriscolaireRequestData saintouenActivitePeriscolaireRequestData) {
        super(requestData);
        this.saintouenActivitePeriscolaireRequestData = saintouenActivitePeriscolaireRequestData;
    }

    public SaintouenActivitePeriscolaireRequest() {
        super();
        this.saintouenActivitePeriscolaireRequestData = new SaintouenActivitePeriscolaireRequestData();
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
          getStepStates().put("enfant", stepState);
        
          stepState = new HashMap<String, Object>(4);
          stepState.put("state", "unavailable");
          stepState.put("required", true);
          stepState.put("errorMsg", null);
          stepState.put("invalidFields", new ArrayList<String>());
          getStepStates().put("activites", stepState);
        
          stepState = new HashMap<String, Object>(4);
          stepState.put("state", "unavailable");
          stepState.put("required", true);
          stepState.put("errorMsg", null);
          stepState.put("invalidFields", new ArrayList<String>());
          getStepStates().put("paiement", stepState);
        
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
    public SaintouenActivitePeriscolaireRequestData getSpecificData() {
        return saintouenActivitePeriscolaireRequestData;
    }

    /**
     * Reserved for RequestDAO !
     */
    public void setSpecificData(SaintouenActivitePeriscolaireRequestData saintouenActivitePeriscolaireRequestData) {
        this.saintouenActivitePeriscolaireRequestData = saintouenActivitePeriscolaireRequestData;
    }

    @Override
    public final String modelToXmlString() {
        SaintouenActivitePeriscolaireRequestDocument object = this.modelToXml();
        XmlOptions opts = new XmlOptions();
        opts.setSavePrettyPrint();
        opts.setSavePrettyPrintIndent(4);
        opts.setUseDefaultNamespace();
        opts.setCharacterEncoding("UTF-8");
        return object.xmlText(opts);
    }

    @Override
    public final SaintouenActivitePeriscolaireRequestDocument modelToXml() {
        
        Calendar calendar = Calendar.getInstance();
        LocalTime localTime = new LocalTime();
        Date date = null;
        SaintouenActivitePeriscolaireRequestDocument saintouenActivitePeriscolaireRequestDoc = SaintouenActivitePeriscolaireRequestDocument.Factory.newInstance();
        SaintouenActivitePeriscolaireRequestDocument.SaintouenActivitePeriscolaireRequest saintouenActivitePeriscolaireRequest = saintouenActivitePeriscolaireRequestDoc.addNewSaintouenActivitePeriscolaireRequest();
        super.fillCommonXmlInfo(saintouenActivitePeriscolaireRequest);
        int i = 0;
        
        if (getEcoleInscription() != null)
            saintouenActivitePeriscolaireRequest.setEcoleInscription(fr.cg95.cvq.xml.request.school.SaprEcoleInscriptionType.Enum.forString(getEcoleInscription().getLegacyLabel()));
        SaprInscriptionPeriscolaireType saprInscriptionPeriscolaireTypeSaprInscriptionPeriscolaire = saintouenActivitePeriscolaireRequest.addNewSaprInscriptionPeriscolaire();
        if (getSaprAccueilMatin() != null)
            saprInscriptionPeriscolaireTypeSaprInscriptionPeriscolaire.setSaprAccueilMatin(getSaprAccueilMatin().booleanValue());
      
        if (getSaprAccueilMercrediEtVacances() != null)
            saprInscriptionPeriscolaireTypeSaprInscriptionPeriscolaire.setSaprAccueilMercrediEtVacances(getSaprAccueilMercrediEtVacances().booleanValue());
      
        if (getSaprAccueilSoir() != null)
            saprInscriptionPeriscolaireTypeSaprInscriptionPeriscolaire.setSaprAccueilSoir(getSaprAccueilSoir().booleanValue());
      
        if (getSaprEstAllergique() != null)
            saintouenActivitePeriscolaireRequest.setSaprEstAllergique(getSaprEstAllergique().booleanValue());
      
        if (getSaprEstHandicapeInvalidant() != null)
            saintouenActivitePeriscolaireRequest.setSaprEstHandicapeInvalidant(getSaprEstHandicapeInvalidant().booleanValue());
      
        if (getSaprEstRestauration() != null)
            saintouenActivitePeriscolaireRequest.setSaprEstRestauration(getSaprEstRestauration().booleanValue());
      
        if (getSaprEtudesSurveillees() != null)
            saprInscriptionPeriscolaireTypeSaprInscriptionPeriscolaire.setSaprEtudesSurveillees(getSaprEtudesSurveillees().booleanValue());
      
        i = 0;
        if (getSaprModeReglement() != null) {
            fr.cg95.cvq.xml.common.LocalReferentialDataType[] saprModeReglementTypeTab = new fr.cg95.cvq.xml.common.LocalReferentialDataType[getSaprModeReglement().size()];
            for (LocalReferentialData object : getSaprModeReglement()) {
              saprModeReglementTypeTab[i++] = LocalReferentialData.modelToXml(object);
            }
            saintouenActivitePeriscolaireRequest.setSaprModeReglementArray(saprModeReglementTypeTab);
        }
      
        if (getSaprReglementInterieur() != null)
            saintouenActivitePeriscolaireRequest.setSaprReglementInterieur(getSaprReglementInterieur().booleanValue());
      
        return saintouenActivitePeriscolaireRequestDoc;
    }

    @Override
    public final SaintouenActivitePeriscolaireRequestDocument.SaintouenActivitePeriscolaireRequest modelToXmlRequest() {
        return modelToXml().getSaintouenActivitePeriscolaireRequest();
    }

    public static SaintouenActivitePeriscolaireRequest xmlToModel(SaintouenActivitePeriscolaireRequestDocument saintouenActivitePeriscolaireRequestDoc) {
        SaintouenActivitePeriscolaireRequestDocument.SaintouenActivitePeriscolaireRequest saintouenActivitePeriscolaireRequestXml = saintouenActivitePeriscolaireRequestDoc.getSaintouenActivitePeriscolaireRequest();
        Calendar calendar = Calendar.getInstance();
        LocalTime localTime = new LocalTime();
        List list = new ArrayList();
        SaintouenActivitePeriscolaireRequest saintouenActivitePeriscolaireRequest = new SaintouenActivitePeriscolaireRequest();
        saintouenActivitePeriscolaireRequest.fillCommonModelInfo(saintouenActivitePeriscolaireRequest, saintouenActivitePeriscolaireRequestXml);
        
        if (saintouenActivitePeriscolaireRequestXml.getEcoleInscription() != null)
            saintouenActivitePeriscolaireRequest.setEcoleInscription(fr.cg95.cvq.business.request.school.SaprEcoleInscriptionType.forString(saintouenActivitePeriscolaireRequestXml.getEcoleInscription().toString()));
        else
            saintouenActivitePeriscolaireRequest.setEcoleInscription(fr.cg95.cvq.business.request.school.SaprEcoleInscriptionType.getDefaultSaprEcoleInscriptionType());
      
        saintouenActivitePeriscolaireRequest.setSaprAccueilMatin(Boolean.valueOf(saintouenActivitePeriscolaireRequestXml.getSaprInscriptionPeriscolaire().getSaprAccueilMatin()));
      
        saintouenActivitePeriscolaireRequest.setSaprAccueilMercrediEtVacances(Boolean.valueOf(saintouenActivitePeriscolaireRequestXml.getSaprInscriptionPeriscolaire().getSaprAccueilMercrediEtVacances()));
      
        saintouenActivitePeriscolaireRequest.setSaprAccueilSoir(Boolean.valueOf(saintouenActivitePeriscolaireRequestXml.getSaprInscriptionPeriscolaire().getSaprAccueilSoir()));
      
        saintouenActivitePeriscolaireRequest.setSaprEstAllergique(Boolean.valueOf(saintouenActivitePeriscolaireRequestXml.getSaprEstAllergique()));
      
        saintouenActivitePeriscolaireRequest.setSaprEstHandicapeInvalidant(Boolean.valueOf(saintouenActivitePeriscolaireRequestXml.getSaprEstHandicapeInvalidant()));
      
        saintouenActivitePeriscolaireRequest.setSaprEstRestauration(Boolean.valueOf(saintouenActivitePeriscolaireRequestXml.getSaprEstRestauration()));
      
        saintouenActivitePeriscolaireRequest.setSaprEtudesSurveillees(Boolean.valueOf(saintouenActivitePeriscolaireRequestXml.getSaprInscriptionPeriscolaire().getSaprEtudesSurveillees()));
      
        List<fr.cg95.cvq.business.request.LocalReferentialData> saprModeReglementList = new ArrayList<fr.cg95.cvq.business.request.LocalReferentialData>(saintouenActivitePeriscolaireRequestXml.sizeOfSaprModeReglementArray());
        for (LocalReferentialDataType object : saintouenActivitePeriscolaireRequestXml.getSaprModeReglementArray()) {
            saprModeReglementList.add(fr.cg95.cvq.business.request.LocalReferentialData.xmlToModel(object));
        }
        saintouenActivitePeriscolaireRequest.setSaprModeReglement(saprModeReglementList);
      
        saintouenActivitePeriscolaireRequest.setSaprReglementInterieur(Boolean.valueOf(saintouenActivitePeriscolaireRequestXml.getSaprReglementInterieur()));
      
        return saintouenActivitePeriscolaireRequest;
    }

    @Override
    public SaintouenActivitePeriscolaireRequest clone() {
        SaintouenActivitePeriscolaireRequest clone = new SaintouenActivitePeriscolaireRequest(getRequestData().clone(), saintouenActivitePeriscolaireRequestData.clone());
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
          clone.getStepStates().put("enfant", stepState);
        
          stepState = new HashMap<String, Object>(4);
          stepState.put("state", "unavailable");
          stepState.put("required", true);
          stepState.put("errorMsg", null);
          stepState.put("invalidFields", new ArrayList<String>());
          clone.getStepStates().put("activites", stepState);
        
          stepState = new HashMap<String, Object>(4);
          stepState.put("state", "unavailable");
          stepState.put("required", true);
          stepState.put("errorMsg", null);
          stepState.put("invalidFields", new ArrayList<String>());
          clone.getStepStates().put("paiement", stepState);
        
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

  
    public final void setEcoleInscription(final fr.cg95.cvq.business.request.school.SaprEcoleInscriptionType ecoleInscription) {
        saintouenActivitePeriscolaireRequestData.setEcoleInscription(ecoleInscription);
    }

    
    public final fr.cg95.cvq.business.request.school.SaprEcoleInscriptionType getEcoleInscription() {
        return saintouenActivitePeriscolaireRequestData.getEcoleInscription();
    }
  
    public final void setSaprAccueilMatin(final Boolean saprAccueilMatin) {
        saintouenActivitePeriscolaireRequestData.setSaprAccueilMatin(saprAccueilMatin);
    }

    
    public final Boolean getSaprAccueilMatin() {
        return saintouenActivitePeriscolaireRequestData.getSaprAccueilMatin();
    }
  
    public final void setSaprAccueilMercrediEtVacances(final Boolean saprAccueilMercrediEtVacances) {
        saintouenActivitePeriscolaireRequestData.setSaprAccueilMercrediEtVacances(saprAccueilMercrediEtVacances);
    }

    
    public final Boolean getSaprAccueilMercrediEtVacances() {
        return saintouenActivitePeriscolaireRequestData.getSaprAccueilMercrediEtVacances();
    }
  
    public final void setSaprAccueilSoir(final Boolean saprAccueilSoir) {
        saintouenActivitePeriscolaireRequestData.setSaprAccueilSoir(saprAccueilSoir);
    }

    
    public final Boolean getSaprAccueilSoir() {
        return saintouenActivitePeriscolaireRequestData.getSaprAccueilSoir();
    }
  
    public final void setSaprEstAllergique(final Boolean saprEstAllergique) {
        saintouenActivitePeriscolaireRequestData.setSaprEstAllergique(saprEstAllergique);
    }

    
    public final Boolean getSaprEstAllergique() {
        return saintouenActivitePeriscolaireRequestData.getSaprEstAllergique();
    }
  
    public final void setSaprEstHandicapeInvalidant(final Boolean saprEstHandicapeInvalidant) {
        saintouenActivitePeriscolaireRequestData.setSaprEstHandicapeInvalidant(saprEstHandicapeInvalidant);
    }

    
    public final Boolean getSaprEstHandicapeInvalidant() {
        return saintouenActivitePeriscolaireRequestData.getSaprEstHandicapeInvalidant();
    }
  
    public final void setSaprEstRestauration(final Boolean saprEstRestauration) {
        saintouenActivitePeriscolaireRequestData.setSaprEstRestauration(saprEstRestauration);
    }

    
    public final Boolean getSaprEstRestauration() {
        return saintouenActivitePeriscolaireRequestData.getSaprEstRestauration();
    }
  
    public final void setSaprEtudesSurveillees(final Boolean saprEtudesSurveillees) {
        saintouenActivitePeriscolaireRequestData.setSaprEtudesSurveillees(saprEtudesSurveillees);
    }

    
    public final Boolean getSaprEtudesSurveillees() {
        return saintouenActivitePeriscolaireRequestData.getSaprEtudesSurveillees();
    }
  
    public final void setSaprModeReglement(final List<fr.cg95.cvq.business.request.LocalReferentialData> saprModeReglement) {
        saintouenActivitePeriscolaireRequestData.setSaprModeReglement(saprModeReglement);
    }

    
    public final List<fr.cg95.cvq.business.request.LocalReferentialData> getSaprModeReglement() {
        return saintouenActivitePeriscolaireRequestData.getSaprModeReglement();
    }
  
    public final void setSaprReglementInterieur(final Boolean saprReglementInterieur) {
        saintouenActivitePeriscolaireRequestData.setSaprReglementInterieur(saprReglementInterieur);
    }

    @IsRulesAcceptance
    public final Boolean getSaprReglementInterieur() {
        return saintouenActivitePeriscolaireRequestData.getSaprReglementInterieur();
    }
  
}
