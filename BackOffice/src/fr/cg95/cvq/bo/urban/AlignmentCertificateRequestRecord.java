package fr.cg95.cvq.bo.urban;

import java.util.Calendar;
import java.util.List;
import java.util.Set;
import java.util.Vector;

import fr.cg95.cvq.wizard.*;
import fr.cg95.cvq.bo.record.BaseRecord;
import fr.cg95.cvq.bo.record.RequestRecord;
import fr.cg95.cvq.business.authority.*;
import fr.cg95.cvq.business.users.*;
import fr.cg95.cvq.business.urbanism.*;

public class AlignmentCertificateRequestRecord extends RequestRecord {

  	private String ownerAddressAdditionalDeliveryInformation;
	private String ownerAddressAdditionalGeographicalInformation;
	private String ownerAddressStreetNumber;
	private String ownerAddressStreetName;
	private String ownerAddressPlaceNameOrService;
	private String ownerAddressPostalCode;
	private String ownerAddressCity;
	private String section;
	private String requesterFirstName;
	private String transportationRoute;
	private String requesterLastName;
	private String locality;
	private String ownerLastName;
	private java.math.BigInteger number;
	private String ownerFirstNames;
	private String requesterQuality;

	public AlignmentCertificateRequestRecord() {
		super();
	}
	
	protected Object clone() throws CloneNotSupportedException {
		AlignmentCertificateRequestRecord clonedRecord = (AlignmentCertificateRequestRecord)super.clone();
		return clonedRecord;
	}
	
	public BaseRecord getDataRecord(Long id) {

		if (id.equals(this.getId()))
			return this;
			
		return super.getDataRecord(id);
	}

    public void load(Object xmlRequest) {
        if ((xmlRequest != null) && (xmlRequest instanceof AlignmentCertificateRequest)) {
            AlignmentCertificateRequest request = (AlignmentCertificateRequest)xmlRequest; 

			if (request.getOwnerAddress() != null) {
				this.ownerAddressAdditionalDeliveryInformation = request.getOwnerAddress().getAdditionalDeliveryInformation();
				this.ownerAddressAdditionalGeographicalInformation = request.getOwnerAddress().getAdditionalGeographicalInformation();
				this.ownerAddressStreetNumber = request.getOwnerAddress().getStreetNumber();
				this.ownerAddressStreetName = request.getOwnerAddress().getStreetName();
				this.ownerAddressPlaceNameOrService = request.getOwnerAddress().getPlaceNameOrService();
				this.ownerAddressPostalCode = request.getOwnerAddress().getPostalCode();
				this.ownerAddressCity = request.getOwnerAddress().getCity();
			}
			this.section = request.getSection();
            if ((request.getRequester() != null))
			this.requesterFirstName = request.getRequester().getFirstName();
			this.transportationRoute = request.getTransportationRoute();
            if ((request.getRequester() != null))
			this.requesterLastName = request.getRequester().getLastName();
			this.locality = request.getLocality();
			this.ownerLastName = request.getOwnerLastName();
			this.number = request.getNumber();
			this.ownerFirstNames = request.getOwnerFirstNames();
			if (request.getRequesterQuality() != null)
                this.requesterQuality = getEnumElementTranslation(
                        fr.cg95.cvq.xml.urbanism.AlignmentCertificateRequestDocument.AlignmentCertificateRequest.class.getName(), 
                        "RequesterQuality", request.getRequesterQuality().toString());
        }
    }
    
    public void saveRequest(Object xmlRequest) {
        if ((xmlRequest != null) && (xmlRequest instanceof AlignmentCertificateRequest)) {
            AlignmentCertificateRequest request = (AlignmentCertificateRequest)xmlRequest; 
        }
    }
    
    public void saveData(Object xmlRequest) {
        if ((xmlRequest != null) && (xmlRequest instanceof AlignmentCertificateRequest)) {
            AlignmentCertificateRequest request = (AlignmentCertificateRequest)xmlRequest; 

  			if (request.getOwnerAddress() != null) {
				request.getOwnerAddress().setAdditionalDeliveryInformation(this.ownerAddressAdditionalDeliveryInformation);
				request.getOwnerAddress().setAdditionalGeographicalInformation(this.ownerAddressAdditionalGeographicalInformation);
				request.getOwnerAddress().setStreetNumber(this.ownerAddressStreetNumber);
				request.getOwnerAddress().setStreetName(this.ownerAddressStreetName);
				request.getOwnerAddress().setPlaceNameOrService(this.ownerAddressPlaceNameOrService);
				request.getOwnerAddress().setPostalCode(this.ownerAddressPostalCode);
				request.getOwnerAddress().setCity(this.ownerAddressCity);
			}
			request.setSection(this.section);
			request.setTransportationRoute(this.transportationRoute);
			request.setLocality(this.locality);
			request.setOwnerLastName(this.ownerLastName);
			request.setNumber(this.number);
			request.setOwnerFirstNames(this.ownerFirstNames);
			if (this.requesterQuality != null)
                request.setRequesterQuality(
                    AcrRequesterQualityType.forString(
                        getEnumKeyTranslation(
                            fr.cg95.cvq.xml.urbanism.AlignmentCertificateRequestDocument.AlignmentCertificateRequest.class.getName(), 
                            "RequesterQuality", this.requesterQuality)
                    )
                );
        }
    }
    
	public void setOwnerAddressAdditionalDeliveryInformation(String ownerAddressAdditionalDeliveryInformation) {
		this.ownerAddressAdditionalDeliveryInformation = ownerAddressAdditionalDeliveryInformation;
	}
	
	public String getOwnerAddressAdditionalDeliveryInformation() {
		return this.ownerAddressAdditionalDeliveryInformation;
	}

	public void setOwnerAddressAdditionalGeographicalInformation(String ownerAddressAdditionalGeographicalInformation) {
		this.ownerAddressAdditionalGeographicalInformation = ownerAddressAdditionalGeographicalInformation;
	}
	
	public String getOwnerAddressAdditionalGeographicalInformation() {
		return this.ownerAddressAdditionalGeographicalInformation;
	}

	public void setOwnerAddressStreetNumber(String ownerAddressStreetNumber) {
		this.ownerAddressStreetNumber = ownerAddressStreetNumber;
	}
	
	public String getOwnerAddressStreetNumber() {
		return this.ownerAddressStreetNumber;
	}

	public void setOwnerAddressStreetName(String ownerAddressStreetName) {
		this.ownerAddressStreetName = ownerAddressStreetName;
	}
	
	public String getOwnerAddressStreetName() {
		return this.ownerAddressStreetName;
	}

	public void setOwnerAddressPlaceNameOrService(String ownerAddressPlaceNameOrService) {
		this.ownerAddressPlaceNameOrService = ownerAddressPlaceNameOrService;
	}
	
	public String getOwnerAddressPlaceNameOrService() {
		return this.ownerAddressPlaceNameOrService;
	}

	public void setOwnerAddressPostalCode(String ownerAddressPostalCode) {
		this.ownerAddressPostalCode = ownerAddressPostalCode;
	}
	
	public String getOwnerAddressPostalCode() {
		return this.ownerAddressPostalCode;
	}

	public void setOwnerAddressCity(String ownerAddressCity) {
		this.ownerAddressCity = ownerAddressCity;
	}
	
	public String getOwnerAddressCity() {
		return this.ownerAddressCity;
	}

	public void setSection(String section) {
		this.section = section;
	}
	
	public String getSection() {
		return this.section;
	}

	public void setRequesterFirstName(String requesterFirstName) {
		this.requesterFirstName = requesterFirstName;
	}
	
	public String getRequesterFirstName() {
		return this.requesterFirstName;
	}

	public void setTransportationRoute(String transportationRoute) {
		this.transportationRoute = transportationRoute;
	}
	
	public String getTransportationRoute() {
		return this.transportationRoute;
	}

	public void setRequesterLastName(String requesterLastName) {
		this.requesterLastName = requesterLastName;
	}
	
	public String getRequesterLastName() {
		return this.requesterLastName;
	}

	public void setLocality(String locality) {
		this.locality = locality;
	}
	
	public String getLocality() {
		return this.locality;
	}

	public void setOwnerLastName(String ownerLastName) {
		this.ownerLastName = ownerLastName;
	}
	
	public String getOwnerLastName() {
		return this.ownerLastName;
	}

	public void setNumber(java.math.BigInteger number) {
		this.number = number;
	}
	
	public java.math.BigInteger getNumber() {
		return this.number;
	}

	public void setOwnerFirstNames(String ownerFirstNames) {
		this.ownerFirstNames = ownerFirstNames;
	}
	
	public String getOwnerFirstNames() {
		return this.ownerFirstNames;
	}

	public void setRequesterQuality(String requesterQuality) {
		this.requesterQuality = requesterQuality;
	}
	
	public String getRequesterQuality() {
		return this.requesterQuality;
	}

}

