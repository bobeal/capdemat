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

	private String deathFirstNames;
	private String deathCity;
	private String format;
	private String deathLastName;
	private java.math.BigInteger copies;
	private String comment;
	private Calendar deathDate;
	private String motive;
	private String deathPostalCode;

	public Validation() {
		super();
	}
	
	public void reset(String state) {
		if (state.equals("summary")) {
		}
	}
	
	public void load(HttpSession session, Object xmlbRequest) {
		if ((xmlbRequest != null) && (xmlbRequest instanceof DeathDetailsRequest)) {
			DeathDetailsRequest request = (DeathDetailsRequest)xmlbRequest;
			this.deathFirstNames = request.getDeathFirstNames();
			this.deathCity = request.getDeathCity();
			if (request.getFormat() != null)
			this.format = request.getFormat().toString();
			this.deathLastName = request.getDeathLastName();
			this.copies = request.getCopies();
			this.comment = request.getComment();
			this.deathDate = request.getDeathDate();
			if (request.getMotive() != null)
			this.motive = request.getMotive().toString();
			this.deathPostalCode = request.getDeathPostalCode();
		}
	}
	
	public void save(HttpSession session, Object xmlbRequest) {
		if ((xmlbRequest != null) && (xmlbRequest instanceof DeathDetailsRequest)) {
			DeathDetailsRequest request = (DeathDetailsRequest)xmlbRequest;
			request.setDeathFirstNames(this.deathFirstNames);
			request.setDeathCity(this.deathCity);
			request.setFormat(DeathCertificateFormatType.Enum.forString(this.format));
			request.setDeathLastName(this.deathLastName);
			request.setCopies(this.copies);
			request.setComment(this.comment);
			request.setDeathDate(this.deathDate);
			request.setMotive(DeathCertificateMotiveType.Enum.forString(this.motive));
			request.setDeathPostalCode(this.deathPostalCode);
		}
	}
	
	public boolean isComplete() {
		if (this.checkDeathFirstNames() &&
			((this.deathFirstNames == null) || (this.deathFirstNames.length() == 0)))
			return false;
		if (this.checkDeathCity() &&
			((this.deathCity == null) || (this.deathCity.length() == 0)))
			return false;
		if (this.checkFormat() &&
			((this.format == null) || (this.format.length() == 0)))
			return false;
		if (this.checkDeathLastName() &&
			((this.deathLastName == null) || (this.deathLastName.length() == 0)))
			return false;
		if (this.checkCopies() && (this.copies == null))
			return false;
		if (this.checkDeathDate() && (this.deathDate == null))
			return false;
		if (this.checkDeathPostalCode() &&
			((this.deathPostalCode == null) || (this.deathPostalCode.length() == 0)))
			return false;
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

	public void setDeathCity(String deathCity) {
		this.deathCity = deathCity;
	}
	
	public String getDeathCity() {
		return this.deathCity;
	}
	
	public boolean checkDeathCity() {
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

	public void setDeathLastName(String deathLastName) {
		this.deathLastName = deathLastName;
	}
	
	public String getDeathLastName() {
		return this.deathLastName;
	}
	
	public boolean checkDeathLastName() {
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

	public void setComment(String comment) {
		this.comment = comment;
	}
	
	public String getComment() {
		return this.comment;
	}
	
	public boolean checkComment() {
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

	public void setMotive(String motive) {
		this.motive = motive;
	}
	
	public String getMotive() {
		return this.motive;
	}
	
	public boolean checkMotive() {
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

}