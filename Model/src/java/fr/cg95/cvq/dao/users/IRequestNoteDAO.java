package fr.cg95.cvq.dao.users;

import fr.cg95.cvq.business.users.RequestNote;
import fr.cg95.cvq.business.users.RequestNoteType;
import fr.cg95.cvq.dao.IGenericDAO;
import fr.cg95.cvq.permission.CvqPermissionException;
import java.util.List;

/**
 * @author bor@zenexity.fr
 */
public interface IRequestNoteDAO extends IGenericDAO {

    /**
     * Look up a RequestNote by request id and note type.
     */
    RequestNote findByRequestAndType(final Long requestId, final RequestNoteType rnt)
        throws CvqPermissionException;
    /**
     * Return the list of notes related to a given request.
     */
    List listByRequest(final Long requestId) throws CvqPermissionException;
}
