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
package fr.cg95.cvq.bo.business;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import fr.cg95.cvq.bo.TwoWayMap;
import fr.cg95.cvq.bo.Utils;
import fr.cg95.cvq.bo.manager.RequestManager;
import fr.cg95.cvq.bo.manager.TaskManager;
import fr.cg95.cvq.bo.record.PaperRecord;
import fr.cg95.cvq.bo.record.RequestRecord;
import fr.cg95.cvq.bo.record.RequestTypeRecord;
import fr.cg95.cvq.business.authority.SectionType;
import fr.cg95.cvq.business.authority.SiteProfile;
import fr.cg95.cvq.business.document.Document;
import fr.cg95.cvq.business.document.DocumentState;
import fr.cg95.cvq.business.document.DocumentType;
import fr.cg95.cvq.business.request.DataState;
import fr.cg95.cvq.business.request.MeansOfContactEnum;
import fr.cg95.cvq.business.request.RequestState;
import fr.cg95.cvq.business.request.RequestType;
import fr.cg95.cvq.business.request.Requirement;
import fr.cg95.cvq.business.users.CardState;
import fr.cg95.cvq.business.users.FamilyStatusType;
import fr.cg95.cvq.business.users.LegalResponsibleRole;
import fr.cg95.cvq.business.users.SexType;
import fr.cg95.cvq.business.users.TitleType;
import fr.cg95.cvq.business.users.payment.PaymentState;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.exception.CvqObjectNotFoundException;
import fr.cg95.cvq.payment.IPaymentService;
import fr.cg95.cvq.service.document.IDocumentService;
import fr.cg95.cvq.service.request.IRequestService;
import fr.cg95.cvq.util.localization.ILocalizationService;
import fr.cg95.cvq.wizard.ReferentialData;
import fr.cg95.cvq.xml.common.DataStateType;
import fr.cg95.cvq.xml.common.LegalResponsibleType;
import fr.cg95.cvq.xml.common.MeansOfContactType;
import fr.cg95.cvq.xml.common.RequestStateType;
import fr.cg95.cvq.xml.school.SchoolRegistrationRequestDocument.SchoolRegistrationRequest;

/**
 * @author René le CLERCQ
 */
public class BusinessDictionary implements IBusinessConstants {

    public static final String LANGUAGE = "fr";
    
    private static BusinessDictionary bd = null;

    private static TwoWayMap requestStates = null;

    private static TwoWayMap documentStates = null;

    private static TwoWayMap familyStatus = null;

    private static TwoWayMap sexType = null;

    private static TwoWayMap titleType = null;

    private static HashMap actionType = null;

    private static Collection countries = null;

    private static TwoWayMap dataStates = null;

    private static TwoWayMap classes = null;

    private static HashMap documentTypes = null;

    private static TwoWayMap paymentTypes = null;

    private static TwoWayMap paymentStates = null;

    private static TwoWayMap dateTypes = null;

    private static TwoWayMap cardStates = null;

    public BusinessDictionary() {
        super();

        if (bd == null)
            bd = this;
    }

    public static ArrayList<RequestTypeRecord> getRequestTypeRecords(RequestManager requestManager, boolean activeOnly) {
        ArrayList<RequestTypeRecord> requestTypes = new ArrayList<RequestTypeRecord>();
        if (BusinessManager.getAc() != null) {
            try {
                IRequestService requestService = BusinessManager.getDefaultRequestService();

                Iterator iter = requestService.getAllRequestTypes().iterator();

                while (iter.hasNext()) {
                    RequestType requestType = (RequestType) iter.next();

                    if (!activeOnly || requestType.getActive().booleanValue()) {
                        RequestTypeRecord typeRecord = requestManager.getRequestTypeRecord(requestType);

                        requestTypes.add(typeRecord);
                    }
                }
                Collections.sort(requestTypes, new RequestTypeComparator());

            } catch (CvqException e) {
                e.printStackTrace();
            }
        }
        return requestTypes;
    }

    public static ArrayList<RequestTypeRecord> getSeasonableRequestTypeRecords(RequestManager requestManager) {
        ArrayList<RequestTypeRecord> requestTypes = new ArrayList<RequestTypeRecord>();
        if (BusinessManager.getAc() != null) {
            Iterator iter = BusinessManager.getSeasonableRequestTypes().iterator();

            while (iter.hasNext()) {
                IRequestService requestService = (IRequestService) iter.next();
                RequestTypeRecord typeRecord = requestManager.getRequestTypeRecord(requestService.getLabel());

                requestTypes.add(typeRecord);
            }
        
            Collections.sort(requestTypes, new RequestTypeComparator());
        }
        return requestTypes;
    }

    private static class RequestTypeComparator implements Comparator {

        public RequestTypeComparator() {
            super();
        }

        public int compare(Object o1, Object o2) {
            // get the requesttype records to compare
            RequestTypeRecord type1 = null;
            RequestTypeRecord type2 = null;
            
            if (o1 instanceof RequestTypeRecord)
                type1 = (RequestTypeRecord)o1;

            if (o2 instanceof RequestTypeRecord)
                type2 = (RequestTypeRecord)o2;
            
            // We sort on labels, so get the labels
            String label1 = (type1 == null) ? null : type1.getLabel();
            String label2 = (type2 == null) ? null : type2.getLabel();
            
            if (label1 == null || label1.equals("")) {
                if (label2 == null || label2.equals(""))
                    // both null so they are equals
                    return 0;
                else
                    // label2 not null so it's greater than res1
                    return 1;
            } else if (label2 == null || label2.equals("")) {
                // label1 not null so it's greater than label2
                return -1;
            } else {
                return (label1).compareTo(label2);
            }
        }
    }

    private static Collection getClasses() {
        if (classes == null) {
            classes = new TwoWayMap();

            ILocalizationService service = 
                (ILocalizationService)BusinessManager.getAc().getBean(ILocalizationService.SERVICE_NAME);
            
            for (int i = 1; i <= fr.cg95.cvq.xml.common.SectionType.Enum.table.lastInt(); i++) {
                String section = fr.cg95.cvq.xml.common.SectionType.Enum.forInt(i).toString();
                classes.put(SectionType.forString(section), 
                        service.getEnumElementTranslation(
                                SchoolRegistrationRequest.class.getName(),"Section", section.toString(), LANGUAGE));
            }
        }
        return classes.getOneWayValues();
    }

    public static String getSection(SectionType section) {
        if (section != null) {
            getClasses();
            return (String) classes.get(section);
        }
        return SCHOOL_UNKNOWN;
    }

    public static SectionType getSection(String clazz) {
        getClasses();
        SectionType section = (SectionType) classes.get(clazz);

        if (section != null)
            return section;

        return SectionType.UNKNOWN;
    }

    public static Collection getNationalities() {

        if (countries == null) {
            countries = new ArrayList();

            countries.add(new ReferentialData("FR", "Française"));
            countries.add(new ReferentialData("EEC", "UE"));
            countries.add(new ReferentialData("OUTSIDE_EEC", "Hors UE"));
        }
        return countries;
    }

    public static String getCountry(String code) {
        getNationalities();

        String country = "";
        if (code != null) {
        	Iterator iter = countries.iterator();
        	while (iter.hasNext()) {
        		ReferentialData data = (ReferentialData)iter.next();
        		if (code.equals(data.getKey()))
        			country = data.getValue();
        	}
        }
        return country;
    }

    public static Collection getRequestStates() {
        if (requestStates == null) {
            requestStates = new TwoWayMap();

            ILocalizationService service = 
                (ILocalizationService)BusinessManager.getAc().getBean(ILocalizationService.SERVICE_NAME);
            
            for (int i = 1; i <= RequestStateType.Enum.table.lastInt(); i++) {
                String requestState = RequestStateType.Enum.forInt(i).toString();
                requestStates.put(RequestState.forString(requestState), 
                        service.getEnumElementTranslation(
                                fr.cg95.cvq.xml.common.RequestType.class.getName(),"State", requestState, LANGUAGE));
            }
            Collections.sort((List)requestStates.getOneWayValues());
        }
        return requestStates.getOneWayValues();
    }

    public static String getRequestState(RequestState state) {
        getRequestStates();
        return (String) requestStates.get(state);
    }

    public static RequestState getRequestState(String state) {
        getRequestStates();
        return (RequestState) requestStates.get(state);
    }

    public static Collection getDocumentStates() {
        if (documentStates == null) {
            documentStates = new TwoWayMap();

            documentStates.put(DocumentState.CHECKED, STATE_CHECKED);
            documentStates.put(DocumentState.OUTDATED, STATE_OUTDATED);
            documentStates.put(DocumentState.PENDING, STATE_PENDING);
            documentStates.put(DocumentState.REFUSED, STATE_REFUSED);
            documentStates.put(DocumentState.VALIDATED, STATE_VALIDATED);

            Collections.sort((List)documentStates.getOneWayValues());
        }
        return documentStates.getOneWayValues();
    }

    public static String getDocumentState(DocumentState state) {
        getDocumentStates();
        return (String) documentStates.get(state);
    }

    public static DocumentState getDocumentState(String state) {
        getDocumentStates();
        return (DocumentState) documentStates.get(state);
    }

    public static Collection getDataStates() {
        if (dataStates == null) {
            dataStates = new TwoWayMap();

            ILocalizationService service = 
                (ILocalizationService)BusinessManager.getAc().getBean(ILocalizationService.SERVICE_NAME);
            
            for (int i = 1; i <= DataStateType.Enum.table.lastInt(); i++) {
                String dataState = DataStateType.Enum.forInt(i).toString();
                dataStates.put(DataState.forString(dataState), 
                        service.getEnumElementTranslation(
                                fr.cg95.cvq.xml.common.RequestType.class.getName(),"DataState", dataState, LANGUAGE));
            }
            Collections.sort((List)dataStates.getOneWayValues());
        }
        return dataStates.getOneWayValues();
    }

    public static String getDataState(DataState state) {
        getDataStates();
        return (String) dataStates.get(state);
    }

    public static DataState getDataState(String state) {
        getDataStates();
        return (DataState) dataStates.get(state);
    }

    public static String getFamilyStatus(FamilyStatusType status) {
        initFamilyStatus();
        return (String) familyStatus.get(status);
    }

    public static FamilyStatusType getFamilyStatus(String status) {
        initFamilyStatus();
        return (FamilyStatusType) familyStatus.get(status);
    }

    private static void initFamilyStatus() {
        if (familyStatus == null) {
            familyStatus = new TwoWayMap();
            
            ILocalizationService service = 
                (ILocalizationService)BusinessManager.getAc().getBean(ILocalizationService.SERVICE_NAME);
            
            for (int i = 1; i <= fr.cg95.cvq.xml.common.FamilyStatusType.Enum.table.lastInt(); i++) {
                String status = fr.cg95.cvq.xml.common.FamilyStatusType.Enum.forInt(i).toString();
                familyStatus.put(FamilyStatusType.forString(status), 
                        service.getEnumElementTranslation(
                                fr.cg95.cvq.xml.common.AdultType.class.getName(),"FamilyStatus", status, LANGUAGE));
            }
        }
    }

    public static String getSex(SexType sex) {
        initSex();
        return (String) sexType.get(sex);
    }

    public static SexType getSex(String sex) {
        initSex();
        return (SexType) sexType.get(sex);
    }

    private static void initSex() {
        if (sexType == null) {
            sexType = new TwoWayMap();

            ILocalizationService service = 
                (ILocalizationService)BusinessManager.getAc().getBean(ILocalizationService.SERVICE_NAME);
            
            for (int i = 1; i <= fr.cg95.cvq.xml.common.SexType.Enum.table.lastInt(); i++) {
                String sex = fr.cg95.cvq.xml.common.SexType.Enum.forInt(i).toString();
                sexType.put(SexType.forString(sex), 
                        service.getEnumElementTranslation(
                                fr.cg95.cvq.xml.common.IndividualType.class.getName(),"Sex", sex, LANGUAGE));
            }
        }
    }

    public static String getPaymentType(String type) {
        initPaymentTypes();
        return (String) paymentTypes.get(type);
    }

    public static Collection getPaymentTypes() {
        initPaymentTypes();
        return paymentTypes.getOneWayValues();
    }

    private static void initPaymentTypes() {
        if (paymentTypes == null) {
            paymentTypes = new TwoWayMap();
            paymentTypes.put("W", "Borne");
            paymentTypes.put("P", "Internet");
        }
    }

    public static PaymentState getPaymentState(String state) {
        initDateTypes();
        return (PaymentState) paymentStates.get(state);
    }

    public static String getPaymentState(PaymentState state) {
        initDateTypes();
        return (String) paymentStates.get(state);
    }

    public static Collection getPaymentStates() {
        initPaymentStates();
        return paymentStates.getOneWayValues();
    }
    
    private static void initPaymentStates() {
        if (paymentStates == null) {
            paymentStates = new TwoWayMap();
            paymentStates.put(PaymentState.CANCELLED, "Annulé");
            paymentStates.put(PaymentState.INITIALIZED, "Initialisé");
            paymentStates.put(PaymentState.REFUSED, "Refusé");
            paymentStates.put(PaymentState.VALIDATED, "Validé");
        }
    }
    
    public static CardState getDateType(String state) {
        initDateTypes();
        return (CardState) dateTypes.get(state);
    }

    public static Collection getDateTypes() {
        initDateTypes();
        return dateTypes.getOneWayValues();
    }

    private static void initDateTypes() {
        if (dateTypes == null) {
            dateTypes = new TwoWayMap();
            dateTypes.put(IPaymentService.DATE_TYPE_INITIALIZATION, "Initialisation");
            dateTypes.put(IPaymentService.DATE_TYPE_COMMIT, "Validation");
        }
    }

    public static String getCardState(CardState state) {
        initCardStates();
        return (String) cardStates.get(state);
    }

    public static CardState getCardState(String state) {
        initCardStates();
        return (CardState) cardStates.get(state);
    }

    public static Collection getCardStates() {
        initCardStates();
        return cardStates.getOneWayValues();
    }

    private static void initCardStates() {
        if (cardStates == null) {
            cardStates = new TwoWayMap();
            cardStates.put(CardState.ACTIVE, "Active");
            cardStates.put(CardState.BLOCKED, "Bloqué");
            cardStates.put(CardState.DEBLOCKED, "Débloqué");
            cardStates.put(CardState.LOST, "Perdu");
            cardStates.put(CardState.STOLEN, "Volé");
        }
    }

    public static String getTitle(TitleType title) {
        initTitle();
        return (String) titleType.get(title);
    }

    public static TitleType getTitle(String title) {
        initTitle();
        return (TitleType) titleType.get(title);
    }

    private static void initTitle() {
        if (titleType == null) {
            titleType = new TwoWayMap();

            ILocalizationService service = 
                (ILocalizationService)BusinessManager.getAc().getBean(ILocalizationService.SERVICE_NAME);
            
            for (int i = 1; i <= fr.cg95.cvq.xml.common.TitleType.Enum.table.lastInt(); i++) {
                String title = fr.cg95.cvq.xml.common.TitleType.Enum.forInt(i).toString();
                titleType.put(TitleType.forString(title), 
                        service.getEnumElementTranslation(
                                fr.cg95.cvq.xml.common.AdultType.class.getName(),"Title", title, LANGUAGE));
            }
        }
    }

    public static String getActionType(String action) {
        if (actionType == null) {
            actionType = new HashMap();
            actionType.put(IRequestService.CREATION_ACTION, "Création");
            actionType.put(IRequestService.STATE_CHANGE_ACTION, "Changement d'état");
        }
        return (String) actionType.get(action);

    }

    public static String getAdultRole(LegalResponsibleRole role) {
        ILocalizationService service = 
            (ILocalizationService)BusinessManager.getAc().getBean(ILocalizationService.SERVICE_NAME);
        
        return service.getEnumElementTranslation(LegalResponsibleType.class.getName(),"Role", role.toString(), LANGUAGE);
    }

    public static String getSiteProfile(SiteProfile profile) {
        if (profile.equals(SiteProfile.AGENT))
            return "R/W";

        if (profile.equals(SiteProfile.ADMIN))
            return "Admin";

        return "";
    }

    public static HashMap getDocumentTypes() {
        if (documentTypes == null) {
            documentTypes = new HashMap();

            documentTypes.put(IDocumentService.NO_TYPE, "Justificatif inconnu");
            documentTypes.put(IDocumentService.ADOPTION_JUDGMENT_TYPE, "Jugement d'adoption");
            documentTypes.put(IDocumentService.BANK_IDENTITY_RECEIPT_TYPE, "RIB");
            documentTypes.put(IDocumentService.BIRTH_CERTIFICATE_TYPE, "Acte de naissance");
            documentTypes.put(IDocumentService.DOMICILE_RECEIPT_TYPE, "Justificatif de domicile");
            documentTypes.put(IDocumentService.EXSPOUSE_PERMISSION_TYPE, "Autorisation ex-conjoint");
            documentTypes.put(IDocumentService.FAMILY_NOTEBOOK_TYPE, "Livret de famille");
            documentTypes.put(IDocumentService.FRENCH_NATIONALITY_ACQUISITION_TYPE, "Déclaration de nationalité française par le mariage");
            documentTypes.put(IDocumentService.FRENCH_NATIONALITY_RECEIPT_TYPE,
                    "Justificatif de nationalité française");
            documentTypes.put(IDocumentService.HEALTH_NOTEBOOK_TYPE, "Carnet de santé");
            documentTypes.put(IDocumentService.ID_CARD_LOSS_DECLARATION_TYPE, "Déclaration de perte de CI");
            documentTypes.put(IDocumentService.IDENTITY_RECEIPT_TYPE, "Pièce d'identité");
            documentTypes.put(IDocumentService.INSURANCE_CERTIFICATE_TYPE, "Attestation d'assurance");
            documentTypes.put(IDocumentService.MEDICAL_CERTIFICATE_TYPE, "Certificat médical");
            documentTypes.put(IDocumentService.OLD_CNI_TYPE, "Ancienne CNI");
            documentTypes.put(IDocumentService.PAYROLL_TYPE, "Bulletin de salaire");
            documentTypes.put(IDocumentService.SCHOOL_CERTIFICATE_TYPE, "Certificat de scolarité");
            documentTypes.put(IDocumentService.SCHOOL_INSURANCE_TYPE, "Assurance scolaire");
            documentTypes.put(IDocumentService.SPECIFIC_REQUEST_RECEIPT_TYPE, "Justificatif spécifique");
            documentTypes.put(IDocumentService.TAXES_NOTIFICATION_TYPE, "Avis d'imposition");
            documentTypes.put(IDocumentService.TUTOR_APPOINTMENT_DECLARATION_TYPE, "Autorité parentale");
            documentTypes.put(IDocumentService.VACATING_CERTIFICATE_TYPE, "Certificat de radiation");
            documentTypes.put(IDocumentService.VITAL_CARD_CERTIFICATE_TYPE, "Attestation Carte Vitale");
            documentTypes.put(IDocumentService.DOMICILE_RECEIPT_TYPE, "Justificatif de domicile");
            documentTypes.put(IDocumentService.IDENTITY_RECEIPT_TYPE, "Pièce d'identité");
            documentTypes.put(IDocumentService.FAMILY_NOTEBOOK_TYPE, "Livret de famille");
            documentTypes.put(IDocumentService.MEDICAL_CERTIFICATE_TYPE, "Certificat médical");
            documentTypes.put(IDocumentService.HEALTH_NOTEBOOK_TYPE, "Carnet de santé");
            documentTypes.put(IDocumentService.VACATING_CERTIFICATE_TYPE, "Certificat de radiation");
            documentTypes.put(IDocumentService.BIRTH_CERTIFICATE_TYPE, "Extrait d'acte de naissance");
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

    public static String getDocumentType(Integer type) {
        return (String) getDocumentTypes().get(type);
    }

    public static void addDocuments(RequestRecord record, Set documentTypes) {
        Iterator iter = documentTypes.iterator();
        while (iter.hasNext()) {
            Requirement requirement = (Requirement) iter.next();
            DocumentType documentType = requirement.getDocumentType();

            PaperRecord paper = new PaperRecord();
            paper.setType(getDocumentType(documentType.getType()));
            paper.setTypeId(documentType.getType());

            paper.setState(STATE_ABSENT);

            record.addPaper(paper);
        }
    }

    public static void updateDocuments(RequestRecord record) {
        // If the record has no papers attached at this moment, no papers are needed
        if (record.getPapers() == null)
            return;

        if (BusinessManager.getAc() != null) {
            try {
                IRequestService requestService = BusinessManager.getDefaultRequestService();
                Iterator iter = requestService.getAssociatedDocuments(record.getId()).iterator();
                while (iter.hasNext()) {
                    Document document = (Document) iter.next();
                    PaperRecord paperRecord = null;
                    if (document.getDocumentType() != null)
                        paperRecord = getPaperRecord(record, document.getDocumentType().getType());

                    if (paperRecord != null) {
                        paperRecord.setPerson(document.getIndividual());
                        paperRecord.setExpirationDate(Utils.getDateAsString(document.getEndValidityDate()));
                        paperRecord.setState(getDocumentState(document.getState()));
                        paperRecord.setSubmissionDate(Utils.getDateAsString(document.getCreationDate()));
                        paperRecord.setValidationDate(Utils.getDateAsString(document.getValidationDate()));
                    } else {
                        Integer type = IDocumentService.NO_TYPE;
                        if (document.getDocumentType() != null)
                            type = document.getDocumentType().getType();

                        paperRecord = new PaperRecord(getDocumentType(type), getDocumentState(document
                                .getState()), Utils.getDateAsString(document.getEndValidityDate()), Utils
                                .getDateAsString(document.getValidationDate()), Utils
                                .getDateAsString(document.getCreationDate()));
                        
                        record.getPapers().add(paperRecord);
                    }
                    paperRecord.setCertified(document.getCertified().booleanValue());
                    paperRecord.setId(document.getId());
                    // BusinessManager.getDocumentData(paperRecord);

                    record.getTasks().updateTask(TaskManager.TASK_DOCUMENTS, paperRecord.getState(),
                            paperRecord.getType(), record.getPapers().size());
                }
            } catch (CvqObjectNotFoundException ce) {
            } catch (CvqException ce) {
            }
        }
    }

    private static PaperRecord getPaperRecord(RequestRecord record, Integer type) {
        ArrayList papers = record.getPapers();

        if (papers != null) {
            for (int i = 0; i < papers.size(); i++) {
                if (type.equals(((PaperRecord) papers.get(i)).getTypeId()))
                    return (PaperRecord) papers.get(i);
            }
        }
        return null;
    }

    public static void addTasks(RequestRecord record) {
        TaskManager tasks = new TaskManager();

        tasks.addTask(TaskManager.TASK_DATA, TASK_DATA_LABEL, 0, "");
        tasks.addTask(TaskManager.TASK_DOCUMENTS, TASK_DOCUMENTS_LABEL, 0, "");
        tasks.addTask(TaskManager.TASK_REQUEST, TASK_REQUEST_LABEL, 0, "");
        tasks.addTask(TaskManager.TASK_CERTIFICATE, TASK_CERTIFICATE_LABEL, 0, "");

        record.setTasks(tasks);
    }

    public static String getMeansOfContactLabel(MeansOfContactEnum meansOfContactEnum) {
        return getEnumElementTranslation(MeansOfContactType.class.getName(), "Type", meansOfContactEnum.toString());
//        ILocalizationService service = 
//            (ILocalizationService)BusinessManager.getAc().getBean(ILocalizationService.SERVICE_NAME);
//
//        return service.getEnumElementTranslation(MeansOfContactType.class.getName(), "Type", meansOfContactEnum.toString() , LANGUAGE);
    }
    
    public static String getMeansOfContactKey(String type) {
        return getEnumKeyTranslation(MeansOfContactType.class.getName(), "Type", type);
    }
    
    public static String getEnumElementTranslation(String className, String elementName, String elementValue) {
        ILocalizationService service = 
            (ILocalizationService)BusinessManager.getAc().getBean(ILocalizationService.SERVICE_NAME);
        
        return service.getEnumElementTranslation(className, elementName, elementValue, "fr");
    }
    
    public static String getEnumKeyTranslation(String className, String elementName, String elementValue) {
        ILocalizationService service = 
            (ILocalizationService)BusinessManager.getAc().getBean(ILocalizationService.SERVICE_NAME);
        
        return service.getEnumKeyFromTranslation(className, elementName, elementValue, "fr");
    }
    
}
