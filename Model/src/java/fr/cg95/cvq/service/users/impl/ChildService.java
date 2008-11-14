package fr.cg95.cvq.service.users.impl;

import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;

import fr.cg95.cvq.business.users.Address;
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

    public Long create(Individual individual, final HomeFolder homeFolder, Address address,
            boolean assignLogin) 
        throws CvqException {

        if (!(individual instanceof Child))
            return super.create(individual, homeFolder, address, assignLogin);

        Child child = (Child) individual;
        if (child.getSex() == null)
            child.setSex(SexType.UNKNOWN);

        return super.create(child, homeFolder, address, assignLogin);
    }

    public void delete(final Child child, boolean deletingHomeFolder) 
        throws CvqException {
    
        super.delete(child);
    }
    
    public Child getById(final Long id)
        throws CvqException, CvqObjectNotFoundException {
            return (Child) childDAO.findById(Child.class, id);
    }
    
    public List<ChildLegalResponsible> getLegalResponsibles(final Long id)
            throws CvqException, CvqObjectNotFoundException {
        return childDAO.listChildLegalResponsibles(id);
    }

    public void removeLegalResponsible(final Long childId, final Long adultId, 
            boolean deletingHomeFolder)
        throws CvqException, CvqObjectNotFoundException, CvqModelException {
        
        if (childId == null || adultId == null)
            throw new CvqObjectNotFoundException("either adult id or child id not provided");

        Child child = getById(childId);
        Set<ChildLegalResponsible> childClrSet = child.getLegalResponsibles();
        boolean foundAdult = false;
        for (ChildLegalResponsible clr : childClrSet) {
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
            logger.debug("removeLegalResponsible() removing " + adultId + " from CLRs of child " 
                    + childId);
            childDAO.update(child);
        } else {
            logger.debug("removeLegalResponsible() " + adultId + " is not a CLR for child " 
                    + childId);
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
}

