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
package fr.cg95.cvq.fo.util;


/**
 * @author Laurent MARQUEZ
 *  
 */
public interface Constants {
    //
    public static final String TEMPORARY_DIRECTORY = "temp";

    // struts property file name
    public static final String FILE_PROPERTY_NAME = "application";

    //
    public static final String YES = "Oui";

    public static final String NO = "Non";

    //

    public static final String LOGIN_ERROR_KEY = "login_error";

    public static final String BAD_USER_VALUE = "errors.login.userName";

    public static final String WRONG_PASSWORD_VALUE = "errors.login.password";

    public static final String AUTHENTICATION_FAILED_VALUE = "errors.login.authentication.failed";

    public static final String DISABLED_ACCOUNT_VALUE = "errors.login.disabled.account";
    
    public static final String NOT_ACCOUNT_MANAGER = "errors.login.accountManager";

    public static final String LOGIN_NONIDENTICAL_PASSWORD_VALUE = "errors.login.password.notidentical";

		public static final String RESET_PASSWORD_VALUE = "errors.reset.password";
		public static final String MAIL_PASSWORD_VALUE = "message.mail.password";
		public static final String TOWN_PASSWORD_VALUE = "message.town.password";

    public static final String BAD_FILE_FORMAT_KEY = "bad_file_format";

    public static final String BAD_FILE_FORMAT_VALUE = "errors.file.format";

    // action mapping
    public static final String FAILURE = "failure";

    public static final String CLOSE = "close";

    public static final String SUCCESS = "success";

    public static final String SAVE = "save";

    public static final String MODIFY = "modify";

    public static final String ADD = "add";

    public static final String POPUP = "popup";

    public static final String URL = "url";

    public static final String HREF = "href";

    // GUIWizard Manager Name
    public static final String GUIWIZARD_MANAGER_PERSONAL = "personal";

    // url parameter name for the personal context service
    // eventually used by the back office
		public static final String FAMILYID = "familyId";
		public static final String AGENTID = "agentId";

    // type id of the document
    public static final String TYPEID = "typeId";

    // Selected page of the document
    public static final String PAGE = "page";

    // Request for cookie on terminal and name for the cookie
    public static final String COOKIE_REQUEST = "termid";

    public static final String COOKIE_NAME = "TERMINAL";

    // Form name
    public static final String ADULT_FORM = "adultForm";

	public static final String CHILD_FORM = "childForm";
	public static final String CHILDCOUNT_FORM = "childCountForm";

    public static final String DOCUMENT_FORM = "documentForm";

    public static final String LOGIN_FORM = "loginForm";

    public static final String CONTROL_FORM = "controlForm";


	// Buyers caddy
	public static final String CADDY = "caddy";
		
    // parse date
    public static final String SHORT_DATE_FORMAT = "dd/MM/yyyy";
    public static final String DATE_FORMAT = "dd MMMMM yyyy à HH:mm:ss ";

    public static final String BIRTHDAY_DATE_FORMAT = "dd/MM/yyyy";

    public static final String DAY_DATE_FORMAT = "dd";

    public static final String MONTH_DATE_FORMAT = "MM";

    public static final String YEAR_DATE_FORMAT = "yyyy";

    // Document type

		public static final String ADOPTION_JUDGMENT_TYPE = "Jugement d'adoption";
		public static final String BANK_IDENTITY_RECEIPT_TYPE = "RIB";
		public static final String BIRTH_CERTIFICATE_DOCUMENT_TYPE = "Acte de naissance";
		public static final String DOMICILE_RECEIPT_DOCUMENT_TYPE = "Justificatif de domicile";
		public static final String EXSPOUSE_PERMISSION_TYPE = "Autorisation ex-conjoint";
		public static final String FAMILY_NOTEBOOK_DOCUMENT_TYPE = "Livret de famille";
		public static final String FRENCH_NATIONALITY_ACQUISITION_TYPE = "";
		public static final String FRENCH_NATIONALITY_RECEIPT_TYPE = "Justificatif de nationalité française";
		public static final String HEALTH_NOTEBOOK_DOCUMENT_TYPE = "Carnet de santé";
		public static final String ID_CARD_LOSS_DECLARATION_TYPE = "Déclaration de perte de CI";
		public static final String IDENTITY_RECEIPT_DOCUMENT_TYPE = "Pièce d'identité";
		public static final String INSURANCE_CERTIFICATE_TYPE = "Attestation d'assurance";
		public static final String MEDICAL_CERTIFICATE_DOCUMENT_TYPE = "Certificat médical";
		public static final String OLD_CNI_TYPE = "Ancienne CNI";
		public static final String PAYROLL_TYPE = "Bulletin de salaire";
		public static final String SCHOOL_CERTIFICATE_TYPE = "Certificat de scolarité";
		public static final String SCHOOL_INSURANCE_TYPE = "Assurance scolaire";
		public static final String SPECIFIC_REQUEST_RECEIPT_TYPE = "Justificatif spécifique";
		public static final String TAXES_NOTIFICATION_TYPE = "Avis d'imposition";
		public static final String TUTOR_APPOINTMENT_DECLARATION_TYPE = "Autorité parentale";
		public static final String VACATING_CERTIFICATE_DOCUMENT_TYPE = "Certificat de radiation";
		public static final String VITAL_CARD_CERTIFICATE_TYPE = "Attestation Carte Vitale";

    // Document type

    public static final String DOMICILE_RECEIPT_DOCUMENT_TYPE_PATH = "/common/document/domicileReceipt.jsp";

    public static final String IDENTITY_RECEIPT_DOCUMENT_TYPE_PATH = "/common/document/identityReceipt.jsp";

    public static final String FAMILY_NOTEBOOK_DOCUMENT_TYPE_PATH = "/common/document/familyNotebook.jsp";

    public static final String MEDICAL_CERTIFICATE_DOCUMENT_TYPE_PATH = "/common/document/medicalCertificate.jsp";

    public static final String HEALTH_NOTEBOOK_DOCUMENT_TYPE_PATH = "/common/document/healthNotebook.jsp";

    public static final String VACATING_CERTIFICATE_DOCUMENT_TYPE_PATH = "/common/document/vacatingCertificate.jsp";

    public static final String BIRTH_CERTIFICATE_DOCUMENT_TYPE_PATH = "/common/document/birthCertificate.jsp";

    // Document State

    public final static String STATE_CHECKED = "Verifié";
    public final static String STATE_OUTDATED = "Périmé";
    public final static String STATE_PENDING = "En attente";
    public final static String STATE_REFUSED = "Refusé";
    public final static String STATE_VALIDATED = "Validé";
    public final static String STATE_CERTIFIED = "Certifié";

    // image size
    public static final Integer UPLOAD_FILE_SIZE = new Integer(1048576);

    public static String UPLOAD_FILE_JPG_FORMAT = "jpg";

    public static String UPLOAD_FILE_JPEG_FORMAT = "jpeg";

    public static String UPLOAD_FILE_BMP_FORMAT = "bmp";

    public static String UPLOAD_FILE_PNG_FORMAT = "png";

    public static String UPLOAD_FILE_GIF_FORMAT = "gif";

    public static String UPLOAD_FILE_TIFF_FORMAT = "tiff";

    //country
    public static String COUNTRY_KEY = "countries";

    public static String COUNTRY_CHOOSE = "country.choose";

    public static String COUNTRY_EEC = "country.eec";

    public static String COUNTRY_OUTSIDE_EEC = "country.outside_eec";

    public static String NATIONALITY_FRANCE = "nationality.france";


    // country code

    public static String COUNTRY_CODE_EEC = "EEC";

    public static String COUNTRY_CODE_OUTSIDE_EEC = "OUTSIDE_EEC";

    public static String COUNTRY_CODE_FRANCE = "FR";

}

