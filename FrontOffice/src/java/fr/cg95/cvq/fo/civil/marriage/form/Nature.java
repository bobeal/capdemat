package fr.cg95.cvq.fo.civil.marriage.form;

import java.util.Calendar;
import java.util.Collection;
import java.util.List;
import javax.servlet.http.HttpSession;
import fr.cg95.cvq.wizard.*;
import fr.cg95.cvq.xml.common.*;
import fr.cg95.cvq.xml.civil.*;
import fr.cg95.cvq.xml.civil.MarriageDetailsRequestDocument.MarriageDetailsRequest;

public class Nature extends IStageForm {

	private String requesterQuality;
	private Calendar marriageDate;
	private String marriageHusbandFirstNames;
	private String marriageHusbandLastName;
	private String marriageCity;
	private String marriageWifeFirstNames;
	private String marriageWifeLastName;
	private String marriagePostalCode;
	private String requesterQualityPrecision;

	public Nature() {
		super();
	}
	
	public void reset(String state) {
		if (state.equals("displaymarriage")) {
		}
		if (state.equals("marriage")) {
		}
	}
	
	public void load(HttpSession session, Object xmlbRequest) {
		if ((xmlbRequest != null) && (xmlbRequest instanceof MarriageDetailsRequest)) {
			MarriageDetailsRequest request = (MarriageDetailsRequest)xmlbRequest;
			if (request.getRequesterQuality() != null)
			this.requesterQuality = request.getRequesterQuality().toString();
			this.marriageDate = request.getMarriageDate();
			this.marriageHusbandFirstNames = request.getMarriageHusbandFirstNames();
			this.marriageHusbandLastName = request.getMarriageHusbandLastName();
			this.marriageCity = request.getMarriageCity();
			this.marriageWifeFirstNames = request.getMarriageWifeFirstNames();
			this.marriageWifeLastName = request.getMarriageWifeLastName();
			this.marriagePostalCode = request.getMarriagePostalCode();
			this.requesterQualityPrecision = request.getRequesterQualityPrecision();
		}
	}
	
	public void save(HttpSession session, Object xmlbRequest) {
		if ((xmlbRequest != null) && (xmlbRequest instanceof MarriageDetailsRequest)) {
			MarriageDetailsRequest request = (MarriageDetailsRequest)xmlbRequest;
			request.setRequesterQuality(MarriageRequesterQualityType.Enum.forString(this.requesterQuality));
			request.setMarriageDate(this.marriageDate);
			request.setMarriageHusbandFirstNames(this.marriageHusbandFirstNames);
			request.setMarriageHusbandLastName(this.marriageHusbandLastName);
			request.setMarriageCity(this.marriageCity);
			request.setMarriageWifeFirstNames(this.marriageWifeFirstNames);
			request.setMarriageWifeLastName(this.marriageWifeLastName);
			request.setMarriagePostalCode(this.marriagePostalCode);
			request.setRequesterQualityPrecision(this.requesterQualityPrecision);
		}
	}
	
	public boolean isComplete() {
		if (this.checkMarriageDate() && (this.marriageDate == null))
			return false;
		if (this.checkMarriageHusbandFirstNames() &&
			((this.marriageHusbandFirstNames == null) || (this.marriageHusbandFirstNames.length() == 0)))
			return false;
		if (this.checkMarriageHusbandLastName() &&
			((this.marriageHusbandLastName == null) || (this.marriageHusbandLastName.length() == 0)))
			return false;
		if (this.checkMarriageCity() &&
			((this.marriageCity == null) || (this.marriageCity.length() == 0)))
			return false;
		if (this.checkMarriageWifeFirstNames() &&
			((this.marriageWifeFirstNames == null) || (this.marriageWifeFirstNames.length() == 0)))
			return false;
		if (this.checkMarriageWifeLastName() &&
			((this.marriageWifeLastName == null) || (this.marriageWifeLastName.length() == 0)))
			return false;
		if (this.checkMarriagePostalCode() &&
			((this.marriagePostalCode == null) || (this.marriagePostalCode.length() == 0)))
			return false;
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

	public void setMarriageDate(Calendar marriageDate) {
		this.marriageDate = marriageDate;
	}
	
	public Calendar getMarriageDate() {
		return this.marriageDate;
	}
	
	public boolean checkMarriageDate() {
		return true;
	}

	public void setMarriageHusbandFirstNames(String marriageHusbandFirstNames) {
		this.marriageHusbandFirstNames = marriageHusbandFirstNames;
	}
	
	public String getMarriageHusbandFirstNames() {
		return this.marriageHusbandFirstNames;
	}
	
	public boolean checkMarriageHusbandFirstNames() {
		return true;
	}

	public void setMarriageHusbandLastName(String marriageHusbandLastName) {
		this.marriageHusbandLastName = marriageHusbandLastName;
	}
	
	public String getMarriageHusbandLastName() {
		return this.marriageHusbandLastName;
	}
	
	public boolean checkMarriageHusbandLastName() {
		return true;
	}

	public void setMarriageCity(String marriageCity) {
		this.marriageCity = marriageCity;
	}
	
	public String getMarriageCity() {
		return this.marriageCity;
	}
	
	public boolean checkMarriageCity() {
		return true;
	}

	public void setMarriageWifeFirstNames(String marriageWifeFirstNames) {
		this.marriageWifeFirstNames = marriageWifeFirstNames;
	}
	
	public String getMarriageWifeFirstNames() {
		return this.marriageWifeFirstNames;
	}
	
	public boolean checkMarriageWifeFirstNames() {
		return true;
	}

	public void setMarriageWifeLastName(String marriageWifeLastName) {
		this.marriageWifeLastName = marriageWifeLastName;
	}
	
	public String getMarriageWifeLastName() {
		return this.marriageWifeLastName;
	}
	
	public boolean checkMarriageWifeLastName() {
		return true;
	}

	public void setMarriagePostalCode(String marriagePostalCode) {
		this.marriagePostalCode = marriagePostalCode;
	}
	
	public String getMarriagePostalCode() {
		return this.marriagePostalCode;
	}
	
	public boolean checkMarriagePostalCode() {
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

}