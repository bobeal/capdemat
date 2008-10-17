package fr.cg95.cvq.fo.military.form;

import java.util.Calendar;
import java.util.Collection;
import java.util.List;
import javax.servlet.http.HttpSession;
import fr.cg95.cvq.wizard.*;
import fr.cg95.cvq.xml.common.*;
import fr.cg95.cvq.xml.military.*;
import fr.cg95.cvq.xml.military.MilitaryCensusRequestDocument.MilitaryCensusRequest;

public class Information extends IStageForm {

	private String fatherBirthCity;
	private Calendar fatherBirthDate;
	private String fatherBirthDepartment;
	private String childProfession;
	private String fatherFirstName;
	private String childSpeciality;
	private String otherSituation;
	private String motherBirthCity;
	private String fatherNationality;
	private Calendar motherBirthDate;
	private String childStatus;
	private java.math.BigInteger aliveChildren;
	private java.math.BigInteger childrenInCharge;
	private boolean prefectPupil;
	private String childSituation;
	private String motherFirstName;
	private boolean statePupil;
	private String motherNationality;
	private String fatherBirthCountry;
	private String motherLastName;
	private String childDiploma;
	private String motherBirthCountry;
	private String fatherLastName;
	private String prefectPupilDepartment;
	private String motherBirthDepartment;

	public Information() {
		super();
	}
	
	public void reset(String state) {
		if (state.equals("display")) {
		}
		if (state.equals("situation")) {
		}
		if (state.equals("filiation")) {
		}
	}
	
	public void load(HttpSession session, Object xmlbRequest) {
		if ((xmlbRequest != null) && (xmlbRequest instanceof MilitaryCensusRequest)) {
			MilitaryCensusRequest request = (MilitaryCensusRequest)xmlbRequest;
			this.fatherBirthCity = request.getFatherBirthCity();
			this.fatherBirthDate = request.getFatherBirthDate();
			if (request.getFatherBirthDepartment() != null)
			this.fatherBirthDepartment = request.getFatherBirthDepartment().toString();
			this.childProfession = request.getChildProfession();
			this.fatherFirstName = request.getFatherFirstName();
			this.childSpeciality = request.getChildSpeciality();
			this.otherSituation = request.getOtherSituation();
			this.motherBirthCity = request.getMotherBirthCity();
			if (request.getFatherNationality() != null)
			this.fatherNationality = request.getFatherNationality().toString();
			this.motherBirthDate = request.getMotherBirthDate();
			if (request.getChildStatus() != null)
			this.childStatus = request.getChildStatus().toString();
			this.aliveChildren = request.getAliveChildren();
			this.childrenInCharge = request.getChildrenInCharge();
			this.prefectPupil = request.getPrefectPupil();
			if (request.getChildSituation() != null)
			this.childSituation = request.getChildSituation().toString();
			this.motherFirstName = request.getMotherFirstName();
			this.statePupil = request.getStatePupil();
			if (request.getMotherNationality() != null)
			this.motherNationality = request.getMotherNationality().toString();
			if (request.getFatherBirthCountry() != null)
			this.fatherBirthCountry = request.getFatherBirthCountry().toString();
			this.motherLastName = request.getMotherLastName();
			if (request.getChildDiploma() != null)
			this.childDiploma = request.getChildDiploma().toString();
			if (request.getMotherBirthCountry() != null)
			this.motherBirthCountry = request.getMotherBirthCountry().toString();
			this.fatherLastName = request.getFatherLastName();
			if (request.getPrefectPupilDepartment() != null)
			this.prefectPupilDepartment = request.getPrefectPupilDepartment().toString();
			if (request.getMotherBirthDepartment() != null)
			this.motherBirthDepartment = request.getMotherBirthDepartment().toString();
		}
	}
	
	public void save(HttpSession session, Object xmlbRequest) {
		if ((xmlbRequest != null) && (xmlbRequest instanceof MilitaryCensusRequest)) {
			MilitaryCensusRequest request = (MilitaryCensusRequest)xmlbRequest;
			request.setFatherBirthCity(this.fatherBirthCity);
			request.setFatherBirthDate(this.fatherBirthDate);
			request.setFatherBirthDepartment(InseeDepartementCodeType.Enum.forString(this.fatherBirthDepartment));
			request.setChildProfession(this.childProfession);
			request.setFatherFirstName(this.fatherFirstName);
			request.setChildSpeciality(this.childSpeciality);
			request.setOtherSituation(this.otherSituation);
			request.setMotherBirthCity(this.motherBirthCity);
			request.setFatherNationality(FullNationalityType.Enum.forString(this.fatherNationality));
			request.setMotherBirthDate(this.motherBirthDate);
			request.setChildStatus(FamilyStatusType.Enum.forString(this.childStatus));
			request.setAliveChildren(this.aliveChildren);
			request.setChildrenInCharge(this.childrenInCharge);
			request.setPrefectPupil(this.prefectPupil);
			request.setChildSituation(ChildSituationType.Enum.forString(this.childSituation));
			request.setMotherFirstName(this.motherFirstName);
			request.setStatePupil(this.statePupil);
			request.setMotherNationality(FullNationalityType.Enum.forString(this.motherNationality));
			request.setFatherBirthCountry(CountryType.Enum.forString(this.fatherBirthCountry));
			request.setMotherLastName(this.motherLastName);
			request.setChildDiploma(ChildDiplomaType.Enum.forString(this.childDiploma));
			request.setMotherBirthCountry(CountryType.Enum.forString(this.motherBirthCountry));
			request.setFatherLastName(this.fatherLastName);
			request.setPrefectPupilDepartment(InseeDepartementCodeType.Enum.forString(this.prefectPupilDepartment));
			request.setMotherBirthDepartment(InseeDepartementCodeType.Enum.forString(this.motherBirthDepartment));
		}
	}
	
	public boolean isComplete() {
		if (this.checkMotherBirthCity() &&
			((this.motherBirthCity == null) || (this.motherBirthCity.length() == 0)))
			return false;
		if (this.checkMotherBirthDate() && (this.motherBirthDate == null))
			return false;
		if (this.checkChildStatus() &&
			((this.childStatus == null) || (this.childStatus.length() == 0)))
			return false;
		if (this.checkAliveChildren() && (this.aliveChildren == null))
			return false;
		if (this.checkChildrenInCharge() && (this.childrenInCharge == null))
			return false;
		if (this.checkChildSituation() &&
			((this.childSituation == null) || (this.childSituation.length() == 0)))
			return false;
		if (this.checkMotherFirstName() &&
			((this.motherFirstName == null) || (this.motherFirstName.length() == 0)))
			return false;
		if (this.checkMotherNationality() &&
			((this.motherNationality == null) || (this.motherNationality.length() == 0)))
			return false;
		if (this.checkMotherLastName() &&
			((this.motherLastName == null) || (this.motherLastName.length() == 0)))
			return false;
		if (this.checkChildDiploma() &&
			((this.childDiploma == null) || (this.childDiploma.length() == 0)))
			return false;
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

	public void setFatherBirthDate(Calendar fatherBirthDate) {
		this.fatherBirthDate = fatherBirthDate;
	}
	
	public Calendar getFatherBirthDate() {
		return this.fatherBirthDate;
	}
	
	public boolean checkFatherBirthDate() {
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

	public void setChildProfession(String childProfession) {
		this.childProfession = childProfession;
	}
	
	public String getChildProfession() {
		return this.childProfession;
	}
	
	public boolean checkChildProfession() {
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

	public void setChildSpeciality(String childSpeciality) {
		this.childSpeciality = childSpeciality;
	}
	
	public String getChildSpeciality() {
		return this.childSpeciality;
	}
	
	public boolean checkChildSpeciality() {
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

	public void setMotherBirthCity(String motherBirthCity) {
		this.motherBirthCity = motherBirthCity;
	}
	
	public String getMotherBirthCity() {
		return this.motherBirthCity;
	}
	
	public boolean checkMotherBirthCity() {
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

	public void setMotherBirthDate(Calendar motherBirthDate) {
		this.motherBirthDate = motherBirthDate;
	}
	
	public Calendar getMotherBirthDate() {
		return this.motherBirthDate;
	}
	
	public boolean checkMotherBirthDate() {
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

	public void setAliveChildren(java.math.BigInteger aliveChildren) {
		this.aliveChildren = aliveChildren;
	}
	
	public java.math.BigInteger getAliveChildren() {
		return this.aliveChildren;
	}
	
	public boolean checkAliveChildren() {
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

	public void setPrefectPupil(boolean prefectPupil) {
		this.prefectPupil = prefectPupil;
	}
	
	public boolean getPrefectPupil() {
		return this.prefectPupil;
	}
	
	public boolean checkPrefectPupil() {
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

	public void setMotherNationality(String motherNationality) {
		this.motherNationality = motherNationality;
	}
	
	public String getMotherNationality() {
		return this.motherNationality;
	}
	
	public boolean checkMotherNationality() {
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

	public void setMotherLastName(String motherLastName) {
		this.motherLastName = motherLastName;
	}
	
	public String getMotherLastName() {
		return this.motherLastName;
	}
	
	public boolean checkMotherLastName() {
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

	public void setMotherBirthCountry(String motherBirthCountry) {
		this.motherBirthCountry = motherBirthCountry;
	}
	
	public String getMotherBirthCountry() {
		return this.motherBirthCountry;
	}
	
	public boolean checkMotherBirthCountry() {
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

	public void setPrefectPupilDepartment(String prefectPupilDepartment) {
		this.prefectPupilDepartment = prefectPupilDepartment;
	}
	
	public String getPrefectPupilDepartment() {
		return this.prefectPupilDepartment;
	}
	
	public boolean checkPrefectPupilDepartment() {
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

}