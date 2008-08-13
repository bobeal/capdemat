package fr.cg95.cvq.fo.technical.form;

import java.util.Calendar;
import java.util.Collection;
import java.util.List;
import javax.servlet.http.HttpSession;
import fr.cg95.cvq.wizard.*;
import fr.cg95.cvq.xml.common.*;
import fr.cg95.cvq.xml.technical.*;
import fr.cg95.cvq.xml.technical.TechnicalInterventionRequestDocument.TechnicalInterventionRequest;

public class Place extends IStageForm {

  	private String interventionPlaceAdditionalDeliveryInformation;
	private String interventionPlaceAdditionalGeographicalInformation;
	private String interventionPlaceStreetNumber;
	private String interventionPlaceStreetName;
	private String interventionPlacePlaceNameOrService;
	private String interventionPlacePostalCode;
	private String interventionPlaceCity;

	public Place() {
		super();
	}
	
	public void reset(String state) {
		if (state.equals("place")) {
		}
	}
	
	public void load(HttpSession session, Object xmlbRequest) {
		if ((xmlbRequest != null) && (xmlbRequest instanceof TechnicalInterventionRequest)) {
			TechnicalInterventionRequest request = (TechnicalInterventionRequest)xmlbRequest;
  			this.interventionPlaceAdditionalDeliveryInformation = request.getInterventionPlace().getAdditionalDeliveryInformation();
			this.interventionPlaceAdditionalGeographicalInformation = request.getInterventionPlace().getAdditionalGeographicalInformation();
			this.interventionPlaceStreetNumber = request.getInterventionPlace().getStreetNumber();
			this.interventionPlaceStreetName = request.getInterventionPlace().getStreetName();
			this.interventionPlacePlaceNameOrService = request.getInterventionPlace().getPlaceNameOrService();
			this.interventionPlacePostalCode = request.getInterventionPlace().getPostalCode();
			this.interventionPlaceCity = request.getInterventionPlace().getCity();
		}
	}
	
	public void save(HttpSession session, Object xmlbRequest) {
		if ((xmlbRequest != null) && (xmlbRequest instanceof TechnicalInterventionRequest)) {
			TechnicalInterventionRequest request = (TechnicalInterventionRequest)xmlbRequest;
  			request.getInterventionPlace().setAdditionalDeliveryInformation(this.interventionPlaceAdditionalDeliveryInformation);
			request.getInterventionPlace().setAdditionalGeographicalInformation(this.interventionPlaceAdditionalGeographicalInformation);
			request.getInterventionPlace().setStreetNumber(this.interventionPlaceStreetNumber);
			request.getInterventionPlace().setStreetName(this.interventionPlaceStreetName);
			request.getInterventionPlace().setPlaceNameOrService(this.interventionPlacePlaceNameOrService);
			request.getInterventionPlace().setPostalCode(this.interventionPlacePostalCode);
			request.getInterventionPlace().setCity(this.interventionPlaceCity);
		}
	}
	
	public boolean isComplete() {
  		if (this.checkInterventionPlaceStreetName() &&
			((this.interventionPlaceStreetName == null) || (this.interventionPlaceStreetName.length() == 0)))
			return false;
		if (this.checkInterventionPlacePostalCode() &&
			((this.interventionPlacePostalCode == null) || (this.interventionPlacePostalCode.length() == 0)))
			return false;
		if (this.checkInterventionPlaceCity() &&
			((this.interventionPlaceCity == null) || (this.interventionPlaceCity.length() == 0)))
			return false;
		return true;
	}
	
  	public void setInterventionPlaceAdditionalDeliveryInformation(String interventionPlaceAdditionalDeliveryInformation) {
		this.interventionPlaceAdditionalDeliveryInformation = interventionPlaceAdditionalDeliveryInformation;
	}
	
	public String getInterventionPlaceAdditionalDeliveryInformation() {
		return this.interventionPlaceAdditionalDeliveryInformation;
	}
	
	public boolean checkInterventionPlaceAdditionalDeliveryInformation() {
		return true;
	}

	public void setInterventionPlaceAdditionalGeographicalInformation(String interventionPlaceAdditionalGeographicalInformation) {
		this.interventionPlaceAdditionalGeographicalInformation = interventionPlaceAdditionalGeographicalInformation;
	}
	
	public String getInterventionPlaceAdditionalGeographicalInformation() {
		return this.interventionPlaceAdditionalGeographicalInformation;
	}
	
	public boolean checkInterventionPlaceAdditionalGeographicalInformation() {
		return true;
	}

	public void setInterventionPlaceStreetNumber(String interventionPlaceStreetNumber) {
		this.interventionPlaceStreetNumber = interventionPlaceStreetNumber;
	}
	
	public String getInterventionPlaceStreetNumber() {
		return this.interventionPlaceStreetNumber;
	}
	
	public boolean checkInterventionPlaceStreetNumber() {
		return true;
	}

	public void setInterventionPlaceStreetName(String interventionPlaceStreetName) {
		this.interventionPlaceStreetName = interventionPlaceStreetName;
	}
	
	public String getInterventionPlaceStreetName() {
		return this.interventionPlaceStreetName;
	}
	
	public boolean checkInterventionPlaceStreetName() {
		return true;
	}

	public void setInterventionPlacePlaceNameOrService(String interventionPlacePlaceNameOrService) {
		this.interventionPlacePlaceNameOrService = interventionPlacePlaceNameOrService;
	}
	
	public String getInterventionPlacePlaceNameOrService() {
		return this.interventionPlacePlaceNameOrService;
	}
	
	public boolean checkInterventionPlacePlaceNameOrService() {
		return true;
	}

	public void setInterventionPlacePostalCode(String interventionPlacePostalCode) {
		this.interventionPlacePostalCode = interventionPlacePostalCode;
	}
	
	public String getInterventionPlacePostalCode() {
		return this.interventionPlacePostalCode;
	}
	
	public boolean checkInterventionPlacePostalCode() {
		return true;
	}

	public void setInterventionPlaceCity(String interventionPlaceCity) {
		this.interventionPlaceCity = interventionPlaceCity;
	}
	
	public String getInterventionPlaceCity() {
		return this.interventionPlaceCity;
	}
	
	public boolean checkInterventionPlaceCity() {
		return true;
	}

}
