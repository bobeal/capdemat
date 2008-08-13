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

public class BirthDetailsRequestRecord extends RequestRecord {

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

	public BirthDetailsRequestRecord() {
		super();
	}
	
	protected Object clone() throws CloneNotSupportedException {
		BirthDetailsRequestRecord clonedRecord = (BirthDetailsRequestRecord)super.clone();
		return clonedRecord;
	}
	
	public BaseRecord getDataRecord(Long id) {

		if (id.equals(this.getId()))
			return this;
			
		return super.getDataRecord(id);
	}

    public void load(Object xmlRequest) {
        if ((xmlRequest != null) && (xmlRequest instanceof BirthDetailsRequest)) {
            BirthDetailsRequest request = (BirthDetailsRequest)xmlRequest; 

			this.birthFirstNames = request.getBirthFirstNames();
			this.copies = request.getCopies();
			this.motherFirstNames = request.getMotherFirstNames();
			this.birthLastName = request.getBirthLastName();
			this.requesterQualityPrecision = request.getRequesterQualityPrecision();
			if (request.getRelationship() != null)
                this.relationship = getEnumElementTranslation(
                        fr.cg95.cvq.xml.civil.BirthDetailsRequestDocument.BirthDetailsRequest.class.getName(), 
                        "Relationship", request.getRelationship().toString());
			this.usage = request.getUsage();
			if (request.getRequesterQuality() != null)
                this.requesterQuality = getEnumElementTranslation(
                        fr.cg95.cvq.xml.civil.BirthDetailsRequestDocument.BirthDetailsRequest.class.getName(), 
                        "RequesterQuality", request.getRequesterQuality().toString());
			this.fatherLastName = request.getFatherLastName();
			this.birthPostalCode = request.getBirthPostalCode();
			this.birthCity = request.getBirthCity();
			if (request.getBirthDate() != null) {
				this.birthDate = Calendar.getInstance(); 
	            this.birthDate.setTime(request.getBirthDate());
			}
			this.motherMaidenName = request.getMotherMaidenName();
			this.fatherFirstNames = request.getFatherFirstNames();
			if (request.getFormat() != null)
                this.format = getEnumElementTranslation(
                        fr.cg95.cvq.xml.civil.BirthDetailsRequestDocument.BirthDetailsRequest.class.getName(), 
                        "Format", request.getFormat().toString());
        }
    }
    
    public void saveRequest(Object xmlRequest) {
        if ((xmlRequest != null) && (xmlRequest instanceof BirthDetailsRequest)) {
            BirthDetailsRequest request = (BirthDetailsRequest)xmlRequest; 
        }
    }
    
    public void saveData(Object xmlRequest) {
        if ((xmlRequest != null) && (xmlRequest instanceof BirthDetailsRequest)) {
            BirthDetailsRequest request = (BirthDetailsRequest)xmlRequest; 

			request.setBirthFirstNames(this.birthFirstNames);
			request.setCopies(this.copies);
			request.setMotherFirstNames(this.motherFirstNames);
			request.setBirthLastName(this.birthLastName);
			request.setRequesterQualityPrecision(this.requesterQualityPrecision);
			if (this.relationship != null)
                request.setRelationship(
                    BirthRelationshipType.forString(
                        getEnumKeyTranslation(
                            fr.cg95.cvq.xml.civil.BirthDetailsRequestDocument.BirthDetailsRequest.class.getName(), 
                            "Relationship", this.relationship)
                    )
                );
			request.setUsage(this.usage);
			if (this.requesterQuality != null)
                request.setRequesterQuality(
                    BirthRequesterQualityType.forString(
                        getEnumKeyTranslation(
                            fr.cg95.cvq.xml.civil.BirthDetailsRequestDocument.BirthDetailsRequest.class.getName(), 
                            "RequesterQuality", this.requesterQuality)
                    )
                );
			request.setFatherLastName(this.fatherLastName);
			request.setBirthPostalCode(this.birthPostalCode);
			request.setBirthCity(this.birthCity);
			if (this.birthDate != null)
			request.setBirthDate(this.birthDate.getTime());
			request.setMotherMaidenName(this.motherMaidenName);
			request.setFatherFirstNames(this.fatherFirstNames);
			if (this.format != null)
                request.setFormat(
                    BirthCertificateFormatType.forString(
                        getEnumKeyTranslation(
                            fr.cg95.cvq.xml.civil.BirthDetailsRequestDocument.BirthDetailsRequest.class.getName(), 
                            "Format", this.format)
                    )
                );
        }
    }
    
	public void setBirthFirstNames(String birthFirstNames) {
		this.birthFirstNames = birthFirstNames;
	}
	
	public String getBirthFirstNames() {
		return this.birthFirstNames;
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

	public void setBirthLastName(String birthLastName) {
		this.birthLastName = birthLastName;
	}
	
	public String getBirthLastName() {
		return this.birthLastName;
	}

	public void setRequesterQualityPrecision(String requesterQualityPrecision) {
		this.requesterQualityPrecision = requesterQualityPrecision;
	}
	
	public String getRequesterQualityPrecision() {
		return this.requesterQualityPrecision;
	}

	public void setRelationship(String relationship) {
		this.relationship = relationship;
	}
	
	public String getRelationship() {
		return this.relationship;
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

	public void setBirthPostalCode(String birthPostalCode) {
		this.birthPostalCode = birthPostalCode;
	}
	
	public String getBirthPostalCode() {
		return this.birthPostalCode;
	}

	public void setBirthCity(String birthCity) {
		this.birthCity = birthCity;
	}
	
	public String getBirthCity() {
		return this.birthCity;
	}

	public void setBirthDate(Calendar birthDate) {
		this.birthDate = birthDate;
	}
	
	public Calendar getBirthDate() {
		return this.birthDate;
	}

	public void setMotherMaidenName(String motherMaidenName) {
		this.motherMaidenName = motherMaidenName;
	}
	
	public String getMotherMaidenName() {
		return this.motherMaidenName;
	}

	public void setFatherFirstNames(String fatherFirstNames) {
		this.fatherFirstNames = fatherFirstNames;
	}
	
	public String getFatherFirstNames() {
		return this.fatherFirstNames;
	}

	public void setFormat(String format) {
		this.format = format;
	}
	
	public String getFormat() {
		return this.format;
	}

}

