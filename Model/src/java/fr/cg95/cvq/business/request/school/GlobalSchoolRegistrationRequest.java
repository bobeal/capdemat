
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
public class GlobalSchoolRegistrationRequest extends Request implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final Map<String, IConditionChecker> conditions = GlobalSchoolRegistrationRequestData.conditions;

    @AssertValid(message = "")
    private GlobalSchoolRegistrationRequestData globalSchoolRegistrationRequestData;

    public GlobalSchoolRegistrationRequest(RequestData requestData, GlobalSchoolRegistrationRequestData globalSchoolRegistrationRequestData) {
        super(requestData);
        this.globalSchoolRegistrationRequestData = globalSchoolRegistrationRequestData;
    }

    public GlobalSchoolRegistrationRequest() {
        super();
        this.globalSchoolRegistrationRequestData = new GlobalSchoolRegistrationRequestData();
        Map<String, Object> stepState;
        
          stepState = new HashMap<String, Object>(4);
          stepState.put("state", "uncomplete");
          stepState.put("required", true);
          stepState.put("errorMsg", null);
          stepState.put("invalidFields", new ArrayList<String>());
          getStepStates().put("enfant", stepState);
        
          stepState = new HashMap<String, Object>(4);
          stepState.put("state", "unavailable");
          stepState.put("required", true);
          stepState.put("errorMsg", null);
          stepState.put("invalidFields", new ArrayList<String>());
          getStepStates().put("restauration", stepState);
        
          stepState = new HashMap<String, Object>(4);
          stepState.put("state", "unavailable");
          stepState.put("required", true);
          stepState.put("errorMsg", null);
          stepState.put("invalidFields", new ArrayList<String>());
          getStepStates().put("periscolaire", stepState);
        
          stepState = new HashMap<String, Object>(4);
          stepState.put("state", "unavailable");
          stepState.put("required", true);
          stepState.put("errorMsg", null);
          stepState.put("invalidFields", new ArrayList<String>());
          getStepStates().put("reglements", stepState);
        
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
    public GlobalSchoolRegistrationRequestData getSpecificData() {
        return globalSchoolRegistrationRequestData;
    }

    /**
     * Reserved for RequestDAO !
     */
    public void setSpecificData(GlobalSchoolRegistrationRequestData globalSchoolRegistrationRequestData) {
        this.globalSchoolRegistrationRequestData = globalSchoolRegistrationRequestData;
    }

    @Override
    public final String modelToXmlString() {
        GlobalSchoolRegistrationRequestDocument object = this.modelToXml();
        XmlOptions opts = new XmlOptions();
        opts.setSavePrettyPrint();
        opts.setSavePrettyPrintIndent(4);
        opts.setUseDefaultNamespace();
        opts.setCharacterEncoding("UTF-8");
        return object.xmlText(opts);
    }

    @Override
    public final GlobalSchoolRegistrationRequestDocument modelToXml() {
        
        Calendar calendar = Calendar.getInstance();
        LocalTime localTime = new LocalTime();
        Date date = null;
        GlobalSchoolRegistrationRequestDocument globalSchoolRegistrationRequestDoc = GlobalSchoolRegistrationRequestDocument.Factory.newInstance();
        GlobalSchoolRegistrationRequestDocument.GlobalSchoolRegistrationRequest globalSchoolRegistrationRequest = globalSchoolRegistrationRequestDoc.addNewGlobalSchoolRegistrationRequest();
        super.fillCommonXmlInfo(globalSchoolRegistrationRequest);
        int i = 0;
        
        if (getAcceptationReglementInterieur() != null)
            globalSchoolRegistrationRequest.setAcceptationReglementInterieur(getAcceptationReglementInterieur().booleanValue());
      
        if (getEstDerogation() != null)
            globalSchoolRegistrationRequest.setEstDerogation(getEstDerogation().booleanValue());
      
        if (getEstPeriscolaire() != null)
            globalSchoolRegistrationRequest.setEstPeriscolaire(getEstPeriscolaire().booleanValue());
      
        if (getEstRestauration() != null)
            globalSchoolRegistrationRequest.setEstRestauration(getEstRestauration().booleanValue());
        EcoleDerogType ecoleDerogTypeEcoleDerogation = globalSchoolRegistrationRequest.addNewEcoleDerogation();
        ecoleDerogTypeEcoleDerogation.setIdEcoleDerog(getIdEcoleDerog());
        EcoleSecteurType ecoleSecteurTypeEcoleSecteur = globalSchoolRegistrationRequest.addNewEcoleSecteur();
        ecoleSecteurTypeEcoleSecteur.setIdEcoleSecteur(getIdEcoleSecteur());
      
        globalSchoolRegistrationRequest.setInformationsComplementairesDerogation(getInformationsComplementairesDerogation());
      
        ecoleDerogTypeEcoleDerogation.setLabelEcoleDerog(getLabelEcoleDerog());
      
        ecoleSecteurTypeEcoleSecteur.setLabelEcoleSecteur(getLabelEcoleSecteur());
      
        i = 0;
        if (getMotifsDerogationEcole() != null) {
            fr.cg95.cvq.xml.common.LocalReferentialDataType[] motifsDerogationEcoleTypeTab = new fr.cg95.cvq.xml.common.LocalReferentialDataType[getMotifsDerogationEcole().size()];
            for (LocalReferentialData object : getMotifsDerogationEcole()) {
              motifsDerogationEcoleTypeTab[i++] = LocalReferentialData.modelToXml(object);
            }
            globalSchoolRegistrationRequest.setMotifsDerogationEcoleArray(motifsDerogationEcoleTypeTab);
        }
      
        i = 0;
        if (getRegimeAlimentaire() != null) {
            fr.cg95.cvq.xml.common.LocalReferentialDataType[] regimeAlimentaireTypeTab = new fr.cg95.cvq.xml.common.LocalReferentialDataType[getRegimeAlimentaire().size()];
            for (LocalReferentialData object : getRegimeAlimentaire()) {
              regimeAlimentaireTypeTab[i++] = LocalReferentialData.modelToXml(object);
            }
            globalSchoolRegistrationRequest.setRegimeAlimentaireArray(regimeAlimentaireTypeTab);
        }
      
        return globalSchoolRegistrationRequestDoc;
    }

    @Override
    public final GlobalSchoolRegistrationRequestDocument.GlobalSchoolRegistrationRequest modelToXmlRequest() {
        return modelToXml().getGlobalSchoolRegistrationRequest();
    }

    public static GlobalSchoolRegistrationRequest xmlToModel(GlobalSchoolRegistrationRequestDocument globalSchoolRegistrationRequestDoc) {
        GlobalSchoolRegistrationRequestDocument.GlobalSchoolRegistrationRequest globalSchoolRegistrationRequestXml = globalSchoolRegistrationRequestDoc.getGlobalSchoolRegistrationRequest();
        Calendar calendar = Calendar.getInstance();
        LocalTime localTime = new LocalTime();
        List list = new ArrayList();
        GlobalSchoolRegistrationRequest globalSchoolRegistrationRequest = new GlobalSchoolRegistrationRequest();
        globalSchoolRegistrationRequest.fillCommonModelInfo(globalSchoolRegistrationRequest, globalSchoolRegistrationRequestXml);
        
        globalSchoolRegistrationRequest.setAcceptationReglementInterieur(Boolean.valueOf(globalSchoolRegistrationRequestXml.getAcceptationReglementInterieur()));
      
        globalSchoolRegistrationRequest.setEstDerogation(Boolean.valueOf(globalSchoolRegistrationRequestXml.getEstDerogation()));
      
        globalSchoolRegistrationRequest.setEstPeriscolaire(Boolean.valueOf(globalSchoolRegistrationRequestXml.getEstPeriscolaire()));
      
        globalSchoolRegistrationRequest.setEstRestauration(Boolean.valueOf(globalSchoolRegistrationRequestXml.getEstRestauration()));
      
        globalSchoolRegistrationRequest.setIdEcoleDerog(globalSchoolRegistrationRequestXml.getEcoleDerogation().getIdEcoleDerog());
      
        globalSchoolRegistrationRequest.setIdEcoleSecteur(globalSchoolRegistrationRequestXml.getEcoleSecteur().getIdEcoleSecteur());
      
        globalSchoolRegistrationRequest.setInformationsComplementairesDerogation(globalSchoolRegistrationRequestXml.getInformationsComplementairesDerogation());
      
        globalSchoolRegistrationRequest.setLabelEcoleDerog(globalSchoolRegistrationRequestXml.getEcoleDerogation().getLabelEcoleDerog());
      
        globalSchoolRegistrationRequest.setLabelEcoleSecteur(globalSchoolRegistrationRequestXml.getEcoleSecteur().getLabelEcoleSecteur());
      
        List<fr.cg95.cvq.business.request.LocalReferentialData> motifsDerogationEcoleList = new ArrayList<fr.cg95.cvq.business.request.LocalReferentialData>(globalSchoolRegistrationRequestXml.sizeOfMotifsDerogationEcoleArray());
        for (LocalReferentialDataType object : globalSchoolRegistrationRequestXml.getMotifsDerogationEcoleArray()) {
            motifsDerogationEcoleList.add(fr.cg95.cvq.business.request.LocalReferentialData.xmlToModel(object));
        }
        globalSchoolRegistrationRequest.setMotifsDerogationEcole(motifsDerogationEcoleList);
      
        List<fr.cg95.cvq.business.request.LocalReferentialData> regimeAlimentaireList = new ArrayList<fr.cg95.cvq.business.request.LocalReferentialData>(globalSchoolRegistrationRequestXml.sizeOfRegimeAlimentaireArray());
        for (LocalReferentialDataType object : globalSchoolRegistrationRequestXml.getRegimeAlimentaireArray()) {
            regimeAlimentaireList.add(fr.cg95.cvq.business.request.LocalReferentialData.xmlToModel(object));
        }
        globalSchoolRegistrationRequest.setRegimeAlimentaire(regimeAlimentaireList);
      
        return globalSchoolRegistrationRequest;
    }

    @Override
    public GlobalSchoolRegistrationRequest clone() {
        GlobalSchoolRegistrationRequest clone = new GlobalSchoolRegistrationRequest(getRequestData().clone(), globalSchoolRegistrationRequestData.clone());
        Map<String, Object> stepState;
        
          stepState = new HashMap<String, Object>(4);
          stepState.put("state", "uncomplete");
          stepState.put("required", true);
          stepState.put("errorMsg", null);
          stepState.put("invalidFields", new ArrayList<String>());
          clone.getStepStates().put("enfant", stepState);
        
          stepState = new HashMap<String, Object>(4);
          stepState.put("state", "unavailable");
          stepState.put("required", true);
          stepState.put("errorMsg", null);
          stepState.put("invalidFields", new ArrayList<String>());
          clone.getStepStates().put("restauration", stepState);
        
          stepState = new HashMap<String, Object>(4);
          stepState.put("state", "unavailable");
          stepState.put("required", true);
          stepState.put("errorMsg", null);
          stepState.put("invalidFields", new ArrayList<String>());
          clone.getStepStates().put("periscolaire", stepState);
        
          stepState = new HashMap<String, Object>(4);
          stepState.put("state", "unavailable");
          stepState.put("required", true);
          stepState.put("errorMsg", null);
          stepState.put("invalidFields", new ArrayList<String>());
          clone.getStepStates().put("reglements", stepState);
        
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

  
    public final void setAcceptationReglementInterieur(final Boolean acceptationReglementInterieur) {
        globalSchoolRegistrationRequestData.setAcceptationReglementInterieur(acceptationReglementInterieur);
    }

    @IsRulesAcceptance
    public final Boolean getAcceptationReglementInterieur() {
        return globalSchoolRegistrationRequestData.getAcceptationReglementInterieur();
    }
  
    public final void setEstDerogation(final Boolean estDerogation) {
        globalSchoolRegistrationRequestData.setEstDerogation(estDerogation);
    }

    
    public final Boolean getEstDerogation() {
        return globalSchoolRegistrationRequestData.getEstDerogation();
    }
  
    public final void setEstPeriscolaire(final Boolean estPeriscolaire) {
        globalSchoolRegistrationRequestData.setEstPeriscolaire(estPeriscolaire);
    }

    
    public final Boolean getEstPeriscolaire() {
        return globalSchoolRegistrationRequestData.getEstPeriscolaire();
    }
  
    public final void setEstRestauration(final Boolean estRestauration) {
        globalSchoolRegistrationRequestData.setEstRestauration(estRestauration);
    }

    
    public final Boolean getEstRestauration() {
        return globalSchoolRegistrationRequestData.getEstRestauration();
    }
  
    public final void setIdEcoleDerog(final String idEcoleDerog) {
        globalSchoolRegistrationRequestData.setIdEcoleDerog(idEcoleDerog);
    }

    
    public final String getIdEcoleDerog() {
        return globalSchoolRegistrationRequestData.getIdEcoleDerog();
    }
  
    public final void setIdEcoleSecteur(final String idEcoleSecteur) {
        globalSchoolRegistrationRequestData.setIdEcoleSecteur(idEcoleSecteur);
    }

    
    public final String getIdEcoleSecteur() {
        return globalSchoolRegistrationRequestData.getIdEcoleSecteur();
    }
  
    public final void setInformationsComplementairesDerogation(final String informationsComplementairesDerogation) {
        globalSchoolRegistrationRequestData.setInformationsComplementairesDerogation(informationsComplementairesDerogation);
    }

    
    public final String getInformationsComplementairesDerogation() {
        return globalSchoolRegistrationRequestData.getInformationsComplementairesDerogation();
    }
  
    public final void setLabelEcoleDerog(final String labelEcoleDerog) {
        globalSchoolRegistrationRequestData.setLabelEcoleDerog(labelEcoleDerog);
    }

    
    public final String getLabelEcoleDerog() {
        return globalSchoolRegistrationRequestData.getLabelEcoleDerog();
    }
  
    public final void setLabelEcoleSecteur(final String labelEcoleSecteur) {
        globalSchoolRegistrationRequestData.setLabelEcoleSecteur(labelEcoleSecteur);
    }

    
    public final String getLabelEcoleSecteur() {
        return globalSchoolRegistrationRequestData.getLabelEcoleSecteur();
    }
  
    public final void setMotifsDerogationEcole(final List<fr.cg95.cvq.business.request.LocalReferentialData> motifsDerogationEcole) {
        globalSchoolRegistrationRequestData.setMotifsDerogationEcole(motifsDerogationEcole);
    }

    
    public final List<fr.cg95.cvq.business.request.LocalReferentialData> getMotifsDerogationEcole() {
        return globalSchoolRegistrationRequestData.getMotifsDerogationEcole();
    }
  
    public final void setRegimeAlimentaire(final List<fr.cg95.cvq.business.request.LocalReferentialData> regimeAlimentaire) {
        globalSchoolRegistrationRequestData.setRegimeAlimentaire(regimeAlimentaire);
    }

    
    public final List<fr.cg95.cvq.business.request.LocalReferentialData> getRegimeAlimentaire() {
        return globalSchoolRegistrationRequestData.getRegimeAlimentaire();
    }
  
}
