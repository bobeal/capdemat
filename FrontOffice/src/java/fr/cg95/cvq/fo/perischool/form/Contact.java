package fr.cg95.cvq.fo.perischool.form;

import java.util.Calendar;
import java.util.Collection;
import java.util.List;
import javax.servlet.http.HttpSession;
import fr.cg95.cvq.wizard.*;
import fr.cg95.cvq.xml.common.*;
import fr.cg95.cvq.xml.school.*;
import fr.cg95.cvq.xml.school.PerischoolActivityRegistrationRequestDocument.PerischoolActivityRegistrationRequest;

public class Contact extends IStageForm {

	private String otherIndividualOfficePhone;
	private String otherIndividualFirstName;
	private String otherIndividualHomePhone;
	private String otherIndividualAddress;
	private String otherIndividualLastName;

	public Contact() {
		super();
	}
	
	public void reset(String state) {
		if (state.equals("display")) {
		}
		if (state.equals("contact")) {
		}
	}
	
	public void load(HttpSession session, Object xmlbRequest) {
		if ((xmlbRequest != null) && (xmlbRequest instanceof PerischoolActivityRegistrationRequest)) {
			PerischoolActivityRegistrationRequest request = (PerischoolActivityRegistrationRequest)xmlbRequest;
		}
	}
	
	public void save(HttpSession session, Object xmlbRequest) {
		if ((xmlbRequest != null) && (xmlbRequest instanceof PerischoolActivityRegistrationRequest)) {
			PerischoolActivityRegistrationRequest request = (PerischoolActivityRegistrationRequest)xmlbRequest;
		}
	}
	
	public boolean isComplete() {
		if (this.checkOtherIndividualFirstName() &&
			((this.otherIndividualFirstName == null) || (this.otherIndividualFirstName.length() == 0)))
			return false;
		if (this.checkOtherIndividualAddress() &&
			((this.otherIndividualAddress == null) || (this.otherIndividualAddress.length() == 0)))
			return false;
		if (this.checkOtherIndividualLastName() &&
			((this.otherIndividualLastName == null) || (this.otherIndividualLastName.length() == 0)))
			return false;
		return true;
	}
	
	public void setOtherIndividualOfficePhone(String otherIndividualOfficePhone) {
		this.otherIndividualOfficePhone = otherIndividualOfficePhone;
	}
	
	public String getOtherIndividualOfficePhone() {
		return this.otherIndividualOfficePhone;
	}
	
	public boolean checkOtherIndividualOfficePhone() {
		return true;
	}

	public void setOtherIndividualFirstName(String otherIndividualFirstName) {
		this.otherIndividualFirstName = otherIndividualFirstName;
	}
	
	public String getOtherIndividualFirstName() {
		return this.otherIndividualFirstName;
	}
	
	public boolean checkOtherIndividualFirstName() {
		return true;
	}

	public void setOtherIndividualHomePhone(String otherIndividualHomePhone) {
		this.otherIndividualHomePhone = otherIndividualHomePhone;
	}
	
	public String getOtherIndividualHomePhone() {
		return this.otherIndividualHomePhone;
	}
	
	public boolean checkOtherIndividualHomePhone() {
		return true;
	}

	public void setOtherIndividualAddress(String otherIndividualAddress) {
		this.otherIndividualAddress = otherIndividualAddress;
	}
	
	public String getOtherIndividualAddress() {
		return this.otherIndividualAddress;
	}
	
	public boolean checkOtherIndividualAddress() {
		return true;
	}

	public void setOtherIndividualLastName(String otherIndividualLastName) {
		this.otherIndividualLastName = otherIndividualLastName;
	}
	
	public String getOtherIndividualLastName() {
		return this.otherIndividualLastName;
	}
	
	public boolean checkOtherIndividualLastName() {
		return true;
	}

}