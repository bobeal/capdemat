package fr.cg95.cvq.service.users.impl;

import java.util.Date;
import java.util.Iterator;
import java.util.Set;

import org.apache.log4j.Logger;

import fr.cg95.cvq.business.users.ActorState;
import fr.cg95.cvq.business.users.Address;
import fr.cg95.cvq.business.users.Adult;
import fr.cg95.cvq.business.users.Child;
import fr.cg95.cvq.business.users.ChildLegalResponsible;
import fr.cg95.cvq.business.users.HomeFolder;
import fr.cg95.cvq.business.users.Individual;
import fr.cg95.cvq.business.users.SexType;
import fr.cg95.cvq.dao.IGenericDAO;
import fr.cg95.cvq.dao.users.IChildDAO;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.exception.CvqModelException;
import fr.cg95.cvq.exception.CvqObjectNotFoundException;
import fr.cg95.cvq.service.users.IAdultService;
import fr.cg95.cvq.service.users.IChildService;

/**
 * Implementation of the {@link IChildService child service}.
 *
 * @author bor@zenexity.fr
 */
public class ChildService extends IndividualService implements IChildService {

    static Logger logger = Logger.getLogger(ChildService.class);

    private IChildDAO childDAO;
    private IGenericDAO genericDAO;
    private IAdultService adultService;

    public Long create(Individual individual, final HomeFolder homeFolder, Address address,
            boolean assignLogin) 
        throws CvqException {

        if (!(individual instanceof Child))
            return super.create(individual, homeFolder, address, assignLogin);

        Child child = (Child) individual;
        if (child.getSex() == null)
            child.setSex(SexType.UNKNOWN);

        // check child does not have more than 3 legal responsibles
        Set legalResponsiblesSet = child.getLegalResponsibles();
        if (legalResponsiblesSet == null) {
            logger.error("create() Child must have at least one legal responsible");
            throw new CvqModelException("Child must have at least one legal responsible");
        } else if (legalResponsiblesSet.size() > 3) {
            logger.error("create() Too many legal responsibles for child : "  
                    + child.getFirstName());
            throw new CvqModelException("Too many legal responsibles for child : " 
                    + child.getFirstName());
        } else {
            Iterator lrSetIt = legalResponsiblesSet.iterator();
            while (lrSetIt.hasNext()) {
                ChildLegalResponsible clr = (ChildLegalResponsible) lrSetIt.next();
                Adult tempAdult = clr.getLegalResponsible();
                if (!homeFolder.getIndividuals().contains(tempAdult)) {
                    logger.debug("create() saving out-of-folder adult");
                    tempAdult.setState(ActorState.PENDING);
                    tempAdult.setCreationDate(new Date());
                    genericDAO.create(tempAdult);
                }

                genericDAO.create(clr);
            }
        }

        return super.create(child, homeFolder, address, assignLogin);
    }

    public void delete(final Child child, boolean deletingHomeFolder) 
        throws CvqException {
    
        logger.debug("Gonna delete child : " + child);

        child.setAdress(null);
        super.delete((Individual) child);
    }
    
    public Child getById(final Long id)
        throws CvqException, CvqObjectNotFoundException {
            return (Child) childDAO.findById(Child.class, id);
    }

    public void removeLegalResponsible(final Long childId, final Long adultId, 
            boolean deletingHomeFolder)
        throws CvqException, CvqObjectNotFoundException, CvqModelException {
        
        if (childId == null || adultId == null)
            throw new CvqObjectNotFoundException("either adult id or child id not provided");

        Child child = getById(childId);
        Set childClrSet = child.getLegalResponsibles();
        Iterator childClrIt = childClrSet.iterator();
        boolean foundAdult = false;
        while (childClrIt.hasNext()) {
            ChildLegalResponsible clr = (ChildLegalResponsible) childClrIt.next();
            if (clr.getLegalResponsible().getId().equals(adultId)) {
                // can't leave a child without at least one legal responsible
                if (!deletingHomeFolder && childClrSet.size() == 0) {
                    throw new CvqModelException("can't leave a child without a legal responsible");
                } 
                
                clr.setLegalResponsible(null);
                childClrSet.remove(clr);
                genericDAO.delete(clr);
                foundAdult = true;
                break;
            }
        }
        
        if (foundAdult) {
            logger.debug("removeLegalResponsible() removing " + adultId + " from CLRs of " 
                    + childId);
            childDAO.update(child);
        } else {
            logger.debug("removeLegalResponsible() did not find legal responsible : " + adultId);
        }
    }

    public Child getByBadgeNumber(String badgeNumber)
        throws CvqException {
        return childDAO.findByBadgeNumber(badgeNumber);
    }

    public void setChildDAO(IChildDAO childDAO) {
        this.childDAO = childDAO;
    }

    public void setGenericDAO(IGenericDAO genericDAO) {
        this.genericDAO = genericDAO;
    }

    public void setAdultService(IAdultService adultService) {
        this.adultService = adultService;
    }
}

