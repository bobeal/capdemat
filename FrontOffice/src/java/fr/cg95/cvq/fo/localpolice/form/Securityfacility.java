package fr.cg95.cvq.fo.localpolice.form;

import java.util.Calendar;
import java.util.Collection;
import java.util.List;
import javax.servlet.http.HttpSession;
import fr.cg95.cvq.wizard.*;
import fr.cg95.cvq.xml.common.*;
import fr.cg95.cvq.xml.localpolice.*;
import fr.cg95.cvq.xml.localpolice.HolidaySecurityRequestDocument.HolidaySecurityRequest;

public class Securityfacility extends IStageForm {

	private boolean light;
	private boolean alarm;

	public Securityfacility() {
		super();
	}
	
	public void reset(String state) {
		if (state.equals("securityfacility")) {
		}
	}
	
	public void load(HttpSession session, Object xmlbRequest) {
		if ((xmlbRequest != null) && (xmlbRequest instanceof HolidaySecurityRequest)) {
			HolidaySecurityRequest request = (HolidaySecurityRequest)xmlbRequest;
			this.light = request.getLight();
			this.alarm = request.getAlarm();
		}
	}
	
	public void save(HttpSession session, Object xmlbRequest) {
		if ((xmlbRequest != null) && (xmlbRequest instanceof HolidaySecurityRequest)) {
			HolidaySecurityRequest request = (HolidaySecurityRequest)xmlbRequest;
			request.setLight(this.light);
			request.setAlarm(this.alarm);
		}
	}
	
	public boolean isComplete() {
		return true;
	}
	
	public void setLight(boolean light) {
		this.light = light;
	}
	
	public boolean getLight() {
		return this.light;
	}
	
	public boolean checkLight() {
		return true;
	}

	public void setAlarm(boolean alarm) {
		this.alarm = alarm;
	}
	
	public boolean getAlarm() {
		return this.alarm;
	}
	
	public boolean checkAlarm() {
		return true;
	}

}