package fr.cg95.cvq.dao.external;

import java.util.List;
import java.util.Set;

import fr.cg95.cvq.business.external.ExternalServiceTrace;
import fr.cg95.cvq.dao.IGenericDAO;
import fr.cg95.cvq.util.Critere;

/**
 * @author jsb@zenexity.fr
 */
public interface IExternalServiceTraceDAO extends IGenericDAO {

    List<ExternalServiceTrace> get(Set<Critere> criteriaSet, String sort,
        String dir, int count, int offset, boolean lastOnly);

    Long getCount(Set<Critere> criteriaSet, boolean lastOnly);
}
