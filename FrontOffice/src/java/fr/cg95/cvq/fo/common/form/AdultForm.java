/*
 * Cartevaloise
 * 
 * Copyright (C) 2004 Conseil Général du Val d'Oise. All Rights Reserved.
 * 
 * Developed by Laurent Marquez (ARTAL Technologies) and René le Clercq
 * 
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation; either version 2 of the License, or (at your option) any later
 * version.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 * 
 * You should have received a copy of the GNU General Public License along with
 * this program; if not, write to the Free Software Foundation, Inc., 59 Temple
 * Place - Suite 330, Boston, MA 02111-1307, USA.
 */

package fr.cg95.cvq.fo.common.form;

import fr.cg95.cvq.wizard.StringUtils;


/**
 * @author Laurent MARQUEZ
 * 
 */
public class AdultForm extends IndividualForm {
    private int index = -1;

    private String _title;

    private String _quality;

    private String _familyStatus;

    private String _sex;

    private boolean _familyHomeResponsible = false;

    private String _domicilePhone;

    private String _officePhone;

    private String _mobilePhone;

    private String _email;

    private String _userName;

    private String _maidenName;

    private String _caseOfFamilyBenifitsNumber;

    private String _profession;

    private String _companyName;

    private String _companyAddress;
    
    private String _login;
    
    private String _question;
    
    private String _answer;

    /**
     * An adult that is the legal responsible of a child does not necessary belong to an home folder
     */
    private boolean _externalToHomeFolder = false;

    public AdultForm() {

    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    /**
     * @return Returns the sex.
     */
    public String getSex() {
        return _sex;
    }

    /**
     * @param pSex
     *            The sex to set.
     */
    public void setSex(String pSex) {
        _sex = pSex;
    }

    /**
     * @return Returns the familyStatus.
     */
    public String getFamilyStatus() {
        return _familyStatus;
    }

    /**
     * @param pFamilyStatus
     *            The familyStatus to set.
     */
    public void setFamilyStatus(String pFamilyStatus) {
        _familyStatus = pFamilyStatus;
    }

    /**
     * @return Returns the responsible.
     */
    public boolean isFamilyHomeResponsible() {
        return _familyHomeResponsible;
    }

    /**
     * @param pResponsible
     *            The responsible to set.
     */
    public void setFamilyHomeResponsible(boolean pResponsible) {
        _familyHomeResponsible = pResponsible;
    }

    public boolean isExternalToHomeFolder() {
        return _externalToHomeFolder;
    }

    public void setExternalToHomeFolder(boolean pExternalToHomeFolder) {
        _externalToHomeFolder = pExternalToHomeFolder;
    }

    /**
     * @return Returns the domicilePhone.
     */
    public String getDomicilePhone() {
        return _domicilePhone;
    }

    /**
     * @param pDomicilePhone
     *            The domicilePhone to set.
     */
    public void setDomicilePhone(String pDomicilePhone) {
        _domicilePhone = pDomicilePhone;
    }

    /**
     * @return Returns the mobilePhone.
     */
    public String getMobilePhone() {
        return _mobilePhone;
    }

    /**
     * @param pMobilePhone
     *            The mobilePhone to set.
     */
    public void setMobilePhone(String pMobilePhone) {
        _mobilePhone = pMobilePhone;
    }

    /**
     * @return Returns the officePhone.
     */
    public String getOfficePhone() {
        return _officePhone;
    }

    /**
     * @param pOfficePhone
     *            The officePhone to set.
     */
    public void setOfficePhone(String pOfficePhone) {
        _officePhone = pOfficePhone;
    }

    /**
     * @return Returns the email.
     */
    public String getEmail() {
        return _email;
    }

    /**
     * @param pEmail
     *            The email to set.
     */
    public void setEmail(String pEmail) {
        _email = pEmail;
    }

    /**
     * @return Returns the title.
     */
    public String getTitle() {
        return _title;
    }

    /**
     * @param pTitle
     *            The title to set.
     */
    public void setTitle(String pTitle) {
        _title = pTitle;
    }

    /**
     * @return Returns the usageName.
     */
    public String getUserName() {
        return _userName;
    }

    /**
     * @param pUsageName
     *            The usageName to set.
     */
    public void setUserName(String pUsageName) {
        _userName = pUsageName;
    }

    /**
     * @return Returns the youngGirlName.
     */
    public String getMaidenName() {
        return _maidenName;
    }

    /**
     * @param pYoungGirlName
     *            The youngGirlName to set.
     */
    public void setMaidenName(String pYoungGirlName) {
        _maidenName = pYoungGirlName;
    }

    /**
     * @return Returns the caseOfFamilyBenifitsNumber.
     */
    public String getCaseOfFamilyBenifitsNumber() {
        return _caseOfFamilyBenifitsNumber;
    }

    /**
     * @param pCaseOfFamilyBenifitsNumber
     *            The caseOfFamilyBenifitsNumber to set.
     */
    public void setCaseOfFamilyBenifitsNumber(String pCaseOfFamilyBenifitsNumber) {
        _caseOfFamilyBenifitsNumber = pCaseOfFamilyBenifitsNumber;
    }

    /**
     * @return Returns the companyAdress.
     */
    public String getCompanyAddress() {
        return _companyAddress;
    }

    /**
     * @param pCompanyAdress
     *            The companyAdress to set.
     */
    public void setCompanyAddress(String pCompanyAdress) {
        _companyAddress = pCompanyAdress;
    }

    /**
     * @return Returns the companyName.
     */
    public String getCompanyName() {
        return _companyName;
    }

    /**
     * @param pCompanyName
     *            The companyName to set.
     */
    public void setCompanyName(String pCompanyName) {
        _companyName = pCompanyName;
    }

    /**
     * @return Returns the profession.
     */
    public String getProfession() {
        return _profession;
    }

    /**
     * @param pProfession
     *            The profession to set.
     */
    public void setProfession(String pProfession) {
        _profession = pProfession;
    }

    /**
     * @return Returns the quality.
     */
    public String getQuality() {
        return _quality;
    }

    /**
     * @param pQuality
     *            The quality to set.
     */
    public void setQuality(String pQuality) {
        _quality = pQuality;
    }

    public String getAnswer() {
        return _answer;
    }

    public void setAnswer(String answer) {
        _answer = answer;
    }

    public String getLogin() {
        return _login;
    }

    public String getDisplayLogin(String maxDisplayLength) {
        try {
            int maxChars = Integer.parseInt(maxDisplayLength);
            return StringUtils.split(_login, maxChars);
        } catch (NumberFormatException e) {
        } 
        return _login;
    }

    public void setLogin(String login) {
        _login = login;
    }

    public String getQuestion() {
        return _question;
    }

    public void setQuestion(String question) {
        _question = question;
    }

}