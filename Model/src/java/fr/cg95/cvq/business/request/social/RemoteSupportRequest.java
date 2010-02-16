
package fr.cg95.cvq.business.request.social;

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
import fr.cg95.cvq.business.users.*;
import fr.cg95.cvq.xml.common.*;
import fr.cg95.cvq.xml.request.social.*;

/**
 * Generated class file, do not edit !
 */
public class RemoteSupportRequest extends Request implements Serializable {

    private static final long serialVersionUID = 1L;

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
        Date date = null;
        RemoteSupportRequestDocument remoteSupportRequestDoc = RemoteSupportRequestDocument.Factory.newInstance();
        RemoteSupportRequestDocument.RemoteSupportRequest remoteSupportRequest = remoteSupportRequestDoc.addNewRemoteSupportRequest();
        super.fillCommonXmlInfo(remoteSupportRequest);
        int i = 0;
          RsrTrusteeType rsrTrusteeTypeTrustee = remoteSupportRequest.addNewTrustee();
        rsrTrusteeTypeTrustee.setTrusteePhone(getTrusteePhone());
        RsrSpouseType rsrSpouseTypeSpouse = remoteSupportRequest.addNewSpouse();
        if (getSpouseIsDisabledPerson() != null)
            rsrSpouseTypeSpouse.setSpouseIsDisabledPerson(getSpouseIsDisabledPerson().booleanValue());
        RsrSubjectType rsrSubjectTypeRsrSubject = remoteSupportRequest.addNewRsrSubject();
        date = getSubjectBirthDate();
        if (date != null) {
            calendar.setTime(date);
            rsrSubjectTypeRsrSubject.setSubjectBirthDate(calendar);
        }
      
        if (getSubjectIsAPABeneficiary() != null)
            rsrSubjectTypeRsrSubject.setSubjectIsAPABeneficiary(getSubjectIsAPABeneficiary().booleanValue());
      
        if (getSubjectResideWith() != null)
            rsrSubjectTypeRsrSubject.setSubjectResideWith(fr.cg95.cvq.xml.request.social.RsrSubjectResideWithType.Enum.forString(getSubjectResideWith().toString()));
      
        date = getSpouseBirthDate();
        if (date != null) {
            calendar.setTime(date);
            rsrSpouseTypeSpouse.setSpouseBirthDate(calendar);
        }
        RsrContactType rsrContactTypeFirstContact = remoteSupportRequest.addNewFirstContact();
        rsrContactTypeFirstContact.setContactPhone(getContactPhone());
      
        rsrSpouseTypeSpouse.setSpouseLastName(getSpouseLastName());
        RsrRequestInformationType rsrRequestInformationTypeRequestInformation = remoteSupportRequest.addNewRequestInformation();
        if (getRequestInformationEmergency() != null)
            rsrRequestInformationTypeRequestInformation.setRequestInformationEmergency(getRequestInformationEmergency().booleanValue());
      
        if (getRequestInformationRequestKind() != null)
            rsrRequestInformationTypeRequestInformation.setRequestInformationRequestKind(fr.cg95.cvq.xml.request.social.RsrRequestInformationRequestKindType.Enum.forString(getRequestInformationRequestKind().toString()));
      
        if (getSubjectIsDisabledPerson() != null)
            rsrSubjectTypeRsrSubject.setSubjectIsDisabledPerson(getSubjectIsDisabledPerson().booleanValue());
        RsrSecondContactType rsrSecondContactTypeSecondContact = remoteSupportRequest.addNewSecondContact();
        rsrSecondContactTypeSecondContact.setSecondContactLastName(getSecondContactLastName());
      
        rsrRequestInformationTypeRequestInformation.setRequestInformationEmergencyMotive(getRequestInformationEmergencyMotive());
      
        rsrContactTypeFirstContact.setContactLastName(getContactLastName());
      
        if (getSpouseTitle() != null)
            rsrSpouseTypeSpouse.setSpouseTitle(fr.cg95.cvq.xml.common.TitleType.Enum.forString(getSpouseTitle().toString()));
      
        if (getSubjectTitle() != null)
            rsrSubjectTypeRsrSubject.setSubjectTitle(fr.cg95.cvq.xml.common.TitleType.Enum.forString(getSubjectTitle().toString()));
      
        rsrSpouseTypeSpouse.setSpouseFirstName(getSpouseFirstName());
      
        rsrContactTypeFirstContact.setContactFirstName(getContactFirstName());
      
        rsrTrusteeTypeTrustee.setTrusteeFirstName(getTrusteeFirstName());
      
        if (getContactKind() != null)
            remoteSupportRequest.setContactKind(fr.cg95.cvq.xml.request.social.RsrContactKindType.Enum.forString(getContactKind().toString()));
      
        rsrSecondContactTypeSecondContact.setSecondContactFirstName(getSecondContactFirstName());
      
        if (getSubjectIsTaxable() != null)
            rsrSubjectTypeRsrSubject.setSubjectIsTaxable(getSubjectIsTaxable().booleanValue());
      
        rsrTrusteeTypeTrustee.setTrusteeLastName(getTrusteeLastName());
      
        rsrSecondContactTypeSecondContact.setSecondContactPhone(getSecondContactPhone());
      
        return remoteSupportRequestDoc;
    }

    @Override
    public final RemoteSupportRequestDocument.RemoteSupportRequest modelToXmlRequest() {
        return modelToXml().getRemoteSupportRequest();
    }

    public static RemoteSupportRequest xmlToModel(RemoteSupportRequestDocument remoteSupportRequestDoc) {
        RemoteSupportRequestDocument.RemoteSupportRequest remoteSupportRequestXml = remoteSupportRequestDoc.getRemoteSupportRequest();
        Calendar calendar = Calendar.getInstance();
        List list = new ArrayList();
        RemoteSupportRequest remoteSupportRequest = new RemoteSupportRequest();
        remoteSupportRequest.fillCommonModelInfo(remoteSupportRequest, remoteSupportRequestXml);
        
        remoteSupportRequest.setTrusteePhone(remoteSupportRequestXml.getTrustee().getTrusteePhone());
      
        remoteSupportRequest.setSpouseIsDisabledPerson(Boolean.valueOf(remoteSupportRequestXml.getSpouse().getSpouseIsDisabledPerson()));
      
        calendar = remoteSupportRequestXml.getRsrSubject().getSubjectBirthDate();
        if (calendar != null) {
            remoteSupportRequest.setSubjectBirthDate(calendar.getTime());
        }
      
        remoteSupportRequest.setSubjectIsAPABeneficiary(Boolean.valueOf(remoteSupportRequestXml.getRsrSubject().getSubjectIsAPABeneficiary()));
      
        if (remoteSupportRequestXml.getRsrSubject().getSubjectResideWith() != null)
            remoteSupportRequest.setSubjectResideWith(fr.cg95.cvq.business.request.social.RsrSubjectResideWithType.forString(remoteSupportRequestXml.getRsrSubject().getSubjectResideWith().toString()));
        else
            remoteSupportRequest.setSubjectResideWith(fr.cg95.cvq.business.request.social.RsrSubjectResideWithType.getDefaultRsrSubjectResideWithType());
      
        calendar = remoteSupportRequestXml.getSpouse().getSpouseBirthDate();
        if (calendar != null) {
            remoteSupportRequest.setSpouseBirthDate(calendar.getTime());
        }
      
        remoteSupportRequest.setContactPhone(remoteSupportRequestXml.getFirstContact().getContactPhone());
      
        remoteSupportRequest.setSpouseLastName(remoteSupportRequestXml.getSpouse().getSpouseLastName());
      
        remoteSupportRequest.setRequestInformationEmergency(Boolean.valueOf(remoteSupportRequestXml.getRequestInformation().getRequestInformationEmergency()));
      
        if (remoteSupportRequestXml.getRequestInformation().getRequestInformationRequestKind() != null)
            remoteSupportRequest.setRequestInformationRequestKind(fr.cg95.cvq.business.request.social.RsrRequestInformationRequestKindType.forString(remoteSupportRequestXml.getRequestInformation().getRequestInformationRequestKind().toString()));
        else
            remoteSupportRequest.setRequestInformationRequestKind(fr.cg95.cvq.business.request.social.RsrRequestInformationRequestKindType.getDefaultRsrRequestInformationRequestKindType());
      
        remoteSupportRequest.setSubjectIsDisabledPerson(Boolean.valueOf(remoteSupportRequestXml.getRsrSubject().getSubjectIsDisabledPerson()));
      
        remoteSupportRequest.setSecondContactLastName(remoteSupportRequestXml.getSecondContact().getSecondContactLastName());
      
        remoteSupportRequest.setRequestInformationEmergencyMotive(remoteSupportRequestXml.getRequestInformation().getRequestInformationEmergencyMotive());
      
        remoteSupportRequest.setContactLastName(remoteSupportRequestXml.getFirstContact().getContactLastName());
      
        if (remoteSupportRequestXml.getSpouse().getSpouseTitle() != null)
            remoteSupportRequest.setSpouseTitle(fr.cg95.cvq.business.users.TitleType.forString(remoteSupportRequestXml.getSpouse().getSpouseTitle().toString()));
        else
            remoteSupportRequest.setSpouseTitle(fr.cg95.cvq.business.users.TitleType.getDefaultTitleType());
      
        if (remoteSupportRequestXml.getRsrSubject().getSubjectTitle() != null)
            remoteSupportRequest.setSubjectTitle(fr.cg95.cvq.business.users.TitleType.forString(remoteSupportRequestXml.getRsrSubject().getSubjectTitle().toString()));
        else
            remoteSupportRequest.setSubjectTitle(fr.cg95.cvq.business.users.TitleType.getDefaultTitleType());
      
        remoteSupportRequest.setSpouseFirstName(remoteSupportRequestXml.getSpouse().getSpouseFirstName());
      
        remoteSupportRequest.setContactFirstName(remoteSupportRequestXml.getFirstContact().getContactFirstName());
      
        remoteSupportRequest.setTrusteeFirstName(remoteSupportRequestXml.getTrustee().getTrusteeFirstName());
      
        if (remoteSupportRequestXml.getContactKind() != null)
            remoteSupportRequest.setContactKind(fr.cg95.cvq.business.request.social.RsrContactKindType.forString(remoteSupportRequestXml.getContactKind().toString()));
        else
            remoteSupportRequest.setContactKind(fr.cg95.cvq.business.request.social.RsrContactKindType.getDefaultRsrContactKindType());
      
        remoteSupportRequest.setSecondContactFirstName(remoteSupportRequestXml.getSecondContact().getSecondContactFirstName());
      
        remoteSupportRequest.setSubjectIsTaxable(Boolean.valueOf(remoteSupportRequestXml.getRsrSubject().getSubjectIsTaxable()));
      
        remoteSupportRequest.setTrusteeLastName(remoteSupportRequestXml.getTrustee().getTrusteeLastName());
      
        remoteSupportRequest.setSecondContactPhone(remoteSupportRequestXml.getSecondContact().getSecondContactPhone());
      
        return remoteSupportRequest;
    }

  
    public final void setTrusteePhone(final String trusteePhone) {
        remoteSupportRequestData.setTrusteePhone(trusteePhone);
    }

    public final String getTrusteePhone() {
        return remoteSupportRequestData.getTrusteePhone();
    }
  
    public final void setSpouseIsDisabledPerson(final Boolean spouseIsDisabledPerson) {
        remoteSupportRequestData.setSpouseIsDisabledPerson(spouseIsDisabledPerson);
    }

    public final Boolean getSpouseIsDisabledPerson() {
        return remoteSupportRequestData.getSpouseIsDisabledPerson();
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
  
    public final void setSubjectResideWith(final fr.cg95.cvq.business.request.social.RsrSubjectResideWithType subjectResideWith) {
        remoteSupportRequestData.setSubjectResideWith(subjectResideWith);
    }

    public final fr.cg95.cvq.business.request.social.RsrSubjectResideWithType getSubjectResideWith() {
        return remoteSupportRequestData.getSubjectResideWith();
    }
  
    public final void setSpouseBirthDate(final java.util.Date spouseBirthDate) {
        remoteSupportRequestData.setSpouseBirthDate(spouseBirthDate);
    }

    public final java.util.Date getSpouseBirthDate() {
        return remoteSupportRequestData.getSpouseBirthDate();
    }
  
    public final void setContactPhone(final String contactPhone) {
        remoteSupportRequestData.setContactPhone(contactPhone);
    }

    public final String getContactPhone() {
        return remoteSupportRequestData.getContactPhone();
    }
  
    public final void setSpouseLastName(final String spouseLastName) {
        remoteSupportRequestData.setSpouseLastName(spouseLastName);
    }

    public final String getSpouseLastName() {
        return remoteSupportRequestData.getSpouseLastName();
    }
  
    public final void setRequestInformationEmergency(final Boolean requestInformationEmergency) {
        remoteSupportRequestData.setRequestInformationEmergency(requestInformationEmergency);
    }

    public final Boolean getRequestInformationEmergency() {
        return remoteSupportRequestData.getRequestInformationEmergency();
    }
  
    public final void setRequestInformationRequestKind(final fr.cg95.cvq.business.request.social.RsrRequestInformationRequestKindType requestInformationRequestKind) {
        remoteSupportRequestData.setRequestInformationRequestKind(requestInformationRequestKind);
    }

    public final fr.cg95.cvq.business.request.social.RsrRequestInformationRequestKindType getRequestInformationRequestKind() {
        return remoteSupportRequestData.getRequestInformationRequestKind();
    }
  
    public final void setSubjectIsDisabledPerson(final Boolean subjectIsDisabledPerson) {
        remoteSupportRequestData.setSubjectIsDisabledPerson(subjectIsDisabledPerson);
    }

    public final Boolean getSubjectIsDisabledPerson() {
        return remoteSupportRequestData.getSubjectIsDisabledPerson();
    }
  
    public final void setSecondContactLastName(final String secondContactLastName) {
        remoteSupportRequestData.setSecondContactLastName(secondContactLastName);
    }

    public final String getSecondContactLastName() {
        return remoteSupportRequestData.getSecondContactLastName();
    }
  
    public final void setRequestInformationEmergencyMotive(final String requestInformationEmergencyMotive) {
        remoteSupportRequestData.setRequestInformationEmergencyMotive(requestInformationEmergencyMotive);
    }

    public final String getRequestInformationEmergencyMotive() {
        return remoteSupportRequestData.getRequestInformationEmergencyMotive();
    }
  
    public final void setContactLastName(final String contactLastName) {
        remoteSupportRequestData.setContactLastName(contactLastName);
    }

    public final String getContactLastName() {
        return remoteSupportRequestData.getContactLastName();
    }
  
    public final void setSpouseTitle(final fr.cg95.cvq.business.users.TitleType spouseTitle) {
        remoteSupportRequestData.setSpouseTitle(spouseTitle);
    }

    public final fr.cg95.cvq.business.users.TitleType getSpouseTitle() {
        return remoteSupportRequestData.getSpouseTitle();
    }
  
    public final void setSubjectTitle(final fr.cg95.cvq.business.users.TitleType subjectTitle) {
        remoteSupportRequestData.setSubjectTitle(subjectTitle);
    }

    public final fr.cg95.cvq.business.users.TitleType getSubjectTitle() {
        return remoteSupportRequestData.getSubjectTitle();
    }
  
    public final void setSpouseFirstName(final String spouseFirstName) {
        remoteSupportRequestData.setSpouseFirstName(spouseFirstName);
    }

    public final String getSpouseFirstName() {
        return remoteSupportRequestData.getSpouseFirstName();
    }
  
    public final void setContactFirstName(final String contactFirstName) {
        remoteSupportRequestData.setContactFirstName(contactFirstName);
    }

    public final String getContactFirstName() {
        return remoteSupportRequestData.getContactFirstName();
    }
  
    public final void setTrusteeFirstName(final String trusteeFirstName) {
        remoteSupportRequestData.setTrusteeFirstName(trusteeFirstName);
    }

    public final String getTrusteeFirstName() {
        return remoteSupportRequestData.getTrusteeFirstName();
    }
  
    public final void setContactKind(final fr.cg95.cvq.business.request.social.RsrContactKindType contactKind) {
        remoteSupportRequestData.setContactKind(contactKind);
    }

    public final fr.cg95.cvq.business.request.social.RsrContactKindType getContactKind() {
        return remoteSupportRequestData.getContactKind();
    }
  
    public final void setSecondContactFirstName(final String secondContactFirstName) {
        remoteSupportRequestData.setSecondContactFirstName(secondContactFirstName);
    }

    public final String getSecondContactFirstName() {
        return remoteSupportRequestData.getSecondContactFirstName();
    }
  
    public final void setSubjectIsTaxable(final Boolean subjectIsTaxable) {
        remoteSupportRequestData.setSubjectIsTaxable(subjectIsTaxable);
    }

    public final Boolean getSubjectIsTaxable() {
        return remoteSupportRequestData.getSubjectIsTaxable();
    }
  
    public final void setTrusteeLastName(final String trusteeLastName) {
        remoteSupportRequestData.setTrusteeLastName(trusteeLastName);
    }

    public final String getTrusteeLastName() {
        return remoteSupportRequestData.getTrusteeLastName();
    }
  
    public final void setSecondContactPhone(final String secondContactPhone) {
        remoteSupportRequestData.setSecondContactPhone(secondContactPhone);
    }

    public final String getSecondContactPhone() {
        return remoteSupportRequestData.getSecondContactPhone();
    }
  
}
