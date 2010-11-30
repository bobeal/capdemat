package fr.cg95.cvq.service.request.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.apache.xmlbeans.XmlObject;
import org.springframework.scheduling.annotation.Async;

import fr.cg95.cvq.business.external.ExternalServiceTrace;
import fr.cg95.cvq.business.external.TraceStatusEnum;
import fr.cg95.cvq.business.request.Request;
import fr.cg95.cvq.business.request.RequestState;
import fr.cg95.cvq.business.request.RequestType;
import fr.cg95.cvq.dao.external.IExternalServiceTraceDAO;
import fr.cg95.cvq.dao.hibernate.HibernateUtil;
import fr.cg95.cvq.dao.request.IRequestDAO;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.external.ExternalServiceBean;
import fr.cg95.cvq.external.IExternalProviderService;
import fr.cg95.cvq.external.IExternalService;
import fr.cg95.cvq.security.SecurityContext;
import fr.cg95.cvq.security.annotation.Context;
import fr.cg95.cvq.security.annotation.ContextPrivilege;
import fr.cg95.cvq.security.annotation.ContextType;
import fr.cg95.cvq.service.authority.ILocalAuthorityLifecycleAware;
import fr.cg95.cvq.service.request.IRequestExportService;
import fr.cg95.cvq.service.request.IRequestExternalService;
import fr.cg95.cvq.service.request.IRequestSearchService;
import fr.cg95.cvq.service.request.IRequestTypeService;
import fr.cg95.cvq.service.request.annotation.RequestFilter;
import fr.cg95.cvq.util.Critere;
import fr.cg95.cvq.util.mail.IMailService;
import fr.cg95.cvq.util.translation.ITranslationService;

public class RequestExternalService implements IRequestExternalService,
    ILocalAuthorityLifecycleAware {

    private static Logger logger = Logger.getLogger(RequestExternalService.class);

    private IExternalServiceTraceDAO externalServiceTraceDAO;

    private IRequestDAO requestDAO;

    private IRequestExportService requestExportService;
    private IExternalService externalService;

    private IRequestTypeService requestTypeService;

    private ITranslationService translationService;

    private IMailService mailService;

    private IRequestSearchService requestSearchService;

    private static final Set<TraceStatusEnum> finalExternalStatuses =
        new HashSet<TraceStatusEnum>(2);
    static {
        finalExternalStatuses.add(TraceStatusEnum.ACCEPTED);
        finalExternalStatuses.add(TraceStatusEnum.REJECTED);
    }

    @Override
    public IExternalProviderService getExternalServiceByRequestType(String requestTypeLabel) {
        Set<IExternalProviderService> externalProviderServices =
            getExternalServicesByRequestType(requestTypeLabel);
        if (!externalProviderServices.isEmpty())
            return getExternalServicesByRequestType(requestTypeLabel).toArray(new IExternalProviderService[1])[0];

        return null;
    }

    @Override
    public Set<IExternalProviderService> getExternalServicesByRequestType(String requestTypeLabel) {
        Set<String> requestTypesLabels = new HashSet<String>();
        requestTypesLabels.add(requestTypeLabel);
        return getExternalServicesByRequestTypes(requestTypesLabels);

    }

    /**
     * Get the list of external services objects for the current local authority
     * interested in events about the given request types.
     * 
     * @return an empty set if none found
     */
    private Set<IExternalProviderService>
        getExternalServicesByRequestTypes(final Set<String> requestTypesLabels) {
        Set<IExternalProviderService> resultSet = new HashSet<IExternalProviderService>();
        for (Map.Entry<IExternalProviderService, ExternalServiceBean> entry :
            SecurityContext.getCurrentConfigurationBean().getExternalServices().entrySet()) {
            for (String requestTypeLabel : requestTypesLabels) {
                if (entry.getValue().supportRequestType(requestTypeLabel)) {
                    resultSet.add(entry.getKey());
                }
            }
        }
        return resultSet;
    }

    @Override
    public boolean hasMatchingExternalService(String requestLabel) {
        Set<IExternalProviderService> externalProviderServices =
            getExternalServicesByRequestType(requestLabel);
        return !externalProviderServices.isEmpty();
    }

    @Override
    public Collection<String> getRequestTypesForExternalService(String externalServiceLabel) {
        ExternalServiceBean esb =
            externalService.getBeanForExternalService(externalService.getExternalServiceByLabel(externalServiceLabel));
        return esb == null ? Collections.<String>emptyList() : esb.getRequestTypes();
    }

    @Context(types = {ContextType.SUPER_ADMIN}, privilege = ContextPrivilege.NONE)
    public List<Request> getSendableRequests(String externalServiceLabel) {
        Set<RequestState> set = new HashSet<RequestState>(1);
        set.add(RequestState.VALIDATED);
        List<Request> result = new ArrayList<Request>();
        for (String rt : getRequestTypesForExternalService(externalServiceLabel)) {
            for (Request req : requestDAO.listByStatesAndType(set, rt, true)) {
                Set<Critere> criteriaSet = new HashSet<Critere>(3);
                criteriaSet.add(new Critere(ExternalServiceTrace.SEARCH_BY_KEY,
                    String.valueOf(req.getId()), Critere.EQUALS));
                criteriaSet.add(new Critere(ExternalServiceTrace.SEARCH_BY_NAME,
                    externalServiceLabel, Critere.EQUALS));
                criteriaSet.add(new Critere(
                    ExternalServiceTrace.SEARCH_BY_STATUS, finalExternalStatuses,
                    Critere.IN));
                if (externalService.getTracesCount(criteriaSet) == 0) {
                    result.add(req);
                }
            }
        }
        return result;
    }

    @Override
    @Context(types = {ContextType.SUPER_ADMIN}, privilege = ContextPrivilege.NONE)
    public Set<String> getGenerableRequestTypes() {
        Set<String> result = new HashSet<String>();
        for (ExternalServiceBean esb :
            SecurityContext.getCurrentConfigurationBean().getExternalServices().values()) {
            if (esb.getGenerateTracedRequest())
                result.addAll(esb.getRequestTypes());
        }
        return result;
    }

    @Override
    @Context(types = {ContextType.AGENT}, privilege = ContextPrivilege.READ)
    public List<String> checkExternalReferential(Request request) throws CvqException {

        if (!hasMatchingExternalService(request.getRequestType().getLabel()))
            return Collections.<String>emptyList();
        
        XmlObject xmlRequest = requestExportService.fillRequestXml(request);
        
        return externalService.checkExternalReferential(xmlRequest,
                getExternalServicesByRequestType(request.getRequestType().getLabel()));
    }

    @Override
    @Context(types = {ContextType.AGENT}, privilege = ContextPrivilege.WRITE)
    public void sendRequest(Request request) throws CvqException {

        if (!request.getState().equals(RequestState.VALIDATED))
            throw new CvqException("plugins.externalservices.error.requestMustBeValidated");

        if (!hasMatchingExternalService(request.getRequestType().getLabel()))
            return;

        externalService.sendRequest(requestExportService.fillRequestXml(request),
                getExternalServicesByRequestType(request.getRequestType().getLabel()));
    }

    @Override
    @Async
    @Context(types = {ContextType.AGENT}, privilege = ContextPrivilege.MANAGE)
    @RequestFilter(privilege = ContextPrivilege.MANAGE)
    public void sendRequests(Set<Critere> ids, String email) throws CvqException {
        HibernateUtil.beginTransaction();
        Set<Long> successes = new HashSet<Long>();
        Map<Long, String> failures = new HashMap<Long, String>();
        for (Request request : requestSearchService.get(ids, null, null, 0, 0, true)) {
            try {
                sendRequest(request);
                successes.add(request.getId());
            } catch (Exception e) {
                failures.put(request.getId(), e.getMessage());
            }
        }
        String body = "";
        if (!successes.isEmpty()) {
            body += translationService.translate(
                "externalService.batchRequestResend.notification.body.success",
                new Object[]{successes.size()}) + "\n\t* "
                    + StringUtils.join(successes, "\n\t* ") + "\n\n";
        }
        if (!failures.isEmpty()) {
            String failuresChunk = "";
            for (Map.Entry<Long, String> failure : failures.entrySet()) {
                failuresChunk += "\t* " + failure.getKey() + " : " + failure.getValue() + "\n";
            }
            body += translationService.translate(
                "externalService.batchRequestResend.notification.body.failure",
                new Object[]{failures.size()}) + "\n" + failuresChunk;
        }
        mailService.send(null, email, null,
            translationService.translate("externalService.batchRequestResend.notification.subject"),
            body);
        HibernateUtil.commitTransaction();
    }

    @Override
    @Context(types = {ContextType.AGENT}, privilege = ContextPrivilege.MANAGE)
    @RequestFilter(privilege = ContextPrivilege.MANAGE)
    public List<String> getKeys(Set<Critere> criterias) {
        return externalServiceTraceDAO.getKeys(criterias);
    }

    @Override
    @Context(types = {ContextType.ECITIZEN, ContextType.AGENT}, privilege = ContextPrivilege.READ)
    public Map<String, Object> loadExternalInformations(Request request) throws CvqException {

        if (!hasMatchingExternalService(request.getRequestType().getLabel()))
            return Collections.emptyMap();

        return externalService.loadExternalInformations(requestExportService.fillRequestXml(request));
    }

    @Override
    @Context(types = {ContextType.ECITIZEN, ContextType.AGENT}, privilege = ContextPrivilege.READ)
    public Map<Date, String> getConsumptionsByRequest(final Long requestId, Date dateFrom, Date dateTo)
            throws CvqException {

        Request request = (Request) requestDAO.findById(Request.class, requestId);
        if (request.getState().equals(RequestState.ARCHIVED)) {
            logger.debug("getConsumptionsByRequest() Filtering archived request : " + requestId);
            return null;
        }

        Set<IExternalProviderService> externalProviderServices =
            getExternalServicesByRequestType(request.getRequestType().getLabel());
        if (externalProviderServices == null || externalProviderServices.isEmpty())
            return Collections.emptyMap();

        return externalService.getConsumptions(request.getId(), dateFrom, dateTo, 
                externalProviderServices);
    }

    @Override
    @Context(types = {ContextType.SUPER_ADMIN})
    public void addLocalAuthority(String localAuthorityName) {
        for (RequestType rt : requestTypeService.getAllRequestTypes()) {
            for (IExternalProviderService service : getExternalServicesByRequestType(rt.getLabel())) {
                for (Long id :
                    externalServiceTraceDAO.getRequestsWithoutTrace(rt.getId(), service.getLabel())) {
                    externalService.addTrace(new ExternalServiceTrace(new Date(), id.toString(),
                        null, "capdemat",
                        translationService.translate("externalServiceTrace.message.addTraceOnStartup"),
                        service.getLabel(), TraceStatusEnum.NOT_SENT));
                }
            }
        }
    }

    @Override
    public void removeLocalAuthority(String localAuthorityName) {
        // nothing to do yet
    }

    public void setRequestDAO(IRequestDAO requestDAO) {
        this.requestDAO = requestDAO;
    }

    public void setRequestExportService(IRequestExportService requestExportService) {
        this.requestExportService = requestExportService;
    }

    public void setExternalService(IExternalService externalService) {
        this.externalService = externalService;
    }

    public void setExternalServiceTraceDAO(IExternalServiceTraceDAO externalServiceTraceDAO) {
        this.externalServiceTraceDAO = externalServiceTraceDAO;
    }

    public void setRequestTypeService(IRequestTypeService requestTypeService) {
        this.requestTypeService = requestTypeService;
    }

    public void setTranslationService(ITranslationService translationService) {
        this.translationService = translationService;
    }

    public void setMailService(IMailService mailService) {
        this.mailService = mailService;
    }

    public void setRequestSearchService(IRequestSearchService requestSearchService) {
        this.requestSearchService = requestSearchService;
    }
}
