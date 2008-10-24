package fr.cg95.cvq.fo.civil.birth.form;

import java.util.Calendar;
import java.util.Collection;
import java.util.List;
import javax.servlet.http.HttpSession;
import fr.cg95.cvq.wizard.*;
import fr.cg95.cvq.xml.common.*;
import fr.cg95.cvq.xml.civil.*;
import fr.cg95.cvq.xml.civil.BirthDetailsRequestDocument.BirthDetailsRequest;

public class Nature extends IStageForm {

	private String birthCity;
	private String requesterQuality;
	private String birthPostalCode;
	private String birthFirstNames;
	private Calendar birthDate;
	private String requesterQualityPrecision;
	private String birthLastName;

	public Nature() {
		super();
	}
	
	public void reset(String state) {
		if (state.equals("birth")) {
		}
		if (state.equals("displaybirth")) {
		}
	}
	
	public void load(HttpSession session, Object xmlbRequest) {
		if ((xmlbRequest != null) && (xmlbRequest instanceof BirthDetailsRequest)) {
			BirthDetailsRequest request = (BirthDetailsRequest)xmlbRequest;
			this.birthCity = request.getBirthCity();
			if (request.getRequesterQuality() != null)
			this.requesterQuality = request.getRequesterQuality().toString();
			this.birthPostalCode = request.getBirthPostalCode();
			this.birthFirstNames = request.getBirthFirstNames();
			this.birthDate = request.getBirthDate();
			this.requesterQualityPrecision = request.getRequesterQualityPrecision();
			this.birthLastName = request.getBirthLastName();
		}
	}
	
	public void save(HttpSession session, Object xmlbRequest) {
		if ((xmlbRequest != null) && (xmlbRequest instanceof BirthDetailsRequest)) {
			BirthDetailsRequest request = (BirthDetailsRequest)xmlbRequest;
			request.setBirthCity(this.birthCity);
			request.setRequesterQuality(BirthRequesterQualityType.Enum.forString(this.requesterQuality));
			request.setBirthPostalCode(this.birthPostalCode);
			request.setBirthFirstNames(this.birthFirstNames);
			request.setBirthDate(this.birthDate);
			request.setRequesterQualityPrecision(this.requesterQualityPrecision);
			request.setBirthLastName(this.birthLastName);
		}
	}
	
	public boolean isComplete() {
		if (this.checkBirthCity() &&
			((this.birthCity == null) || (this.birthCity.length() == 0)))
			return false;
		if (this.checkBirthPostalCode() &&
			((this.birthPostalCode == null) || (this.birthPostalCode.length() == 0)))
			return false;
		if (this.checkBirthFirstNames() &&
			((this.birthFirstNames == null) || (this.birthFirstNames.length() == 0)))
			return false;
		if (this.checkBirthDate() && (this.birthDate == null))
			return false;
		if (this.checkBirthLastName() &&
			((this.birthLastName == null) || (this.birthLastName.length() == 0)))
			return false;
		return true;
	}
	
	public void setBirthCity(String birthCity) {
		this.birthCity = birthCity;
	}
	
	public String getBirthCity() {
		return this.birthCity;
	}
	
	public boolean checkBirthCity() {
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

	public void setBirthPostalCode(String birthPostalCode) {
		this.birthPostalCode = birthPostalCode;
	}
	
	public String getBirthPostalCode() {
		return this.birthPostalCode;
	}
	
	public boolean checkBirthPostalCode() {
		return true;
	}

	public void setBirthFirstNames(String birthFirstNames) {
		this.birthFirstNames = birthFirstNames;
	}
	
	public String getBirthFirstNames() {
		return this.birthFirstNames;
	}
	
	public boolean checkBirthFirstNames() {
		return true;
	}

	public void setBirthDate(Calendar birthDate) {
		this.birthDate = birthDate;
	}
	
	public Calendar getBirthDate() {
		return this.birthDate;
	}
	
	public boolean checkBirthDate() {
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

	public void setBirthLastName(String birthLastName) {
		this.birthLastName = birthLastName;
	}
	
	public String getBirthLastName() {
		return this.birthLastName;
	}
	
	public boolean checkBirthLastName() {
		return true;
	}

}