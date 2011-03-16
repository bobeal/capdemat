
package fr.cg95.cvq.service.request.social;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import static org.junit.Assert.*;
import org.junit.Test;

import fr.cg95.cvq.business.document.*;
import fr.cg95.cvq.business.request.*;
import fr.cg95.cvq.business.request.social.*;
import fr.cg95.cvq.business.users.*;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.exception.CvqObjectNotFoundException;
import fr.cg95.cvq.security.SecurityContext;
import fr.cg95.cvq.service.document.IDocumentTypeService;
import fr.cg95.cvq.service.request.IRequestService;
import fr.cg95.cvq.service.request.RequestTestCase;
import fr.cg95.cvq.util.Critere;
import fr.cg95.cvq.util.development.BusinessObjectsFactory;

/**
 * Generated class file, do not edit !
 * Extend it to define your own specific test cases.
 */
public class HandicapCompensationChildRequestServiceTest extends RequestTestCase {
    
    @Resource(name="handicapCompensationChildRequestService")
    protected IRequestService requestService;

    protected HandicapCompensationChildRequest fillMeARequest() {
        HandicapCompensationChildRequest request = new HandicapCompensationChildRequest();
        
          
          
            
            
          
        
          
          
            
              if ("AseReferentDepartment".length() > 2)
                  request.setAseReferentDepartment("AseReferentDepartment".substring(0, 2));
              else
                  request.setAseReferentDepartment("AseReferentDepartment");
            
          
        
          
          
            
              if ("AseReferentLastName".length() > 38)
                  request.setAseReferentLastName("AseReferentLastName".substring(0, 38));
              else
                  request.setAseReferentLastName("AseReferentLastName");
            
          
        
          
          
               request.setBenefitsCompensatoryAllowanceForExpenses(Boolean.valueOf(true));
          
        
          
          
               request.setBenefitsDailyAllowances(Boolean.valueOf(true));
          
        
          
          
               request.setBenefitsDisabilityCard(Boolean.valueOf(true));
          
        
          
          
               request.setBenefitsDisabilityCompensation(Boolean.valueOf(true));
          
        
          
          
               request.setBenefitsDisabilityPension(Boolean.valueOf(true));
          
        
          
          
            
              if ("BenefitsDisabilityPensionCategory".length() > 60)
                  request.setBenefitsDisabilityPensionCategory("BenefitsDisabilityPensionCategory".substring(0, 60));
              else
                  request.setBenefitsDisabilityPensionCategory("BenefitsDisabilityPensionCategory");
            
          
        
          
          
            
              if ("BenefitsDisabilityRatio".length() > 3)
                  request.setBenefitsDisabilityRatio("BenefitsDisabilityRatio".substring(0, 3));
              else
                  request.setBenefitsDisabilityRatio("BenefitsDisabilityRatio");
            
          
        
          
          
               request.setBenefitsDisabilityRecognition(Boolean.valueOf(true));
          
        
          
          
               request.setBenefitsDisabledAdultAllocation(Boolean.valueOf(true));
          
        
          
          
               request.setBenefitsDisabledWorkerRecognition(Boolean.valueOf(true));
          
        
          
          
               request.setBenefitsEducationAllocationOfDisabledChildren(Boolean.valueOf(true));
          
        
          
          
               request.setBenefitsEducationOfDisabledChildren(Boolean.valueOf(true));
          
        
          
          
            
              if ("BenefitsEducationOfDisabledChildrenDetails".length() > 60)
                  request.setBenefitsEducationOfDisabledChildrenDetails("BenefitsEducationOfDisabledChildrenDetails".substring(0, 60));
              else
                  request.setBenefitsEducationOfDisabledChildrenDetails("BenefitsEducationOfDisabledChildrenDetails");
            
          
        
          
          
               request.setBenefitsIncreaseForIndependentLiving(Boolean.valueOf(true));
          
        
          
          
               request.setBenefitsOtherBenefits(Boolean.valueOf(true));
          
        
          
          
               request.setBenefitsPainfulStandingCard(Boolean.valueOf(true));
          
        
          
          
               request.setBenefitsParkingCard(Boolean.valueOf(true));
          
        
          
          
               request.setBenefitsProfessionalOrientation(Boolean.valueOf(true));
          
        
          
          
            
              if ("BenefitsProfessionalOrientationDetails".length() > 60)
                  request.setBenefitsProfessionalOrientationDetails("BenefitsProfessionalOrientationDetails".substring(0, 60));
              else
                  request.setBenefitsProfessionalOrientationDetails("BenefitsProfessionalOrientationDetails");
            
          
        
          
          
               request.setBenefitsSocialWelfare(Boolean.valueOf(true));
          
        
          
          
               request.setBenefitsSupplementForSingleParents(Boolean.valueOf(true));
          
        
          
          
               request.setBenefitsSupportedByAnInstitution(Boolean.valueOf(true));
          
        
          
          
            
              if ("BenefitsSupportedByAnInstitutionDetails".length() > 60)
                  request.setBenefitsSupportedByAnInstitutionDetails("BenefitsSupportedByAnInstitutionDetails".substring(0, 60));
              else
                  request.setBenefitsSupportedByAnInstitutionDetails("BenefitsSupportedByAnInstitutionDetails");
            
          
        
          
          
               request.setBenefitsThirdPartyCompensatoryAllowance(Boolean.valueOf(true));
          
        
          
          
               request.setBenefitsThirdPartySupplement(Boolean.valueOf(true));
          
        
          
          
               request.setBenefitsThirdPersonCompensatoryAllowance(Boolean.valueOf(true));
          
        
          
          
               request.setBenefitsUnemploymentBenefits(Boolean.valueOf(true));
          
        
          
          
               request.setBenefitsWorkAccidentAnnuity(Boolean.valueOf(true));
          
        
          
          
            
              if ("BenefitsWorkAccidentAnnuityRatio".length() > 3)
                  request.setBenefitsWorkAccidentAnnuityRatio("BenefitsWorkAccidentAnnuityRatio".substring(0, 3));
              else
                  request.setBenefitsWorkAccidentAnnuityRatio("BenefitsWorkAccidentAnnuityRatio");
            
          
        
          
          
               request.setCareCareServices(Boolean.valueOf(true));
          
        
          
          
            
            
          
        
          
          
               request.setDwellingEstablishmentReception(Boolean.valueOf(true));
          
        
          
          
            
              request.setDwellingKind(HccrDwellingKindType.PLACE_OF_RESIDENCE);
            
          
        
          
          
            
              if ("DwellingPrecision".length() > 120)
                  request.setDwellingPrecision("DwellingPrecision".substring(0, 120));
              else
                  request.setDwellingPrecision("DwellingPrecision");
            
          
        
          
          
            
            
              
                request.setDwellingReceptionAddress(BusinessObjectsFactory.gimmeAdress("1", "Unit test address", "Paris", "75012"));
              
            
          
        
          
          
            
              if ("DwellingReceptionNaming".length() > 80)
                  request.setDwellingReceptionNaming("DwellingReceptionNaming".substring(0, 80));
              else
                  request.setDwellingReceptionNaming("DwellingReceptionNaming");
            
          
        
          
          
            
              request.setDwellingReceptionType(HccrDwellingReceptionKindType.INTERNSHIP);
            
          
        
          
          
               request.setDwellingSocialReception(Boolean.valueOf(true));
          
        
          
          
            
            
              
                request.setDwellingSocialReceptionAddress(BusinessObjectsFactory.gimmeAdress("1", "Unit test address", "Paris", "75012"));
              
            
          
        
          
          
            
              if ("DwellingSocialReceptionNaming".length() > 80)
                  request.setDwellingSocialReceptionNaming("DwellingSocialReceptionNaming".substring(0, 80));
              else
                  request.setDwellingSocialReceptionNaming("DwellingSocialReceptionNaming");
            
          
        
          
          
               request.setFacilitiesAnimalAid(Boolean.valueOf(true));
          
        
          
          
            
              if ("FacilitiesAnimalAidDetails".length() > 60)
                  request.setFacilitiesAnimalAidDetails("FacilitiesAnimalAidDetails".substring(0, 60));
              else
                  request.setFacilitiesAnimalAidDetails("FacilitiesAnimalAidDetails");
            
          
        
          
          
               request.setFacilitiesCustomCar(Boolean.valueOf(true));
          
        
          
          
            
              if ("FacilitiesCustomCarDetails".length() > 60)
                  request.setFacilitiesCustomCarDetails("FacilitiesCustomCarDetails".substring(0, 60));
              else
                  request.setFacilitiesCustomCarDetails("FacilitiesCustomCarDetails");
            
          
        
          
          
               request.setFacilitiesHousing(Boolean.valueOf(true));
          
        
          
          
            
              if ("FacilitiesHousingDetails".length() > 60)
                  request.setFacilitiesHousingDetails("FacilitiesHousingDetails".substring(0, 60));
              else
                  request.setFacilitiesHousingDetails("FacilitiesHousingDetails");
            
          
        
          
          
               request.setFacilitiesSpecializedTransport(Boolean.valueOf(true));
          
        
          
          
            
              if ("FacilitiesSpecializedTransportDetails".length() > 60)
                  request.setFacilitiesSpecializedTransportDetails("FacilitiesSpecializedTransportDetails".substring(0, 60));
              else
                  request.setFacilitiesSpecializedTransportDetails("FacilitiesSpecializedTransportDetails");
            
          
        
          
          
               request.setFacilitiesTechnicalAssistance(Boolean.valueOf(true));
          
        
          
          
            
              if ("FacilitiesTechnicalAssistanceDetails".length() > 60)
                  request.setFacilitiesTechnicalAssistanceDetails("FacilitiesTechnicalAssistanceDetails".substring(0, 60));
              else
                  request.setFacilitiesTechnicalAssistanceDetails("FacilitiesTechnicalAssistanceDetails");
            
          
        
          
          
            
            
          
        
          
          
            
            
          
        
          
          
               request.setFatherActivityReduction(Boolean.valueOf(true));
          
        
          
          
               request.setFatherActivityReductionRatio(BigInteger.valueOf(1));
          
        
          
          
            
              if ("FatherFirstName".length() > 38)
                  request.setFatherFirstName("FatherFirstName".substring(0, 38));
              else
                  request.setFatherFirstName("FatherFirstName");
            
          
        
          
          
            
              if ("FatherJob".length() > 60)
                  request.setFatherJob("FatherJob".substring(0, 60));
              else
                  request.setFatherJob("FatherJob");
            
          
        
          
          
            
              if ("FatherLastName".length() > 38)
                  request.setFatherLastName("FatherLastName".substring(0, 38));
              else
                  request.setFatherLastName("FatherLastName");
            
          
        
          
          
               request.setFoldersCdes(Boolean.valueOf(true));
          
        
          
          
            
              if ("FoldersCdesDepartment".length() > 2)
                  request.setFoldersCdesDepartment("FoldersCdesDepartment".substring(0, 2));
              else
                  request.setFoldersCdesDepartment("FoldersCdesDepartment");
            
          
        
          
          
            
              if ("FoldersCdesNumber".length() > 30)
                  request.setFoldersCdesNumber("FoldersCdesNumber".substring(0, 30));
              else
                  request.setFoldersCdesNumber("FoldersCdesNumber");
            
          
        
          
          
               request.setFoldersCotorep(Boolean.valueOf(true));
          
        
          
          
            
              if ("FoldersCotorepDepartment".length() > 2)
                  request.setFoldersCotorepDepartment("FoldersCotorepDepartment".substring(0, 2));
              else
                  request.setFoldersCotorepDepartment("FoldersCotorepDepartment");
            
          
        
          
          
            
              if ("FoldersCotorepNumber".length() > 30)
                  request.setFoldersCotorepNumber("FoldersCotorepNumber".substring(0, 30));
              else
                  request.setFoldersCotorepNumber("FoldersCotorepNumber");
            
          
        
          
          
               request.setFoldersMdph(Boolean.valueOf(true));
          
        
          
          
            
              if ("FoldersMdphDepartment".length() > 2)
                  request.setFoldersMdphDepartment("FoldersMdphDepartment".substring(0, 2));
              else
                  request.setFoldersMdphDepartment("FoldersMdphDepartment");
            
          
        
          
          
            
              if ("FoldersMdphNumber".length() > 30)
                  request.setFoldersMdphNumber("FoldersMdphNumber".substring(0, 30));
              else
                  request.setFoldersMdphNumber("FoldersMdphNumber");
            
          
        
          
          
               request.setFoldersOtherFolders(Boolean.valueOf(true));
          
        
          
          
            
              if ("FormationCurrentFormation".length() > 120)
                  request.setFormationCurrentFormation("FormationCurrentFormation".substring(0, 120));
              else
                  request.setFormationCurrentFormation("FormationCurrentFormation");
            
          
        
          
          
            
              if ("FormationDiploma".length() > 120)
                  request.setFormationDiploma("FormationDiploma".substring(0, 120));
              else
                  request.setFormationDiploma("FormationDiploma");
            
          
        
          
          
            
              if ("FormationPreviousFormation".length() > 180)
                  request.setFormationPreviousFormation("FormationPreviousFormation".substring(0, 180));
              else
                  request.setFormationPreviousFormation("FormationPreviousFormation");
            
          
        
          
          
            
              if ("FormationStudiesLevel".length() > 30)
                  request.setFormationStudiesLevel("FormationStudiesLevel".substring(0, 30));
              else
                  request.setFormationStudiesLevel("FormationStudiesLevel");
            
          
        
          
          
            
              if ("HealthDoctorFirstName".length() > 38)
                  request.setHealthDoctorFirstName("HealthDoctorFirstName".substring(0, 38));
              else
                  request.setHealthDoctorFirstName("HealthDoctorFirstName");
            
          
        
          
          
            
              if ("HealthDoctorLastName".length() > 38)
                  request.setHealthDoctorLastName("HealthDoctorLastName".substring(0, 38));
              else
                  request.setHealthDoctorLastName("HealthDoctorLastName");
            
          
        
          
          
               request.setHealthFollowedByDoctor(Boolean.valueOf(true));
          
        
          
          
               request.setHealthFollowedByHospital(Boolean.valueOf(true));
          
        
          
          
               request.setHealthFollowedByProfessional(Boolean.valueOf(true));
          
        
          
          
            
              if ("HealthHospitalName".length() > 60)
                  request.setHealthHospitalName("HealthHospitalName".substring(0, 60));
              else
                  request.setHealthHospitalName("HealthHospitalName");
            
          
        
          
          
            
              if ("HealthProfessionalFirstName".length() > 38)
                  request.setHealthProfessionalFirstName("HealthProfessionalFirstName".substring(0, 38));
              else
                  request.setHealthProfessionalFirstName("HealthProfessionalFirstName");
            
          
        
          
          
            
              if ("HealthProfessionalLastName".length() > 38)
                  request.setHealthProfessionalLastName("HealthProfessionalLastName".substring(0, 38));
              else
                  request.setHealthProfessionalLastName("HealthProfessionalLastName");
            
          
        
          
          
            
            
          
        
          
          
               request.setHomeInterventionHomeIntervenant(Boolean.valueOf(true));
          
        
          
          
               request.setIsFamilyAssistance(Boolean.valueOf(true));
          
        
          
          
               request.setMotherActivityReduction(Boolean.valueOf(true));
          
        
          
          
               request.setMotherActivityReductionRatio(BigInteger.valueOf(1));
          
        
          
          
            
              if ("MotherFirstName".length() > 38)
                  request.setMotherFirstName("MotherFirstName".substring(0, 38));
              else
                  request.setMotherFirstName("MotherFirstName");
            
          
        
          
          
            
              if ("MotherJob".length() > 60)
                  request.setMotherJob("MotherJob".substring(0, 60));
              else
                  request.setMotherJob("MotherJob");
            
          
        
          
          
            
              if ("MotherLastName".length() > 38)
                  request.setMotherLastName("MotherLastName".substring(0, 38));
              else
                  request.setMotherLastName("MotherLastName");
            
          
        
          
          
            
            
          
        
          
          
            
            
          
        
          
          
            
            
              
                request.setPaymentAgencyAddress(BusinessObjectsFactory.gimmeAdress("1", "Unit test address", "Paris", "75012"));
              
            
          
        
          
          
            
              request.setPaymentAgencyBeneficiary(HccrPaymentAgencyBeneficiaryType.C_A_F);
            
          
        
          
          
            
              if ("PaymentAgencyBeneficiaryNumber".length() > 20)
                  request.setPaymentAgencyBeneficiaryNumber("PaymentAgencyBeneficiaryNumber".substring(0, 20));
              else
                  request.setPaymentAgencyBeneficiaryNumber("PaymentAgencyBeneficiaryNumber");
            
          
        
          
          
            
              if ("PaymentAgencyName".length() > 50)
                  request.setPaymentAgencyName("PaymentAgencyName".substring(0, 50));
              else
                  request.setPaymentAgencyName("PaymentAgencyName");
            
          
        
          
          
            
            
              
                request.setProfessionalStatusAddress(BusinessObjectsFactory.gimmeAdress("1", "Unit test address", "Paris", "75012"));
              
            
          
        
          
          
               request.setProfessionalStatusDate(new Date());
          
        
          
          
               request.setProfessionalStatusElectiveFunction(Boolean.valueOf(true));
          
        
          
          
            
              if ("ProfessionalStatusElectiveFunctionDetails".length() > 60)
                  request.setProfessionalStatusElectiveFunctionDetails("ProfessionalStatusElectiveFunctionDetails".substring(0, 60));
              else
                  request.setProfessionalStatusElectiveFunctionDetails("ProfessionalStatusElectiveFunctionDetails");
            
          
        
          
          
            
              if ("ProfessionalStatusEmployerName".length() > 38)
                  request.setProfessionalStatusEmployerName("ProfessionalStatusEmployerName".substring(0, 38));
              else
                  request.setProfessionalStatusEmployerName("ProfessionalStatusEmployerName");
            
          
        
          
          
            
              request.setProfessionalStatusEnvironment(HccrProfessionalStatusEnvironmentType.ORDINARY);
            
          
        
          
          
               request.setProfessionalStatusIndemnified(Boolean.valueOf(true));
          
        
          
          
               request.setProfessionalStatusIndemnifiedDate(new Date());
          
        
          
          
            
              request.setProfessionalStatusKind(HccrProfessionalStatusKindType.EMPLOYEE);
            
          
        
          
          
            
              if ("ProfessionalStatusProfession".length() > 60)
                  request.setProfessionalStatusProfession("ProfessionalStatusProfession".substring(0, 60));
              else
                  request.setProfessionalStatusProfession("ProfessionalStatusProfession");
            
          
        
          
          
               request.setProfessionalStatusRegisterAsUnemployed(Boolean.valueOf(true));
          
        
          
          
               request.setProfessionalStatusRegisterAsUnemployedDate(new Date());
          
        
          
          
               request.setProfessionalSupportDealsWithSameProfessional(Boolean.valueOf(true));
          
        
          
          
               request.setProfessionalSupportProfessionals(Boolean.valueOf(true));
          
        
          
          
            
            
          
        
          
          
            
              if ("ProjectComments".length() > 600)
                  request.setProjectComments("ProjectComments".substring(0, 600));
              else
                  request.setProjectComments("ProjectComments");
            
          
        
          
          
            
              if ("ProjectNeeds".length() > 600)
                  request.setProjectNeeds("ProjectNeeds".substring(0, 600));
              else
                  request.setProjectNeeds("ProjectNeeds");
            
          
        
          
          
               request.setProjectRequestsACTPRenewal(Boolean.valueOf(true));
          
        
          
          
               request.setProjectRequestsAssistance(Boolean.valueOf(true));
          
        
          
          
               request.setProjectRequestsCustomCar(Boolean.valueOf(true));
          
        
          
          
               request.setProjectRequestsDisabilityCard(Boolean.valueOf(true));
          
        
          
          
               request.setProjectRequestsDisabilityCostAllocation(Boolean.valueOf(true));
          
        
          
          
               request.setProjectRequestsDisabledAdultAllowance(Boolean.valueOf(true));
          
        
          
          
               request.setProjectRequestsDisabledPriorityCard(Boolean.valueOf(true));
          
        
          
          
               request.setProjectRequestsDisabledWorkerRecognition(Boolean.valueOf(true));
          
        
          
          
               request.setProjectRequestsEducationAllocationOfDisabledChildren(Boolean.valueOf(true));
          
        
          
          
               request.setProjectRequestsEuropeanParkingCard(Boolean.valueOf(true));
          
        
          
          
               request.setProjectRequestsFreePensionMembership(Boolean.valueOf(true));
          
        
          
          
               request.setProjectRequestsHandicapRecognition(Boolean.valueOf(true));
          
        
          
          
               request.setProjectRequestsHousingFacilities(Boolean.valueOf(true));
          
        
          
          
               request.setProjectRequestsIncreaseForIndependentLiving(Boolean.valueOf(true));
          
        
          
          
               request.setProjectRequestsInstitutionSupport(Boolean.valueOf(true));
          
        
          
          
               request.setProjectRequestsOrdinaryWorking(Boolean.valueOf(true));
          
        
          
          
               request.setProjectRequestsOther(Boolean.valueOf(true));
          
        
          
          
            
              if ("ProjectRequestsOtherDetails".length() > 60)
                  request.setProjectRequestsOtherDetails("ProjectRequestsOtherDetails".substring(0, 60));
              else
                  request.setProjectRequestsOtherDetails("ProjectRequestsOtherDetails");
            
          
        
          
          
               request.setProjectRequestsProfessionalOrientation(Boolean.valueOf(true));
          
        
          
          
               request.setProjectRequestsShelteredWork(Boolean.valueOf(true));
          
        
          
          
               request.setProjectRequestsTechnicalHelp(Boolean.valueOf(true));
          
        
          
          
               request.setProjectRequestsThirdPartyHelp(Boolean.valueOf(true));
          
        
          
          
               request.setProjectRequestsTransportCostAllocation(Boolean.valueOf(true));
          
        
          
          
               request.setProjectRequestsVocationalTraining(Boolean.valueOf(true));
          
        
          
          
            
              if ("ProjectWish".length() > 600)
                  request.setProjectWish("ProjectWish".substring(0, 600));
              else
                  request.setProjectWish("ProjectWish");
            
          
        
          
          
            
              if ("ReferentBirthCity".length() > 32)
                  request.setReferentBirthCity("ReferentBirthCity".substring(0, 32));
              else
                  request.setReferentBirthCity("ReferentBirthCity");
            
          
        
          
          
            
              if ("ReferentBirthCountry".length() > 50)
                  request.setReferentBirthCountry("ReferentBirthCountry".substring(0, 50));
              else
                  request.setReferentBirthCountry("ReferentBirthCountry");
            
          
        
          
          
               request.setReferentBirthDate(new Date());
          
        
          
          
               request.setReferentFamilyDependents(Boolean.valueOf(true));
          
        
          
          
            
              request.setReferentFamilyStatus(FamilyStatusType.MARRIED);
            
          
        
          
          
            
              if ("ReferentFirstName".length() > 38)
                  request.setReferentFirstName("ReferentFirstName".substring(0, 38));
              else
                  request.setReferentFirstName("ReferentFirstName");
            
          
        
          
          
            
              if ("ReferentLastName".length() > 38)
                  request.setReferentLastName("ReferentLastName".substring(0, 38));
              else
                  request.setReferentLastName("ReferentLastName");
            
          
        
          
          
            
              if ("ReferentMaidenName".length() > 38)
                  request.setReferentMaidenName("ReferentMaidenName".substring(0, 38));
              else
                  request.setReferentMaidenName("ReferentMaidenName");
            
          
        
          
          
            
              request.setReferentTitle(TitleType.MISTER);
            
          
        
          
          
            
              request.setSchoolingAttendedGrade(SectionType.BEFORE_FIRST_SECTION);
            
          
        
          
          
               request.setSchoolingEnrolment(Boolean.valueOf(true));
          
        
          
          
               request.setSchoolingExtraCurricular(Boolean.valueOf(true));
          
        
          
          
            
              if ("SchoolingExtraCurricularDetails".length() > 50)
                  request.setSchoolingExtraCurricularDetails("SchoolingExtraCurricularDetails".substring(0, 50));
              else
                  request.setSchoolingExtraCurricularDetails("SchoolingExtraCurricularDetails");
            
          
        
          
          
               request.setSchoolingHomeSchooling(Boolean.valueOf(true));
          
        
          
          
            
            
              
                request.setSchoolingHomeSchoolingAccompanistAddress(BusinessObjectsFactory.gimmeAdress("1", "Unit test address", "Paris", "75012"));
              
            
          
        
          
          
            
              if ("SchoolingHomeSchoolingAccompanistFirstName".length() > 38)
                  request.setSchoolingHomeSchoolingAccompanistFirstName("SchoolingHomeSchoolingAccompanistFirstName".substring(0, 38));
              else
                  request.setSchoolingHomeSchoolingAccompanistFirstName("SchoolingHomeSchoolingAccompanistFirstName");
            
          
        
          
          
            
              if ("SchoolingHomeSchoolingAccompanistLastName".length() > 38)
                  request.setSchoolingHomeSchoolingAccompanistLastName("SchoolingHomeSchoolingAccompanistLastName".substring(0, 38));
              else
                  request.setSchoolingHomeSchoolingAccompanistLastName("SchoolingHomeSchoolingAccompanistLastName");
            
          
        
          
          
            
              request.setSchoolingHomeSchoolingKind(HccrHomeSchoolingKindType.ALONE);
            
          
        
          
          
               request.setSchoolingPersonalizedSchoolingPlan(Boolean.valueOf(true));
          
        
          
          
            
            
              
                request.setSchoolingSchoolAddress(BusinessObjectsFactory.gimmeAdress("1", "Unit test address", "Paris", "75012"));
              
            
          
        
          
          
            
              if ("SchoolingSchoolName".length() > 80)
                  request.setSchoolingSchoolName("SchoolingSchoolName".substring(0, 80));
              else
                  request.setSchoolingSchoolName("SchoolingSchoolName");
            
          
        
          
          
            
              request.setSchoolingSchoolingKind(HccrSchoolingKindType.FULL_TIME);
            
          
        
          
          
               request.setSchoolingSendToSchool(Boolean.valueOf(true));
          
        
          
          
               request.setSchoolingSpecializedGrade(Boolean.valueOf(true));
          
        
          
          
            
              if ("SchoolingSpecializedGradeDetails".length() > 30)
                  request.setSchoolingSpecializedGradeDetails("SchoolingSpecializedGradeDetails".substring(0, 30));
              else
                  request.setSchoolingSpecializedGradeDetails("SchoolingSpecializedGradeDetails");
            
          
        
          
          
            
                  if ("SchoolingTime".length() > 4)
                      request.setSchoolingTime("SchoolingTime".substring(0, 4));
                  else
                      request.setSchoolingTime("SchoolingTime");
            
          
        
          
          
            
            
              
                request.setSocialSecurityAgencyAddress(BusinessObjectsFactory.gimmeAdress("1", "Unit test address", "Paris", "75012"));
              
            
          
        
          
          
            
              if ("SocialSecurityAgencyName".length() > 50)
                  request.setSocialSecurityAgencyName("SocialSecurityAgencyName".substring(0, 50));
              else
                  request.setSocialSecurityAgencyName("SocialSecurityAgencyName");
            
          
        
          
          
            
              request.setSocialSecurityMemberShipKind(HccrSocialSecurityMemberShipKindType.INSURED);
            
          
        
          
          
            
                  if ("SocialSecurityNumber".length() > 13)
                      request.setSocialSecurityNumber("SocialSecurityNumber".substring(0, 13));
                  else
                      request.setSocialSecurityNumber("SocialSecurityNumber");
            
          
        
          
          
            
            
              
                request.setSocialServiceAddress(BusinessObjectsFactory.gimmeAdress("1", "Unit test address", "Paris", "75012"));
              
            
          
        
          
          
            
              if ("SocialServiceName".length() > 60)
                  request.setSocialServiceName("SocialServiceName".substring(0, 60));
              else
                  request.setSocialServiceName("SocialServiceName");
            
          
        
          
          
               request.setSocialServiceSupport(Boolean.valueOf(true));
          
        
          
          
               request.setStudiesAssistanceUnderDisability(Boolean.valueOf(true));
          
        
          
          
            
              if ("StudiesAssistanceUnderDisabilityDetails".length() > 60)
                  request.setStudiesAssistanceUnderDisabilityDetails("StudiesAssistanceUnderDisabilityDetails".substring(0, 60));
              else
                  request.setStudiesAssistanceUnderDisabilityDetails("StudiesAssistanceUnderDisabilityDetails");
            
          
        
          
          
               request.setStudiesHighSchool(Boolean.valueOf(true));
          
        
          
          
            
            
              
                request.setStudiesHighSchoolAddress(BusinessObjectsFactory.gimmeAdress("1", "Unit test address", "Paris", "75012"));
              
            
          
        
          
          
            
              if ("StudiesHighSchoolGrade".length() > 60)
                  request.setStudiesHighSchoolGrade("StudiesHighSchoolGrade".substring(0, 60));
              else
                  request.setStudiesHighSchoolGrade("StudiesHighSchoolGrade");
            
          
        
          
          
            
              if ("StudiesHighSchoolName".length() > 60)
                  request.setStudiesHighSchoolName("StudiesHighSchoolName".substring(0, 60));
              else
                  request.setStudiesHighSchoolName("StudiesHighSchoolName");
            
          
        
          
          
            
              if ("SubjectBirthCity".length() > 32)
                  request.setSubjectBirthCity("SubjectBirthCity".substring(0, 32));
              else
                  request.setSubjectBirthCity("SubjectBirthCity");
            
          
        
          
          
            
              if ("SubjectBirthCountry".length() > 50)
                  request.setSubjectBirthCountry("SubjectBirthCountry".substring(0, 50));
              else
                  request.setSubjectBirthCountry("SubjectBirthCountry");
            
          
        
          
          
               request.setSubjectBirthDate(new Date());
          
        
          
          
            
              request.setSubjectParentalAuthorityHolder(HccrSubjectParentalAuthorityHolderType.FATHER);
            
          
        
        // Means Of Contact
        MeansOfContact meansOfContact = meansOfContactService.getMeansOfContactByType(MeansOfContactEnum.EMAIL);
        request.setMeansOfContact(meansOfContact);
        HandicapCompensationChildRequestFeeder.feed(request);
        return request;
    }

    protected void completeValidateAndDelete(HandicapCompensationChildRequest request)
        throws CvqException, IOException {
        // add a document to the request
        ///////////////////////////////
        Document doc = new Document();
        doc.setEcitizenNote("Ma carte d'identité !");
        doc.setDepositOrigin(DepositOrigin.ECITIZEN);
        doc.setDepositType(DepositType.PC);
        doc.setHomeFolderId(request.getHomeFolderId());
        doc.setIndividualId(request.getRequesterId());
        doc.setDocumentType(documentTypeService.getDocumentTypeByType(IDocumentTypeService.IDENTITY_RECEIPT_TYPE));
        Long documentId = documentService.create(doc);
        requestDocumentService.addDocument(request.getId(), documentId);
        Set<RequestDocument> documentsSet = requestDocumentService.getAssociatedDocuments(request.getId());
        assertEquals(documentsSet.size(), 1);
        // FIXME : test list of pending / in-progress registrations
        Critere testCrit = new Critere();
        testCrit.setAttribut(Request.SEARCH_BY_HOME_FOLDER_ID);
        testCrit.setComparatif(Critere.EQUALS);
        testCrit.setValue(request.getHomeFolderId());
        Set<Critere> testCritSet = new HashSet<Critere>();
        testCritSet.add(testCrit);
        List<Request> allRequests = requestSearchService.get(testCritSet, null, null, -1, 0, false);
        assertNotNull(allRequests);
        // close current session and re-open a new one
        continueWithNewTransaction();
        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.BACK_OFFICE_CONTEXT);
        SecurityContext.setCurrentAgent(agentNameWithCategoriesRoles);
        requestWorkflowService.updateRequestState(request.getId(), RequestState.COMPLETE, null);
        requestWorkflowService.updateRequestState(request.getId(), RequestState.VALIDATED, null);
        // close current session and re-open a new one
        continueWithNewTransaction();
        byte[] generatedCertificate = requestSearchService.getCertificate(request.getId(), RequestState.PENDING);
        if (generatedCertificate == null)
            fail("No certificate found");
        //     Write tele-service xml data file
        File xmlFile = File.createTempFile("tmp" + request.getId(), ".xml");
        FileOutputStream xmlFos = new FileOutputStream(xmlFile);
        xmlFos.write(requestSearchService.getById(request.getId(), true).modelToXmlString().getBytes());
        File file = File.createTempFile("tmp" + request.getId(), ".pdf");
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(generatedCertificate);
        // close current session and re-open a new one
        continueWithNewTransaction();
        // delete request
        requestWorkflowService.delete(request.getId());
    }
    
    @Test
    public void testWithHomeFolderPojo()
        throws CvqException, CvqObjectNotFoundException, FileNotFoundException, IOException {
        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.FRONT_OFFICE_CONTEXT);
        // create a vo card request (to create home folder and associates)
        CreationBean cb = gimmeAnHomeFolderWithRequest();
        SecurityContext.setCurrentEcitizen(cb.getLogin());
        // get the home folder id
        HomeFolder homeFolder = homeFolderService.getById(cb.getHomeFolderId());
        assertNotNull(homeFolder);
        Long homeFolderId = homeFolder.getId();
        assertNotNull(homeFolderId);
        // fill and create the request
        //////////////////////////////
        HandicapCompensationChildRequest request = fillMeARequest();
        request.setRequesterId(SecurityContext.getCurrentUserId());
        request.setHomeFolderId(homeFolderId);
        HandicapCompensationChildRequestFeeder.setSubject(request, requestService.getSubjectPolicy(), null, homeFolder);
        Long requestId = requestWorkflowService.create(request, null);
        HandicapCompensationChildRequest requestFromDb = (HandicapCompensationChildRequest) requestSearchService.getById(requestId, true);
        assertEquals(requestId, requestFromDb.getId());
        assertNotNull(requestFromDb.getRequesterId());
        assertNotNull(requestFromDb.getRequesterLastName());
        if (requestFromDb.getSubjectId() != null)
            assertNotNull(requestFromDb.getSubjectLastName());
        completeValidateAndDelete(requestFromDb);
        HomeFolder homeFolderAfterDelete = homeFolderService.getById(homeFolderId);
        assertNotNull(homeFolderAfterDelete);
        assertNotNull(homeFolderService.getHomeFolderResponsible(homeFolderAfterDelete.getId()));
    }
    
    @Test
    public void testWithoutHomeFolder()
        throws CvqException, CvqObjectNotFoundException, FileNotFoundException, IOException {
        if (!requestService.supportUnregisteredCreation())
            return;
        startTransaction();
        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.FRONT_OFFICE_CONTEXT);
        HandicapCompensationChildRequest request = fillMeARequest();
        Address address = BusinessObjectsFactory.gimmeAdress("12", "Rue d'Aligre", "Paris", "75012");
        Adult requester = BusinessObjectsFactory.gimmeAdult(TitleType.MISTER, "LASTNAME", "requester", address, FamilyStatusType.MARRIED);
        requester.setPassword("requester");
        requester.setAdress(address);
        homeFolderService.addHomeFolderRole(requester, RoleType.HOME_FOLDER_RESPONSIBLE);
        HandicapCompensationChildRequestFeeder
            .setSubject(request, requestService.getSubjectPolicy(), requester, null);
        Long requestId = requestWorkflowService.create(request, requester, null);
        // close current session and re-open a new one
        continueWithNewTransaction();
        // start testing request creation
        /////////////////////////////////
        HandicapCompensationChildRequest requestFromDb = (HandicapCompensationChildRequest) requestSearchService.getById(requestId, true);
        assertEquals(requestId, requestFromDb.getId());
        assertNotNull(requestFromDb.getRequesterId());
        assertNotNull(requestFromDb.getRequesterLastName());
        if (requestFromDb.getSubjectId() != null)
            assertNotNull(requestFromDb.getSubjectLastName());
        Long homeFolderId = requestFromDb.getHomeFolderId();
        Long requesterId = requestFromDb.getRequesterId();
        // close current session and re-open a new one
        continueWithNewTransaction();
        completeValidateAndDelete(requestFromDb);
        // close current session and re-open a new one
        continueWithNewTransaction();
        try {
            homeFolderService.getById(homeFolderId);
            fail("should not have found home folder");
        } catch (CvqObjectNotFoundException confe) {
            // great, that was expected
        }
        try {
            individualService.getById(requesterId);
            fail("should not have found requester");
        } catch (CvqObjectNotFoundException confe) {
            // great, that was expected
        }
        SecurityContext.resetCurrentSite();
        commitTransaction();
    }
}
