package fr.cg95.cvq.service.authority.impl;

import java.util.List;

import org.apache.log4j.Logger;

import fr.cg95.cvq.business.authority.RecreationCenter;
import fr.cg95.cvq.dao.authority.IRecreationCenterDAO;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.service.authority.IRecreationCenterService;

/**
 * Implementation of the recreation center service.
 *
 * @author bor@zenexity.fr
 */
public final class RecreationCenterService implements IRecreationCenterService {

    static Logger logger = Logger.getLogger(RecreationCenterService.class);

    private IRecreationCenterDAO recreationCenterDAO;

    public RecreationCenterService() {
        super();
    }

    public RecreationCenter getByName(final String recreationCenterName)
        throws CvqException {

        return recreationCenterDAO.findByName(recreationCenterName);
    }

    public List<RecreationCenter> getAll()
        throws CvqException {

        return recreationCenterDAO.listAll();
    }

    public Long create(final RecreationCenter recreationCenter)
        throws CvqException {

        Long recreationCenterId = null;

        if (recreationCenter != null)
                recreationCenterId = recreationCenterDAO.create(recreationCenter);

        logger.debug("Created recreation center object with id : " + recreationCenterId);

        return recreationCenterId;
    }

    public void setDAO(IRecreationCenterDAO recreationCenterDAO) {
        this.recreationCenterDAO = recreationCenterDAO;
    }
}

