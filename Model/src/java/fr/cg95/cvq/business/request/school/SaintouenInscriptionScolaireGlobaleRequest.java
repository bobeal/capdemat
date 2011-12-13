
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
public class SaintouenInscriptionScolaireGlobaleRequest extends Request implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final Map<String, IConditionChecker> conditions = SaintouenInscriptionScolaireGlobaleRequestData.conditions;

    @AssertValid(message = "")
    private SaintouenInscriptionScolaireGlobaleRequestData saintouenInscriptionScolaireGlobaleRequestData;

    public SaintouenInscriptionScolaireGlobaleRequest(RequestData requestData, SaintouenInscriptionScolaireGlobaleRequestData saintouenInscriptionScolaireGlobaleRequestData) {
        super(requestData);
        this.saintouenInscriptionScolaireGlobaleRequestData = saintouenInscriptionScolaireGlobaleRequestData;
    }

    public SaintouenInscriptionScolaireGlobaleRequest() {
        super();
        this.saintouenInscriptionScolaireGlobaleRequestData = new SaintouenInscriptionScolaireGlobaleRequestData();
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
    public SaintouenInscriptionScolaireGlobaleRequestData getSpecificData() {
        return saintouenInscriptionScolaireGlobaleRequestData;
    }

    /**
     * Reserved for RequestDAO !
     */
    public void setSpecificData(SaintouenInscriptionScolaireGlobaleRequestData saintouenInscriptionScolaireGlobaleRequestData) {
        this.saintouenInscriptionScolaireGlobaleRequestData = saintouenInscriptionScolaireGlobaleRequestData;
    }

    @Override
    public final String modelToXmlString() {
        SaintouenInscriptionScolaireGlobaleRequestDocument object = this.modelToXml();
        XmlOptions opts = new XmlOptions();
        opts.setSavePrettyPrint();
        opts.setSavePrettyPrintIndent(4);
        opts.setUseDefaultNamespace();
        opts.setCharacterEncoding("UTF-8");
        return object.xmlText(opts);
    }

    @Override
    public final SaintouenInscriptionScolaireGlobaleRequestDocument modelToXml() {
        
        Calendar calendar = Calendar.getInstance();
        LocalTime localTime = new LocalTime();
        Date date = null;
        SaintouenInscriptionScolaireGlobaleRequestDocument saintouenInscriptionScolaireGlobaleRequestDoc = SaintouenInscriptionScolaireGlobaleRequestDocument.Factory.newInstance();
        SaintouenInscriptionScolaireGlobaleRequestDocument.SaintouenInscriptionScolaireGlobaleRequest saintouenInscriptionScolaireGlobaleRequest = saintouenInscriptionScolaireGlobaleRequestDoc.addNewSaintouenInscriptionScolaireGlobaleRequest();
        super.fillCommonXmlInfo(saintouenInscriptionScolaireGlobaleRequest);
        int i = 0;
          SisgrInscriptionPeriscolaireType sisgrInscriptionPeriscolaireTypeInscriptionPeriscolaire = saintouenInscriptionScolaireGlobaleRequest.addNewInscriptionPeriscolaire();
        if (getAccueilMatin() != null)
            sisgrInscriptionPeriscolaireTypeInscriptionPeriscolaire.setAccueilMatin(getAccueilMatin().booleanValue());
      
        if (getAccueilMercrediEtVacances() != null)
            sisgrInscriptionPeriscolaireTypeInscriptionPeriscolaire.setAccueilMercrediEtVacances(getAccueilMercrediEtVacances().booleanValue());
      
        if (getAccueilSoir() != null)
            sisgrInscriptionPeriscolaireTypeInscriptionPeriscolaire.setAccueilSoir(getAccueilSoir().booleanValue());
      
        if (getEstAllergique() != null)
            saintouenInscriptionScolaireGlobaleRequest.setEstAllergique(getEstAllergique().booleanValue());
      
        if (getEstHandicapeInvalidant() != null)
            saintouenInscriptionScolaireGlobaleRequest.setEstHandicapeInvalidant(getEstHandicapeInvalidant().booleanValue());
      
        if (getEstRestauration() != null)
            saintouenInscriptionScolaireGlobaleRequest.setEstRestauration(getEstRestauration().booleanValue());
      
        if (getEtudesSurveillees() != null)
            sisgrInscriptionPeriscolaireTypeInscriptionPeriscolaire.setEtudesSurveillees(getEtudesSurveillees().booleanValue());
        SisgrEcoleSecteurType sisgrEcoleSecteurTypeEcoleSecteur = saintouenInscriptionScolaireGlobaleRequest.addNewEcoleSecteur();
        sisgrEcoleSecteurTypeEcoleSecteur.setIdEcoleSecteur(getIdEcoleSecteur());
      
        sisgrEcoleSecteurTypeEcoleSecteur.setLabelEcoleSecteur(getLabelEcoleSecteur());
      
        i = 0;
        if (getModeReglement() != null) {
            fr.cg95.cvq.xml.common.LocalReferentialDataType[] modeReglementTypeTab = new fr.cg95.cvq.xml.common.LocalReferentialDataType[getModeReglement().size()];
            for (LocalReferentialData object : getModeReglement()) {
              modeReglementTypeTab[i++] = LocalReferentialData.modelToXml(object);
            }
            saintouenInscriptionScolaireGlobaleRequest.setModeReglementArray(modeReglementTypeTab);
        }
      
        if (getReglementInterieur() != null)
            saintouenInscriptionScolaireGlobaleRequest.setReglementInterieur(getReglementInterieur().booleanValue());
      
        return saintouenInscriptionScolaireGlobaleRequestDoc;
    }

    @Override
    public final SaintouenInscriptionScolaireGlobaleRequestDocument.SaintouenInscriptionScolaireGlobaleRequest modelToXmlRequest() {
        return modelToXml().getSaintouenInscriptionScolaireGlobaleRequest();
    }

    public static SaintouenInscriptionScolaireGlobaleRequest xmlToModel(SaintouenInscriptionScolaireGlobaleRequestDocument saintouenInscriptionScolaireGlobaleRequestDoc) {
        SaintouenInscriptionScolaireGlobaleRequestDocument.SaintouenInscriptionScolaireGlobaleRequest saintouenInscriptionScolaireGlobaleRequestXml = saintouenInscriptionScolaireGlobaleRequestDoc.getSaintouenInscriptionScolaireGlobaleRequest();
        Calendar calendar = Calendar.getInstance();
        LocalTime localTime = new LocalTime();
        List list = new ArrayList();
        SaintouenInscriptionScolaireGlobaleRequest saintouenInscriptionScolaireGlobaleRequest = new SaintouenInscriptionScolaireGlobaleRequest();
        saintouenInscriptionScolaireGlobaleRequest.fillCommonModelInfo(saintouenInscriptionScolaireGlobaleRequest, saintouenInscriptionScolaireGlobaleRequestXml);
        
        saintouenInscriptionScolaireGlobaleRequest.setAccueilMatin(Boolean.valueOf(saintouenInscriptionScolaireGlobaleRequestXml.getInscriptionPeriscolaire().getAccueilMatin()));
      
        saintouenInscriptionScolaireGlobaleRequest.setAccueilMercrediEtVacances(Boolean.valueOf(saintouenInscriptionScolaireGlobaleRequestXml.getInscriptionPeriscolaire().getAccueilMercrediEtVacances()));
      
        saintouenInscriptionScolaireGlobaleRequest.setAccueilSoir(Boolean.valueOf(saintouenInscriptionScolaireGlobaleRequestXml.getInscriptionPeriscolaire().getAccueilSoir()));
      
        saintouenInscriptionScolaireGlobaleRequest.setEstAllergique(Boolean.valueOf(saintouenInscriptionScolaireGlobaleRequestXml.getEstAllergique()));
      
        saintouenInscriptionScolaireGlobaleRequest.setEstHandicapeInvalidant(Boolean.valueOf(saintouenInscriptionScolaireGlobaleRequestXml.getEstHandicapeInvalidant()));
      
        saintouenInscriptionScolaireGlobaleRequest.setEstRestauration(Boolean.valueOf(saintouenInscriptionScolaireGlobaleRequestXml.getEstRestauration()));
      
        saintouenInscriptionScolaireGlobaleRequest.setEtudesSurveillees(Boolean.valueOf(saintouenInscriptionScolaireGlobaleRequestXml.getInscriptionPeriscolaire().getEtudesSurveillees()));
      
        saintouenInscriptionScolaireGlobaleRequest.setIdEcoleSecteur(saintouenInscriptionScolaireGlobaleRequestXml.getEcoleSecteur().getIdEcoleSecteur());
      
        saintouenInscriptionScolaireGlobaleRequest.setLabelEcoleSecteur(saintouenInscriptionScolaireGlobaleRequestXml.getEcoleSecteur().getLabelEcoleSecteur());
      
        List<fr.cg95.cvq.business.request.LocalReferentialData> modeReglementList = new ArrayList<fr.cg95.cvq.business.request.LocalReferentialData>(saintouenInscriptionScolaireGlobaleRequestXml.sizeOfModeReglementArray());
        for (LocalReferentialDataType object : saintouenInscriptionScolaireGlobaleRequestXml.getModeReglementArray()) {
            modeReglementList.add(fr.cg95.cvq.business.request.LocalReferentialData.xmlToModel(object));
        }
        saintouenInscriptionScolaireGlobaleRequest.setModeReglement(modeReglementList);
      
        saintouenInscriptionScolaireGlobaleRequest.setReglementInterieur(Boolean.valueOf(saintouenInscriptionScolaireGlobaleRequestXml.getReglementInterieur()));
      
        return saintouenInscriptionScolaireGlobaleRequest;
    }

    @Override
    public SaintouenInscriptionScolaireGlobaleRequest clone() {
        SaintouenInscriptionScolaireGlobaleRequest clone = new SaintouenInscriptionScolaireGlobaleRequest(getRequestData().clone(), saintouenInscriptionScolaireGlobaleRequestData.clone());
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

  
    public final void setAccueilMatin(final Boolean accueilMatin) {
        saintouenInscriptionScolaireGlobaleRequestData.setAccueilMatin(accueilMatin);
    }

    
    public final Boolean getAccueilMatin() {
        return saintouenInscriptionScolaireGlobaleRequestData.getAccueilMatin();
    }
  
    public final void setAccueilMercrediEtVacances(final Boolean accueilMercrediEtVacances) {
        saintouenInscriptionScolaireGlobaleRequestData.setAccueilMercrediEtVacances(accueilMercrediEtVacances);
    }

    
    public final Boolean getAccueilMercrediEtVacances() {
        return saintouenInscriptionScolaireGlobaleRequestData.getAccueilMercrediEtVacances();
    }
  
    public final void setAccueilSoir(final Boolean accueilSoir) {
        saintouenInscriptionScolaireGlobaleRequestData.setAccueilSoir(accueilSoir);
    }

    
    public final Boolean getAccueilSoir() {
        return saintouenInscriptionScolaireGlobaleRequestData.getAccueilSoir();
    }
  
    public final void setEstAllergique(final Boolean estAllergique) {
        saintouenInscriptionScolaireGlobaleRequestData.setEstAllergique(estAllergique);
    }

    
    public final Boolean getEstAllergique() {
        return saintouenInscriptionScolaireGlobaleRequestData.getEstAllergique();
    }
  
    public final void setEstHandicapeInvalidant(final Boolean estHandicapeInvalidant) {
        saintouenInscriptionScolaireGlobaleRequestData.setEstHandicapeInvalidant(estHandicapeInvalidant);
    }

    
    public final Boolean getEstHandicapeInvalidant() {
        return saintouenInscriptionScolaireGlobaleRequestData.getEstHandicapeInvalidant();
    }
  
    public final void setEstRestauration(final Boolean estRestauration) {
        saintouenInscriptionScolaireGlobaleRequestData.setEstRestauration(estRestauration);
    }

    
    public final Boolean getEstRestauration() {
        return saintouenInscriptionScolaireGlobaleRequestData.getEstRestauration();
    }
  
    public final void setEtudesSurveillees(final Boolean etudesSurveillees) {
        saintouenInscriptionScolaireGlobaleRequestData.setEtudesSurveillees(etudesSurveillees);
    }

    
    public final Boolean getEtudesSurveillees() {
        return saintouenInscriptionScolaireGlobaleRequestData.getEtudesSurveillees();
    }
  
    public final void setIdEcoleSecteur(final String idEcoleSecteur) {
        saintouenInscriptionScolaireGlobaleRequestData.setIdEcoleSecteur(idEcoleSecteur);
    }

    
    public final String getIdEcoleSecteur() {
        return saintouenInscriptionScolaireGlobaleRequestData.getIdEcoleSecteur();
    }
  
    public final void setLabelEcoleSecteur(final String labelEcoleSecteur) {
        saintouenInscriptionScolaireGlobaleRequestData.setLabelEcoleSecteur(labelEcoleSecteur);
    }

    
    public final String getLabelEcoleSecteur() {
        return saintouenInscriptionScolaireGlobaleRequestData.getLabelEcoleSecteur();
    }
  
    public final void setModeReglement(final List<fr.cg95.cvq.business.request.LocalReferentialData> modeReglement) {
        saintouenInscriptionScolaireGlobaleRequestData.setModeReglement(modeReglement);
    }

    
    public final List<fr.cg95.cvq.business.request.LocalReferentialData> getModeReglement() {
        return saintouenInscriptionScolaireGlobaleRequestData.getModeReglement();
    }
  
    public final void setReglementInterieur(final Boolean reglementInterieur) {
        saintouenInscriptionScolaireGlobaleRequestData.setReglementInterieur(reglementInterieur);
    }

    @IsRulesAcceptance
    public final Boolean getReglementInterieur() {
        return saintouenInscriptionScolaireGlobaleRequestData.getReglementInterieur();
    }
  
}
