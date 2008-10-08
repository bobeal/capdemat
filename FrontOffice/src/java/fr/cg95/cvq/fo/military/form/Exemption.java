package fr.cg95.cvq.fo.military.form;

import java.util.Calendar;
import java.util.Collection;
import java.util.List;
import javax.servlet.http.HttpSession;
import fr.cg95.cvq.wizard.*;
import fr.cg95.cvq.xml.common.*;
import fr.cg95.cvq.xml.military.*;
import fr.cg95.cvq.xml.military.MilitaryCensusRequestDocument.MilitaryCensusRequest;

public class Exemption extends IStageForm {

	private boolean highlyInfirm;
	private boolean affectionOrDisease;
	private boolean japdExemption;

	public Exemption() {
		super();
	}
	
	public void reset(String state) {
		if (state.equals("exemption")) {
		}
		if (state.equals("display")) {
		}
	}
	
	public void load(HttpSession session, Object xmlbRequest) {
		if ((xmlbRequest != null) && (xmlbRequest instanceof MilitaryCensusRequest)) {
			MilitaryCensusRequest request = (MilitaryCensusRequest)xmlbRequest;
			this.highlyInfirm = request.getHighlyInfirm();
			this.affectionOrDisease = request.getAffectionOrDisease();
			this.japdExemption = request.getJapdExemption();
		}
	}
	
	public void save(HttpSession session, Object xmlbRequest) {
		if ((xmlbRequest != null) && (xmlbRequest instanceof MilitaryCensusRequest)) {
			MilitaryCensusRequest request = (MilitaryCensusRequest)xmlbRequest;
			request.setHighlyInfirm(this.highlyInfirm);
			request.setAffectionOrDisease(this.affectionOrDisease);
			request.setJapdExemption(this.japdExemption);
		}
	}
	
	public boolean isComplete() {
		return true;
	}
	
	public void setHighlyInfirm(boolean highlyInfirm) {
		this.highlyInfirm = highlyInfirm;
	}
	
	public boolean getHighlyInfirm() {
		return this.highlyInfirm;
	}
	
	public boolean checkHighlyInfirm() {
		return true;
	}

	public void setAffectionOrDisease(boolean affectionOrDisease) {
		this.affectionOrDisease = affectionOrDisease;
	}
	
	public boolean getAffectionOrDisease() {
		return this.affectionOrDisease;
	}
	
	public boolean checkAffectionOrDisease() {
		return true;
	}

	public void setJapdExemption(boolean japdExemption) {
		this.japdExemption = japdExemption;
	}
	
	public boolean getJapdExemption() {
		return this.japdExemption;
	}
	
	public boolean checkJapdExemption() {
		return true;
	}

}
