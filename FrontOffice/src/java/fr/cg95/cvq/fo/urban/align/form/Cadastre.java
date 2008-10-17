package fr.cg95.cvq.fo.urban.align.form;

import java.util.Calendar;
import java.util.Collection;
import java.util.List;
import javax.servlet.http.HttpSession;
import fr.cg95.cvq.wizard.*;
import fr.cg95.cvq.xml.common.*;
import fr.cg95.cvq.xml.urbanism.*;
import fr.cg95.cvq.xml.urbanism.AlignmentCertificateRequestDocument.AlignmentCertificateRequest;

public class Cadastre extends IStageForm {

	private String requesterFirstName;
	private String requesterQuality;
	private String requesterLastName;
	private String section;
	private String transportationRoute;
	private String ownerFirstNames;
	private String locality;
	private java.math.BigInteger number;
	private String ownerLastName;
  	private String ownerAddressAdditionalDeliveryInformation;
	private String ownerAddressAdditionalGeographicalInformation;
	private String ownerAddressStreetNumber;
	private String ownerAddressStreetName;
	private String ownerAddressPlaceNameOrService;
	private String ownerAddressPostalCode;
	private String ownerAddressCity;

	public Cadastre() {
		super();
	}
	
	public void reset(String state) {
		if (state.equals("cadastre")) {
		}
		if (state.equals("displayowner")) {
		}
		if (state.equals("display")) {
		}
	}
	
	public void load(HttpSession session, Object xmlbRequest) {
		if ((xmlbRequest != null) && (xmlbRequest instanceof AlignmentCertificateRequest)) {
			AlignmentCertificateRequest request = (AlignmentCertificateRequest)xmlbRequest;
			this.requesterFirstName = request.getRequester().getFirstName();
			if (request.getRequesterQuality() != null)
			this.requesterQuality = request.getRequesterQuality().toString();
			this.requesterLastName = request.getRequester().getLastName();
			this.section = request.getSection();
			this.transportationRoute = request.getTransportationRoute();
			this.ownerFirstNames = request.getOwnerFirstNames();
			this.locality = request.getLocality();
			this.number = request.getNumber();
			this.ownerLastName = request.getOwnerLastName();
  			this.ownerAddressAdditionalDeliveryInformation = request.getOwnerAddress().getAdditionalDeliveryInformation();
			this.ownerAddressAdditionalGeographicalInformation = request.getOwnerAddress().getAdditionalGeographicalInformation();
			this.ownerAddressStreetNumber = request.getOwnerAddress().getStreetNumber();
			this.ownerAddressStreetName = request.getOwnerAddress().getStreetName();
			this.ownerAddressPlaceNameOrService = request.getOwnerAddress().getPlaceNameOrService();
			this.ownerAddressPostalCode = request.getOwnerAddress().getPostalCode();
			this.ownerAddressCity = request.getOwnerAddress().getCity();
		}
	}
	
	public void save(HttpSession session, Object xmlbRequest) {
		if ((xmlbRequest != null) && (xmlbRequest instanceof AlignmentCertificateRequest)) {
			AlignmentCertificateRequest request = (AlignmentCertificateRequest)xmlbRequest;
			request.getRequester().setFirstName(this.requesterFirstName);
			request.setRequesterQuality(AcrRequesterQualityType.Enum.forString(this.requesterQuality));
			request.getRequester().setLastName(this.requesterLastName);
			request.setSection(this.section);
			request.setTransportationRoute(this.transportationRoute);
			request.setOwnerFirstNames(this.ownerFirstNames);
			request.setLocality(this.locality);
			request.setNumber(this.number);
			request.setOwnerLastName(this.ownerLastName);
  			request.getOwnerAddress().setAdditionalDeliveryInformation(this.ownerAddressAdditionalDeliveryInformation);
			request.getOwnerAddress().setAdditionalGeographicalInformation(this.ownerAddressAdditionalGeographicalInformation);
			request.getOwnerAddress().setStreetNumber(this.ownerAddressStreetNumber);
			request.getOwnerAddress().setStreetName(this.ownerAddressStreetName);
			request.getOwnerAddress().setPlaceNameOrService(this.ownerAddressPlaceNameOrService);
			request.getOwnerAddress().setPostalCode(this.ownerAddressPostalCode);
			request.getOwnerAddress().setCity(this.ownerAddressCity);
		}
	}
	
	public boolean isComplete() {
		if (this.checkRequesterFirstName() &&
			((this.requesterFirstName == null) || (this.requesterFirstName.length() == 0)))
			return false;
		if (this.checkRequesterQuality() &&
			((this.requesterQuality == null) || (this.requesterQuality.length() == 0)))
			return false;
		if (this.checkRequesterLastName() &&
			((this.requesterLastName == null) || (this.requesterLastName.length() == 0)))
			return false;
		if (this.checkSection() &&
			((this.section == null) || (this.section.length() == 0)))
			return false;
		if (this.checkOwnerFirstNames() &&
			((this.ownerFirstNames == null) || (this.ownerFirstNames.length() == 0)))
			return false;
		if (this.checkNumber() && (this.number == null))
			return false;
		if (this.checkOwnerLastName() &&
			((this.ownerLastName == null) || (this.ownerLastName.length() == 0)))
			return false;
  		if (this.checkOwnerAddressStreetName() &&
			((this.ownerAddressStreetName == null) || (this.ownerAddressStreetName.length() == 0)))
			return false;
		if (this.checkOwnerAddressPostalCode() &&
			((this.ownerAddressPostalCode == null) || (this.ownerAddressPostalCode.length() == 0)))
			return false;
		if (this.checkOwnerAddressCity() &&
			((this.ownerAddressCity == null) || (this.ownerAddressCity.length() == 0)))
			return false;
		return true;
	}
	
	public void setRequesterFirstName(String requesterFirstName) {
		this.requesterFirstName = requesterFirstName;
	}
	
	public String getRequesterFirstName() {
		return this.requesterFirstName;
	}
	
	public boolean checkRequesterFirstName() {
		return true;
	}

	public void setRequesterQuality(String requesterQuality) {
		this.requesterQuality = requesterQuality;
	}
	
	public String getRequesterQuality() {
		return this.requesterQuality;
	}
	
	public boolean checkRequesterQuality() {
		return true;
	}

	public void setRequesterLastName(String requesterLastName) {
		this.requesterLastName = requesterLastName;
	}
	
	public String getRequesterLastName() {
		return this.requesterLastName;
	}
	
	public boolean checkRequesterLastName() {
		return true;
	}

	public void setSection(String section) {
		this.section = section;
	}
	
	public String getSection() {
		return this.section;
	}
	
	public boolean checkSection() {
		return true;
	}

	public void setTransportationRoute(String transportationRoute) {
		this.transportationRoute = transportationRoute;
	}
	
	public String getTransportationRoute() {
		return this.transportationRoute;
	}
	
	public boolean checkTransportationRoute() {
		return true;
	}

	public void setOwnerFirstNames(String ownerFirstNames) {
		this.ownerFirstNames = ownerFirstNames;
	}
	
	public String getOwnerFirstNames() {
		return this.ownerFirstNames;
	}
	
	public boolean checkOwnerFirstNames() {
		return requesterQuality.equals("Tenant");
	}

	public void setLocality(String locality) {
		this.locality = locality;
	}
	
	public String getLocality() {
		return this.locality;
	}
	
	public boolean checkLocality() {
		return true;
	}

	public void setNumber(java.math.BigInteger number) {
		this.number = number;
	}
	
	public java.math.BigInteger getNumber() {
		return this.number;
	}
	
	public boolean checkNumber() {
		return true;
	}

	public void setOwnerLastName(String ownerLastName) {
		this.ownerLastName = ownerLastName;
	}
	
	public String getOwnerLastName() {
		return this.ownerLastName;
	}
	
	public boolean checkOwnerLastName() {
		return requesterQuality.equals("Tenant");
	}

  	public void setOwnerAddressAdditionalDeliveryInformation(String ownerAddressAdditionalDeliveryInformation) {
		this.ownerAddressAdditionalDeliveryInformation = ownerAddressAdditionalDeliveryInformation;
	}
	
	public String getOwnerAddressAdditionalDeliveryInformation() {
		return this.ownerAddressAdditionalDeliveryInformation;
	}
	
	public boolean checkOwnerAddressAdditionalDeliveryInformation() {
		return true;
	}

	public void setOwnerAddressAdditionalGeographicalInformation(String ownerAddressAdditionalGeographicalInformation) {
		this.ownerAddressAdditionalGeographicalInformation = ownerAddressAdditionalGeographicalInformation;
	}
	
	public String getOwnerAddressAdditionalGeographicalInformation() {
		return this.ownerAddressAdditionalGeographicalInformation;
	}
	
	public boolean checkOwnerAddressAdditionalGeographicalInformation() {
		return true;
	}

	public void setOwnerAddressStreetNumber(String ownerAddressStreetNumber) {
		this.ownerAddressStreetNumber = ownerAddressStreetNumber;
	}
	
	public String getOwnerAddressStreetNumber() {
		return this.ownerAddressStreetNumber;
	}
	
	public boolean checkOwnerAddressStreetNumber() {
		return true;
	}

	public void setOwnerAddressStreetName(String ownerAddressStreetName) {
		this.ownerAddressStreetName = ownerAddressStreetName;
	}
	
	public String getOwnerAddressStreetName() {
		return this.ownerAddressStreetName;
	}
	
	public boolean checkOwnerAddressStreetName() {
		return requesterQuality.equals("Tenant");
	}

	public void setOwnerAddressPlaceNameOrService(String ownerAddressPlaceNameOrService) {
		this.ownerAddressPlaceNameOrService = ownerAddressPlaceNameOrService;
	}
	
	public String getOwnerAddressPlaceNameOrService() {
		return this.ownerAddressPlaceNameOrService;
	}
	
	public boolean checkOwnerAddressPlaceNameOrService() {
		return true;
	}

	public void setOwnerAddressPostalCode(String ownerAddressPostalCode) {
		this.ownerAddressPostalCode = ownerAddressPostalCode;
	}
	
	public String getOwnerAddressPostalCode() {
		return this.ownerAddressPostalCode;
	}
	
	public boolean checkOwnerAddressPostalCode() {
		return requesterQuality.equals("Tenant");
	}

	public void setOwnerAddressCity(String ownerAddressCity) {
		this.ownerAddressCity = ownerAddressCity;
	}
	
	public String getOwnerAddressCity() {
		return this.ownerAddressCity;
	}
	
	public boolean checkOwnerAddressCity() {
		return requesterQuality.equals("Tenant");
	}

}