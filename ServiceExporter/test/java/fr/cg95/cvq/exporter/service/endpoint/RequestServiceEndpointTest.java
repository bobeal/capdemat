package fr.cg95.cvq.exporter.service.endpoint;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;

import org.springframework.beans.BeansException;
import org.springframework.oxm.xmlbeans.XmlBeansMarshaller;

import fr.capwebct.capdemat.AckRequestType;
import fr.capwebct.capdemat.AckRequestsRequestDocument;
import fr.capwebct.capdemat.GetRequestsRequestDocument;
import fr.capwebct.capdemat.AckRequestsRequestDocument.AckRequestsRequest;
import fr.capwebct.capdemat.AckRequestsResponseDocument.AckRequestsResponse;
import fr.capwebct.capdemat.GetRequestsRequestDocument.GetRequestsRequest;
import fr.capwebct.capdemat.GetRequestsResponseDocument.GetRequestsResponse;
import fr.cg95.cvq.business.external.ExternalServiceTrace;
import fr.cg95.cvq.business.external.TraceStatusEnum;
import fr.cg95.cvq.business.users.CreationBean;
import fr.cg95.cvq.business.request.RequestState;
import fr.cg95.cvq.dao.hibernate.HibernateUtil;
import fr.cg95.cvq.dao.request.IRequestDAO;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.exception.CvqObjectNotFoundException;
import fr.cg95.cvq.external.ExternalServiceBean;
import fr.cg95.cvq.external.IExternalProviderService;
import fr.cg95.cvq.external.IExternalService;
import fr.cg95.cvq.security.SecurityContext;
import fr.cg95.cvq.service.authority.ILocalAuthorityRegistry;
import fr.cg95.cvq.service.authority.LocalAuthorityConfigurationBean;
import fr.cg95.cvq.service.request.IRequestTypeService;
import fr.cg95.cvq.service.request.RequestTestCase;
import fr.cg95.cvq.util.Critere;
import fr.cg95.cvq.util.DateUtils;
import fr.cg95.cvq.xml.common.RequestStateType;

public class RequestServiceEndpointTest extends RequestTestCase {
    
    private IExternalProviderService fakeExternalService;
    private String fakeExternalServiceLabel = "Fake External Service";

    @Override
    public void onSetUp() throws Exception {
        super.onSetUp();
        
        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.ADMIN_CONTEXT);

        ExternalServiceBean esb = new ExternalServiceBean();
        esb.setGenerateTracedRequest(true);
        List<String> requestTypes = new ArrayList<String>();
        requestTypes.add(IRequestTypeService.VO_CARD_REGISTRATION_REQUEST);
        esb.setRequestTypes(requestTypes);
        LocalAuthorityConfigurationBean lacb = SecurityContext.getCurrentConfigurationBean();
        fakeExternalService = getApplicationBean("fakeExternalService");
        lacb.registerExternalService(fakeExternalService, esb);
    }
    
    public void testGetAndAckFlow() throws Exception {

        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.BACK_OFFICE_CONTEXT);
        SecurityContext.setCurrentAgent(agentNameWithManageRoles);
        
        /* Initialize internal variables */
        AckRequestServiceEndpoint endpoint1 = 
            new AckRequestServiceEndpoint(new XmlBeansMarshaller());
        RequestServiceEndpoint endpoint2 = new RequestServiceEndpoint(new XmlBeansMarshaller());
        IExternalService externalService = getApplicationBean("externalService");
        ILocalAuthorityRegistry localAuthorityRegistry = getApplicationBean("localAuthorityRegistry");
        endpoint1.setExternalService(externalService);
        endpoint2.setExternalService(externalService);
        endpoint2.setRequestSearchService(requestSearchService);
        endpoint2.setLocalAuthorityRegistry(localAuthorityRegistry);
        endpoint2.setRequestDAO((IRequestDAO)getApplicationBean("requestDAO"));
        
        try {
            for (ExternalServiceTrace trace :
                externalService.getTraces(Collections.<Critere>emptySet(),
                    null, null, 0, 0)) {
                HibernateUtil.getSession().delete(trace);
            }
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(new Date());
            
            CreationBean cb = this.gimmeAnHomeFolderWithRequest();
            this.continueWithNewTransaction();
            
            SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.BACK_OFFICE_CONTEXT);
            SecurityContext.setCurrentExternalService(fakeExternalServiceLabel);

            GetRequestsRequest getRequest = GetRequestsRequest.Factory.newInstance();
            AckRequestsRequest ackRequest = AckRequestsRequest.Factory.newInstance();
            GetRequestsRequestDocument requestDocument = 
                GetRequestsRequestDocument.Factory.newInstance();
            
            getRequest.setDateFrom(calendar);
            getRequest.setState(RequestStateType.Enum.forString(RequestState.PENDING.toString()));
            requestDocument.setGetRequestsRequest(getRequest);
            
            // test we get our VO card request
            GetRequestsResponse getResponse = 
                (GetRequestsResponse) endpoint2.invokeInternal(requestDocument);
            int getCountBefore = getResponse.getRequestArray().length;
            assertEquals(1, getCountBefore);
            
            SecurityContext.setCurrentAgent(agentNameWithManageRoles);

            Set<Critere> criteriaSet = new HashSet<Critere>();
            criteriaSet.add(new Critere(ExternalServiceTrace.SEARCH_BY_DATE,
                DateUtils.parseDate("13/07/2007"), Critere.GT));
            assertEquals(1, externalService.getTracesCount(criteriaSet).longValue());
            
            /* Create acknowledgement response */
            AckRequestType[] types = new AckRequestType[1];
            AckRequestType type = AckRequestType.Factory.newInstance();
            type.setRequestId(cb.getRequestId());
            type.setErroneous(false);
            types[0] = type;
            
            SecurityContext.setCurrentExternalService(fakeExternalServiceLabel);

            ackRequest.setAckElementsArray(types);
            AckRequestsRequestDocument ackRequestDocument = 
                AckRequestsRequestDocument.Factory.newInstance();
            ackRequestDocument.setAckRequestsRequest(ackRequest);
            AckRequestsResponse ackResponse = 
                (AckRequestsResponse) endpoint1.invokeInternal(ackRequestDocument);
            assertNotNull(ackResponse);
            assertTrue(ackResponse.getAccomplished());
            
            SecurityContext.setCurrentAgent(agentNameWithManageRoles);

            assertEquals(2, externalService.getTracesCount(criteriaSet).longValue());
            
            SecurityContext.setCurrentExternalService(fakeExternalServiceLabel);

            getResponse = (GetRequestsResponse) endpoint2.invokeInternal(requestDocument);
            assertEquals(0, getResponse.getRequestArray().length);
            
        } catch (Exception e) {
            e.printStackTrace();
            fail("Unwaited exception trown : " + e.getMessage());
        } finally {
            SecurityContext.setCurrentAgent(agentNameWithManageRoles);
            for (ExternalServiceTrace trace :
                externalService.getTraces(Collections.<Critere>emptySet(),
                    null, null, 0, 0)) {
                HibernateUtil.getSession().delete(trace);
            }
        }
    }
    
    public void testAckServiceEndpoint() throws Exception {
        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.BACK_OFFICE_CONTEXT);
        SecurityContext.setCurrentAgent(agentNameWithManageRoles);
        
        /* Initialize internal variables */
        AckRequestServiceEndpoint endpoint1 = 
            new AckRequestServiceEndpoint(new XmlBeansMarshaller());
        RequestServiceEndpoint endpoint2 = new RequestServiceEndpoint(new XmlBeansMarshaller());
        IExternalService externalService = getApplicationBean("externalService");
        ILocalAuthorityRegistry localAuthorityRegistry = getApplicationBean("localAuthorityRegistry");
        endpoint1.setExternalService(externalService);
        endpoint2.setExternalService(externalService);
        endpoint2.setRequestSearchService(requestSearchService);
        endpoint2.setLocalAuthorityRegistry(localAuthorityRegistry);
        endpoint2.setRequestDAO((IRequestDAO)getApplicationBean("requestDAO"));
        
        try {
            for (ExternalServiceTrace trace :
                externalService.getTraces(Collections.<Critere>emptySet(),
                    null, null, 0, 0)) {
                HibernateUtil.getSession().delete(trace);
            }
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(new Date());
            
            this.gimmeAnHomeFolderWithRequest();
            this.continueWithNewTransaction();
            
            GetRequestsRequest getRequest = GetRequestsRequest.Factory.newInstance();
            AckRequestsRequest ackRequest = AckRequestsRequest.Factory.newInstance();
            GetRequestsRequestDocument requestDocument = 
                GetRequestsRequestDocument.Factory.newInstance();
            
            getRequest.setDateFrom(calendar);
            getRequest.setState(RequestStateType.Enum.forString(RequestState.PENDING.toString()));
            requestDocument.setGetRequestsRequest(getRequest);
            
            SecurityContext.setCurrentExternalService(fakeExternalServiceLabel);
            
            /* Create sent traces */
            GetRequestsResponse getResponse = 
                (GetRequestsResponse) endpoint2.invokeInternal(requestDocument);
            int getCountBefore = getResponse.getRequestArray().length;
            
            assertEquals(1, getCountBefore);
            
            getRequest.setRequestTypeLabel(IRequestTypeService.VO_CARD_REGISTRATION_REQUEST);
            requestDocument.setGetRequestsRequest(getRequest);

            getResponse = (GetRequestsResponse) endpoint2.invokeInternal(requestDocument);
            getCountBefore = getResponse.getRequestArray().length;
            
            assertEquals(1, getCountBefore);
            
            SecurityContext.setCurrentAgent(agentNameWithManageRoles);
            
            Set<Critere> criteriaSet = new HashSet<Critere>();
            criteriaSet.add(new Critere(ExternalServiceTrace.SEARCH_BY_DATE,
                DateUtils.parseDate("13/07/2007"), Critere.GT));
            long tracesCount = externalService.getTracesCount(criteriaSet);
            assertNotSame(0, tracesCount);
            
            /* Create acknowledged traces */
            AckRequestType[] types = new AckRequestType[3];
            AckRequestType type = AckRequestType.Factory.newInstance();
            type.setRequestId(2345L);
            type.setErroneous(false);
            types[0] = type;
            
            type = AckRequestType.Factory.newInstance();
            type.setRequestId(2346L);
            type.setErroneous(false);
            types[1] = type;
            
            type = AckRequestType.Factory.newInstance();
            type.setRequestId(2347L);
            type.setErroneous(true);
            types[2] = type;
            
            SecurityContext.setCurrentExternalService(fakeExternalServiceLabel);
            
            ackRequest.setAckElementsArray(types);
            AckRequestsRequestDocument ackRequestDocument = AckRequestsRequestDocument.Factory.newInstance();
            ackRequestDocument.setAckRequestsRequest(ackRequest);
            AckRequestsResponse ackResponse = (AckRequestsResponse) endpoint1.invokeInternal(ackRequestDocument);
            assertNotNull(ackResponse);

            SecurityContext.setCurrentAgent(agentNameWithManageRoles);
            
            assertEquals(externalService.getTracesCount(criteriaSet).longValue(), tracesCount+3);
            
            criteriaSet = new HashSet<Critere>();
            criteriaSet.add(new Critere(ExternalServiceTrace.SEARCH_BY_STATUS,
                TraceStatusEnum.ERROR, Critere.EQUALS));
            ExternalServiceTrace trace = externalService.getTraces(criteriaSet, null, null, 1, 0).get(0);
            
            assertEquals(trace.getKey(), "2347");
            assertEquals(trace.getKeyOwner(),"capdemat");
            assertEquals(trace.getStatus(), TraceStatusEnum.ERROR);
            
            
        } catch (Exception e) {
            e.printStackTrace();
            fail("Unwaited exception trown : " + e.getMessage());
        } finally {
            for (ExternalServiceTrace trace :
                externalService.getTraces(Collections.<Critere>emptySet(),
                    null, null, 0, 0)) {
                HibernateUtil.getSession().delete(trace);
            }
        }
        
    }
    
    public void testSecuredEndpoint() throws Exception {
        try {
            SecurityContext.resetCurrentSite();
            SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.BACK_OFFICE_CONTEXT);
            SecurityContext.setCurrentAgent(agentNameWithCategoriesRoles);
            IExternalService externalService = getApplicationBean("externalService");
            ILocalAuthorityRegistry localAuthorityRegistry = getApplicationBean("localAuthorityRegistry");
            
            SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.ADMIN_CONTEXT);
            
            XmlBeansMarshaller xmlBeansMarshaller = new XmlBeansMarshaller();
            RequestServiceEndpoint endpoint = new RequestServiceEndpoint(xmlBeansMarshaller);
            endpoint.setRequestSearchService(requestSearchService);
            endpoint.setExternalService(externalService);
            endpoint.setLocalAuthorityRegistry(localAuthorityRegistry);
            GetRequestsRequestDocument pendedRequestDocument = 
                GetRequestsRequestDocument.Factory.newInstance();
            GetRequestsRequest pendedRequest = GetRequestsRequest.Factory.newInstance();
            
            SecurityContext.setCurrentExternalService(fakeExternalServiceLabel);
            
            pendedRequestDocument.setGetRequestsRequest(pendedRequest);
            endpoint.invokeInternal(pendedRequestDocument);
            fail();
            
        } catch (CvqObjectNotFoundException e) {
            fail("Unwaited exception raised");
        } catch (CvqException e) {
            // Do nothing because raised exception is a part of normal behavior in current situation
        } catch (BeansException e) {
            fail("Unwaited exception raised");
        } 
        
    }
    
    public void testAccessPermissions() {
        try {
            SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.BACK_OFFICE_CONTEXT);
            SecurityContext.setCurrentExternalService(fakeExternalServiceLabel);
            IExternalService externalService = getApplicationBean("externalService");
            ILocalAuthorityRegistry localAuthorityRegistry = getApplicationBean("localAuthorityRegistry");
            
            XmlBeansMarshaller xmlBeansMarshaller = new XmlBeansMarshaller();
            RequestServiceEndpoint endpoint = new RequestServiceEndpoint(xmlBeansMarshaller);
            endpoint.setRequestSearchService(requestSearchService);
            endpoint.setExternalService(externalService);
            endpoint.setLocalAuthorityRegistry(localAuthorityRegistry);
            
            GetRequestsRequestDocument pendedRequestDocument = 
                GetRequestsRequestDocument.Factory.newInstance();
            GetRequestsRequest pendedRequest = GetRequestsRequest.Factory.newInstance();
            pendedRequest.setRequestTypeLabel("Dude Registration");
            
            pendedRequestDocument.setGetRequestsRequest(pendedRequest);
            GetRequestsResponse getResponse = 
                (GetRequestsResponse) endpoint.invokeInternal(pendedRequestDocument);
            assertNotSame(getResponse.getError().length(), 0);
            
        } catch (Exception e) {
            e.printStackTrace();
            fail("Unwaited exception raised");
        }
    }
    
    public void testRequestServiceEndpoint() throws Exception {
        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.BACK_OFFICE_CONTEXT);
        SecurityContext.setCurrentExternalService(fakeExternalServiceLabel);
        
        IExternalService externalService = getApplicationBean("externalService");
        
        try {
            int completeCountBefore = 0;
            ILocalAuthorityRegistry localAuthorityRegistry = getApplicationBean("localAuthorityRegistry");
            
            XmlBeansMarshaller xmlBeansMarshaller = new XmlBeansMarshaller();
            
            /* Initialize internal variables */
            RequestServiceEndpoint endpoint = new RequestServiceEndpoint(xmlBeansMarshaller);
            AckRequestServiceEndpoint endpoint2 = new AckRequestServiceEndpoint(new XmlBeansMarshaller());
            endpoint.setRequestSearchService(requestSearchService);
            endpoint.setExternalService(externalService);
            endpoint.setLocalAuthorityRegistry(localAuthorityRegistry);
            endpoint.setRequestDAO((IRequestDAO)getApplicationBean("requestDAO"));
            
            endpoint2.setExternalService(externalService);
            GetRequestsRequestDocument pendedRequestDocument = GetRequestsRequestDocument.Factory.newInstance();
            GetRequestsRequest pendedRequest = GetRequestsRequest.Factory.newInstance();
            
            /*
             * Retrieve requests that has pending status and has fromDate
             * equals to current date
             */
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(new Date());
            pendedRequest.setDateFrom(calendar);
            pendedRequest.setState(RequestStateType.Enum.forString(RequestState.PENDING.toString()));
            
            pendedRequestDocument.setGetRequestsRequest(pendedRequest);
            GetRequestsResponse pendedResponse = (GetRequestsResponse) endpoint.invokeInternal(pendedRequestDocument);
            int pendedCountBefore = pendedResponse.getRequestArray().length;
            
            /* Retrieving requests with an another state */
            GetRequestsRequestDocument completeRequestDocument = GetRequestsRequestDocument.Factory.newInstance();
            GetRequestsRequest completeRequest = GetRequestsRequest.Factory.newInstance();
            completeRequest.setDateFrom(pendedRequest.getDateFrom());
            completeRequest.setState(RequestStateType.Enum.forString(RequestState.COMPLETE.toString()));
            
            completeRequestDocument.setGetRequestsRequest(completeRequest);
            GetRequestsResponse completeResponse = (GetRequestsResponse) endpoint.invokeInternal(completeRequestDocument);
            completeCountBefore = completeResponse.getRequestArray().length;
            
            /* Create new request and child entities */
            CreationBean cb = this.gimmeAnHomeFolderWithRequest();
            this.gimmeAnHomeFolderWithRequest();
            this.continueWithNewTransaction();
            
            SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.BACK_OFFICE_CONTEXT);
            SecurityContext.setCurrentExternalService(fakeExternalServiceLabel);

            pendedResponse = (GetRequestsResponse) endpoint.invokeInternal(pendedRequestDocument);
            completeResponse = (GetRequestsResponse) endpoint.invokeInternal(completeRequestDocument);
            int pendedCountAfter = pendedResponse.getRequestArray().length;
            int completeCountAfter = completeResponse.getRequestArray().length;
            
            assertEquals("Pended request counts don't match", 
                    pendedCountBefore + 2, pendedCountAfter);
            assertEquals("Complete request counts don't match",
                    completeCountBefore, completeCountAfter);
            
            /*
             * Retrieve a request by its id
             */
            GetRequestsRequest getRequestById = GetRequestsRequest.Factory.newInstance();
            getRequestById.setId(cb.getRequestId());
            pendedRequestDocument.setGetRequestsRequest(getRequestById);
            GetRequestsResponse getRequestByIdResponse = 
                (GetRequestsResponse) endpoint.invokeInternal(pendedRequestDocument);
            assertEquals(1, getRequestByIdResponse.getRequestArray().length);
            
            /*
             * Ack it and check we still get it when asked by id 
             */
            AckRequestsRequest ackRequest = AckRequestsRequest.Factory.newInstance();
            AckRequestType[] types = new AckRequestType[1];
            AckRequestType type = AckRequestType.Factory.newInstance();
            type.setRequestId(cb.getRequestId());
            type.setErroneous(false);
            types[0] = type;
            ackRequest.setAckElementsArray(types);

            AckRequestsRequestDocument ackRequestDocument = 
                AckRequestsRequestDocument.Factory.newInstance();
            ackRequestDocument.setAckRequestsRequest(ackRequest);
            AckRequestsResponse ackResponse = 
                (AckRequestsResponse) endpoint2.invokeInternal(ackRequestDocument);
            assertNotNull(ackResponse);

            getRequestByIdResponse = 
                (GetRequestsResponse) endpoint.invokeInternal(pendedRequestDocument);
            assertEquals(1, getRequestByIdResponse.getRequestArray().length);
            
        } catch (Exception e) {
            e.printStackTrace();
            fail("Unwaited exception trown : " + e.getMessage());
        } finally {
            SecurityContext.setCurrentContext(SecurityContext.BACK_OFFICE_CONTEXT);
            SecurityContext.setCurrentAgent(agentNameWithManageRoles);
            for (ExternalServiceTrace trace :
                externalService.getTraces(Collections.<Critere>emptySet(),
                    null, null, 0, 0)) {
                HibernateUtil.getSession().delete(trace);
            }
        }
    }
}
