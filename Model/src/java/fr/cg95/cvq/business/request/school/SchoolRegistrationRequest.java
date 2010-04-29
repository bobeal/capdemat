
package fr.cg95.cvq.business.request.school;

import java.io.Serializable;
import java.math.BigInteger;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

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
public class SchoolRegistrationRequest extends Request implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final Map<String, IConditionChecker> conditions = SchoolRegistrationRequestData.conditions;

    @AssertValid(message = "")
    private SchoolRegistrationRequestData schoolRegistrationRequestData;

    public SchoolRegistrationRequest(RequestData requestData, SchoolRegistrationRequestData schoolRegistrationRequestData) {
        super(requestData);
        this.schoolRegistrationRequestData = schoolRegistrationRequestData;
    }

    public SchoolRegistrationRequest() {
        super();
        this.schoolRegistrationRequestData = new SchoolRegistrationRequestData();
    }

    /**
     * Reserved for RequestDAO !
     */
    @Override
    public SchoolRegistrationRequestData getSpecificData() {
        return schoolRegistrationRequestData;
    }

    /**
     * Reserved for RequestDAO !
     */
    public void setSpecificData(SchoolRegistrationRequestData schoolRegistrationRequestData) {
        this.schoolRegistrationRequestData = schoolRegistrationRequestData;
    }

    @Override
    public final String modelToXmlString() {
        SchoolRegistrationRequestDocument object = this.modelToXml();
        XmlOptions opts = new XmlOptions();
        opts.setSavePrettyPrint();
        opts.setSavePrettyPrintIndent(4);
        opts.setUseDefaultNamespace();
        opts.setCharacterEncoding("UTF-8");
        return object.xmlText(opts);
    }

    @Override
    public final SchoolRegistrationRequestDocument modelToXml() {
        
        Calendar calendar = Calendar.getInstance();
        Date date = null;
        SchoolRegistrationRequestDocument schoolRegistrationRequestDoc = SchoolRegistrationRequestDocument.Factory.newInstance();
        SchoolRegistrationRequestDocument.SchoolRegistrationRequest schoolRegistrationRequest = schoolRegistrationRequestDoc.addNewSchoolRegistrationRequest();
        super.fillCommonXmlInfo(schoolRegistrationRequest);
        int i = 0;
          CurrentSchoolType currentSchoolTypeCurrentSchool = schoolRegistrationRequest.addNewCurrentSchool();
        currentSchoolTypeCurrentSchool.setCurrentSchoolAddress(getCurrentSchoolAddress());
      
        currentSchoolTypeCurrentSchool.setCurrentSchoolName(getCurrentSchoolName());
      
        if (getCurrentSection() != null)
            currentSchoolTypeCurrentSchool.setCurrentSection(fr.cg95.cvq.xml.common.SectionType.Enum.forString(getCurrentSection().toString()));
      
        if (getSchool() != null)
            schoolRegistrationRequest.setSchool(School.modelToXml(getSchool()));
      
        if (getRulesAndRegulationsAcceptance() != null)
            schoolRegistrationRequest.setRulesAndRegulationsAcceptance(getRulesAndRegulationsAcceptance().booleanValue());
      
        schoolRegistrationRequest.setUrgencyPhone(getUrgencyPhone());
      
        if (getSection() != null)
            schoolRegistrationRequest.setSection(fr.cg95.cvq.xml.common.SectionType.Enum.forString(getSection().toString()));
      
        return schoolRegistrationRequestDoc;
    }

    @Override
    public final SchoolRegistrationRequestDocument.SchoolRegistrationRequest modelToXmlRequest() {
        return modelToXml().getSchoolRegistrationRequest();
    }

    public static SchoolRegistrationRequest xmlToModel(SchoolRegistrationRequestDocument schoolRegistrationRequestDoc) {
        SchoolRegistrationRequestDocument.SchoolRegistrationRequest schoolRegistrationRequestXml = schoolRegistrationRequestDoc.getSchoolRegistrationRequest();
        Calendar calendar = Calendar.getInstance();
        List list = new ArrayList();
        SchoolRegistrationRequest schoolRegistrationRequest = new SchoolRegistrationRequest();
        schoolRegistrationRequest.fillCommonModelInfo(schoolRegistrationRequest, schoolRegistrationRequestXml);
        
        schoolRegistrationRequest.setCurrentSchoolAddress(schoolRegistrationRequestXml.getCurrentSchool().getCurrentSchoolAddress());
      
        schoolRegistrationRequest.setCurrentSchoolName(schoolRegistrationRequestXml.getCurrentSchool().getCurrentSchoolName());
      
        if (schoolRegistrationRequestXml.getCurrentSchool().getCurrentSection() != null)
            schoolRegistrationRequest.setCurrentSection(fr.cg95.cvq.business.users.SectionType.forString(schoolRegistrationRequestXml.getCurrentSchool().getCurrentSection().toString()));
        else
            schoolRegistrationRequest.setCurrentSection(fr.cg95.cvq.business.users.SectionType.getDefaultSectionType());
      
        if (schoolRegistrationRequestXml.getSchool() != null)
            schoolRegistrationRequest.setSchool(School.xmlToModel(schoolRegistrationRequestXml.getSchool()));
      
        schoolRegistrationRequest.setRulesAndRegulationsAcceptance(Boolean.valueOf(schoolRegistrationRequestXml.getRulesAndRegulationsAcceptance()));
      
        schoolRegistrationRequest.setUrgencyPhone(schoolRegistrationRequestXml.getUrgencyPhone());
      
        if (schoolRegistrationRequestXml.getSection() != null)
            schoolRegistrationRequest.setSection(fr.cg95.cvq.business.users.SectionType.forString(schoolRegistrationRequestXml.getSection().toString()));
        else
            schoolRegistrationRequest.setSection(fr.cg95.cvq.business.users.SectionType.getDefaultSectionType());
      
        return schoolRegistrationRequest;
    }

  
    public final void setCurrentSchoolAddress(final String currentSchoolAddress) {
        schoolRegistrationRequestData.setCurrentSchoolAddress(currentSchoolAddress);
    }

    
    public final String getCurrentSchoolAddress() {
        return schoolRegistrationRequestData.getCurrentSchoolAddress();
    }
  
    public final void setCurrentSchoolName(final String currentSchoolName) {
        schoolRegistrationRequestData.setCurrentSchoolName(currentSchoolName);
    }

    
    public final String getCurrentSchoolName() {
        return schoolRegistrationRequestData.getCurrentSchoolName();
    }
  
    public final void setCurrentSection(final fr.cg95.cvq.business.users.SectionType currentSection) {
        schoolRegistrationRequestData.setCurrentSection(currentSection);
    }

    
    public final fr.cg95.cvq.business.users.SectionType getCurrentSection() {
        return schoolRegistrationRequestData.getCurrentSection();
    }
  
    public final void setSchool(final fr.cg95.cvq.business.authority.School school) {
        schoolRegistrationRequestData.setSchool(school);
    }

    
    public final fr.cg95.cvq.business.authority.School getSchool() {
        return schoolRegistrationRequestData.getSchool();
    }
  
    public final void setRulesAndRegulationsAcceptance(final Boolean rulesAndRegulationsAcceptance) {
        schoolRegistrationRequestData.setRulesAndRegulationsAcceptance(rulesAndRegulationsAcceptance);
    }

    @IsRulesAcceptance
    public final Boolean getRulesAndRegulationsAcceptance() {
        return schoolRegistrationRequestData.getRulesAndRegulationsAcceptance();
    }
  
    public final void setUrgencyPhone(final String urgencyPhone) {
        schoolRegistrationRequestData.setUrgencyPhone(urgencyPhone);
    }

    
    public final String getUrgencyPhone() {
        return schoolRegistrationRequestData.getUrgencyPhone();
    }
  
    public final void setSection(final fr.cg95.cvq.business.users.SectionType section) {
        schoolRegistrationRequestData.setSection(section);
    }

    
    public final fr.cg95.cvq.business.users.SectionType getSection() {
        return schoolRegistrationRequestData.getSection();
    }
  
}
