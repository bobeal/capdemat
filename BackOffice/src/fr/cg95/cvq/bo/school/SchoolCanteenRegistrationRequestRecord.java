package fr.cg95.cvq.bo.school;

import java.util.Calendar;
import java.util.List;
import java.util.Set;
import java.util.Vector;

import fr.cg95.cvq.wizard.*;
import fr.cg95.cvq.bo.record.BaseRecord;
import fr.cg95.cvq.bo.record.RequestRecord;
import fr.cg95.cvq.business.authority.*;
import fr.cg95.cvq.business.users.*;
import fr.cg95.cvq.business.school.*;

public class SchoolCanteenRegistrationRequestRecord extends RequestRecord {

	private boolean rulesAndRegulationsAcceptance;
	private boolean[] foodDiet;
   	private List foodDietList;
	private String doctorPhone;
	private String subjectChildFirstName;
	private String doctorName;
	private boolean[] canteenAttendingDays;
   	private List canteenAttendingDaysList;
	private boolean hospitalizationPermission;
	private String subjectChildLastName;
	private boolean foodAllergy;
	private String section;
	private String urgencyPhone;
	private String schoolName;
	private Calendar subjectChildBirthDate;

	public SchoolCanteenRegistrationRequestRecord() {
		super();
	}
	
	protected Object clone() throws CloneNotSupportedException {
		SchoolCanteenRegistrationRequestRecord clonedRecord = (SchoolCanteenRegistrationRequestRecord)super.clone();
		clonedRecord.foodDiet = (boolean[])this.foodDiet.clone();
		clonedRecord.canteenAttendingDays = (boolean[])this.canteenAttendingDays.clone();
		return clonedRecord;
	}
	
	public BaseRecord getDataRecord(Long id) {

		if (id.equals(this.getId()))
			return this;
			
		return super.getDataRecord(id);
	}

    public void load(Object xmlRequest) {
        if ((xmlRequest != null) && (xmlRequest instanceof SchoolCanteenRegistrationRequest)) {
            SchoolCanteenRegistrationRequest request = (SchoolCanteenRegistrationRequest)xmlRequest; 

            if ((request.getRulesAndRegulationsAcceptance() != null))
			this.rulesAndRegulationsAcceptance = request.getRulesAndRegulationsAcceptance();
            this.setFoodDiet(this.getList("FoodDiet"), request.getFoodDiet());
			this.doctorPhone = request.getDoctorPhone();
			this.subjectChildFirstName = ((Child)request.getSubject()).getFirstName();
			this.doctorName = request.getDoctorName();
            this.setCanteenAttendingDays(this.getList("CanteenAttendingDays"), request.getCanteenAttendingDays());
            if ((request.getHospitalizationPermission() != null))
			this.hospitalizationPermission = request.getHospitalizationPermission();
			this.subjectChildLastName = ((Child)request.getSubject()).getLastName();
            if ((request.getFoodAllergy() != null))
			this.foodAllergy = request.getFoodAllergy();
			if (request.getSection() != null)
                this.section = getEnumElementTranslation(
                        fr.cg95.cvq.xml.school.SchoolCanteenRegistrationRequestDocument.SchoolCanteenRegistrationRequest.class.getName(), 
                        "Section", request.getSection().toString());
			this.urgencyPhone = request.getUrgencyPhone();
            if ((request.getSchool() != null))
			this.schoolName = request.getSchool().getName();
			if (((Child)request.getSubject()).getBirthDate() != null) {
				this.subjectChildBirthDate = Calendar.getInstance(); 
	            this.subjectChildBirthDate.setTime(((Child)request.getSubject()).getBirthDate());
			}
        }
    }
    
    public void saveRequest(Object xmlRequest) {
        if ((xmlRequest != null) && (xmlRequest instanceof SchoolCanteenRegistrationRequest)) {
            SchoolCanteenRegistrationRequest request = (SchoolCanteenRegistrationRequest)xmlRequest; 
        }
    }
    
    public void saveData(Object xmlRequest) {
        if ((xmlRequest != null) && (xmlRequest instanceof SchoolCanteenRegistrationRequest)) {
            SchoolCanteenRegistrationRequest request = (SchoolCanteenRegistrationRequest)xmlRequest; 

            if ((request.getRulesAndRegulationsAcceptance() != null))
			request.setRulesAndRegulationsAcceptance(this.rulesAndRegulationsAcceptance);
			request.setFoodDiet(this.getFoodDietKeys());
			request.setDoctorPhone(this.doctorPhone);
			request.setDoctorName(this.doctorName);
			request.setCanteenAttendingDays(this.getCanteenAttendingDaysKeys());
            if ((request.getHospitalizationPermission() != null))
			request.setHospitalizationPermission(this.hospitalizationPermission);
            if ((request.getFoodAllergy() != null))
			request.setFoodAllergy(this.foodAllergy);
			request.setUrgencyPhone(this.urgencyPhone);
        }
    }
    
	public void setRulesAndRegulationsAcceptance(boolean rulesAndRegulationsAcceptance) {
		this.rulesAndRegulationsAcceptance = rulesAndRegulationsAcceptance;
	}
	
	public boolean getRulesAndRegulationsAcceptance() {
		return this.rulesAndRegulationsAcceptance;
	}

	public void setFoodDiet(List referential, Set values) {
		if (referential != null) {
			this.foodDiet = new boolean[referential.size()];
			this.foodDietList = referential;
			
			if (values != null) {
				for (int i = 0; i < foodDiet.length; i++) {
					String key = ((ReferentialData)foodDietList.get(i)).getKey();
					foodDiet[i] = containsRefData(values, key);
				}
			}
		}
	}
	
	public List getFoodDietList() {
		return this.foodDietList;
	}
	
	public Set getFoodDietKeys() {
		return getRefDataSet(foodDiet, foodDietList);
	}

	public String[] getFoodDiet() {
		Vector values = new Vector();
		
		for (int i = 0; i < foodDiet.length; i++) {
			if (foodDiet[i]) {
				values.add(((ReferentialData)foodDietList.get(i)).getValue());
			}
		}

		String[] value = new String[values.size()];
		for (int i = 0; i < values.size(); i++)
			value[i] = (String)values.get(i);

		return value;
	}

	public void setFoodDiet(String[] value) {
		String values = "";
		for (int i = 0; i < value.length; i++)
			values += "<" + value[i] + ">";
		
		for (int i = 0; i < foodDiet.length; i++) {
			foodDiet[i] = values.indexOf("<" + ((ReferentialData)foodDietList.get(i)).getValue() + ">") != -1;
		}
	}
	public void setDoctorPhone(String doctorPhone) {
		this.doctorPhone = doctorPhone;
	}
	
	public String getDoctorPhone() {
		return this.doctorPhone;
	}

	public void setSubjectChildFirstName(String subjectChildFirstName) {
		this.subjectChildFirstName = subjectChildFirstName;
	}
	
	public String getSubjectChildFirstName() {
		return this.subjectChildFirstName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
	
	public String getDoctorName() {
		return this.doctorName;
	}

	public void setCanteenAttendingDays(List referential, Set values) {
		if (referential != null) {
			this.canteenAttendingDays = new boolean[referential.size()];
			this.canteenAttendingDaysList = referential;
			
			if (values != null) {
				for (int i = 0; i < canteenAttendingDays.length; i++) {
					String key = ((ReferentialData)canteenAttendingDaysList.get(i)).getKey();
					canteenAttendingDays[i] = containsRefData(values, key);
				}
			}
		}
	}
	
	public List getCanteenAttendingDaysList() {
		return this.canteenAttendingDaysList;
	}
	
	public Set getCanteenAttendingDaysKeys() {
		return getRefDataSet(canteenAttendingDays, canteenAttendingDaysList);
	}

	public String[] getCanteenAttendingDays() {
		Vector values = new Vector();
		
		for (int i = 0; i < canteenAttendingDays.length; i++) {
			if (canteenAttendingDays[i]) {
				values.add(((ReferentialData)canteenAttendingDaysList.get(i)).getValue());
			}
		}

		String[] value = new String[values.size()];
		for (int i = 0; i < values.size(); i++)
			value[i] = (String)values.get(i);

		return value;
	}

	public void setCanteenAttendingDays(String[] value) {
		String values = "";
		for (int i = 0; i < value.length; i++)
			values += "<" + value[i] + ">";
		
		for (int i = 0; i < canteenAttendingDays.length; i++) {
			canteenAttendingDays[i] = values.indexOf("<" + ((ReferentialData)canteenAttendingDaysList.get(i)).getValue() + ">") != -1;
		}
	}
	public void setHospitalizationPermission(boolean hospitalizationPermission) {
		this.hospitalizationPermission = hospitalizationPermission;
	}
	
	public boolean getHospitalizationPermission() {
		return this.hospitalizationPermission;
	}

	public void setSubjectChildLastName(String subjectChildLastName) {
		this.subjectChildLastName = subjectChildLastName;
	}
	
	public String getSubjectChildLastName() {
		return this.subjectChildLastName;
	}

	public void setFoodAllergy(boolean foodAllergy) {
		this.foodAllergy = foodAllergy;
	}
	
	public boolean getFoodAllergy() {
		return this.foodAllergy;
	}

	public void setSection(String section) {
		this.section = section;
	}
	
	public String getSection() {
		return this.section;
	}

	public void setUrgencyPhone(String urgencyPhone) {
		this.urgencyPhone = urgencyPhone;
	}
	
	public String getUrgencyPhone() {
		return this.urgencyPhone;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}
	
	public String getSchoolName() {
		return this.schoolName;
	}

	public void setSubjectChildBirthDate(Calendar subjectChildBirthDate) {
		this.subjectChildBirthDate = subjectChildBirthDate;
	}
	
	public Calendar getSubjectChildBirthDate() {
		return this.subjectChildBirthDate;
	}

}

