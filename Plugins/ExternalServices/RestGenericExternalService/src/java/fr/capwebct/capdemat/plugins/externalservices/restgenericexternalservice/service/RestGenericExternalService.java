package fr.capwebct.capdemat.plugins.externalservices.restgenericexternalservice.service;

import java.io.File;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang.StringEscapeUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.xmlbeans.XmlObject;

import fr.cg95.cvq.business.authority.LocalAuthorityResource.Type;
import fr.cg95.cvq.business.payment.ExternalAccountItem;
import fr.cg95.cvq.business.payment.ExternalDepositAccountItem;
import fr.cg95.cvq.business.payment.ExternalInvoiceItem;
import fr.cg95.cvq.business.payment.PurchaseItem;
import fr.cg95.cvq.business.request.Request;
import fr.cg95.cvq.business.request.RequestState;
import fr.cg95.cvq.business.request.external.RequestExternalAction;
import fr.cg95.cvq.business.request.workflow.event.IWorkflowPostAction;
import fr.cg95.cvq.business.request.workflow.event.impl.WorkflowArchivedEvent;
import fr.cg95.cvq.business.request.workflow.event.impl.WorkflowCancelledEvent;
import fr.cg95.cvq.business.request.workflow.event.impl.WorkflowClosedEvent;
import fr.cg95.cvq.business.request.workflow.event.impl.WorkflowCompleteEvent;
import fr.cg95.cvq.business.request.workflow.event.impl.WorkflowDraftEvent;
import fr.cg95.cvq.business.request.workflow.event.impl.WorkflowExtInProgressEvent;
import fr.cg95.cvq.business.request.workflow.event.impl.WorkflowGenericEvent;
import fr.cg95.cvq.business.request.workflow.event.impl.WorkflowInProgressEvent;
import fr.cg95.cvq.business.request.workflow.event.impl.WorkflowNotifiedEvent;
import fr.cg95.cvq.business.request.workflow.event.impl.WorkflowPendingEvent;
import fr.cg95.cvq.business.request.workflow.event.impl.WorkflowRectifiedEvent;
import fr.cg95.cvq.business.request.workflow.event.impl.WorkflowRejectedEvent;
import fr.cg95.cvq.business.request.workflow.event.impl.WorkflowUncompleteEvent;
import fr.cg95.cvq.business.request.workflow.event.impl.WorkflowValidatedEvent;
import fr.cg95.cvq.business.users.Adult;
import fr.cg95.cvq.business.users.Child;
import fr.cg95.cvq.business.users.HomeFolder;
import fr.cg95.cvq.business.users.Individual;
import fr.cg95.cvq.business.users.external.HomeFolderMapping;
import fr.cg95.cvq.dao.request.external.IRequestExternalActionDAO;
import fr.cg95.cvq.exception.CvqConfigurationException;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.external.ExternalServiceBean;
import fr.cg95.cvq.external.impl.ExternalProviderServiceAdapter;
import fr.cg95.cvq.security.SecurityContext;
import fr.cg95.cvq.service.authority.ILocalAuthorityRegistry;
import fr.cg95.cvq.service.request.IRequestActionService;
import fr.cg95.cvq.service.request.IRequestWorkflowService;
import fr.cg95.cvq.util.web.WS;
import fr.cg95.cvq.util.web.WS.HttpResponse;
import fr.cg95.cvq.util.web.WS.WSRequest;
import fr.cg95.cvq.xml.common.RequestType;
import fr.cg95.cvq.xml.common.SubjectType;
import groovy.lang.Writable;
import groovy.text.GStringTemplateEngine;
import groovy.text.TemplateEngine;

public class RestGenericExternalService extends ExternalProviderServiceAdapter {

    private static Logger logger = Logger.getLogger(RestGenericExternalService.class);

    private IRequestExternalActionDAO requestExternalActionDAO;
    private ILocalAuthorityRegistry localAuthorityRegistry;
    private IRequestActionService requestActionService;

    private String label;

    @Override
    public void checkConfiguration(ExternalServiceBean externalServiceBean, String localAuthorityName)
            throws CvqConfigurationException {
    }

    @Override
    public Map<String, List<ExternalAccountItem>> getAccountsByHomeFolder(Long homeFolderId,
            String externalHomeFolderId, String externalId) throws CvqException {
        return Collections.emptyMap();
    }

    @Override
    public Map<Date, String> getConsumptions(Long key, Date dateFrom, Date dateTo)
            throws CvqException {
        return Collections.emptyMap();
    }

    @Override
    public List<String> checkExternalReferential(XmlObject requestXml) {
        return new ArrayList<String>(0);
    }

    @Override
    public void creditHomeFolderAccounts(Collection<PurchaseItem> purchaseItems,
            String cvqReference, String bankReference, Long homeFolderId,
            String externalHomeFolderId, String externalId, Date validationDate)
            throws CvqException {    }

    @Override
    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
    
    @Override
    public boolean handlesTraces() {
        return true;
    }

    @Override
    public String helloWorld() throws CvqException {
        return "";
    }

    @Override
    public void loadDepositAccountDetails(ExternalDepositAccountItem edai)
        throws CvqException {    }

    @Override
    public Map<String, Object> loadExternalInformations(XmlObject requestXml)
        throws CvqException {
        return Collections.emptyMap();
    }

    @Override
    public void loadInvoiceDetails(ExternalInvoiceItem eii) throws CvqException {
        throw new UnsupportedOperationException();
    }

    @Override
    public void sendRequest(Request request) throws CvqException {
        // First of all get the payload
        RequestType requestType = requestExternalService.getRequestPayload(request, this);
        String externalId = sendRequestOrHomeFolderModification(requestType, request);

        if (request != null && request.getHomeFolderId() != null &&
                externalId != null && !externalId.equals("")) {
            HomeFolderMapping mapping = externalHomeFolderService.getHomeFolderMapping(
                    getLabel(),request.getHomeFolderId());
            mapping.setExternalId(externalId);
            externalHomeFolderService.modifyHomeFolderMapping(mapping);
        }
    }

    private String sendRequestOrHomeFolderModification(RequestType requestType, Request request) throws CvqException {
        SubjectType subjectType = requestType.getSubject();
        HomeFolder homeFolder = HomeFolder.xmlToModel(requestType.getHomeFolder());
        Adult requester = Adult.xmlToModel(requestType.getRequester());
        if (homeFolder != null && homeFolder.getExternalId() == null) {
            HomeFolderMapping hfm = externalHomeFolderService.getHomeFolderMapping(getLabel(), homeFolder.getId());
            if (hfm != null) {
                homeFolder.setExternalId(hfm.getExternalId());
            }
        }
        Individual subject = null;
        if (subjectType != null) {
            subject = subjectType.getAdult() != null ? Adult.xmlToModel(subjectType.getAdult()) : Child.xmlToModel(subjectType.getChild());
        }
        Map<String,Object> binding = new HashMap<String, Object>();
        binding.put("request", request);
        binding.put("requester",requester);
        binding.put("subject", subject);
        binding.put("homeFolder", homeFolder);
        binding.put("requestActionService", requestActionService);

        String requestTypeLabelAsDir = StringUtils.uncapitalize(requestType.getRequestTypeLabel().replace(" ", "")) + "Request";
        logger.debug(">>> " + requestTypeLabelAsDir);
        String payloadTemplate = localAuthorityRegistry.getBufferedLocalAuthorityResource(Type.XML, "send"+ File.separatorChar + requestTypeLabelAsDir + File.separatorChar + "send.tpl", false);        
        TemplateEngine engine = new GStringTemplateEngine();

        RequestExternalAction             //add trace for sending the request
            rea = new RequestExternalAction(new Date(),
                request.getId(),
                "capdemat",
                null,
                getLabel(),
                RequestExternalAction.Status.SENT
            );

        String externalId = null;
        try {
            logger.debug(">>> " + payloadTemplate + " <<<");
            Writable template = engine.createTemplate(payloadTemplate).make(binding);
            String payload = template.toString();
            logger.debug("sendRequest() routing request to external service " + getLabel());
            externalId = sendRequest(requestType, payload);
        } catch (Exception e) {
            logger.error("sendRequest() error while sending request to " + getLabel(), e);
            rea.setStatus(RequestExternalAction.Status.ERROR);
            rea.setMessage(e.getMessage());
        }

        if (!handlesTraces())
            requestExternalActionService.addTrace(rea);
        return externalId;
    }

    private String sendRequest(RequestType request, String payload) {
        RequestExternalAction est = new RequestExternalAction(new Date(),
            request.getId(), "capdemat", null, getLabel(), null);

        logger.debug("sendRequest() sending : " + payload);
        String id = null;
        try {
            String requestType = request.getRequestTypeLabel();
            logger.debug(requestType);
            ExternalServiceBean esb = SecurityContext.getCurrentConfigurationBean()
                .getExternalServiceConfigurationBean().getBeanForExternalService(getLabel());
            String url = (String) esb.getProperty(requestType + " WSUrl");
            String login = (String) esb.getProperty(requestType + " WSLogin");
            String pw = (String) esb.getProperty(requestType + " WSPassword");
            WSRequest wsReq = WS.url(url);
            if (login != null && pw != null && !login.isEmpty() && !pw.isEmpty()) {
                wsReq.setHeader("Authorization", "Basic " +
                        new String(Base64.encodeBase64((login + ":" + pw).getBytes("UTF-8")), "UTF-8"));
            }
            wsReq.setHeader("Content-Type", "text/xml");
            HttpResponse response = wsReq.body(payload).post();
            int status = response.getStatus();
            logger.debug("sendRequest() got response : " + response.getString());
            String message = null;
            if (status == 200 || status == 201) {
                est.setStatus(RequestExternalAction.Status.SENT);
                String specificResponseMethod = (String) esb.getProperty(requestType + " SpecificResponse");
                if (specificResponseMethod != null && !specificResponseMethod.isEmpty()) {
                    try {
                        Method m = RestGenericUtil.class.getDeclaredMethod(specificResponseMethod, HttpResponse.class);
                        m.setAccessible(true);
                        id = (String) m.invoke(null, response);
                    } catch (Exception responseException) {
                        logger.error("Unable to extract the specific response.", responseException);
                        id = response.getString();
                    }
                } else {
                    id = response.getString();
                }
            } else {
                message = response.getString();
                if (status == 500) {
                    est.setStatus(RequestExternalAction.Status.ERROR);
                } else if (status == 404 || status == 403 || status == 401) {
                    est.setStatus(RequestExternalAction.Status.NOT_SENT);
                    est.setMessage("Le service distant a répondu avec le code : " + status);
                } else {
                    est.setStatus(RequestExternalAction.Status.ERROR);
                }
            }
            if (message != null) {
                message = StringEscapeUtils.escapeHtml(message);
                est.setMessage(message.substring(0, Math.min(message.length(), 254)));
            }
        } catch (Exception e) {
            est.setStatus(RequestExternalAction.Status.ERROR);
            est.setMessage(e.getMessage().substring(0, Math.min(e.getMessage().length(), 254)));
        }
        requestExternalActionDAO.create(est);

        return id;
    }

    @Override
    public String sendHomeFolderModification(XmlObject requestXml) throws CvqException {
        RequestType requestType = (RequestType)requestXml;
        ExternalServiceBean esb = SecurityContext.getCurrentConfigurationBean()
                .getExternalServiceConfigurationBean().getBeanForExternalService(getLabel());
        if (esb.getProperty(requestType.getRequestTypeLabel() + " WSUrl") != null) {
            Request request = new Request();
            request.fillCommonModelInfo(request, requestType);
            return sendRequestOrHomeFolderModification(requestType, request);
        }
        return "";
    }

    @Override
    public void sendMergedHomeFolder(XmlObject xmlObject) throws CvqException {
        // TODO Auto-generated method stub
        super.sendMergedHomeFolder(xmlObject);
    }

    @Override
    public String sendRequest(XmlObject requestXml) throws CvqException {
        throw new UnsupportedOperationException("RestGenericExternal provider does not handle sendRequest with XmlObject payload");
    }

    @Override
    public boolean supportsConsumptions() {
        return false;
    }

    public void setRequestExternalActionDAO(IRequestExternalActionDAO requestExternalActionDAO) {
        this.requestExternalActionDAO = requestExternalActionDAO;
    }

    @Override
    public void visit(final WorkflowPendingEvent wfEvent) throws CvqException {
        sendRequestOnState(wfEvent);
        changeState(wfEvent);
    }

    @Override
    public void visit(final WorkflowExtInProgressEvent wfEvent) throws CvqException {
        sendRequestOnState(wfEvent);
        changeState(wfEvent);
    }

    // Default is to send on WorkflowCompleteEvent, hence this overriding.
    @Override
    public void visit(final WorkflowCompleteEvent wfEvent) throws CvqException {
        sendRequestOnState(wfEvent);
        changeState(wfEvent);
    }

    @Override
    public void visit(final WorkflowRectifiedEvent wfEvent) throws CvqException {
        sendRequestOnState(wfEvent);
        changeState(wfEvent);
    }

    public void setLocalAuthorityRegistry(ILocalAuthorityRegistry localAuthorityRegistry) {
        this.localAuthorityRegistry = localAuthorityRegistry;
    }

    @Override
    public void visit(WorkflowDraftEvent wfEvent) throws CvqException {
        sendRequestOnState(wfEvent);
        changeState(wfEvent);
    }

    @Override
    public void visit(WorkflowInProgressEvent wfEvent) throws CvqException {
        sendRequestOnState(wfEvent);
        changeState(wfEvent);
    }

    @Override
    public void visit(WorkflowUncompleteEvent wfEvent) throws CvqException {
        sendRequestOnState(wfEvent);
        changeState(wfEvent);
    }

    @Override
    public void visit(WorkflowCancelledEvent wfEvent) throws CvqException {
        sendRequestOnState(wfEvent);
        changeState(wfEvent);
    }

    @Override
    public void visit(WorkflowRejectedEvent wfEvent) throws CvqException {
        sendRequestOnState(wfEvent);
        changeState(wfEvent);
    }

    @Override
    public void visit(WorkflowValidatedEvent wfEvent) throws CvqException {
        sendRequestOnState(wfEvent);
        changeState(wfEvent);
    }

    @Override
    public void visit(WorkflowNotifiedEvent wfEvent) throws CvqException {
        sendRequestOnState(wfEvent);
        changeState(wfEvent);
    }

    @Override
    public void visit(WorkflowClosedEvent wfEvent) throws CvqException {
        sendRequestOnState(wfEvent);
        changeState(wfEvent);
    }

    @Override
    public void visit(WorkflowArchivedEvent wfEvent) throws CvqException {
        sendRequestOnState(wfEvent);
        changeState(wfEvent);
    }

    private void sendRequestOnState(WorkflowGenericEvent wfEvent) throws CvqException {
        String requestType = requestExternalService.getRequestPayload(
                wfEvent.getRequest(), this).getRequestTypeLabel();
        ExternalServiceBean esb = SecurityContext.getCurrentConfigurationBean()
                .getExternalServiceConfigurationBean().getBeanForExternalService(getLabel());
        String sendStates = (String) esb.getProperty(requestType + " WSSend");
        if (sendStates != null && !sendStates.trim().isEmpty()) {
            List<String> sendState = Arrays.asList(sendStates.split(","));
            if (sendState.contains(wfEvent.getClass().getSimpleName())) {
                checkExtReferentialAndSendRequest(wfEvent.getRequest());
            }
        }
    }

    private void changeState(final WorkflowGenericEvent wfEvent) throws CvqException {
        String requestType = requestExternalService.getRequestPayload(
                wfEvent.getRequest(), this).getRequestTypeLabel();
        ExternalServiceBean esb = SecurityContext.getCurrentConfigurationBean()
                .getExternalServiceConfigurationBean().getBeanForExternalService(getLabel());
        logger.debug(requestType +
                " ChangeState" + wfEvent.getClass().getSimpleName());
        final String nextState = (String) esb.getProperty(requestType +
                " ChangeState" + wfEvent.getClass().getSimpleName());
        if (nextState != null && !nextState.trim().isEmpty()) {
           final RequestState nState = RequestState.forString(nextState);
           if (nextState.equals(nState.getLegacyLabel())) {
               wfEvent.setWorkflowPostAction(new IWorkflowPostAction() {
                   @Override
                   public String getExecutor() {
                       return getLabel();
                   }

                   @Override
                   public void execute(IRequestWorkflowService requestWorkflowService) {
                       try {
                           requestWorkflowService.updateRequestState(wfEvent.getRequest().getId(),
                                   nState, null);
                       } catch (CvqException e) {
                           logger.error(e.getMessage());
                       }
                   }
               });
           }
        }
    }

    public void setRequestActionService(IRequestActionService requestActionService) {
        this.requestActionService = requestActionService;
    }
}
