package fr.cg95.cvq.service.request.social.impl;

import java.util.Arrays;

import org.apache.log4j.Logger;

import fr.cg95.cvq.business.request.Request;
import fr.cg95.cvq.business.request.social.HandicapCompensationAdultRequest;
import fr.cg95.cvq.business.request.social.HcarDwellingKindType;
import fr.cg95.cvq.business.request.social.HcarHomeIntervenantKindType;
import fr.cg95.cvq.business.request.social.HcarLegalAccessRepresentativeKindType;
import fr.cg95.cvq.business.request.social.HcarPaymentAgencyBeneficiaryType;
import fr.cg95.cvq.business.request.social.HcarProfessionalStatusKindType;
import fr.cg95.cvq.business.request.social.HcarSocialSecurityMemberShipKindType;
import fr.cg95.cvq.business.request.social.HcarPaymentAgencyBeneficiaryType;
import fr.cg95.cvq.service.request.condition.EqualityChecker;
import fr.cg95.cvq.service.request.condition.EqualityListChecker;
import fr.cg95.cvq.service.request.impl.RequestService;

/**
 * Implementation of the adult handicap compensation request service.
 * 
 * @author maxence.veyret@bull.net
 */
public class HandicapCompensationAdultRequestService extends RequestService {

    static Logger logger = Logger.getLogger(HandicapCompensationAdultRequestService.class);

    @Override
    public void init() {
        HandicapCompensationAdultRequest.conditions.put("subjectTitle",
            new EqualityChecker("Madam"));
        HandicapCompensationAdultRequest.conditions.put("legalAccessPresence",
            new EqualityChecker("true"));
        HandicapCompensationAdultRequest.conditions.put("legalAccessRepresentativeKind",
            new EqualityChecker(HcarLegalAccessRepresentativeKindType.OTHER.name()));
        HandicapCompensationAdultRequest.conditions.put("familyFamilyDependents",
            new EqualityChecker("true"));
        HandicapCompensationAdultRequest.conditions.put("dwellingKind",
            new EqualityListChecker(Arrays.asList(HcarDwellingKindType.OTHER.name(),HcarDwellingKindType.THIRD_PARTY_PLACE_OF_RESIDENCE.name())));
        HandicapCompensationAdultRequest.conditions.put("dwellingEstablishmentReception",
            new EqualityChecker("true"));
        HandicapCompensationAdultRequest.conditions.put("dwellingSocialReception",
            new EqualityChecker("true"));
        HandicapCompensationAdultRequest.conditions.put("socialSecurityMemberShipKind",
            new EqualityListChecker(Arrays.asList(HcarSocialSecurityMemberShipKindType.INSURED.name(),HcarSocialSecurityMemberShipKindType.CLAIMANT.name())));
        HandicapCompensationAdultRequest.conditions.put("paymentAgencyBeneficiary",
            new EqualityListChecker(Arrays.asList(HcarPaymentAgencyBeneficiaryType.C_A_F.name(), HcarPaymentAgencyBeneficiaryType.M_S_A.name(),HcarPaymentAgencyBeneficiaryType.OTHER.name())));
        HandicapCompensationAdultRequest.conditions.put("studiesHighSchool",
            new EqualityChecker("true"));
        HandicapCompensationAdultRequest.conditions.put("studiesAssistanceUnderDisability",
            new EqualityChecker("true"));
        HandicapCompensationAdultRequest.conditions.put("professionalStatusKind",
            new EqualityChecker(HcarProfessionalStatusKindType.EMPLOYEE.name()));
        HandicapCompensationAdultRequest.conditions.put("professionalStatusRegisterAsUnemployed",
            new EqualityChecker("true"));
        HandicapCompensationAdultRequest.conditions.put("professionalStatusIndemnified",
            new EqualityChecker("true"));
        HandicapCompensationAdultRequest.conditions.put("professionalStatusElectiveFunction",
            new EqualityChecker("true"));
        HandicapCompensationAdultRequest.conditions.put("foldersMdph", new EqualityChecker("true"));
        HandicapCompensationAdultRequest.conditions.put("foldersCotorep",
            new EqualityChecker("true"));
        HandicapCompensationAdultRequest.conditions.put("foldersCdes", new EqualityChecker("true"));
        HandicapCompensationAdultRequest.conditions.put("foldersOtherFolders",
            new EqualityChecker("true"));
        HandicapCompensationAdultRequest.conditions.put("benefitsDisabilityRecognition",
            new EqualityChecker("true"));
        HandicapCompensationAdultRequest.conditions.put("benefitsProfessionalOrientation",
            new EqualityChecker("true"));
        HandicapCompensationAdultRequest.conditions.put("benefitsEducationOfDisabledChildren",
            new EqualityChecker("true"));
        HandicapCompensationAdultRequest.conditions.put("benefitsDisabilityPension",
            new EqualityChecker("true"));
        HandicapCompensationAdultRequest.conditions.put("benefitsWorkAccidentAnnuity",
            new EqualityChecker("true"));
        HandicapCompensationAdultRequest.conditions.put("benefitsSupportedByAnInstitution",
            new EqualityChecker("true"));
        HandicapCompensationAdultRequest.conditions.put("benefitsOtherBenefits",
            new EqualityChecker("true"));
        HandicapCompensationAdultRequest.conditions.put("isFamilyAssistance",
            new EqualityChecker("true"));
        HandicapCompensationAdultRequest.conditions.put("homeInterventionHomeIntervenant",
            new EqualityChecker("true"));
        HandicapCompensationAdultRequest.conditions.put("homeIntervenants.homeIntervenantKind",
            new EqualityChecker(HcarHomeIntervenantKindType.OTHER.name()));
        HandicapCompensationAdultRequest.conditions.put("careCareServices",
            new EqualityChecker("true"));
        HandicapCompensationAdultRequest.conditions.put(
            "careServices.careServiceCareServiceEmployer", new EqualityChecker("true"));
        HandicapCompensationAdultRequest.conditions.put("facilitiesHousing",
            new EqualityChecker("true"));
        HandicapCompensationAdultRequest.conditions.put("facilitiesTechnicalAssistance",
            new EqualityChecker("true"));
        HandicapCompensationAdultRequest.conditions.put("facilitiesCustomCar",
            new EqualityChecker("true"));
        HandicapCompensationAdultRequest.conditions.put("facilitiesAnimalAid",
            new EqualityChecker("true"));
        HandicapCompensationAdultRequest.conditions.put("facilitiesSpecializedTransport",
            new EqualityChecker("true"));
        HandicapCompensationAdultRequest.conditions.put("professionalSupportProfessionals",
            new EqualityChecker("true"));
        HandicapCompensationAdultRequest.conditions.put("professionalSupportSocialServiceSupport",
            new EqualityChecker("true"));
        HandicapCompensationAdultRequest.conditions.put("socialServiceSupport",
            new EqualityChecker("true"));
        HandicapCompensationAdultRequest.conditions.put("healthFollowedByDoctor",
            new EqualityChecker("true"));
        HandicapCompensationAdultRequest.conditions.put("healthFollowedByProfessional",
            new EqualityChecker("true"));
        HandicapCompensationAdultRequest.conditions.put("healthFollowedByHospital",
            new EqualityChecker("true"));
        HandicapCompensationAdultRequest.conditions.put("projectRequestsProfessionalOrientation",
            new EqualityChecker("true"));
        HandicapCompensationAdultRequest.conditions.put("projectRequestsOther",
            new EqualityChecker("true"));
    }

    @Override
    public boolean accept(Request request) {
        return request instanceof HandicapCompensationAdultRequest;
    }

    @Override
    public Request getSkeletonRequest() {
        return new HandicapCompensationAdultRequest();
    }
}