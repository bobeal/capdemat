
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
public class BAFAGrantRequest extends Request implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final Map<String, IConditionChecker> conditions = BAFAGrantRequestData.conditions;

    @AssertValid(message = "")
    private BAFAGrantRequestData bAFAGrantRequestData;

    public BAFAGrantRequest(RequestData requestData, BAFAGrantRequestData bAFAGrantRequestData) {
        super(requestData);
        this.bAFAGrantRequestData = bAFAGrantRequestData;
    }

    public BAFAGrantRequest() {
        super();
        this.bAFAGrantRequestData = new BAFAGrantRequestData();
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
    public BAFAGrantRequestData getSpecificData() {
        return bAFAGrantRequestData;
    }

    /**
     * Reserved for RequestDAO !
     */
    public void setSpecificData(BAFAGrantRequestData bAFAGrantRequestData) {
        this.bAFAGrantRequestData = bAFAGrantRequestData;
    }

    @Override
    public final String modelToXmlString() {
        BAFAGrantRequestDocument object = this.modelToXml();
        XmlOptions opts = new XmlOptions();
        opts.setSavePrettyPrint();
        opts.setSavePrettyPrintIndent(4);
        opts.setUseDefaultNamespace();
        opts.setCharacterEncoding("UTF-8");
        return object.xmlText(opts);
    }

    @Override
    public final BAFAGrantRequestDocument modelToXml() {
        
        Calendar calendar = Calendar.getInstance();
        Date date = null;
        BAFAGrantRequestDocument bAFAGrantRequestDoc = BAFAGrantRequestDocument.Factory.newInstance();
        BAFAGrantRequestDocument.BAFAGrantRequest bAFAGrantRequest = bAFAGrantRequestDoc.addNewBAFAGrantRequest();
        super.fillCommonXmlInfo(bAFAGrantRequest);
        int i = 0;
        
        bAFAGrantRequest.setAccountHolderFirstName(getAccountHolderFirstName());
      
        bAFAGrantRequest.setAccountHolderEdemandeId(getAccountHolderEdemandeId());
      
        if (getInternshipInstituteAddress() != null)
            bAFAGrantRequest.setInternshipInstituteAddress(Address.modelToXml(getInternshipInstituteAddress()));
      
        bAFAGrantRequest.setEdemandeId(getEdemandeId());
      
        date = getInternshipStartDate();
        if (date != null) {
            calendar.setTime(date);
            bAFAGrantRequest.setInternshipStartDate(calendar);
        }
      
        date = getInternshipEndDate();
        if (date != null) {
            calendar.setTime(date);
            bAFAGrantRequest.setInternshipEndDate(calendar);
        }
      
        if (getIsSubjectAccountHolder() != null)
            bAFAGrantRequest.setIsSubjectAccountHolder(getIsSubjectAccountHolder().booleanValue());
      
        if (getFrenchRIB() != null)
            bAFAGrantRequest.setFrenchRIB(FrenchRIB.modelToXml(getFrenchRIB()));
      
        bAFAGrantRequest.setSubjectBirthCity(getSubjectBirthCity());
      
        date = getAccountHolderBirthDate();
        if (date != null) {
            calendar.setTime(date);
            bAFAGrantRequest.setAccountHolderBirthDate(calendar);
        }
      
        date = getSubjectBirthDate();
        if (date != null) {
            calendar.setTime(date);
            bAFAGrantRequest.setSubjectBirthDate(calendar);
        }
      
        bAFAGrantRequest.setInternshipInstituteName(getInternshipInstituteName());
      
        if (getSubjectAddress() != null)
            bAFAGrantRequest.setSubjectAddress(Address.modelToXml(getSubjectAddress()));
      
        bAFAGrantRequest.setAccountHolderLastName(getAccountHolderLastName());
      
        bAFAGrantRequest.setSubjectPhone(getSubjectPhone());
      
        bAFAGrantRequest.setSubjectEmail(getSubjectEmail());
      
        if (getAccountHolderTitle() != null)
            bAFAGrantRequest.setAccountHolderTitle(fr.cg95.cvq.xml.common.TitleType.Enum.forString(getAccountHolderTitle().toString()));
      
        return bAFAGrantRequestDoc;
    }

    @Override
    public final BAFAGrantRequestDocument.BAFAGrantRequest modelToXmlRequest() {
        return modelToXml().getBAFAGrantRequest();
    }

    public static BAFAGrantRequest xmlToModel(BAFAGrantRequestDocument bAFAGrantRequestDoc) {
        BAFAGrantRequestDocument.BAFAGrantRequest bAFAGrantRequestXml = bAFAGrantRequestDoc.getBAFAGrantRequest();
        Calendar calendar = Calendar.getInstance();
        List list = new ArrayList();
        BAFAGrantRequest bAFAGrantRequest = new BAFAGrantRequest();
        bAFAGrantRequest.fillCommonModelInfo(bAFAGrantRequest, bAFAGrantRequestXml);
        
        bAFAGrantRequest.setAccountHolderFirstName(bAFAGrantRequestXml.getAccountHolderFirstName());
      
        bAFAGrantRequest.setAccountHolderEdemandeId(bAFAGrantRequestXml.getAccountHolderEdemandeId());
      
        if (bAFAGrantRequestXml.getInternshipInstituteAddress() != null)
            bAFAGrantRequest.setInternshipInstituteAddress(Address.xmlToModel(bAFAGrantRequestXml.getInternshipInstituteAddress()));
      
        bAFAGrantRequest.setEdemandeId(bAFAGrantRequestXml.getEdemandeId());
      
        calendar = bAFAGrantRequestXml.getInternshipStartDate();
        if (calendar != null) {
            bAFAGrantRequest.setInternshipStartDate(calendar.getTime());
        }
      
        calendar = bAFAGrantRequestXml.getInternshipEndDate();
        if (calendar != null) {
            bAFAGrantRequest.setInternshipEndDate(calendar.getTime());
        }
      
        bAFAGrantRequest.setIsSubjectAccountHolder(Boolean.valueOf(bAFAGrantRequestXml.getIsSubjectAccountHolder()));
      
        if (bAFAGrantRequestXml.getFrenchRIB() != null)
            bAFAGrantRequest.setFrenchRIB(FrenchRIB.xmlToModel(bAFAGrantRequestXml.getFrenchRIB()));
      
        bAFAGrantRequest.setSubjectBirthCity(bAFAGrantRequestXml.getSubjectBirthCity());
      
        calendar = bAFAGrantRequestXml.getAccountHolderBirthDate();
        if (calendar != null) {
            bAFAGrantRequest.setAccountHolderBirthDate(calendar.getTime());
        }
      
        calendar = bAFAGrantRequestXml.getSubjectBirthDate();
        if (calendar != null) {
            bAFAGrantRequest.setSubjectBirthDate(calendar.getTime());
        }
      
        bAFAGrantRequest.setInternshipInstituteName(bAFAGrantRequestXml.getInternshipInstituteName());
      
        if (bAFAGrantRequestXml.getSubjectAddress() != null)
            bAFAGrantRequest.setSubjectAddress(Address.xmlToModel(bAFAGrantRequestXml.getSubjectAddress()));
      
        bAFAGrantRequest.setAccountHolderLastName(bAFAGrantRequestXml.getAccountHolderLastName());
      
        bAFAGrantRequest.setSubjectPhone(bAFAGrantRequestXml.getSubjectPhone());
      
        bAFAGrantRequest.setSubjectEmail(bAFAGrantRequestXml.getSubjectEmail());
      
        if (bAFAGrantRequestXml.getAccountHolderTitle() != null)
            bAFAGrantRequest.setAccountHolderTitle(fr.cg95.cvq.business.users.TitleType.forString(bAFAGrantRequestXml.getAccountHolderTitle().toString()));
        else
            bAFAGrantRequest.setAccountHolderTitle(fr.cg95.cvq.business.users.TitleType.getDefaultTitleType());
      
        return bAFAGrantRequest;
    }

  
    public final void setAccountHolderFirstName(final String accountHolderFirstName) {
        bAFAGrantRequestData.setAccountHolderFirstName(accountHolderFirstName);
    }

    
    public final String getAccountHolderFirstName() {
        return bAFAGrantRequestData.getAccountHolderFirstName();
    }
  
    public final void setAccountHolderEdemandeId(final String accountHolderEdemandeId) {
        bAFAGrantRequestData.setAccountHolderEdemandeId(accountHolderEdemandeId);
    }

    
    public final String getAccountHolderEdemandeId() {
        return bAFAGrantRequestData.getAccountHolderEdemandeId();
    }
  
    public final void setInternshipInstituteAddress(final fr.cg95.cvq.business.users.Address internshipInstituteAddress) {
        bAFAGrantRequestData.setInternshipInstituteAddress(internshipInstituteAddress);
    }

    
    public final fr.cg95.cvq.business.users.Address getInternshipInstituteAddress() {
        return bAFAGrantRequestData.getInternshipInstituteAddress();
    }
  
    public final void setEdemandeId(final String edemandeId) {
        bAFAGrantRequestData.setEdemandeId(edemandeId);
    }

    
    public final String getEdemandeId() {
        return bAFAGrantRequestData.getEdemandeId();
    }
  
    public final void setInternshipStartDate(final java.util.Date internshipStartDate) {
        bAFAGrantRequestData.setInternshipStartDate(internshipStartDate);
    }

    
    public final java.util.Date getInternshipStartDate() {
        return bAFAGrantRequestData.getInternshipStartDate();
    }
  
    public final void setInternshipEndDate(final java.util.Date internshipEndDate) {
        bAFAGrantRequestData.setInternshipEndDate(internshipEndDate);
    }

    
    public final java.util.Date getInternshipEndDate() {
        return bAFAGrantRequestData.getInternshipEndDate();
    }
  
    public final void setIsSubjectAccountHolder(final Boolean isSubjectAccountHolder) {
        bAFAGrantRequestData.setIsSubjectAccountHolder(isSubjectAccountHolder);
    }

    
    public final Boolean getIsSubjectAccountHolder() {
        return bAFAGrantRequestData.getIsSubjectAccountHolder();
    }
  
    public final void setFrenchRIB(final fr.cg95.cvq.business.users.FrenchRIB frenchRIB) {
        bAFAGrantRequestData.setFrenchRIB(frenchRIB);
    }

    
    public final fr.cg95.cvq.business.users.FrenchRIB getFrenchRIB() {
        return bAFAGrantRequestData.getFrenchRIB();
    }
  
    public final void setSubjectBirthCity(final String subjectBirthCity) {
        bAFAGrantRequestData.setSubjectBirthCity(subjectBirthCity);
    }

    
    public final String getSubjectBirthCity() {
        return bAFAGrantRequestData.getSubjectBirthCity();
    }
  
    public final void setAccountHolderBirthDate(final java.util.Date accountHolderBirthDate) {
        bAFAGrantRequestData.setAccountHolderBirthDate(accountHolderBirthDate);
    }

    
    public final java.util.Date getAccountHolderBirthDate() {
        return bAFAGrantRequestData.getAccountHolderBirthDate();
    }
  
    public final void setSubjectBirthDate(final java.util.Date subjectBirthDate) {
        bAFAGrantRequestData.setSubjectBirthDate(subjectBirthDate);
    }

    
    public final java.util.Date getSubjectBirthDate() {
        return bAFAGrantRequestData.getSubjectBirthDate();
    }
  
    public final void setInternshipInstituteName(final String internshipInstituteName) {
        bAFAGrantRequestData.setInternshipInstituteName(internshipInstituteName);
    }

    
    public final String getInternshipInstituteName() {
        return bAFAGrantRequestData.getInternshipInstituteName();
    }
  
    public final void setSubjectAddress(final fr.cg95.cvq.business.users.Address subjectAddress) {
        bAFAGrantRequestData.setSubjectAddress(subjectAddress);
    }

    
    public final fr.cg95.cvq.business.users.Address getSubjectAddress() {
        return bAFAGrantRequestData.getSubjectAddress();
    }
  
    public final void setAccountHolderLastName(final String accountHolderLastName) {
        bAFAGrantRequestData.setAccountHolderLastName(accountHolderLastName);
    }

    
    public final String getAccountHolderLastName() {
        return bAFAGrantRequestData.getAccountHolderLastName();
    }
  
    public final void setSubjectPhone(final String subjectPhone) {
        bAFAGrantRequestData.setSubjectPhone(subjectPhone);
    }

    
    public final String getSubjectPhone() {
        return bAFAGrantRequestData.getSubjectPhone();
    }
  
    public final void setSubjectEmail(final String subjectEmail) {
        bAFAGrantRequestData.setSubjectEmail(subjectEmail);
    }

    
    public final String getSubjectEmail() {
        return bAFAGrantRequestData.getSubjectEmail();
    }
  
    public final void setAccountHolderTitle(final fr.cg95.cvq.business.users.TitleType accountHolderTitle) {
        bAFAGrantRequestData.setAccountHolderTitle(accountHolderTitle);
    }

    
    public final fr.cg95.cvq.business.users.TitleType getAccountHolderTitle() {
        return bAFAGrantRequestData.getAccountHolderTitle();
    }
  
}
