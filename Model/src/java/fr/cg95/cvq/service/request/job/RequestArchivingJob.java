package fr.cg95.cvq.service.request.job;

import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.joda.time.DateMidnight;
import org.joda.time.Months;
import org.joda.time.format.ISODateTimeFormat;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import fr.cg95.cvq.business.authority.LocalAuthorityResource.Type;
import fr.cg95.cvq.business.external.ExternalServiceTrace;
import fr.cg95.cvq.business.request.Request;
import fr.cg95.cvq.business.request.RequestAdminAction;
import fr.cg95.cvq.business.request.RequestAdminEvent;
import fr.cg95.cvq.business.request.RequestState;
import fr.cg95.cvq.dao.hibernate.HibernateUtil;
import fr.cg95.cvq.dao.request.IRequestDAO;
import fr.cg95.cvq.external.IExternalService;
import fr.cg95.cvq.security.annotation.Context;
import fr.cg95.cvq.security.annotation.ContextType;
import fr.cg95.cvq.service.authority.ILocalAuthorityRegistry;
import fr.cg95.cvq.service.request.IRequestPdfService;
import fr.cg95.cvq.service.request.IRequestServiceRegistry;
import fr.cg95.cvq.service.request.IRequestWorkflowService;
import fr.cg95.cvq.util.Critere;
import fr.cg95.cvq.util.translation.ITranslationService;

public class RequestArchivingJob implements ApplicationContextAware {

    public static class Result implements Serializable {
        private static final long serialVersionUID = 1L;
        public int numberOfSuccesses = 0;
        public Map<Request, Throwable> failures = new HashMap<Request, Throwable>();
    }

    private static final Set<RequestState> states = new HashSet<RequestState>(3);
    static {
        states.add(RequestState.VALIDATED);
        states.add(RequestState.NOTIFIED);
        states.add(RequestState.CLOSED);
    }

    private ApplicationContext applicationContext;
    private IExternalService externalService;
    private ILocalAuthorityRegistry localAuthorityRegistry;
    private IRequestDAO requestDAO;
    private IRequestPdfService requestPdfService;
    private IRequestServiceRegistry requestServiceRegistry;
    private IRequestWorkflowService requestWorkflowService;
    private ITranslationService translationService;

    @Context(types = {ContextType.SUPER_ADMIN})
    public void launch() {
        localAuthorityRegistry.browseAndCallback(this, "archive", null);
    }

    @Context(types = {ContextType.SUPER_ADMIN})
    public void archive() {
        Result result = new Result();
        DateMidnight today = new DateMidnight();
        for (Request request : requestDAO.listByStates(states, true)) {
            HibernateUtil.beginTransaction();
            int filingDelay = requestServiceRegistry.getRequestService(request).getFilingDelay();
            DateMidnight lastModificationDay = new DateMidnight(request.getLastModificationDate());
            if (Months.monthsBetween(lastModificationDay, today).getMonths() >= filingDelay) {
                try {
                    String motive = translationService
                        .translate("requestArchive.motive", new Object[]{filingDelay});
                    if (RequestState.VALIDATED.equals(request.getState()))
                        requestWorkflowService.updateRequestState(request.getId(),
                            RequestState.NOTIFIED, motive);
                    requestWorkflowService.updateRequestState(request.getId(),
                        RequestState.ARCHIVED, motive);
                    byte archive[] = requestPdfService.generateArchive(request.getId());
                    requestDAO.empty(request);
                    Set<Critere> criteriaSet = new HashSet<Critere>(1);
                    criteriaSet.add(new Critere(ExternalServiceTrace.SEARCH_BY_KEY,
                        request.getId().toString(), Critere.EQUALS));
                    for (ExternalServiceTrace trace :
                        externalService.getTraces(criteriaSet, null, null, 0, 0)) {
                        requestDAO.delete(trace);
                    }
                    String filename = translationService.translate("requestArchive.filename",
                        new Object[] {
                            translationService
                                .translateRequestTypeLabel(request.getRequestType().getLabel()),
                            today.toString(ISODateTimeFormat.date()),
                            request.getId().toString()
                    });
                    localAuthorityRegistry.saveLocalAuthorityResource(Type.REQUEST_ARCHIVE,
                        filename, archive);
                    try {
                        HibernateUtil.commitTransaction();
                        result.numberOfSuccesses++;
                    } catch (Throwable t) {
                        localAuthorityRegistry.getLocalAuthorityResourceFile(Type.REQUEST_ARCHIVE,
                            filename, false).delete();
                        throw t;
                    }
                } catch (Throwable t) {
                    t.printStackTrace();
                    result.failures.put(request, t);
                }
            }
        }
        RequestAdminAction action =
            new RequestAdminAction(RequestAdminAction.Type.REQUESTS_ARCHIVED);
        action.getComplementaryData().put(RequestAdminAction.Data.ARCHIVING_RESULT, result);
        HibernateUtil.beginTransaction();
        requestDAO.saveOrUpdate(action);
        RequestAdminEvent event = new RequestAdminEvent(this, action);
        applicationContext.publishEvent(event);
    }

    @Context(types = {ContextType.SUPER_ADMIN})
    public void migrate() {
        Result result = new Result();
        Set<RequestState> archivedStates = new HashSet<RequestState>(1);
        archivedStates.add(RequestState.ARCHIVED);
        DateMidnight today = new DateMidnight();
        for (Request request : requestDAO.listByStates(archivedStates, true)) {
            HibernateUtil.beginTransaction();
            try {
                byte archive[] = requestPdfService.generateArchive(request.getId());
                requestDAO.empty(request);
                Set<Critere> criteriaSet = new HashSet<Critere>(1);
                criteriaSet.add(new Critere(ExternalServiceTrace.SEARCH_BY_KEY,
                    request.getId().toString(), Critere.EQUALS));
                for (ExternalServiceTrace trace :
                    externalService.getTraces(criteriaSet, null, null, 0, 0)) {
                    requestDAO.delete(trace);
                }
                String filename = translationService.translate("requestArchive.filename",
                    new Object[] {
                        translationService
                            .translateRequestTypeLabel(request.getRequestType().getLabel()),
                        today.toString(ISODateTimeFormat.date()),
                        request.getId().toString()
                });
                localAuthorityRegistry.saveLocalAuthorityResource(Type.REQUEST_ARCHIVE,
                    filename, archive);
                try {
                    HibernateUtil.commitTransaction();
                    result.numberOfSuccesses++;
                } catch (Throwable t) {
                    localAuthorityRegistry.getLocalAuthorityResourceFile(Type.REQUEST_ARCHIVE,
                        filename, false).delete();
                    throw t;
                }
            } catch (Throwable t) {
                t.printStackTrace();
                result.failures.put(request, t);
            }
        }
        RequestAdminAction action =
            new RequestAdminAction(RequestAdminAction.Type.ARCHIVES_MIGRATED);
        action.getComplementaryData().put(RequestAdminAction.Data.ARCHIVING_RESULT, result);
        HibernateUtil.beginTransaction();
        requestDAO.saveOrUpdate(action);
        RequestAdminEvent event = new RequestAdminEvent(this, action);
        applicationContext.publishEvent(event);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext)
        throws BeansException {
        this.applicationContext = applicationContext;
    }

    public void setExternalService(IExternalService externalService) {
        this.externalService = externalService;
    }

    public void setLocalAuthorityRegistry(ILocalAuthorityRegistry localAuthorityRegistry) {
        this.localAuthorityRegistry = localAuthorityRegistry;
    }

    public void setRequestDAO(IRequestDAO requestDAO) {
        this.requestDAO = requestDAO;
    }

    public void setRequestPdfService(IRequestPdfService requestPdfService) {
        this.requestPdfService = requestPdfService;
    }

    public void setRequestServiceRegistry(IRequestServiceRegistry requestServiceRegistry) {
        this.requestServiceRegistry = requestServiceRegistry;
    }

    public void setRequestWorkflowService(IRequestWorkflowService requestWorkflowService) {
        this.requestWorkflowService = requestWorkflowService;
    }

    public void setTranslationService(ITranslationService translationService) {
        this.translationService = translationService;
    }
}
