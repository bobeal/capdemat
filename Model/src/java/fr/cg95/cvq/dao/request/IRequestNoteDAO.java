package fr.cg95.cvq.dao.request;

import fr.cg95.cvq.business.request.RequestNote;
import fr.cg95.cvq.dao.IGenericDAO;
import java.util.List;

/**
 * @author bor@zenexity.fr
 */
public interface IRequestNoteDAO extends IGenericDAO {

    /**
     * Return the list of notes related to a given request.
     */
    List<RequestNote> listByRequest(final Long requestId);
}
