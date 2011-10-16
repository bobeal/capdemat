
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
public class LimogesTemporaryStopWorkRequest extends Request implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final Map<String, IConditionChecker> conditions = LimogesTemporaryStopWorkRequestData.conditions;

    @AssertValid(message = "")
    private LimogesTemporaryStopWorkRequestData limogesTemporaryStopWorkRequestData;

    public LimogesTemporaryStopWorkRequest(RequestData requestData, LimogesTemporaryStopWorkRequestData limogesTemporaryStopWorkRequestData) {
        super(requestData);
        this.limogesTemporaryStopWorkRequestData = limogesTemporaryStopWorkRequestData;
    }

    public LimogesTemporaryStopWorkRequest() {
        super();
        this.limogesTemporaryStopWorkRequestData = new LimogesTemporaryStopWorkRequestData();
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
          stepState.put("required", true);
          stepState.put("errorMsg", null);
          stepState.put("invalidFields", new ArrayList<String>());
          getStepStates().put("informations", stepState);
        
          stepState = new HashMap<String, Object>(4);
          stepState.put("state", "unavailable");
          stepState.put("required", true);
          stepState.put("errorMsg", null);
          stepState.put("invalidFields", new ArrayList<String>());
          getStepStates().put("rules", stepState);
        
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
    public LimogesTemporaryStopWorkRequestData getSpecificData() {
        return limogesTemporaryStopWorkRequestData;
    }

    /**
     * Reserved for RequestDAO !
     */
    public void setSpecificData(LimogesTemporaryStopWorkRequestData limogesTemporaryStopWorkRequestData) {
        this.limogesTemporaryStopWorkRequestData = limogesTemporaryStopWorkRequestData;
    }

    @Override
    public final String modelToXmlString() {
        LimogesTemporaryStopWorkRequestDocument object = this.modelToXml();
        XmlOptions opts = new XmlOptions();
        opts.setSavePrettyPrint();
        opts.setSavePrettyPrintIndent(4);
        opts.setUseDefaultNamespace();
        opts.setCharacterEncoding("UTF-8");
        return object.xmlText(opts);
    }

    @Override
    public final LimogesTemporaryStopWorkRequestDocument modelToXml() {
        
        Calendar calendar = Calendar.getInstance();
        LocalTime localTime = new LocalTime();
        Date date = null;
        LimogesTemporaryStopWorkRequestDocument limogesTemporaryStopWorkRequestDoc = LimogesTemporaryStopWorkRequestDocument.Factory.newInstance();
        LimogesTemporaryStopWorkRequestDocument.LimogesTemporaryStopWorkRequest limogesTemporaryStopWorkRequest = limogesTemporaryStopWorkRequestDoc.addNewLimogesTemporaryStopWorkRequest();
        super.fillCommonXmlInfo(limogesTemporaryStopWorkRequest);
        int i = 0;
        
        limogesTemporaryStopWorkRequest.setAddress(getAddress());
      
        if (getAlternateTraffic() != null)
            limogesTemporaryStopWorkRequest.setAlternateTraffic(fr.cg95.cvq.xml.request.urbanism.LtswrAlternateTraffic.Enum.forString(getAlternateTraffic().getLegacyLabel()));
      
        limogesTemporaryStopWorkRequest.setAlternateTrafficDirection(getAlternateTrafficDirection());
      
        limogesTemporaryStopWorkRequest.setAlternateTrafficMeter(getAlternateTrafficMeter());
      
        limogesTemporaryStopWorkRequest.setAutorizationNumber(getAutorizationNumber());
      
        if (getCivility() != null)
            limogesTemporaryStopWorkRequest.setCivility(fr.cg95.cvq.xml.common.TitleType.Enum.forString(getCivility().getLegacyLabel()));
      
        limogesTemporaryStopWorkRequest.setCollectivityName(getCollectivityName());
      
        limogesTemporaryStopWorkRequest.setComment(getComment());
      
        limogesTemporaryStopWorkRequest.setContractorName(getContractorName());
      
        limogesTemporaryStopWorkRequest.setDeviation(getDeviation());
      
        if (getDrivingBan() != null)
            limogesTemporaryStopWorkRequest.setDrivingBan(fr.cg95.cvq.xml.request.urbanism.LtswrDrivingBan.Enum.forString(getDrivingBan().getLegacyLabel()));
      
        limogesTemporaryStopWorkRequest.setDrivingBanBetween(getDrivingBanBetween());
      
        limogesTemporaryStopWorkRequest.setDrivingBanDirection(getDrivingBanDirection());
      
        limogesTemporaryStopWorkRequest.setFaxNumber(getFaxNumber());
      
        limogesTemporaryStopWorkRequest.setFirstName(getFirstName());
      
        limogesTemporaryStopWorkRequest.setLastName(getLastName());
      
        if (getLtswrRule() != null)
            limogesTemporaryStopWorkRequest.setLtswrRule(getLtswrRule().booleanValue());
      
        limogesTemporaryStopWorkRequest.setMail(getMail());
      
        if (getNoParking() != null)
            limogesTemporaryStopWorkRequest.setNoParking(fr.cg95.cvq.xml.request.urbanism.LtswrNoParking.Enum.forString(getNoParking().getLegacyLabel()));
      
        limogesTemporaryStopWorkRequest.setNoParkingStraightMeter(getNoParkingStraightMeter());
      
        limogesTemporaryStopWorkRequest.setNoParkingStraightNumber(getNoParkingStraightNumber());
      
        limogesTemporaryStopWorkRequest.setOnBehalf(getOnBehalf());
      
        limogesTemporaryStopWorkRequest.setPhoneNumber(getPhoneNumber());
      
        if (getRequesterType() != null)
            limogesTemporaryStopWorkRequest.setRequesterType(fr.cg95.cvq.xml.request.urbanism.LtswrRequesterType.Enum.forString(getRequesterType().getLegacyLabel()));
      
        if (getSelectedRequestType() != null)
            limogesTemporaryStopWorkRequest.setSelectedRequestType(fr.cg95.cvq.xml.request.urbanism.LtswrRequestType.Enum.forString(getSelectedRequestType().getLegacyLabel()));
      
        limogesTemporaryStopWorkRequest.setWorkAddress(getWorkAddress());
      
        date = getWorkDate();
        if (date != null) {
            calendar.setTime(date);
            limogesTemporaryStopWorkRequest.setWorkDate(calendar);
        }
      
        limogesTemporaryStopWorkRequest.setWorkDuration(getWorkDuration());
      
        limogesTemporaryStopWorkRequest.setWorkTime(getWorkTime());
      
        limogesTemporaryStopWorkRequest.setWorkType(getWorkType());
      
        return limogesTemporaryStopWorkRequestDoc;
    }

    @Override
    public final LimogesTemporaryStopWorkRequestDocument.LimogesTemporaryStopWorkRequest modelToXmlRequest() {
        return modelToXml().getLimogesTemporaryStopWorkRequest();
    }

    public static LimogesTemporaryStopWorkRequest xmlToModel(LimogesTemporaryStopWorkRequestDocument limogesTemporaryStopWorkRequestDoc) {
        LimogesTemporaryStopWorkRequestDocument.LimogesTemporaryStopWorkRequest limogesTemporaryStopWorkRequestXml = limogesTemporaryStopWorkRequestDoc.getLimogesTemporaryStopWorkRequest();
        Calendar calendar = Calendar.getInstance();
        LocalTime localTime = new LocalTime();
        List list = new ArrayList();
        LimogesTemporaryStopWorkRequest limogesTemporaryStopWorkRequest = new LimogesTemporaryStopWorkRequest();
        limogesTemporaryStopWorkRequest.fillCommonModelInfo(limogesTemporaryStopWorkRequest, limogesTemporaryStopWorkRequestXml);
        
        limogesTemporaryStopWorkRequest.setAddress(limogesTemporaryStopWorkRequestXml.getAddress());
      
        if (limogesTemporaryStopWorkRequestXml.getAlternateTraffic() != null)
            limogesTemporaryStopWorkRequest.setAlternateTraffic(fr.cg95.cvq.business.request.urbanism.LtswrAlternateTraffic.forString(limogesTemporaryStopWorkRequestXml.getAlternateTraffic().toString()));
        else
            limogesTemporaryStopWorkRequest.setAlternateTraffic(fr.cg95.cvq.business.request.urbanism.LtswrAlternateTraffic.getDefaultLtswrAlternateTraffic());
      
        limogesTemporaryStopWorkRequest.setAlternateTrafficDirection(limogesTemporaryStopWorkRequestXml.getAlternateTrafficDirection());
      
        limogesTemporaryStopWorkRequest.setAlternateTrafficMeter(limogesTemporaryStopWorkRequestXml.getAlternateTrafficMeter());
      
        limogesTemporaryStopWorkRequest.setAutorizationNumber(limogesTemporaryStopWorkRequestXml.getAutorizationNumber());
      
        if (limogesTemporaryStopWorkRequestXml.getCivility() != null)
            limogesTemporaryStopWorkRequest.setCivility(fr.cg95.cvq.business.users.TitleType.forString(limogesTemporaryStopWorkRequestXml.getCivility().toString()));
        else
            limogesTemporaryStopWorkRequest.setCivility(fr.cg95.cvq.business.users.TitleType.getDefaultTitleType());
      
        limogesTemporaryStopWorkRequest.setCollectivityName(limogesTemporaryStopWorkRequestXml.getCollectivityName());
      
        limogesTemporaryStopWorkRequest.setComment(limogesTemporaryStopWorkRequestXml.getComment());
      
        limogesTemporaryStopWorkRequest.setContractorName(limogesTemporaryStopWorkRequestXml.getContractorName());
      
        limogesTemporaryStopWorkRequest.setDeviation(limogesTemporaryStopWorkRequestXml.getDeviation());
      
        if (limogesTemporaryStopWorkRequestXml.getDrivingBan() != null)
            limogesTemporaryStopWorkRequest.setDrivingBan(fr.cg95.cvq.business.request.urbanism.LtswrDrivingBan.forString(limogesTemporaryStopWorkRequestXml.getDrivingBan().toString()));
        else
            limogesTemporaryStopWorkRequest.setDrivingBan(fr.cg95.cvq.business.request.urbanism.LtswrDrivingBan.getDefaultLtswrDrivingBan());
      
        limogesTemporaryStopWorkRequest.setDrivingBanBetween(limogesTemporaryStopWorkRequestXml.getDrivingBanBetween());
      
        limogesTemporaryStopWorkRequest.setDrivingBanDirection(limogesTemporaryStopWorkRequestXml.getDrivingBanDirection());
      
        limogesTemporaryStopWorkRequest.setFaxNumber(limogesTemporaryStopWorkRequestXml.getFaxNumber());
      
        limogesTemporaryStopWorkRequest.setFirstName(limogesTemporaryStopWorkRequestXml.getFirstName());
      
        limogesTemporaryStopWorkRequest.setLastName(limogesTemporaryStopWorkRequestXml.getLastName());
      
        limogesTemporaryStopWorkRequest.setLtswrRule(Boolean.valueOf(limogesTemporaryStopWorkRequestXml.getLtswrRule()));
      
        limogesTemporaryStopWorkRequest.setMail(limogesTemporaryStopWorkRequestXml.getMail());
      
        if (limogesTemporaryStopWorkRequestXml.getNoParking() != null)
            limogesTemporaryStopWorkRequest.setNoParking(fr.cg95.cvq.business.request.urbanism.LtswrNoParking.forString(limogesTemporaryStopWorkRequestXml.getNoParking().toString()));
        else
            limogesTemporaryStopWorkRequest.setNoParking(fr.cg95.cvq.business.request.urbanism.LtswrNoParking.getDefaultLtswrNoParking());
      
        limogesTemporaryStopWorkRequest.setNoParkingStraightMeter(limogesTemporaryStopWorkRequestXml.getNoParkingStraightMeter());
      
        limogesTemporaryStopWorkRequest.setNoParkingStraightNumber(limogesTemporaryStopWorkRequestXml.getNoParkingStraightNumber());
      
        limogesTemporaryStopWorkRequest.setOnBehalf(limogesTemporaryStopWorkRequestXml.getOnBehalf());
      
        limogesTemporaryStopWorkRequest.setPhoneNumber(limogesTemporaryStopWorkRequestXml.getPhoneNumber());
      
        if (limogesTemporaryStopWorkRequestXml.getRequesterType() != null)
            limogesTemporaryStopWorkRequest.setRequesterType(fr.cg95.cvq.business.request.urbanism.LtswrRequesterType.forString(limogesTemporaryStopWorkRequestXml.getRequesterType().toString()));
        else
            limogesTemporaryStopWorkRequest.setRequesterType(fr.cg95.cvq.business.request.urbanism.LtswrRequesterType.getDefaultLtswrRequesterType());
      
        if (limogesTemporaryStopWorkRequestXml.getSelectedRequestType() != null)
            limogesTemporaryStopWorkRequest.setSelectedRequestType(fr.cg95.cvq.business.request.urbanism.LtswrRequestType.forString(limogesTemporaryStopWorkRequestXml.getSelectedRequestType().toString()));
        else
            limogesTemporaryStopWorkRequest.setSelectedRequestType(fr.cg95.cvq.business.request.urbanism.LtswrRequestType.getDefaultLtswrRequestType());
      
        limogesTemporaryStopWorkRequest.setWorkAddress(limogesTemporaryStopWorkRequestXml.getWorkAddress());
      
        calendar = limogesTemporaryStopWorkRequestXml.getWorkDate();
        if (calendar != null) {
            limogesTemporaryStopWorkRequest.setWorkDate(calendar.getTime());
        }
      
        limogesTemporaryStopWorkRequest.setWorkDuration(limogesTemporaryStopWorkRequestXml.getWorkDuration());
      
        limogesTemporaryStopWorkRequest.setWorkTime(limogesTemporaryStopWorkRequestXml.getWorkTime());
      
        limogesTemporaryStopWorkRequest.setWorkType(limogesTemporaryStopWorkRequestXml.getWorkType());
      
        return limogesTemporaryStopWorkRequest;
    }

    @Override
    public LimogesTemporaryStopWorkRequest clone() {
        LimogesTemporaryStopWorkRequest clone = new LimogesTemporaryStopWorkRequest(getRequestData().clone(), limogesTemporaryStopWorkRequestData.clone());
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
          stepState.put("required", true);
          stepState.put("errorMsg", null);
          stepState.put("invalidFields", new ArrayList<String>());
          clone.getStepStates().put("informations", stepState);
        
          stepState = new HashMap<String, Object>(4);
          stepState.put("state", "unavailable");
          stepState.put("required", true);
          stepState.put("errorMsg", null);
          stepState.put("invalidFields", new ArrayList<String>());
          clone.getStepStates().put("rules", stepState);
        
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

  
    public final void setAddress(final String address) {
        limogesTemporaryStopWorkRequestData.setAddress(address);
    }

    
    public final String getAddress() {
        return limogesTemporaryStopWorkRequestData.getAddress();
    }
  
    public final void setAlternateTraffic(final fr.cg95.cvq.business.request.urbanism.LtswrAlternateTraffic alternateTraffic) {
        limogesTemporaryStopWorkRequestData.setAlternateTraffic(alternateTraffic);
    }

    
    public final fr.cg95.cvq.business.request.urbanism.LtswrAlternateTraffic getAlternateTraffic() {
        return limogesTemporaryStopWorkRequestData.getAlternateTraffic();
    }
  
    public final void setAlternateTrafficDirection(final String alternateTrafficDirection) {
        limogesTemporaryStopWorkRequestData.setAlternateTrafficDirection(alternateTrafficDirection);
    }

    
    public final String getAlternateTrafficDirection() {
        return limogesTemporaryStopWorkRequestData.getAlternateTrafficDirection();
    }
  
    public final void setAlternateTrafficMeter(final String alternateTrafficMeter) {
        limogesTemporaryStopWorkRequestData.setAlternateTrafficMeter(alternateTrafficMeter);
    }

    
    public final String getAlternateTrafficMeter() {
        return limogesTemporaryStopWorkRequestData.getAlternateTrafficMeter();
    }
  
    public final void setAutorizationNumber(final String autorizationNumber) {
        limogesTemporaryStopWorkRequestData.setAutorizationNumber(autorizationNumber);
    }

    
    public final String getAutorizationNumber() {
        return limogesTemporaryStopWorkRequestData.getAutorizationNumber();
    }
  
    public final void setCivility(final fr.cg95.cvq.business.users.TitleType civility) {
        limogesTemporaryStopWorkRequestData.setCivility(civility);
    }

    
    public final fr.cg95.cvq.business.users.TitleType getCivility() {
        return limogesTemporaryStopWorkRequestData.getCivility();
    }
  
    public final void setCollectivityName(final String collectivityName) {
        limogesTemporaryStopWorkRequestData.setCollectivityName(collectivityName);
    }

    
    public final String getCollectivityName() {
        return limogesTemporaryStopWorkRequestData.getCollectivityName();
    }
  
    public final void setComment(final String comment) {
        limogesTemporaryStopWorkRequestData.setComment(comment);
    }

    
    public final String getComment() {
        return limogesTemporaryStopWorkRequestData.getComment();
    }
  
    public final void setContractorName(final String contractorName) {
        limogesTemporaryStopWorkRequestData.setContractorName(contractorName);
    }

    
    public final String getContractorName() {
        return limogesTemporaryStopWorkRequestData.getContractorName();
    }
  
    public final void setDeviation(final String deviation) {
        limogesTemporaryStopWorkRequestData.setDeviation(deviation);
    }

    
    public final String getDeviation() {
        return limogesTemporaryStopWorkRequestData.getDeviation();
    }
  
    public final void setDrivingBan(final fr.cg95.cvq.business.request.urbanism.LtswrDrivingBan drivingBan) {
        limogesTemporaryStopWorkRequestData.setDrivingBan(drivingBan);
    }

    
    public final fr.cg95.cvq.business.request.urbanism.LtswrDrivingBan getDrivingBan() {
        return limogesTemporaryStopWorkRequestData.getDrivingBan();
    }
  
    public final void setDrivingBanBetween(final String drivingBanBetween) {
        limogesTemporaryStopWorkRequestData.setDrivingBanBetween(drivingBanBetween);
    }

    
    public final String getDrivingBanBetween() {
        return limogesTemporaryStopWorkRequestData.getDrivingBanBetween();
    }
  
    public final void setDrivingBanDirection(final String drivingBanDirection) {
        limogesTemporaryStopWorkRequestData.setDrivingBanDirection(drivingBanDirection);
    }

    
    public final String getDrivingBanDirection() {
        return limogesTemporaryStopWorkRequestData.getDrivingBanDirection();
    }
  
    public final void setFaxNumber(final String faxNumber) {
        limogesTemporaryStopWorkRequestData.setFaxNumber(faxNumber);
    }

    
    public final String getFaxNumber() {
        return limogesTemporaryStopWorkRequestData.getFaxNumber();
    }
  
    public final void setFirstName(final String firstName) {
        limogesTemporaryStopWorkRequestData.setFirstName(firstName);
    }

    
    public final String getFirstName() {
        return limogesTemporaryStopWorkRequestData.getFirstName();
    }
  
    public final void setLastName(final String lastName) {
        limogesTemporaryStopWorkRequestData.setLastName(lastName);
    }

    
    public final String getLastName() {
        return limogesTemporaryStopWorkRequestData.getLastName();
    }
  
    public final void setLtswrRule(final Boolean ltswrRule) {
        limogesTemporaryStopWorkRequestData.setLtswrRule(ltswrRule);
    }

    @IsRulesAcceptance
    public final Boolean getLtswrRule() {
        return limogesTemporaryStopWorkRequestData.getLtswrRule();
    }
  
    public final void setMail(final String mail) {
        limogesTemporaryStopWorkRequestData.setMail(mail);
    }

    
    public final String getMail() {
        return limogesTemporaryStopWorkRequestData.getMail();
    }
  
    public final void setNoParking(final fr.cg95.cvq.business.request.urbanism.LtswrNoParking noParking) {
        limogesTemporaryStopWorkRequestData.setNoParking(noParking);
    }

    
    public final fr.cg95.cvq.business.request.urbanism.LtswrNoParking getNoParking() {
        return limogesTemporaryStopWorkRequestData.getNoParking();
    }
  
    public final void setNoParkingStraightMeter(final String noParkingStraightMeter) {
        limogesTemporaryStopWorkRequestData.setNoParkingStraightMeter(noParkingStraightMeter);
    }

    
    public final String getNoParkingStraightMeter() {
        return limogesTemporaryStopWorkRequestData.getNoParkingStraightMeter();
    }
  
    public final void setNoParkingStraightNumber(final String noParkingStraightNumber) {
        limogesTemporaryStopWorkRequestData.setNoParkingStraightNumber(noParkingStraightNumber);
    }

    
    public final String getNoParkingStraightNumber() {
        return limogesTemporaryStopWorkRequestData.getNoParkingStraightNumber();
    }
  
    public final void setOnBehalf(final String onBehalf) {
        limogesTemporaryStopWorkRequestData.setOnBehalf(onBehalf);
    }

    
    public final String getOnBehalf() {
        return limogesTemporaryStopWorkRequestData.getOnBehalf();
    }
  
    public final void setPhoneNumber(final String phoneNumber) {
        limogesTemporaryStopWorkRequestData.setPhoneNumber(phoneNumber);
    }

    
    public final String getPhoneNumber() {
        return limogesTemporaryStopWorkRequestData.getPhoneNumber();
    }
  
    public final void setRequesterType(final fr.cg95.cvq.business.request.urbanism.LtswrRequesterType requesterType) {
        limogesTemporaryStopWorkRequestData.setRequesterType(requesterType);
    }

    
    public final fr.cg95.cvq.business.request.urbanism.LtswrRequesterType getRequesterType() {
        return limogesTemporaryStopWorkRequestData.getRequesterType();
    }
  
    public final void setSelectedRequestType(final fr.cg95.cvq.business.request.urbanism.LtswrRequestType selectedRequestType) {
        limogesTemporaryStopWorkRequestData.setSelectedRequestType(selectedRequestType);
    }

    
    public final fr.cg95.cvq.business.request.urbanism.LtswrRequestType getSelectedRequestType() {
        return limogesTemporaryStopWorkRequestData.getSelectedRequestType();
    }
  
    public final void setWorkAddress(final String workAddress) {
        limogesTemporaryStopWorkRequestData.setWorkAddress(workAddress);
    }

    
    public final String getWorkAddress() {
        return limogesTemporaryStopWorkRequestData.getWorkAddress();
    }
  
    public final void setWorkDate(final java.util.Date workDate) {
        limogesTemporaryStopWorkRequestData.setWorkDate(workDate);
    }

    
    public final java.util.Date getWorkDate() {
        return limogesTemporaryStopWorkRequestData.getWorkDate();
    }
  
    public final void setWorkDuration(final String workDuration) {
        limogesTemporaryStopWorkRequestData.setWorkDuration(workDuration);
    }

    
    public final String getWorkDuration() {
        return limogesTemporaryStopWorkRequestData.getWorkDuration();
    }
  
    public final void setWorkTime(final String workTime) {
        limogesTemporaryStopWorkRequestData.setWorkTime(workTime);
    }

    
    public final String getWorkTime() {
        return limogesTemporaryStopWorkRequestData.getWorkTime();
    }
  
    public final void setWorkType(final String workType) {
        limogesTemporaryStopWorkRequestData.setWorkType(workType);
    }

    
    public final String getWorkType() {
        return limogesTemporaryStopWorkRequestData.getWorkType();
    }
  
}
