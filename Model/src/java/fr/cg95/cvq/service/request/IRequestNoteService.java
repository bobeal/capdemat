package fr.cg95.cvq.service.request;

import java.util.List;

import fr.cg95.cvq.business.request.RequestNote;
import fr.cg95.cvq.business.request.RequestNoteType;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.service.request.annotation.IsRequest;

public interface IRequestNoteService {

    /**
     * Get notes related to a given request.
     * Optionnal type parameter, used to filter notes if it is not null.
     * Filters notes that must not be readable
     * (private notes which don't belong to the current context)
     *
     * @return a list of {@link fr.cg95.cvq.business.request.RequestNote} objects
     */
    List<RequestNote> getNotes(@IsRequest final Long requestId, final RequestNoteType type)
        throws CvqException;

    /**
     * Get the last readable note (of this type, if not null).
     */
    RequestNote getLastNote(@IsRequest final Long requestId, final RequestNoteType type)
        throws CvqException;

    /**
     * Get the last readable note written by an agent (of this type, if not null).
     */
    RequestNote getLastAgentNote(@IsRequest final Long requestId, final RequestNoteType type)
        throws CvqException;

    /**
     * Add a note to a request.
     *
     * @param requestId the request to which note has to be added
     * @param rnt the type of the note
     * @param note the body of the note itself
     */
    void addNote(@IsRequest final Long requestId, final RequestNoteType rnt, final String note);

}
