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

import java.util.Date;

import javax.servlet.jsp.PageContext;

import fr.cg95.cvq.bo.Utils;
import fr.cg95.cvq.bo.business.BusinessManager;
import fr.cg95.cvq.wizard.StringUtils;

/**
 * @author René le CLERCQ
 */
public class IndividualRecord extends BaseRecord {

	private static final long serialVersionUID = -4743817551011591839L;

	private Long id;

	private String lastName;

	private String firstName;

	private String firstName2;

	private String firstName3;

	private Date birthDate;

	private String birthPlace;
	
	private String birthPostalCode;
	
	private String birthCountry;

	private String nationality;

	private String sex;

    private String additionalDeliveryInformation;
    private String additionalGeographicalInformation;
    private String streetNumber;
    private String streetName;
    private String placeNameOrService;
    private String postalCode;
    private String city;

    private Long familyId;
    
    private String cardState;
    
    private Date cardDate;
    
    private Long cardId;

    private String state;
    
    private DisplayColumn familyColumns[] =
    {
        new DisplayColumn("familyId", "N° du compte", "text", true, "family", "validMember"),
        new DisplayColumn("lastName", "Nom de l'habitant", true, null, 18),
        new DisplayColumn("firstName", "Prénom", true, null, 18),
        new DisplayColumn("address", "Adresse", true, null),
        new DisplayColumn("birthDate", "Date de naissance", true, null),
        new DisplayColumn("state", "Etat du compte", true, null)};

    private DisplayColumn cardColumns[] =
    {
        new DisplayColumn("familyId", "N° du compte", "text", true, "family", "validMember"),
        new DisplayColumn("lastName", "Nom de l'habitant", true, null),
        new DisplayColumn("address", "Adresse", true, null),
        new DisplayColumn("cardId", "N° de la carte", true, "card"),
        new DisplayColumn("cardState", "Etat de la carte", true, null),
        new DisplayColumn("cardDate", "Date de création de la carte", true, null)};

    private boolean loaded = false;
    
	public IndividualRecord() {
		super();
	}

	public IndividualRecord(Long id) {
	    this.id = id;
	}

    public Long getResultId() {
        return id;
    }
    
    public void load() {
        if (!loaded) {
            BusinessManager.getIndividualRecord(this);
            loaded = true;
        }
    }

    public boolean isLoaded() {
        return loaded;
    }

	public String getValidMember() {
		if (getFamilyId() != null)
			return "select";
			
		return "hide";
	}

	
	public String getName() {
        return StringUtils.split(firstName + " " + lastName, 25);
	}

	/**
	 */
	public String getAddress() {
	    if (getStreetNumber() != null)
	        return getStreetNumber() + " " + getStreetName();
        
        return getStreetName();
	}

	/**
	 */
	public String getBirthDate() {
		return Utils.getDateAsString(birthDate);
	}

	public Date getBirthDateProperty() {
		return birthDate;
	}

	/**
	 */
	public String getBirthPlace() {
		return birthPlace;
	}

	/**
	 */
	public String getCity() {
		return city;
	}

	/**
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 */
	public String getFirstName2() {
		return firstName2;
	}

	/**
	 */
	public String getFirstName3() {
		return firstName3;
	}

	/**
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 */
	public String getNationality() {
		return nationality;
	}

	/**
	 */
	public String getPostalCode() {
		return postalCode;
	}

	/**
	 */
	public String getSex() {
		return sex;
	}

	/**
	 */
	public void setBirthDate(String date) {
		birthDate = Utils.getStringAsDate(date);
	}

	/**
	 */
	public void setBirthPlace(String string) {
		birthPlace = string;
	}

	/**
	 */
	public void setCity(String string) {
		city = string;
	}

	/**
	 */
	public void setFirstName(String string) {
		firstName = string;
	}

	/**
	 */
	public void setFirstName2(String string) {
		firstName2 = string;
	}

	/**
	 */
	public void setFirstName3(String string) {
		firstName3 = string;
	}

	/**
	 */
	public void setLastName(String string) {
		lastName = string;
	}

	/**
	 */
	public void setNationality(String string) {
		nationality = string;
	}

	/**
	 */
	public void setPostalCode(String string) {
		postalCode = string;
	}

	/**
	 */
	public void setSex(String string) {
		sex = string;
	}

	/**
	 */
	public Long getFamilyId() {
		return familyId;
	}

	/**
	 */
	public void setFamilyId(Long long1) {
		familyId = long1;
	}

	public String getBirthDay() {
		return getBirthDate();
	}

	public Long getId() {
		return id;
	}

	public void setBirthDay(String string) {
		setBirthDate(string);
	}

	public void setId(Long long1) {
		id = long1;
	}

	public String getBirthCountry() {
		return birthCountry;
	}

	public String getBirthPostalCode() {
		return birthPostalCode;
	}

	public void setBirthCountry(String string) {
		birthCountry = string;
	}

	public void setBirthPostalCode(String string) {
		birthPostalCode = string;
	}

    public String getCardDate() {
        return Utils.getDateAsString(cardDate);
    }

    public void setCardDate(Date cardDate) {
        this.cardDate = cardDate;
    }

    public String getCardState() {
        return cardState;
    }

    public void setCardState(String cardState) {
        this.cardState = cardState;
    }

	public Long getCardId() {
        return cardId;
    }

    public void setCardId(Long cardId) {
        this.cardId = cardId;
    }

    public DisplayColumn[] getDisplayColumns(PageContext pageContext, String type) {
        if ((type != null) && type.equals("card"))
            return cardColumns;
            
		return familyColumns;
	}

	public String getNavigateAction(PageContext pageContext) {
		return "searchAction";
	}

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
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
