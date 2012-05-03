
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
public class SchoolRegistrationSimplifyRequest extends Request implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final Map<String, IConditionChecker> conditions = SchoolRegistrationSimplifyRequestData.conditions;

    @AssertValid(message = "")
    private SchoolRegistrationSimplifyRequestData schoolRegistrationSimplifyRequestData;

    public SchoolRegistrationSimplifyRequest(RequestData requestData, SchoolRegistrationSimplifyRequestData schoolRegistrationSimplifyRequestData) {
        super(requestData);
        this.schoolRegistrationSimplifyRequestData = schoolRegistrationSimplifyRequestData;
    }

    public SchoolRegistrationSimplifyRequest() {
        super();
        this.schoolRegistrationSimplifyRequestData = new SchoolRegistrationSimplifyRequestData();
    }

    /**
     * Reserved for RequestDAO !
     */
    @Override
    public SchoolRegistrationSimplifyRequestData getSpecificData() {
        return schoolRegistrationSimplifyRequestData;
    }

    /**
     * Reserved for RequestDAO !
     */
    public void setSpecificData(SchoolRegistrationSimplifyRequestData schoolRegistrationSimplifyRequestData) {
        this.schoolRegistrationSimplifyRequestData = schoolRegistrationSimplifyRequestData;
    }

    @Override
    public final String modelToXmlString() {
        SchoolRegistrationSimplifyRequestDocument object = this.modelToXml();
        XmlOptions opts = new XmlOptions();
        opts.setSavePrettyPrint();
        opts.setSavePrettyPrintIndent(4);
        opts.setUseDefaultNamespace();
        opts.setCharacterEncoding("UTF-8");
        return object.xmlText(opts);
    }

    @Override
    public final SchoolRegistrationSimplifyRequestDocument modelToXml() {
        
        Calendar calendar = Calendar.getInstance();
        Date date = null;
        SchoolRegistrationSimplifyRequestDocument schoolRegistrationSimplifyRequestDoc = SchoolRegistrationSimplifyRequestDocument.Factory.newInstance();
        SchoolRegistrationSimplifyRequestDocument.SchoolRegistrationSimplifyRequest schoolRegistrationSimplifyRequest = schoolRegistrationSimplifyRequestDoc.addNewSchoolRegistrationSimplifyRequest();
        super.fillCommonXmlInfo(schoolRegistrationSimplifyRequest);
        int i = 0;
        
        schoolRegistrationSimplifyRequest.setEmergencyContactName(getEmergencyContactName());
      
        schoolRegistrationSimplifyRequest.setCurrentSchoolAddress(getCurrentSchoolAddress());
      
        schoolRegistrationSimplifyRequest.setEmergencyPhone(getEmergencyPhone());
      
        schoolRegistrationSimplifyRequest.setCurrentSchoolName(getCurrentSchoolName());
      
        schoolRegistrationSimplifyRequest.setCurrentSchoolLevel(getCurrentSchoolLevel());
      
        i = 0;
        if (getSection() != null) {
            fr.cg95.cvq.xml.common.LocalReferentialDataType[] sectionTypeTab = new fr.cg95.cvq.xml.common.LocalReferentialDataType[getSection().size()];
            for (LocalReferentialData object : getSection()) {
              sectionTypeTab[i++] = LocalReferentialData.modelToXml(object);
            }
            schoolRegistrationSimplifyRequest.setSectionArray(sectionTypeTab);
        }
      
        if (getExistRegistration() != null)
            schoolRegistrationSimplifyRequest.setExistRegistration(getExistRegistration().booleanValue());
      
        return schoolRegistrationSimplifyRequestDoc;
    }

    @Override
    public final SchoolRegistrationSimplifyRequestDocument.SchoolRegistrationSimplifyRequest modelToXmlRequest() {
        return modelToXml().getSchoolRegistrationSimplifyRequest();
    }

    public static SchoolRegistrationSimplifyRequest xmlToModel(SchoolRegistrationSimplifyRequestDocument schoolRegistrationSimplifyRequestDoc) {
        SchoolRegistrationSimplifyRequestDocument.SchoolRegistrationSimplifyRequest schoolRegistrationSimplifyRequestXml = schoolRegistrationSimplifyRequestDoc.getSchoolRegistrationSimplifyRequest();
        Calendar calendar = Calendar.getInstance();
        List list = new ArrayList();
        SchoolRegistrationSimplifyRequest schoolRegistrationSimplifyRequest = new SchoolRegistrationSimplifyRequest();
        schoolRegistrationSimplifyRequest.fillCommonModelInfo(schoolRegistrationSimplifyRequest, schoolRegistrationSimplifyRequestXml);
        
        schoolRegistrationSimplifyRequest.setEmergencyContactName(schoolRegistrationSimplifyRequestXml.getEmergencyContactName());
      
        schoolRegistrationSimplifyRequest.setCurrentSchoolAddress(schoolRegistrationSimplifyRequestXml.getCurrentSchoolAddress());
      
        schoolRegistrationSimplifyRequest.setEmergencyPhone(schoolRegistrationSimplifyRequestXml.getEmergencyPhone());
      
        schoolRegistrationSimplifyRequest.setCurrentSchoolName(schoolRegistrationSimplifyRequestXml.getCurrentSchoolName());
      
        schoolRegistrationSimplifyRequest.setCurrentSchoolLevel(schoolRegistrationSimplifyRequestXml.getCurrentSchoolLevel());
      
        List<fr.cg95.cvq.business.request.LocalReferentialData> sectionList = new ArrayList<fr.cg95.cvq.business.request.LocalReferentialData>(schoolRegistrationSimplifyRequestXml.sizeOfSectionArray());
        for (LocalReferentialDataType object : schoolRegistrationSimplifyRequestXml.getSectionArray()) {
            sectionList.add(fr.cg95.cvq.business.request.LocalReferentialData.xmlToModel(object));
        }
        schoolRegistrationSimplifyRequest.setSection(sectionList);
      
        schoolRegistrationSimplifyRequest.setExistRegistration(Boolean.valueOf(schoolRegistrationSimplifyRequestXml.getExistRegistration()));
      
        return schoolRegistrationSimplifyRequest;
    }

  
    public final void setEmergencyContactName(final String emergencyContactName) {
        schoolRegistrationSimplifyRequestData.setEmergencyContactName(emergencyContactName);
    }

    
    public final String getEmergencyContactName() {
        return schoolRegistrationSimplifyRequestData.getEmergencyContactName();
    }
  
    public final void setCurrentSchoolAddress(final String currentSchoolAddress) {
        schoolRegistrationSimplifyRequestData.setCurrentSchoolAddress(currentSchoolAddress);
    }

    
    public final String getCurrentSchoolAddress() {
        return schoolRegistrationSimplifyRequestData.getCurrentSchoolAddress();
    }
  
    public final void setEmergencyPhone(final String emergencyPhone) {
        schoolRegistrationSimplifyRequestData.setEmergencyPhone(emergencyPhone);
    }

    
    public final String getEmergencyPhone() {
        return schoolRegistrationSimplifyRequestData.getEmergencyPhone();
    }
  
    public final void setCurrentSchoolName(final String currentSchoolName) {
        schoolRegistrationSimplifyRequestData.setCurrentSchoolName(currentSchoolName);
    }

    
    public final String getCurrentSchoolName() {
        return schoolRegistrationSimplifyRequestData.getCurrentSchoolName();
    }
  
    public final void setCurrentSchoolLevel(final String currentSchoolLevel) {
        schoolRegistrationSimplifyRequestData.setCurrentSchoolLevel(currentSchoolLevel);
    }

    
    public final String getCurrentSchoolLevel() {
        return schoolRegistrationSimplifyRequestData.getCurrentSchoolLevel();
    }
  
    public final void setSection(final List<fr.cg95.cvq.business.request.LocalReferentialData> section) {
        schoolRegistrationSimplifyRequestData.setSection(section);
    }

    
    public final List<fr.cg95.cvq.business.request.LocalReferentialData> getSection() {
        return schoolRegistrationSimplifyRequestData.getSection();
    }
  
    public final void setExistRegistration(final Boolean existRegistration) {
        schoolRegistrationSimplifyRequestData.setExistRegistration(existRegistration);
    }

    
    public final Boolean getExistRegistration() {
        return schoolRegistrationSimplifyRequestData.getExistRegistration();
    }
  
}
