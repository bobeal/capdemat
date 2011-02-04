
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
public class HandicapCompensationAdultRequestServiceTest extends RequestTestCase {
    
    @Resource(name="handicapCompensationAdultRequestService")
    protected IRequestService requestService;

    protected HandicapCompensationAdultRequest fillMeARequest() {
        HandicapCompensationAdultRequest request = new HandicapCompensationAdultRequest();
        
          
          
               request.setHealthFollowedByProfessional(Boolean.valueOf(true));
          
        
          
          
               request.setProfessionalSupportProfessionals(Boolean.valueOf(true));
          
        
          
          
            
            
          
        
          
          
               request.setIsFamilyAssistance(Boolean.valueOf(true));
          
        
          
          
            
              if ("ProjectComments".length() > 600)
                  request.setProjectComments("ProjectComments".substring(0, 600));
              else
                  request.setProjectComments("ProjectComments");
            
          
        
          
          
            
              if ("FoldersMdphDepartment".length() > 2)
                  request.setFoldersMdphDepartment("FoldersMdphDepartment".substring(0, 2));
              else
                  request.setFoldersMdphDepartment("FoldersMdphDepartment");
            
          
        
          
          
               request.setFoldersCdes(Boolean.valueOf(true));
          
        
          
          
            
              if ("ProjectNeeds".length() > 600)
                  request.setProjectNeeds("ProjectNeeds".substring(0, 600));
              else
                  request.setProjectNeeds("ProjectNeeds");
            
          
        
          
          
               request.setBenefitsEducationAllocationOfDisabledChildren(Boolean.valueOf(true));
          
        
          
          
               request.setHomeInterventionHomeIntervenant(Boolean.valueOf(true));
          
        
          
          
            
            
          
        
          
          
            
              if ("FoldersMdphNumber".length() > 30)
                  request.setFoldersMdphNumber("FoldersMdphNumber".substring(0, 30));
              else
                  request.setFoldersMdphNumber("FoldersMdphNumber");
            
          
        
          
          
               request.setProjectRequestsHousingFacilities(Boolean.valueOf(true));
          
        
          
          
               request.setSubjectBirthDate(new Date());
          
        
          
          
               request.setBenefitsDisabilityPension(Boolean.valueOf(true));
          
        
          
          
               request.setLegalAccessPresence(Boolean.valueOf(true));
          
        
          
          
            
              if ("SubjectMaidenName".length() > 38)
                  request.setSubjectMaidenName("SubjectMaidenName".substring(0, 38));
              else
                  request.setSubjectMaidenName("SubjectMaidenName");
            
          
        
          
          
               request.setProjectRequestsDisabledWorkerRecognition(Boolean.valueOf(true));
          
        
          
          
               request.setBenefitsUnemploymentBenefits(Boolean.valueOf(true));
          
        
          
          
            
            
          
        
          
          
            
              request.setProfessionalStatusKind(HcarProfessionalStatusKindType.EMPLOYEE);
            
          
        
          
          
               request.setFamilyFamilyDependents(Boolean.valueOf(true));
          
        
          
          
            
              if ("FormationPreviousFormation".length() > 180)
                  request.setFormationPreviousFormation("FormationPreviousFormation".substring(0, 180));
              else
                  request.setFormationPreviousFormation("FormationPreviousFormation");
            
          
        
          
          
            
              if ("BenefitsEducationOfDisabledChildrenDetails".length() > 60)
                  request.setBenefitsEducationOfDisabledChildrenDetails("BenefitsEducationOfDisabledChildrenDetails".substring(0, 60));
              else
                  request.setBenefitsEducationOfDisabledChildrenDetails("BenefitsEducationOfDisabledChildrenDetails");
            
          
        
          
          
               request.setProjectRequestsVocationalTraining(Boolean.valueOf(true));
          
        
          
          
               request.setFacilitiesCustomCar(Boolean.valueOf(true));
          
        
          
          
            
              if ("LegalAccessRepresentativeKindDetail".length() > 80)
                  request.setLegalAccessRepresentativeKindDetail("LegalAccessRepresentativeKindDetail".substring(0, 80));
              else
                  request.setLegalAccessRepresentativeKindDetail("LegalAccessRepresentativeKindDetail");
            
          
        
          
          
               request.setProfessionalStatusIndemnified(Boolean.valueOf(true));
          
        
          
          
               request.setBenefitsDisabledAdultAllocation(Boolean.valueOf(true));
          
        
          
          
               request.setBenefitsThirdPartyCompensatoryAllowance(Boolean.valueOf(true));
          
        
          
          
               request.setProfessionalStatusDate(new Date());
          
        
          
          
               request.setProjectRequestsTransportCostAllocation(Boolean.valueOf(true));
          
        
          
          
               request.setBenefitsProfessionalOrientation(Boolean.valueOf(true));
          
        
          
          
               request.setBenefitsDisabilityRecognition(Boolean.valueOf(true));
          
        
          
          
               request.setProfessionalStatusRegisterAsUnemployed(Boolean.valueOf(true));
          
        
          
          
            
              if ("DwellingSocialReceptionNaming".length() > 80)
                  request.setDwellingSocialReceptionNaming("DwellingSocialReceptionNaming".substring(0, 80));
              else
                  request.setDwellingSocialReceptionNaming("DwellingSocialReceptionNaming");
            
          
        
          
          
               request.setProfessionalStatusIndemnifiedDate(new Date());
          
        
          
          
            
              request.setFamilyStatus(FamilyStatusType.MARRIED);
            
          
        
          
          
               request.setBenefitsPainfulStandingCard(Boolean.valueOf(true));
          
        
          
          
            
              if ("BenefitsProfessionalOrientationDetails".length() > 60)
                  request.setBenefitsProfessionalOrientationDetails("BenefitsProfessionalOrientationDetails".substring(0, 60));
              else
                  request.setBenefitsProfessionalOrientationDetails("BenefitsProfessionalOrientationDetails");
            
          
        
          
          
            
              if ("FoldersCdesDepartment".length() > 2)
                  request.setFoldersCdesDepartment("FoldersCdesDepartment".substring(0, 2));
              else
                  request.setFoldersCdesDepartment("FoldersCdesDepartment");
            
          
        
          
          
               request.setFacilitiesSpecializedTransport(Boolean.valueOf(true));
          
        
          
          
               request.setBenefitsParkingCard(Boolean.valueOf(true));
          
        
          
          
            
              if ("FacilitiesSpecializedTransportDetails".length() > 60)
                  request.setFacilitiesSpecializedTransportDetails("FacilitiesSpecializedTransportDetails".substring(0, 60));
              else
                  request.setFacilitiesSpecializedTransportDetails("FacilitiesSpecializedTransportDetails");
            
          
        
          
          
               request.setProfessionalSupportSocialServiceSupport(Boolean.valueOf(true));
          
        
          
          
            
                  if ("SocialSecurityNumber".length() > 13)
                      request.setSocialSecurityNumber("SocialSecurityNumber".substring(0, 13));
                  else
                      request.setSocialSecurityNumber("SocialSecurityNumber");
            
          
        
          
          
            
              if ("BenefitsWorkAccidentAnnuityRatio".length() > 3)
                  request.setBenefitsWorkAccidentAnnuityRatio("BenefitsWorkAccidentAnnuityRatio".substring(0, 3));
              else
                  request.setBenefitsWorkAccidentAnnuityRatio("BenefitsWorkAccidentAnnuityRatio");
            
          
        
          
          
               request.setBenefitsWorkAccidentAnnuity(Boolean.valueOf(true));
          
        
          
          
               request.setCareCareServices(Boolean.valueOf(true));
          
        
          
          
            
              if ("BenefitsDisabilityRatio".length() > 3)
                  request.setBenefitsDisabilityRatio("BenefitsDisabilityRatio".substring(0, 3));
              else
                  request.setBenefitsDisabilityRatio("BenefitsDisabilityRatio");
            
          
        
          
          
               request.setBenefitsDailyAllowances(Boolean.valueOf(true));
          
        
          
          
               request.setProjectRequestsCustomCar(Boolean.valueOf(true));
          
        
          
          
            
              if ("PaymentAgencyBeneficiaryNumber".length() > 20)
                  request.setPaymentAgencyBeneficiaryNumber("PaymentAgencyBeneficiaryNumber".substring(0, 20));
              else
                  request.setPaymentAgencyBeneficiaryNumber("PaymentAgencyBeneficiaryNumber");
            
          
        
          
          
            
              if ("FoldersCotorepNumber".length() > 30)
                  request.setFoldersCotorepNumber("FoldersCotorepNumber".substring(0, 30));
              else
                  request.setFoldersCotorepNumber("FoldersCotorepNumber");
            
          
        
          
          
               request.setProjectRequestsACTPRenewal(Boolean.valueOf(true));
          
        
          
          
            
            
              
                request.setDwellingSocialReceptionAddress(BusinessObjectsFactory.gimmeAddress("1", "Unit test address", "Paris", "75012"));
              
            
          
        
          
          
               request.setFoldersMdph(Boolean.valueOf(true));
          
        
          
          
            
              if ("BenefitsSupportedByAnInstitutionDetails".length() > 60)
                  request.setBenefitsSupportedByAnInstitutionDetails("BenefitsSupportedByAnInstitutionDetails".substring(0, 60));
              else
                  request.setBenefitsSupportedByAnInstitutionDetails("BenefitsSupportedByAnInstitutionDetails");
            
          
        
          
          
               request.setProfessionalSupportDealsWithSameProfessional(Boolean.valueOf(true));
          
        
          
          
               request.setDwellingEstablishmentReception(Boolean.valueOf(true));
          
        
          
          
            
              if ("FoldersCotorepDepartment".length() > 2)
                  request.setFoldersCotorepDepartment("FoldersCotorepDepartment".substring(0, 2));
              else
                  request.setFoldersCotorepDepartment("FoldersCotorepDepartment");
            
          
        
          
          
            
            
          
        
          
          
               request.setProjectRequestsOrdinaryWorking(Boolean.valueOf(true));
          
        
          
          
            
              if ("LegalAccessRepresentativeFirstName".length() > 38)
                  request.setLegalAccessRepresentativeFirstName("LegalAccessRepresentativeFirstName".substring(0, 38));
              else
                  request.setLegalAccessRepresentativeFirstName("LegalAccessRepresentativeFirstName");
            
          
        
          
          
               request.setDwellingSocialReception(Boolean.valueOf(true));
          
        
          
          
               request.setBenefitsDisabledWorkerRecognition(Boolean.valueOf(true));
          
        
          
          
               request.setProjectRequestsEuropeanParkingCard(Boolean.valueOf(true));
          
        
          
          
               request.setHealthFollowedByDoctor(Boolean.valueOf(true));
          
        
          
          
            
            
          
        
          
          
               request.setProjectRequestsFreePensionMembership(Boolean.valueOf(true));
          
        
          
          
            
            
          
        
          
          
               request.setHealthFollowedByHospital(Boolean.valueOf(true));
          
        
          
          
            
              if ("ProfessionalStatusEmployerName".length() > 38)
                  request.setProfessionalStatusEmployerName("ProfessionalStatusEmployerName".substring(0, 38));
              else
                  request.setProfessionalStatusEmployerName("ProfessionalStatusEmployerName");
            
          
        
          
          
               request.setProjectRequestsInstitutionSupport(Boolean.valueOf(true));
          
        
          
          
               request.setBenefitsSocialWelfare(Boolean.valueOf(true));
          
        
          
          
               request.setProjectRequestsHandicapRecognition(Boolean.valueOf(true));
          
        
          
          
            
            
          
        
          
          
            
              if ("ProjectWish".length() > 600)
                  request.setProjectWish("ProjectWish".substring(0, 600));
              else
                  request.setProjectWish("ProjectWish");
            
          
        
          
          
            
              request.setDwellingKind(HcarDwellingKindType.PLACE_OF_RESIDENCE);
            
          
        
          
          
            
              if ("HealthProfessionalLastName".length() > 38)
                  request.setHealthProfessionalLastName("HealthProfessionalLastName".substring(0, 38));
              else
                  request.setHealthProfessionalLastName("HealthProfessionalLastName");
            
          
        
          
          
            
              if ("FormationStudiesLevel".length() > 30)
                  request.setFormationStudiesLevel("FormationStudiesLevel".substring(0, 30));
              else
                  request.setFormationStudiesLevel("FormationStudiesLevel");
            
          
        
          
          
               request.setProjectRequestsProfessionalOrientation(Boolean.valueOf(true));
          
        
          
          
            
              if ("HealthDoctorLastName".length() > 38)
                  request.setHealthDoctorLastName("HealthDoctorLastName".substring(0, 38));
              else
                  request.setHealthDoctorLastName("HealthDoctorLastName");
            
          
        
          
          
            
              request.setLegalAccessKind(HcarLegalAccessKindType.SAFEGUARDING_JUSTICE);
            
          
        
          
          
            
              if ("FacilitiesHousingDetails".length() > 60)
                  request.setFacilitiesHousingDetails("FacilitiesHousingDetails".substring(0, 60));
              else
                  request.setFacilitiesHousingDetails("FacilitiesHousingDetails");
            
          
        
          
          
               request.setBenefitsSupplementForSingleParents(Boolean.valueOf(true));
          
        
          
          
               request.setProjectRequestsIncreaseForIndependentLiving(Boolean.valueOf(true));
          
        
          
          
            
              if ("BenefitsDisabilityPensionCategory".length() > 60)
                  request.setBenefitsDisabilityPensionCategory("BenefitsDisabilityPensionCategory".substring(0, 60));
              else
                  request.setBenefitsDisabilityPensionCategory("BenefitsDisabilityPensionCategory");
            
          
        
          
          
               request.setBenefitsThirdPartySupplement(Boolean.valueOf(true));
          
        
          
          
            
              if ("StudiesHighSchoolGrade".length() > 60)
                  request.setStudiesHighSchoolGrade("StudiesHighSchoolGrade".substring(0, 60));
              else
                  request.setStudiesHighSchoolGrade("StudiesHighSchoolGrade");
            
          
        
          
          
            
              if ("SubjectBirthCity".length() > 32)
                  request.setSubjectBirthCity("SubjectBirthCity".substring(0, 32));
              else
                  request.setSubjectBirthCity("SubjectBirthCity");
            
          
        
          
          
            
              if ("LegalAccessRepresentativeName".length() > 38)
                  request.setLegalAccessRepresentativeName("LegalAccessRepresentativeName".substring(0, 38));
              else
                  request.setLegalAccessRepresentativeName("LegalAccessRepresentativeName");
            
          
        
          
          
               request.setProjectRequestsAssistance(Boolean.valueOf(true));
          
        
          
          
            
              request.setProfessionalStatusEnvironment(HcarProfessionalStatusEnvironmentType.ORDINARY);
            
          
        
          
          
               request.setBenefitsSupportedByAnInstitution(Boolean.valueOf(true));
          
        
          
          
               request.setProjectRequestsThirdPartyHelp(Boolean.valueOf(true));
          
        
          
          
               request.setProjectRequestsDisabledAdultAllowance(Boolean.valueOf(true));
          
        
          
          
            
              request.setPaymentAgencyBeneficiary(HcarPaymentAgencyBeneficiaryType.C_A_F);
            
          
        
          
          
               request.setFoldersOtherFolders(Boolean.valueOf(true));
          
        
          
          
            
              if ("FacilitiesAnimalAidDetails".length() > 60)
                  request.setFacilitiesAnimalAidDetails("FacilitiesAnimalAidDetails".substring(0, 60));
              else
                  request.setFacilitiesAnimalAidDetails("FacilitiesAnimalAidDetails");
            
          
        
          
          
            
              if ("StudiesAssistanceUnderDisabilityDetails".length() > 60)
                  request.setStudiesAssistanceUnderDisabilityDetails("StudiesAssistanceUnderDisabilityDetails".substring(0, 60));
              else
                  request.setStudiesAssistanceUnderDisabilityDetails("StudiesAssistanceUnderDisabilityDetails");
            
          
        
          
          
            
            
          
        
          
          
            
            
              
                request.setPaymentAgencyAddress(BusinessObjectsFactory.gimmeAddress("1", "Unit test address", "Paris", "75012"));
              
            
          
        
          
          
               request.setProjectRequestsOther(Boolean.valueOf(true));
          
        
          
          
               request.setBenefitsThirdPersonCompensatoryAllowance(Boolean.valueOf(true));
          
        
          
          
               request.setProjectRequestsDisabilityCostAllocation(Boolean.valueOf(true));
          
        
          
          
            
            
              
                request.setSocialSecurityAgencyAddress(BusinessObjectsFactory.gimmeAddress("1", "Unit test address", "Paris", "75012"));
              
            
          
        
          
          
            
            
              
                request.setDwellingReceptionAddress(BusinessObjectsFactory.gimmeAddress("1", "Unit test address", "Paris", "75012"));
              
            
          
        
          
          
            
              if ("ProfessionalStatusProfession".length() > 60)
                  request.setProfessionalStatusProfession("ProfessionalStatusProfession".substring(0, 60));
              else
                  request.setProfessionalStatusProfession("ProfessionalStatusProfession");
            
          
        
          
          
            
            
              
                request.setProfessionalStatusAddress(BusinessObjectsFactory.gimmeAddress("1", "Unit test address", "Paris", "75012"));
              
            
          
        
          
          
            
              if ("FormationDiploma".length() > 120)
                  request.setFormationDiploma("FormationDiploma".substring(0, 120));
              else
                  request.setFormationDiploma("FormationDiploma");
            
          
        
          
          
            
              request.setSubjectTitle(TitleType.MISTER);
            
          
        
          
          
               request.setProfessionalStatusElectiveFunction(Boolean.valueOf(true));
          
        
          
          
               request.setFoldersCotorep(Boolean.valueOf(true));
          
        
          
          
               request.setBenefitsIncreaseForIndependentLiving(Boolean.valueOf(true));
          
        
          
          
            
              if ("SubjectBirthCountry".length() > 50)
                  request.setSubjectBirthCountry("SubjectBirthCountry".substring(0, 50));
              else
                  request.setSubjectBirthCountry("SubjectBirthCountry");
            
          
        
          
          
               request.setProjectRequestsDisabilityCard(Boolean.valueOf(true));
          
        
          
          
            
              if ("StudiesHighSchoolName".length() > 60)
                  request.setStudiesHighSchoolName("StudiesHighSchoolName".substring(0, 60));
              else
                  request.setStudiesHighSchoolName("StudiesHighSchoolName");
            
          
        
          
          
            
              request.setDwellingReceptionType(HcarDwellingReceptionKindType.INTERNSHIP);
            
          
        
          
          
               request.setProfessionalStatusRegisterAsUnemployedDate(new Date());
          
        
          
          
            
              if ("PaymentAgencyName".length() > 50)
                  request.setPaymentAgencyName("PaymentAgencyName".substring(0, 50));
              else
                  request.setPaymentAgencyName("PaymentAgencyName");
            
          
        
          
          
            
              if ("DwellingReceptionNaming".length() > 80)
                  request.setDwellingReceptionNaming("DwellingReceptionNaming".substring(0, 80));
              else
                  request.setDwellingReceptionNaming("DwellingReceptionNaming");
            
          
        
          
          
            
              if ("SocialSecurityAgencyName".length() > 50)
                  request.setSocialSecurityAgencyName("SocialSecurityAgencyName".substring(0, 50));
              else
                  request.setSocialSecurityAgencyName("SocialSecurityAgencyName");
            
          
        
          
          
               request.setBenefitsEducationOfDisabledChildren(Boolean.valueOf(true));
          
        
          
          
            
              if ("FacilitiesTechnicalAssistanceDetails".length() > 60)
                  request.setFacilitiesTechnicalAssistanceDetails("FacilitiesTechnicalAssistanceDetails".substring(0, 60));
              else
                  request.setFacilitiesTechnicalAssistanceDetails("FacilitiesTechnicalAssistanceDetails");
            
          
        
          
          
               request.setBenefitsOtherBenefits(Boolean.valueOf(true));
          
        
          
          
            
              if ("FoldersCdesNumber".length() > 30)
                  request.setFoldersCdesNumber("FoldersCdesNumber".substring(0, 30));
              else
                  request.setFoldersCdesNumber("FoldersCdesNumber");
            
          
        
          
          
               request.setBenefitsDisabilityCompensation(Boolean.valueOf(true));
          
        
          
          
            
              if ("HealthDoctorFirstName".length() > 38)
                  request.setHealthDoctorFirstName("HealthDoctorFirstName".substring(0, 38));
              else
                  request.setHealthDoctorFirstName("HealthDoctorFirstName");
            
          
        
          
          
               request.setProjectRequestsTechnicalHelp(Boolean.valueOf(true));
          
        
          
          
               request.setFacilitiesTechnicalAssistance(Boolean.valueOf(true));
          
        
          
          
               request.setBenefitsCompensatoryAllowanceForExpenses(Boolean.valueOf(true));
          
        
          
          
               request.setFacilitiesHousing(Boolean.valueOf(true));
          
        
          
          
            
              if ("HealthHospitalName".length() > 60)
                  request.setHealthHospitalName("HealthHospitalName".substring(0, 60));
              else
                  request.setHealthHospitalName("HealthHospitalName");
            
          
        
          
          
               request.setProjectRequestsDisabledPriorityCard(Boolean.valueOf(true));
          
        
          
          
               request.setProjectRequestsEducationAllocationOfDisabledChildren(Boolean.valueOf(true));
          
        
          
          
            
              if ("ProjectRequestsOtherDetails".length() > 60)
                  request.setProjectRequestsOtherDetails("ProjectRequestsOtherDetails".substring(0, 60));
              else
                  request.setProjectRequestsOtherDetails("ProjectRequestsOtherDetails");
            
          
        
          
          
            
              request.setLegalAccessRepresentativeKind(HcarLegalAccessRepresentativeKindType.FAMILY_MEMBER);
            
          
        
          
          
               request.setProjectRequestsShelteredWork(Boolean.valueOf(true));
          
        
          
          
            
              if ("FormationCurrentFormation".length() > 120)
                  request.setFormationCurrentFormation("FormationCurrentFormation".substring(0, 120));
              else
                  request.setFormationCurrentFormation("FormationCurrentFormation");
            
          
        
          
          
               request.setStudiesAssistanceUnderDisability(Boolean.valueOf(true));
          
        
          
          
            
            
              
                request.setProfessionalSupportSocialServiceAddress(BusinessObjectsFactory.gimmeAddress("1", "Unit test address", "Paris", "75012"));
              
            
          
        
          
          
               request.setStudiesHighSchool(Boolean.valueOf(true));
          
        
          
          
            
              if ("HealthProfessionalFirstName".length() > 38)
                  request.setHealthProfessionalFirstName("HealthProfessionalFirstName".substring(0, 38));
              else
                  request.setHealthProfessionalFirstName("HealthProfessionalFirstName");
            
          
        
          
          
            
              if ("ProfessionalSupportSocialServiceName".length() > 60)
                  request.setProfessionalSupportSocialServiceName("ProfessionalSupportSocialServiceName".substring(0, 60));
              else
                  request.setProfessionalSupportSocialServiceName("ProfessionalSupportSocialServiceName");
            
          
        
          
          
            
              if ("FacilitiesCustomCarDetails".length() > 60)
                  request.setFacilitiesCustomCarDetails("FacilitiesCustomCarDetails".substring(0, 60));
              else
                  request.setFacilitiesCustomCarDetails("FacilitiesCustomCarDetails");
            
          
        
          
          
            
              if ("DwellingPrecision".length() > 120)
                  request.setDwellingPrecision("DwellingPrecision".substring(0, 120));
              else
                  request.setDwellingPrecision("DwellingPrecision");
            
          
        
          
          
               request.setBenefitsDisabilityCard(Boolean.valueOf(true));
          
        
          
          
            
              request.setSocialSecurityMemberShipKind(HcarSocialSecurityMemberShipKindType.INSURED);
            
          
        
          
          
            
              if ("ProfessionalStatusElectiveFunctionDetails".length() > 60)
                  request.setProfessionalStatusElectiveFunctionDetails("ProfessionalStatusElectiveFunctionDetails".substring(0, 60));
              else
                  request.setProfessionalStatusElectiveFunctionDetails("ProfessionalStatusElectiveFunctionDetails");
            
          
        
          
          
               request.setFacilitiesAnimalAid(Boolean.valueOf(true));
          
        
          
          
            
            
              
                request.setStudiesHighSchoolAddress(BusinessObjectsFactory.gimmeAddress("1", "Unit test address", "Paris", "75012"));
              
            
          
        
        // Means Of Contact
        MeansOfContact meansOfContact = meansOfContactService.getMeansOfContactByType(MeansOfContactEnum.EMAIL);
        request.setMeansOfContact(meansOfContact);
        HandicapCompensationAdultRequestFeeder.feed(request);
        return request;
    }

    protected void completeValidateAndDelete(HandicapCompensationAdultRequest request)
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
        HandicapCompensationAdultRequest request = fillMeARequest();
        request.setRequesterId(SecurityContext.getCurrentUserId());
        request.setHomeFolderId(homeFolderId);
        HandicapCompensationAdultRequestFeeder.setSubject(request, requestService.getSubjectPolicy(), null, homeFolder);
        Long requestId = requestWorkflowService.create(request, null);
        HandicapCompensationAdultRequest requestFromDb = (HandicapCompensationAdultRequest) requestSearchService.getById(requestId, true);
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
        HandicapCompensationAdultRequest request = fillMeARequest();
        Address address = BusinessObjectsFactory.gimmeAddress("12", "Rue d'Aligre", "Paris", "75012");
        Adult requester = BusinessObjectsFactory.gimmeAdult(TitleType.MISTER, "LASTNAME", "requester", address, FamilyStatusType.MARRIED);
        requester.setPassword("requester");
        requester.setAddress(address);
        homeFolderService.addHomeFolderRole(requester, RoleType.HOME_FOLDER_RESPONSIBLE);
        HandicapCompensationAdultRequestFeeder
            .setSubject(request, requestService.getSubjectPolicy(), requester, null);
        Long requestId = requestWorkflowService.create(request, requester, null);
        // close current session and re-open a new one
        continueWithNewTransaction();
        // start testing request creation
        /////////////////////////////////
        HandicapCompensationAdultRequest requestFromDb = (HandicapCompensationAdultRequest) requestSearchService.getById(requestId, true);
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
