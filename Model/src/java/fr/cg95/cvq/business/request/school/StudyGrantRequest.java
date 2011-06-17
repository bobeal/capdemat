
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
public class StudyGrantRequest extends Request implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final Map<String, IConditionChecker> conditions = StudyGrantRequestData.conditions;

    @AssertValid(message = "")
    private StudyGrantRequestData studyGrantRequestData;

    public StudyGrantRequest(RequestData requestData, StudyGrantRequestData studyGrantRequestData) {
        super(requestData);
        this.studyGrantRequestData = studyGrantRequestData;
    }

    public StudyGrantRequest() {
        super();
        this.studyGrantRequestData = new StudyGrantRequestData();
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
          getStepStates().put("taxHousehold", stepState);
        
          stepState = new HashMap<String, Object>(4);
          stepState.put("state", "unavailable");
          stepState.put("required", true);
          stepState.put("errorMsg", null);
          stepState.put("invalidFields", new ArrayList<String>());
          getStepStates().put("otherHelps", stepState);
        
          stepState = new HashMap<String, Object>(4);
          stepState.put("state", "unavailable");
          stepState.put("required", true);
          stepState.put("errorMsg", null);
          stepState.put("invalidFields", new ArrayList<String>());
          getStepStates().put("currentStudies", stepState);
        
          stepState = new HashMap<String, Object>(4);
          stepState.put("state", "unavailable");
          stepState.put("required", true);
          stepState.put("errorMsg", null);
          stepState.put("invalidFields", new ArrayList<String>());
          getStepStates().put("calculationElements", stepState);
        
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
    public StudyGrantRequestData getSpecificData() {
        return studyGrantRequestData;
    }

    /**
     * Reserved for RequestDAO !
     */
    public void setSpecificData(StudyGrantRequestData studyGrantRequestData) {
        this.studyGrantRequestData = studyGrantRequestData;
    }

    @Override
    public final String modelToXmlString() {
        StudyGrantRequestDocument object = this.modelToXml();
        XmlOptions opts = new XmlOptions();
        opts.setSavePrettyPrint();
        opts.setSavePrettyPrintIndent(4);
        opts.setUseDefaultNamespace();
        opts.setCharacterEncoding("UTF-8");
        return object.xmlText(opts);
    }

    @Override
    public final StudyGrantRequestDocument modelToXml() {
        
        Calendar calendar = Calendar.getInstance();
        LocalTime localTime = new LocalTime();
        Date date = null;
        StudyGrantRequestDocument studyGrantRequestDoc = StudyGrantRequestDocument.Factory.newInstance();
        StudyGrantRequestDocument.StudyGrantRequest studyGrantRequest = studyGrantRequestDoc.addNewStudyGrantRequest();
        super.fillCommonXmlInfo(studyGrantRequest);
        int i = 0;
          CurrentStudiesInformationsType currentStudiesInformationsTypeCurrentStudiesInformations = studyGrantRequest.addNewCurrentStudiesInformations();
        if (getAbroadInternship() != null)
            currentStudiesInformationsTypeCurrentStudiesInformations.setAbroadInternship(getAbroadInternship().booleanValue());
      
        date = getAbroadInternshipEndDate();
        if (date != null) {
            calendar.setTime(date);
            currentStudiesInformationsTypeCurrentStudiesInformations.setAbroadInternshipEndDate(calendar);
        }
      
        if (getAbroadInternshipSchoolCountry() != null)
            currentStudiesInformationsTypeCurrentStudiesInformations.setAbroadInternshipSchoolCountry(fr.cg95.cvq.xml.common.CountryType.Enum.forString(getAbroadInternshipSchoolCountry().toString()));
      
        currentStudiesInformationsTypeCurrentStudiesInformations.setAbroadInternshipSchoolName(getAbroadInternshipSchoolName());
      
        date = getAbroadInternshipStartDate();
        if (date != null) {
            calendar.setTime(date);
            currentStudiesInformationsTypeCurrentStudiesInformations.setAbroadInternshipStartDate(calendar);
        }
      
        date = getAccountHolderBirthDate();
        if (date != null) {
            calendar.setTime(date);
            studyGrantRequest.setAccountHolderBirthDate(calendar);
        }
      
        studyGrantRequest.setAccountHolderEdemandeId(getAccountHolderEdemandeId());
      
        studyGrantRequest.setAccountHolderFirstName(getAccountHolderFirstName());
      
        studyGrantRequest.setAccountHolderLastName(getAccountHolderLastName());
      
        if (getAccountHolderTitle() != null)
            studyGrantRequest.setAccountHolderTitle(fr.cg95.cvq.xml.common.TitleType.Enum.forString(getAccountHolderTitle().toString()));
        ALevelsInformationsType aLevelsInformationsTypeALevelsInformations = studyGrantRequest.addNewALevelsInformations();
        if (getAlevels() != null)
            aLevelsInformationsTypeALevelsInformations.setAlevels(fr.cg95.cvq.xml.request.school.ALevelsType.Enum.forString(getAlevels().toString()));
      
        aLevelsInformationsTypeALevelsInformations.setAlevelsDate(getAlevelsDate());
      
        if (getBankAccount() != null)
            studyGrantRequest.setBankAccount(BankAccount.modelToXml(getBankAccount()));
        SgrCurrentSchoolType sgrCurrentSchoolTypeCurrentSchool = studyGrantRequest.addNewCurrentSchool();
        sgrCurrentSchoolTypeCurrentSchool.setCurrentSchoolCity(getCurrentSchoolCity());
      
        if (getCurrentSchoolCountry() != null)
            sgrCurrentSchoolTypeCurrentSchool.setCurrentSchoolCountry(fr.cg95.cvq.xml.common.CountryType.Enum.forString(getCurrentSchoolCountry().toString()));
      
        i = 0;
        if (getCurrentSchoolName() != null) {
            fr.cg95.cvq.xml.common.LocalReferentialDataType[] currentSchoolNameTypeTab = new fr.cg95.cvq.xml.common.LocalReferentialDataType[getCurrentSchoolName().size()];
            for (LocalReferentialData object : getCurrentSchoolName()) {
              currentSchoolNameTypeTab[i++] = LocalReferentialData.modelToXml(object);
            }
            sgrCurrentSchoolTypeCurrentSchool.setCurrentSchoolNameArray(currentSchoolNameTypeTab);
        }
      
        sgrCurrentSchoolTypeCurrentSchool.setCurrentSchoolNamePrecision(getCurrentSchoolNamePrecision());
      
        sgrCurrentSchoolTypeCurrentSchool.setCurrentSchoolPostalCode(getCurrentSchoolPostalCode());
      
        if (getCurrentStudiesDiploma() != null)
            currentStudiesInformationsTypeCurrentStudiesInformations.setCurrentStudiesDiploma(fr.cg95.cvq.xml.request.school.CurrentStudiesType.Enum.forString(getCurrentStudiesDiploma().toString()));
      
        if (getCurrentStudiesLevel() != null)
            currentStudiesInformationsTypeCurrentStudiesInformations.setCurrentStudiesLevel(fr.cg95.cvq.xml.request.school.CurrentStudiesLevelType.Enum.forString(getCurrentStudiesLevel().toString()));
      
        if (getDistance() != null)
            studyGrantRequest.setDistance(fr.cg95.cvq.xml.request.school.DistanceType.Enum.forString(getDistance().toString()));
      
        studyGrantRequest.setEdemandeId(getEdemandeId());
      
        if (getHasCROUSHelp() != null)
            studyGrantRequest.setHasCROUSHelp(getHasCROUSHelp().booleanValue());
      
        if (getHasEuropeHelp() != null)
            studyGrantRequest.setHasEuropeHelp(getHasEuropeHelp().booleanValue());
      
        if (getHasOtherHelp() != null)
            studyGrantRequest.setHasOtherHelp(getHasOtherHelp().booleanValue());
      
        if (getHasRegionalCouncilHelp() != null)
            studyGrantRequest.setHasRegionalCouncilHelp(getHasRegionalCouncilHelp().booleanValue());
      
        if (getIsSubjectAccountHolder() != null)
            studyGrantRequest.setIsSubjectAccountHolder(getIsSubjectAccountHolder().booleanValue());
      
        currentStudiesInformationsTypeCurrentStudiesInformations.setOtherStudiesLabel(getOtherStudiesLabel());
      
        if (getSandwichCourses() != null)
            currentStudiesInformationsTypeCurrentStudiesInformations.setSandwichCourses(getSandwichCourses().booleanValue());
        SubjectInformationsType subjectInformationsTypeSubjectInformations = studyGrantRequest.addNewSubjectInformations();
        date = getSubjectBirthDate();
        if (date != null) {
            calendar.setTime(date);
            subjectInformationsTypeSubjectInformations.setSubjectBirthDate(calendar);
        }
      
        if (getSubjectFirstRequest() != null)
            subjectInformationsTypeSubjectInformations.setSubjectFirstRequest(getSubjectFirstRequest().booleanValue());
      
        i = 0;
        if (getTaxHouseholdCity() != null) {
            fr.cg95.cvq.xml.common.LocalReferentialDataType[] taxHouseholdCityTypeTab = new fr.cg95.cvq.xml.common.LocalReferentialDataType[getTaxHouseholdCity().size()];
            for (LocalReferentialData object : getTaxHouseholdCity()) {
              taxHouseholdCityTypeTab[i++] = LocalReferentialData.modelToXml(object);
            }
            studyGrantRequest.setTaxHouseholdCityArray(taxHouseholdCityTypeTab);
        }
      
        studyGrantRequest.setTaxHouseholdCityPrecision(getTaxHouseholdCityPrecision());
      
        studyGrantRequest.setTaxHouseholdFirstName(getTaxHouseholdFirstName());
      
        if (getTaxHouseholdIncome() != null)
            studyGrantRequest.setTaxHouseholdIncome(getTaxHouseholdIncome().doubleValue());
      
        studyGrantRequest.setTaxHouseholdLastName(getTaxHouseholdLastName());
      
        return studyGrantRequestDoc;
    }

    @Override
    public final StudyGrantRequestDocument.StudyGrantRequest modelToXmlRequest() {
        return modelToXml().getStudyGrantRequest();
    }

    public static StudyGrantRequest xmlToModel(StudyGrantRequestDocument studyGrantRequestDoc) {
        StudyGrantRequestDocument.StudyGrantRequest studyGrantRequestXml = studyGrantRequestDoc.getStudyGrantRequest();
        Calendar calendar = Calendar.getInstance();
        LocalTime localTime = new LocalTime();
        List list = new ArrayList();
        StudyGrantRequest studyGrantRequest = new StudyGrantRequest();
        studyGrantRequest.fillCommonModelInfo(studyGrantRequest, studyGrantRequestXml);
        
        studyGrantRequest.setAbroadInternship(Boolean.valueOf(studyGrantRequestXml.getCurrentStudiesInformations().getAbroadInternship()));
      
        calendar = studyGrantRequestXml.getCurrentStudiesInformations().getAbroadInternshipEndDate();
        if (calendar != null) {
            studyGrantRequest.setAbroadInternshipEndDate(calendar.getTime());
        }
      
        if (studyGrantRequestXml.getCurrentStudiesInformations().getAbroadInternshipSchoolCountry() != null)
            studyGrantRequest.setAbroadInternshipSchoolCountry(fr.cg95.cvq.business.users.CountryType.forString(studyGrantRequestXml.getCurrentStudiesInformations().getAbroadInternshipSchoolCountry().toString()));
        else
            studyGrantRequest.setAbroadInternshipSchoolCountry(fr.cg95.cvq.business.users.CountryType.getDefaultCountryType());
      
        studyGrantRequest.setAbroadInternshipSchoolName(studyGrantRequestXml.getCurrentStudiesInformations().getAbroadInternshipSchoolName());
      
        calendar = studyGrantRequestXml.getCurrentStudiesInformations().getAbroadInternshipStartDate();
        if (calendar != null) {
            studyGrantRequest.setAbroadInternshipStartDate(calendar.getTime());
        }
      
        calendar = studyGrantRequestXml.getAccountHolderBirthDate();
        if (calendar != null) {
            studyGrantRequest.setAccountHolderBirthDate(calendar.getTime());
        }
      
        studyGrantRequest.setAccountHolderEdemandeId(studyGrantRequestXml.getAccountHolderEdemandeId());
      
        studyGrantRequest.setAccountHolderFirstName(studyGrantRequestXml.getAccountHolderFirstName());
      
        studyGrantRequest.setAccountHolderLastName(studyGrantRequestXml.getAccountHolderLastName());
      
        if (studyGrantRequestXml.getAccountHolderTitle() != null)
            studyGrantRequest.setAccountHolderTitle(fr.cg95.cvq.business.users.TitleType.forString(studyGrantRequestXml.getAccountHolderTitle().toString()));
        else
            studyGrantRequest.setAccountHolderTitle(fr.cg95.cvq.business.users.TitleType.getDefaultTitleType());
      
        if (studyGrantRequestXml.getALevelsInformations().getAlevels() != null)
            studyGrantRequest.setAlevels(fr.cg95.cvq.business.request.school.ALevelsType.forString(studyGrantRequestXml.getALevelsInformations().getAlevels().toString()));
        else
            studyGrantRequest.setAlevels(fr.cg95.cvq.business.request.school.ALevelsType.getDefaultALevelsType());
      
        studyGrantRequest.setAlevelsDate(studyGrantRequestXml.getALevelsInformations().getAlevelsDate());
      
        if (studyGrantRequestXml.getBankAccount() != null)
            studyGrantRequest.setBankAccount(BankAccount.xmlToModel(studyGrantRequestXml.getBankAccount()));
      
        studyGrantRequest.setCurrentSchoolCity(studyGrantRequestXml.getCurrentSchool().getCurrentSchoolCity());
      
        if (studyGrantRequestXml.getCurrentSchool().getCurrentSchoolCountry() != null)
            studyGrantRequest.setCurrentSchoolCountry(fr.cg95.cvq.business.users.CountryType.forString(studyGrantRequestXml.getCurrentSchool().getCurrentSchoolCountry().toString()));
        else
            studyGrantRequest.setCurrentSchoolCountry(fr.cg95.cvq.business.users.CountryType.getDefaultCountryType());
      
        List<fr.cg95.cvq.business.request.LocalReferentialData> currentSchoolNameList = new ArrayList<fr.cg95.cvq.business.request.LocalReferentialData>(studyGrantRequestXml.getCurrentSchool().sizeOfCurrentSchoolNameArray());
        for (LocalReferentialDataType object : studyGrantRequestXml.getCurrentSchool().getCurrentSchoolNameArray()) {
            currentSchoolNameList.add(fr.cg95.cvq.business.request.LocalReferentialData.xmlToModel(object));
        }
        studyGrantRequest.setCurrentSchoolName(currentSchoolNameList);
      
        studyGrantRequest.setCurrentSchoolNamePrecision(studyGrantRequestXml.getCurrentSchool().getCurrentSchoolNamePrecision());
      
        studyGrantRequest.setCurrentSchoolPostalCode(studyGrantRequestXml.getCurrentSchool().getCurrentSchoolPostalCode());
      
        if (studyGrantRequestXml.getCurrentStudiesInformations().getCurrentStudiesDiploma() != null)
            studyGrantRequest.setCurrentStudiesDiploma(fr.cg95.cvq.business.request.school.CurrentStudiesType.forString(studyGrantRequestXml.getCurrentStudiesInformations().getCurrentStudiesDiploma().toString()));
        else
            studyGrantRequest.setCurrentStudiesDiploma(fr.cg95.cvq.business.request.school.CurrentStudiesType.getDefaultCurrentStudiesType());
      
        if (studyGrantRequestXml.getCurrentStudiesInformations().getCurrentStudiesLevel() != null)
            studyGrantRequest.setCurrentStudiesLevel(fr.cg95.cvq.business.request.school.CurrentStudiesLevelType.forString(studyGrantRequestXml.getCurrentStudiesInformations().getCurrentStudiesLevel().toString()));
        else
            studyGrantRequest.setCurrentStudiesLevel(fr.cg95.cvq.business.request.school.CurrentStudiesLevelType.getDefaultCurrentStudiesLevelType());
      
        if (studyGrantRequestXml.getDistance() != null)
            studyGrantRequest.setDistance(fr.cg95.cvq.business.request.school.DistanceType.forString(studyGrantRequestXml.getDistance().toString()));
        else
            studyGrantRequest.setDistance(fr.cg95.cvq.business.request.school.DistanceType.getDefaultDistanceType());
      
        studyGrantRequest.setEdemandeId(studyGrantRequestXml.getEdemandeId());
      
        studyGrantRequest.setHasCROUSHelp(Boolean.valueOf(studyGrantRequestXml.getHasCROUSHelp()));
      
        studyGrantRequest.setHasEuropeHelp(Boolean.valueOf(studyGrantRequestXml.getHasEuropeHelp()));
      
        studyGrantRequest.setHasOtherHelp(Boolean.valueOf(studyGrantRequestXml.getHasOtherHelp()));
      
        studyGrantRequest.setHasRegionalCouncilHelp(Boolean.valueOf(studyGrantRequestXml.getHasRegionalCouncilHelp()));
      
        studyGrantRequest.setIsSubjectAccountHolder(Boolean.valueOf(studyGrantRequestXml.getIsSubjectAccountHolder()));
      
        studyGrantRequest.setOtherStudiesLabel(studyGrantRequestXml.getCurrentStudiesInformations().getOtherStudiesLabel());
      
        studyGrantRequest.setSandwichCourses(Boolean.valueOf(studyGrantRequestXml.getCurrentStudiesInformations().getSandwichCourses()));
      
        calendar = studyGrantRequestXml.getSubjectInformations().getSubjectBirthDate();
        if (calendar != null) {
            studyGrantRequest.setSubjectBirthDate(calendar.getTime());
        }
      
        studyGrantRequest.setSubjectFirstRequest(Boolean.valueOf(studyGrantRequestXml.getSubjectInformations().getSubjectFirstRequest()));
      
        List<fr.cg95.cvq.business.request.LocalReferentialData> taxHouseholdCityList = new ArrayList<fr.cg95.cvq.business.request.LocalReferentialData>(studyGrantRequestXml.sizeOfTaxHouseholdCityArray());
        for (LocalReferentialDataType object : studyGrantRequestXml.getTaxHouseholdCityArray()) {
            taxHouseholdCityList.add(fr.cg95.cvq.business.request.LocalReferentialData.xmlToModel(object));
        }
        studyGrantRequest.setTaxHouseholdCity(taxHouseholdCityList);
      
        studyGrantRequest.setTaxHouseholdCityPrecision(studyGrantRequestXml.getTaxHouseholdCityPrecision());
      
        studyGrantRequest.setTaxHouseholdFirstName(studyGrantRequestXml.getTaxHouseholdFirstName());
      
        studyGrantRequest.setTaxHouseholdIncome(new Double(studyGrantRequestXml.getTaxHouseholdIncome()));
      
        studyGrantRequest.setTaxHouseholdLastName(studyGrantRequestXml.getTaxHouseholdLastName());
      
        return studyGrantRequest;
    }

    @Override
    public StudyGrantRequest clone() {
        StudyGrantRequest clone = new StudyGrantRequest(getRequestData().clone(), studyGrantRequestData.clone());
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
          clone.getStepStates().put("taxHousehold", stepState);
        
          stepState = new HashMap<String, Object>(4);
          stepState.put("state", "unavailable");
          stepState.put("required", true);
          stepState.put("errorMsg", null);
          stepState.put("invalidFields", new ArrayList<String>());
          clone.getStepStates().put("otherHelps", stepState);
        
          stepState = new HashMap<String, Object>(4);
          stepState.put("state", "unavailable");
          stepState.put("required", true);
          stepState.put("errorMsg", null);
          stepState.put("invalidFields", new ArrayList<String>());
          clone.getStepStates().put("currentStudies", stepState);
        
          stepState = new HashMap<String, Object>(4);
          stepState.put("state", "unavailable");
          stepState.put("required", true);
          stepState.put("errorMsg", null);
          stepState.put("invalidFields", new ArrayList<String>());
          clone.getStepStates().put("calculationElements", stepState);
        
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

  
    public final void setAbroadInternship(final Boolean abroadInternship) {
        studyGrantRequestData.setAbroadInternship(abroadInternship);
    }

    
    public final Boolean getAbroadInternship() {
        return studyGrantRequestData.getAbroadInternship();
    }
  
    public final void setAbroadInternshipEndDate(final java.util.Date abroadInternshipEndDate) {
        studyGrantRequestData.setAbroadInternshipEndDate(abroadInternshipEndDate);
    }

    
    public final java.util.Date getAbroadInternshipEndDate() {
        return studyGrantRequestData.getAbroadInternshipEndDate();
    }
  
    public final void setAbroadInternshipSchoolCountry(final fr.cg95.cvq.business.users.CountryType abroadInternshipSchoolCountry) {
        studyGrantRequestData.setAbroadInternshipSchoolCountry(abroadInternshipSchoolCountry);
    }

    
    public final fr.cg95.cvq.business.users.CountryType getAbroadInternshipSchoolCountry() {
        return studyGrantRequestData.getAbroadInternshipSchoolCountry();
    }
  
    public final void setAbroadInternshipSchoolName(final String abroadInternshipSchoolName) {
        studyGrantRequestData.setAbroadInternshipSchoolName(abroadInternshipSchoolName);
    }

    
    public final String getAbroadInternshipSchoolName() {
        return studyGrantRequestData.getAbroadInternshipSchoolName();
    }
  
    public final void setAbroadInternshipStartDate(final java.util.Date abroadInternshipStartDate) {
        studyGrantRequestData.setAbroadInternshipStartDate(abroadInternshipStartDate);
    }

    
    public final java.util.Date getAbroadInternshipStartDate() {
        return studyGrantRequestData.getAbroadInternshipStartDate();
    }
  
    public final void setAccountHolderBirthDate(final java.util.Date accountHolderBirthDate) {
        studyGrantRequestData.setAccountHolderBirthDate(accountHolderBirthDate);
    }

    
    public final java.util.Date getAccountHolderBirthDate() {
        return studyGrantRequestData.getAccountHolderBirthDate();
    }
  
    public final void setAccountHolderEdemandeId(final String accountHolderEdemandeId) {
        studyGrantRequestData.setAccountHolderEdemandeId(accountHolderEdemandeId);
    }

    
    public final String getAccountHolderEdemandeId() {
        return studyGrantRequestData.getAccountHolderEdemandeId();
    }
  
    public final void setAccountHolderFirstName(final String accountHolderFirstName) {
        studyGrantRequestData.setAccountHolderFirstName(accountHolderFirstName);
    }

    
    public final String getAccountHolderFirstName() {
        return studyGrantRequestData.getAccountHolderFirstName();
    }
  
    public final void setAccountHolderLastName(final String accountHolderLastName) {
        studyGrantRequestData.setAccountHolderLastName(accountHolderLastName);
    }

    
    public final String getAccountHolderLastName() {
        return studyGrantRequestData.getAccountHolderLastName();
    }
  
    public final void setAccountHolderTitle(final fr.cg95.cvq.business.users.TitleType accountHolderTitle) {
        studyGrantRequestData.setAccountHolderTitle(accountHolderTitle);
    }

    
    public final fr.cg95.cvq.business.users.TitleType getAccountHolderTitle() {
        return studyGrantRequestData.getAccountHolderTitle();
    }
  
    public final void setAlevels(final fr.cg95.cvq.business.request.school.ALevelsType alevels) {
        studyGrantRequestData.setAlevels(alevels);
    }

    
    public final fr.cg95.cvq.business.request.school.ALevelsType getAlevels() {
        return studyGrantRequestData.getAlevels();
    }
  
    public final void setAlevelsDate(final String alevelsDate) {
        studyGrantRequestData.setAlevelsDate(alevelsDate);
    }

    
    public final String getAlevelsDate() {
        return studyGrantRequestData.getAlevelsDate();
    }
  
    public final void setBankAccount(final fr.cg95.cvq.business.users.BankAccount bankAccount) {
        studyGrantRequestData.setBankAccount(bankAccount);
    }

    
    public final fr.cg95.cvq.business.users.BankAccount getBankAccount() {
        return studyGrantRequestData.getBankAccount();
    }
  
    public final void setCurrentSchoolCity(final String currentSchoolCity) {
        studyGrantRequestData.setCurrentSchoolCity(currentSchoolCity);
    }

    
    public final String getCurrentSchoolCity() {
        return studyGrantRequestData.getCurrentSchoolCity();
    }
  
    public final void setCurrentSchoolCountry(final fr.cg95.cvq.business.users.CountryType currentSchoolCountry) {
        studyGrantRequestData.setCurrentSchoolCountry(currentSchoolCountry);
    }

    
    public final fr.cg95.cvq.business.users.CountryType getCurrentSchoolCountry() {
        return studyGrantRequestData.getCurrentSchoolCountry();
    }
  
    public final void setCurrentSchoolName(final List<fr.cg95.cvq.business.request.LocalReferentialData> currentSchoolName) {
        studyGrantRequestData.setCurrentSchoolName(currentSchoolName);
    }

    
    public final List<fr.cg95.cvq.business.request.LocalReferentialData> getCurrentSchoolName() {
        return studyGrantRequestData.getCurrentSchoolName();
    }
  
    public final void setCurrentSchoolNamePrecision(final String currentSchoolNamePrecision) {
        studyGrantRequestData.setCurrentSchoolNamePrecision(currentSchoolNamePrecision);
    }

    
    public final String getCurrentSchoolNamePrecision() {
        return studyGrantRequestData.getCurrentSchoolNamePrecision();
    }
  
    public final void setCurrentSchoolPostalCode(final String currentSchoolPostalCode) {
        studyGrantRequestData.setCurrentSchoolPostalCode(currentSchoolPostalCode);
    }

    
    public final String getCurrentSchoolPostalCode() {
        return studyGrantRequestData.getCurrentSchoolPostalCode();
    }
  
    public final void setCurrentStudiesDiploma(final fr.cg95.cvq.business.request.school.CurrentStudiesType currentStudiesDiploma) {
        studyGrantRequestData.setCurrentStudiesDiploma(currentStudiesDiploma);
    }

    
    public final fr.cg95.cvq.business.request.school.CurrentStudiesType getCurrentStudiesDiploma() {
        return studyGrantRequestData.getCurrentStudiesDiploma();
    }
  
    public final void setCurrentStudiesLevel(final fr.cg95.cvq.business.request.school.CurrentStudiesLevelType currentStudiesLevel) {
        studyGrantRequestData.setCurrentStudiesLevel(currentStudiesLevel);
    }

    
    public final fr.cg95.cvq.business.request.school.CurrentStudiesLevelType getCurrentStudiesLevel() {
        return studyGrantRequestData.getCurrentStudiesLevel();
    }
  
    public final void setDistance(final fr.cg95.cvq.business.request.school.DistanceType distance) {
        studyGrantRequestData.setDistance(distance);
    }

    
    public final fr.cg95.cvq.business.request.school.DistanceType getDistance() {
        return studyGrantRequestData.getDistance();
    }
  
    public final void setEdemandeId(final String edemandeId) {
        studyGrantRequestData.setEdemandeId(edemandeId);
    }

    
    public final String getEdemandeId() {
        return studyGrantRequestData.getEdemandeId();
    }
  
    public final void setHasCROUSHelp(final Boolean hasCROUSHelp) {
        studyGrantRequestData.setHasCROUSHelp(hasCROUSHelp);
    }

    
    public final Boolean getHasCROUSHelp() {
        return studyGrantRequestData.getHasCROUSHelp();
    }
  
    public final void setHasEuropeHelp(final Boolean hasEuropeHelp) {
        studyGrantRequestData.setHasEuropeHelp(hasEuropeHelp);
    }

    
    public final Boolean getHasEuropeHelp() {
        return studyGrantRequestData.getHasEuropeHelp();
    }
  
    public final void setHasOtherHelp(final Boolean hasOtherHelp) {
        studyGrantRequestData.setHasOtherHelp(hasOtherHelp);
    }

    
    public final Boolean getHasOtherHelp() {
        return studyGrantRequestData.getHasOtherHelp();
    }
  
    public final void setHasRegionalCouncilHelp(final Boolean hasRegionalCouncilHelp) {
        studyGrantRequestData.setHasRegionalCouncilHelp(hasRegionalCouncilHelp);
    }

    
    public final Boolean getHasRegionalCouncilHelp() {
        return studyGrantRequestData.getHasRegionalCouncilHelp();
    }
  
    public final void setIsSubjectAccountHolder(final Boolean isSubjectAccountHolder) {
        studyGrantRequestData.setIsSubjectAccountHolder(isSubjectAccountHolder);
    }

    
    public final Boolean getIsSubjectAccountHolder() {
        return studyGrantRequestData.getIsSubjectAccountHolder();
    }
  
    public final void setOtherStudiesLabel(final String otherStudiesLabel) {
        studyGrantRequestData.setOtherStudiesLabel(otherStudiesLabel);
    }

    
    public final String getOtherStudiesLabel() {
        return studyGrantRequestData.getOtherStudiesLabel();
    }
  
    public final void setSandwichCourses(final Boolean sandwichCourses) {
        studyGrantRequestData.setSandwichCourses(sandwichCourses);
    }

    
    public final Boolean getSandwichCourses() {
        return studyGrantRequestData.getSandwichCourses();
    }
  
    public final void setSubjectBirthDate(final java.util.Date subjectBirthDate) {
        studyGrantRequestData.setSubjectBirthDate(subjectBirthDate);
    }

    
    public final java.util.Date getSubjectBirthDate() {
        return studyGrantRequestData.getSubjectBirthDate();
    }
  
    public final void setSubjectFirstRequest(final Boolean subjectFirstRequest) {
        studyGrantRequestData.setSubjectFirstRequest(subjectFirstRequest);
    }

    
    public final Boolean getSubjectFirstRequest() {
        return studyGrantRequestData.getSubjectFirstRequest();
    }
  
    public final void setTaxHouseholdCity(final List<fr.cg95.cvq.business.request.LocalReferentialData> taxHouseholdCity) {
        studyGrantRequestData.setTaxHouseholdCity(taxHouseholdCity);
    }

    
    public final List<fr.cg95.cvq.business.request.LocalReferentialData> getTaxHouseholdCity() {
        return studyGrantRequestData.getTaxHouseholdCity();
    }
  
    public final void setTaxHouseholdCityPrecision(final String taxHouseholdCityPrecision) {
        studyGrantRequestData.setTaxHouseholdCityPrecision(taxHouseholdCityPrecision);
    }

    
    public final String getTaxHouseholdCityPrecision() {
        return studyGrantRequestData.getTaxHouseholdCityPrecision();
    }
  
    public final void setTaxHouseholdFirstName(final String taxHouseholdFirstName) {
        studyGrantRequestData.setTaxHouseholdFirstName(taxHouseholdFirstName);
    }

    
    public final String getTaxHouseholdFirstName() {
        return studyGrantRequestData.getTaxHouseholdFirstName();
    }
  
    public final void setTaxHouseholdIncome(final Double taxHouseholdIncome) {
        studyGrantRequestData.setTaxHouseholdIncome(taxHouseholdIncome);
    }

    
    public final Double getTaxHouseholdIncome() {
        return studyGrantRequestData.getTaxHouseholdIncome();
    }
  
    public final void setTaxHouseholdLastName(final String taxHouseholdLastName) {
        studyGrantRequestData.setTaxHouseholdLastName(taxHouseholdLastName);
    }

    
    public final String getTaxHouseholdLastName() {
        return studyGrantRequestData.getTaxHouseholdLastName();
    }
  
}
