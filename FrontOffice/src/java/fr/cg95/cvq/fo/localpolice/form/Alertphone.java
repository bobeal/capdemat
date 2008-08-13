package fr.cg95.cvq.fo.localpolice.form;

import java.util.Calendar;
import java.util.Collection;
import java.util.List;
import javax.servlet.http.HttpSession;
import fr.cg95.cvq.wizard.*;
import fr.cg95.cvq.xml.common.*;
import fr.cg95.cvq.xml.localpolice.*;
import fr.cg95.cvq.xml.localpolice.HolidaySecurityRequestDocument.HolidaySecurityRequest;

public class Alertphone extends IStageForm {

	private String alertPhone;

	public Alertphone() {
		super();
	}
	
	public void reset(String state) {
		if (state.equals("alertphone")) {
		}
	}
	
	public void load(HttpSession session, Object xmlbRequest) {
		if ((xmlbRequest != null) && (xmlbRequest instanceof HolidaySecurityRequest)) {
			HolidaySecurityRequest request = (HolidaySecurityRequest)xmlbRequest;
			this.alertPhone = request.getAlertPhone();
		}
	}
	
	public void save(HttpSession session, Object xmlbRequest) {
		if ((xmlbRequest != null) && (xmlbRequest instanceof HolidaySecurityRequest)) {
			HolidaySecurityRequest request = (HolidaySecurityRequest)xmlbRequest;
			request.setAlertPhone(this.alertPhone);
		}
	}
	
	public boolean isComplete() {
		if (this.checkAlertPhone() &&
			((this.alertPhone == null) || (this.alertPhone.length() == 0)))
			return false;
		return true;
	}
	
	public void setAlertPhone(String alertPhone) {
		this.alertPhone = alertPhone;
	}
	
	public String getAlertPhone() {
		return this.alertPhone;
	}
	
	public boolean checkAlertPhone() {
		return true;
	}

}
