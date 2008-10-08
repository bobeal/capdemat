package fr.cg95.cvq.fo.social.assistance.form;

import java.util.Calendar;
import java.util.Collection;
import java.util.List;
import javax.servlet.http.HttpSession;
import fr.cg95.cvq.wizard.*;
import fr.cg95.cvq.xml.common.*;
import fr.cg95.cvq.xml.social.*;
import fr.cg95.cvq.xml.social.RemoteSupportRequestDocument.RemoteSupportRequest;

public class Keydeposit extends IStageForm {

	private String trustee;
	private String trusteeFirstName;
	private String trusteePhone;
	private String trusteeName;

	public Keydeposit() {
		super();
	}
	
	public void reset(String state) {
		if (state.equals("display")) {
		}
		if (state.equals("keydeposit")) {
		}
	}
	
	public void load(HttpSession session, Object xmlbRequest) {
		if ((xmlbRequest != null) && (xmlbRequest instanceof RemoteSupportRequest)) {
			RemoteSupportRequest request = (RemoteSupportRequest)xmlbRequest;
			if (request.getTrustee() != null)
			this.trustee = request.getTrustee().toString();
			this.trusteeFirstName = request.getTrusteeFirstName();
			this.trusteePhone = request.getTrusteePhone();
			this.trusteeName = request.getTrusteeName();
		}
	}
	
	public void save(HttpSession session, Object xmlbRequest) {
		if ((xmlbRequest != null) && (xmlbRequest instanceof RemoteSupportRequest)) {
			RemoteSupportRequest request = (RemoteSupportRequest)xmlbRequest;
			request.setTrustee(TrusteeType.Enum.forString(this.trustee));
			request.setTrusteeFirstName(this.trusteeFirstName);
			request.setTrusteePhone(this.trusteePhone);
			request.setTrusteeName(this.trusteeName);
		}
	}
	
	public boolean isComplete() {
		return true;
	}
	
	public void setTrustee(String trustee) {
		this.trustee = trustee;
	}
	
	public String getTrustee() {
		return this.trustee;
	}
	
	public boolean checkTrustee() {
		return true;
	}

	public void setTrusteeFirstName(String trusteeFirstName) {
		this.trusteeFirstName = trusteeFirstName;
	}
	
	public String getTrusteeFirstName() {
		return this.trusteeFirstName;
	}
	
	public boolean checkTrusteeFirstName() {
		return trustee.equals("Other");
	}

	public void setTrusteePhone(String trusteePhone) {
		this.trusteePhone = trusteePhone;
	}
	
	public String getTrusteePhone() {
		return this.trusteePhone;
	}
	
	public boolean checkTrusteePhone() {
		return trustee.equals("Other");
	}

	public void setTrusteeName(String trusteeName) {
		this.trusteeName = trusteeName;
	}
	
	public String getTrusteeName() {
		return this.trusteeName;
	}
	
	public boolean checkTrusteeName() {
		return trustee.equals("Other");
	}

}
