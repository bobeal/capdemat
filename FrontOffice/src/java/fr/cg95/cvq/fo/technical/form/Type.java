package fr.cg95.cvq.fo.technical.form;

import java.util.Calendar;
import java.util.Collection;
import java.util.List;
import javax.servlet.http.HttpSession;
import fr.cg95.cvq.wizard.*;
import fr.cg95.cvq.xml.common.*;
import fr.cg95.cvq.xml.technical.*;
import fr.cg95.cvq.xml.technical.TechnicalInterventionRequestDocument.TechnicalInterventionRequest;

public class Type extends IStageForm {

	private String interventionType;

	public Type() {
		super();
	}
	
	public void reset(String state) {
		if (state.equals("type")) {
		}
	}
	
	public void load(HttpSession session, Object xmlbRequest) {
		if ((xmlbRequest != null) && (xmlbRequest instanceof TechnicalInterventionRequest)) {
			TechnicalInterventionRequest request = (TechnicalInterventionRequest)xmlbRequest;
			this.interventionType = loadForm(this.interventionType,(Collection)session.getAttribute("InterventionType"),request.getInterventionTypeArray());
		}
	}
	
	public void save(HttpSession session, Object xmlbRequest) {
		if ((xmlbRequest != null) && (xmlbRequest instanceof TechnicalInterventionRequest)) {
			TechnicalInterventionRequest request = (TechnicalInterventionRequest)xmlbRequest;
			request.setInterventionTypeArray(saveForm(this.interventionType,(Collection)session.getAttribute("InterventionType")));
		}
	}
	
	public boolean isComplete() {
		if (this.checkInterventionType() &&
			((this.interventionType == null) || (this.interventionType.length() == 0)))
			return false;
		return true;
	}
	
	public void setInterventionType(String interventionType) {
		this.interventionType = interventionType;
	}
	
	public String getInterventionType() {
		return this.interventionType;
	}
	
	public boolean checkInterventionType() {
		return true;
	}

}