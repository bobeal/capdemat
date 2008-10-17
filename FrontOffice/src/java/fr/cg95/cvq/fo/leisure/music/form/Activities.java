package fr.cg95.cvq.fo.leisure.music.form;

import java.util.Calendar;
import java.util.Collection;
import java.util.List;
import javax.servlet.http.HttpSession;
import fr.cg95.cvq.wizard.*;
import fr.cg95.cvq.xml.common.*;
import fr.cg95.cvq.xml.leisure.music.*;
import fr.cg95.cvq.xml.leisure.music.MusicSchoolRegistrationRequestDocument.MusicSchoolRegistrationRequest;

public class Activities extends IStageForm {


	public Activities() {
		super();
	}
	
	public void reset(String state) {
		if (state.equals("display")) {
		}
		if (state.equals("activities")) {
		}
	}
	
	public void load(HttpSession session, Object xmlbRequest) {
		if ((xmlbRequest != null) && (xmlbRequest instanceof MusicSchoolRegistrationRequest)) {
			MusicSchoolRegistrationRequest request = (MusicSchoolRegistrationRequest)xmlbRequest;
		}
	}
	
	public void save(HttpSession session, Object xmlbRequest) {
		if ((xmlbRequest != null) && (xmlbRequest instanceof MusicSchoolRegistrationRequest)) {
			MusicSchoolRegistrationRequest request = (MusicSchoolRegistrationRequest)xmlbRequest;
			request.setActivityArray(saveForm((ReferentialData)session.getAttribute("Activity")));
		}
	}
	
	public boolean isComplete() {
		return true;
	}
	
}