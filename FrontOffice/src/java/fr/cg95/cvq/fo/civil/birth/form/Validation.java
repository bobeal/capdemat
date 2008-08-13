package fr.cg95.cvq.fo.civil.birth.form;

import java.util.Calendar;
import java.util.Collection;
import java.util.List;
import javax.servlet.http.HttpSession;
import fr.cg95.cvq.wizard.*;
import fr.cg95.cvq.xml.common.*;
import fr.cg95.cvq.xml.civil.*;
import fr.cg95.cvq.xml.civil.BirthDetailsRequestDocument.BirthDetailsRequest;

public class Validation extends IStageForm {

	private String birthFirstNames;
	private java.math.BigInteger copies;
	private String motherFirstNames;
	private String birthLastName;
	private String requesterQualityPrecision;
	private String relationship;
	private String usage;
	private String requesterQuality;
	private String fatherLastName;
	private String birthPostalCode;
	private String birthCity;
	private Calendar birthDate;
	private String motherMaidenName;
	private String fatherFirstNames;
	private String format;

	public Validation() {
		super();
	}
	
	public void reset(String state) {
		if (state.equals("summary")) {
		}
		if (state.equals("summaryrelation")) {
		}
	}
	
	public void load(HttpSession session, Object xmlbRequest) {
		if ((xmlbRequest != null) && (xmlbRequest instanceof BirthDetailsRequest)) {
			BirthDetailsRequest request = (BirthDetailsRequest)xmlbRequest;
			this.birthFirstNames = request.getBirthFirstNames();
			this.copies = request.getCopies();
			this.motherFirstNames = request.getMotherFirstNames();
			this.birthLastName = request.getBirthLastName();
			this.requesterQualityPrecision = request.getRequesterQualityPrecision();
			if (request.getRelationship() != null)
			this.relationship = request.getRelationship().toString();
			this.usage = request.getUsage();
			if (request.getRequesterQuality() != null)
			this.requesterQuality = request.getRequesterQuality().toString();
			this.fatherLastName = request.getFatherLastName();
			this.birthPostalCode = request.getBirthPostalCode();
			this.birthCity = request.getBirthCity();
			this.birthDate = request.getBirthDate();
			this.motherMaidenName = request.getMotherMaidenName();
			this.fatherFirstNames = request.getFatherFirstNames();
			if (request.getFormat() != null)
			this.format = request.getFormat().toString();
		}
	}
	
	public void save(HttpSession session, Object xmlbRequest) {
		if ((xmlbRequest != null) && (xmlbRequest instanceof BirthDetailsRequest)) {
			BirthDetailsRequest request = (BirthDetailsRequest)xmlbRequest;
			request.setBirthFirstNames(this.birthFirstNames);
			request.setCopies(this.copies);
			request.setMotherFirstNames(this.motherFirstNames);
			request.setBirthLastName(this.birthLastName);
			request.setRequesterQualityPrecision(this.requesterQualityPrecision);
			request.setRelationship(BirthRelationshipType.Enum.forString(this.relationship));
			request.setUsage(this.usage);
			request.setRequesterQuality(BirthRequesterQualityType.Enum.forString(this.requesterQuality));
			request.setFatherLastName(this.fatherLastName);
			request.setBirthPostalCode(this.birthPostalCode);
			request.setBirthCity(this.birthCity);
			request.setBirthDate(this.birthDate);
			request.setMotherMaidenName(this.motherMaidenName);
			request.setFatherFirstNames(this.fatherFirstNames);
			request.setFormat(BirthCertificateFormatType.Enum.forString(this.format));
		}
	}
	
	public boolean isComplete() {
		if (this.checkBirthFirstNames() &&
			((this.birthFirstNames == null) || (this.birthFirstNames.length() == 0)))
			return false;
		if (this.checkMotherFirstNames() &&
			((this.motherFirstNames == null) || (this.motherFirstNames.length() == 0)))
			return false;
		if (this.checkBirthLastName() &&
			((this.birthLastName == null) || (this.birthLastName.length() == 0)))
			return false;
		if (this.checkRelationship() &&
			((this.relationship == null) || (this.relationship.length() == 0)))
			return false;
		if (this.checkFatherLastName() &&
			((this.fatherLastName == null) || (this.fatherLastName.length() == 0)))
			return false;
		if (this.checkBirthPostalCode() &&
			((this.birthPostalCode == null) || (this.birthPostalCode.length() == 0)))
			return false;
		if (this.checkBirthCity() &&
			((this.birthCity == null) || (this.birthCity.length() == 0)))
			return false;
		if (this.checkMotherMaidenName() &&
			((this.motherMaidenName == null) || (this.motherMaidenName.length() == 0)))
			return false;
		if (this.checkFatherFirstNames() &&
			((this.fatherFirstNames == null) || (this.fatherFirstNames.length() == 0)))
			return false;
		if (this.checkFormat() &&
			((this.format == null) || (this.format.length() == 0)))
			return false;
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

	public void setCopies(java.math.BigInteger copies) {
		this.copies = copies;
	}
	
	public java.math.BigInteger getCopies() {
		return this.copies;
	}
	
	public boolean checkCopies() {
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

	public void setBirthLastName(String birthLastName) {
		this.birthLastName = birthLastName;
	}
	
	public String getBirthLastName() {
		return this.birthLastName;
	}
	
	public boolean checkBirthLastName() {
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

	public void setRelationship(String relationship) {
		this.relationship = relationship;
	}
	
	public String getRelationship() {
		return this.relationship;
	}
	
	public boolean checkRelationship() {
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

	public void setRequesterQuality(String requesterQuality) {
		this.requesterQuality = requesterQuality;
	}
	
	public String getRequesterQuality() {
		return this.requesterQuality;
	}
	
	public boolean checkRequesterQuality() {
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

	public void setBirthPostalCode(String birthPostalCode) {
		this.birthPostalCode = birthPostalCode;
	}
	
	public String getBirthPostalCode() {
		return this.birthPostalCode;
	}
	
	public boolean checkBirthPostalCode() {
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

	public void setBirthDate(Calendar birthDate) {
		this.birthDate = birthDate;
	}
	
	public Calendar getBirthDate() {
		return this.birthDate;
	}
	
	public boolean checkBirthDate() {
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

	public void setFatherFirstNames(String fatherFirstNames) {
		this.fatherFirstNames = fatherFirstNames;
	}
	
	public String getFatherFirstNames() {
		return this.fatherFirstNames;
	}
	
	public boolean checkFatherFirstNames() {
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

}
