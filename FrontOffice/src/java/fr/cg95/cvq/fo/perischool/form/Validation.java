package fr.cg95.cvq.fo.perischool.form;

import java.util.Calendar;
import java.util.Collection;
import java.util.List;
import javax.servlet.http.HttpSession;
import fr.cg95.cvq.wizard.*;
import fr.cg95.cvq.xml.common.*;
import fr.cg95.cvq.xml.school.*;
import fr.cg95.cvq.xml.school.PerischoolActivityRegistrationRequestDocument.PerischoolActivityRegistrationRequest;

public class Validation extends IStageForm {

	private String subjectChildLastName;
	private Calendar subjectChildBirthDate;
	private boolean rulesAndRegulationsAcceptance;
	private boolean[] perischoolActivity;
	private boolean childPhotoExploitationPermission;
	private boolean classTripPermission;
	private String urgencyPhone;
	private boolean hospitalizationPermission;
	private String subjectChildFirstName;

	public Validation() {
		super();
	}
	
	public void reset(String state) {
		if (state.equals("summary")) {
		}
	}
	
	public void load(HttpSession session, Object xmlbRequest) {
		if ((xmlbRequest != null) && (xmlbRequest instanceof PerischoolActivityRegistrationRequest)) {
			PerischoolActivityRegistrationRequest request = (PerischoolActivityRegistrationRequest)xmlbRequest;
			this.subjectChildLastName = request.getSubject().getChild().getLastName();
			this.subjectChildBirthDate = request.getSubject().getChild().getBirthDate();
			this.rulesAndRegulationsAcceptance = request.getRulesAndRegulationsAcceptance();
			this.perischoolActivity = loadForm(this.perischoolActivity,(Collection)session.getAttribute("activityList"),request.getPerischoolActivityArray());
			this.childPhotoExploitationPermission = request.getChildPhotoExploitationPermission();
			this.classTripPermission = request.getClassTripPermission();
			this.urgencyPhone = request.getUrgencyPhone();
			this.hospitalizationPermission = request.getHospitalizationPermission();
			this.subjectChildFirstName = request.getSubject().getChild().getFirstName();
		}
	}
	
	public void save(HttpSession session, Object xmlbRequest) {
		if ((xmlbRequest != null) && (xmlbRequest instanceof PerischoolActivityRegistrationRequest)) {
			PerischoolActivityRegistrationRequest request = (PerischoolActivityRegistrationRequest)xmlbRequest;
			request.getSubject().getChild().setLastName(this.subjectChildLastName);
			request.getSubject().getChild().setBirthDate(this.subjectChildBirthDate);
			request.setRulesAndRegulationsAcceptance(this.rulesAndRegulationsAcceptance);
			request.setPerischoolActivityArray(saveForm(this.perischoolActivity,(Collection)session.getAttribute("activityList")));
			request.setChildPhotoExploitationPermission(this.childPhotoExploitationPermission);
			request.setClassTripPermission(this.classTripPermission);
			request.setUrgencyPhone(this.urgencyPhone);
			request.setHospitalizationPermission(this.hospitalizationPermission);
			request.getSubject().getChild().setFirstName(this.subjectChildFirstName);
		}
	}
	
	public boolean isComplete() {
		if (this.checkSubjectChildLastName() &&
			((this.subjectChildLastName == null) || (this.subjectChildLastName.length() == 0)))
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

	public void setPerischoolActivity(boolean[] perischoolActivity) {
		this.perischoolActivity = perischoolActivity;
	}
	
	public boolean[] getPerischoolActivity() {
		return this.perischoolActivity;
	}
	
	public boolean checkPerischoolActivity() {
		return true;
	}

	public void setPerischoolActivity(int i, boolean perischoolActivity) {
		this.perischoolActivity[i] = perischoolActivity;
	}
	
	public boolean getPerischoolActivity(int i) {
		return this.perischoolActivity[i];
	}
	
	public int getSizeOfPerischoolActivity() {
        return this.perischoolActivity.length;
    }
    
    public void setSizeOfPerischoolActivity(int size) {
        this.perischoolActivity = new boolean[size];
    }
    
    public int getNbSelectedPerischoolActivity() {
        int count = 0;
        for (int i = 0; i < perischoolActivity.length; i++)
            if (perischoolActivity[i])
                count++;
        return count;
    }

	public void setChildPhotoExploitationPermission(boolean childPhotoExploitationPermission) {
		this.childPhotoExploitationPermission = childPhotoExploitationPermission;
	}
	
	public boolean getChildPhotoExploitationPermission() {
		return this.childPhotoExploitationPermission;
	}
	
	public boolean checkChildPhotoExploitationPermission() {
		return true;
	}

	public void setClassTripPermission(boolean classTripPermission) {
		this.classTripPermission = classTripPermission;
	}
	
	public boolean getClassTripPermission() {
		return this.classTripPermission;
	}
	
	public boolean checkClassTripPermission() {
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

	public void setHospitalizationPermission(boolean hospitalizationPermission) {
		this.hospitalizationPermission = hospitalizationPermission;
	}
	
	public boolean getHospitalizationPermission() {
		return this.hospitalizationPermission;
	}
	
	public boolean checkHospitalizationPermission() {
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

}