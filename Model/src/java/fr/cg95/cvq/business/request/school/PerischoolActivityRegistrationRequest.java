
package fr.cg95.cvq.business.request.school;

import java.io.Serializable;
import java.math.BigInteger;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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
public class PerischoolActivityRegistrationRequest extends Request implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final Map<String, IConditionChecker> conditions = PerischoolActivityRegistrationRequestData.conditions;

    @AssertValid(message = "")
    private PerischoolActivityRegistrationRequestData perischoolActivityRegistrationRequestData;

    public PerischoolActivityRegistrationRequest(RequestData requestData, PerischoolActivityRegistrationRequestData perischoolActivityRegistrationRequestData) {
        super(requestData);
        this.perischoolActivityRegistrationRequestData = perischoolActivityRegistrationRequestData;
    }

    public PerischoolActivityRegistrationRequest() {
        super();
        this.perischoolActivityRegistrationRequestData = new PerischoolActivityRegistrationRequestData();
    }

    /**
     * Reserved for RequestDAO !
     */
    @Override
    public PerischoolActivityRegistrationRequestData getSpecificData() {
        return perischoolActivityRegistrationRequestData;
    }

    /**
     * Reserved for RequestDAO !
     */
    public void setSpecificData(PerischoolActivityRegistrationRequestData perischoolActivityRegistrationRequestData) {
        this.perischoolActivityRegistrationRequestData = perischoolActivityRegistrationRequestData;
    }

    @Override
    public final String modelToXmlString() {
        PerischoolActivityRegistrationRequestDocument object = this.modelToXml();
        XmlOptions opts = new XmlOptions();
        opts.setSavePrettyPrint();
        opts.setSavePrettyPrintIndent(4);
        opts.setUseDefaultNamespace();
        opts.setCharacterEncoding("UTF-8");
        return object.xmlText(opts);
    }

    @Override
    public final PerischoolActivityRegistrationRequestDocument modelToXml() {
        
        Calendar calendar = Calendar.getInstance();
        LocalTime localTime = new LocalTime();
        Date date = null;
        PerischoolActivityRegistrationRequestDocument perischoolActivityRegistrationRequestDoc = PerischoolActivityRegistrationRequestDocument.Factory.newInstance();
        PerischoolActivityRegistrationRequestDocument.PerischoolActivityRegistrationRequest perischoolActivityRegistrationRequest = perischoolActivityRegistrationRequestDoc.addNewPerischoolActivityRegistrationRequest();
        super.fillCommonXmlInfo(perischoolActivityRegistrationRequest);
        int i = 0;
        
        i = 0;
        if (getAuthorizedIndividuals() != null) {
            fr.cg95.cvq.xml.request.school.PerischoolAuthorizedIndividualType[] authorizedIndividualsTypeTab = new fr.cg95.cvq.xml.request.school.PerischoolAuthorizedIndividualType[getAuthorizedIndividuals().size()];
            for (PerischoolAuthorizedIndividual object : getAuthorizedIndividuals()) {
              authorizedIndividualsTypeTab[i++] = object.modelToXml();
            }
            perischoolActivityRegistrationRequest.setAuthorizedIndividualsArray(authorizedIndividualsTypeTab);
        }
      
        if (getChildPhotoExploitationPermission() != null)
            perischoolActivityRegistrationRequest.setChildPhotoExploitationPermission(getChildPhotoExploitationPermission().booleanValue());
      
        if (getClassTripPermission() != null)
            perischoolActivityRegistrationRequest.setClassTripPermission(getClassTripPermission().booleanValue());
      
        i = 0;
        if (getContactIndividuals() != null) {
            fr.cg95.cvq.xml.request.school.PerischoolContactIndividualType[] contactIndividualsTypeTab = new fr.cg95.cvq.xml.request.school.PerischoolContactIndividualType[getContactIndividuals().size()];
            for (PerischoolContactIndividual object : getContactIndividuals()) {
              contactIndividualsTypeTab[i++] = object.modelToXml();
            }
            perischoolActivityRegistrationRequest.setContactIndividualsArray(contactIndividualsTypeTab);
        }
      
        if (getHospitalizationPermission() != null)
            perischoolActivityRegistrationRequest.setHospitalizationPermission(getHospitalizationPermission().booleanValue());
      
        i = 0;
        if (getPerischoolActivity() != null) {
            fr.cg95.cvq.xml.common.LocalReferentialDataType[] perischoolActivityTypeTab = new fr.cg95.cvq.xml.common.LocalReferentialDataType[getPerischoolActivity().size()];
            for (LocalReferentialData object : getPerischoolActivity()) {
              perischoolActivityTypeTab[i++] = LocalReferentialData.modelToXml(object);
            }
            perischoolActivityRegistrationRequest.setPerischoolActivityArray(perischoolActivityTypeTab);
        }
      
        if (getRulesAndRegulationsAcceptance() != null)
            perischoolActivityRegistrationRequest.setRulesAndRegulationsAcceptance(getRulesAndRegulationsAcceptance().booleanValue());
      
        if (getSchool() != null)
            perischoolActivityRegistrationRequest.setSchool(School.modelToXml(getSchool()));
      
        if (getSection() != null)
            perischoolActivityRegistrationRequest.setSection(fr.cg95.cvq.xml.common.SectionType.Enum.forString(getSection().toString()));
      
        perischoolActivityRegistrationRequest.setUrgencyPhone(getUrgencyPhone());
      
        return perischoolActivityRegistrationRequestDoc;
    }

    @Override
    public final PerischoolActivityRegistrationRequestDocument.PerischoolActivityRegistrationRequest modelToXmlRequest() {
        return modelToXml().getPerischoolActivityRegistrationRequest();
    }

    public static PerischoolActivityRegistrationRequest xmlToModel(PerischoolActivityRegistrationRequestDocument perischoolActivityRegistrationRequestDoc) {
        PerischoolActivityRegistrationRequestDocument.PerischoolActivityRegistrationRequest perischoolActivityRegistrationRequestXml = perischoolActivityRegistrationRequestDoc.getPerischoolActivityRegistrationRequest();
        Calendar calendar = Calendar.getInstance();
        LocalTime localTime = new LocalTime();
        List list = new ArrayList();
        PerischoolActivityRegistrationRequest perischoolActivityRegistrationRequest = new PerischoolActivityRegistrationRequest();
        perischoolActivityRegistrationRequest.fillCommonModelInfo(perischoolActivityRegistrationRequest, perischoolActivityRegistrationRequestXml);
        
        List<fr.cg95.cvq.business.request.school.PerischoolAuthorizedIndividual> authorizedIndividualsList = new ArrayList<fr.cg95.cvq.business.request.school.PerischoolAuthorizedIndividual>(perischoolActivityRegistrationRequestXml.sizeOfAuthorizedIndividualsArray());
        for (PerischoolAuthorizedIndividualType object : perischoolActivityRegistrationRequestXml.getAuthorizedIndividualsArray()) {
            authorizedIndividualsList.add(fr.cg95.cvq.business.request.school.PerischoolAuthorizedIndividual.xmlToModel(object));
        }
        perischoolActivityRegistrationRequest.setAuthorizedIndividuals(authorizedIndividualsList);
      
        perischoolActivityRegistrationRequest.setChildPhotoExploitationPermission(Boolean.valueOf(perischoolActivityRegistrationRequestXml.getChildPhotoExploitationPermission()));
      
        perischoolActivityRegistrationRequest.setClassTripPermission(Boolean.valueOf(perischoolActivityRegistrationRequestXml.getClassTripPermission()));
      
        List<fr.cg95.cvq.business.request.school.PerischoolContactIndividual> contactIndividualsList = new ArrayList<fr.cg95.cvq.business.request.school.PerischoolContactIndividual>(perischoolActivityRegistrationRequestXml.sizeOfContactIndividualsArray());
        for (PerischoolContactIndividualType object : perischoolActivityRegistrationRequestXml.getContactIndividualsArray()) {
            contactIndividualsList.add(fr.cg95.cvq.business.request.school.PerischoolContactIndividual.xmlToModel(object));
        }
        perischoolActivityRegistrationRequest.setContactIndividuals(contactIndividualsList);
      
        perischoolActivityRegistrationRequest.setHospitalizationPermission(Boolean.valueOf(perischoolActivityRegistrationRequestXml.getHospitalizationPermission()));
      
        List<fr.cg95.cvq.business.request.LocalReferentialData> perischoolActivityList = new ArrayList<fr.cg95.cvq.business.request.LocalReferentialData>(perischoolActivityRegistrationRequestXml.sizeOfPerischoolActivityArray());
        for (LocalReferentialDataType object : perischoolActivityRegistrationRequestXml.getPerischoolActivityArray()) {
            perischoolActivityList.add(fr.cg95.cvq.business.request.LocalReferentialData.xmlToModel(object));
        }
        perischoolActivityRegistrationRequest.setPerischoolActivity(perischoolActivityList);
      
        perischoolActivityRegistrationRequest.setRulesAndRegulationsAcceptance(Boolean.valueOf(perischoolActivityRegistrationRequestXml.getRulesAndRegulationsAcceptance()));
      
        if (perischoolActivityRegistrationRequestXml.getSchool() != null)
            perischoolActivityRegistrationRequest.setSchool(School.xmlToModel(perischoolActivityRegistrationRequestXml.getSchool()));
      
        if (perischoolActivityRegistrationRequestXml.getSection() != null)
            perischoolActivityRegistrationRequest.setSection(fr.cg95.cvq.business.users.SectionType.forString(perischoolActivityRegistrationRequestXml.getSection().toString()));
        else
            perischoolActivityRegistrationRequest.setSection(fr.cg95.cvq.business.users.SectionType.getDefaultSectionType());
      
        perischoolActivityRegistrationRequest.setUrgencyPhone(perischoolActivityRegistrationRequestXml.getUrgencyPhone());
      
        return perischoolActivityRegistrationRequest;
    }

  
    public final void setAuthorizedIndividuals(final List<fr.cg95.cvq.business.request.school.PerischoolAuthorizedIndividual> authorizedIndividuals) {
        perischoolActivityRegistrationRequestData.setAuthorizedIndividuals(authorizedIndividuals);
    }

    
    public final List<fr.cg95.cvq.business.request.school.PerischoolAuthorizedIndividual> getAuthorizedIndividuals() {
        return perischoolActivityRegistrationRequestData.getAuthorizedIndividuals();
    }
  
    public final void setChildPhotoExploitationPermission(final Boolean childPhotoExploitationPermission) {
        perischoolActivityRegistrationRequestData.setChildPhotoExploitationPermission(childPhotoExploitationPermission);
    }

    @IsRulesAcceptance
    public final Boolean getChildPhotoExploitationPermission() {
        return perischoolActivityRegistrationRequestData.getChildPhotoExploitationPermission();
    }
  
    public final void setClassTripPermission(final Boolean classTripPermission) {
        perischoolActivityRegistrationRequestData.setClassTripPermission(classTripPermission);
    }

    @IsRulesAcceptance
    public final Boolean getClassTripPermission() {
        return perischoolActivityRegistrationRequestData.getClassTripPermission();
    }
  
    public final void setContactIndividuals(final List<fr.cg95.cvq.business.request.school.PerischoolContactIndividual> contactIndividuals) {
        perischoolActivityRegistrationRequestData.setContactIndividuals(contactIndividuals);
    }

    
    public final List<fr.cg95.cvq.business.request.school.PerischoolContactIndividual> getContactIndividuals() {
        return perischoolActivityRegistrationRequestData.getContactIndividuals();
    }
  
    public final void setHospitalizationPermission(final Boolean hospitalizationPermission) {
        perischoolActivityRegistrationRequestData.setHospitalizationPermission(hospitalizationPermission);
    }

    @IsRulesAcceptance
    public final Boolean getHospitalizationPermission() {
        return perischoolActivityRegistrationRequestData.getHospitalizationPermission();
    }
  
    public final void setPerischoolActivity(final List<fr.cg95.cvq.business.request.LocalReferentialData> perischoolActivity) {
        perischoolActivityRegistrationRequestData.setPerischoolActivity(perischoolActivity);
    }

    
    public final List<fr.cg95.cvq.business.request.LocalReferentialData> getPerischoolActivity() {
        return perischoolActivityRegistrationRequestData.getPerischoolActivity();
    }
  
    public final void setRulesAndRegulationsAcceptance(final Boolean rulesAndRegulationsAcceptance) {
        perischoolActivityRegistrationRequestData.setRulesAndRegulationsAcceptance(rulesAndRegulationsAcceptance);
    }

    @IsRulesAcceptance
    public final Boolean getRulesAndRegulationsAcceptance() {
        return perischoolActivityRegistrationRequestData.getRulesAndRegulationsAcceptance();
    }
  
    public final void setSchool(final fr.cg95.cvq.business.authority.School school) {
        perischoolActivityRegistrationRequestData.setSchool(school);
    }

    
    public final fr.cg95.cvq.business.authority.School getSchool() {
        return perischoolActivityRegistrationRequestData.getSchool();
    }
  
    public final void setSection(final fr.cg95.cvq.business.users.SectionType section) {
        perischoolActivityRegistrationRequestData.setSection(section);
    }

    
    public final fr.cg95.cvq.business.users.SectionType getSection() {
        return perischoolActivityRegistrationRequestData.getSection();
    }
  
    public final void setUrgencyPhone(final String urgencyPhone) {
        perischoolActivityRegistrationRequestData.setUrgencyPhone(urgencyPhone);
    }

    
    public final String getUrgencyPhone() {
        return perischoolActivityRegistrationRequestData.getUrgencyPhone();
    }
  
}
