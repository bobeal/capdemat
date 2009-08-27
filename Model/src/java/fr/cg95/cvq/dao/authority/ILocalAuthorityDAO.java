package fr.cg95.cvq.dao.authority;

import fr.cg95.cvq.business.authority.LocalAuthority;
import fr.cg95.cvq.dao.IGenericDAO;

/**
 * @author bor@zenexity.fr
 */
public interface ILocalAuthorityDAO extends IGenericDAO {

    /**
     * Look up a LocalAuthority by name.
     */
    LocalAuthority findByName(final String name);
}
