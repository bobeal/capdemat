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

	private String format;
	private java.math.BigInteger copies;
	private String birthPostalCode;
	private String comment;
	private String birthFirstNames;
	private String motive;
	private String requesterQualityPrecision;
	private Calendar birthDate;
	private String requesterQuality;
	private String birthCity;
	private String fatherLastName;
	private String motherFirstNames;
	private String fatherFirstNames;
	private String motherMaidenName;
	private String birthLastName;

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

			if (request.getFormat() != null)
                this.format = getEnumElementTranslation(
                        fr.cg95.cvq.xml.civil.BirthDetailsRequestDocument.BirthDetailsRequest.class.getName(), 
                        "Format", request.getFormat().toString());
			this.copies = request.getCopies();
			this.birthPostalCode = request.getBirthPostalCode();
			this.comment = request.getComment();
			this.birthFirstNames = request.getBirthFirstNames();
			if (request.getMotive() != null)
                this.motive = getEnumElementTranslation(
                        fr.cg95.cvq.xml.civil.BirthDetailsRequestDocument.BirthDetailsRequest.class.getName(), 
                        "Motive", request.getMotive().toString());
			this.requesterQualityPrecision = request.getRequesterQualityPrecision();
			if (request.getBirthDate() != null) {
				this.birthDate = Calendar.getInstance(); 
	            this.birthDate.setTime(request.getBirthDate());
			}
			if (request.getRequesterQuality() != null)
                this.requesterQuality = getEnumElementTranslation(
                        fr.cg95.cvq.xml.civil.BirthDetailsRequestDocument.BirthDetailsRequest.class.getName(), 
                        "RequesterQuality", request.getRequesterQuality().toString());
			this.birthCity = request.getBirthCity();
			this.fatherLastName = request.getFatherLastName();
			this.motherFirstNames = request.getMotherFirstNames();
			this.fatherFirstNames = request.getFatherFirstNames();
			this.motherMaidenName = request.getMotherMaidenName();
			this.birthLastName = request.getBirthLastName();
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

			if (this.format != null)
                request.setFormat(
                    BirthCertificateFormatType.forString(
                        getEnumKeyTranslation(
                            fr.cg95.cvq.xml.civil.BirthDetailsRequestDocument.BirthDetailsRequest.class.getName(), 
                            "Format", this.format)
                    )
                );
			request.setCopies(this.copies);
			request.setBirthPostalCode(this.birthPostalCode);
			request.setComment(this.comment);
			request.setBirthFirstNames(this.birthFirstNames);
			if (this.motive != null)
                request.setMotive(
                    BirthCertificateMotiveType.forString(
                        getEnumKeyTranslation(
                            fr.cg95.cvq.xml.civil.BirthDetailsRequestDocument.BirthDetailsRequest.class.getName(), 
                            "Motive", this.motive)
                    )
                );
			request.setRequesterQualityPrecision(this.requesterQualityPrecision);
			if (this.birthDate != null)
			request.setBirthDate(this.birthDate.getTime());
			if (this.requesterQuality != null)
                request.setRequesterQuality(
                    BirthRequesterQualityType.forString(
                        getEnumKeyTranslation(
                            fr.cg95.cvq.xml.civil.BirthDetailsRequestDocument.BirthDetailsRequest.class.getName(), 
                            "RequesterQuality", this.requesterQuality)
                    )
                );
			request.setBirthCity(this.birthCity);
			request.setFatherLastName(this.fatherLastName);
			request.setMotherFirstNames(this.motherFirstNames);
			request.setFatherFirstNames(this.fatherFirstNames);
			request.setMotherMaidenName(this.motherMaidenName);
			request.setBirthLastName(this.birthLastName);
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

	public void setBirthPostalCode(String birthPostalCode) {
		this.birthPostalCode = birthPostalCode;
	}
	
	public String getBirthPostalCode() {
		return this.birthPostalCode;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
	
	public String getComment() {
		return this.comment;
	}

	public void setBirthFirstNames(String birthFirstNames) {
		this.birthFirstNames = birthFirstNames;
	}
	
	public String getBirthFirstNames() {
		return this.birthFirstNames;
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

	public void setBirthDate(Calendar birthDate) {
		this.birthDate = birthDate;
	}
	
	public Calendar getBirthDate() {
		return this.birthDate;
	}

	public void setRequesterQuality(String requesterQuality) {
		this.requesterQuality = requesterQuality;
	}
	
	public String getRequesterQuality() {
		return this.requesterQuality;
	}

	public void setBirthCity(String birthCity) {
		this.birthCity = birthCity;
	}
	
	public String getBirthCity() {
		return this.birthCity;
	}

	public void setFatherLastName(String fatherLastName) {
		this.fatherLastName = fatherLastName;
	}
	
	public String getFatherLastName() {
		return this.fatherLastName;
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

