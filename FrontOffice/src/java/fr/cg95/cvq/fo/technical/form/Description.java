package fr.cg95.cvq.fo.technical.form;

import java.util.Calendar;
import java.util.Collection;
import java.util.List;
import javax.servlet.http.HttpSession;
import fr.cg95.cvq.wizard.*;
import fr.cg95.cvq.xml.common.*;
import fr.cg95.cvq.xml.technical.*;
import fr.cg95.cvq.xml.technical.TechnicalInterventionRequestDocument.TechnicalInterventionRequest;

public class Description extends IStageForm {

	private String interventionDescription;

	public Description() {
		super();
	}
	
	public void reset(String state) {
		if (state.equals("description")) {
		}
	}
	
	public void load(HttpSession session, Object xmlbRequest) {
		if ((xmlbRequest != null) && (xmlbRequest instanceof TechnicalInterventionRequest)) {
			TechnicalInterventionRequest request = (TechnicalInterventionRequest)xmlbRequest;
			this.interventionDescription = request.getInterventionDescription();
		}
	}
	
	public void save(HttpSession session, Object xmlbRequest) {
		if ((xmlbRequest != null) && (xmlbRequest instanceof TechnicalInterventionRequest)) {
			TechnicalInterventionRequest request = (TechnicalInterventionRequest)xmlbRequest;
			request.setInterventionDescription(this.interventionDescription);
		}
	}
	
	public boolean isComplete() {
		if (this.checkInterventionDescription() &&
			((this.interventionDescription == null) || (this.interventionDescription.length() == 0)))
			return false;
		return true;
	}
	
	public void setInterventionDescription(String interventionDescription) {
		this.interventionDescription = interventionDescription;
	}
	
	public String getInterventionDescription() {
		return this.interventionDescription;
	}
	
	public boolean checkInterventionDescription() {
		return true;
	}

}
