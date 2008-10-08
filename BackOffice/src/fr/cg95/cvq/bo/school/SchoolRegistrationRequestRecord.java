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

public class SchoolRegistrationRequestRecord extends RequestRecord {

	private String subjectChildLastName;
	private String schoolName;
	private Calendar subjectChildBirthDate;
	private boolean rulesAndRegulationsAcceptance;
	private String section;
	private String urgencyPhone;
	private String currentSchoolAddress;
	private String currentSection;
	private String subjectChildFirstName;
	private String currentSchoolName;

	public SchoolRegistrationRequestRecord() {
		super();
	}
	
	protected Object clone() throws CloneNotSupportedException {
		SchoolRegistrationRequestRecord clonedRecord = (SchoolRegistrationRequestRecord)super.clone();
		return clonedRecord;
	}
	
	public BaseRecord getDataRecord(Long id) {

		if (id.equals(this.getId()))
			return this;
			
		return super.getDataRecord(id);
	}

    public void load(Object xmlRequest) {
        if ((xmlRequest != null) && (xmlRequest instanceof SchoolRegistrationRequest)) {
            SchoolRegistrationRequest request = (SchoolRegistrationRequest)xmlRequest; 

			this.subjectChildLastName = ((Child)request.getSubject()).getLastName();
            if ((request.getSchool() != null))
			this.schoolName = request.getSchool().getName();
			if (((Child)request.getSubject()).getBirthDate() != null) {
				this.subjectChildBirthDate = Calendar.getInstance(); 
	            this.subjectChildBirthDate.setTime(((Child)request.getSubject()).getBirthDate());
			}
            if ((request.getRulesAndRegulationsAcceptance() != null))
			this.rulesAndRegulationsAcceptance = request.getRulesAndRegulationsAcceptance();
			if (request.getSection() != null)
                this.section = getEnumElementTranslation(
                        fr.cg95.cvq.xml.school.SchoolRegistrationRequestDocument.SchoolRegistrationRequest.class.getName(), 
                        "Section", request.getSection().toString());
			this.urgencyPhone = request.getUrgencyPhone();
			this.currentSchoolAddress = request.getCurrentSchoolAddress();
			if (request.getCurrentSection() != null)
                this.currentSection = getEnumElementTranslation(
                        fr.cg95.cvq.xml.school.SchoolRegistrationRequestDocument.SchoolRegistrationRequest.class.getName(), 
                        "CurrentSection", request.getCurrentSection().toString());
			this.subjectChildFirstName = ((Child)request.getSubject()).getFirstName();
			this.currentSchoolName = request.getCurrentSchoolName();
        }
    }
    
    public void saveRequest(Object xmlRequest) {
        if ((xmlRequest != null) && (xmlRequest instanceof SchoolRegistrationRequest)) {
            SchoolRegistrationRequest request = (SchoolRegistrationRequest)xmlRequest; 
        }
    }
    
    public void saveData(Object xmlRequest) {
        if ((xmlRequest != null) && (xmlRequest instanceof SchoolRegistrationRequest)) {
            SchoolRegistrationRequest request = (SchoolRegistrationRequest)xmlRequest; 

            if ((request.getSchool() != null))
			request.getSchool().setName(this.schoolName);
            if ((request.getRulesAndRegulationsAcceptance() != null))
			request.setRulesAndRegulationsAcceptance(this.rulesAndRegulationsAcceptance);
			if (this.section != null)
                request.setSection(
                    SectionType.forString(
                        getEnumKeyTranslation(
                            fr.cg95.cvq.xml.school.SchoolRegistrationRequestDocument.SchoolRegistrationRequest.class.getName(), 
                            "Section", this.section)
                    )
                );
			request.setUrgencyPhone(this.urgencyPhone);
			request.setCurrentSchoolAddress(this.currentSchoolAddress);
			if (this.currentSection != null)
                request.setCurrentSection(
                    SectionType.forString(
                        getEnumKeyTranslation(
                            fr.cg95.cvq.xml.school.SchoolRegistrationRequestDocument.SchoolRegistrationRequest.class.getName(), 
                            "CurrentSection", this.currentSection)
                    )
                );
			request.setCurrentSchoolName(this.currentSchoolName);
        }
    }
    
	public void setSubjectChildLastName(String subjectChildLastName) {
		this.subjectChildLastName = subjectChildLastName;
	}
	
	public String getSubjectChildLastName() {
		return this.subjectChildLastName;
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

	public void setRulesAndRegulationsAcceptance(boolean rulesAndRegulationsAcceptance) {
		this.rulesAndRegulationsAcceptance = rulesAndRegulationsAcceptance;
	}
	
	public boolean getRulesAndRegulationsAcceptance() {
		return this.rulesAndRegulationsAcceptance;
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

	public void setCurrentSchoolAddress(String currentSchoolAddress) {
		this.currentSchoolAddress = currentSchoolAddress;
	}
	
	public String getCurrentSchoolAddress() {
		return this.currentSchoolAddress;
	}

	public void setCurrentSection(String currentSection) {
		this.currentSection = currentSection;
	}
	
	public String getCurrentSection() {
		return this.currentSection;
	}

	public void setSubjectChildFirstName(String subjectChildFirstName) {
		this.subjectChildFirstName = subjectChildFirstName;
	}
	
	public String getSubjectChildFirstName() {
		return this.subjectChildFirstName;
	}

	public void setCurrentSchoolName(String currentSchoolName) {
		this.currentSchoolName = currentSchoolName;
	}
	
	public String getCurrentSchoolName() {
		return this.currentSchoolName;
	}

}

