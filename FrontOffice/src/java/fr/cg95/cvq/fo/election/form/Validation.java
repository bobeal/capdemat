package fr.cg95.cvq.fo.election.form;

import java.util.Calendar;
import java.util.Collection;
import java.util.List;
import javax.servlet.http.HttpSession;
import fr.cg95.cvq.wizard.*;
import fr.cg95.cvq.xml.common.*;
import fr.cg95.cvq.xml.social.*;
import fr.cg95.cvq.xml.social.HandicapAllowanceRequestDocument.HandicapAllowanceRequest;

public class Validation extends IStageForm {

	private String needs;
	private String comments;
	private String helperResponsability;
	private boolean hopesAndNeeds;
	private String helperName;
	private boolean writingHelp;
	private String hopes;

	public Validation() {
		super();
	}
	
	public void reset(String state) {
		if (state.equals("summary")) {
		}
	}
	
	public void load(HttpSession session, Object xmlbRequest) {
		if ((xmlbRequest != null) && (xmlbRequest instanceof HandicapAllowanceRequest)) {
			HandicapAllowanceRequest request = (HandicapAllowanceRequest)xmlbRequest;
			this.needs = request.getNeeds();
			this.comments = request.getComments();
			this.helperResponsability = request.getHelperResponsability();
			this.hopesAndNeeds = request.getHopesAndNeeds();
			this.helperName = request.getHelperName();
			this.writingHelp = request.getWritingHelp();
			this.hopes = request.getHopes();
		}
	}
	
	public void save(HttpSession session, Object xmlbRequest) {
		if ((xmlbRequest != null) && (xmlbRequest instanceof HandicapAllowanceRequest)) {
			HandicapAllowanceRequest request = (HandicapAllowanceRequest)xmlbRequest;
			request.setNeeds(this.needs);
			request.setComments(this.comments);
			request.setHelperResponsability(this.helperResponsability);
			request.setHopesAndNeeds(this.hopesAndNeeds);
			request.setHelperName(this.helperName);
			request.setWritingHelp(this.writingHelp);
			request.setHopes(this.hopes);
		}
	}
	
	public boolean isComplete() {
		return true;
	}
	
	public void setNeeds(String needs) {
		this.needs = needs;
	}
	
	public String getNeeds() {
		return this.needs;
	}
	
	public boolean checkNeeds() {
		return true;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}
	
	public String getComments() {
		return this.comments;
	}
	
	public boolean checkComments() {
		return true;
	}

	public void setHelperResponsability(String helperResponsability) {
		this.helperResponsability = helperResponsability;
	}
	
	public String getHelperResponsability() {
		return this.helperResponsability;
	}
	
	public boolean checkHelperResponsability() {
		return true;
	}

	public void setHopesAndNeeds(boolean hopesAndNeeds) {
		this.hopesAndNeeds = hopesAndNeeds;
	}
	
	public boolean getHopesAndNeeds() {
		return this.hopesAndNeeds;
	}
	
	public boolean checkHopesAndNeeds() {
		return true;
	}

	public void setHelperName(String helperName) {
		this.helperName = helperName;
	}
	
	public String getHelperName() {
		return this.helperName;
	}
	
	public boolean checkHelperName() {
		return true;
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

	public void setHopes(String hopes) {
		this.hopes = hopes;
	}
	
	public String getHopes() {
		return this.hopes;
	}
	
	public boolean checkHopes() {
		return true;
	}

}