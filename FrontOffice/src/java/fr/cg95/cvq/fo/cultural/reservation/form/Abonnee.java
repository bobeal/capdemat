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

	private String subscriberNumber;
	private boolean isSubscriber;

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
			this.subscriberNumber = request.getSubscriberNumber();
			this.isSubscriber = request.getIsSubscriber();
		}
	}
	
	public void save(HttpSession session, Object xmlbRequest) {
		if ((xmlbRequest != null) && (xmlbRequest instanceof PlaceReservationRequest)) {
			PlaceReservationRequest request = (PlaceReservationRequest)xmlbRequest;
			request.setSubscriberNumber(this.subscriberNumber);
			request.setIsSubscriber(this.isSubscriber);
		}
	}
	
	public boolean isComplete() {
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

	public void setIsSubscriber(boolean isSubscriber) {
		this.isSubscriber = isSubscriber;
	}
	
	public boolean getIsSubscriber() {
		return this.isSubscriber;
	}
	
	public boolean checkIsSubscriber() {
		return true;
	}

}
