package fr.cg95.cvq.fo.social.domestichelp.form;

import java.util.Calendar;
import java.util.Collection;
import java.util.List;
import javax.servlet.http.HttpSession;
import fr.cg95.cvq.wizard.*;
import fr.cg95.cvq.xml.common.*;
import fr.cg95.cvq.xml.social.*;
import fr.cg95.cvq.xml.social.DomesticHelpRequestDocument.DomesticHelpRequest;

public class Residences extends IStageForm {

	private java.math.BigInteger currentDwellingCurrentDwellingNetFloorArea;
	private java.math.BigInteger currentDwellingCurrentDwellingRoomNumber;
	private String currentDwellingCurrentDwellingStatus;
	private Calendar previousDwellingPreviousDwellingDepartureDate;
	private Calendar currentDwellingCurrentDwellingArrivalDate;
	private String currentDwellingCurrentDwellingPersonalPhone;
  	private String previousDwellingPreviousDwellingAddressAdditionalDeliveryInformation;
	private String previousDwellingPreviousDwellingAddressAdditionalGeographicalInformation;
	private String previousDwellingPreviousDwellingAddressStreetNumber;
	private String previousDwellingPreviousDwellingAddressStreetName;
	private String previousDwellingPreviousDwellingAddressPlaceNameOrService;
	private String previousDwellingPreviousDwellingAddressPostalCode;
	private String previousDwellingPreviousDwellingAddressCity;
  	private String currentDwellingCurrentDwellingAddressAdditionalDeliveryInformation;
	private String currentDwellingCurrentDwellingAddressAdditionalGeographicalInformation;
	private String currentDwellingCurrentDwellingAddressStreetNumber;
	private String currentDwellingCurrentDwellingAddressStreetName;
	private String currentDwellingCurrentDwellingAddressPlaceNameOrService;
	private String currentDwellingCurrentDwellingAddressPostalCode;
	private String currentDwellingCurrentDwellingAddressCity;
	private Calendar previousDwellingPreviousDwellingArrivalDate;
	private String currentDwellingCurrentDwellingType;

	public Residences() {
		super();
	}
	
	public void reset(String state) {
		if (state.equals("previous")) {
		}
		if (state.equals("displayprevious")) {
		}
		if (state.equals("current")) {
		}
		if (state.equals("display")) {
		}
	}
	
	public void load(HttpSession session, Object xmlbRequest) {
		if ((xmlbRequest != null) && (xmlbRequest instanceof DomesticHelpRequest)) {
			DomesticHelpRequest request = (DomesticHelpRequest)xmlbRequest;
			this.currentDwellingCurrentDwellingNetFloorArea = request.getCurrentDwelling().getCurrentDwellingNetFloorArea();
			this.currentDwellingCurrentDwellingRoomNumber = request.getCurrentDwelling().getCurrentDwellingRoomNumber();
			if (request.getCurrentDwelling().getCurrentDwellingStatus() != null)
			this.currentDwellingCurrentDwellingStatus = request.getCurrentDwelling().getCurrentDwellingStatus().toString();
			this.previousDwellingPreviousDwellingDepartureDate = request.getPreviousDwelling().getPreviousDwellingDepartureDate();
			this.currentDwellingCurrentDwellingArrivalDate = request.getCurrentDwelling().getCurrentDwellingArrivalDate();
			this.currentDwellingCurrentDwellingPersonalPhone = request.getCurrentDwelling().getCurrentDwellingPersonalPhone();
  			this.previousDwellingPreviousDwellingAddressAdditionalDeliveryInformation = request.getPreviousDwelling().getPreviousDwellingAddress().getAdditionalDeliveryInformation();
			this.previousDwellingPreviousDwellingAddressAdditionalGeographicalInformation = request.getPreviousDwelling().getPreviousDwellingAddress().getAdditionalGeographicalInformation();
			this.previousDwellingPreviousDwellingAddressStreetNumber = request.getPreviousDwelling().getPreviousDwellingAddress().getStreetNumber();
			this.previousDwellingPreviousDwellingAddressStreetName = request.getPreviousDwelling().getPreviousDwellingAddress().getStreetName();
			this.previousDwellingPreviousDwellingAddressPlaceNameOrService = request.getPreviousDwelling().getPreviousDwellingAddress().getPlaceNameOrService();
			this.previousDwellingPreviousDwellingAddressPostalCode = request.getPreviousDwelling().getPreviousDwellingAddress().getPostalCode();
			this.previousDwellingPreviousDwellingAddressCity = request.getPreviousDwelling().getPreviousDwellingAddress().getCity();
  			this.currentDwellingCurrentDwellingAddressAdditionalDeliveryInformation = request.getCurrentDwelling().getCurrentDwellingAddress().getAdditionalDeliveryInformation();
			this.currentDwellingCurrentDwellingAddressAdditionalGeographicalInformation = request.getCurrentDwelling().getCurrentDwellingAddress().getAdditionalGeographicalInformation();
			this.currentDwellingCurrentDwellingAddressStreetNumber = request.getCurrentDwelling().getCurrentDwellingAddress().getStreetNumber();
			this.currentDwellingCurrentDwellingAddressStreetName = request.getCurrentDwelling().getCurrentDwellingAddress().getStreetName();
			this.currentDwellingCurrentDwellingAddressPlaceNameOrService = request.getCurrentDwelling().getCurrentDwellingAddress().getPlaceNameOrService();
			this.currentDwellingCurrentDwellingAddressPostalCode = request.getCurrentDwelling().getCurrentDwellingAddress().getPostalCode();
			this.currentDwellingCurrentDwellingAddressCity = request.getCurrentDwelling().getCurrentDwellingAddress().getCity();
			this.previousDwellingPreviousDwellingArrivalDate = request.getPreviousDwelling().getPreviousDwellingArrivalDate();
			if (request.getCurrentDwelling().getCurrentDwellingType() != null)
			this.currentDwellingCurrentDwellingType = request.getCurrentDwelling().getCurrentDwellingType().toString();
		}
	}
	
	public void save(HttpSession session, Object xmlbRequest) {
		if ((xmlbRequest != null) && (xmlbRequest instanceof DomesticHelpRequest)) {
			DomesticHelpRequest request = (DomesticHelpRequest)xmlbRequest;
			request.getCurrentDwelling().setCurrentDwellingNetFloorArea(this.currentDwellingCurrentDwellingNetFloorArea);
			request.getCurrentDwelling().setCurrentDwellingRoomNumber(this.currentDwellingCurrentDwellingRoomNumber);
			request.getCurrentDwelling().setCurrentDwellingStatus(DhrDwellingStatusType.Enum.forString(this.currentDwellingCurrentDwellingStatus));
			request.getPreviousDwelling().setPreviousDwellingDepartureDate(this.previousDwellingPreviousDwellingDepartureDate);
			request.getCurrentDwelling().setCurrentDwellingArrivalDate(this.currentDwellingCurrentDwellingArrivalDate);
			request.getCurrentDwelling().setCurrentDwellingPersonalPhone(this.currentDwellingCurrentDwellingPersonalPhone);
  			request.getPreviousDwelling().getPreviousDwellingAddress().setAdditionalDeliveryInformation(this.previousDwellingPreviousDwellingAddressAdditionalDeliveryInformation);
			request.getPreviousDwelling().getPreviousDwellingAddress().setAdditionalGeographicalInformation(this.previousDwellingPreviousDwellingAddressAdditionalGeographicalInformation);
			request.getPreviousDwelling().getPreviousDwellingAddress().setStreetNumber(this.previousDwellingPreviousDwellingAddressStreetNumber);
			request.getPreviousDwelling().getPreviousDwellingAddress().setStreetName(this.previousDwellingPreviousDwellingAddressStreetName);
			request.getPreviousDwelling().getPreviousDwellingAddress().setPlaceNameOrService(this.previousDwellingPreviousDwellingAddressPlaceNameOrService);
			request.getPreviousDwelling().getPreviousDwellingAddress().setPostalCode(this.previousDwellingPreviousDwellingAddressPostalCode);
			request.getPreviousDwelling().getPreviousDwellingAddress().setCity(this.previousDwellingPreviousDwellingAddressCity);
  			request.getCurrentDwelling().getCurrentDwellingAddress().setAdditionalDeliveryInformation(this.currentDwellingCurrentDwellingAddressAdditionalDeliveryInformation);
			request.getCurrentDwelling().getCurrentDwellingAddress().setAdditionalGeographicalInformation(this.currentDwellingCurrentDwellingAddressAdditionalGeographicalInformation);
			request.getCurrentDwelling().getCurrentDwellingAddress().setStreetNumber(this.currentDwellingCurrentDwellingAddressStreetNumber);
			request.getCurrentDwelling().getCurrentDwellingAddress().setStreetName(this.currentDwellingCurrentDwellingAddressStreetName);
			request.getCurrentDwelling().getCurrentDwellingAddress().setPlaceNameOrService(this.currentDwellingCurrentDwellingAddressPlaceNameOrService);
			request.getCurrentDwelling().getCurrentDwellingAddress().setPostalCode(this.currentDwellingCurrentDwellingAddressPostalCode);
			request.getCurrentDwelling().getCurrentDwellingAddress().setCity(this.currentDwellingCurrentDwellingAddressCity);
			request.getPreviousDwelling().setPreviousDwellingArrivalDate(this.previousDwellingPreviousDwellingArrivalDate);
			request.getCurrentDwelling().setCurrentDwellingType(DhrDwellingType.Enum.forString(this.currentDwellingCurrentDwellingType));
		}
	}
	
	public boolean isComplete() {
		if (this.checkCurrentDwellingCurrentDwellingNetFloorArea() && (this.currentDwellingCurrentDwellingNetFloorArea == null))
			return false;
		if (this.checkCurrentDwellingCurrentDwellingRoomNumber() && (this.currentDwellingCurrentDwellingRoomNumber == null))
			return false;
		if (this.checkCurrentDwellingCurrentDwellingStatus() &&
			((this.currentDwellingCurrentDwellingStatus == null) || (this.currentDwellingCurrentDwellingStatus.length() == 0)))
			return false;
		if (this.checkPreviousDwellingPreviousDwellingDepartureDate() && (this.previousDwellingPreviousDwellingDepartureDate == null))
			return false;
		if (this.checkCurrentDwellingCurrentDwellingArrivalDate() && (this.currentDwellingCurrentDwellingArrivalDate == null))
			return false;
  		if (this.checkPreviousDwellingPreviousDwellingAddressStreetName() &&
			((this.previousDwellingPreviousDwellingAddressStreetName == null) || (this.previousDwellingPreviousDwellingAddressStreetName.length() == 0)))
			return false;
		if (this.checkPreviousDwellingPreviousDwellingAddressPostalCode() &&
			((this.previousDwellingPreviousDwellingAddressPostalCode == null) || (this.previousDwellingPreviousDwellingAddressPostalCode.length() == 0)))
			return false;
		if (this.checkPreviousDwellingPreviousDwellingAddressCity() &&
			((this.previousDwellingPreviousDwellingAddressCity == null) || (this.previousDwellingPreviousDwellingAddressCity.length() == 0)))
			return false;
  		if (this.checkCurrentDwellingCurrentDwellingAddressStreetName() &&
			((this.currentDwellingCurrentDwellingAddressStreetName == null) || (this.currentDwellingCurrentDwellingAddressStreetName.length() == 0)))
			return false;
		if (this.checkCurrentDwellingCurrentDwellingAddressPostalCode() &&
			((this.currentDwellingCurrentDwellingAddressPostalCode == null) || (this.currentDwellingCurrentDwellingAddressPostalCode.length() == 0)))
			return false;
		if (this.checkCurrentDwellingCurrentDwellingAddressCity() &&
			((this.currentDwellingCurrentDwellingAddressCity == null) || (this.currentDwellingCurrentDwellingAddressCity.length() == 0)))
			return false;
		if (this.checkPreviousDwellingPreviousDwellingArrivalDate() && (this.previousDwellingPreviousDwellingArrivalDate == null))
			return false;
		if (this.checkCurrentDwellingCurrentDwellingType() &&
			((this.currentDwellingCurrentDwellingType == null) || (this.currentDwellingCurrentDwellingType.length() == 0)))
			return false;
		return true;
	}
	
	public void setCurrentDwellingCurrentDwellingNetFloorArea(java.math.BigInteger currentDwellingCurrentDwellingNetFloorArea) {
		this.currentDwellingCurrentDwellingNetFloorArea = currentDwellingCurrentDwellingNetFloorArea;
	}
	
	public java.math.BigInteger getCurrentDwellingCurrentDwellingNetFloorArea() {
		return this.currentDwellingCurrentDwellingNetFloorArea;
	}
	
	public boolean checkCurrentDwellingCurrentDwellingNetFloorArea() {
		return currentDwellingCurrentDwellingType.equals("Domicile");
	}

	public void setCurrentDwellingCurrentDwellingRoomNumber(java.math.BigInteger currentDwellingCurrentDwellingRoomNumber) {
		this.currentDwellingCurrentDwellingRoomNumber = currentDwellingCurrentDwellingRoomNumber;
	}
	
	public java.math.BigInteger getCurrentDwellingCurrentDwellingRoomNumber() {
		return this.currentDwellingCurrentDwellingRoomNumber;
	}
	
	public boolean checkCurrentDwellingCurrentDwellingRoomNumber() {
		return currentDwellingCurrentDwellingType.equals("Domicile");
	}

	public void setCurrentDwellingCurrentDwellingStatus(String currentDwellingCurrentDwellingStatus) {
		this.currentDwellingCurrentDwellingStatus = currentDwellingCurrentDwellingStatus;
	}
	
	public String getCurrentDwellingCurrentDwellingStatus() {
		return this.currentDwellingCurrentDwellingStatus;
	}
	
	public boolean checkCurrentDwellingCurrentDwellingStatus() {
		return currentDwellingCurrentDwellingType.equals("Domicile");
	}

	public void setPreviousDwellingPreviousDwellingDepartureDate(Calendar previousDwellingPreviousDwellingDepartureDate) {
		this.previousDwellingPreviousDwellingDepartureDate = previousDwellingPreviousDwellingDepartureDate;
	}
	
	public Calendar getPreviousDwellingPreviousDwellingDepartureDate() {
		return this.previousDwellingPreviousDwellingDepartureDate;
	}
	
	public boolean checkPreviousDwellingPreviousDwellingDepartureDate() {
		return false;
	}

	public void setCurrentDwellingCurrentDwellingArrivalDate(Calendar currentDwellingCurrentDwellingArrivalDate) {
		this.currentDwellingCurrentDwellingArrivalDate = currentDwellingCurrentDwellingArrivalDate;
	}
	
	public Calendar getCurrentDwellingCurrentDwellingArrivalDate() {
		return this.currentDwellingCurrentDwellingArrivalDate;
	}
	
	public boolean checkCurrentDwellingCurrentDwellingArrivalDate() {
		return true;
	}

	public void setCurrentDwellingCurrentDwellingPersonalPhone(String currentDwellingCurrentDwellingPersonalPhone) {
		this.currentDwellingCurrentDwellingPersonalPhone = currentDwellingCurrentDwellingPersonalPhone;
	}
	
	public String getCurrentDwellingCurrentDwellingPersonalPhone() {
		return this.currentDwellingCurrentDwellingPersonalPhone;
	}
	
	public boolean checkCurrentDwellingCurrentDwellingPersonalPhone() {
		return true;
	}

  	public void setPreviousDwellingPreviousDwellingAddressAdditionalDeliveryInformation(String previousDwellingPreviousDwellingAddressAdditionalDeliveryInformation) {
		this.previousDwellingPreviousDwellingAddressAdditionalDeliveryInformation = previousDwellingPreviousDwellingAddressAdditionalDeliveryInformation;
	}
	
	public String getPreviousDwellingPreviousDwellingAddressAdditionalDeliveryInformation() {
		return this.previousDwellingPreviousDwellingAddressAdditionalDeliveryInformation;
	}
	
	public boolean checkPreviousDwellingPreviousDwellingAddressAdditionalDeliveryInformation() {
		return true;
	}

	public void setPreviousDwellingPreviousDwellingAddressAdditionalGeographicalInformation(String previousDwellingPreviousDwellingAddressAdditionalGeographicalInformation) {
		this.previousDwellingPreviousDwellingAddressAdditionalGeographicalInformation = previousDwellingPreviousDwellingAddressAdditionalGeographicalInformation;
	}
	
	public String getPreviousDwellingPreviousDwellingAddressAdditionalGeographicalInformation() {
		return this.previousDwellingPreviousDwellingAddressAdditionalGeographicalInformation;
	}
	
	public boolean checkPreviousDwellingPreviousDwellingAddressAdditionalGeographicalInformation() {
		return true;
	}

	public void setPreviousDwellingPreviousDwellingAddressStreetNumber(String previousDwellingPreviousDwellingAddressStreetNumber) {
		this.previousDwellingPreviousDwellingAddressStreetNumber = previousDwellingPreviousDwellingAddressStreetNumber;
	}
	
	public String getPreviousDwellingPreviousDwellingAddressStreetNumber() {
		return this.previousDwellingPreviousDwellingAddressStreetNumber;
	}
	
	public boolean checkPreviousDwellingPreviousDwellingAddressStreetNumber() {
		return true;
	}

	public void setPreviousDwellingPreviousDwellingAddressStreetName(String previousDwellingPreviousDwellingAddressStreetName) {
		this.previousDwellingPreviousDwellingAddressStreetName = previousDwellingPreviousDwellingAddressStreetName;
	}
	
	public String getPreviousDwellingPreviousDwellingAddressStreetName() {
		return this.previousDwellingPreviousDwellingAddressStreetName;
	}
	
	public boolean checkPreviousDwellingPreviousDwellingAddressStreetName() {
		return false;
	}

	public void setPreviousDwellingPreviousDwellingAddressPlaceNameOrService(String previousDwellingPreviousDwellingAddressPlaceNameOrService) {
		this.previousDwellingPreviousDwellingAddressPlaceNameOrService = previousDwellingPreviousDwellingAddressPlaceNameOrService;
	}
	
	public String getPreviousDwellingPreviousDwellingAddressPlaceNameOrService() {
		return this.previousDwellingPreviousDwellingAddressPlaceNameOrService;
	}
	
	public boolean checkPreviousDwellingPreviousDwellingAddressPlaceNameOrService() {
		return true;
	}

	public void setPreviousDwellingPreviousDwellingAddressPostalCode(String previousDwellingPreviousDwellingAddressPostalCode) {
		this.previousDwellingPreviousDwellingAddressPostalCode = previousDwellingPreviousDwellingAddressPostalCode;
	}
	
	public String getPreviousDwellingPreviousDwellingAddressPostalCode() {
		return this.previousDwellingPreviousDwellingAddressPostalCode;
	}
	
	public boolean checkPreviousDwellingPreviousDwellingAddressPostalCode() {
		return false;
	}

	public void setPreviousDwellingPreviousDwellingAddressCity(String previousDwellingPreviousDwellingAddressCity) {
		this.previousDwellingPreviousDwellingAddressCity = previousDwellingPreviousDwellingAddressCity;
	}
	
	public String getPreviousDwellingPreviousDwellingAddressCity() {
		return this.previousDwellingPreviousDwellingAddressCity;
	}
	
	public boolean checkPreviousDwellingPreviousDwellingAddressCity() {
		return false;
	}

  	public void setCurrentDwellingCurrentDwellingAddressAdditionalDeliveryInformation(String currentDwellingCurrentDwellingAddressAdditionalDeliveryInformation) {
		this.currentDwellingCurrentDwellingAddressAdditionalDeliveryInformation = currentDwellingCurrentDwellingAddressAdditionalDeliveryInformation;
	}
	
	public String getCurrentDwellingCurrentDwellingAddressAdditionalDeliveryInformation() {
		return this.currentDwellingCurrentDwellingAddressAdditionalDeliveryInformation;
	}
	
	public boolean checkCurrentDwellingCurrentDwellingAddressAdditionalDeliveryInformation() {
		return true;
	}

	public void setCurrentDwellingCurrentDwellingAddressAdditionalGeographicalInformation(String currentDwellingCurrentDwellingAddressAdditionalGeographicalInformation) {
		this.currentDwellingCurrentDwellingAddressAdditionalGeographicalInformation = currentDwellingCurrentDwellingAddressAdditionalGeographicalInformation;
	}
	
	public String getCurrentDwellingCurrentDwellingAddressAdditionalGeographicalInformation() {
		return this.currentDwellingCurrentDwellingAddressAdditionalGeographicalInformation;
	}
	
	public boolean checkCurrentDwellingCurrentDwellingAddressAdditionalGeographicalInformation() {
		return true;
	}

	public void setCurrentDwellingCurrentDwellingAddressStreetNumber(String currentDwellingCurrentDwellingAddressStreetNumber) {
		this.currentDwellingCurrentDwellingAddressStreetNumber = currentDwellingCurrentDwellingAddressStreetNumber;
	}
	
	public String getCurrentDwellingCurrentDwellingAddressStreetNumber() {
		return this.currentDwellingCurrentDwellingAddressStreetNumber;
	}
	
	public boolean checkCurrentDwellingCurrentDwellingAddressStreetNumber() {
		return true;
	}

	public void setCurrentDwellingCurrentDwellingAddressStreetName(String currentDwellingCurrentDwellingAddressStreetName) {
		this.currentDwellingCurrentDwellingAddressStreetName = currentDwellingCurrentDwellingAddressStreetName;
	}
	
	public String getCurrentDwellingCurrentDwellingAddressStreetName() {
		return this.currentDwellingCurrentDwellingAddressStreetName;
	}
	
	public boolean checkCurrentDwellingCurrentDwellingAddressStreetName() {
		return true;
	}

	public void setCurrentDwellingCurrentDwellingAddressPlaceNameOrService(String currentDwellingCurrentDwellingAddressPlaceNameOrService) {
		this.currentDwellingCurrentDwellingAddressPlaceNameOrService = currentDwellingCurrentDwellingAddressPlaceNameOrService;
	}
	
	public String getCurrentDwellingCurrentDwellingAddressPlaceNameOrService() {
		return this.currentDwellingCurrentDwellingAddressPlaceNameOrService;
	}
	
	public boolean checkCurrentDwellingCurrentDwellingAddressPlaceNameOrService() {
		return true;
	}

	public void setCurrentDwellingCurrentDwellingAddressPostalCode(String currentDwellingCurrentDwellingAddressPostalCode) {
		this.currentDwellingCurrentDwellingAddressPostalCode = currentDwellingCurrentDwellingAddressPostalCode;
	}
	
	public String getCurrentDwellingCurrentDwellingAddressPostalCode() {
		return this.currentDwellingCurrentDwellingAddressPostalCode;
	}
	
	public boolean checkCurrentDwellingCurrentDwellingAddressPostalCode() {
		return true;
	}

	public void setCurrentDwellingCurrentDwellingAddressCity(String currentDwellingCurrentDwellingAddressCity) {
		this.currentDwellingCurrentDwellingAddressCity = currentDwellingCurrentDwellingAddressCity;
	}
	
	public String getCurrentDwellingCurrentDwellingAddressCity() {
		return this.currentDwellingCurrentDwellingAddressCity;
	}
	
	public boolean checkCurrentDwellingCurrentDwellingAddressCity() {
		return true;
	}

	public void setPreviousDwellingPreviousDwellingArrivalDate(Calendar previousDwellingPreviousDwellingArrivalDate) {
		this.previousDwellingPreviousDwellingArrivalDate = previousDwellingPreviousDwellingArrivalDate;
	}
	
	public Calendar getPreviousDwellingPreviousDwellingArrivalDate() {
		return this.previousDwellingPreviousDwellingArrivalDate;
	}
	
	public boolean checkPreviousDwellingPreviousDwellingArrivalDate() {
		return false;
	}

	public void setCurrentDwellingCurrentDwellingType(String currentDwellingCurrentDwellingType) {
		this.currentDwellingCurrentDwellingType = currentDwellingCurrentDwellingType;
	}
	
	public String getCurrentDwellingCurrentDwellingType() {
		return this.currentDwellingCurrentDwellingType;
	}
	
	public boolean checkCurrentDwellingCurrentDwellingType() {
		return true;
	}

}