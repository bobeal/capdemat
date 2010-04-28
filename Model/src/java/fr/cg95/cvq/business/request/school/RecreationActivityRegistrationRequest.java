
package fr.cg95.cvq.business.request.school;

import java.io.Serializable;
import java.math.BigInteger;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.xmlbeans.XmlOptions;

import fr.cg95.cvq.business.authority.*;
import fr.cg95.cvq.business.request.*;
import fr.cg95.cvq.business.request.annotation.*;
import fr.cg95.cvq.business.users.*;
import fr.cg95.cvq.xml.common.*;
import fr.cg95.cvq.xml.request.school.*;

/**
 * Generated class file, do not edit !
 */
public class RecreationActivityRegistrationRequest extends Request implements Serializable {

    private static final long serialVersionUID = 1L;

    private RecreationActivityRegistrationRequestData recreationActivityRegistrationRequestData;

    public RecreationActivityRegistrationRequest(RequestData requestData, RecreationActivityRegistrationRequestData recreationActivityRegistrationRequestData) {
        super(requestData);
        this.recreationActivityRegistrationRequestData = recreationActivityRegistrationRequestData;
    }

    public RecreationActivityRegistrationRequest() {
        super();
        this.recreationActivityRegistrationRequestData = new RecreationActivityRegistrationRequestData();
    }

    /**
     * Reserved for RequestDAO !
     */
    @Override
    public RecreationActivityRegistrationRequestData getSpecificData() {
        return recreationActivityRegistrationRequestData;
    }

    /**
     * Reserved for RequestDAO !
     */
    public void setSpecificData(RecreationActivityRegistrationRequestData recreationActivityRegistrationRequestData) {
        this.recreationActivityRegistrationRequestData = recreationActivityRegistrationRequestData;
    }

    @Override
    public final String modelToXmlString() {
        RecreationActivityRegistrationRequestDocument object = this.modelToXml();
        XmlOptions opts = new XmlOptions();
        opts.setSavePrettyPrint();
        opts.setSavePrettyPrintIndent(4);
        opts.setUseDefaultNamespace();
        opts.setCharacterEncoding("UTF-8");
        return object.xmlText(opts);
    }

    @Override
    public final RecreationActivityRegistrationRequestDocument modelToXml() {
        
        Calendar calendar = Calendar.getInstance();
        Date date = null;
        RecreationActivityRegistrationRequestDocument recreationActivityRegistrationRequestDoc = RecreationActivityRegistrationRequestDocument.Factory.newInstance();
        RecreationActivityRegistrationRequestDocument.RecreationActivityRegistrationRequest recreationActivityRegistrationRequest = recreationActivityRegistrationRequestDoc.addNewRecreationActivityRegistrationRequest();
        super.fillCommonXmlInfo(recreationActivityRegistrationRequest);
        int i = 0;
        
        if (getRecreationCenter() != null)
            recreationActivityRegistrationRequest.setRecreationCenter(RecreationCenter.modelToXml(getRecreationCenter()));
      
        i = 0;
        if (getAuthorizedIndividuals() != null) {
            fr.cg95.cvq.xml.request.school.RecreationAuthorizedIndividualType[] authorizedIndividualsTypeTab = new fr.cg95.cvq.xml.request.school.RecreationAuthorizedIndividualType[getAuthorizedIndividuals().size()];
            for (RecreationAuthorizedIndividual object : getAuthorizedIndividuals()) {
              authorizedIndividualsTypeTab[i++] = object.modelToXml();
            }
            recreationActivityRegistrationRequest.setAuthorizedIndividualsArray(authorizedIndividualsTypeTab);
        }
      
        i = 0;
        if (getContactIndividuals() != null) {
            fr.cg95.cvq.xml.request.school.RecreationContactIndividualType[] contactIndividualsTypeTab = new fr.cg95.cvq.xml.request.school.RecreationContactIndividualType[getContactIndividuals().size()];
            for (RecreationContactIndividual object : getContactIndividuals()) {
              contactIndividualsTypeTab[i++] = object.modelToXml();
            }
            recreationActivityRegistrationRequest.setContactIndividualsArray(contactIndividualsTypeTab);
        }
      
        if (getClassTripPermission() != null)
            recreationActivityRegistrationRequest.setClassTripPermission(getClassTripPermission().booleanValue());
      
        i = 0;
        if (getRecreationActivity() != null) {
            fr.cg95.cvq.xml.common.LocalReferentialDataType[] recreationActivityTypeTab = new fr.cg95.cvq.xml.common.LocalReferentialDataType[getRecreationActivity().size()];
            for (LocalReferentialData object : getRecreationActivity()) {
              recreationActivityTypeTab[i++] = LocalReferentialData.modelToXml(object);
            }
            recreationActivityRegistrationRequest.setRecreationActivityArray(recreationActivityTypeTab);
        }
      
        if (getChildPhotoExploitationPermission() != null)
            recreationActivityRegistrationRequest.setChildPhotoExploitationPermission(getChildPhotoExploitationPermission().booleanValue());
      
        if (getHospitalizationPermission() != null)
            recreationActivityRegistrationRequest.setHospitalizationPermission(getHospitalizationPermission().booleanValue());
      
        if (getRulesAndRegulationsAcceptance() != null)
            recreationActivityRegistrationRequest.setRulesAndRegulationsAcceptance(getRulesAndRegulationsAcceptance().booleanValue());
      
        recreationActivityRegistrationRequest.setUrgencyPhone(getUrgencyPhone());
      
        return recreationActivityRegistrationRequestDoc;
    }

    @Override
    public final RecreationActivityRegistrationRequestDocument.RecreationActivityRegistrationRequest modelToXmlRequest() {
        return modelToXml().getRecreationActivityRegistrationRequest();
    }

    public static RecreationActivityRegistrationRequest xmlToModel(RecreationActivityRegistrationRequestDocument recreationActivityRegistrationRequestDoc) {
        RecreationActivityRegistrationRequestDocument.RecreationActivityRegistrationRequest recreationActivityRegistrationRequestXml = recreationActivityRegistrationRequestDoc.getRecreationActivityRegistrationRequest();
        Calendar calendar = Calendar.getInstance();
        List list = new ArrayList();
        RecreationActivityRegistrationRequest recreationActivityRegistrationRequest = new RecreationActivityRegistrationRequest();
        recreationActivityRegistrationRequest.fillCommonModelInfo(recreationActivityRegistrationRequest, recreationActivityRegistrationRequestXml);
        
        if (recreationActivityRegistrationRequestXml.getRecreationCenter() != null)
            recreationActivityRegistrationRequest.setRecreationCenter(RecreationCenter.xmlToModel(recreationActivityRegistrationRequestXml.getRecreationCenter()));
      
        List<fr.cg95.cvq.business.request.school.RecreationAuthorizedIndividual> authorizedIndividualsList = new ArrayList<fr.cg95.cvq.business.request.school.RecreationAuthorizedIndividual>(recreationActivityRegistrationRequestXml.sizeOfAuthorizedIndividualsArray());
        for (RecreationAuthorizedIndividualType object : recreationActivityRegistrationRequestXml.getAuthorizedIndividualsArray()) {
            authorizedIndividualsList.add(fr.cg95.cvq.business.request.school.RecreationAuthorizedIndividual.xmlToModel(object));
        }
        recreationActivityRegistrationRequest.setAuthorizedIndividuals(authorizedIndividualsList);
      
        List<fr.cg95.cvq.business.request.school.RecreationContactIndividual> contactIndividualsList = new ArrayList<fr.cg95.cvq.business.request.school.RecreationContactIndividual>(recreationActivityRegistrationRequestXml.sizeOfContactIndividualsArray());
        for (RecreationContactIndividualType object : recreationActivityRegistrationRequestXml.getContactIndividualsArray()) {
            contactIndividualsList.add(fr.cg95.cvq.business.request.school.RecreationContactIndividual.xmlToModel(object));
        }
        recreationActivityRegistrationRequest.setContactIndividuals(contactIndividualsList);
      
        recreationActivityRegistrationRequest.setClassTripPermission(Boolean.valueOf(recreationActivityRegistrationRequestXml.getClassTripPermission()));
      
        List<fr.cg95.cvq.business.request.LocalReferentialData> recreationActivityList = new ArrayList<fr.cg95.cvq.business.request.LocalReferentialData>(recreationActivityRegistrationRequestXml.sizeOfRecreationActivityArray());
        for (LocalReferentialDataType object : recreationActivityRegistrationRequestXml.getRecreationActivityArray()) {
            recreationActivityList.add(fr.cg95.cvq.business.request.LocalReferentialData.xmlToModel(object));
        }
        recreationActivityRegistrationRequest.setRecreationActivity(recreationActivityList);
      
        recreationActivityRegistrationRequest.setChildPhotoExploitationPermission(Boolean.valueOf(recreationActivityRegistrationRequestXml.getChildPhotoExploitationPermission()));
      
        recreationActivityRegistrationRequest.setHospitalizationPermission(Boolean.valueOf(recreationActivityRegistrationRequestXml.getHospitalizationPermission()));
      
        recreationActivityRegistrationRequest.setRulesAndRegulationsAcceptance(Boolean.valueOf(recreationActivityRegistrationRequestXml.getRulesAndRegulationsAcceptance()));
      
        recreationActivityRegistrationRequest.setUrgencyPhone(recreationActivityRegistrationRequestXml.getUrgencyPhone());
      
        return recreationActivityRegistrationRequest;
    }

  
    public final void setRecreationCenter(final fr.cg95.cvq.business.authority.RecreationCenter recreationCenter) {
        recreationActivityRegistrationRequestData.setRecreationCenter(recreationCenter);
    }

    
    public final fr.cg95.cvq.business.authority.RecreationCenter getRecreationCenter() {
        return recreationActivityRegistrationRequestData.getRecreationCenter();
    }
  
    public final void setAuthorizedIndividuals(final List<fr.cg95.cvq.business.request.school.RecreationAuthorizedIndividual> authorizedIndividuals) {
        recreationActivityRegistrationRequestData.setAuthorizedIndividuals(authorizedIndividuals);
    }

    
    public final List<fr.cg95.cvq.business.request.school.RecreationAuthorizedIndividual> getAuthorizedIndividuals() {
        return recreationActivityRegistrationRequestData.getAuthorizedIndividuals();
    }
  
    public final void setContactIndividuals(final List<fr.cg95.cvq.business.request.school.RecreationContactIndividual> contactIndividuals) {
        recreationActivityRegistrationRequestData.setContactIndividuals(contactIndividuals);
    }

    
    public final List<fr.cg95.cvq.business.request.school.RecreationContactIndividual> getContactIndividuals() {
        return recreationActivityRegistrationRequestData.getContactIndividuals();
    }
  
    public final void setClassTripPermission(final Boolean classTripPermission) {
        recreationActivityRegistrationRequestData.setClassTripPermission(classTripPermission);
    }

    @IsRulesAcceptance
    public final Boolean getClassTripPermission() {
        return recreationActivityRegistrationRequestData.getClassTripPermission();
    }
  
    public final void setRecreationActivity(final List<fr.cg95.cvq.business.request.LocalReferentialData> recreationActivity) {
        recreationActivityRegistrationRequestData.setRecreationActivity(recreationActivity);
    }

    
    public final List<fr.cg95.cvq.business.request.LocalReferentialData> getRecreationActivity() {
        return recreationActivityRegistrationRequestData.getRecreationActivity();
    }
  
    public final void setChildPhotoExploitationPermission(final Boolean childPhotoExploitationPermission) {
        recreationActivityRegistrationRequestData.setChildPhotoExploitationPermission(childPhotoExploitationPermission);
    }

    @IsRulesAcceptance
    public final Boolean getChildPhotoExploitationPermission() {
        return recreationActivityRegistrationRequestData.getChildPhotoExploitationPermission();
    }
  
    public final void setHospitalizationPermission(final Boolean hospitalizationPermission) {
        recreationActivityRegistrationRequestData.setHospitalizationPermission(hospitalizationPermission);
    }

    @IsRulesAcceptance
    public final Boolean getHospitalizationPermission() {
        return recreationActivityRegistrationRequestData.getHospitalizationPermission();
    }
  
    public final void setRulesAndRegulationsAcceptance(final Boolean rulesAndRegulationsAcceptance) {
        recreationActivityRegistrationRequestData.setRulesAndRegulationsAcceptance(rulesAndRegulationsAcceptance);
    }

    @IsRulesAcceptance
    public final Boolean getRulesAndRegulationsAcceptance() {
        return recreationActivityRegistrationRequestData.getRulesAndRegulationsAcceptance();
    }
  
    public final void setUrgencyPhone(final String urgencyPhone) {
        recreationActivityRegistrationRequestData.setUrgencyPhone(urgencyPhone);
    }

    
    public final String getUrgencyPhone() {
        return recreationActivityRegistrationRequestData.getUrgencyPhone();
    }
  
}
