package fr.cg95.cvq.bo.social;

import java.util.Calendar;
import java.util.List;
import java.util.Set;
import java.util.Vector;

import fr.cg95.cvq.wizard.*;
import fr.cg95.cvq.bo.record.BaseRecord;
import fr.cg95.cvq.bo.record.RequestRecord;
import fr.cg95.cvq.business.authority.*;
import fr.cg95.cvq.business.users.*;
import fr.cg95.cvq.business.social.*;

public class DhrPreviousDwellings extends RequestRecord {

	private Calendar previousDwellingsPreviousDwellingDepartureDate;
	private Calendar previousDwellingsPreviousDwellingArrivalDate;
  	private String previousDwellingsPreviousDwellingAddressAdditionalDeliveryInformation;
	private String previousDwellingsPreviousDwellingAddressAdditionalGeographicalInformation;
	private String previousDwellingsPreviousDwellingAddressStreetNumber;
	private String previousDwellingsPreviousDwellingAddressStreetName;
	private String previousDwellingsPreviousDwellingAddressPlaceNameOrService;
	private String previousDwellingsPreviousDwellingAddressPostalCode;
	private String previousDwellingsPreviousDwellingAddressCity;

	public DhrPreviousDwellings() {
		super();
	}
	
	protected Object clone() throws CloneNotSupportedException {
		DhrPreviousDwellings clonedRecord = (DhrPreviousDwellings)super.clone();
		return clonedRecord;
	}
	
	public BaseRecord getDataRecord(Long id) {

		if (id.equals(this.getId()))
			return this;
			
		return super.getDataRecord(id);
	}

    public void load(DhrPreviousDwelling request) {
    	if (request != null) {

			if (request.getPreviousDwellingDepartureDate() != null) {
				this.previousDwellingsPreviousDwellingDepartureDate = Calendar.getInstance(); 
	            this.previousDwellingsPreviousDwellingDepartureDate.setTime(request.getPreviousDwellingDepartureDate());
			}
			if (request.getPreviousDwellingArrivalDate() != null) {
				this.previousDwellingsPreviousDwellingArrivalDate = Calendar.getInstance(); 
	            this.previousDwellingsPreviousDwellingArrivalDate.setTime(request.getPreviousDwellingArrivalDate());
			}
			if (request.getPreviousDwellingAddress() != null) {
				this.previousDwellingsPreviousDwellingAddressAdditionalDeliveryInformation = request.getPreviousDwellingAddress().getAdditionalDeliveryInformation();
				this.previousDwellingsPreviousDwellingAddressAdditionalGeographicalInformation = request.getPreviousDwellingAddress().getAdditionalGeographicalInformation();
				this.previousDwellingsPreviousDwellingAddressStreetNumber = request.getPreviousDwellingAddress().getStreetNumber();
				this.previousDwellingsPreviousDwellingAddressStreetName = request.getPreviousDwellingAddress().getStreetName();
				this.previousDwellingsPreviousDwellingAddressPlaceNameOrService = request.getPreviousDwellingAddress().getPlaceNameOrService();
				this.previousDwellingsPreviousDwellingAddressPostalCode = request.getPreviousDwellingAddress().getPostalCode();
				this.previousDwellingsPreviousDwellingAddressCity = request.getPreviousDwellingAddress().getCity();
			}
        }
    }
    
    public void saveRequest(Object xmlRequest) {
        if ((xmlRequest != null) && (xmlRequest instanceof DomesticHelpRequest)) {
            DomesticHelpRequest request = (DomesticHelpRequest)xmlRequest; 
        }
    }
    
    public void saveData(Object xmlRequest) {
        if ((xmlRequest != null) && (xmlRequest instanceof DomesticHelpRequest)) {
            DomesticHelpRequest request = (DomesticHelpRequest)xmlRequest; 

        }
    }
    
	public void setPreviousDwellingsPreviousDwellingDepartureDate(Calendar previousDwellingsPreviousDwellingDepartureDate) {
		this.previousDwellingsPreviousDwellingDepartureDate = previousDwellingsPreviousDwellingDepartureDate;
	}
	
	public Calendar getPreviousDwellingsPreviousDwellingDepartureDate() {
		return this.previousDwellingsPreviousDwellingDepartureDate;
	}

	public void setPreviousDwellingsPreviousDwellingArrivalDate(Calendar previousDwellingsPreviousDwellingArrivalDate) {
		this.previousDwellingsPreviousDwellingArrivalDate = previousDwellingsPreviousDwellingArrivalDate;
	}
	
	public Calendar getPreviousDwellingsPreviousDwellingArrivalDate() {
		return this.previousDwellingsPreviousDwellingArrivalDate;
	}

	public void setPreviousDwellingsPreviousDwellingAddressAdditionalDeliveryInformation(String previousDwellingsPreviousDwellingAddressAdditionalDeliveryInformation) {
		this.previousDwellingsPreviousDwellingAddressAdditionalDeliveryInformation = previousDwellingsPreviousDwellingAddressAdditionalDeliveryInformation;
	}
	
	public String getPreviousDwellingsPreviousDwellingAddressAdditionalDeliveryInformation() {
		return this.previousDwellingsPreviousDwellingAddressAdditionalDeliveryInformation;
	}

	public void setPreviousDwellingsPreviousDwellingAddressAdditionalGeographicalInformation(String previousDwellingsPreviousDwellingAddressAdditionalGeographicalInformation) {
		this.previousDwellingsPreviousDwellingAddressAdditionalGeographicalInformation = previousDwellingsPreviousDwellingAddressAdditionalGeographicalInformation;
	}
	
	public String getPreviousDwellingsPreviousDwellingAddressAdditionalGeographicalInformation() {
		return this.previousDwellingsPreviousDwellingAddressAdditionalGeographicalInformation;
	}

	public void setPreviousDwellingsPreviousDwellingAddressStreetNumber(String previousDwellingsPreviousDwellingAddressStreetNumber) {
		this.previousDwellingsPreviousDwellingAddressStreetNumber = previousDwellingsPreviousDwellingAddressStreetNumber;
	}
	
	public String getPreviousDwellingsPreviousDwellingAddressStreetNumber() {
		return this.previousDwellingsPreviousDwellingAddressStreetNumber;
	}

	public void setPreviousDwellingsPreviousDwellingAddressStreetName(String previousDwellingsPreviousDwellingAddressStreetName) {
		this.previousDwellingsPreviousDwellingAddressStreetName = previousDwellingsPreviousDwellingAddressStreetName;
	}
	
	public String getPreviousDwellingsPreviousDwellingAddressStreetName() {
		return this.previousDwellingsPreviousDwellingAddressStreetName;
	}

	public void setPreviousDwellingsPreviousDwellingAddressPlaceNameOrService(String previousDwellingsPreviousDwellingAddressPlaceNameOrService) {
		this.previousDwellingsPreviousDwellingAddressPlaceNameOrService = previousDwellingsPreviousDwellingAddressPlaceNameOrService;
	}
	
	public String getPreviousDwellingsPreviousDwellingAddressPlaceNameOrService() {
		return this.previousDwellingsPreviousDwellingAddressPlaceNameOrService;
	}

	public void setPreviousDwellingsPreviousDwellingAddressPostalCode(String previousDwellingsPreviousDwellingAddressPostalCode) {
		this.previousDwellingsPreviousDwellingAddressPostalCode = previousDwellingsPreviousDwellingAddressPostalCode;
	}
	
	public String getPreviousDwellingsPreviousDwellingAddressPostalCode() {
		return this.previousDwellingsPreviousDwellingAddressPostalCode;
	}

	public void setPreviousDwellingsPreviousDwellingAddressCity(String previousDwellingsPreviousDwellingAddressCity) {
		this.previousDwellingsPreviousDwellingAddressCity = previousDwellingsPreviousDwellingAddressCity;
	}
	
	public String getPreviousDwellingsPreviousDwellingAddressCity() {
		return this.previousDwellingsPreviousDwellingAddressCity;
	}

}

