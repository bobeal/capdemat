package fr.cg95.cvq.bo.cultural;

import java.util.Calendar;
import java.util.List;
import java.util.Set;
import java.util.Vector;

import fr.cg95.cvq.wizard.*;
import fr.cg95.cvq.bo.record.BaseRecord;
import fr.cg95.cvq.bo.record.RequestRecord;
import fr.cg95.cvq.business.authority.*;
import fr.cg95.cvq.business.users.*;
import fr.cg95.cvq.business.reservation.*;

public class PlaceReservationRequestRecord extends RequestRecord {

	private String requesterFirstName;
	private String requesterLastName;
	private String subscriberNumber;
   	private ReservationNode placeReservation;
	private boolean isSubscriber;
	private String paymentReference;

	public PlaceReservationRequestRecord() {
		super();
	}
	
	protected Object clone() throws CloneNotSupportedException {
		PlaceReservationRequestRecord clonedRecord = (PlaceReservationRequestRecord)super.clone();
		return clonedRecord;
	}
	
	public BaseRecord getDataRecord(Long id) {

		if (id.equals(this.getId()))
			return this;
			
		return super.getDataRecord(id);
	}

    public void load(Object xmlRequest) {
        if ((xmlRequest != null) && (xmlRequest instanceof PlaceReservationRequest)) {
            PlaceReservationRequest request = (PlaceReservationRequest)xmlRequest; 

            if ((request.getRequester() != null))
			this.requesterFirstName = request.getRequester().getFirstName();
            if ((request.getRequester() != null))
			this.requesterLastName = request.getRequester().getLastName();
			this.subscriberNumber = request.getSubscriberNumber();
            this.setPlaceReservation(getReservations(this.getList("Place Reservation"), request.getPlaceReservation()));
            if ((request.getIsSubscriber() != null))
			this.isSubscriber = request.getIsSubscriber();
			this.paymentReference = request.getPaymentReference();
        }
    }
    
    public void saveRequest(Object xmlRequest) {
        if ((xmlRequest != null) && (xmlRequest instanceof PlaceReservationRequest)) {
            PlaceReservationRequest request = (PlaceReservationRequest)xmlRequest; 
        }
    }
    
    public void saveData(Object xmlRequest) {
        if ((xmlRequest != null) && (xmlRequest instanceof PlaceReservationRequest)) {
            PlaceReservationRequest request = (PlaceReservationRequest)xmlRequest; 

			request.setPaymentReference(this.paymentReference);
        }
    }
    
	public void setRequesterFirstName(String requesterFirstName) {
		this.requesterFirstName = requesterFirstName;
	}
	
	public String getRequesterFirstName() {
		return this.requesterFirstName;
	}

	public void setRequesterLastName(String requesterLastName) {
		this.requesterLastName = requesterLastName;
	}
	
	public String getRequesterLastName() {
		return this.requesterLastName;
	}

	public void setSubscriberNumber(String subscriberNumber) {
		this.subscriberNumber = subscriberNumber;
	}
	
	public String getSubscriberNumber() {
		return this.subscriberNumber;
	}

	public void setPlaceReservation(ReservationNode placeReservation) {
		this.placeReservation = placeReservation;
	}
	
	public ReservationNode getPlaceReservation() {
		return this.placeReservation;
	}

	public void setIsSubscriber(boolean isSubscriber) {
		this.isSubscriber = isSubscriber;
	}
	
	public boolean getIsSubscriber() {
		return this.isSubscriber;
	}

	public void setPaymentReference(String paymentReference) {
		this.paymentReference = paymentReference;
	}
	
	public String getPaymentReference() {
		return this.paymentReference;
	}

}

