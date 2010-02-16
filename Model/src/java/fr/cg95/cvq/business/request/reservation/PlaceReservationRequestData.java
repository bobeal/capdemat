
package fr.cg95.cvq.business.request.reservation;

import java.io.Serializable;
import java.math.BigInteger;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import fr.cg95.cvq.business.authority.*;
import fr.cg95.cvq.business.request.*;
import fr.cg95.cvq.business.users.*;

/**
 * Generated class file, do not edit !
 *
 * @hibernate.class
 *  table="place_reservation_request"
 *  lazy="false"
 */
public class PlaceReservationRequestData implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    public PlaceReservationRequestData() {
      
        isSubscriber = Boolean.valueOf(false);
      
    }

    public final void setId(final Long id) {
        this.id = id;
    }

    /**
     * @hibernate.id
     *  column="id"
     *  generator-class="sequence"
     */
    public final Long getId() {
        return this.id;
    }

  
    private String subscriberNumber;

    public final void setSubscriberNumber(final String subscriberNumber) {
        this.subscriberNumber = subscriberNumber;
    }

    /**
 
        * @hibernate.property
        *  column="subscriber_number"
        
      
    */
    public final String getSubscriberNumber() {
        return this.subscriberNumber;
    }
  
    private Boolean isSubscriber;

    public final void setIsSubscriber(final Boolean isSubscriber) {
        this.isSubscriber = isSubscriber;
    }

    /**
 
        * @hibernate.property
        *  column="is_subscriber"
        
      
    */
    public final Boolean getIsSubscriber() {
        return this.isSubscriber;
    }
  
    private List<fr.cg95.cvq.business.request.PlaceReservationData> placeReservation;

    public final void setPlaceReservation(final List<fr.cg95.cvq.business.request.PlaceReservationData> placeReservation) {
        this.placeReservation = placeReservation;
    }

    /**
 
        * @hibernate.list
        *  inverse="false"
        *  lazy="false"
        *  cascade="all"
        *  table="place_reservation_request_place_reservation"
        * @hibernate.key
        *  column="place_reservation_request_id"
        * @hibernate.list-index
        *  column="place_reservation_index"
        * @hibernate.many-to-many
        *  column="place_reservation_id"
        *  class="fr.cg95.cvq.business.request.PlaceReservationData"
      
    */
    public final List<fr.cg95.cvq.business.request.PlaceReservationData> getPlaceReservation() {
        return this.placeReservation;
    }
  
    private String paymentReference;

    public final void setPaymentReference(final String paymentReference) {
        this.paymentReference = paymentReference;
    }

    /**
 
        * @hibernate.property
        *  column="payment_reference"
        
      
    */
    public final String getPaymentReference() {
        return this.paymentReference;
    }
  
}
