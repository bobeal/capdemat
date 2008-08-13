package fr.cg95.cvq.fo.military.form;

import java.util.Calendar;
import java.util.Collection;
import java.util.List;
import javax.servlet.http.HttpSession;
import fr.cg95.cvq.wizard.*;
import fr.cg95.cvq.xml.common.*;
import fr.cg95.cvq.xml.military.*;
import fr.cg95.cvq.xml.military.MilitaryCensusRequestDocument.MilitaryCensusRequest;

public class Validation extends IStageForm {

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

	public Validation() {
		super();
	}
	
	public void reset(String state) {
		if (state.equals("summary")) {
		}
	}
	
	public void load(HttpSession session, Object xmlbRequest) {
		if ((xmlbRequest != null) && (xmlbRequest instanceof MilitaryCensusRequest)) {
			MilitaryCensusRequest request = (MilitaryCensusRequest)xmlbRequest;
			if (request.getFatherBirthCountry() != null)
			this.fatherBirthCountry = request.getFatherBirthCountry().toString();
			this.motherFirstName = request.getMotherFirstName();
			this.statePupil = request.getStatePupil();
			this.otherSituation = request.getOtherSituation();
			if (request.getMotherBirthCountry() != null)
			this.motherBirthCountry = request.getMotherBirthCountry().toString();
			this.aliveChildren = request.getAliveChildren();
			this.fatherFirstName = request.getFatherFirstName();
			this.maidenName = request.getMaidenName();
			this.fatherBirthCity = request.getFatherBirthCity();
			this.motherBirthCity = request.getMotherBirthCity();
			this.childSpeciality = request.getChildSpeciality();
			this.prefectPupil = request.getPrefectPupil();
			if (request.getChildDiploma() != null)
			this.childDiploma = request.getChildDiploma().toString();
			if (request.getChildResidenceCountry() != null)
			this.childResidenceCountry = request.getChildResidenceCountry().toString();
  			this.subjectChildAddressAdditionalDeliveryInformation = request.getSubject().getChild().getAddress().getAdditionalDeliveryInformation();
			this.subjectChildAddressAdditionalGeographicalInformation = request.getSubject().getChild().getAddress().getAdditionalGeographicalInformation();
			this.subjectChildAddressStreetNumber = request.getSubject().getChild().getAddress().getStreetNumber();
			this.subjectChildAddressStreetName = request.getSubject().getChild().getAddress().getStreetName();
			this.subjectChildAddressPlaceNameOrService = request.getSubject().getChild().getAddress().getPlaceNameOrService();
			this.subjectChildAddressPostalCode = request.getSubject().getChild().getAddress().getPostalCode();
			this.subjectChildAddressCity = request.getSubject().getChild().getAddress().getCity();
			if (request.getFatherNationality() != null)
			this.fatherNationality = request.getFatherNationality().toString();
			if (request.getChildCountry() != null)
			this.childCountry = request.getChildCountry().toString();
			this.subjectChildBirthPlacePostalCode = request.getSubject().getChild().getBirthPlace().getPostalCode();
			if (request.getFatherBirthDepartment() != null)
			this.fatherBirthDepartment = request.getFatherBirthDepartment().toString();
			this.subjectChildBirthDate = request.getSubject().getChild().getBirthDate();
			if (request.getMotherNationality() != null)
			this.motherNationality = request.getMotherNationality().toString();
			this.affectionOrDisease = request.getAffectionOrDisease();
			if (request.getChildStatus() != null)
			this.childStatus = request.getChildStatus().toString();
			this.motherBirthDate = request.getMotherBirthDate();
			this.childrenInCharge = request.getChildrenInCharge();
			this.motherLastName = request.getMotherLastName();
			this.subjectChildFirstName = request.getSubject().getChild().getFirstName();
			if (request.getChildTitle() != null)
			this.childTitle = request.getChildTitle().toString();
			this.fatherBirthDate = request.getFatherBirthDate();
			this.childConvention = request.getChildConvention();
			this.childMail = request.getChildMail();
			this.subjectChildBirthPlaceCity = request.getSubject().getChild().getBirthPlace().getCity();
			this.subjectChildLastName = request.getSubject().getChild().getLastName();
			if (request.getMotherBirthDepartment() != null)
			this.motherBirthDepartment = request.getMotherBirthDepartment().toString();
			if (request.getChildSituation() != null)
			this.childSituation = request.getChildSituation().toString();
			if (request.getChildOtherCountry() != null)
			this.childOtherCountry = request.getChildOtherCountry().toString();
			this.fatherLastName = request.getFatherLastName();
			this.childProfession = request.getChildProfession();
			if (request.getChildBirthCountry() != null)
			this.childBirthCountry = request.getChildBirthCountry().toString();
			this.japdExemption = request.getJapdExemption();
			this.highlyInfirm = request.getHighlyInfirm();
			if (request.getPrefectPupilDepartment() != null)
			this.prefectPupilDepartment = request.getPrefectPupilDepartment().toString();
			this.childPhone = request.getChildPhone();
		}
	}
	
	public void save(HttpSession session, Object xmlbRequest) {
		if ((xmlbRequest != null) && (xmlbRequest instanceof MilitaryCensusRequest)) {
			MilitaryCensusRequest request = (MilitaryCensusRequest)xmlbRequest;
			request.setFatherBirthCountry(CountryType.Enum.forString(this.fatherBirthCountry));
			request.setMotherFirstName(this.motherFirstName);
			request.setStatePupil(this.statePupil);
			request.setOtherSituation(this.otherSituation);
			request.setMotherBirthCountry(CountryType.Enum.forString(this.motherBirthCountry));
			request.setAliveChildren(this.aliveChildren);
			request.setFatherFirstName(this.fatherFirstName);
			request.setMaidenName(this.maidenName);
			request.setFatherBirthCity(this.fatherBirthCity);
			request.setMotherBirthCity(this.motherBirthCity);
			request.setChildSpeciality(this.childSpeciality);
			request.setPrefectPupil(this.prefectPupil);
			request.setChildDiploma(ChildDiplomaType.Enum.forString(this.childDiploma));
			request.setChildResidenceCountry(CountryType.Enum.forString(this.childResidenceCountry));
  			request.getSubject().getChild().getAddress().setAdditionalDeliveryInformation(this.subjectChildAddressAdditionalDeliveryInformation);
			request.getSubject().getChild().getAddress().setAdditionalGeographicalInformation(this.subjectChildAddressAdditionalGeographicalInformation);
			request.getSubject().getChild().getAddress().setStreetNumber(this.subjectChildAddressStreetNumber);
			request.getSubject().getChild().getAddress().setStreetName(this.subjectChildAddressStreetName);
			request.getSubject().getChild().getAddress().setPlaceNameOrService(this.subjectChildAddressPlaceNameOrService);
			request.getSubject().getChild().getAddress().setPostalCode(this.subjectChildAddressPostalCode);
			request.getSubject().getChild().getAddress().setCity(this.subjectChildAddressCity);
			request.setFatherNationality(FullNationalityType.Enum.forString(this.fatherNationality));
			request.setChildCountry(FullNationalityType.Enum.forString(this.childCountry));
			request.getSubject().getChild().getBirthPlace().setPostalCode(this.subjectChildBirthPlacePostalCode);
			request.setFatherBirthDepartment(InseeDepartementCodeType.Enum.forString(this.fatherBirthDepartment));
			request.getSubject().getChild().setBirthDate(this.subjectChildBirthDate);
			request.setMotherNationality(FullNationalityType.Enum.forString(this.motherNationality));
			request.setAffectionOrDisease(this.affectionOrDisease);
			request.setChildStatus(FamilyStatusType.Enum.forString(this.childStatus));
			request.setMotherBirthDate(this.motherBirthDate);
			request.setChildrenInCharge(this.childrenInCharge);
			request.setMotherLastName(this.motherLastName);
			request.getSubject().getChild().setFirstName(this.subjectChildFirstName);
			request.setChildTitle(TitleType.Enum.forString(this.childTitle));
			request.setFatherBirthDate(this.fatherBirthDate);
			request.setChildConvention(this.childConvention);
			request.setChildMail(this.childMail);
			request.getSubject().getChild().getBirthPlace().setCity(this.subjectChildBirthPlaceCity);
			request.getSubject().getChild().setLastName(this.subjectChildLastName);
			request.setMotherBirthDepartment(InseeDepartementCodeType.Enum.forString(this.motherBirthDepartment));
			request.setChildSituation(ChildSituationType.Enum.forString(this.childSituation));
			request.setChildOtherCountry(FullNationalityType.Enum.forString(this.childOtherCountry));
			request.setFatherLastName(this.fatherLastName);
			request.setChildProfession(this.childProfession);
			request.setChildBirthCountry(CountryType.Enum.forString(this.childBirthCountry));
			request.setJapdExemption(this.japdExemption);
			request.setHighlyInfirm(this.highlyInfirm);
			request.setPrefectPupilDepartment(InseeDepartementCodeType.Enum.forString(this.prefectPupilDepartment));
			request.setChildPhone(this.childPhone);
		}
	}
	
	public boolean isComplete() {
		if (this.checkMotherFirstName() &&
			((this.motherFirstName == null) || (this.motherFirstName.length() == 0)))
			return false;
		if (this.checkMotherBirthCity() &&
			((this.motherBirthCity == null) || (this.motherBirthCity.length() == 0)))
			return false;
		if (this.checkChildDiploma() &&
			((this.childDiploma == null) || (this.childDiploma.length() == 0)))
			return false;
  		if (this.checkSubjectChildAddressStreetName() &&
			((this.subjectChildAddressStreetName == null) || (this.subjectChildAddressStreetName.length() == 0)))
			return false;
		if (this.checkSubjectChildAddressPostalCode() &&
			((this.subjectChildAddressPostalCode == null) || (this.subjectChildAddressPostalCode.length() == 0)))
			return false;
		if (this.checkSubjectChildAddressCity() &&
			((this.subjectChildAddressCity == null) || (this.subjectChildAddressCity.length() == 0)))
			return false;
		if (this.checkChildCountry() &&
			((this.childCountry == null) || (this.childCountry.length() == 0)))
			return false;
		if (this.checkSubjectChildBirthPlacePostalCode() &&
			((this.subjectChildBirthPlacePostalCode == null) || (this.subjectChildBirthPlacePostalCode.length() == 0)))
			return false;
		if (this.checkMotherNationality() &&
			((this.motherNationality == null) || (this.motherNationality.length() == 0)))
			return false;
		if (this.checkChildStatus() &&
			((this.childStatus == null) || (this.childStatus.length() == 0)))
			return false;
		if (this.checkMotherLastName() &&
			((this.motherLastName == null) || (this.motherLastName.length() == 0)))
			return false;
		if (this.checkSubjectChildFirstName() &&
			((this.subjectChildFirstName == null) || (this.subjectChildFirstName.length() == 0)))
			return false;
		if (this.checkChildTitle() &&
			((this.childTitle == null) || (this.childTitle.length() == 0)))
			return false;
		if (this.checkSubjectChildBirthPlaceCity() &&
			((this.subjectChildBirthPlaceCity == null) || (this.subjectChildBirthPlaceCity.length() == 0)))
			return false;
		if (this.checkSubjectChildLastName() &&
			((this.subjectChildLastName == null) || (this.subjectChildLastName.length() == 0)))
			return false;
		if (this.checkChildSituation() &&
			((this.childSituation == null) || (this.childSituation.length() == 0)))
			return false;
		if (this.checkChildBirthCountry() &&
			((this.childBirthCountry == null) || (this.childBirthCountry.length() == 0)))
			return false;
		if (this.checkChildPhone() &&
			((this.childPhone == null) || (this.childPhone.length() == 0)))
			return false;
		return true;
	}
	
	public void setFatherBirthCountry(String fatherBirthCountry) {
		this.fatherBirthCountry = fatherBirthCountry;
	}
	
	public String getFatherBirthCountry() {
		return this.fatherBirthCountry;
	}
	
	public boolean checkFatherBirthCountry() {
		return true;
	}

	public void setMotherFirstName(String motherFirstName) {
		this.motherFirstName = motherFirstName;
	}
	
	public String getMotherFirstName() {
		return this.motherFirstName;
	}
	
	public boolean checkMotherFirstName() {
		return true;
	}

	public void setStatePupil(boolean statePupil) {
		this.statePupil = statePupil;
	}
	
	public boolean getStatePupil() {
		return this.statePupil;
	}
	
	public boolean checkStatePupil() {
		return true;
	}

	public void setOtherSituation(String otherSituation) {
		this.otherSituation = otherSituation;
	}
	
	public String getOtherSituation() {
		return this.otherSituation;
	}
	
	public boolean checkOtherSituation() {
		return true;
	}

	public void setMotherBirthCountry(String motherBirthCountry) {
		this.motherBirthCountry = motherBirthCountry;
	}
	
	public String getMotherBirthCountry() {
		return this.motherBirthCountry;
	}
	
	public boolean checkMotherBirthCountry() {
		return true;
	}

	public void setAliveChildren(java.math.BigInteger aliveChildren) {
		this.aliveChildren = aliveChildren;
	}
	
	public java.math.BigInteger getAliveChildren() {
		return this.aliveChildren;
	}
	
	public boolean checkAliveChildren() {
		return true;
	}

	public void setFatherFirstName(String fatherFirstName) {
		this.fatherFirstName = fatherFirstName;
	}
	
	public String getFatherFirstName() {
		return this.fatherFirstName;
	}
	
	public boolean checkFatherFirstName() {
		return true;
	}

	public void setMaidenName(String maidenName) {
		this.maidenName = maidenName;
	}
	
	public String getMaidenName() {
		return this.maidenName;
	}
	
	public boolean checkMaidenName() {
		return true;
	}

	public void setFatherBirthCity(String fatherBirthCity) {
		this.fatherBirthCity = fatherBirthCity;
	}
	
	public String getFatherBirthCity() {
		return this.fatherBirthCity;
	}
	
	public boolean checkFatherBirthCity() {
		return true;
	}

	public void setMotherBirthCity(String motherBirthCity) {
		this.motherBirthCity = motherBirthCity;
	}
	
	public String getMotherBirthCity() {
		return this.motherBirthCity;
	}
	
	public boolean checkMotherBirthCity() {
		return true;
	}

	public void setChildSpeciality(String childSpeciality) {
		this.childSpeciality = childSpeciality;
	}
	
	public String getChildSpeciality() {
		return this.childSpeciality;
	}
	
	public boolean checkChildSpeciality() {
		return true;
	}

	public void setPrefectPupil(boolean prefectPupil) {
		this.prefectPupil = prefectPupil;
	}
	
	public boolean getPrefectPupil() {
		return this.prefectPupil;
	}
	
	public boolean checkPrefectPupil() {
		return true;
	}

	public void setChildDiploma(String childDiploma) {
		this.childDiploma = childDiploma;
	}
	
	public String getChildDiploma() {
		return this.childDiploma;
	}
	
	public boolean checkChildDiploma() {
		return true;
	}

	public void setChildResidenceCountry(String childResidenceCountry) {
		this.childResidenceCountry = childResidenceCountry;
	}
	
	public String getChildResidenceCountry() {
		return this.childResidenceCountry;
	}
	
	public boolean checkChildResidenceCountry() {
		return true;
	}

  	public void setSubjectChildAddressAdditionalDeliveryInformation(String subjectChildAddressAdditionalDeliveryInformation) {
		this.subjectChildAddressAdditionalDeliveryInformation = subjectChildAddressAdditionalDeliveryInformation;
	}
	
	public String getSubjectChildAddressAdditionalDeliveryInformation() {
		return this.subjectChildAddressAdditionalDeliveryInformation;
	}
	
	public boolean checkSubjectChildAddressAdditionalDeliveryInformation() {
		return true;
	}

	public void setSubjectChildAddressAdditionalGeographicalInformation(String subjectChildAddressAdditionalGeographicalInformation) {
		this.subjectChildAddressAdditionalGeographicalInformation = subjectChildAddressAdditionalGeographicalInformation;
	}
	
	public String getSubjectChildAddressAdditionalGeographicalInformation() {
		return this.subjectChildAddressAdditionalGeographicalInformation;
	}
	
	public boolean checkSubjectChildAddressAdditionalGeographicalInformation() {
		return true;
	}

	public void setSubjectChildAddressStreetNumber(String subjectChildAddressStreetNumber) {
		this.subjectChildAddressStreetNumber = subjectChildAddressStreetNumber;
	}
	
	public String getSubjectChildAddressStreetNumber() {
		return this.subjectChildAddressStreetNumber;
	}
	
	public boolean checkSubjectChildAddressStreetNumber() {
		return true;
	}

	public void setSubjectChildAddressStreetName(String subjectChildAddressStreetName) {
		this.subjectChildAddressStreetName = subjectChildAddressStreetName;
	}
	
	public String getSubjectChildAddressStreetName() {
		return this.subjectChildAddressStreetName;
	}
	
	public boolean checkSubjectChildAddressStreetName() {
		return true;
	}

	public void setSubjectChildAddressPlaceNameOrService(String subjectChildAddressPlaceNameOrService) {
		this.subjectChildAddressPlaceNameOrService = subjectChildAddressPlaceNameOrService;
	}
	
	public String getSubjectChildAddressPlaceNameOrService() {
		return this.subjectChildAddressPlaceNameOrService;
	}
	
	public boolean checkSubjectChildAddressPlaceNameOrService() {
		return true;
	}

	public void setSubjectChildAddressPostalCode(String subjectChildAddressPostalCode) {
		this.subjectChildAddressPostalCode = subjectChildAddressPostalCode;
	}
	
	public String getSubjectChildAddressPostalCode() {
		return this.subjectChildAddressPostalCode;
	}
	
	public boolean checkSubjectChildAddressPostalCode() {
		return true;
	}

	public void setSubjectChildAddressCity(String subjectChildAddressCity) {
		this.subjectChildAddressCity = subjectChildAddressCity;
	}
	
	public String getSubjectChildAddressCity() {
		return this.subjectChildAddressCity;
	}
	
	public boolean checkSubjectChildAddressCity() {
		return true;
	}

	public void setFatherNationality(String fatherNationality) {
		this.fatherNationality = fatherNationality;
	}
	
	public String getFatherNationality() {
		return this.fatherNationality;
	}
	
	public boolean checkFatherNationality() {
		return true;
	}

	public void setChildCountry(String childCountry) {
		this.childCountry = childCountry;
	}
	
	public String getChildCountry() {
		return this.childCountry;
	}
	
	public boolean checkChildCountry() {
		return true;
	}

	public void setSubjectChildBirthPlacePostalCode(String subjectChildBirthPlacePostalCode) {
		this.subjectChildBirthPlacePostalCode = subjectChildBirthPlacePostalCode;
	}
	
	public String getSubjectChildBirthPlacePostalCode() {
		return this.subjectChildBirthPlacePostalCode;
	}
	
	public boolean checkSubjectChildBirthPlacePostalCode() {
		return true;
	}

	public void setFatherBirthDepartment(String fatherBirthDepartment) {
		this.fatherBirthDepartment = fatherBirthDepartment;
	}
	
	public String getFatherBirthDepartment() {
		return this.fatherBirthDepartment;
	}
	
	public boolean checkFatherBirthDepartment() {
		return true;
	}

	public void setSubjectChildBirthDate(Calendar subjectChildBirthDate) {
		this.subjectChildBirthDate = subjectChildBirthDate;
	}
	
	public Calendar getSubjectChildBirthDate() {
		return this.subjectChildBirthDate;
	}
	
	public boolean checkSubjectChildBirthDate() {
		return true;
	}

	public void setMotherNationality(String motherNationality) {
		this.motherNationality = motherNationality;
	}
	
	public String getMotherNationality() {
		return this.motherNationality;
	}
	
	public boolean checkMotherNationality() {
		return true;
	}

	public void setAffectionOrDisease(boolean affectionOrDisease) {
		this.affectionOrDisease = affectionOrDisease;
	}
	
	public boolean getAffectionOrDisease() {
		return this.affectionOrDisease;
	}
	
	public boolean checkAffectionOrDisease() {
		return true;
	}

	public void setChildStatus(String childStatus) {
		this.childStatus = childStatus;
	}
	
	public String getChildStatus() {
		return this.childStatus;
	}
	
	public boolean checkChildStatus() {
		return true;
	}

	public void setMotherBirthDate(Calendar motherBirthDate) {
		this.motherBirthDate = motherBirthDate;
	}
	
	public Calendar getMotherBirthDate() {
		return this.motherBirthDate;
	}
	
	public boolean checkMotherBirthDate() {
		return true;
	}

	public void setChildrenInCharge(java.math.BigInteger childrenInCharge) {
		this.childrenInCharge = childrenInCharge;
	}
	
	public java.math.BigInteger getChildrenInCharge() {
		return this.childrenInCharge;
	}
	
	public boolean checkChildrenInCharge() {
		return true;
	}

	public void setMotherLastName(String motherLastName) {
		this.motherLastName = motherLastName;
	}
	
	public String getMotherLastName() {
		return this.motherLastName;
	}
	
	public boolean checkMotherLastName() {
		return true;
	}

	public void setSubjectChildFirstName(String subjectChildFirstName) {
		this.subjectChildFirstName = subjectChildFirstName;
	}
	
	public String getSubjectChildFirstName() {
		return this.subjectChildFirstName;
	}
	
	public boolean checkSubjectChildFirstName() {
		return true;
	}

	public void setChildTitle(String childTitle) {
		this.childTitle = childTitle;
	}
	
	public String getChildTitle() {
		return this.childTitle;
	}
	
	public boolean checkChildTitle() {
		return true;
	}

	public void setFatherBirthDate(Calendar fatherBirthDate) {
		this.fatherBirthDate = fatherBirthDate;
	}
	
	public Calendar getFatherBirthDate() {
		return this.fatherBirthDate;
	}
	
	public boolean checkFatherBirthDate() {
		return true;
	}

	public void setChildConvention(String childConvention) {
		this.childConvention = childConvention;
	}
	
	public String getChildConvention() {
		return this.childConvention;
	}
	
	public boolean checkChildConvention() {
		return true;
	}

	public void setChildMail(String childMail) {
		this.childMail = childMail;
	}
	
	public String getChildMail() {
		return this.childMail;
	}
	
	public boolean checkChildMail() {
		return true;
	}

	public void setSubjectChildBirthPlaceCity(String subjectChildBirthPlaceCity) {
		this.subjectChildBirthPlaceCity = subjectChildBirthPlaceCity;
	}
	
	public String getSubjectChildBirthPlaceCity() {
		return this.subjectChildBirthPlaceCity;
	}
	
	public boolean checkSubjectChildBirthPlaceCity() {
		return true;
	}

	public void setSubjectChildLastName(String subjectChildLastName) {
		this.subjectChildLastName = subjectChildLastName;
	}
	
	public String getSubjectChildLastName() {
		return this.subjectChildLastName;
	}
	
	public boolean checkSubjectChildLastName() {
		return true;
	}

	public void setMotherBirthDepartment(String motherBirthDepartment) {
		this.motherBirthDepartment = motherBirthDepartment;
	}
	
	public String getMotherBirthDepartment() {
		return this.motherBirthDepartment;
	}
	
	public boolean checkMotherBirthDepartment() {
		return true;
	}

	public void setChildSituation(String childSituation) {
		this.childSituation = childSituation;
	}
	
	public String getChildSituation() {
		return this.childSituation;
	}
	
	public boolean checkChildSituation() {
		return true;
	}

	public void setChildOtherCountry(String childOtherCountry) {
		this.childOtherCountry = childOtherCountry;
	}
	
	public String getChildOtherCountry() {
		return this.childOtherCountry;
	}
	
	public boolean checkChildOtherCountry() {
		return true;
	}

	public void setFatherLastName(String fatherLastName) {
		this.fatherLastName = fatherLastName;
	}
	
	public String getFatherLastName() {
		return this.fatherLastName;
	}
	
	public boolean checkFatherLastName() {
		return true;
	}

	public void setChildProfession(String childProfession) {
		this.childProfession = childProfession;
	}
	
	public String getChildProfession() {
		return this.childProfession;
	}
	
	public boolean checkChildProfession() {
		return true;
	}

	public void setChildBirthCountry(String childBirthCountry) {
		this.childBirthCountry = childBirthCountry;
	}
	
	public String getChildBirthCountry() {
		return this.childBirthCountry;
	}
	
	public boolean checkChildBirthCountry() {
		return true;
	}

	public void setJapdExemption(boolean japdExemption) {
		this.japdExemption = japdExemption;
	}
	
	public boolean getJapdExemption() {
		return this.japdExemption;
	}
	
	public boolean checkJapdExemption() {
		return true;
	}

	public void setHighlyInfirm(boolean highlyInfirm) {
		this.highlyInfirm = highlyInfirm;
	}
	
	public boolean getHighlyInfirm() {
		return this.highlyInfirm;
	}
	
	public boolean checkHighlyInfirm() {
		return true;
	}

	public void setPrefectPupilDepartment(String prefectPupilDepartment) {
		this.prefectPupilDepartment = prefectPupilDepartment;
	}
	
	public String getPrefectPupilDepartment() {
		return this.prefectPupilDepartment;
	}
	
	public boolean checkPrefectPupilDepartment() {
		return true;
	}

	public void setChildPhone(String childPhone) {
		this.childPhone = childPhone;
	}
	
	public String getChildPhone() {
		return this.childPhone;
	}
	
	public boolean checkChildPhone() {
		return true;
	}

}
