package fr.cg95.cvq.dao.request.external;

import java.util.List;
import java.util.Set;

import fr.cg95.cvq.business.request.external.RequestExternalAction;
import fr.cg95.cvq.dao.IGenericDAO;
import fr.cg95.cvq.util.Critere;

/**
 * @author jsb@zenexity.fr
 */
public interface IRequestExternalActionDAO extends IGenericDAO {

    List<RequestExternalAction> get(Set<Critere> criteriaSet, String sort,
        String dir, int count, int offset, boolean lastOnly);

    Long getCount(Set<Critere> criteriaSet, boolean lastOnly);

    List<String> getKeys(Set<Critere> criterias);

    List<Long> getRequestsWithoutTrace(Long requestTypeId, String externalServiceLabel);
}
