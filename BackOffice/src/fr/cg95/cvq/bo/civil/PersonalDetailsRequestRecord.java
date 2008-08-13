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

	private String birthFirstNames;
	private String birthLastName;
	private String requesterQualityPrecision;
	private String deathFirstNames;
	private String relationship;
	private String marriagePostalCode;
	private String birthPostalCode;
	private Calendar deathDate;
	private Calendar birthDate;
	private String deathPostalCode;
	private String marriageWifeFirstNames;
	private String marriageWifeLastName;
	private String marriageHusbandLastName;
	private String fatherFirstNames;
	private String format;
	private java.math.BigInteger copies;
	private String motherFirstNames;
	private String certificate;
	private String marriageCity;
	private String usage;
	private String requesterQuality;
	private String fatherLastName;
	private String birthCity;
	private String deathCity;
	private String motherMaidenName;
	private String deathLastName;
	private Calendar marriageDate;
	private String marriageHusbandFirstNames;

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

			this.birthFirstNames = request.getBirthFirstNames();
			this.birthLastName = request.getBirthLastName();
			this.requesterQualityPrecision = request.getRequesterQualityPrecision();
			this.deathFirstNames = request.getDeathFirstNames();
			if (request.getRelationship() != null)
                this.relationship = getEnumElementTranslation(
                        fr.cg95.cvq.xml.civil.PersonalDetailsRequestDocument.PersonalDetailsRequest.class.getName(), 
                        "Relationship", request.getRelationship().toString());
			this.marriagePostalCode = request.getMarriagePostalCode();
			this.birthPostalCode = request.getBirthPostalCode();
			if (request.getDeathDate() != null) {
				this.deathDate = Calendar.getInstance(); 
	            this.deathDate.setTime(request.getDeathDate());
			}
			if (request.getBirthDate() != null) {
				this.birthDate = Calendar.getInstance(); 
	            this.birthDate.setTime(request.getBirthDate());
			}
			this.deathPostalCode = request.getDeathPostalCode();
			this.marriageWifeFirstNames = request.getMarriageWifeFirstNames();
			this.marriageWifeLastName = request.getMarriageWifeLastName();
			this.marriageHusbandLastName = request.getMarriageHusbandLastName();
			this.fatherFirstNames = request.getFatherFirstNames();
			if (request.getFormat() != null)
                this.format = getEnumElementTranslation(
                        fr.cg95.cvq.xml.civil.PersonalDetailsRequestDocument.PersonalDetailsRequest.class.getName(), 
                        "Format", request.getFormat().toString());
			this.copies = request.getCopies();
			this.motherFirstNames = request.getMotherFirstNames();
			if (request.getCertificate() != null)
                this.certificate = getEnumElementTranslation(
                        fr.cg95.cvq.xml.civil.PersonalDetailsRequestDocument.PersonalDetailsRequest.class.getName(), 
                        "Certificate", request.getCertificate().toString());
			this.marriageCity = request.getMarriageCity();
			this.usage = request.getUsage();
			if (request.getRequesterQuality() != null)
                this.requesterQuality = getEnumElementTranslation(
                        fr.cg95.cvq.xml.civil.PersonalDetailsRequestDocument.PersonalDetailsRequest.class.getName(), 
                        "RequesterQuality", request.getRequesterQuality().toString());
			this.fatherLastName = request.getFatherLastName();
			this.birthCity = request.getBirthCity();
			this.deathCity = request.getDeathCity();
			this.motherMaidenName = request.getMotherMaidenName();
			this.deathLastName = request.getDeathLastName();
			if (request.getMarriageDate() != null) {
				this.marriageDate = Calendar.getInstance(); 
	            this.marriageDate.setTime(request.getMarriageDate());
			}
			this.marriageHusbandFirstNames = request.getMarriageHusbandFirstNames();
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

			request.setBirthFirstNames(this.birthFirstNames);
			request.setBirthLastName(this.birthLastName);
			request.setRequesterQualityPrecision(this.requesterQualityPrecision);
			request.setDeathFirstNames(this.deathFirstNames);
			if (this.relationship != null)
                request.setRelationship(
                    RelationshipType.forString(
                        getEnumKeyTranslation(
                            fr.cg95.cvq.xml.civil.PersonalDetailsRequestDocument.PersonalDetailsRequest.class.getName(), 
                            "Relationship", this.relationship)
                    )
                );
			request.setMarriagePostalCode(this.marriagePostalCode);
			request.setBirthPostalCode(this.birthPostalCode);
			if (this.deathDate != null)
			request.setDeathDate(this.deathDate.getTime());
			if (this.birthDate != null)
			request.setBirthDate(this.birthDate.getTime());
			request.setDeathPostalCode(this.deathPostalCode);
			request.setMarriageWifeFirstNames(this.marriageWifeFirstNames);
			request.setMarriageWifeLastName(this.marriageWifeLastName);
			request.setMarriageHusbandLastName(this.marriageHusbandLastName);
			request.setFatherFirstNames(this.fatherFirstNames);
			if (this.format != null)
                request.setFormat(
                    CertificateFormatType.forString(
                        getEnumKeyTranslation(
                            fr.cg95.cvq.xml.civil.PersonalDetailsRequestDocument.PersonalDetailsRequest.class.getName(), 
                            "Format", this.format)
                    )
                );
			request.setCopies(this.copies);
			request.setMotherFirstNames(this.motherFirstNames);
			if (this.certificate != null)
                request.setCertificate(
                    CertificateType.forString(
                        getEnumKeyTranslation(
                            fr.cg95.cvq.xml.civil.PersonalDetailsRequestDocument.PersonalDetailsRequest.class.getName(), 
                            "Certificate", this.certificate)
                    )
                );
			request.setMarriageCity(this.marriageCity);
			request.setUsage(this.usage);
			if (this.requesterQuality != null)
                request.setRequesterQuality(
                    RequesterQualityType.forString(
                        getEnumKeyTranslation(
                            fr.cg95.cvq.xml.civil.PersonalDetailsRequestDocument.PersonalDetailsRequest.class.getName(), 
                            "RequesterQuality", this.requesterQuality)
                    )
                );
			request.setFatherLastName(this.fatherLastName);
			request.setBirthCity(this.birthCity);
			request.setDeathCity(this.deathCity);
			request.setMotherMaidenName(this.motherMaidenName);
			request.setDeathLastName(this.deathLastName);
			if (this.marriageDate != null)
			request.setMarriageDate(this.marriageDate.getTime());
			request.setMarriageHusbandFirstNames(this.marriageHusbandFirstNames);
        }
    }
    
	public void setBirthFirstNames(String birthFirstNames) {
		this.birthFirstNames = birthFirstNames;
	}
	
	public String getBirthFirstNames() {
		return this.birthFirstNames;
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

	public void setMarriagePostalCode(String marriagePostalCode) {
		this.marriagePostalCode = marriagePostalCode;
	}
	
	public String getMarriagePostalCode() {
		return this.marriagePostalCode;
	}

	public void setBirthPostalCode(String birthPostalCode) {
		this.birthPostalCode = birthPostalCode;
	}
	
	public String getBirthPostalCode() {
		return this.birthPostalCode;
	}

	public void setDeathDate(Calendar deathDate) {
		this.deathDate = deathDate;
	}
	
	public Calendar getDeathDate() {
		return this.deathDate;
	}

	public void setBirthDate(Calendar birthDate) {
		this.birthDate = birthDate;
	}
	
	public Calendar getBirthDate() {
		return this.birthDate;
	}

	public void setDeathPostalCode(String deathPostalCode) {
		this.deathPostalCode = deathPostalCode;
	}
	
	public String getDeathPostalCode() {
		return this.deathPostalCode;
	}

	public void setMarriageWifeFirstNames(String marriageWifeFirstNames) {
		this.marriageWifeFirstNames = marriageWifeFirstNames;
	}
	
	public String getMarriageWifeFirstNames() {
		return this.marriageWifeFirstNames;
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

	public void setMotherFirstNames(String motherFirstNames) {
		this.motherFirstNames = motherFirstNames;
	}
	
	public String getMotherFirstNames() {
		return this.motherFirstNames;
	}

	public void setCertificate(String certificate) {
		this.certificate = certificate;
	}
	
	public String getCertificate() {
		return this.certificate;
	}

	public void setMarriageCity(String marriageCity) {
		this.marriageCity = marriageCity;
	}
	
	public String getMarriageCity() {
		return this.marriageCity;
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

	public void setBirthCity(String birthCity) {
		this.birthCity = birthCity;
	}
	
	public String getBirthCity() {
		return this.birthCity;
	}

	public void setDeathCity(String deathCity) {
		this.deathCity = deathCity;
	}
	
	public String getDeathCity() {
		return this.deathCity;
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

	public void setMarriageDate(Calendar marriageDate) {
		this.marriageDate = marriageDate;
	}
	
	public Calendar getMarriageDate() {
		return this.marriageDate;
	}

	public void setMarriageHusbandFirstNames(String marriageHusbandFirstNames) {
		this.marriageHusbandFirstNames = marriageHusbandFirstNames;
	}
	
	public String getMarriageHusbandFirstNames() {
		return this.marriageHusbandFirstNames;
	}

}

