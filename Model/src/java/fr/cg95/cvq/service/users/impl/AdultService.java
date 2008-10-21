package fr.cg95.cvq.service.users.impl;

import java.util.Iterator;
import java.util.Set;

import org.apache.log4j.Logger;

import fr.cg95.cvq.business.users.Address;
import fr.cg95.cvq.business.users.Adult;
import fr.cg95.cvq.business.users.Child;
import fr.cg95.cvq.business.users.FamilyStatusType;
import fr.cg95.cvq.business.users.HomeFolder;
import fr.cg95.cvq.business.users.Individual;
import fr.cg95.cvq.business.users.SexType;
import fr.cg95.cvq.business.users.TitleType;
import fr.cg95.cvq.dao.users.IAdultDAO;
import fr.cg95.cvq.exception.CvqAuthenticationFailedException;
import fr.cg95.cvq.exception.CvqBadPasswordException;
import fr.cg95.cvq.exception.CvqDisabledAccountException;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.exception.CvqObjectNotFoundException;
import fr.cg95.cvq.service.users.IAdultService;
import fr.cg95.cvq.service.users.IChildService;


/**
 * Implementation of the {@link IAdultService adult service}. 
 *
 * @author bor@zenexity.fr
 */
public class AdultService extends IndividualService implements IAdultService {

    static Logger logger = Logger.getLogger(AdultService.class);

    protected IAdultDAO adultDAO;
    protected IChildService childService;

    public Long create(Individual individual, final HomeFolder homeFolder, Address address,
            boolean assignLogin) 
        throws CvqException {
    
        if (!(individual instanceof Adult))
            return super.create(individual, homeFolder, address, assignLogin);
        
        Adult adult = (Adult) individual;
        if (adult.getFamilyStatus() == null)
            adult.setFamilyStatus(FamilyStatusType.OTHER);
        if (adult.getSex() == null)
            adult.setSex(SexType.UNKNOWN);
        if (adult.getTitle() == null)
            adult.setTitle(TitleType.UNKNOWN);
        if (assignLogin) {
            // generate a login even if user has not asked for a personal space
            assignLogin(individual);
        }
        if (adult.getPassword() != null)
            adult.setPassword(encryptPassword(adult.getPassword()));
        
        return super.create(adult, homeFolder, address, assignLogin);
    }
    
    public void modifyPassword(final Adult adult, final String oldPassword, 
            final String newPassword)
        throws CvqException, CvqBadPasswordException {

        // check the old password
        try {
            authenticationService.authenticate(adult.getLogin(), oldPassword);
        } catch (CvqAuthenticationFailedException cafe) {
            logger.warn("modifyPassword() old password does not match for user "
                        + adult.getLogin());
            throw new CvqBadPasswordException("Old password does not match for user "
                                   + adult.getLogin());
        } catch (CvqDisabledAccountException cdae) {
            logger.info("modifyPassword() account is disabled, still authorizing password change");
        }

        // it's ok, set the new one
        authenticationService.resetAdultPassword(adult, newPassword);
    }

    public void delete(final Adult adult, boolean deletingHomeFolder)
        throws CvqException {
        
        logger.debug("Gonna delete adult : " + adult);

        Set children = adult.getHomeFolder().getIndividuals();
        Iterator childrenIt = children.iterator();
        while (childrenIt.hasNext()) {
            Individual ind = (Individual) childrenIt.next();
            if (ind  instanceof Child) {
                childService.removeLegalResponsible(ind.getId(), adult.getId(), deletingHomeFolder);
            }
        }
        
        super.delete((Individual) adult);
    }
    
    public Adult getById(final Long id)
        throws CvqException, CvqObjectNotFoundException {

        Adult adult = (Adult) adultDAO.findById(Adult.class, id);
        return adult;
    }

    public void setAdultDAO(IAdultDAO iDAO) {
        this.adultDAO = iDAO;
    }

    public void setChildService(IChildService childService) {
        this.childService = childService;
    }
}