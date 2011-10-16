
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
public class LimogesParkingSpaceReservationRequest extends Request implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final Map<String, IConditionChecker> conditions = LimogesParkingSpaceReservationRequestData.conditions;

    @AssertValid(message = "")
    private LimogesParkingSpaceReservationRequestData limogesParkingSpaceReservationRequestData;

    public LimogesParkingSpaceReservationRequest(RequestData requestData, LimogesParkingSpaceReservationRequestData limogesParkingSpaceReservationRequestData) {
        super(requestData);
        this.limogesParkingSpaceReservationRequestData = limogesParkingSpaceReservationRequestData;
    }

    public LimogesParkingSpaceReservationRequest() {
        super();
        this.limogesParkingSpaceReservationRequestData = new LimogesParkingSpaceReservationRequestData();
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
          getStepStates().put("reservation", stepState);
        
          stepState = new HashMap<String, Object>(4);
          stepState.put("state", "unavailable");
          stepState.put("required", true);
          stepState.put("errorMsg", null);
          stepState.put("invalidFields", new ArrayList<String>());
          getStepStates().put("complement", stepState);
        
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
    public LimogesParkingSpaceReservationRequestData getSpecificData() {
        return limogesParkingSpaceReservationRequestData;
    }

    /**
     * Reserved for RequestDAO !
     */
    public void setSpecificData(LimogesParkingSpaceReservationRequestData limogesParkingSpaceReservationRequestData) {
        this.limogesParkingSpaceReservationRequestData = limogesParkingSpaceReservationRequestData;
    }

    @Override
    public final String modelToXmlString() {
        LimogesParkingSpaceReservationRequestDocument object = this.modelToXml();
        XmlOptions opts = new XmlOptions();
        opts.setSavePrettyPrint();
        opts.setSavePrettyPrintIndent(4);
        opts.setUseDefaultNamespace();
        opts.setCharacterEncoding("UTF-8");
        return object.xmlText(opts);
    }

    @Override
    public final LimogesParkingSpaceReservationRequestDocument modelToXml() {
        
        Calendar calendar = Calendar.getInstance();
        LocalTime localTime = new LocalTime();
        Date date = null;
        LimogesParkingSpaceReservationRequestDocument limogesParkingSpaceReservationRequestDoc = LimogesParkingSpaceReservationRequestDocument.Factory.newInstance();
        LimogesParkingSpaceReservationRequestDocument.LimogesParkingSpaceReservationRequest limogesParkingSpaceReservationRequest = limogesParkingSpaceReservationRequestDoc.addNewLimogesParkingSpaceReservationRequest();
        super.fillCommonXmlInfo(limogesParkingSpaceReservationRequest);
        int i = 0;
        
        limogesParkingSpaceReservationRequest.setAddress(getAddress());
      
        if (getCivility() != null)
            limogesParkingSpaceReservationRequest.setCivility(fr.cg95.cvq.xml.common.TitleType.Enum.forString(getCivility().getLegacyLabel()));
      
        limogesParkingSpaceReservationRequest.setContractorName(getContractorName());
      
        i = 0;
        if (getDuration() != null) {
            fr.cg95.cvq.xml.common.LocalReferentialDataType[] durationTypeTab = new fr.cg95.cvq.xml.common.LocalReferentialDataType[getDuration().size()];
            for (LocalReferentialData object : getDuration()) {
              durationTypeTab[i++] = LocalReferentialData.modelToXml(object);
            }
            limogesParkingSpaceReservationRequest.setDurationArray(durationTypeTab);
        }
      
        limogesParkingSpaceReservationRequest.setFaxNumber(getFaxNumber());
      
        limogesParkingSpaceReservationRequest.setFirstName(getFirstName());
      
        if (getFootWay() != null)
            limogesParkingSpaceReservationRequest.setFootWay(getFootWay().booleanValue());
      
        if (getFurnitureLift() != null)
            limogesParkingSpaceReservationRequest.setFurnitureLift(getFurnitureLift().booleanValue());
      
        limogesParkingSpaceReservationRequest.setLastName(getLastName());
      
        if (getLpsrrRule() != null)
            limogesParkingSpaceReservationRequest.setLpsrrRule(getLpsrrRule().booleanValue());
      
        limogesParkingSpaceReservationRequest.setMail(getMail());
      
        limogesParkingSpaceReservationRequest.setPhoneNumber(getPhoneNumber());
      
        limogesParkingSpaceReservationRequest.setRequesterFirstAddress(getRequesterFirstAddress());
      
        if (getRequesterFirstAddressKind() != null)
            limogesParkingSpaceReservationRequest.setRequesterFirstAddressKind(fr.cg95.cvq.xml.request.urbanism.AccountAddressKindType.Enum.forString(getRequesterFirstAddressKind().getLegacyLabel()));
      
        limogesParkingSpaceReservationRequest.setRequesterOtherAddress(getRequesterOtherAddress());
      
        if (getRequesterOtherAddressKind() != null)
            limogesParkingSpaceReservationRequest.setRequesterOtherAddressKind(fr.cg95.cvq.xml.request.urbanism.AccountAddressKindType.Enum.forString(getRequesterOtherAddressKind().getLegacyLabel()));
      
        if (getRequesterType() != null)
            limogesParkingSpaceReservationRequest.setRequesterType(fr.cg95.cvq.xml.request.urbanism.LpsrrRequesterType.Enum.forString(getRequesterType().getLegacyLabel()));
      
        date = getStartDate();
        if (date != null) {
            calendar.setTime(date);
            limogesParkingSpaceReservationRequest.setStartDate(calendar);
        }
      
        limogesParkingSpaceReservationRequest.setVehiclesRegistration(getVehiclesRegistration());
      
        return limogesParkingSpaceReservationRequestDoc;
    }

    @Override
    public final LimogesParkingSpaceReservationRequestDocument.LimogesParkingSpaceReservationRequest modelToXmlRequest() {
        return modelToXml().getLimogesParkingSpaceReservationRequest();
    }

    public static LimogesParkingSpaceReservationRequest xmlToModel(LimogesParkingSpaceReservationRequestDocument limogesParkingSpaceReservationRequestDoc) {
        LimogesParkingSpaceReservationRequestDocument.LimogesParkingSpaceReservationRequest limogesParkingSpaceReservationRequestXml = limogesParkingSpaceReservationRequestDoc.getLimogesParkingSpaceReservationRequest();
        Calendar calendar = Calendar.getInstance();
        LocalTime localTime = new LocalTime();
        List list = new ArrayList();
        LimogesParkingSpaceReservationRequest limogesParkingSpaceReservationRequest = new LimogesParkingSpaceReservationRequest();
        limogesParkingSpaceReservationRequest.fillCommonModelInfo(limogesParkingSpaceReservationRequest, limogesParkingSpaceReservationRequestXml);
        
        limogesParkingSpaceReservationRequest.setAddress(limogesParkingSpaceReservationRequestXml.getAddress());
      
        if (limogesParkingSpaceReservationRequestXml.getCivility() != null)
            limogesParkingSpaceReservationRequest.setCivility(fr.cg95.cvq.business.users.TitleType.forString(limogesParkingSpaceReservationRequestXml.getCivility().toString()));
        else
            limogesParkingSpaceReservationRequest.setCivility(fr.cg95.cvq.business.users.TitleType.getDefaultTitleType());
      
        limogesParkingSpaceReservationRequest.setContractorName(limogesParkingSpaceReservationRequestXml.getContractorName());
      
        List<fr.cg95.cvq.business.request.LocalReferentialData> durationList = new ArrayList<fr.cg95.cvq.business.request.LocalReferentialData>(limogesParkingSpaceReservationRequestXml.sizeOfDurationArray());
        for (LocalReferentialDataType object : limogesParkingSpaceReservationRequestXml.getDurationArray()) {
            durationList.add(fr.cg95.cvq.business.request.LocalReferentialData.xmlToModel(object));
        }
        limogesParkingSpaceReservationRequest.setDuration(durationList);
      
        limogesParkingSpaceReservationRequest.setFaxNumber(limogesParkingSpaceReservationRequestXml.getFaxNumber());
      
        limogesParkingSpaceReservationRequest.setFirstName(limogesParkingSpaceReservationRequestXml.getFirstName());
      
        limogesParkingSpaceReservationRequest.setFootWay(Boolean.valueOf(limogesParkingSpaceReservationRequestXml.getFootWay()));
      
        limogesParkingSpaceReservationRequest.setFurnitureLift(Boolean.valueOf(limogesParkingSpaceReservationRequestXml.getFurnitureLift()));
      
        limogesParkingSpaceReservationRequest.setLastName(limogesParkingSpaceReservationRequestXml.getLastName());
      
        limogesParkingSpaceReservationRequest.setLpsrrRule(Boolean.valueOf(limogesParkingSpaceReservationRequestXml.getLpsrrRule()));
      
        limogesParkingSpaceReservationRequest.setMail(limogesParkingSpaceReservationRequestXml.getMail());
      
        limogesParkingSpaceReservationRequest.setPhoneNumber(limogesParkingSpaceReservationRequestXml.getPhoneNumber());
      
        limogesParkingSpaceReservationRequest.setRequesterFirstAddress(limogesParkingSpaceReservationRequestXml.getRequesterFirstAddress());
      
        if (limogesParkingSpaceReservationRequestXml.getRequesterFirstAddressKind() != null)
            limogesParkingSpaceReservationRequest.setRequesterFirstAddressKind(fr.cg95.cvq.business.request.urbanism.AccountAddressKindType.forString(limogesParkingSpaceReservationRequestXml.getRequesterFirstAddressKind().toString()));
        else
            limogesParkingSpaceReservationRequest.setRequesterFirstAddressKind(fr.cg95.cvq.business.request.urbanism.AccountAddressKindType.getDefaultAccountAddressKindType());
      
        limogesParkingSpaceReservationRequest.setRequesterOtherAddress(limogesParkingSpaceReservationRequestXml.getRequesterOtherAddress());
      
        if (limogesParkingSpaceReservationRequestXml.getRequesterOtherAddressKind() != null)
            limogesParkingSpaceReservationRequest.setRequesterOtherAddressKind(fr.cg95.cvq.business.request.urbanism.AccountAddressKindType.forString(limogesParkingSpaceReservationRequestXml.getRequesterOtherAddressKind().toString()));
        else
            limogesParkingSpaceReservationRequest.setRequesterOtherAddressKind(fr.cg95.cvq.business.request.urbanism.AccountAddressKindType.getDefaultAccountAddressKindType());
      
        if (limogesParkingSpaceReservationRequestXml.getRequesterType() != null)
            limogesParkingSpaceReservationRequest.setRequesterType(fr.cg95.cvq.business.request.urbanism.LpsrrRequesterType.forString(limogesParkingSpaceReservationRequestXml.getRequesterType().toString()));
        else
            limogesParkingSpaceReservationRequest.setRequesterType(fr.cg95.cvq.business.request.urbanism.LpsrrRequesterType.getDefaultLpsrrRequesterType());
      
        calendar = limogesParkingSpaceReservationRequestXml.getStartDate();
        if (calendar != null) {
            limogesParkingSpaceReservationRequest.setStartDate(calendar.getTime());
        }
      
        limogesParkingSpaceReservationRequest.setVehiclesRegistration(limogesParkingSpaceReservationRequestXml.getVehiclesRegistration());
      
        return limogesParkingSpaceReservationRequest;
    }

    @Override
    public LimogesParkingSpaceReservationRequest clone() {
        LimogesParkingSpaceReservationRequest clone = new LimogesParkingSpaceReservationRequest(getRequestData().clone(), limogesParkingSpaceReservationRequestData.clone());
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
          clone.getStepStates().put("reservation", stepState);
        
          stepState = new HashMap<String, Object>(4);
          stepState.put("state", "unavailable");
          stepState.put("required", true);
          stepState.put("errorMsg", null);
          stepState.put("invalidFields", new ArrayList<String>());
          clone.getStepStates().put("complement", stepState);
        
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
        limogesParkingSpaceReservationRequestData.setAddress(address);
    }

    
    public final String getAddress() {
        return limogesParkingSpaceReservationRequestData.getAddress();
    }
  
    public final void setCivility(final fr.cg95.cvq.business.users.TitleType civility) {
        limogesParkingSpaceReservationRequestData.setCivility(civility);
    }

    
    public final fr.cg95.cvq.business.users.TitleType getCivility() {
        return limogesParkingSpaceReservationRequestData.getCivility();
    }
  
    public final void setContractorName(final String contractorName) {
        limogesParkingSpaceReservationRequestData.setContractorName(contractorName);
    }

    
    public final String getContractorName() {
        return limogesParkingSpaceReservationRequestData.getContractorName();
    }
  
    public final void setDuration(final List<fr.cg95.cvq.business.request.LocalReferentialData> duration) {
        limogesParkingSpaceReservationRequestData.setDuration(duration);
    }

    
    public final List<fr.cg95.cvq.business.request.LocalReferentialData> getDuration() {
        return limogesParkingSpaceReservationRequestData.getDuration();
    }
  
    public final void setFaxNumber(final String faxNumber) {
        limogesParkingSpaceReservationRequestData.setFaxNumber(faxNumber);
    }

    
    public final String getFaxNumber() {
        return limogesParkingSpaceReservationRequestData.getFaxNumber();
    }
  
    public final void setFirstName(final String firstName) {
        limogesParkingSpaceReservationRequestData.setFirstName(firstName);
    }

    
    public final String getFirstName() {
        return limogesParkingSpaceReservationRequestData.getFirstName();
    }
  
    public final void setFootWay(final Boolean footWay) {
        limogesParkingSpaceReservationRequestData.setFootWay(footWay);
    }

    
    public final Boolean getFootWay() {
        return limogesParkingSpaceReservationRequestData.getFootWay();
    }
  
    public final void setFurnitureLift(final Boolean furnitureLift) {
        limogesParkingSpaceReservationRequestData.setFurnitureLift(furnitureLift);
    }

    
    public final Boolean getFurnitureLift() {
        return limogesParkingSpaceReservationRequestData.getFurnitureLift();
    }
  
    public final void setLastName(final String lastName) {
        limogesParkingSpaceReservationRequestData.setLastName(lastName);
    }

    
    public final String getLastName() {
        return limogesParkingSpaceReservationRequestData.getLastName();
    }
  
    public final void setLpsrrRule(final Boolean lpsrrRule) {
        limogesParkingSpaceReservationRequestData.setLpsrrRule(lpsrrRule);
    }

    @IsRulesAcceptance
    public final Boolean getLpsrrRule() {
        return limogesParkingSpaceReservationRequestData.getLpsrrRule();
    }
  
    public final void setMail(final String mail) {
        limogesParkingSpaceReservationRequestData.setMail(mail);
    }

    
    public final String getMail() {
        return limogesParkingSpaceReservationRequestData.getMail();
    }
  
    public final void setPhoneNumber(final String phoneNumber) {
        limogesParkingSpaceReservationRequestData.setPhoneNumber(phoneNumber);
    }

    
    public final String getPhoneNumber() {
        return limogesParkingSpaceReservationRequestData.getPhoneNumber();
    }
  
    public final void setRequesterFirstAddress(final String requesterFirstAddress) {
        limogesParkingSpaceReservationRequestData.setRequesterFirstAddress(requesterFirstAddress);
    }

    
    public final String getRequesterFirstAddress() {
        return limogesParkingSpaceReservationRequestData.getRequesterFirstAddress();
    }
  
    public final void setRequesterFirstAddressKind(final fr.cg95.cvq.business.request.urbanism.AccountAddressKindType requesterFirstAddressKind) {
        limogesParkingSpaceReservationRequestData.setRequesterFirstAddressKind(requesterFirstAddressKind);
    }

    
    public final fr.cg95.cvq.business.request.urbanism.AccountAddressKindType getRequesterFirstAddressKind() {
        return limogesParkingSpaceReservationRequestData.getRequesterFirstAddressKind();
    }
  
    public final void setRequesterOtherAddress(final String requesterOtherAddress) {
        limogesParkingSpaceReservationRequestData.setRequesterOtherAddress(requesterOtherAddress);
    }

    
    public final String getRequesterOtherAddress() {
        return limogesParkingSpaceReservationRequestData.getRequesterOtherAddress();
    }
  
    public final void setRequesterOtherAddressKind(final fr.cg95.cvq.business.request.urbanism.AccountAddressKindType requesterOtherAddressKind) {
        limogesParkingSpaceReservationRequestData.setRequesterOtherAddressKind(requesterOtherAddressKind);
    }

    
    public final fr.cg95.cvq.business.request.urbanism.AccountAddressKindType getRequesterOtherAddressKind() {
        return limogesParkingSpaceReservationRequestData.getRequesterOtherAddressKind();
    }
  
    public final void setRequesterType(final fr.cg95.cvq.business.request.urbanism.LpsrrRequesterType requesterType) {
        limogesParkingSpaceReservationRequestData.setRequesterType(requesterType);
    }

    
    public final fr.cg95.cvq.business.request.urbanism.LpsrrRequesterType getRequesterType() {
        return limogesParkingSpaceReservationRequestData.getRequesterType();
    }
  
    public final void setStartDate(final java.util.Date startDate) {
        limogesParkingSpaceReservationRequestData.setStartDate(startDate);
    }

    
    public final java.util.Date getStartDate() {
        return limogesParkingSpaceReservationRequestData.getStartDate();
    }
  
    public final void setVehiclesRegistration(final String vehiclesRegistration) {
        limogesParkingSpaceReservationRequestData.setVehiclesRegistration(vehiclesRegistration);
    }

    
    public final String getVehiclesRegistration() {
        return limogesParkingSpaceReservationRequestData.getVehiclesRegistration();
    }
  
}
