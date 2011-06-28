
package fr.cg95.cvq.business.request.election;

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
import fr.cg95.cvq.xml.request.election.*;
import fr.cg95.cvq.service.request.condition.IConditionChecker;

/**
 * Generated class file, do not edit !
 */
public class MultiCerfaElectoralRollRegistrationRequest extends Request implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final Map<String, IConditionChecker> conditions = MultiCerfaElectoralRollRegistrationRequestData.conditions;

    @AssertValid(message = "")
    private MultiCerfaElectoralRollRegistrationRequestData multiCerfaElectoralRollRegistrationRequestData;

    public MultiCerfaElectoralRollRegistrationRequest(RequestData requestData, MultiCerfaElectoralRollRegistrationRequestData multiCerfaElectoralRollRegistrationRequestData) {
        super(requestData);
        this.multiCerfaElectoralRollRegistrationRequestData = multiCerfaElectoralRollRegistrationRequestData;
    }

    public MultiCerfaElectoralRollRegistrationRequest() {
        super();
        this.multiCerfaElectoralRollRegistrationRequestData = new MultiCerfaElectoralRollRegistrationRequestData();
    }

    /**
     * Reserved for RequestDAO !
     */
    @Override
    public MultiCerfaElectoralRollRegistrationRequestData getSpecificData() {
        return multiCerfaElectoralRollRegistrationRequestData;
    }

    /**
     * Reserved for RequestDAO !
     */
    public void setSpecificData(MultiCerfaElectoralRollRegistrationRequestData multiCerfaElectoralRollRegistrationRequestData) {
        this.multiCerfaElectoralRollRegistrationRequestData = multiCerfaElectoralRollRegistrationRequestData;
    }

    @Override
    public final String modelToXmlString() {
        MultiCerfaElectoralRollRegistrationRequestDocument object = this.modelToXml();
        XmlOptions opts = new XmlOptions();
        opts.setSavePrettyPrint();
        opts.setSavePrettyPrintIndent(4);
        opts.setUseDefaultNamespace();
        opts.setCharacterEncoding("UTF-8");
        return object.xmlText(opts);
    }

    @Override
    public final MultiCerfaElectoralRollRegistrationRequestDocument modelToXml() {
        
        Calendar calendar = Calendar.getInstance();
        Date date = null;
        MultiCerfaElectoralRollRegistrationRequestDocument multiCerfaElectoralRollRegistrationRequestDoc = MultiCerfaElectoralRollRegistrationRequestDocument.Factory.newInstance();
        MultiCerfaElectoralRollRegistrationRequestDocument.MultiCerfaElectoralRollRegistrationRequest multiCerfaElectoralRollRegistrationRequest = multiCerfaElectoralRollRegistrationRequestDoc.addNewMultiCerfaElectoralRollRegistrationRequest();
        super.fillCommonXmlInfo(multiCerfaElectoralRollRegistrationRequest);
        int i = 0;
          AdditionalOldAddressInformationType additionalOldAddressInformationTypeOldAddressInformation = multiCerfaElectoralRollRegistrationRequest.addNewOldAddressInformation();
        additionalOldAddressInformationTypeOldAddressInformation.setOldDepartment(getOldDepartment());
      
        multiCerfaElectoralRollRegistrationRequest.setExternalDistrictAECT(getExternalDistrictAECT());
      
        if (getMotive() != null)
            multiCerfaElectoralRollRegistrationRequest.setMotive(fr.cg95.cvq.xml.request.election.ElectoralSituationType.Enum.forString(getMotive().toString()));
      
        if (getChoiceNationality() != null)
            multiCerfaElectoralRollRegistrationRequest.setChoiceNationality(fr.cg95.cvq.xml.request.election.NationalityChoiceType.Enum.forString(getChoiceNationality().toString()));
        SubjectPlaceRegistrationType subjectPlaceRegistrationTypeSubjectPlaceToRegister = multiCerfaElectoralRollRegistrationRequest.addNewSubjectPlaceToRegister();
        subjectPlaceRegistrationTypeSubjectPlaceToRegister.setRegistrationCity(getRegistrationCity());
        SubjectChoiceType subjectChoiceTypeSubjectSheet = multiCerfaElectoralRollRegistrationRequest.addNewSubjectSheet();
        date = getSubjectChoiceBirthDate();
        if (date != null) {
            calendar.setTime(date);
            subjectChoiceTypeSubjectSheet.setSubjectChoiceBirthDate(calendar);
        }
        AdditionalFrenchCerfaType additionalFrenchCerfaTypeAdditionInformationFrenchCerfa = multiCerfaElectoralRollRegistrationRequest.addNewAdditionInformationFrenchCerfa();
        additionalFrenchCerfaTypeAdditionInformationFrenchCerfa.setAmbassyOrConsulateAFCT(getAmbassyOrConsulateAFCT());
      
        subjectChoiceTypeSubjectSheet.setSubjectChoiceEmail(getSubjectChoiceEmail());
      
        subjectPlaceRegistrationTypeSubjectPlaceToRegister.setRegistrationPostalCode(getRegistrationPostalCode());
      
        if (getSubjectChoiceTitle() != null)
            subjectChoiceTypeSubjectSheet.setSubjectChoiceTitle(fr.cg95.cvq.xml.common.TitleType.Enum.forString(getSubjectChoiceTitle().toString()));
      
        subjectChoiceTypeSubjectSheet.setSubjectChoiceMobilPhone(getSubjectChoiceMobilPhone());
      
        subjectChoiceTypeSubjectSheet.setSubjectChoiceProPhone(getSubjectChoiceProPhone());
      
        subjectChoiceTypeSubjectSheet.setSubjectChoiceFirstName(getSubjectChoiceFirstName());
      
        if (getEuropeanNationality() != null)
            multiCerfaElectoralRollRegistrationRequest.setEuropeanNationality(fr.cg95.cvq.xml.request.election.EuropeanNationalityType.Enum.forString(getEuropeanNationality().toString()));
      
        multiCerfaElectoralRollRegistrationRequest.setExternalCityAECT(getExternalCityAECT());
      
        subjectChoiceTypeSubjectSheet.setSubjectChoiceBirthCity(getSubjectChoiceBirthCity());
      
        subjectChoiceTypeSubjectSheet.setSubjectChoiceLastName(getSubjectChoiceLastName());
      
        subjectChoiceTypeSubjectSheet.setSubjectChoiceBirthPostalCode(getSubjectChoiceBirthPostalCode());
      
        subjectChoiceTypeSubjectSheet.setSubjectChoiceHomePhone(getSubjectChoiceHomePhone());
      
        additionalOldAddressInformationTypeOldAddressInformation.setOldCity(getOldCity());
      
        if (getExternalCountryAECT() != null)
            multiCerfaElectoralRollRegistrationRequest.setExternalCountryAECT(fr.cg95.cvq.xml.request.election.EuropeanNationalityType.Enum.forString(getExternalCountryAECT().toString()));
      
        subjectChoiceTypeSubjectSheet.setSubjectChoiceMaidenName(getSubjectChoiceMaidenName());
      
        if (getExternalCountryAFCT() != null)
            additionalFrenchCerfaTypeAdditionInformationFrenchCerfa.setExternalCountryAFCT(fr.cg95.cvq.xml.common.CountryType.Enum.forString(getExternalCountryAFCT().toString()));
      
        if (getElectionChoice() != null)
            multiCerfaElectoralRollRegistrationRequest.setElectionChoice(fr.cg95.cvq.xml.request.election.ElectoralChoiceEuropeanType.Enum.forString(getElectionChoice().toString()));
      
        additionalOldAddressInformationTypeOldAddressInformation.setOldOverseas(getOldOverseas());
      
        if (getSubjectChoiceAddress() != null)
            subjectChoiceTypeSubjectSheet.setSubjectChoiceAddress(Address.modelToXml(getSubjectChoiceAddress()));
      
        if (getSubjectChoiceBirthCountry() != null)
            subjectChoiceTypeSubjectSheet.setSubjectChoiceBirthCountry(fr.cg95.cvq.xml.common.CountryType.Enum.forString(getSubjectChoiceBirthCountry().toString()));
      
        return multiCerfaElectoralRollRegistrationRequestDoc;
    }

    @Override
    public final MultiCerfaElectoralRollRegistrationRequestDocument.MultiCerfaElectoralRollRegistrationRequest modelToXmlRequest() {
        return modelToXml().getMultiCerfaElectoralRollRegistrationRequest();
    }

    public static MultiCerfaElectoralRollRegistrationRequest xmlToModel(MultiCerfaElectoralRollRegistrationRequestDocument multiCerfaElectoralRollRegistrationRequestDoc) {
        MultiCerfaElectoralRollRegistrationRequestDocument.MultiCerfaElectoralRollRegistrationRequest multiCerfaElectoralRollRegistrationRequestXml = multiCerfaElectoralRollRegistrationRequestDoc.getMultiCerfaElectoralRollRegistrationRequest();
        Calendar calendar = Calendar.getInstance();
        List list = new ArrayList();
        MultiCerfaElectoralRollRegistrationRequest multiCerfaElectoralRollRegistrationRequest = new MultiCerfaElectoralRollRegistrationRequest();
        multiCerfaElectoralRollRegistrationRequest.fillCommonModelInfo(multiCerfaElectoralRollRegistrationRequest, multiCerfaElectoralRollRegistrationRequestXml);
        
        multiCerfaElectoralRollRegistrationRequest.setOldDepartment(multiCerfaElectoralRollRegistrationRequestXml.getOldAddressInformation().getOldDepartment());
      
        multiCerfaElectoralRollRegistrationRequest.setExternalDistrictAECT(multiCerfaElectoralRollRegistrationRequestXml.getExternalDistrictAECT());
      
        if (multiCerfaElectoralRollRegistrationRequestXml.getMotive() != null)
            multiCerfaElectoralRollRegistrationRequest.setMotive(fr.cg95.cvq.business.request.election.ElectoralSituationType.forString(multiCerfaElectoralRollRegistrationRequestXml.getMotive().toString()));
        else
            multiCerfaElectoralRollRegistrationRequest.setMotive(fr.cg95.cvq.business.request.election.ElectoralSituationType.getDefaultElectoralSituationType());
      
        if (multiCerfaElectoralRollRegistrationRequestXml.getChoiceNationality() != null)
            multiCerfaElectoralRollRegistrationRequest.setChoiceNationality(fr.cg95.cvq.business.request.election.NationalityChoiceType.forString(multiCerfaElectoralRollRegistrationRequestXml.getChoiceNationality().toString()));
        else
            multiCerfaElectoralRollRegistrationRequest.setChoiceNationality(fr.cg95.cvq.business.request.election.NationalityChoiceType.getDefaultNationalityChoiceType());
      
        multiCerfaElectoralRollRegistrationRequest.setRegistrationCity(multiCerfaElectoralRollRegistrationRequestXml.getSubjectPlaceToRegister().getRegistrationCity());
      
        calendar = multiCerfaElectoralRollRegistrationRequestXml.getSubjectSheet().getSubjectChoiceBirthDate();
        if (calendar != null) {
            multiCerfaElectoralRollRegistrationRequest.setSubjectChoiceBirthDate(calendar.getTime());
        }
      
        multiCerfaElectoralRollRegistrationRequest.setAmbassyOrConsulateAFCT(multiCerfaElectoralRollRegistrationRequestXml.getAdditionInformationFrenchCerfa().getAmbassyOrConsulateAFCT());
      
        multiCerfaElectoralRollRegistrationRequest.setSubjectChoiceEmail(multiCerfaElectoralRollRegistrationRequestXml.getSubjectSheet().getSubjectChoiceEmail());
      
        multiCerfaElectoralRollRegistrationRequest.setRegistrationPostalCode(multiCerfaElectoralRollRegistrationRequestXml.getSubjectPlaceToRegister().getRegistrationPostalCode());
      
        if (multiCerfaElectoralRollRegistrationRequestXml.getSubjectSheet().getSubjectChoiceTitle() != null)
            multiCerfaElectoralRollRegistrationRequest.setSubjectChoiceTitle(fr.cg95.cvq.business.users.TitleType.forString(multiCerfaElectoralRollRegistrationRequestXml.getSubjectSheet().getSubjectChoiceTitle().toString()));
        else
            multiCerfaElectoralRollRegistrationRequest.setSubjectChoiceTitle(fr.cg95.cvq.business.users.TitleType.getDefaultTitleType());
      
        multiCerfaElectoralRollRegistrationRequest.setSubjectChoiceMobilPhone(multiCerfaElectoralRollRegistrationRequestXml.getSubjectSheet().getSubjectChoiceMobilPhone());
      
        multiCerfaElectoralRollRegistrationRequest.setSubjectChoiceProPhone(multiCerfaElectoralRollRegistrationRequestXml.getSubjectSheet().getSubjectChoiceProPhone());
      
        multiCerfaElectoralRollRegistrationRequest.setSubjectChoiceFirstName(multiCerfaElectoralRollRegistrationRequestXml.getSubjectSheet().getSubjectChoiceFirstName());
      
        if (multiCerfaElectoralRollRegistrationRequestXml.getEuropeanNationality() != null)
            multiCerfaElectoralRollRegistrationRequest.setEuropeanNationality(fr.cg95.cvq.business.request.election.EuropeanNationalityType.forString(multiCerfaElectoralRollRegistrationRequestXml.getEuropeanNationality().toString()));
        else
            multiCerfaElectoralRollRegistrationRequest.setEuropeanNationality(fr.cg95.cvq.business.request.election.EuropeanNationalityType.getDefaultEuropeanNationalityType());
      
        multiCerfaElectoralRollRegistrationRequest.setExternalCityAECT(multiCerfaElectoralRollRegistrationRequestXml.getExternalCityAECT());
      
        multiCerfaElectoralRollRegistrationRequest.setSubjectChoiceBirthCity(multiCerfaElectoralRollRegistrationRequestXml.getSubjectSheet().getSubjectChoiceBirthCity());
      
        multiCerfaElectoralRollRegistrationRequest.setSubjectChoiceLastName(multiCerfaElectoralRollRegistrationRequestXml.getSubjectSheet().getSubjectChoiceLastName());
      
        multiCerfaElectoralRollRegistrationRequest.setSubjectChoiceBirthPostalCode(multiCerfaElectoralRollRegistrationRequestXml.getSubjectSheet().getSubjectChoiceBirthPostalCode());
      
        multiCerfaElectoralRollRegistrationRequest.setSubjectChoiceHomePhone(multiCerfaElectoralRollRegistrationRequestXml.getSubjectSheet().getSubjectChoiceHomePhone());
      
        multiCerfaElectoralRollRegistrationRequest.setOldCity(multiCerfaElectoralRollRegistrationRequestXml.getOldAddressInformation().getOldCity());
      
        if (multiCerfaElectoralRollRegistrationRequestXml.getExternalCountryAECT() != null)
            multiCerfaElectoralRollRegistrationRequest.setExternalCountryAECT(fr.cg95.cvq.business.request.election.EuropeanNationalityType.forString(multiCerfaElectoralRollRegistrationRequestXml.getExternalCountryAECT().toString()));
        else
            multiCerfaElectoralRollRegistrationRequest.setExternalCountryAECT(fr.cg95.cvq.business.request.election.EuropeanNationalityType.getDefaultEuropeanNationalityType());
      
        multiCerfaElectoralRollRegistrationRequest.setSubjectChoiceMaidenName(multiCerfaElectoralRollRegistrationRequestXml.getSubjectSheet().getSubjectChoiceMaidenName());
      
        if (multiCerfaElectoralRollRegistrationRequestXml.getAdditionInformationFrenchCerfa().getExternalCountryAFCT() != null)
            multiCerfaElectoralRollRegistrationRequest.setExternalCountryAFCT(fr.cg95.cvq.business.users.CountryType.forString(multiCerfaElectoralRollRegistrationRequestXml.getAdditionInformationFrenchCerfa().getExternalCountryAFCT().toString()));
        else
            multiCerfaElectoralRollRegistrationRequest.setExternalCountryAFCT(fr.cg95.cvq.business.users.CountryType.getDefaultCountryType());
      
        if (multiCerfaElectoralRollRegistrationRequestXml.getElectionChoice() != null)
            multiCerfaElectoralRollRegistrationRequest.setElectionChoice(fr.cg95.cvq.business.request.election.ElectoralChoiceEuropeanType.forString(multiCerfaElectoralRollRegistrationRequestXml.getElectionChoice().toString()));
        else
            multiCerfaElectoralRollRegistrationRequest.setElectionChoice(fr.cg95.cvq.business.request.election.ElectoralChoiceEuropeanType.getDefaultElectoralChoiceEuropeanType());
      
        multiCerfaElectoralRollRegistrationRequest.setOldOverseas(multiCerfaElectoralRollRegistrationRequestXml.getOldAddressInformation().getOldOverseas());
      
        if (multiCerfaElectoralRollRegistrationRequestXml.getSubjectSheet().getSubjectChoiceAddress() != null)
            multiCerfaElectoralRollRegistrationRequest.setSubjectChoiceAddress(Address.xmlToModel(multiCerfaElectoralRollRegistrationRequestXml.getSubjectSheet().getSubjectChoiceAddress()));
      
        if (multiCerfaElectoralRollRegistrationRequestXml.getSubjectSheet().getSubjectChoiceBirthCountry() != null)
            multiCerfaElectoralRollRegistrationRequest.setSubjectChoiceBirthCountry(fr.cg95.cvq.business.users.CountryType.forString(multiCerfaElectoralRollRegistrationRequestXml.getSubjectSheet().getSubjectChoiceBirthCountry().toString()));
        else
            multiCerfaElectoralRollRegistrationRequest.setSubjectChoiceBirthCountry(fr.cg95.cvq.business.users.CountryType.getDefaultCountryType());
      
        return multiCerfaElectoralRollRegistrationRequest;
    }

  
    public final void setOldDepartment(final String oldDepartment) {
        multiCerfaElectoralRollRegistrationRequestData.setOldDepartment(oldDepartment);
    }

    
    public final String getOldDepartment() {
        return multiCerfaElectoralRollRegistrationRequestData.getOldDepartment();
    }
  
    public final void setExternalDistrictAECT(final String externalDistrictAECT) {
        multiCerfaElectoralRollRegistrationRequestData.setExternalDistrictAECT(externalDistrictAECT);
    }

    
    public final String getExternalDistrictAECT() {
        return multiCerfaElectoralRollRegistrationRequestData.getExternalDistrictAECT();
    }
  
    public final void setMotive(final fr.cg95.cvq.business.request.election.ElectoralSituationType motive) {
        multiCerfaElectoralRollRegistrationRequestData.setMotive(motive);
    }

    
    public final fr.cg95.cvq.business.request.election.ElectoralSituationType getMotive() {
        return multiCerfaElectoralRollRegistrationRequestData.getMotive();
    }
  
    public final void setChoiceNationality(final fr.cg95.cvq.business.request.election.NationalityChoiceType choiceNationality) {
        multiCerfaElectoralRollRegistrationRequestData.setChoiceNationality(choiceNationality);
    }

    
    public final fr.cg95.cvq.business.request.election.NationalityChoiceType getChoiceNationality() {
        return multiCerfaElectoralRollRegistrationRequestData.getChoiceNationality();
    }
  
    public final void setRegistrationCity(final String registrationCity) {
        multiCerfaElectoralRollRegistrationRequestData.setRegistrationCity(registrationCity);
    }

    
    public final String getRegistrationCity() {
        return multiCerfaElectoralRollRegistrationRequestData.getRegistrationCity();
    }
  
    public final void setSubjectChoiceBirthDate(final java.util.Date subjectChoiceBirthDate) {
        multiCerfaElectoralRollRegistrationRequestData.setSubjectChoiceBirthDate(subjectChoiceBirthDate);
    }

    
    public final java.util.Date getSubjectChoiceBirthDate() {
        return multiCerfaElectoralRollRegistrationRequestData.getSubjectChoiceBirthDate();
    }
  
    public final void setAmbassyOrConsulateAFCT(final String ambassyOrConsulateAFCT) {
        multiCerfaElectoralRollRegistrationRequestData.setAmbassyOrConsulateAFCT(ambassyOrConsulateAFCT);
    }

    
    public final String getAmbassyOrConsulateAFCT() {
        return multiCerfaElectoralRollRegistrationRequestData.getAmbassyOrConsulateAFCT();
    }
  
    public final void setSubjectChoiceEmail(final String subjectChoiceEmail) {
        multiCerfaElectoralRollRegistrationRequestData.setSubjectChoiceEmail(subjectChoiceEmail);
    }

    
    public final String getSubjectChoiceEmail() {
        return multiCerfaElectoralRollRegistrationRequestData.getSubjectChoiceEmail();
    }
  
    public final void setRegistrationPostalCode(final String registrationPostalCode) {
        multiCerfaElectoralRollRegistrationRequestData.setRegistrationPostalCode(registrationPostalCode);
    }

    
    public final String getRegistrationPostalCode() {
        return multiCerfaElectoralRollRegistrationRequestData.getRegistrationPostalCode();
    }
  
    public final void setSubjectChoiceTitle(final fr.cg95.cvq.business.users.TitleType subjectChoiceTitle) {
        multiCerfaElectoralRollRegistrationRequestData.setSubjectChoiceTitle(subjectChoiceTitle);
    }

    
    public final fr.cg95.cvq.business.users.TitleType getSubjectChoiceTitle() {
        return multiCerfaElectoralRollRegistrationRequestData.getSubjectChoiceTitle();
    }
  
    public final void setSubjectChoiceMobilPhone(final String subjectChoiceMobilPhone) {
        multiCerfaElectoralRollRegistrationRequestData.setSubjectChoiceMobilPhone(subjectChoiceMobilPhone);
    }

    
    public final String getSubjectChoiceMobilPhone() {
        return multiCerfaElectoralRollRegistrationRequestData.getSubjectChoiceMobilPhone();
    }
  
    public final void setSubjectChoiceProPhone(final String subjectChoiceProPhone) {
        multiCerfaElectoralRollRegistrationRequestData.setSubjectChoiceProPhone(subjectChoiceProPhone);
    }

    
    public final String getSubjectChoiceProPhone() {
        return multiCerfaElectoralRollRegistrationRequestData.getSubjectChoiceProPhone();
    }
  
    public final void setSubjectChoiceFirstName(final String subjectChoiceFirstName) {
        multiCerfaElectoralRollRegistrationRequestData.setSubjectChoiceFirstName(subjectChoiceFirstName);
    }

    
    public final String getSubjectChoiceFirstName() {
        return multiCerfaElectoralRollRegistrationRequestData.getSubjectChoiceFirstName();
    }
  
    public final void setEuropeanNationality(final fr.cg95.cvq.business.request.election.EuropeanNationalityType europeanNationality) {
        multiCerfaElectoralRollRegistrationRequestData.setEuropeanNationality(europeanNationality);
    }

    
    public final fr.cg95.cvq.business.request.election.EuropeanNationalityType getEuropeanNationality() {
        return multiCerfaElectoralRollRegistrationRequestData.getEuropeanNationality();
    }
  
    public final void setExternalCityAECT(final String externalCityAECT) {
        multiCerfaElectoralRollRegistrationRequestData.setExternalCityAECT(externalCityAECT);
    }

    
    public final String getExternalCityAECT() {
        return multiCerfaElectoralRollRegistrationRequestData.getExternalCityAECT();
    }
  
    public final void setSubjectChoiceBirthCity(final String subjectChoiceBirthCity) {
        multiCerfaElectoralRollRegistrationRequestData.setSubjectChoiceBirthCity(subjectChoiceBirthCity);
    }

    
    public final String getSubjectChoiceBirthCity() {
        return multiCerfaElectoralRollRegistrationRequestData.getSubjectChoiceBirthCity();
    }
  
    public final void setSubjectChoiceLastName(final String subjectChoiceLastName) {
        multiCerfaElectoralRollRegistrationRequestData.setSubjectChoiceLastName(subjectChoiceLastName);
    }

    
    public final String getSubjectChoiceLastName() {
        return multiCerfaElectoralRollRegistrationRequestData.getSubjectChoiceLastName();
    }
  
    public final void setSubjectChoiceBirthPostalCode(final String subjectChoiceBirthPostalCode) {
        multiCerfaElectoralRollRegistrationRequestData.setSubjectChoiceBirthPostalCode(subjectChoiceBirthPostalCode);
    }

    
    public final String getSubjectChoiceBirthPostalCode() {
        return multiCerfaElectoralRollRegistrationRequestData.getSubjectChoiceBirthPostalCode();
    }
  
    public final void setSubjectChoiceHomePhone(final String subjectChoiceHomePhone) {
        multiCerfaElectoralRollRegistrationRequestData.setSubjectChoiceHomePhone(subjectChoiceHomePhone);
    }

    
    public final String getSubjectChoiceHomePhone() {
        return multiCerfaElectoralRollRegistrationRequestData.getSubjectChoiceHomePhone();
    }
  
    public final void setOldCity(final String oldCity) {
        multiCerfaElectoralRollRegistrationRequestData.setOldCity(oldCity);
    }

    
    public final String getOldCity() {
        return multiCerfaElectoralRollRegistrationRequestData.getOldCity();
    }
  
    public final void setExternalCountryAECT(final fr.cg95.cvq.business.request.election.EuropeanNationalityType externalCountryAECT) {
        multiCerfaElectoralRollRegistrationRequestData.setExternalCountryAECT(externalCountryAECT);
    }

    
    public final fr.cg95.cvq.business.request.election.EuropeanNationalityType getExternalCountryAECT() {
        return multiCerfaElectoralRollRegistrationRequestData.getExternalCountryAECT();
    }
  
    public final void setSubjectChoiceMaidenName(final String subjectChoiceMaidenName) {
        multiCerfaElectoralRollRegistrationRequestData.setSubjectChoiceMaidenName(subjectChoiceMaidenName);
    }

    
    public final String getSubjectChoiceMaidenName() {
        return multiCerfaElectoralRollRegistrationRequestData.getSubjectChoiceMaidenName();
    }
  
    public final void setExternalCountryAFCT(final fr.cg95.cvq.business.users.CountryType externalCountryAFCT) {
        multiCerfaElectoralRollRegistrationRequestData.setExternalCountryAFCT(externalCountryAFCT);
    }

    
    public final fr.cg95.cvq.business.users.CountryType getExternalCountryAFCT() {
        return multiCerfaElectoralRollRegistrationRequestData.getExternalCountryAFCT();
    }
  
    public final void setElectionChoice(final fr.cg95.cvq.business.request.election.ElectoralChoiceEuropeanType electionChoice) {
        multiCerfaElectoralRollRegistrationRequestData.setElectionChoice(electionChoice);
    }

    
    public final fr.cg95.cvq.business.request.election.ElectoralChoiceEuropeanType getElectionChoice() {
        return multiCerfaElectoralRollRegistrationRequestData.getElectionChoice();
    }
  
    public final void setOldOverseas(final String oldOverseas) {
        multiCerfaElectoralRollRegistrationRequestData.setOldOverseas(oldOverseas);
    }

    
    public final String getOldOverseas() {
        return multiCerfaElectoralRollRegistrationRequestData.getOldOverseas();
    }
  
    public final void setSubjectChoiceAddress(final fr.cg95.cvq.business.users.Address subjectChoiceAddress) {
        multiCerfaElectoralRollRegistrationRequestData.setSubjectChoiceAddress(subjectChoiceAddress);
    }

    
    public final fr.cg95.cvq.business.users.Address getSubjectChoiceAddress() {
        return multiCerfaElectoralRollRegistrationRequestData.getSubjectChoiceAddress();
    }
  
    public final void setSubjectChoiceBirthCountry(final fr.cg95.cvq.business.users.CountryType subjectChoiceBirthCountry) {
        multiCerfaElectoralRollRegistrationRequestData.setSubjectChoiceBirthCountry(subjectChoiceBirthCountry);
    }

    
    public final fr.cg95.cvq.business.users.CountryType getSubjectChoiceBirthCountry() {
        return multiCerfaElectoralRollRegistrationRequestData.getSubjectChoiceBirthCountry();
    }
  
}
