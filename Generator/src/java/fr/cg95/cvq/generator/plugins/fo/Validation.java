package fr.cg95.cvq.generator.plugins.fo;

import java.math.BigInteger;

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
*/
//------------------------------------------------------------------------------------------------------------------
public class Validation {
	
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

	private static final String BOOLEAN_TYPE = "boolean";
	private static final String DATE_TYPE = "date";
	private static final String POSITIVE_INTEGER_TYPE = "positiveInteger";
	private static final String EMAIL_TYPE = "EmailType";
	private static final String PHONE_TYPE = "PhoneType";
	
	public static String getValidation(Element element, String elementType, String namespace, 
			int minOccurs) {
		String result = "";
		if (minOccurs == 1) result = REQUIRED;
		result += checkValidation(element, elementType, namespace);
		return result;
	}
	
	private static String checkValidation(Element element, String elementType, String namespace) {
		String result = "";
		if (element != null) {
			//TODO ADD YESNO, TEXT,ONE_TO_MANY, -- LEGEND, 
			//LABEL (for *) validation.contains("required") 
			result += SPACE;
			if (element instanceof SelectElement) result += VALIDATE_NOT_FIRST;
			else if (element instanceof RadioElement) result += VALIDATE_ONE_REQUIRED;
		}
		else if (elementType != null) {
			//TODO MUST BE REMOVE --> Because of RenderType for all xs:boolean (YESNO), xs:string(TEXT)
			// BUT CHECK REGEX
			result += SPACE;
			if (elementType.equals(BOOLEAN_TYPE)) result += VALIDATE_ONE_REQUIRED;
			else if (elementType.equals(DATE_TYPE)) result += VALIDATE_DATE;
			else if (elementType.equals(POSITIVE_INTEGER_TYPE)) result += VALIDATE_NUMBER;
			else if (elementType.equals(EMAIL_TYPE)) result += VALIDATE_EMAIL;
		} else {
			System.out.println("elementType && renderType  are null ");
		}
		return result;
	}
	
}
