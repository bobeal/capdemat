package fr.capwebct.capdemat.plugins.externalservices.edemande.service;

import java.util.Date;

import org.apache.commons.lang.StringUtils;

import fr.cg95.cvq.business.document.Document;
import fr.cg95.cvq.business.request.MeansOfContact;
import fr.cg95.cvq.business.request.MeansOfContactEnum;
import fr.cg95.cvq.business.request.school.ALevelsType;
import fr.cg95.cvq.business.request.school.CurrentStudiesLevelType;
import fr.cg95.cvq.business.request.school.CurrentStudiesType;
import fr.cg95.cvq.business.request.school.DistanceType;
import fr.cg95.cvq.business.request.school.StudyGrantRequest;
import fr.cg95.cvq.business.users.Address;
import fr.cg95.cvq.business.users.CountryType;
import fr.cg95.cvq.business.users.CreationBean;
import fr.cg95.cvq.business.users.HomeFolder;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.external.IExternalProviderService;
import fr.cg95.cvq.security.SecurityContext;
import fr.cg95.cvq.service.document.IDocumentTypeService;
import fr.cg95.cvq.service.request.school.IStudyGrantRequestService;
import fr.cg95.cvq.service.request.school.StudyGrantRequestFeeder;
import fr.cg95.cvq.testtool.BusinessObjectsFactory;
import fr.cg95.cvq.testtool.ServiceTestCase;

public class EdemandeServiceTest extends ServiceTestCase {

    private IExternalProviderService externalProviderService;
    protected IStudyGrantRequestService iStudyGrantRequestService;

    protected void onSetUp() throws Exception {
        super.onSetUp();
        externalProviderService = getApplicationBean("edemandeExternalService");
        iStudyGrantRequestService = 
            (IStudyGrantRequestService) getBean(StringUtils.uncapitalize("StudyGrantRequest") + "Service");
    }

    protected StudyGrantRequest fillMeARequest() throws CvqException {

        StudyGrantRequest request = new StudyGrantRequest();
          request.setSubjectBirthDate(new Date());
              if ("CurrentSchoolCity".length() > 32)
        request.setCurrentSchoolCity("CurrentSchoolCity".substring(0, 32));
      else
        request.setCurrentSchoolCity("CurrentSchoolCity");
                    request.setSubjectEmail("SubjectEmail");
                  if ("TaxHouseholdCity".length() > 32)
        request.setTaxHouseholdCity("TaxHouseholdCity".substring(0, 32));
      else
        request.setTaxHouseholdCity("TaxHouseholdCity");
                  if ("TaxHouseholdPostalCode".length() > 5)
        request.setTaxHouseholdPostalCode("TaxHouseholdPostalCode".substring(0, 5));
      else
        request.setTaxHouseholdPostalCode("TaxHouseholdPostalCode");
                request.setHasOtherHelp(Boolean.valueOf(true));
              if ("SubjectPhone".length() > 10)
        request.setSubjectPhone("SubjectPhone".substring(0, 10));
      else
        request.setSubjectPhone("SubjectPhone");
                  request.setCurrentStudies(CurrentStudiesType.LICENCE);
                  if ("AlevelsDate".length() > 4)
        request.setAlevelsDate("AlevelsDate".substring(0, 4));
      else
        request.setAlevelsDate("AlevelsDate");
        request.setCounterCode("00030");
                    request.setCurrentSchoolName("CurrentSchoolName");
                  request.setAbroadInternshipSchoolCountry(CountryType.UNKNOWN);
                  if ("TaxHouseholdLastName".length() > 38)
        request.setTaxHouseholdLastName("TaxHouseholdLastName".substring(0, 38));
      else
        request.setTaxHouseholdLastName("TaxHouseholdLastName");
                    request.setAbroadInternshipSchoolName("AbroadInternshipSchoolName");
                  
        request.setAccountKey("97");
                request.setHasRegionalCouncilHelp(Boolean.valueOf(true));
              request.setCurrentStudiesLevel(CurrentStudiesLevelType.FIRST_YEAR);
                  if ("CurrentSchoolPostalCode".length() > 5)
        request.setCurrentSchoolPostalCode("CurrentSchoolPostalCode".substring(0, 5));
      else
        request.setCurrentSchoolPostalCode("CurrentSchoolPostalCode");
                request.setAbroadInternshipStartDate(new Date());
            request.setHasCROUSHelp(Boolean.valueOf(true));
              
        request.setAccountNumber("70011077234");
                  request.setDistance(DistanceType.LESS_THAN30KMS);
                  request.setAlevels(ALevelsType.ES);
                  if ("SubjectMobilePhone".length() > 10)
        request.setSubjectMobilePhone("SubjectMobilePhone".substring(0, 10));
      else
        request.setSubjectMobilePhone("SubjectMobilePhone");
                    request.setOtherStudiesLabel("OtherStudiesLabel");
                    request.setCurrentSchoolCountry(CountryType.UNKNOWN);
                                Address SubjectAddress = BusinessObjectsFactory.gimmeAdress("1", "Unit test address", "Paris", "75012");
            request.setSubjectAddress(SubjectAddress);
                        request.setAbroadInternshipEndDate(new Date());
            request.setHasEuropeHelp(Boolean.valueOf(true));
              if ("TaxHouseholdFirstName".length() > 38)
        request.setTaxHouseholdFirstName("TaxHouseholdFirstName".substring(0, 38));
      else
        request.setTaxHouseholdFirstName("TaxHouseholdFirstName");
                  
        request.setBankCode("14806");
                request.setSandwichCourses(Boolean.valueOf(true));
            request.setAbroadInternship(Boolean.valueOf(true));
  
        // Means Of Contact
        MeansOfContact meansOfContact = iMeansOfContactService.getMeansOfContactByType(
                    MeansOfContactEnum.EMAIL);
        request.setMeansOfContact(meansOfContact);
        
        StudyGrantRequestFeeder.feed(request);
        
        return request;
    }

    public void testChargerTypeDemande() throws Exception {
        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.FRONT_OFFICE_CONTEXT);

        // create a vo card request (to create home folder and associates)
        CreationBean cb = gimmeAnHomeFolder();

        SecurityContext.setCurrentEcitizen(cb.getLogin());

        // get the home folder id
        HomeFolder homeFolder = iHomeFolderService.getById(cb.getHomeFolderId());
        assertNotNull(homeFolder);
        Long homeFolderId = homeFolder.getId();
        assertNotNull(homeFolderId);

        // fill and create the request
        //////////////////////////////

        StudyGrantRequest request = fillMeARequest();
        request.setRequesterId(SecurityContext.getCurrentUserId());
        request.setHomeFolderId(homeFolderId);
        StudyGrantRequestFeeder.setSubject(request, 
            iStudyGrantRequestService.getSubjectPolicy(), null, homeFolder);
        Document document = new Document();
        document.setDocumentType(iDocumentTypeService.getDocumentTypeByType(IDocumentTypeService.SCHOOL_CERTIFICATE_TYPE));
        document.setHomeFolderId(homeFolderId);
        document.setIndividualId(request.getSubjectId());
        Long documentId = iDocumentService.create(document);
        //DocumentBinary documentBinary = new DocumentBinary();
        //File file = getResourceFile("zenexity.png");
        //byte[] data = new byte[(int) file.length()];
        //FileInputStream fis = new FileInputStream(file);
        //fis.read(data);
        //documentBinary.setData(data);
        //iDocumentService.addPage(documentId, documentBinary);
        //document.setDatas(null);
        Long requestId =
            iStudyGrantRequestService.create(request);
        iStudyGrantRequestService.addDocument(requestId, documentId);
        externalProviderService.sendRequest(iRequestService.fillRequestXml(request));
    }
}

