package fr.cg95.cvq.fo.schoolcanteen.form;

import java.util.Calendar;
import java.util.Collection;
import java.util.List;
import javax.servlet.http.HttpSession;
import fr.cg95.cvq.wizard.*;
import fr.cg95.cvq.xml.common.*;
import fr.cg95.cvq.xml.school.*;
import fr.cg95.cvq.xml.school.SchoolCanteenRegistrationRequestDocument.SchoolCanteenRegistrationRequest;

public class Validation extends IStageForm {

	private boolean rulesAndRegulationsAcceptance;
	private boolean[] foodDiet;
	private String urgencyPhone;
	private String subjectChildFirstName;
	private String doctorPhone;
	private String doctorName;
	private boolean[] canteenAttendingDays;
	private boolean hospitalizationPermission;
	private String subjectChildLastName;
	private Calendar subjectChildBirthDate;
	private boolean foodAllergy;

	public Validation() {
		super();
	}
	
	public void reset(String state) {
		if (state.equals("summary")) {
		}
	}
	
	public void load(HttpSession session, Object xmlbRequest) {
		if ((xmlbRequest != null) && (xmlbRequest instanceof SchoolCanteenRegistrationRequest)) {
			SchoolCanteenRegistrationRequest request = (SchoolCanteenRegistrationRequest)xmlbRequest;
			this.rulesAndRegulationsAcceptance = request.getRulesAndRegulationsAcceptance();
			this.foodDiet = loadForm(this.foodDiet,(Collection)session.getAttribute("FoodDiet"),request.getFoodDietArray());
			this.urgencyPhone = request.getUrgencyPhone();
			this.subjectChildFirstName = request.getSubject().getChild().getFirstName();
			this.doctorPhone = request.getDoctorPhone();
			this.doctorName = request.getDoctorName();
			this.canteenAttendingDays = loadForm(this.canteenAttendingDays,(Collection)session.getAttribute("CanteenAttendingDays"),request.getCanteenAttendingDaysArray());
			this.hospitalizationPermission = request.getHospitalizationPermission();
			this.subjectChildLastName = request.getSubject().getChild().getLastName();
			this.subjectChildBirthDate = request.getSubject().getChild().getBirthDate();
			this.foodAllergy = request.getFoodAllergy();
		}
	}
	
	public void save(HttpSession session, Object xmlbRequest) {
		if ((xmlbRequest != null) && (xmlbRequest instanceof SchoolCanteenRegistrationRequest)) {
			SchoolCanteenRegistrationRequest request = (SchoolCanteenRegistrationRequest)xmlbRequest;
			request.setRulesAndRegulationsAcceptance(this.rulesAndRegulationsAcceptance);
			request.setFoodDietArray(saveForm(this.foodDiet,(Collection)session.getAttribute("FoodDiet")));
			request.setUrgencyPhone(this.urgencyPhone);
			request.getSubject().getChild().setFirstName(this.subjectChildFirstName);
			request.setDoctorPhone(this.doctorPhone);
			request.setDoctorName(this.doctorName);
			request.setCanteenAttendingDaysArray(saveForm(this.canteenAttendingDays,(Collection)session.getAttribute("CanteenAttendingDays")));
			request.setHospitalizationPermission(this.hospitalizationPermission);
			request.getSubject().getChild().setLastName(this.subjectChildLastName);
			request.getSubject().getChild().setBirthDate(this.subjectChildBirthDate);
			request.setFoodAllergy(this.foodAllergy);
		}
	}
	
	public boolean isComplete() {
		if (this.checkUrgencyPhone() &&
			((this.urgencyPhone == null) || (this.urgencyPhone.length() == 0)))
			return false;
		if (this.checkSubjectChildFirstName() &&
			((this.subjectChildFirstName == null) || (this.subjectChildFirstName.length() == 0)))
			return false;
		if (this.checkSubjectChildLastName() &&
			((this.subjectChildLastName == null) || (this.subjectChildLastName.length() == 0)))
			return false;
		return true;
	}
	
	public void setRulesAndRegulationsAcceptance(boolean rulesAndRegulationsAcceptance) {
		this.rulesAndRegulationsAcceptance = rulesAndRegulationsAcceptance;
	}
	
	public boolean getRulesAndRegulationsAcceptance() {
		return this.rulesAndRegulationsAcceptance;
	}
	
	public boolean checkRulesAndRegulationsAcceptance() {
		return true;
	}

	public void setFoodDiet(boolean[] foodDiet) {
		this.foodDiet = foodDiet;
	}
	
	public boolean[] getFoodDiet() {
		return this.foodDiet;
	}
	
	public boolean checkFoodDiet() {
		return true;
	}

	public void setFoodDiet(int i, boolean foodDiet) {
		this.foodDiet[i] = foodDiet;
	}
	
	public boolean getFoodDiet(int i) {
		return this.foodDiet[i];
	}
	
	public int getSizeOfFoodDiet() {
        return this.foodDiet.length;
    }
    
    public void setSizeOfFoodDiet(int size) {
        this.foodDiet = new boolean[size];
    }
    
    public int getNbSelectedFoodDiet() {
        int count = 0;
        for (int i = 0; i < foodDiet.length; i++)
            if (foodDiet[i])
                count++;
        return count;
    }

	public void setUrgencyPhone(String urgencyPhone) {
		this.urgencyPhone = urgencyPhone;
	}
	
	public String getUrgencyPhone() {
		return this.urgencyPhone;
	}
	
	public boolean checkUrgencyPhone() {
		return true;
	}

	public void setSubjectChildFirstName(String subjectChildFirstName) {
		this.subjectChildFirstName = subjectChildFirstName;
	}
	
	public String getSubjectChildFirstName() {
		return this.subjectChildFirstName;
	}
	
	public boolean checkSubjectChildFirstName() {
		return true;
	}

	public void setDoctorPhone(String doctorPhone) {
		this.doctorPhone = doctorPhone;
	}
	
	public String getDoctorPhone() {
		return this.doctorPhone;
	}
	
	public boolean checkDoctorPhone() {
		return true;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
	
	public String getDoctorName() {
		return this.doctorName;
	}
	
	public boolean checkDoctorName() {
		return true;
	}

	public void setCanteenAttendingDays(boolean[] canteenAttendingDays) {
		this.canteenAttendingDays = canteenAttendingDays;
	}
	
	public boolean[] getCanteenAttendingDays() {
		return this.canteenAttendingDays;
	}
	
	public boolean checkCanteenAttendingDays() {
		return true;
	}

	public void setCanteenAttendingDays(int i, boolean canteenAttendingDays) {
		this.canteenAttendingDays[i] = canteenAttendingDays;
	}
	
	public boolean getCanteenAttendingDays(int i) {
		return this.canteenAttendingDays[i];
	}
	
	public int getSizeOfCanteenAttendingDays() {
        return this.canteenAttendingDays.length;
    }
    
    public void setSizeOfCanteenAttendingDays(int size) {
        this.canteenAttendingDays = new boolean[size];
    }
    
    public int getNbSelectedCanteenAttendingDays() {
        int count = 0;
        for (int i = 0; i < canteenAttendingDays.length; i++)
            if (canteenAttendingDays[i])
                count++;
        return count;
    }

	public void setHospitalizationPermission(boolean hospitalizationPermission) {
		this.hospitalizationPermission = hospitalizationPermission;
	}
	
	public boolean getHospitalizationPermission() {
		return this.hospitalizationPermission;
	}
	
	public boolean checkHospitalizationPermission() {
		return true;
	}

	public void setSubjectChildLastName(String subjectChildLastName) {
		this.subjectChildLastName = subjectChildLastName;
	}
	
	public String getSubjectChildLastName() {
		return this.subjectChildLastName;
	}
	
	public boolean checkSubjectChildLastName() {
		return true;
	}

	public void setSubjectChildBirthDate(Calendar subjectChildBirthDate) {
		this.subjectChildBirthDate = subjectChildBirthDate;
	}
	
	public Calendar getSubjectChildBirthDate() {
		return this.subjectChildBirthDate;
	}
	
	public boolean checkSubjectChildBirthDate() {
		return true;
	}

	public void setFoodAllergy(boolean foodAllergy) {
		this.foodAllergy = foodAllergy;
	}
	
	public boolean getFoodAllergy() {
		return this.foodAllergy;
	}
	
	public boolean checkFoodAllergy() {
		return true;
	}

}
