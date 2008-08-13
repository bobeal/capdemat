package fr.cg95.cvq.bo.military;

import java.util.Calendar;
import java.util.List;
import java.util.Set;
import java.util.Vector;

import fr.cg95.cvq.wizard.*;
import fr.cg95.cvq.bo.record.BaseRecord;
import fr.cg95.cvq.bo.record.RequestRecord;
import fr.cg95.cvq.business.authority.*;
import fr.cg95.cvq.business.users.*;
import fr.cg95.cvq.business.military.*;

public class MilitaryCensusRequestRecord extends RequestRecord {

	private String fatherBirthCountry;
	private String motherFirstName;
	private boolean statePupil;
	private String otherSituation;
	private String motherBirthCountry;
	private java.math.BigInteger aliveChildren;
	private String fatherFirstName;
	private String maidenName;
	private String fatherBirthCity;
	private String motherBirthCity;
	private String childSpeciality;
	private boolean prefectPupil;
	private String childDiploma;
	private String childResidenceCountry;
  	private String subjectChildAddressAdditionalDeliveryInformation;
	private String subjectChildAddressAdditionalGeographicalInformation;
	private String subjectChildAddressStreetNumber;
	private String subjectChildAddressStreetName;
	private String subjectChildAddressPlaceNameOrService;
	private String subjectChildAddressPostalCode;
	private String subjectChildAddressCity;
	private String fatherNationality;
	private String childCountry;
	private String subjectChildBirthPlacePostalCode;
	private String fatherBirthDepartment;
	private Calendar subjectChildBirthDate;
	private String motherNationality;
	private boolean affectionOrDisease;
	private String childStatus;
	private Calendar motherBirthDate;
	private java.math.BigInteger childrenInCharge;
	private String motherLastName;
	private String subjectChildFirstName;
	private String childTitle;
	private Calendar fatherBirthDate;
	private String childConvention;
	private String childMail;
	private String subjectChildBirthPlaceCity;
	private String subjectChildLastName;
	private String motherBirthDepartment;
	private String childSituation;
	private String childOtherCountry;
	private String fatherLastName;
	private String childProfession;
	private String childBirthCountry;
	private boolean japdExemption;
	private boolean highlyInfirm;
	private String prefectPupilDepartment;
	private String childPhone;

	public MilitaryCensusRequestRecord() {
		super();
	}
	
	protected Object clone() throws CloneNotSupportedException {
		MilitaryCensusRequestRecord clonedRecord = (MilitaryCensusRequestRecord)super.clone();
		return clonedRecord;
	}
	
	public BaseRecord getDataRecord(Long id) {

		if (id.equals(this.getId()))
			return this;
			
		return super.getDataRecord(id);
	}

    public void load(Object xmlRequest) {
        if ((xmlRequest != null) && (xmlRequest instanceof MilitaryCensusRequest)) {
            MilitaryCensusRequest request = (MilitaryCensusRequest)xmlRequest; 

			if (request.getFatherBirthCountry() != null)
                this.fatherBirthCountry = getEnumElementTranslation(
                        fr.cg95.cvq.xml.military.MilitaryCensusRequestDocument.MilitaryCensusRequest.class.getName(), 
                        "FatherBirthCountry", request.getFatherBirthCountry().toString());
			this.motherFirstName = request.getMotherFirstName();
            if ((request.getStatePupil() != null))
			this.statePupil = request.getStatePupil();
			this.otherSituation = request.getOtherSituation();
			if (request.getMotherBirthCountry() != null)
                this.motherBirthCountry = getEnumElementTranslation(
                        fr.cg95.cvq.xml.military.MilitaryCensusRequestDocument.MilitaryCensusRequest.class.getName(), 
                        "MotherBirthCountry", request.getMotherBirthCountry().toString());
			this.aliveChildren = request.getAliveChildren();
			this.fatherFirstName = request.getFatherFirstName();
			this.maidenName = request.getMaidenName();
			this.fatherBirthCity = request.getFatherBirthCity();
			this.motherBirthCity = request.getMotherBirthCity();
			this.childSpeciality = request.getChildSpeciality();
            if ((request.getPrefectPupil() != null))
			this.prefectPupil = request.getPrefectPupil();
			if (request.getChildDiploma() != null)
                this.childDiploma = getEnumElementTranslation(
                        fr.cg95.cvq.xml.military.MilitaryCensusRequestDocument.MilitaryCensusRequest.class.getName(), 
                        "ChildDiploma", request.getChildDiploma().toString());
			if (request.getChildResidenceCountry() != null)
                this.childResidenceCountry = getEnumElementTranslation(
                        fr.cg95.cvq.xml.military.MilitaryCensusRequestDocument.MilitaryCensusRequest.class.getName(), 
                        "ChildResidenceCountry", request.getChildResidenceCountry().toString());
			if (((Child)request.getSubject()).getAdress() != null) {
				this.subjectChildAddressAdditionalDeliveryInformation = ((Child)request.getSubject()).getAdress().getAdditionalDeliveryInformation();
				this.subjectChildAddressAdditionalGeographicalInformation = ((Child)request.getSubject()).getAdress().getAdditionalGeographicalInformation();
				this.subjectChildAddressStreetNumber = ((Child)request.getSubject()).getAdress().getStreetNumber();
				this.subjectChildAddressStreetName = ((Child)request.getSubject()).getAdress().getStreetName();
				this.subjectChildAddressPlaceNameOrService = ((Child)request.getSubject()).getAdress().getPlaceNameOrService();
				this.subjectChildAddressPostalCode = ((Child)request.getSubject()).getAdress().getPostalCode();
				this.subjectChildAddressCity = ((Child)request.getSubject()).getAdress().getCity();
			}
			if (request.getFatherNationality() != null)
                this.fatherNationality = getEnumElementTranslation(
                        fr.cg95.cvq.xml.military.MilitaryCensusRequestDocument.MilitaryCensusRequest.class.getName(), 
                        "FatherNationality", request.getFatherNationality().toString());
			if (request.getChildCountry() != null)
                this.childCountry = getEnumElementTranslation(
                        fr.cg95.cvq.xml.military.MilitaryCensusRequestDocument.MilitaryCensusRequest.class.getName(), 
                        "ChildCountry", request.getChildCountry().toString());
			this.subjectChildBirthPlacePostalCode = ((Child)request.getSubject()).getBirthPostalCode();
			if (request.getFatherBirthDepartment() != null)
                this.fatherBirthDepartment = getEnumElementTranslation(
                        fr.cg95.cvq.xml.military.MilitaryCensusRequestDocument.MilitaryCensusRequest.class.getName(), 
                        "FatherBirthDepartment", request.getFatherBirthDepartment().toString());
			if (((Child)request.getSubject()).getBirthDate() != null) {
				this.subjectChildBirthDate = Calendar.getInstance(); 
	            this.subjectChildBirthDate.setTime(((Child)request.getSubject()).getBirthDate());
			}
			if (request.getMotherNationality() != null)
                this.motherNationality = getEnumElementTranslation(
                        fr.cg95.cvq.xml.military.MilitaryCensusRequestDocument.MilitaryCensusRequest.class.getName(), 
                        "MotherNationality", request.getMotherNationality().toString());
            if ((request.getAffectionOrDisease() != null))
			this.affectionOrDisease = request.getAffectionOrDisease();
			if (request.getChildStatus() != null)
                this.childStatus = getEnumElementTranslation(
                        fr.cg95.cvq.xml.military.MilitaryCensusRequestDocument.MilitaryCensusRequest.class.getName(), 
                        "ChildStatus", request.getChildStatus().toString());
			if (request.getMotherBirthDate() != null) {
				this.motherBirthDate = Calendar.getInstance(); 
	            this.motherBirthDate.setTime(request.getMotherBirthDate());
			}
			this.childrenInCharge = request.getChildrenInCharge();
			this.motherLastName = request.getMotherLastName();
			this.subjectChildFirstName = ((Child)request.getSubject()).getFirstName();
			if (request.getChildTitle() != null)
                this.childTitle = getEnumElementTranslation(
                        fr.cg95.cvq.xml.military.MilitaryCensusRequestDocument.MilitaryCensusRequest.class.getName(), 
                        "ChildTitle", request.getChildTitle().toString());
			if (request.getFatherBirthDate() != null) {
				this.fatherBirthDate = Calendar.getInstance(); 
	            this.fatherBirthDate.setTime(request.getFatherBirthDate());
			}
			this.childConvention = request.getChildConvention();
			this.childMail = request.getChildMail();
			this.subjectChildBirthPlaceCity = ((Child)request.getSubject()).getBirthCity();
			this.subjectChildLastName = ((Child)request.getSubject()).getLastName();
			if (request.getMotherBirthDepartment() != null)
                this.motherBirthDepartment = getEnumElementTranslation(
                        fr.cg95.cvq.xml.military.MilitaryCensusRequestDocument.MilitaryCensusRequest.class.getName(), 
                        "MotherBirthDepartment", request.getMotherBirthDepartment().toString());
			if (request.getChildSituation() != null)
                this.childSituation = getEnumElementTranslation(
                        fr.cg95.cvq.xml.military.MilitaryCensusRequestDocument.MilitaryCensusRequest.class.getName(), 
                        "ChildSituation", request.getChildSituation().toString());
			if (request.getChildOtherCountry() != null)
                this.childOtherCountry = getEnumElementTranslation(
                        fr.cg95.cvq.xml.military.MilitaryCensusRequestDocument.MilitaryCensusRequest.class.getName(), 
                        "ChildOtherCountry", request.getChildOtherCountry().toString());
			this.fatherLastName = request.getFatherLastName();
			this.childProfession = request.getChildProfession();
			if (request.getChildBirthCountry() != null)
                this.childBirthCountry = getEnumElementTranslation(
                        fr.cg95.cvq.xml.military.MilitaryCensusRequestDocument.MilitaryCensusRequest.class.getName(), 
                        "ChildBirthCountry", request.getChildBirthCountry().toString());
            if ((request.getJapdExemption() != null))
			this.japdExemption = request.getJapdExemption();
            if ((request.getHighlyInfirm() != null))
			this.highlyInfirm = request.getHighlyInfirm();
			if (request.getPrefectPupilDepartment() != null)
                this.prefectPupilDepartment = getEnumElementTranslation(
                        fr.cg95.cvq.xml.military.MilitaryCensusRequestDocument.MilitaryCensusRequest.class.getName(), 
                        "PrefectPupilDepartment", request.getPrefectPupilDepartment().toString());
			this.childPhone = request.getChildPhone();
        }
    }
    
    public void saveRequest(Object xmlRequest) {
        if ((xmlRequest != null) && (xmlRequest instanceof MilitaryCensusRequest)) {
            MilitaryCensusRequest request = (MilitaryCensusRequest)xmlRequest; 
        }
    }
    
    public void saveData(Object xmlRequest) {
        if ((xmlRequest != null) && (xmlRequest instanceof MilitaryCensusRequest)) {
            MilitaryCensusRequest request = (MilitaryCensusRequest)xmlRequest; 

			if (this.fatherBirthCountry != null)
                request.setFatherBirthCountry(
                    CountryType.forString(
                        getEnumKeyTranslation(
                            fr.cg95.cvq.xml.military.MilitaryCensusRequestDocument.MilitaryCensusRequest.class.getName(), 
                            "FatherBirthCountry", this.fatherBirthCountry)
                    )
                );
			request.setMotherFirstName(this.motherFirstName);
            if ((request.getStatePupil() != null))
			request.setStatePupil(this.statePupil);
			request.setOtherSituation(this.otherSituation);
			if (this.motherBirthCountry != null)
                request.setMotherBirthCountry(
                    CountryType.forString(
                        getEnumKeyTranslation(
                            fr.cg95.cvq.xml.military.MilitaryCensusRequestDocument.MilitaryCensusRequest.class.getName(), 
                            "MotherBirthCountry", this.motherBirthCountry)
                    )
                );
			request.setAliveChildren(this.aliveChildren);
			request.setFatherFirstName(this.fatherFirstName);
			request.setMaidenName(this.maidenName);
			request.setFatherBirthCity(this.fatherBirthCity);
			request.setMotherBirthCity(this.motherBirthCity);
			request.setChildSpeciality(this.childSpeciality);
            if ((request.getPrefectPupil() != null))
			request.setPrefectPupil(this.prefectPupil);
			if (this.childDiploma != null)
                request.setChildDiploma(
                    ChildDiplomaType.forString(
                        getEnumKeyTranslation(
                            fr.cg95.cvq.xml.military.MilitaryCensusRequestDocument.MilitaryCensusRequest.class.getName(), 
                            "ChildDiploma", this.childDiploma)
                    )
                );
			if (this.childResidenceCountry != null)
                request.setChildResidenceCountry(
                    CountryType.forString(
                        getEnumKeyTranslation(
                            fr.cg95.cvq.xml.military.MilitaryCensusRequestDocument.MilitaryCensusRequest.class.getName(), 
                            "ChildResidenceCountry", this.childResidenceCountry)
                    )
                );
			if (this.fatherNationality != null)
                request.setFatherNationality(
                    FullNationalityType.forString(
                        getEnumKeyTranslation(
                            fr.cg95.cvq.xml.military.MilitaryCensusRequestDocument.MilitaryCensusRequest.class.getName(), 
                            "FatherNationality", this.fatherNationality)
                    )
                );
			if (this.fatherBirthDepartment != null)
                request.setFatherBirthDepartment(
                    InseeDepartementCodeType.forString(
                        getEnumKeyTranslation(
                            fr.cg95.cvq.xml.military.MilitaryCensusRequestDocument.MilitaryCensusRequest.class.getName(), 
                            "FatherBirthDepartment", this.fatherBirthDepartment)
                    )
                );
			if (this.motherNationality != null)
                request.setMotherNationality(
                    FullNationalityType.forString(
                        getEnumKeyTranslation(
                            fr.cg95.cvq.xml.military.MilitaryCensusRequestDocument.MilitaryCensusRequest.class.getName(), 
                            "MotherNationality", this.motherNationality)
                    )
                );
            if ((request.getAffectionOrDisease() != null))
			request.setAffectionOrDisease(this.affectionOrDisease);
			if (this.childStatus != null)
                request.setChildStatus(
                    FamilyStatusType.forString(
                        getEnumKeyTranslation(
                            fr.cg95.cvq.xml.military.MilitaryCensusRequestDocument.MilitaryCensusRequest.class.getName(), 
                            "ChildStatus", this.childStatus)
                    )
                );
			if (this.motherBirthDate != null)
			request.setMotherBirthDate(this.motherBirthDate.getTime());
			request.setChildrenInCharge(this.childrenInCharge);
			request.setMotherLastName(this.motherLastName);
			if (this.childTitle != null)
                request.setChildTitle(
                    TitleType.forString(
                        getEnumKeyTranslation(
                            fr.cg95.cvq.xml.military.MilitaryCensusRequestDocument.MilitaryCensusRequest.class.getName(), 
                            "ChildTitle", this.childTitle)
                    )
                );
			if (this.fatherBirthDate != null)
			request.setFatherBirthDate(this.fatherBirthDate.getTime());
			request.setChildConvention(this.childConvention);
			request.setChildMail(this.childMail);
			if (this.motherBirthDepartment != null)
                request.setMotherBirthDepartment(
                    InseeDepartementCodeType.forString(
                        getEnumKeyTranslation(
                            fr.cg95.cvq.xml.military.MilitaryCensusRequestDocument.MilitaryCensusRequest.class.getName(), 
                            "MotherBirthDepartment", this.motherBirthDepartment)
                    )
                );
			if (this.childSituation != null)
                request.setChildSituation(
                    ChildSituationType.forString(
                        getEnumKeyTranslation(
                            fr.cg95.cvq.xml.military.MilitaryCensusRequestDocument.MilitaryCensusRequest.class.getName(), 
                            "ChildSituation", this.childSituation)
                    )
                );
			request.setFatherLastName(this.fatherLastName);
			request.setChildProfession(this.childProfession);
			if (this.childBirthCountry != null)
                request.setChildBirthCountry(
                    CountryType.forString(
                        getEnumKeyTranslation(
                            fr.cg95.cvq.xml.military.MilitaryCensusRequestDocument.MilitaryCensusRequest.class.getName(), 
                            "ChildBirthCountry", this.childBirthCountry)
                    )
                );
            if ((request.getJapdExemption() != null))
			request.setJapdExemption(this.japdExemption);
            if ((request.getHighlyInfirm() != null))
			request.setHighlyInfirm(this.highlyInfirm);
			if (this.prefectPupilDepartment != null)
                request.setPrefectPupilDepartment(
                    InseeDepartementCodeType.forString(
                        getEnumKeyTranslation(
                            fr.cg95.cvq.xml.military.MilitaryCensusRequestDocument.MilitaryCensusRequest.class.getName(), 
                            "PrefectPupilDepartment", this.prefectPupilDepartment)
                    )
                );
        }
    }
    
	public void setFatherBirthCountry(String fatherBirthCountry) {
		this.fatherBirthCountry = fatherBirthCountry;
	}
	
	public String getFatherBirthCountry() {
		return this.fatherBirthCountry;
	}

	public void setMotherFirstName(String motherFirstName) {
		this.motherFirstName = motherFirstName;
	}
	
	public String getMotherFirstName() {
		return this.motherFirstName;
	}

	public void setStatePupil(boolean statePupil) {
		this.statePupil = statePupil;
	}
	
	public boolean getStatePupil() {
		return this.statePupil;
	}

	public void setOtherSituation(String otherSituation) {
		this.otherSituation = otherSituation;
	}
	
	public String getOtherSituation() {
		return this.otherSituation;
	}

	public void setMotherBirthCountry(String motherBirthCountry) {
		this.motherBirthCountry = motherBirthCountry;
	}
	
	public String getMotherBirthCountry() {
		return this.motherBirthCountry;
	}

	public void setAliveChildren(java.math.BigInteger aliveChildren) {
		this.aliveChildren = aliveChildren;
	}
	
	public java.math.BigInteger getAliveChildren() {
		return this.aliveChildren;
	}

	public void setFatherFirstName(String fatherFirstName) {
		this.fatherFirstName = fatherFirstName;
	}
	
	public String getFatherFirstName() {
		return this.fatherFirstName;
	}

	public void setMaidenName(String maidenName) {
		this.maidenName = maidenName;
	}
	
	public String getMaidenName() {
		return this.maidenName;
	}

	public void setFatherBirthCity(String fatherBirthCity) {
		this.fatherBirthCity = fatherBirthCity;
	}
	
	public String getFatherBirthCity() {
		return this.fatherBirthCity;
	}

	public void setMotherBirthCity(String motherBirthCity) {
		this.motherBirthCity = motherBirthCity;
	}
	
	public String getMotherBirthCity() {
		return this.motherBirthCity;
	}

	public void setChildSpeciality(String childSpeciality) {
		this.childSpeciality = childSpeciality;
	}
	
	public String getChildSpeciality() {
		return this.childSpeciality;
	}

	public void setPrefectPupil(boolean prefectPupil) {
		this.prefectPupil = prefectPupil;
	}
	
	public boolean getPrefectPupil() {
		return this.prefectPupil;
	}

	public void setChildDiploma(String childDiploma) {
		this.childDiploma = childDiploma;
	}
	
	public String getChildDiploma() {
		return this.childDiploma;
	}

	public void setChildResidenceCountry(String childResidenceCountry) {
		this.childResidenceCountry = childResidenceCountry;
	}
	
	public String getChildResidenceCountry() {
		return this.childResidenceCountry;
	}

	public void setSubjectChildAddressAdditionalDeliveryInformation(String subjectChildAddressAdditionalDeliveryInformation) {
		this.subjectChildAddressAdditionalDeliveryInformation = subjectChildAddressAdditionalDeliveryInformation;
	}
	
	public String getSubjectChildAddressAdditionalDeliveryInformation() {
		return this.subjectChildAddressAdditionalDeliveryInformation;
	}

	public void setSubjectChildAddressAdditionalGeographicalInformation(String subjectChildAddressAdditionalGeographicalInformation) {
		this.subjectChildAddressAdditionalGeographicalInformation = subjectChildAddressAdditionalGeographicalInformation;
	}
	
	public String getSubjectChildAddressAdditionalGeographicalInformation() {
		return this.subjectChildAddressAdditionalGeographicalInformation;
	}

	public void setSubjectChildAddressStreetNumber(String subjectChildAddressStreetNumber) {
		this.subjectChildAddressStreetNumber = subjectChildAddressStreetNumber;
	}
	
	public String getSubjectChildAddressStreetNumber() {
		return this.subjectChildAddressStreetNumber;
	}

	public void setSubjectChildAddressStreetName(String subjectChildAddressStreetName) {
		this.subjectChildAddressStreetName = subjectChildAddressStreetName;
	}
	
	public String getSubjectChildAddressStreetName() {
		return this.subjectChildAddressStreetName;
	}

	public void setSubjectChildAddressPlaceNameOrService(String subjectChildAddressPlaceNameOrService) {
		this.subjectChildAddressPlaceNameOrService = subjectChildAddressPlaceNameOrService;
	}
	
	public String getSubjectChildAddressPlaceNameOrService() {
		return this.subjectChildAddressPlaceNameOrService;
	}

	public void setSubjectChildAddressPostalCode(String subjectChildAddressPostalCode) {
		this.subjectChildAddressPostalCode = subjectChildAddressPostalCode;
	}
	
	public String getSubjectChildAddressPostalCode() {
		return this.subjectChildAddressPostalCode;
	}

	public void setSubjectChildAddressCity(String subjectChildAddressCity) {
		this.subjectChildAddressCity = subjectChildAddressCity;
	}
	
	public String getSubjectChildAddressCity() {
		return this.subjectChildAddressCity;
	}

	public void setFatherNationality(String fatherNationality) {
		this.fatherNationality = fatherNationality;
	}
	
	public String getFatherNationality() {
		return this.fatherNationality;
	}

	public void setChildCountry(String childCountry) {
		this.childCountry = childCountry;
	}
	
	public String getChildCountry() {
		return this.childCountry;
	}

	public void setSubjectChildBirthPlacePostalCode(String subjectChildBirthPlacePostalCode) {
		this.subjectChildBirthPlacePostalCode = subjectChildBirthPlacePostalCode;
	}
	
	public String getSubjectChildBirthPlacePostalCode() {
		return this.subjectChildBirthPlacePostalCode;
	}

	public void setFatherBirthDepartment(String fatherBirthDepartment) {
		this.fatherBirthDepartment = fatherBirthDepartment;
	}
	
	public String getFatherBirthDepartment() {
		return this.fatherBirthDepartment;
	}

	public void setSubjectChildBirthDate(Calendar subjectChildBirthDate) {
		this.subjectChildBirthDate = subjectChildBirthDate;
	}
	
	public Calendar getSubjectChildBirthDate() {
		return this.subjectChildBirthDate;
	}

	public void setMotherNationality(String motherNationality) {
		this.motherNationality = motherNationality;
	}
	
	public String getMotherNationality() {
		return this.motherNationality;
	}

	public void setAffectionOrDisease(boolean affectionOrDisease) {
		this.affectionOrDisease = affectionOrDisease;
	}
	
	public boolean getAffectionOrDisease() {
		return this.affectionOrDisease;
	}

	public void setChildStatus(String childStatus) {
		this.childStatus = childStatus;
	}
	
	public String getChildStatus() {
		return this.childStatus;
	}

	public void setMotherBirthDate(Calendar motherBirthDate) {
		this.motherBirthDate = motherBirthDate;
	}
	
	public Calendar getMotherBirthDate() {
		return this.motherBirthDate;
	}

	public void setChildrenInCharge(java.math.BigInteger childrenInCharge) {
		this.childrenInCharge = childrenInCharge;
	}
	
	public java.math.BigInteger getChildrenInCharge() {
		return this.childrenInCharge;
	}

	public void setMotherLastName(String motherLastName) {
		this.motherLastName = motherLastName;
	}
	
	public String getMotherLastName() {
		return this.motherLastName;
	}

	public void setSubjectChildFirstName(String subjectChildFirstName) {
		this.subjectChildFirstName = subjectChildFirstName;
	}
	
	public String getSubjectChildFirstName() {
		return this.subjectChildFirstName;
	}

	public void setChildTitle(String childTitle) {
		this.childTitle = childTitle;
	}
	
	public String getChildTitle() {
		return this.childTitle;
	}

	public void setFatherBirthDate(Calendar fatherBirthDate) {
		this.fatherBirthDate = fatherBirthDate;
	}
	
	public Calendar getFatherBirthDate() {
		return this.fatherBirthDate;
	}

	public void setChildConvention(String childConvention) {
		this.childConvention = childConvention;
	}
	
	public String getChildConvention() {
		return this.childConvention;
	}

	public void setChildMail(String childMail) {
		this.childMail = childMail;
	}
	
	public String getChildMail() {
		return this.childMail;
	}

	public void setSubjectChildBirthPlaceCity(String subjectChildBirthPlaceCity) {
		this.subjectChildBirthPlaceCity = subjectChildBirthPlaceCity;
	}
	
	public String getSubjectChildBirthPlaceCity() {
		return this.subjectChildBirthPlaceCity;
	}

	public void setSubjectChildLastName(String subjectChildLastName) {
		this.subjectChildLastName = subjectChildLastName;
	}
	
	public String getSubjectChildLastName() {
		return this.subjectChildLastName;
	}

	public void setMotherBirthDepartment(String motherBirthDepartment) {
		this.motherBirthDepartment = motherBirthDepartment;
	}
	
	public String getMotherBirthDepartment() {
		return this.motherBirthDepartment;
	}

	public void setChildSituation(String childSituation) {
		this.childSituation = childSituation;
	}
	
	public String getChildSituation() {
		return this.childSituation;
	}

	public void setChildOtherCountry(String childOtherCountry) {
		this.childOtherCountry = childOtherCountry;
	}
	
	public String getChildOtherCountry() {
		return this.childOtherCountry;
	}

	public void setFatherLastName(String fatherLastName) {
		this.fatherLastName = fatherLastName;
	}
	
	public String getFatherLastName() {
		return this.fatherLastName;
	}

	public void setChildProfession(String childProfession) {
		this.childProfession = childProfession;
	}
	
	public String getChildProfession() {
		return this.childProfession;
	}

	public void setChildBirthCountry(String childBirthCountry) {
		this.childBirthCountry = childBirthCountry;
	}
	
	public String getChildBirthCountry() {
		return this.childBirthCountry;
	}

	public void setJapdExemption(boolean japdExemption) {
		this.japdExemption = japdExemption;
	}
	
	public boolean getJapdExemption() {
		return this.japdExemption;
	}

	public void setHighlyInfirm(boolean highlyInfirm) {
		this.highlyInfirm = highlyInfirm;
	}
	
	public boolean getHighlyInfirm() {
		return this.highlyInfirm;
	}

	public void setPrefectPupilDepartment(String prefectPupilDepartment) {
		this.prefectPupilDepartment = prefectPupilDepartment;
	}
	
	public String getPrefectPupilDepartment() {
		return this.prefectPupilDepartment;
	}

	public void setChildPhone(String childPhone) {
		this.childPhone = childPhone;
	}
	
	public String getChildPhone() {
		return this.childPhone;
	}

}

