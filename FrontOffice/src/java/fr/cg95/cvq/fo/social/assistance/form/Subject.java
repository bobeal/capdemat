package fr.cg95.cvq.fo.social.assistance.form;

import java.util.Calendar;
import java.util.Collection;
import java.util.List;
import javax.servlet.http.HttpSession;
import fr.cg95.cvq.wizard.*;
import fr.cg95.cvq.xml.common.*;
import fr.cg95.cvq.xml.social.*;
import fr.cg95.cvq.xml.social.RemoteSupportRequestDocument.RemoteSupportRequest;

public class Subject extends IStageForm {

	private boolean seniorAssitanceBeneficiary;
	private java.math.BigInteger appartmentNumber;
	private boolean taxable;
	private java.math.BigInteger floor;
	private Calendar subjectAdultBirthDate;
	private String subjectAdultHomePhone;
	private String subjectAdultSex;
	private String subjectAdultAddressStreetName;
	private String subjectAdultLastName;
	private String subjectAdultFirstName2;
	private String subjectAdultFirstName;
	private String dwelling;

	public Subject() {
		super();
	}
	
	public void reset(String state) {
		if (state.equals("display")) {
		}
		if (state.equals("subject")) {
		}
	}
	
	public void load(HttpSession session, Object xmlbRequest) {
		if ((xmlbRequest != null) && (xmlbRequest instanceof RemoteSupportRequest)) {
			RemoteSupportRequest request = (RemoteSupportRequest)xmlbRequest;
			this.seniorAssitanceBeneficiary = request.getSeniorAssitanceBeneficiary();
			this.appartmentNumber = request.getAppartmentNumber();
			this.taxable = request.getTaxable();
			this.floor = request.getFloor();
			this.subjectAdultBirthDate = request.getSubject().getAdult().getBirthDate();
			this.subjectAdultHomePhone = request.getSubject().getAdult().getHomePhone();
			if (request.getSubject().getAdult().getSex() != null)
			this.subjectAdultSex = request.getSubject().getAdult().getSex().toString();
			this.subjectAdultAddressStreetName = request.getSubject().getAdult().getAddress().getStreetName();
			this.subjectAdultLastName = request.getSubject().getAdult().getLastName();
			this.subjectAdultFirstName2 = request.getSubject().getAdult().getFirstName2();
			this.subjectAdultFirstName = request.getSubject().getAdult().getFirstName();
			if (request.getDwelling() != null)
			this.dwelling = request.getDwelling().toString();
		}
	}
	
	public void save(HttpSession session, Object xmlbRequest) {
		if ((xmlbRequest != null) && (xmlbRequest instanceof RemoteSupportRequest)) {
			RemoteSupportRequest request = (RemoteSupportRequest)xmlbRequest;
			request.setSeniorAssitanceBeneficiary(this.seniorAssitanceBeneficiary);
			request.setAppartmentNumber(this.appartmentNumber);
			request.setTaxable(this.taxable);
			request.setFloor(this.floor);
			request.getSubject().getAdult().setBirthDate(this.subjectAdultBirthDate);
			request.getSubject().getAdult().setHomePhone(this.subjectAdultHomePhone);
			request.getSubject().getAdult().setSex(SexType.Enum.forString(this.subjectAdultSex));
			request.getSubject().getAdult().getAddress().setStreetName(this.subjectAdultAddressStreetName);
			request.getSubject().getAdult().setLastName(this.subjectAdultLastName);
			request.getSubject().getAdult().setFirstName2(this.subjectAdultFirstName2);
			request.getSubject().getAdult().setFirstName(this.subjectAdultFirstName);
			request.setDwelling(RsrDwellingType.Enum.forString(this.dwelling));
		}
	}
	
	public boolean isComplete() {
		if (this.checkSubjectAdultHomePhone() &&
			((this.subjectAdultHomePhone == null) || (this.subjectAdultHomePhone.length() == 0)))
			return false;
		if (this.checkSubjectAdultAddressStreetName() &&
			((this.subjectAdultAddressStreetName == null) || (this.subjectAdultAddressStreetName.length() == 0)))
			return false;
		if (this.checkSubjectAdultLastName() &&
			((this.subjectAdultLastName == null) || (this.subjectAdultLastName.length() == 0)))
			return false;
		if (this.checkSubjectAdultFirstName() &&
			((this.subjectAdultFirstName == null) || (this.subjectAdultFirstName.length() == 0)))
			return false;
		if (this.checkDwelling() &&
			((this.dwelling == null) || (this.dwelling.length() == 0)))
			return false;
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
		return dwelling.equals("Appartment");
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

	public void setFloor(java.math.BigInteger floor) {
		this.floor = floor;
	}
	
	public java.math.BigInteger getFloor() {
		return this.floor;
	}
	
	public boolean checkFloor() {
		return dwelling.equals("Appartment");
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

	public void setSubjectAdultHomePhone(String subjectAdultHomePhone) {
		this.subjectAdultHomePhone = subjectAdultHomePhone;
	}
	
	public String getSubjectAdultHomePhone() {
		return this.subjectAdultHomePhone;
	}
	
	public boolean checkSubjectAdultHomePhone() {
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

	public void setSubjectAdultAddressStreetName(String subjectAdultAddressStreetName) {
		this.subjectAdultAddressStreetName = subjectAdultAddressStreetName;
	}
	
	public String getSubjectAdultAddressStreetName() {
		return this.subjectAdultAddressStreetName;
	}
	
	public boolean checkSubjectAdultAddressStreetName() {
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

}
