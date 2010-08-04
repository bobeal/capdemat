package fr.cg95.cvq.service.request.reservation;

import fr.cg95.cvq.business.request.reservation.TicketBookingRequest;
import fr.cg95.cvq.business.users.Adult;
import fr.cg95.cvq.business.users.HomeFolder;
import fr.cg95.cvq.testtool.TestUtils;

public class TicketBookingRequestFeeder {

    public static void feed(TicketBookingRequest request) {
    }
    
    public static void setSubject(TicketBookingRequest request, 
            String subjectPolicy, Adult requester, HomeFolder homeFolder) {

        TestUtils.feedRequestSubject(request, subjectPolicy, requester, homeFolder);
    }
}
