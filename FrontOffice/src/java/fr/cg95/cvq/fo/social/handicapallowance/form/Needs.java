package fr.cg95.cvq.fo.social.handicapallowance.form;

import java.util.Calendar;
import java.util.Collection;
import java.util.List;
import javax.servlet.http.HttpSession;
import fr.cg95.cvq.wizard.*;
import fr.cg95.cvq.xml.common.*;
import fr.cg95.cvq.xml.social.*;
import fr.cg95.cvq.xml.social.HandicapAllowanceRequestDocument.HandicapAllowanceRequest;

public class Needs extends IStageForm {

	private String needs;
	private String comments;
	private boolean hopesAndNeeds;
	private String hopes;

	public Needs() {
		super();
	}
	
	public void reset(String state) {
		if (state.equals("needs")) {
		}
		if (state.equals("display")) {
		}
	}
	
	public void load(HttpSession session, Object xmlbRequest) {
		if ((xmlbRequest != null) && (xmlbRequest instanceof HandicapAllowanceRequest)) {
			HandicapAllowanceRequest request = (HandicapAllowanceRequest)xmlbRequest;
			this.needs = request.getNeeds();
			this.comments = request.getComments();
			this.hopesAndNeeds = request.getHopesAndNeeds();
			this.hopes = request.getHopes();
		}
	}
	
	public void save(HttpSession session, Object xmlbRequest) {
		if ((xmlbRequest != null) && (xmlbRequest instanceof HandicapAllowanceRequest)) {
			HandicapAllowanceRequest request = (HandicapAllowanceRequest)xmlbRequest;
			request.setNeeds(this.needs);
			request.setComments(this.comments);
			request.setHopesAndNeeds(this.hopesAndNeeds);
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
		return hopesAndNeeds;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}
	
	public String getComments() {
		return this.comments;
	}
	
	public boolean checkComments() {
		return hopesAndNeeds;
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

	public void setHopes(String hopes) {
		this.hopes = hopes;
	}
	
	public String getHopes() {
		return this.hopes;
	}
	
	public boolean checkHopes() {
		return hopesAndNeeds;
	}

}
