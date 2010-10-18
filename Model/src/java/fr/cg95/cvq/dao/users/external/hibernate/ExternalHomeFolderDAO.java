package fr.cg95.cvq.dao.users.external.hibernate;

import java.util.List;

import org.hibernate.criterion.Restrictions;

import fr.cg95.cvq.business.users.external.HomeFolderMapping;
import fr.cg95.cvq.dao.hibernate.GenericDAO;
import fr.cg95.cvq.dao.hibernate.HibernateUtil;
import fr.cg95.cvq.dao.users.external.IExternalHomeFolderDAO;

/**
 * @author jsb@zenexity.fr
 */
public class ExternalHomeFolderDAO
    extends GenericDAO implements IExternalHomeFolderDAO {

    @Override
    public HomeFolderMapping findHomeFolderMappingBy(String externalServiceLabel, 
            Long homeFolderId) {
        return (HomeFolderMapping)HibernateUtil.getSession()
            .createCriteria(HomeFolderMapping.class)
            .add(Restrictions.eq("externalServiceLabel", externalServiceLabel))
            .add(Restrictions.eq("homeFolderId", homeFolderId)).uniqueResult();
    }

    @Override
    public HomeFolderMapping findHomeFolderMappingBy(String externalServiceLabel,
            String externalCapdematId) {
        return (HomeFolderMapping)HibernateUtil.getSession()
            .createCriteria(HomeFolderMapping.class)
            .add(Restrictions.eq("externalServiceLabel", externalServiceLabel))
            .add(Restrictions.eq("externalCapDematId", externalCapdematId)).uniqueResult();
    }
}
