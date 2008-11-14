package fr.cg95.cvq.service.users.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.apache.log4j.Logger;

import fr.cg95.cvq.authentication.IAuthenticationService;
import fr.cg95.cvq.business.users.ActorState;
import fr.cg95.cvq.business.users.Address;
import fr.cg95.cvq.business.users.Adult;
import fr.cg95.cvq.business.users.HomeFolder;
import fr.cg95.cvq.business.users.Individual;
import fr.cg95.cvq.business.users.IndividualRole;
import fr.cg95.cvq.business.users.RoleEnum;
import fr.cg95.cvq.dao.users.IIndividualDAO;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.exception.CvqModelException;
import fr.cg95.cvq.exception.CvqObjectNotFoundException;
import fr.cg95.cvq.service.document.IDocumentService;
import fr.cg95.cvq.service.users.IIndividualService;
import fr.cg95.cvq.util.Critere;

/**
 * Implementation of the {@link IIndividualService} service.
 *
 * @author Benoit Orihuela (bor@zenexity.fr)
 */
public class IndividualService implements IIndividualService {

    static Logger logger = Logger.getLogger(IndividualService.class);

    private static Collection<String> bookedLogin = 
        Collections.synchronizedCollection(new ArrayList<String>());
    
    protected IIndividualDAO individualDAO;
    protected IDocumentService documentService;
    protected IAuthenticationService authenticationService;

    public List<Individual> get(final Set<Critere> criteriaSet, final String orderedBy, 
            final boolean searchAmongArchived)
        throws CvqException {
        
        return individualDAO.search(criteriaSet, orderedBy, 
                searchAmongArchived ? null : new ActorState[] { ActorState.ARCHIVED });
    }

    public Individual getById(final Long id)
        throws CvqException, CvqObjectNotFoundException {
        return (Individual) individualDAO.findById(Individual.class, id);
    }

    public Individual getByLogin(final String login)
        throws CvqException {

        return individualDAO.findByLogin(login);
    }

    public Individual getByCertificate(final String certificate)
        throws CvqException {

        return individualDAO.findByCertificate(certificate);
    }

    public Individual getByFederationKey(final String federationKey)
        throws CvqException {

        return individualDAO.findByFederationKey(federationKey);
    }

    @Override
    public List<Individual> getByHomeFolderRole(Long homeFolderId, RoleEnum role) {
        return individualDAO.listByHomeFolderRole(homeFolderId, role);
    }

    @Override
    public List<Individual> getBySubjectRole(Long subjectId, RoleEnum role) {
        return individualDAO.listBySubjectRole(subjectId, role);
    }

    public String encryptPassword(final String clearPassword)
        throws CvqException {

        return authenticationService.encryptPassword(clearPassword);
    }

    private String computeNewLogin(List<String> baseList, String baseLogin) {

        TreeSet<Integer> indexesSet = new TreeSet<Integer>();
        for (String login : baseList) {
            String index = login.substring(baseLogin.length());
            if (index == null || index.equals(""))
                index = "1";
            try {
                Integer intIndex = Integer.valueOf(index);
                indexesSet.add(intIndex);
            } catch (NumberFormatException nfe) {
                // the tail was not an integer, ignore it
            }
        }

        int finalIndex = 0;
        if (!indexesSet.isEmpty()) {
            finalIndex = indexesSet.last();
        }
        logger.debug("computeNewLogin() got final index " + finalIndex);
        
        String loginFromDb = null;
        if (finalIndex == 0)
            loginFromDb = baseLogin;
        else
            loginFromDb = baseLogin + String.valueOf(++finalIndex);
        logger.debug("computeNewLogin() got new login from DB " + loginFromDb);
        
        if (bookedLogin.contains(loginFromDb)) {
            String currentIndex = loginFromDb.substring(baseLogin.length());
            int currIdx = 1;
            if (currentIndex != null && !currentIndex.equals(""))
                currIdx = (Integer.parseInt(currentIndex) > finalIndex ? 
                        Integer.parseInt(currentIndex) : finalIndex);
            String loginToTest = null;
            do {
                currIdx++;
                loginToTest = baseLogin + String.valueOf(currIdx);
            } while (bookedLogin.contains(loginToTest));
            
            bookedLogin.add(loginToTest);
            return loginToTest;
        } else {
            bookedLogin.add(loginFromDb);
            return loginFromDb;
        }
    }

    public String assignLogin(Individual individual)
        throws CvqException {

        synchronized (bookedLogin) {

            if (individual.getFirstName() == null || individual.getLastName() == null)
                throw new CvqModelException("Individual must have not-null first and last names");

            // lower case and remove any whitespace from last and first names
            String firstName = individual.getFirstName().toLowerCase().trim();
            firstName = firstName.replaceAll(" ", "-");
            String lastName = individual.getLastName().toLowerCase().trim();
            lastName = lastName.replaceAll(" ", "-");
            String baseLogin = firstName + "." + lastName;
            logger.debug("assignLogin() searching from " + baseLogin);
            List<String> similarLogins = individualDAO.getSimilarLogins(baseLogin);
            String finalLogin = computeNewLogin(similarLogins, baseLogin);
            logger.debug("assignLogin() setting login : " + finalLogin);

            individual.setLogin(finalLogin);

            return finalLogin;
        }
    }

    public Long create(Individual individual, final HomeFolder homeFolder, Address address,
            boolean assignLogin)
        throws CvqException {

        if (individual == null)
            return null;
        
        individual.setState(ActorState.PENDING);
        individual.setCreationDate(new Date());
        if (address != null)
            individual.setAdress(address);
        if (homeFolder != null)
            individual.setHomeFolder(homeFolder);
        
        return individualDAO.create(individual);
    }

    public void modify(final Individual individual)
        throws CvqException {

        if (individual == null)
            throw new CvqException("No adult object provided");
        else if (individual.getId() == null)
            throw new CvqException("Cannot modify a transient individual");

        individualDAO.update(individual);
    }

    @Override
    public void addRole(Long ownerId, RoleEnum role, Long homeFolderId, Long individualId)
            throws CvqException {

        Individual owner = getById(ownerId);
        
        if (role.equals(RoleEnum.HOME_FOLDER_RESPONSIBLE)) {
            if (! (owner instanceof Adult))
                throw new CvqModelException("homeFolder.role.error.responsibleMustBeAnAdult");
            if (homeFolderId == null)
                throw new CvqModelException("homeFolder.role.error.responsibleRequiresHomeFolderTarget");
            // FIXME ACMF : can we have more than one HF responsible for an HF ?
            IndividualRole individualRole = new IndividualRole();
            individualRole.setOwner(owner);
            individualRole.setRole(RoleEnum.HOME_FOLDER_RESPONSIBLE);
            individualRole.setHomeFolderId(homeFolderId);
            if (owner.getIndividualRoles() == null)
                owner.setIndividualRoles(new HashSet<IndividualRole>());
            owner.getIndividualRoles().add(individualRole);
        }
    }

    @Override
    public void removeRole(Long ownerId, RoleEnum role, Long homeFolderId, Long individualId)
            throws CvqException {

        Individual owner = getById(ownerId);
        if (role.equals(RoleEnum.HOME_FOLDER_RESPONSIBLE)) {
            if (! (owner instanceof Adult))
                throw new CvqModelException("homeFolder.role.error.responsibleMustBeAnAdult");
            if (homeFolderId == null)
                throw new CvqModelException("homeFolder.role.error.responsibleRequiresHomeFolderTarget");
            IndividualRole roleToRemove = null;
            for (IndividualRole individualRole : owner.getIndividualRoles()) {
                if (individualRole.getRole().equals(RoleEnum.HOME_FOLDER_RESPONSIBLE)
                        && individualRole.getHomeFolderId().equals(homeFolderId)) {
                    roleToRemove = individualRole;
                    break;
                }
            }
            if (roleToRemove != null)
                owner.getIndividualRoles().remove(roleToRemove);
            else
                logger.warn("role " + role + " not found for " + ownerId 
                        + " on home folder " + homeFolderId);
        }  
    }

    protected void delete(final Individual individual) 
        throws CvqException {

        individual.setAdress(null);
		individualDAO.delete(individual);
	}

    public void updateIndividualState(Individual individual, ActorState newState) 
        throws CvqException {
        
        individual.setState(newState);
        individualDAO.update(individual);
    }

    public void setIndividualDAO(IIndividualDAO individualDAO) {
        this.individualDAO = individualDAO;
    }

    public void setDocumentService(IDocumentService documentService) {
        this.documentService = documentService;
    }

    public void setAuthenticationService(IAuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }
}

