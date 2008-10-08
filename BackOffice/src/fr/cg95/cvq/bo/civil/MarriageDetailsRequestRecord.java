package fr.cg95.cvq.bo.civil;

import java.util.Calendar;
import java.util.List;
import java.util.Set;
import java.util.Vector;

import fr.cg95.cvq.wizard.*;
import fr.cg95.cvq.bo.record.BaseRecord;
import fr.cg95.cvq.bo.record.RequestRecord;
import fr.cg95.cvq.business.authority.*;
import fr.cg95.cvq.business.users.*;
import fr.cg95.cvq.business.civil.*;

public class MarriageDetailsRequestRecord extends RequestRecord {

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

	public MarriageDetailsRequestRecord() {
		super();
	}
	
	protected Object clone() throws CloneNotSupportedException {
		MarriageDetailsRequestRecord clonedRecord = (MarriageDetailsRequestRecord)super.clone();
		return clonedRecord;
	}
	
	public BaseRecord getDataRecord(Long id) {

		if (id.equals(this.getId()))
			return this;
			
		return super.getDataRecord(id);
	}

    public void load(Object xmlRequest) {
        if ((xmlRequest != null) && (xmlRequest instanceof MarriageDetailsRequest)) {
            MarriageDetailsRequest request = (MarriageDetailsRequest)xmlRequest; 

			if (request.getFormat() != null)
                this.format = getEnumElementTranslation(
                        fr.cg95.cvq.xml.civil.MarriageDetailsRequestDocument.MarriageDetailsRequest.class.getName(), 
                        "Format", request.getFormat().toString());
			this.copies = request.getCopies();
			this.marriageHusbandFirstNames = request.getMarriageHusbandFirstNames();
			this.comment = request.getComment();
			this.marriageCity = request.getMarriageCity();
			this.marriageWifeLastName = request.getMarriageWifeLastName();
			if (request.getMotive() != null)
                this.motive = getEnumElementTranslation(
                        fr.cg95.cvq.xml.civil.MarriageDetailsRequestDocument.MarriageDetailsRequest.class.getName(), 
                        "Motive", request.getMotive().toString());
			this.requesterQualityPrecision = request.getRequesterQualityPrecision();
			if (request.getRequesterQuality() != null)
                this.requesterQuality = getEnumElementTranslation(
                        fr.cg95.cvq.xml.civil.MarriageDetailsRequestDocument.MarriageDetailsRequest.class.getName(), 
                        "RequesterQuality", request.getRequesterQuality().toString());
			if (request.getMarriageDate() != null) {
				this.marriageDate = Calendar.getInstance(); 
	            this.marriageDate.setTime(request.getMarriageDate());
			}
			this.fatherLastName = request.getFatherLastName();
			this.marriageHusbandLastName = request.getMarriageHusbandLastName();
			if (request.getRelationship() != null)
                this.relationship = getEnumElementTranslation(
                        fr.cg95.cvq.xml.civil.MarriageDetailsRequestDocument.MarriageDetailsRequest.class.getName(), 
                        "Relationship", request.getRelationship().toString());
			this.marriageWifeFirstNames = request.getMarriageWifeFirstNames();
			this.motherFirstNames = request.getMotherFirstNames();
			this.fatherFirstNames = request.getFatherFirstNames();
			this.marriagePostalCode = request.getMarriagePostalCode();
			this.motherMaidenName = request.getMotherMaidenName();
        }
    }
    
    public void saveRequest(Object xmlRequest) {
        if ((xmlRequest != null) && (xmlRequest instanceof MarriageDetailsRequest)) {
            MarriageDetailsRequest request = (MarriageDetailsRequest)xmlRequest; 
        }
    }
    
    public void saveData(Object xmlRequest) {
        if ((xmlRequest != null) && (xmlRequest instanceof MarriageDetailsRequest)) {
            MarriageDetailsRequest request = (MarriageDetailsRequest)xmlRequest; 

			if (this.format != null)
                request.setFormat(
                    MarriageCertificateFormatType.forString(
                        getEnumKeyTranslation(
                            fr.cg95.cvq.xml.civil.MarriageDetailsRequestDocument.MarriageDetailsRequest.class.getName(), 
                            "Format", this.format)
                    )
                );
			request.setCopies(this.copies);
			request.setMarriageHusbandFirstNames(this.marriageHusbandFirstNames);
			request.setComment(this.comment);
			request.setMarriageCity(this.marriageCity);
			request.setMarriageWifeLastName(this.marriageWifeLastName);
			if (this.motive != null)
                request.setMotive(
                    MarriageCertificateMotiveType.forString(
                        getEnumKeyTranslation(
                            fr.cg95.cvq.xml.civil.MarriageDetailsRequestDocument.MarriageDetailsRequest.class.getName(), 
                            "Motive", this.motive)
                    )
                );
			request.setRequesterQualityPrecision(this.requesterQualityPrecision);
			if (this.requesterQuality != null)
                request.setRequesterQuality(
                    MarriageRequesterQualityType.forString(
                        getEnumKeyTranslation(
                            fr.cg95.cvq.xml.civil.MarriageDetailsRequestDocument.MarriageDetailsRequest.class.getName(), 
                            "RequesterQuality", this.requesterQuality)
                    )
                );
			if (this.marriageDate != null)
			request.setMarriageDate(this.marriageDate.getTime());
			request.setFatherLastName(this.fatherLastName);
			request.setMarriageHusbandLastName(this.marriageHusbandLastName);
			if (this.relationship != null)
                request.setRelationship(
                    MarriageRelationshipType.forString(
                        getEnumKeyTranslation(
                            fr.cg95.cvq.xml.civil.MarriageDetailsRequestDocument.MarriageDetailsRequest.class.getName(), 
                            "Relationship", this.relationship)
                    )
                );
			request.setMarriageWifeFirstNames(this.marriageWifeFirstNames);
			request.setMotherFirstNames(this.motherFirstNames);
			request.setFatherFirstNames(this.fatherFirstNames);
			request.setMarriagePostalCode(this.marriagePostalCode);
			request.setMotherMaidenName(this.motherMaidenName);
        }
    }
    
	public void setFormat(String format) {
		this.format = format;
	}
	
	public String getFormat() {
		return this.format;
	}

	public void setCopies(java.math.BigInteger copies) {
		this.copies = copies;
	}
	
	public java.math.BigInteger getCopies() {
		return this.copies;
	}

	public void setMarriageHusbandFirstNames(String marriageHusbandFirstNames) {
		this.marriageHusbandFirstNames = marriageHusbandFirstNames;
	}
	
	public String getMarriageHusbandFirstNames() {
		return this.marriageHusbandFirstNames;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
	
	public String getComment() {
		return this.comment;
	}

	public void setMarriageCity(String marriageCity) {
		this.marriageCity = marriageCity;
	}
	
	public String getMarriageCity() {
		return this.marriageCity;
	}

	public void setMarriageWifeLastName(String marriageWifeLastName) {
		this.marriageWifeLastName = marriageWifeLastName;
	}
	
	public String getMarriageWifeLastName() {
		return this.marriageWifeLastName;
	}

	public void setMotive(String motive) {
		this.motive = motive;
	}
	
	public String getMotive() {
		return this.motive;
	}

	public void setRequesterQualityPrecision(String requesterQualityPrecision) {
		this.requesterQualityPrecision = requesterQualityPrecision;
	}
	
	public String getRequesterQualityPrecision() {
		return this.requesterQualityPrecision;
	}

	public void setRequesterQuality(String requesterQuality) {
		this.requesterQuality = requesterQuality;
	}
	
	public String getRequesterQuality() {
		return this.requesterQuality;
	}

	public void setMarriageDate(Calendar marriageDate) {
		this.marriageDate = marriageDate;
	}
	
	public Calendar getMarriageDate() {
		return this.marriageDate;
	}

	public void setFatherLastName(String fatherLastName) {
		this.fatherLastName = fatherLastName;
	}
	
	public String getFatherLastName() {
		return this.fatherLastName;
	}

	public void setMarriageHusbandLastName(String marriageHusbandLastName) {
		this.marriageHusbandLastName = marriageHusbandLastName;
	}
	
	public String getMarriageHusbandLastName() {
		return this.marriageHusbandLastName;
	}

	public void setRelationship(String relationship) {
		this.relationship = relationship;
	}
	
	public String getRelationship() {
		return this.relationship;
	}

	public void setMarriageWifeFirstNames(String marriageWifeFirstNames) {
		this.marriageWifeFirstNames = marriageWifeFirstNames;
	}
	
	public String getMarriageWifeFirstNames() {
		return this.marriageWifeFirstNames;
	}

	public void setMotherFirstNames(String motherFirstNames) {
		this.motherFirstNames = motherFirstNames;
	}
	
	public String getMotherFirstNames() {
		return this.motherFirstNames;
	}

	public void setFatherFirstNames(String fatherFirstNames) {
		this.fatherFirstNames = fatherFirstNames;
	}
	
	public String getFatherFirstNames() {
		return this.fatherFirstNames;
	}

	public void setMarriagePostalCode(String marriagePostalCode) {
		this.marriagePostalCode = marriagePostalCode;
	}
	
	public String getMarriagePostalCode() {
		return this.marriagePostalCode;
	}

	public void setMotherMaidenName(String motherMaidenName) {
		this.motherMaidenName = motherMaidenName;
	}
	
	public String getMotherMaidenName() {
		return this.motherMaidenName;
	}

}

