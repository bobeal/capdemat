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

public class PersonalDetailsRequestRecord extends RequestRecord {

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

	public PersonalDetailsRequestRecord() {
		super();
	}
	
	protected Object clone() throws CloneNotSupportedException {
		PersonalDetailsRequestRecord clonedRecord = (PersonalDetailsRequestRecord)super.clone();
		return clonedRecord;
	}
	
	public BaseRecord getDataRecord(Long id) {

		if (id.equals(this.getId()))
			return this;
			
		return super.getDataRecord(id);
	}

    public void load(Object xmlRequest) {
        if ((xmlRequest != null) && (xmlRequest instanceof PersonalDetailsRequest)) {
            PersonalDetailsRequest request = (PersonalDetailsRequest)xmlRequest; 

			this.deathFirstNames = request.getDeathFirstNames();
			this.deathCity = request.getDeathCity();
			if (request.getFormat() != null)
                this.format = getEnumElementTranslation(
                        fr.cg95.cvq.xml.civil.PersonalDetailsRequestDocument.PersonalDetailsRequest.class.getName(), 
                        "Format", request.getFormat().toString());
			this.copies = request.getCopies();
			this.birthPostalCode = request.getBirthPostalCode();
			this.marriageHusbandFirstNames = request.getMarriageHusbandFirstNames();
			this.usage = request.getUsage();
			this.birthCity = request.getBirthCity();
			if (request.getRequesterQuality() != null)
                this.requesterQuality = getEnumElementTranslation(
                        fr.cg95.cvq.xml.civil.PersonalDetailsRequestDocument.PersonalDetailsRequest.class.getName(), 
                        "RequesterQuality", request.getRequesterQuality().toString());
			if (request.getMarriageDate() != null) {
				this.marriageDate = Calendar.getInstance(); 
	            this.marriageDate.setTime(request.getMarriageDate());
			}
			this.marriageHusbandLastName = request.getMarriageHusbandLastName();
			this.marriageWifeFirstNames = request.getMarriageWifeFirstNames();
			if (request.getDeathDate() != null) {
				this.deathDate = Calendar.getInstance(); 
	            this.deathDate.setTime(request.getDeathDate());
			}
			this.marriageCity = request.getMarriageCity();
			this.birthFirstNames = request.getBirthFirstNames();
			this.marriageWifeLastName = request.getMarriageWifeLastName();
			if (request.getBirthDate() != null) {
				this.birthDate = Calendar.getInstance(); 
	            this.birthDate.setTime(request.getBirthDate());
			}
			this.requesterQualityPrecision = request.getRequesterQualityPrecision();
			this.deathPostalCode = request.getDeathPostalCode();
			this.deathLastName = request.getDeathLastName();
			this.fatherLastName = request.getFatherLastName();
			if (request.getRelationship() != null)
                this.relationship = getEnumElementTranslation(
                        fr.cg95.cvq.xml.civil.PersonalDetailsRequestDocument.PersonalDetailsRequest.class.getName(), 
                        "Relationship", request.getRelationship().toString());
			this.motherFirstNames = request.getMotherFirstNames();
			this.fatherFirstNames = request.getFatherFirstNames();
			if (request.getCertificate() != null)
                this.certificate = getEnumElementTranslation(
                        fr.cg95.cvq.xml.civil.PersonalDetailsRequestDocument.PersonalDetailsRequest.class.getName(), 
                        "Certificate", request.getCertificate().toString());
			this.marriagePostalCode = request.getMarriagePostalCode();
			this.motherMaidenName = request.getMotherMaidenName();
			this.birthLastName = request.getBirthLastName();
        }
    }
    
    public void saveRequest(Object xmlRequest) {
        if ((xmlRequest != null) && (xmlRequest instanceof PersonalDetailsRequest)) {
            PersonalDetailsRequest request = (PersonalDetailsRequest)xmlRequest; 
        }
    }
    
    public void saveData(Object xmlRequest) {
        if ((xmlRequest != null) && (xmlRequest instanceof PersonalDetailsRequest)) {
            PersonalDetailsRequest request = (PersonalDetailsRequest)xmlRequest; 

			request.setDeathFirstNames(this.deathFirstNames);
			request.setDeathCity(this.deathCity);
			if (this.format != null)
                request.setFormat(
                    CertificateFormatType.forString(
                        getEnumKeyTranslation(
                            fr.cg95.cvq.xml.civil.PersonalDetailsRequestDocument.PersonalDetailsRequest.class.getName(), 
                            "Format", this.format)
                    )
                );
			request.setCopies(this.copies);
			request.setBirthPostalCode(this.birthPostalCode);
			request.setMarriageHusbandFirstNames(this.marriageHusbandFirstNames);
			request.setUsage(this.usage);
			request.setBirthCity(this.birthCity);
			if (this.requesterQuality != null)
                request.setRequesterQuality(
                    RequesterQualityType.forString(
                        getEnumKeyTranslation(
                            fr.cg95.cvq.xml.civil.PersonalDetailsRequestDocument.PersonalDetailsRequest.class.getName(), 
                            "RequesterQuality", this.requesterQuality)
                    )
                );
			if (this.marriageDate != null)
			request.setMarriageDate(this.marriageDate.getTime());
			request.setMarriageHusbandLastName(this.marriageHusbandLastName);
			request.setMarriageWifeFirstNames(this.marriageWifeFirstNames);
			if (this.deathDate != null)
			request.setDeathDate(this.deathDate.getTime());
			request.setMarriageCity(this.marriageCity);
			request.setBirthFirstNames(this.birthFirstNames);
			request.setMarriageWifeLastName(this.marriageWifeLastName);
			if (this.birthDate != null)
			request.setBirthDate(this.birthDate.getTime());
			request.setRequesterQualityPrecision(this.requesterQualityPrecision);
			request.setDeathPostalCode(this.deathPostalCode);
			request.setDeathLastName(this.deathLastName);
			request.setFatherLastName(this.fatherLastName);
			if (this.relationship != null)
                request.setRelationship(
                    RelationshipType.forString(
                        getEnumKeyTranslation(
                            fr.cg95.cvq.xml.civil.PersonalDetailsRequestDocument.PersonalDetailsRequest.class.getName(), 
                            "Relationship", this.relationship)
                    )
                );
			request.setMotherFirstNames(this.motherFirstNames);
			request.setFatherFirstNames(this.fatherFirstNames);
			if (this.certificate != null)
                request.setCertificate(
                    CertificateType.forString(
                        getEnumKeyTranslation(
                            fr.cg95.cvq.xml.civil.PersonalDetailsRequestDocument.PersonalDetailsRequest.class.getName(), 
                            "Certificate", this.certificate)
                    )
                );
			request.setMarriagePostalCode(this.marriagePostalCode);
			request.setMotherMaidenName(this.motherMaidenName);
			request.setBirthLastName(this.birthLastName);
        }
    }
    
	public void setDeathFirstNames(String deathFirstNames) {
		this.deathFirstNames = deathFirstNames;
	}
	
	public String getDeathFirstNames() {
		return this.deathFirstNames;
	}

	public void setDeathCity(String deathCity) {
		this.deathCity = deathCity;
	}
	
	public String getDeathCity() {
		return this.deathCity;
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

	public void setBirthPostalCode(String birthPostalCode) {
		this.birthPostalCode = birthPostalCode;
	}
	
	public String getBirthPostalCode() {
		return this.birthPostalCode;
	}

	public void setMarriageHusbandFirstNames(String marriageHusbandFirstNames) {
		this.marriageHusbandFirstNames = marriageHusbandFirstNames;
	}
	
	public String getMarriageHusbandFirstNames() {
		return this.marriageHusbandFirstNames;
	}

	public void setUsage(String usage) {
		this.usage = usage;
	}
	
	public String getUsage() {
		return this.usage;
	}

	public void setBirthCity(String birthCity) {
		this.birthCity = birthCity;
	}
	
	public String getBirthCity() {
		return this.birthCity;
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

	public void setMarriageHusbandLastName(String marriageHusbandLastName) {
		this.marriageHusbandLastName = marriageHusbandLastName;
	}
	
	public String getMarriageHusbandLastName() {
		return this.marriageHusbandLastName;
	}

	public void setMarriageWifeFirstNames(String marriageWifeFirstNames) {
		this.marriageWifeFirstNames = marriageWifeFirstNames;
	}
	
	public String getMarriageWifeFirstNames() {
		return this.marriageWifeFirstNames;
	}

	public void setDeathDate(Calendar deathDate) {
		this.deathDate = deathDate;
	}
	
	public Calendar getDeathDate() {
		return this.deathDate;
	}

	public void setMarriageCity(String marriageCity) {
		this.marriageCity = marriageCity;
	}
	
	public String getMarriageCity() {
		return this.marriageCity;
	}

	public void setBirthFirstNames(String birthFirstNames) {
		this.birthFirstNames = birthFirstNames;
	}
	
	public String getBirthFirstNames() {
		return this.birthFirstNames;
	}

	public void setMarriageWifeLastName(String marriageWifeLastName) {
		this.marriageWifeLastName = marriageWifeLastName;
	}
	
	public String getMarriageWifeLastName() {
		return this.marriageWifeLastName;
	}

	public void setBirthDate(Calendar birthDate) {
		this.birthDate = birthDate;
	}
	
	public Calendar getBirthDate() {
		return this.birthDate;
	}

	public void setRequesterQualityPrecision(String requesterQualityPrecision) {
		this.requesterQualityPrecision = requesterQualityPrecision;
	}
	
	public String getRequesterQualityPrecision() {
		return this.requesterQualityPrecision;
	}

	public void setDeathPostalCode(String deathPostalCode) {
		this.deathPostalCode = deathPostalCode;
	}
	
	public String getDeathPostalCode() {
		return this.deathPostalCode;
	}

	public void setDeathLastName(String deathLastName) {
		this.deathLastName = deathLastName;
	}
	
	public String getDeathLastName() {
		return this.deathLastName;
	}

	public void setFatherLastName(String fatherLastName) {
		this.fatherLastName = fatherLastName;
	}
	
	public String getFatherLastName() {
		return this.fatherLastName;
	}

	public void setRelationship(String relationship) {
		this.relationship = relationship;
	}
	
	public String getRelationship() {
		return this.relationship;
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

	public void setCertificate(String certificate) {
		this.certificate = certificate;
	}
	
	public String getCertificate() {
		return this.certificate;
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

	public void setBirthLastName(String birthLastName) {
		this.birthLastName = birthLastName;
	}
	
	public String getBirthLastName() {
		return this.birthLastName;
	}

}

