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

	private String deathFirstNames;
	private String deathCity;
	private String deathLastName;
	private Calendar deathDate;
	private String deathPostalCode;

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
			this.deathFirstNames = request.getDeathFirstNames();
			this.deathCity = request.getDeathCity();
			this.deathLastName = request.getDeathLastName();
			this.deathDate = request.getDeathDate();
			this.deathPostalCode = request.getDeathPostalCode();
		}
	}
	
	public void save(HttpSession session, Object xmlbRequest) {
		if ((xmlbRequest != null) && (xmlbRequest instanceof DeathDetailsRequest)) {
			DeathDetailsRequest request = (DeathDetailsRequest)xmlbRequest;
			request.setDeathFirstNames(this.deathFirstNames);
			request.setDeathCity(this.deathCity);
			request.setDeathLastName(this.deathLastName);
			request.setDeathDate(this.deathDate);
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
		if (this.checkDeathLastName() &&
			((this.deathLastName == null) || (this.deathLastName.length() == 0)))
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

	public void setDeathLastName(String deathLastName) {
		this.deathLastName = deathLastName;
	}
	
	public String getDeathLastName() {
		return this.deathLastName;
	}
	
	public boolean checkDeathLastName() {
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
