package fr.cg95.cvq.fo.school.form;

import java.util.Calendar;
import java.util.Collection;
import java.util.List;
import javax.servlet.http.HttpSession;
import fr.cg95.cvq.wizard.*;
import fr.cg95.cvq.xml.common.*;
import fr.cg95.cvq.xml.school.*;
import fr.cg95.cvq.xml.school.SchoolRegistrationRequestDocument.SchoolRegistrationRequest;

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
		if ((xmlbRequest != null) && (xmlbRequest instanceof SchoolRegistrationRequest)) {
			SchoolRegistrationRequest request = (SchoolRegistrationRequest)xmlbRequest;
			this.rulesAndRegulationsAcceptance = request.getRulesAndRegulationsAcceptance();
		}
	}
	
	public void save(HttpSession session, Object xmlbRequest) {
		if ((xmlbRequest != null) && (xmlbRequest instanceof SchoolRegistrationRequest)) {
			SchoolRegistrationRequest request = (SchoolRegistrationRequest)xmlbRequest;
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