package fr.cg95.cvq.fo.citizen.form;

import java.util.Calendar;
import java.util.Collection;
import java.util.List;
import javax.servlet.http.HttpSession;
import fr.cg95.cvq.wizard.*;
import fr.cg95.cvq.xml.common.*;
import fr.cg95.cvq.xml.ecitizen.*;
import fr.cg95.cvq.xml.ecitizen.VoCardRequestDocument.VoCardRequest;

public class Validation extends IStageForm {


	public Validation() {
		super();
	}
	
	public void reset(String state) {
		if (state.equals("summary")) {
		}
	}
	
	public void load(HttpSession session, Object xmlbRequest) {
		if ((xmlbRequest != null) && (xmlbRequest instanceof VoCardRequest)) {
			VoCardRequest request = (VoCardRequest)xmlbRequest;
		}
	}
	
	public void save(HttpSession session, Object xmlbRequest) {
		if ((xmlbRequest != null) && (xmlbRequest instanceof VoCardRequest)) {
			VoCardRequest request = (VoCardRequest)xmlbRequest;
		}
	}
	
	public boolean isComplete() {
		return true;
	}
	
}
