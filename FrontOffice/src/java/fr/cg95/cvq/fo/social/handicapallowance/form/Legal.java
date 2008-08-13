package fr.cg95.cvq.fo.social.handicapallowance.form;

import java.util.Calendar;
import java.util.Collection;
import java.util.List;
import javax.servlet.http.HttpSession;
import fr.cg95.cvq.wizard.*;
import fr.cg95.cvq.xml.common.*;
import fr.cg95.cvq.xml.social.*;
import fr.cg95.cvq.xml.social.HandicapAllowanceRequestDocument.HandicapAllowanceRequest;

public class Legal extends IStageForm {

	private String legalRepresentativeFamilyRelationship;
  	private String legalRepresentativeAddressAdditionalDeliveryInformation;
	private String legalRepresentativeAddressAdditionalGeographicalInformation;
	private String legalRepresentativeAddressStreetNumber;
	private String legalRepresentativeAddressStreetName;
	private String legalRepresentativeAddressPlaceNameOrService;
	private String legalRepresentativeAddressPostalCode;
	private String legalRepresentativeAddressCity;
	private String legalRepresentativeName;
	private String legalRepresentativeFirstame;
	private boolean legalRepresentative;
	private String legalRepresentativePhone;

	public Legal() {
		super();
	}
	
	public void reset(String state) {
		if (state.equals("display")) {
		}
		if (state.equals("legal")) {
		}
	}
	
	public void load(HttpSession session, Object xmlbRequest) {
		if ((xmlbRequest != null) && (xmlbRequest instanceof HandicapAllowanceRequest)) {
			HandicapAllowanceRequest request = (HandicapAllowanceRequest)xmlbRequest;
			this.legalRepresentativeFamilyRelationship = request.getLegalRepresentativeFamilyRelationship();
  			this.legalRepresentativeAddressAdditionalDeliveryInformation = request.getLegalRepresentativeAddress().getAdditionalDeliveryInformation();
			this.legalRepresentativeAddressAdditionalGeographicalInformation = request.getLegalRepresentativeAddress().getAdditionalGeographicalInformation();
			this.legalRepresentativeAddressStreetNumber = request.getLegalRepresentativeAddress().getStreetNumber();
			this.legalRepresentativeAddressStreetName = request.getLegalRepresentativeAddress().getStreetName();
			this.legalRepresentativeAddressPlaceNameOrService = request.getLegalRepresentativeAddress().getPlaceNameOrService();
			this.legalRepresentativeAddressPostalCode = request.getLegalRepresentativeAddress().getPostalCode();
			this.legalRepresentativeAddressCity = request.getLegalRepresentativeAddress().getCity();
			this.legalRepresentativeName = request.getLegalRepresentativeName();
			this.legalRepresentativeFirstame = request.getLegalRepresentativeFirstame();
			this.legalRepresentative = request.getLegalRepresentative();
			this.legalRepresentativePhone = request.getLegalRepresentativePhone();
		}
	}
	
	public void save(HttpSession session, Object xmlbRequest) {
		if ((xmlbRequest != null) && (xmlbRequest instanceof HandicapAllowanceRequest)) {
			HandicapAllowanceRequest request = (HandicapAllowanceRequest)xmlbRequest;
			request.setLegalRepresentativeFamilyRelationship(this.legalRepresentativeFamilyRelationship);
  			request.getLegalRepresentativeAddress().setAdditionalDeliveryInformation(this.legalRepresentativeAddressAdditionalDeliveryInformation);
			request.getLegalRepresentativeAddress().setAdditionalGeographicalInformation(this.legalRepresentativeAddressAdditionalGeographicalInformation);
			request.getLegalRepresentativeAddress().setStreetNumber(this.legalRepresentativeAddressStreetNumber);
			request.getLegalRepresentativeAddress().setStreetName(this.legalRepresentativeAddressStreetName);
			request.getLegalRepresentativeAddress().setPlaceNameOrService(this.legalRepresentativeAddressPlaceNameOrService);
			request.getLegalRepresentativeAddress().setPostalCode(this.legalRepresentativeAddressPostalCode);
			request.getLegalRepresentativeAddress().setCity(this.legalRepresentativeAddressCity);
			request.setLegalRepresentativeName(this.legalRepresentativeName);
			request.setLegalRepresentativeFirstame(this.legalRepresentativeFirstame);
			request.setLegalRepresentative(this.legalRepresentative);
			request.setLegalRepresentativePhone(this.legalRepresentativePhone);
		}
	}
	
	public boolean isComplete() {
  		if (this.checkLegalRepresentativeAddressStreetName() &&
			((this.legalRepresentativeAddressStreetName == null) || (this.legalRepresentativeAddressStreetName.length() == 0)))
			return false;
		if (this.checkLegalRepresentativeAddressPostalCode() &&
			((this.legalRepresentativeAddressPostalCode == null) || (this.legalRepresentativeAddressPostalCode.length() == 0)))
			return false;
		if (this.checkLegalRepresentativeAddressCity() &&
			((this.legalRepresentativeAddressCity == null) || (this.legalRepresentativeAddressCity.length() == 0)))
			return false;
		return true;
	}
	
	public void setLegalRepresentativeFamilyRelationship(String legalRepresentativeFamilyRelationship) {
		this.legalRepresentativeFamilyRelationship = legalRepresentativeFamilyRelationship;
	}
	
	public String getLegalRepresentativeFamilyRelationship() {
		return this.legalRepresentativeFamilyRelationship;
	}
	
	public boolean checkLegalRepresentativeFamilyRelationship() {
		return legalRepresentative;
	}

  	public void setLegalRepresentativeAddressAdditionalDeliveryInformation(String legalRepresentativeAddressAdditionalDeliveryInformation) {
		this.legalRepresentativeAddressAdditionalDeliveryInformation = legalRepresentativeAddressAdditionalDeliveryInformation;
	}
	
	public String getLegalRepresentativeAddressAdditionalDeliveryInformation() {
		return this.legalRepresentativeAddressAdditionalDeliveryInformation;
	}
	
	public boolean checkLegalRepresentativeAddressAdditionalDeliveryInformation() {
		return true;
	}

	public void setLegalRepresentativeAddressAdditionalGeographicalInformation(String legalRepresentativeAddressAdditionalGeographicalInformation) {
		this.legalRepresentativeAddressAdditionalGeographicalInformation = legalRepresentativeAddressAdditionalGeographicalInformation;
	}
	
	public String getLegalRepresentativeAddressAdditionalGeographicalInformation() {
		return this.legalRepresentativeAddressAdditionalGeographicalInformation;
	}
	
	public boolean checkLegalRepresentativeAddressAdditionalGeographicalInformation() {
		return true;
	}

	public void setLegalRepresentativeAddressStreetNumber(String legalRepresentativeAddressStreetNumber) {
		this.legalRepresentativeAddressStreetNumber = legalRepresentativeAddressStreetNumber;
	}
	
	public String getLegalRepresentativeAddressStreetNumber() {
		return this.legalRepresentativeAddressStreetNumber;
	}
	
	public boolean checkLegalRepresentativeAddressStreetNumber() {
		return true;
	}

	public void setLegalRepresentativeAddressStreetName(String legalRepresentativeAddressStreetName) {
		this.legalRepresentativeAddressStreetName = legalRepresentativeAddressStreetName;
	}
	
	public String getLegalRepresentativeAddressStreetName() {
		return this.legalRepresentativeAddressStreetName;
	}
	
	public boolean checkLegalRepresentativeAddressStreetName() {
		return legalRepresentative;
	}

	public void setLegalRepresentativeAddressPlaceNameOrService(String legalRepresentativeAddressPlaceNameOrService) {
		this.legalRepresentativeAddressPlaceNameOrService = legalRepresentativeAddressPlaceNameOrService;
	}
	
	public String getLegalRepresentativeAddressPlaceNameOrService() {
		return this.legalRepresentativeAddressPlaceNameOrService;
	}
	
	public boolean checkLegalRepresentativeAddressPlaceNameOrService() {
		return true;
	}

	public void setLegalRepresentativeAddressPostalCode(String legalRepresentativeAddressPostalCode) {
		this.legalRepresentativeAddressPostalCode = legalRepresentativeAddressPostalCode;
	}
	
	public String getLegalRepresentativeAddressPostalCode() {
		return this.legalRepresentativeAddressPostalCode;
	}
	
	public boolean checkLegalRepresentativeAddressPostalCode() {
		return legalRepresentative;
	}

	public void setLegalRepresentativeAddressCity(String legalRepresentativeAddressCity) {
		this.legalRepresentativeAddressCity = legalRepresentativeAddressCity;
	}
	
	public String getLegalRepresentativeAddressCity() {
		return this.legalRepresentativeAddressCity;
	}
	
	public boolean checkLegalRepresentativeAddressCity() {
		return legalRepresentative;
	}

	public void setLegalRepresentativeName(String legalRepresentativeName) {
		this.legalRepresentativeName = legalRepresentativeName;
	}
	
	public String getLegalRepresentativeName() {
		return this.legalRepresentativeName;
	}
	
	public boolean checkLegalRepresentativeName() {
		return legalRepresentative;
	}

	public void setLegalRepresentativeFirstame(String legalRepresentativeFirstame) {
		this.legalRepresentativeFirstame = legalRepresentativeFirstame;
	}
	
	public String getLegalRepresentativeFirstame() {
		return this.legalRepresentativeFirstame;
	}
	
	public boolean checkLegalRepresentativeFirstame() {
		return legalRepresentative;
	}

	public void setLegalRepresentative(boolean legalRepresentative) {
		this.legalRepresentative = legalRepresentative;
	}
	
	public boolean getLegalRepresentative() {
		return this.legalRepresentative;
	}
	
	public boolean checkLegalRepresentative() {
		return true;
	}

	public void setLegalRepresentativePhone(String legalRepresentativePhone) {
		this.legalRepresentativePhone = legalRepresentativePhone;
	}
	
	public String getLegalRepresentativePhone() {
		return this.legalRepresentativePhone;
	}
	
	public boolean checkLegalRepresentativePhone() {
		return legalRepresentative;
	}

}
