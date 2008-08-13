package fr.cg95.cvq.testtool;

import junit.framework.Test;
import junit.framework.TestSuite;
import fr.cg95.cvq.external.FakeExternalServiceTest;
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
import fr.cg95.cvq.service.leisure.culture.LibraryRegistrationRequestServiceTest;
import fr.cg95.cvq.service.leisure.music.MusicSchoolRegistrationRequestServiceTest;
import fr.cg95.cvq.service.school.PerischoolActivityRegistrationRequestServiceTest;
import fr.cg95.cvq.service.school.RecreationActivityRegistrationRequestServiceTest;
import fr.cg95.cvq.service.school.SchoolCanteenRegistrationRequestServiceTest;
import fr.cg95.cvq.service.school.SchoolRegistrationRequestServiceSeasonsTest;
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

public class CapdematTestSuite extends TestSuite {

    public static Test suite() {
        TestSuite testSuite = new TestSuite();
       
        testSuite.addTestSuite(AgentServiceTest.class);
        testSuite.addTestSuite(CategoryServiceTest.class);
        testSuite.addTestSuite(LocalReferentialServiceTest.class);
        testSuite.addTestSuite(PlaceReservationServiceTest.class);
        
        testSuite.addTestSuite(BirthDetailsRequestServiceTest.class);
        testSuite.addTestSuite(DeathDetailsRequestServiceTest.class);
        testSuite.addTestSuite(MarriageDetailsRequestServiceTest.class);
        testSuite.addTestSuite(PersonalDetailsRequestServiceTest.class);

        testSuite.addTestSuite(VoCardRequestServiceTest.class);
        
        testSuite.addTestSuite(ElectoralRollRegistrationRequestServiceTest.class);

        testSuite.addTestSuite(FakeExternalServiceTest.class);
        
        testSuite.addTestSuite(LibraryRegistrationRequestServiceTest.class);
        
        testSuite.addTestSuite(MusicSchoolRegistrationRequestServiceTest.class);
        
//        testSuite.addTestSuite(PlaceReservationRequestServicePaymentTest.class);
//        testSuite.addTestSuite(PlaceReservationRequestServiceTest.class);
//        testSuite.addTestSuite(PlaceReservationRequestServiceSubscriberTest.class);
        
        testSuite.addTestSuite(PerischoolActivityRegistrationRequestServiceTest.class);
        testSuite.addTestSuite(RecreationActivityRegistrationRequestServiceTest.class);
        testSuite.addTestSuite(SchoolCanteenRegistrationRequestServiceTest.class);
        testSuite.addTestSuite(SchoolRegistrationRequestServiceSeasonsTest.class);
        testSuite.addTestSuite(SchoolRegistrationRequestServiceTest.class);
        
//        testSuite.addTestSuite(VacationsRegistrationRequestServiceTest.class);
       
        testSuite.addTestSuite(DomesticHelpRequestServiceTest.class);
        testSuite.addTestSuite(HandicapAllowanceRequestServiceTest.class);
        testSuite.addTestSuite(RemoteSupportRequestServiceTest.class);
        
        testSuite.addTestSuite(AlignmentCertificateRequestServiceTest.class);
        testSuite.addTestSuite(SewerConnectionRequestServiceTest.class);
        
        testSuite.addTestSuite(DocumentServiceTest.class);
        testSuite.addTestSuite(HomeFolderModificationRequestServiceTest.class);
        
        testSuite.addTestSuite(HomeFolderServiceTest.class);
        testSuite.addTestSuite(MeansOfContactServiceTest.class);
        return testSuite;
    }
}
