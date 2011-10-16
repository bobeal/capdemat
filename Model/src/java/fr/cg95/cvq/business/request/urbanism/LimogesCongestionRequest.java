
package fr.cg95.cvq.business.request.urbanism;

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
import fr.cg95.cvq.xml.request.urbanism.*;
import fr.cg95.cvq.service.request.condition.IConditionChecker;

/**
 * Generated class file, do not edit !
 */
public class LimogesCongestionRequest extends Request implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final Map<String, IConditionChecker> conditions = LimogesCongestionRequestData.conditions;

    @AssertValid(message = "")
    private LimogesCongestionRequestData limogesCongestionRequestData;

    public LimogesCongestionRequest(RequestData requestData, LimogesCongestionRequestData limogesCongestionRequestData) {
        super(requestData);
        this.limogesCongestionRequestData = limogesCongestionRequestData;
    }

    public LimogesCongestionRequest() {
        super();
        this.limogesCongestionRequestData = new LimogesCongestionRequestData();
        Map<String, Object> stepState;
        
          stepState = new HashMap<String, Object>(4);
          stepState.put("state", "uncomplete");
          stepState.put("required", true);
          stepState.put("errorMsg", null);
          stepState.put("invalidFields", new ArrayList<String>());
          getStepStates().put("requester", stepState);
        
          stepState = new HashMap<String, Object>(4);
          stepState.put("state", "unavailable");
          stepState.put("required", true);
          stepState.put("errorMsg", null);
          stepState.put("invalidFields", new ArrayList<String>());
          getStepStates().put("work", stepState);
        
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
    public LimogesCongestionRequestData getSpecificData() {
        return limogesCongestionRequestData;
    }

    /**
     * Reserved for RequestDAO !
     */
    public void setSpecificData(LimogesCongestionRequestData limogesCongestionRequestData) {
        this.limogesCongestionRequestData = limogesCongestionRequestData;
    }

    @Override
    public final String modelToXmlString() {
        LimogesCongestionRequestDocument object = this.modelToXml();
        XmlOptions opts = new XmlOptions();
        opts.setSavePrettyPrint();
        opts.setSavePrettyPrintIndent(4);
        opts.setUseDefaultNamespace();
        opts.setCharacterEncoding("UTF-8");
        return object.xmlText(opts);
    }

    @Override
    public final LimogesCongestionRequestDocument modelToXml() {
        
        Calendar calendar = Calendar.getInstance();
        LocalTime localTime = new LocalTime();
        Date date = null;
        LimogesCongestionRequestDocument limogesCongestionRequestDoc = LimogesCongestionRequestDocument.Factory.newInstance();
        LimogesCongestionRequestDocument.LimogesCongestionRequest limogesCongestionRequest = limogesCongestionRequestDoc.addNewLimogesCongestionRequest();
        super.fillCommonXmlInfo(limogesCongestionRequest);
        int i = 0;
        
        limogesCongestionRequest.setAddress(getAddress());
      
        limogesCongestionRequest.setAutorizationNumber(getAutorizationNumber());
      
        if (getCivility() != null)
            limogesCongestionRequest.setCivility(fr.cg95.cvq.xml.common.TitleType.Enum.forString(getCivility().getLegacyLabel()));
      
        limogesCongestionRequest.setCollectivityName(getCollectivityName());
      
        limogesCongestionRequest.setContractorName(getContractorName());
      
        limogesCongestionRequest.setFaxNumber(getFaxNumber());
      
        limogesCongestionRequest.setFirstName(getFirstName());
      
        limogesCongestionRequest.setLastName(getLastName());
      
        limogesCongestionRequest.setLcrCompteDe(getLcrCompteDe());
      
        i = 0;
        if (getLcrDescription() != null) {
            fr.cg95.cvq.xml.request.urbanism.LcrDescriptionType[] lcrDescriptionTypeTab = new fr.cg95.cvq.xml.request.urbanism.LcrDescriptionType[getLcrDescription().size()];
            for (LcrDescription object : getLcrDescription()) {
              lcrDescriptionTypeTab[i++] = object.modelToXml();
            }
            limogesCongestionRequest.setLcrDescriptionArray(lcrDescriptionTypeTab);
        }
      
        if (getLcrDuesAcceptance() != null)
            limogesCongestionRequest.setLcrDuesAcceptance(getLcrDuesAcceptance().booleanValue());
      
        limogesCongestionRequest.setLcrDuration(getLcrDuration());
      
        limogesCongestionRequest.setLcrEndWork(getLcrEndWork());
      
        limogesCongestionRequest.setLcrStartWork(getLcrStartWork());
      
        limogesCongestionRequest.setLcrWorkAddress(getLcrWorkAddress());
      
        limogesCongestionRequest.setLcrWorkNature(getLcrWorkNature());
      
        limogesCongestionRequest.setMail(getMail());
      
        limogesCongestionRequest.setPhoneNumber(getPhoneNumber());
      
        if (getRequesterType() != null)
            limogesCongestionRequest.setRequesterType(fr.cg95.cvq.xml.request.urbanism.LcrRequesterType.Enum.forString(getRequesterType().getLegacyLabel()));
      
        if (getSelectedRequestType() != null)
            limogesCongestionRequest.setSelectedRequestType(fr.cg95.cvq.xml.request.urbanism.LcrRequestType.Enum.forString(getSelectedRequestType().getLegacyLabel()));
      
        return limogesCongestionRequestDoc;
    }

    @Override
    public final LimogesCongestionRequestDocument.LimogesCongestionRequest modelToXmlRequest() {
        return modelToXml().getLimogesCongestionRequest();
    }

    public static LimogesCongestionRequest xmlToModel(LimogesCongestionRequestDocument limogesCongestionRequestDoc) {
        LimogesCongestionRequestDocument.LimogesCongestionRequest limogesCongestionRequestXml = limogesCongestionRequestDoc.getLimogesCongestionRequest();
        Calendar calendar = Calendar.getInstance();
        LocalTime localTime = new LocalTime();
        List list = new ArrayList();
        LimogesCongestionRequest limogesCongestionRequest = new LimogesCongestionRequest();
        limogesCongestionRequest.fillCommonModelInfo(limogesCongestionRequest, limogesCongestionRequestXml);
        
        limogesCongestionRequest.setAddress(limogesCongestionRequestXml.getAddress());
      
        limogesCongestionRequest.setAutorizationNumber(limogesCongestionRequestXml.getAutorizationNumber());
      
        if (limogesCongestionRequestXml.getCivility() != null)
            limogesCongestionRequest.setCivility(fr.cg95.cvq.business.users.TitleType.forString(limogesCongestionRequestXml.getCivility().toString()));
        else
            limogesCongestionRequest.setCivility(fr.cg95.cvq.business.users.TitleType.getDefaultTitleType());
      
        limogesCongestionRequest.setCollectivityName(limogesCongestionRequestXml.getCollectivityName());
      
        limogesCongestionRequest.setContractorName(limogesCongestionRequestXml.getContractorName());
      
        limogesCongestionRequest.setFaxNumber(limogesCongestionRequestXml.getFaxNumber());
      
        limogesCongestionRequest.setFirstName(limogesCongestionRequestXml.getFirstName());
      
        limogesCongestionRequest.setLastName(limogesCongestionRequestXml.getLastName());
      
        limogesCongestionRequest.setLcrCompteDe(limogesCongestionRequestXml.getLcrCompteDe());
      
        List<fr.cg95.cvq.business.request.urbanism.LcrDescription> lcrDescriptionList = new ArrayList<fr.cg95.cvq.business.request.urbanism.LcrDescription>(limogesCongestionRequestXml.sizeOfLcrDescriptionArray());
        for (LcrDescriptionType object : limogesCongestionRequestXml.getLcrDescriptionArray()) {
            lcrDescriptionList.add(fr.cg95.cvq.business.request.urbanism.LcrDescription.xmlToModel(object));
        }
        limogesCongestionRequest.setLcrDescription(lcrDescriptionList);
      
        limogesCongestionRequest.setLcrDuesAcceptance(Boolean.valueOf(limogesCongestionRequestXml.getLcrDuesAcceptance()));
      
        limogesCongestionRequest.setLcrDuration(limogesCongestionRequestXml.getLcrDuration());
      
        limogesCongestionRequest.setLcrEndWork(limogesCongestionRequestXml.getLcrEndWork());
      
        limogesCongestionRequest.setLcrStartWork(limogesCongestionRequestXml.getLcrStartWork());
      
        limogesCongestionRequest.setLcrWorkAddress(limogesCongestionRequestXml.getLcrWorkAddress());
      
        limogesCongestionRequest.setLcrWorkNature(limogesCongestionRequestXml.getLcrWorkNature());
      
        limogesCongestionRequest.setMail(limogesCongestionRequestXml.getMail());
      
        limogesCongestionRequest.setPhoneNumber(limogesCongestionRequestXml.getPhoneNumber());
      
        if (limogesCongestionRequestXml.getRequesterType() != null)
            limogesCongestionRequest.setRequesterType(fr.cg95.cvq.business.request.urbanism.LcrRequesterType.forString(limogesCongestionRequestXml.getRequesterType().toString()));
        else
            limogesCongestionRequest.setRequesterType(fr.cg95.cvq.business.request.urbanism.LcrRequesterType.getDefaultLcrRequesterType());
      
        if (limogesCongestionRequestXml.getSelectedRequestType() != null)
            limogesCongestionRequest.setSelectedRequestType(fr.cg95.cvq.business.request.urbanism.LcrRequestType.forString(limogesCongestionRequestXml.getSelectedRequestType().toString()));
        else
            limogesCongestionRequest.setSelectedRequestType(fr.cg95.cvq.business.request.urbanism.LcrRequestType.getDefaultLcrRequestType());
      
        return limogesCongestionRequest;
    }

    @Override
    public LimogesCongestionRequest clone() {
        LimogesCongestionRequest clone = new LimogesCongestionRequest(getRequestData().clone(), limogesCongestionRequestData.clone());
        Map<String, Object> stepState;
        
          stepState = new HashMap<String, Object>(4);
          stepState.put("state", "uncomplete");
          stepState.put("required", true);
          stepState.put("errorMsg", null);
          stepState.put("invalidFields", new ArrayList<String>());
          clone.getStepStates().put("requester", stepState);
        
          stepState = new HashMap<String, Object>(4);
          stepState.put("state", "unavailable");
          stepState.put("required", true);
          stepState.put("errorMsg", null);
          stepState.put("invalidFields", new ArrayList<String>());
          clone.getStepStates().put("work", stepState);
        
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
          clone.getStepStates().put("rules", stepState);
        
          stepState = new HashMap<String, Object>(4);
          stepState.put("state", "unavailable");
          stepState.put("required", true);
          stepState.put("errorMsg", null);
          stepState.put("invalidFields", new ArrayList<String>());
          clone.getStepStates().put("validation", stepState);
        
        return clone;
    }

  
    public final void setAddress(final String address) {
        limogesCongestionRequestData.setAddress(address);
    }

    
    public final String getAddress() {
        return limogesCongestionRequestData.getAddress();
    }
  
    public final void setAutorizationNumber(final String autorizationNumber) {
        limogesCongestionRequestData.setAutorizationNumber(autorizationNumber);
    }

    
    public final String getAutorizationNumber() {
        return limogesCongestionRequestData.getAutorizationNumber();
    }
  
    public final void setCivility(final fr.cg95.cvq.business.users.TitleType civility) {
        limogesCongestionRequestData.setCivility(civility);
    }

    
    public final fr.cg95.cvq.business.users.TitleType getCivility() {
        return limogesCongestionRequestData.getCivility();
    }
  
    public final void setCollectivityName(final String collectivityName) {
        limogesCongestionRequestData.setCollectivityName(collectivityName);
    }

    
    public final String getCollectivityName() {
        return limogesCongestionRequestData.getCollectivityName();
    }
  
    public final void setContractorName(final String contractorName) {
        limogesCongestionRequestData.setContractorName(contractorName);
    }

    
    public final String getContractorName() {
        return limogesCongestionRequestData.getContractorName();
    }
  
    public final void setFaxNumber(final String faxNumber) {
        limogesCongestionRequestData.setFaxNumber(faxNumber);
    }

    
    public final String getFaxNumber() {
        return limogesCongestionRequestData.getFaxNumber();
    }
  
    public final void setFirstName(final String firstName) {
        limogesCongestionRequestData.setFirstName(firstName);
    }

    
    public final String getFirstName() {
        return limogesCongestionRequestData.getFirstName();
    }
  
    public final void setLastName(final String lastName) {
        limogesCongestionRequestData.setLastName(lastName);
    }

    
    public final String getLastName() {
        return limogesCongestionRequestData.getLastName();
    }
  
    public final void setLcrCompteDe(final String lcrCompteDe) {
        limogesCongestionRequestData.setLcrCompteDe(lcrCompteDe);
    }

    
    public final String getLcrCompteDe() {
        return limogesCongestionRequestData.getLcrCompteDe();
    }
  
    public final void setLcrDescription(final List<fr.cg95.cvq.business.request.urbanism.LcrDescription> lcrDescription) {
        limogesCongestionRequestData.setLcrDescription(lcrDescription);
    }

    
    public final List<fr.cg95.cvq.business.request.urbanism.LcrDescription> getLcrDescription() {
        return limogesCongestionRequestData.getLcrDescription();
    }
  
    public final void setLcrDuesAcceptance(final Boolean lcrDuesAcceptance) {
        limogesCongestionRequestData.setLcrDuesAcceptance(lcrDuesAcceptance);
    }

    @IsRulesAcceptance
    public final Boolean getLcrDuesAcceptance() {
        return limogesCongestionRequestData.getLcrDuesAcceptance();
    }
  
    public final void setLcrDuration(final String lcrDuration) {
        limogesCongestionRequestData.setLcrDuration(lcrDuration);
    }

    
    public final String getLcrDuration() {
        return limogesCongestionRequestData.getLcrDuration();
    }
  
    public final void setLcrEndWork(final String lcrEndWork) {
        limogesCongestionRequestData.setLcrEndWork(lcrEndWork);
    }

    
    public final String getLcrEndWork() {
        return limogesCongestionRequestData.getLcrEndWork();
    }
  
    public final void setLcrStartWork(final String lcrStartWork) {
        limogesCongestionRequestData.setLcrStartWork(lcrStartWork);
    }

    
    public final String getLcrStartWork() {
        return limogesCongestionRequestData.getLcrStartWork();
    }
  
    public final void setLcrWorkAddress(final String lcrWorkAddress) {
        limogesCongestionRequestData.setLcrWorkAddress(lcrWorkAddress);
    }

    
    public final String getLcrWorkAddress() {
        return limogesCongestionRequestData.getLcrWorkAddress();
    }
  
    public final void setLcrWorkNature(final String lcrWorkNature) {
        limogesCongestionRequestData.setLcrWorkNature(lcrWorkNature);
    }

    
    public final String getLcrWorkNature() {
        return limogesCongestionRequestData.getLcrWorkNature();
    }
  
    public final void setMail(final String mail) {
        limogesCongestionRequestData.setMail(mail);
    }

    
    public final String getMail() {
        return limogesCongestionRequestData.getMail();
    }
  
    public final void setPhoneNumber(final String phoneNumber) {
        limogesCongestionRequestData.setPhoneNumber(phoneNumber);
    }

    
    public final String getPhoneNumber() {
        return limogesCongestionRequestData.getPhoneNumber();
    }
  
    public final void setRequesterType(final fr.cg95.cvq.business.request.urbanism.LcrRequesterType requesterType) {
        limogesCongestionRequestData.setRequesterType(requesterType);
    }

    
    public final fr.cg95.cvq.business.request.urbanism.LcrRequesterType getRequesterType() {
        return limogesCongestionRequestData.getRequesterType();
    }
  
    public final void setSelectedRequestType(final fr.cg95.cvq.business.request.urbanism.LcrRequestType selectedRequestType) {
        limogesCongestionRequestData.setSelectedRequestType(selectedRequestType);
    }

    
    public final fr.cg95.cvq.business.request.urbanism.LcrRequestType getSelectedRequestType() {
        return limogesCongestionRequestData.getSelectedRequestType();
    }
  
}
