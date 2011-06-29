
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
public class RecreationActivityPolyRegistrationRequest extends Request implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final Map<String, IConditionChecker> conditions = RecreationActivityPolyRegistrationRequestData.conditions;

    @AssertValid(message = "")
    private RecreationActivityPolyRegistrationRequestData recreationActivityPolyRegistrationRequestData;

    public RecreationActivityPolyRegistrationRequest(RequestData requestData, RecreationActivityPolyRegistrationRequestData recreationActivityPolyRegistrationRequestData) {
        super(requestData);
        this.recreationActivityPolyRegistrationRequestData = recreationActivityPolyRegistrationRequestData;
    }

    public RecreationActivityPolyRegistrationRequest() {
        super();
        this.recreationActivityPolyRegistrationRequestData = new RecreationActivityPolyRegistrationRequestData();
    }

    /**
     * Reserved for RequestDAO !
     */
    @Override
    public RecreationActivityPolyRegistrationRequestData getSpecificData() {
        return recreationActivityPolyRegistrationRequestData;
    }

    /**
     * Reserved for RequestDAO !
     */
    public void setSpecificData(RecreationActivityPolyRegistrationRequestData recreationActivityPolyRegistrationRequestData) {
        this.recreationActivityPolyRegistrationRequestData = recreationActivityPolyRegistrationRequestData;
    }

    @Override
    public final String modelToXmlString() {
        RecreationActivityPolyRegistrationRequestDocument object = this.modelToXml();
        XmlOptions opts = new XmlOptions();
        opts.setSavePrettyPrint();
        opts.setSavePrettyPrintIndent(4);
        opts.setUseDefaultNamespace();
        opts.setCharacterEncoding("UTF-8");
        return object.xmlText(opts);
    }

    @Override
    public final RecreationActivityPolyRegistrationRequestDocument modelToXml() {
        
        Calendar calendar = Calendar.getInstance();
        Date date = null;
        RecreationActivityPolyRegistrationRequestDocument recreationActivityPolyRegistrationRequestDoc = RecreationActivityPolyRegistrationRequestDocument.Factory.newInstance();
        RecreationActivityPolyRegistrationRequestDocument.RecreationActivityPolyRegistrationRequest recreationActivityPolyRegistrationRequest = recreationActivityPolyRegistrationRequestDoc.addNewRecreationActivityPolyRegistrationRequest();
        super.fillCommonXmlInfo(recreationActivityPolyRegistrationRequest);
        int i = 0;
        
        i = 0;
        if (getAuthorizedPolyIndividuals() != null) {
            fr.cg95.cvq.xml.request.school.RecreationAuthorizedPolyIndividualType[] authorizedPolyIndividualsTypeTab = new fr.cg95.cvq.xml.request.school.RecreationAuthorizedPolyIndividualType[getAuthorizedPolyIndividuals().size()];
            for (RecreationAuthorizedPolyIndividual object : getAuthorizedPolyIndividuals()) {
              authorizedPolyIndividualsTypeTab[i++] = object.modelToXml();
            }
            recreationActivityPolyRegistrationRequest.setAuthorizedPolyIndividualsArray(authorizedPolyIndividualsTypeTab);
        }
      
        recreationActivityPolyRegistrationRequest.setUrgencyPolyPhone(getUrgencyPolyPhone());
      
        if (getRecreationPolyCenter() != null)
            recreationActivityPolyRegistrationRequest.setRecreationPolyCenter(RecreationCenter.modelToXml(getRecreationPolyCenter()));
      
        if (getHospitalizationPolyPermission() != null)
            recreationActivityPolyRegistrationRequest.setHospitalizationPolyPermission(getHospitalizationPolyPermission().booleanValue());
      
        if (getRulesAndRegulationsPolyAcceptance() != null)
            recreationActivityPolyRegistrationRequest.setRulesAndRegulationsPolyAcceptance(getRulesAndRegulationsPolyAcceptance().booleanValue());
      
        if (getChildPhotoExploitationPolyPermission() != null)
            recreationActivityPolyRegistrationRequest.setChildPhotoExploitationPolyPermission(getChildPhotoExploitationPolyPermission().booleanValue());
      
        if (getClassTripPolyPermission() != null)
            recreationActivityPolyRegistrationRequest.setClassTripPolyPermission(getClassTripPolyPermission().booleanValue());
      
        i = 0;
        if (getContactPolyIndividuals() != null) {
            fr.cg95.cvq.xml.request.school.RecreationContactPolyIndividualType[] contactPolyIndividualsTypeTab = new fr.cg95.cvq.xml.request.school.RecreationContactPolyIndividualType[getContactPolyIndividuals().size()];
            for (RecreationContactPolyIndividual object : getContactPolyIndividuals()) {
              contactPolyIndividualsTypeTab[i++] = object.modelToXml();
            }
            recreationActivityPolyRegistrationRequest.setContactPolyIndividualsArray(contactPolyIndividualsTypeTab);
        }
      
        i = 0;
        if (getRecreationPolyActivity() != null) {
            fr.cg95.cvq.xml.common.LocalReferentialDataType[] recreationPolyActivityTypeTab = new fr.cg95.cvq.xml.common.LocalReferentialDataType[getRecreationPolyActivity().size()];
            for (LocalReferentialData object : getRecreationPolyActivity()) {
              recreationPolyActivityTypeTab[i++] = LocalReferentialData.modelToXml(object);
            }
            recreationActivityPolyRegistrationRequest.setRecreationPolyActivityArray(recreationPolyActivityTypeTab);
        }
      
        return recreationActivityPolyRegistrationRequestDoc;
    }

    @Override
    public final RecreationActivityPolyRegistrationRequestDocument.RecreationActivityPolyRegistrationRequest modelToXmlRequest() {
        return modelToXml().getRecreationActivityPolyRegistrationRequest();
    }

    public static RecreationActivityPolyRegistrationRequest xmlToModel(RecreationActivityPolyRegistrationRequestDocument recreationActivityPolyRegistrationRequestDoc) {
        RecreationActivityPolyRegistrationRequestDocument.RecreationActivityPolyRegistrationRequest recreationActivityPolyRegistrationRequestXml = recreationActivityPolyRegistrationRequestDoc.getRecreationActivityPolyRegistrationRequest();
        Calendar calendar = Calendar.getInstance();
        List list = new ArrayList();
        RecreationActivityPolyRegistrationRequest recreationActivityPolyRegistrationRequest = new RecreationActivityPolyRegistrationRequest();
        recreationActivityPolyRegistrationRequest.fillCommonModelInfo(recreationActivityPolyRegistrationRequest, recreationActivityPolyRegistrationRequestXml);
        
        List<fr.cg95.cvq.business.request.school.RecreationAuthorizedPolyIndividual> authorizedPolyIndividualsList = new ArrayList<fr.cg95.cvq.business.request.school.RecreationAuthorizedPolyIndividual>(recreationActivityPolyRegistrationRequestXml.sizeOfAuthorizedPolyIndividualsArray());
        for (RecreationAuthorizedPolyIndividualType object : recreationActivityPolyRegistrationRequestXml.getAuthorizedPolyIndividualsArray()) {
            authorizedPolyIndividualsList.add(fr.cg95.cvq.business.request.school.RecreationAuthorizedPolyIndividual.xmlToModel(object));
        }
        recreationActivityPolyRegistrationRequest.setAuthorizedPolyIndividuals(authorizedPolyIndividualsList);
      
        recreationActivityPolyRegistrationRequest.setUrgencyPolyPhone(recreationActivityPolyRegistrationRequestXml.getUrgencyPolyPhone());
      
        if (recreationActivityPolyRegistrationRequestXml.getRecreationPolyCenter() != null)
            recreationActivityPolyRegistrationRequest.setRecreationPolyCenter(RecreationCenter.xmlToModel(recreationActivityPolyRegistrationRequestXml.getRecreationPolyCenter()));
      
        recreationActivityPolyRegistrationRequest.setHospitalizationPolyPermission(Boolean.valueOf(recreationActivityPolyRegistrationRequestXml.getHospitalizationPolyPermission()));
      
        recreationActivityPolyRegistrationRequest.setRulesAndRegulationsPolyAcceptance(Boolean.valueOf(recreationActivityPolyRegistrationRequestXml.getRulesAndRegulationsPolyAcceptance()));
      
        recreationActivityPolyRegistrationRequest.setChildPhotoExploitationPolyPermission(Boolean.valueOf(recreationActivityPolyRegistrationRequestXml.getChildPhotoExploitationPolyPermission()));
      
        recreationActivityPolyRegistrationRequest.setClassTripPolyPermission(Boolean.valueOf(recreationActivityPolyRegistrationRequestXml.getClassTripPolyPermission()));
      
        List<fr.cg95.cvq.business.request.school.RecreationContactPolyIndividual> contactPolyIndividualsList = new ArrayList<fr.cg95.cvq.business.request.school.RecreationContactPolyIndividual>(recreationActivityPolyRegistrationRequestXml.sizeOfContactPolyIndividualsArray());
        for (RecreationContactPolyIndividualType object : recreationActivityPolyRegistrationRequestXml.getContactPolyIndividualsArray()) {
            contactPolyIndividualsList.add(fr.cg95.cvq.business.request.school.RecreationContactPolyIndividual.xmlToModel(object));
        }
        recreationActivityPolyRegistrationRequest.setContactPolyIndividuals(contactPolyIndividualsList);
      
        List<fr.cg95.cvq.business.request.LocalReferentialData> recreationPolyActivityList = new ArrayList<fr.cg95.cvq.business.request.LocalReferentialData>(recreationActivityPolyRegistrationRequestXml.sizeOfRecreationPolyActivityArray());
        for (LocalReferentialDataType object : recreationActivityPolyRegistrationRequestXml.getRecreationPolyActivityArray()) {
            recreationPolyActivityList.add(fr.cg95.cvq.business.request.LocalReferentialData.xmlToModel(object));
        }
        recreationActivityPolyRegistrationRequest.setRecreationPolyActivity(recreationPolyActivityList);
      
        return recreationActivityPolyRegistrationRequest;
    }

  
    public final void setAuthorizedPolyIndividuals(final List<fr.cg95.cvq.business.request.school.RecreationAuthorizedPolyIndividual> authorizedPolyIndividuals) {
        recreationActivityPolyRegistrationRequestData.setAuthorizedPolyIndividuals(authorizedPolyIndividuals);
    }

    
    public final List<fr.cg95.cvq.business.request.school.RecreationAuthorizedPolyIndividual> getAuthorizedPolyIndividuals() {
        return recreationActivityPolyRegistrationRequestData.getAuthorizedPolyIndividuals();
    }
  
    public final void setUrgencyPolyPhone(final String urgencyPolyPhone) {
        recreationActivityPolyRegistrationRequestData.setUrgencyPolyPhone(urgencyPolyPhone);
    }

    
    public final String getUrgencyPolyPhone() {
        return recreationActivityPolyRegistrationRequestData.getUrgencyPolyPhone();
    }
  
    public final void setRecreationPolyCenter(final fr.cg95.cvq.business.authority.RecreationCenter recreationPolyCenter) {
        recreationActivityPolyRegistrationRequestData.setRecreationPolyCenter(recreationPolyCenter);
    }

    
    public final fr.cg95.cvq.business.authority.RecreationCenter getRecreationPolyCenter() {
        return recreationActivityPolyRegistrationRequestData.getRecreationPolyCenter();
    }
  
    public final void setHospitalizationPolyPermission(final Boolean hospitalizationPolyPermission) {
        recreationActivityPolyRegistrationRequestData.setHospitalizationPolyPermission(hospitalizationPolyPermission);
    }

    @IsRulesAcceptance
    public final Boolean getHospitalizationPolyPermission() {
        return recreationActivityPolyRegistrationRequestData.getHospitalizationPolyPermission();
    }
  
    public final void setRulesAndRegulationsPolyAcceptance(final Boolean rulesAndRegulationsPolyAcceptance) {
        recreationActivityPolyRegistrationRequestData.setRulesAndRegulationsPolyAcceptance(rulesAndRegulationsPolyAcceptance);
    }

    @IsRulesAcceptance
    public final Boolean getRulesAndRegulationsPolyAcceptance() {
        return recreationActivityPolyRegistrationRequestData.getRulesAndRegulationsPolyAcceptance();
    }
  
    public final void setChildPhotoExploitationPolyPermission(final Boolean childPhotoExploitationPolyPermission) {
        recreationActivityPolyRegistrationRequestData.setChildPhotoExploitationPolyPermission(childPhotoExploitationPolyPermission);
    }

    @IsRulesAcceptance
    public final Boolean getChildPhotoExploitationPolyPermission() {
        return recreationActivityPolyRegistrationRequestData.getChildPhotoExploitationPolyPermission();
    }
  
    public final void setClassTripPolyPermission(final Boolean classTripPolyPermission) {
        recreationActivityPolyRegistrationRequestData.setClassTripPolyPermission(classTripPolyPermission);
    }

    @IsRulesAcceptance
    public final Boolean getClassTripPolyPermission() {
        return recreationActivityPolyRegistrationRequestData.getClassTripPolyPermission();
    }
  
    public final void setContactPolyIndividuals(final List<fr.cg95.cvq.business.request.school.RecreationContactPolyIndividual> contactPolyIndividuals) {
        recreationActivityPolyRegistrationRequestData.setContactPolyIndividuals(contactPolyIndividuals);
    }

    
    public final List<fr.cg95.cvq.business.request.school.RecreationContactPolyIndividual> getContactPolyIndividuals() {
        return recreationActivityPolyRegistrationRequestData.getContactPolyIndividuals();
    }
  
    public final void setRecreationPolyActivity(final List<fr.cg95.cvq.business.request.LocalReferentialData> recreationPolyActivity) {
        recreationActivityPolyRegistrationRequestData.setRecreationPolyActivity(recreationPolyActivity);
    }

    
    public final List<fr.cg95.cvq.business.request.LocalReferentialData> getRecreationPolyActivity() {
        return recreationActivityPolyRegistrationRequestData.getRecreationPolyActivity();
    }
  
}
