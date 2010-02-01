package fr.cg95.cvq.dao.users;

import java.util.List;

import fr.cg95.cvq.business.users.HomeFolder;
import fr.cg95.cvq.dao.IGenericDAO;

/**
 * @author bor@zenexity.fr
 */
public interface IHomeFolderDAO extends IGenericDAO {

    /**
     * Return the list of all known home folders.
     */
    List<HomeFolder> listAll(boolean filterArchived, boolean filterTemporary);
}
