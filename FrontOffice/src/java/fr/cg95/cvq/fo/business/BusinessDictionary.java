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
package fr.cg95.cvq.fo.business;

import java.util.Collection;
import java.util.HashMap;

import org.apache.struts.util.MessageResources;

import fr.cg95.cvq.business.users.DocumentState;
import fr.cg95.cvq.business.users.FamilyStatusType;
import fr.cg95.cvq.business.users.LegalResponsibleRole;
import fr.cg95.cvq.business.users.MeansOfContactEnum;
import fr.cg95.cvq.business.users.RequestState;
import fr.cg95.cvq.business.users.SexType;
import fr.cg95.cvq.business.users.TitleType;
import fr.cg95.cvq.fo.util.Constants;
import fr.cg95.cvq.service.users.IDocumentService;
import fr.cg95.cvq.util.localization.ILocalizationService;
import fr.cg95.cvq.xml.common.AdultType;
import fr.cg95.cvq.xml.common.IndividualType;
import fr.cg95.cvq.xml.common.LegalResponsibleType;
import fr.cg95.cvq.xml.common.MeansOfContactEnumType;
import fr.cg95.cvq.xml.common.MeansOfContactType;
import fr.cg95.cvq.xml.common.RequestType;

public class BusinessDictionary implements Constants {

    private static final String LANGUAGE = "fr";
    
    private static HashMap documentTypes = null;

    private static HashMap documentStates = null;

    private static HashMap countryCodes = null;
    
    public static HashMap getDocumentTypes() {
        if (documentTypes == null) {
            documentTypes = new HashMap();

            documentTypes.put(IDocumentService.ADOPTION_JUDGMENT_TYPE, ADOPTION_JUDGMENT_TYPE);
            documentTypes.put(IDocumentService.BANK_IDENTITY_RECEIPT_TYPE, BANK_IDENTITY_RECEIPT_TYPE);
            documentTypes.put(IDocumentService.BIRTH_CERTIFICATE_TYPE, BIRTH_CERTIFICATE_DOCUMENT_TYPE);
            documentTypes.put(IDocumentService.DOMICILE_RECEIPT_TYPE, DOMICILE_RECEIPT_DOCUMENT_TYPE);
            documentTypes.put(IDocumentService.EXSPOUSE_PERMISSION_TYPE, EXSPOUSE_PERMISSION_TYPE);
            documentTypes.put(IDocumentService.FAMILY_NOTEBOOK_TYPE, FAMILY_NOTEBOOK_DOCUMENT_TYPE);
            documentTypes.put(IDocumentService.FRENCH_NATIONALITY_ACQUISITION_TYPE,
                    FRENCH_NATIONALITY_ACQUISITION_TYPE);
            documentTypes.put(IDocumentService.FRENCH_NATIONALITY_RECEIPT_TYPE,
                    FRENCH_NATIONALITY_RECEIPT_TYPE);
            documentTypes.put(IDocumentService.HEALTH_NOTEBOOK_TYPE, HEALTH_NOTEBOOK_DOCUMENT_TYPE);
            documentTypes.put(IDocumentService.ID_CARD_LOSS_DECLARATION_TYPE, ID_CARD_LOSS_DECLARATION_TYPE);
            documentTypes.put(IDocumentService.IDENTITY_RECEIPT_TYPE, IDENTITY_RECEIPT_DOCUMENT_TYPE);
            documentTypes.put(IDocumentService.INSURANCE_CERTIFICATE_TYPE, INSURANCE_CERTIFICATE_TYPE);
            documentTypes.put(IDocumentService.MEDICAL_CERTIFICATE_TYPE, MEDICAL_CERTIFICATE_DOCUMENT_TYPE);
            documentTypes.put(IDocumentService.OLD_CNI_TYPE, OLD_CNI_TYPE);
            documentTypes.put(IDocumentService.PAYROLL_TYPE, PAYROLL_TYPE); 
            documentTypes.put(IDocumentService.SCHOOL_CERTIFICATE_TYPE, SCHOOL_CERTIFICATE_TYPE);
            documentTypes.put(IDocumentService.SCHOOL_INSURANCE_TYPE, SCHOOL_INSURANCE_TYPE);
            documentTypes.put(IDocumentService.SPECIFIC_REQUEST_RECEIPT_TYPE, SPECIFIC_REQUEST_RECEIPT_TYPE);
            documentTypes.put(IDocumentService.TAXES_NOTIFICATION_TYPE, TAXES_NOTIFICATION_TYPE);
            documentTypes.put(IDocumentService.TUTOR_APPOINTMENT_DECLARATION_TYPE,
                    TUTOR_APPOINTMENT_DECLARATION_TYPE);
            documentTypes
                    .put(IDocumentService.VACATING_CERTIFICATE_TYPE, VACATING_CERTIFICATE_DOCUMENT_TYPE);
            documentTypes.put(IDocumentService.VITAL_CARD_CERTIFICATE_TYPE, VITAL_CARD_CERTIFICATE_TYPE);
            documentTypes.put(IDocumentService.INDIVIDUAL_ALIGNMENT_CERTIFICATE_TYPE, "Certificat d'alignement individuel");
            documentTypes.put(IDocumentService.BUILDING_SITUATION_PLAN_TYPE, "Plan de situation de l'immeuble");
            documentTypes.put(IDocumentService.GROUND_SITUATION_PLAN_TYPE, "Plan de situation du terrain");
            documentTypes.put(IDocumentService.MASS_PLAN_TYPE, "Plan de masse");
            documentTypes.put(IDocumentService.BANK_STATEMENT_TYPE, "Relevé d'extrait de compte");
            documentTypes.put(IDocumentService.SAVING_ACCOUNT_TYPE, "Livret d'épargne");
            documentTypes.put(IDocumentService.LOCATION_RECEIPT_TYPE, "Quittance de loyer");
            documentTypes.put(IDocumentService.HOUSING_TAXES_NOTIFICATION_TYPE, "Avis d'imposition de la taxe d'habitation et foncière");
            documentTypes.put(IDocumentService.HANDICAP_CARD_TYPE, "Carte d'invalidité");
            documentTypes.put(IDocumentService.REVENUE_TAXES_NOTIFICATION_TYPE, "Avis d'imposition sur les revenus");
            documentTypes.put(IDocumentService.FAMILY_HELP_CERTIFICATE_TYPE, "Attestation d'allocations familiales");
            documentTypes.put(IDocumentService.IDENTITY_PHOTO_TYPE, "Photo d'identité");
        }
        return documentTypes;
    }

    public static String getDocumentType(Integer pType) {
        return (String) getDocumentTypes().get(pType);
    }

    public static Collection getDocumentStates() {
        if (documentStates == null) {
            documentStates = new HashMap();

            documentStates.put(DocumentState.CHECKED, STATE_CHECKED);
            documentStates.put(DocumentState.OUTDATED, STATE_OUTDATED);
            documentStates.put(DocumentState.PENDING, STATE_PENDING);
            documentStates.put(DocumentState.REFUSED, STATE_REFUSED);
            documentStates.put(DocumentState.VALIDATED, STATE_VALIDATED);

            documentStates.put(STATE_CHECKED, DocumentState.CHECKED);
            documentStates.put(STATE_OUTDATED, DocumentState.OUTDATED);
            documentStates.put(STATE_PENDING, DocumentState.PENDING);
            documentStates.put(STATE_REFUSED, DocumentState.REFUSED);
            documentStates.put(STATE_VALIDATED, DocumentState.VALIDATED);
        }
        return documentStates.values();
    }

    public static String getDocumentState(DocumentState state) {
        getDocumentStates();
        return (String) documentStates.get(state);
    }

    public static DocumentState getDocumentState(String state) {
        getDocumentStates();
        return (DocumentState) documentStates.get(state);
    }

    public static String getRequestState(RequestState pState) {
        ILocalizationService service = 
            (ILocalizationService)BusinessManager.getAc().getBean(ILocalizationService.SERVICE_NAME);

        return service.getEnumElementTranslation(RequestType.class.getName(), "State", pState.toString() , LANGUAGE);
    }

    public static String getFamilyStatus(FamilyStatusType pFamilyStatus) {
        ILocalizationService service = 
            (ILocalizationService)BusinessManager.getAc().getBean(ILocalizationService.SERVICE_NAME);

        return service.getEnumElementTranslation(AdultType.class.getName(), "FamilyStatus", pFamilyStatus.toString() , LANGUAGE);
    }

    public static String getSexType(SexType pSexType) {
        ILocalizationService service = 
            (ILocalizationService)BusinessManager.getAc().getBean(ILocalizationService.SERVICE_NAME);

        return service.getEnumElementTranslation(IndividualType.class.getName(), "Sex", pSexType.toString() , LANGUAGE);
    }

    public static String getTitleType(TitleType pTitleType) {
        ILocalizationService service = 
            (ILocalizationService)BusinessManager.getAc().getBean(ILocalizationService.SERVICE_NAME);

        return service.getEnumElementTranslation(AdultType.class.getName(), "Title", pTitleType.toString() , LANGUAGE);
    }

    public static String getQualityType(LegalResponsibleRole pQuality) {
        ILocalizationService service = 
            (ILocalizationService)BusinessManager.getAc().getBean(ILocalizationService.SERVICE_NAME);

        return service.getEnumElementTranslation(LegalResponsibleType.class.getName(), "Role", pQuality.toString() , LANGUAGE);
    }

    public static String getMeansofContactEnum(MeansOfContactEnum meansOfContactEnum) {
        ILocalizationService service = 
            (ILocalizationService)BusinessManager.getAc().getBean(ILocalizationService.SERVICE_NAME);

        return service.getEnumElementTranslation(MeansOfContactType.class.getName(), "Type", meansOfContactEnum.toString() , LANGUAGE);
    }
    
    public static void initCountryCodes() {
        if (countryCodes == null) {
            
            MessageResources messageResources = MessageResources.getMessageResources(FILE_PROPERTY_NAME);

            countryCodes = new HashMap();
            
            countryCodes.put(COUNTRY_CODE_EEC, messageResources.getMessage(COUNTRY_EEC));
            countryCodes.put(COUNTRY_CODE_OUTSIDE_EEC, messageResources.getMessage(COUNTRY_OUTSIDE_EEC));
            
            countryCodes.put(messageResources.getMessage(COUNTRY_EEC), COUNTRY_CODE_EEC);
            countryCodes.put(messageResources.getMessage(COUNTRY_OUTSIDE_EEC), COUNTRY_CODE_OUTSIDE_EEC);
        }        
    }
    
    public static String getCountry(String code) {
        initCountryCodes();
        String country = (String)countryCodes.get(code);
        if (country == null)
            country = "";
        return country;
    }
    
    public static String getCountryCode(String country) {
        initCountryCodes();

        String code =(String)countryCodes.get(country);
        
        if (code == null)
            code = "";
        
        return code;
    }
    
}
