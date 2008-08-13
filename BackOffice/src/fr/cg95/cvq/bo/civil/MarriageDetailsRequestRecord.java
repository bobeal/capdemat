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

	private java.math.BigInteger copies;
	private String motherFirstNames;
	private String requesterQualityPrecision;
	private String marriageCity;
	private String relationship;
	private String marriagePostalCode;
	private String usage;
	private String requesterQuality;
	private String fatherLastName;
	private String motherMaidenName;
	private String marriageWifeFirstNames;
	private Calendar marriageDate;
	private String marriageWifeLastName;
	private String marriageHusbandLastName;
	private String fatherFirstNames;
	private String marriageHusbandFirstNames;
	private String format;

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

			this.copies = request.getCopies();
			this.motherFirstNames = request.getMotherFirstNames();
			this.requesterQualityPrecision = request.getRequesterQualityPrecision();
			this.marriageCity = request.getMarriageCity();
			if (request.getRelationship() != null)
                this.relationship = getEnumElementTranslation(
                        fr.cg95.cvq.xml.civil.MarriageDetailsRequestDocument.MarriageDetailsRequest.class.getName(), 
                        "Relationship", request.getRelationship().toString());
			this.marriagePostalCode = request.getMarriagePostalCode();
			this.usage = request.getUsage();
			if (request.getRequesterQuality() != null)
                this.requesterQuality = getEnumElementTranslation(
                        fr.cg95.cvq.xml.civil.MarriageDetailsRequestDocument.MarriageDetailsRequest.class.getName(), 
                        "RequesterQuality", request.getRequesterQuality().toString());
			this.fatherLastName = request.getFatherLastName();
			this.motherMaidenName = request.getMotherMaidenName();
			this.marriageWifeFirstNames = request.getMarriageWifeFirstNames();
			if (request.getMarriageDate() != null) {
				this.marriageDate = Calendar.getInstance(); 
	            this.marriageDate.setTime(request.getMarriageDate());
			}
			this.marriageWifeLastName = request.getMarriageWifeLastName();
			this.marriageHusbandLastName = request.getMarriageHusbandLastName();
			this.fatherFirstNames = request.getFatherFirstNames();
			this.marriageHusbandFirstNames = request.getMarriageHusbandFirstNames();
			if (request.getFormat() != null)
                this.format = getEnumElementTranslation(
                        fr.cg95.cvq.xml.civil.MarriageDetailsRequestDocument.MarriageDetailsRequest.class.getName(), 
                        "Format", request.getFormat().toString());
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

			request.setCopies(this.copies);
			request.setMotherFirstNames(this.motherFirstNames);
			request.setRequesterQualityPrecision(this.requesterQualityPrecision);
			request.setMarriageCity(this.marriageCity);
			if (this.relationship != null)
                request.setRelationship(
                    MarriageRelationshipType.forString(
                        getEnumKeyTranslation(
                            fr.cg95.cvq.xml.civil.MarriageDetailsRequestDocument.MarriageDetailsRequest.class.getName(), 
                            "Relationship", this.relationship)
                    )
                );
			request.setMarriagePostalCode(this.marriagePostalCode);
			request.setUsage(this.usage);
			if (this.requesterQuality != null)
                request.setRequesterQuality(
                    MarriageRequesterQualityType.forString(
                        getEnumKeyTranslation(
                            fr.cg95.cvq.xml.civil.MarriageDetailsRequestDocument.MarriageDetailsRequest.class.getName(), 
                            "RequesterQuality", this.requesterQuality)
                    )
                );
			request.setFatherLastName(this.fatherLastName);
			request.setMotherMaidenName(this.motherMaidenName);
			request.setMarriageWifeFirstNames(this.marriageWifeFirstNames);
			if (this.marriageDate != null)
			request.setMarriageDate(this.marriageDate.getTime());
			request.setMarriageWifeLastName(this.marriageWifeLastName);
			request.setMarriageHusbandLastName(this.marriageHusbandLastName);
			request.setFatherFirstNames(this.fatherFirstNames);
			request.setMarriageHusbandFirstNames(this.marriageHusbandFirstNames);
			if (this.format != null)
                request.setFormat(
                    MarriageCertificateFormatType.forString(
                        getEnumKeyTranslation(
                            fr.cg95.cvq.xml.civil.MarriageDetailsRequestDocument.MarriageDetailsRequest.class.getName(), 
                            "Format", this.format)
                    )
                );
        }
    }
    
	public void setCopies(java.math.BigInteger copies) {
		this.copies = copies;
	}
	
	public java.math.BigInteger getCopies() {
		return this.copies;
	}

	public void setMotherFirstNames(String motherFirstNames) {
		this.motherFirstNames = motherFirstNames;
	}
	
	public String getMotherFirstNames() {
		return this.motherFirstNames;
	}

	public void setRequesterQualityPrecision(String requesterQualityPrecision) {
		this.requesterQualityPrecision = requesterQualityPrecision;
	}
	
	public String getRequesterQualityPrecision() {
		return this.requesterQualityPrecision;
	}

	public void setMarriageCity(String marriageCity) {
		this.marriageCity = marriageCity;
	}
	
	public String getMarriageCity() {
		return this.marriageCity;
	}

	public void setRelationship(String relationship) {
		this.relationship = relationship;
	}
	
	public String getRelationship() {
		return this.relationship;
	}

	public void setMarriagePostalCode(String marriagePostalCode) {
		this.marriagePostalCode = marriagePostalCode;
	}
	
	public String getMarriagePostalCode() {
		return this.marriagePostalCode;
	}

	public void setUsage(String usage) {
		this.usage = usage;
	}
	
	public String getUsage() {
		return this.usage;
	}

	public void setRequesterQuality(String requesterQuality) {
		this.requesterQuality = requesterQuality;
	}
	
	public String getRequesterQuality() {
		return this.requesterQuality;
	}

	public void setFatherLastName(String fatherLastName) {
		this.fatherLastName = fatherLastName;
	}
	
	public String getFatherLastName() {
		return this.fatherLastName;
	}

	public void setMotherMaidenName(String motherMaidenName) {
		this.motherMaidenName = motherMaidenName;
	}
	
	public String getMotherMaidenName() {
		return this.motherMaidenName;
	}

	public void setMarriageWifeFirstNames(String marriageWifeFirstNames) {
		this.marriageWifeFirstNames = marriageWifeFirstNames;
	}
	
	public String getMarriageWifeFirstNames() {
		return this.marriageWifeFirstNames;
	}

	public void setMarriageDate(Calendar marriageDate) {
		this.marriageDate = marriageDate;
	}
	
	public Calendar getMarriageDate() {
		return this.marriageDate;
	}

	public void setMarriageWifeLastName(String marriageWifeLastName) {
		this.marriageWifeLastName = marriageWifeLastName;
	}
	
	public String getMarriageWifeLastName() {
		return this.marriageWifeLastName;
	}

	public void setMarriageHusbandLastName(String marriageHusbandLastName) {
		this.marriageHusbandLastName = marriageHusbandLastName;
	}
	
	public String getMarriageHusbandLastName() {
		return this.marriageHusbandLastName;
	}

	public void setFatherFirstNames(String fatherFirstNames) {
		this.fatherFirstNames = fatherFirstNames;
	}
	
	public String getFatherFirstNames() {
		return this.fatherFirstNames;
	}

	public void setMarriageHusbandFirstNames(String marriageHusbandFirstNames) {
		this.marriageHusbandFirstNames = marriageHusbandFirstNames;
	}
	
	public String getMarriageHusbandFirstNames() {
		return this.marriageHusbandFirstNames;
	}

	public void setFormat(String format) {
		this.format = format;
	}
	
	public String getFormat() {
		return this.format;
	}

}

