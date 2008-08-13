package fr.cg95.cvq.fo.civil.death.form;

import java.util.Calendar;
import java.util.Collection;
import java.util.List;
import javax.servlet.http.HttpSession;
import fr.cg95.cvq.wizard.*;
import fr.cg95.cvq.xml.common.*;
import fr.cg95.cvq.xml.civil.*;
import fr.cg95.cvq.xml.civil.DeathDetailsRequestDocument.DeathDetailsRequest;

public class Nature extends IStageForm {

	private Calendar deathDate;
	private String deathCity;
	private String deathPostalCode;
	private String deathLastName;
	private String deathFirstNames;
	private String requesterQualityPrecision;
	private String requesterQuality;

	public Nature() {
		super();
	}
	
	public void reset(String state) {
		if (state.equals("displaydeath")) {
		}
		if (state.equals("death")) {
		}
	}
	
	public void load(HttpSession session, Object xmlbRequest) {
		if ((xmlbRequest != null) && (xmlbRequest instanceof DeathDetailsRequest)) {
			DeathDetailsRequest request = (DeathDetailsRequest)xmlbRequest;
			this.deathDate = request.getDeathDate();
			this.deathCity = request.getDeathCity();
			this.deathPostalCode = request.getDeathPostalCode();
			this.deathLastName = request.getDeathLastName();
			this.deathFirstNames = request.getDeathFirstNames();
			this.requesterQualityPrecision = request.getRequesterQualityPrecision();
			if (request.getRequesterQuality() != null)
			this.requesterQuality = request.getRequesterQuality().toString();
		}
	}
	
	public void save(HttpSession session, Object xmlbRequest) {
		if ((xmlbRequest != null) && (xmlbRequest instanceof DeathDetailsRequest)) {
			DeathDetailsRequest request = (DeathDetailsRequest)xmlbRequest;
			request.setDeathDate(this.deathDate);
			request.setDeathCity(this.deathCity);
			request.setDeathPostalCode(this.deathPostalCode);
			request.setDeathLastName(this.deathLastName);
			request.setDeathFirstNames(this.deathFirstNames);
			request.setRequesterQualityPrecision(this.requesterQualityPrecision);
			request.setRequesterQuality(DeathRequesterQualityType.Enum.forString(this.requesterQuality));
		}
	}
	
	public boolean isComplete() {
		if (this.checkDeathCity() &&
			((this.deathCity == null) || (this.deathCity.length() == 0)))
			return false;
		if (this.checkDeathPostalCode() &&
			((this.deathPostalCode == null) || (this.deathPostalCode.length() == 0)))
			return false;
		if (this.checkDeathLastName() &&
			((this.deathLastName == null) || (this.deathLastName.length() == 0)))
			return false;
		if (this.checkDeathFirstNames() &&
			((this.deathFirstNames == null) || (this.deathFirstNames.length() == 0)))
			return false;
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

	public void setDeathCity(String deathCity) {
		this.deathCity = deathCity;
	}
	
	public String getDeathCity() {
		return this.deathCity;
	}
	
	public boolean checkDeathCity() {
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

	public void setDeathLastName(String deathLastName) {
		this.deathLastName = deathLastName;
	}
	
	public String getDeathLastName() {
		return this.deathLastName;
	}
	
	public boolean checkDeathLastName() {
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
