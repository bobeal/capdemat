
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
public class RenewalPerischoolActivitiesRequest extends Request implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final Map<String, IConditionChecker> conditions = RenewalPerischoolActivitiesRequestData.conditions;

    @AssertValid(message = "")
    private RenewalPerischoolActivitiesRequestData renewalPerischoolActivitiesRequestData;

    public RenewalPerischoolActivitiesRequest(RequestData requestData, RenewalPerischoolActivitiesRequestData renewalPerischoolActivitiesRequestData) {
        super(requestData);
        this.renewalPerischoolActivitiesRequestData = renewalPerischoolActivitiesRequestData;
    }

    public RenewalPerischoolActivitiesRequest() {
        super();
        this.renewalPerischoolActivitiesRequestData = new RenewalPerischoolActivitiesRequestData();
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
    public RenewalPerischoolActivitiesRequestData getSpecificData() {
        return renewalPerischoolActivitiesRequestData;
    }

    /**
     * Reserved for RequestDAO !
     */
    public void setSpecificData(RenewalPerischoolActivitiesRequestData renewalPerischoolActivitiesRequestData) {
        this.renewalPerischoolActivitiesRequestData = renewalPerischoolActivitiesRequestData;
    }

    @Override
    public final String modelToXmlString() {
        RenewalPerischoolActivitiesRequestDocument object = this.modelToXml();
        XmlOptions opts = new XmlOptions();
        opts.setSavePrettyPrint();
        opts.setSavePrettyPrintIndent(4);
        opts.setUseDefaultNamespace();
        opts.setCharacterEncoding("UTF-8");
        return object.xmlText(opts);
    }

    @Override
    public final RenewalPerischoolActivitiesRequestDocument modelToXml() {
        
        Calendar calendar = Calendar.getInstance();
        LocalTime localTime = new LocalTime();
        Date date = null;
        RenewalPerischoolActivitiesRequestDocument renewalPerischoolActivitiesRequestDoc = RenewalPerischoolActivitiesRequestDocument.Factory.newInstance();
        RenewalPerischoolActivitiesRequestDocument.RenewalPerischoolActivitiesRequest renewalPerischoolActivitiesRequest = renewalPerischoolActivitiesRequestDoc.addNewRenewalPerischoolActivitiesRequest();
        super.fillCommonXmlInfo(renewalPerischoolActivitiesRequest);
        int i = 0;
        
        if (getAcceptationReglementInterieur() != null)
            renewalPerischoolActivitiesRequest.setAcceptationReglementInterieur(getAcceptationReglementInterieur().booleanValue());
      
        if (getEstPeriscolaire() != null)
            renewalPerischoolActivitiesRequest.setEstPeriscolaire(getEstPeriscolaire().booleanValue());
      
        if (getEstRestauration() != null)
            renewalPerischoolActivitiesRequest.setEstRestauration(getEstRestauration().booleanValue());
      
        return renewalPerischoolActivitiesRequestDoc;
    }

    @Override
    public final RenewalPerischoolActivitiesRequestDocument.RenewalPerischoolActivitiesRequest modelToXmlRequest() {
        return modelToXml().getRenewalPerischoolActivitiesRequest();
    }

    public static RenewalPerischoolActivitiesRequest xmlToModel(RenewalPerischoolActivitiesRequestDocument renewalPerischoolActivitiesRequestDoc) {
        RenewalPerischoolActivitiesRequestDocument.RenewalPerischoolActivitiesRequest renewalPerischoolActivitiesRequestXml = renewalPerischoolActivitiesRequestDoc.getRenewalPerischoolActivitiesRequest();
        Calendar calendar = Calendar.getInstance();
        LocalTime localTime = new LocalTime();
        List list = new ArrayList();
        RenewalPerischoolActivitiesRequest renewalPerischoolActivitiesRequest = new RenewalPerischoolActivitiesRequest();
        renewalPerischoolActivitiesRequest.fillCommonModelInfo(renewalPerischoolActivitiesRequest, renewalPerischoolActivitiesRequestXml);
        
        renewalPerischoolActivitiesRequest.setAcceptationReglementInterieur(Boolean.valueOf(renewalPerischoolActivitiesRequestXml.getAcceptationReglementInterieur()));
      
        renewalPerischoolActivitiesRequest.setEstPeriscolaire(Boolean.valueOf(renewalPerischoolActivitiesRequestXml.getEstPeriscolaire()));
      
        renewalPerischoolActivitiesRequest.setEstRestauration(Boolean.valueOf(renewalPerischoolActivitiesRequestXml.getEstRestauration()));
      
        return renewalPerischoolActivitiesRequest;
    }

    @Override
    public RenewalPerischoolActivitiesRequest clone() {
        RenewalPerischoolActivitiesRequest clone = new RenewalPerischoolActivitiesRequest(getRequestData().clone(), renewalPerischoolActivitiesRequestData.clone());
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
        renewalPerischoolActivitiesRequestData.setAcceptationReglementInterieur(acceptationReglementInterieur);
    }

    @IsRulesAcceptance
    public final Boolean getAcceptationReglementInterieur() {
        return renewalPerischoolActivitiesRequestData.getAcceptationReglementInterieur();
    }
  
    public final void setEstPeriscolaire(final Boolean estPeriscolaire) {
        renewalPerischoolActivitiesRequestData.setEstPeriscolaire(estPeriscolaire);
    }

    
    public final Boolean getEstPeriscolaire() {
        return renewalPerischoolActivitiesRequestData.getEstPeriscolaire();
    }
  
    public final void setEstRestauration(final Boolean estRestauration) {
        renewalPerischoolActivitiesRequestData.setEstRestauration(estRestauration);
    }

    
    public final Boolean getEstRestauration() {
        return renewalPerischoolActivitiesRequestData.getEstRestauration();
    }
  
}
