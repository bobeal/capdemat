
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
public class LeisureCenterRegistrationRequest extends Request implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final Map<String, IConditionChecker> conditions = LeisureCenterRegistrationRequestData.conditions;

    @AssertValid(message = "")
    private LeisureCenterRegistrationRequestData leisureCenterRegistrationRequestData;

    public LeisureCenterRegistrationRequest(RequestData requestData, LeisureCenterRegistrationRequestData leisureCenterRegistrationRequestData) {
        super(requestData);
        this.leisureCenterRegistrationRequestData = leisureCenterRegistrationRequestData;
    }

    public LeisureCenterRegistrationRequest() {
        super();
        this.leisureCenterRegistrationRequestData = new LeisureCenterRegistrationRequestData();
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
    public LeisureCenterRegistrationRequestData getSpecificData() {
        return leisureCenterRegistrationRequestData;
    }

    /**
     * Reserved for RequestDAO !
     */
    public void setSpecificData(LeisureCenterRegistrationRequestData leisureCenterRegistrationRequestData) {
        this.leisureCenterRegistrationRequestData = leisureCenterRegistrationRequestData;
    }

    @Override
    public final String modelToXmlString() {
        LeisureCenterRegistrationRequestDocument object = this.modelToXml();
        XmlOptions opts = new XmlOptions();
        opts.setSavePrettyPrint();
        opts.setSavePrettyPrintIndent(4);
        opts.setUseDefaultNamespace();
        opts.setCharacterEncoding("UTF-8");
        return object.xmlText(opts);
    }

    @Override
    public final LeisureCenterRegistrationRequestDocument modelToXml() {
        
        Calendar calendar = Calendar.getInstance();
        LocalTime localTime = new LocalTime();
        Date date = null;
        LeisureCenterRegistrationRequestDocument leisureCenterRegistrationRequestDoc = LeisureCenterRegistrationRequestDocument.Factory.newInstance();
        LeisureCenterRegistrationRequestDocument.LeisureCenterRegistrationRequest leisureCenterRegistrationRequest = leisureCenterRegistrationRequestDoc.addNewLeisureCenterRegistrationRequest();
        super.fillCommonXmlInfo(leisureCenterRegistrationRequest);
        int i = 0;
        
        if (getAcceptationReglementInterieur() != null)
            leisureCenterRegistrationRequest.setAcceptationReglementInterieur(getAcceptationReglementInterieur().booleanValue());
      
        if (getEstDerogation() != null)
            leisureCenterRegistrationRequest.setEstDerogation(getEstDerogation().booleanValue());
      
        if (getEstTransport() != null)
            leisureCenterRegistrationRequest.setEstTransport(getEstTransport().booleanValue());
        TransportsType transportsTypeTransports = leisureCenterRegistrationRequest.addNewTransports();
        transportsTypeTransports.setIdArret(getIdArret());
        CentreLoisirsType centreLoisirsTypeCentresLoisirs = leisureCenterRegistrationRequest.addNewCentresLoisirs();
        centreLoisirsTypeCentresLoisirs.setIdCentreLoisirs(getIdCentreLoisirs());
      
        transportsTypeTransports.setIdLigne(getIdLigne());
      
        transportsTypeTransports.setLabelArret(getLabelArret());
      
        centreLoisirsTypeCentresLoisirs.setLabelCentreLoisirs(getLabelCentreLoisirs());
      
        transportsTypeTransports.setLabelLigne(getLabelLigne());
      
        i = 0;
        if (getMotifsDerogationCentreLoisirs() != null) {
            fr.cg95.cvq.xml.common.LocalReferentialDataType[] motifsDerogationCentreLoisirsTypeTab = new fr.cg95.cvq.xml.common.LocalReferentialDataType[getMotifsDerogationCentreLoisirs().size()];
            for (LocalReferentialData object : getMotifsDerogationCentreLoisirs()) {
              motifsDerogationCentreLoisirsTypeTab[i++] = LocalReferentialData.modelToXml(object);
            }
            leisureCenterRegistrationRequest.setMotifsDerogationCentreLoisirsArray(motifsDerogationCentreLoisirsTypeTab);
        }
      
        return leisureCenterRegistrationRequestDoc;
    }

    @Override
    public final LeisureCenterRegistrationRequestDocument.LeisureCenterRegistrationRequest modelToXmlRequest() {
        return modelToXml().getLeisureCenterRegistrationRequest();
    }

    public static LeisureCenterRegistrationRequest xmlToModel(LeisureCenterRegistrationRequestDocument leisureCenterRegistrationRequestDoc) {
        LeisureCenterRegistrationRequestDocument.LeisureCenterRegistrationRequest leisureCenterRegistrationRequestXml = leisureCenterRegistrationRequestDoc.getLeisureCenterRegistrationRequest();
        Calendar calendar = Calendar.getInstance();
        LocalTime localTime = new LocalTime();
        List list = new ArrayList();
        LeisureCenterRegistrationRequest leisureCenterRegistrationRequest = new LeisureCenterRegistrationRequest();
        leisureCenterRegistrationRequest.fillCommonModelInfo(leisureCenterRegistrationRequest, leisureCenterRegistrationRequestXml);
        
        leisureCenterRegistrationRequest.setAcceptationReglementInterieur(Boolean.valueOf(leisureCenterRegistrationRequestXml.getAcceptationReglementInterieur()));
      
        leisureCenterRegistrationRequest.setEstDerogation(Boolean.valueOf(leisureCenterRegistrationRequestXml.getEstDerogation()));
      
        leisureCenterRegistrationRequest.setEstTransport(Boolean.valueOf(leisureCenterRegistrationRequestXml.getEstTransport()));
      
        leisureCenterRegistrationRequest.setIdArret(leisureCenterRegistrationRequestXml.getTransports().getIdArret());
      
        leisureCenterRegistrationRequest.setIdCentreLoisirs(leisureCenterRegistrationRequestXml.getCentresLoisirs().getIdCentreLoisirs());
      
        leisureCenterRegistrationRequest.setIdLigne(leisureCenterRegistrationRequestXml.getTransports().getIdLigne());
      
        leisureCenterRegistrationRequest.setLabelArret(leisureCenterRegistrationRequestXml.getTransports().getLabelArret());
      
        leisureCenterRegistrationRequest.setLabelCentreLoisirs(leisureCenterRegistrationRequestXml.getCentresLoisirs().getLabelCentreLoisirs());
      
        leisureCenterRegistrationRequest.setLabelLigne(leisureCenterRegistrationRequestXml.getTransports().getLabelLigne());
      
        List<fr.cg95.cvq.business.request.LocalReferentialData> motifsDerogationCentreLoisirsList = new ArrayList<fr.cg95.cvq.business.request.LocalReferentialData>(leisureCenterRegistrationRequestXml.sizeOfMotifsDerogationCentreLoisirsArray());
        for (LocalReferentialDataType object : leisureCenterRegistrationRequestXml.getMotifsDerogationCentreLoisirsArray()) {
            motifsDerogationCentreLoisirsList.add(fr.cg95.cvq.business.request.LocalReferentialData.xmlToModel(object));
        }
        leisureCenterRegistrationRequest.setMotifsDerogationCentreLoisirs(motifsDerogationCentreLoisirsList);
      
        return leisureCenterRegistrationRequest;
    }

    @Override
    public LeisureCenterRegistrationRequest clone() {
        LeisureCenterRegistrationRequest clone = new LeisureCenterRegistrationRequest(getRequestData().clone(), leisureCenterRegistrationRequestData.clone());
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
        leisureCenterRegistrationRequestData.setAcceptationReglementInterieur(acceptationReglementInterieur);
    }

    @IsRulesAcceptance
    public final Boolean getAcceptationReglementInterieur() {
        return leisureCenterRegistrationRequestData.getAcceptationReglementInterieur();
    }
  
    public final void setEstDerogation(final Boolean estDerogation) {
        leisureCenterRegistrationRequestData.setEstDerogation(estDerogation);
    }

    
    public final Boolean getEstDerogation() {
        return leisureCenterRegistrationRequestData.getEstDerogation();
    }
  
    public final void setEstTransport(final Boolean estTransport) {
        leisureCenterRegistrationRequestData.setEstTransport(estTransport);
    }

    
    public final Boolean getEstTransport() {
        return leisureCenterRegistrationRequestData.getEstTransport();
    }
  
    public final void setIdArret(final String idArret) {
        leisureCenterRegistrationRequestData.setIdArret(idArret);
    }

    
    public final String getIdArret() {
        return leisureCenterRegistrationRequestData.getIdArret();
    }
  
    public final void setIdCentreLoisirs(final String idCentreLoisirs) {
        leisureCenterRegistrationRequestData.setIdCentreLoisirs(idCentreLoisirs);
    }

    
    public final String getIdCentreLoisirs() {
        return leisureCenterRegistrationRequestData.getIdCentreLoisirs();
    }
  
    public final void setIdLigne(final String idLigne) {
        leisureCenterRegistrationRequestData.setIdLigne(idLigne);
    }

    
    public final String getIdLigne() {
        return leisureCenterRegistrationRequestData.getIdLigne();
    }
  
    public final void setLabelArret(final String labelArret) {
        leisureCenterRegistrationRequestData.setLabelArret(labelArret);
    }

    
    public final String getLabelArret() {
        return leisureCenterRegistrationRequestData.getLabelArret();
    }
  
    public final void setLabelCentreLoisirs(final String labelCentreLoisirs) {
        leisureCenterRegistrationRequestData.setLabelCentreLoisirs(labelCentreLoisirs);
    }

    
    public final String getLabelCentreLoisirs() {
        return leisureCenterRegistrationRequestData.getLabelCentreLoisirs();
    }
  
    public final void setLabelLigne(final String labelLigne) {
        leisureCenterRegistrationRequestData.setLabelLigne(labelLigne);
    }

    
    public final String getLabelLigne() {
        return leisureCenterRegistrationRequestData.getLabelLigne();
    }
  
    public final void setMotifsDerogationCentreLoisirs(final List<fr.cg95.cvq.business.request.LocalReferentialData> motifsDerogationCentreLoisirs) {
        leisureCenterRegistrationRequestData.setMotifsDerogationCentreLoisirs(motifsDerogationCentreLoisirs);
    }

    
    public final List<fr.cg95.cvq.business.request.LocalReferentialData> getMotifsDerogationCentreLoisirs() {
        return leisureCenterRegistrationRequestData.getMotifsDerogationCentreLoisirs();
    }
  
}
