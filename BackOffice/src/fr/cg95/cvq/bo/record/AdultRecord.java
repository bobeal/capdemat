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
 package fr.cg95.cvq.bo.record;

import fr.cg95.cvq.wizard.StringUtils;


/**
 * @author René le CLERCQ
 */
public class AdultRecord extends IndividualRecord {

	private static final long serialVersionUID = -3556091329277195982L;

	private String title;

	private String maidenName;

	private String userName;

	private String familyStatus;

	private String homePhone;

	private String mobilePhone;

	private String officePhone;

	private String email;

	private String caseOfFamilyBenifitsNumber;

	private String profession;

	private String companyName;

	private String companyAddress;

	private String quality;
	
	private String role;

	private boolean familyHomeResponsible = false;

	private String method;
	
	private String login;
	
	private String question;
	
	private String answer;

	public AdultRecord() {
		super();
	}

	public String getCompanyAddress() {
		return companyAddress;
	}

	public String getCompanyName() {
		return companyName;
	}

	public String getEmail() {
		return email;
	}

	public String getFamilyStatus() {
		return familyStatus;
	}

	public String getMaidenName() {
		return maidenName;
	}

	public String getMobilePhone() {
		return mobilePhone;
	}

	public String getOfficePhone() {
		return officePhone;
	}

	public String getProfession() {
		return profession;
	}

	public String getTitle() {
		return title;
	}

	public void setCompanyAddress(String string) {
		companyAddress = string;
	}

	public void setCompanyName(String string) {
		companyName = string;
	}

	public void setEmail(String string) {
		email = string;
	}

	public void setFamilyStatus(String string) {
		familyStatus = string;
	}

	public void setMaidenName(String string) {
		maidenName = string;
	}

	public void setMobilePhone(String string) {
		mobilePhone = string;
	}

	public void setOfficePhone(String string) {
		officePhone = string;
	}

	public void setProfession(String string) {
		profession = string;
	}

	public void setTitle(String string) {
		title = string;
	}

	public String getCaseOfFamilyBenifitsNumber() {
		if (caseOfFamilyBenifitsNumber == null)
			return "";
			
		return caseOfFamilyBenifitsNumber.toString();
	}

	public String getHomePhone() {
		return homePhone;
	}

	public boolean isFamilyHomeResponsible() {
		return familyHomeResponsible;
	}

	public String getMethod() {
		return method;
	}

	public String getQuality() {
		return quality;
	}

	public String getUserName() {
		return userName;
	}

	public void setCaseOfFamilyBenifitsNumber(String s) {
		caseOfFamilyBenifitsNumber = s;
	}

	public void setHomePhone(String string) {
		homePhone = string;
	}

	public void setFamilyHomeResponsible(boolean b) {
		familyHomeResponsible = b;
	}

	public void setMethod(String string) {
		method = string;
	}

	public void setQuality(String string) {
		quality = string;
	}

	public void setUserName(String string) {
		userName = string;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String string) {
		role = string;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

    public String getDisplayLogin(String maxDisplayLength) {
        try {
            int maxChars = Integer.parseInt(maxDisplayLength);
            return StringUtils.split(login, maxChars);
        } catch (NumberFormatException e) {
        } 
        return login;
    }

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

}
