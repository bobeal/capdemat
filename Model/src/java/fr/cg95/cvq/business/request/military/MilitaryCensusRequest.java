
package fr.cg95.cvq.business.request.military;

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
import fr.cg95.cvq.xml.request.military.*;
import fr.cg95.cvq.service.request.condition.IConditionChecker;

/**
 * Generated class file, do not edit !
 */
public class MilitaryCensusRequest extends Request implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final Map<String, IConditionChecker> conditions = MilitaryCensusRequestData.conditions;

    @AssertValid(message = "")
    private MilitaryCensusRequestData militaryCensusRequestData;

    public MilitaryCensusRequest(RequestData requestData, MilitaryCensusRequestData militaryCensusRequestData) {
        super(requestData);
        this.militaryCensusRequestData = militaryCensusRequestData;
    }

    public MilitaryCensusRequest() {
        super();
        this.militaryCensusRequestData = new MilitaryCensusRequestData();
        Map<String, Object> stepState;
        
          stepState = new HashMap<String, Object>(4);
          stepState.put("state", "uncomplete");
          stepState.put("required", true);
          stepState.put("errorMsg", null);
          stepState.put("invalidFields", new ArrayList<String>());
          getStepStates().put("census", stepState);
        
          stepState = new HashMap<String, Object>(4);
          stepState.put("state", "unavailable");
          stepState.put("required", true);
          stepState.put("errorMsg", null);
          stepState.put("invalidFields", new ArrayList<String>());
          getStepStates().put("parentage", stepState);
        
          stepState = new HashMap<String, Object>(4);
          stepState.put("state", "unavailable");
          stepState.put("required", true);
          stepState.put("errorMsg", null);
          stepState.put("invalidFields", new ArrayList<String>());
          getStepStates().put("situation", stepState);
        
          stepState = new HashMap<String, Object>(4);
          stepState.put("state", "unavailable");
          stepState.put("required", false);
          stepState.put("errorMsg", null);
          stepState.put("invalidFields", new ArrayList<String>());
          getStepStates().put("exemption", stepState);
        
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
    public MilitaryCensusRequestData getSpecificData() {
        return militaryCensusRequestData;
    }

    /**
     * Reserved for RequestDAO !
     */
    public void setSpecificData(MilitaryCensusRequestData militaryCensusRequestData) {
        this.militaryCensusRequestData = militaryCensusRequestData;
    }

    @Override
    public final String modelToXmlString() {
        MilitaryCensusRequestDocument object = this.modelToXml();
        XmlOptions opts = new XmlOptions();
        opts.setSavePrettyPrint();
        opts.setSavePrettyPrintIndent(4);
        opts.setUseDefaultNamespace();
        opts.setCharacterEncoding("UTF-8");
        return object.xmlText(opts);
    }

    @Override
    public final MilitaryCensusRequestDocument modelToXml() {
        
        Calendar calendar = Calendar.getInstance();
        LocalTime localTime = new LocalTime();
        Date date = null;
        MilitaryCensusRequestDocument militaryCensusRequestDoc = MilitaryCensusRequestDocument.Factory.newInstance();
        MilitaryCensusRequestDocument.MilitaryCensusRequest militaryCensusRequest = militaryCensusRequestDoc.addNewMilitaryCensusRequest();
        super.fillCommonXmlInfo(militaryCensusRequest);
        int i = 0;
        
        if (getAffectionOrDisease() != null)
            militaryCensusRequest.setAffectionOrDisease(getAffectionOrDisease().booleanValue());
        FamilySituationInformationType familySituationInformationTypeFamilySituationInformation = militaryCensusRequest.addNewFamilySituationInformation();
        if (getAliveChildren() != null)
            familySituationInformationTypeFamilySituationInformation.setAliveChildren(new BigInteger(getAliveChildren().toString()));
      
        if (getChildBirthCountry() != null)
            militaryCensusRequest.setChildBirthCountry(fr.cg95.cvq.xml.common.CountryType.Enum.forString(getChildBirthCountry().getLegacyLabel()));
      
        militaryCensusRequest.setChildConvention(getChildConvention());
      
        if (getChildCountry() != null)
            militaryCensusRequest.setChildCountry(fr.cg95.cvq.xml.common.FullNationalityType.Enum.forString(getChildCountry().getLegacyLabel()));
        ProfessionalSituationInformationType professionalSituationInformationTypeProfessionalSituationInformation = militaryCensusRequest.addNewProfessionalSituationInformation();
        if (getChildDiploma() != null)
            professionalSituationInformationTypeProfessionalSituationInformation.setChildDiploma(fr.cg95.cvq.xml.request.military.ChildDiplomaType.Enum.forString(getChildDiploma().getLegacyLabel()));
      
        militaryCensusRequest.setChildMail(getChildMail());
      
        if (getChildOtherCountry() != null)
            militaryCensusRequest.setChildOtherCountry(fr.cg95.cvq.xml.common.FullNationalityType.Enum.forString(getChildOtherCountry().getLegacyLabel()));
      
        militaryCensusRequest.setChildPhone(getChildPhone());
      
        professionalSituationInformationTypeProfessionalSituationInformation.setChildProfession(getChildProfession());
      
        if (getChildResidenceCountry() != null)
            militaryCensusRequest.setChildResidenceCountry(fr.cg95.cvq.xml.common.CountryType.Enum.forString(getChildResidenceCountry().getLegacyLabel()));
      
        if (getChildSituation() != null)
            professionalSituationInformationTypeProfessionalSituationInformation.setChildSituation(fr.cg95.cvq.xml.request.military.ChildSituationType.Enum.forString(getChildSituation().getLegacyLabel()));
      
        professionalSituationInformationTypeProfessionalSituationInformation.setChildSpeciality(getChildSpeciality());
      
        if (getChildStatus() != null)
            familySituationInformationTypeFamilySituationInformation.setChildStatus(fr.cg95.cvq.xml.common.FamilyStatusType.Enum.forString(getChildStatus().getLegacyLabel()));
      
        if (getChildTitle() != null)
            militaryCensusRequest.setChildTitle(fr.cg95.cvq.xml.common.TitleType.Enum.forString(getChildTitle().getLegacyLabel()));
      
        if (getChildrenInCharge() != null)
            familySituationInformationTypeFamilySituationInformation.setChildrenInCharge(new BigInteger(getChildrenInCharge().toString()));
        MilitaryFatherInformationType militaryFatherInformationTypeFatherInformation = militaryCensusRequest.addNewFatherInformation();
        militaryFatherInformationTypeFatherInformation.setFatherBirthCity(getFatherBirthCity());
      
        if (getFatherBirthCountry() != null)
            militaryFatherInformationTypeFatherInformation.setFatherBirthCountry(fr.cg95.cvq.xml.common.CountryType.Enum.forString(getFatherBirthCountry().getLegacyLabel()));
      
        date = getFatherBirthDate();
        if (date != null) {
            calendar.setTime(date);
            militaryFatherInformationTypeFatherInformation.setFatherBirthDate(calendar);
        }
      
        if (getFatherBirthDepartment() != null)
            militaryFatherInformationTypeFatherInformation.setFatherBirthDepartment(fr.cg95.cvq.xml.common.InseeDepartementCodeType.Enum.forString(getFatherBirthDepartment().getLegacyLabel()));
      
        militaryFatherInformationTypeFatherInformation.setFatherFirstName(getFatherFirstName());
      
        militaryFatherInformationTypeFatherInformation.setFatherLastName(getFatherLastName());
      
        if (getFatherNationality() != null)
            militaryFatherInformationTypeFatherInformation.setFatherNationality(fr.cg95.cvq.xml.common.FullNationalityType.Enum.forString(getFatherNationality().getLegacyLabel()));
      
        if (getHighlyInfirm() != null)
            militaryCensusRequest.setHighlyInfirm(getHighlyInfirm().booleanValue());
      
        if (getJapdExemption() != null)
            militaryCensusRequest.setJapdExemption(getJapdExemption().booleanValue());
      
        militaryCensusRequest.setMaidenName(getMaidenName());
        MilitaryMotherInformationType militaryMotherInformationTypeMotherInformation = militaryCensusRequest.addNewMotherInformation();
        militaryMotherInformationTypeMotherInformation.setMotherBirthCity(getMotherBirthCity());
      
        if (getMotherBirthCountry() != null)
            militaryMotherInformationTypeMotherInformation.setMotherBirthCountry(fr.cg95.cvq.xml.common.CountryType.Enum.forString(getMotherBirthCountry().getLegacyLabel()));
      
        date = getMotherBirthDate();
        if (date != null) {
            calendar.setTime(date);
            militaryMotherInformationTypeMotherInformation.setMotherBirthDate(calendar);
        }
      
        if (getMotherBirthDepartment() != null)
            militaryMotherInformationTypeMotherInformation.setMotherBirthDepartment(fr.cg95.cvq.xml.common.InseeDepartementCodeType.Enum.forString(getMotherBirthDepartment().getLegacyLabel()));
      
        militaryMotherInformationTypeMotherInformation.setMotherFirstName(getMotherFirstName());
      
        militaryMotherInformationTypeMotherInformation.setMotherLastName(getMotherLastName());
      
        if (getMotherNationality() != null)
            militaryMotherInformationTypeMotherInformation.setMotherNationality(fr.cg95.cvq.xml.common.FullNationalityType.Enum.forString(getMotherNationality().getLegacyLabel()));
      
        familySituationInformationTypeFamilySituationInformation.setOtherSituation(getOtherSituation());
      
        if (getPrefectPupil() != null)
            familySituationInformationTypeFamilySituationInformation.setPrefectPupil(getPrefectPupil().booleanValue());
      
        if (getPrefectPupilDepartment() != null)
            familySituationInformationTypeFamilySituationInformation.setPrefectPupilDepartment(fr.cg95.cvq.xml.common.InseeDepartementCodeType.Enum.forString(getPrefectPupilDepartment().getLegacyLabel()));
      
        if (getStatePupil() != null)
            familySituationInformationTypeFamilySituationInformation.setStatePupil(getStatePupil().booleanValue());
      
        return militaryCensusRequestDoc;
    }

    @Override
    public final MilitaryCensusRequestDocument.MilitaryCensusRequest modelToXmlRequest() {
        return modelToXml().getMilitaryCensusRequest();
    }

    public static MilitaryCensusRequest xmlToModel(MilitaryCensusRequestDocument militaryCensusRequestDoc) {
        MilitaryCensusRequestDocument.MilitaryCensusRequest militaryCensusRequestXml = militaryCensusRequestDoc.getMilitaryCensusRequest();
        Calendar calendar = Calendar.getInstance();
        LocalTime localTime = new LocalTime();
        List list = new ArrayList();
        MilitaryCensusRequest militaryCensusRequest = new MilitaryCensusRequest();
        militaryCensusRequest.fillCommonModelInfo(militaryCensusRequest, militaryCensusRequestXml);
        
        militaryCensusRequest.setAffectionOrDisease(Boolean.valueOf(militaryCensusRequestXml.getAffectionOrDisease()));
      
        militaryCensusRequest.setAliveChildren(militaryCensusRequestXml.getFamilySituationInformation().getAliveChildren());
      
        if (militaryCensusRequestXml.getChildBirthCountry() != null)
            militaryCensusRequest.setChildBirthCountry(fr.cg95.cvq.business.users.CountryType.forString(militaryCensusRequestXml.getChildBirthCountry().toString()));
        else
            militaryCensusRequest.setChildBirthCountry(fr.cg95.cvq.business.users.CountryType.getDefaultCountryType());
      
        militaryCensusRequest.setChildConvention(militaryCensusRequestXml.getChildConvention());
      
        if (militaryCensusRequestXml.getChildCountry() != null)
            militaryCensusRequest.setChildCountry(fr.cg95.cvq.business.users.FullNationalityType.forString(militaryCensusRequestXml.getChildCountry().toString()));
        else
            militaryCensusRequest.setChildCountry(fr.cg95.cvq.business.users.FullNationalityType.getDefaultFullNationalityType());
      
        if (militaryCensusRequestXml.getProfessionalSituationInformation().getChildDiploma() != null)
            militaryCensusRequest.setChildDiploma(fr.cg95.cvq.business.request.military.ChildDiplomaType.forString(militaryCensusRequestXml.getProfessionalSituationInformation().getChildDiploma().toString()));
        else
            militaryCensusRequest.setChildDiploma(fr.cg95.cvq.business.request.military.ChildDiplomaType.getDefaultChildDiplomaType());
      
        militaryCensusRequest.setChildMail(militaryCensusRequestXml.getChildMail());
      
        if (militaryCensusRequestXml.getChildOtherCountry() != null)
            militaryCensusRequest.setChildOtherCountry(fr.cg95.cvq.business.users.FullNationalityType.forString(militaryCensusRequestXml.getChildOtherCountry().toString()));
        else
            militaryCensusRequest.setChildOtherCountry(fr.cg95.cvq.business.users.FullNationalityType.getDefaultFullNationalityType());
      
        militaryCensusRequest.setChildPhone(militaryCensusRequestXml.getChildPhone());
      
        militaryCensusRequest.setChildProfession(militaryCensusRequestXml.getProfessionalSituationInformation().getChildProfession());
      
        if (militaryCensusRequestXml.getChildResidenceCountry() != null)
            militaryCensusRequest.setChildResidenceCountry(fr.cg95.cvq.business.users.CountryType.forString(militaryCensusRequestXml.getChildResidenceCountry().toString()));
        else
            militaryCensusRequest.setChildResidenceCountry(fr.cg95.cvq.business.users.CountryType.getDefaultCountryType());
      
        if (militaryCensusRequestXml.getProfessionalSituationInformation().getChildSituation() != null)
            militaryCensusRequest.setChildSituation(fr.cg95.cvq.business.request.military.ChildSituationType.forString(militaryCensusRequestXml.getProfessionalSituationInformation().getChildSituation().toString()));
        else
            militaryCensusRequest.setChildSituation(fr.cg95.cvq.business.request.military.ChildSituationType.getDefaultChildSituationType());
      
        militaryCensusRequest.setChildSpeciality(militaryCensusRequestXml.getProfessionalSituationInformation().getChildSpeciality());
      
        if (militaryCensusRequestXml.getFamilySituationInformation().getChildStatus() != null)
            militaryCensusRequest.setChildStatus(fr.cg95.cvq.business.users.FamilyStatusType.forString(militaryCensusRequestXml.getFamilySituationInformation().getChildStatus().toString()));
        else
            militaryCensusRequest.setChildStatus(fr.cg95.cvq.business.users.FamilyStatusType.getDefaultFamilyStatusType());
      
        if (militaryCensusRequestXml.getChildTitle() != null)
            militaryCensusRequest.setChildTitle(fr.cg95.cvq.business.users.TitleType.forString(militaryCensusRequestXml.getChildTitle().toString()));
        else
            militaryCensusRequest.setChildTitle(fr.cg95.cvq.business.users.TitleType.getDefaultTitleType());
      
        militaryCensusRequest.setChildrenInCharge(militaryCensusRequestXml.getFamilySituationInformation().getChildrenInCharge());
      
        militaryCensusRequest.setFatherBirthCity(militaryCensusRequestXml.getFatherInformation().getFatherBirthCity());
      
        if (militaryCensusRequestXml.getFatherInformation().getFatherBirthCountry() != null)
            militaryCensusRequest.setFatherBirthCountry(fr.cg95.cvq.business.users.CountryType.forString(militaryCensusRequestXml.getFatherInformation().getFatherBirthCountry().toString()));
        else
            militaryCensusRequest.setFatherBirthCountry(fr.cg95.cvq.business.users.CountryType.getDefaultCountryType());
      
        calendar = militaryCensusRequestXml.getFatherInformation().getFatherBirthDate();
        if (calendar != null) {
            militaryCensusRequest.setFatherBirthDate(calendar.getTime());
        }
      
        if (militaryCensusRequestXml.getFatherInformation().getFatherBirthDepartment() != null)
            militaryCensusRequest.setFatherBirthDepartment(fr.cg95.cvq.business.users.InseeDepartementCodeType.forString(militaryCensusRequestXml.getFatherInformation().getFatherBirthDepartment().toString()));
        else
            militaryCensusRequest.setFatherBirthDepartment(fr.cg95.cvq.business.users.InseeDepartementCodeType.getDefaultInseeDepartementCodeType());
      
        militaryCensusRequest.setFatherFirstName(militaryCensusRequestXml.getFatherInformation().getFatherFirstName());
      
        militaryCensusRequest.setFatherLastName(militaryCensusRequestXml.getFatherInformation().getFatherLastName());
      
        if (militaryCensusRequestXml.getFatherInformation().getFatherNationality() != null)
            militaryCensusRequest.setFatherNationality(fr.cg95.cvq.business.users.FullNationalityType.forString(militaryCensusRequestXml.getFatherInformation().getFatherNationality().toString()));
        else
            militaryCensusRequest.setFatherNationality(fr.cg95.cvq.business.users.FullNationalityType.getDefaultFullNationalityType());
      
        militaryCensusRequest.setHighlyInfirm(Boolean.valueOf(militaryCensusRequestXml.getHighlyInfirm()));
      
        militaryCensusRequest.setJapdExemption(Boolean.valueOf(militaryCensusRequestXml.getJapdExemption()));
      
        militaryCensusRequest.setMaidenName(militaryCensusRequestXml.getMaidenName());
      
        militaryCensusRequest.setMotherBirthCity(militaryCensusRequestXml.getMotherInformation().getMotherBirthCity());
      
        if (militaryCensusRequestXml.getMotherInformation().getMotherBirthCountry() != null)
            militaryCensusRequest.setMotherBirthCountry(fr.cg95.cvq.business.users.CountryType.forString(militaryCensusRequestXml.getMotherInformation().getMotherBirthCountry().toString()));
        else
            militaryCensusRequest.setMotherBirthCountry(fr.cg95.cvq.business.users.CountryType.getDefaultCountryType());
      
        calendar = militaryCensusRequestXml.getMotherInformation().getMotherBirthDate();
        if (calendar != null) {
            militaryCensusRequest.setMotherBirthDate(calendar.getTime());
        }
      
        if (militaryCensusRequestXml.getMotherInformation().getMotherBirthDepartment() != null)
            militaryCensusRequest.setMotherBirthDepartment(fr.cg95.cvq.business.users.InseeDepartementCodeType.forString(militaryCensusRequestXml.getMotherInformation().getMotherBirthDepartment().toString()));
        else
            militaryCensusRequest.setMotherBirthDepartment(fr.cg95.cvq.business.users.InseeDepartementCodeType.getDefaultInseeDepartementCodeType());
      
        militaryCensusRequest.setMotherFirstName(militaryCensusRequestXml.getMotherInformation().getMotherFirstName());
      
        militaryCensusRequest.setMotherLastName(militaryCensusRequestXml.getMotherInformation().getMotherLastName());
      
        if (militaryCensusRequestXml.getMotherInformation().getMotherNationality() != null)
            militaryCensusRequest.setMotherNationality(fr.cg95.cvq.business.users.FullNationalityType.forString(militaryCensusRequestXml.getMotherInformation().getMotherNationality().toString()));
        else
            militaryCensusRequest.setMotherNationality(fr.cg95.cvq.business.users.FullNationalityType.getDefaultFullNationalityType());
      
        militaryCensusRequest.setOtherSituation(militaryCensusRequestXml.getFamilySituationInformation().getOtherSituation());
      
        militaryCensusRequest.setPrefectPupil(Boolean.valueOf(militaryCensusRequestXml.getFamilySituationInformation().getPrefectPupil()));
      
        if (militaryCensusRequestXml.getFamilySituationInformation().getPrefectPupilDepartment() != null)
            militaryCensusRequest.setPrefectPupilDepartment(fr.cg95.cvq.business.users.InseeDepartementCodeType.forString(militaryCensusRequestXml.getFamilySituationInformation().getPrefectPupilDepartment().toString()));
        else
            militaryCensusRequest.setPrefectPupilDepartment(fr.cg95.cvq.business.users.InseeDepartementCodeType.getDefaultInseeDepartementCodeType());
      
        militaryCensusRequest.setStatePupil(Boolean.valueOf(militaryCensusRequestXml.getFamilySituationInformation().getStatePupil()));
      
        return militaryCensusRequest;
    }

    @Override
    public MilitaryCensusRequest clone() {
        MilitaryCensusRequest clone = new MilitaryCensusRequest(getRequestData().clone(), militaryCensusRequestData.clone());
        Map<String, Object> stepState;
        
          stepState = new HashMap<String, Object>(4);
          stepState.put("state", "uncomplete");
          stepState.put("required", true);
          stepState.put("errorMsg", null);
          stepState.put("invalidFields", new ArrayList<String>());
          clone.getStepStates().put("census", stepState);
        
          stepState = new HashMap<String, Object>(4);
          stepState.put("state", "unavailable");
          stepState.put("required", true);
          stepState.put("errorMsg", null);
          stepState.put("invalidFields", new ArrayList<String>());
          clone.getStepStates().put("parentage", stepState);
        
          stepState = new HashMap<String, Object>(4);
          stepState.put("state", "unavailable");
          stepState.put("required", true);
          stepState.put("errorMsg", null);
          stepState.put("invalidFields", new ArrayList<String>());
          clone.getStepStates().put("situation", stepState);
        
          stepState = new HashMap<String, Object>(4);
          stepState.put("state", "unavailable");
          stepState.put("required", false);
          stepState.put("errorMsg", null);
          stepState.put("invalidFields", new ArrayList<String>());
          clone.getStepStates().put("exemption", stepState);
        
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

  
    public final void setAffectionOrDisease(final Boolean affectionOrDisease) {
        militaryCensusRequestData.setAffectionOrDisease(affectionOrDisease);
    }

    
    public final Boolean getAffectionOrDisease() {
        return militaryCensusRequestData.getAffectionOrDisease();
    }
  
    public final void setAliveChildren(final java.math.BigInteger aliveChildren) {
        militaryCensusRequestData.setAliveChildren(aliveChildren);
    }

    
    public final java.math.BigInteger getAliveChildren() {
        return militaryCensusRequestData.getAliveChildren();
    }
  
    public final void setChildBirthCountry(final fr.cg95.cvq.business.users.CountryType childBirthCountry) {
        militaryCensusRequestData.setChildBirthCountry(childBirthCountry);
    }

    
    public final fr.cg95.cvq.business.users.CountryType getChildBirthCountry() {
        return militaryCensusRequestData.getChildBirthCountry();
    }
  
    public final void setChildConvention(final String childConvention) {
        militaryCensusRequestData.setChildConvention(childConvention);
    }

    
    public final String getChildConvention() {
        return militaryCensusRequestData.getChildConvention();
    }
  
    public final void setChildCountry(final fr.cg95.cvq.business.users.FullNationalityType childCountry) {
        militaryCensusRequestData.setChildCountry(childCountry);
    }

    
    public final fr.cg95.cvq.business.users.FullNationalityType getChildCountry() {
        return militaryCensusRequestData.getChildCountry();
    }
  
    public final void setChildDiploma(final fr.cg95.cvq.business.request.military.ChildDiplomaType childDiploma) {
        militaryCensusRequestData.setChildDiploma(childDiploma);
    }

    
    public final fr.cg95.cvq.business.request.military.ChildDiplomaType getChildDiploma() {
        return militaryCensusRequestData.getChildDiploma();
    }
  
    public final void setChildMail(final String childMail) {
        militaryCensusRequestData.setChildMail(childMail);
    }

    
    public final String getChildMail() {
        return militaryCensusRequestData.getChildMail();
    }
  
    public final void setChildOtherCountry(final fr.cg95.cvq.business.users.FullNationalityType childOtherCountry) {
        militaryCensusRequestData.setChildOtherCountry(childOtherCountry);
    }

    
    public final fr.cg95.cvq.business.users.FullNationalityType getChildOtherCountry() {
        return militaryCensusRequestData.getChildOtherCountry();
    }
  
    public final void setChildPhone(final String childPhone) {
        militaryCensusRequestData.setChildPhone(childPhone);
    }

    
    public final String getChildPhone() {
        return militaryCensusRequestData.getChildPhone();
    }
  
    public final void setChildProfession(final String childProfession) {
        militaryCensusRequestData.setChildProfession(childProfession);
    }

    
    public final String getChildProfession() {
        return militaryCensusRequestData.getChildProfession();
    }
  
    public final void setChildResidenceCountry(final fr.cg95.cvq.business.users.CountryType childResidenceCountry) {
        militaryCensusRequestData.setChildResidenceCountry(childResidenceCountry);
    }

    
    public final fr.cg95.cvq.business.users.CountryType getChildResidenceCountry() {
        return militaryCensusRequestData.getChildResidenceCountry();
    }
  
    public final void setChildSituation(final fr.cg95.cvq.business.request.military.ChildSituationType childSituation) {
        militaryCensusRequestData.setChildSituation(childSituation);
    }

    
    public final fr.cg95.cvq.business.request.military.ChildSituationType getChildSituation() {
        return militaryCensusRequestData.getChildSituation();
    }
  
    public final void setChildSpeciality(final String childSpeciality) {
        militaryCensusRequestData.setChildSpeciality(childSpeciality);
    }

    
    public final String getChildSpeciality() {
        return militaryCensusRequestData.getChildSpeciality();
    }
  
    public final void setChildStatus(final fr.cg95.cvq.business.users.FamilyStatusType childStatus) {
        militaryCensusRequestData.setChildStatus(childStatus);
    }

    
    public final fr.cg95.cvq.business.users.FamilyStatusType getChildStatus() {
        return militaryCensusRequestData.getChildStatus();
    }
  
    public final void setChildTitle(final fr.cg95.cvq.business.users.TitleType childTitle) {
        militaryCensusRequestData.setChildTitle(childTitle);
    }

    
    public final fr.cg95.cvq.business.users.TitleType getChildTitle() {
        return militaryCensusRequestData.getChildTitle();
    }
  
    public final void setChildrenInCharge(final java.math.BigInteger childrenInCharge) {
        militaryCensusRequestData.setChildrenInCharge(childrenInCharge);
    }

    
    public final java.math.BigInteger getChildrenInCharge() {
        return militaryCensusRequestData.getChildrenInCharge();
    }
  
    public final void setFatherBirthCity(final String fatherBirthCity) {
        militaryCensusRequestData.setFatherBirthCity(fatherBirthCity);
    }

    
    public final String getFatherBirthCity() {
        return militaryCensusRequestData.getFatherBirthCity();
    }
  
    public final void setFatherBirthCountry(final fr.cg95.cvq.business.users.CountryType fatherBirthCountry) {
        militaryCensusRequestData.setFatherBirthCountry(fatherBirthCountry);
    }

    
    public final fr.cg95.cvq.business.users.CountryType getFatherBirthCountry() {
        return militaryCensusRequestData.getFatherBirthCountry();
    }
  
    public final void setFatherBirthDate(final java.util.Date fatherBirthDate) {
        militaryCensusRequestData.setFatherBirthDate(fatherBirthDate);
    }

    
    public final java.util.Date getFatherBirthDate() {
        return militaryCensusRequestData.getFatherBirthDate();
    }
  
    public final void setFatherBirthDepartment(final fr.cg95.cvq.business.users.InseeDepartementCodeType fatherBirthDepartment) {
        militaryCensusRequestData.setFatherBirthDepartment(fatherBirthDepartment);
    }

    
    public final fr.cg95.cvq.business.users.InseeDepartementCodeType getFatherBirthDepartment() {
        return militaryCensusRequestData.getFatherBirthDepartment();
    }
  
    public final void setFatherFirstName(final String fatherFirstName) {
        militaryCensusRequestData.setFatherFirstName(fatherFirstName);
    }

    
    public final String getFatherFirstName() {
        return militaryCensusRequestData.getFatherFirstName();
    }
  
    public final void setFatherLastName(final String fatherLastName) {
        militaryCensusRequestData.setFatherLastName(fatherLastName);
    }

    
    public final String getFatherLastName() {
        return militaryCensusRequestData.getFatherLastName();
    }
  
    public final void setFatherNationality(final fr.cg95.cvq.business.users.FullNationalityType fatherNationality) {
        militaryCensusRequestData.setFatherNationality(fatherNationality);
    }

    
    public final fr.cg95.cvq.business.users.FullNationalityType getFatherNationality() {
        return militaryCensusRequestData.getFatherNationality();
    }
  
    public final void setHighlyInfirm(final Boolean highlyInfirm) {
        militaryCensusRequestData.setHighlyInfirm(highlyInfirm);
    }

    
    public final Boolean getHighlyInfirm() {
        return militaryCensusRequestData.getHighlyInfirm();
    }
  
    public final void setJapdExemption(final Boolean japdExemption) {
        militaryCensusRequestData.setJapdExemption(japdExemption);
    }

    
    public final Boolean getJapdExemption() {
        return militaryCensusRequestData.getJapdExemption();
    }
  
    public final void setMaidenName(final String maidenName) {
        militaryCensusRequestData.setMaidenName(maidenName);
    }

    
    public final String getMaidenName() {
        return militaryCensusRequestData.getMaidenName();
    }
  
    public final void setMotherBirthCity(final String motherBirthCity) {
        militaryCensusRequestData.setMotherBirthCity(motherBirthCity);
    }

    
    public final String getMotherBirthCity() {
        return militaryCensusRequestData.getMotherBirthCity();
    }
  
    public final void setMotherBirthCountry(final fr.cg95.cvq.business.users.CountryType motherBirthCountry) {
        militaryCensusRequestData.setMotherBirthCountry(motherBirthCountry);
    }

    
    public final fr.cg95.cvq.business.users.CountryType getMotherBirthCountry() {
        return militaryCensusRequestData.getMotherBirthCountry();
    }
  
    public final void setMotherBirthDate(final java.util.Date motherBirthDate) {
        militaryCensusRequestData.setMotherBirthDate(motherBirthDate);
    }

    
    public final java.util.Date getMotherBirthDate() {
        return militaryCensusRequestData.getMotherBirthDate();
    }
  
    public final void setMotherBirthDepartment(final fr.cg95.cvq.business.users.InseeDepartementCodeType motherBirthDepartment) {
        militaryCensusRequestData.setMotherBirthDepartment(motherBirthDepartment);
    }

    
    public final fr.cg95.cvq.business.users.InseeDepartementCodeType getMotherBirthDepartment() {
        return militaryCensusRequestData.getMotherBirthDepartment();
    }
  
    public final void setMotherFirstName(final String motherFirstName) {
        militaryCensusRequestData.setMotherFirstName(motherFirstName);
    }

    
    public final String getMotherFirstName() {
        return militaryCensusRequestData.getMotherFirstName();
    }
  
    public final void setMotherLastName(final String motherLastName) {
        militaryCensusRequestData.setMotherLastName(motherLastName);
    }

    
    public final String getMotherLastName() {
        return militaryCensusRequestData.getMotherLastName();
    }
  
    public final void setMotherNationality(final fr.cg95.cvq.business.users.FullNationalityType motherNationality) {
        militaryCensusRequestData.setMotherNationality(motherNationality);
    }

    
    public final fr.cg95.cvq.business.users.FullNationalityType getMotherNationality() {
        return militaryCensusRequestData.getMotherNationality();
    }
  
    public final void setOtherSituation(final String otherSituation) {
        militaryCensusRequestData.setOtherSituation(otherSituation);
    }

    
    public final String getOtherSituation() {
        return militaryCensusRequestData.getOtherSituation();
    }
  
    public final void setPrefectPupil(final Boolean prefectPupil) {
        militaryCensusRequestData.setPrefectPupil(prefectPupil);
    }

    
    public final Boolean getPrefectPupil() {
        return militaryCensusRequestData.getPrefectPupil();
    }
  
    public final void setPrefectPupilDepartment(final fr.cg95.cvq.business.users.InseeDepartementCodeType prefectPupilDepartment) {
        militaryCensusRequestData.setPrefectPupilDepartment(prefectPupilDepartment);
    }

    
    public final fr.cg95.cvq.business.users.InseeDepartementCodeType getPrefectPupilDepartment() {
        return militaryCensusRequestData.getPrefectPupilDepartment();
    }
  
    public final void setStatePupil(final Boolean statePupil) {
        militaryCensusRequestData.setStatePupil(statePupil);
    }

    
    public final Boolean getStatePupil() {
        return militaryCensusRequestData.getStatePupil();
    }
  
}
