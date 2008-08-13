package fr.cg95.cvq.fo.civil.death.form;

import java.util.Calendar;
import java.util.Collection;
import java.util.List;
import javax.servlet.http.HttpSession;
import fr.cg95.cvq.wizard.*;
import fr.cg95.cvq.xml.common.*;
import fr.cg95.cvq.xml.civil.*;
import fr.cg95.cvq.xml.civil.DeathDetailsRequestDocument.DeathDetailsRequest;

public class Validation extends IStageForm {

	private java.math.BigInteger copies;
	private String motherFirstNames;
	private String requesterQualityPrecision;
	private String deathFirstNames;
	private String relationship;
	private String usage;
	private String requesterQuality;
	private String fatherLastName;
	private Calendar deathDate;
	private String deathCity;
	private String deathPostalCode;
	private String motherMaidenName;
	private String deathLastName;
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
		if ((xmlbRequest != null) && (xmlbRequest instanceof DeathDetailsRequest)) {
			DeathDetailsRequest request = (DeathDetailsRequest)xmlbRequest;
			this.copies = request.getCopies();
			this.motherFirstNames = request.getMotherFirstNames();
			this.requesterQualityPrecision = request.getRequesterQualityPrecision();
			this.deathFirstNames = request.getDeathFirstNames();
			if (request.getRelationship() != null)
			this.relationship = request.getRelationship().toString();
			this.usage = request.getUsage();
			if (request.getRequesterQuality() != null)
			this.requesterQuality = request.getRequesterQuality().toString();
			this.fatherLastName = request.getFatherLastName();
			this.deathDate = request.getDeathDate();
			this.deathCity = request.getDeathCity();
			this.deathPostalCode = request.getDeathPostalCode();
			this.motherMaidenName = request.getMotherMaidenName();
			this.deathLastName = request.getDeathLastName();
			this.fatherFirstNames = request.getFatherFirstNames();
			if (request.getFormat() != null)
			this.format = request.getFormat().toString();
		}
	}
	
	public void save(HttpSession session, Object xmlbRequest) {
		if ((xmlbRequest != null) && (xmlbRequest instanceof DeathDetailsRequest)) {
			DeathDetailsRequest request = (DeathDetailsRequest)xmlbRequest;
			request.setCopies(this.copies);
			request.setMotherFirstNames(this.motherFirstNames);
			request.setRequesterQualityPrecision(this.requesterQualityPrecision);
			request.setDeathFirstNames(this.deathFirstNames);
			request.setRelationship(DeathRelationshipType.Enum.forString(this.relationship));
			request.setUsage(this.usage);
			request.setRequesterQuality(DeathRequesterQualityType.Enum.forString(this.requesterQuality));
			request.setFatherLastName(this.fatherLastName);
			request.setDeathDate(this.deathDate);
			request.setDeathCity(this.deathCity);
			request.setDeathPostalCode(this.deathPostalCode);
			request.setMotherMaidenName(this.motherMaidenName);
			request.setDeathLastName(this.deathLastName);
			request.setFatherFirstNames(this.fatherFirstNames);
			request.setFormat(DeathCertificateFormatType.Enum.forString(this.format));
		}
	}
	
	public boolean isComplete() {
		if (this.checkMotherFirstNames() &&
			((this.motherFirstNames == null) || (this.motherFirstNames.length() == 0)))
			return false;
		if (this.checkDeathFirstNames() &&
			((this.deathFirstNames == null) || (this.deathFirstNames.length() == 0)))
			return false;
		if (this.checkRelationship() &&
			((this.relationship == null) || (this.relationship.length() == 0)))
			return false;
		if (this.checkFatherLastName() &&
			((this.fatherLastName == null) || (this.fatherLastName.length() == 0)))
			return false;
		if (this.checkDeathCity() &&
			((this.deathCity == null) || (this.deathCity.length() == 0)))
			return false;
		if (this.checkDeathPostalCode() &&
			((this.deathPostalCode == null) || (this.deathPostalCode.length() == 0)))
			return false;
		if (this.checkMotherMaidenName() &&
			((this.motherMaidenName == null) || (this.motherMaidenName.length() == 0)))
			return false;
		if (this.checkDeathLastName() &&
			((this.deathLastName == null) || (this.deathLastName.length() == 0)))
			return false;
		if (this.checkFatherFirstNames() &&
			((this.fatherFirstNames == null) || (this.fatherFirstNames.length() == 0)))
			return false;
		if (this.checkFormat() &&
			((this.format == null) || (this.format.length() == 0)))
			return false;
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

	public void setRequesterQualityPrecision(String requesterQualityPrecision) {
		this.requesterQualityPrecision = requesterQualityPrecision;
	}
	
	public String getRequesterQualityPrecision() {
		return this.requesterQualityPrecision;
	}
	
	public boolean checkRequesterQualityPrecision() {
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

	public void setDeathDate(Calendar deathDate) {
		this.deathDate = deathDate;
	}
	
	public Calendar getDeathDate() {
		return this.deathDate;
	}
	
	public boolean checkDeathDate() {
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

	public void setDeathPostalCode(String deathPostalCode) {
		this.deathPostalCode = deathPostalCode;
	}
	
	public String getDeathPostalCode() {
		return this.deathPostalCode;
	}
	
	public boolean checkDeathPostalCode() {
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

	public void setDeathLastName(String deathLastName) {
		this.deathLastName = deathLastName;
	}
	
	public String getDeathLastName() {
		return this.deathLastName;
	}
	
	public boolean checkDeathLastName() {
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
