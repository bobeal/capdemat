package fr.cg95.cvq.fo.election.form;

import java.util.Calendar;
import java.util.Collection;
import java.util.List;
import javax.servlet.http.HttpSession;
import fr.cg95.cvq.wizard.*;
import fr.cg95.cvq.xml.common.*;
import fr.cg95.cvq.xml.social.*;
import fr.cg95.cvq.xml.social.HandicapAllowanceRequestDocument.HandicapAllowanceRequest;

public class Subject extends IStageForm {

	private String requestInformationRequestInformationRequesterProfile;
	private Calendar requestInformationRequestInformationExpirationDate;
	private String requestInformationRequestInformationKind;

	public Subject() {
		super();
	}
	
	public void reset(String state) {
		if (state.equals("requestkind")) {
		}
		if (state.equals("display_requestkind")) {
		}
	}
	
	public void load(HttpSession session, Object xmlbRequest) {
		if ((xmlbRequest != null) && (xmlbRequest instanceof HandicapAllowanceRequest)) {
			HandicapAllowanceRequest request = (HandicapAllowanceRequest)xmlbRequest;
			if (request.getRequestInformation().getRequestInformationRequesterProfile() != null)
			this.requestInformationRequestInformationRequesterProfile = request.getRequestInformation().getRequestInformationRequesterProfile().toString();
			this.requestInformationRequestInformationExpirationDate = request.getRequestInformation().getRequestInformationExpirationDate();
			if (request.getRequestInformation().getRequestInformationKind() != null)
			this.requestInformationRequestInformationKind = request.getRequestInformation().getRequestInformationKind().toString();
		}
	}
	
	public void save(HttpSession session, Object xmlbRequest) {
		if ((xmlbRequest != null) && (xmlbRequest instanceof HandicapAllowanceRequest)) {
			HandicapAllowanceRequest request = (HandicapAllowanceRequest)xmlbRequest;
			request.getRequestInformation().setRequestInformationRequesterProfile(HarRequestInformationProfileType.Enum.forString(this.requestInformationRequestInformationRequesterProfile));
			request.getRequestInformation().setRequestInformationExpirationDate(this.requestInformationRequestInformationExpirationDate);
			request.getRequestInformation().setRequestInformationKind(HarRequestInformationKindType.Enum.forString(this.requestInformationRequestInformationKind));
		}
	}
	
	public boolean isComplete() {
		if (this.checkRequestInformationRequestInformationRequesterProfile() &&
			((this.requestInformationRequestInformationRequesterProfile == null) || (this.requestInformationRequestInformationRequesterProfile.length() == 0)))
			return false;
		if (this.checkRequestInformationRequestInformationExpirationDate() && (this.requestInformationRequestInformationExpirationDate == null))
			return false;
		if (this.checkRequestInformationRequestInformationKind() &&
			((this.requestInformationRequestInformationKind == null) || (this.requestInformationRequestInformationKind.length() == 0)))
			return false;
		return true;
	}
	
	public void setRequestInformationRequestInformationRequesterProfile(String requestInformationRequestInformationRequesterProfile) {
		this.requestInformationRequestInformationRequesterProfile = requestInformationRequestInformationRequesterProfile;
	}
	
	public String getRequestInformationRequestInformationRequesterProfile() {
		return this.requestInformationRequestInformationRequesterProfile;
	}
	
	public boolean checkRequestInformationRequestInformationRequesterProfile() {
		return true;
	}

	public void setRequestInformationRequestInformationExpirationDate(Calendar requestInformationRequestInformationExpirationDate) {
		this.requestInformationRequestInformationExpirationDate = requestInformationRequestInformationExpirationDate;
	}
	
	public Calendar getRequestInformationRequestInformationExpirationDate() {
		return this.requestInformationRequestInformationExpirationDate;
	}
	
	public boolean checkRequestInformationRequestInformationExpirationDate() {
		return requestInformationRequestInformationKind.equals("Renewal");
	}

	public void setRequestInformationRequestInformationKind(String requestInformationRequestInformationKind) {
		this.requestInformationRequestInformationKind = requestInformationRequestInformationKind;
	}
	
	public String getRequestInformationRequestInformationKind() {
		return this.requestInformationRequestInformationKind;
	}
	
	public boolean checkRequestInformationRequestInformationKind() {
		return true;
	}

}