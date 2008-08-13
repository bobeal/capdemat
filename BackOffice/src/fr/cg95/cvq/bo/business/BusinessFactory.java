/*
 * Cartevaloise
 *
 * Copyright (C) 2004 Conseil Général du Val d'Oise. All Rights
 * Reserved.
 *
 * Developed by René le Clercq.
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

import java.util.Iterator;
import java.util.Set;

import org.apache.log4j.Logger;

import fr.cg95.cvq.bo.Utils;
import fr.cg95.cvq.bo.manager.ProfileManager;
import fr.cg95.cvq.bo.manager.RequestManager;
import fr.cg95.cvq.bo.manager.TaskManager;
import fr.cg95.cvq.bo.record.AdultRecord;
import fr.cg95.cvq.bo.record.CategoryRecord;
import fr.cg95.cvq.bo.record.ChildRecord;
import fr.cg95.cvq.bo.record.DocumentTypeRecord;
import fr.cg95.cvq.bo.record.FamilyRecord;
import fr.cg95.cvq.bo.record.IndividualRecord;
import fr.cg95.cvq.bo.record.MeansOfContactRecord;
import fr.cg95.cvq.bo.record.RequestRecord;
import fr.cg95.cvq.bo.record.UserRecord;
import fr.cg95.cvq.business.authority.Agent;
import fr.cg95.cvq.business.authority.Category;
import fr.cg95.cvq.business.authority.CategoryProfile;
import fr.cg95.cvq.business.authority.CategoryRoles;
import fr.cg95.cvq.business.authority.DocumentType;
import fr.cg95.cvq.business.authority.SiteProfile;
import fr.cg95.cvq.business.authority.SiteRoles;
import fr.cg95.cvq.business.school.SchoolRegistrationRequest;
import fr.cg95.cvq.business.users.ActorState;
import fr.cg95.cvq.business.users.Address;
import fr.cg95.cvq.business.users.Adult;
import fr.cg95.cvq.business.users.Card;
import fr.cg95.cvq.business.users.Child;
import fr.cg95.cvq.business.users.ChildLegalResponsible;
import fr.cg95.cvq.business.users.HomeFolder;
import fr.cg95.cvq.business.users.Individual;
import fr.cg95.cvq.business.users.MeansOfContact;
import fr.cg95.cvq.business.users.Request;
import fr.cg95.cvq.business.users.RequestNote;
import fr.cg95.cvq.business.users.RequestNoteType;
import fr.cg95.cvq.business.users.SexType;
import fr.cg95.cvq.business.users.TitleType;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.service.school.ISchoolCanteenRegistrationRequestService;
import fr.cg95.cvq.service.school.ISchoolRegistrationRequestService;

/**
 * BusinessFactory
 */
public class BusinessFactory implements IBusinessConstants {

    /** Commons Logging instance. */
    private static Logger log = Logger.getLogger(BusinessFactory.class);
    
    private BusinessFactory() {
        super();
    }

    public static RequestRecord getRequestRecord(RequestManager requestManager, RequestRecord record,
            Object object) {

        log.debug("Start request record");
        
        Request demand = (Request) object;
        record = requestManager.getRequestRecord(demand, record);

        record.setId(demand.getId());
        record.setDate(demand.getCreationDate());
        record.setDemanderName(demand.getRequester().getFirstName() + " "
                + demand.getRequester().getLastName());
        record.setFamilyId(demand.getHomeFolder().getId());
        record.setTemporary(demand.getHomeFolder().getBoundToRequest().booleanValue());
        record.setState(BusinessDictionary.getRequestState(demand.getState()));
        record.setModificationDate(demand.getLastModificationDate());
        record.setLastAgent(BusinessManager.getActor(demand.getLastInterveningAgentId()));
        record.setOrangeAlert(demand.getOrangeAlert());
        record.setRedAlert(demand.getRedAlert());

        record.setDemander(BusinessFactory.getAdultRecord(demand.getRequester()));

        if (demand.getSubject() != null) {
            IndividualRecord individualRecord = 
                BusinessFactory.getIndividualRecord(demand.getSubject(),null);
            record.setSubject(BusinessFactory.getIndividualRecord(demand.getSubject(), null));
            record.setSubjectName(individualRecord.getFirstName()
                    + " " + individualRecord.getLastName());
        }

        log.debug("End request record");
        return record;
    }

    public static RequestRecord loadRequestRecord(RequestManager requestManager, Object object) {
        Request demand = (Request) object;

        RequestRecord requestRecord = getRequestRecord(requestManager, null, demand);

        if (demand.getSubject() != null)
            requestRecord.setSubject(BusinessFactory.getSubjectRecord(demand.getSubject()));

        initRequestRecord(requestRecord, demand);
        initTasks(requestRecord);
        BusinessDictionary.updateDocuments(requestRecord);

        requestManager.loadRequest(demand, requestRecord);

        return requestRecord;
    }

    private static void initRequestRecord(RequestRecord record, Request demand) {
        record.setCurrentTask("");
        record.setEMail(demand.getRequester().getEmail());
        record.setMobilePhone(demand.getRequester().getMobilePhone());
        if (demand.getMeansOfContact() != null)
            record.setMeansOfContact(
                    BusinessDictionary.getMeansOfContactLabel(demand.getMeansOfContact().getType()));
        else
            record.setMeansOfContact("Missing value in database");

        record.setStep(notNullValue(demand.getStep()));
        record.setDataState(BusinessDictionary.getDataState(demand.getDataState()));

        Category category = (Category) demand.getRequestType().getCategory();
        if (category != null) {
            record.setCategory(BusinessManager.getCategory(category.getId()));
        }

        BusinessDictionary.addDocuments(record, demand.getRequestType().getRequirements());

        if (demand.getNotes() != null) {
            Iterator iter = demand.getNotes().iterator();

            while (iter.hasNext()) {
                RequestNote note = (RequestNote) iter.next();
                if (note.getType().equals(RequestNoteType.INSTRUCTION_INTERNAL))
                    record.setInstructionInternal(note.getNote());

                else if (note.getType().equals(RequestNoteType.INSTRUCTION_EXTERNAL))
                    record.setInstructionExternal(note.getNote());

                else if (note.getType().equals(RequestNoteType.DELIVERY_INTERNAL))
                    record.setDeliveryInternal(note.getNote());

                else if (note.getType().equals(RequestNoteType.DELIVERY_EXTERNAL))
                    record.setDeliveryExternal(note.getNote());
            }
        }
    }

    private static void initTasks(RequestRecord record) {
        BusinessDictionary.addTasks(record);

        // Update the tasks with the state of the request in the DB.
        record.getTasks().updateTask(TaskManager.TASK_REQUEST, record.getState());
        record.getTasks().updateTask(TaskManager.TASK_DATA, record.getDataState());
        // record.getTasks().updateTask(TaskManager.TASK_CERTIFICATE, saveForm.getPrint());
    }

    /**
     */
    public static FamilyRecord getFamilyRecord(Object object) {
        HomeFolder homeFolder = (HomeFolder) object;

        FamilyRecord record = new FamilyRecord();

        record.setId(homeFolder.getId());
        record.setState(homeFolder.getState().toString());
        if (record.isArchived())
            record.setEnabled(false);
        else
            record.setEnabled(homeFolder.getEnabled().booleanValue());

        record.setArchived(homeFolder.getState().equals(ActorState.ARCHIVED));
        record.setFamilyQuotient(homeFolder.getFamilyQuotient());

        Iterator iter = homeFolder.getIndividuals().iterator();

        Adult responsible = homeFolder.getHomeFolderResponsible();

        while (iter.hasNext()) {
            Object individual = iter.next();
            if (individual instanceof Adult) {
                AdultRecord adultRecord = getAdultRecord(individual);
                if (individual == responsible) {
                    adultRecord.setFamilyHomeResponsible(true);
                    record.setResponsible(adultRecord);
                }
                record.addAdult(adultRecord);
            } else if (individual instanceof Child)
                record.addChild(getChildRecord(individual));
        }

        return record;
    }

    private static IndividualRecord getSubjectRecord(Object object) {
        if (object instanceof Adult)
            return getAdultRecord(object);

        if (object instanceof Child)
            return getChildRecord(object);
        
        return getIndividualRecord(object, null);
    }
    
     /**
     */
    public static IndividualRecord getIndividualRecord(Object object, String cardState) {
        if ((cardState != null) && !isHomeFolderResponsible((Individual) object))
            return null;

        IndividualRecord record = new IndividualRecord();

        setIndividualRecord(record, object);

        if ((cardState != null) && (cardState.length() > 0)) {
            if (!cardState.equals(record.getCardState()))
                return null;
        }
        return record;
    }

    public static void setIndividualRecord(IndividualRecord record, Object object) {
        Individual individual = (Individual) object;

        Address adress = individual.getAdress();
        HomeFolder family = individual.getHomeFolder();
        if (family != null) {
            record.setFamilyId(family.getId());
            if (adress == null)
                adress = family.getAdress();
            if (family.getState().equals(ActorState.ARCHIVED))
                record.setState(IBusinessConstants.STATE_ARCHIVED);
            else if (family.getEnabled().booleanValue())
                record.setState(IBusinessConstants.STATE_ENABLED);
            else
                record.setState(IBusinessConstants.STATE_DISABLED);
        }
        record.setId(individual.getId());

        record.setBirthDate(Utils.getDateAsString(individual.getBirthDate()));
        record.setBirthPlace(individual.getBirthCity());
        record.setBirthPostalCode(individual.getBirthPostalCode());
        record.setBirthCountry(BusinessDictionary.getCountry(individual.getBirthCountry()));

        if (adress != null) {
            record.setAdditionalDeliveryInformation(adress.getAdditionalDeliveryInformation());
            record.setAdditionalGeographicalInformation(adress.getAdditionalGeographicalInformation());
            record.setStreetNumber(adress.getStreetNumber());
            record.setStreetName(adress.getStreetName());
            record.setPlaceNameOrService(adress.getPlaceNameOrService());
            record.setCity(adress.getCity());
            record.setPostalCode(adress.getPostalCode());
        }
        record.setFirstName(individual.getFirstName());
        record.setFirstName2(individual.getFirstName2());
        record.setFirstName3(individual.getFirstName3());
        record.setLastName(individual.getLastName());
        // record.setNationality(individual.getNationality());
        record.setSex(BusinessDictionary.getSex(individual.getSex()));

        Card card = individual.getCard();
        if (card != null) {
            record.setCardId(card.getId());
            record.setCardDate(card.getCardDeliveryDate());
            record.setCardState(BusinessDictionary.getCardState(card.getCardState()));
        }
    }

    private static boolean isHomeFolderResponsible(Individual individual) {
        if (individual.getHomeFolder() == null)
            return false;

        return individual.getHomeFolder().getHomeFolderResponsible().getId().equals(individual.getId());
    }

    public static AdultRecord getAdultRecord(Object object) {
        AdultRecord adultRecord = new AdultRecord();

        setIndividualRecord(adultRecord, object);

        Adult adult = (Adult) object;

        adultRecord.setCaseOfFamilyBenifitsNumber(adult.getCfbn());
        adultRecord.setEmail(adult.getEmail());
        adultRecord.setFamilyStatus(BusinessDictionary.getFamilyStatus(adult.getFamilyStatus()));
        adultRecord.setHomePhone(adult.getHomePhone());
        adultRecord.setMaidenName(adult.getMaidenName());
        adultRecord.setMobilePhone(adult.getMobilePhone());
        adultRecord.setUserName(adult.getNameOfUse());
        adultRecord.setOfficePhone(adult.getOfficePhone());
        adultRecord.setProfession(adult.getProfession());
        adultRecord.setTitle(BusinessDictionary.getTitle(adult.getTitle()));
        if ((adult.getTitle() == TitleType.MADAM) || (adult.getTitle() == TitleType.MISS))
            adultRecord.setSex(BusinessDictionary.getSex(SexType.FEMALE));
        else if (adult.getTitle() == TitleType.MISTER)
            adultRecord.setSex(BusinessDictionary.getSex(SexType.MALE));

        adultRecord.setLogin(adult.getLogin());
        adultRecord.setQuestion(adult.getQuestion());
        adultRecord.setAnswer(adult.getAnswer());

        // adultRecord.setQuality();
        // adultRecord.setMethod();

        return adultRecord;
    }

    public static ChildRecord getChildRecord(Object object) {
        ChildRecord childRecord = new ChildRecord();

        setIndividualRecord(childRecord, object);

        Child child = (Child) object;

        childRecord.setObservations(child.getNote());

        Iterator iter = child.getLegalResponsibles().iterator();
        while (iter.hasNext()) {
            ChildLegalResponsible responsible = (ChildLegalResponsible) iter.next();
            if (responsible.getLegalResponsible() != null) {
                AdultRecord adult = getAdultRecord(responsible.getLegalResponsible());
                adult.setRole(BusinessDictionary.getAdultRole(responsible.getRole()));
                childRecord.addLegalResponsible(adult);
            }
        }

        try {
            ISchoolCanteenRegistrationRequestService schoolCanteenService = (ISchoolCanteenRegistrationRequestService) BusinessManager
                    .getAc().getBean(ISchoolCanteenRegistrationRequestService.SERVICE_NAME);
            Set childSchoolCanteenRequest = schoolCanteenService.getBySubjectIdAndRequestLabel(child.getId(),
                    schoolCanteenService.getLabel(), false);
            if (childSchoolCanteenRequest != null && !childSchoolCanteenRequest.isEmpty()) {
                childRecord.setCanteen(true);
            }
            ISchoolRegistrationRequestService schoolService = (ISchoolRegistrationRequestService) BusinessManager
                    .getAc().getBean(ISchoolRegistrationRequestService.SERVICE_NAME);
            Set childSchoolRequest = schoolService.getBySubjectIdAndRequestLabel(child.getId(), schoolService
                    .getLabel(), false);
            if (childSchoolRequest != null && !childSchoolRequest.isEmpty()) {
                SchoolRegistrationRequest request = (SchoolRegistrationRequest) childSchoolRequest.iterator()
                        .next();
                if (request.getSchool() != null) {
                    childRecord.setSchool(request.getSchool().getName());
                    childRecord.setSection(BusinessDictionary.getSection(request.getSection()));
                }
            }
        } catch (CvqException e) {
            // FIXME
            throw new RuntimeException();
        }

        return childRecord;
    }

    public static CategoryRecord getCategoryRecord(Object object) {
        CategoryRecord categoryRecord = new CategoryRecord();

        Category category = (Category) object;

        categoryRecord.setId(category.getId());
        categoryRecord.setName(category.getName());
        categoryRecord.setEMail(category.getPrimaryEmail());

        return categoryRecord;
    }

    public static UserRecord getUserRecord(Object object) {
        UserRecord userRecord = new UserRecord();

        Agent user = (Agent) object;

        userRecord.setId(user.getId());
        userRecord.setLogin(user.getLogin());
        userRecord.setFirstName(user.getFirstName());
        userRecord.setLastName(user.getLastName());
        userRecord.setProfile(BusinessDictionary.getSiteProfile(SiteProfile.AGENT));

        Set sitesRoles = user.getSitesRoles();
        if (sitesRoles != null) {
            Iterator iter = sitesRoles.iterator();
            if (iter.hasNext()) {
                SiteRoles siteRole = (SiteRoles) iter.next();
                userRecord.setProfile(BusinessDictionary.getSiteProfile(siteRole.getProfile()));
            }
        }

        if (user.getCategoriesRoles() != null) {
            Iterator iter = user.getCategoriesRoles().iterator();
            while (iter.hasNext()) {
                CategoryRoles categoryRole = (CategoryRoles) iter.next();
                int profile = ProfileManager.PROFILE_NONE;
                if (categoryRole.getProfile().equals(CategoryProfile.READ_ONLY))
                    profile = ProfileManager.PROFILE_RO;

                else if (categoryRole.getProfile().equals(CategoryProfile.READ_WRITE))
                    profile = ProfileManager.PROFILE_RW;

                else if (categoryRole.getProfile().equals(CategoryProfile.MANAGER))
                    profile = ProfileManager.PROFILE_MANAGER;

                userRecord.addCategoryProfile(categoryRole.getCategory().getId(), profile);
            }
        }

        return userRecord;
    }

    public static DocumentTypeRecord getDocumentTypeRecord(DocumentType documentType) {
        DocumentTypeRecord record = new DocumentTypeRecord();

        record.setId(documentType.getId());
        record.setType(documentType.getType());
        record.setName(documentType.getName());
        record.setLabel(BusinessDictionary.getDocumentType(documentType.getType()));

        return record;
    }

    public static MeansOfContactRecord getMeansOfContactRecord(MeansOfContact meansOfContact) {
        MeansOfContactRecord record = new MeansOfContactRecord();

        record.setId(meansOfContact.getId());
        record.setType(meansOfContact.getType());
        record.setEnabled(meansOfContact.isEnabled());
        record.setLabel(BusinessDictionary.getMeansOfContactLabel(record.getType()));

        return record;
    }

    private static String notNullValue(Object obj) {
        if (obj == null)
            return "";

        return obj.toString();
    }

}
