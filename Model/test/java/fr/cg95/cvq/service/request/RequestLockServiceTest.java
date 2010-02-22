package fr.cg95.cvq.service.request;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import fr.cg95.cvq.business.request.Request;
import fr.cg95.cvq.business.users.CreationBean;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.security.PermissionException;
import fr.cg95.cvq.security.SecurityContext;

public class RequestLockServiceTest extends RequestTestCase {

    @Autowired
    protected IRequestLockService requestLockService;
    
    @Test
    public void testRequestLocks() throws CvqException {
        
        // create a home folder request
        CreationBean creationBean = gimmeAnHomeFolderWithRequest();
        continueWithNewTransaction();

        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.FRONT_OFFICE_CONTEXT);
        SecurityContext.setCurrentEcitizen(creationBean.getLogin());

        Long requestId = creationBean.getRequestId();
        Request request;
        // try to lock it with agent method in FO
        try {
            requestLockService.getAndTryToLock(requestId);
            fail("should have been forbidden");
        } catch (PermissionException e) {
            // OK
        } catch (Exception e) {
            fail("should have thrown a PermissionException");
        }
        // lock it with ecitizen method
        request = requestLockService.getAndLock(requestId);
        assertEquals(requestId, request.getId());
        assertTrue(requestLockService.isLockedByCurrentUser(requestId));
        assertFalse(requestLockService.isLocked(requestId));

        // try to lock it in BO
        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.BACK_OFFICE_CONTEXT);
        SecurityContext.setCurrentAgent(agentNameWithCategoriesRoles);
        request = requestLockService.getAndTryToLock(requestId);
        // check it couldn't be locked
        assertEquals(requestId, request.getId());
        assertFalse(requestLockService.isLockedByCurrentUser(requestId));
        assertTrue(requestLockService.isLocked(requestId));

        // go back in FO and release request
        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.FRONT_OFFICE_CONTEXT);
        SecurityContext.setCurrentEcitizen(creationBean.getLogin());
        requestLockService.release(requestId);
        // check it was correctly released
        assertFalse(requestLockService.isLockedByCurrentUser(requestId));
        assertFalse(requestLockService.isLocked(requestId));

        // go lock it in BO
        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.BACK_OFFICE_CONTEXT);
        SecurityContext.setCurrentAgent(agentNameWithCategoriesRoles);
        // try to lock it with ecitizen method in BO
        try {
            requestLockService.getAndLock(requestId);
            fail("should have been forbidden");
        } catch (PermissionException e) {
            // OK
        } catch (Exception e) {
            fail("should have thrown a PermissionException");
        }
        // lock it with correct method
        request = requestLockService.getAndTryToLock(requestId);
        assertEquals(requestId, request.getId());
        assertTrue(requestLockService.isLockedByCurrentUser(requestId));
        assertFalse(requestLockService.isLocked(requestId));
        // go back in FO and try to lock it
        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.FRONT_OFFICE_CONTEXT);
        SecurityContext.setCurrentEcitizen(creationBean.getLogin());
        try {
            requestLockService.getAndLock(requestId);
            fail("should have been forbidden");
        } catch (CvqException e) {
            // OK
        }  catch (Exception e) {
            fail("should have thrown a CvqException");
        }
        // go back in BO and release it
        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.BACK_OFFICE_CONTEXT);
        SecurityContext.setCurrentAgent(agentNameWithCategoriesRoles);
        requestLockService.release(requestId);
        assertFalse(requestLockService.isLockedByCurrentUser(requestId));
        assertFalse(requestLockService.isLocked(requestId));
    }
}
