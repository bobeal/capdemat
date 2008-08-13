package fr.cg95.cvq.fo.social.domestichelp.form;

import java.util.Calendar;
import java.util.Collection;
import java.util.List;
import javax.servlet.http.HttpSession;
import fr.cg95.cvq.wizard.*;
import fr.cg95.cvq.xml.common.*;
import fr.cg95.cvq.xml.social.*;
import fr.cg95.cvq.xml.social.DomesticHelpRequestDocument.DomesticHelpRequest;

public class Resources extends IStageForm {

	private java.math.BigInteger requesterIncomesRequesterPensions;
	private java.math.BigInteger requesterIncomesRequesterInvestmentIncome;
	private java.math.BigInteger requesterSpouseIncomesSpouseNetIncome;
	private java.math.BigInteger requesterSpouseIncomesSpousePensions;
	private java.math.BigInteger requesterSpouseIncomesSpouseAllowances;
	private java.math.BigInteger requesterIncomesRequesterNetIncome;
	private java.math.BigInteger requesterIncomesRequesterAllowances;
	private java.math.BigInteger requesterSpouseIncomesSpouseInvestmentIncome;

	public Resources() {
		super();
	}
	
	public void reset(String state) {
		if (state.equals("display")) {
		}
		if (state.equals("spouse")) {
		}
		if (state.equals("subject")) {
		}
	}
	
	public void load(HttpSession session, Object xmlbRequest) {
		if ((xmlbRequest != null) && (xmlbRequest instanceof DomesticHelpRequest)) {
			DomesticHelpRequest request = (DomesticHelpRequest)xmlbRequest;
			this.requesterIncomesRequesterPensions = request.getRequesterIncomes().getRequesterPensions();
			this.requesterIncomesRequesterInvestmentIncome = request.getRequesterIncomes().getRequesterInvestmentIncome();
			this.requesterSpouseIncomesSpouseNetIncome = request.getRequesterSpouseIncomes().getSpouseNetIncome();
			this.requesterSpouseIncomesSpousePensions = request.getRequesterSpouseIncomes().getSpousePensions();
			this.requesterSpouseIncomesSpouseAllowances = request.getRequesterSpouseIncomes().getSpouseAllowances();
			this.requesterIncomesRequesterNetIncome = request.getRequesterIncomes().getRequesterNetIncome();
			this.requesterIncomesRequesterAllowances = request.getRequesterIncomes().getRequesterAllowances();
			this.requesterSpouseIncomesSpouseInvestmentIncome = request.getRequesterSpouseIncomes().getSpouseInvestmentIncome();
		}
	}
	
	public void save(HttpSession session, Object xmlbRequest) {
		if ((xmlbRequest != null) && (xmlbRequest instanceof DomesticHelpRequest)) {
			DomesticHelpRequest request = (DomesticHelpRequest)xmlbRequest;
			request.getRequesterIncomes().setRequesterPensions(this.requesterIncomesRequesterPensions);
			request.getRequesterIncomes().setRequesterInvestmentIncome(this.requesterIncomesRequesterInvestmentIncome);
			request.getRequesterSpouseIncomes().setSpouseNetIncome(this.requesterSpouseIncomesSpouseNetIncome);
			request.getRequesterSpouseIncomes().setSpousePensions(this.requesterSpouseIncomesSpousePensions);
			request.getRequesterSpouseIncomes().setSpouseAllowances(this.requesterSpouseIncomesSpouseAllowances);
			request.getRequesterIncomes().setRequesterNetIncome(this.requesterIncomesRequesterNetIncome);
			request.getRequesterIncomes().setRequesterAllowances(this.requesterIncomesRequesterAllowances);
			request.getRequesterSpouseIncomes().setSpouseInvestmentIncome(this.requesterSpouseIncomesSpouseInvestmentIncome);
		}
	}
	
	public boolean isComplete() {
		return true;
	}
	
	public void setRequesterIncomesRequesterPensions(java.math.BigInteger requesterIncomesRequesterPensions) {
		this.requesterIncomesRequesterPensions = requesterIncomesRequesterPensions;
	}
	
	public java.math.BigInteger getRequesterIncomesRequesterPensions() {
		return this.requesterIncomesRequesterPensions;
	}
	
	public boolean checkRequesterIncomesRequesterPensions() {
		return true;
	}

	public void setRequesterIncomesRequesterInvestmentIncome(java.math.BigInteger requesterIncomesRequesterInvestmentIncome) {
		this.requesterIncomesRequesterInvestmentIncome = requesterIncomesRequesterInvestmentIncome;
	}
	
	public java.math.BigInteger getRequesterIncomesRequesterInvestmentIncome() {
		return this.requesterIncomesRequesterInvestmentIncome;
	}
	
	public boolean checkRequesterIncomesRequesterInvestmentIncome() {
		return true;
	}

	public void setRequesterSpouseIncomesSpouseNetIncome(java.math.BigInteger requesterSpouseIncomesSpouseNetIncome) {
		this.requesterSpouseIncomesSpouseNetIncome = requesterSpouseIncomesSpouseNetIncome;
	}
	
	public java.math.BigInteger getRequesterSpouseIncomesSpouseNetIncome() {
		return this.requesterSpouseIncomesSpouseNetIncome;
	}
	
	public boolean checkRequesterSpouseIncomesSpouseNetIncome() {
		return true;
	}

	public void setRequesterSpouseIncomesSpousePensions(java.math.BigInteger requesterSpouseIncomesSpousePensions) {
		this.requesterSpouseIncomesSpousePensions = requesterSpouseIncomesSpousePensions;
	}
	
	public java.math.BigInteger getRequesterSpouseIncomesSpousePensions() {
		return this.requesterSpouseIncomesSpousePensions;
	}
	
	public boolean checkRequesterSpouseIncomesSpousePensions() {
		return true;
	}

	public void setRequesterSpouseIncomesSpouseAllowances(java.math.BigInteger requesterSpouseIncomesSpouseAllowances) {
		this.requesterSpouseIncomesSpouseAllowances = requesterSpouseIncomesSpouseAllowances;
	}
	
	public java.math.BigInteger getRequesterSpouseIncomesSpouseAllowances() {
		return this.requesterSpouseIncomesSpouseAllowances;
	}
	
	public boolean checkRequesterSpouseIncomesSpouseAllowances() {
		return true;
	}

	public void setRequesterIncomesRequesterNetIncome(java.math.BigInteger requesterIncomesRequesterNetIncome) {
		this.requesterIncomesRequesterNetIncome = requesterIncomesRequesterNetIncome;
	}
	
	public java.math.BigInteger getRequesterIncomesRequesterNetIncome() {
		return this.requesterIncomesRequesterNetIncome;
	}
	
	public boolean checkRequesterIncomesRequesterNetIncome() {
		return true;
	}

	public void setRequesterIncomesRequesterAllowances(java.math.BigInteger requesterIncomesRequesterAllowances) {
		this.requesterIncomesRequesterAllowances = requesterIncomesRequesterAllowances;
	}
	
	public java.math.BigInteger getRequesterIncomesRequesterAllowances() {
		return this.requesterIncomesRequesterAllowances;
	}
	
	public boolean checkRequesterIncomesRequesterAllowances() {
		return true;
	}

	public void setRequesterSpouseIncomesSpouseInvestmentIncome(java.math.BigInteger requesterSpouseIncomesSpouseInvestmentIncome) {
		this.requesterSpouseIncomesSpouseInvestmentIncome = requesterSpouseIncomesSpouseInvestmentIncome;
	}
	
	public java.math.BigInteger getRequesterSpouseIncomesSpouseInvestmentIncome() {
		return this.requesterSpouseIncomesSpouseInvestmentIncome;
	}
	
	public boolean checkRequesterSpouseIncomesSpouseInvestmentIncome() {
		return true;
	}

}
