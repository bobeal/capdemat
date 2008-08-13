package fr.cg95.cvq.fo.citizen.form;

import java.util.Calendar;
import java.util.Collection;
import java.util.List;
import javax.servlet.http.HttpSession;
import fr.cg95.cvq.wizard.*;
import fr.cg95.cvq.xml.common.*;
import fr.cg95.cvq.xml.ecitizen.*;
import fr.cg95.cvq.xml.ecitizen.VoCardRequestDocument.VoCardRequest;

public class Account extends IStageForm {

	private String loginConfirmPassword;
	private String loginPassword;
	private String loginAnswer;
	private String loginQuestion;
	private boolean loginNewAccount;

	public Account() {
		super();
	}
	
	public void reset(String state) {
		if (state.equals("account")) {
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
		if (this.checkLoginConfirmPassword() &&
			((this.loginConfirmPassword == null) || (this.loginConfirmPassword.length() == 0)))
			return false;
		if (this.checkLoginPassword() &&
			((this.loginPassword == null) || (this.loginPassword.length() == 0)))
			return false;
		if (this.checkLoginAnswer() &&
			((this.loginAnswer == null) || (this.loginAnswer.length() == 0)))
			return false;
		if (this.checkLoginQuestion() &&
			((this.loginQuestion == null) || (this.loginQuestion.length() == 0)))
			return false;
		return true;
	}
	
	public void setLoginConfirmPassword(String loginConfirmPassword) {
		this.loginConfirmPassword = loginConfirmPassword;
	}
	
	public String getLoginConfirmPassword() {
		return this.loginConfirmPassword;
	}
	
	public boolean checkLoginConfirmPassword() {
		return true;
	}

	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}
	
	public String getLoginPassword() {
		return this.loginPassword;
	}
	
	public boolean checkLoginPassword() {
		return true;
	}

	public void setLoginAnswer(String loginAnswer) {
		this.loginAnswer = loginAnswer;
	}
	
	public String getLoginAnswer() {
		return this.loginAnswer;
	}
	
	public boolean checkLoginAnswer() {
		return true;
	}

	public void setLoginQuestion(String loginQuestion) {
		this.loginQuestion = loginQuestion;
	}
	
	public String getLoginQuestion() {
		return this.loginQuestion;
	}
	
	public boolean checkLoginQuestion() {
		return true;
	}

	public void setLoginNewAccount(boolean loginNewAccount) {
		this.loginNewAccount = loginNewAccount;
	}
	
	public boolean getLoginNewAccount() {
		return this.loginNewAccount;
	}
	
	public boolean checkLoginNewAccount() {
		return true;
	}

}
