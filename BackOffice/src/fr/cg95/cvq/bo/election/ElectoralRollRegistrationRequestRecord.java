package fr.cg95.cvq.bo.election;

import java.util.Calendar;
import java.util.List;
import java.util.Set;
import java.util.Vector;

import fr.cg95.cvq.wizard.*;
import fr.cg95.cvq.bo.record.BaseRecord;
import fr.cg95.cvq.bo.record.RequestRecord;
import fr.cg95.cvq.business.authority.*;
import fr.cg95.cvq.business.users.*;
import fr.cg95.cvq.business.election.*;

public class ElectoralRollRegistrationRequestRecord extends RequestRecord {

	private String subjectIndividualFirstName2;
	private Calendar subjectIndividualBirthDate;
	private String subjectIndividualLastName;
  	private String subjectIndividualAddressAdditionalDeliveryInformation;
	private String subjectIndividualAddressAdditionalGeographicalInformation;
	private String subjectIndividualAddressStreetNumber;
	private String subjectIndividualAddressStreetName;
	private String subjectIndividualAddressPlaceNameOrService;
	private String subjectIndividualAddressPostalCode;
	private String subjectIndividualAddressCity;
	private String motive;
	private String subjectOldCity;
	private String subjectNationality;
   	private List subjectNationalityList;
	private long pollingStation;
  	private String subjectAddressOutsideCityAdditionalDeliveryInformation;
	private String subjectAddressOutsideCityAdditionalGeographicalInformation;
	private String subjectAddressOutsideCityStreetNumber;
	private String subjectAddressOutsideCityStreetName;
	private String subjectAddressOutsideCityPlaceNameOrService;
	private String subjectAddressOutsideCityPostalCode;
	private String subjectAddressOutsideCityCity;
	private String pollingSchoolName;
	private String subjectIndividualFirstName;
	private long electoralNumber;
	private String subjectIndividualFirstName3;
	private String subjectIndividualSex;

	public ElectoralRollRegistrationRequestRecord() {
		super();
	}
	
	protected Object clone() throws CloneNotSupportedException {
		ElectoralRollRegistrationRequestRecord clonedRecord = (ElectoralRollRegistrationRequestRecord)super.clone();
		return clonedRecord;
	}
	
	public BaseRecord getDataRecord(Long id) {

		if (id.equals(this.getId()))
			return this;
			
		return super.getDataRecord(id);
	}

    public void load(Object xmlRequest) {
        if ((xmlRequest != null) && (xmlRequest instanceof ElectoralRollRegistrationRequest)) {
            ElectoralRollRegistrationRequest request = (ElectoralRollRegistrationRequest)xmlRequest; 

			this.subjectIndividualFirstName2 = ((Individual)request.getSubject()).getFirstName2();
			if (((Individual)request.getSubject()).getBirthDate() != null) {
				this.subjectIndividualBirthDate = Calendar.getInstance(); 
	            this.subjectIndividualBirthDate.setTime(((Individual)request.getSubject()).getBirthDate());
			}
			this.subjectIndividualLastName = ((Individual)request.getSubject()).getLastName();
			if (((Individual)request.getSubject()).getAdress() != null) {
				this.subjectIndividualAddressAdditionalDeliveryInformation = ((Individual)request.getSubject()).getAdress().getAdditionalDeliveryInformation();
				this.subjectIndividualAddressAdditionalGeographicalInformation = ((Individual)request.getSubject()).getAdress().getAdditionalGeographicalInformation();
				this.subjectIndividualAddressStreetNumber = ((Individual)request.getSubject()).getAdress().getStreetNumber();
				this.subjectIndividualAddressStreetName = ((Individual)request.getSubject()).getAdress().getStreetName();
				this.subjectIndividualAddressPlaceNameOrService = ((Individual)request.getSubject()).getAdress().getPlaceNameOrService();
				this.subjectIndividualAddressPostalCode = ((Individual)request.getSubject()).getAdress().getPostalCode();
				this.subjectIndividualAddressCity = ((Individual)request.getSubject()).getAdress().getCity();
			}
			if (request.getMotive() != null)
                this.motive = getEnumElementTranslation(
                        fr.cg95.cvq.xml.election.ElectoralRollRegistrationRequestDocument.ElectoralRollRegistrationRequest.class.getName(), 
                        "Motive", request.getMotive().toString());
			this.subjectOldCity = request.getSubjectOldCity();
            this.setSubjectNationality(this.getList("Nationality"), request.getSubjectNationality());
            if ((request.getPollingStation() != null))
			this.pollingStation = request.getPollingStation();
			if (request.getSubjectAddressOutsideCity() != null) {
				this.subjectAddressOutsideCityAdditionalDeliveryInformation = request.getSubjectAddressOutsideCity().getAdditionalDeliveryInformation();
				this.subjectAddressOutsideCityAdditionalGeographicalInformation = request.getSubjectAddressOutsideCity().getAdditionalGeographicalInformation();
				this.subjectAddressOutsideCityStreetNumber = request.getSubjectAddressOutsideCity().getStreetNumber();
				this.subjectAddressOutsideCityStreetName = request.getSubjectAddressOutsideCity().getStreetName();
				this.subjectAddressOutsideCityPlaceNameOrService = request.getSubjectAddressOutsideCity().getPlaceNameOrService();
				this.subjectAddressOutsideCityPostalCode = request.getSubjectAddressOutsideCity().getPostalCode();
				this.subjectAddressOutsideCityCity = request.getSubjectAddressOutsideCity().getCity();
			}
			this.pollingSchoolName = request.getPollingSchoolName();
			this.subjectIndividualFirstName = ((Individual)request.getSubject()).getFirstName();
            if ((request.getElectoralNumber() != null))
			this.electoralNumber = request.getElectoralNumber();
			this.subjectIndividualFirstName3 = ((Individual)request.getSubject()).getFirstName3();
        }
    }
    
    public void saveRequest(Object xmlRequest) {
        if ((xmlRequest != null) && (xmlRequest instanceof ElectoralRollRegistrationRequest)) {
            ElectoralRollRegistrationRequest request = (ElectoralRollRegistrationRequest)xmlRequest; 
        }
    }
    
    public void saveData(Object xmlRequest) {
        if ((xmlRequest != null) && (xmlRequest instanceof ElectoralRollRegistrationRequest)) {
            ElectoralRollRegistrationRequest request = (ElectoralRollRegistrationRequest)xmlRequest; 

			if (this.motive != null)
                request.setMotive(
                    ElectoralMotiveType.forString(
                        getEnumKeyTranslation(
                            fr.cg95.cvq.xml.election.ElectoralRollRegistrationRequestDocument.ElectoralRollRegistrationRequest.class.getName(), 
                            "Motive", this.motive)
                    )
                );
			request.setSubjectOldCity(this.subjectOldCity);
			request.setSubjectNationality(this.getSubjectNationalityKey());
            if ((request.getPollingStation() != null))
			request.setPollingStation(this.pollingStation);
  			if (request.getSubjectAddressOutsideCity() != null) {
				request.getSubjectAddressOutsideCity().setAdditionalDeliveryInformation(this.subjectAddressOutsideCityAdditionalDeliveryInformation);
				request.getSubjectAddressOutsideCity().setAdditionalGeographicalInformation(this.subjectAddressOutsideCityAdditionalGeographicalInformation);
				request.getSubjectAddressOutsideCity().setStreetNumber(this.subjectAddressOutsideCityStreetNumber);
				request.getSubjectAddressOutsideCity().setStreetName(this.subjectAddressOutsideCityStreetName);
				request.getSubjectAddressOutsideCity().setPlaceNameOrService(this.subjectAddressOutsideCityPlaceNameOrService);
				request.getSubjectAddressOutsideCity().setPostalCode(this.subjectAddressOutsideCityPostalCode);
				request.getSubjectAddressOutsideCity().setCity(this.subjectAddressOutsideCityCity);
			}
			request.setPollingSchoolName(this.pollingSchoolName);
            if ((request.getElectoralNumber() != null))
			request.setElectoralNumber(this.electoralNumber);
        }
    }
    
	public void setSubjectIndividualFirstName2(String subjectIndividualFirstName2) {
		this.subjectIndividualFirstName2 = subjectIndividualFirstName2;
	}
	
	public String getSubjectIndividualFirstName2() {
		return this.subjectIndividualFirstName2;
	}

	public void setSubjectIndividualBirthDate(Calendar subjectIndividualBirthDate) {
		this.subjectIndividualBirthDate = subjectIndividualBirthDate;
	}
	
	public Calendar getSubjectIndividualBirthDate() {
		return this.subjectIndividualBirthDate;
	}

	public void setSubjectIndividualLastName(String subjectIndividualLastName) {
		this.subjectIndividualLastName = subjectIndividualLastName;
	}
	
	public String getSubjectIndividualLastName() {
		return this.subjectIndividualLastName;
	}

	public void setSubjectIndividualAddressAdditionalDeliveryInformation(String subjectIndividualAddressAdditionalDeliveryInformation) {
		this.subjectIndividualAddressAdditionalDeliveryInformation = subjectIndividualAddressAdditionalDeliveryInformation;
	}
	
	public String getSubjectIndividualAddressAdditionalDeliveryInformation() {
		return this.subjectIndividualAddressAdditionalDeliveryInformation;
	}

	public void setSubjectIndividualAddressAdditionalGeographicalInformation(String subjectIndividualAddressAdditionalGeographicalInformation) {
		this.subjectIndividualAddressAdditionalGeographicalInformation = subjectIndividualAddressAdditionalGeographicalInformation;
	}
	
	public String getSubjectIndividualAddressAdditionalGeographicalInformation() {
		return this.subjectIndividualAddressAdditionalGeographicalInformation;
	}

	public void setSubjectIndividualAddressStreetNumber(String subjectIndividualAddressStreetNumber) {
		this.subjectIndividualAddressStreetNumber = subjectIndividualAddressStreetNumber;
	}
	
	public String getSubjectIndividualAddressStreetNumber() {
		return this.subjectIndividualAddressStreetNumber;
	}

	public void setSubjectIndividualAddressStreetName(String subjectIndividualAddressStreetName) {
		this.subjectIndividualAddressStreetName = subjectIndividualAddressStreetName;
	}
	
	public String getSubjectIndividualAddressStreetName() {
		return this.subjectIndividualAddressStreetName;
	}

	public void setSubjectIndividualAddressPlaceNameOrService(String subjectIndividualAddressPlaceNameOrService) {
		this.subjectIndividualAddressPlaceNameOrService = subjectIndividualAddressPlaceNameOrService;
	}
	
	public String getSubjectIndividualAddressPlaceNameOrService() {
		return this.subjectIndividualAddressPlaceNameOrService;
	}

	public void setSubjectIndividualAddressPostalCode(String subjectIndividualAddressPostalCode) {
		this.subjectIndividualAddressPostalCode = subjectIndividualAddressPostalCode;
	}
	
	public String getSubjectIndividualAddressPostalCode() {
		return this.subjectIndividualAddressPostalCode;
	}

	public void setSubjectIndividualAddressCity(String subjectIndividualAddressCity) {
		this.subjectIndividualAddressCity = subjectIndividualAddressCity;
	}
	
	public String getSubjectIndividualAddressCity() {
		return this.subjectIndividualAddressCity;
	}

	public void setMotive(String motive) {
		this.motive = motive;
	}
	
	public String getMotive() {
		return this.motive;
	}

	public void setSubjectOldCity(String subjectOldCity) {
		this.subjectOldCity = subjectOldCity;
	}
	
	public String getSubjectOldCity() {
		return this.subjectOldCity;
	}

	public void setSubjectNationality(String subjectNationality) {
		this.subjectNationality = subjectNationality;
	}
	
	public String getSubjectNationality() {
		return this.subjectNationality;
	}

	public void setSubjectNationality(List referential, String subjectNationality) {
		this.subjectNationalityList = referential;
		for (int i = 0; i < referential.size(); i++) {
			if (subjectNationality.equals(((ReferentialData)referential.get(i)).getKey()))
				this.subjectNationality = ((ReferentialData)referential.get(i)).getValue();
		}
	}
	
	public String getSubjectNationalityKey() {
		for (int i = 0; i < subjectNationalityList.size(); i++) {
			if (this.subjectNationality.equals(((ReferentialData)subjectNationalityList.get(i)).getValue()))
				return ((ReferentialData)subjectNationalityList.get(i)).getKey();
		}
		return null;
	}

	public List getSubjectNationalityList() {
		return this.subjectNationalityList;
	}
	
	public void setPollingStation(long pollingStation) {
		this.pollingStation = pollingStation;
	}
	
	public long getPollingStation() {
		return this.pollingStation;
	}

	public void setSubjectAddressOutsideCityAdditionalDeliveryInformation(String subjectAddressOutsideCityAdditionalDeliveryInformation) {
		this.subjectAddressOutsideCityAdditionalDeliveryInformation = subjectAddressOutsideCityAdditionalDeliveryInformation;
	}
	
	public String getSubjectAddressOutsideCityAdditionalDeliveryInformation() {
		return this.subjectAddressOutsideCityAdditionalDeliveryInformation;
	}

	public void setSubjectAddressOutsideCityAdditionalGeographicalInformation(String subjectAddressOutsideCityAdditionalGeographicalInformation) {
		this.subjectAddressOutsideCityAdditionalGeographicalInformation = subjectAddressOutsideCityAdditionalGeographicalInformation;
	}
	
	public String getSubjectAddressOutsideCityAdditionalGeographicalInformation() {
		return this.subjectAddressOutsideCityAdditionalGeographicalInformation;
	}

	public void setSubjectAddressOutsideCityStreetNumber(String subjectAddressOutsideCityStreetNumber) {
		this.subjectAddressOutsideCityStreetNumber = subjectAddressOutsideCityStreetNumber;
	}
	
	public String getSubjectAddressOutsideCityStreetNumber() {
		return this.subjectAddressOutsideCityStreetNumber;
	}

	public void setSubjectAddressOutsideCityStreetName(String subjectAddressOutsideCityStreetName) {
		this.subjectAddressOutsideCityStreetName = subjectAddressOutsideCityStreetName;
	}
	
	public String getSubjectAddressOutsideCityStreetName() {
		return this.subjectAddressOutsideCityStreetName;
	}

	public void setSubjectAddressOutsideCityPlaceNameOrService(String subjectAddressOutsideCityPlaceNameOrService) {
		this.subjectAddressOutsideCityPlaceNameOrService = subjectAddressOutsideCityPlaceNameOrService;
	}
	
	public String getSubjectAddressOutsideCityPlaceNameOrService() {
		return this.subjectAddressOutsideCityPlaceNameOrService;
	}

	public void setSubjectAddressOutsideCityPostalCode(String subjectAddressOutsideCityPostalCode) {
		this.subjectAddressOutsideCityPostalCode = subjectAddressOutsideCityPostalCode;
	}
	
	public String getSubjectAddressOutsideCityPostalCode() {
		return this.subjectAddressOutsideCityPostalCode;
	}

	public void setSubjectAddressOutsideCityCity(String subjectAddressOutsideCityCity) {
		this.subjectAddressOutsideCityCity = subjectAddressOutsideCityCity;
	}
	
	public String getSubjectAddressOutsideCityCity() {
		return this.subjectAddressOutsideCityCity;
	}

	public void setPollingSchoolName(String pollingSchoolName) {
		this.pollingSchoolName = pollingSchoolName;
	}
	
	public String getPollingSchoolName() {
		return this.pollingSchoolName;
	}

	public void setSubjectIndividualFirstName(String subjectIndividualFirstName) {
		this.subjectIndividualFirstName = subjectIndividualFirstName;
	}
	
	public String getSubjectIndividualFirstName() {
		return this.subjectIndividualFirstName;
	}

	public void setElectoralNumber(long electoralNumber) {
		this.electoralNumber = electoralNumber;
	}
	
	public long getElectoralNumber() {
		return this.electoralNumber;
	}

	public void setSubjectIndividualFirstName3(String subjectIndividualFirstName3) {
		this.subjectIndividualFirstName3 = subjectIndividualFirstName3;
	}
	
	public String getSubjectIndividualFirstName3() {
		return this.subjectIndividualFirstName3;
	}

	public void setSubjectIndividualSex(String subjectIndividualSex) {
		this.subjectIndividualSex = subjectIndividualSex;
	}
	
	public String getSubjectIndividualSex() {
		return this.subjectIndividualSex;
	}

}

