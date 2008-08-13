package fr.cg95.cvq.fo.perischool.form;

import java.util.Calendar;
import java.util.Collection;
import java.util.List;
import javax.servlet.http.HttpSession;
import fr.cg95.cvq.wizard.*;
import fr.cg95.cvq.xml.common.*;
import fr.cg95.cvq.xml.school.*;
import fr.cg95.cvq.xml.school.PerischoolActivityRegistrationRequestDocument.PerischoolActivityRegistrationRequest;

public class Rules extends IStageForm {

	private boolean classTripPermission;
	private boolean childPhotoExploitationPermission;
	private boolean rulesAndRegulationsAcceptance;
	private boolean hospitalizationPermission;

	public Rules() {
		super();
	}
	
	public void reset(String state) {
		if (state.equals("authorisation")) {
		}
	}
	
	public void load(HttpSession session, Object xmlbRequest) {
		if ((xmlbRequest != null) && (xmlbRequest instanceof PerischoolActivityRegistrationRequest)) {
			PerischoolActivityRegistrationRequest request = (PerischoolActivityRegistrationRequest)xmlbRequest;
			this.classTripPermission = request.getClassTripPermission();
			this.childPhotoExploitationPermission = request.getChildPhotoExploitationPermission();
			this.rulesAndRegulationsAcceptance = request.getRulesAndRegulationsAcceptance();
			this.hospitalizationPermission = request.getHospitalizationPermission();
		}
	}
	
	public void save(HttpSession session, Object xmlbRequest) {
		if ((xmlbRequest != null) && (xmlbRequest instanceof PerischoolActivityRegistrationRequest)) {
			PerischoolActivityRegistrationRequest request = (PerischoolActivityRegistrationRequest)xmlbRequest;
			request.setClassTripPermission(this.classTripPermission);
			request.setChildPhotoExploitationPermission(this.childPhotoExploitationPermission);
			request.setRulesAndRegulationsAcceptance(this.rulesAndRegulationsAcceptance);
			request.setHospitalizationPermission(this.hospitalizationPermission);
		}
	}
	
	public boolean isComplete() {
		return true;
	}
	
	public void setClassTripPermission(boolean classTripPermission) {
		this.classTripPermission = classTripPermission;
	}
	
	public boolean getClassTripPermission() {
		return this.classTripPermission;
	}
	
	public boolean checkClassTripPermission() {
		return true;
	}

	public void setChildPhotoExploitationPermission(boolean childPhotoExploitationPermission) {
		this.childPhotoExploitationPermission = childPhotoExploitationPermission;
	}
	
	public boolean getChildPhotoExploitationPermission() {
		return this.childPhotoExploitationPermission;
	}
	
	public boolean checkChildPhotoExploitationPermission() {
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

	public void setHospitalizationPermission(boolean hospitalizationPermission) {
		this.hospitalizationPermission = hospitalizationPermission;
	}
	
	public boolean getHospitalizationPermission() {
		return this.hospitalizationPermission;
	}
	
	public boolean checkHospitalizationPermission() {
		return true;
	}

}
