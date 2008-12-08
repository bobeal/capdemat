package fr.cg95.cvq.generator.plugins.fo;

import org.apache.log4j.Logger;

/**
 * @author maxence.veyret@bull.net
 */
//==================================================================================================================
//Form Input Checking by JC
/*
	Apply these class names to form elements:
	* required (not blank)
	* validate-number (a valid number)
	* validate-digits (digits only, spaces allowed.)
	* validate-alpha (letters only)
	* validate-alphanum (only letters and numbers)
	* validate-date (a valid date value)
	* validate-email (a valid email address)
	* validate-url (a valid URL)
	* validate-date-au (a date formatted as; dd/mm/yyyy or d/m/yyyy)
	* validate-currency-dollar (a valid dollar value)
	* validate-one-required (At least one checkbox/radio element must be selected in a group)
	* validate-not-first (Selects only, must choose an option other than the first)
	* validate-not-empty (Selects only, must choose an option with a value that is not empty)
	* validate-regex (requires the element to have a 'regex=' attribute applied)

	Also, you can specify this attribute for text, passwird and textarea elements:
	* minlength="x" (where x is the minimum number of characters)
	
	Capdemat extension
	* validate-string
    * validate-token
    * validate-positiveinteger
    * validate-long
    * validate-postalcode
    * validate-departmentcode
    * validate-phone
    * validate-city
    * validate-firstname
    * validate-lastname
    * validate-cfbn
*/
//------------------------------------------------------------------------------------------------------------------
public class Validation {
	
    private static Logger logger = Logger.getLogger(Validation.class);
    
	private static final String SPACE = " ";
	private static final String REQUIRED = "required"; // minOccurs = 1 (depth ?)
	private static final String VALIDATE_NUMBER = "validate-number"; // POSITIVE_INTEGER_TYPE ???
	private static final String VALIDATE_DIGITS = "validate-digits"; // POSITIVE_INTEGER_TYPE ???
	private static final String VALIDATE_ALPHA = "validate-alpha";
	private static final String VALIDATE_ALPHANUM = "validate-alphanum";
	private static final String VALIDATE_DATE = "validate-date"; //DATE_TYPE
	private static final String VALIDATE_EMAIL = "validate-email"; // EMAIL_TYPE
	private static final String VALIDATE_URL = "validate-url";
	private static final String VALIDATE_DATE_AU = "validate-date-au";
	private static final String VALIDATE_CURRENCY_DOLLAR = "validate-currency-dollar";
	private static final String VALIDATE_ONE_REQUIRED = "validate-one-required"; // radio ou yesno
	private static final String VALIDATE_NOT_FIRST = "validate-not-first"; // select
	private static final String VALIDATE_NOT_EMPTY = "validate-not-empty";
	private static final String VALIDATE_REGEX = "validate-regex"; // other with regex in XSD

	// Capdemat Extension
	private static final String VALIDATE_STRING = "validate-string";
	private static final String VALIDATE_TOKEN = "validate-token";
	private static final String VALIDATE_POSITIVE_INTEGER = "validate-positiveinteger";
	private static final String VALIDATE_LONG = "validate-long";
	private static final String VALIDATE_POSTAL_CODE = "validate-postalcode";
	private static final String VALIDATE_DEPARTMENT_CODE = "validate-departmentcode";
	private static final String VALIDATE_PHONE = "validate-phone";
	private static final String VALIDATE_CITY = "validate-city";
	private static final String VALIDATE_FIRSTNAME = "validate-firstname";
	private static final String VALIDATE_LASTNAME = "validate-lastname";
	private static final String VALIDATE_CFBN = "validate-cfbn";
	
	private static final String STRING_TYPE = "string";
	private static final String TOKEN_TYPE = "token";
	private static final String POSITIVE_INTEGER_TYPE = "positiveInteger";
	private static final String LONG_TYPE = "long";
	private static final String POSTAL_CODE_TYPE = "PostalCodeType";
	private static final String DEPARTMENT_CODE_TYPE = "DepartmentCodeType";
	private static final String PHONE_TYPE = "PhoneType";
	private static final String CITY_TYPE = "CityType";
	private static final String FIRSTNAME_TYPE = "FirstNameType";
	private static final String LASTNAME_TYPE = "LastNameType";
	private static final String CFBN_TYPE = "CfbnType";
	private static final String BOOLEAN_TYPE = "boolean";
	private static final String DATE_TYPE = "date";
	private static final String EMAIL_TYPE = "EmailType";
	
	
	public static String getValidation(Element element, String elementType,	int minOccurs) {
		StringBuffer result = new StringBuffer();
		if (minOccurs == 1) result.append(REQUIRED);
		    result.append(checkValidation(element, elementType));
		return result.toString();
	}
	
	private static String checkValidation(Element element, String elementType) {
	    logger.debug("Start checkValidation, element: " + element.getName() + ", elementType: " + elementType);
	    StringBuffer result = new StringBuffer();
		if (element != null) {
			result.append(SPACE);
			if (element instanceof SelectElement) result.append(VALIDATE_NOT_FIRST);
			else if (element instanceof RadioElement) result.append(VALIDATE_ONE_REQUIRED);
			else if (element instanceof YesnoElement) result.append(VALIDATE_ONE_REQUIRED);
		    else if (elementType != null) {
    		    result.append(SPACE);
    			if (elementType.equals(BOOLEAN_TYPE)) result.append(VALIDATE_ONE_REQUIRED);
    			else if (elementType.equals(DATE_TYPE)) result.append(VALIDATE_DATE_AU);
    			else if (elementType.equals(EMAIL_TYPE)) result.append(VALIDATE_EMAIL);
    			else if (elementType.equals(STRING_TYPE)) result.append(VALIDATE_STRING);
    			else if (elementType.equals(TOKEN_TYPE)) result.append(VALIDATE_TOKEN);
    			else if (elementType.equals(POSITIVE_INTEGER_TYPE)) result.append(VALIDATE_POSITIVE_INTEGER);
    			else if (elementType.equals(LONG_TYPE)) result.append(VALIDATE_LONG);
    			else if (elementType.equals(POSTAL_CODE_TYPE)) result.append(VALIDATE_POSTAL_CODE);
    	        else if (elementType.equals(DEPARTMENT_CODE_TYPE)) result.append(VALIDATE_DEPARTMENT_CODE);
    	        else if (elementType.equals(PHONE_TYPE)) result.append(VALIDATE_PHONE);
    	        else if (elementType.equals(CITY_TYPE)) result.append(VALIDATE_CITY);
    	        else if (elementType.equals(FIRSTNAME_TYPE)) result.append(VALIDATE_FIRSTNAME);
    	        else if (elementType.equals(LASTNAME_TYPE)) result.append(VALIDATE_LASTNAME);
    	        else if (elementType.equals(CFBN_TYPE)) result.append(VALIDATE_CFBN);
		    }
		} else {
			logger.error("Element and ElementType are null");
		}
		return result.toString();
	}	
}
