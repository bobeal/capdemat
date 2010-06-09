
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
public class SchoolCanteenRegistrationRequest extends Request implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final Map<String, IConditionChecker> conditions = SchoolCanteenRegistrationRequestData.conditions;

    @AssertValid(message = "")
    private SchoolCanteenRegistrationRequestData schoolCanteenRegistrationRequestData;

    public SchoolCanteenRegistrationRequest(RequestData requestData, SchoolCanteenRegistrationRequestData schoolCanteenRegistrationRequestData) {
        super(requestData);
        this.schoolCanteenRegistrationRequestData = schoolCanteenRegistrationRequestData;
    }

    public SchoolCanteenRegistrationRequest() {
        super();
        this.schoolCanteenRegistrationRequestData = new SchoolCanteenRegistrationRequestData();
        Map<String, Object> stepState;
        
          stepState = new HashMap<String, Object>(4);
          stepState.put("state", "uncomplete");
          stepState.put("required", true);
          stepState.put("errorMsg", null);
          stepState.put("invalidFields", new ArrayList<String>());
          getStepStates().put("registration", stepState);
        
          stepState = new HashMap<String, Object>(4);
          stepState.put("state", "uncomplete");
          stepState.put("required", true);
          stepState.put("errorMsg", null);
          stepState.put("invalidFields", new ArrayList<String>());
          getStepStates().put("rules", stepState);
        
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
    public SchoolCanteenRegistrationRequestData getSpecificData() {
        return schoolCanteenRegistrationRequestData;
    }

    /**
     * Reserved for RequestDAO !
     */
    public void setSpecificData(SchoolCanteenRegistrationRequestData schoolCanteenRegistrationRequestData) {
        this.schoolCanteenRegistrationRequestData = schoolCanteenRegistrationRequestData;
    }

    @Override
    public final String modelToXmlString() {
        SchoolCanteenRegistrationRequestDocument object = this.modelToXml();
        XmlOptions opts = new XmlOptions();
        opts.setSavePrettyPrint();
        opts.setSavePrettyPrintIndent(4);
        opts.setUseDefaultNamespace();
        opts.setCharacterEncoding("UTF-8");
        return object.xmlText(opts);
    }

    @Override
    public final SchoolCanteenRegistrationRequestDocument modelToXml() {
        
        Calendar calendar = Calendar.getInstance();
        LocalTime localTime = new LocalTime();
        Date date = null;
        SchoolCanteenRegistrationRequestDocument schoolCanteenRegistrationRequestDoc = SchoolCanteenRegistrationRequestDocument.Factory.newInstance();
        SchoolCanteenRegistrationRequestDocument.SchoolCanteenRegistrationRequest schoolCanteenRegistrationRequest = schoolCanteenRegistrationRequestDoc.addNewSchoolCanteenRegistrationRequest();
        super.fillCommonXmlInfo(schoolCanteenRegistrationRequest);
        int i = 0;
        
        i = 0;
        if (getFoodDiet() != null) {
            fr.cg95.cvq.xml.common.LocalReferentialDataType[] foodDietTypeTab = new fr.cg95.cvq.xml.common.LocalReferentialDataType[getFoodDiet().size()];
            for (LocalReferentialData object : getFoodDiet()) {
              foodDietTypeTab[i++] = LocalReferentialData.modelToXml(object);
            }
            schoolCanteenRegistrationRequest.setFoodDietArray(foodDietTypeTab);
        }
      
        if (getFoodAllergy() != null)
            schoolCanteenRegistrationRequest.setFoodAllergy(getFoodAllergy().booleanValue());
      
        schoolCanteenRegistrationRequest.setDoctorPhone(getDoctorPhone());
      
        schoolCanteenRegistrationRequest.setDoctorName(getDoctorName());
      
        i = 0;
        if (getCanteenAttendingDays() != null) {
            fr.cg95.cvq.xml.common.LocalReferentialDataType[] canteenAttendingDaysTypeTab = new fr.cg95.cvq.xml.common.LocalReferentialDataType[getCanteenAttendingDays().size()];
            for (LocalReferentialData object : getCanteenAttendingDays()) {
              canteenAttendingDaysTypeTab[i++] = LocalReferentialData.modelToXml(object);
            }
            schoolCanteenRegistrationRequest.setCanteenAttendingDaysArray(canteenAttendingDaysTypeTab);
        }
      
        if (getSchool() != null)
            schoolCanteenRegistrationRequest.setSchool(School.modelToXml(getSchool()));
      
        if (getHospitalizationPermission() != null)
            schoolCanteenRegistrationRequest.setHospitalizationPermission(getHospitalizationPermission().booleanValue());
      
        if (getRulesAndRegulationsAcceptance() != null)
            schoolCanteenRegistrationRequest.setRulesAndRegulationsAcceptance(getRulesAndRegulationsAcceptance().booleanValue());
      
        schoolCanteenRegistrationRequest.setUrgencyPhone(getUrgencyPhone());
      
        if (getSection() != null)
            schoolCanteenRegistrationRequest.setSection(fr.cg95.cvq.xml.common.SectionType.Enum.forString(getSection().toString()));
      
        return schoolCanteenRegistrationRequestDoc;
    }

    @Override
    public final SchoolCanteenRegistrationRequestDocument.SchoolCanteenRegistrationRequest modelToXmlRequest() {
        return modelToXml().getSchoolCanteenRegistrationRequest();
    }

    public static SchoolCanteenRegistrationRequest xmlToModel(SchoolCanteenRegistrationRequestDocument schoolCanteenRegistrationRequestDoc) {
        SchoolCanteenRegistrationRequestDocument.SchoolCanteenRegistrationRequest schoolCanteenRegistrationRequestXml = schoolCanteenRegistrationRequestDoc.getSchoolCanteenRegistrationRequest();
        Calendar calendar = Calendar.getInstance();
        LocalTime localTime = new LocalTime();
        List list = new ArrayList();
        SchoolCanteenRegistrationRequest schoolCanteenRegistrationRequest = new SchoolCanteenRegistrationRequest();
        schoolCanteenRegistrationRequest.fillCommonModelInfo(schoolCanteenRegistrationRequest, schoolCanteenRegistrationRequestXml);
        
        List<fr.cg95.cvq.business.request.LocalReferentialData> foodDietList = new ArrayList<fr.cg95.cvq.business.request.LocalReferentialData>(schoolCanteenRegistrationRequestXml.sizeOfFoodDietArray());
        for (LocalReferentialDataType object : schoolCanteenRegistrationRequestXml.getFoodDietArray()) {
            foodDietList.add(fr.cg95.cvq.business.request.LocalReferentialData.xmlToModel(object));
        }
        schoolCanteenRegistrationRequest.setFoodDiet(foodDietList);
      
        schoolCanteenRegistrationRequest.setFoodAllergy(Boolean.valueOf(schoolCanteenRegistrationRequestXml.getFoodAllergy()));
      
        schoolCanteenRegistrationRequest.setDoctorPhone(schoolCanteenRegistrationRequestXml.getDoctorPhone());
      
        schoolCanteenRegistrationRequest.setDoctorName(schoolCanteenRegistrationRequestXml.getDoctorName());
      
        List<fr.cg95.cvq.business.request.LocalReferentialData> canteenAttendingDaysList = new ArrayList<fr.cg95.cvq.business.request.LocalReferentialData>(schoolCanteenRegistrationRequestXml.sizeOfCanteenAttendingDaysArray());
        for (LocalReferentialDataType object : schoolCanteenRegistrationRequestXml.getCanteenAttendingDaysArray()) {
            canteenAttendingDaysList.add(fr.cg95.cvq.business.request.LocalReferentialData.xmlToModel(object));
        }
        schoolCanteenRegistrationRequest.setCanteenAttendingDays(canteenAttendingDaysList);
      
        if (schoolCanteenRegistrationRequestXml.getSchool() != null)
            schoolCanteenRegistrationRequest.setSchool(School.xmlToModel(schoolCanteenRegistrationRequestXml.getSchool()));
      
        schoolCanteenRegistrationRequest.setHospitalizationPermission(Boolean.valueOf(schoolCanteenRegistrationRequestXml.getHospitalizationPermission()));
      
        schoolCanteenRegistrationRequest.setRulesAndRegulationsAcceptance(Boolean.valueOf(schoolCanteenRegistrationRequestXml.getRulesAndRegulationsAcceptance()));
      
        schoolCanteenRegistrationRequest.setUrgencyPhone(schoolCanteenRegistrationRequestXml.getUrgencyPhone());
      
        if (schoolCanteenRegistrationRequestXml.getSection() != null)
            schoolCanteenRegistrationRequest.setSection(fr.cg95.cvq.business.users.SectionType.forString(schoolCanteenRegistrationRequestXml.getSection().toString()));
        else
            schoolCanteenRegistrationRequest.setSection(fr.cg95.cvq.business.users.SectionType.getDefaultSectionType());
      
        return schoolCanteenRegistrationRequest;
    }

  
    public final void setFoodDiet(final List<fr.cg95.cvq.business.request.LocalReferentialData> foodDiet) {
        schoolCanteenRegistrationRequestData.setFoodDiet(foodDiet);
    }

    
    public final List<fr.cg95.cvq.business.request.LocalReferentialData> getFoodDiet() {
        return schoolCanteenRegistrationRequestData.getFoodDiet();
    }
  
    public final void setFoodAllergy(final Boolean foodAllergy) {
        schoolCanteenRegistrationRequestData.setFoodAllergy(foodAllergy);
    }

    
    public final Boolean getFoodAllergy() {
        return schoolCanteenRegistrationRequestData.getFoodAllergy();
    }
  
    public final void setDoctorPhone(final String doctorPhone) {
        schoolCanteenRegistrationRequestData.setDoctorPhone(doctorPhone);
    }

    
    public final String getDoctorPhone() {
        return schoolCanteenRegistrationRequestData.getDoctorPhone();
    }
  
    public final void setDoctorName(final String doctorName) {
        schoolCanteenRegistrationRequestData.setDoctorName(doctorName);
    }

    
    public final String getDoctorName() {
        return schoolCanteenRegistrationRequestData.getDoctorName();
    }
  
    public final void setCanteenAttendingDays(final List<fr.cg95.cvq.business.request.LocalReferentialData> canteenAttendingDays) {
        schoolCanteenRegistrationRequestData.setCanteenAttendingDays(canteenAttendingDays);
    }

    
    public final List<fr.cg95.cvq.business.request.LocalReferentialData> getCanteenAttendingDays() {
        return schoolCanteenRegistrationRequestData.getCanteenAttendingDays();
    }
  
    public final void setSchool(final fr.cg95.cvq.business.authority.School school) {
        schoolCanteenRegistrationRequestData.setSchool(school);
    }

    
    public final fr.cg95.cvq.business.authority.School getSchool() {
        return schoolCanteenRegistrationRequestData.getSchool();
    }
  
    public final void setHospitalizationPermission(final Boolean hospitalizationPermission) {
        schoolCanteenRegistrationRequestData.setHospitalizationPermission(hospitalizationPermission);
    }

    @IsRulesAcceptance
    public final Boolean getHospitalizationPermission() {
        return schoolCanteenRegistrationRequestData.getHospitalizationPermission();
    }
  
    public final void setRulesAndRegulationsAcceptance(final Boolean rulesAndRegulationsAcceptance) {
        schoolCanteenRegistrationRequestData.setRulesAndRegulationsAcceptance(rulesAndRegulationsAcceptance);
    }

    @IsRulesAcceptance
    public final Boolean getRulesAndRegulationsAcceptance() {
        return schoolCanteenRegistrationRequestData.getRulesAndRegulationsAcceptance();
    }
  
    public final void setUrgencyPhone(final String urgencyPhone) {
        schoolCanteenRegistrationRequestData.setUrgencyPhone(urgencyPhone);
    }

    
    public final String getUrgencyPhone() {
        return schoolCanteenRegistrationRequestData.getUrgencyPhone();
    }
  
    public final void setSection(final fr.cg95.cvq.business.users.SectionType section) {
        schoolCanteenRegistrationRequestData.setSection(section);
    }

    
    public final fr.cg95.cvq.business.users.SectionType getSection() {
        return schoolCanteenRegistrationRequestData.getSection();
    }
  
}
