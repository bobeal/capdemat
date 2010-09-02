package fr.cg95.cvq.service.request.impl;

import java.util.Date;

import org.joda.time.DateTime;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.ListableBeanFactory;

import fr.cg95.cvq.business.request.RequestLock;
import fr.cg95.cvq.dao.hibernate.HibernateUtil;
import fr.cg95.cvq.dao.request.IRequestDAO;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.security.PermissionException;
import fr.cg95.cvq.security.SecurityContext;
import fr.cg95.cvq.security.annotation.Context;
import fr.cg95.cvq.security.annotation.ContextPrivilege;
import fr.cg95.cvq.security.annotation.ContextType;
import fr.cg95.cvq.service.request.IRequestLockService;
import fr.cg95.cvq.service.request.IRequestTypeService;

public class RequestLockService implements IRequestLockService, BeanFactoryAware {

    private IRequestDAO requestDAO;
    private IRequestTypeService requestTypeService;
    private ListableBeanFactory beanFactory;

    @Override
    @Context(types = {ContextType.ECITIZEN}, privilege = ContextPrivilege.WRITE)
    public void lock(final Long id)
        throws CvqException {
        applyLock(id);
    }

    @Override
    @Context(types = {ContextType.AGENT}, privilege = ContextPrivilege.READ)
    public void tryToLock(final Long id) {
        try {
            // FIXME JSB : hack to avoid bypassing aspect security
            ((IRequestLockService)beanFactory.getBean("requestLockService")).applyLock(id);
        } catch (PermissionException e) {
            // couldn't lock request : we only have READ privilege
        } catch (CvqException e) {
            // couldn't lock request : it is probably already locked
        }
    }

    @Override
    @Context(types = {ContextType.ECITIZEN, ContextType.AGENT}, privilege = ContextPrivilege.WRITE)
    public void applyLock(final Long requestId)
        throws CvqException {
        synchronized(this) {
            RequestLock lock = getRequestLock(requestId);
            if (lock == null) {
                // no lock, we can acquire a new one
                lock = new RequestLock(requestId, SecurityContext.getCurrentUserId());
            }
            else if (lock.getUserId().equals(SecurityContext.getCurrentUserId())
                    || new DateTime(lock.getDate().getTime()).plusMinutes(
                        requestTypeService.getGlobalRequestTypeConfiguration().getRequestLockMaxDelay())
                            .isBeforeNow()) {
                // current user owns the lock,
                // or the lock is old enough to be overriden
                lock.setDate(new Date());
                lock.setUserId(SecurityContext.getCurrentUserId());
            } else {
                throw new CvqException("request.lock.error.alreadyLocked");
            }
            requestDAO.saveOrUpdate(lock);
            HibernateUtil.getSession().flush();
        }
    }

    @Override
    @Context(types = {ContextType.ECITIZEN, ContextType.AGENT}, privilege = ContextPrivilege.READ)
    public RequestLock getRequestLock(final Long requestId) {
        synchronized(this) {
            return requestDAO.getRequestLock(requestId);
        }
    }

    @Override
    @Context(types = {ContextType.ECITIZEN, ContextType.AGENT}, privilege = ContextPrivilege.READ)
    public boolean isLocked(final Long requestId) {
        RequestLock lock = getRequestLock(requestId);
        return (lock != null
                && !lock.getUserId().equals(SecurityContext.getCurrentUserId())
                && !new DateTime(lock.getDate().getTime()).plusMinutes(
                    requestTypeService.getGlobalRequestTypeConfiguration().getRequestLockMaxDelay())
                        .isBeforeNow());
    }

    @Override
    @Context(types = {ContextType.ECITIZEN, ContextType.AGENT}, privilege = ContextPrivilege.READ)
    public boolean isLockedByCurrentUser(final Long requestId) {
        RequestLock lock = getRequestLock(requestId);
        return (lock != null
                && lock.getUserId().equals(SecurityContext.getCurrentUserId())
                && !new DateTime(lock.getDate().getTime()).plusMinutes(
                    requestTypeService.getGlobalRequestTypeConfiguration().getRequestLockMaxDelay())
                        .isBeforeNow());
    }

    @Override
    @Context(types = {ContextType.ECITIZEN, ContextType.AGENT}, privilege = ContextPrivilege.WRITE)
    public void release(final Long requestId) {
        synchronized(this) {
            RequestLock lock = getRequestLock(requestId);
            if (lock == null || !lock.getUserId().equals(SecurityContext.getCurrentUserId())) {
                return;
            }
            requestDAO.delete(lock);
            HibernateUtil.getSession().flush();
        }
    }

    @Override
    @Context(types = {ContextType.SUPER_ADMIN}, privilege = ContextPrivilege.NONE)
    public void cleanRequestLocks() {
        synchronized(this) {
            requestDAO.cleanRequestLocks(
                requestTypeService.getGlobalRequestTypeConfiguration().getRequestLockMaxDelay());
            HibernateUtil.getSession().flush();
        }
    }

    public void setRequestDAO(IRequestDAO requestDAO) {
        this.requestDAO = requestDAO;
    }

    @Override
    public void setBeanFactory(BeanFactory arg0) throws BeansException {
        this.beanFactory = (ListableBeanFactory) arg0;
    }

    public void setRequestTypeService(IRequestTypeService requestTypeService) {
        this.requestTypeService = requestTypeService;
    }
}
