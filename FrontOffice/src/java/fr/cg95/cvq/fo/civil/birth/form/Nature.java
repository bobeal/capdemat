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

	private String birthPostalCode;
	private String birthFirstNames;
	private String birthCity;
	private String birthLastName;
	private Calendar birthDate;
	private String requesterQualityPrecision;
	private String requesterQuality;

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
			this.birthPostalCode = request.getBirthPostalCode();
			this.birthFirstNames = request.getBirthFirstNames();
			this.birthCity = request.getBirthCity();
			this.birthLastName = request.getBirthLastName();
			this.birthDate = request.getBirthDate();
			this.requesterQualityPrecision = request.getRequesterQualityPrecision();
			if (request.getRequesterQuality() != null)
			this.requesterQuality = request.getRequesterQuality().toString();
		}
	}
	
	public void save(HttpSession session, Object xmlbRequest) {
		if ((xmlbRequest != null) && (xmlbRequest instanceof BirthDetailsRequest)) {
			BirthDetailsRequest request = (BirthDetailsRequest)xmlbRequest;
			request.setBirthPostalCode(this.birthPostalCode);
			request.setBirthFirstNames(this.birthFirstNames);
			request.setBirthCity(this.birthCity);
			request.setBirthLastName(this.birthLastName);
			request.setBirthDate(this.birthDate);
			request.setRequesterQualityPrecision(this.requesterQualityPrecision);
			request.setRequesterQuality(BirthRequesterQualityType.Enum.forString(this.requesterQuality));
		}
	}
	
	public boolean isComplete() {
		if (this.checkBirthPostalCode() &&
			((this.birthPostalCode == null) || (this.birthPostalCode.length() == 0)))
			return false;
		if (this.checkBirthFirstNames() &&
			((this.birthFirstNames == null) || (this.birthFirstNames.length() == 0)))
			return false;
		if (this.checkBirthCity() &&
			((this.birthCity == null) || (this.birthCity.length() == 0)))
			return false;
		if (this.checkBirthLastName() &&
			((this.birthLastName == null) || (this.birthLastName.length() == 0)))
			return false;
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

	public void setBirthCity(String birthCity) {
		this.birthCity = birthCity;
	}
	
	public String getBirthCity() {
		return this.birthCity;
	}
	
	public boolean checkBirthCity() {
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

	public void setRequesterQuality(String requesterQuality) {
		this.requesterQuality = requesterQuality;
	}
	
	public String getRequesterQuality() {
		return this.requesterQuality;
	}
	
	public boolean checkRequesterQuality() {
		return true;
	}

}
