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

	private String fatherBirthCity;
	private Calendar fatherBirthDate;
	private String fatherBirthDepartment;
	private String childProfession;
	private String childSpeciality;
	private String fatherFirstName;
	private String childOtherCountry;
	private String otherSituation;
	private String motherBirthCity;
	private String fatherNationality;
	private String subjectChildLastName;
	private Calendar motherBirthDate;
	private String childStatus;
	private java.math.BigInteger aliveChildren;
	private boolean prefectPupil;
	private java.math.BigInteger childrenInCharge;
	private String childCountry;
	private boolean affectionOrDisease;
	private String subjectChildFirstName;
	private boolean japdExemption;
	private String childSituation;
	private String subjectChildBirthPlacePostalCode;
	private String motherFirstName;
	private String maidenName;
	private boolean statePupil;
	private String childTitle;
	private String childConvention;
	private String childBirthCountry;
	private String motherNationality;
	private String childPhone;
	private String fatherBirthCountry;
	private String childMail;
	private String motherLastName;
	private String subjectChildBirthPlaceCity;
	private Calendar subjectChildBirthDate;
	private String childDiploma;
	private boolean highlyInfirm;
	private String fatherLastName;
	private String motherBirthCountry;
  	private String subjectChildAddressAdditionalDeliveryInformation;
	private String subjectChildAddressAdditionalGeographicalInformation;
	private String subjectChildAddressStreetNumber;
	private String subjectChildAddressStreetName;
	private String subjectChildAddressPlaceNameOrService;
	private String subjectChildAddressPostalCode;
	private String subjectChildAddressCity;
	private String prefectPupilDepartment;
	private String childResidenceCountry;
	private String motherBirthDepartment;

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

			this.fatherBirthCity = request.getFatherBirthCity();
			if (request.getFatherBirthDate() != null) {
				this.fatherBirthDate = Calendar.getInstance(); 
	            this.fatherBirthDate.setTime(request.getFatherBirthDate());
			}
			if (request.getFatherBirthDepartment() != null)
                this.fatherBirthDepartment = getEnumElementTranslation(
                        fr.cg95.cvq.xml.military.MilitaryCensusRequestDocument.MilitaryCensusRequest.class.getName(), 
                        "FatherBirthDepartment", request.getFatherBirthDepartment().toString());
			this.childProfession = request.getChildProfession();
			this.childSpeciality = request.getChildSpeciality();
			this.fatherFirstName = request.getFatherFirstName();
			if (request.getChildOtherCountry() != null)
                this.childOtherCountry = getEnumElementTranslation(
                        fr.cg95.cvq.xml.military.MilitaryCensusRequestDocument.MilitaryCensusRequest.class.getName(), 
                        "ChildOtherCountry", request.getChildOtherCountry().toString());
			this.otherSituation = request.getOtherSituation();
			this.motherBirthCity = request.getMotherBirthCity();
			if (request.getFatherNationality() != null)
                this.fatherNationality = getEnumElementTranslation(
                        fr.cg95.cvq.xml.military.MilitaryCensusRequestDocument.MilitaryCensusRequest.class.getName(), 
                        "FatherNationality", request.getFatherNationality().toString());
			this.subjectChildLastName = ((Child)request.getSubject()).getLastName();
			if (request.getMotherBirthDate() != null) {
				this.motherBirthDate = Calendar.getInstance(); 
	            this.motherBirthDate.setTime(request.getMotherBirthDate());
			}
			if (request.getChildStatus() != null)
                this.childStatus = getEnumElementTranslation(
                        fr.cg95.cvq.xml.military.MilitaryCensusRequestDocument.MilitaryCensusRequest.class.getName(), 
                        "ChildStatus", request.getChildStatus().toString());
			this.aliveChildren = request.getAliveChildren();
            if ((request.getPrefectPupil() != null))
			this.prefectPupil = request.getPrefectPupil();
			this.childrenInCharge = request.getChildrenInCharge();
			if (request.getChildCountry() != null)
                this.childCountry = getEnumElementTranslation(
                        fr.cg95.cvq.xml.military.MilitaryCensusRequestDocument.MilitaryCensusRequest.class.getName(), 
                        "ChildCountry", request.getChildCountry().toString());
            if ((request.getAffectionOrDisease() != null))
			this.affectionOrDisease = request.getAffectionOrDisease();
			this.subjectChildFirstName = ((Child)request.getSubject()).getFirstName();
            if ((request.getJapdExemption() != null))
			this.japdExemption = request.getJapdExemption();
			if (request.getChildSituation() != null)
                this.childSituation = getEnumElementTranslation(
                        fr.cg95.cvq.xml.military.MilitaryCensusRequestDocument.MilitaryCensusRequest.class.getName(), 
                        "ChildSituation", request.getChildSituation().toString());
			this.subjectChildBirthPlacePostalCode = ((Child)request.getSubject()).getBirthPostalCode();
			this.motherFirstName = request.getMotherFirstName();
			this.maidenName = request.getMaidenName();
            if ((request.getStatePupil() != null))
			this.statePupil = request.getStatePupil();
			if (request.getChildTitle() != null)
                this.childTitle = getEnumElementTranslation(
                        fr.cg95.cvq.xml.military.MilitaryCensusRequestDocument.MilitaryCensusRequest.class.getName(), 
                        "ChildTitle", request.getChildTitle().toString());
			this.childConvention = request.getChildConvention();
			if (request.getChildBirthCountry() != null)
                this.childBirthCountry = getEnumElementTranslation(
                        fr.cg95.cvq.xml.military.MilitaryCensusRequestDocument.MilitaryCensusRequest.class.getName(), 
                        "ChildBirthCountry", request.getChildBirthCountry().toString());
			if (request.getMotherNationality() != null)
                this.motherNationality = getEnumElementTranslation(
                        fr.cg95.cvq.xml.military.MilitaryCensusRequestDocument.MilitaryCensusRequest.class.getName(), 
                        "MotherNationality", request.getMotherNationality().toString());
			this.childPhone = request.getChildPhone();
			if (request.getFatherBirthCountry() != null)
                this.fatherBirthCountry = getEnumElementTranslation(
                        fr.cg95.cvq.xml.military.MilitaryCensusRequestDocument.MilitaryCensusRequest.class.getName(), 
                        "FatherBirthCountry", request.getFatherBirthCountry().toString());
			this.childMail = request.getChildMail();
			this.motherLastName = request.getMotherLastName();
			this.subjectChildBirthPlaceCity = ((Child)request.getSubject()).getBirthCity();
			if (((Child)request.getSubject()).getBirthDate() != null) {
				this.subjectChildBirthDate = Calendar.getInstance(); 
	            this.subjectChildBirthDate.setTime(((Child)request.getSubject()).getBirthDate());
			}
			if (request.getChildDiploma() != null)
                this.childDiploma = getEnumElementTranslation(
                        fr.cg95.cvq.xml.military.MilitaryCensusRequestDocument.MilitaryCensusRequest.class.getName(), 
                        "ChildDiploma", request.getChildDiploma().toString());
            if ((request.getHighlyInfirm() != null))
			this.highlyInfirm = request.getHighlyInfirm();
			this.fatherLastName = request.getFatherLastName();
			if (request.getMotherBirthCountry() != null)
                this.motherBirthCountry = getEnumElementTranslation(
                        fr.cg95.cvq.xml.military.MilitaryCensusRequestDocument.MilitaryCensusRequest.class.getName(), 
                        "MotherBirthCountry", request.getMotherBirthCountry().toString());
			if (((Child)request.getSubject()).getAdress() != null) {
				this.subjectChildAddressAdditionalDeliveryInformation = ((Child)request.getSubject()).getAdress().getAdditionalDeliveryInformation();
				this.subjectChildAddressAdditionalGeographicalInformation = ((Child)request.getSubject()).getAdress().getAdditionalGeographicalInformation();
				this.subjectChildAddressStreetNumber = ((Child)request.getSubject()).getAdress().getStreetNumber();
				this.subjectChildAddressStreetName = ((Child)request.getSubject()).getAdress().getStreetName();
				this.subjectChildAddressPlaceNameOrService = ((Child)request.getSubject()).getAdress().getPlaceNameOrService();
				this.subjectChildAddressPostalCode = ((Child)request.getSubject()).getAdress().getPostalCode();
				this.subjectChildAddressCity = ((Child)request.getSubject()).getAdress().getCity();
			}
			if (request.getPrefectPupilDepartment() != null)
                this.prefectPupilDepartment = getEnumElementTranslation(
                        fr.cg95.cvq.xml.military.MilitaryCensusRequestDocument.MilitaryCensusRequest.class.getName(), 
                        "PrefectPupilDepartment", request.getPrefectPupilDepartment().toString());
			if (request.getChildResidenceCountry() != null)
                this.childResidenceCountry = getEnumElementTranslation(
                        fr.cg95.cvq.xml.military.MilitaryCensusRequestDocument.MilitaryCensusRequest.class.getName(), 
                        "ChildResidenceCountry", request.getChildResidenceCountry().toString());
			if (request.getMotherBirthDepartment() != null)
                this.motherBirthDepartment = getEnumElementTranslation(
                        fr.cg95.cvq.xml.military.MilitaryCensusRequestDocument.MilitaryCensusRequest.class.getName(), 
                        "MotherBirthDepartment", request.getMotherBirthDepartment().toString());
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

			request.setFatherBirthCity(this.fatherBirthCity);
			if (this.fatherBirthDate != null)
			request.setFatherBirthDate(this.fatherBirthDate.getTime());
			if (this.fatherBirthDepartment != null)
                request.setFatherBirthDepartment(
                    InseeDepartementCodeType.forString(
                        getEnumKeyTranslation(
                            fr.cg95.cvq.xml.military.MilitaryCensusRequestDocument.MilitaryCensusRequest.class.getName(), 
                            "FatherBirthDepartment", this.fatherBirthDepartment)
                    )
                );
			request.setChildProfession(this.childProfession);
			request.setChildSpeciality(this.childSpeciality);
			request.setFatherFirstName(this.fatherFirstName);
			request.setOtherSituation(this.otherSituation);
			request.setMotherBirthCity(this.motherBirthCity);
			if (this.fatherNationality != null)
                request.setFatherNationality(
                    FullNationalityType.forString(
                        getEnumKeyTranslation(
                            fr.cg95.cvq.xml.military.MilitaryCensusRequestDocument.MilitaryCensusRequest.class.getName(), 
                            "FatherNationality", this.fatherNationality)
                    )
                );
			if (this.motherBirthDate != null)
			request.setMotherBirthDate(this.motherBirthDate.getTime());
			if (this.childStatus != null)
                request.setChildStatus(
                    FamilyStatusType.forString(
                        getEnumKeyTranslation(
                            fr.cg95.cvq.xml.military.MilitaryCensusRequestDocument.MilitaryCensusRequest.class.getName(), 
                            "ChildStatus", this.childStatus)
                    )
                );
			request.setAliveChildren(this.aliveChildren);
            if ((request.getPrefectPupil() != null))
			request.setPrefectPupil(this.prefectPupil);
			request.setChildrenInCharge(this.childrenInCharge);
            if ((request.getAffectionOrDisease() != null))
			request.setAffectionOrDisease(this.affectionOrDisease);
            if ((request.getJapdExemption() != null))
			request.setJapdExemption(this.japdExemption);
			if (this.childSituation != null)
                request.setChildSituation(
                    ChildSituationType.forString(
                        getEnumKeyTranslation(
                            fr.cg95.cvq.xml.military.MilitaryCensusRequestDocument.MilitaryCensusRequest.class.getName(), 
                            "ChildSituation", this.childSituation)
                    )
                );
			request.setMotherFirstName(this.motherFirstName);
			request.setMaidenName(this.maidenName);
            if ((request.getStatePupil() != null))
			request.setStatePupil(this.statePupil);
			if (this.childTitle != null)
                request.setChildTitle(
                    TitleType.forString(
                        getEnumKeyTranslation(
                            fr.cg95.cvq.xml.military.MilitaryCensusRequestDocument.MilitaryCensusRequest.class.getName(), 
                            "ChildTitle", this.childTitle)
                    )
                );
			request.setChildConvention(this.childConvention);
			if (this.childBirthCountry != null)
                request.setChildBirthCountry(
                    CountryType.forString(
                        getEnumKeyTranslation(
                            fr.cg95.cvq.xml.military.MilitaryCensusRequestDocument.MilitaryCensusRequest.class.getName(), 
                            "ChildBirthCountry", this.childBirthCountry)
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
			if (this.fatherBirthCountry != null)
                request.setFatherBirthCountry(
                    CountryType.forString(
                        getEnumKeyTranslation(
                            fr.cg95.cvq.xml.military.MilitaryCensusRequestDocument.MilitaryCensusRequest.class.getName(), 
                            "FatherBirthCountry", this.fatherBirthCountry)
                    )
                );
			request.setChildMail(this.childMail);
			request.setMotherLastName(this.motherLastName);
			if (this.childDiploma != null)
                request.setChildDiploma(
                    ChildDiplomaType.forString(
                        getEnumKeyTranslation(
                            fr.cg95.cvq.xml.military.MilitaryCensusRequestDocument.MilitaryCensusRequest.class.getName(), 
                            "ChildDiploma", this.childDiploma)
                    )
                );
            if ((request.getHighlyInfirm() != null))
			request.setHighlyInfirm(this.highlyInfirm);
			request.setFatherLastName(this.fatherLastName);
			if (this.motherBirthCountry != null)
                request.setMotherBirthCountry(
                    CountryType.forString(
                        getEnumKeyTranslation(
                            fr.cg95.cvq.xml.military.MilitaryCensusRequestDocument.MilitaryCensusRequest.class.getName(), 
                            "MotherBirthCountry", this.motherBirthCountry)
                    )
                );
			if (this.prefectPupilDepartment != null)
                request.setPrefectPupilDepartment(
                    InseeDepartementCodeType.forString(
                        getEnumKeyTranslation(
                            fr.cg95.cvq.xml.military.MilitaryCensusRequestDocument.MilitaryCensusRequest.class.getName(), 
                            "PrefectPupilDepartment", this.prefectPupilDepartment)
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
			if (this.motherBirthDepartment != null)
                request.setMotherBirthDepartment(
                    InseeDepartementCodeType.forString(
                        getEnumKeyTranslation(
                            fr.cg95.cvq.xml.military.MilitaryCensusRequestDocument.MilitaryCensusRequest.class.getName(), 
                            "MotherBirthDepartment", this.motherBirthDepartment)
                    )
                );
        }
    }
    
	public void setFatherBirthCity(String fatherBirthCity) {
		this.fatherBirthCity = fatherBirthCity;
	}
	
	public String getFatherBirthCity() {
		return this.fatherBirthCity;
	}

	public void setFatherBirthDate(Calendar fatherBirthDate) {
		this.fatherBirthDate = fatherBirthDate;
	}
	
	public Calendar getFatherBirthDate() {
		return this.fatherBirthDate;
	}

	public void setFatherBirthDepartment(String fatherBirthDepartment) {
		this.fatherBirthDepartment = fatherBirthDepartment;
	}
	
	public String getFatherBirthDepartment() {
		return this.fatherBirthDepartment;
	}

	public void setChildProfession(String childProfession) {
		this.childProfession = childProfession;
	}
	
	public String getChildProfession() {
		return this.childProfession;
	}

	public void setChildSpeciality(String childSpeciality) {
		this.childSpeciality = childSpeciality;
	}
	
	public String getChildSpeciality() {
		return this.childSpeciality;
	}

	public void setFatherFirstName(String fatherFirstName) {
		this.fatherFirstName = fatherFirstName;
	}
	
	public String getFatherFirstName() {
		return this.fatherFirstName;
	}

	public void setChildOtherCountry(String childOtherCountry) {
		this.childOtherCountry = childOtherCountry;
	}
	
	public String getChildOtherCountry() {
		return this.childOtherCountry;
	}

	public void setOtherSituation(String otherSituation) {
		this.otherSituation = otherSituation;
	}
	
	public String getOtherSituation() {
		return this.otherSituation;
	}

	public void setMotherBirthCity(String motherBirthCity) {
		this.motherBirthCity = motherBirthCity;
	}
	
	public String getMotherBirthCity() {
		return this.motherBirthCity;
	}

	public void setFatherNationality(String fatherNationality) {
		this.fatherNationality = fatherNationality;
	}
	
	public String getFatherNationality() {
		return this.fatherNationality;
	}

	public void setSubjectChildLastName(String subjectChildLastName) {
		this.subjectChildLastName = subjectChildLastName;
	}
	
	public String getSubjectChildLastName() {
		return this.subjectChildLastName;
	}

	public void setMotherBirthDate(Calendar motherBirthDate) {
		this.motherBirthDate = motherBirthDate;
	}
	
	public Calendar getMotherBirthDate() {
		return this.motherBirthDate;
	}

	public void setChildStatus(String childStatus) {
		this.childStatus = childStatus;
	}
	
	public String getChildStatus() {
		return this.childStatus;
	}

	public void setAliveChildren(java.math.BigInteger aliveChildren) {
		this.aliveChildren = aliveChildren;
	}
	
	public java.math.BigInteger getAliveChildren() {
		return this.aliveChildren;
	}

	public void setPrefectPupil(boolean prefectPupil) {
		this.prefectPupil = prefectPupil;
	}
	
	public boolean getPrefectPupil() {
		return this.prefectPupil;
	}

	public void setChildrenInCharge(java.math.BigInteger childrenInCharge) {
		this.childrenInCharge = childrenInCharge;
	}
	
	public java.math.BigInteger getChildrenInCharge() {
		return this.childrenInCharge;
	}

	public void setChildCountry(String childCountry) {
		this.childCountry = childCountry;
	}
	
	public String getChildCountry() {
		return this.childCountry;
	}

	public void setAffectionOrDisease(boolean affectionOrDisease) {
		this.affectionOrDisease = affectionOrDisease;
	}
	
	public boolean getAffectionOrDisease() {
		return this.affectionOrDisease;
	}

	public void setSubjectChildFirstName(String subjectChildFirstName) {
		this.subjectChildFirstName = subjectChildFirstName;
	}
	
	public String getSubjectChildFirstName() {
		return this.subjectChildFirstName;
	}

	public void setJapdExemption(boolean japdExemption) {
		this.japdExemption = japdExemption;
	}
	
	public boolean getJapdExemption() {
		return this.japdExemption;
	}

	public void setChildSituation(String childSituation) {
		this.childSituation = childSituation;
	}
	
	public String getChildSituation() {
		return this.childSituation;
	}

	public void setSubjectChildBirthPlacePostalCode(String subjectChildBirthPlacePostalCode) {
		this.subjectChildBirthPlacePostalCode = subjectChildBirthPlacePostalCode;
	}
	
	public String getSubjectChildBirthPlacePostalCode() {
		return this.subjectChildBirthPlacePostalCode;
	}

	public void setMotherFirstName(String motherFirstName) {
		this.motherFirstName = motherFirstName;
	}
	
	public String getMotherFirstName() {
		return this.motherFirstName;
	}

	public void setMaidenName(String maidenName) {
		this.maidenName = maidenName;
	}
	
	public String getMaidenName() {
		return this.maidenName;
	}

	public void setStatePupil(boolean statePupil) {
		this.statePupil = statePupil;
	}
	
	public boolean getStatePupil() {
		return this.statePupil;
	}

	public void setChildTitle(String childTitle) {
		this.childTitle = childTitle;
	}
	
	public String getChildTitle() {
		return this.childTitle;
	}

	public void setChildConvention(String childConvention) {
		this.childConvention = childConvention;
	}
	
	public String getChildConvention() {
		return this.childConvention;
	}

	public void setChildBirthCountry(String childBirthCountry) {
		this.childBirthCountry = childBirthCountry;
	}
	
	public String getChildBirthCountry() {
		return this.childBirthCountry;
	}

	public void setMotherNationality(String motherNationality) {
		this.motherNationality = motherNationality;
	}
	
	public String getMotherNationality() {
		return this.motherNationality;
	}

	public void setChildPhone(String childPhone) {
		this.childPhone = childPhone;
	}
	
	public String getChildPhone() {
		return this.childPhone;
	}

	public void setFatherBirthCountry(String fatherBirthCountry) {
		this.fatherBirthCountry = fatherBirthCountry;
	}
	
	public String getFatherBirthCountry() {
		return this.fatherBirthCountry;
	}

	public void setChildMail(String childMail) {
		this.childMail = childMail;
	}
	
	public String getChildMail() {
		return this.childMail;
	}

	public void setMotherLastName(String motherLastName) {
		this.motherLastName = motherLastName;
	}
	
	public String getMotherLastName() {
		return this.motherLastName;
	}

	public void setSubjectChildBirthPlaceCity(String subjectChildBirthPlaceCity) {
		this.subjectChildBirthPlaceCity = subjectChildBirthPlaceCity;
	}
	
	public String getSubjectChildBirthPlaceCity() {
		return this.subjectChildBirthPlaceCity;
	}

	public void setSubjectChildBirthDate(Calendar subjectChildBirthDate) {
		this.subjectChildBirthDate = subjectChildBirthDate;
	}
	
	public Calendar getSubjectChildBirthDate() {
		return this.subjectChildBirthDate;
	}

	public void setChildDiploma(String childDiploma) {
		this.childDiploma = childDiploma;
	}
	
	public String getChildDiploma() {
		return this.childDiploma;
	}

	public void setHighlyInfirm(boolean highlyInfirm) {
		this.highlyInfirm = highlyInfirm;
	}
	
	public boolean getHighlyInfirm() {
		return this.highlyInfirm;
	}

	public void setFatherLastName(String fatherLastName) {
		this.fatherLastName = fatherLastName;
	}
	
	public String getFatherLastName() {
		return this.fatherLastName;
	}

	public void setMotherBirthCountry(String motherBirthCountry) {
		this.motherBirthCountry = motherBirthCountry;
	}
	
	public String getMotherBirthCountry() {
		return this.motherBirthCountry;
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

	public void setPrefectPupilDepartment(String prefectPupilDepartment) {
		this.prefectPupilDepartment = prefectPupilDepartment;
	}
	
	public String getPrefectPupilDepartment() {
		return this.prefectPupilDepartment;
	}

	public void setChildResidenceCountry(String childResidenceCountry) {
		this.childResidenceCountry = childResidenceCountry;
	}
	
	public String getChildResidenceCountry() {
		return this.childResidenceCountry;
	}

	public void setMotherBirthDepartment(String motherBirthDepartment) {
		this.motherBirthDepartment = motherBirthDepartment;
	}
	
	public String getMotherBirthDepartment() {
		return this.motherBirthDepartment;
	}

}

