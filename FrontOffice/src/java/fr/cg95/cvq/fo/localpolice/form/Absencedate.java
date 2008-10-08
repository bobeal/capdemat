package fr.cg95.cvq.fo.localpolice.form;

import java.util.Calendar;
import java.util.Collection;
import java.util.List;
import javax.servlet.http.HttpSession;
import fr.cg95.cvq.wizard.*;
import fr.cg95.cvq.xml.common.*;
import fr.cg95.cvq.xml.localpolice.*;
import fr.cg95.cvq.xml.localpolice.HolidaySecurityRequestDocument.HolidaySecurityRequest;

public class Absencedate extends IStageForm {

	private Calendar absenceStartDate;
	private Calendar absenceEndDate;

	public Absencedate() {
		super();
	}
	
	public void reset(String state) {
		if (state.equals("absencedate")) {
		}
	}
	
	public void load(HttpSession session, Object xmlbRequest) {
		if ((xmlbRequest != null) && (xmlbRequest instanceof HolidaySecurityRequest)) {
			HolidaySecurityRequest request = (HolidaySecurityRequest)xmlbRequest;
			this.absenceStartDate = request.getAbsenceStartDate();
			this.absenceEndDate = request.getAbsenceEndDate();
		}
	}
	
	public void save(HttpSession session, Object xmlbRequest) {
		if ((xmlbRequest != null) && (xmlbRequest instanceof HolidaySecurityRequest)) {
			HolidaySecurityRequest request = (HolidaySecurityRequest)xmlbRequest;
			request.setAbsenceStartDate(this.absenceStartDate);
			request.setAbsenceEndDate(this.absenceEndDate);
		}
	}
	
	public boolean isComplete() {
		return true;
	}
	
	public void setAbsenceStartDate(Calendar absenceStartDate) {
		this.absenceStartDate = absenceStartDate;
	}
	
	public Calendar getAbsenceStartDate() {
		return this.absenceStartDate;
	}
	
	public boolean checkAbsenceStartDate() {
		return true;
	}

	public void setAbsenceEndDate(Calendar absenceEndDate) {
		this.absenceEndDate = absenceEndDate;
	}
	
	public Calendar getAbsenceEndDate() {
		return this.absenceEndDate;
	}
	
	public boolean checkAbsenceEndDate() {
		return true;
	}

}
