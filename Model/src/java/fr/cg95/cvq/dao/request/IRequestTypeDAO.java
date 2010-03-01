package fr.cg95.cvq.dao.request;

import java.util.List;
import java.util.Set;

import fr.cg95.cvq.business.request.GlobalRequestTypeConfiguration;
import fr.cg95.cvq.business.request.RequestType;
import fr.cg95.cvq.business.request.DisplayGroup;
import fr.cg95.cvq.dao.IGenericDAO;
import fr.cg95.cvq.util.Critere;

/**
 * @author bor@zenexity.fr
 */
public interface IRequestTypeDAO extends IGenericDAO {

    /**
     * Look up a request type by label.
     */
    RequestType findByLabel(final String requestTypeLabel);

    /**
     * Return the list of all known requests types.
     */
    List<RequestType> listAll();

    /**
     * Return the list of requests types in the given activation state.
     */
    List<RequestType> listByCategoryAndState(Set<Critere> criteriaSet);

    List<DisplayGroup> listAllDisplayGroup();

    GlobalRequestTypeConfiguration getGlobalRequestTypeConfiguration();
}
