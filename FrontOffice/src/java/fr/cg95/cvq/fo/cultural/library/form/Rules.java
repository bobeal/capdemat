package fr.cg95.cvq.fo.cultural.library.form;

import java.util.Calendar;
import java.util.Collection;
import java.util.List;
import javax.servlet.http.HttpSession;
import fr.cg95.cvq.wizard.*;
import fr.cg95.cvq.xml.common.*;
import fr.cg95.cvq.xml.leisure.culture.*;
import fr.cg95.cvq.xml.leisure.culture.LibraryRegistrationRequestDocument.LibraryRegistrationRequest;

public class Rules extends IStageForm {

	private boolean rulesAndRegulationsAcceptance;
	private boolean parentalAuthorization;

	public Rules() {
		super();
	}
	
	public void reset(String state) {
		if (state.equals("authorisation")) {
		}
	}
	
	public void load(HttpSession session, Object xmlbRequest) {
		if ((xmlbRequest != null) && (xmlbRequest instanceof LibraryRegistrationRequest)) {
			LibraryRegistrationRequest request = (LibraryRegistrationRequest)xmlbRequest;
			this.rulesAndRegulationsAcceptance = request.getRulesAndRegulationsAcceptance();
			this.parentalAuthorization = request.getParentalAuthorization();
		}
	}
	
	public void save(HttpSession session, Object xmlbRequest) {
		if ((xmlbRequest != null) && (xmlbRequest instanceof LibraryRegistrationRequest)) {
			LibraryRegistrationRequest request = (LibraryRegistrationRequest)xmlbRequest;
			request.setRulesAndRegulationsAcceptance(this.rulesAndRegulationsAcceptance);
			request.setParentalAuthorization(this.parentalAuthorization);
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

	public void setParentalAuthorization(boolean parentalAuthorization) {
		this.parentalAuthorization = parentalAuthorization;
	}
	
	public boolean getParentalAuthorization() {
		return this.parentalAuthorization;
	}
	
	public boolean checkParentalAuthorization() {
		return true;
	}

}
