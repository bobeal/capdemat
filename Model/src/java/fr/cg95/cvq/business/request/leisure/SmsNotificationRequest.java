
package fr.cg95.cvq.business.request.leisure;

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
import fr.cg95.cvq.xml.request.leisure.*;
import fr.cg95.cvq.service.request.condition.IConditionChecker;

/**
 * Generated class file, do not edit !
 */
public class SmsNotificationRequest extends Request implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final Map<String, IConditionChecker> conditions = SmsNotificationRequestData.conditions;

    @AssertValid(message = "")
    private SmsNotificationRequestData smsNotificationRequestData;

    public SmsNotificationRequest(RequestData requestData, SmsNotificationRequestData smsNotificationRequestData) {
        super(requestData);
        this.smsNotificationRequestData = smsNotificationRequestData;
    }

    public SmsNotificationRequest() {
        super();
        this.smsNotificationRequestData = new SmsNotificationRequestData();
        Map<String, Object> stepState;
        
          stepState = new HashMap<String, Object>(4);
          stepState.put("state", "uncomplete");
          stepState.put("required", true);
          stepState.put("errorMsg", null);
          stepState.put("invalidFields", new ArrayList<String>());
          getStepStates().put("subscription", stepState);
        
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
        
          stepState = new HashMap<String, Object>(4);
          stepState.put("state", "unavailable");
          stepState.put("required", false);
          stepState.put("errorMsg", null);
          stepState.put("invalidFields", new ArrayList<String>());
          getStepStates().put("administration", stepState);
        
    }

    /**
     * Reserved for RequestDAO !
     */
    @Override
    public SmsNotificationRequestData getSpecificData() {
        return smsNotificationRequestData;
    }

    /**
     * Reserved for RequestDAO !
     */
    public void setSpecificData(SmsNotificationRequestData smsNotificationRequestData) {
        this.smsNotificationRequestData = smsNotificationRequestData;
    }

    @Override
    public final String modelToXmlString() {
        SmsNotificationRequestDocument object = this.modelToXml();
        XmlOptions opts = new XmlOptions();
        opts.setSavePrettyPrint();
        opts.setSavePrettyPrintIndent(4);
        opts.setUseDefaultNamespace();
        opts.setCharacterEncoding("UTF-8");
        return object.xmlText(opts);
    }

    @Override
    public final SmsNotificationRequestDocument modelToXml() {
        
        Calendar calendar = Calendar.getInstance();
        LocalTime localTime = new LocalTime();
        Date date = null;
        SmsNotificationRequestDocument smsNotificationRequestDoc = SmsNotificationRequestDocument.Factory.newInstance();
        SmsNotificationRequestDocument.SmsNotificationRequest smsNotificationRequest = smsNotificationRequestDoc.addNewSmsNotificationRequest();
        super.fillCommonXmlInfo(smsNotificationRequest);
        int i = 0;
        
        smsNotificationRequest.setCleverSmsContactId(getCleverSmsContactId());
      
        smsNotificationRequest.setMobilePhone(getMobilePhone());
      
        i = 0;
        if (getInterests() != null) {
            fr.cg95.cvq.xml.common.LocalReferentialDataType[] interestsTypeTab = new fr.cg95.cvq.xml.common.LocalReferentialDataType[getInterests().size()];
            for (LocalReferentialData object : getInterests()) {
              interestsTypeTab[i++] = LocalReferentialData.modelToXml(object);
            }
            smsNotificationRequest.setInterestsArray(interestsTypeTab);
        }
      
        if (getSubscription() != null)
            smsNotificationRequest.setSubscription(getSubscription().booleanValue());
      
        return smsNotificationRequestDoc;
    }

    @Override
    public final SmsNotificationRequestDocument.SmsNotificationRequest modelToXmlRequest() {
        return modelToXml().getSmsNotificationRequest();
    }

    public static SmsNotificationRequest xmlToModel(SmsNotificationRequestDocument smsNotificationRequestDoc) {
        SmsNotificationRequestDocument.SmsNotificationRequest smsNotificationRequestXml = smsNotificationRequestDoc.getSmsNotificationRequest();
        Calendar calendar = Calendar.getInstance();
        LocalTime localTime = new LocalTime();
        List list = new ArrayList();
        SmsNotificationRequest smsNotificationRequest = new SmsNotificationRequest();
        smsNotificationRequest.fillCommonModelInfo(smsNotificationRequest, smsNotificationRequestXml);
        
        smsNotificationRequest.setCleverSmsContactId(smsNotificationRequestXml.getCleverSmsContactId());
      
        smsNotificationRequest.setMobilePhone(smsNotificationRequestXml.getMobilePhone());
      
        List<fr.cg95.cvq.business.request.LocalReferentialData> interestsList = new ArrayList<fr.cg95.cvq.business.request.LocalReferentialData>(smsNotificationRequestXml.sizeOfInterestsArray());
        for (LocalReferentialDataType object : smsNotificationRequestXml.getInterestsArray()) {
            interestsList.add(fr.cg95.cvq.business.request.LocalReferentialData.xmlToModel(object));
        }
        smsNotificationRequest.setInterests(interestsList);
      
        smsNotificationRequest.setSubscription(Boolean.valueOf(smsNotificationRequestXml.getSubscription()));
      
        return smsNotificationRequest;
    }

    @Override
    public SmsNotificationRequest clone() {
        SmsNotificationRequest clone = new SmsNotificationRequest(getRequestData().clone(), smsNotificationRequestData.clone());
        Map<String, Object> stepState;
        
          stepState = new HashMap<String, Object>(4);
          stepState.put("state", "uncomplete");
          stepState.put("required", true);
          stepState.put("errorMsg", null);
          stepState.put("invalidFields", new ArrayList<String>());
          clone.getStepStates().put("subscription", stepState);
        
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
        
          stepState = new HashMap<String, Object>(4);
          stepState.put("state", "unavailable");
          stepState.put("required", false);
          stepState.put("errorMsg", null);
          stepState.put("invalidFields", new ArrayList<String>());
          clone.getStepStates().put("administration", stepState);
        
        return clone;
    }

  
    public final void setCleverSmsContactId(final String cleverSmsContactId) {
        smsNotificationRequestData.setCleverSmsContactId(cleverSmsContactId);
    }

    
    public final String getCleverSmsContactId() {
        return smsNotificationRequestData.getCleverSmsContactId();
    }
  
    public final void setMobilePhone(final String mobilePhone) {
        smsNotificationRequestData.setMobilePhone(mobilePhone);
    }

    
    public final String getMobilePhone() {
        return smsNotificationRequestData.getMobilePhone();
    }
  
    public final void setInterests(final List<fr.cg95.cvq.business.request.LocalReferentialData> interests) {
        smsNotificationRequestData.setInterests(interests);
    }

    
    public final List<fr.cg95.cvq.business.request.LocalReferentialData> getInterests() {
        return smsNotificationRequestData.getInterests();
    }
  
    public final void setSubscription(final Boolean subscription) {
        smsNotificationRequestData.setSubscription(subscription);
    }

    
    public final Boolean getSubscription() {
        return smsNotificationRequestData.getSubscription();
    }
  
}
