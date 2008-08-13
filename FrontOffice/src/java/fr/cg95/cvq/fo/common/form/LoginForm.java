/*
 * Cartevaloise 
 *
 * Copyright (C) 2004, 2005 Conseil Général du Val d'Oise. All Rights
 * Reserved.
 *
 * Managed and developed by 
 *        Bruno Perrin, Philippe Usclade and René le Clercq 
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License as
 * published by the Free Software Foundation; either version 2 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA
 * 02111-1307, USA.
 */
package fr.cg95.cvq.fo.common.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.ValidatorForm;

import fr.cg95.cvq.fo.common.FamilyHome;
import fr.cg95.cvq.fo.dispatcher.SessionManager;
import fr.cg95.cvq.security.SecurityContext;
import fr.cg95.cvq.wizard.manager.ManagerWizardState;

/**
 * @author Laurent MARQUEZ
 *  
 */
public class LoginForm extends ValidatorForm {

	private Long _adultId;

	private String _userName;

	private String _oldPassword;

	private String _password;

	private String _passwordConfirm;

	private String _question;

	private String _answer;

	private String _acknowledge;

	private String _acknowledgeValue;

	private String _method;

	private String _publicKey;

	private Boolean _newLogin = null;

	private String _certificate;
	private String _signature;
	
	private String _context = SecurityContext.FRONT_OFFICE_CONTEXT;
	
	public LoginForm() {
		super();
	}

	/**
	 * @return Returns the acknowledge.
	 */
	public String getAcknowledge() {
		return _acknowledge;
	}

	/**
	 * @param pAcknowledge
	 *            The acknowledge to set.
	 */
	public void setAcknowledge(String pAcknowledge) {
		_acknowledge = pAcknowledge;
	}

	/**
	 * @return Returns the answer.
	 */
	public String getAnswer() {
		return _answer;
	}

	/**
	 * @param pAnswer
	 *            The answer to set.
	 */
	public void setAnswer(String pAnswer) {
		_answer = pAnswer;
	}

	/**
	 * @return Returns the login.
	 */
	public String getUserName() {
		return _userName;
	}

	/**
	 * @param pLogin
	 *            The login to set.
	 */
	public void setUserName(String pLogin) {
		_userName = pLogin;
	}

	/**
	 * @return Returns the password.
	 */
	public String getPassword() {
		return _password;
	}

	/**
	 * @param pPassword
	 *            The password to set.
	 */
	public void setPassword(String pPassword) {
		_password = pPassword;
	}

	/**
	 * @return Returns the passwordConfirm.
	 */
	public String getPasswordConfirm() {
		return _passwordConfirm;
	}

	/**
	 * @param pPasswordConfirm
	 *            The passwordConfirm to set.
	 */
	public void setPasswordConfirm(String pPasswordConfirm) {
		_passwordConfirm = pPasswordConfirm;
	}

	/**
	 * @return Returns the question.
	 */
	public String getQuestion() {
		return _question;
	}

	/**
	 * @param pQuestion
	 *            The question to set.
	 */
	public void setQuestion(String pQuestion) {
		_question = pQuestion;
	}
	/**
	 * @return Returns the method.
	 */
	public String getMethod() {
		return _method;
	}
	/**
	 * @param pMethod The method to set.
	 */
	public void setMethod(String pMethod) {
		_method = pMethod;
	}
	/**
	 * @return Returns the acknowledgeValue.
	 */
	public String getAcknowledgeValue() {
		return _acknowledgeValue;
	}
	/**
	 * @param pAcknowledgeValue The acknowledgeValue to set.
	 */
	public void setAcknowledgeValue(String pAcknowledgeValue) {
		_acknowledgeValue = pAcknowledgeValue;
	}

	public String getPublicKey() {
		return _publicKey;
	}

	public void setPublicKey(String string) {
		_publicKey = string;
	}

	public String getOldPassword() {
		return _oldPassword;
	}

	public void setOldPassword(String string) {
		_oldPassword = string;
	}

	public void reset(ActionMapping mapping, HttpServletRequest request) {

		FamilyHome familyHome = SessionManager.getFamilyHome(request);

		if ((familyHome != null) && (familyHome.getId() != null) && !familyHome.isNewResponsible())
			_newLogin = null;
		else if (_newLogin == null)
			_newLogin = new Boolean(true);

		if ((familyHome != null) && (familyHome.getLogin() != null)) {
			String transition = request.getParameter(ManagerWizardState.TRANSITION_REQUEST_PARAMETER);
			if ((transition == null) || !transition.equals("password")) {
				_password = familyHome.getLogin().getPassword();
				_passwordConfirm = familyHome.getLogin().getPassword();
				_question = familyHome.getLogin().getQuestion();
				_answer = familyHome.getLogin().getAnswer();
				_acknowledge = familyHome.getLogin().getAcknowledge();
				_acknowledgeValue = familyHome.getLogin().getAcknowledgeValue();
			}
			if ((_newLogin != null) && (familyHome.getLogin().getOldPassword() == null)) {
				_password = "";
				_passwordConfirm = "";
				familyHome.getLogin().setOldPassword(familyHome.getLogin().getPassword());
			}
		}
		super.reset(mapping, request);
	}

	public Boolean getNewLogin() {
		return _newLogin;
	}

	public Long getAdultId() {
		return _adultId;
	}

	public void setAdultId(Long long1) {
		_adultId = long1;
	}

	public String getCertificate() {
		return _certificate;
	}

	public String getSignature() {
		return _signature;
	}

	public void setCertificate(String string) {
		_certificate = string;
	}

	public void setSignature(String string) {
		_signature = string;
	}

	public String getContext() {
		return _context;
	}

	public void setContext(String context) {
		_context = context;
	}

}