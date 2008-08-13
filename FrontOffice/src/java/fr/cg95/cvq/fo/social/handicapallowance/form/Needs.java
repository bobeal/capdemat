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

	private String comments;
	private String needs;
	private String hopes;
	private boolean hopesAndNeeds;

	public Needs() {
		super();
	}
	
	public void reset(String state) {
		if (state.equals("display")) {
		}
		if (state.equals("needs")) {
		}
	}
	
	public void load(HttpSession session, Object xmlbRequest) {
		if ((xmlbRequest != null) && (xmlbRequest instanceof HandicapAllowanceRequest)) {
			HandicapAllowanceRequest request = (HandicapAllowanceRequest)xmlbRequest;
			this.comments = request.getComments();
			this.needs = request.getNeeds();
			this.hopes = request.getHopes();
			this.hopesAndNeeds = request.getHopesAndNeeds();
		}
	}
	
	public void save(HttpSession session, Object xmlbRequest) {
		if ((xmlbRequest != null) && (xmlbRequest instanceof HandicapAllowanceRequest)) {
			HandicapAllowanceRequest request = (HandicapAllowanceRequest)xmlbRequest;
			request.setComments(this.comments);
			request.setNeeds(this.needs);
			request.setHopes(this.hopes);
			request.setHopesAndNeeds(this.hopesAndNeeds);
		}
	}
	
	public boolean isComplete() {
		return true;
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

	public void setNeeds(String needs) {
		this.needs = needs;
	}
	
	public String getNeeds() {
		return this.needs;
	}
	
	public boolean checkNeeds() {
		return hopesAndNeeds;
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

	public void setHopesAndNeeds(boolean hopesAndNeeds) {
		this.hopesAndNeeds = hopesAndNeeds;
	}
	
	public boolean getHopesAndNeeds() {
		return this.hopesAndNeeds;
	}
	
	public boolean checkHopesAndNeeds() {
		return true;
	}

}
