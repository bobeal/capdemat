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

public class RecreationActivityRegistrationRequestRecord extends RequestRecord {

	private boolean classTripPermission;
	private boolean childPhotoExploitationPermission;
	private boolean rulesAndRegulationsAcceptance;
	private String urgencyPhone;
	private String subjectChildFirstName;
	private String recreationCenterName;
	private boolean hospitalizationPermission;
	private String subjectChildLastName;
	private Calendar subjectChildBirthDate;
	private boolean[] recreationActivity;
   	private List recreationActivityList;

	public RecreationActivityRegistrationRequestRecord() {
		super();
	}
	
	protected Object clone() throws CloneNotSupportedException {
		RecreationActivityRegistrationRequestRecord clonedRecord = (RecreationActivityRegistrationRequestRecord)super.clone();
		clonedRecord.recreationActivity = (boolean[])this.recreationActivity.clone();
		return clonedRecord;
	}
	
	public BaseRecord getDataRecord(Long id) {

		if (id.equals(this.getId()))
			return this;
			
		return super.getDataRecord(id);
	}

    public void load(Object xmlRequest) {
        if ((xmlRequest != null) && (xmlRequest instanceof RecreationActivityRegistrationRequest)) {
            RecreationActivityRegistrationRequest request = (RecreationActivityRegistrationRequest)xmlRequest; 

            if ((request.getClassTripPermission() != null))
			this.classTripPermission = request.getClassTripPermission();
            if ((request.getChildPhotoExploitationPermission() != null))
			this.childPhotoExploitationPermission = request.getChildPhotoExploitationPermission();
            if ((request.getRulesAndRegulationsAcceptance() != null))
			this.rulesAndRegulationsAcceptance = request.getRulesAndRegulationsAcceptance();
			this.urgencyPhone = request.getUrgencyPhone();
			this.subjectChildFirstName = ((Child)request.getSubject()).getFirstName();
            if ((request.getRecreationCenter() != null))
			this.recreationCenterName = request.getRecreationCenter().getName();
            if ((request.getHospitalizationPermission() != null))
			this.hospitalizationPermission = request.getHospitalizationPermission();
			this.subjectChildLastName = ((Child)request.getSubject()).getLastName();
			if (((Child)request.getSubject()).getBirthDate() != null) {
				this.subjectChildBirthDate = Calendar.getInstance(); 
	            this.subjectChildBirthDate.setTime(((Child)request.getSubject()).getBirthDate());
			}
            this.setRecreationActivity(this.getList("RecreationActivity"), request.getRecreationActivity());
        }
    }
    
    public void saveRequest(Object xmlRequest) {
        if ((xmlRequest != null) && (xmlRequest instanceof RecreationActivityRegistrationRequest)) {
            RecreationActivityRegistrationRequest request = (RecreationActivityRegistrationRequest)xmlRequest; 
        }
    }
    
    public void saveData(Object xmlRequest) {
        if ((xmlRequest != null) && (xmlRequest instanceof RecreationActivityRegistrationRequest)) {
            RecreationActivityRegistrationRequest request = (RecreationActivityRegistrationRequest)xmlRequest; 

            if ((request.getClassTripPermission() != null))
			request.setClassTripPermission(this.classTripPermission);
            if ((request.getChildPhotoExploitationPermission() != null))
			request.setChildPhotoExploitationPermission(this.childPhotoExploitationPermission);
            if ((request.getRulesAndRegulationsAcceptance() != null))
			request.setRulesAndRegulationsAcceptance(this.rulesAndRegulationsAcceptance);
			request.setUrgencyPhone(this.urgencyPhone);
            if ((request.getRecreationCenter() != null))
			request.getRecreationCenter().setName(this.recreationCenterName);
            if ((request.getHospitalizationPermission() != null))
			request.setHospitalizationPermission(this.hospitalizationPermission);
			request.setRecreationActivity(this.getRecreationActivityKeys());
        }
    }
    
	public void setClassTripPermission(boolean classTripPermission) {
		this.classTripPermission = classTripPermission;
	}
	
	public boolean getClassTripPermission() {
		return this.classTripPermission;
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

	public void setRecreationCenterName(String recreationCenterName) {
		this.recreationCenterName = recreationCenterName;
	}
	
	public String getRecreationCenterName() {
		return this.recreationCenterName;
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

	public void setRecreationActivity(List referential, Set values) {
		if (referential != null) {
			this.recreationActivity = new boolean[referential.size()];
			this.recreationActivityList = referential;
			
			if (values != null) {
				for (int i = 0; i < recreationActivity.length; i++) {
					String key = ((ReferentialData)recreationActivityList.get(i)).getKey();
					recreationActivity[i] = containsRefData(values, key);
				}
			}
		}
	}
	
	public List getRecreationActivityList() {
		return this.recreationActivityList;
	}
	
	public Set getRecreationActivityKeys() {
		return getRefDataSet(recreationActivity, recreationActivityList);
	}

	public String[] getRecreationActivity() {
		Vector values = new Vector();
		
		for (int i = 0; i < recreationActivity.length; i++) {
			if (recreationActivity[i]) {
				values.add(((ReferentialData)recreationActivityList.get(i)).getValue());
			}
		}

		String[] value = new String[values.size()];
		for (int i = 0; i < values.size(); i++)
			value[i] = (String)values.get(i);

		return value;
	}

	public void setRecreationActivity(String[] value) {
		String values = "";
		for (int i = 0; i < value.length; i++)
			values += "<" + value[i] + ">";
		
		for (int i = 0; i < recreationActivity.length; i++) {
			recreationActivity[i] = values.indexOf("<" + ((ReferentialData)recreationActivityList.get(i)).getValue() + ">") != -1;
		}
	}
}

