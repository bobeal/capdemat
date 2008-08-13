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

public class PerischoolActivityRegistrationRequestRecord extends RequestRecord {

	private boolean classTripPermission;
	private String section;
	private boolean childPhotoExploitationPermission;
	private boolean rulesAndRegulationsAcceptance;
	private String urgencyPhone;
	private String subjectChildFirstName;
	private String schoolName;
	private boolean hospitalizationPermission;
	private String subjectChildLastName;
	private Calendar subjectChildBirthDate;
	private boolean[] perischoolActivity;
   	private List perischoolActivityList;

	public PerischoolActivityRegistrationRequestRecord() {
		super();
	}
	
	protected Object clone() throws CloneNotSupportedException {
		PerischoolActivityRegistrationRequestRecord clonedRecord = (PerischoolActivityRegistrationRequestRecord)super.clone();
		clonedRecord.perischoolActivity = (boolean[])this.perischoolActivity.clone();
		return clonedRecord;
	}
	
	public BaseRecord getDataRecord(Long id) {

		if (id.equals(this.getId()))
			return this;
			
		return super.getDataRecord(id);
	}

    public void load(Object xmlRequest) {
        if ((xmlRequest != null) && (xmlRequest instanceof PerischoolActivityRegistrationRequest)) {
            PerischoolActivityRegistrationRequest request = (PerischoolActivityRegistrationRequest)xmlRequest; 

            if ((request.getClassTripPermission() != null))
			this.classTripPermission = request.getClassTripPermission();
			if (request.getSection() != null)
                this.section = getEnumElementTranslation(
                        fr.cg95.cvq.xml.school.PerischoolActivityRegistrationRequestDocument.PerischoolActivityRegistrationRequest.class.getName(), 
                        "Section", request.getSection().toString());
            if ((request.getChildPhotoExploitationPermission() != null))
			this.childPhotoExploitationPermission = request.getChildPhotoExploitationPermission();
            if ((request.getRulesAndRegulationsAcceptance() != null))
			this.rulesAndRegulationsAcceptance = request.getRulesAndRegulationsAcceptance();
			this.urgencyPhone = request.getUrgencyPhone();
			this.subjectChildFirstName = ((Child)request.getSubject()).getFirstName();
            if ((request.getSchool() != null))
			this.schoolName = request.getSchool().getName();
            if ((request.getHospitalizationPermission() != null))
			this.hospitalizationPermission = request.getHospitalizationPermission();
			this.subjectChildLastName = ((Child)request.getSubject()).getLastName();
			if (((Child)request.getSubject()).getBirthDate() != null) {
				this.subjectChildBirthDate = Calendar.getInstance(); 
	            this.subjectChildBirthDate.setTime(((Child)request.getSubject()).getBirthDate());
			}
            this.setPerischoolActivity(this.getList("PerischoolActivity"), request.getPerischoolActivity());
        }
    }
    
    public void saveRequest(Object xmlRequest) {
        if ((xmlRequest != null) && (xmlRequest instanceof PerischoolActivityRegistrationRequest)) {
            PerischoolActivityRegistrationRequest request = (PerischoolActivityRegistrationRequest)xmlRequest; 
        }
    }
    
    public void saveData(Object xmlRequest) {
        if ((xmlRequest != null) && (xmlRequest instanceof PerischoolActivityRegistrationRequest)) {
            PerischoolActivityRegistrationRequest request = (PerischoolActivityRegistrationRequest)xmlRequest; 

            if ((request.getClassTripPermission() != null))
			request.setClassTripPermission(this.classTripPermission);
			if (this.section != null)
                request.setSection(
                    SectionType.forString(
                        getEnumKeyTranslation(
                            fr.cg95.cvq.xml.school.PerischoolActivityRegistrationRequestDocument.PerischoolActivityRegistrationRequest.class.getName(), 
                            "Section", this.section)
                    )
                );
            if ((request.getChildPhotoExploitationPermission() != null))
			request.setChildPhotoExploitationPermission(this.childPhotoExploitationPermission);
            if ((request.getRulesAndRegulationsAcceptance() != null))
			request.setRulesAndRegulationsAcceptance(this.rulesAndRegulationsAcceptance);
			request.setUrgencyPhone(this.urgencyPhone);
            if ((request.getSchool() != null))
			request.getSchool().setName(this.schoolName);
            if ((request.getHospitalizationPermission() != null))
			request.setHospitalizationPermission(this.hospitalizationPermission);
			request.setPerischoolActivity(this.getPerischoolActivityKeys());
        }
    }
    
	public void setClassTripPermission(boolean classTripPermission) {
		this.classTripPermission = classTripPermission;
	}
	
	public boolean getClassTripPermission() {
		return this.classTripPermission;
	}

	public void setSection(String section) {
		this.section = section;
	}
	
	public String getSection() {
		return this.section;
	}

	public void setChildPhotoExploitationPermission(boolean childPhotoExploitationPermission) {
		this.childPhotoExploitationPermission = childPhotoExploitationPermission;
	}
	
	public boolean getChildPhotoExploitationPermission() {
		return this.childPhotoExploitationPermission;
	}

	public void setRulesAndRegulationsAcceptance(boolean rulesAndRegulationsAcceptance) {
		this.rulesAndRegulationsAcceptance = rulesAndRegulationsAcceptance;
	}
	
	public boolean getRulesAndRegulationsAcceptance() {
		return this.rulesAndRegulationsAcceptance;
	}

	public void setUrgencyPhone(String urgencyPhone) {
		this.urgencyPhone = urgencyPhone;
	}
	
	public String getUrgencyPhone() {
		return this.urgencyPhone;
	}

	public void setSubjectChildFirstName(String subjectChildFirstName) {
		this.subjectChildFirstName = subjectChildFirstName;
	}
	
	public String getSubjectChildFirstName() {
		return this.subjectChildFirstName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}
	
	public String getSchoolName() {
		return this.schoolName;
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

	public void setSubjectChildBirthDate(Calendar subjectChildBirthDate) {
		this.subjectChildBirthDate = subjectChildBirthDate;
	}
	
	public Calendar getSubjectChildBirthDate() {
		return this.subjectChildBirthDate;
	}

	public void setPerischoolActivity(List referential, Set values) {
		if (referential != null) {
			this.perischoolActivity = new boolean[referential.size()];
			this.perischoolActivityList = referential;
			
			if (values != null) {
				for (int i = 0; i < perischoolActivity.length; i++) {
					String key = ((ReferentialData)perischoolActivityList.get(i)).getKey();
					perischoolActivity[i] = containsRefData(values, key);
				}
			}
		}
	}
	
	public List getPerischoolActivityList() {
		return this.perischoolActivityList;
	}
	
	public Set getPerischoolActivityKeys() {
		return getRefDataSet(perischoolActivity, perischoolActivityList);
	}

	public String[] getPerischoolActivity() {
		Vector values = new Vector();
		
		for (int i = 0; i < perischoolActivity.length; i++) {
			if (perischoolActivity[i]) {
				values.add(((ReferentialData)perischoolActivityList.get(i)).getValue());
			}
		}

		String[] value = new String[values.size()];
		for (int i = 0; i < values.size(); i++)
			value[i] = (String)values.get(i);

		return value;
	}

	public void setPerischoolActivity(String[] value) {
		String values = "";
		for (int i = 0; i < value.length; i++)
			values += "<" + value[i] + ">";
		
		for (int i = 0; i < perischoolActivity.length; i++) {
			perischoolActivity[i] = values.indexOf("<" + ((ReferentialData)perischoolActivityList.get(i)).getValue() + ">") != -1;
		}
	}
}

