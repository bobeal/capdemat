package fr.cg95.cvq.bo.localpolice;

import java.util.Calendar;
import java.util.List;
import java.util.Set;
import java.util.Vector;

import fr.cg95.cvq.wizard.*;
import fr.cg95.cvq.bo.record.BaseRecord;
import fr.cg95.cvq.bo.record.RequestRecord;
import fr.cg95.cvq.business.authority.*;
import fr.cg95.cvq.business.users.*;
import fr.cg95.cvq.business.localpolice.*;

public class HolidaySecurityRequestRecord extends RequestRecord {

	private String otherContactLastName;
	private boolean rulesAndRegulationsAcceptance;
  	private String otherContactAddressAdditionalDeliveryInformation;
	private String otherContactAddressAdditionalGeographicalInformation;
	private String otherContactAddressStreetNumber;
	private String otherContactAddressStreetName;
	private String otherContactAddressPlaceNameOrService;
	private String otherContactAddressPostalCode;
	private String otherContactAddressCity;
	private boolean light;
	private String subjectAdultEmail;
	private Calendar absenceEndDate;
	private Calendar absenceStartDate;
	private String subjectAdultLastName;
	private String alertPhone;
	private boolean alarm;
	private String otherContactPhone;
	private String subjectAdultMobilePhone;
  	private String subjectAdultAddressAdditionalDeliveryInformation;
	private String subjectAdultAddressAdditionalGeographicalInformation;
	private String subjectAdultAddressStreetNumber;
	private String subjectAdultAddressStreetName;
	private String subjectAdultAddressPlaceNameOrService;
	private String subjectAdultAddressPostalCode;
	private String subjectAdultAddressCity;
	private String otherContactFirstName;
	private String subjectAdultFirstName;

	public HolidaySecurityRequestRecord() {
		super();
	}
	
	protected Object clone() throws CloneNotSupportedException {
		HolidaySecurityRequestRecord clonedRecord = (HolidaySecurityRequestRecord)super.clone();
		return clonedRecord;
	}
	
	public BaseRecord getDataRecord(Long id) {

		if (id.equals(this.getId()))
			return this;
			
		return super.getDataRecord(id);
	}

    public void load(Object xmlRequest) {
        if ((xmlRequest != null) && (xmlRequest instanceof HolidaySecurityRequest)) {
            HolidaySecurityRequest request = (HolidaySecurityRequest)xmlRequest; 

			this.otherContactLastName = request.getOtherContactLastName();
            if ((request.getRulesAndRegulationsAcceptance() != null))
			this.rulesAndRegulationsAcceptance = request.getRulesAndRegulationsAcceptance();
			if (request.getOtherContactAddress() != null) {
				this.otherContactAddressAdditionalDeliveryInformation = request.getOtherContactAddress().getAdditionalDeliveryInformation();
				this.otherContactAddressAdditionalGeographicalInformation = request.getOtherContactAddress().getAdditionalGeographicalInformation();
				this.otherContactAddressStreetNumber = request.getOtherContactAddress().getStreetNumber();
				this.otherContactAddressStreetName = request.getOtherContactAddress().getStreetName();
				this.otherContactAddressPlaceNameOrService = request.getOtherContactAddress().getPlaceNameOrService();
				this.otherContactAddressPostalCode = request.getOtherContactAddress().getPostalCode();
				this.otherContactAddressCity = request.getOtherContactAddress().getCity();
			}
            if ((request.getLight() != null))
			this.light = request.getLight();
			this.subjectAdultEmail = ((Adult)request.getSubject()).getEmail();
			if (request.getAbsenceEndDate() != null) {
				this.absenceEndDate = Calendar.getInstance(); 
	            this.absenceEndDate.setTime(request.getAbsenceEndDate());
			}
			if (request.getAbsenceStartDate() != null) {
				this.absenceStartDate = Calendar.getInstance(); 
	            this.absenceStartDate.setTime(request.getAbsenceStartDate());
			}
			this.subjectAdultLastName = ((Adult)request.getSubject()).getLastName();
			this.alertPhone = request.getAlertPhone();
            if ((request.getAlarm() != null))
			this.alarm = request.getAlarm();
			this.otherContactPhone = request.getOtherContactPhone();
			this.subjectAdultMobilePhone = ((Adult)request.getSubject()).getMobilePhone();
			if (((Adult)request.getSubject()).getAdress() != null) {
				this.subjectAdultAddressAdditionalDeliveryInformation = ((Adult)request.getSubject()).getAdress().getAdditionalDeliveryInformation();
				this.subjectAdultAddressAdditionalGeographicalInformation = ((Adult)request.getSubject()).getAdress().getAdditionalGeographicalInformation();
				this.subjectAdultAddressStreetNumber = ((Adult)request.getSubject()).getAdress().getStreetNumber();
				this.subjectAdultAddressStreetName = ((Adult)request.getSubject()).getAdress().getStreetName();
				this.subjectAdultAddressPlaceNameOrService = ((Adult)request.getSubject()).getAdress().getPlaceNameOrService();
				this.subjectAdultAddressPostalCode = ((Adult)request.getSubject()).getAdress().getPostalCode();
				this.subjectAdultAddressCity = ((Adult)request.getSubject()).getAdress().getCity();
			}
			this.otherContactFirstName = request.getOtherContactFirstName();
			this.subjectAdultFirstName = ((Adult)request.getSubject()).getFirstName();
        }
    }
    
    public void saveRequest(Object xmlRequest) {
        if ((xmlRequest != null) && (xmlRequest instanceof HolidaySecurityRequest)) {
            HolidaySecurityRequest request = (HolidaySecurityRequest)xmlRequest; 
        }
    }
    
    public void saveData(Object xmlRequest) {
        if ((xmlRequest != null) && (xmlRequest instanceof HolidaySecurityRequest)) {
            HolidaySecurityRequest request = (HolidaySecurityRequest)xmlRequest; 

            if ((request.getRulesAndRegulationsAcceptance() != null))
			request.setRulesAndRegulationsAcceptance(this.rulesAndRegulationsAcceptance);
        }
    }
    
	public void setOtherContactLastName(String otherContactLastName) {
		this.otherContactLastName = otherContactLastName;
	}
	
	public String getOtherContactLastName() {
		return this.otherContactLastName;
	}

	public void setRulesAndRegulationsAcceptance(boolean rulesAndRegulationsAcceptance) {
		this.rulesAndRegulationsAcceptance = rulesAndRegulationsAcceptance;
	}
	
	public boolean getRulesAndRegulationsAcceptance() {
		return this.rulesAndRegulationsAcceptance;
	}

	public void setOtherContactAddressAdditionalDeliveryInformation(String otherContactAddressAdditionalDeliveryInformation) {
		this.otherContactAddressAdditionalDeliveryInformation = otherContactAddressAdditionalDeliveryInformation;
	}
	
	public String getOtherContactAddressAdditionalDeliveryInformation() {
		return this.otherContactAddressAdditionalDeliveryInformation;
	}

	public void setOtherContactAddressAdditionalGeographicalInformation(String otherContactAddressAdditionalGeographicalInformation) {
		this.otherContactAddressAdditionalGeographicalInformation = otherContactAddressAdditionalGeographicalInformation;
	}
	
	public String getOtherContactAddressAdditionalGeographicalInformation() {
		return this.otherContactAddressAdditionalGeographicalInformation;
	}

	public void setOtherContactAddressStreetNumber(String otherContactAddressStreetNumber) {
		this.otherContactAddressStreetNumber = otherContactAddressStreetNumber;
	}
	
	public String getOtherContactAddressStreetNumber() {
		return this.otherContactAddressStreetNumber;
	}

	public void setOtherContactAddressStreetName(String otherContactAddressStreetName) {
		this.otherContactAddressStreetName = otherContactAddressStreetName;
	}
	
	public String getOtherContactAddressStreetName() {
		return this.otherContactAddressStreetName;
	}

	public void setOtherContactAddressPlaceNameOrService(String otherContactAddressPlaceNameOrService) {
		this.otherContactAddressPlaceNameOrService = otherContactAddressPlaceNameOrService;
	}
	
	public String getOtherContactAddressPlaceNameOrService() {
		return this.otherContactAddressPlaceNameOrService;
	}

	public void setOtherContactAddressPostalCode(String otherContactAddressPostalCode) {
		this.otherContactAddressPostalCode = otherContactAddressPostalCode;
	}
	
	public String getOtherContactAddressPostalCode() {
		return this.otherContactAddressPostalCode;
	}

	public void setOtherContactAddressCity(String otherContactAddressCity) {
		this.otherContactAddressCity = otherContactAddressCity;
	}
	
	public String getOtherContactAddressCity() {
		return this.otherContactAddressCity;
	}

	public void setLight(boolean light) {
		this.light = light;
	}
	
	public boolean getLight() {
		return this.light;
	}

	public void setSubjectAdultEmail(String subjectAdultEmail) {
		this.subjectAdultEmail = subjectAdultEmail;
	}
	
	public String getSubjectAdultEmail() {
		return this.subjectAdultEmail;
	}

	public void setAbsenceEndDate(Calendar absenceEndDate) {
		this.absenceEndDate = absenceEndDate;
	}
	
	public Calendar getAbsenceEndDate() {
		return this.absenceEndDate;
	}

	public void setAbsenceStartDate(Calendar absenceStartDate) {
		this.absenceStartDate = absenceStartDate;
	}
	
	public Calendar getAbsenceStartDate() {
		return this.absenceStartDate;
	}

	public void setSubjectAdultLastName(String subjectAdultLastName) {
		this.subjectAdultLastName = subjectAdultLastName;
	}
	
	public String getSubjectAdultLastName() {
		return this.subjectAdultLastName;
	}

	public void setAlertPhone(String alertPhone) {
		this.alertPhone = alertPhone;
	}
	
	public String getAlertPhone() {
		return this.alertPhone;
	}

	public void setAlarm(boolean alarm) {
		this.alarm = alarm;
	}
	
	public boolean getAlarm() {
		return this.alarm;
	}

	public void setOtherContactPhone(String otherContactPhone) {
		this.otherContactPhone = otherContactPhone;
	}
	
	public String getOtherContactPhone() {
		return this.otherContactPhone;
	}

	public void setSubjectAdultMobilePhone(String subjectAdultMobilePhone) {
		this.subjectAdultMobilePhone = subjectAdultMobilePhone;
	}
	
	public String getSubjectAdultMobilePhone() {
		return this.subjectAdultMobilePhone;
	}

	public void setSubjectAdultAddressAdditionalDeliveryInformation(String subjectAdultAddressAdditionalDeliveryInformation) {
		this.subjectAdultAddressAdditionalDeliveryInformation = subjectAdultAddressAdditionalDeliveryInformation;
	}
	
	public String getSubjectAdultAddressAdditionalDeliveryInformation() {
		return this.subjectAdultAddressAdditionalDeliveryInformation;
	}

	public void setSubjectAdultAddressAdditionalGeographicalInformation(String subjectAdultAddressAdditionalGeographicalInformation) {
		this.subjectAdultAddressAdditionalGeographicalInformation = subjectAdultAddressAdditionalGeographicalInformation;
	}
	
	public String getSubjectAdultAddressAdditionalGeographicalInformation() {
		return this.subjectAdultAddressAdditionalGeographicalInformation;
	}

	public void setSubjectAdultAddressStreetNumber(String subjectAdultAddressStreetNumber) {
		this.subjectAdultAddressStreetNumber = subjectAdultAddressStreetNumber;
	}
	
	public String getSubjectAdultAddressStreetNumber() {
		return this.subjectAdultAddressStreetNumber;
	}

	public void setSubjectAdultAddressStreetName(String subjectAdultAddressStreetName) {
		this.subjectAdultAddressStreetName = subjectAdultAddressStreetName;
	}
	
	public String getSubjectAdultAddressStreetName() {
		return this.subjectAdultAddressStreetName;
	}

	public void setSubjectAdultAddressPlaceNameOrService(String subjectAdultAddressPlaceNameOrService) {
		this.subjectAdultAddressPlaceNameOrService = subjectAdultAddressPlaceNameOrService;
	}
	
	public String getSubjectAdultAddressPlaceNameOrService() {
		return this.subjectAdultAddressPlaceNameOrService;
	}

	public void setSubjectAdultAddressPostalCode(String subjectAdultAddressPostalCode) {
		this.subjectAdultAddressPostalCode = subjectAdultAddressPostalCode;
	}
	
	public String getSubjectAdultAddressPostalCode() {
		return this.subjectAdultAddressPostalCode;
	}

	public void setSubjectAdultAddressCity(String subjectAdultAddressCity) {
		this.subjectAdultAddressCity = subjectAdultAddressCity;
	}
	
	public String getSubjectAdultAddressCity() {
		return this.subjectAdultAddressCity;
	}

	public void setOtherContactFirstName(String otherContactFirstName) {
		this.otherContactFirstName = otherContactFirstName;
	}
	
	public String getOtherContactFirstName() {
		return this.otherContactFirstName;
	}

	public void setSubjectAdultFirstName(String subjectAdultFirstName) {
		this.subjectAdultFirstName = subjectAdultFirstName;
	}
	
	public String getSubjectAdultFirstName() {
		return this.subjectAdultFirstName;
	}

}

