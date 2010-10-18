package fr.cg95.cvq.dao.users.external;

import fr.cg95.cvq.business.users.external.HomeFolderMapping;
import fr.cg95.cvq.dao.IGenericDAO;

/**
 * @author jsb@zenexity.fr
 */
public interface IExternalHomeFolderDAO extends IGenericDAO {

    HomeFolderMapping findHomeFolderMappingBy(String externalServiceLabel, Long homeFolderId);
    HomeFolderMapping findHomeFolderMappingBy(String externalServiceLabel, String externalCapdematId);
}
