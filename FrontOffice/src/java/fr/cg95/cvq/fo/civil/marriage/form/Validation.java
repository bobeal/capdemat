package fr.cg95.cvq.fo.civil.marriage.form;

import java.util.Calendar;
import java.util.Collection;
import java.util.List;
import javax.servlet.http.HttpSession;
import fr.cg95.cvq.wizard.*;
import fr.cg95.cvq.xml.common.*;
import fr.cg95.cvq.xml.civil.*;
import fr.cg95.cvq.xml.civil.MarriageDetailsRequestDocument.MarriageDetailsRequest;

public class Validation extends IStageForm {

	private String format;
	private java.math.BigInteger copies;
	private String marriageHusbandFirstNames;
	private String comment;
	private String marriageCity;
	private String marriageWifeLastName;
	private String motive;
	private String requesterQualityPrecision;
	private String requesterQuality;
	private Calendar marriageDate;
	private String fatherLastName;
	private String marriageHusbandLastName;
	private String relationship;
	private String marriageWifeFirstNames;
	private String motherFirstNames;
	private String fatherFirstNames;
	private String marriagePostalCode;
	private String motherMaidenName;

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
		if ((xmlbRequest != null) && (xmlbRequest instanceof MarriageDetailsRequest)) {
			MarriageDetailsRequest request = (MarriageDetailsRequest)xmlbRequest;
			if (request.getFormat() != null)
			this.format = request.getFormat().toString();
			this.copies = request.getCopies();
			this.marriageHusbandFirstNames = request.getMarriageHusbandFirstNames();
			this.comment = request.getComment();
			this.marriageCity = request.getMarriageCity();
			this.marriageWifeLastName = request.getMarriageWifeLastName();
			if (request.getMotive() != null)
			this.motive = request.getMotive().toString();
			this.requesterQualityPrecision = request.getRequesterQualityPrecision();
			if (request.getRequesterQuality() != null)
			this.requesterQuality = request.getRequesterQuality().toString();
			this.marriageDate = request.getMarriageDate();
			this.fatherLastName = request.getFatherLastName();
			this.marriageHusbandLastName = request.getMarriageHusbandLastName();
			if (request.getRelationship() != null)
			this.relationship = request.getRelationship().toString();
			this.marriageWifeFirstNames = request.getMarriageWifeFirstNames();
			this.motherFirstNames = request.getMotherFirstNames();
			this.fatherFirstNames = request.getFatherFirstNames();
			this.marriagePostalCode = request.getMarriagePostalCode();
			this.motherMaidenName = request.getMotherMaidenName();
		}
	}
	
	public void save(HttpSession session, Object xmlbRequest) {
		if ((xmlbRequest != null) && (xmlbRequest instanceof MarriageDetailsRequest)) {
			MarriageDetailsRequest request = (MarriageDetailsRequest)xmlbRequest;
			request.setFormat(MarriageCertificateFormatType.Enum.forString(this.format));
			request.setCopies(this.copies);
			request.setMarriageHusbandFirstNames(this.marriageHusbandFirstNames);
			request.setComment(this.comment);
			request.setMarriageCity(this.marriageCity);
			request.setMarriageWifeLastName(this.marriageWifeLastName);
			request.setMotive(MarriageCertificateMotiveType.Enum.forString(this.motive));
			request.setRequesterQualityPrecision(this.requesterQualityPrecision);
			request.setRequesterQuality(MarriageRequesterQualityType.Enum.forString(this.requesterQuality));
			request.setMarriageDate(this.marriageDate);
			request.setFatherLastName(this.fatherLastName);
			request.setMarriageHusbandLastName(this.marriageHusbandLastName);
			request.setRelationship(MarriageRelationshipType.Enum.forString(this.relationship));
			request.setMarriageWifeFirstNames(this.marriageWifeFirstNames);
			request.setMotherFirstNames(this.motherFirstNames);
			request.setFatherFirstNames(this.fatherFirstNames);
			request.setMarriagePostalCode(this.marriagePostalCode);
			request.setMotherMaidenName(this.motherMaidenName);
		}
	}
	
	public boolean isComplete() {
		if (this.checkFormat() &&
			((this.format == null) || (this.format.length() == 0)))
			return false;
		if (this.checkCopies() && (this.copies == null))
			return false;
		if (this.checkMarriageHusbandFirstNames() &&
			((this.marriageHusbandFirstNames == null) || (this.marriageHusbandFirstNames.length() == 0)))
			return false;
		if (this.checkMarriageCity() &&
			((this.marriageCity == null) || (this.marriageCity.length() == 0)))
			return false;
		if (this.checkMarriageWifeLastName() &&
			((this.marriageWifeLastName == null) || (this.marriageWifeLastName.length() == 0)))
			return false;
		if (this.checkMarriageDate() && (this.marriageDate == null))
			return false;
		if (this.checkFatherLastName() &&
			((this.fatherLastName == null) || (this.fatherLastName.length() == 0)))
			return false;
		if (this.checkMarriageHusbandLastName() &&
			((this.marriageHusbandLastName == null) || (this.marriageHusbandLastName.length() == 0)))
			return false;
		if (this.checkRelationship() &&
			((this.relationship == null) || (this.relationship.length() == 0)))
			return false;
		if (this.checkMarriageWifeFirstNames() &&
			((this.marriageWifeFirstNames == null) || (this.marriageWifeFirstNames.length() == 0)))
			return false;
		if (this.checkMotherFirstNames() &&
			((this.motherFirstNames == null) || (this.motherFirstNames.length() == 0)))
			return false;
		if (this.checkFatherFirstNames() &&
			((this.fatherFirstNames == null) || (this.fatherFirstNames.length() == 0)))
			return false;
		if (this.checkMarriagePostalCode() &&
			((this.marriagePostalCode == null) || (this.marriagePostalCode.length() == 0)))
			return false;
		if (this.checkMotherMaidenName() &&
			((this.motherMaidenName == null) || (this.motherMaidenName.length() == 0)))
			return false;
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

	public void setMarriageHusbandFirstNames(String marriageHusbandFirstNames) {
		this.marriageHusbandFirstNames = marriageHusbandFirstNames;
	}
	
	public String getMarriageHusbandFirstNames() {
		return this.marriageHusbandFirstNames;
	}
	
	public boolean checkMarriageHusbandFirstNames() {
		return true;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
	
	public String getComment() {
		return this.comment;
	}
	
	public boolean checkComment() {
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

	public void setMarriageWifeLastName(String marriageWifeLastName) {
		this.marriageWifeLastName = marriageWifeLastName;
	}
	
	public String getMarriageWifeLastName() {
		return this.marriageWifeLastName;
	}
	
	public boolean checkMarriageWifeLastName() {
		return true;
	}

	public void setMotive(String motive) {
		this.motive = motive;
	}
	
	public String getMotive() {
		return this.motive;
	}
	
	public boolean checkMotive() {
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

	public void setFatherLastName(String fatherLastName) {
		this.fatherLastName = fatherLastName;
	}
	
	public String getFatherLastName() {
		return this.fatherLastName;
	}
	
	public boolean checkFatherLastName() {
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

	public void setRelationship(String relationship) {
		this.relationship = relationship;
	}
	
	public String getRelationship() {
		return this.relationship;
	}
	
	public boolean checkRelationship() {
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

}