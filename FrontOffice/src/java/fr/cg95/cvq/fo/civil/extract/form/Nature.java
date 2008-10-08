package fr.cg95.cvq.fo.civil.extract.form;

import java.util.Calendar;
import java.util.Collection;
import java.util.List;
import javax.servlet.http.HttpSession;
import fr.cg95.cvq.wizard.*;
import fr.cg95.cvq.xml.common.*;
import fr.cg95.cvq.xml.civil.*;
import fr.cg95.cvq.xml.civil.PersonalDetailsRequestDocument.PersonalDetailsRequest;

public class Nature extends IStageForm {

	private String deathFirstNames;
	private String deathCity;
	private String birthPostalCode;
	private String marriageHusbandFirstNames;
	private String marriageCity;
	private String birthFirstNames;
	private String marriageWifeLastName;
	private String requesterQualityPrecision;
	private Calendar birthDate;
	private String deathPostalCode;
	private String requesterQuality;
	private String birthCity;
	private Calendar marriageDate;
	private String deathLastName;
	private String marriageHusbandLastName;
	private String marriageWifeFirstNames;
	private String marriagePostalCode;
	private String certificate;
	private Calendar deathDate;
	private String birthLastName;

	public Nature() {
		super();
	}
	
	public void reset(String state) {
		if (state.equals("displaydeath")) {
		}
		if (state.equals("birth")) {
		}
		if (state.equals("death")) {
		}
		if (state.equals("displaybirth")) {
		}
		if (state.equals("displaymarriage")) {
		}
		if (state.equals("marriage")) {
		}
	}
	
	public void load(HttpSession session, Object xmlbRequest) {
		if ((xmlbRequest != null) && (xmlbRequest instanceof PersonalDetailsRequest)) {
			PersonalDetailsRequest request = (PersonalDetailsRequest)xmlbRequest;
			this.deathFirstNames = request.getDeathFirstNames();
			this.deathCity = request.getDeathCity();
			this.birthPostalCode = request.getBirthPostalCode();
			this.marriageHusbandFirstNames = request.getMarriageHusbandFirstNames();
			this.marriageCity = request.getMarriageCity();
			this.birthFirstNames = request.getBirthFirstNames();
			this.marriageWifeLastName = request.getMarriageWifeLastName();
			this.requesterQualityPrecision = request.getRequesterQualityPrecision();
			this.birthDate = request.getBirthDate();
			this.deathPostalCode = request.getDeathPostalCode();
			if (request.getRequesterQuality() != null)
			this.requesterQuality = request.getRequesterQuality().toString();
			this.birthCity = request.getBirthCity();
			this.marriageDate = request.getMarriageDate();
			this.deathLastName = request.getDeathLastName();
			this.marriageHusbandLastName = request.getMarriageHusbandLastName();
			this.marriageWifeFirstNames = request.getMarriageWifeFirstNames();
			this.marriagePostalCode = request.getMarriagePostalCode();
			if (request.getCertificate() != null)
			this.certificate = request.getCertificate().toString();
			this.deathDate = request.getDeathDate();
			this.birthLastName = request.getBirthLastName();
		}
	}
	
	public void save(HttpSession session, Object xmlbRequest) {
		if ((xmlbRequest != null) && (xmlbRequest instanceof PersonalDetailsRequest)) {
			PersonalDetailsRequest request = (PersonalDetailsRequest)xmlbRequest;
			request.setDeathFirstNames(this.deathFirstNames);
			request.setDeathCity(this.deathCity);
			request.setBirthPostalCode(this.birthPostalCode);
			request.setMarriageHusbandFirstNames(this.marriageHusbandFirstNames);
			request.setMarriageCity(this.marriageCity);
			request.setBirthFirstNames(this.birthFirstNames);
			request.setMarriageWifeLastName(this.marriageWifeLastName);
			request.setRequesterQualityPrecision(this.requesterQualityPrecision);
			request.setBirthDate(this.birthDate);
			request.setDeathPostalCode(this.deathPostalCode);
			request.setRequesterQuality(RequesterQualityType.Enum.forString(this.requesterQuality));
			request.setBirthCity(this.birthCity);
			request.setMarriageDate(this.marriageDate);
			request.setDeathLastName(this.deathLastName);
			request.setMarriageHusbandLastName(this.marriageHusbandLastName);
			request.setMarriageWifeFirstNames(this.marriageWifeFirstNames);
			request.setMarriagePostalCode(this.marriagePostalCode);
			request.setCertificate(CertificateType.Enum.forString(this.certificate));
			request.setDeathDate(this.deathDate);
			request.setBirthLastName(this.birthLastName);
		}
	}
	
	public boolean isComplete() {
		if (this.checkDeathFirstNames() &&
			((this.deathFirstNames == null) || (this.deathFirstNames.length() == 0)))
			return false;
		if (this.checkDeathCity() &&
			((this.deathCity == null) || (this.deathCity.length() == 0)))
			return false;
		if (this.checkBirthPostalCode() &&
			((this.birthPostalCode == null) || (this.birthPostalCode.length() == 0)))
			return false;
		if (this.checkMarriageHusbandFirstNames() &&
			((this.marriageHusbandFirstNames == null) || (this.marriageHusbandFirstNames.length() == 0)))
			return false;
		if (this.checkMarriageCity() &&
			((this.marriageCity == null) || (this.marriageCity.length() == 0)))
			return false;
		if (this.checkBirthFirstNames() &&
			((this.birthFirstNames == null) || (this.birthFirstNames.length() == 0)))
			return false;
		if (this.checkMarriageWifeLastName() &&
			((this.marriageWifeLastName == null) || (this.marriageWifeLastName.length() == 0)))
			return false;
		if (this.checkDeathPostalCode() &&
			((this.deathPostalCode == null) || (this.deathPostalCode.length() == 0)))
			return false;
		if (this.checkBirthCity() &&
			((this.birthCity == null) || (this.birthCity.length() == 0)))
			return false;
		if (this.checkDeathLastName() &&
			((this.deathLastName == null) || (this.deathLastName.length() == 0)))
			return false;
		if (this.checkMarriageHusbandLastName() &&
			((this.marriageHusbandLastName == null) || (this.marriageHusbandLastName.length() == 0)))
			return false;
		if (this.checkMarriageWifeFirstNames() &&
			((this.marriageWifeFirstNames == null) || (this.marriageWifeFirstNames.length() == 0)))
			return false;
		if (this.checkMarriagePostalCode() &&
			((this.marriagePostalCode == null) || (this.marriagePostalCode.length() == 0)))
			return false;
		if (this.checkCertificate() &&
			((this.certificate == null) || (this.certificate.length() == 0)))
			return false;
		if (this.checkBirthLastName() &&
			((this.birthLastName == null) || (this.birthLastName.length() == 0)))
			return false;
		return true;
	}
	
	public void setDeathFirstNames(String deathFirstNames) {
		this.deathFirstNames = deathFirstNames;
	}
	
	public String getDeathFirstNames() {
		return this.deathFirstNames;
	}
	
	public boolean checkDeathFirstNames() {
		return certificate.equals("Death");
	}

	public void setDeathCity(String deathCity) {
		this.deathCity = deathCity;
	}
	
	public String getDeathCity() {
		return this.deathCity;
	}
	
	public boolean checkDeathCity() {
		return certificate.equals("Death");
	}

	public void setBirthPostalCode(String birthPostalCode) {
		this.birthPostalCode = birthPostalCode;
	}
	
	public String getBirthPostalCode() {
		return this.birthPostalCode;
	}
	
	public boolean checkBirthPostalCode() {
		return certificate.equals("Birth");
	}

	public void setMarriageHusbandFirstNames(String marriageHusbandFirstNames) {
		this.marriageHusbandFirstNames = marriageHusbandFirstNames;
	}
	
	public String getMarriageHusbandFirstNames() {
		return this.marriageHusbandFirstNames;
	}
	
	public boolean checkMarriageHusbandFirstNames() {
		return certificate.equals("Marriage");
	}

	public void setMarriageCity(String marriageCity) {
		this.marriageCity = marriageCity;
	}
	
	public String getMarriageCity() {
		return this.marriageCity;
	}
	
	public boolean checkMarriageCity() {
		return certificate.equals("Marriage");
	}

	public void setBirthFirstNames(String birthFirstNames) {
		this.birthFirstNames = birthFirstNames;
	}
	
	public String getBirthFirstNames() {
		return this.birthFirstNames;
	}
	
	public boolean checkBirthFirstNames() {
		return certificate.equals("Birth");
	}

	public void setMarriageWifeLastName(String marriageWifeLastName) {
		this.marriageWifeLastName = marriageWifeLastName;
	}
	
	public String getMarriageWifeLastName() {
		return this.marriageWifeLastName;
	}
	
	public boolean checkMarriageWifeLastName() {
		return certificate.equals("Marriage");
	}

	public void setRequesterQualityPrecision(String requesterQualityPrecision) {
		this.requesterQualityPrecision = requesterQualityPrecision;
	}
	
	public String getRequesterQualityPrecision() {
		return this.requesterQualityPrecision;
	}
	
	public boolean checkRequesterQualityPrecision() {
		return true;
	}

	public void setBirthDate(Calendar birthDate) {
		this.birthDate = birthDate;
	}
	
	public Calendar getBirthDate() {
		return this.birthDate;
	}
	
	public boolean checkBirthDate() {
		return certificate.equals("Birth");
	}

	public void setDeathPostalCode(String deathPostalCode) {
		this.deathPostalCode = deathPostalCode;
	}
	
	public String getDeathPostalCode() {
		return this.deathPostalCode;
	}
	
	public boolean checkDeathPostalCode() {
		return certificate.equals("Death");
	}

	public void setRequesterQuality(String requesterQuality) {
		this.requesterQuality = requesterQuality;
	}
	
	public String getRequesterQuality() {
		return this.requesterQuality;
	}
	
	public boolean checkRequesterQuality() {
		return true;
	}

	public void setBirthCity(String birthCity) {
		this.birthCity = birthCity;
	}
	
	public String getBirthCity() {
		return this.birthCity;
	}
	
	public boolean checkBirthCity() {
		return certificate.equals("Birth");
	}

	public void setMarriageDate(Calendar marriageDate) {
		this.marriageDate = marriageDate;
	}
	
	public Calendar getMarriageDate() {
		return this.marriageDate;
	}
	
	public boolean checkMarriageDate() {
		return certificate.equals("Marriage");
	}

	public void setDeathLastName(String deathLastName) {
		this.deathLastName = deathLastName;
	}
	
	public String getDeathLastName() {
		return this.deathLastName;
	}
	
	public boolean checkDeathLastName() {
		return certificate.equals("Death");
	}

	public void setMarriageHusbandLastName(String marriageHusbandLastName) {
		this.marriageHusbandLastName = marriageHusbandLastName;
	}
	
	public String getMarriageHusbandLastName() {
		return this.marriageHusbandLastName;
	}
	
	public boolean checkMarriageHusbandLastName() {
		return certificate.equals("Marriage");
	}

	public void setMarriageWifeFirstNames(String marriageWifeFirstNames) {
		this.marriageWifeFirstNames = marriageWifeFirstNames;
	}
	
	public String getMarriageWifeFirstNames() {
		return this.marriageWifeFirstNames;
	}
	
	public boolean checkMarriageWifeFirstNames() {
		return certificate.equals("Marriage");
	}

	public void setMarriagePostalCode(String marriagePostalCode) {
		this.marriagePostalCode = marriagePostalCode;
	}
	
	public String getMarriagePostalCode() {
		return this.marriagePostalCode;
	}
	
	public boolean checkMarriagePostalCode() {
		return certificate.equals("Marriage");
	}

	public void setCertificate(String certificate) {
		this.certificate = certificate;
	}
	
	public String getCertificate() {
		return this.certificate;
	}
	
	public boolean checkCertificate() {
		return true;
	}

	public void setDeathDate(Calendar deathDate) {
		this.deathDate = deathDate;
	}
	
	public Calendar getDeathDate() {
		return this.deathDate;
	}
	
	public boolean checkDeathDate() {
		return certificate.equals("Death");
	}

	public void setBirthLastName(String birthLastName) {
		this.birthLastName = birthLastName;
	}
	
	public String getBirthLastName() {
		return this.birthLastName;
	}
	
	public boolean checkBirthLastName() {
		return certificate.equals("Birth");
	}

}
