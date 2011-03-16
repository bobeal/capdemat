
package fr.cg95.cvq.business.request.social;

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
import fr.cg95.cvq.xml.request.social.*;
import fr.cg95.cvq.service.request.condition.IConditionChecker;

/**
 * Generated class file, do not edit !
 */
public class RemoteSupportRequest extends Request implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final Map<String, IConditionChecker> conditions = RemoteSupportRequestData.conditions;

    @AssertValid(message = "")
    private RemoteSupportRequestData remoteSupportRequestData;

    public RemoteSupportRequest(RequestData requestData, RemoteSupportRequestData remoteSupportRequestData) {
        super(requestData);
        this.remoteSupportRequestData = remoteSupportRequestData;
    }

    public RemoteSupportRequest() {
        super();
        this.remoteSupportRequestData = new RemoteSupportRequestData();
    }

    /**
     * Reserved for RequestDAO !
     */
    @Override
    public RemoteSupportRequestData getSpecificData() {
        return remoteSupportRequestData;
    }

    /**
     * Reserved for RequestDAO !
     */
    public void setSpecificData(RemoteSupportRequestData remoteSupportRequestData) {
        this.remoteSupportRequestData = remoteSupportRequestData;
    }

    @Override
    public final String modelToXmlString() {
        RemoteSupportRequestDocument object = this.modelToXml();
        XmlOptions opts = new XmlOptions();
        opts.setSavePrettyPrint();
        opts.setSavePrettyPrintIndent(4);
        opts.setUseDefaultNamespace();
        opts.setCharacterEncoding("UTF-8");
        return object.xmlText(opts);
    }

    @Override
    public final RemoteSupportRequestDocument modelToXml() {
        
        Calendar calendar = Calendar.getInstance();
        LocalTime localTime = new LocalTime();
        Date date = null;
        RemoteSupportRequestDocument remoteSupportRequestDoc = RemoteSupportRequestDocument.Factory.newInstance();
        RemoteSupportRequestDocument.RemoteSupportRequest remoteSupportRequest = remoteSupportRequestDoc.addNewRemoteSupportRequest();
        super.fillCommonXmlInfo(remoteSupportRequest);
        int i = 0;
          RsrContactType rsrContactTypeFirstContact = remoteSupportRequest.addNewFirstContact();
        rsrContactTypeFirstContact.setContactFirstName(getContactFirstName());
      
        if (getContactKind() != null)
            remoteSupportRequest.setContactKind(fr.cg95.cvq.xml.request.social.RsrContactKindType.Enum.forString(getContactKind().toString()));
      
        rsrContactTypeFirstContact.setContactLastName(getContactLastName());
      
        rsrContactTypeFirstContact.setContactPhone(getContactPhone());
        RsrRequestInformationType rsrRequestInformationTypeRequestInformation = remoteSupportRequest.addNewRequestInformation();
        if (getRequestInformationEmergency() != null)
            rsrRequestInformationTypeRequestInformation.setRequestInformationEmergency(getRequestInformationEmergency().booleanValue());
      
        rsrRequestInformationTypeRequestInformation.setRequestInformationEmergencyMotive(getRequestInformationEmergencyMotive());
      
        if (getRequestInformationRequestKind() != null)
            rsrRequestInformationTypeRequestInformation.setRequestInformationRequestKind(fr.cg95.cvq.xml.request.social.RsrRequestInformationRequestKindType.Enum.forString(getRequestInformationRequestKind().toString()));
        RsrSecondContactType rsrSecondContactTypeSecondContact = remoteSupportRequest.addNewSecondContact();
        rsrSecondContactTypeSecondContact.setSecondContactFirstName(getSecondContactFirstName());
      
        rsrSecondContactTypeSecondContact.setSecondContactLastName(getSecondContactLastName());
      
        rsrSecondContactTypeSecondContact.setSecondContactPhone(getSecondContactPhone());
        RsrSpouseType rsrSpouseTypeSpouse = remoteSupportRequest.addNewSpouse();
        date = getSpouseBirthDate();
        if (date != null) {
            calendar.setTime(date);
            rsrSpouseTypeSpouse.setSpouseBirthDate(calendar);
        }
      
        rsrSpouseTypeSpouse.setSpouseFirstName(getSpouseFirstName());
      
        if (getSpouseIsDisabledPerson() != null)
            rsrSpouseTypeSpouse.setSpouseIsDisabledPerson(getSpouseIsDisabledPerson().booleanValue());
      
        rsrSpouseTypeSpouse.setSpouseLastName(getSpouseLastName());
      
        if (getSpouseTitle() != null)
            rsrSpouseTypeSpouse.setSpouseTitle(fr.cg95.cvq.xml.common.TitleType.Enum.forString(getSpouseTitle().toString()));
        RsrSubjectType rsrSubjectTypeRsrSubject = remoteSupportRequest.addNewRsrSubject();
        date = getSubjectBirthDate();
        if (date != null) {
            calendar.setTime(date);
            rsrSubjectTypeRsrSubject.setSubjectBirthDate(calendar);
        }
      
        if (getSubjectIsAPABeneficiary() != null)
            rsrSubjectTypeRsrSubject.setSubjectIsAPABeneficiary(getSubjectIsAPABeneficiary().booleanValue());
      
        if (getSubjectIsDisabledPerson() != null)
            rsrSubjectTypeRsrSubject.setSubjectIsDisabledPerson(getSubjectIsDisabledPerson().booleanValue());
      
        if (getSubjectIsTaxable() != null)
            rsrSubjectTypeRsrSubject.setSubjectIsTaxable(getSubjectIsTaxable().booleanValue());
      
        if (getSubjectResideWith() != null)
            rsrSubjectTypeRsrSubject.setSubjectResideWith(fr.cg95.cvq.xml.request.social.RsrSubjectResideWithType.Enum.forString(getSubjectResideWith().toString()));
      
        if (getSubjectTitle() != null)
            rsrSubjectTypeRsrSubject.setSubjectTitle(fr.cg95.cvq.xml.common.TitleType.Enum.forString(getSubjectTitle().toString()));
        RsrTrusteeType rsrTrusteeTypeTrustee = remoteSupportRequest.addNewTrustee();
        rsrTrusteeTypeTrustee.setTrusteeFirstName(getTrusteeFirstName());
      
        rsrTrusteeTypeTrustee.setTrusteeLastName(getTrusteeLastName());
      
        rsrTrusteeTypeTrustee.setTrusteePhone(getTrusteePhone());
      
        return remoteSupportRequestDoc;
    }

    @Override
    public final RemoteSupportRequestDocument.RemoteSupportRequest modelToXmlRequest() {
        return modelToXml().getRemoteSupportRequest();
    }

    public static RemoteSupportRequest xmlToModel(RemoteSupportRequestDocument remoteSupportRequestDoc) {
        RemoteSupportRequestDocument.RemoteSupportRequest remoteSupportRequestXml = remoteSupportRequestDoc.getRemoteSupportRequest();
        Calendar calendar = Calendar.getInstance();
        LocalTime localTime = new LocalTime();
        List list = new ArrayList();
        RemoteSupportRequest remoteSupportRequest = new RemoteSupportRequest();
        remoteSupportRequest.fillCommonModelInfo(remoteSupportRequest, remoteSupportRequestXml);
        
        remoteSupportRequest.setContactFirstName(remoteSupportRequestXml.getFirstContact().getContactFirstName());
      
        if (remoteSupportRequestXml.getContactKind() != null)
            remoteSupportRequest.setContactKind(fr.cg95.cvq.business.request.social.RsrContactKindType.forString(remoteSupportRequestXml.getContactKind().toString()));
        else
            remoteSupportRequest.setContactKind(fr.cg95.cvq.business.request.social.RsrContactKindType.getDefaultRsrContactKindType());
      
        remoteSupportRequest.setContactLastName(remoteSupportRequestXml.getFirstContact().getContactLastName());
      
        remoteSupportRequest.setContactPhone(remoteSupportRequestXml.getFirstContact().getContactPhone());
      
        remoteSupportRequest.setRequestInformationEmergency(Boolean.valueOf(remoteSupportRequestXml.getRequestInformation().getRequestInformationEmergency()));
      
        remoteSupportRequest.setRequestInformationEmergencyMotive(remoteSupportRequestXml.getRequestInformation().getRequestInformationEmergencyMotive());
      
        if (remoteSupportRequestXml.getRequestInformation().getRequestInformationRequestKind() != null)
            remoteSupportRequest.setRequestInformationRequestKind(fr.cg95.cvq.business.request.social.RsrRequestInformationRequestKindType.forString(remoteSupportRequestXml.getRequestInformation().getRequestInformationRequestKind().toString()));
        else
            remoteSupportRequest.setRequestInformationRequestKind(fr.cg95.cvq.business.request.social.RsrRequestInformationRequestKindType.getDefaultRsrRequestInformationRequestKindType());
      
        remoteSupportRequest.setSecondContactFirstName(remoteSupportRequestXml.getSecondContact().getSecondContactFirstName());
      
        remoteSupportRequest.setSecondContactLastName(remoteSupportRequestXml.getSecondContact().getSecondContactLastName());
      
        remoteSupportRequest.setSecondContactPhone(remoteSupportRequestXml.getSecondContact().getSecondContactPhone());
      
        calendar = remoteSupportRequestXml.getSpouse().getSpouseBirthDate();
        if (calendar != null) {
            remoteSupportRequest.setSpouseBirthDate(calendar.getTime());
        }
      
        remoteSupportRequest.setSpouseFirstName(remoteSupportRequestXml.getSpouse().getSpouseFirstName());
      
        remoteSupportRequest.setSpouseIsDisabledPerson(Boolean.valueOf(remoteSupportRequestXml.getSpouse().getSpouseIsDisabledPerson()));
      
        remoteSupportRequest.setSpouseLastName(remoteSupportRequestXml.getSpouse().getSpouseLastName());
      
        if (remoteSupportRequestXml.getSpouse().getSpouseTitle() != null)
            remoteSupportRequest.setSpouseTitle(fr.cg95.cvq.business.users.TitleType.forString(remoteSupportRequestXml.getSpouse().getSpouseTitle().toString()));
        else
            remoteSupportRequest.setSpouseTitle(fr.cg95.cvq.business.users.TitleType.getDefaultTitleType());
      
        calendar = remoteSupportRequestXml.getRsrSubject().getSubjectBirthDate();
        if (calendar != null) {
            remoteSupportRequest.setSubjectBirthDate(calendar.getTime());
        }
      
        remoteSupportRequest.setSubjectIsAPABeneficiary(Boolean.valueOf(remoteSupportRequestXml.getRsrSubject().getSubjectIsAPABeneficiary()));
      
        remoteSupportRequest.setSubjectIsDisabledPerson(Boolean.valueOf(remoteSupportRequestXml.getRsrSubject().getSubjectIsDisabledPerson()));
      
        remoteSupportRequest.setSubjectIsTaxable(Boolean.valueOf(remoteSupportRequestXml.getRsrSubject().getSubjectIsTaxable()));
      
        if (remoteSupportRequestXml.getRsrSubject().getSubjectResideWith() != null)
            remoteSupportRequest.setSubjectResideWith(fr.cg95.cvq.business.request.social.RsrSubjectResideWithType.forString(remoteSupportRequestXml.getRsrSubject().getSubjectResideWith().toString()));
        else
            remoteSupportRequest.setSubjectResideWith(fr.cg95.cvq.business.request.social.RsrSubjectResideWithType.getDefaultRsrSubjectResideWithType());
      
        if (remoteSupportRequestXml.getRsrSubject().getSubjectTitle() != null)
            remoteSupportRequest.setSubjectTitle(fr.cg95.cvq.business.users.TitleType.forString(remoteSupportRequestXml.getRsrSubject().getSubjectTitle().toString()));
        else
            remoteSupportRequest.setSubjectTitle(fr.cg95.cvq.business.users.TitleType.getDefaultTitleType());
      
        remoteSupportRequest.setTrusteeFirstName(remoteSupportRequestXml.getTrustee().getTrusteeFirstName());
      
        remoteSupportRequest.setTrusteeLastName(remoteSupportRequestXml.getTrustee().getTrusteeLastName());
      
        remoteSupportRequest.setTrusteePhone(remoteSupportRequestXml.getTrustee().getTrusteePhone());
      
        return remoteSupportRequest;
    }

  
    public final void setContactFirstName(final String contactFirstName) {
        remoteSupportRequestData.setContactFirstName(contactFirstName);
    }

    
    public final String getContactFirstName() {
        return remoteSupportRequestData.getContactFirstName();
    }
  
    public final void setContactKind(final fr.cg95.cvq.business.request.social.RsrContactKindType contactKind) {
        remoteSupportRequestData.setContactKind(contactKind);
    }

    
    public final fr.cg95.cvq.business.request.social.RsrContactKindType getContactKind() {
        return remoteSupportRequestData.getContactKind();
    }
  
    public final void setContactLastName(final String contactLastName) {
        remoteSupportRequestData.setContactLastName(contactLastName);
    }

    
    public final String getContactLastName() {
        return remoteSupportRequestData.getContactLastName();
    }
  
    public final void setContactPhone(final String contactPhone) {
        remoteSupportRequestData.setContactPhone(contactPhone);
    }

    
    public final String getContactPhone() {
        return remoteSupportRequestData.getContactPhone();
    }
  
    public final void setRequestInformationEmergency(final Boolean requestInformationEmergency) {
        remoteSupportRequestData.setRequestInformationEmergency(requestInformationEmergency);
    }

    
    public final Boolean getRequestInformationEmergency() {
        return remoteSupportRequestData.getRequestInformationEmergency();
    }
  
    public final void setRequestInformationEmergencyMotive(final String requestInformationEmergencyMotive) {
        remoteSupportRequestData.setRequestInformationEmergencyMotive(requestInformationEmergencyMotive);
    }

    
    public final String getRequestInformationEmergencyMotive() {
        return remoteSupportRequestData.getRequestInformationEmergencyMotive();
    }
  
    public final void setRequestInformationRequestKind(final fr.cg95.cvq.business.request.social.RsrRequestInformationRequestKindType requestInformationRequestKind) {
        remoteSupportRequestData.setRequestInformationRequestKind(requestInformationRequestKind);
    }

    
    public final fr.cg95.cvq.business.request.social.RsrRequestInformationRequestKindType getRequestInformationRequestKind() {
        return remoteSupportRequestData.getRequestInformationRequestKind();
    }
  
    public final void setSecondContactFirstName(final String secondContactFirstName) {
        remoteSupportRequestData.setSecondContactFirstName(secondContactFirstName);
    }

    
    public final String getSecondContactFirstName() {
        return remoteSupportRequestData.getSecondContactFirstName();
    }
  
    public final void setSecondContactLastName(final String secondContactLastName) {
        remoteSupportRequestData.setSecondContactLastName(secondContactLastName);
    }

    
    public final String getSecondContactLastName() {
        return remoteSupportRequestData.getSecondContactLastName();
    }
  
    public final void setSecondContactPhone(final String secondContactPhone) {
        remoteSupportRequestData.setSecondContactPhone(secondContactPhone);
    }

    
    public final String getSecondContactPhone() {
        return remoteSupportRequestData.getSecondContactPhone();
    }
  
    public final void setSpouseBirthDate(final java.util.Date spouseBirthDate) {
        remoteSupportRequestData.setSpouseBirthDate(spouseBirthDate);
    }

    
    public final java.util.Date getSpouseBirthDate() {
        return remoteSupportRequestData.getSpouseBirthDate();
    }
  
    public final void setSpouseFirstName(final String spouseFirstName) {
        remoteSupportRequestData.setSpouseFirstName(spouseFirstName);
    }

    
    public final String getSpouseFirstName() {
        return remoteSupportRequestData.getSpouseFirstName();
    }
  
    public final void setSpouseIsDisabledPerson(final Boolean spouseIsDisabledPerson) {
        remoteSupportRequestData.setSpouseIsDisabledPerson(spouseIsDisabledPerson);
    }

    
    public final Boolean getSpouseIsDisabledPerson() {
        return remoteSupportRequestData.getSpouseIsDisabledPerson();
    }
  
    public final void setSpouseLastName(final String spouseLastName) {
        remoteSupportRequestData.setSpouseLastName(spouseLastName);
    }

    
    public final String getSpouseLastName() {
        return remoteSupportRequestData.getSpouseLastName();
    }
  
    public final void setSpouseTitle(final fr.cg95.cvq.business.users.TitleType spouseTitle) {
        remoteSupportRequestData.setSpouseTitle(spouseTitle);
    }

    
    public final fr.cg95.cvq.business.users.TitleType getSpouseTitle() {
        return remoteSupportRequestData.getSpouseTitle();
    }
  
    public final void setSubjectBirthDate(final java.util.Date subjectBirthDate) {
        remoteSupportRequestData.setSubjectBirthDate(subjectBirthDate);
    }

    
    public final java.util.Date getSubjectBirthDate() {
        return remoteSupportRequestData.getSubjectBirthDate();
    }
  
    public final void setSubjectIsAPABeneficiary(final Boolean subjectIsAPABeneficiary) {
        remoteSupportRequestData.setSubjectIsAPABeneficiary(subjectIsAPABeneficiary);
    }

    
    public final Boolean getSubjectIsAPABeneficiary() {
        return remoteSupportRequestData.getSubjectIsAPABeneficiary();
    }
  
    public final void setSubjectIsDisabledPerson(final Boolean subjectIsDisabledPerson) {
        remoteSupportRequestData.setSubjectIsDisabledPerson(subjectIsDisabledPerson);
    }

    
    public final Boolean getSubjectIsDisabledPerson() {
        return remoteSupportRequestData.getSubjectIsDisabledPerson();
    }
  
    public final void setSubjectIsTaxable(final Boolean subjectIsTaxable) {
        remoteSupportRequestData.setSubjectIsTaxable(subjectIsTaxable);
    }

    
    public final Boolean getSubjectIsTaxable() {
        return remoteSupportRequestData.getSubjectIsTaxable();
    }
  
    public final void setSubjectResideWith(final fr.cg95.cvq.business.request.social.RsrSubjectResideWithType subjectResideWith) {
        remoteSupportRequestData.setSubjectResideWith(subjectResideWith);
    }

    
    public final fr.cg95.cvq.business.request.social.RsrSubjectResideWithType getSubjectResideWith() {
        return remoteSupportRequestData.getSubjectResideWith();
    }
  
    public final void setSubjectTitle(final fr.cg95.cvq.business.users.TitleType subjectTitle) {
        remoteSupportRequestData.setSubjectTitle(subjectTitle);
    }

    
    public final fr.cg95.cvq.business.users.TitleType getSubjectTitle() {
        return remoteSupportRequestData.getSubjectTitle();
    }
  
    public final void setTrusteeFirstName(final String trusteeFirstName) {
        remoteSupportRequestData.setTrusteeFirstName(trusteeFirstName);
    }

    
    public final String getTrusteeFirstName() {
        return remoteSupportRequestData.getTrusteeFirstName();
    }
  
    public final void setTrusteeLastName(final String trusteeLastName) {
        remoteSupportRequestData.setTrusteeLastName(trusteeLastName);
    }

    
    public final String getTrusteeLastName() {
        return remoteSupportRequestData.getTrusteeLastName();
    }
  
    public final void setTrusteePhone(final String trusteePhone) {
        remoteSupportRequestData.setTrusteePhone(trusteePhone);
    }

    
    public final String getTrusteePhone() {
        return remoteSupportRequestData.getTrusteePhone();
    }
  
}
