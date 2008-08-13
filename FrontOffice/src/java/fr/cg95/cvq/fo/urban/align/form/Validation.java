package fr.cg95.cvq.fo.urban.align.form;

import java.util.Calendar;
import java.util.Collection;
import java.util.List;
import javax.servlet.http.HttpSession;
import fr.cg95.cvq.wizard.*;
import fr.cg95.cvq.xml.common.*;
import fr.cg95.cvq.xml.urbanism.*;
import fr.cg95.cvq.xml.urbanism.AlignmentCertificateRequestDocument.AlignmentCertificateRequest;

public class Validation extends IStageForm {

  	private String ownerAddressAdditionalDeliveryInformation;
	private String ownerAddressAdditionalGeographicalInformation;
	private String ownerAddressStreetNumber;
	private String ownerAddressStreetName;
	private String ownerAddressPlaceNameOrService;
	private String ownerAddressPostalCode;
	private String ownerAddressCity;
	private String section;
	private String transportationRoute;
	private String locality;
	private String ownerLastName;
	private java.math.BigInteger number;
	private String ownerFirstNames;
	private String requesterQuality;

	public Validation() {
		super();
	}
	
	public void reset(String state) {
		if (state.equals("summary")) {
		}
		if (state.equals("summaryowner")) {
		}
	}
	
	public void load(HttpSession session, Object xmlbRequest) {
		if ((xmlbRequest != null) && (xmlbRequest instanceof AlignmentCertificateRequest)) {
			AlignmentCertificateRequest request = (AlignmentCertificateRequest)xmlbRequest;
  			this.ownerAddressAdditionalDeliveryInformation = request.getOwnerAddress().getAdditionalDeliveryInformation();
			this.ownerAddressAdditionalGeographicalInformation = request.getOwnerAddress().getAdditionalGeographicalInformation();
			this.ownerAddressStreetNumber = request.getOwnerAddress().getStreetNumber();
			this.ownerAddressStreetName = request.getOwnerAddress().getStreetName();
			this.ownerAddressPlaceNameOrService = request.getOwnerAddress().getPlaceNameOrService();
			this.ownerAddressPostalCode = request.getOwnerAddress().getPostalCode();
			this.ownerAddressCity = request.getOwnerAddress().getCity();
			this.section = request.getSection();
			this.transportationRoute = request.getTransportationRoute();
			this.locality = request.getLocality();
			this.ownerLastName = request.getOwnerLastName();
			this.number = request.getNumber();
			this.ownerFirstNames = request.getOwnerFirstNames();
			if (request.getRequesterQuality() != null)
			this.requesterQuality = request.getRequesterQuality().toString();
		}
	}
	
	public void save(HttpSession session, Object xmlbRequest) {
		if ((xmlbRequest != null) && (xmlbRequest instanceof AlignmentCertificateRequest)) {
			AlignmentCertificateRequest request = (AlignmentCertificateRequest)xmlbRequest;
  			request.getOwnerAddress().setAdditionalDeliveryInformation(this.ownerAddressAdditionalDeliveryInformation);
			request.getOwnerAddress().setAdditionalGeographicalInformation(this.ownerAddressAdditionalGeographicalInformation);
			request.getOwnerAddress().setStreetNumber(this.ownerAddressStreetNumber);
			request.getOwnerAddress().setStreetName(this.ownerAddressStreetName);
			request.getOwnerAddress().setPlaceNameOrService(this.ownerAddressPlaceNameOrService);
			request.getOwnerAddress().setPostalCode(this.ownerAddressPostalCode);
			request.getOwnerAddress().setCity(this.ownerAddressCity);
			request.setSection(this.section);
			request.setTransportationRoute(this.transportationRoute);
			request.setLocality(this.locality);
			request.setOwnerLastName(this.ownerLastName);
			request.setNumber(this.number);
			request.setOwnerFirstNames(this.ownerFirstNames);
			request.setRequesterQuality(AcrRequesterQualityType.Enum.forString(this.requesterQuality));
		}
	}
	
	public boolean isComplete() {
  		if (this.checkOwnerAddressStreetName() &&
			((this.ownerAddressStreetName == null) || (this.ownerAddressStreetName.length() == 0)))
			return false;
		if (this.checkOwnerAddressPostalCode() &&
			((this.ownerAddressPostalCode == null) || (this.ownerAddressPostalCode.length() == 0)))
			return false;
		if (this.checkOwnerAddressCity() &&
			((this.ownerAddressCity == null) || (this.ownerAddressCity.length() == 0)))
			return false;
		if (this.checkSection() &&
			((this.section == null) || (this.section.length() == 0)))
			return false;
		if (this.checkRequesterQuality() &&
			((this.requesterQuality == null) || (this.requesterQuality.length() == 0)))
			return false;
		return true;
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
		return true;
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
		return true;
	}

	public void setOwnerAddressCity(String ownerAddressCity) {
		this.ownerAddressCity = ownerAddressCity;
	}
	
	public String getOwnerAddressCity() {
		return this.ownerAddressCity;
	}
	
	public boolean checkOwnerAddressCity() {
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

	public void setLocality(String locality) {
		this.locality = locality;
	}
	
	public String getLocality() {
		return this.locality;
	}
	
	public boolean checkLocality() {
		return true;
	}

	public void setOwnerLastName(String ownerLastName) {
		this.ownerLastName = ownerLastName;
	}
	
	public String getOwnerLastName() {
		return this.ownerLastName;
	}
	
	public boolean checkOwnerLastName() {
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

	public void setOwnerFirstNames(String ownerFirstNames) {
		this.ownerFirstNames = ownerFirstNames;
	}
	
	public String getOwnerFirstNames() {
		return this.ownerFirstNames;
	}
	
	public boolean checkOwnerFirstNames() {
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

}
