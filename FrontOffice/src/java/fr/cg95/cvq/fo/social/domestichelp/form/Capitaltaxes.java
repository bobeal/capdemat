package fr.cg95.cvq.fo.social.domestichelp.form;

import java.util.Calendar;
import java.util.Collection;
import java.util.List;
import javax.servlet.http.HttpSession;
import fr.cg95.cvq.wizard.*;
import fr.cg95.cvq.xml.common.*;
import fr.cg95.cvq.xml.social.*;
import fr.cg95.cvq.xml.social.DomesticHelpRequestDocument.DomesticHelpRequest;

public class Capitaltaxes extends IStageForm {

	private java.math.BigInteger capitalsSharesAmount;
	private java.math.BigInteger taxesAmountLocalRate;
	private java.math.BigInteger taxesAmountPropertyTaxes;
	private java.math.BigInteger taxesAmountIncomeTax;
	private java.math.BigInteger capitalsBondsAmount;
	private java.math.BigInteger taxesAmountProfessionalTaxes;

	public Capitaltaxes() {
		super();
	}
	
	public void reset(String state) {
		if (state.equals("displaycapital")) {
		}
		if (state.equals("capital")) {
		}
	}
	
	public void load(HttpSession session, Object xmlbRequest) {
		if ((xmlbRequest != null) && (xmlbRequest instanceof DomesticHelpRequest)) {
			DomesticHelpRequest request = (DomesticHelpRequest)xmlbRequest;
			this.capitalsSharesAmount = request.getCapitals().getSharesAmount();
			this.taxesAmountLocalRate = request.getTaxesAmount().getLocalRate();
			this.taxesAmountPropertyTaxes = request.getTaxesAmount().getPropertyTaxes();
			this.taxesAmountIncomeTax = request.getTaxesAmount().getIncomeTax();
			this.capitalsBondsAmount = request.getCapitals().getBondsAmount();
			this.taxesAmountProfessionalTaxes = request.getTaxesAmount().getProfessionalTaxes();
		}
	}
	
	public void save(HttpSession session, Object xmlbRequest) {
		if ((xmlbRequest != null) && (xmlbRequest instanceof DomesticHelpRequest)) {
			DomesticHelpRequest request = (DomesticHelpRequest)xmlbRequest;
			request.getCapitals().setSharesAmount(this.capitalsSharesAmount);
			request.getTaxesAmount().setLocalRate(this.taxesAmountLocalRate);
			request.getTaxesAmount().setPropertyTaxes(this.taxesAmountPropertyTaxes);
			request.getTaxesAmount().setIncomeTax(this.taxesAmountIncomeTax);
			request.getCapitals().setBondsAmount(this.capitalsBondsAmount);
			request.getTaxesAmount().setProfessionalTaxes(this.taxesAmountProfessionalTaxes);
		}
	}
	
	public boolean isComplete() {
		return true;
	}
	
	public void setCapitalsSharesAmount(java.math.BigInteger capitalsSharesAmount) {
		this.capitalsSharesAmount = capitalsSharesAmount;
	}
	
	public java.math.BigInteger getCapitalsSharesAmount() {
		return this.capitalsSharesAmount;
	}
	
	public boolean checkCapitalsSharesAmount() {
		return true;
	}

	public void setTaxesAmountLocalRate(java.math.BigInteger taxesAmountLocalRate) {
		this.taxesAmountLocalRate = taxesAmountLocalRate;
	}
	
	public java.math.BigInteger getTaxesAmountLocalRate() {
		return this.taxesAmountLocalRate;
	}
	
	public boolean checkTaxesAmountLocalRate() {
		return true;
	}

	public void setTaxesAmountPropertyTaxes(java.math.BigInteger taxesAmountPropertyTaxes) {
		this.taxesAmountPropertyTaxes = taxesAmountPropertyTaxes;
	}
	
	public java.math.BigInteger getTaxesAmountPropertyTaxes() {
		return this.taxesAmountPropertyTaxes;
	}
	
	public boolean checkTaxesAmountPropertyTaxes() {
		return true;
	}

	public void setTaxesAmountIncomeTax(java.math.BigInteger taxesAmountIncomeTax) {
		this.taxesAmountIncomeTax = taxesAmountIncomeTax;
	}
	
	public java.math.BigInteger getTaxesAmountIncomeTax() {
		return this.taxesAmountIncomeTax;
	}
	
	public boolean checkTaxesAmountIncomeTax() {
		return true;
	}

	public void setCapitalsBondsAmount(java.math.BigInteger capitalsBondsAmount) {
		this.capitalsBondsAmount = capitalsBondsAmount;
	}
	
	public java.math.BigInteger getCapitalsBondsAmount() {
		return this.capitalsBondsAmount;
	}
	
	public boolean checkCapitalsBondsAmount() {
		return true;
	}

	public void setTaxesAmountProfessionalTaxes(java.math.BigInteger taxesAmountProfessionalTaxes) {
		this.taxesAmountProfessionalTaxes = taxesAmountProfessionalTaxes;
	}
	
	public java.math.BigInteger getTaxesAmountProfessionalTaxes() {
		return this.taxesAmountProfessionalTaxes;
	}
	
	public boolean checkTaxesAmountProfessionalTaxes() {
		return true;
	}

}
