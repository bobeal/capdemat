package fr.cg95.cvq.service.authority;

import java.util.Set;

import fr.cg95.cvq.business.authority.PlaceReservationType;
import fr.cg95.cvq.exception.CvqModelException;
import fr.cg95.cvq.exception.CvqPlaceReservationReferentialException;

/**
 * Service dedicated to the management of place reservation referential data.
 * 
 * @author bor@zenexity.fr
 */
public interface IPlaceReservationService {

    /** service name used by Spring's application context */
    String SERVICE_NAME = "placeReservationService";
    
    public static final String REDUCED_PRICE_SUBSCRIBER = "ReducedPriceSubscriber";
    public static final String FULL_PRICE_SUBSCRIBER = "FullPriceSubscriber";
    
    /**
     * Return all place reservation referential data associated to the given request type.
     *   
     * @param requestTypeLabel label of the request type as per 
     *                         {@link fr.cg95.cvq.service.request.IRequestService#getLabel()}.
     * @param forSubscriber whether we return place reservation and ticket selection 
     *                      for a subscriber (only meaningful in FO context).
     * @return a set of {@link PlaceReservationType} objects if there are some defined for the 
     *         given requet type, or null otherwise.
     * @throws CvqModelException if the given request type has no place reservation mechanism 
     *                           associated.
     * @throws CvqPlaceReservationReferentialException if the loaded data is not XML valid.     
     */
    Set<PlaceReservationType> getPlaceReservationForRequestType(final String requestTypeLabel, 
            final boolean forSubscriber) 
        throws CvqModelException, CvqPlaceReservationReferentialException;
    
    /**
     * Return the place reservation referential data associated to the given place reservation 
     * of the request type.
     *   
     * @param requestTypeLabel label of the request type as per 
     *                         {@link fr.cg95.cvq.service.request.IRequestService#getLabel()}.
     * @param placeReservationKey key of the place reservation we are looking for
     * @param forSubscriber whether we return place reservation and ticket selection 
     *                      for a subscriber (only meaningful and used in FO context).
     *                      
     * @return the corresponding {@link PlaceReservationType} object if it exists or null otherwise.
     * @throws CvqModelException if the given request type has no place reservation mechanism 
     *                           associated.
     * @throws CvqPlaceReservationReferentialException if the loaded data is not XML valid.     
     */
    PlaceReservationType getPlaceReservationForRequestType(final String requestTypeLabel,
            final String placeReservationKey, boolean forSubscriber)
        throws CvqModelException, CvqPlaceReservationReferentialException;
    
    /**
     * Set a whole new place reservation referential data for the given request type.
     * 
     * @param requestTypeLabel label of the request type as per 
     *                         {@link fr.cg95.cvq.service.request.IRequestService#getLabel()}.
     * @param placeReservationTypeSet a set of {@link PlaceReservationType} objects.
     * @throws CvqModelException if the given request type has no place reservation mechanism 
     *                           associated.
     * @throws CvqPlaceReservationReferentialException if the new data is not XML valid     
     */
    void setPlaceReservationForRequestType(final String requestTypeLabel,
            final Set<PlaceReservationType> placeReservationTypeSet)
        throws CvqModelException, CvqPlaceReservationReferentialException;

    /**
     * Set a new place reservation referential data for the given request type.
     * 
     * @param requestTypeLabel label of the request type as per 
     *                         {@link fr.cg95.cvq.service.request.IRequestService#getLabel()}.
     * @param placeReservationType the {@link PlaceReservationType} object to update/add
     * @throws CvqModelException if the given request type has no place reservation mechanism 
     *                           associated.
     * @throws CvqPlaceReservationReferentialException if the new data is not XML valid     
     */
    void setPlaceReservationForRequestType(final String requestTypeLabel,
            final PlaceReservationType placeReservationType)
        throws CvqModelException, CvqPlaceReservationReferentialException;
    
    /**
     * Remove the place reservation with the given key from the place reservation referential data.
     * 
     * @param requestTypeLabel label of the request type as per 
     *                         {@link fr.cg95.cvq.service.request.IRequestService#getLabel()}.
     * @param placeReservationKey key of the {@link PlaceReservationType} object to remove
     * @throws CvqModelException if the given request type has no place reservation mechanism 
     *                           associated.
     */

    void removePlaceReservationForRequestType(final String requestTypeLabel,
            final String placeReservationKey)
        throws CvqModelException, CvqPlaceReservationReferentialException;
    
    /**
     * Update the number of remaining places for the given request type and reservation.
     * 
     * @param requestTypeLabel label of the request type as per 
     *                         {@link fr.cg95.cvq.service.request.IRequestService#getLabel()}.
     * @param placeReservationKey ket of the place reservation as per
     *                         {@link PlaceReservationType#getKey()}
     * @param numberOfPlaces number of places to add or remove the total of remaining places.
     * 
     * @return the number of remaining places after the update.
     * 
     * @throws CvqModelException if the given request type has no place reservation mechanism 
     *                           associated.
     * @throws CvqPlaceReservationReferentialException if the new number of remaining places is
     *                             below zero or above total number of available places.
     */
    int updateRemainingPlacesForReservation(final String requestTypeLabel,
            final String placeReservationKey, final int numberOfPlaces)
        throws CvqModelException, CvqPlaceReservationReferentialException;
    
    /**
     * Return, if it exists, the ticket entry that is reserved for subscribers for the given place
     * reservation key.
     * 
     * @return the ticket entry key if found one or null otherwise.
     */
    Set<String> getSubscriberTickets(final String requestTypeLabel, final String placeReservationKey)
        throws CvqModelException;
}
