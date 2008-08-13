package fr.cg95.cvq.fo.citizen.form;

import java.util.Calendar;
import java.util.Collection;
import java.util.List;
import javax.servlet.http.HttpSession;
import fr.cg95.cvq.wizard.*;
import fr.cg95.cvq.xml.common.*;
import fr.cg95.cvq.xml.ecitizen.*;
import fr.cg95.cvq.xml.ecitizen.VoCardRequestDocument.VoCardRequest;

public class Child extends IStageForm {

	private String childFirstName2;
	private String childLastName;
	private String childBirthPlaceCity;
	private long childId;
	private boolean[] childAdult;
	private String childBirthPlacePostalCode;
	private Calendar childBirthDate;
	private String childFirstName;
	private List childLegalResponsible;
	private String childFirstName3;
	private String childBirthPlaceCountry;
	private String childSex;

	public Child() {
		super();
	}
	
	public void reset(String state) {
		if (state.equals("display")) {
		}
		if (state.equals("child")) {
		}
		if (state.equals("legal")) {
			for (int i = 0; i < this.childAdult.length; i++)
				this.childAdult[i] = false;
		}
	}
	
	public void load(HttpSession session, Object xmlbRequest) {
		if ((xmlbRequest != null) && (xmlbRequest instanceof VoCardRequest)) {
			VoCardRequest request = (VoCardRequest)xmlbRequest;
			this.childAdult = loadForm(this.childAdult,(Collection)session.getAttribute("adults"),null);
		}
	}
	
	public void save(HttpSession session, Object xmlbRequest) {
		if ((xmlbRequest != null) && (xmlbRequest instanceof VoCardRequest)) {
			VoCardRequest request = (VoCardRequest)xmlbRequest;
		}
	}
	
	public boolean isComplete() {
		if (this.checkChildLastName() &&
			((this.childLastName == null) || (this.childLastName.length() == 0)))
			return false;
		if (this.checkChildFirstName() &&
			((this.childFirstName == null) || (this.childFirstName.length() == 0)))
			return false;
		if (this.checkChildSex() &&
			((this.childSex == null) || (this.childSex.length() == 0)))
			return false;
		return true;
	}
	
	public void setChildFirstName2(String childFirstName2) {
		this.childFirstName2 = childFirstName2;
	}
	
	public String getChildFirstName2() {
		return this.childFirstName2;
	}
	
	public boolean checkChildFirstName2() {
		return true;
	}

	public void setChildLastName(String childLastName) {
		this.childLastName = childLastName;
	}
	
	public String getChildLastName() {
		return this.childLastName;
	}
	
	public boolean checkChildLastName() {
		return true;
	}

	public void setChildBirthPlaceCity(String childBirthPlaceCity) {
		this.childBirthPlaceCity = childBirthPlaceCity;
	}
	
	public String getChildBirthPlaceCity() {
		return this.childBirthPlaceCity;
	}
	
	public boolean checkChildBirthPlaceCity() {
		return true;
	}

	public void setChildId(long childId) {
		this.childId = childId;
	}
	
	public long getChildId() {
		return this.childId;
	}
	
	public boolean checkChildId() {
		return true;
	}

	public void setChildAdult(boolean[] childAdult) {
		this.childAdult = childAdult;
	}
	
	public boolean[] getChildAdult() {
		return this.childAdult;
	}
	
	public boolean checkChildAdult() {
		return true;
	}

	public void setChildAdult(int i, boolean childAdult) {
		this.childAdult[i] = childAdult;
	}
	
	public boolean getChildAdult(int i) {
		return this.childAdult[i];
	}
	
	public int getSizeOfChildAdult() {
        return this.childAdult.length;
    }
    
    public void setSizeOfChildAdult(int size) {
        this.childAdult = new boolean[size];
    }
    
    public int getNbSelectedChildAdult() {
        int count = 0;
        for (int i = 0; i < childAdult.length; i++)
            if (childAdult[i])
                count++;
        return count;
    }

	public void setChildBirthPlacePostalCode(String childBirthPlacePostalCode) {
		this.childBirthPlacePostalCode = childBirthPlacePostalCode;
	}
	
	public String getChildBirthPlacePostalCode() {
		return this.childBirthPlacePostalCode;
	}
	
	public boolean checkChildBirthPlacePostalCode() {
		return true;
	}

	public void setChildBirthDate(Calendar childBirthDate) {
		this.childBirthDate = childBirthDate;
	}
	
	public Calendar getChildBirthDate() {
		return this.childBirthDate;
	}
	
	public boolean checkChildBirthDate() {
		return true;
	}

	public void setChildFirstName(String childFirstName) {
		this.childFirstName = childFirstName;
	}
	
	public String getChildFirstName() {
		return this.childFirstName;
	}
	
	public boolean checkChildFirstName() {
		return true;
	}

	public void setChildLegalResponsible(List childLegalResponsible) {
		this.childLegalResponsible = childLegalResponsible;
	}
	
	public List getChildLegalResponsible() {
		return this.childLegalResponsible;
	}
	
	public boolean checkChildLegalResponsible() {
		return true;
	}

    public int getSizeOfChildLegalResponsible() {
        return this.childLegalResponsible.size();
    }

	public void setChildFirstName3(String childFirstName3) {
		this.childFirstName3 = childFirstName3;
	}
	
	public String getChildFirstName3() {
		return this.childFirstName3;
	}
	
	public boolean checkChildFirstName3() {
		return true;
	}

	public void setChildBirthPlaceCountry(String childBirthPlaceCountry) {
		this.childBirthPlaceCountry = childBirthPlaceCountry;
	}
	
	public String getChildBirthPlaceCountry() {
		return this.childBirthPlaceCountry;
	}
	
	public boolean checkChildBirthPlaceCountry() {
		return true;
	}

	public void setChildSex(String childSex) {
		this.childSex = childSex;
	}
	
	public String getChildSex() {
		return this.childSex;
	}
	
	public boolean checkChildSex() {
		return true;
	}

}
