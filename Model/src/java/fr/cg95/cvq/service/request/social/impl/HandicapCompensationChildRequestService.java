package fr.cg95.cvq.service.request.social.impl;

import java.util.Arrays;
import java.util.Calendar;

import org.apache.log4j.Logger;

import fr.cg95.cvq.business.request.Request;
import fr.cg95.cvq.business.request.social.HandicapCompensationChildRequest;
import fr.cg95.cvq.business.request.social.HccrDwellingKindType;
import fr.cg95.cvq.business.request.social.HccrHomeIntervenantKindType;
import fr.cg95.cvq.business.request.social.HccrPaymentAgencyBeneficiaryType;
import fr.cg95.cvq.business.request.social.HccrProfessionalStatusKindType;
import fr.cg95.cvq.business.request.social.HccrReferentFamilyDependentActualSituationType;
import fr.cg95.cvq.business.request.social.HccrSocialSecurityMemberShipKindType;
import fr.cg95.cvq.service.request.condition.DateChecker;
import fr.cg95.cvq.service.request.condition.EqualityChecker;
import fr.cg95.cvq.service.request.condition.EqualityListChecker;
import fr.cg95.cvq.service.request.impl.RequestService;
import fr.cg95.cvq.util.DateUtils;

/**
 * Implementation of the child handicap allowance request service.
 * 
 * @author maxence.veyret@bull.net
 */
public class HandicapCompensationChildRequestService extends RequestService {

    static Logger logger = Logger.getLogger(HandicapCompensationChildRequestService.class);

    @Override
    public void init() {
        HandicapCompensationChildRequest.conditions.put("referentTitle",
            new EqualityChecker("Madam"));
        HandicapCompensationChildRequest.conditions.put("fatherActivityReduction",
            new EqualityChecker("true"));
        HandicapCompensationChildRequest.conditions.put("motherActivityReduction",
            new EqualityChecker("true"));
        HandicapCompensationChildRequest.conditions.put("referentFamilyDependents",
            new EqualityChecker("true"));
        HandicapCompensationChildRequest.conditions.put("dwellingKind",
            new EqualityListChecker(Arrays.asList(HccrDwellingKindType.OTHER.name(), HccrDwellingKindType.THIRD_PARTY_PLACE_OF_RESIDENCE.name())));
        HandicapCompensationChildRequest.conditions.put("dwellingEstablishmentReception",
            new EqualityChecker("true"));
        HandicapCompensationChildRequest.conditions.put("dwellingSocialReception",
            new EqualityChecker("true"));
        HandicapCompensationChildRequest.conditions.put("socialSecurityMemberShipKind",
            new EqualityListChecker(Arrays.asList(HccrSocialSecurityMemberShipKindType.INSURED.name(), HccrSocialSecurityMemberShipKindType.CLAIMANT.name())));
        HandicapCompensationChildRequest.conditions.put("paymentAgencyBeneficiary",
            new EqualityListChecker(Arrays.asList(HccrPaymentAgencyBeneficiaryType.C_A_F.name(),HccrPaymentAgencyBeneficiaryType.M_S_A.name(), HccrPaymentAgencyBeneficiaryType.OTHER.name())));
        HandicapCompensationChildRequest.conditions.put("studiesHighSchool",
            new EqualityChecker("true"));
        HandicapCompensationChildRequest.conditions.put("studiesAssistanceUnderDisability",
            new EqualityChecker("true"));
        HandicapCompensationChildRequest.conditions.put("professionalStatusKind",
            new EqualityChecker(HccrProfessionalStatusKindType.EMPLOYEE.name()));
        HandicapCompensationChildRequest.conditions.put("professionalStatusRegisterAsUnemployed",
            new EqualityChecker("true"));
        HandicapCompensationChildRequest.conditions.put("professionalStatusIndemnified",
            new EqualityChecker("true"));
        HandicapCompensationChildRequest.conditions.put("professionalStatusElectiveFunction",
            new EqualityChecker("true"));
        HandicapCompensationChildRequest.conditions.put("foldersMdph", new EqualityChecker("true"));
        HandicapCompensationChildRequest.conditions.put("foldersCotorep",
            new EqualityChecker("true"));
        HandicapCompensationChildRequest.conditions.put("foldersCdes", new EqualityChecker("true"));
        HandicapCompensationChildRequest.conditions.put("foldersOtherFolders",
            new EqualityChecker("true"));
        HandicapCompensationChildRequest.conditions.put("benefitsDisabilityRecognition",
            new EqualityChecker("true"));
        HandicapCompensationChildRequest.conditions.put("benefitsProfessionalOrientation",
            new EqualityChecker("true"));
        HandicapCompensationChildRequest.conditions.put("benefitsEducationOfDisabledChildren",
            new EqualityChecker("true"));
        HandicapCompensationChildRequest.conditions.put("benefitsDisabilityPension",
            new EqualityChecker("true"));
        HandicapCompensationChildRequest.conditions.put("benefitsWorkAccidentAnnuity",
            new EqualityChecker("true"));
        HandicapCompensationChildRequest.conditions.put("benefitsSupportedByAnInstitution",
            new EqualityChecker("true"));
        HandicapCompensationChildRequest.conditions.put("benefitsOtherBenefits",
            new EqualityChecker("true"));
        HandicapCompensationChildRequest.conditions.put("isFamilyAssistance",
            new EqualityChecker("true"));
        HandicapCompensationChildRequest.conditions.put("homeInterventionHomeIntervenant",
            new EqualityChecker("true"));
        HandicapCompensationChildRequest.conditions.put("homeIntervenants[0].homeIntervenantKind",
            new EqualityChecker(HccrHomeIntervenantKindType.OTHER.name()));
        HandicapCompensationChildRequest.conditions.put("careCareServices",
            new EqualityChecker("true"));
        HandicapCompensationChildRequest.conditions.put(
            "careServices[0].careServiceCareServiceEmployer", new EqualityChecker("true"));
        HandicapCompensationChildRequest.conditions.put("facilitiesHousing",
            new EqualityChecker("true"));
        HandicapCompensationChildRequest.conditions.put("facilitiesTechnicalAssistance",
            new EqualityChecker("true"));
        HandicapCompensationChildRequest.conditions.put("facilitiesCustomCar",
            new EqualityChecker("true"));
        HandicapCompensationChildRequest.conditions.put("facilitiesAnimalAid",
            new EqualityChecker("true"));
        HandicapCompensationChildRequest.conditions.put("facilitiesSpecializedTransport",
            new EqualityChecker("true"));
        HandicapCompensationChildRequest.conditions.put("professionalSupportProfessionals",
            new EqualityChecker("true"));
        HandicapCompensationChildRequest.conditions.put("professionalSupportSocialServiceSupport",
            new EqualityChecker("true"));
        HandicapCompensationChildRequest.conditions.put("socialServiceSupport",
            new EqualityChecker("true"));
        HandicapCompensationChildRequest.conditions.put("healthFollowedByDoctor",
            new EqualityChecker("true"));
        HandicapCompensationChildRequest.conditions.put("healthFollowedByProfessional",
            new EqualityChecker("true"));
        HandicapCompensationChildRequest.conditions.put("healthFollowedByHospital",
            new EqualityChecker("true"));
        HandicapCompensationChildRequest.conditions.put("projectRequestsProfessionalOrientation",
            new EqualityChecker("true"));
        HandicapCompensationChildRequest.conditions.put("projectRequestsOther",
            new EqualityChecker("true"));
        HandicapCompensationChildRequest.conditions.put("subjectBirthDate",
            new DateChecker("<", DateUtils.getShiftedDate(Calendar.YEAR, -18)));
    }

    @Override
    public boolean accept(Request request) {
        return request instanceof HandicapCompensationChildRequest;
    }

    @Override
    public Request getSkeletonRequest() {
        return new HandicapCompensationChildRequest();
    }
}