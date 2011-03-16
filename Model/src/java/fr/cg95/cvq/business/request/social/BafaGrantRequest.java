
package fr.cg95.cvq.business.request.social;

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
import fr.cg95.cvq.xml.request.social.*;
import fr.cg95.cvq.service.request.condition.IConditionChecker;

/**
 * Generated class file, do not edit !
 */
public class BafaGrantRequest extends Request implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final Map<String, IConditionChecker> conditions = BafaGrantRequestData.conditions;

    @AssertValid(message = "")
    private BafaGrantRequestData bafaGrantRequestData;

    public BafaGrantRequest(RequestData requestData, BafaGrantRequestData bafaGrantRequestData) {
        super(requestData);
        this.bafaGrantRequestData = bafaGrantRequestData;
    }

    public BafaGrantRequest() {
        super();
        this.bafaGrantRequestData = new BafaGrantRequestData();
        Map<String, Object> stepState;
        
          stepState = new HashMap<String, Object>(4);
          stepState.put("state", "uncomplete");
          stepState.put("required", true);
          stepState.put("errorMsg", null);
          stepState.put("invalidFields", new ArrayList<String>());
          getStepStates().put("subject", stepState);
        
          stepState = new HashMap<String, Object>(4);
          stepState.put("state", "unavailable");
          stepState.put("required", true);
          stepState.put("errorMsg", null);
          stepState.put("invalidFields", new ArrayList<String>());
          getStepStates().put("internship", stepState);
        
          stepState = new HashMap<String, Object>(4);
          stepState.put("state", "unavailable");
          stepState.put("required", true);
          stepState.put("errorMsg", null);
          stepState.put("invalidFields", new ArrayList<String>());
          getStepStates().put("bankReference", stepState);
        
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
    public BafaGrantRequestData getSpecificData() {
        return bafaGrantRequestData;
    }

    /**
     * Reserved for RequestDAO !
     */
    public void setSpecificData(BafaGrantRequestData bafaGrantRequestData) {
        this.bafaGrantRequestData = bafaGrantRequestData;
    }

    @Override
    public final String modelToXmlString() {
        BafaGrantRequestDocument object = this.modelToXml();
        XmlOptions opts = new XmlOptions();
        opts.setSavePrettyPrint();
        opts.setSavePrettyPrintIndent(4);
        opts.setUseDefaultNamespace();
        opts.setCharacterEncoding("UTF-8");
        return object.xmlText(opts);
    }

    @Override
    public final BafaGrantRequestDocument modelToXml() {
        
        Calendar calendar = Calendar.getInstance();
        LocalTime localTime = new LocalTime();
        Date date = null;
        BafaGrantRequestDocument bafaGrantRequestDoc = BafaGrantRequestDocument.Factory.newInstance();
        BafaGrantRequestDocument.BafaGrantRequest bafaGrantRequest = bafaGrantRequestDoc.addNewBafaGrantRequest();
        super.fillCommonXmlInfo(bafaGrantRequest);
        int i = 0;
        
        date = getAccountHolderBirthDate();
        if (date != null) {
            calendar.setTime(date);
            bafaGrantRequest.setAccountHolderBirthDate(calendar);
        }
      
        bafaGrantRequest.setAccountHolderEdemandeId(getAccountHolderEdemandeId());
      
        bafaGrantRequest.setAccountHolderFirstName(getAccountHolderFirstName());
      
        bafaGrantRequest.setAccountHolderLastName(getAccountHolderLastName());
      
        if (getAccountHolderTitle() != null)
            bafaGrantRequest.setAccountHolderTitle(fr.cg95.cvq.xml.common.TitleType.Enum.forString(getAccountHolderTitle().toString()));
      
        bafaGrantRequest.setEdemandeId(getEdemandeId());
      
        if (getFrenchRIB() != null)
            bafaGrantRequest.setFrenchRIB(FrenchRIB.modelToXml(getFrenchRIB()));
      
        date = getInternshipEndDate();
        if (date != null) {
            calendar.setTime(date);
            bafaGrantRequest.setInternshipEndDate(calendar);
        }
      
        if (getInternshipInstituteAddress() != null)
            bafaGrantRequest.setInternshipInstituteAddress(Address.modelToXml(getInternshipInstituteAddress()));
      
        bafaGrantRequest.setInternshipInstituteName(getInternshipInstituteName());
      
        date = getInternshipStartDate();
        if (date != null) {
            calendar.setTime(date);
            bafaGrantRequest.setInternshipStartDate(calendar);
        }
      
        if (getIsSubjectAccountHolder() != null)
            bafaGrantRequest.setIsSubjectAccountHolder(getIsSubjectAccountHolder().booleanValue());
      
        if (getSubjectAddress() != null)
            bafaGrantRequest.setSubjectAddress(Address.modelToXml(getSubjectAddress()));
      
        bafaGrantRequest.setSubjectBirthCity(getSubjectBirthCity());
      
        date = getSubjectBirthDate();
        if (date != null) {
            calendar.setTime(date);
            bafaGrantRequest.setSubjectBirthDate(calendar);
        }
      
        bafaGrantRequest.setSubjectEmail(getSubjectEmail());
      
        bafaGrantRequest.setSubjectPhone(getSubjectPhone());
      
        return bafaGrantRequestDoc;
    }

    @Override
    public final BafaGrantRequestDocument.BafaGrantRequest modelToXmlRequest() {
        return modelToXml().getBafaGrantRequest();
    }

    public static BafaGrantRequest xmlToModel(BafaGrantRequestDocument bafaGrantRequestDoc) {
        BafaGrantRequestDocument.BafaGrantRequest bafaGrantRequestXml = bafaGrantRequestDoc.getBafaGrantRequest();
        Calendar calendar = Calendar.getInstance();
        LocalTime localTime = new LocalTime();
        List list = new ArrayList();
        BafaGrantRequest bafaGrantRequest = new BafaGrantRequest();
        bafaGrantRequest.fillCommonModelInfo(bafaGrantRequest, bafaGrantRequestXml);
        
        calendar = bafaGrantRequestXml.getAccountHolderBirthDate();
        if (calendar != null) {
            bafaGrantRequest.setAccountHolderBirthDate(calendar.getTime());
        }
      
        bafaGrantRequest.setAccountHolderEdemandeId(bafaGrantRequestXml.getAccountHolderEdemandeId());
      
        bafaGrantRequest.setAccountHolderFirstName(bafaGrantRequestXml.getAccountHolderFirstName());
      
        bafaGrantRequest.setAccountHolderLastName(bafaGrantRequestXml.getAccountHolderLastName());
      
        if (bafaGrantRequestXml.getAccountHolderTitle() != null)
            bafaGrantRequest.setAccountHolderTitle(fr.cg95.cvq.business.users.TitleType.forString(bafaGrantRequestXml.getAccountHolderTitle().toString()));
        else
            bafaGrantRequest.setAccountHolderTitle(fr.cg95.cvq.business.users.TitleType.getDefaultTitleType());
      
        bafaGrantRequest.setEdemandeId(bafaGrantRequestXml.getEdemandeId());
      
        if (bafaGrantRequestXml.getFrenchRIB() != null)
            bafaGrantRequest.setFrenchRIB(FrenchRIB.xmlToModel(bafaGrantRequestXml.getFrenchRIB()));
      
        calendar = bafaGrantRequestXml.getInternshipEndDate();
        if (calendar != null) {
            bafaGrantRequest.setInternshipEndDate(calendar.getTime());
        }
      
        if (bafaGrantRequestXml.getInternshipInstituteAddress() != null)
            bafaGrantRequest.setInternshipInstituteAddress(Address.xmlToModel(bafaGrantRequestXml.getInternshipInstituteAddress()));
      
        bafaGrantRequest.setInternshipInstituteName(bafaGrantRequestXml.getInternshipInstituteName());
      
        calendar = bafaGrantRequestXml.getInternshipStartDate();
        if (calendar != null) {
            bafaGrantRequest.setInternshipStartDate(calendar.getTime());
        }
      
        bafaGrantRequest.setIsSubjectAccountHolder(Boolean.valueOf(bafaGrantRequestXml.getIsSubjectAccountHolder()));
      
        if (bafaGrantRequestXml.getSubjectAddress() != null)
            bafaGrantRequest.setSubjectAddress(Address.xmlToModel(bafaGrantRequestXml.getSubjectAddress()));
      
        bafaGrantRequest.setSubjectBirthCity(bafaGrantRequestXml.getSubjectBirthCity());
      
        calendar = bafaGrantRequestXml.getSubjectBirthDate();
        if (calendar != null) {
            bafaGrantRequest.setSubjectBirthDate(calendar.getTime());
        }
      
        bafaGrantRequest.setSubjectEmail(bafaGrantRequestXml.getSubjectEmail());
      
        bafaGrantRequest.setSubjectPhone(bafaGrantRequestXml.getSubjectPhone());
      
        return bafaGrantRequest;
    }

    @Override
    public BafaGrantRequest clone() {
        BafaGrantRequest clone = new BafaGrantRequest(getRequestData().clone(), bafaGrantRequestData.clone());
        Map<String, Object> stepState;
        
          stepState = new HashMap<String, Object>(4);
          stepState.put("state", "uncomplete");
          stepState.put("required", true);
          stepState.put("errorMsg", null);
          stepState.put("invalidFields", new ArrayList<String>());
          clone.getStepStates().put("subject", stepState);
        
          stepState = new HashMap<String, Object>(4);
          stepState.put("state", "unavailable");
          stepState.put("required", true);
          stepState.put("errorMsg", null);
          stepState.put("invalidFields", new ArrayList<String>());
          clone.getStepStates().put("internship", stepState);
        
          stepState = new HashMap<String, Object>(4);
          stepState.put("state", "unavailable");
          stepState.put("required", true);
          stepState.put("errorMsg", null);
          stepState.put("invalidFields", new ArrayList<String>());
          clone.getStepStates().put("bankReference", stepState);
        
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

  
    public final void setAccountHolderBirthDate(final java.util.Date accountHolderBirthDate) {
        bafaGrantRequestData.setAccountHolderBirthDate(accountHolderBirthDate);
    }

    
    public final java.util.Date getAccountHolderBirthDate() {
        return bafaGrantRequestData.getAccountHolderBirthDate();
    }
  
    public final void setAccountHolderEdemandeId(final String accountHolderEdemandeId) {
        bafaGrantRequestData.setAccountHolderEdemandeId(accountHolderEdemandeId);
    }

    
    public final String getAccountHolderEdemandeId() {
        return bafaGrantRequestData.getAccountHolderEdemandeId();
    }
  
    public final void setAccountHolderFirstName(final String accountHolderFirstName) {
        bafaGrantRequestData.setAccountHolderFirstName(accountHolderFirstName);
    }

    
    public final String getAccountHolderFirstName() {
        return bafaGrantRequestData.getAccountHolderFirstName();
    }
  
    public final void setAccountHolderLastName(final String accountHolderLastName) {
        bafaGrantRequestData.setAccountHolderLastName(accountHolderLastName);
    }

    
    public final String getAccountHolderLastName() {
        return bafaGrantRequestData.getAccountHolderLastName();
    }
  
    public final void setAccountHolderTitle(final fr.cg95.cvq.business.users.TitleType accountHolderTitle) {
        bafaGrantRequestData.setAccountHolderTitle(accountHolderTitle);
    }

    
    public final fr.cg95.cvq.business.users.TitleType getAccountHolderTitle() {
        return bafaGrantRequestData.getAccountHolderTitle();
    }
  
    public final void setEdemandeId(final String edemandeId) {
        bafaGrantRequestData.setEdemandeId(edemandeId);
    }

    
    public final String getEdemandeId() {
        return bafaGrantRequestData.getEdemandeId();
    }
  
    public final void setFrenchRIB(final fr.cg95.cvq.business.users.FrenchRIB frenchRIB) {
        bafaGrantRequestData.setFrenchRIB(frenchRIB);
    }

    
    public final fr.cg95.cvq.business.users.FrenchRIB getFrenchRIB() {
        return bafaGrantRequestData.getFrenchRIB();
    }
  
    public final void setInternshipEndDate(final java.util.Date internshipEndDate) {
        bafaGrantRequestData.setInternshipEndDate(internshipEndDate);
    }

    
    public final java.util.Date getInternshipEndDate() {
        return bafaGrantRequestData.getInternshipEndDate();
    }
  
    public final void setInternshipInstituteAddress(final fr.cg95.cvq.business.users.Address internshipInstituteAddress) {
        bafaGrantRequestData.setInternshipInstituteAddress(internshipInstituteAddress);
    }

    
    public final fr.cg95.cvq.business.users.Address getInternshipInstituteAddress() {
        return bafaGrantRequestData.getInternshipInstituteAddress();
    }
  
    public final void setInternshipInstituteName(final String internshipInstituteName) {
        bafaGrantRequestData.setInternshipInstituteName(internshipInstituteName);
    }

    
    public final String getInternshipInstituteName() {
        return bafaGrantRequestData.getInternshipInstituteName();
    }
  
    public final void setInternshipStartDate(final java.util.Date internshipStartDate) {
        bafaGrantRequestData.setInternshipStartDate(internshipStartDate);
    }

    
    public final java.util.Date getInternshipStartDate() {
        return bafaGrantRequestData.getInternshipStartDate();
    }
  
    public final void setIsSubjectAccountHolder(final Boolean isSubjectAccountHolder) {
        bafaGrantRequestData.setIsSubjectAccountHolder(isSubjectAccountHolder);
    }

    
    public final Boolean getIsSubjectAccountHolder() {
        return bafaGrantRequestData.getIsSubjectAccountHolder();
    }
  
    public final void setSubjectAddress(final fr.cg95.cvq.business.users.Address subjectAddress) {
        bafaGrantRequestData.setSubjectAddress(subjectAddress);
    }

    
    public final fr.cg95.cvq.business.users.Address getSubjectAddress() {
        return bafaGrantRequestData.getSubjectAddress();
    }
  
    public final void setSubjectBirthCity(final String subjectBirthCity) {
        bafaGrantRequestData.setSubjectBirthCity(subjectBirthCity);
    }

    
    public final String getSubjectBirthCity() {
        return bafaGrantRequestData.getSubjectBirthCity();
    }
  
    public final void setSubjectBirthDate(final java.util.Date subjectBirthDate) {
        bafaGrantRequestData.setSubjectBirthDate(subjectBirthDate);
    }

    
    public final java.util.Date getSubjectBirthDate() {
        return bafaGrantRequestData.getSubjectBirthDate();
    }
  
    public final void setSubjectEmail(final String subjectEmail) {
        bafaGrantRequestData.setSubjectEmail(subjectEmail);
    }

    
    public final String getSubjectEmail() {
        return bafaGrantRequestData.getSubjectEmail();
    }
  
    public final void setSubjectPhone(final String subjectPhone) {
        bafaGrantRequestData.setSubjectPhone(subjectPhone);
    }

    
    public final String getSubjectPhone() {
        return bafaGrantRequestData.getSubjectPhone();
    }
  
}
