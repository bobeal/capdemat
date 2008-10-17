package fr.cg95.cvq.bo.election;

import java.util.Calendar;
import java.util.List;
import java.util.Set;
import java.util.Vector;

import fr.cg95.cvq.wizard.*;
import fr.cg95.cvq.bo.record.BaseRecord;
import fr.cg95.cvq.bo.record.RequestRecord;
import fr.cg95.cvq.business.authority.*;
import fr.cg95.cvq.business.users.*;
import fr.cg95.cvq.business.social.*;

public class HandicapAllowanceRequestRecord extends RequestRecord {

	private String needs;
	private String comments;
	private String helperResponsability;
	private boolean hopesAndNeeds;
	private String helperName;
	private boolean writingHelp;
	private String hopes;

	public HandicapAllowanceRequestRecord() {
		super();
	}
	
	protected Object clone() throws CloneNotSupportedException {
		HandicapAllowanceRequestRecord clonedRecord = (HandicapAllowanceRequestRecord)super.clone();
		return clonedRecord;
	}
	
	public BaseRecord getDataRecord(Long id) {

		if (id.equals(this.getId()))
			return this;
			
		return super.getDataRecord(id);
	}

    public void load(Object xmlRequest) {
        if ((xmlRequest != null) && (xmlRequest instanceof HandicapAllowanceRequest)) {
            HandicapAllowanceRequest request = (HandicapAllowanceRequest)xmlRequest; 

			this.needs = request.getNeeds();
			this.comments = request.getComments();
			this.helperResponsability = request.getHelperResponsability();
            if ((request.getHopesAndNeeds() != null))
			this.hopesAndNeeds = request.getHopesAndNeeds();
			this.helperName = request.getHelperName();
            if ((request.getWritingHelp() != null))
			this.writingHelp = request.getWritingHelp();
			this.hopes = request.getHopes();
        }
    }
    
    public void saveRequest(Object xmlRequest) {
        if ((xmlRequest != null) && (xmlRequest instanceof HandicapAllowanceRequest)) {
            HandicapAllowanceRequest request = (HandicapAllowanceRequest)xmlRequest; 
        }
    }
    
    public void saveData(Object xmlRequest) {
        if ((xmlRequest != null) && (xmlRequest instanceof HandicapAllowanceRequest)) {
            HandicapAllowanceRequest request = (HandicapAllowanceRequest)xmlRequest; 

			request.setNeeds(this.needs);
			request.setComments(this.comments);
			request.setHelperResponsability(this.helperResponsability);
            if ((request.getHopesAndNeeds() != null))
			request.setHopesAndNeeds(this.hopesAndNeeds);
			request.setHelperName(this.helperName);
            if ((request.getWritingHelp() != null))
			request.setWritingHelp(this.writingHelp);
			request.setHopes(this.hopes);
        }
    }
    
	public void setNeeds(String needs) {
		this.needs = needs;
	}
	
	public String getNeeds() {
		return this.needs;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}
	
	public String getComments() {
		return this.comments;
	}

	public void setHelperResponsability(String helperResponsability) {
		this.helperResponsability = helperResponsability;
	}
	
	public String getHelperResponsability() {
		return this.helperResponsability;
	}

	public void setHopesAndNeeds(boolean hopesAndNeeds) {
		this.hopesAndNeeds = hopesAndNeeds;
	}
	
	public boolean getHopesAndNeeds() {
		return this.hopesAndNeeds;
	}

	public void setHelperName(String helperName) {
		this.helperName = helperName;
	}
	
	public String getHelperName() {
		return this.helperName;
	}

	public void setWritingHelp(boolean writingHelp) {
		this.writingHelp = writingHelp;
	}
	
	public boolean getWritingHelp() {
		return this.writingHelp;
	}

	public void setHopes(String hopes) {
		this.hopes = hopes;
	}
	
	public String getHopes() {
		return this.hopes;
	}

}

