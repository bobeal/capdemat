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

import java.util.Date;

import fr.cg95.cvq.fo.util.Constants;
import fr.cg95.cvq.fo.util.TimeHandler;
import fr.cg95.cvq.wizard.StringUtils;

public class IndividualForm {

	private Long id;

	private String lastName;

	private String firstName;

	private String firstNameTwo;

	private String firstNameThree;
    
    private Date birthDate;

	private String birthDay;

	private String birthMonth;

	private String birthYear;

	private String birthPlaceCountry;

	private String birthPlaceCity;

	private String birthPlacePostalCode;

	private String nationality;

    private String additionalDeliveryInformation;
    private String additionalGeographicalInformation;
    private String streetNumber;
    private String streetName;
    private String placeNameOrService;
    private String postalCode;
    private String city;

	private String method;

	public IndividualForm() {
	}

	public String getBirthDate() {
        if (birthDate != null)
            return TimeHandler.parseDate(birthDate, Constants.BIRTHDAY_DATE_FORMAT);
        
        return "";
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    /**
	 * @return Returns the birthDay.
	 */
	public String getBirthDay() {
		return birthDay;
	}

	/**
	 * @param pBirthDay
	 *            The birthDay to set.
	 */
	public void setBirthDay(String pBirthDay) {
		birthDay = pBirthDay;
	}

	/**
	 * @return Returns the birthMonth.
	 */
	public String getBirthMonth() {
		return birthMonth;
	}

	/**
	 * @param pBirthMonth
	 *            The birthMonth to set.
	 */
	public void setBirthMonth(String pBirthMonth) {
		birthMonth = pBirthMonth;
	}

	/**
	 * @return Returns the birthPlaceCity.
	 */
	public String getBirthPlaceCity() {
		return birthPlaceCity;
	}

	/**
	 * @param pBirthPlaceCity
	 *            The birthPlaceCity to set.
	 */
	public void setBirthPlaceCity(String pBirthPlaceCity) {
		birthPlaceCity = pBirthPlaceCity;
	}

	/**
	 * @return Returns the birthPlaceCountry.
	 */
	public String getBirthPlaceCountry() {
		return birthPlaceCountry;
	}

	/**
	 * @param pBirthPlaceCountry
	 *            The birthPlaceCountry to set.
	 */
	public void setBirthPlaceCountry(String pBirthPlaceCountry) {
		birthPlaceCountry = pBirthPlaceCountry;
	}

	/**
	 * @return Returns the birthPlacePostalCode.
	 */
	public String getBirthPlacePostalCode() {
		return birthPlacePostalCode;
	}

	/**
	 * @param pBirthPlacePostalCode
	 *            The birthPlacePostalCode to set.
	 */
	public void setBirthPlacePostalCode(String pBirthPlacePostalCode) {
		birthPlacePostalCode = pBirthPlacePostalCode;
	}

	/**
	 * @return Returns the birthYear.
	 */
	public String getBirthYear() {
		return birthYear;
	}

	/**
	 * @param pBirthYear
	 *            The birthYear to set.
	 */
	public void setBirthYear(String pBirthYear) {
		birthYear = pBirthYear;
	}

	/**
	 * @return Returns the firstName.
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param pFirstName
	 *            The firstName to set.
	 */
	public void setFirstName(String pFirstName) {
		// firstName = pFirstName.replaceAll(" ","");
		firstName = pFirstName;
	}

	/**
	 * @return Returns the firstNameThree.
	 */
	public String getFirstNameThree() {
		return firstNameThree;
	}

	/**
	 * @param pFirstNameThree
	 *            The firstNameThree to set.
	 */
	public void setFirstNameThree(String pFirstNameThree) {
		firstNameThree = pFirstNameThree;
	}

	/**
	 * @return Returns the firstNameTwo.
	 */
	public String getFirstNameTwo() {
		return firstNameTwo;
	}

	/**
	 * @param pFirstNameTwo
	 *            The firstNameTwo to set.
	 */
	public void setFirstNameTwo(String pFirstNameTwo) {
		firstNameTwo = pFirstNameTwo;
	}

	/**
	 * @return Returns the id.
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param pId
	 *            The id to set.
	 */
	public void setId(Long pId) {
		id = pId;
	}

	/**
	 * @return Returns the lastName.
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param pLastName
	 *            The lastName to set.
	 */
	public void setLastName(String pLastName) {
		// lastName = pLastName.replaceAll(" ","");
		lastName = pLastName;
	}

	/**
	 * @return Returns the method.
	 */
	public String getMethod() {
		return method;
	}

	/**
	 * @param pMethod
	 *            The method to set.
	 */
	public void setMethod(String pMethod) {
		method = pMethod;
	}

	/**
	 * @return Returns the nationality.
	 */
	public String getNationality() {
		return nationality;
	}

	/**
	 * @param pNationality
	 *            The nationality to set.
	 */
	public void setNationality(String pNationality) {
		nationality = pNationality;
	}

	public String getFullName(String maxDisplayLength) {
	    try {
    	    int maxChars = Integer.parseInt(maxDisplayLength);
    		return StringUtils.truncateLine(firstName + " " + lastName, maxChars);
	    } catch (NumberFormatException e) {
        } 
	    return firstName + " " + lastName;
	}

	/**
	 * @return Returns the postalCode.
	 */
	public String getPostalCode() {
		return postalCode;
	}

	/**
	 * @param pPostalCode
	 *            The postalCode to set.
	 */
	public void setPostalCode(String pPostalCode) {
		postalCode = pPostalCode;
	}

	/**
	 * @return Returns the city.
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param pCity
	 *            The city to set.
	 */
	public void setCity(String pCity) {
		city = pCity;
	}

    public String getAdditionalDeliveryInformation() {
        return additionalDeliveryInformation;
    }

    public void setAdditionalDeliveryInformation(String additionalDeliveryInformation) {
        this.additionalDeliveryInformation = additionalDeliveryInformation;
    }

    public String getAdditionalGeographicalInformation() {
        return additionalGeographicalInformation;
    }

    public void setAdditionalGeographicalInformation(String additionalGeographicalInformation) {
        this.additionalGeographicalInformation = additionalGeographicalInformation;
    }

    public String getPlaceNameOrService() {
        return placeNameOrService;
    }

    public void setPlaceNameOrService(String placeNameOrService) {
        this.placeNameOrService = placeNameOrService;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }

}