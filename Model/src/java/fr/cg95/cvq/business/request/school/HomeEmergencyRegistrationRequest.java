
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
public class HomeEmergencyRegistrationRequest extends Request implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final Map<String, IConditionChecker> conditions = HomeEmergencyRegistrationRequestData.conditions;

    @AssertValid(message = "")
    private HomeEmergencyRegistrationRequestData homeEmergencyRegistrationRequestData;

    public HomeEmergencyRegistrationRequest(RequestData requestData, HomeEmergencyRegistrationRequestData homeEmergencyRegistrationRequestData) {
        super(requestData);
        this.homeEmergencyRegistrationRequestData = homeEmergencyRegistrationRequestData;
    }

    public HomeEmergencyRegistrationRequest() {
        super();
        this.homeEmergencyRegistrationRequestData = new HomeEmergencyRegistrationRequestData();
        Map<String, Object> stepState;
        
          stepState = new HashMap<String, Object>(4);
          stepState.put("state", "uncomplete");
          stepState.put("required", true);
          stepState.put("errorMsg", null);
          stepState.put("invalidFields", new ArrayList<String>());
          getStepStates().put("subject", stepState);
        
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
    public HomeEmergencyRegistrationRequestData getSpecificData() {
        return homeEmergencyRegistrationRequestData;
    }

    /**
     * Reserved for RequestDAO !
     */
    public void setSpecificData(HomeEmergencyRegistrationRequestData homeEmergencyRegistrationRequestData) {
        this.homeEmergencyRegistrationRequestData = homeEmergencyRegistrationRequestData;
    }

    @Override
    public final String modelToXmlString() {
        HomeEmergencyRegistrationRequestDocument object = this.modelToXml();
        XmlOptions opts = new XmlOptions();
        opts.setSavePrettyPrint();
        opts.setSavePrettyPrintIndent(4);
        opts.setUseDefaultNamespace();
        opts.setCharacterEncoding("UTF-8");
        return object.xmlText(opts);
    }

    @Override
    public final HomeEmergencyRegistrationRequestDocument modelToXml() {
        
        Calendar calendar = Calendar.getInstance();
        LocalTime localTime = new LocalTime();
        Date date = null;
        HomeEmergencyRegistrationRequestDocument homeEmergencyRegistrationRequestDoc = HomeEmergencyRegistrationRequestDocument.Factory.newInstance();
        HomeEmergencyRegistrationRequestDocument.HomeEmergencyRegistrationRequest homeEmergencyRegistrationRequest = homeEmergencyRegistrationRequestDoc.addNewHomeEmergencyRegistrationRequest();
        super.fillCommonXmlInfo(homeEmergencyRegistrationRequest);
        int i = 0;
        
        date = getDateDepart();
        if (date != null) {
            calendar.setTime(date);
            homeEmergencyRegistrationRequest.setDateDepart(calendar);
        }
      
        homeEmergencyRegistrationRequest.setDuree(getDuree());
      
        homeEmergencyRegistrationRequest.setTelephone(getTelephone());
      
        return homeEmergencyRegistrationRequestDoc;
    }

    @Override
    public final HomeEmergencyRegistrationRequestDocument.HomeEmergencyRegistrationRequest modelToXmlRequest() {
        return modelToXml().getHomeEmergencyRegistrationRequest();
    }

    public static HomeEmergencyRegistrationRequest xmlToModel(HomeEmergencyRegistrationRequestDocument homeEmergencyRegistrationRequestDoc) {
        HomeEmergencyRegistrationRequestDocument.HomeEmergencyRegistrationRequest homeEmergencyRegistrationRequestXml = homeEmergencyRegistrationRequestDoc.getHomeEmergencyRegistrationRequest();
        Calendar calendar = Calendar.getInstance();
        LocalTime localTime = new LocalTime();
        List list = new ArrayList();
        HomeEmergencyRegistrationRequest homeEmergencyRegistrationRequest = new HomeEmergencyRegistrationRequest();
        homeEmergencyRegistrationRequest.fillCommonModelInfo(homeEmergencyRegistrationRequest, homeEmergencyRegistrationRequestXml);
        
        calendar = homeEmergencyRegistrationRequestXml.getDateDepart();
        if (calendar != null) {
            homeEmergencyRegistrationRequest.setDateDepart(calendar.getTime());
        }
      
        homeEmergencyRegistrationRequest.setDuree(homeEmergencyRegistrationRequestXml.getDuree());
      
        homeEmergencyRegistrationRequest.setTelephone(homeEmergencyRegistrationRequestXml.getTelephone());
      
        return homeEmergencyRegistrationRequest;
    }

    @Override
    public HomeEmergencyRegistrationRequest clone() {
        HomeEmergencyRegistrationRequest clone = new HomeEmergencyRegistrationRequest(getRequestData().clone(), homeEmergencyRegistrationRequestData.clone());
        Map<String, Object> stepState;
        
          stepState = new HashMap<String, Object>(4);
          stepState.put("state", "uncomplete");
          stepState.put("required", true);
          stepState.put("errorMsg", null);
          stepState.put("invalidFields", new ArrayList<String>());
          clone.getStepStates().put("subject", stepState);
        
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

  
    public final void setDateDepart(final java.util.Date dateDepart) {
        homeEmergencyRegistrationRequestData.setDateDepart(dateDepart);
    }

    
    public final java.util.Date getDateDepart() {
        return homeEmergencyRegistrationRequestData.getDateDepart();
    }
  
    public final void setDuree(final String duree) {
        homeEmergencyRegistrationRequestData.setDuree(duree);
    }

    
    public final String getDuree() {
        return homeEmergencyRegistrationRequestData.getDuree();
    }
  
    public final void setTelephone(final String telephone) {
        homeEmergencyRegistrationRequestData.setTelephone(telephone);
    }

    
    public final String getTelephone() {
        return homeEmergencyRegistrationRequestData.getTelephone();
    }
  
}
