package fr.cg95.cvq.fo.leisure.sms.form;

import java.util.Calendar;
import java.util.Collection;
import java.util.List;
import javax.servlet.http.HttpSession;
import fr.cg95.cvq.wizard.*;
import fr.cg95.cvq.xml.common.*;
import fr.cg95.cvq.xml.leisure.*;
import fr.cg95.cvq.xml.leisure.SmsNotificationRequestDocument.SmsNotificationRequest;

public class Subscription extends IStageForm {

	private boolean subscription;
	private boolean[] interests;

	public Subscription() {
		super();
	}
	
	public void reset(String state) {
		if (state.equals("subscription")) {
			for (int i = 0; i < this.interests.length; i++)
				this.interests[i] = false;
		}
		if (state.equals("display")) {
		}
	}
	
	public void load(HttpSession session, Object xmlbRequest) {
		if ((xmlbRequest != null) && (xmlbRequest instanceof SmsNotificationRequest)) {
			SmsNotificationRequest request = (SmsNotificationRequest)xmlbRequest;
			this.subscription = request.getSubscription();
			this.interests = loadForm(this.interests,(Collection)session.getAttribute("Interests"),request.getInterestsArray());
		}
	}
	
	public void save(HttpSession session, Object xmlbRequest) {
		if ((xmlbRequest != null) && (xmlbRequest instanceof SmsNotificationRequest)) {
			SmsNotificationRequest request = (SmsNotificationRequest)xmlbRequest;
			request.setSubscription(this.subscription);
			request.setInterestsArray(saveForm(this.interests,(Collection)session.getAttribute("Interests")));
		}
	}
	
	public boolean isComplete() {
		return true;
	}
	
	public void setSubscription(boolean subscription) {
		this.subscription = subscription;
	}
	
	public boolean getSubscription() {
		return this.subscription;
	}
	
	public boolean checkSubscription() {
		return true;
	}

	public void setInterests(boolean[] interests) {
		this.interests = interests;
	}
	
	public boolean[] getInterests() {
		return this.interests;
	}
	
	public boolean checkInterests() {
		return true;
	}

	public void setInterests(int i, boolean interests) {
		this.interests[i] = interests;
	}
	
	public boolean getInterests(int i) {
		return this.interests[i];
	}
	
	public int getSizeOfInterests() {
        return this.interests.length;
    }
    
    public void setSizeOfInterests(int size) {
        this.interests = new boolean[size];
    }
    
    public int getNbSelectedInterests() {
        int count = 0;
        for (int i = 0; i < interests.length; i++)
            if (interests[i])
                count++;
        return count;
    }

}
