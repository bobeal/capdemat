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

	private String deathFirstNames;
	private String deathCity;
	private String format;
	private String deathLastName;
	private java.math.BigInteger copies;
	private String comment;
	private Calendar deathDate;
	private String motive;
	private String deathPostalCode;

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

			this.deathFirstNames = request.getDeathFirstNames();
			this.deathCity = request.getDeathCity();
			if (request.getFormat() != null)
                this.format = getEnumElementTranslation(
                        fr.cg95.cvq.xml.civil.DeathDetailsRequestDocument.DeathDetailsRequest.class.getName(), 
                        "Format", request.getFormat().toString());
			this.deathLastName = request.getDeathLastName();
			this.copies = request.getCopies();
			this.comment = request.getComment();
			if (request.getDeathDate() != null) {
				this.deathDate = Calendar.getInstance(); 
	            this.deathDate.setTime(request.getDeathDate());
			}
			if (request.getMotive() != null)
                this.motive = getEnumElementTranslation(
                        fr.cg95.cvq.xml.civil.DeathDetailsRequestDocument.DeathDetailsRequest.class.getName(), 
                        "Motive", request.getMotive().toString());
			this.deathPostalCode = request.getDeathPostalCode();
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

			request.setDeathFirstNames(this.deathFirstNames);
			request.setDeathCity(this.deathCity);
			if (this.format != null)
                request.setFormat(
                    DeathCertificateFormatType.forString(
                        getEnumKeyTranslation(
                            fr.cg95.cvq.xml.civil.DeathDetailsRequestDocument.DeathDetailsRequest.class.getName(), 
                            "Format", this.format)
                    )
                );
			request.setDeathLastName(this.deathLastName);
			request.setCopies(this.copies);
			request.setComment(this.comment);
			if (this.deathDate != null)
			request.setDeathDate(this.deathDate.getTime());
			if (this.motive != null)
                request.setMotive(
                    DeathCertificateMotiveType.forString(
                        getEnumKeyTranslation(
                            fr.cg95.cvq.xml.civil.DeathDetailsRequestDocument.DeathDetailsRequest.class.getName(), 
                            "Motive", this.motive)
                    )
                );
			request.setDeathPostalCode(this.deathPostalCode);
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

	public void setDeathLastName(String deathLastName) {
		this.deathLastName = deathLastName;
	}
	
	public String getDeathLastName() {
		return this.deathLastName;
	}

	public void setCopies(java.math.BigInteger copies) {
		this.copies = copies;
	}
	
	public java.math.BigInteger getCopies() {
		return this.copies;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
	
	public String getComment() {
		return this.comment;
	}

	public void setDeathDate(Calendar deathDate) {
		this.deathDate = deathDate;
	}
	
	public Calendar getDeathDate() {
		return this.deathDate;
	}

	public void setMotive(String motive) {
		this.motive = motive;
	}
	
	public String getMotive() {
		return this.motive;
	}

	public void setDeathPostalCode(String deathPostalCode) {
		this.deathPostalCode = deathPostalCode;
	}
	
	public String getDeathPostalCode() {
		return this.deathPostalCode;
	}

}

