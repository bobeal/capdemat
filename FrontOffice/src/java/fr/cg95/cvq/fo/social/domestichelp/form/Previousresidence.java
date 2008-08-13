package fr.cg95.cvq.fo.social.domestichelp.form;

import java.util.Calendar;
import java.util.Collection;
import java.util.List;
import javax.servlet.http.HttpSession;
import fr.cg95.cvq.wizard.*;
import fr.cg95.cvq.xml.common.*;
import fr.cg95.cvq.xml.social.*;
import fr.cg95.cvq.xml.social.DomesticHelpRequestDocument.DomesticHelpRequest;

public class Previousresidence extends IStageForm {

	private Calendar previousDwellingsPreviousDwellingDepartureDate;
  	private String previousDwellingsPreviousDwellingAddressAdditionalDeliveryInformation;
	private String previousDwellingsPreviousDwellingAddressAdditionalGeographicalInformation;
	private String previousDwellingsPreviousDwellingAddressStreetNumber;
	private String previousDwellingsPreviousDwellingAddressStreetName;
	private String previousDwellingsPreviousDwellingAddressPlaceNameOrService;
	private String previousDwellingsPreviousDwellingAddressPostalCode;
	private String previousDwellingsPreviousDwellingAddressCity;
	private Calendar previousDwellingsPreviousDwellingArrivalDate;

	public Previousresidence() {
		super();
	}
	
	public void reset(String state) {
		if (state.equals("displayprevious")) {
		}
		if (state.equals("previous")) {
		}
	}
	
	public void load(HttpSession session, Object xmlbRequest) {
		if ((xmlbRequest != null) && (xmlbRequest instanceof DomesticHelpRequest)) {
			DomesticHelpRequest request = (DomesticHelpRequest)xmlbRequest;
		}
	}
	
	public void save(HttpSession session, Object xmlbRequest) {
		if ((xmlbRequest != null) && (xmlbRequest instanceof DomesticHelpRequest)) {
			DomesticHelpRequest request = (DomesticHelpRequest)xmlbRequest;
		}
	}
	
	public boolean isComplete() {
  		if (this.checkPreviousDwellingsPreviousDwellingAddressStreetName() &&
			((this.previousDwellingsPreviousDwellingAddressStreetName == null) || (this.previousDwellingsPreviousDwellingAddressStreetName.length() == 0)))
			return false;
		if (this.checkPreviousDwellingsPreviousDwellingAddressPostalCode() &&
			((this.previousDwellingsPreviousDwellingAddressPostalCode == null) || (this.previousDwellingsPreviousDwellingAddressPostalCode.length() == 0)))
			return false;
		if (this.checkPreviousDwellingsPreviousDwellingAddressCity() &&
			((this.previousDwellingsPreviousDwellingAddressCity == null) || (this.previousDwellingsPreviousDwellingAddressCity.length() == 0)))
			return false;
		return true;
	}
	
	public void setPreviousDwellingsPreviousDwellingDepartureDate(Calendar previousDwellingsPreviousDwellingDepartureDate) {
		this.previousDwellingsPreviousDwellingDepartureDate = previousDwellingsPreviousDwellingDepartureDate;
	}
	
	public Calendar getPreviousDwellingsPreviousDwellingDepartureDate() {
		return this.previousDwellingsPreviousDwellingDepartureDate;
	}
	
	public boolean checkPreviousDwellingsPreviousDwellingDepartureDate() {
		return true;
	}

  	public void setPreviousDwellingsPreviousDwellingAddressAdditionalDeliveryInformation(String previousDwellingsPreviousDwellingAddressAdditionalDeliveryInformation) {
		this.previousDwellingsPreviousDwellingAddressAdditionalDeliveryInformation = previousDwellingsPreviousDwellingAddressAdditionalDeliveryInformation;
	}
	
	public String getPreviousDwellingsPreviousDwellingAddressAdditionalDeliveryInformation() {
		return this.previousDwellingsPreviousDwellingAddressAdditionalDeliveryInformation;
	}
	
	public boolean checkPreviousDwellingsPreviousDwellingAddressAdditionalDeliveryInformation() {
		return true;
	}

	public void setPreviousDwellingsPreviousDwellingAddressAdditionalGeographicalInformation(String previousDwellingsPreviousDwellingAddressAdditionalGeographicalInformation) {
		this.previousDwellingsPreviousDwellingAddressAdditionalGeographicalInformation = previousDwellingsPreviousDwellingAddressAdditionalGeographicalInformation;
	}
	
	public String getPreviousDwellingsPreviousDwellingAddressAdditionalGeographicalInformation() {
		return this.previousDwellingsPreviousDwellingAddressAdditionalGeographicalInformation;
	}
	
	public boolean checkPreviousDwellingsPreviousDwellingAddressAdditionalGeographicalInformation() {
		return true;
	}

	public void setPreviousDwellingsPreviousDwellingAddressStreetNumber(String previousDwellingsPreviousDwellingAddressStreetNumber) {
		this.previousDwellingsPreviousDwellingAddressStreetNumber = previousDwellingsPreviousDwellingAddressStreetNumber;
	}
	
	public String getPreviousDwellingsPreviousDwellingAddressStreetNumber() {
		return this.previousDwellingsPreviousDwellingAddressStreetNumber;
	}
	
	public boolean checkPreviousDwellingsPreviousDwellingAddressStreetNumber() {
		return true;
	}

	public void setPreviousDwellingsPreviousDwellingAddressStreetName(String previousDwellingsPreviousDwellingAddressStreetName) {
		this.previousDwellingsPreviousDwellingAddressStreetName = previousDwellingsPreviousDwellingAddressStreetName;
	}
	
	public String getPreviousDwellingsPreviousDwellingAddressStreetName() {
		return this.previousDwellingsPreviousDwellingAddressStreetName;
	}
	
	public boolean checkPreviousDwellingsPreviousDwellingAddressStreetName() {
		return true;
	}

	public void setPreviousDwellingsPreviousDwellingAddressPlaceNameOrService(String previousDwellingsPreviousDwellingAddressPlaceNameOrService) {
		this.previousDwellingsPreviousDwellingAddressPlaceNameOrService = previousDwellingsPreviousDwellingAddressPlaceNameOrService;
	}
	
	public String getPreviousDwellingsPreviousDwellingAddressPlaceNameOrService() {
		return this.previousDwellingsPreviousDwellingAddressPlaceNameOrService;
	}
	
	public boolean checkPreviousDwellingsPreviousDwellingAddressPlaceNameOrService() {
		return true;
	}

	public void setPreviousDwellingsPreviousDwellingAddressPostalCode(String previousDwellingsPreviousDwellingAddressPostalCode) {
		this.previousDwellingsPreviousDwellingAddressPostalCode = previousDwellingsPreviousDwellingAddressPostalCode;
	}
	
	public String getPreviousDwellingsPreviousDwellingAddressPostalCode() {
		return this.previousDwellingsPreviousDwellingAddressPostalCode;
	}
	
	public boolean checkPreviousDwellingsPreviousDwellingAddressPostalCode() {
		return true;
	}

	public void setPreviousDwellingsPreviousDwellingAddressCity(String previousDwellingsPreviousDwellingAddressCity) {
		this.previousDwellingsPreviousDwellingAddressCity = previousDwellingsPreviousDwellingAddressCity;
	}
	
	public String getPreviousDwellingsPreviousDwellingAddressCity() {
		return this.previousDwellingsPreviousDwellingAddressCity;
	}
	
	public boolean checkPreviousDwellingsPreviousDwellingAddressCity() {
		return true;
	}

	public void setPreviousDwellingsPreviousDwellingArrivalDate(Calendar previousDwellingsPreviousDwellingArrivalDate) {
		this.previousDwellingsPreviousDwellingArrivalDate = previousDwellingsPreviousDwellingArrivalDate;
	}
	
	public Calendar getPreviousDwellingsPreviousDwellingArrivalDate() {
		return this.previousDwellingsPreviousDwellingArrivalDate;
	}
	
	public boolean checkPreviousDwellingsPreviousDwellingArrivalDate() {
		return true;
	}

}
