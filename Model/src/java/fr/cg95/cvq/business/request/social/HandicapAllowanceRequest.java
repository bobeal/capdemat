package fr.cg95.cvq.business.request.social;

import fr.cg95.cvq.business.request.*;
import fr.cg95.cvq.business.users.*;
import fr.cg95.cvq.business.authority.*;
import fr.cg95.cvq.xml.common.*;
import fr.cg95.cvq.xml.request.social.*;

import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlObject;

import fr.cg95.cvq.xml.common.RequestType;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.*;

/**
 * Generated class file, do not edit !
 *
 * @hibernate.joined-subclass
 *  table="handicap_allowance_request"
 *  lazy="false"
 * @hibernate.joined-subclass-key
 *  column="id"
 */
public class HandicapAllowanceRequest extends Request implements Serializable { 

    private static final long serialVersionUID = 1L;



    public HandicapAllowanceRequest() {
        super();
    }


    public final String modelToXmlString() {

        HandicapAllowanceRequestDocument object = (HandicapAllowanceRequestDocument) this.modelToXml();
        XmlOptions opts = new XmlOptions();
        opts.setSavePrettyPrint();
        opts.setSavePrettyPrintIndent(4);
        opts.setUseDefaultNamespace();
        opts.setCharacterEncoding("UTF-8");
        return object.xmlText(opts);
    }

    public final XmlObject modelToXml() {

        Calendar calendar = Calendar.getInstance();
        Date date = null;
        HandicapAllowanceRequestDocument handicapAllowanceRequestDoc = HandicapAllowanceRequestDocument.Factory.newInstance();
        HandicapAllowanceRequestDocument.HandicapAllowanceRequest handicapAllowanceRequest = handicapAllowanceRequestDoc.addNewHandicapAllowanceRequest();
        super.fillCommonXmlInfo(handicapAllowanceRequest);
        AdultRequesterType adultRequesterTypeAdultRequester = handicapAllowanceRequest.addNewAdultRequester();
        adultRequesterTypeAdultRequester.setAdultRequesterFirstName(this.adultRequesterFirstName);
        LessThan20ReferentType lessThan20ReferentTypeLessThan20Referent = handicapAllowanceRequest.addNewLessThan20Referent();
        lessThan20ReferentTypeLessThan20Referent.setLessThan20ReferentBirthPlaceCity(this.lessThan20ReferentBirthPlaceCity);
        int i = 0;
        if (familyDependents != null) {
            fr.cg95.cvq.xml.request.social.HarFamilyDependentType[] familyDependentsTypeTab = new fr.cg95.cvq.xml.request.social.HarFamilyDependentType[familyDependents.size()];
            Iterator familyDependentsIt = familyDependents.iterator();
            while (familyDependentsIt.hasNext()) {
                HarFamilyDependent object = (HarFamilyDependent) familyDependentsIt.next();
                familyDependentsTypeTab[i] = (HarFamilyDependentType) object.modelToXml();
                i = i + 1;
            }
            handicapAllowanceRequest.setFamilyDependentsArray(familyDependentsTypeTab);
        }
        LessThan20FatherType lessThan20FatherTypeLessThan20Father = handicapAllowanceRequest.addNewLessThan20Father();
        lessThan20FatherTypeLessThan20Father.setLessThan20FatherMobilePhone(this.lessThan20FatherMobilePhone);
        lessThan20ReferentTypeLessThan20Referent.setLessThan20ReferentHomePhone(this.lessThan20ReferentHomePhone);
        if (this.lessThan20ReferentAddress != null)
            lessThan20ReferentTypeLessThan20Referent.setLessThan20ReferentAddress(Address.modelToXml(this.lessThan20ReferentAddress));
        if (this.writingHelp != null)
            handicapAllowanceRequest.setWritingHelp(this.writingHelp.booleanValue());
        FamilyType familyTypeFamily = handicapAllowanceRequest.addNewFamily();
        if (this.familyHasFamilyDependents != null)
            familyTypeFamily.setFamilyHasFamilyDependents(this.familyHasFamilyDependents.booleanValue());
        LessThan20ParentalAuthorityType lessThan20ParentalAuthorityTypeLessThan20ParentalAuthority = handicapAllowanceRequest.addNewLessThan20ParentalAuthority();
        lessThan20ParentalAuthorityTypeLessThan20ParentalAuthority.setLessThan20ParentalAuthorityDepartment(this.lessThan20ParentalAuthorityDepartment);
        LessThan20LegalRepresentativeType lessThan20LegalRepresentativeTypeLessThan20LegalRepresentative = handicapAllowanceRequest.addNewLessThan20LegalRepresentative();
        lessThan20LegalRepresentativeTypeLessThan20LegalRepresentative.setLessThan20LegalRepresentativeHomePhone(this.lessThan20LegalRepresentativeHomePhone);
        adultRequesterTypeAdultRequester.setAdultRequesterLastName(this.adultRequesterLastName);
        handicapAllowanceRequest.setHelperResponsability(this.helperResponsability);
        PaymentAgencyType paymentAgencyTypePaymentAgency = handicapAllowanceRequest.addNewPaymentAgency();
        if (this.paymentAgencyBeneficiary != null)
            paymentAgencyTypePaymentAgency.setPaymentAgencyBeneficiary(fr.cg95.cvq.xml.request.social.HarPaymentAgencyBeneficiaryType.Enum.forString(this.paymentAgencyBeneficiary.toString()));
        lessThan20FatherTypeLessThan20Father.setLessThan20FatherJob(this.lessThan20FatherJob);
        date = this.adultRequesterBirthDate;
        if (date != null) {
            calendar.setTime(date);
            adultRequesterTypeAdultRequester.setAdultRequesterBirthDate(calendar);
        }
        RequestInformationType requestInformationTypeRequestInformation = handicapAllowanceRequest.addNewRequestInformation();
        if (this.requestInformationRequesterProfile != null)
            requestInformationTypeRequestInformation.setRequestInformationRequesterProfile(fr.cg95.cvq.xml.request.social.HarRequestInformationProfileType.Enum.forString(this.requestInformationRequesterProfile.toString()));
        if (this.requestInformationKind != null)
            requestInformationTypeRequestInformation.setRequestInformationKind(fr.cg95.cvq.xml.request.social.HarRequestInformationKindType.Enum.forString(this.requestInformationKind.toString()));
        if (this.paymentAgencyAddress != null)
            paymentAgencyTypePaymentAgency.setPaymentAgencyAddress(Address.modelToXml(this.paymentAgencyAddress));
        if (this.lessThan20FatherAddress != null)
            lessThan20FatherTypeLessThan20Father.setLessThan20FatherAddress(Address.modelToXml(this.lessThan20FatherAddress));
        adultRequesterTypeAdultRequester.setAdultRequesterBirthPlaceCity(this.adultRequesterBirthPlaceCity);
        handicapAllowanceRequest.setComments(this.comments);
        adultRequesterTypeAdultRequester.setAdultRequesterEmail(this.adultRequesterEmail);
        SocialSecurityType socialSecurityTypeSocialSecurity = handicapAllowanceRequest.addNewSocialSecurity();
        if (this.socialSecurityAgencyAddress != null)
            socialSecurityTypeSocialSecurity.setSocialSecurityAgencyAddress(Address.modelToXml(this.socialSecurityAgencyAddress));
        DwellingType dwellingTypeDwelling = handicapAllowanceRequest.addNewDwelling();
        if (this.dwellingReceptionAddress != null)
            dwellingTypeDwelling.setDwellingReceptionAddress(Address.modelToXml(this.dwellingReceptionAddress));
        adultRequesterTypeAdultRequester.setAdultRequesterMobilePhone(this.adultRequesterMobilePhone);
        lessThan20ReferentTypeLessThan20Referent.setLessThan20ReferentMobilePhone(this.lessThan20ReferentMobilePhone);
        AdultLegalAccessType adultLegalAccessTypeAdultLegalAccess = handicapAllowanceRequest.addNewAdultLegalAccess();
        adultLegalAccessTypeAdultLegalAccess.setAdultLegalAccessRepresentativeLastName(this.adultLegalAccessRepresentativeLastName);
        if (this.adultLegalAccessKind != null)
            adultLegalAccessTypeAdultLegalAccess.setAdultLegalAccessKind(fr.cg95.cvq.xml.request.social.HarAdultLegalAccessKindType.Enum.forString(this.adultLegalAccessKind.toString()));
        lessThan20ReferentTypeLessThan20Referent.setLessThan20ReferentFirstName(this.lessThan20ReferentFirstName);
        lessThan20LegalRepresentativeTypeLessThan20LegalRepresentative.setLessThan20LegalRepresentativeFirstName(this.lessThan20LegalRepresentativeFirstName);
        lessThan20FatherTypeLessThan20Father.setLessThan20FatherFirstName(this.lessThan20FatherFirstName);
        adultLegalAccessTypeAdultLegalAccess.setAdultLegalAccessRepresentativeMobilePhone(this.adultLegalAccessRepresentativeMobilePhone);
        LessThan20MotherType lessThan20MotherTypeLessThan20Mother = handicapAllowanceRequest.addNewLessThan20Mother();
        lessThan20MotherTypeLessThan20Mother.setLessThan20MotherReductionRatio(this.lessThan20MotherReductionRatio);
        LessThan20RequesterType lessThan20RequesterTypeLessThan20Requester = handicapAllowanceRequest.addNewLessThan20Requester();
        lessThan20RequesterTypeLessThan20Requester.setLessThan20RequesterMobilePhone(this.lessThan20RequesterMobilePhone);
        lessThan20FatherTypeLessThan20Father.setLessThan20FatherHomePhone(this.lessThan20FatherHomePhone);
        if (this.dwellingReceptionType != null)
            dwellingTypeDwelling.setDwellingReceptionType(fr.cg95.cvq.xml.request.social.HarDwellingReceptionType.Enum.forString(this.dwellingReceptionType.toString()));
        lessThan20FatherTypeLessThan20Father.setLessThan20FatherReductionRatio(this.lessThan20FatherReductionRatio);
        if (this.adultRequesterAddress != null)
            adultRequesterTypeAdultRequester.setAdultRequesterAddress(Address.modelToXml(this.adultRequesterAddress));
        paymentAgencyTypePaymentAgency.setPaymentAgencyName(this.paymentAgencyName);
        dwellingTypeDwelling.setDwellingSocialReceptionNaming(this.dwellingSocialReceptionNaming);
        if (this.familyStatus != null)
            familyTypeFamily.setFamilyStatus(fr.cg95.cvq.xml.common.FamilyStatusType.Enum.forString(this.familyStatus.toString()));
        if (this.lessThan20MotherAddress != null)
            lessThan20MotherTypeLessThan20Mother.setLessThan20MotherAddress(Address.modelToXml(this.lessThan20MotherAddress));
        if (this.lessThan20Requester != null)
            lessThan20RequesterTypeLessThan20Requester.setLessThan20Requester(Individual.modelToXml(this.lessThan20Requester));
        lessThan20ParentalAuthorityTypeLessThan20ParentalAuthority.setLessThan20ParentalAuthorityName(this.lessThan20ParentalAuthorityName);
        adultLegalAccessTypeAdultLegalAccess.setAdultLegalAccessRepresentativePrecision(this.adultLegalAccessRepresentativePrecision);
        if (this.lessThan20LegalRepresentativeAddress != null)
            lessThan20LegalRepresentativeTypeLessThan20LegalRepresentative.setLessThan20LegalRepresentativeAddress(Address.modelToXml(this.lessThan20LegalRepresentativeAddress));
        socialSecurityTypeSocialSecurity.setSocialSecurityAgencyName(this.socialSecurityAgencyName);
        if (this.dwellingReceptionNaming != null)
            dwellingTypeDwelling.setDwellingReceptionNaming(fr.cg95.cvq.xml.request.social.HarDwellingReceptionType.Enum.forString(this.dwellingReceptionNaming.toString()));
        lessThan20MotherTypeLessThan20Mother.setLessThan20MotherFirstName(this.lessThan20MotherFirstName);
        socialSecurityTypeSocialSecurity.setSocialSecurityNumber(this.socialSecurityNumber);
        lessThan20MotherTypeLessThan20Mother.setLessThan20MotherMobilePhone(this.lessThan20MotherMobilePhone);
        if (this.lessThan20MotherActivityReduction != null)
            lessThan20MotherTypeLessThan20Mother.setLessThan20MotherActivityReduction(this.lessThan20MotherActivityReduction.booleanValue());
        lessThan20ReferentTypeLessThan20Referent.setLessThan20ReferentLastName(this.lessThan20ReferentLastName);
        adultLegalAccessTypeAdultLegalAccess.setAdultLegalAccessRepresentativeEmail(this.adultLegalAccessRepresentativeEmail);
        if (this.lessThan20ReferentBirthPlaceCountry != null)
            lessThan20ReferentTypeLessThan20Referent.setLessThan20ReferentBirthPlaceCountry(fr.cg95.cvq.xml.common.CountryType.Enum.forString(this.lessThan20ReferentBirthPlaceCountry.toString()));
        paymentAgencyTypePaymentAgency.setPaymentAgencyBeneficiaryNumber(this.paymentAgencyBeneficiaryNumber);
        if (this.lessThan20LegalRepresentative != null)
            lessThan20LegalRepresentativeTypeLessThan20LegalRepresentative.setLessThan20LegalRepresentative(this.lessThan20LegalRepresentative.booleanValue());
        adultLegalAccessTypeAdultLegalAccess.setAdultLegalAccessRepresentativeHomePhone(this.adultLegalAccessRepresentativeHomePhone);
        if (this.adultRequesterBirthPlaceCountry != null)
            adultRequesterTypeAdultRequester.setAdultRequesterBirthPlaceCountry(fr.cg95.cvq.xml.common.CountryType.Enum.forString(this.adultRequesterBirthPlaceCountry.toString()));
        if (this.dwellingSocialReceptionAddress != null)
            dwellingTypeDwelling.setDwellingSocialReceptionAddress(Address.modelToXml(this.dwellingSocialReceptionAddress));
        date = this.requestInformationExpirationDate;
        if (date != null) {
            calendar.setTime(date);
            requestInformationTypeRequestInformation.setRequestInformationExpirationDate(calendar);
        }
        if (this.adultRequesterTitle != null)
            adultRequesterTypeAdultRequester.setAdultRequesterTitle(fr.cg95.cvq.xml.common.TitleType.Enum.forString(this.adultRequesterTitle.toString()));
        if (this.adultLegalAccessRepresentativeAddress != null)
            adultLegalAccessTypeAdultLegalAccess.setAdultLegalAccessRepresentativeAddress(Address.modelToXml(this.adultLegalAccessRepresentativeAddress));
        lessThan20RequesterTypeLessThan20Requester.setLessThan20RequesterHomePhone(this.lessThan20RequesterHomePhone);
        if (this.adultLegalAccessRepresentativeKind != null)
            adultLegalAccessTypeAdultLegalAccess.setAdultLegalAccessRepresentativeKind(fr.cg95.cvq.xml.request.social.HarAdultLegalAccessRepresentativeKindType.Enum.forString(this.adultLegalAccessRepresentativeKind.toString()));
        date = this.lessThan20ReferentBirthDate;
        if (date != null) {
            calendar.setTime(date);
            lessThan20ReferentTypeLessThan20Referent.setLessThan20ReferentBirthDate(calendar);
        }
        if (this.adultLegalAccessPresence != null)
            adultLegalAccessTypeAdultLegalAccess.setAdultLegalAccessPresence(this.adultLegalAccessPresence.booleanValue());
        if (this.dwellingEstablishmentReception != null)
            dwellingTypeDwelling.setDwellingEstablishmentReception(this.dwellingEstablishmentReception.booleanValue());
        lessThan20RequesterTypeLessThan20Requester.setLessThan20RequesterEmail(this.lessThan20RequesterEmail);
        if (this.dwellingSocialReception != null)
            dwellingTypeDwelling.setDwellingSocialReception(this.dwellingSocialReception.booleanValue());
        if (this.hopesAndNeeds != null)
            handicapAllowanceRequest.setHopesAndNeeds(this.hopesAndNeeds.booleanValue());
        if (this.lessThan20FatherActivityReduction != null)
            lessThan20FatherTypeLessThan20Father.setLessThan20FatherActivityReduction(this.lessThan20FatherActivityReduction.booleanValue());
        lessThan20FatherTypeLessThan20Father.setLessThan20FatherLastName(this.lessThan20FatherLastName);
        lessThan20MotherTypeLessThan20Mother.setLessThan20MotherLastName(this.lessThan20MotherLastName);
        lessThan20MotherTypeLessThan20Mother.setLessThan20MotherHomePhone(this.lessThan20MotherHomePhone);
        dwellingTypeDwelling.setDwellingPrecision(this.dwellingPrecision);
        if (this.lessThan20ParentalAuthorityHolder != null)
            lessThan20ParentalAuthorityTypeLessThan20ParentalAuthority.setLessThan20ParentalAuthorityHolder(fr.cg95.cvq.xml.request.social.HarLessThan20ParentalAuthorityHolderType.Enum.forString(this.lessThan20ParentalAuthorityHolder.toString()));
        lessThan20LegalRepresentativeTypeLessThan20LegalRepresentative.setLessThan20LegalRepresentativeMobilePhone(this.lessThan20LegalRepresentativeMobilePhone);
        if (this.socialSecurityMemberShipKind != null)
            socialSecurityTypeSocialSecurity.setSocialSecurityMemberShipKind(fr.cg95.cvq.xml.request.social.HarSocialSecurityMemberShipKindType.Enum.forString(this.socialSecurityMemberShipKind.toString()));
        if (this.lessThan20ReferentTitle != null)
            lessThan20ReferentTypeLessThan20Referent.setLessThan20ReferentTitle(fr.cg95.cvq.xml.common.TitleType.Enum.forString(this.lessThan20ReferentTitle.toString()));
        handicapAllowanceRequest.setNeeds(this.needs);
        lessThan20ReferentTypeLessThan20Referent.setLessThan20ReferentEmail(this.lessThan20ReferentEmail);
        lessThan20MotherTypeLessThan20Mother.setLessThan20MotherJob(this.lessThan20MotherJob);
        adultLegalAccessTypeAdultLegalAccess.setAdultLegalAccessRepresentativeFirstName(this.adultLegalAccessRepresentativeFirstName);
        lessThan20LegalRepresentativeTypeLessThan20LegalRepresentative.setLessThan20LegalRepresentativeLastName(this.lessThan20LegalRepresentativeLastName);
        handicapAllowanceRequest.setHelperName(this.helperName);
        if (this.dwellingKind != null)
            dwellingTypeDwelling.setDwellingKind(fr.cg95.cvq.xml.request.social.HarDwellingKindType.Enum.forString(this.dwellingKind.toString()));
        adultRequesterTypeAdultRequester.setAdultRequesterHomePhone(this.adultRequesterHomePhone);
        handicapAllowanceRequest.setHopes(this.hopes);
        return handicapAllowanceRequestDoc;
    }

    @Override
    public RequestType modelToXmlRequest() {
        HandicapAllowanceRequestDocument handicapAllowanceRequestDoc =
            (HandicapAllowanceRequestDocument) modelToXml();
        return handicapAllowanceRequestDoc.getHandicapAllowanceRequest();
    }

    public static HandicapAllowanceRequest xmlToModel(HandicapAllowanceRequestDocument handicapAllowanceRequestDoc) {

        HandicapAllowanceRequestDocument.HandicapAllowanceRequest handicapAllowanceRequestXml = handicapAllowanceRequestDoc.getHandicapAllowanceRequest();
        Calendar calendar = Calendar.getInstance();
        List list = new ArrayList();
        HandicapAllowanceRequest handicapAllowanceRequest = new HandicapAllowanceRequest();
        handicapAllowanceRequest.fillCommonModelInfo(handicapAllowanceRequest,handicapAllowanceRequestXml);
        handicapAllowanceRequest.setAdultRequesterFirstName(handicapAllowanceRequestXml.getAdultRequester().getAdultRequesterFirstName());
        handicapAllowanceRequest.setLessThan20ReferentBirthPlaceCity(handicapAllowanceRequestXml.getLessThan20Referent().getLessThan20ReferentBirthPlaceCity());
        List<fr.cg95.cvq.business.request.social.HarFamilyDependent> familyDependentsList = new ArrayList<fr.cg95.cvq.business.request.social.HarFamilyDependent> ();
        if ( handicapAllowanceRequestXml.sizeOfFamilyDependentsArray() > 0) {
            for (int i = 0; i < handicapAllowanceRequestXml.getFamilyDependentsArray().length; i++) {
                familyDependentsList.add(HarFamilyDependent.xmlToModel(handicapAllowanceRequestXml.getFamilyDependentsArray(i)));
            }
        }
        handicapAllowanceRequest.setFamilyDependents(familyDependentsList);
        handicapAllowanceRequest.setLessThan20FatherMobilePhone(handicapAllowanceRequestXml.getLessThan20Father().getLessThan20FatherMobilePhone());
        handicapAllowanceRequest.setLessThan20ReferentHomePhone(handicapAllowanceRequestXml.getLessThan20Referent().getLessThan20ReferentHomePhone());
        if (handicapAllowanceRequestXml.getLessThan20Referent().getLessThan20ReferentAddress() != null)
            handicapAllowanceRequest.setLessThan20ReferentAddress(Address.xmlToModel(handicapAllowanceRequestXml.getLessThan20Referent().getLessThan20ReferentAddress()));
        handicapAllowanceRequest.setWritingHelp(Boolean.valueOf(handicapAllowanceRequestXml.getWritingHelp()));
        handicapAllowanceRequest.setFamilyHasFamilyDependents(Boolean.valueOf(handicapAllowanceRequestXml.getFamily().getFamilyHasFamilyDependents()));
        handicapAllowanceRequest.setLessThan20ParentalAuthorityDepartment(handicapAllowanceRequestXml.getLessThan20ParentalAuthority().getLessThan20ParentalAuthorityDepartment());
        handicapAllowanceRequest.setLessThan20LegalRepresentativeHomePhone(handicapAllowanceRequestXml.getLessThan20LegalRepresentative().getLessThan20LegalRepresentativeHomePhone());
        handicapAllowanceRequest.setAdultRequesterLastName(handicapAllowanceRequestXml.getAdultRequester().getAdultRequesterLastName());
        handicapAllowanceRequest.setHelperResponsability(handicapAllowanceRequestXml.getHelperResponsability());
        if (handicapAllowanceRequestXml.getPaymentAgency().getPaymentAgencyBeneficiary() != null)
            handicapAllowanceRequest.setPaymentAgencyBeneficiary(fr.cg95.cvq.business.request.social.HarPaymentAgencyBeneficiaryType.forString(handicapAllowanceRequestXml.getPaymentAgency().getPaymentAgencyBeneficiary().toString()));
        else
            handicapAllowanceRequest.setPaymentAgencyBeneficiary(fr.cg95.cvq.business.request.social.HarPaymentAgencyBeneficiaryType.getDefaultHarPaymentAgencyBeneficiaryType());
        handicapAllowanceRequest.setLessThan20FatherJob(handicapAllowanceRequestXml.getLessThan20Father().getLessThan20FatherJob());
        calendar = handicapAllowanceRequestXml.getAdultRequester().getAdultRequesterBirthDate();
        if (calendar != null) {
            handicapAllowanceRequest.setAdultRequesterBirthDate(calendar.getTime());
        }
        if (handicapAllowanceRequestXml.getRequestInformation().getRequestInformationRequesterProfile() != null)
            handicapAllowanceRequest.setRequestInformationRequesterProfile(fr.cg95.cvq.business.request.social.HarRequestInformationProfileType.forString(handicapAllowanceRequestXml.getRequestInformation().getRequestInformationRequesterProfile().toString()));
        else
            handicapAllowanceRequest.setRequestInformationRequesterProfile(fr.cg95.cvq.business.request.social.HarRequestInformationProfileType.getDefaultHarRequestInformationProfileType());
        if (handicapAllowanceRequestXml.getRequestInformation().getRequestInformationKind() != null)
            handicapAllowanceRequest.setRequestInformationKind(fr.cg95.cvq.business.request.social.HarRequestInformationKindType.forString(handicapAllowanceRequestXml.getRequestInformation().getRequestInformationKind().toString()));
        else
            handicapAllowanceRequest.setRequestInformationKind(fr.cg95.cvq.business.request.social.HarRequestInformationKindType.getDefaultHarRequestInformationKindType());
        if (handicapAllowanceRequestXml.getPaymentAgency().getPaymentAgencyAddress() != null)
            handicapAllowanceRequest.setPaymentAgencyAddress(Address.xmlToModel(handicapAllowanceRequestXml.getPaymentAgency().getPaymentAgencyAddress()));
        if (handicapAllowanceRequestXml.getLessThan20Father().getLessThan20FatherAddress() != null)
            handicapAllowanceRequest.setLessThan20FatherAddress(Address.xmlToModel(handicapAllowanceRequestXml.getLessThan20Father().getLessThan20FatherAddress()));
        handicapAllowanceRequest.setAdultRequesterBirthPlaceCity(handicapAllowanceRequestXml.getAdultRequester().getAdultRequesterBirthPlaceCity());
        handicapAllowanceRequest.setComments(handicapAllowanceRequestXml.getComments());
        handicapAllowanceRequest.setAdultRequesterEmail(handicapAllowanceRequestXml.getAdultRequester().getAdultRequesterEmail());
        if (handicapAllowanceRequestXml.getSocialSecurity().getSocialSecurityAgencyAddress() != null)
            handicapAllowanceRequest.setSocialSecurityAgencyAddress(Address.xmlToModel(handicapAllowanceRequestXml.getSocialSecurity().getSocialSecurityAgencyAddress()));
        if (handicapAllowanceRequestXml.getDwelling().getDwellingReceptionAddress() != null)
            handicapAllowanceRequest.setDwellingReceptionAddress(Address.xmlToModel(handicapAllowanceRequestXml.getDwelling().getDwellingReceptionAddress()));
        handicapAllowanceRequest.setAdultRequesterMobilePhone(handicapAllowanceRequestXml.getAdultRequester().getAdultRequesterMobilePhone());
        handicapAllowanceRequest.setLessThan20ReferentMobilePhone(handicapAllowanceRequestXml.getLessThan20Referent().getLessThan20ReferentMobilePhone());
        handicapAllowanceRequest.setAdultLegalAccessRepresentativeLastName(handicapAllowanceRequestXml.getAdultLegalAccess().getAdultLegalAccessRepresentativeLastName());
        if (handicapAllowanceRequestXml.getAdultLegalAccess().getAdultLegalAccessKind() != null)
            handicapAllowanceRequest.setAdultLegalAccessKind(fr.cg95.cvq.business.request.social.HarAdultLegalAccessKindType.forString(handicapAllowanceRequestXml.getAdultLegalAccess().getAdultLegalAccessKind().toString()));
        else
            handicapAllowanceRequest.setAdultLegalAccessKind(fr.cg95.cvq.business.request.social.HarAdultLegalAccessKindType.getDefaultHarAdultLegalAccessKindType());
        handicapAllowanceRequest.setLessThan20ReferentFirstName(handicapAllowanceRequestXml.getLessThan20Referent().getLessThan20ReferentFirstName());
        handicapAllowanceRequest.setLessThan20LegalRepresentativeFirstName(handicapAllowanceRequestXml.getLessThan20LegalRepresentative().getLessThan20LegalRepresentativeFirstName());
        handicapAllowanceRequest.setLessThan20FatherFirstName(handicapAllowanceRequestXml.getLessThan20Father().getLessThan20FatherFirstName());
        handicapAllowanceRequest.setAdultLegalAccessRepresentativeMobilePhone(handicapAllowanceRequestXml.getAdultLegalAccess().getAdultLegalAccessRepresentativeMobilePhone());
        handicapAllowanceRequest.setLessThan20MotherReductionRatio(handicapAllowanceRequestXml.getLessThan20Mother().getLessThan20MotherReductionRatio());
        handicapAllowanceRequest.setLessThan20RequesterMobilePhone(handicapAllowanceRequestXml.getLessThan20Requester().getLessThan20RequesterMobilePhone());
        handicapAllowanceRequest.setLessThan20FatherHomePhone(handicapAllowanceRequestXml.getLessThan20Father().getLessThan20FatherHomePhone());
        if (handicapAllowanceRequestXml.getDwelling().getDwellingReceptionType() != null)
            handicapAllowanceRequest.setDwellingReceptionType(fr.cg95.cvq.business.request.social.HarDwellingReceptionType.forString(handicapAllowanceRequestXml.getDwelling().getDwellingReceptionType().toString()));
        else
            handicapAllowanceRequest.setDwellingReceptionType(fr.cg95.cvq.business.request.social.HarDwellingReceptionType.getDefaultHarDwellingReceptionType());
        handicapAllowanceRequest.setLessThan20FatherReductionRatio(handicapAllowanceRequestXml.getLessThan20Father().getLessThan20FatherReductionRatio());
        if (handicapAllowanceRequestXml.getAdultRequester().getAdultRequesterAddress() != null)
            handicapAllowanceRequest.setAdultRequesterAddress(Address.xmlToModel(handicapAllowanceRequestXml.getAdultRequester().getAdultRequesterAddress()));
        handicapAllowanceRequest.setPaymentAgencyName(handicapAllowanceRequestXml.getPaymentAgency().getPaymentAgencyName());
        handicapAllowanceRequest.setDwellingSocialReceptionNaming(handicapAllowanceRequestXml.getDwelling().getDwellingSocialReceptionNaming());
        if (handicapAllowanceRequestXml.getFamily().getFamilyStatus() != null)
            handicapAllowanceRequest.setFamilyStatus(fr.cg95.cvq.business.users.FamilyStatusType.forString(handicapAllowanceRequestXml.getFamily().getFamilyStatus().toString()));
        else
            handicapAllowanceRequest.setFamilyStatus(fr.cg95.cvq.business.users.FamilyStatusType.getDefaultFamilyStatusType());
        if (handicapAllowanceRequestXml.getLessThan20Mother().getLessThan20MotherAddress() != null)
            handicapAllowanceRequest.setLessThan20MotherAddress(Address.xmlToModel(handicapAllowanceRequestXml.getLessThan20Mother().getLessThan20MotherAddress()));
        if (handicapAllowanceRequestXml.getLessThan20Requester().getLessThan20Requester() != null)
            handicapAllowanceRequest.setLessThan20Requester(Individual.xmlToModel(handicapAllowanceRequestXml.getLessThan20Requester().getLessThan20Requester()));
        handicapAllowanceRequest.setLessThan20ParentalAuthorityName(handicapAllowanceRequestXml.getLessThan20ParentalAuthority().getLessThan20ParentalAuthorityName());
        handicapAllowanceRequest.setAdultLegalAccessRepresentativePrecision(handicapAllowanceRequestXml.getAdultLegalAccess().getAdultLegalAccessRepresentativePrecision());
        if (handicapAllowanceRequestXml.getLessThan20LegalRepresentative().getLessThan20LegalRepresentativeAddress() != null)
            handicapAllowanceRequest.setLessThan20LegalRepresentativeAddress(Address.xmlToModel(handicapAllowanceRequestXml.getLessThan20LegalRepresentative().getLessThan20LegalRepresentativeAddress()));
        handicapAllowanceRequest.setSocialSecurityAgencyName(handicapAllowanceRequestXml.getSocialSecurity().getSocialSecurityAgencyName());
        if (handicapAllowanceRequestXml.getDwelling().getDwellingReceptionNaming() != null)
            handicapAllowanceRequest.setDwellingReceptionNaming(fr.cg95.cvq.business.request.social.HarDwellingReceptionType.forString(handicapAllowanceRequestXml.getDwelling().getDwellingReceptionNaming().toString()));
        else
            handicapAllowanceRequest.setDwellingReceptionNaming(fr.cg95.cvq.business.request.social.HarDwellingReceptionType.getDefaultHarDwellingReceptionType());
        handicapAllowanceRequest.setLessThan20MotherFirstName(handicapAllowanceRequestXml.getLessThan20Mother().getLessThan20MotherFirstName());
        handicapAllowanceRequest.setSocialSecurityNumber(handicapAllowanceRequestXml.getSocialSecurity().getSocialSecurityNumber());
        handicapAllowanceRequest.setLessThan20MotherMobilePhone(handicapAllowanceRequestXml.getLessThan20Mother().getLessThan20MotherMobilePhone());
        handicapAllowanceRequest.setLessThan20MotherActivityReduction(Boolean.valueOf(handicapAllowanceRequestXml.getLessThan20Mother().getLessThan20MotherActivityReduction()));
        handicapAllowanceRequest.setLessThan20ReferentLastName(handicapAllowanceRequestXml.getLessThan20Referent().getLessThan20ReferentLastName());
        handicapAllowanceRequest.setAdultLegalAccessRepresentativeEmail(handicapAllowanceRequestXml.getAdultLegalAccess().getAdultLegalAccessRepresentativeEmail());
        if (handicapAllowanceRequestXml.getLessThan20Referent().getLessThan20ReferentBirthPlaceCountry() != null)
            handicapAllowanceRequest.setLessThan20ReferentBirthPlaceCountry(fr.cg95.cvq.business.users.CountryType.forString(handicapAllowanceRequestXml.getLessThan20Referent().getLessThan20ReferentBirthPlaceCountry().toString()));
        else
            handicapAllowanceRequest.setLessThan20ReferentBirthPlaceCountry(fr.cg95.cvq.business.users.CountryType.getDefaultCountryType());
        handicapAllowanceRequest.setPaymentAgencyBeneficiaryNumber(handicapAllowanceRequestXml.getPaymentAgency().getPaymentAgencyBeneficiaryNumber());
        handicapAllowanceRequest.setLessThan20LegalRepresentative(Boolean.valueOf(handicapAllowanceRequestXml.getLessThan20LegalRepresentative().getLessThan20LegalRepresentative()));
        handicapAllowanceRequest.setAdultLegalAccessRepresentativeHomePhone(handicapAllowanceRequestXml.getAdultLegalAccess().getAdultLegalAccessRepresentativeHomePhone());
        if (handicapAllowanceRequestXml.getAdultRequester().getAdultRequesterBirthPlaceCountry() != null)
            handicapAllowanceRequest.setAdultRequesterBirthPlaceCountry(fr.cg95.cvq.business.users.CountryType.forString(handicapAllowanceRequestXml.getAdultRequester().getAdultRequesterBirthPlaceCountry().toString()));
        else
            handicapAllowanceRequest.setAdultRequesterBirthPlaceCountry(fr.cg95.cvq.business.users.CountryType.getDefaultCountryType());
        if (handicapAllowanceRequestXml.getDwelling().getDwellingSocialReceptionAddress() != null)
            handicapAllowanceRequest.setDwellingSocialReceptionAddress(Address.xmlToModel(handicapAllowanceRequestXml.getDwelling().getDwellingSocialReceptionAddress()));
        calendar = handicapAllowanceRequestXml.getRequestInformation().getRequestInformationExpirationDate();
        if (calendar != null) {
            handicapAllowanceRequest.setRequestInformationExpirationDate(calendar.getTime());
        }
        if (handicapAllowanceRequestXml.getAdultRequester().getAdultRequesterTitle() != null)
            handicapAllowanceRequest.setAdultRequesterTitle(fr.cg95.cvq.business.users.TitleType.forString(handicapAllowanceRequestXml.getAdultRequester().getAdultRequesterTitle().toString()));
        else
            handicapAllowanceRequest.setAdultRequesterTitle(fr.cg95.cvq.business.users.TitleType.getDefaultTitleType());
        if (handicapAllowanceRequestXml.getAdultLegalAccess().getAdultLegalAccessRepresentativeAddress() != null)
            handicapAllowanceRequest.setAdultLegalAccessRepresentativeAddress(Address.xmlToModel(handicapAllowanceRequestXml.getAdultLegalAccess().getAdultLegalAccessRepresentativeAddress()));
        handicapAllowanceRequest.setLessThan20RequesterHomePhone(handicapAllowanceRequestXml.getLessThan20Requester().getLessThan20RequesterHomePhone());
        if (handicapAllowanceRequestXml.getAdultLegalAccess().getAdultLegalAccessRepresentativeKind() != null)
            handicapAllowanceRequest.setAdultLegalAccessRepresentativeKind(fr.cg95.cvq.business.request.social.HarAdultLegalAccessRepresentativeKindType.forString(handicapAllowanceRequestXml.getAdultLegalAccess().getAdultLegalAccessRepresentativeKind().toString()));
        else
            handicapAllowanceRequest.setAdultLegalAccessRepresentativeKind(fr.cg95.cvq.business.request.social.HarAdultLegalAccessRepresentativeKindType.getDefaultHarAdultLegalAccessRepresentativeKindType());
        calendar = handicapAllowanceRequestXml.getLessThan20Referent().getLessThan20ReferentBirthDate();
        if (calendar != null) {
            handicapAllowanceRequest.setLessThan20ReferentBirthDate(calendar.getTime());
        }
        handicapAllowanceRequest.setAdultLegalAccessPresence(Boolean.valueOf(handicapAllowanceRequestXml.getAdultLegalAccess().getAdultLegalAccessPresence()));
        handicapAllowanceRequest.setDwellingEstablishmentReception(Boolean.valueOf(handicapAllowanceRequestXml.getDwelling().getDwellingEstablishmentReception()));
        handicapAllowanceRequest.setLessThan20RequesterEmail(handicapAllowanceRequestXml.getLessThan20Requester().getLessThan20RequesterEmail());
        handicapAllowanceRequest.setDwellingSocialReception(Boolean.valueOf(handicapAllowanceRequestXml.getDwelling().getDwellingSocialReception()));
        handicapAllowanceRequest.setHopesAndNeeds(Boolean.valueOf(handicapAllowanceRequestXml.getHopesAndNeeds()));
        handicapAllowanceRequest.setLessThan20FatherActivityReduction(Boolean.valueOf(handicapAllowanceRequestXml.getLessThan20Father().getLessThan20FatherActivityReduction()));
        handicapAllowanceRequest.setLessThan20FatherLastName(handicapAllowanceRequestXml.getLessThan20Father().getLessThan20FatherLastName());
        handicapAllowanceRequest.setLessThan20MotherLastName(handicapAllowanceRequestXml.getLessThan20Mother().getLessThan20MotherLastName());
        handicapAllowanceRequest.setLessThan20MotherHomePhone(handicapAllowanceRequestXml.getLessThan20Mother().getLessThan20MotherHomePhone());
        handicapAllowanceRequest.setDwellingPrecision(handicapAllowanceRequestXml.getDwelling().getDwellingPrecision());
        if (handicapAllowanceRequestXml.getLessThan20ParentalAuthority().getLessThan20ParentalAuthorityHolder() != null)
            handicapAllowanceRequest.setLessThan20ParentalAuthorityHolder(fr.cg95.cvq.business.request.social.HarLessThan20ParentalAuthorityHolderType.forString(handicapAllowanceRequestXml.getLessThan20ParentalAuthority().getLessThan20ParentalAuthorityHolder().toString()));
        else
            handicapAllowanceRequest.setLessThan20ParentalAuthorityHolder(fr.cg95.cvq.business.request.social.HarLessThan20ParentalAuthorityHolderType.getDefaultHarLessThan20ParentalAuthorityHolderType());
        handicapAllowanceRequest.setLessThan20LegalRepresentativeMobilePhone(handicapAllowanceRequestXml.getLessThan20LegalRepresentative().getLessThan20LegalRepresentativeMobilePhone());
        if (handicapAllowanceRequestXml.getSocialSecurity().getSocialSecurityMemberShipKind() != null)
            handicapAllowanceRequest.setSocialSecurityMemberShipKind(fr.cg95.cvq.business.request.social.HarSocialSecurityMemberShipKindType.forString(handicapAllowanceRequestXml.getSocialSecurity().getSocialSecurityMemberShipKind().toString()));
        else
            handicapAllowanceRequest.setSocialSecurityMemberShipKind(fr.cg95.cvq.business.request.social.HarSocialSecurityMemberShipKindType.getDefaultHarSocialSecurityMemberShipKindType());
        if (handicapAllowanceRequestXml.getLessThan20Referent().getLessThan20ReferentTitle() != null)
            handicapAllowanceRequest.setLessThan20ReferentTitle(fr.cg95.cvq.business.users.TitleType.forString(handicapAllowanceRequestXml.getLessThan20Referent().getLessThan20ReferentTitle().toString()));
        else
            handicapAllowanceRequest.setLessThan20ReferentTitle(fr.cg95.cvq.business.users.TitleType.getDefaultTitleType());
        handicapAllowanceRequest.setNeeds(handicapAllowanceRequestXml.getNeeds());
        handicapAllowanceRequest.setLessThan20ReferentEmail(handicapAllowanceRequestXml.getLessThan20Referent().getLessThan20ReferentEmail());
        handicapAllowanceRequest.setLessThan20MotherJob(handicapAllowanceRequestXml.getLessThan20Mother().getLessThan20MotherJob());
        handicapAllowanceRequest.setAdultLegalAccessRepresentativeFirstName(handicapAllowanceRequestXml.getAdultLegalAccess().getAdultLegalAccessRepresentativeFirstName());
        handicapAllowanceRequest.setLessThan20LegalRepresentativeLastName(handicapAllowanceRequestXml.getLessThan20LegalRepresentative().getLessThan20LegalRepresentativeLastName());
        handicapAllowanceRequest.setHelperName(handicapAllowanceRequestXml.getHelperName());
        if (handicapAllowanceRequestXml.getDwelling().getDwellingKind() != null)
            handicapAllowanceRequest.setDwellingKind(fr.cg95.cvq.business.request.social.HarDwellingKindType.forString(handicapAllowanceRequestXml.getDwelling().getDwellingKind().toString()));
        else
            handicapAllowanceRequest.setDwellingKind(fr.cg95.cvq.business.request.social.HarDwellingKindType.getDefaultHarDwellingKindType());
        handicapAllowanceRequest.setAdultRequesterHomePhone(handicapAllowanceRequestXml.getAdultRequester().getAdultRequesterHomePhone());
        handicapAllowanceRequest.setHopes(handicapAllowanceRequestXml.getHopes());
        return handicapAllowanceRequest;
    }

    private String adultRequesterFirstName;

    public final void setAdultRequesterFirstName(final String adultRequesterFirstName) {
        this.adultRequesterFirstName = adultRequesterFirstName;
    }


    /**
     * @hibernate.property
     *  column="adult_requester_first_name"
     *  length="38"
     */
    public final String getAdultRequesterFirstName() {
        return this.adultRequesterFirstName;
    }

    private String lessThan20ReferentBirthPlaceCity;

    public final void setLessThan20ReferentBirthPlaceCity(final String lessThan20ReferentBirthPlaceCity) {
        this.lessThan20ReferentBirthPlaceCity = lessThan20ReferentBirthPlaceCity;
    }


    /**
     * @hibernate.property
     *  column="less_than20_referent_birth_place_city"
     *  length="32"
     */
    public final String getLessThan20ReferentBirthPlaceCity() {
        return this.lessThan20ReferentBirthPlaceCity;
    }

    private List<fr.cg95.cvq.business.request.social.HarFamilyDependent> familyDependents;

    public final void setFamilyDependents(final List<fr.cg95.cvq.business.request.social.HarFamilyDependent> familyDependents) {
        this.familyDependents = familyDependents;
    }


    /**
     * @hibernate.list
     *  inverse="false"
     *  lazy="false"
     *  cascade="all"
     * @hibernate.key
     *  column="handicap_allowance_request_id"
     * @hibernate.list-index
     *  column="family_dependents_index"
     * @hibernate.one-to-many
     *  class="fr.cg95.cvq.business.request.social.HarFamilyDependent"
     */
    public final List<fr.cg95.cvq.business.request.social.HarFamilyDependent> getFamilyDependents() {
        return this.familyDependents;
    }

    private String lessThan20FatherMobilePhone;

    public final void setLessThan20FatherMobilePhone(final String lessThan20FatherMobilePhone) {
        this.lessThan20FatherMobilePhone = lessThan20FatherMobilePhone;
    }


    /**
     * @hibernate.property
     *  column="less_than20_father_mobile_phone"
     *  length="10"
     */
    public final String getLessThan20FatherMobilePhone() {
        return this.lessThan20FatherMobilePhone;
    }

    private String lessThan20ReferentHomePhone;

    public final void setLessThan20ReferentHomePhone(final String lessThan20ReferentHomePhone) {
        this.lessThan20ReferentHomePhone = lessThan20ReferentHomePhone;
    }


    /**
     * @hibernate.property
     *  column="less_than20_referent_home_phone"
     *  length="10"
     */
    public final String getLessThan20ReferentHomePhone() {
        return this.lessThan20ReferentHomePhone;
    }

    private fr.cg95.cvq.business.users.Address lessThan20ReferentAddress;

    public final void setLessThan20ReferentAddress(final fr.cg95.cvq.business.users.Address lessThan20ReferentAddress) {
        this.lessThan20ReferentAddress = lessThan20ReferentAddress;
    }


    /**
     * @hibernate.many-to-one
     *  column="less_than20_referent_address_id"
     *  class="fr.cg95.cvq.business.users.Address"
     */
    public final fr.cg95.cvq.business.users.Address getLessThan20ReferentAddress() {
        return this.lessThan20ReferentAddress;
    }

    private Boolean writingHelp;

    public final void setWritingHelp(final Boolean writingHelp) {
        this.writingHelp = writingHelp;
    }


    /**
     * @hibernate.property
     *  column="writing_help"
     */
    public final Boolean getWritingHelp() {
        return this.writingHelp;
    }

    private Boolean familyHasFamilyDependents;

    public final void setFamilyHasFamilyDependents(final Boolean familyHasFamilyDependents) {
        this.familyHasFamilyDependents = familyHasFamilyDependents;
    }


    /**
     * @hibernate.property
     *  column="family_has_family_dependents"
     */
    public final Boolean getFamilyHasFamilyDependents() {
        return this.familyHasFamilyDependents;
    }

    private String lessThan20ParentalAuthorityDepartment;

    public final void setLessThan20ParentalAuthorityDepartment(final String lessThan20ParentalAuthorityDepartment) {
        this.lessThan20ParentalAuthorityDepartment = lessThan20ParentalAuthorityDepartment;
    }


    /**
     * @hibernate.property
     *  column="less_than20_parental_authority_department"
     */
    public final String getLessThan20ParentalAuthorityDepartment() {
        return this.lessThan20ParentalAuthorityDepartment;
    }

    private String lessThan20LegalRepresentativeHomePhone;

    public final void setLessThan20LegalRepresentativeHomePhone(final String lessThan20LegalRepresentativeHomePhone) {
        this.lessThan20LegalRepresentativeHomePhone = lessThan20LegalRepresentativeHomePhone;
    }


    /**
     * @hibernate.property
     *  column="less_than20_legal_representative_home_phone"
     *  length="10"
     */
    public final String getLessThan20LegalRepresentativeHomePhone() {
        return this.lessThan20LegalRepresentativeHomePhone;
    }

    private String adultRequesterLastName;

    public final void setAdultRequesterLastName(final String adultRequesterLastName) {
        this.adultRequesterLastName = adultRequesterLastName;
    }


    /**
     * @hibernate.property
     *  column="adult_requester_last_name"
     *  length="38"
     */
    public final String getAdultRequesterLastName() {
        return this.adultRequesterLastName;
    }

    private String helperResponsability;

    public final void setHelperResponsability(final String helperResponsability) {
        this.helperResponsability = helperResponsability;
    }


    /**
     * @hibernate.property
     *  column="helper_responsability"
     */
    public final String getHelperResponsability() {
        return this.helperResponsability;
    }

    private fr.cg95.cvq.business.request.social.HarPaymentAgencyBeneficiaryType paymentAgencyBeneficiary;

    public final void setPaymentAgencyBeneficiary(final fr.cg95.cvq.business.request.social.HarPaymentAgencyBeneficiaryType paymentAgencyBeneficiary) {
        this.paymentAgencyBeneficiary = paymentAgencyBeneficiary;
    }


    /**
     * @hibernate.property
     *  column="payment_agency_beneficiary"
     */
    public final fr.cg95.cvq.business.request.social.HarPaymentAgencyBeneficiaryType getPaymentAgencyBeneficiary() {
        return this.paymentAgencyBeneficiary;
    }

    private String lessThan20FatherJob;

    public final void setLessThan20FatherJob(final String lessThan20FatherJob) {
        this.lessThan20FatherJob = lessThan20FatherJob;
    }


    /**
     * @hibernate.property
     *  column="less_than20_father_job"
     */
    public final String getLessThan20FatherJob() {
        return this.lessThan20FatherJob;
    }

    private java.util.Date adultRequesterBirthDate;

    public final void setAdultRequesterBirthDate(final java.util.Date adultRequesterBirthDate) {
        this.adultRequesterBirthDate = adultRequesterBirthDate;
    }


    /**
     * @hibernate.property
     *  column="adult_requester_birth_date"
     */
    public final java.util.Date getAdultRequesterBirthDate() {
        return this.adultRequesterBirthDate;
    }

    private fr.cg95.cvq.business.request.social.HarRequestInformationProfileType requestInformationRequesterProfile;

    public final void setRequestInformationRequesterProfile(final fr.cg95.cvq.business.request.social.HarRequestInformationProfileType requestInformationRequesterProfile) {
        this.requestInformationRequesterProfile = requestInformationRequesterProfile;
    }


    /**
     * @hibernate.property
     *  column="request_information_requester_profile"
     */
    public final fr.cg95.cvq.business.request.social.HarRequestInformationProfileType getRequestInformationRequesterProfile() {
        return this.requestInformationRequesterProfile;
    }

    private fr.cg95.cvq.business.request.social.HarRequestInformationKindType requestInformationKind;

    public final void setRequestInformationKind(final fr.cg95.cvq.business.request.social.HarRequestInformationKindType requestInformationKind) {
        this.requestInformationKind = requestInformationKind;
    }


    /**
     * @hibernate.property
     *  column="request_information_kind"
     */
    public final fr.cg95.cvq.business.request.social.HarRequestInformationKindType getRequestInformationKind() {
        return this.requestInformationKind;
    }

    private fr.cg95.cvq.business.users.Address paymentAgencyAddress;

    public final void setPaymentAgencyAddress(final fr.cg95.cvq.business.users.Address paymentAgencyAddress) {
        this.paymentAgencyAddress = paymentAgencyAddress;
    }


    /**
     * @hibernate.many-to-one
     *  column="payment_agency_address_id"
     *  class="fr.cg95.cvq.business.users.Address"
     */
    public final fr.cg95.cvq.business.users.Address getPaymentAgencyAddress() {
        return this.paymentAgencyAddress;
    }

    private fr.cg95.cvq.business.users.Address lessThan20FatherAddress;

    public final void setLessThan20FatherAddress(final fr.cg95.cvq.business.users.Address lessThan20FatherAddress) {
        this.lessThan20FatherAddress = lessThan20FatherAddress;
    }


    /**
     * @hibernate.many-to-one
     *  column="less_than20_father_address_id"
     *  class="fr.cg95.cvq.business.users.Address"
     */
    public final fr.cg95.cvq.business.users.Address getLessThan20FatherAddress() {
        return this.lessThan20FatherAddress;
    }

    private String adultRequesterBirthPlaceCity;

    public final void setAdultRequesterBirthPlaceCity(final String adultRequesterBirthPlaceCity) {
        this.adultRequesterBirthPlaceCity = adultRequesterBirthPlaceCity;
    }


    /**
     * @hibernate.property
     *  column="adult_requester_birth_place_city"
     *  length="32"
     */
    public final String getAdultRequesterBirthPlaceCity() {
        return this.adultRequesterBirthPlaceCity;
    }

    private String comments;

    public final void setComments(final String comments) {
        this.comments = comments;
    }


    /**
     * @hibernate.property
     *  column="comments"
     */
    public final String getComments() {
        return this.comments;
    }

    private String adultRequesterEmail;

    public final void setAdultRequesterEmail(final String adultRequesterEmail) {
        this.adultRequesterEmail = adultRequesterEmail;
    }


    /**
     * @hibernate.property
     *  column="adult_requester_email"
     */
    public final String getAdultRequesterEmail() {
        return this.adultRequesterEmail;
    }

    private fr.cg95.cvq.business.users.Address socialSecurityAgencyAddress;

    public final void setSocialSecurityAgencyAddress(final fr.cg95.cvq.business.users.Address socialSecurityAgencyAddress) {
        this.socialSecurityAgencyAddress = socialSecurityAgencyAddress;
    }


    /**
     * @hibernate.many-to-one
     *  column="social_security_agency_address_id"
     *  class="fr.cg95.cvq.business.users.Address"
     */
    public final fr.cg95.cvq.business.users.Address getSocialSecurityAgencyAddress() {
        return this.socialSecurityAgencyAddress;
    }

    private fr.cg95.cvq.business.users.Address dwellingReceptionAddress;

    public final void setDwellingReceptionAddress(final fr.cg95.cvq.business.users.Address dwellingReceptionAddress) {
        this.dwellingReceptionAddress = dwellingReceptionAddress;
    }


    /**
     * @hibernate.many-to-one
     *  column="dwelling_reception_address_id"
     *  class="fr.cg95.cvq.business.users.Address"
     */
    public final fr.cg95.cvq.business.users.Address getDwellingReceptionAddress() {
        return this.dwellingReceptionAddress;
    }

    private String adultRequesterMobilePhone;

    public final void setAdultRequesterMobilePhone(final String adultRequesterMobilePhone) {
        this.adultRequesterMobilePhone = adultRequesterMobilePhone;
    }


    /**
     * @hibernate.property
     *  column="adult_requester_mobile_phone"
     *  length="10"
     */
    public final String getAdultRequesterMobilePhone() {
        return this.adultRequesterMobilePhone;
    }

    private String lessThan20ReferentMobilePhone;

    public final void setLessThan20ReferentMobilePhone(final String lessThan20ReferentMobilePhone) {
        this.lessThan20ReferentMobilePhone = lessThan20ReferentMobilePhone;
    }


    /**
     * @hibernate.property
     *  column="less_than20_referent_mobile_phone"
     *  length="10"
     */
    public final String getLessThan20ReferentMobilePhone() {
        return this.lessThan20ReferentMobilePhone;
    }

    private String adultLegalAccessRepresentativeLastName;

    public final void setAdultLegalAccessRepresentativeLastName(final String adultLegalAccessRepresentativeLastName) {
        this.adultLegalAccessRepresentativeLastName = adultLegalAccessRepresentativeLastName;
    }


    /**
     * @hibernate.property
     *  column="adult_legal_access_representative_last_name"
     *  length="38"
     */
    public final String getAdultLegalAccessRepresentativeLastName() {
        return this.adultLegalAccessRepresentativeLastName;
    }

    private fr.cg95.cvq.business.request.social.HarAdultLegalAccessKindType adultLegalAccessKind;

    public final void setAdultLegalAccessKind(final fr.cg95.cvq.business.request.social.HarAdultLegalAccessKindType adultLegalAccessKind) {
        this.adultLegalAccessKind = adultLegalAccessKind;
    }


    /**
     * @hibernate.property
     *  column="adult_legal_access_kind"
     */
    public final fr.cg95.cvq.business.request.social.HarAdultLegalAccessKindType getAdultLegalAccessKind() {
        return this.adultLegalAccessKind;
    }

    private String lessThan20ReferentFirstName;

    public final void setLessThan20ReferentFirstName(final String lessThan20ReferentFirstName) {
        this.lessThan20ReferentFirstName = lessThan20ReferentFirstName;
    }


    /**
     * @hibernate.property
     *  column="less_than20_referent_first_name"
     *  length="38"
     */
    public final String getLessThan20ReferentFirstName() {
        return this.lessThan20ReferentFirstName;
    }

    private String lessThan20LegalRepresentativeFirstName;

    public final void setLessThan20LegalRepresentativeFirstName(final String lessThan20LegalRepresentativeFirstName) {
        this.lessThan20LegalRepresentativeFirstName = lessThan20LegalRepresentativeFirstName;
    }


    /**
     * @hibernate.property
     *  column="less_than20_legal_representative_first_name"
     *  length="38"
     */
    public final String getLessThan20LegalRepresentativeFirstName() {
        return this.lessThan20LegalRepresentativeFirstName;
    }

    private String lessThan20FatherFirstName;

    public final void setLessThan20FatherFirstName(final String lessThan20FatherFirstName) {
        this.lessThan20FatherFirstName = lessThan20FatherFirstName;
    }


    /**
     * @hibernate.property
     *  column="less_than20_father_first_name"
     *  length="38"
     */
    public final String getLessThan20FatherFirstName() {
        return this.lessThan20FatherFirstName;
    }

    private String adultLegalAccessRepresentativeMobilePhone;

    public final void setAdultLegalAccessRepresentativeMobilePhone(final String adultLegalAccessRepresentativeMobilePhone) {
        this.adultLegalAccessRepresentativeMobilePhone = adultLegalAccessRepresentativeMobilePhone;
    }


    /**
     * @hibernate.property
     *  column="adult_legal_access_representative_mobile_phone"
     *  length="10"
     */
    public final String getAdultLegalAccessRepresentativeMobilePhone() {
        return this.adultLegalAccessRepresentativeMobilePhone;
    }

    private String lessThan20MotherReductionRatio;

    public final void setLessThan20MotherReductionRatio(final String lessThan20MotherReductionRatio) {
        this.lessThan20MotherReductionRatio = lessThan20MotherReductionRatio;
    }


    /**
     * @hibernate.property
     *  column="less_than20_mother_reduction_ratio"
     */
    public final String getLessThan20MotherReductionRatio() {
        return this.lessThan20MotherReductionRatio;
    }

    private String lessThan20RequesterMobilePhone;

    public final void setLessThan20RequesterMobilePhone(final String lessThan20RequesterMobilePhone) {
        this.lessThan20RequesterMobilePhone = lessThan20RequesterMobilePhone;
    }


    /**
     * @hibernate.property
     *  column="less_than20_requester_mobile_phone"
     *  length="10"
     */
    public final String getLessThan20RequesterMobilePhone() {
        return this.lessThan20RequesterMobilePhone;
    }

    private String lessThan20FatherHomePhone;

    public final void setLessThan20FatherHomePhone(final String lessThan20FatherHomePhone) {
        this.lessThan20FatherHomePhone = lessThan20FatherHomePhone;
    }


    /**
     * @hibernate.property
     *  column="less_than20_father_home_phone"
     *  length="10"
     */
    public final String getLessThan20FatherHomePhone() {
        return this.lessThan20FatherHomePhone;
    }

    private fr.cg95.cvq.business.request.social.HarDwellingReceptionType dwellingReceptionType;

    public final void setDwellingReceptionType(final fr.cg95.cvq.business.request.social.HarDwellingReceptionType dwellingReceptionType) {
        this.dwellingReceptionType = dwellingReceptionType;
    }


    /**
     * @hibernate.property
     *  column="dwelling_reception_type"
     */
    public final fr.cg95.cvq.business.request.social.HarDwellingReceptionType getDwellingReceptionType() {
        return this.dwellingReceptionType;
    }

    private String lessThan20FatherReductionRatio;

    public final void setLessThan20FatherReductionRatio(final String lessThan20FatherReductionRatio) {
        this.lessThan20FatherReductionRatio = lessThan20FatherReductionRatio;
    }


    /**
     * @hibernate.property
     *  column="less_than20_father_reduction_ratio"
     */
    public final String getLessThan20FatherReductionRatio() {
        return this.lessThan20FatherReductionRatio;
    }

    private fr.cg95.cvq.business.users.Address adultRequesterAddress;

    public final void setAdultRequesterAddress(final fr.cg95.cvq.business.users.Address adultRequesterAddress) {
        this.adultRequesterAddress = adultRequesterAddress;
    }


    /**
     * @hibernate.many-to-one
     *  column="adult_requester_address_id"
     *  class="fr.cg95.cvq.business.users.Address"
     */
    public final fr.cg95.cvq.business.users.Address getAdultRequesterAddress() {
        return this.adultRequesterAddress;
    }

    private String paymentAgencyName;

    public final void setPaymentAgencyName(final String paymentAgencyName) {
        this.paymentAgencyName = paymentAgencyName;
    }


    /**
     * @hibernate.property
     *  column="payment_agency_name"
     */
    public final String getPaymentAgencyName() {
        return this.paymentAgencyName;
    }

    private String dwellingSocialReceptionNaming;

    public final void setDwellingSocialReceptionNaming(final String dwellingSocialReceptionNaming) {
        this.dwellingSocialReceptionNaming = dwellingSocialReceptionNaming;
    }


    /**
     * @hibernate.property
     *  column="dwelling_social_reception_naming"
     */
    public final String getDwellingSocialReceptionNaming() {
        return this.dwellingSocialReceptionNaming;
    }

    private fr.cg95.cvq.business.users.FamilyStatusType familyStatus;

    public final void setFamilyStatus(final fr.cg95.cvq.business.users.FamilyStatusType familyStatus) {
        this.familyStatus = familyStatus;
    }


    /**
     * @hibernate.property
     *  column="family_status"
     */
    public final fr.cg95.cvq.business.users.FamilyStatusType getFamilyStatus() {
        return this.familyStatus;
    }

    private fr.cg95.cvq.business.users.Address lessThan20MotherAddress;

    public final void setLessThan20MotherAddress(final fr.cg95.cvq.business.users.Address lessThan20MotherAddress) {
        this.lessThan20MotherAddress = lessThan20MotherAddress;
    }


    /**
     * @hibernate.many-to-one
     *  column="less_than20_mother_address_id"
     *  class="fr.cg95.cvq.business.users.Address"
     */
    public final fr.cg95.cvq.business.users.Address getLessThan20MotherAddress() {
        return this.lessThan20MotherAddress;
    }

    private fr.cg95.cvq.business.users.Individual lessThan20Requester;

    public final void setLessThan20Requester(final fr.cg95.cvq.business.users.Individual lessThan20Requester) {
        this.lessThan20Requester = lessThan20Requester;
    }


    /**
     * @hibernate.many-to-one
     *  column="less_than20_requester_id"
     *  class="fr.cg95.cvq.business.users.Individual"
     */
    public final fr.cg95.cvq.business.users.Individual getLessThan20Requester() {
        return this.lessThan20Requester;
    }

    private String lessThan20ParentalAuthorityName;

    public final void setLessThan20ParentalAuthorityName(final String lessThan20ParentalAuthorityName) {
        this.lessThan20ParentalAuthorityName = lessThan20ParentalAuthorityName;
    }


    /**
     * @hibernate.property
     *  column="less_than20_parental_authority_name"
     *  length="38"
     */
    public final String getLessThan20ParentalAuthorityName() {
        return this.lessThan20ParentalAuthorityName;
    }

    private String adultLegalAccessRepresentativePrecision;

    public final void setAdultLegalAccessRepresentativePrecision(final String adultLegalAccessRepresentativePrecision) {
        this.adultLegalAccessRepresentativePrecision = adultLegalAccessRepresentativePrecision;
    }


    /**
     * @hibernate.property
     *  column="adult_legal_access_representative_precision"
     *  length="50"
     */
    public final String getAdultLegalAccessRepresentativePrecision() {
        return this.adultLegalAccessRepresentativePrecision;
    }

    private fr.cg95.cvq.business.users.Address lessThan20LegalRepresentativeAddress;

    public final void setLessThan20LegalRepresentativeAddress(final fr.cg95.cvq.business.users.Address lessThan20LegalRepresentativeAddress) {
        this.lessThan20LegalRepresentativeAddress = lessThan20LegalRepresentativeAddress;
    }


    /**
     * @hibernate.many-to-one
     *  column="less_than20_legal_representative_address_id"
     *  class="fr.cg95.cvq.business.users.Address"
     */
    public final fr.cg95.cvq.business.users.Address getLessThan20LegalRepresentativeAddress() {
        return this.lessThan20LegalRepresentativeAddress;
    }

    private String socialSecurityAgencyName;

    public final void setSocialSecurityAgencyName(final String socialSecurityAgencyName) {
        this.socialSecurityAgencyName = socialSecurityAgencyName;
    }


    /**
     * @hibernate.property
     *  column="social_security_agency_name"
     */
    public final String getSocialSecurityAgencyName() {
        return this.socialSecurityAgencyName;
    }

    private fr.cg95.cvq.business.request.social.HarDwellingReceptionType dwellingReceptionNaming;

    public final void setDwellingReceptionNaming(final fr.cg95.cvq.business.request.social.HarDwellingReceptionType dwellingReceptionNaming) {
        this.dwellingReceptionNaming = dwellingReceptionNaming;
    }


    /**
     * @hibernate.property
     *  column="dwelling_reception_naming"
     */
    public final fr.cg95.cvq.business.request.social.HarDwellingReceptionType getDwellingReceptionNaming() {
        return this.dwellingReceptionNaming;
    }

    private String lessThan20MotherFirstName;

    public final void setLessThan20MotherFirstName(final String lessThan20MotherFirstName) {
        this.lessThan20MotherFirstName = lessThan20MotherFirstName;
    }


    /**
     * @hibernate.property
     *  column="less_than20_mother_first_name"
     *  length="38"
     */
    public final String getLessThan20MotherFirstName() {
        return this.lessThan20MotherFirstName;
    }

    private String socialSecurityNumber;

    public final void setSocialSecurityNumber(final String socialSecurityNumber) {
        this.socialSecurityNumber = socialSecurityNumber;
    }


    /**
     * @hibernate.property
     *  column="social_security_number"
     *  length="13"
     */
    public final String getSocialSecurityNumber() {
        return this.socialSecurityNumber;
    }

    private String lessThan20MotherMobilePhone;

    public final void setLessThan20MotherMobilePhone(final String lessThan20MotherMobilePhone) {
        this.lessThan20MotherMobilePhone = lessThan20MotherMobilePhone;
    }


    /**
     * @hibernate.property
     *  column="less_than20_mother_mobile_phone"
     *  length="10"
     */
    public final String getLessThan20MotherMobilePhone() {
        return this.lessThan20MotherMobilePhone;
    }

    private Boolean lessThan20MotherActivityReduction;

    public final void setLessThan20MotherActivityReduction(final Boolean lessThan20MotherActivityReduction) {
        this.lessThan20MotherActivityReduction = lessThan20MotherActivityReduction;
    }


    /**
     * @hibernate.property
     *  column="less_than20_mother_activity_reduction"
     */
    public final Boolean getLessThan20MotherActivityReduction() {
        return this.lessThan20MotherActivityReduction;
    }

    private String lessThan20ReferentLastName;

    public final void setLessThan20ReferentLastName(final String lessThan20ReferentLastName) {
        this.lessThan20ReferentLastName = lessThan20ReferentLastName;
    }


    /**
     * @hibernate.property
     *  column="less_than20_referent_last_name"
     *  length="38"
     */
    public final String getLessThan20ReferentLastName() {
        return this.lessThan20ReferentLastName;
    }

    private String adultLegalAccessRepresentativeEmail;

    public final void setAdultLegalAccessRepresentativeEmail(final String adultLegalAccessRepresentativeEmail) {
        this.adultLegalAccessRepresentativeEmail = adultLegalAccessRepresentativeEmail;
    }


    /**
     * @hibernate.property
     *  column="adult_legal_access_representative_email"
     */
    public final String getAdultLegalAccessRepresentativeEmail() {
        return this.adultLegalAccessRepresentativeEmail;
    }

    private fr.cg95.cvq.business.users.CountryType lessThan20ReferentBirthPlaceCountry;

    public final void setLessThan20ReferentBirthPlaceCountry(final fr.cg95.cvq.business.users.CountryType lessThan20ReferentBirthPlaceCountry) {
        this.lessThan20ReferentBirthPlaceCountry = lessThan20ReferentBirthPlaceCountry;
    }


    /**
     * @hibernate.property
     *  column="less_than20_referent_birth_place_country"
     */
    public final fr.cg95.cvq.business.users.CountryType getLessThan20ReferentBirthPlaceCountry() {
        return this.lessThan20ReferentBirthPlaceCountry;
    }

    private String paymentAgencyBeneficiaryNumber;

    public final void setPaymentAgencyBeneficiaryNumber(final String paymentAgencyBeneficiaryNumber) {
        this.paymentAgencyBeneficiaryNumber = paymentAgencyBeneficiaryNumber;
    }


    /**
     * @hibernate.property
     *  column="payment_agency_beneficiary_number"
     */
    public final String getPaymentAgencyBeneficiaryNumber() {
        return this.paymentAgencyBeneficiaryNumber;
    }

    private Boolean lessThan20LegalRepresentative;

    public final void setLessThan20LegalRepresentative(final Boolean lessThan20LegalRepresentative) {
        this.lessThan20LegalRepresentative = lessThan20LegalRepresentative;
    }


    /**
     * @hibernate.property
     *  column="less_than20_legal_representative"
     */
    public final Boolean getLessThan20LegalRepresentative() {
        return this.lessThan20LegalRepresentative;
    }

    private String adultLegalAccessRepresentativeHomePhone;

    public final void setAdultLegalAccessRepresentativeHomePhone(final String adultLegalAccessRepresentativeHomePhone) {
        this.adultLegalAccessRepresentativeHomePhone = adultLegalAccessRepresentativeHomePhone;
    }


    /**
     * @hibernate.property
     *  column="adult_legal_access_representative_home_phone"
     *  length="10"
     */
    public final String getAdultLegalAccessRepresentativeHomePhone() {
        return this.adultLegalAccessRepresentativeHomePhone;
    }

    private fr.cg95.cvq.business.users.CountryType adultRequesterBirthPlaceCountry;

    public final void setAdultRequesterBirthPlaceCountry(final fr.cg95.cvq.business.users.CountryType adultRequesterBirthPlaceCountry) {
        this.adultRequesterBirthPlaceCountry = adultRequesterBirthPlaceCountry;
    }


    /**
     * @hibernate.property
     *  column="adult_requester_birth_place_country"
     */
    public final fr.cg95.cvq.business.users.CountryType getAdultRequesterBirthPlaceCountry() {
        return this.adultRequesterBirthPlaceCountry;
    }

    private fr.cg95.cvq.business.users.Address dwellingSocialReceptionAddress;

    public final void setDwellingSocialReceptionAddress(final fr.cg95.cvq.business.users.Address dwellingSocialReceptionAddress) {
        this.dwellingSocialReceptionAddress = dwellingSocialReceptionAddress;
    }


    /**
     * @hibernate.many-to-one
     *  column="dwelling_social_reception_address_id"
     *  class="fr.cg95.cvq.business.users.Address"
     */
    public final fr.cg95.cvq.business.users.Address getDwellingSocialReceptionAddress() {
        return this.dwellingSocialReceptionAddress;
    }

    private java.util.Date requestInformationExpirationDate;

    public final void setRequestInformationExpirationDate(final java.util.Date requestInformationExpirationDate) {
        this.requestInformationExpirationDate = requestInformationExpirationDate;
    }


    /**
     * @hibernate.property
     *  column="request_information_expiration_date"
     */
    public final java.util.Date getRequestInformationExpirationDate() {
        return this.requestInformationExpirationDate;
    }

    private fr.cg95.cvq.business.users.TitleType adultRequesterTitle;

    public final void setAdultRequesterTitle(final fr.cg95.cvq.business.users.TitleType adultRequesterTitle) {
        this.adultRequesterTitle = adultRequesterTitle;
    }


    /**
     * @hibernate.property
     *  column="adult_requester_title"
     */
    public final fr.cg95.cvq.business.users.TitleType getAdultRequesterTitle() {
        return this.adultRequesterTitle;
    }

    private fr.cg95.cvq.business.users.Address adultLegalAccessRepresentativeAddress;

    public final void setAdultLegalAccessRepresentativeAddress(final fr.cg95.cvq.business.users.Address adultLegalAccessRepresentativeAddress) {
        this.adultLegalAccessRepresentativeAddress = adultLegalAccessRepresentativeAddress;
    }


    /**
     * @hibernate.many-to-one
     *  column="adult_legal_access_representative_address_id"
     *  class="fr.cg95.cvq.business.users.Address"
     */
    public final fr.cg95.cvq.business.users.Address getAdultLegalAccessRepresentativeAddress() {
        return this.adultLegalAccessRepresentativeAddress;
    }

    private String lessThan20RequesterHomePhone;

    public final void setLessThan20RequesterHomePhone(final String lessThan20RequesterHomePhone) {
        this.lessThan20RequesterHomePhone = lessThan20RequesterHomePhone;
    }


    /**
     * @hibernate.property
     *  column="less_than20_requester_home_phone"
     *  length="10"
     */
    public final String getLessThan20RequesterHomePhone() {
        return this.lessThan20RequesterHomePhone;
    }

    private fr.cg95.cvq.business.request.social.HarAdultLegalAccessRepresentativeKindType adultLegalAccessRepresentativeKind;

    public final void setAdultLegalAccessRepresentativeKind(final fr.cg95.cvq.business.request.social.HarAdultLegalAccessRepresentativeKindType adultLegalAccessRepresentativeKind) {
        this.adultLegalAccessRepresentativeKind = adultLegalAccessRepresentativeKind;
    }


    /**
     * @hibernate.property
     *  column="adult_legal_access_representative_kind"
     */
    public final fr.cg95.cvq.business.request.social.HarAdultLegalAccessRepresentativeKindType getAdultLegalAccessRepresentativeKind() {
        return this.adultLegalAccessRepresentativeKind;
    }

    private java.util.Date lessThan20ReferentBirthDate;

    public final void setLessThan20ReferentBirthDate(final java.util.Date lessThan20ReferentBirthDate) {
        this.lessThan20ReferentBirthDate = lessThan20ReferentBirthDate;
    }


    /**
     * @hibernate.property
     *  column="less_than20_referent_birth_date"
     */
    public final java.util.Date getLessThan20ReferentBirthDate() {
        return this.lessThan20ReferentBirthDate;
    }

    private Boolean adultLegalAccessPresence;

    public final void setAdultLegalAccessPresence(final Boolean adultLegalAccessPresence) {
        this.adultLegalAccessPresence = adultLegalAccessPresence;
    }


    /**
     * @hibernate.property
     *  column="adult_legal_access_presence"
     */
    public final Boolean getAdultLegalAccessPresence() {
        return this.adultLegalAccessPresence;
    }

    private Boolean dwellingEstablishmentReception;

    public final void setDwellingEstablishmentReception(final Boolean dwellingEstablishmentReception) {
        this.dwellingEstablishmentReception = dwellingEstablishmentReception;
    }


    /**
     * @hibernate.property
     *  column="dwelling_establishment_reception"
     */
    public final Boolean getDwellingEstablishmentReception() {
        return this.dwellingEstablishmentReception;
    }

    private String lessThan20RequesterEmail;

    public final void setLessThan20RequesterEmail(final String lessThan20RequesterEmail) {
        this.lessThan20RequesterEmail = lessThan20RequesterEmail;
    }


    /**
     * @hibernate.property
     *  column="less_than20_requester_email"
     */
    public final String getLessThan20RequesterEmail() {
        return this.lessThan20RequesterEmail;
    }

    private Boolean dwellingSocialReception;

    public final void setDwellingSocialReception(final Boolean dwellingSocialReception) {
        this.dwellingSocialReception = dwellingSocialReception;
    }


    /**
     * @hibernate.property
     *  column="dwelling_social_reception"
     */
    public final Boolean getDwellingSocialReception() {
        return this.dwellingSocialReception;
    }

    private Boolean hopesAndNeeds;

    public final void setHopesAndNeeds(final Boolean hopesAndNeeds) {
        this.hopesAndNeeds = hopesAndNeeds;
    }


    /**
     * @hibernate.property
     *  column="hopes_and_needs"
     */
    public final Boolean getHopesAndNeeds() {
        return this.hopesAndNeeds;
    }

    private Boolean lessThan20FatherActivityReduction;

    public final void setLessThan20FatherActivityReduction(final Boolean lessThan20FatherActivityReduction) {
        this.lessThan20FatherActivityReduction = lessThan20FatherActivityReduction;
    }


    /**
     * @hibernate.property
     *  column="less_than20_father_activity_reduction"
     */
    public final Boolean getLessThan20FatherActivityReduction() {
        return this.lessThan20FatherActivityReduction;
    }

    private String lessThan20FatherLastName;

    public final void setLessThan20FatherLastName(final String lessThan20FatherLastName) {
        this.lessThan20FatherLastName = lessThan20FatherLastName;
    }


    /**
     * @hibernate.property
     *  column="less_than20_father_last_name"
     *  length="38"
     */
    public final String getLessThan20FatherLastName() {
        return this.lessThan20FatherLastName;
    }

    private String lessThan20MotherLastName;

    public final void setLessThan20MotherLastName(final String lessThan20MotherLastName) {
        this.lessThan20MotherLastName = lessThan20MotherLastName;
    }


    /**
     * @hibernate.property
     *  column="less_than20_mother_last_name"
     *  length="38"
     */
    public final String getLessThan20MotherLastName() {
        return this.lessThan20MotherLastName;
    }

    private String lessThan20MotherHomePhone;

    public final void setLessThan20MotherHomePhone(final String lessThan20MotherHomePhone) {
        this.lessThan20MotherHomePhone = lessThan20MotherHomePhone;
    }


    /**
     * @hibernate.property
     *  column="less_than20_mother_home_phone"
     *  length="10"
     */
    public final String getLessThan20MotherHomePhone() {
        return this.lessThan20MotherHomePhone;
    }

    private String dwellingPrecision;

    public final void setDwellingPrecision(final String dwellingPrecision) {
        this.dwellingPrecision = dwellingPrecision;
    }


    /**
     * @hibernate.property
     *  column="dwelling_precision"
     */
    public final String getDwellingPrecision() {
        return this.dwellingPrecision;
    }

    private fr.cg95.cvq.business.request.social.HarLessThan20ParentalAuthorityHolderType lessThan20ParentalAuthorityHolder;

    public final void setLessThan20ParentalAuthorityHolder(final fr.cg95.cvq.business.request.social.HarLessThan20ParentalAuthorityHolderType lessThan20ParentalAuthorityHolder) {
        this.lessThan20ParentalAuthorityHolder = lessThan20ParentalAuthorityHolder;
    }


    /**
     * @hibernate.property
     *  column="less_than20_parental_authority_holder"
     */
    public final fr.cg95.cvq.business.request.social.HarLessThan20ParentalAuthorityHolderType getLessThan20ParentalAuthorityHolder() {
        return this.lessThan20ParentalAuthorityHolder;
    }

    private String lessThan20LegalRepresentativeMobilePhone;

    public final void setLessThan20LegalRepresentativeMobilePhone(final String lessThan20LegalRepresentativeMobilePhone) {
        this.lessThan20LegalRepresentativeMobilePhone = lessThan20LegalRepresentativeMobilePhone;
    }


    /**
     * @hibernate.property
     *  column="less_than20_legal_representative_mobile_phone"
     *  length="10"
     */
    public final String getLessThan20LegalRepresentativeMobilePhone() {
        return this.lessThan20LegalRepresentativeMobilePhone;
    }

    private fr.cg95.cvq.business.request.social.HarSocialSecurityMemberShipKindType socialSecurityMemberShipKind;

    public final void setSocialSecurityMemberShipKind(final fr.cg95.cvq.business.request.social.HarSocialSecurityMemberShipKindType socialSecurityMemberShipKind) {
        this.socialSecurityMemberShipKind = socialSecurityMemberShipKind;
    }


    /**
     * @hibernate.property
     *  column="social_security_member_ship_kind"
     */
    public final fr.cg95.cvq.business.request.social.HarSocialSecurityMemberShipKindType getSocialSecurityMemberShipKind() {
        return this.socialSecurityMemberShipKind;
    }

    private fr.cg95.cvq.business.users.TitleType lessThan20ReferentTitle;

    public final void setLessThan20ReferentTitle(final fr.cg95.cvq.business.users.TitleType lessThan20ReferentTitle) {
        this.lessThan20ReferentTitle = lessThan20ReferentTitle;
    }


    /**
     * @hibernate.property
     *  column="less_than20_referent_title"
     */
    public final fr.cg95.cvq.business.users.TitleType getLessThan20ReferentTitle() {
        return this.lessThan20ReferentTitle;
    }

    private String needs;

    public final void setNeeds(final String needs) {
        this.needs = needs;
    }


    /**
     * @hibernate.property
     *  column="needs"
     */
    public final String getNeeds() {
        return this.needs;
    }

    private String lessThan20ReferentEmail;

    public final void setLessThan20ReferentEmail(final String lessThan20ReferentEmail) {
        this.lessThan20ReferentEmail = lessThan20ReferentEmail;
    }


    /**
     * @hibernate.property
     *  column="less_than20_referent_email"
     */
    public final String getLessThan20ReferentEmail() {
        return this.lessThan20ReferentEmail;
    }

    private String lessThan20MotherJob;

    public final void setLessThan20MotherJob(final String lessThan20MotherJob) {
        this.lessThan20MotherJob = lessThan20MotherJob;
    }


    /**
     * @hibernate.property
     *  column="less_than20_mother_job"
     */
    public final String getLessThan20MotherJob() {
        return this.lessThan20MotherJob;
    }

    private String adultLegalAccessRepresentativeFirstName;

    public final void setAdultLegalAccessRepresentativeFirstName(final String adultLegalAccessRepresentativeFirstName) {
        this.adultLegalAccessRepresentativeFirstName = adultLegalAccessRepresentativeFirstName;
    }


    /**
     * @hibernate.property
     *  column="adult_legal_access_representative_first_name"
     *  length="38"
     */
    public final String getAdultLegalAccessRepresentativeFirstName() {
        return this.adultLegalAccessRepresentativeFirstName;
    }

    private String lessThan20LegalRepresentativeLastName;

    public final void setLessThan20LegalRepresentativeLastName(final String lessThan20LegalRepresentativeLastName) {
        this.lessThan20LegalRepresentativeLastName = lessThan20LegalRepresentativeLastName;
    }


    /**
     * @hibernate.property
     *  column="less_than20_legal_representative_last_name"
     *  length="38"
     */
    public final String getLessThan20LegalRepresentativeLastName() {
        return this.lessThan20LegalRepresentativeLastName;
    }

    private String helperName;

    public final void setHelperName(final String helperName) {
        this.helperName = helperName;
    }


    /**
     * @hibernate.property
     *  column="helper_name"
     *  length="38"
     */
    public final String getHelperName() {
        return this.helperName;
    }

    private fr.cg95.cvq.business.request.social.HarDwellingKindType dwellingKind;

    public final void setDwellingKind(final fr.cg95.cvq.business.request.social.HarDwellingKindType dwellingKind) {
        this.dwellingKind = dwellingKind;
    }


    /**
     * @hibernate.property
     *  column="dwelling_kind"
     */
    public final fr.cg95.cvq.business.request.social.HarDwellingKindType getDwellingKind() {
        return this.dwellingKind;
    }

    private String adultRequesterHomePhone;

    public final void setAdultRequesterHomePhone(final String adultRequesterHomePhone) {
        this.adultRequesterHomePhone = adultRequesterHomePhone;
    }


    /**
     * @hibernate.property
     *  column="adult_requester_home_phone"
     *  length="10"
     */
    public final String getAdultRequesterHomePhone() {
        return this.adultRequesterHomePhone;
    }

    private String hopes;

    public final void setHopes(final String hopes) {
        this.hopes = hopes;
    }


    /**
     * @hibernate.property
     *  column="hopes"
     */
    public final String getHopes() {
        return this.hopes;
    }

}
