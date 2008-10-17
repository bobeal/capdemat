package fr.cg95.cvq.fo.school.recreation.form;

import java.util.Calendar;
import java.util.Collection;
import java.util.List;
import javax.servlet.http.HttpSession;
import fr.cg95.cvq.wizard.*;
import fr.cg95.cvq.xml.common.*;
import fr.cg95.cvq.xml.school.*;
import fr.cg95.cvq.xml.school.RecreationActivityRegistrationRequestDocument.RecreationActivityRegistrationRequest;

public class Inscription extends IStageForm {

	private String subjectChildLastName;
	private Calendar subjectChildBirthDate;
	private String urgencyPhone;
	private String subjectChildFirstName;
	private boolean[] recreationActivity;

	public Inscription() {
		super();
	}
	
	public void reset(String state) {
		if (state.equals("school")) {
		}
		if (state.equals("*")) {
		}
		if (state.equals("display")) {
		}
		if (state.equals("recreation")) {
			for (int i = 0; i < this.recreationActivity.length; i++)
				this.recreationActivity[i] = false;
		}
	}
	
	public void load(HttpSession session, Object xmlbRequest) {
		if ((xmlbRequest != null) && (xmlbRequest instanceof RecreationActivityRegistrationRequest)) {
			RecreationActivityRegistrationRequest request = (RecreationActivityRegistrationRequest)xmlbRequest;
			this.subjectChildLastName = request.getSubject().getChild().getLastName();
			this.subjectChildBirthDate = request.getSubject().getChild().getBirthDate();
			this.urgencyPhone = request.getUrgencyPhone();
			this.subjectChildFirstName = request.getSubject().getChild().getFirstName();
			this.recreationActivity = loadForm(this.recreationActivity,(Collection)session.getAttribute("activityList"),request.getRecreationActivityArray());
		}
	}
	
	public void save(HttpSession session, Object xmlbRequest) {
		if ((xmlbRequest != null) && (xmlbRequest instanceof RecreationActivityRegistrationRequest)) {
			RecreationActivityRegistrationRequest request = (RecreationActivityRegistrationRequest)xmlbRequest;
			request.getSubject().getChild().setLastName(this.subjectChildLastName);
			request.getSubject().getChild().setBirthDate(this.subjectChildBirthDate);
			request.setUrgencyPhone(this.urgencyPhone);
			request.getSubject().getChild().setFirstName(this.subjectChildFirstName);
			request.setRecreationActivityArray(saveForm(this.recreationActivity,(Collection)session.getAttribute("activityList")));
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

	public void setRecreationActivity(boolean[] recreationActivity) {
		this.recreationActivity = recreationActivity;
	}
	
	public boolean[] getRecreationActivity() {
		return this.recreationActivity;
	}
	
	public boolean checkRecreationActivity() {
		return true;
	}

	public void setRecreationActivity(int i, boolean recreationActivity) {
		this.recreationActivity[i] = recreationActivity;
	}
	
	public boolean getRecreationActivity(int i) {
		return this.recreationActivity[i];
	}
	
	public int getSizeOfRecreationActivity() {
        return this.recreationActivity.length;
    }
    
    public void setSizeOfRecreationActivity(int size) {
        this.recreationActivity = new boolean[size];
    }
    
    public int getNbSelectedRecreationActivity() {
        int count = 0;
        for (int i = 0; i < recreationActivity.length; i++)
            if (recreationActivity[i])
                count++;
        return count;
    }

}