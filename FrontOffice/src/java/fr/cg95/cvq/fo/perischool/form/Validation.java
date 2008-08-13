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

	private boolean classTripPermission;
	private boolean childPhotoExploitationPermission;
	private boolean rulesAndRegulationsAcceptance;
	private String urgencyPhone;
	private String subjectChildFirstName;
	private boolean hospitalizationPermission;
	private String subjectChildLastName;
	private Calendar subjectChildBirthDate;
	private boolean[] perischoolActivity;

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
			this.classTripPermission = request.getClassTripPermission();
			this.childPhotoExploitationPermission = request.getChildPhotoExploitationPermission();
			this.rulesAndRegulationsAcceptance = request.getRulesAndRegulationsAcceptance();
			this.urgencyPhone = request.getUrgencyPhone();
			this.subjectChildFirstName = request.getSubject().getChild().getFirstName();
			this.hospitalizationPermission = request.getHospitalizationPermission();
			this.subjectChildLastName = request.getSubject().getChild().getLastName();
			this.subjectChildBirthDate = request.getSubject().getChild().getBirthDate();
			this.perischoolActivity = loadForm(this.perischoolActivity,(Collection)session.getAttribute("activityList"),request.getPerischoolActivityArray());
		}
	}
	
	public void save(HttpSession session, Object xmlbRequest) {
		if ((xmlbRequest != null) && (xmlbRequest instanceof PerischoolActivityRegistrationRequest)) {
			PerischoolActivityRegistrationRequest request = (PerischoolActivityRegistrationRequest)xmlbRequest;
			request.setClassTripPermission(this.classTripPermission);
			request.setChildPhotoExploitationPermission(this.childPhotoExploitationPermission);
			request.setRulesAndRegulationsAcceptance(this.rulesAndRegulationsAcceptance);
			request.setUrgencyPhone(this.urgencyPhone);
			request.getSubject().getChild().setFirstName(this.subjectChildFirstName);
			request.setHospitalizationPermission(this.hospitalizationPermission);
			request.getSubject().getChild().setLastName(this.subjectChildLastName);
			request.getSubject().getChild().setBirthDate(this.subjectChildBirthDate);
			request.setPerischoolActivityArray(saveForm(this.perischoolActivity,(Collection)session.getAttribute("activityList")));
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
	
	public void setClassTripPermission(boolean classTripPermission) {
		this.classTripPermission = classTripPermission;
	}
	
	public boolean getClassTripPermission() {
		return this.classTripPermission;
	}
	
	public boolean checkClassTripPermission() {
		return true;
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

	public void setRulesAndRegulationsAcceptance(boolean rulesAndRegulationsAcceptance) {
		this.rulesAndRegulationsAcceptance = rulesAndRegulationsAcceptance;
	}
	
	public boolean getRulesAndRegulationsAcceptance() {
		return this.rulesAndRegulationsAcceptance;
	}
	
	public boolean checkRulesAndRegulationsAcceptance() {
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

	public void setSubjectChildFirstName(String subjectChildFirstName) {
		this.subjectChildFirstName = subjectChildFirstName;
	}
	
	public String getSubjectChildFirstName() {
		return this.subjectChildFirstName;
	}
	
	public boolean checkSubjectChildFirstName() {
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

}
