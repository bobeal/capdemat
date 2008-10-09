package fr.cg95.cvq.fo.social.handicapallowance.form;

import java.util.Calendar;
import java.util.Collection;
import java.util.List;
import javax.servlet.http.HttpSession;
import fr.cg95.cvq.wizard.*;
import fr.cg95.cvq.xml.common.*;
import fr.cg95.cvq.xml.social.*;
import fr.cg95.cvq.xml.social.HandicapAllowanceRequestDocument.HandicapAllowanceRequest;

public class Help extends IStageForm {

	private String helperResponsability;
	private String helperName;
	private boolean writingHelp;

	public Help() {
		super();
	}
	
	public void reset(String state) {
		if (state.equals("help")) {
		}
		if (state.equals("display")) {
		}
	}
	
	public void load(HttpSession session, Object xmlbRequest) {
		if ((xmlbRequest != null) && (xmlbRequest instanceof HandicapAllowanceRequest)) {
			HandicapAllowanceRequest request = (HandicapAllowanceRequest)xmlbRequest;
			this.helperResponsability = request.getHelperResponsability();
			this.helperName = request.getHelperName();
			this.writingHelp = request.getWritingHelp();
		}
	}
	
	public void save(HttpSession session, Object xmlbRequest) {
		if ((xmlbRequest != null) && (xmlbRequest instanceof HandicapAllowanceRequest)) {
			HandicapAllowanceRequest request = (HandicapAllowanceRequest)xmlbRequest;
			request.setHelperResponsability(this.helperResponsability);
			request.setHelperName(this.helperName);
			request.setWritingHelp(this.writingHelp);
		}
	}
	
	public boolean isComplete() {
		return true;
	}
	
	public void setHelperResponsability(String helperResponsability) {
		this.helperResponsability = helperResponsability;
	}
	
	public String getHelperResponsability() {
		return this.helperResponsability;
	}
	
	public boolean checkHelperResponsability() {
		return writingHelp;
	}

	public void setHelperName(String helperName) {
		this.helperName = helperName;
	}
	
	public String getHelperName() {
		return this.helperName;
	}
	
	public boolean checkHelperName() {
		return writingHelp;
	}

	public void setWritingHelp(boolean writingHelp) {
		this.writingHelp = writingHelp;
	}
	
	public boolean getWritingHelp() {
		return this.writingHelp;
	}
	
	public boolean checkWritingHelp() {
		return true;
	}

}
