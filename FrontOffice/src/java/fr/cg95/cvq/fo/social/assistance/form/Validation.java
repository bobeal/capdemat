package fr.cg95.cvq.fo.social.assistance.form;

import java.util.Calendar;
import java.util.Collection;
import java.util.List;
import javax.servlet.http.HttpSession;
import fr.cg95.cvq.wizard.*;
import fr.cg95.cvq.xml.common.*;
import fr.cg95.cvq.xml.social.*;
import fr.cg95.cvq.xml.social.RemoteSupportRequestDocument.RemoteSupportRequest;

public class Validation extends IStageForm {

	private String subjectAdultHomePhone;
	private String contactName;
	private boolean emergency;
	private String subjectAdultLastName;
	private String subjectAdultFirstName2;
	private String trusteeFirstName;
	private boolean seniorAssitanceBeneficiary;
	private java.math.BigInteger appartmentNumber;
	private String trusteeName;
	private java.math.BigInteger floor;
	private boolean taxable;
	private String contactFirstName;
	private Calendar subjectAdultBirthDate;
	private String contact;
	private String subjectAdultSex;
	private String trusteePhone;
	private String subjectAdultAddressStreetName;
	private String trustee;
	private String subjectAdultFirstName;
	private String dwelling;
	private String contactPhone;

	public Validation() {
		super();
	}
	
	public void reset(String state) {
		if (state.equals("summary")) {
		}
	}
	
	public void load(HttpSession session, Object xmlbRequest) {
		if ((xmlbRequest != null) && (xmlbRequest instanceof RemoteSupportRequest)) {
			RemoteSupportRequest request = (RemoteSupportRequest)xmlbRequest;
			this.subjectAdultHomePhone = request.getSubject().getAdult().getHomePhone();
			this.contactName = request.getContactName();
			this.emergency = request.getEmergency();
			this.subjectAdultLastName = request.getSubject().getAdult().getLastName();
			this.subjectAdultFirstName2 = request.getSubject().getAdult().getFirstName2();
			this.trusteeFirstName = request.getTrusteeFirstName();
			this.seniorAssitanceBeneficiary = request.getSeniorAssitanceBeneficiary();
			this.appartmentNumber = request.getAppartmentNumber();
			this.trusteeName = request.getTrusteeName();
			this.floor = request.getFloor();
			this.taxable = request.getTaxable();
			this.contactFirstName = request.getContactFirstName();
			this.subjectAdultBirthDate = request.getSubject().getAdult().getBirthDate();
			if (request.getContact() != null)
			this.contact = request.getContact().toString();
			if (request.getSubject().getAdult().getSex() != null)
			this.subjectAdultSex = request.getSubject().getAdult().getSex().toString();
			this.trusteePhone = request.getTrusteePhone();
			this.subjectAdultAddressStreetName = request.getSubject().getAdult().getAddress().getStreetName();
			if (request.getTrustee() != null)
			this.trustee = request.getTrustee().toString();
			this.subjectAdultFirstName = request.getSubject().getAdult().getFirstName();
			if (request.getDwelling() != null)
			this.dwelling = request.getDwelling().toString();
			this.contactPhone = request.getContactPhone();
		}
	}
	
	public void save(HttpSession session, Object xmlbRequest) {
		if ((xmlbRequest != null) && (xmlbRequest instanceof RemoteSupportRequest)) {
			RemoteSupportRequest request = (RemoteSupportRequest)xmlbRequest;
			request.getSubject().getAdult().setHomePhone(this.subjectAdultHomePhone);
			request.setContactName(this.contactName);
			request.setEmergency(this.emergency);
			request.getSubject().getAdult().setLastName(this.subjectAdultLastName);
			request.getSubject().getAdult().setFirstName2(this.subjectAdultFirstName2);
			request.setTrusteeFirstName(this.trusteeFirstName);
			request.setSeniorAssitanceBeneficiary(this.seniorAssitanceBeneficiary);
			request.setAppartmentNumber(this.appartmentNumber);
			request.setTrusteeName(this.trusteeName);
			request.setFloor(this.floor);
			request.setTaxable(this.taxable);
			request.setContactFirstName(this.contactFirstName);
			request.getSubject().getAdult().setBirthDate(this.subjectAdultBirthDate);
			request.setContact(RsrContactType.Enum.forString(this.contact));
			request.getSubject().getAdult().setSex(SexType.Enum.forString(this.subjectAdultSex));
			request.setTrusteePhone(this.trusteePhone);
			request.getSubject().getAdult().getAddress().setStreetName(this.subjectAdultAddressStreetName);
			request.setTrustee(TrusteeType.Enum.forString(this.trustee));
			request.getSubject().getAdult().setFirstName(this.subjectAdultFirstName);
			request.setDwelling(RsrDwellingType.Enum.forString(this.dwelling));
			request.setContactPhone(this.contactPhone);
		}
	}
	
	public boolean isComplete() {
		if (this.checkSubjectAdultHomePhone() &&
			((this.subjectAdultHomePhone == null) || (this.subjectAdultHomePhone.length() == 0)))
			return false;
		if (this.checkSubjectAdultLastName() &&
			((this.subjectAdultLastName == null) || (this.subjectAdultLastName.length() == 0)))
			return false;
		if (this.checkSubjectAdultAddressStreetName() &&
			((this.subjectAdultAddressStreetName == null) || (this.subjectAdultAddressStreetName.length() == 0)))
			return false;
		if (this.checkSubjectAdultFirstName() &&
			((this.subjectAdultFirstName == null) || (this.subjectAdultFirstName.length() == 0)))
			return false;
		if (this.checkDwelling() &&
			((this.dwelling == null) || (this.dwelling.length() == 0)))
			return false;
		return true;
	}
	
	public void setSubjectAdultHomePhone(String subjectAdultHomePhone) {
		this.subjectAdultHomePhone = subjectAdultHomePhone;
	}
	
	public String getSubjectAdultHomePhone() {
		return this.subjectAdultHomePhone;
	}
	
	public boolean checkSubjectAdultHomePhone() {
		return true;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}
	
	public String getContactName() {
		return this.contactName;
	}
	
	public boolean checkContactName() {
		return true;
	}

	public void setEmergency(boolean emergency) {
		this.emergency = emergency;
	}
	
	public boolean getEmergency() {
		return this.emergency;
	}
	
	public boolean checkEmergency() {
		return true;
	}

	public void setSubjectAdultLastName(String subjectAdultLastName) {
		this.subjectAdultLastName = subjectAdultLastName;
	}
	
	public String getSubjectAdultLastName() {
		return this.subjectAdultLastName;
	}
	
	public boolean checkSubjectAdultLastName() {
		return true;
	}

	public void setSubjectAdultFirstName2(String subjectAdultFirstName2) {
		this.subjectAdultFirstName2 = subjectAdultFirstName2;
	}
	
	public String getSubjectAdultFirstName2() {
		return this.subjectAdultFirstName2;
	}
	
	public boolean checkSubjectAdultFirstName2() {
		return true;
	}

	public void setTrusteeFirstName(String trusteeFirstName) {
		this.trusteeFirstName = trusteeFirstName;
	}
	
	public String getTrusteeFirstName() {
		return this.trusteeFirstName;
	}
	
	public boolean checkTrusteeFirstName() {
		return true;
	}

	public void setSeniorAssitanceBeneficiary(boolean seniorAssitanceBeneficiary) {
		this.seniorAssitanceBeneficiary = seniorAssitanceBeneficiary;
	}
	
	public boolean getSeniorAssitanceBeneficiary() {
		return this.seniorAssitanceBeneficiary;
	}
	
	public boolean checkSeniorAssitanceBeneficiary() {
		return true;
	}

	public void setAppartmentNumber(java.math.BigInteger appartmentNumber) {
		this.appartmentNumber = appartmentNumber;
	}
	
	public java.math.BigInteger getAppartmentNumber() {
		return this.appartmentNumber;
	}
	
	public boolean checkAppartmentNumber() {
		return true;
	}

	public void setTrusteeName(String trusteeName) {
		this.trusteeName = trusteeName;
	}
	
	public String getTrusteeName() {
		return this.trusteeName;
	}
	
	public boolean checkTrusteeName() {
		return true;
	}

	public void setFloor(java.math.BigInteger floor) {
		this.floor = floor;
	}
	
	public java.math.BigInteger getFloor() {
		return this.floor;
	}
	
	public boolean checkFloor() {
		return true;
	}

	public void setTaxable(boolean taxable) {
		this.taxable = taxable;
	}
	
	public boolean getTaxable() {
		return this.taxable;
	}
	
	public boolean checkTaxable() {
		return true;
	}

	public void setContactFirstName(String contactFirstName) {
		this.contactFirstName = contactFirstName;
	}
	
	public String getContactFirstName() {
		return this.contactFirstName;
	}
	
	public boolean checkContactFirstName() {
		return true;
	}

	public void setSubjectAdultBirthDate(Calendar subjectAdultBirthDate) {
		this.subjectAdultBirthDate = subjectAdultBirthDate;
	}
	
	public Calendar getSubjectAdultBirthDate() {
		return this.subjectAdultBirthDate;
	}
	
	public boolean checkSubjectAdultBirthDate() {
		return true;
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

	public void setSubjectAdultSex(String subjectAdultSex) {
		this.subjectAdultSex = subjectAdultSex;
	}
	
	public String getSubjectAdultSex() {
		return this.subjectAdultSex;
	}
	
	public boolean checkSubjectAdultSex() {
		return true;
	}

	public void setTrusteePhone(String trusteePhone) {
		this.trusteePhone = trusteePhone;
	}
	
	public String getTrusteePhone() {
		return this.trusteePhone;
	}
	
	public boolean checkTrusteePhone() {
		return true;
	}

	public void setSubjectAdultAddressStreetName(String subjectAdultAddressStreetName) {
		this.subjectAdultAddressStreetName = subjectAdultAddressStreetName;
	}
	
	public String getSubjectAdultAddressStreetName() {
		return this.subjectAdultAddressStreetName;
	}
	
	public boolean checkSubjectAdultAddressStreetName() {
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

	public void setSubjectAdultFirstName(String subjectAdultFirstName) {
		this.subjectAdultFirstName = subjectAdultFirstName;
	}
	
	public String getSubjectAdultFirstName() {
		return this.subjectAdultFirstName;
	}
	
	public boolean checkSubjectAdultFirstName() {
		return true;
	}

	public void setDwelling(String dwelling) {
		this.dwelling = dwelling;
	}
	
	public String getDwelling() {
		return this.dwelling;
	}
	
	public boolean checkDwelling() {
		return true;
	}

	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}
	
	public String getContactPhone() {
		return this.contactPhone;
	}
	
	public boolean checkContactPhone() {
		return true;
	}

}
