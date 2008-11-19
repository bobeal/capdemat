package fr.cg95.cvq.service.users.impl;

import org.apache.log4j.Logger;

import fr.cg95.cvq.business.users.Address;
import fr.cg95.cvq.business.users.Child;
import fr.cg95.cvq.business.users.HomeFolder;
import fr.cg95.cvq.business.users.Individual;
import fr.cg95.cvq.business.users.SexType;
import fr.cg95.cvq.dao.users.IChildDAO;
import fr.cg95.cvq.exception.CvqException;
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

    public Long create(Individual individual, final HomeFolder homeFolder, Address address,
            boolean assignLogin) throws CvqException {

        if (!(individual instanceof Child))
            return super.create(individual, homeFolder, address, assignLogin);

        Child child = (Child) individual;
        if (child.getSex() == null)
            child.setSex(SexType.UNKNOWN);

        return super.create(child, homeFolder, address, assignLogin);
    }

    public void delete(final Child child, boolean deletingHomeFolder) throws CvqException {
        super.delete(child);
    }

    public Child getById(final Long id) throws CvqException, CvqObjectNotFoundException {
        return (Child) childDAO.findById(Child.class, id);
    }

    public Child getByBadgeNumber(String badgeNumber) throws CvqException {
        return childDAO.findByBadgeNumber(badgeNumber);
    }

    public void setChildDAO(IChildDAO childDAO) {
        this.childDAO = childDAO;
    }
}
