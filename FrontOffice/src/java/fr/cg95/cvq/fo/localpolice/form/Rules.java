package fr.cg95.cvq.fo.localpolice.form;

import java.util.Calendar;
import java.util.Collection;
import java.util.List;
import javax.servlet.http.HttpSession;
import fr.cg95.cvq.wizard.*;
import fr.cg95.cvq.xml.common.*;
import fr.cg95.cvq.xml.localpolice.*;
import fr.cg95.cvq.xml.localpolice.HolidaySecurityRequestDocument.HolidaySecurityRequest;

public class Rules extends IStageForm {

	private boolean rulesAndRegulationsAcceptance;

	public Rules() {
		super();
	}
	
	public void reset(String state) {
		if (state.equals("authorisation")) {
		}
	}
	
	public void load(HttpSession session, Object xmlbRequest) {
		if ((xmlbRequest != null) && (xmlbRequest instanceof HolidaySecurityRequest)) {
			HolidaySecurityRequest request = (HolidaySecurityRequest)xmlbRequest;
			this.rulesAndRegulationsAcceptance = request.getRulesAndRegulationsAcceptance();
		}
	}
	
	public void save(HttpSession session, Object xmlbRequest) {
		if ((xmlbRequest != null) && (xmlbRequest instanceof HolidaySecurityRequest)) {
			HolidaySecurityRequest request = (HolidaySecurityRequest)xmlbRequest;
			request.setRulesAndRegulationsAcceptance(this.rulesAndRegulationsAcceptance);
		}
	}
	
	public boolean isComplete() {
		return true;
	}
	
	public void setRulesAndRegulationsAcceptance(boolean rulesAndRegulationsAcceptance) {
		this.rulesAndRegulationsAcceptance = rulesAndRegulationsAcceptance;
	}
	
	public boolean getRulesAndRegulationsAcceptance() {
		return this.rulesAndRegulationsAcceptance;
	}
	
	public boolean checkRulesAndRegulationsAcceptance() {
		return true;
	}

}
