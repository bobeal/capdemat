package fr.cg95.cvq.service.request.reservation;

import fr.cg95.cvq.business.request.reservation.TicketBookingRequest;
import fr.cg95.cvq.exception.CvqTicketBookingException;
import fr.cg95.cvq.service.payment.IRequestPaymentService;
import fr.cg95.cvq.service.request.IRequestService;

public interface ITicketBookingRequestService extends IRequestService, IRequestPaymentService {

    void reserve(TicketBookingRequest request, String placeNumber, Long fareId,
            Long placeCategoryId, Long eventId) throws CvqTicketBookingException;
    
    void free(TicketBookingRequest request, int ticketIndex);

    void switchSubscriberMode(TicketBookingRequest request, boolean isSubscriber, String number, 
            String firstName, String lastName) throws CvqTicketBookingException;

    void freeAllBookedPlaces(String placeCategoriesAndBookedPlaces);
}
