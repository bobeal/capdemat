package fr.cg95.cvq.testtool;

import junit.framework.Test;
import junit.framework.TestSuite;
import fr.cg95.cvq.external.ExternalServiceGeneralTest;
import fr.cg95.cvq.external.ExternalServiceIdentifierMappingTest;
import fr.cg95.cvq.external.ExternalServiceInteractionsTest;
import fr.cg95.cvq.external.ExternalServiceTracesTest;
import fr.cg95.cvq.external.FakeExternalServiceTest;
import fr.cg95.cvq.service.authority.AgentServiceTest;
import fr.cg95.cvq.service.authority.LocalAuthorityRegistryTest;
import fr.cg95.cvq.service.document.DocumentDigitalizationTest;
import fr.cg95.cvq.service.document.DocumentServiceTest;
import fr.cg95.cvq.service.payment.PaymentServiceJobTest;
import fr.cg95.cvq.service.payment.PaymentServiceTest;
import fr.cg95.cvq.service.request.CategoryServiceTest;
import fr.cg95.cvq.service.request.DisplayGroupServiceTest;
import fr.cg95.cvq.service.request.LocalReferentialServiceTest;
import fr.cg95.cvq.service.request.RequestDraftTest;
import fr.cg95.cvq.service.request.RequestExternalServiceTest;
import fr.cg95.cvq.service.request.RequestLockServiceTest;
import fr.cg95.cvq.service.request.RequestSearchServiceTest;
import fr.cg95.cvq.service.request.RequestSeasonServiceTest;
import fr.cg95.cvq.service.request.RequestServiceTest;
import fr.cg95.cvq.service.request.RequestStatisticsServiceTest;
import fr.cg95.cvq.service.request.civil.BirthDetailsRequestServiceTest;
import fr.cg95.cvq.service.request.civil.DeathDetailsRequestServiceTest;
import fr.cg95.cvq.service.request.civil.MarriageDetailsRequestServiceTest;
import fr.cg95.cvq.service.request.ecitizen.VoCardRequestServiceTest;
import fr.cg95.cvq.service.request.election.ElectoralRollRegistrationRequestServiceTest;
import fr.cg95.cvq.service.request.environment.BulkyWasteCollectionRequestServiceTest;
import fr.cg95.cvq.service.request.environment.CompostableWasteCollectionRequestServiceTest;
import fr.cg95.cvq.service.request.job.DraftManagementJobTest;
import fr.cg95.cvq.service.request.job.RequestSeasonsJobTest;
import fr.cg95.cvq.service.request.job.RequestXmlGenerationJobTest;
import fr.cg95.cvq.service.request.leisure.SmsNotificationRequestServiceTest;
import fr.cg95.cvq.service.request.leisure.culture.LibraryRegistrationRequestServiceTest;
import fr.cg95.cvq.service.request.localpolice.HolidaySecurityRequestServiceTest;
import fr.cg95.cvq.service.request.military.MilitaryCensusRequestServiceTest;
import fr.cg95.cvq.service.request.school.PerischoolActivityRegistrationRequestServiceTest;
import fr.cg95.cvq.service.request.school.RecreationActivityRegistrationRequestServiceTest;
import fr.cg95.cvq.service.request.school.SchoolCanteenRegistrationRequestServiceTest;
import fr.cg95.cvq.service.request.school.SchoolRegistrationRequestServiceTest;
import fr.cg95.cvq.service.request.school.StudyGrantRequestServiceTest;
import fr.cg95.cvq.service.request.technical.TechnicalInterventionRequestServiceTest;
import fr.cg95.cvq.service.request.urbanism.AlignmentCertificateRequestServiceTest;
import fr.cg95.cvq.service.request.urbanism.AlignmentNumberingConnectionRequestServiceTest;
import fr.cg95.cvq.service.request.urbanism.SewerConnectionRequestServiceTest;
import fr.cg95.cvq.service.users.HomeFolderServiceTest;
import fr.cg95.cvq.service.users.MeansOfContactServiceTest;

public class CapdematTestSuite extends TestSuite {

    public static Test suite() {
        TestSuite testSuite = new TestSuite();
       
        // service.authority package
        testSuite.addTestSuite(AgentServiceTest.class);
        testSuite.addTestSuite(LocalAuthorityRegistryTest.class);

        // service.users package
        testSuite.addTestSuite(HomeFolderServiceTest.class);
        testSuite.addTestSuite(MeansOfContactServiceTest.class);

        // service.document package
        testSuite.addTestSuite(DocumentServiceTest.class);
        testSuite.addTestSuite(DocumentDigitalizationTest.class);

        // payment package
        testSuite.addTestSuite(PaymentServiceJobTest.class);
        testSuite.addTestSuite(PaymentServiceTest.class);

        // external package
        testSuite.addTestSuite(ExternalServiceGeneralTest.class);
        testSuite.addTestSuite(ExternalServiceIdentifierMappingTest.class);
        testSuite.addTestSuite(ExternalServiceInteractionsTest.class);
        testSuite.addTestSuite(ExternalServiceTracesTest.class);
        testSuite.addTestSuite(FakeExternalServiceTest.class);
        
        // service.request
        testSuite.addTestSuite(CategoryServiceTest.class);
        testSuite.addTestSuite(DisplayGroupServiceTest.class);
        testSuite.addTestSuite(LocalReferentialServiceTest.class);
        testSuite.addTestSuite(RequestDraftTest.class);
        testSuite.addTestSuite(RequestExternalServiceTest.class);
        testSuite.addTestSuite(RequestLockServiceTest.class);
        testSuite.addTestSuite(RequestSearchServiceTest.class);
        testSuite.addTestSuite(RequestSeasonServiceTest.class);
        testSuite.addTestSuite(RequestServiceTest.class);
        testSuite.addTestSuite(RequestStatisticsServiceTest.class);

        // service.request.job package
        testSuite.addTestSuite(RequestSeasonsJobTest.class);
        testSuite.addTestSuite(RequestXmlGenerationJobTest.class);
        testSuite.addTestSuite(DraftManagementJobTest.class);

        // service.request.civil package
        testSuite.addTestSuite(BirthDetailsRequestServiceTest.class);
        testSuite.addTestSuite(DeathDetailsRequestServiceTest.class);
        testSuite.addTestSuite(MarriageDetailsRequestServiceTest.class);

        // service.request.ecitizen package
        testSuite.addTestSuite(VoCardRequestServiceTest.class);
//        testSuite.addTestSuite(HomeFolderModificationRequestServiceTest.class);

        // service.request.election package
        testSuite.addTestSuite(ElectoralRollRegistrationRequestServiceTest.class);

        // service.request.environment package
        testSuite.addTestSuite(CompostableWasteCollectionRequestServiceTest.class);
        testSuite.addTestSuite(BulkyWasteCollectionRequestServiceTest.class);

        // service.request.leisure package
        testSuite.addTestSuite(SmsNotificationRequestServiceTest.class);

        // service.request.leisure.culture package
        testSuite.addTestSuite(LibraryRegistrationRequestServiceTest.class);

        // service.request.leisure.music package
//        testSuite.addTestSuite(MusicSchoolRegistrationRequestServiceTest.class);

        // service.request.localpolice package
        testSuite.addTestSuite(HolidaySecurityRequestServiceTest.class);        

        // service.request.military package
        testSuite.addTestSuite(MilitaryCensusRequestServiceTest.class);        

        // service.request.reservation package
//        testSuite.addTestSuite(PlaceReservationRequestServicePaymentTest.class);
//        testSuite.addTestSuite(PlaceReservationRequestServiceTest.class);
//        testSuite.addTestSuite(PlaceReservationRequestServiceSubscriberTest.class);

        // service.request.school package
        testSuite.addTestSuite(PerischoolActivityRegistrationRequestServiceTest.class);
        testSuite.addTestSuite(RecreationActivityRegistrationRequestServiceTest.class);
        testSuite.addTestSuite(SchoolCanteenRegistrationRequestServiceTest.class);
        testSuite.addTestSuite(SchoolRegistrationRequestServiceTest.class);
        testSuite.addTestSuite(StudyGrantRequestServiceTest.class);

        // service.request.social package
//        testSuite.addTestSuite(DomesticHelpRequestServiceTest.class);
        // test fails (unsaved transient instance)
//        testSuite.addTestSuite(HandicapCompensationAdultRequestServiceTest.class);
//        testSuite.addTestSuite(HandicapCompensationChildRequestServiceTest.class);
//        testSuite.addTestSuite(RemoteSupportRequestServiceTest.class);

        // service.request.technical
        testSuite.addTestSuite(TechnicalInterventionRequestServiceTest.class);

        // service.request.urbanism package
        testSuite.addTestSuite(AlignmentCertificateRequestServiceTest.class);
        testSuite.addTestSuite(SewerConnectionRequestServiceTest.class);
        testSuite.addTestSuite(AlignmentNumberingConnectionRequestServiceTest.class);
        
        return testSuite;
    }
}
