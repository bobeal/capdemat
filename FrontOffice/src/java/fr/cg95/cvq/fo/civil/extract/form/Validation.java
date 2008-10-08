package fr.cg95.cvq.fo.civil.extract.form;

import java.util.Calendar;
import java.util.Collection;
import java.util.List;
import javax.servlet.http.HttpSession;
import fr.cg95.cvq.wizard.*;
import fr.cg95.cvq.xml.common.*;
import fr.cg95.cvq.xml.civil.*;
import fr.cg95.cvq.xml.civil.PersonalDetailsRequestDocument.PersonalDetailsRequest;

public class Validation extends IStageForm {

	private String deathFirstNames;
	private String deathCity;
	private String format;
	private java.math.BigInteger copies;
	private String birthPostalCode;
	private String marriageHusbandFirstNames;
	private String usage;
	private String birthCity;
	private String requesterQuality;
	private Calendar marriageDate;
	private String marriageHusbandLastName;
	private String marriageWifeFirstNames;
	private Calendar deathDate;
	private String marriageCity;
	private String birthFirstNames;
	private String marriageWifeLastName;
	private Calendar birthDate;
	private String requesterQualityPrecision;
	private String deathPostalCode;
	private String deathLastName;
	private String fatherLastName;
	private String relationship;
	private String motherFirstNames;
	private String fatherFirstNames;
	private String certificate;
	private String marriagePostalCode;
	private String motherMaidenName;
	private String birthLastName;

	public Validation() {
		super();
	}
	
	public void reset(String state) {
		if (state.equals("summary")) {
		}
		if (state.equals("summaryrelation")) {
		}
		if (state.equals("summarydeath")) {
		}
		if (state.equals("summarybirth")) {
		}
		if (state.equals("summarymarriage")) {
		}
	}
	
	public void load(HttpSession session, Object xmlbRequest) {
		if ((xmlbRequest != null) && (xmlbRequest instanceof PersonalDetailsRequest)) {
			PersonalDetailsRequest request = (PersonalDetailsRequest)xmlbRequest;
			this.deathFirstNames = request.getDeathFirstNames();
			this.deathCity = request.getDeathCity();
			if (request.getFormat() != null)
			this.format = request.getFormat().toString();
			this.copies = request.getCopies();
			this.birthPostalCode = request.getBirthPostalCode();
			this.marriageHusbandFirstNames = request.getMarriageHusbandFirstNames();
			this.usage = request.getUsage();
			this.birthCity = request.getBirthCity();
			if (request.getRequesterQuality() != null)
			this.requesterQuality = request.getRequesterQuality().toString();
			this.marriageDate = request.getMarriageDate();
			this.marriageHusbandLastName = request.getMarriageHusbandLastName();
			this.marriageWifeFirstNames = request.getMarriageWifeFirstNames();
			this.deathDate = request.getDeathDate();
			this.marriageCity = request.getMarriageCity();
			this.birthFirstNames = request.getBirthFirstNames();
			this.marriageWifeLastName = request.getMarriageWifeLastName();
			this.birthDate = request.getBirthDate();
			this.requesterQualityPrecision = request.getRequesterQualityPrecision();
			this.deathPostalCode = request.getDeathPostalCode();
			this.deathLastName = request.getDeathLastName();
			this.fatherLastName = request.getFatherLastName();
			if (request.getRelationship() != null)
			this.relationship = request.getRelationship().toString();
			this.motherFirstNames = request.getMotherFirstNames();
			this.fatherFirstNames = request.getFatherFirstNames();
			if (request.getCertificate() != null)
			this.certificate = request.getCertificate().toString();
			this.marriagePostalCode = request.getMarriagePostalCode();
			this.motherMaidenName = request.getMotherMaidenName();
			this.birthLastName = request.getBirthLastName();
		}
	}
	
	public void save(HttpSession session, Object xmlbRequest) {
		if ((xmlbRequest != null) && (xmlbRequest instanceof PersonalDetailsRequest)) {
			PersonalDetailsRequest request = (PersonalDetailsRequest)xmlbRequest;
			request.setDeathFirstNames(this.deathFirstNames);
			request.setDeathCity(this.deathCity);
			request.setFormat(CertificateFormatType.Enum.forString(this.format));
			request.setCopies(this.copies);
			request.setBirthPostalCode(this.birthPostalCode);
			request.setMarriageHusbandFirstNames(this.marriageHusbandFirstNames);
			request.setUsage(this.usage);
			request.setBirthCity(this.birthCity);
			request.setRequesterQuality(RequesterQualityType.Enum.forString(this.requesterQuality));
			request.setMarriageDate(this.marriageDate);
			request.setMarriageHusbandLastName(this.marriageHusbandLastName);
			request.setMarriageWifeFirstNames(this.marriageWifeFirstNames);
			request.setDeathDate(this.deathDate);
			request.setMarriageCity(this.marriageCity);
			request.setBirthFirstNames(this.birthFirstNames);
			request.setMarriageWifeLastName(this.marriageWifeLastName);
			request.setBirthDate(this.birthDate);
			request.setRequesterQualityPrecision(this.requesterQualityPrecision);
			request.setDeathPostalCode(this.deathPostalCode);
			request.setDeathLastName(this.deathLastName);
			request.setFatherLastName(this.fatherLastName);
			request.setRelationship(RelationshipType.Enum.forString(this.relationship));
			request.setMotherFirstNames(this.motherFirstNames);
			request.setFatherFirstNames(this.fatherFirstNames);
			request.setCertificate(CertificateType.Enum.forString(this.certificate));
			request.setMarriagePostalCode(this.marriagePostalCode);
			request.setMotherMaidenName(this.motherMaidenName);
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
		if (this.checkFormat() &&
			((this.format == null) || (this.format.length() == 0)))
			return false;
		if (this.checkBirthPostalCode() &&
			((this.birthPostalCode == null) || (this.birthPostalCode.length() == 0)))
			return false;
		if (this.checkMarriageHusbandFirstNames() &&
			((this.marriageHusbandFirstNames == null) || (this.marriageHusbandFirstNames.length() == 0)))
			return false;
		if (this.checkBirthCity() &&
			((this.birthCity == null) || (this.birthCity.length() == 0)))
			return false;
		if (this.checkMarriageHusbandLastName() &&
			((this.marriageHusbandLastName == null) || (this.marriageHusbandLastName.length() == 0)))
			return false;
		if (this.checkMarriageWifeFirstNames() &&
			((this.marriageWifeFirstNames == null) || (this.marriageWifeFirstNames.length() == 0)))
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
		if (this.checkDeathLastName() &&
			((this.deathLastName == null) || (this.deathLastName.length() == 0)))
			return false;
		if (this.checkFatherLastName() &&
			((this.fatherLastName == null) || (this.fatherLastName.length() == 0)))
			return false;
		if (this.checkRelationship() &&
			((this.relationship == null) || (this.relationship.length() == 0)))
			return false;
		if (this.checkMotherFirstNames() &&
			((this.motherFirstNames == null) || (this.motherFirstNames.length() == 0)))
			return false;
		if (this.checkFatherFirstNames() &&
			((this.fatherFirstNames == null) || (this.fatherFirstNames.length() == 0)))
			return false;
		if (this.checkCertificate() &&
			((this.certificate == null) || (this.certificate.length() == 0)))
			return false;
		if (this.checkMarriagePostalCode() &&
			((this.marriagePostalCode == null) || (this.marriagePostalCode.length() == 0)))
			return false;
		if (this.checkMotherMaidenName() &&
			((this.motherMaidenName == null) || (this.motherMaidenName.length() == 0)))
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
		return true;
	}

	public void setDeathCity(String deathCity) {
		this.deathCity = deathCity;
	}
	
	public String getDeathCity() {
		return this.deathCity;
	}
	
	public boolean checkDeathCity() {
		return true;
	}

	public void setFormat(String format) {
		this.format = format;
	}
	
	public String getFormat() {
		return this.format;
	}
	
	public boolean checkFormat() {
		return true;
	}

	public void setCopies(java.math.BigInteger copies) {
		this.copies = copies;
	}
	
	public java.math.BigInteger getCopies() {
		return this.copies;
	}
	
	public boolean checkCopies() {
		return true;
	}

	public void setBirthPostalCode(String birthPostalCode) {
		this.birthPostalCode = birthPostalCode;
	}
	
	public String getBirthPostalCode() {
		return this.birthPostalCode;
	}
	
	public boolean checkBirthPostalCode() {
		return true;
	}

	public void setMarriageHusbandFirstNames(String marriageHusbandFirstNames) {
		this.marriageHusbandFirstNames = marriageHusbandFirstNames;
	}
	
	public String getMarriageHusbandFirstNames() {
		return this.marriageHusbandFirstNames;
	}
	
	public boolean checkMarriageHusbandFirstNames() {
		return true;
	}

	public void setUsage(String usage) {
		this.usage = usage;
	}
	
	public String getUsage() {
		return this.usage;
	}
	
	public boolean checkUsage() {
		return true;
	}

	public void setBirthCity(String birthCity) {
		this.birthCity = birthCity;
	}
	
	public String getBirthCity() {
		return this.birthCity;
	}
	
	public boolean checkBirthCity() {
		return true;
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

	public void setMarriageDate(Calendar marriageDate) {
		this.marriageDate = marriageDate;
	}
	
	public Calendar getMarriageDate() {
		return this.marriageDate;
	}
	
	public boolean checkMarriageDate() {
		return true;
	}

	public void setMarriageHusbandLastName(String marriageHusbandLastName) {
		this.marriageHusbandLastName = marriageHusbandLastName;
	}
	
	public String getMarriageHusbandLastName() {
		return this.marriageHusbandLastName;
	}
	
	public boolean checkMarriageHusbandLastName() {
		return true;
	}

	public void setMarriageWifeFirstNames(String marriageWifeFirstNames) {
		this.marriageWifeFirstNames = marriageWifeFirstNames;
	}
	
	public String getMarriageWifeFirstNames() {
		return this.marriageWifeFirstNames;
	}
	
	public boolean checkMarriageWifeFirstNames() {
		return true;
	}

	public void setDeathDate(Calendar deathDate) {
		this.deathDate = deathDate;
	}
	
	public Calendar getDeathDate() {
		return this.deathDate;
	}
	
	public boolean checkDeathDate() {
		return true;
	}

	public void setMarriageCity(String marriageCity) {
		this.marriageCity = marriageCity;
	}
	
	public String getMarriageCity() {
		return this.marriageCity;
	}
	
	public boolean checkMarriageCity() {
		return true;
	}

	public void setBirthFirstNames(String birthFirstNames) {
		this.birthFirstNames = birthFirstNames;
	}
	
	public String getBirthFirstNames() {
		return this.birthFirstNames;
	}
	
	public boolean checkBirthFirstNames() {
		return true;
	}

	public void setMarriageWifeLastName(String marriageWifeLastName) {
		this.marriageWifeLastName = marriageWifeLastName;
	}
	
	public String getMarriageWifeLastName() {
		return this.marriageWifeLastName;
	}
	
	public boolean checkMarriageWifeLastName() {
		return true;
	}

	public void setBirthDate(Calendar birthDate) {
		this.birthDate = birthDate;
	}
	
	public Calendar getBirthDate() {
		return this.birthDate;
	}
	
	public boolean checkBirthDate() {
		return true;
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

	public void setDeathPostalCode(String deathPostalCode) {
		this.deathPostalCode = deathPostalCode;
	}
	
	public String getDeathPostalCode() {
		return this.deathPostalCode;
	}
	
	public boolean checkDeathPostalCode() {
		return true;
	}

	public void setDeathLastName(String deathLastName) {
		this.deathLastName = deathLastName;
	}
	
	public String getDeathLastName() {
		return this.deathLastName;
	}
	
	public boolean checkDeathLastName() {
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

	public void setRelationship(String relationship) {
		this.relationship = relationship;
	}
	
	public String getRelationship() {
		return this.relationship;
	}
	
	public boolean checkRelationship() {
		return true;
	}

	public void setMotherFirstNames(String motherFirstNames) {
		this.motherFirstNames = motherFirstNames;
	}
	
	public String getMotherFirstNames() {
		return this.motherFirstNames;
	}
	
	public boolean checkMotherFirstNames() {
		return true;
	}

	public void setFatherFirstNames(String fatherFirstNames) {
		this.fatherFirstNames = fatherFirstNames;
	}
	
	public String getFatherFirstNames() {
		return this.fatherFirstNames;
	}
	
	public boolean checkFatherFirstNames() {
		return true;
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

	public void setMarriagePostalCode(String marriagePostalCode) {
		this.marriagePostalCode = marriagePostalCode;
	}
	
	public String getMarriagePostalCode() {
		return this.marriagePostalCode;
	}
	
	public boolean checkMarriagePostalCode() {
		return true;
	}

	public void setMotherMaidenName(String motherMaidenName) {
		this.motherMaidenName = motherMaidenName;
	}
	
	public String getMotherMaidenName() {
		return this.motherMaidenName;
	}
	
	public boolean checkMotherMaidenName() {
		return true;
	}

	public void setBirthLastName(String birthLastName) {
		this.birthLastName = birthLastName;
	}
	
	public String getBirthLastName() {
		return this.birthLastName;
	}
	
	public boolean checkBirthLastName() {
		return true;
	}

}
