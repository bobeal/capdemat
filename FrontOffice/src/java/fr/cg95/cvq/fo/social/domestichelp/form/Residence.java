package fr.cg95.cvq.fo.social.domestichelp.form;

import java.util.Calendar;
import java.util.Collection;
import java.util.List;
import javax.servlet.http.HttpSession;
import fr.cg95.cvq.wizard.*;
import fr.cg95.cvq.xml.common.*;
import fr.cg95.cvq.xml.social.*;
import fr.cg95.cvq.xml.social.DomesticHelpRequestDocument.DomesticHelpRequest;

public class Residence extends IStageForm {

	private List previousDwellings;
	private java.math.BigInteger currentDwellingCurrentDwellingNetFloorArea;
	private java.math.BigInteger currentDwellingCurrentDwellingRoomNumber;
	private String currentDwellingCurrentDwellingStatus;
	private Calendar currentDwellingCurrentDwellingArrivalDate;
  	private String currentDwellingCurrentDwellingAddressAdditionalDeliveryInformation;
	private String currentDwellingCurrentDwellingAddressAdditionalGeographicalInformation;
	private String currentDwellingCurrentDwellingAddressStreetNumber;
	private String currentDwellingCurrentDwellingAddressStreetName;
	private String currentDwellingCurrentDwellingAddressPlaceNameOrService;
	private String currentDwellingCurrentDwellingAddressPostalCode;
	private String currentDwellingCurrentDwellingAddressCity;
	private String currentDwellingCurrentDwellingType;

	public Residence() {
		super();
	}
	
	public void reset(String state) {
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
			this.currentDwellingCurrentDwellingArrivalDate = request.getCurrentDwelling().getCurrentDwellingArrivalDate();
  			this.currentDwellingCurrentDwellingAddressAdditionalDeliveryInformation = request.getCurrentDwelling().getCurrentDwellingAddress().getAdditionalDeliveryInformation();
			this.currentDwellingCurrentDwellingAddressAdditionalGeographicalInformation = request.getCurrentDwelling().getCurrentDwellingAddress().getAdditionalGeographicalInformation();
			this.currentDwellingCurrentDwellingAddressStreetNumber = request.getCurrentDwelling().getCurrentDwellingAddress().getStreetNumber();
			this.currentDwellingCurrentDwellingAddressStreetName = request.getCurrentDwelling().getCurrentDwellingAddress().getStreetName();
			this.currentDwellingCurrentDwellingAddressPlaceNameOrService = request.getCurrentDwelling().getCurrentDwellingAddress().getPlaceNameOrService();
			this.currentDwellingCurrentDwellingAddressPostalCode = request.getCurrentDwelling().getCurrentDwellingAddress().getPostalCode();
			this.currentDwellingCurrentDwellingAddressCity = request.getCurrentDwelling().getCurrentDwellingAddress().getCity();
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
			request.getCurrentDwelling().setCurrentDwellingArrivalDate(this.currentDwellingCurrentDwellingArrivalDate);
  			request.getCurrentDwelling().getCurrentDwellingAddress().setAdditionalDeliveryInformation(this.currentDwellingCurrentDwellingAddressAdditionalDeliveryInformation);
			request.getCurrentDwelling().getCurrentDwellingAddress().setAdditionalGeographicalInformation(this.currentDwellingCurrentDwellingAddressAdditionalGeographicalInformation);
			request.getCurrentDwelling().getCurrentDwellingAddress().setStreetNumber(this.currentDwellingCurrentDwellingAddressStreetNumber);
			request.getCurrentDwelling().getCurrentDwellingAddress().setStreetName(this.currentDwellingCurrentDwellingAddressStreetName);
			request.getCurrentDwelling().getCurrentDwellingAddress().setPlaceNameOrService(this.currentDwellingCurrentDwellingAddressPlaceNameOrService);
			request.getCurrentDwelling().getCurrentDwellingAddress().setPostalCode(this.currentDwellingCurrentDwellingAddressPostalCode);
			request.getCurrentDwelling().getCurrentDwellingAddress().setCity(this.currentDwellingCurrentDwellingAddressCity);
			request.getCurrentDwelling().setCurrentDwellingType(DhrDwellingType.Enum.forString(this.currentDwellingCurrentDwellingType));
		}
	}
	
	public boolean isComplete() {
  		if (this.checkCurrentDwellingCurrentDwellingAddressStreetName() &&
			((this.currentDwellingCurrentDwellingAddressStreetName == null) || (this.currentDwellingCurrentDwellingAddressStreetName.length() == 0)))
			return false;
		if (this.checkCurrentDwellingCurrentDwellingAddressPostalCode() &&
			((this.currentDwellingCurrentDwellingAddressPostalCode == null) || (this.currentDwellingCurrentDwellingAddressPostalCode.length() == 0)))
			return false;
		if (this.checkCurrentDwellingCurrentDwellingAddressCity() &&
			((this.currentDwellingCurrentDwellingAddressCity == null) || (this.currentDwellingCurrentDwellingAddressCity.length() == 0)))
			return false;
		return true;
	}
	
	public void setPreviousDwellings(List previousDwellings) {
		this.previousDwellings = previousDwellings;
	}
	
	public List getPreviousDwellings() {
		return this.previousDwellings;
	}
	
	public boolean checkPreviousDwellings() {
		return true;
	}

    public int getSizeOfPreviousDwellings() {
        return this.previousDwellings.size();
    }

	public void setCurrentDwellingCurrentDwellingNetFloorArea(java.math.BigInteger currentDwellingCurrentDwellingNetFloorArea) {
		this.currentDwellingCurrentDwellingNetFloorArea = currentDwellingCurrentDwellingNetFloorArea;
	}
	
	public java.math.BigInteger getCurrentDwellingCurrentDwellingNetFloorArea() {
		return this.currentDwellingCurrentDwellingNetFloorArea;
	}
	
	public boolean checkCurrentDwellingCurrentDwellingNetFloorArea() {
		return !currentDwellingCurrentDwellingType.equals("Domicile");
	}

	public void setCurrentDwellingCurrentDwellingRoomNumber(java.math.BigInteger currentDwellingCurrentDwellingRoomNumber) {
		this.currentDwellingCurrentDwellingRoomNumber = currentDwellingCurrentDwellingRoomNumber;
	}
	
	public java.math.BigInteger getCurrentDwellingCurrentDwellingRoomNumber() {
		return this.currentDwellingCurrentDwellingRoomNumber;
	}
	
	public boolean checkCurrentDwellingCurrentDwellingRoomNumber() {
		return !currentDwellingCurrentDwellingType.equals("Domicile");
	}

	public void setCurrentDwellingCurrentDwellingStatus(String currentDwellingCurrentDwellingStatus) {
		this.currentDwellingCurrentDwellingStatus = currentDwellingCurrentDwellingStatus;
	}
	
	public String getCurrentDwellingCurrentDwellingStatus() {
		return this.currentDwellingCurrentDwellingStatus;
	}
	
	public boolean checkCurrentDwellingCurrentDwellingStatus() {
		return !currentDwellingCurrentDwellingType.equals("Domicile");
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
