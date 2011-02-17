package fr.cg95.cvq.service.users.impl;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.scheduling.annotation.Async;

import au.com.bytecode.opencsv.CSVWriter;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;

import fr.cg95.cvq.authentication.IAuthenticationService;
import fr.cg95.cvq.business.users.ActorState;
import fr.cg95.cvq.business.users.Address;
import fr.cg95.cvq.business.users.Adult;
import fr.cg95.cvq.business.users.Child;
import fr.cg95.cvq.business.users.HomeFolder;
import fr.cg95.cvq.business.users.Individual;
import fr.cg95.cvq.business.users.IndividualRole;
import fr.cg95.cvq.business.users.RoleType;
import fr.cg95.cvq.business.users.UserAction;
import fr.cg95.cvq.business.users.UsersEvent;
import fr.cg95.cvq.business.users.UsersEvent.EVENT_TYPE;
import fr.cg95.cvq.business.users.external.HomeFolderMapping;
import fr.cg95.cvq.business.users.external.IndividualMapping;
import fr.cg95.cvq.dao.IGenericDAO;
import fr.cg95.cvq.dao.hibernate.HibernateUtil;
import fr.cg95.cvq.dao.users.IAdultDAO;
import fr.cg95.cvq.dao.users.IChildDAO;
import fr.cg95.cvq.dao.users.IHomeFolderDAO;
import fr.cg95.cvq.dao.users.IIndividualDAO;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.exception.CvqObjectNotFoundException;
import fr.cg95.cvq.schema.ximport.HomeFolderImportDocument;
import fr.cg95.cvq.security.SecurityContext;
import fr.cg95.cvq.security.annotation.Context;
import fr.cg95.cvq.security.annotation.ContextPrivilege;
import fr.cg95.cvq.security.annotation.ContextType;
import fr.cg95.cvq.service.authority.ILocalAuthorityRegistry;
import fr.cg95.cvq.service.users.IHomeFolderService;
import fr.cg95.cvq.service.users.IIndividualService;
import fr.cg95.cvq.util.mail.IMailService;
import fr.cg95.cvq.util.translation.ITranslationService;
import fr.cg95.cvq.xml.common.AddressType;
import fr.cg95.cvq.xml.common.AdultType;
import fr.cg95.cvq.xml.common.ChildType;
import fr.cg95.cvq.xml.common.HomeFolderType;
import fr.cg95.cvq.xml.common.IndividualType;

/**
 * Implementation of the home folder service.
 *
 * @author Benoit Orihuela (bor@zenexity.fr)
 */
public class HomeFolderService implements IHomeFolderService, ApplicationContextAware {

    private static Logger logger = Logger.getLogger(HomeFolderService.class);

    protected IGenericDAO genericDAO;
    protected IHomeFolderDAO homeFolderDAO;
    protected IIndividualDAO individualDAO;
    protected IChildDAO childDAO;
    protected IAdultDAO adultDAO;

    protected IIndividualService individualService;

    protected ILocalAuthorityRegistry localAuthorityRegistry;
    protected IMailService mailService;

    private ApplicationContext applicationContext;

    private IAuthenticationService authenticationService;

    private ITranslationService translationService;

    @Override
    @Context(types = {ContextType.UNAUTH_ECITIZEN}, privilege = ContextPrivilege.WRITE)
    public HomeFolder create(final Adult adult, boolean temporary)
        throws CvqException {
        // FIXME bypass all access checks while we're setting everything up
        SecurityContext.setCurrentContext(SecurityContext.ADMIN_CONTEXT);
        HomeFolder homeFolder = new HomeFolder();
        homeFolder.setAddress(adult.getAddress());
        homeFolder.setEnabled(Boolean.TRUE);
        homeFolder.setState(ActorState.PENDING);
        homeFolder.setTemporary(temporary);
        homeFolderDAO.create(homeFolder);
        homeFolder.getActions().add(new UserAction(UserAction.Type.CREATION, homeFolder.getId()));
        addAdult(homeFolder, adult, !temporary);
        link(adult, homeFolder, Collections.singleton(RoleType.HOME_FOLDER_RESPONSIBLE));
        logger.debug("create() successfully created home folder " + homeFolder.getId());
        // FIXME hack for CG77
        if (adult.getPassword() != null) {
            applicationContext.publishEvent(new UsersEvent(
                this, UsersEvent.EVENT_TYPE.LOGIN_ASSIGNED, homeFolder.getId(), adult.getId()));
        }
        HibernateUtil.getSession().flush();
        // FIXME attribute all actions to the newly created responsible instead of system
        for (UserAction action : homeFolder.getActions()) {
            action.setUserId(adult.getId());
        }
        homeFolderDAO.update(homeFolder);
        // FIXME restore correct context
        SecurityContext.setCurrentContext(SecurityContext.FRONT_OFFICE_CONTEXT);
        return homeFolder;
    }

    @Override
    @Context(types = {ContextType.ECITIZEN, ContextType.AGENT}, privilege = ContextPrivilege.WRITE)
    public final void modify(final HomeFolder homeFolder) {
        if (homeFolder != null)
            homeFolderDAO.update(homeFolder);
    }

    @Override
    @Context(types = {ContextType.ECITIZEN, ContextType.AGENT}, privilege = ContextPrivilege.WRITE)
    public final void delete(final Long id)
        throws CvqObjectNotFoundException {
        HomeFolder homeFolder = getById(id);
        delete(homeFolder);
    }

    @Override
    @Context(types = {ContextType.ECITIZEN, ContextType.AGENT}, privilege = ContextPrivilege.WRITE)
    public void addAdult(HomeFolder homeFolder, Adult adult, boolean assignLogin)
        throws CvqException {
        homeFolder.getIndividuals().add(adult);
        adult.setHomeFolder(homeFolder);
        if (adult.getAddress() == null) adult.setAddress(homeFolder.getAddress());
        individualService.create(adult, assignLogin);
        homeFolderDAO.update(homeFolder);
    }

    @Override
    @Context(types = {ContextType.ECITIZEN, ContextType.AGENT}, privilege = ContextPrivilege.WRITE)
    public void addChild(HomeFolder homeFolder, Child child) {
        homeFolder.getIndividuals().add(child);
        child.setHomeFolder(homeFolder);
        if (child.getAddress() == null) child.setAddress(homeFolder.getAddress());
        individualService.create(child);
        homeFolderDAO.update(homeFolder);
    }

    @Override
    @Context(types = {ContextType.ECITIZEN, ContextType.AGENT}, privilege = ContextPrivilege.WRITE)
    public void deleteIndividual(final Long homeFolderId, final Long individualId) 
        throws CvqObjectNotFoundException {

        Individual individual = individualService.getById(individualId);
        HomeFolder homeFolder = getById(homeFolderId);
        for (Individual responsible : homeFolder.getIndividuals()) {
            unlink(responsible, individual);
        }
        individual.setHomeFolder(null);

        homeFolder.getIndividuals().remove(individual);
        individualService.delete(individual);

        UsersEvent individualEvent = 
            new UsersEvent(this, EVENT_TYPE.INDIVIDUAL_DELETE, null, individual.getId());
        applicationContext.publishEvent(individualEvent);
    }

    @Override
    @Context(types = {ContextType.ECITIZEN, ContextType.AGENT}, privilege = ContextPrivilege.WRITE)
    public void delete(HomeFolder homeFolder) {

        UsersEvent homeFolderEvent = 
            new UsersEvent(this, EVENT_TYPE.HOME_FOLDER_DELETE, homeFolder.getId(), null);
        applicationContext.publishEvent(homeFolderEvent);
        
        List<Individual> individuals = homeFolder.getIndividuals();
        for (Individual individual : individuals) {
            UsersEvent individualEvent = 
                new UsersEvent(this, EVENT_TYPE.INDIVIDUAL_DELETE, null, individual.getId());
            applicationContext.publishEvent(individualEvent);
        }

        // need to stack adults and children to ensure that adults are deleted before children
        // because of legal responsibles constraints
        Set<Adult> adults = new HashSet<Adult>();
        Set<Child> children = new HashSet<Child>();
        for (Individual individual : individuals) {
            if (individual instanceof Adult)
                adults.add((Adult)individual);
            else if (individual instanceof Child)
                children.add((Child) individual);
        }

        for (Adult adult : adults) {
            individualService.delete(adult);
        }

        for (Child child : children) {
            individualService.delete(child);
        }

        homeFolderDAO.delete(homeFolder);
    }

    @Override
    @Context(types = {ContextType.AGENT}, privilege = ContextPrivilege.READ)
    public final List<HomeFolder> getAll(boolean filterArchived, boolean filterTemporary) {
        return homeFolderDAO.listAll(filterArchived, filterTemporary);
    }

    @Override
    @Context(types = {ContextType.ECITIZEN, ContextType.AGENT}, privilege = ContextPrivilege.READ)
    public final HomeFolder getById(final Long id)
        throws CvqObjectNotFoundException {
        return (HomeFolder) homeFolderDAO.findById(HomeFolder.class, id);
    }

    @Override
    @Context(types = {ContextType.ECITIZEN, ContextType.AGENT}, privilege = ContextPrivilege.READ)
    public final List<Child> getChildren(final Long homeFolderId) {
        return childDAO.listChildrenByHomeFolder(homeFolderId);
    }

    @Override
    @Context(types = {ContextType.ECITIZEN, ContextType.AGENT}, privilege = ContextPrivilege.READ)
    public final List<Adult> getAdults(final Long homeFolderId) {
        return adultDAO.listAdultsByHomeFolder(homeFolderId);
    }

    @Override
    @Context(types = {ContextType.ECITIZEN, ContextType.AGENT}, privilege = ContextPrivilege.READ)
    public List<Individual> getIndividuals(Long homeFolderId) {
        return individualDAO.listByHomeFolder(homeFolderId);
    }

    @Override
    @Context(types = {ContextType.ECITIZEN, ContextType.AGENT}, privilege = ContextPrivilege.READ)
    public List<Individual> getExternalIndividuals(final Long homeFolderId) {
        Set<Individual> externalIndividuals = new HashSet<Individual>();
        externalIndividuals.addAll(individualDAO.listByHomeFolderRoles(homeFolderId, RoleType.allRoleTypes, true));
        for (Individual individual : getIndividuals(homeFolderId))
            externalIndividuals.addAll(individualDAO.listBySubjectRoles(individual.getId(), RoleType.allRoleTypes, true));
        return new ArrayList<Individual>(externalIndividuals);
    }

    @Override
    @Context(types = {ContextType.ECITIZEN, ContextType.AGENT}, privilege = ContextPrivilege.WRITE)
    public void link(Individual owner, HomeFolder target, Collection<RoleType> types) {
        Set<RoleType> missing = new HashSet<RoleType>(types);
        for (IndividualRole role : owner.getHomeFolderRoles(target.getId())) {
            if (types.contains(role.getRole())) missing.remove(role.getRole());
            else owner.getIndividualRoles().remove(role);
        }
        for (RoleType type : missing) {
            IndividualRole newRole = new IndividualRole();
            newRole.setRole(type);
            newRole.setHomeFolderId(target.getId());
            owner.getIndividualRoles().add(newRole);
        }
        UserAction action = new UserAction(UserAction.Type.MODIFICATION, target.getId());
        JsonObject payload = new JsonObject();
        JsonObject jsonResponsible = new JsonObject();
        JsonArray jsonTypes = new JsonArray();
        for (RoleType type : types) jsonTypes.add(new JsonPrimitive(type.toString()));
        jsonResponsible.add("types", jsonTypes);
        jsonResponsible.addProperty("id", owner.getId());
        payload.add("responsible", jsonResponsible);
        action.setData(new Gson().toJson(payload));
        owner.getHomeFolder().getActions().add(action);
        homeFolderDAO.update(owner.getHomeFolder());
    }

    @Override
    @Context(types = {ContextType.ECITIZEN, ContextType.AGENT}, privilege = ContextPrivilege.WRITE)
    public void unlink(Individual owner, HomeFolder target) {
        Set<RoleType> deleted = new HashSet<RoleType>();
        for (IndividualRole role : owner.getHomeFolderRoles(target.getId())) {
            owner.getIndividualRoles().remove(role);
            deleted.add(role.getRole());
        }
        UserAction action = new UserAction(UserAction.Type.MODIFICATION, target.getId());
        JsonObject payload = new JsonObject();
        JsonObject jsonResponsible = new JsonObject();
        JsonArray jsonTypes = new JsonArray();
        for (RoleType type : deleted) jsonTypes.add(new JsonPrimitive(type.toString()));
        jsonResponsible.add("deleted", jsonTypes);
        jsonResponsible.addProperty("id", owner.getId());
        payload.add("responsible", jsonResponsible);
        action.setData(new Gson().toJson(payload));
        owner.getHomeFolder().getActions().add(action);
        homeFolderDAO.update(owner.getHomeFolder());
    }

    @Override
    @Context(types = {ContextType.ECITIZEN, ContextType.AGENT}, privilege = ContextPrivilege.WRITE)
    public void link(Individual owner, Individual target, Collection<RoleType> types) {
        Set<RoleType> missing = new HashSet<RoleType>(types);
        for (IndividualRole role : owner.getIndividualRoles(target.getId())) {
            if (types.contains(role.getRole())) missing.remove(role.getRole());
            else owner.getIndividualRoles().remove(role);
        }
        for (RoleType type : missing) {
            IndividualRole newRole = new IndividualRole();
            newRole.setRole(type);
            newRole.setIndividualId(target.getId());
            owner.getIndividualRoles().add(newRole);
        }
        UserAction action = new UserAction(UserAction.Type.MODIFICATION, target.getId());
        JsonObject payload = new JsonObject();
        JsonObject jsonResponsible = new JsonObject();
        JsonArray jsonTypes = new JsonArray();
        for (RoleType type : types) jsonTypes.add(new JsonPrimitive(type.toString()));
        jsonResponsible.add("types", jsonTypes);
        jsonResponsible.addProperty("id", owner.getId());
        payload.add("responsible", jsonResponsible);
        action.setData(new Gson().toJson(payload));
        owner.getHomeFolder().getActions().add(action);
        homeFolderDAO.update(owner.getHomeFolder());
    }

    @Override
    @Context(types = {ContextType.ECITIZEN, ContextType.AGENT}, privilege = ContextPrivilege.WRITE)
    public void unlink( Individual owner, Individual target) {
        Set<RoleType> deleted = new HashSet<RoleType>();
        for (IndividualRole role : owner.getIndividualRoles(target.getId())) {
            owner.getIndividualRoles().remove(role);
            deleted.add(role.getRole());
        }
        UserAction action = new UserAction(UserAction.Type.MODIFICATION, target.getId());
        JsonObject payload = new JsonObject();
        JsonObject jsonResponsible = new JsonObject();
        JsonArray jsonTypes = new JsonArray();
        for (RoleType type : deleted) jsonTypes.add(new JsonPrimitive(type.toString()));
        jsonResponsible.add("deleted", jsonTypes);
        jsonResponsible.addProperty("id", owner.getId());
        payload.add("responsible", jsonResponsible);
        action.setData(new Gson().toJson(payload));
        owner.getHomeFolder().getActions().add(action);
        homeFolderDAO.update(owner.getHomeFolder());
    }

    @Override
    @Context(types = {ContextType.ECITIZEN, ContextType.AGENT}, privilege = ContextPrivilege.READ)
    public boolean hasHomeFolderRole(Long ownerId, Long homeFolderId, RoleType role)
            throws CvqObjectNotFoundException {
        
        Individual owner = individualService.getById(ownerId);
        if (owner.getIndividualRoles() == null)
            return false;
        
        for (IndividualRole individualRole : owner.getIndividualRoles()) {
            if (individualRole.getRole().equals(role)
                    && homeFolderId.equals(individualRole.getHomeFolderId()))
                return true;
        }
        
        return false;
    }

    @Override
    @Context(types = {ContextType.ECITIZEN, ContextType.AGENT}, privilege = ContextPrivilege.READ)
    public Adult getHomeFolderResponsible(Long homeFolderId) {
        List<Individual> individuals = 
            individualDAO.listByHomeFolderRole(homeFolderId, RoleType.HOME_FOLDER_RESPONSIBLE);
        // here we can make the assumption that we properly enforced the role
        return (Adult) individuals.get(0);
    }

    @Override
    @Context(types = {ContextType.ECITIZEN, ContextType.AGENT}, privilege = ContextPrivilege.READ)
    public List<Individual> listByHomeFolderRole(Long homeFolderId, RoleType role) {
        return individualDAO.listByHomeFolderRole(homeFolderId, role);
    }

    @Override
    @Context(types = {ContextType.ECITIZEN, ContextType.AGENT}, privilege = ContextPrivilege.READ)
    public List<Individual> listByHomeFolderRoles(Long homeFolderId, RoleType[] roles) {
        return individualDAO.listByHomeFolderRoles(homeFolderId, roles, false);
    }

    @Override
    @Context(types = {ContextType.ECITIZEN, ContextType.AGENT}, privilege = ContextPrivilege.READ)
    public List<Individual> listBySubjectRole(Long subjectId, RoleType role) {
        return individualDAO.listBySubjectRole(subjectId, role);
    }

    @Override
    @Context(types = {ContextType.ECITIZEN, ContextType.AGENT}, privilege = ContextPrivilege.READ)
    public List<Individual> listBySubjectRoles(Long subjectId, RoleType[] roles) {
        return individualDAO.listBySubjectRoles(subjectId, roles, false);
    }

    private void updateHomeFolderState(HomeFolder homeFolder, ActorState newState) {
        logger.debug("updateHomeFolderState() Gonna update state of home folder : "
            + homeFolder.getId());
        homeFolder.setState(newState);
        UserAction action = new UserAction(UserAction.Type.STATE_CHANGE, homeFolder.getId());
        JsonObject payload = new JsonObject();
        payload.addProperty("state", newState.toString());
        action.setData(new Gson().toJson(payload));
        homeFolder.getActions().add(action);
        homeFolderDAO.update(homeFolder);
		// retrieve individuals and validate them
		List<Individual> homeFolderIndividuals = homeFolder.getIndividuals();
		for (Individual individual : homeFolderIndividuals) {
			individualService.updateIndividualState(individual, newState);
		}
    }

    @Override
    @Context(types = {ContextType.AGENT}, privilege = ContextPrivilege.WRITE)
    public final void validate(final Long id)
        throws CvqObjectNotFoundException {
        updateHomeFolderState(getById(id), ActorState.VALID);
    }

    @Override
    @Context(types = {ContextType.AGENT}, privilege = ContextPrivilege.WRITE)
    public final void invalidate(final Long id)
        throws CvqObjectNotFoundException {
        updateHomeFolderState(getById(id), ActorState.INVALID);
    }

    @Override
    @Context(types = {ContextType.AGENT}, privilege = ContextPrivilege.WRITE)
    public final void archive(final Long id) 
        throws CvqObjectNotFoundException {
        HomeFolder homeFolder = getById(id);
        updateHomeFolderState(homeFolder, ActorState.ARCHIVED);
        UsersEvent homeFolderEvent =
            new UsersEvent(this, EVENT_TYPE.HOME_FOLDER_ARCHIVE, homeFolder.getId(), null);
        applicationContext.publishEvent(homeFolderEvent);
    }

    @Override
    public PasswordResetNotificationType notifyPasswordReset(Adult adult, String password, String categoryAddress)
        throws CvqException {
        String to = null;
        String body = null;
        PasswordResetNotificationType notificationType = PasswordResetNotificationType.INLINE;
        if (adult.getEmail() != null && !adult.getEmail().trim().isEmpty()) {
            to = adult.getEmail();
            body = "Veuillez trouver ci-dessous votre nouveau mot de passe :\n\t" + password + "\n\nBien cordialement.";
            notificationType = PasswordResetNotificationType.ADULT_EMAIL;
        } else if (categoryAddress != null) {
            to = categoryAddress;
            body = "Le mot de passe ci-dessous a été attribué à " + adult.getTitle() + " " + adult.getLastName() + " " + adult.getFirstName() + " (" + adult.getLogin() + ") :\n\t" + password;
            notificationType = PasswordResetNotificationType.CATEGORY_EMAIL;
        }
        if (notificationType != PasswordResetNotificationType.INLINE) {
            mailService.send(categoryAddress, to, null, "[" + SecurityContext.getCurrentSite().getDisplayTitle() + "] " + "Votre nouveau mot de passe pour vos démarches en ligne", body);
        }
        return notificationType;
    }

    @Override
    @Async
    @Context(types = {ContextType.ADMIN}, privilege = ContextPrivilege.WRITE)
    public void importHomeFolders(HomeFolderImportDocument doc)
        throws CvqException, IOException {
        ByteArrayOutputStream creationsOutput = new ByteArrayOutputStream();
        CSVWriter creations = new CSVWriter(new OutputStreamWriter(creationsOutput));
        creations.writeNext(new String[] {
            translationService.translate("homeFolder.property.id"),
            translationService.translate("homeFolder.property.externalId"),
            translationService.translate("homeFolder.individual.property.firstName"),
            translationService.translate("homeFolder.individual.property.lastName"),
            translationService.translate("homeFolder.adult.property.login"),
            translationService.translate("homeFolder.adult.property.password"),
            translationService.translate("homeFolder.adult.property.email"),
            translationService.translate("homeFolder.individual.property.address")
        });
        boolean hasCreations = false;
        ByteArrayOutputStream duplicatesOutput = new ByteArrayOutputStream();
        CSVWriter duplicates = new CSVWriter(new OutputStreamWriter(duplicatesOutput));
        duplicates.writeNext(new String[] {
            translationService.translate("homeFolder.property.externalId"),
            translationService.translate("homeFolder.individual.property.firstName"),
            translationService.translate("homeFolder.individual.property.lastName"),
            translationService.translate("homeFolder.adult.property.email"),
            translationService.translate("homeFolder.adult.property.homePhone"),
            translationService.translate("homeFolder.individual.property.address")
        });
        boolean hasDuplicates = false;
        ByteArrayOutputStream failuresOutput = new ByteArrayOutputStream();
        CSVWriter failures = new CSVWriter(new OutputStreamWriter(failuresOutput));
        failures.writeNext(new String[] {
            translationService.translate("homeFolder.property.externalId"),
            translationService.translate("Error")
        });
        boolean hasFailures = false;
        String label = doc.getHomeFolderImport().getExternalServiceLabel();
        homeFolders : for (HomeFolderType homeFolder : doc.getHomeFolderImport().getHomeFolderArray()) {
            HibernateUtil.beginTransaction();
            try {
                List<Adult> adults = new ArrayList<Adult>();
                List<Child> children = new ArrayList<Child>();
                List<Individual> individuals = new ArrayList<Individual>();
                HomeFolderMapping homeFolderMapping = null;
                if (label != null && homeFolder.getExternalId() != null) {
                    homeFolderMapping = new HomeFolderMapping(label, null, homeFolder.getExternalId());
                }
                Address homeFolderAddress = Address.xmlToModel(homeFolder.getAddress());
                for (IndividualType individual : homeFolder.getIndividualsArray()) {
                    String email = null;
                    String phone = null;
                    if (individual instanceof AdultType) {
                        AdultType adult = (AdultType)individual;
                        email = adult.getEmail();
                        phone = adult.getHomePhone();
                        Adult a = Adult.xmlToModel(adult);
                        adults.add(a);
                        individuals.add(a);
                    } else {
                        Child c = Child.xmlToModel((ChildType)individual);
                        children.add(c);
                        individuals.add(c);
                    }
                    AddressType address = individual.getAddress();
                    if (individualDAO.hasSimilarIndividuals(individual.getFirstName(),
                        individual.getLastName(), email, phone, address.getStreetNumber(),
                        address.getStreetName(), address.getPostalCode(), address.getCity())) {
                        duplicates.writeNext(new String[] {
                            homeFolder.getExternalId(),
                            individual.getFirstName(),
                            individual.getLastName(),
                            email,
                            phone,
                            address.getStreetNumber() == null ?
                                String.format("%s %s %s", address.getStreetName(),
                                    address.getPostalCode(), address.getCity()) :
                                String.format("%s %s %s %s", address.getStreetNumber(),
                                    address.getStreetName(), address.getPostalCode(), address.getCity())
                        });
                        hasDuplicates = true;
                        continue homeFolders;
                    }
                    if (homeFolderMapping != null) {
                        homeFolderMapping.getIndividualsMappings().add(
                            new IndividualMapping(null, individual.getExternalId(), homeFolderMapping));
                    }
                }
                HomeFolder result = new HomeFolder();
                //create(adults, children, homeFolderAddress, false);
                updateHomeFolderState(result, ActorState.VALID);
                HibernateUtil.getSession().flush();
                Adult responsible = getHomeFolderResponsible(result.getId());
                String password = authenticationService.generatePassword();
                authenticationService.resetAdultPassword(responsible, password);
                creations.writeNext(new String[] {
                    String.valueOf(result.getId()),
                    homeFolder.getExternalId(),
                    responsible.getFirstName(),
                    responsible.getLastName(),
                    responsible.getLogin(),
                    password,
                    responsible.getEmail(),
                    homeFolderAddress.getStreetNumber() == null ?
                            String.format("%s %s %s", homeFolderAddress.getStreetName(),
                                    homeFolderAddress.getPostalCode(), homeFolderAddress.getCity()) :
                            String.format("%s %s %s %s", homeFolderAddress.getStreetNumber(),
                                    homeFolderAddress.getStreetName(), homeFolderAddress.getPostalCode(), homeFolderAddress.getCity())
                });
                if (homeFolderMapping != null) {
                    homeFolderMapping.setHomeFolderId(result.getId());
                    for (int i = 0; i < individuals.size(); i++) {
                        homeFolderMapping.getIndividualsMappings().get(i).setIndividualId(
                            individuals.get(i).getId());
                    }
                    genericDAO.create(homeFolderMapping);
                }
                HibernateUtil.commitTransaction();
                hasCreations = true;
            } catch (Throwable t) {
                failures.writeNext(new String[]{homeFolder.getExternalId(), t.getMessage()});
                HibernateUtil.rollbackTransaction();
                hasFailures = true;
            }
        }
        creations.close();
        duplicates.close();
        failures.close();
        Map<String, byte[]> attachments = new LinkedHashMap<String, byte[]>();
        if (hasCreations) {
            attachments.put(translationService
                .translate("homeFolder.import.notification.attachmentName.creations") + ".csv",
                creationsOutput.toByteArray());
        }
        if (hasDuplicates) {
            attachments.put(translationService
                .translate("homeFolder.import.notification.attachmentName.duplicates") + ".csv",
                duplicatesOutput.toByteArray());
        }
        if (hasFailures) {
            attachments.put(translationService
                .translate("homeFolder.import.notification.attachmentName.errors") + ".csv",
                failuresOutput.toByteArray());
        }
        try {
            mailService.send(null, SecurityContext.getCurrentSite().getAdminEmail(), null,
                translationService.translate("homeFolder.import.notification.subject",
                    new Object[]{ SecurityContext.getCurrentSite().getDisplayTitle() }),
                translationService.translate("homeFolder.import.notification.body"), attachments);
        } catch (CvqException e) {
            logger.error("importHomeFolders : could not notify result", e);
        }
    }

	public void setLocalAuthorityRegistry(ILocalAuthorityRegistry localAuthorityRegistry) {
        this.localAuthorityRegistry = localAuthorityRegistry;
    }

    public void setMailService(IMailService mailService) {
		this.mailService = mailService;
	}
    public void setIndividualService(final IIndividualService individualService) {
		this.individualService = individualService;
	}

    public final void setHomeFolderDAO(final IHomeFolderDAO homeFolderDAO) {
        this.homeFolderDAO = homeFolderDAO;
    }

    public final void setChildDAO(final IChildDAO childDAO) {
        this.childDAO = childDAO;
    }

    public final void setAdultDAO(final IAdultDAO adultDAO) {
        this.adultDAO = adultDAO;
    }

	public void setIndividualDAO(IIndividualDAO individualDAO) {
        this.individualDAO = individualDAO;
    }

    public void setGenericDAO(IGenericDAO genericDAO) {
		this.genericDAO = genericDAO;
	}

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public void setAuthenticationService(IAuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    public void setTranslationService(ITranslationService translationService) {
        this.translationService = translationService;
    }
}
