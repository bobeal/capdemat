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

	private Calendar absenceEndDate;
	private Calendar absenceStartDate;

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
			this.absenceEndDate = request.getAbsenceEndDate();
			this.absenceStartDate = request.getAbsenceStartDate();
		}
	}
	
	public void save(HttpSession session, Object xmlbRequest) {
		if ((xmlbRequest != null) && (xmlbRequest instanceof HolidaySecurityRequest)) {
			HolidaySecurityRequest request = (HolidaySecurityRequest)xmlbRequest;
			request.setAbsenceEndDate(this.absenceEndDate);
			request.setAbsenceStartDate(this.absenceStartDate);
		}
	}
	
	public boolean isComplete() {
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

	public void setAbsenceStartDate(Calendar absenceStartDate) {
		this.absenceStartDate = absenceStartDate;
	}
	
	public Calendar getAbsenceStartDate() {
		return this.absenceStartDate;
	}
	
	public boolean checkAbsenceStartDate() {
		return true;
	}

}
