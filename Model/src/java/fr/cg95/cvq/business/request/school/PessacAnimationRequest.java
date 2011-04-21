
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
public class PessacAnimationRequest extends Request implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final Map<String, IConditionChecker> conditions = PessacAnimationRequestData.conditions;

    @AssertValid(message = "")
    private PessacAnimationRequestData pessacAnimationRequestData;

    public PessacAnimationRequest(RequestData requestData, PessacAnimationRequestData pessacAnimationRequestData) {
        super(requestData);
        this.pessacAnimationRequestData = pessacAnimationRequestData;
    }

    public PessacAnimationRequest() {
        super();
        this.pessacAnimationRequestData = new PessacAnimationRequestData();
        Map<String, Object> stepState;
        
          stepState = new HashMap<String, Object>(4);
          stepState.put("state", "uncomplete");
          stepState.put("required", true);
          stepState.put("errorMsg", null);
          stepState.put("invalidFields", new ArrayList<String>());
          getStepStates().put("enfant", stepState);
        
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
    public PessacAnimationRequestData getSpecificData() {
        return pessacAnimationRequestData;
    }

    /**
     * Reserved for RequestDAO !
     */
    public void setSpecificData(PessacAnimationRequestData pessacAnimationRequestData) {
        this.pessacAnimationRequestData = pessacAnimationRequestData;
    }

    @Override
    public final String modelToXmlString() {
        PessacAnimationRequestDocument object = this.modelToXml();
        XmlOptions opts = new XmlOptions();
        opts.setSavePrettyPrint();
        opts.setSavePrettyPrintIndent(4);
        opts.setUseDefaultNamespace();
        opts.setCharacterEncoding("UTF-8");
        return object.xmlText(opts);
    }

    @Override
    public final PessacAnimationRequestDocument modelToXml() {
        
        Calendar calendar = Calendar.getInstance();
        LocalTime localTime = new LocalTime();
        Date date = null;
        PessacAnimationRequestDocument pessacAnimationRequestDoc = PessacAnimationRequestDocument.Factory.newInstance();
        PessacAnimationRequestDocument.PessacAnimationRequest pessacAnimationRequest = pessacAnimationRequestDoc.addNewPessacAnimationRequest();
        super.fillCommonXmlInfo(pessacAnimationRequest);
        int i = 0;
        
        if (getAcceptationReglementInterieur() != null)
            pessacAnimationRequest.setAcceptationReglementInterieur(getAcceptationReglementInterieur().booleanValue());
      
        pessacAnimationRequest.setEmailSujet(getEmailSujet());
      
        pessacAnimationRequest.setTelephoneSujet(getTelephoneSujet());
      
        return pessacAnimationRequestDoc;
    }

    @Override
    public final PessacAnimationRequestDocument.PessacAnimationRequest modelToXmlRequest() {
        return modelToXml().getPessacAnimationRequest();
    }

    public static PessacAnimationRequest xmlToModel(PessacAnimationRequestDocument pessacAnimationRequestDoc) {
        PessacAnimationRequestDocument.PessacAnimationRequest pessacAnimationRequestXml = pessacAnimationRequestDoc.getPessacAnimationRequest();
        Calendar calendar = Calendar.getInstance();
        LocalTime localTime = new LocalTime();
        List list = new ArrayList();
        PessacAnimationRequest pessacAnimationRequest = new PessacAnimationRequest();
        pessacAnimationRequest.fillCommonModelInfo(pessacAnimationRequest, pessacAnimationRequestXml);
        
        pessacAnimationRequest.setAcceptationReglementInterieur(Boolean.valueOf(pessacAnimationRequestXml.getAcceptationReglementInterieur()));
      
        pessacAnimationRequest.setEmailSujet(pessacAnimationRequestXml.getEmailSujet());
      
        pessacAnimationRequest.setTelephoneSujet(pessacAnimationRequestXml.getTelephoneSujet());
      
        return pessacAnimationRequest;
    }

    @Override
    public PessacAnimationRequest clone() {
        PessacAnimationRequest clone = new PessacAnimationRequest(getRequestData().clone(), pessacAnimationRequestData.clone());
        Map<String, Object> stepState;
        
          stepState = new HashMap<String, Object>(4);
          stepState.put("state", "uncomplete");
          stepState.put("required", true);
          stepState.put("errorMsg", null);
          stepState.put("invalidFields", new ArrayList<String>());
          clone.getStepStates().put("enfant", stepState);
        
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
        pessacAnimationRequestData.setAcceptationReglementInterieur(acceptationReglementInterieur);
    }

    @IsRulesAcceptance
    public final Boolean getAcceptationReglementInterieur() {
        return pessacAnimationRequestData.getAcceptationReglementInterieur();
    }
  
    public final void setEmailSujet(final String emailSujet) {
        pessacAnimationRequestData.setEmailSujet(emailSujet);
    }

    
    public final String getEmailSujet() {
        return pessacAnimationRequestData.getEmailSujet();
    }
  
    public final void setTelephoneSujet(final String telephoneSujet) {
        pessacAnimationRequestData.setTelephoneSujet(telephoneSujet);
    }

    
    public final String getTelephoneSujet() {
        return pessacAnimationRequestData.getTelephoneSujet();
    }
  
}
