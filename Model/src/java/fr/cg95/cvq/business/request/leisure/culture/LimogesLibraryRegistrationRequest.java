
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
public class LimogesLibraryRegistrationRequest extends Request implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final Map<String, IConditionChecker> conditions = LimogesLibraryRegistrationRequestData.conditions;

    @AssertValid(message = "")
    private LimogesLibraryRegistrationRequestData limogesLibraryRegistrationRequestData;

    public LimogesLibraryRegistrationRequest(RequestData requestData, LimogesLibraryRegistrationRequestData limogesLibraryRegistrationRequestData) {
        super(requestData);
        this.limogesLibraryRegistrationRequestData = limogesLibraryRegistrationRequestData;
    }

    public LimogesLibraryRegistrationRequest() {
        super();
        this.limogesLibraryRegistrationRequestData = new LimogesLibraryRegistrationRequestData();
        Map<String, Object> stepState;
        
          stepState = new HashMap<String, Object>(4);
          stepState.put("state", "uncomplete");
          stepState.put("required", true);
          stepState.put("errorMsg", null);
          stepState.put("invalidFields", new ArrayList<String>());
          getStepStates().put("registration", stepState);
        
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
    public LimogesLibraryRegistrationRequestData getSpecificData() {
        return limogesLibraryRegistrationRequestData;
    }

    /**
     * Reserved for RequestDAO !
     */
    public void setSpecificData(LimogesLibraryRegistrationRequestData limogesLibraryRegistrationRequestData) {
        this.limogesLibraryRegistrationRequestData = limogesLibraryRegistrationRequestData;
    }

    @Override
    public final String modelToXmlString() {
        LimogesLibraryRegistrationRequestDocument object = this.modelToXml();
        XmlOptions opts = new XmlOptions();
        opts.setSavePrettyPrint();
        opts.setSavePrettyPrintIndent(4);
        opts.setUseDefaultNamespace();
        opts.setCharacterEncoding("UTF-8");
        return object.xmlText(opts);
    }

    @Override
    public final LimogesLibraryRegistrationRequestDocument modelToXml() {
        
        Calendar calendar = Calendar.getInstance();
        LocalTime localTime = new LocalTime();
        Date date = null;
        LimogesLibraryRegistrationRequestDocument limogesLibraryRegistrationRequestDoc = LimogesLibraryRegistrationRequestDocument.Factory.newInstance();
        LimogesLibraryRegistrationRequestDocument.LimogesLibraryRegistrationRequest limogesLibraryRegistrationRequest = limogesLibraryRegistrationRequestDoc.addNewLimogesLibraryRegistrationRequest();
        super.fillCommonXmlInfo(limogesLibraryRegistrationRequest);
        int i = 0;
        
        date = getLlrrBirthDate();
        if (date != null) {
            calendar.setTime(date);
            limogesLibraryRegistrationRequest.setLlrrBirthDate(calendar);
        }
      
        i = 0;
        if (getLlrrCareer() != null) {
            fr.cg95.cvq.xml.common.LocalReferentialDataType[] llrrCareerTypeTab = new fr.cg95.cvq.xml.common.LocalReferentialDataType[getLlrrCareer().size()];
            for (LocalReferentialData object : getLlrrCareer()) {
              llrrCareerTypeTab[i++] = LocalReferentialData.modelToXml(object);
            }
            limogesLibraryRegistrationRequest.setLlrrCareerArray(llrrCareerTypeTab);
        }
      
        limogesLibraryRegistrationRequest.setLlrrSchoolClass(getLlrrSchoolClass());
      
        limogesLibraryRegistrationRequest.setLlrrSchoolName(getLlrrSchoolName());
      
        i = 0;
        if (getLlrrSchoolType() != null) {
            fr.cg95.cvq.xml.common.LocalReferentialDataType[] llrrSchoolTypeTypeTab = new fr.cg95.cvq.xml.common.LocalReferentialDataType[getLlrrSchoolType().size()];
            for (LocalReferentialData object : getLlrrSchoolType()) {
              llrrSchoolTypeTypeTab[i++] = LocalReferentialData.modelToXml(object);
            }
            limogesLibraryRegistrationRequest.setLlrrSchoolTypeArray(llrrSchoolTypeTypeTab);
        }
      
        i = 0;
        if (getLlrrSubscription() != null) {
            fr.cg95.cvq.xml.common.LocalReferentialDataType[] llrrSubscriptionTypeTab = new fr.cg95.cvq.xml.common.LocalReferentialDataType[getLlrrSubscription().size()];
            for (LocalReferentialData object : getLlrrSubscription()) {
              llrrSubscriptionTypeTab[i++] = LocalReferentialData.modelToXml(object);
            }
            limogesLibraryRegistrationRequest.setLlrrSubscriptionArray(llrrSubscriptionTypeTab);
        }
      
        if (getMailingList() != null)
            limogesLibraryRegistrationRequest.setMailingList(getMailingList().booleanValue());
      
        if (getRulesAndRegulationsAcceptance() != null)
            limogesLibraryRegistrationRequest.setRulesAndRegulationsAcceptance(getRulesAndRegulationsAcceptance().booleanValue());
      
        return limogesLibraryRegistrationRequestDoc;
    }

    @Override
    public final LimogesLibraryRegistrationRequestDocument.LimogesLibraryRegistrationRequest modelToXmlRequest() {
        return modelToXml().getLimogesLibraryRegistrationRequest();
    }

    public static LimogesLibraryRegistrationRequest xmlToModel(LimogesLibraryRegistrationRequestDocument limogesLibraryRegistrationRequestDoc) {
        LimogesLibraryRegistrationRequestDocument.LimogesLibraryRegistrationRequest limogesLibraryRegistrationRequestXml = limogesLibraryRegistrationRequestDoc.getLimogesLibraryRegistrationRequest();
        Calendar calendar = Calendar.getInstance();
        LocalTime localTime = new LocalTime();
        List list = new ArrayList();
        LimogesLibraryRegistrationRequest limogesLibraryRegistrationRequest = new LimogesLibraryRegistrationRequest();
        limogesLibraryRegistrationRequest.fillCommonModelInfo(limogesLibraryRegistrationRequest, limogesLibraryRegistrationRequestXml);
        
        calendar = limogesLibraryRegistrationRequestXml.getLlrrBirthDate();
        if (calendar != null) {
            limogesLibraryRegistrationRequest.setLlrrBirthDate(calendar.getTime());
        }
      
        List<fr.cg95.cvq.business.request.LocalReferentialData> llrrCareerList = new ArrayList<fr.cg95.cvq.business.request.LocalReferentialData>(limogesLibraryRegistrationRequestXml.sizeOfLlrrCareerArray());
        for (LocalReferentialDataType object : limogesLibraryRegistrationRequestXml.getLlrrCareerArray()) {
            llrrCareerList.add(fr.cg95.cvq.business.request.LocalReferentialData.xmlToModel(object));
        }
        limogesLibraryRegistrationRequest.setLlrrCareer(llrrCareerList);
      
        limogesLibraryRegistrationRequest.setLlrrSchoolClass(limogesLibraryRegistrationRequestXml.getLlrrSchoolClass());
      
        limogesLibraryRegistrationRequest.setLlrrSchoolName(limogesLibraryRegistrationRequestXml.getLlrrSchoolName());
      
        List<fr.cg95.cvq.business.request.LocalReferentialData> llrrSchoolTypeList = new ArrayList<fr.cg95.cvq.business.request.LocalReferentialData>(limogesLibraryRegistrationRequestXml.sizeOfLlrrSchoolTypeArray());
        for (LocalReferentialDataType object : limogesLibraryRegistrationRequestXml.getLlrrSchoolTypeArray()) {
            llrrSchoolTypeList.add(fr.cg95.cvq.business.request.LocalReferentialData.xmlToModel(object));
        }
        limogesLibraryRegistrationRequest.setLlrrSchoolType(llrrSchoolTypeList);
      
        List<fr.cg95.cvq.business.request.LocalReferentialData> llrrSubscriptionList = new ArrayList<fr.cg95.cvq.business.request.LocalReferentialData>(limogesLibraryRegistrationRequestXml.sizeOfLlrrSubscriptionArray());
        for (LocalReferentialDataType object : limogesLibraryRegistrationRequestXml.getLlrrSubscriptionArray()) {
            llrrSubscriptionList.add(fr.cg95.cvq.business.request.LocalReferentialData.xmlToModel(object));
        }
        limogesLibraryRegistrationRequest.setLlrrSubscription(llrrSubscriptionList);
      
        limogesLibraryRegistrationRequest.setMailingList(Boolean.valueOf(limogesLibraryRegistrationRequestXml.getMailingList()));
      
        limogesLibraryRegistrationRequest.setRulesAndRegulationsAcceptance(Boolean.valueOf(limogesLibraryRegistrationRequestXml.getRulesAndRegulationsAcceptance()));
      
        return limogesLibraryRegistrationRequest;
    }

    @Override
    public LimogesLibraryRegistrationRequest clone() {
        LimogesLibraryRegistrationRequest clone = new LimogesLibraryRegistrationRequest(getRequestData().clone(), limogesLibraryRegistrationRequestData.clone());
        Map<String, Object> stepState;
        
          stepState = new HashMap<String, Object>(4);
          stepState.put("state", "uncomplete");
          stepState.put("required", true);
          stepState.put("errorMsg", null);
          stepState.put("invalidFields", new ArrayList<String>());
          clone.getStepStates().put("registration", stepState);
        
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

  
    public final void setLlrrBirthDate(final java.util.Date llrrBirthDate) {
        limogesLibraryRegistrationRequestData.setLlrrBirthDate(llrrBirthDate);
    }

    
    public final java.util.Date getLlrrBirthDate() {
        return limogesLibraryRegistrationRequestData.getLlrrBirthDate();
    }
  
    public final void setLlrrCareer(final List<fr.cg95.cvq.business.request.LocalReferentialData> llrrCareer) {
        limogesLibraryRegistrationRequestData.setLlrrCareer(llrrCareer);
    }

    
    public final List<fr.cg95.cvq.business.request.LocalReferentialData> getLlrrCareer() {
        return limogesLibraryRegistrationRequestData.getLlrrCareer();
    }
  
    public final void setLlrrSchoolClass(final String llrrSchoolClass) {
        limogesLibraryRegistrationRequestData.setLlrrSchoolClass(llrrSchoolClass);
    }

    
    public final String getLlrrSchoolClass() {
        return limogesLibraryRegistrationRequestData.getLlrrSchoolClass();
    }
  
    public final void setLlrrSchoolName(final String llrrSchoolName) {
        limogesLibraryRegistrationRequestData.setLlrrSchoolName(llrrSchoolName);
    }

    
    public final String getLlrrSchoolName() {
        return limogesLibraryRegistrationRequestData.getLlrrSchoolName();
    }
  
    public final void setLlrrSchoolType(final List<fr.cg95.cvq.business.request.LocalReferentialData> llrrSchoolType) {
        limogesLibraryRegistrationRequestData.setLlrrSchoolType(llrrSchoolType);
    }

    
    public final List<fr.cg95.cvq.business.request.LocalReferentialData> getLlrrSchoolType() {
        return limogesLibraryRegistrationRequestData.getLlrrSchoolType();
    }
  
    public final void setLlrrSubscription(final List<fr.cg95.cvq.business.request.LocalReferentialData> llrrSubscription) {
        limogesLibraryRegistrationRequestData.setLlrrSubscription(llrrSubscription);
    }

    
    public final List<fr.cg95.cvq.business.request.LocalReferentialData> getLlrrSubscription() {
        return limogesLibraryRegistrationRequestData.getLlrrSubscription();
    }
  
    public final void setMailingList(final Boolean mailingList) {
        limogesLibraryRegistrationRequestData.setMailingList(mailingList);
    }

    @IsRulesAcceptance
    public final Boolean getMailingList() {
        return limogesLibraryRegistrationRequestData.getMailingList();
    }
  
    public final void setRulesAndRegulationsAcceptance(final Boolean rulesAndRegulationsAcceptance) {
        limogesLibraryRegistrationRequestData.setRulesAndRegulationsAcceptance(rulesAndRegulationsAcceptance);
    }

    @IsRulesAcceptance
    public final Boolean getRulesAndRegulationsAcceptance() {
        return limogesLibraryRegistrationRequestData.getRulesAndRegulationsAcceptance();
    }
  
}
