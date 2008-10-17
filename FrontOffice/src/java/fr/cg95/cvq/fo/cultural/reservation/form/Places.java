package fr.cg95.cvq.fo.cultural.reservation.form;

import java.util.Calendar;
import java.util.Collection;
import java.util.List;
import javax.servlet.http.HttpSession;
import fr.cg95.cvq.wizard.*;
import fr.cg95.cvq.xml.common.*;
import fr.cg95.cvq.xml.reservation.*;
import fr.cg95.cvq.xml.reservation.PlaceReservationRequestDocument.PlaceReservationRequest;

public class Places extends IStageForm {


	public Places() {
		super();
	}
	
	public void reset(String state) {
		if (state.equals("places")) {
		}
	}
	
	public void load(HttpSession session, Object xmlbRequest) {
		if ((xmlbRequest != null) && (xmlbRequest instanceof PlaceReservationRequest)) {
			PlaceReservationRequest request = (PlaceReservationRequest)xmlbRequest;
		}
	}
	
	public void save(HttpSession session, Object xmlbRequest) {
		if ((xmlbRequest != null) && (xmlbRequest instanceof PlaceReservationRequest)) {
			PlaceReservationRequest request = (PlaceReservationRequest)xmlbRequest;
			request.setPlaceReservationArray(saveForm((ReservationNode)session.getAttribute("Place Reservation")));
		}
	}
	
	public boolean isComplete() {
		return true;
	}
	
}