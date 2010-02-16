package fr.cg95.cvq.dao.request.hibernate;

import java.math.BigInteger;

import fr.cg95.cvq.business.request.RequestActionType;
import fr.cg95.cvq.dao.hibernate.GenericDAO;
import fr.cg95.cvq.dao.hibernate.HibernateUtil;
import fr.cg95.cvq.dao.request.IRequestActionDAO;

/**
 * Implementation of the {@link IRequestActionDAO} interface.
 * 
 * @author jsb@zenexity.fr
 */
public class RequestActionDAO extends GenericDAO implements IRequestActionDAO {

    @Override
    public boolean hasAction(final Long requestId, final RequestActionType type) {
        return !BigInteger.ZERO.equals(HibernateUtil.getSession()
            .createQuery("select count(*) from RequestAction where request_id = :requestId and type = :type")
                .setLong("requestId", requestId).setString("type", type.toString()).uniqueResult());
    }
}
