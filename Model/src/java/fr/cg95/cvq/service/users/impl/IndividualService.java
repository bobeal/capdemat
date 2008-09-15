package fr.cg95.cvq.service.users.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.apache.log4j.Logger;

import fr.cg95.cvq.authentication.IAuthenticationService;
import fr.cg95.cvq.business.users.ActorState;
import fr.cg95.cvq.business.users.Address;
import fr.cg95.cvq.business.users.HomeFolder;
import fr.cg95.cvq.business.users.Individual;
import fr.cg95.cvq.dao.document.IDocumentDAO;
import fr.cg95.cvq.dao.users.IIndividualDAO;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.exception.CvqModelException;
import fr.cg95.cvq.exception.CvqObjectNotFoundException;
import fr.cg95.cvq.service.users.IIndividualService;

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
    protected IDocumentDAO documentDAO;
    protected IAuthenticationService authenticationService;

    public IndividualService() {
        super();
    }

    public Set get(final Set criteriaSet, final String orderedBy, final boolean onlyIds,
            final boolean searchAmongArchived)
        throws CvqException {
        
        return new LinkedHashSet(individualDAO.search(criteriaSet, orderedBy, onlyIds, 
                searchAmongArchived ? null : new ActorState[] { ActorState.ARCHIVED }));
    }

    public Individual getById(final Long id)
        throws CvqException, CvqObjectNotFoundException {
        return (Individual) individualDAO.findById(Individual.class, id);
    }

    public Individual getByLogin(final String login)
        throws CvqException {

        Individual individual = null;
        individual = individualDAO.findByLogin(login);
        return individual;
    }

    public Individual getByCertificate(final String certificate)
        throws CvqException {

        Individual individual = null;
        individual = individualDAO.findByCertificate(certificate);
        return individual;
    }

    public Individual getByFederationKey(final String federationKey)
        throws CvqException {

        Individual individual = null;
        individual = individualDAO.findByFederationKey(federationKey);
        return individual;
    }

    // TODO : use document service instead
    public Set getAssociatedDocuments(final Long individualId)
        throws CvqException {

        logger.debug("getAssociatedDocuments() searching documents for individual id : " + individualId);

        List documentsList = documentDAO.listByIndividual(individualId);
        return new LinkedHashSet(documentsList);
    }

    public String encryptPassword(final String clearPassword)
        throws CvqException {

        return authenticationService.encryptPassword(clearPassword);
    }

    private String computeNewLogin(List baseList, String baseLogin) {

        TreeSet<Integer> indexesSet = new TreeSet<Integer>();
        for (int i=0; i < baseList.size(); i++) {
            String login = (String) baseList.get(i);
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

            if (individual.getFirstName() == null
                    || individual.getLastName() == null)
                throw new CvqModelException("Individual must have not-null first and last names");

            // lower case and remove any whitespace from last and first names
            String firstName = individual.getFirstName().toLowerCase().trim();
            firstName = firstName.replaceAll(" ", "-");
            String lastName = individual.getLastName().toLowerCase().trim();
            lastName = lastName.replaceAll(" ", "-");
            String baseLogin = firstName + "." + lastName;
            logger.debug("assignLogin() searching from " + baseLogin);
            List similarLogins = null;
            similarLogins = individualDAO.getSimilarLogins(baseLogin);

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

    protected void delete(final Individual individual) 
        throws CvqException {

		logger.debug("Gonna delete individual with id : " + individual.getId());
//            individual.setAdress(null);
            
            // TODO : remove orphan documents ?
		if (individual.getDocuments() != null)
			individual.getDocuments().clear();
        
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

    public void setDocumentDAO(IDocumentDAO documentDAO) {
        this.documentDAO = documentDAO;
    }

    public void setAuthenticationService(IAuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }
}

