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

public class DeathDetailsRequestRecord extends RequestRecord {

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

	public DeathDetailsRequestRecord() {
		super();
	}
	
	protected Object clone() throws CloneNotSupportedException {
		DeathDetailsRequestRecord clonedRecord = (DeathDetailsRequestRecord)super.clone();
		return clonedRecord;
	}
	
	public BaseRecord getDataRecord(Long id) {

		if (id.equals(this.getId()))
			return this;
			
		return super.getDataRecord(id);
	}

    public void load(Object xmlRequest) {
        if ((xmlRequest != null) && (xmlRequest instanceof DeathDetailsRequest)) {
            DeathDetailsRequest request = (DeathDetailsRequest)xmlRequest; 

			this.copies = request.getCopies();
			this.motherFirstNames = request.getMotherFirstNames();
			this.requesterQualityPrecision = request.getRequesterQualityPrecision();
			this.deathFirstNames = request.getDeathFirstNames();
			if (request.getRelationship() != null)
                this.relationship = getEnumElementTranslation(
                        fr.cg95.cvq.xml.civil.DeathDetailsRequestDocument.DeathDetailsRequest.class.getName(), 
                        "Relationship", request.getRelationship().toString());
			this.usage = request.getUsage();
			if (request.getRequesterQuality() != null)
                this.requesterQuality = getEnumElementTranslation(
                        fr.cg95.cvq.xml.civil.DeathDetailsRequestDocument.DeathDetailsRequest.class.getName(), 
                        "RequesterQuality", request.getRequesterQuality().toString());
			this.fatherLastName = request.getFatherLastName();
			if (request.getDeathDate() != null) {
				this.deathDate = Calendar.getInstance(); 
	            this.deathDate.setTime(request.getDeathDate());
			}
			this.deathCity = request.getDeathCity();
			this.deathPostalCode = request.getDeathPostalCode();
			this.motherMaidenName = request.getMotherMaidenName();
			this.deathLastName = request.getDeathLastName();
			this.fatherFirstNames = request.getFatherFirstNames();
			if (request.getFormat() != null)
                this.format = getEnumElementTranslation(
                        fr.cg95.cvq.xml.civil.DeathDetailsRequestDocument.DeathDetailsRequest.class.getName(), 
                        "Format", request.getFormat().toString());
        }
    }
    
    public void saveRequest(Object xmlRequest) {
        if ((xmlRequest != null) && (xmlRequest instanceof DeathDetailsRequest)) {
            DeathDetailsRequest request = (DeathDetailsRequest)xmlRequest; 
        }
    }
    
    public void saveData(Object xmlRequest) {
        if ((xmlRequest != null) && (xmlRequest instanceof DeathDetailsRequest)) {
            DeathDetailsRequest request = (DeathDetailsRequest)xmlRequest; 

			request.setCopies(this.copies);
			request.setMotherFirstNames(this.motherFirstNames);
			request.setRequesterQualityPrecision(this.requesterQualityPrecision);
			request.setDeathFirstNames(this.deathFirstNames);
			if (this.relationship != null)
                request.setRelationship(
                    DeathRelationshipType.forString(
                        getEnumKeyTranslation(
                            fr.cg95.cvq.xml.civil.DeathDetailsRequestDocument.DeathDetailsRequest.class.getName(), 
                            "Relationship", this.relationship)
                    )
                );
			request.setUsage(this.usage);
			if (this.requesterQuality != null)
                request.setRequesterQuality(
                    DeathRequesterQualityType.forString(
                        getEnumKeyTranslation(
                            fr.cg95.cvq.xml.civil.DeathDetailsRequestDocument.DeathDetailsRequest.class.getName(), 
                            "RequesterQuality", this.requesterQuality)
                    )
                );
			request.setFatherLastName(this.fatherLastName);
			if (this.deathDate != null)
			request.setDeathDate(this.deathDate.getTime());
			request.setDeathCity(this.deathCity);
			request.setDeathPostalCode(this.deathPostalCode);
			request.setMotherMaidenName(this.motherMaidenName);
			request.setDeathLastName(this.deathLastName);
			request.setFatherFirstNames(this.fatherFirstNames);
			if (this.format != null)
                request.setFormat(
                    DeathCertificateFormatType.forString(
                        getEnumKeyTranslation(
                            fr.cg95.cvq.xml.civil.DeathDetailsRequestDocument.DeathDetailsRequest.class.getName(), 
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

	public void setDeathFirstNames(String deathFirstNames) {
		this.deathFirstNames = deathFirstNames;
	}
	
	public String getDeathFirstNames() {
		return this.deathFirstNames;
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

	public void setDeathDate(Calendar deathDate) {
		this.deathDate = deathDate;
	}
	
	public Calendar getDeathDate() {
		return this.deathDate;
	}

	public void setDeathCity(String deathCity) {
		this.deathCity = deathCity;
	}
	
	public String getDeathCity() {
		return this.deathCity;
	}

	public void setDeathPostalCode(String deathPostalCode) {
		this.deathPostalCode = deathPostalCode;
	}
	
	public String getDeathPostalCode() {
		return this.deathPostalCode;
	}

	public void setMotherMaidenName(String motherMaidenName) {
		this.motherMaidenName = motherMaidenName;
	}
	
	public String getMotherMaidenName() {
		return this.motherMaidenName;
	}

	public void setDeathLastName(String deathLastName) {
		this.deathLastName = deathLastName;
	}
	
	public String getDeathLastName() {
		return this.deathLastName;
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

