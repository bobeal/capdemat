
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
public class HolidayCampRegistrationRequest extends Request implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final Map<String, IConditionChecker> conditions = HolidayCampRegistrationRequestData.conditions;

    @AssertValid(message = "")
    private HolidayCampRegistrationRequestData holidayCampRegistrationRequestData;

    public HolidayCampRegistrationRequest(RequestData requestData, HolidayCampRegistrationRequestData holidayCampRegistrationRequestData) {
        super(requestData);
        this.holidayCampRegistrationRequestData = holidayCampRegistrationRequestData;
    }

    public HolidayCampRegistrationRequest() {
        super();
        this.holidayCampRegistrationRequestData = new HolidayCampRegistrationRequestData();
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
    public HolidayCampRegistrationRequestData getSpecificData() {
        return holidayCampRegistrationRequestData;
    }

    /**
     * Reserved for RequestDAO !
     */
    public void setSpecificData(HolidayCampRegistrationRequestData holidayCampRegistrationRequestData) {
        this.holidayCampRegistrationRequestData = holidayCampRegistrationRequestData;
    }

    @Override
    public final String modelToXmlString() {
        HolidayCampRegistrationRequestDocument object = this.modelToXml();
        XmlOptions opts = new XmlOptions();
        opts.setSavePrettyPrint();
        opts.setSavePrettyPrintIndent(4);
        opts.setUseDefaultNamespace();
        opts.setCharacterEncoding("UTF-8");
        return object.xmlText(opts);
    }

    @Override
    public final HolidayCampRegistrationRequestDocument modelToXml() {
        
        Calendar calendar = Calendar.getInstance();
        LocalTime localTime = new LocalTime();
        Date date = null;
        HolidayCampRegistrationRequestDocument holidayCampRegistrationRequestDoc = HolidayCampRegistrationRequestDocument.Factory.newInstance();
        HolidayCampRegistrationRequestDocument.HolidayCampRegistrationRequest holidayCampRegistrationRequest = holidayCampRegistrationRequestDoc.addNewHolidayCampRegistrationRequest();
        super.fillCommonXmlInfo(holidayCampRegistrationRequest);
        int i = 0;
        
        if (getAcceptationReglementInterieur() != null)
            holidayCampRegistrationRequest.setAcceptationReglementInterieur(getAcceptationReglementInterieur().booleanValue());
        CentreSejoursType centreSejoursTypeCentreSejours = holidayCampRegistrationRequest.addNewCentreSejours();
        centreSejoursTypeCentreSejours.setIdCentreSejours(getIdCentreSejours());
      
        centreSejoursTypeCentreSejours.setLabelCentreSejours(getLabelCentreSejours());
      
        return holidayCampRegistrationRequestDoc;
    }

    @Override
    public final HolidayCampRegistrationRequestDocument.HolidayCampRegistrationRequest modelToXmlRequest() {
        return modelToXml().getHolidayCampRegistrationRequest();
    }

    public static HolidayCampRegistrationRequest xmlToModel(HolidayCampRegistrationRequestDocument holidayCampRegistrationRequestDoc) {
        HolidayCampRegistrationRequestDocument.HolidayCampRegistrationRequest holidayCampRegistrationRequestXml = holidayCampRegistrationRequestDoc.getHolidayCampRegistrationRequest();
        Calendar calendar = Calendar.getInstance();
        LocalTime localTime = new LocalTime();
        List list = new ArrayList();
        HolidayCampRegistrationRequest holidayCampRegistrationRequest = new HolidayCampRegistrationRequest();
        holidayCampRegistrationRequest.fillCommonModelInfo(holidayCampRegistrationRequest, holidayCampRegistrationRequestXml);
        
        holidayCampRegistrationRequest.setAcceptationReglementInterieur(Boolean.valueOf(holidayCampRegistrationRequestXml.getAcceptationReglementInterieur()));
      
        holidayCampRegistrationRequest.setIdCentreSejours(holidayCampRegistrationRequestXml.getCentreSejours().getIdCentreSejours());
      
        holidayCampRegistrationRequest.setLabelCentreSejours(holidayCampRegistrationRequestXml.getCentreSejours().getLabelCentreSejours());
      
        return holidayCampRegistrationRequest;
    }

    @Override
    public HolidayCampRegistrationRequest clone() {
        HolidayCampRegistrationRequest clone = new HolidayCampRegistrationRequest(getRequestData().clone(), holidayCampRegistrationRequestData.clone());
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
        holidayCampRegistrationRequestData.setAcceptationReglementInterieur(acceptationReglementInterieur);
    }

    @IsRulesAcceptance
    public final Boolean getAcceptationReglementInterieur() {
        return holidayCampRegistrationRequestData.getAcceptationReglementInterieur();
    }
  
    public final void setIdCentreSejours(final String idCentreSejours) {
        holidayCampRegistrationRequestData.setIdCentreSejours(idCentreSejours);
    }

    
    public final String getIdCentreSejours() {
        return holidayCampRegistrationRequestData.getIdCentreSejours();
    }
  
    public final void setLabelCentreSejours(final String labelCentreSejours) {
        holidayCampRegistrationRequestData.setLabelCentreSejours(labelCentreSejours);
    }

    
    public final String getLabelCentreSejours() {
        return holidayCampRegistrationRequestData.getLabelCentreSejours();
    }
  
}
