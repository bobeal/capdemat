package fr.cg95.cvq.service.request;

import fr.cg95.cvq.business.request.RequestLock;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.service.request.annotation.IsRequest;

public interface IRequestLockService {

    /**
     * Lock a request as an ecitizen or fail with an exception.
     */
    void lock(@IsRequest final Long id)
        throws CvqException;

    /**
     * Lock a request as an agent or fail silently.
     */
    void tryToLock(@IsRequest final Long id);

    /**
     * Get the lock put on this request if it exists
     */
    RequestLock getRequestLock(@IsRequest final Long requestId);

    /**
     * <p>Put a lock on a request.</p>
     * <p>
     *   Visible to allow aspect security checks,
     *   but should not be called directly; use {@link #lock(Long)} or {@link #tryToLock(Long)}.
     * </p>
     */
    void applyLock(@IsRequest final Long requestId)
        throws CvqException;

    /**
     * Check if this request is locked by another person than current user.
     *
     * @param requestId the ID of the request to check
     * @return true if the request is locked by another one,
     *         false otherwise (no lock, or lock owned by current user)
     */
    boolean isLocked(@IsRequest final Long requestId);

    /**
     * Check if this request is locked by current user.
     *
     * @param requestId the ID of the request to check
     * @return true if there is a lock on this request and
     *         it is owned by current user
     */
    boolean isLockedByCurrentUser(@IsRequest final Long requestId);

    /**
     * Drop the lock on this request if current user has it.
     *
     * @param requestId the ID of the request to release
     */
    void release(@IsRequest final Long requestId);

    /**
     * Clean obsolete request locks
     */
    void cleanRequestLocks();
}
