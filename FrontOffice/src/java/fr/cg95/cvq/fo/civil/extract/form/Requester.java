package fr.cg95.cvq.fo.civil.extract.form;

import java.util.Calendar;

import javax.servlet.http.HttpSession;

import fr.cg95.cvq.wizard.IStageForm;
import fr.cg95.cvq.xml.civil.PersonalDetailsRequestDocument.PersonalDetailsRequest;

public class Requester extends IStageForm {

	private String requesterNameOfUse;
	private String requesterEmail;
	private String requesterFirstName;
	private String requesterHomePhone;
	private String requesterAddressPostalCode;
	private String requesterMaidenName;
	private String requesterAddressAddress;
	private String requesterOfficePhone;
	private String requesterAddressCity;
	private String requesterLastName;
	private Calendar requesterBirthDate;
	private String requesterMobilePhone;

	public Requester() {
		super();
	}
	
	public void reset(String state) {
		if (state.equals("requester")) {
		}
	}
	
	public void load(HttpSession session, Object xmlbRequest) {
		if ((xmlbRequest != null) && (xmlbRequest instanceof PersonalDetailsRequest)) {
			PersonalDetailsRequest request = (PersonalDetailsRequest)xmlbRequest;
			this.requesterNameOfUse = request.getRequester().getNameOfUse();
			this.requesterEmail = request.getRequester().getEmail();
			this.requesterFirstName = request.getRequester().getFirstName();
			this.requesterHomePhone = request.getRequester().getHomePhone();
			this.requesterAddressPostalCode = request.getRequester().getAddress().getPostalCode();
			this.requesterMaidenName = request.getRequester().getMaidenName();
			// TODO Better refactor this, to respect Address Normalisation
			this.requesterAddressAddress = request.getRequester().getAddress().getStreetName();
			this.requesterOfficePhone = request.getRequester().getOfficePhone();
			this.requesterAddressCity = request.getRequester().getAddress().getCity();
			this.requesterLastName = request.getRequester().getLastName();
			this.requesterBirthDate = request.getRequester().getBirthDate();
			this.requesterMobilePhone = request.getRequester().getMobilePhone();
		}
	}
	
	public void save(HttpSession session, Object xmlbRequest) {
		if ((xmlbRequest != null) && (xmlbRequest instanceof PersonalDetailsRequest)) {
			PersonalDetailsRequest request = (PersonalDetailsRequest)xmlbRequest;
			request.getRequester().setNameOfUse(this.requesterNameOfUse);
			request.getRequester().setEmail(this.requesterEmail);
			request.getRequester().setFirstName(this.requesterFirstName);
			request.getRequester().setHomePhone(this.requesterHomePhone);
			request.getRequester().getAddress().setPostalCode(this.requesterAddressPostalCode);
			request.getRequester().setMaidenName(this.requesterMaidenName);
			// TODO Better refactor this, to respect Address Normalisation
			request.getRequester().getAddress().setStreetName(this.requesterAddressAddress);
			request.getRequester().setOfficePhone(this.requesterOfficePhone);
			request.getRequester().getAddress().setCity(this.requesterAddressCity);
			request.getRequester().setLastName(this.requesterLastName);
			request.getRequester().setBirthDate(this.requesterBirthDate);
			request.getRequester().setMobilePhone(this.requesterMobilePhone);
		}
	}
	
	public boolean isComplete() {
		if ((this.requesterFirstName == null) || (this.requesterFirstName.length() == 0))
			return false;
		if ((this.requesterHomePhone == null) || (this.requesterHomePhone.length() == 0))
			return false;
		if ((this.requesterAddressPostalCode == null) || (this.requesterAddressPostalCode.length() == 0))
			return false;
		if ((this.requesterAddressAddress == null) || (this.requesterAddressAddress.length() == 0))
			return false;
		if ((this.requesterAddressCity == null) || (this.requesterAddressCity.length() == 0))
			return false;
		if ((this.requesterLastName == null) || (this.requesterLastName.length() == 0))
			return false;
		return true;
	}
	
	public void setRequesterNameOfUse(String requesterNameOfUse) {
		this.requesterNameOfUse = requesterNameOfUse;
	}
	
	public String getRequesterNameOfUse() {
		return this.requesterNameOfUse;
	}
	
	public void setRequesterEmail(String requesterEmail) {
		this.requesterEmail = requesterEmail;
	}
	
	public String getRequesterEmail() {
		return this.requesterEmail;
	}
	
	public void setRequesterFirstName(String requesterFirstName) {
		this.requesterFirstName = requesterFirstName;
	}
	
	public String getRequesterFirstName() {
		return this.requesterFirstName;
	}
	
	public void setRequesterHomePhone(String requesterHomePhone) {
		this.requesterHomePhone = requesterHomePhone;
	}
	
	public String getRequesterHomePhone() {
		return this.requesterHomePhone;
	}
	
	public void setRequesterAddressPostalCode(String requesterAddressPostalCode) {
		this.requesterAddressPostalCode = requesterAddressPostalCode;
	}
	
	public String getRequesterAddressPostalCode() {
		return this.requesterAddressPostalCode;
	}
	
	public void setRequesterMaidenName(String requesterMaidenName) {
		this.requesterMaidenName = requesterMaidenName;
	}
	
	public String getRequesterMaidenName() {
		return this.requesterMaidenName;
	}
	
	public void setRequesterAddressAddress(String requesterAddressAddress) {
		this.requesterAddressAddress = requesterAddressAddress;
	}
	
	public String getRequesterAddressAddress() {
		return this.requesterAddressAddress;
	}
	
	public void setRequesterOfficePhone(String requesterOfficePhone) {
		this.requesterOfficePhone = requesterOfficePhone;
	}
	
	public String getRequesterOfficePhone() {
		return this.requesterOfficePhone;
	}
	
	public void setRequesterAddressCity(String requesterAddressCity) {
		this.requesterAddressCity = requesterAddressCity;
	}
	
	public String getRequesterAddressCity() {
		return this.requesterAddressCity;
	}
	
	public void setRequesterLastName(String requesterLastName) {
		this.requesterLastName = requesterLastName;
	}
	
	public String getRequesterLastName() {
		return this.requesterLastName;
	}
	
	public void setRequesterBirthDate(Calendar requesterBirthDate) {
		this.requesterBirthDate = requesterBirthDate;
	}
	
	public Calendar getRequesterBirthDate() {
		return this.requesterBirthDate;
	}
	
	public void setRequesterMobilePhone(String requesterMobilePhone) {
		this.requesterMobilePhone = requesterMobilePhone;
	}
	
	public String getRequesterMobilePhone() {
		return this.requesterMobilePhone;
	}
	
}
