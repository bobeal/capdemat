
package fr.cg95.cvq.business.request.leisure.culture;

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
import fr.cg95.cvq.xml.request.leisure.culture.*;
import fr.cg95.cvq.service.request.condition.IConditionChecker;

/**
 * Generated class file, do not edit !
 */
public class LibraryRegistrationRequest extends Request implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final Map<String, IConditionChecker> conditions = LibraryRegistrationRequestData.conditions;

    @AssertValid(message = "")
    private LibraryRegistrationRequestData libraryRegistrationRequestData;

    public LibraryRegistrationRequest(RequestData requestData, LibraryRegistrationRequestData libraryRegistrationRequestData) {
        super(requestData);
        this.libraryRegistrationRequestData = libraryRegistrationRequestData;
    }

    public LibraryRegistrationRequest() {
        super();
        this.libraryRegistrationRequestData = new LibraryRegistrationRequestData();
        Map<String, Object> stepState;
        
          stepState = new HashMap<String, Object>(4);
          stepState.put("state", "uncomplete");
          stepState.put("required", true);
          stepState.put("errorMsg", null);
          stepState.put("invalidFields", new ArrayList<String>());
          getStepStates().put("registration", stepState);
        
          stepState = new HashMap<String, Object>(4);
          stepState.put("state", "unavailable");
          stepState.put("required", true);
          stepState.put("errorMsg", null);
          stepState.put("invalidFields", new ArrayList<String>());
          getStepStates().put("rules", stepState);
        
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
    public LibraryRegistrationRequestData getSpecificData() {
        return libraryRegistrationRequestData;
    }

    /**
     * Reserved for RequestDAO !
     */
    public void setSpecificData(LibraryRegistrationRequestData libraryRegistrationRequestData) {
        this.libraryRegistrationRequestData = libraryRegistrationRequestData;
    }

    @Override
    public final String modelToXmlString() {
        LibraryRegistrationRequestDocument object = this.modelToXml();
        XmlOptions opts = new XmlOptions();
        opts.setSavePrettyPrint();
        opts.setSavePrettyPrintIndent(4);
        opts.setUseDefaultNamespace();
        opts.setCharacterEncoding("UTF-8");
        return object.xmlText(opts);
    }

    @Override
    public final LibraryRegistrationRequestDocument modelToXml() {
        
        Calendar calendar = Calendar.getInstance();
        LocalTime localTime = new LocalTime();
        Date date = null;
        LibraryRegistrationRequestDocument libraryRegistrationRequestDoc = LibraryRegistrationRequestDocument.Factory.newInstance();
        LibraryRegistrationRequestDocument.LibraryRegistrationRequest libraryRegistrationRequest = libraryRegistrationRequestDoc.addNewLibraryRegistrationRequest();
        super.fillCommonXmlInfo(libraryRegistrationRequest);
        int i = 0;
        
        libraryRegistrationRequest.setRegistrationNumber(getRegistrationNumber());
      
        if (getParentalAuthorization() != null)
            libraryRegistrationRequest.setParentalAuthorization(getParentalAuthorization().booleanValue());
      
        if (getSubscriptionPrice() != null)
            libraryRegistrationRequest.setSubscriptionPrice(getSubscriptionPrice());
      
        i = 0;
        if (getSubscription() != null) {
            fr.cg95.cvq.xml.common.LocalReferentialDataType[] subscriptionTypeTab = new fr.cg95.cvq.xml.common.LocalReferentialDataType[getSubscription().size()];
            for (LocalReferentialData object : getSubscription()) {
              subscriptionTypeTab[i++] = LocalReferentialData.modelToXml(object);
            }
            libraryRegistrationRequest.setSubscriptionArray(subscriptionTypeTab);
        }
      
        if (getRulesAndRegulationsAcceptance() != null)
            libraryRegistrationRequest.setRulesAndRegulationsAcceptance(getRulesAndRegulationsAcceptance().booleanValue());
      
        return libraryRegistrationRequestDoc;
    }

    @Override
    public final LibraryRegistrationRequestDocument.LibraryRegistrationRequest modelToXmlRequest() {
        return modelToXml().getLibraryRegistrationRequest();
    }

    public static LibraryRegistrationRequest xmlToModel(LibraryRegistrationRequestDocument libraryRegistrationRequestDoc) {
        LibraryRegistrationRequestDocument.LibraryRegistrationRequest libraryRegistrationRequestXml = libraryRegistrationRequestDoc.getLibraryRegistrationRequest();
        Calendar calendar = Calendar.getInstance();
        LocalTime localTime = new LocalTime();
        List list = new ArrayList();
        LibraryRegistrationRequest libraryRegistrationRequest = new LibraryRegistrationRequest();
        libraryRegistrationRequest.fillCommonModelInfo(libraryRegistrationRequest, libraryRegistrationRequestXml);
        
        libraryRegistrationRequest.setRegistrationNumber(libraryRegistrationRequestXml.getRegistrationNumber());
      
        libraryRegistrationRequest.setParentalAuthorization(Boolean.valueOf(libraryRegistrationRequestXml.getParentalAuthorization()));
      
        if (libraryRegistrationRequestXml.getSubscriptionPrice() != null)
            libraryRegistrationRequest.setSubscriptionPrice(libraryRegistrationRequestXml.getSubscriptionPrice());
      
        List<fr.cg95.cvq.business.request.LocalReferentialData> subscriptionList = new ArrayList<fr.cg95.cvq.business.request.LocalReferentialData>(libraryRegistrationRequestXml.sizeOfSubscriptionArray());
        for (LocalReferentialDataType object : libraryRegistrationRequestXml.getSubscriptionArray()) {
            subscriptionList.add(fr.cg95.cvq.business.request.LocalReferentialData.xmlToModel(object));
        }
        libraryRegistrationRequest.setSubscription(subscriptionList);
      
        libraryRegistrationRequest.setRulesAndRegulationsAcceptance(Boolean.valueOf(libraryRegistrationRequestXml.getRulesAndRegulationsAcceptance()));
      
        return libraryRegistrationRequest;
    }

  
    public final void setRegistrationNumber(final String registrationNumber) {
        libraryRegistrationRequestData.setRegistrationNumber(registrationNumber);
    }

    
    public final String getRegistrationNumber() {
        return libraryRegistrationRequestData.getRegistrationNumber();
    }
  
    public final void setParentalAuthorization(final Boolean parentalAuthorization) {
        libraryRegistrationRequestData.setParentalAuthorization(parentalAuthorization);
    }

    @IsRulesAcceptance
    public final Boolean getParentalAuthorization() {
        return libraryRegistrationRequestData.getParentalAuthorization();
    }
  
    public final void setSubscriptionPrice(final java.math.BigDecimal subscriptionPrice) {
        libraryRegistrationRequestData.setSubscriptionPrice(subscriptionPrice);
    }

    
    public final java.math.BigDecimal getSubscriptionPrice() {
        return libraryRegistrationRequestData.getSubscriptionPrice();
    }
  
    public final void setSubscription(final List<fr.cg95.cvq.business.request.LocalReferentialData> subscription) {
        libraryRegistrationRequestData.setSubscription(subscription);
    }

    
    public final List<fr.cg95.cvq.business.request.LocalReferentialData> getSubscription() {
        return libraryRegistrationRequestData.getSubscription();
    }
  
    public final void setRulesAndRegulationsAcceptance(final Boolean rulesAndRegulationsAcceptance) {
        libraryRegistrationRequestData.setRulesAndRegulationsAcceptance(rulesAndRegulationsAcceptance);
    }

    @IsRulesAcceptance
    public final Boolean getRulesAndRegulationsAcceptance() {
        return libraryRegistrationRequestData.getRulesAndRegulationsAcceptance();
    }
  
}
