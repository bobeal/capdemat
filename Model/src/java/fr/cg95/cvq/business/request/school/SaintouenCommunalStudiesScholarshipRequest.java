
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
public class SaintouenCommunalStudiesScholarshipRequest extends Request implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final Map<String, IConditionChecker> conditions = SaintouenCommunalStudiesScholarshipRequestData.conditions;

    @AssertValid(message = "")
    private SaintouenCommunalStudiesScholarshipRequestData saintouenCommunalStudiesScholarshipRequestData;

    public SaintouenCommunalStudiesScholarshipRequest(RequestData requestData, SaintouenCommunalStudiesScholarshipRequestData saintouenCommunalStudiesScholarshipRequestData) {
        super(requestData);
        this.saintouenCommunalStudiesScholarshipRequestData = saintouenCommunalStudiesScholarshipRequestData;
    }

    public SaintouenCommunalStudiesScholarshipRequest() {
        super();
        this.saintouenCommunalStudiesScholarshipRequestData = new SaintouenCommunalStudiesScholarshipRequestData();
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
          getStepStates().put("schoolingInformation", stepState);
        
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
    public SaintouenCommunalStudiesScholarshipRequestData getSpecificData() {
        return saintouenCommunalStudiesScholarshipRequestData;
    }

    /**
     * Reserved for RequestDAO !
     */
    public void setSpecificData(SaintouenCommunalStudiesScholarshipRequestData saintouenCommunalStudiesScholarshipRequestData) {
        this.saintouenCommunalStudiesScholarshipRequestData = saintouenCommunalStudiesScholarshipRequestData;
    }

    @Override
    public final String modelToXmlString() {
        SaintouenCommunalStudiesScholarshipRequestDocument object = this.modelToXml();
        XmlOptions opts = new XmlOptions();
        opts.setSavePrettyPrint();
        opts.setSavePrettyPrintIndent(4);
        opts.setUseDefaultNamespace();
        opts.setCharacterEncoding("UTF-8");
        return object.xmlText(opts);
    }

    @Override
    public final SaintouenCommunalStudiesScholarshipRequestDocument modelToXml() {
        
        Calendar calendar = Calendar.getInstance();
        LocalTime localTime = new LocalTime();
        Date date = null;
        SaintouenCommunalStudiesScholarshipRequestDocument saintouenCommunalStudiesScholarshipRequestDoc = SaintouenCommunalStudiesScholarshipRequestDocument.Factory.newInstance();
        SaintouenCommunalStudiesScholarshipRequestDocument.SaintouenCommunalStudiesScholarshipRequest saintouenCommunalStudiesScholarshipRequest = saintouenCommunalStudiesScholarshipRequestDoc.addNewSaintouenCommunalStudiesScholarshipRequest();
        super.fillCommonXmlInfo(saintouenCommunalStudiesScholarshipRequest);
        int i = 0;
        
        date = getAccountHolderBirthDate();
        if (date != null) {
            calendar.setTime(date);
            saintouenCommunalStudiesScholarshipRequest.setAccountHolderBirthDate(calendar);
        }
      
        saintouenCommunalStudiesScholarshipRequest.setAccountHolderFirstName(getAccountHolderFirstName());
      
        saintouenCommunalStudiesScholarshipRequest.setAccountHolderLastName(getAccountHolderLastName());
      
        if (getAccountHolderTitle() != null)
            saintouenCommunalStudiesScholarshipRequest.setAccountHolderTitle(fr.cg95.cvq.xml.common.TitleType.Enum.forString(getAccountHolderTitle().getLegacyLabel()));
      
        if (getBankAccount() != null)
            saintouenCommunalStudiesScholarshipRequest.setBankAccount(BankAccount.modelToXml(getBankAccount()));
      
        if (getIsOtherSituation() != null)
            saintouenCommunalStudiesScholarshipRequest.setIsOtherSituation(fr.cg95.cvq.xml.request.school.SaintOuenSituationLogementType.Enum.forString(getIsOtherSituation().getLegacyLabel()));
      
        if (getIsSubjectAccountHolder() != null)
            saintouenCommunalStudiesScholarshipRequest.setIsSubjectAccountHolder(getIsSubjectAccountHolder().booleanValue());
      
        saintouenCommunalStudiesScholarshipRequest.setMontantBourse(getMontantBourse());
      
        if (getSaintOuenCurrentStudiesLevel() != null)
            saintouenCommunalStudiesScholarshipRequest.setSaintOuenCurrentStudiesLevel(fr.cg95.cvq.xml.request.school.SaintOuenCurrentStudiesLevelType.Enum.forString(getSaintOuenCurrentStudiesLevel().getLegacyLabel()));
      
        saintouenCommunalStudiesScholarshipRequest.setSaintOuenEstablishmentLabel(getSaintOuenEstablishmentLabel());
      
        if (getSaintOuenIsInOtherStudies() != null)
            saintouenCommunalStudiesScholarshipRequest.setSaintOuenIsInOtherStudies(fr.cg95.cvq.xml.request.school.SaintOuenCurrentStudiesType.Enum.forString(getSaintOuenIsInOtherStudies().getLegacyLabel()));
      
        saintouenCommunalStudiesScholarshipRequest.setSaintOuenOtherSituationDetails(getSaintOuenOtherSituationDetails());
      
        saintouenCommunalStudiesScholarshipRequest.setSaintOuenOtherStudiesLabel(getSaintOuenOtherStudiesLabel());
      
        date = getSubjectBirthDate();
        if (date != null) {
            calendar.setTime(date);
            saintouenCommunalStudiesScholarshipRequest.setSubjectBirthDate(calendar);
        }
      
        date = getSubjectDomiciliationDate();
        if (date != null) {
            calendar.setTime(date);
            saintouenCommunalStudiesScholarshipRequest.setSubjectDomiciliationDate(calendar);
        }
      
        return saintouenCommunalStudiesScholarshipRequestDoc;
    }

    @Override
    public final SaintouenCommunalStudiesScholarshipRequestDocument.SaintouenCommunalStudiesScholarshipRequest modelToXmlRequest() {
        return modelToXml().getSaintouenCommunalStudiesScholarshipRequest();
    }

    public static SaintouenCommunalStudiesScholarshipRequest xmlToModel(SaintouenCommunalStudiesScholarshipRequestDocument saintouenCommunalStudiesScholarshipRequestDoc) {
        SaintouenCommunalStudiesScholarshipRequestDocument.SaintouenCommunalStudiesScholarshipRequest saintouenCommunalStudiesScholarshipRequestXml = saintouenCommunalStudiesScholarshipRequestDoc.getSaintouenCommunalStudiesScholarshipRequest();
        Calendar calendar = Calendar.getInstance();
        LocalTime localTime = new LocalTime();
        List list = new ArrayList();
        SaintouenCommunalStudiesScholarshipRequest saintouenCommunalStudiesScholarshipRequest = new SaintouenCommunalStudiesScholarshipRequest();
        saintouenCommunalStudiesScholarshipRequest.fillCommonModelInfo(saintouenCommunalStudiesScholarshipRequest, saintouenCommunalStudiesScholarshipRequestXml);
        
        calendar = saintouenCommunalStudiesScholarshipRequestXml.getAccountHolderBirthDate();
        if (calendar != null) {
            saintouenCommunalStudiesScholarshipRequest.setAccountHolderBirthDate(calendar.getTime());
        }
      
        saintouenCommunalStudiesScholarshipRequest.setAccountHolderFirstName(saintouenCommunalStudiesScholarshipRequestXml.getAccountHolderFirstName());
      
        saintouenCommunalStudiesScholarshipRequest.setAccountHolderLastName(saintouenCommunalStudiesScholarshipRequestXml.getAccountHolderLastName());
      
        if (saintouenCommunalStudiesScholarshipRequestXml.getAccountHolderTitle() != null)
            saintouenCommunalStudiesScholarshipRequest.setAccountHolderTitle(fr.cg95.cvq.business.users.TitleType.forString(saintouenCommunalStudiesScholarshipRequestXml.getAccountHolderTitle().toString()));
        else
            saintouenCommunalStudiesScholarshipRequest.setAccountHolderTitle(fr.cg95.cvq.business.users.TitleType.getDefaultTitleType());
      
        if (saintouenCommunalStudiesScholarshipRequestXml.getBankAccount() != null)
            saintouenCommunalStudiesScholarshipRequest.setBankAccount(BankAccount.xmlToModel(saintouenCommunalStudiesScholarshipRequestXml.getBankAccount()));
      
        if (saintouenCommunalStudiesScholarshipRequestXml.getIsOtherSituation() != null)
            saintouenCommunalStudiesScholarshipRequest.setIsOtherSituation(fr.cg95.cvq.business.request.school.SaintOuenSituationLogementType.forString(saintouenCommunalStudiesScholarshipRequestXml.getIsOtherSituation().toString()));
        else
            saintouenCommunalStudiesScholarshipRequest.setIsOtherSituation(fr.cg95.cvq.business.request.school.SaintOuenSituationLogementType.getDefaultSaintOuenSituationLogementType());
      
        saintouenCommunalStudiesScholarshipRequest.setIsSubjectAccountHolder(Boolean.valueOf(saintouenCommunalStudiesScholarshipRequestXml.getIsSubjectAccountHolder()));
      
        saintouenCommunalStudiesScholarshipRequest.setMontantBourse(saintouenCommunalStudiesScholarshipRequestXml.getMontantBourse());
      
        if (saintouenCommunalStudiesScholarshipRequestXml.getSaintOuenCurrentStudiesLevel() != null)
            saintouenCommunalStudiesScholarshipRequest.setSaintOuenCurrentStudiesLevel(fr.cg95.cvq.business.request.school.SaintOuenCurrentStudiesLevelType.forString(saintouenCommunalStudiesScholarshipRequestXml.getSaintOuenCurrentStudiesLevel().toString()));
        else
            saintouenCommunalStudiesScholarshipRequest.setSaintOuenCurrentStudiesLevel(fr.cg95.cvq.business.request.school.SaintOuenCurrentStudiesLevelType.getDefaultSaintOuenCurrentStudiesLevelType());
      
        saintouenCommunalStudiesScholarshipRequest.setSaintOuenEstablishmentLabel(saintouenCommunalStudiesScholarshipRequestXml.getSaintOuenEstablishmentLabel());
      
        if (saintouenCommunalStudiesScholarshipRequestXml.getSaintOuenIsInOtherStudies() != null)
            saintouenCommunalStudiesScholarshipRequest.setSaintOuenIsInOtherStudies(fr.cg95.cvq.business.request.school.SaintOuenCurrentStudiesType.forString(saintouenCommunalStudiesScholarshipRequestXml.getSaintOuenIsInOtherStudies().toString()));
        else
            saintouenCommunalStudiesScholarshipRequest.setSaintOuenIsInOtherStudies(fr.cg95.cvq.business.request.school.SaintOuenCurrentStudiesType.getDefaultSaintOuenCurrentStudiesType());
      
        saintouenCommunalStudiesScholarshipRequest.setSaintOuenOtherSituationDetails(saintouenCommunalStudiesScholarshipRequestXml.getSaintOuenOtherSituationDetails());
      
        saintouenCommunalStudiesScholarshipRequest.setSaintOuenOtherStudiesLabel(saintouenCommunalStudiesScholarshipRequestXml.getSaintOuenOtherStudiesLabel());
      
        calendar = saintouenCommunalStudiesScholarshipRequestXml.getSubjectBirthDate();
        if (calendar != null) {
            saintouenCommunalStudiesScholarshipRequest.setSubjectBirthDate(calendar.getTime());
        }
      
        calendar = saintouenCommunalStudiesScholarshipRequestXml.getSubjectDomiciliationDate();
        if (calendar != null) {
            saintouenCommunalStudiesScholarshipRequest.setSubjectDomiciliationDate(calendar.getTime());
        }
      
        return saintouenCommunalStudiesScholarshipRequest;
    }

    @Override
    public SaintouenCommunalStudiesScholarshipRequest clone() {
        SaintouenCommunalStudiesScholarshipRequest clone = new SaintouenCommunalStudiesScholarshipRequest(getRequestData().clone(), saintouenCommunalStudiesScholarshipRequestData.clone());
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
          clone.getStepStates().put("schoolingInformation", stepState);
        
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
        saintouenCommunalStudiesScholarshipRequestData.setAccountHolderBirthDate(accountHolderBirthDate);
    }

    
    public final java.util.Date getAccountHolderBirthDate() {
        return saintouenCommunalStudiesScholarshipRequestData.getAccountHolderBirthDate();
    }
  
    public final void setAccountHolderFirstName(final String accountHolderFirstName) {
        saintouenCommunalStudiesScholarshipRequestData.setAccountHolderFirstName(accountHolderFirstName);
    }

    
    public final String getAccountHolderFirstName() {
        return saintouenCommunalStudiesScholarshipRequestData.getAccountHolderFirstName();
    }
  
    public final void setAccountHolderLastName(final String accountHolderLastName) {
        saintouenCommunalStudiesScholarshipRequestData.setAccountHolderLastName(accountHolderLastName);
    }

    
    public final String getAccountHolderLastName() {
        return saintouenCommunalStudiesScholarshipRequestData.getAccountHolderLastName();
    }
  
    public final void setAccountHolderTitle(final fr.cg95.cvq.business.users.TitleType accountHolderTitle) {
        saintouenCommunalStudiesScholarshipRequestData.setAccountHolderTitle(accountHolderTitle);
    }

    
    public final fr.cg95.cvq.business.users.TitleType getAccountHolderTitle() {
        return saintouenCommunalStudiesScholarshipRequestData.getAccountHolderTitle();
    }
  
    public final void setBankAccount(final fr.cg95.cvq.business.users.BankAccount bankAccount) {
        saintouenCommunalStudiesScholarshipRequestData.setBankAccount(bankAccount);
    }

    
    public final fr.cg95.cvq.business.users.BankAccount getBankAccount() {
        return saintouenCommunalStudiesScholarshipRequestData.getBankAccount();
    }
  
    public final void setIsOtherSituation(final fr.cg95.cvq.business.request.school.SaintOuenSituationLogementType isOtherSituation) {
        saintouenCommunalStudiesScholarshipRequestData.setIsOtherSituation(isOtherSituation);
    }

    
    public final fr.cg95.cvq.business.request.school.SaintOuenSituationLogementType getIsOtherSituation() {
        return saintouenCommunalStudiesScholarshipRequestData.getIsOtherSituation();
    }
  
    public final void setIsSubjectAccountHolder(final Boolean isSubjectAccountHolder) {
        saintouenCommunalStudiesScholarshipRequestData.setIsSubjectAccountHolder(isSubjectAccountHolder);
    }

    
    public final Boolean getIsSubjectAccountHolder() {
        return saintouenCommunalStudiesScholarshipRequestData.getIsSubjectAccountHolder();
    }
  
    public final void setMontantBourse(final String montantBourse) {
        saintouenCommunalStudiesScholarshipRequestData.setMontantBourse(montantBourse);
    }

    
    public final String getMontantBourse() {
        return saintouenCommunalStudiesScholarshipRequestData.getMontantBourse();
    }
  
    public final void setSaintOuenCurrentStudiesLevel(final fr.cg95.cvq.business.request.school.SaintOuenCurrentStudiesLevelType saintOuenCurrentStudiesLevel) {
        saintouenCommunalStudiesScholarshipRequestData.setSaintOuenCurrentStudiesLevel(saintOuenCurrentStudiesLevel);
    }

    
    public final fr.cg95.cvq.business.request.school.SaintOuenCurrentStudiesLevelType getSaintOuenCurrentStudiesLevel() {
        return saintouenCommunalStudiesScholarshipRequestData.getSaintOuenCurrentStudiesLevel();
    }
  
    public final void setSaintOuenEstablishmentLabel(final String saintOuenEstablishmentLabel) {
        saintouenCommunalStudiesScholarshipRequestData.setSaintOuenEstablishmentLabel(saintOuenEstablishmentLabel);
    }

    
    public final String getSaintOuenEstablishmentLabel() {
        return saintouenCommunalStudiesScholarshipRequestData.getSaintOuenEstablishmentLabel();
    }
  
    public final void setSaintOuenIsInOtherStudies(final fr.cg95.cvq.business.request.school.SaintOuenCurrentStudiesType saintOuenIsInOtherStudies) {
        saintouenCommunalStudiesScholarshipRequestData.setSaintOuenIsInOtherStudies(saintOuenIsInOtherStudies);
    }

    
    public final fr.cg95.cvq.business.request.school.SaintOuenCurrentStudiesType getSaintOuenIsInOtherStudies() {
        return saintouenCommunalStudiesScholarshipRequestData.getSaintOuenIsInOtherStudies();
    }
  
    public final void setSaintOuenOtherSituationDetails(final String saintOuenOtherSituationDetails) {
        saintouenCommunalStudiesScholarshipRequestData.setSaintOuenOtherSituationDetails(saintOuenOtherSituationDetails);
    }

    
    public final String getSaintOuenOtherSituationDetails() {
        return saintouenCommunalStudiesScholarshipRequestData.getSaintOuenOtherSituationDetails();
    }
  
    public final void setSaintOuenOtherStudiesLabel(final String saintOuenOtherStudiesLabel) {
        saintouenCommunalStudiesScholarshipRequestData.setSaintOuenOtherStudiesLabel(saintOuenOtherStudiesLabel);
    }

    
    public final String getSaintOuenOtherStudiesLabel() {
        return saintouenCommunalStudiesScholarshipRequestData.getSaintOuenOtherStudiesLabel();
    }
  
    public final void setSubjectBirthDate(final java.util.Date subjectBirthDate) {
        saintouenCommunalStudiesScholarshipRequestData.setSubjectBirthDate(subjectBirthDate);
    }

    
    public final java.util.Date getSubjectBirthDate() {
        return saintouenCommunalStudiesScholarshipRequestData.getSubjectBirthDate();
    }
  
    public final void setSubjectDomiciliationDate(final java.util.Date subjectDomiciliationDate) {
        saintouenCommunalStudiesScholarshipRequestData.setSubjectDomiciliationDate(subjectDomiciliationDate);
    }

    
    public final java.util.Date getSubjectDomiciliationDate() {
        return saintouenCommunalStudiesScholarshipRequestData.getSubjectDomiciliationDate();
    }
  
}
