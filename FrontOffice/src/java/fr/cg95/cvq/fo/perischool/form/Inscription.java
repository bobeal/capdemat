package fr.cg95.cvq.fo.perischool.form;

import java.util.Calendar;
import java.util.Collection;
import java.util.List;
import javax.servlet.http.HttpSession;
import fr.cg95.cvq.wizard.*;
import fr.cg95.cvq.xml.common.*;
import fr.cg95.cvq.xml.school.*;
import fr.cg95.cvq.xml.school.PerischoolActivityRegistrationRequestDocument.PerischoolActivityRegistrationRequest;

public class Inscription extends IStageForm {

	private String subjectChildLastName;
	private Calendar subjectChildBirthDate;
	private boolean[] perischoolActivity;
	private String urgencyPhone;
	private String subjectChildFirstName;

	public Inscription() {
		super();
	}
	
	public void reset(String state) {
		if (state.equals("school")) {
		}
		if (state.equals("perischool")) {
			for (int i = 0; i < this.perischoolActivity.length; i++)
				this.perischoolActivity[i] = false;
		}
		if (state.equals("*")) {
		}
		if (state.equals("display")) {
		}
	}
	
	public void load(HttpSession session, Object xmlbRequest) {
		if ((xmlbRequest != null) && (xmlbRequest instanceof PerischoolActivityRegistrationRequest)) {
			PerischoolActivityRegistrationRequest request = (PerischoolActivityRegistrationRequest)xmlbRequest;
			this.subjectChildLastName = request.getSubject().getChild().getLastName();
			this.subjectChildBirthDate = request.getSubject().getChild().getBirthDate();
			this.perischoolActivity = loadForm(this.perischoolActivity,(Collection)session.getAttribute("activityList"),request.getPerischoolActivityArray());
			this.urgencyPhone = request.getUrgencyPhone();
			this.subjectChildFirstName = request.getSubject().getChild().getFirstName();
		}
	}
	
	public void save(HttpSession session, Object xmlbRequest) {
		if ((xmlbRequest != null) && (xmlbRequest instanceof PerischoolActivityRegistrationRequest)) {
			PerischoolActivityRegistrationRequest request = (PerischoolActivityRegistrationRequest)xmlbRequest;
			request.getSubject().getChild().setLastName(this.subjectChildLastName);
			request.getSubject().getChild().setBirthDate(this.subjectChildBirthDate);
			request.setPerischoolActivityArray(saveForm(this.perischoolActivity,(Collection)session.getAttribute("activityList")));
			request.setUrgencyPhone(this.urgencyPhone);
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

}