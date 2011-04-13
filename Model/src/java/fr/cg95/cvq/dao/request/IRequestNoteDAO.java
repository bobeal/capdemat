package fr.cg95.cvq.dao.request;

import fr.cg95.cvq.business.request.RequestNote;
import fr.cg95.cvq.business.request.RequestNoteType;
import fr.cg95.cvq.dao.jpa.IJpaTemplate;

import java.util.List;

/**
 * @author bor@zenexity.fr
 */
public interface IRequestNoteDAO extends IJpaTemplate<RequestNote, Long> {

    /**
     * Return the list of notes related to a given request,
     * filtered with the specified type if it is not null.
     */
    List<RequestNote> listByRequestAndType(final Long requestId, final RequestNoteType type);
}
