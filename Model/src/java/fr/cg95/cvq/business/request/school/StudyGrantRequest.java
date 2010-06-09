
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
          stepState.put("state", "uncomplete");
          stepState.put("required", true);
          stepState.put("errorMsg", null);
          stepState.put("invalidFields", new ArrayList<String>());
          getStepStates().put("taxHousehold", stepState);
        
          stepState = new HashMap<String, Object>(4);
          stepState.put("state", "uncomplete");
          stepState.put("required", true);
          stepState.put("errorMsg", null);
          stepState.put("invalidFields", new ArrayList<String>());
          getStepStates().put("otherHelps", stepState);
        
          stepState = new HashMap<String, Object>(4);
          stepState.put("state", "uncomplete");
          stepState.put("required", true);
          stepState.put("errorMsg", null);
          stepState.put("invalidFields", new ArrayList<String>());
          getStepStates().put("currentStudies", stepState);
        
          stepState = new HashMap<String, Object>(4);
          stepState.put("state", "uncomplete");
          stepState.put("required", true);
          stepState.put("errorMsg", null);
          stepState.put("invalidFields", new ArrayList<String>());
          getStepStates().put("calculationElements", stepState);
        
          stepState = new HashMap<String, Object>(4);
          stepState.put("state", "uncomplete");
          stepState.put("required", true);
          stepState.put("errorMsg", null);
          stepState.put("invalidFields", new ArrayList<String>());
          getStepStates().put("bankReference", stepState);
        
          stepState = new HashMap<String, Object>(4);
          stepState.put("state", "uncomplete");
          stepState.put("required", false);
          stepState.put("errorMsg", null);
          stepState.put("invalidFields", new ArrayList<String>());
          getStepStates().put("document", stepState);
        
          stepState = new HashMap<String, Object>(4);
          stepState.put("state", "uncomplete");
          stepState.put("required", true);
          stepState.put("errorMsg", null);
          stepState.put("invalidFields", new ArrayList<String>());
          getStepStates().put("validation", stepState);
        
          stepState = new HashMap<String, Object>(4);
          stepState.put("state", "uncomplete");
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
        
        studyGrantRequest.setEdemandeId(getEdemandeId());
        SubjectInformationsType subjectInformationsTypeSubjectInformations = studyGrantRequest.addNewSubjectInformations();
        date = getSubjectBirthDate();
        if (date != null) {
            calendar.setTime(date);
            subjectInformationsTypeSubjectInformations.setSubjectBirthDate(calendar);
        }
        SgrCurrentSchoolType sgrCurrentSchoolTypeCurrentSchool = studyGrantRequest.addNewCurrentSchool();
        sgrCurrentSchoolTypeCurrentSchool.setCurrentSchoolCity(getCurrentSchoolCity());
      
        subjectInformationsTypeSubjectInformations.setSubjectEmail(getSubjectEmail());
      
        i = 0;
        if (getTaxHouseholdCity() != null) {
            fr.cg95.cvq.xml.common.LocalReferentialDataType[] taxHouseholdCityTypeTab = new fr.cg95.cvq.xml.common.LocalReferentialDataType[getTaxHouseholdCity().size()];
            for (LocalReferentialData object : getTaxHouseholdCity()) {
              taxHouseholdCityTypeTab[i++] = LocalReferentialData.modelToXml(object);
            }
            studyGrantRequest.setTaxHouseholdCityArray(taxHouseholdCityTypeTab);
        }
      
        if (getSubjectFirstRequest() != null)
            subjectInformationsTypeSubjectInformations.setSubjectFirstRequest(getSubjectFirstRequest().booleanValue());
      
        if (getHasOtherHelp() != null)
            studyGrantRequest.setHasOtherHelp(getHasOtherHelp().booleanValue());
      
        subjectInformationsTypeSubjectInformations.setSubjectPhone(getSubjectPhone());
        ALevelsInformationsType aLevelsInformationsTypeALevelsInformations = studyGrantRequest.addNewALevelsInformations();
        aLevelsInformationsTypeALevelsInformations.setAlevelsDate(getAlevelsDate());
      
        date = getAccountHolderBirthDate();
        if (date != null) {
            calendar.setTime(date);
            studyGrantRequest.setAccountHolderBirthDate(calendar);
        }
      
        i = 0;
        if (getCurrentSchoolName() != null) {
            fr.cg95.cvq.xml.common.LocalReferentialDataType[] currentSchoolNameTypeTab = new fr.cg95.cvq.xml.common.LocalReferentialDataType[getCurrentSchoolName().size()];
            for (LocalReferentialData object : getCurrentSchoolName()) {
              currentSchoolNameTypeTab[i++] = LocalReferentialData.modelToXml(object);
            }
            sgrCurrentSchoolTypeCurrentSchool.setCurrentSchoolNameArray(currentSchoolNameTypeTab);
        }
      
        if (getAccountHolderTitle() != null)
            studyGrantRequest.setAccountHolderTitle(fr.cg95.cvq.xml.common.TitleType.Enum.forString(getAccountHolderTitle().toString()));
        CurrentStudiesInformationsType currentStudiesInformationsTypeCurrentStudiesInformations = studyGrantRequest.addNewCurrentStudiesInformations();
        if (getAbroadInternshipSchoolCountry() != null)
            currentStudiesInformationsTypeCurrentStudiesInformations.setAbroadInternshipSchoolCountry(fr.cg95.cvq.xml.common.CountryType.Enum.forString(getAbroadInternshipSchoolCountry().toString()));
      
        studyGrantRequest.setTaxHouseholdLastName(getTaxHouseholdLastName());
      
        currentStudiesInformationsTypeCurrentStudiesInformations.setAbroadInternshipSchoolName(getAbroadInternshipSchoolName());
      
        if (getHasRegionalCouncilHelp() != null)
            studyGrantRequest.setHasRegionalCouncilHelp(getHasRegionalCouncilHelp().booleanValue());
      
        studyGrantRequest.setTaxHouseholdCityPrecision(getTaxHouseholdCityPrecision());
      
        if (getCurrentStudiesLevel() != null)
            currentStudiesInformationsTypeCurrentStudiesInformations.setCurrentStudiesLevel(fr.cg95.cvq.xml.request.school.CurrentStudiesLevelType.Enum.forString(getCurrentStudiesLevel().toString()));
      
        sgrCurrentSchoolTypeCurrentSchool.setCurrentSchoolPostalCode(getCurrentSchoolPostalCode());
      
        date = getAbroadInternshipStartDate();
        if (date != null) {
            calendar.setTime(date);
            currentStudiesInformationsTypeCurrentStudiesInformations.setAbroadInternshipStartDate(calendar);
        }
      
        studyGrantRequest.setAccountHolderLastName(getAccountHolderLastName());
      
        if (getHasCROUSHelp() != null)
            studyGrantRequest.setHasCROUSHelp(getHasCROUSHelp().booleanValue());
      
        studyGrantRequest.setAccountHolderFirstName(getAccountHolderFirstName());
      
        if (getDistance() != null)
            studyGrantRequest.setDistance(fr.cg95.cvq.xml.request.school.DistanceType.Enum.forString(getDistance().toString()));
      
        if (getAlevels() != null)
            aLevelsInformationsTypeALevelsInformations.setAlevels(fr.cg95.cvq.xml.request.school.ALevelsType.Enum.forString(getAlevels().toString()));
      
        if (getIsSubjectAccountHolder() != null)
            studyGrantRequest.setIsSubjectAccountHolder(getIsSubjectAccountHolder().booleanValue());
      
        subjectInformationsTypeSubjectInformations.setSubjectMobilePhone(getSubjectMobilePhone());
      
        currentStudiesInformationsTypeCurrentStudiesInformations.setOtherStudiesLabel(getOtherStudiesLabel());
      
        if (getTaxHouseholdIncome() != null)
            studyGrantRequest.setTaxHouseholdIncome(getTaxHouseholdIncome().doubleValue());
      
        sgrCurrentSchoolTypeCurrentSchool.setCurrentSchoolNamePrecision(getCurrentSchoolNamePrecision());
      
        if (getCurrentSchoolCountry() != null)
            sgrCurrentSchoolTypeCurrentSchool.setCurrentSchoolCountry(fr.cg95.cvq.xml.common.CountryType.Enum.forString(getCurrentSchoolCountry().toString()));
      
        if (getSubjectAddress() != null)
            subjectInformationsTypeSubjectInformations.setSubjectAddress(Address.modelToXml(getSubjectAddress()));
      
        date = getAbroadInternshipEndDate();
        if (date != null) {
            calendar.setTime(date);
            currentStudiesInformationsTypeCurrentStudiesInformations.setAbroadInternshipEndDate(calendar);
        }
      
        if (getHasEuropeHelp() != null)
            studyGrantRequest.setHasEuropeHelp(getHasEuropeHelp().booleanValue());
      
        studyGrantRequest.setAccountHolderEdemandeId(getAccountHolderEdemandeId());
      
        studyGrantRequest.setTaxHouseholdFirstName(getTaxHouseholdFirstName());
      
        if (getSandwichCourses() != null)
            currentStudiesInformationsTypeCurrentStudiesInformations.setSandwichCourses(getSandwichCourses().booleanValue());
      
        if (getAbroadInternship() != null)
            currentStudiesInformationsTypeCurrentStudiesInformations.setAbroadInternship(getAbroadInternship().booleanValue());
      
        if (getFrenchRIB() != null)
            studyGrantRequest.setFrenchRIB(FrenchRIB.modelToXml(getFrenchRIB()));
      
        if (getCurrentStudiesDiploma() != null)
            currentStudiesInformationsTypeCurrentStudiesInformations.setCurrentStudiesDiploma(fr.cg95.cvq.xml.request.school.CurrentStudiesType.Enum.forString(getCurrentStudiesDiploma().toString()));
      
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
        
        studyGrantRequest.setEdemandeId(studyGrantRequestXml.getEdemandeId());
      
        calendar = studyGrantRequestXml.getSubjectInformations().getSubjectBirthDate();
        if (calendar != null) {
            studyGrantRequest.setSubjectBirthDate(calendar.getTime());
        }
      
        studyGrantRequest.setCurrentSchoolCity(studyGrantRequestXml.getCurrentSchool().getCurrentSchoolCity());
      
        studyGrantRequest.setSubjectEmail(studyGrantRequestXml.getSubjectInformations().getSubjectEmail());
      
        List<fr.cg95.cvq.business.request.LocalReferentialData> taxHouseholdCityList = new ArrayList<fr.cg95.cvq.business.request.LocalReferentialData>(studyGrantRequestXml.sizeOfTaxHouseholdCityArray());
        for (LocalReferentialDataType object : studyGrantRequestXml.getTaxHouseholdCityArray()) {
            taxHouseholdCityList.add(fr.cg95.cvq.business.request.LocalReferentialData.xmlToModel(object));
        }
        studyGrantRequest.setTaxHouseholdCity(taxHouseholdCityList);
      
        studyGrantRequest.setSubjectFirstRequest(Boolean.valueOf(studyGrantRequestXml.getSubjectInformations().getSubjectFirstRequest()));
      
        studyGrantRequest.setHasOtherHelp(Boolean.valueOf(studyGrantRequestXml.getHasOtherHelp()));
      
        studyGrantRequest.setSubjectPhone(studyGrantRequestXml.getSubjectInformations().getSubjectPhone());
      
        studyGrantRequest.setAlevelsDate(studyGrantRequestXml.getALevelsInformations().getAlevelsDate());
      
        calendar = studyGrantRequestXml.getAccountHolderBirthDate();
        if (calendar != null) {
            studyGrantRequest.setAccountHolderBirthDate(calendar.getTime());
        }
      
        List<fr.cg95.cvq.business.request.LocalReferentialData> currentSchoolNameList = new ArrayList<fr.cg95.cvq.business.request.LocalReferentialData>(studyGrantRequestXml.getCurrentSchool().sizeOfCurrentSchoolNameArray());
        for (LocalReferentialDataType object : studyGrantRequestXml.getCurrentSchool().getCurrentSchoolNameArray()) {
            currentSchoolNameList.add(fr.cg95.cvq.business.request.LocalReferentialData.xmlToModel(object));
        }
        studyGrantRequest.setCurrentSchoolName(currentSchoolNameList);
      
        if (studyGrantRequestXml.getAccountHolderTitle() != null)
            studyGrantRequest.setAccountHolderTitle(fr.cg95.cvq.business.users.TitleType.forString(studyGrantRequestXml.getAccountHolderTitle().toString()));
        else
            studyGrantRequest.setAccountHolderTitle(fr.cg95.cvq.business.users.TitleType.getDefaultTitleType());
      
        if (studyGrantRequestXml.getCurrentStudiesInformations().getAbroadInternshipSchoolCountry() != null)
            studyGrantRequest.setAbroadInternshipSchoolCountry(fr.cg95.cvq.business.users.CountryType.forString(studyGrantRequestXml.getCurrentStudiesInformations().getAbroadInternshipSchoolCountry().toString()));
        else
            studyGrantRequest.setAbroadInternshipSchoolCountry(fr.cg95.cvq.business.users.CountryType.getDefaultCountryType());
      
        studyGrantRequest.setTaxHouseholdLastName(studyGrantRequestXml.getTaxHouseholdLastName());
      
        studyGrantRequest.setAbroadInternshipSchoolName(studyGrantRequestXml.getCurrentStudiesInformations().getAbroadInternshipSchoolName());
      
        studyGrantRequest.setHasRegionalCouncilHelp(Boolean.valueOf(studyGrantRequestXml.getHasRegionalCouncilHelp()));
      
        studyGrantRequest.setTaxHouseholdCityPrecision(studyGrantRequestXml.getTaxHouseholdCityPrecision());
      
        if (studyGrantRequestXml.getCurrentStudiesInformations().getCurrentStudiesLevel() != null)
            studyGrantRequest.setCurrentStudiesLevel(fr.cg95.cvq.business.request.school.CurrentStudiesLevelType.forString(studyGrantRequestXml.getCurrentStudiesInformations().getCurrentStudiesLevel().toString()));
        else
            studyGrantRequest.setCurrentStudiesLevel(fr.cg95.cvq.business.request.school.CurrentStudiesLevelType.getDefaultCurrentStudiesLevelType());
      
        studyGrantRequest.setCurrentSchoolPostalCode(studyGrantRequestXml.getCurrentSchool().getCurrentSchoolPostalCode());
      
        calendar = studyGrantRequestXml.getCurrentStudiesInformations().getAbroadInternshipStartDate();
        if (calendar != null) {
            studyGrantRequest.setAbroadInternshipStartDate(calendar.getTime());
        }
      
        studyGrantRequest.setAccountHolderLastName(studyGrantRequestXml.getAccountHolderLastName());
      
        studyGrantRequest.setHasCROUSHelp(Boolean.valueOf(studyGrantRequestXml.getHasCROUSHelp()));
      
        studyGrantRequest.setAccountHolderFirstName(studyGrantRequestXml.getAccountHolderFirstName());
      
        if (studyGrantRequestXml.getDistance() != null)
            studyGrantRequest.setDistance(fr.cg95.cvq.business.request.school.DistanceType.forString(studyGrantRequestXml.getDistance().toString()));
        else
            studyGrantRequest.setDistance(fr.cg95.cvq.business.request.school.DistanceType.getDefaultDistanceType());
      
        if (studyGrantRequestXml.getALevelsInformations().getAlevels() != null)
            studyGrantRequest.setAlevels(fr.cg95.cvq.business.request.school.ALevelsType.forString(studyGrantRequestXml.getALevelsInformations().getAlevels().toString()));
        else
            studyGrantRequest.setAlevels(fr.cg95.cvq.business.request.school.ALevelsType.getDefaultALevelsType());
      
        studyGrantRequest.setIsSubjectAccountHolder(Boolean.valueOf(studyGrantRequestXml.getIsSubjectAccountHolder()));
      
        studyGrantRequest.setSubjectMobilePhone(studyGrantRequestXml.getSubjectInformations().getSubjectMobilePhone());
      
        studyGrantRequest.setOtherStudiesLabel(studyGrantRequestXml.getCurrentStudiesInformations().getOtherStudiesLabel());
      
        studyGrantRequest.setTaxHouseholdIncome(new Double(studyGrantRequestXml.getTaxHouseholdIncome()));
      
        studyGrantRequest.setCurrentSchoolNamePrecision(studyGrantRequestXml.getCurrentSchool().getCurrentSchoolNamePrecision());
      
        if (studyGrantRequestXml.getCurrentSchool().getCurrentSchoolCountry() != null)
            studyGrantRequest.setCurrentSchoolCountry(fr.cg95.cvq.business.users.CountryType.forString(studyGrantRequestXml.getCurrentSchool().getCurrentSchoolCountry().toString()));
        else
            studyGrantRequest.setCurrentSchoolCountry(fr.cg95.cvq.business.users.CountryType.getDefaultCountryType());
      
        if (studyGrantRequestXml.getSubjectInformations().getSubjectAddress() != null)
            studyGrantRequest.setSubjectAddress(Address.xmlToModel(studyGrantRequestXml.getSubjectInformations().getSubjectAddress()));
      
        calendar = studyGrantRequestXml.getCurrentStudiesInformations().getAbroadInternshipEndDate();
        if (calendar != null) {
            studyGrantRequest.setAbroadInternshipEndDate(calendar.getTime());
        }
      
        studyGrantRequest.setHasEuropeHelp(Boolean.valueOf(studyGrantRequestXml.getHasEuropeHelp()));
      
        studyGrantRequest.setAccountHolderEdemandeId(studyGrantRequestXml.getAccountHolderEdemandeId());
      
        studyGrantRequest.setTaxHouseholdFirstName(studyGrantRequestXml.getTaxHouseholdFirstName());
      
        studyGrantRequest.setSandwichCourses(Boolean.valueOf(studyGrantRequestXml.getCurrentStudiesInformations().getSandwichCourses()));
      
        studyGrantRequest.setAbroadInternship(Boolean.valueOf(studyGrantRequestXml.getCurrentStudiesInformations().getAbroadInternship()));
      
        if (studyGrantRequestXml.getFrenchRIB() != null)
            studyGrantRequest.setFrenchRIB(FrenchRIB.xmlToModel(studyGrantRequestXml.getFrenchRIB()));
      
        if (studyGrantRequestXml.getCurrentStudiesInformations().getCurrentStudiesDiploma() != null)
            studyGrantRequest.setCurrentStudiesDiploma(fr.cg95.cvq.business.request.school.CurrentStudiesType.forString(studyGrantRequestXml.getCurrentStudiesInformations().getCurrentStudiesDiploma().toString()));
        else
            studyGrantRequest.setCurrentStudiesDiploma(fr.cg95.cvq.business.request.school.CurrentStudiesType.getDefaultCurrentStudiesType());
      
        return studyGrantRequest;
    }

  
    public final void setEdemandeId(final String edemandeId) {
        studyGrantRequestData.setEdemandeId(edemandeId);
    }

    
    public final String getEdemandeId() {
        return studyGrantRequestData.getEdemandeId();
    }
  
    public final void setSubjectBirthDate(final java.util.Date subjectBirthDate) {
        studyGrantRequestData.setSubjectBirthDate(subjectBirthDate);
    }

    
    public final java.util.Date getSubjectBirthDate() {
        return studyGrantRequestData.getSubjectBirthDate();
    }
  
    public final void setCurrentSchoolCity(final String currentSchoolCity) {
        studyGrantRequestData.setCurrentSchoolCity(currentSchoolCity);
    }

    
    public final String getCurrentSchoolCity() {
        return studyGrantRequestData.getCurrentSchoolCity();
    }
  
    public final void setSubjectEmail(final String subjectEmail) {
        studyGrantRequestData.setSubjectEmail(subjectEmail);
    }

    
    public final String getSubjectEmail() {
        return studyGrantRequestData.getSubjectEmail();
    }
  
    public final void setTaxHouseholdCity(final List<fr.cg95.cvq.business.request.LocalReferentialData> taxHouseholdCity) {
        studyGrantRequestData.setTaxHouseholdCity(taxHouseholdCity);
    }

    
    public final List<fr.cg95.cvq.business.request.LocalReferentialData> getTaxHouseholdCity() {
        return studyGrantRequestData.getTaxHouseholdCity();
    }
  
    public final void setSubjectFirstRequest(final Boolean subjectFirstRequest) {
        studyGrantRequestData.setSubjectFirstRequest(subjectFirstRequest);
    }

    
    public final Boolean getSubjectFirstRequest() {
        return studyGrantRequestData.getSubjectFirstRequest();
    }
  
    public final void setHasOtherHelp(final Boolean hasOtherHelp) {
        studyGrantRequestData.setHasOtherHelp(hasOtherHelp);
    }

    
    public final Boolean getHasOtherHelp() {
        return studyGrantRequestData.getHasOtherHelp();
    }
  
    public final void setSubjectPhone(final String subjectPhone) {
        studyGrantRequestData.setSubjectPhone(subjectPhone);
    }

    
    public final String getSubjectPhone() {
        return studyGrantRequestData.getSubjectPhone();
    }
  
    public final void setAlevelsDate(final String alevelsDate) {
        studyGrantRequestData.setAlevelsDate(alevelsDate);
    }

    
    public final String getAlevelsDate() {
        return studyGrantRequestData.getAlevelsDate();
    }
  
    public final void setAccountHolderBirthDate(final java.util.Date accountHolderBirthDate) {
        studyGrantRequestData.setAccountHolderBirthDate(accountHolderBirthDate);
    }

    
    public final java.util.Date getAccountHolderBirthDate() {
        return studyGrantRequestData.getAccountHolderBirthDate();
    }
  
    public final void setCurrentSchoolName(final List<fr.cg95.cvq.business.request.LocalReferentialData> currentSchoolName) {
        studyGrantRequestData.setCurrentSchoolName(currentSchoolName);
    }

    
    public final List<fr.cg95.cvq.business.request.LocalReferentialData> getCurrentSchoolName() {
        return studyGrantRequestData.getCurrentSchoolName();
    }
  
    public final void setAccountHolderTitle(final fr.cg95.cvq.business.users.TitleType accountHolderTitle) {
        studyGrantRequestData.setAccountHolderTitle(accountHolderTitle);
    }

    
    public final fr.cg95.cvq.business.users.TitleType getAccountHolderTitle() {
        return studyGrantRequestData.getAccountHolderTitle();
    }
  
    public final void setAbroadInternshipSchoolCountry(final fr.cg95.cvq.business.users.CountryType abroadInternshipSchoolCountry) {
        studyGrantRequestData.setAbroadInternshipSchoolCountry(abroadInternshipSchoolCountry);
    }

    
    public final fr.cg95.cvq.business.users.CountryType getAbroadInternshipSchoolCountry() {
        return studyGrantRequestData.getAbroadInternshipSchoolCountry();
    }
  
    public final void setTaxHouseholdLastName(final String taxHouseholdLastName) {
        studyGrantRequestData.setTaxHouseholdLastName(taxHouseholdLastName);
    }

    
    public final String getTaxHouseholdLastName() {
        return studyGrantRequestData.getTaxHouseholdLastName();
    }
  
    public final void setAbroadInternshipSchoolName(final String abroadInternshipSchoolName) {
        studyGrantRequestData.setAbroadInternshipSchoolName(abroadInternshipSchoolName);
    }

    
    public final String getAbroadInternshipSchoolName() {
        return studyGrantRequestData.getAbroadInternshipSchoolName();
    }
  
    public final void setHasRegionalCouncilHelp(final Boolean hasRegionalCouncilHelp) {
        studyGrantRequestData.setHasRegionalCouncilHelp(hasRegionalCouncilHelp);
    }

    
    public final Boolean getHasRegionalCouncilHelp() {
        return studyGrantRequestData.getHasRegionalCouncilHelp();
    }
  
    public final void setTaxHouseholdCityPrecision(final String taxHouseholdCityPrecision) {
        studyGrantRequestData.setTaxHouseholdCityPrecision(taxHouseholdCityPrecision);
    }

    
    public final String getTaxHouseholdCityPrecision() {
        return studyGrantRequestData.getTaxHouseholdCityPrecision();
    }
  
    public final void setCurrentStudiesLevel(final fr.cg95.cvq.business.request.school.CurrentStudiesLevelType currentStudiesLevel) {
        studyGrantRequestData.setCurrentStudiesLevel(currentStudiesLevel);
    }

    
    public final fr.cg95.cvq.business.request.school.CurrentStudiesLevelType getCurrentStudiesLevel() {
        return studyGrantRequestData.getCurrentStudiesLevel();
    }
  
    public final void setCurrentSchoolPostalCode(final String currentSchoolPostalCode) {
        studyGrantRequestData.setCurrentSchoolPostalCode(currentSchoolPostalCode);
    }

    
    public final String getCurrentSchoolPostalCode() {
        return studyGrantRequestData.getCurrentSchoolPostalCode();
    }
  
    public final void setAbroadInternshipStartDate(final java.util.Date abroadInternshipStartDate) {
        studyGrantRequestData.setAbroadInternshipStartDate(abroadInternshipStartDate);
    }

    
    public final java.util.Date getAbroadInternshipStartDate() {
        return studyGrantRequestData.getAbroadInternshipStartDate();
    }
  
    public final void setAccountHolderLastName(final String accountHolderLastName) {
        studyGrantRequestData.setAccountHolderLastName(accountHolderLastName);
    }

    
    public final String getAccountHolderLastName() {
        return studyGrantRequestData.getAccountHolderLastName();
    }
  
    public final void setHasCROUSHelp(final Boolean hasCROUSHelp) {
        studyGrantRequestData.setHasCROUSHelp(hasCROUSHelp);
    }

    
    public final Boolean getHasCROUSHelp() {
        return studyGrantRequestData.getHasCROUSHelp();
    }
  
    public final void setAccountHolderFirstName(final String accountHolderFirstName) {
        studyGrantRequestData.setAccountHolderFirstName(accountHolderFirstName);
    }

    
    public final String getAccountHolderFirstName() {
        return studyGrantRequestData.getAccountHolderFirstName();
    }
  
    public final void setDistance(final fr.cg95.cvq.business.request.school.DistanceType distance) {
        studyGrantRequestData.setDistance(distance);
    }

    
    public final fr.cg95.cvq.business.request.school.DistanceType getDistance() {
        return studyGrantRequestData.getDistance();
    }
  
    public final void setAlevels(final fr.cg95.cvq.business.request.school.ALevelsType alevels) {
        studyGrantRequestData.setAlevels(alevels);
    }

    
    public final fr.cg95.cvq.business.request.school.ALevelsType getAlevels() {
        return studyGrantRequestData.getAlevels();
    }
  
    public final void setIsSubjectAccountHolder(final Boolean isSubjectAccountHolder) {
        studyGrantRequestData.setIsSubjectAccountHolder(isSubjectAccountHolder);
    }

    
    public final Boolean getIsSubjectAccountHolder() {
        return studyGrantRequestData.getIsSubjectAccountHolder();
    }
  
    public final void setSubjectMobilePhone(final String subjectMobilePhone) {
        studyGrantRequestData.setSubjectMobilePhone(subjectMobilePhone);
    }

    
    public final String getSubjectMobilePhone() {
        return studyGrantRequestData.getSubjectMobilePhone();
    }
  
    public final void setOtherStudiesLabel(final String otherStudiesLabel) {
        studyGrantRequestData.setOtherStudiesLabel(otherStudiesLabel);
    }

    
    public final String getOtherStudiesLabel() {
        return studyGrantRequestData.getOtherStudiesLabel();
    }
  
    public final void setTaxHouseholdIncome(final Double taxHouseholdIncome) {
        studyGrantRequestData.setTaxHouseholdIncome(taxHouseholdIncome);
    }

    
    public final Double getTaxHouseholdIncome() {
        return studyGrantRequestData.getTaxHouseholdIncome();
    }
  
    public final void setCurrentSchoolNamePrecision(final String currentSchoolNamePrecision) {
        studyGrantRequestData.setCurrentSchoolNamePrecision(currentSchoolNamePrecision);
    }

    
    public final String getCurrentSchoolNamePrecision() {
        return studyGrantRequestData.getCurrentSchoolNamePrecision();
    }
  
    public final void setCurrentSchoolCountry(final fr.cg95.cvq.business.users.CountryType currentSchoolCountry) {
        studyGrantRequestData.setCurrentSchoolCountry(currentSchoolCountry);
    }

    
    public final fr.cg95.cvq.business.users.CountryType getCurrentSchoolCountry() {
        return studyGrantRequestData.getCurrentSchoolCountry();
    }
  
    public final void setSubjectAddress(final fr.cg95.cvq.business.users.Address subjectAddress) {
        studyGrantRequestData.setSubjectAddress(subjectAddress);
    }

    
    public final fr.cg95.cvq.business.users.Address getSubjectAddress() {
        return studyGrantRequestData.getSubjectAddress();
    }
  
    public final void setAbroadInternshipEndDate(final java.util.Date abroadInternshipEndDate) {
        studyGrantRequestData.setAbroadInternshipEndDate(abroadInternshipEndDate);
    }

    
    public final java.util.Date getAbroadInternshipEndDate() {
        return studyGrantRequestData.getAbroadInternshipEndDate();
    }
  
    public final void setHasEuropeHelp(final Boolean hasEuropeHelp) {
        studyGrantRequestData.setHasEuropeHelp(hasEuropeHelp);
    }

    
    public final Boolean getHasEuropeHelp() {
        return studyGrantRequestData.getHasEuropeHelp();
    }
  
    public final void setAccountHolderEdemandeId(final String accountHolderEdemandeId) {
        studyGrantRequestData.setAccountHolderEdemandeId(accountHolderEdemandeId);
    }

    
    public final String getAccountHolderEdemandeId() {
        return studyGrantRequestData.getAccountHolderEdemandeId();
    }
  
    public final void setTaxHouseholdFirstName(final String taxHouseholdFirstName) {
        studyGrantRequestData.setTaxHouseholdFirstName(taxHouseholdFirstName);
    }

    
    public final String getTaxHouseholdFirstName() {
        return studyGrantRequestData.getTaxHouseholdFirstName();
    }
  
    public final void setSandwichCourses(final Boolean sandwichCourses) {
        studyGrantRequestData.setSandwichCourses(sandwichCourses);
    }

    
    public final Boolean getSandwichCourses() {
        return studyGrantRequestData.getSandwichCourses();
    }
  
    public final void setAbroadInternship(final Boolean abroadInternship) {
        studyGrantRequestData.setAbroadInternship(abroadInternship);
    }

    
    public final Boolean getAbroadInternship() {
        return studyGrantRequestData.getAbroadInternship();
    }
  
    public final void setFrenchRIB(final fr.cg95.cvq.business.users.FrenchRIB frenchRIB) {
        studyGrantRequestData.setFrenchRIB(frenchRIB);
    }

    
    public final fr.cg95.cvq.business.users.FrenchRIB getFrenchRIB() {
        return studyGrantRequestData.getFrenchRIB();
    }
  
    public final void setCurrentStudiesDiploma(final fr.cg95.cvq.business.request.school.CurrentStudiesType currentStudiesDiploma) {
        studyGrantRequestData.setCurrentStudiesDiploma(currentStudiesDiploma);
    }

    
    public final fr.cg95.cvq.business.request.school.CurrentStudiesType getCurrentStudiesDiploma() {
        return studyGrantRequestData.getCurrentStudiesDiploma();
    }
  
}
