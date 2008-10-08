package fr.cg95.cvq.fo.social.domestichelp.form;

import java.util.Calendar;
import java.util.Collection;
import java.util.List;
import javax.servlet.http.HttpSession;
import fr.cg95.cvq.wizard.*;
import fr.cg95.cvq.xml.common.*;
import fr.cg95.cvq.xml.social.*;
import fr.cg95.cvq.xml.social.DomesticHelpRequestDocument.DomesticHelpRequest;

public class Expenses extends IStageForm {

	private java.math.BigInteger mensualExpensesRent;
	private java.math.BigInteger mensualExpensesAlimonies;

	public Expenses() {
		super();
	}
	
	public void reset(String state) {
		if (state.equals("display")) {
		}
		if (state.equals("expenses")) {
		}
	}
	
	public void load(HttpSession session, Object xmlbRequest) {
		if ((xmlbRequest != null) && (xmlbRequest instanceof DomesticHelpRequest)) {
			DomesticHelpRequest request = (DomesticHelpRequest)xmlbRequest;
			this.mensualExpensesRent = request.getMensualExpenses().getRent();
			this.mensualExpensesAlimonies = request.getMensualExpenses().getAlimonies();
		}
	}
	
	public void save(HttpSession session, Object xmlbRequest) {
		if ((xmlbRequest != null) && (xmlbRequest instanceof DomesticHelpRequest)) {
			DomesticHelpRequest request = (DomesticHelpRequest)xmlbRequest;
			request.getMensualExpenses().setRent(this.mensualExpensesRent);
			request.getMensualExpenses().setAlimonies(this.mensualExpensesAlimonies);
		}
	}
	
	public boolean isComplete() {
		return true;
	}
	
	public void setMensualExpensesRent(java.math.BigInteger mensualExpensesRent) {
		this.mensualExpensesRent = mensualExpensesRent;
	}
	
	public java.math.BigInteger getMensualExpensesRent() {
		return this.mensualExpensesRent;
	}
	
	public boolean checkMensualExpensesRent() {
		return true;
	}

	public void setMensualExpensesAlimonies(java.math.BigInteger mensualExpensesAlimonies) {
		this.mensualExpensesAlimonies = mensualExpensesAlimonies;
	}
	
	public java.math.BigInteger getMensualExpensesAlimonies() {
		return this.mensualExpensesAlimonies;
	}
	
	public boolean checkMensualExpensesAlimonies() {
		return true;
	}

}
