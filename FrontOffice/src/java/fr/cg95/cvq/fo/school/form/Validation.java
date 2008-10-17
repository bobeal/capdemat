package fr.cg95.cvq.fo.school.form;

import java.util.Calendar;
import java.util.Collection;
import java.util.List;
import javax.servlet.http.HttpSession;
import fr.cg95.cvq.wizard.*;
import fr.cg95.cvq.xml.common.*;
import fr.cg95.cvq.xml.school.*;
import fr.cg95.cvq.xml.school.SchoolRegistrationRequestDocument.SchoolRegistrationRequest;

public class Validation extends IStageForm {

	private String subjectChildLastName;
	private Calendar subjectChildBirthDate;
	private boolean rulesAndRegulationsAcceptance;
	private String section;
	private String urgencyPhone;
	private String currentSchoolAddress;
	private String currentSection;
	private String subjectChildFirstName;
	private String currentSchoolName;

	public Validation() {
		super();
	}
	
	public void reset(String state) {
		if (state.equals("summary")) {
		}
	}
	
	public void load(HttpSession session, Object xmlbRequest) {
		if ((xmlbRequest != null) && (xmlbRequest instanceof SchoolRegistrationRequest)) {
			SchoolRegistrationRequest request = (SchoolRegistrationRequest)xmlbRequest;
			this.subjectChildLastName = request.getSubject().getChild().getLastName();
			this.subjectChildBirthDate = request.getSubject().getChild().getBirthDate();
			this.rulesAndRegulationsAcceptance = request.getRulesAndRegulationsAcceptance();
			if (request.getSection() != null)
			this.section = request.getSection().toString();
			this.urgencyPhone = request.getUrgencyPhone();
			this.currentSchoolAddress = request.getCurrentSchoolAddress();
			if (request.getCurrentSection() != null)
			this.currentSection = request.getCurrentSection().toString();
			this.subjectChildFirstName = request.getSubject().getChild().getFirstName();
			this.currentSchoolName = request.getCurrentSchoolName();
		}
	}
	
	public void save(HttpSession session, Object xmlbRequest) {
		if ((xmlbRequest != null) && (xmlbRequest instanceof SchoolRegistrationRequest)) {
			SchoolRegistrationRequest request = (SchoolRegistrationRequest)xmlbRequest;
			request.getSubject().getChild().setLastName(this.subjectChildLastName);
			request.getSubject().getChild().setBirthDate(this.subjectChildBirthDate);
			request.setRulesAndRegulationsAcceptance(this.rulesAndRegulationsAcceptance);
			request.setSection(SectionType.Enum.forString(this.section));
			request.setUrgencyPhone(this.urgencyPhone);
			request.setCurrentSchoolAddress(this.currentSchoolAddress);
			request.setCurrentSection(SectionType.Enum.forString(this.currentSection));
			request.getSubject().getChild().setFirstName(this.subjectChildFirstName);
			request.setCurrentSchoolName(this.currentSchoolName);
		}
	}
	
	public boolean isComplete() {
		if (this.checkSubjectChildLastName() &&
			((this.subjectChildLastName == null) || (this.subjectChildLastName.length() == 0)))
			return false;
		if (this.checkSection() &&
			((this.section == null) || (this.section.length() == 0)))
			return false;
		if (this.checkUrgencyPhone() &&
			((this.urgencyPhone == null) || (this.urgencyPhone.length() == 0)))
			return false;
		if (this.checkSubjectChildFirstName() &&
			((this.subjectChildFirstName == null) || (this.subjectChildFirstName.length() == 0)))
			return false;
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

	public void setRulesAndRegulationsAcceptance(boolean rulesAndRegulationsAcceptance) {
		this.rulesAndRegulationsAcceptance = rulesAndRegulationsAcceptance;
	}
	
	public boolean getRulesAndRegulationsAcceptance() {
		return this.rulesAndRegulationsAcceptance;
	}
	
	public boolean checkRulesAndRegulationsAcceptance() {
		return true;
	}

	public void setSection(String section) {
		this.section = section;
	}
	
	public String getSection() {
		return this.section;
	}
	
	public boolean checkSection() {
		return true;
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

	public void setCurrentSchoolAddress(String currentSchoolAddress) {
		this.currentSchoolAddress = currentSchoolAddress;
	}
	
	public String getCurrentSchoolAddress() {
		return this.currentSchoolAddress;
	}
	
	public boolean checkCurrentSchoolAddress() {
		return true;
	}

	public void setCurrentSection(String currentSection) {
		this.currentSection = currentSection;
	}
	
	public String getCurrentSection() {
		return this.currentSection;
	}
	
	public boolean checkCurrentSection() {
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

	public void setCurrentSchoolName(String currentSchoolName) {
		this.currentSchoolName = currentSchoolName;
	}
	
	public String getCurrentSchoolName() {
		return this.currentSchoolName;
	}
	
	public boolean checkCurrentSchoolName() {
		return true;
	}

}