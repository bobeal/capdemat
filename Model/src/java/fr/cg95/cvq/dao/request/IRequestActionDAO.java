package fr.cg95.cvq.dao.request;

import java.util.List;
import java.util.Set;

import fr.cg95.cvq.business.request.RequestAction;
import fr.cg95.cvq.dao.IGenericDAO;
import fr.cg95.cvq.util.Critere;

/**
 * @author jsb@zenexity.fr
 */
public interface IRequestActionDAO extends IGenericDAO {

    List<RequestAction> get(Set<Critere> criteriaSet, String sort,
        String dir, int recordsReturned, int startIndex);

    Long getCount(Set<Critere> criteriaSet);
}
