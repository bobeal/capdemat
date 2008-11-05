package fr.cg95.cvq.service.request.reservation;

import java.util.List;
import java.util.Map;
import java.util.Set;

import fr.cg95.cvq.business.users.PlaceReservationData;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.exception.CvqObjectNotFoundException;
import fr.cg95.cvq.service.authority.IPlaceReservationService;
import fr.cg95.cvq.service.request.IRequestService;

public interface IPlaceReservationRequestService extends IRequestService {

    public final String SERVICE_NAME = "placeReservationRequestService";

    /**
     * Return the number of places authorized for a given subscriber.
     * 
     * @throws CvqObjectNotFoundException if the given subscriber's number is not found.
     * @return a map of authorized number of places per type of price 
     *                (one of {@link IPlaceReservationService#FULL_PRICE_SUBSCRIBER} 
     *                 or {@link IPlaceReservationService#REDUCED_PRICE_SUBSCRIBER}) 
     */
    Map<String, Integer> getAuthorizedNumberOfPlaces(final String subscriberNumber)
        throws CvqException, CvqObjectNotFoundException;
    
    /**
     * Return whether the given subscriber number exists and is valid.
     */
    boolean isValidSubscriberNumber(final String subscriberNumber)
        throws CvqException;
    
    /**
     * Check that the subscriber with the given number has made a valid reservation 
     * (if he did not choose too many or forbidden reservations).
     * 
     * @fixme always return null since {@link #getAuthorizedNumberOfPlaces(String)} is mocked
     * @return the list of place reservation for which there are errors or null if there are none.
     */
    Set<String> checkPlaceReservationData(final List<PlaceReservationData> placeReservationData, 
            final String subscriberNumber)
        throws CvqException;
}