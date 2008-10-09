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

  	private String subjectAddressOutsideCityAdditionalDeliveryInformation;
	private String subjectAddressOutsideCityAdditionalGeographicalInformation;
	private String subjectAddressOutsideCityStreetNumber;
	private String subjectAddressOutsideCityStreetName;
	private String subjectAddressOutsideCityPlaceNameOrService;
	private String subjectAddressOutsideCityPostalCode;
	private String subjectAddressOutsideCityCity;
  	private String subjectIndividualAddressAdditionalDeliveryInformation;
	private String subjectIndividualAddressAdditionalGeographicalInformation;
	private String subjectIndividualAddressStreetNumber;
	private String subjectIndividualAddressStreetName;
	private String subjectIndividualAddressPlaceNameOrService;
	private String subjectIndividualAddressPostalCode;
	private String subjectIndividualAddressCity;
	private String subjectIndividualSex;
	private String subjectIndividualFirstName;
	private String pollingSchoolName;
	private String motive;
	private String subjectNationality;
   	private List subjectNationalityList;
	private String subjectOldCity;
	private Calendar subjectIndividualBirthDate;
	private long electoralNumber;
	private long pollingStation;
	private String subjectIndividualFirstName2;
	private String subjectIndividualFirstName3;
	private String subjectIndividualLastName;

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

			if (request.getSubjectAddressOutsideCity() != null) {
				this.subjectAddressOutsideCityAdditionalDeliveryInformation = request.getSubjectAddressOutsideCity().getAdditionalDeliveryInformation();
				this.subjectAddressOutsideCityAdditionalGeographicalInformation = request.getSubjectAddressOutsideCity().getAdditionalGeographicalInformation();
				this.subjectAddressOutsideCityStreetNumber = request.getSubjectAddressOutsideCity().getStreetNumber();
				this.subjectAddressOutsideCityStreetName = request.getSubjectAddressOutsideCity().getStreetName();
				this.subjectAddressOutsideCityPlaceNameOrService = request.getSubjectAddressOutsideCity().getPlaceNameOrService();
				this.subjectAddressOutsideCityPostalCode = request.getSubjectAddressOutsideCity().getPostalCode();
				this.subjectAddressOutsideCityCity = request.getSubjectAddressOutsideCity().getCity();
			}
			if (((Individual)request.getSubject()).getAdress() != null) {
				this.subjectIndividualAddressAdditionalDeliveryInformation = ((Individual)request.getSubject()).getAdress().getAdditionalDeliveryInformation();
				this.subjectIndividualAddressAdditionalGeographicalInformation = ((Individual)request.getSubject()).getAdress().getAdditionalGeographicalInformation();
				this.subjectIndividualAddressStreetNumber = ((Individual)request.getSubject()).getAdress().getStreetNumber();
				this.subjectIndividualAddressStreetName = ((Individual)request.getSubject()).getAdress().getStreetName();
				this.subjectIndividualAddressPlaceNameOrService = ((Individual)request.getSubject()).getAdress().getPlaceNameOrService();
				this.subjectIndividualAddressPostalCode = ((Individual)request.getSubject()).getAdress().getPostalCode();
				this.subjectIndividualAddressCity = ((Individual)request.getSubject()).getAdress().getCity();
			}
			this.subjectIndividualFirstName = ((Individual)request.getSubject()).getFirstName();
			this.pollingSchoolName = request.getPollingSchoolName();
			if (request.getMotive() != null)
                this.motive = getEnumElementTranslation(
                        fr.cg95.cvq.xml.election.ElectoralRollRegistrationRequestDocument.ElectoralRollRegistrationRequest.class.getName(), 
                        "Motive", request.getMotive().toString());
            this.setSubjectNationality(this.getList("Nationality"), request.getSubjectNationality());
			this.subjectOldCity = request.getSubjectOldCity();
			if (((Individual)request.getSubject()).getBirthDate() != null) {
				this.subjectIndividualBirthDate = Calendar.getInstance(); 
	            this.subjectIndividualBirthDate.setTime(((Individual)request.getSubject()).getBirthDate());
			}
            if ((request.getElectoralNumber() != null))
			this.electoralNumber = request.getElectoralNumber();
            if ((request.getPollingStation() != null))
			this.pollingStation = request.getPollingStation();
			this.subjectIndividualFirstName2 = ((Individual)request.getSubject()).getFirstName2();
			this.subjectIndividualFirstName3 = ((Individual)request.getSubject()).getFirstName3();
			this.subjectIndividualLastName = ((Individual)request.getSubject()).getLastName();
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
			if (this.motive != null)
                request.setMotive(
                    ElectoralMotiveType.forString(
                        getEnumKeyTranslation(
                            fr.cg95.cvq.xml.election.ElectoralRollRegistrationRequestDocument.ElectoralRollRegistrationRequest.class.getName(), 
                            "Motive", this.motive)
                    )
                );
			request.setSubjectNationality(this.getSubjectNationalityKey());
			request.setSubjectOldCity(this.subjectOldCity);
            if ((request.getElectoralNumber() != null))
			request.setElectoralNumber(this.electoralNumber);
            if ((request.getPollingStation() != null))
			request.setPollingStation(this.pollingStation);
        }
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

	public void setSubjectIndividualSex(String subjectIndividualSex) {
		this.subjectIndividualSex = subjectIndividualSex;
	}
	
	public String getSubjectIndividualSex() {
		return this.subjectIndividualSex;
	}

	public void setSubjectIndividualFirstName(String subjectIndividualFirstName) {
		this.subjectIndividualFirstName = subjectIndividualFirstName;
	}
	
	public String getSubjectIndividualFirstName() {
		return this.subjectIndividualFirstName;
	}

	public void setPollingSchoolName(String pollingSchoolName) {
		this.pollingSchoolName = pollingSchoolName;
	}
	
	public String getPollingSchoolName() {
		return this.pollingSchoolName;
	}

	public void setMotive(String motive) {
		this.motive = motive;
	}
	
	public String getMotive() {
		return this.motive;
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
	
	public void setSubjectOldCity(String subjectOldCity) {
		this.subjectOldCity = subjectOldCity;
	}
	
	public String getSubjectOldCity() {
		return this.subjectOldCity;
	}

	public void setSubjectIndividualBirthDate(Calendar subjectIndividualBirthDate) {
		this.subjectIndividualBirthDate = subjectIndividualBirthDate;
	}
	
	public Calendar getSubjectIndividualBirthDate() {
		return this.subjectIndividualBirthDate;
	}

	public void setElectoralNumber(long electoralNumber) {
		this.electoralNumber = electoralNumber;
	}
	
	public long getElectoralNumber() {
		return this.electoralNumber;
	}

	public void setPollingStation(long pollingStation) {
		this.pollingStation = pollingStation;
	}
	
	public long getPollingStation() {
		return this.pollingStation;
	}

	public void setSubjectIndividualFirstName2(String subjectIndividualFirstName2) {
		this.subjectIndividualFirstName2 = subjectIndividualFirstName2;
	}
	
	public String getSubjectIndividualFirstName2() {
		return this.subjectIndividualFirstName2;
	}

	public void setSubjectIndividualFirstName3(String subjectIndividualFirstName3) {
		this.subjectIndividualFirstName3 = subjectIndividualFirstName3;
	}
	
	public String getSubjectIndividualFirstName3() {
		return this.subjectIndividualFirstName3;
	}

	public void setSubjectIndividualLastName(String subjectIndividualLastName) {
		this.subjectIndividualLastName = subjectIndividualLastName;
	}
	
	public String getSubjectIndividualLastName() {
		return this.subjectIndividualLastName;
	}

}

