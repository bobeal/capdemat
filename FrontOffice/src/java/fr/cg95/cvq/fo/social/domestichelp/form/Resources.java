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

	private java.math.BigInteger requesterSpouseIncomesSpousePensions;
	private java.math.BigInteger requesterIncomesRequesterNetIncome;
	private java.math.BigInteger requesterSpouseIncomesSpouseRealEstateInvestmentIncome;
	private java.math.BigInteger requesterIncomesRequesterPensions;
	private java.math.BigInteger requesterIncomesRequesterRealEstateInvestmentIncome;
	private java.math.BigInteger requesterIncomesRequesterAllowances;
	private java.math.BigInteger requesterSpouseIncomesSpouseNetIncome;
	private java.math.BigInteger requesterIncomesRequesterFurnitureInvestmentIncome;
	private java.math.BigInteger requesterSpouseIncomesSpouseAllowances;
	private java.math.BigInteger requesterSpouseIncomesSpouseFurnitureInvestmentIncome;

	public Resources() {
		super();
	}
	
	public void reset(String state) {
		if (state.equals("spouse")) {
		}
		if (state.equals("subject")) {
		}
		if (state.equals("displayspouse")) {
		}
		if (state.equals("display")) {
		}
	}
	
	public void load(HttpSession session, Object xmlbRequest) {
		if ((xmlbRequest != null) && (xmlbRequest instanceof DomesticHelpRequest)) {
			DomesticHelpRequest request = (DomesticHelpRequest)xmlbRequest;
			this.requesterSpouseIncomesSpousePensions = request.getRequesterSpouseIncomes().getSpousePensions();
			this.requesterIncomesRequesterNetIncome = request.getRequesterIncomes().getRequesterNetIncome();
			this.requesterSpouseIncomesSpouseRealEstateInvestmentIncome = request.getRequesterSpouseIncomes().getSpouseRealEstateInvestmentIncome();
			this.requesterIncomesRequesterPensions = request.getRequesterIncomes().getRequesterPensions();
			this.requesterIncomesRequesterRealEstateInvestmentIncome = request.getRequesterIncomes().getRequesterRealEstateInvestmentIncome();
			this.requesterIncomesRequesterAllowances = request.getRequesterIncomes().getRequesterAllowances();
			this.requesterSpouseIncomesSpouseNetIncome = request.getRequesterSpouseIncomes().getSpouseNetIncome();
			this.requesterIncomesRequesterFurnitureInvestmentIncome = request.getRequesterIncomes().getRequesterFurnitureInvestmentIncome();
			this.requesterSpouseIncomesSpouseAllowances = request.getRequesterSpouseIncomes().getSpouseAllowances();
			this.requesterSpouseIncomesSpouseFurnitureInvestmentIncome = request.getRequesterSpouseIncomes().getSpouseFurnitureInvestmentIncome();
		}
	}
	
	public void save(HttpSession session, Object xmlbRequest) {
		if ((xmlbRequest != null) && (xmlbRequest instanceof DomesticHelpRequest)) {
			DomesticHelpRequest request = (DomesticHelpRequest)xmlbRequest;
			request.getRequesterSpouseIncomes().setSpousePensions(this.requesterSpouseIncomesSpousePensions);
			request.getRequesterIncomes().setRequesterNetIncome(this.requesterIncomesRequesterNetIncome);
			request.getRequesterSpouseIncomes().setSpouseRealEstateInvestmentIncome(this.requesterSpouseIncomesSpouseRealEstateInvestmentIncome);
			request.getRequesterIncomes().setRequesterPensions(this.requesterIncomesRequesterPensions);
			request.getRequesterIncomes().setRequesterRealEstateInvestmentIncome(this.requesterIncomesRequesterRealEstateInvestmentIncome);
			request.getRequesterIncomes().setRequesterAllowances(this.requesterIncomesRequesterAllowances);
			request.getRequesterSpouseIncomes().setSpouseNetIncome(this.requesterSpouseIncomesSpouseNetIncome);
			request.getRequesterIncomes().setRequesterFurnitureInvestmentIncome(this.requesterIncomesRequesterFurnitureInvestmentIncome);
			request.getRequesterSpouseIncomes().setSpouseAllowances(this.requesterSpouseIncomesSpouseAllowances);
			request.getRequesterSpouseIncomes().setSpouseFurnitureInvestmentIncome(this.requesterSpouseIncomesSpouseFurnitureInvestmentIncome);
		}
	}
	
	public boolean isComplete() {
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

	public void setRequesterIncomesRequesterNetIncome(java.math.BigInteger requesterIncomesRequesterNetIncome) {
		this.requesterIncomesRequesterNetIncome = requesterIncomesRequesterNetIncome;
	}
	
	public java.math.BigInteger getRequesterIncomesRequesterNetIncome() {
		return this.requesterIncomesRequesterNetIncome;
	}
	
	public boolean checkRequesterIncomesRequesterNetIncome() {
		return true;
	}

	public void setRequesterSpouseIncomesSpouseRealEstateInvestmentIncome(java.math.BigInteger requesterSpouseIncomesSpouseRealEstateInvestmentIncome) {
		this.requesterSpouseIncomesSpouseRealEstateInvestmentIncome = requesterSpouseIncomesSpouseRealEstateInvestmentIncome;
	}
	
	public java.math.BigInteger getRequesterSpouseIncomesSpouseRealEstateInvestmentIncome() {
		return this.requesterSpouseIncomesSpouseRealEstateInvestmentIncome;
	}
	
	public boolean checkRequesterSpouseIncomesSpouseRealEstateInvestmentIncome() {
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

	public void setRequesterIncomesRequesterRealEstateInvestmentIncome(java.math.BigInteger requesterIncomesRequesterRealEstateInvestmentIncome) {
		this.requesterIncomesRequesterRealEstateInvestmentIncome = requesterIncomesRequesterRealEstateInvestmentIncome;
	}
	
	public java.math.BigInteger getRequesterIncomesRequesterRealEstateInvestmentIncome() {
		return this.requesterIncomesRequesterRealEstateInvestmentIncome;
	}
	
	public boolean checkRequesterIncomesRequesterRealEstateInvestmentIncome() {
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

	public void setRequesterSpouseIncomesSpouseNetIncome(java.math.BigInteger requesterSpouseIncomesSpouseNetIncome) {
		this.requesterSpouseIncomesSpouseNetIncome = requesterSpouseIncomesSpouseNetIncome;
	}
	
	public java.math.BigInteger getRequesterSpouseIncomesSpouseNetIncome() {
		return this.requesterSpouseIncomesSpouseNetIncome;
	}
	
	public boolean checkRequesterSpouseIncomesSpouseNetIncome() {
		return true;
	}

	public void setRequesterIncomesRequesterFurnitureInvestmentIncome(java.math.BigInteger requesterIncomesRequesterFurnitureInvestmentIncome) {
		this.requesterIncomesRequesterFurnitureInvestmentIncome = requesterIncomesRequesterFurnitureInvestmentIncome;
	}
	
	public java.math.BigInteger getRequesterIncomesRequesterFurnitureInvestmentIncome() {
		return this.requesterIncomesRequesterFurnitureInvestmentIncome;
	}
	
	public boolean checkRequesterIncomesRequesterFurnitureInvestmentIncome() {
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

	public void setRequesterSpouseIncomesSpouseFurnitureInvestmentIncome(java.math.BigInteger requesterSpouseIncomesSpouseFurnitureInvestmentIncome) {
		this.requesterSpouseIncomesSpouseFurnitureInvestmentIncome = requesterSpouseIncomesSpouseFurnitureInvestmentIncome;
	}
	
	public java.math.BigInteger getRequesterSpouseIncomesSpouseFurnitureInvestmentIncome() {
		return this.requesterSpouseIncomesSpouseFurnitureInvestmentIncome;
	}
	
	public boolean checkRequesterSpouseIncomesSpouseFurnitureInvestmentIncome() {
		return true;
	}

}