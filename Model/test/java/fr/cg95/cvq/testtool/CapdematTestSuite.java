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
import fr.cg95.cvq.service.authority.CategoryServiceTest;
import fr.cg95.cvq.service.authority.LocalReferentialServiceTest;
import fr.cg95.cvq.service.authority.PlaceReservationServiceTest;
import fr.cg95.cvq.service.civil.BirthDetailsRequestServiceTest;
import fr.cg95.cvq.service.civil.DeathDetailsRequestServiceTest;
import fr.cg95.cvq.service.civil.MarriageDetailsRequestServiceTest;
import fr.cg95.cvq.service.civil.PersonalDetailsRequestServiceTest;
import fr.cg95.cvq.service.ecitizen.VoCardRequestServiceTest;
import fr.cg95.cvq.service.election.ElectoralRollRegistrationRequestServiceTest;
import fr.cg95.cvq.service.environment.BulkyWasteCollectionRequestServiceTest;
import fr.cg95.cvq.service.environment.CompostableWasteCollectionRequestServiceTest;
import fr.cg95.cvq.service.leisure.SmsNotificationRequestServiceTest;
import fr.cg95.cvq.service.leisure.culture.LibraryRegistrationRequestServiceTest;
import fr.cg95.cvq.service.leisure.music.MusicSchoolRegistrationRequestServiceTest;
import fr.cg95.cvq.service.localpolice.HolidaySecurityRequestServiceTest;
import fr.cg95.cvq.service.military.MilitaryCensusRequestServiceTest;
import fr.cg95.cvq.service.reservation.PlaceReservationRequestServicePaymentTest;
import fr.cg95.cvq.service.reservation.PlaceReservationRequestServiceSubscriberTest;
import fr.cg95.cvq.service.reservation.PlaceReservationRequestServiceTest;
import fr.cg95.cvq.service.school.PerischoolActivityRegistrationRequestServiceTest;
import fr.cg95.cvq.service.school.RecreationActivityRegistrationRequestServiceTest;
import fr.cg95.cvq.service.school.SchoolCanteenRegistrationRequestServiceTest;
import fr.cg95.cvq.service.school.SchoolRegistrationRequestServiceTest;
import fr.cg95.cvq.service.social.DomesticHelpRequestServiceTest;
import fr.cg95.cvq.service.social.HandicapAllowanceRequestServiceTest;
import fr.cg95.cvq.service.social.RemoteSupportRequestServiceTest;
import fr.cg95.cvq.service.urbanism.AlignmentCertificateRequestServiceTest;
import fr.cg95.cvq.service.urbanism.SewerConnectionRequestServiceTest;
import fr.cg95.cvq.service.users.DocumentServiceTest;
import fr.cg95.cvq.service.users.HomeFolderModificationRequestServiceTest;
import fr.cg95.cvq.service.users.HomeFolderServiceTest;
import fr.cg95.cvq.service.users.MeansOfContactServiceTest;
import fr.cg95.cvq.service.users.RequestSeasonServiceTest;
import fr.cg95.cvq.service.users.RequestServiceTest;
import fr.cg95.cvq.service.users.RequestStatisticsServiceTest;
import fr.cg95.cvq.service.users.job.RequestSeasonsJobTest;
import fr.cg95.cvq.service.users.job.RequestXmlGenerationJobTest;

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
        testSuite.addTestSuite(PersonalDetailsRequestServiceTest.class);

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
//        testSuite.addTestSuite(VacationsRegistrationRequestServiceTest.class);
       
        // service.social package
        testSuite.addTestSuite(DomesticHelpRequestServiceTest.class);
        testSuite.addTestSuite(HandicapAllowanceRequestServiceTest.class);
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
