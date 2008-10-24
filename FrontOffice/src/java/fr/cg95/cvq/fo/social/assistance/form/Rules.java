package fr.cg95.cvq.fo.social.assistance.form;

import java.util.Calendar;
import java.util.Collection;
import java.util.List;
import javax.servlet.http.HttpSession;
import fr.cg95.cvq.wizard.*;
import fr.cg95.cvq.xml.common.*;
import fr.cg95.cvq.xml.social.*;
import fr.cg95.cvq.xml.social.RemoteSupportRequestDocument.RemoteSupportRequest;

public class Rules extends IStageForm {

	private boolean emergency;

	public Rules() {
		super();
	}
	
	public void reset(String state) {
		if (state.equals("rules")) {
		}
	}
	
	public void load(HttpSession session, Object xmlbRequest) {
		if ((xmlbRequest != null) && (xmlbRequest instanceof RemoteSupportRequest)) {
			RemoteSupportRequest request = (RemoteSupportRequest)xmlbRequest;
			this.emergency = request.getEmergency();
		}
	}
	
	public void save(HttpSession session, Object xmlbRequest) {
		if ((xmlbRequest != null) && (xmlbRequest instanceof RemoteSupportRequest)) {
			RemoteSupportRequest request = (RemoteSupportRequest)xmlbRequest;
			request.setEmergency(this.emergency);
		}
	}
	
	public boolean isComplete() {
		return true;
	}
	
	public void setEmergency(boolean emergency) {
		this.emergency = emergency;
	}
	
	public boolean getEmergency() {
		return this.emergency;
	}
	
	public boolean checkEmergency() {
		return true;
	}

}