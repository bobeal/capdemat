package fr.cg95.cvq.service.request.ecitizen;

import java.util.Set;

import fr.cg95.cvq.business.users.HistoryEntry;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.service.request.IRequestService;

/**
 * @author Benoit Orihuela (bor@zenexity.fr)
 */
public interface IHomeFolderModificationRequestService extends IRequestService {

    /**
     * Return all history entries associated to a given request.
     */
    Set<HistoryEntry> getHistoryEntries(final Long hfmrId)
        throws CvqException;
}
