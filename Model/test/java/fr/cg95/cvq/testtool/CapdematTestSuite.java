package fr.cg95.cvq.testtool;

import junit.framework.Test;
import junit.framework.TestSuite;
import fr.cg95.cvq.external.ExternalServiceGeneralTest;
import fr.cg95.cvq.external.ExternalServiceIdentifierMappingTest;
import fr.cg95.cvq.external.ExternalServiceInteractionsTest;
import fr.cg95.cvq.external.ExternalServiceTracesTest;
import fr.cg95.cvq.external.FakeExternalServiceTest;
import fr.cg95.cvq.payment.PaymentServiceJobTest;
import fr.cg95.cvq.payment.PaymentServiceTest;
import fr.cg95.cvq.service.authority.AgentServiceTest;
import fr.cg95.cvq.service.request.CategoryServiceTest;
import fr.cg95.cvq.service.document.DocumentServiceTest;
import fr.cg95.cvq.service.request.LocalReferentialServiceTest;
import fr.cg95.cvq.service.request.PlaceReservationServiceTest;
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
import fr.cg95.cvq.service.request.leisure.SmsNotificationRequestServiceTest;
import fr.cg95.cvq.service.request.leisure.culture.LibraryRegistrationRequestServiceTest;
import fr.cg95.cvq.service.request.leisure.music.MusicSchoolRegistrationRequestServiceTest;
import fr.cg95.cvq.service.request.localpolice.HolidaySecurityRequestServiceTest;
import fr.cg95.cvq.service.request.military.MilitaryCensusRequestServiceTest;
import fr.cg95.cvq.service.request.reservation.PlaceReservationRequestServicePaymentTest;
import fr.cg95.cvq.service.request.reservation.PlaceReservationRequestServiceSubscriberTest;
import fr.cg95.cvq.service.request.reservation.PlaceReservationRequestServiceTest;
import fr.cg95.cvq.service.request.school.PerischoolActivityRegistrationRequestServiceTest;
import fr.cg95.cvq.service.request.school.RecreationActivityRegistrationRequestServiceTest;
import fr.cg95.cvq.service.request.school.SchoolCanteenRegistrationRequestServiceTest;
import fr.cg95.cvq.service.request.school.SchoolRegistrationRequestServiceTest;
import fr.cg95.cvq.service.request.social.DomesticHelpRequestServiceTest;
import fr.cg95.cvq.service.request.social.HandicapCompensationAdultRequestServiceTest;
import fr.cg95.cvq.service.request.social.HandicapCompensationChildRequestServiceTest;
import fr.cg95.cvq.service.request.social.RemoteSupportRequestServiceTest;
import fr.cg95.cvq.service.request.urbanism.AlignmentCertificateRequestServiceTest;
import fr.cg95.cvq.service.request.urbanism.SewerConnectionRequestServiceTest;
import fr.cg95.cvq.service.users.HomeFolderModificationRequestServiceTest;
import fr.cg95.cvq.service.users.HomeFolderServiceTest;
import fr.cg95.cvq.service.users.MeansOfContactServiceTest;
import fr.cg95.cvq.service.request.job.RequestSeasonsJobTest;
import fr.cg95.cvq.service.request.job.RequestXmlGenerationJobTest;

public class CapdematTestSuite extends TestSuite {

    public static Test suite() {
        TestSuite testSuite = new TestSuite();
       
        // external package
        testSuite.addTestSuite(ExternalServiceGeneralTest.class);
        testSuite.addTestSuite(ExternalServiceIdentifierMappingTest.class);
        testSuite.addTestSuite(ExternalServiceInteractionsTest.class);
        testSuite.addTestSuite(ExternalServiceTracesTest.class);
        testSuite.addTestSuite(FakeExternalServiceTest.class);
        
        // payment package
        testSuite.addTestSuite(PaymentServiceJobTest.class);
        testSuite.addTestSuite(PaymentServiceTest.class);

        // service.authority package
        testSuite.addTestSuite(AgentServiceTest.class);
        testSuite.addTestSuite(CategoryServiceTest.class);
        testSuite.addTestSuite(LocalReferentialServiceTest.class);
        testSuite.addTestSuite(PlaceReservationServiceTest.class);
        
        // service.civil package
        testSuite.addTestSuite(BirthDetailsRequestServiceTest.class);
        testSuite.addTestSuite(DeathDetailsRequestServiceTest.class);
        testSuite.addTestSuite(MarriageDetailsRequestServiceTest.class);

        // service.ecitizen package
        testSuite.addTestSuite(VoCardRequestServiceTest.class);
        
        // service.election package
        testSuite.addTestSuite(ElectoralRollRegistrationRequestServiceTest.class);

        // service.environment package
        testSuite.addTestSuite(CompostableWasteCollectionRequestServiceTest.class);
        testSuite.addTestSuite(BulkyWasteCollectionRequestServiceTest.class);

        // service.leisure package
        testSuite.addTestSuite(SmsNotificationRequestServiceTest.class);

        // service.leisure.culture package
        testSuite.addTestSuite(LibraryRegistrationRequestServiceTest.class);
        
        // service.leisure.music package
        testSuite.addTestSuite(MusicSchoolRegistrationRequestServiceTest.class);
        
        // service.localpolice package
        testSuite.addTestSuite(HolidaySecurityRequestServiceTest.class);        
        
        // service.military package
        testSuite.addTestSuite(MilitaryCensusRequestServiceTest.class);        
        
        // service.reservation package
        testSuite.addTestSuite(PlaceReservationRequestServicePaymentTest.class);
        testSuite.addTestSuite(PlaceReservationRequestServiceTest.class);
        testSuite.addTestSuite(PlaceReservationRequestServiceSubscriberTest.class);
        
        // service.school package
        testSuite.addTestSuite(PerischoolActivityRegistrationRequestServiceTest.class);
        testSuite.addTestSuite(RecreationActivityRegistrationRequestServiceTest.class);
        testSuite.addTestSuite(SchoolCanteenRegistrationRequestServiceTest.class);
        testSuite.addTestSuite(SchoolRegistrationRequestServiceTest.class);
       
        // service.social package
        testSuite.addTestSuite(DomesticHelpRequestServiceTest.class);
        // test fails (unsaved transient instance)
        testSuite.addTestSuite(HandicapCompensationAdultRequestServiceTest.class);
        testSuite.addTestSuite(HandicapCompensationChildRequestServiceTest.class);
        testSuite.addTestSuite(RemoteSupportRequestServiceTest.class);
        
        // service.urbanism package
        testSuite.addTestSuite(AlignmentCertificateRequestServiceTest.class);
        testSuite.addTestSuite(SewerConnectionRequestServiceTest.class);
        
        // service.users package
        testSuite.addTestSuite(DocumentServiceTest.class);
        testSuite.addTestSuite(HomeFolderModificationRequestServiceTest.class);
        testSuite.addTestSuite(HomeFolderServiceTest.class);
        testSuite.addTestSuite(MeansOfContactServiceTest.class);
        testSuite.addTestSuite(RequestSeasonServiceTest.class);
        testSuite.addTestSuite(RequestServiceTest.class);
        testSuite.addTestSuite(RequestStatisticsServiceTest.class);
        
        // service.users.job package
        testSuite.addTestSuite(RequestSeasonsJobTest.class);
        testSuite.addTestSuite(RequestXmlGenerationJobTest.class);
        
        return testSuite;
    }
}
