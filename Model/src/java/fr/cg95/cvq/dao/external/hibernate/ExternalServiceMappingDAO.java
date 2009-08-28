package fr.cg95.cvq.dao.external.hibernate;

import org.hibernate.criterion.Restrictions;

import fr.cg95.cvq.business.external.ExternalServiceIdentifierMapping;
import fr.cg95.cvq.dao.external.IExternalServiceMappingDAO;
import fr.cg95.cvq.dao.hibernate.GenericDAO;
import fr.cg95.cvq.dao.hibernate.HibernateUtil;

/**
 * @author jsb@zenexity.fr
 */
public class ExternalServiceMappingDAO
    extends GenericDAO implements IExternalServiceMappingDAO {

    @Override
    public ExternalServiceIdentifierMapping
        getIdentifierMapping(String externalServiceLabel, Long homeFolderId) {
        return (ExternalServiceIdentifierMapping)HibernateUtil.getSession()
            .createCriteria(ExternalServiceIdentifierMapping.class)
            .add(Restrictions.eq("externalServiceLabel", externalServiceLabel))
            .add(Restrictions.eq("homeFolderId", homeFolderId)).uniqueResult();
    }
}
