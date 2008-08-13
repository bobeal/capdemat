package fr.cg95.cvq.fo.cultural.reservation.form;

import java.util.Calendar;
import java.util.Collection;
import java.util.List;
import javax.servlet.http.HttpSession;
import fr.cg95.cvq.wizard.*;
import fr.cg95.cvq.xml.common.*;
import fr.cg95.cvq.xml.reservation.*;
import fr.cg95.cvq.xml.reservation.PlaceReservationRequestDocument.PlaceReservationRequest;

public class Abonnee extends IStageForm {

	private boolean isSubscriber;
	private String subscriberNumber;

	public Abonnee() {
		super();
	}
	
	public void reset(String state) {
		if (state.equals("abonnee")) {
		}
	}
	
	public void load(HttpSession session, Object xmlbRequest) {
		if ((xmlbRequest != null) && (xmlbRequest instanceof PlaceReservationRequest)) {
			PlaceReservationRequest request = (PlaceReservationRequest)xmlbRequest;
			this.isSubscriber = request.getIsSubscriber();
			this.subscriberNumber = request.getSubscriberNumber();
		}
	}
	
	public void save(HttpSession session, Object xmlbRequest) {
		if ((xmlbRequest != null) && (xmlbRequest instanceof PlaceReservationRequest)) {
			PlaceReservationRequest request = (PlaceReservationRequest)xmlbRequest;
			request.setIsSubscriber(this.isSubscriber);
			request.setSubscriberNumber(this.subscriberNumber);
		}
	}
	
	public boolean isComplete() {
		return true;
	}
	
	public void setIsSubscriber(boolean isSubscriber) {
		this.isSubscriber = isSubscriber;
	}
	
	public boolean getIsSubscriber() {
		return this.isSubscriber;
	}
	
	public boolean checkIsSubscriber() {
		return true;
	}

	public void setSubscriberNumber(String subscriberNumber) {
		this.subscriberNumber = subscriberNumber;
	}
	
	public String getSubscriberNumber() {
		return this.subscriberNumber;
	}
	
	public boolean checkSubscriberNumber() {
		return true;
	}

}
