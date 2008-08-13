package fr.cg95.cvq.fo.social.assistance.form;

import java.util.Calendar;
import java.util.Collection;
import java.util.List;
import javax.servlet.http.HttpSession;
import fr.cg95.cvq.wizard.*;
import fr.cg95.cvq.xml.common.*;
import fr.cg95.cvq.xml.social.*;
import fr.cg95.cvq.xml.social.RemoteSupportRequestDocument.RemoteSupportRequest;

public class Contactperson extends IStageForm {

	private String contactFirstName;
	private String contact;
	private String contactName;
	private String contactPhone;

	public Contactperson() {
		super();
	}
	
	public void reset(String state) {
		if (state.equals("display")) {
		}
		if (state.equals("contact")) {
		}
	}
	
	public void load(HttpSession session, Object xmlbRequest) {
		if ((xmlbRequest != null) && (xmlbRequest instanceof RemoteSupportRequest)) {
			RemoteSupportRequest request = (RemoteSupportRequest)xmlbRequest;
			this.contactFirstName = request.getContactFirstName();
			if (request.getContact() != null)
			this.contact = request.getContact().toString();
			this.contactName = request.getContactName();
			this.contactPhone = request.getContactPhone();
		}
	}
	
	public void save(HttpSession session, Object xmlbRequest) {
		if ((xmlbRequest != null) && (xmlbRequest instanceof RemoteSupportRequest)) {
			RemoteSupportRequest request = (RemoteSupportRequest)xmlbRequest;
			request.setContactFirstName(this.contactFirstName);
			request.setContact(RsrContactType.Enum.forString(this.contact));
			request.setContactName(this.contactName);
			request.setContactPhone(this.contactPhone);
		}
	}
	
	public boolean isComplete() {
		return true;
	}
	
	public void setContactFirstName(String contactFirstName) {
		this.contactFirstName = contactFirstName;
	}
	
	public String getContactFirstName() {
		return this.contactFirstName;
	}
	
	public boolean checkContactFirstName() {
		return contact.equals("Other");
	}

	public void setContact(String contact) {
		this.contact = contact;
	}
	
	public String getContact() {
		return this.contact;
	}
	
	public boolean checkContact() {
		return true;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}
	
	public String getContactName() {
		return this.contactName;
	}
	
	public boolean checkContactName() {
		return contact.equals("Other");
	}

	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}
	
	public String getContactPhone() {
		return this.contactPhone;
	}
	
	public boolean checkContactPhone() {
		return contact.equals("Other");
	}

}
