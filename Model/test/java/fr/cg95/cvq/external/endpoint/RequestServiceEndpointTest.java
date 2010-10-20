package fr.cg95.cvq.external.endpoint;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.xmlbeans.XmlBeansMarshaller;

import fr.capwebct.capdemat.AckRequestType;
import fr.capwebct.capdemat.AckRequestsRequestDocument;
import fr.capwebct.capdemat.GetRequestsRequestDocument;
import fr.capwebct.capdemat.HomeFolderMappingRequestDocument;
import fr.capwebct.capdemat.HomeFolderMappingType;
import fr.capwebct.capdemat.IndividualMappingType;
import fr.capwebct.capdemat.AckRequestsRequestDocument.AckRequestsRequest;
import fr.capwebct.capdemat.AckRequestsResponseDocument.AckRequestsResponse;
import fr.capwebct.capdemat.GetRequestsRequestDocument.GetRequestsRequest;
import fr.capwebct.capdemat.GetRequestsResponseDocument.GetRequestsResponse;
import fr.capwebct.capdemat.HomeFolderMappingRequestDocument.HomeFolderMappingRequest;
import fr.cg95.cvq.business.users.CreationBean;
import fr.cg95.cvq.business.users.Individual;
import fr.cg95.cvq.business.users.external.HomeFolderMapping;
import fr.cg95.cvq.business.users.external.IndividualMapping;
import fr.cg95.cvq.business.request.RequestState;
import fr.cg95.cvq.business.request.external.RequestExternalAction;
import fr.cg95.cvq.business.request.external.RequestExternalActionState;
import fr.cg95.cvq.dao.hibernate.HibernateUtil;
import fr.cg95.cvq.dao.request.IRequestDAO;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.exception.CvqObjectNotFoundException;
import fr.cg95.cvq.external.ExternalServiceBean;
import fr.cg95.cvq.external.ExternalServiceTestCase;
import fr.cg95.cvq.external.endpoint.AckRequestServiceEndpoint;
import fr.cg95.cvq.external.endpoint.HomeFolderMappingServiceEndpoint;
import fr.cg95.cvq.external.endpoint.RequestServiceEndpoint;
import fr.cg95.cvq.security.SecurityContext;
import fr.cg95.cvq.service.authority.LocalAuthorityConfigurationBean;
import fr.cg95.cvq.service.request.IRequestExportService;
import fr.cg95.cvq.service.request.IRequestTypeService;
import fr.cg95.cvq.service.request.external.IRequestExternalService;
import fr.cg95.cvq.util.Critere;
import fr.cg95.cvq.util.DateUtils;
import fr.cg95.cvq.xml.common.RequestStateType;

public class RequestServiceEndpointTest extends ExternalServiceTestCase {
    
    private String fakeExternalServiceLabel = "Fake External Service";
    @Autowired
    private IRequestExternalService requestExternalService;
    @Autowired
    private IRequestExportService requestExportService;

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
    
    @Test
    public void testGetAndAckFlow() throws Exception {

        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.BACK_OFFICE_CONTEXT);
        SecurityContext.setCurrentAgent(agentNameWithManageRoles);
        
        /* Initialize internal variables */
        AckRequestServiceEndpoint endpoint1 = gimmeAckRequestServiceEndpoint();
        RequestServiceEndpoint endpoint2 = gimmeRequestServiceEndpoint();

        try {
            for (RequestExternalAction trace :
                requestExternalActionService.getTraces(Collections.<Critere>emptySet(),
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
            
            continueWithNewTransaction();
            SecurityContext.setCurrentAgent(agentNameWithManageRoles);

            Set<Critere> criteriaSet = new HashSet<Critere>();
            criteriaSet.add(new Critere(RequestExternalAction.SEARCH_BY_DATE,
                DateUtils.parseDate("13/07/2007"), Critere.GT));
            assertEquals(1, requestExternalActionService.getTracesCount(criteriaSet).longValue());
            
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
            
            continueWithNewTransaction();
            SecurityContext.setCurrentAgent(agentNameWithManageRoles);

            assertEquals(2, requestExternalActionService.getTracesCount(criteriaSet).longValue());
            
            SecurityContext.setCurrentExternalService(fakeExternalServiceLabel);

            getResponse = (GetRequestsResponse) endpoint2.invokeInternal(requestDocument);
            assertEquals(0, getResponse.getRequestArray().length);
            
        } catch (Exception e) {
            e.printStackTrace();
            fail("Unwaited exception trown : " + e.getMessage());
        } finally {
            SecurityContext.setCurrentAgent(agentNameWithManageRoles);
            for (RequestExternalAction trace :
                requestExternalActionService.getTraces(Collections.<Critere>emptySet(),
                    null, null, 0, 0)) {
                HibernateUtil.getSession().delete(trace);
            }
        }
    }
    
    @Test
    public void testAckServiceEndpoint() throws Exception {
        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.BACK_OFFICE_CONTEXT);
        SecurityContext.setCurrentAgent(agentNameWithManageRoles);
        
        /* Initialize internal variables */
        AckRequestServiceEndpoint endpoint1 = gimmeAckRequestServiceEndpoint();
        RequestServiceEndpoint endpoint2 = gimmeRequestServiceEndpoint();

        try {
            for (RequestExternalAction trace :
                requestExternalActionService.getTraces(Collections.<Critere>emptySet(),
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
            
            continueWithNewTransaction();
            SecurityContext.setCurrentAgent(agentNameWithManageRoles);
            
            Set<Critere> criteriaSet = new HashSet<Critere>();
            criteriaSet.add(new Critere(RequestExternalAction.SEARCH_BY_DATE,
                DateUtils.parseDate("13/07/2007"), Critere.GT));
            long tracesCount = requestExternalActionService.getTracesCount(criteriaSet);
            assertTrue("Should have found at least one trace", tracesCount > 0);
            
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

            continueWithNewTransaction();
            SecurityContext.setCurrentAgent(agentNameWithManageRoles);
            
            assertEquals(tracesCount+3, requestExternalActionService.getTracesCount(criteriaSet).longValue());
            
            criteriaSet = new HashSet<Critere>();
            criteriaSet.add(new Critere(RequestExternalAction.SEARCH_BY_STATUS,
                RequestExternalActionState.ERROR, Critere.EQUALS));
            RequestExternalAction trace = requestExternalActionService.getTraces(criteriaSet, null, null, 1, 0).get(0);
            
            assertEquals(trace.getKey(), "2347");
            assertEquals(trace.getKeyOwner(),"capdemat");
            assertEquals(trace.getStatus(), RequestExternalActionState.ERROR);
            
            
        } catch (Exception e) {
            e.printStackTrace();
            fail("Unwaited exception trown : " + e.getMessage());
        } finally {
            for (RequestExternalAction trace :
                requestExternalActionService.getTraces(Collections.<Critere>emptySet(),
                    null, null, 0, 0)) {
                HibernateUtil.getSession().delete(trace);
            }
        }
        
    }
    
    @Test
    public void testSecuredEndpoint() throws Exception {
        try {

            SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.ADMIN_CONTEXT);
            
            RequestServiceEndpoint endpoint = gimmeRequestServiceEndpoint();

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
    
    @Test
    public void testAccessPermissions() {
        try {
            SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.BACK_OFFICE_CONTEXT);
            SecurityContext.setCurrentExternalService(fakeExternalServiceLabel);

            RequestServiceEndpoint endpoint = gimmeRequestServiceEndpoint();

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
    
    @Test
    public void testRequestServiceEndpoint() throws Exception {
        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.BACK_OFFICE_CONTEXT);
        SecurityContext.setCurrentExternalService(fakeExternalServiceLabel);
        
        try {
            int completeCountBefore = 0;

            /* Initialize internal variables */
            RequestServiceEndpoint endpoint = gimmeRequestServiceEndpoint();
            AckRequestServiceEndpoint endpoint2 = gimmeAckRequestServiceEndpoint();

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
            for (RequestExternalAction trace :
                requestExternalActionService.getTraces(Collections.<Critere>emptySet(),
                    null, null, 0, 0)) {
                HibernateUtil.getSession().delete(trace);
            }
        }
    }
    
    @Test
    public void testHomeFolderMapping() throws CvqException {
        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.BACK_OFFICE_CONTEXT);
        
        try {

            /* Initialize internal variables */
            XmlBeansMarshaller xmlBeansMarshaller = new XmlBeansMarshaller();
            HomeFolderMappingServiceEndpoint endpoint = new HomeFolderMappingServiceEndpoint(xmlBeansMarshaller);
            endpoint.setExternalHomeFolderService(externalHomeFolderService);

            /* Create new request and child entities */
            CreationBean cb = gimmeAnHomeFolder();
            continueWithNewTransaction();

            HomeFolderMappingRequestDocument homeFolderMappingRequestDocument =
                HomeFolderMappingRequestDocument.Factory.newInstance();
            HomeFolderMappingRequest homeFolderMappingRequest =
                homeFolderMappingRequestDocument.addNewHomeFolderMappingRequest();
            homeFolderMappingRequest.setLocalAuthority(localAuthorityName);

            SecurityContext.setCurrentAgent(agentNameWithManageRoles);
            
            externalHomeFolderService.addHomeFolderMapping(fakeExternalServiceLabel, cb.getHomeFolderId(), "OriginalHomeFolderId");
            continueWithNewTransaction();
            Individual individual = individualService.getByLogin(cb.getLogin());
            externalHomeFolderService.setExternalId(fakeExternalServiceLabel, cb.getHomeFolderId(), individual.getId(), "OriginalIndividualId");
            continueWithNewTransaction();
            
            HomeFolderMapping homeFolderMapping =
                externalHomeFolderService.getHomeFolderMapping(fakeExternalServiceLabel, cb.getHomeFolderId());
            HomeFolderMappingType homeFolderMappingType = homeFolderMappingRequest.addNewHomeFolderMapping();
            homeFolderMappingType.setExternalCapDematId(homeFolderMapping.getExternalCapDematId());
            homeFolderMappingType.setExternalId("ExternalHomeFolderId");
            
            IndividualMappingType individualMappingType = homeFolderMappingRequest.addNewIndividualMapping();
            String externalCapdematId = null;
            for (IndividualMapping indMapping : homeFolderMapping.getIndividualsMappings()) {
                if (indMapping.getExternalId().equals("OriginalIndividualId")) {
                    externalCapdematId = indMapping.getExternalCapDematId();
                    individualMappingType.setExternalCapDematId(indMapping.getExternalCapDematId());
                    individualMappingType.setExternalId("ExternalIndividualId");
                    break;
                }
            }

            SecurityContext.setCurrentExternalService(fakeExternalServiceLabel);
            endpoint.invokeInternal(homeFolderMappingRequestDocument);
            
            continueWithNewTransaction();
            homeFolderMapping = externalHomeFolderService.getHomeFolderMapping(fakeExternalServiceLabel, cb.getHomeFolderId());
            assertEquals("ExternalHomeFolderId", homeFolderMapping.getExternalId());
            for (IndividualMapping indMapping : homeFolderMapping.getIndividualsMappings()) {
                if (indMapping.getExternalCapDematId().equals(externalCapdematId)) {
                    assertEquals("ExternalIndividualId", indMapping.getExternalId());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            fail("Unwaited exception trown : " + e.getMessage());
        } finally {
            SecurityContext.setCurrentContext(SecurityContext.BACK_OFFICE_CONTEXT);
            SecurityContext.setCurrentAgent(agentNameWithManageRoles);
            for (RequestExternalAction trace :
                requestExternalActionService.getTraces(Collections.<Critere>emptySet(),
                    null, null, 0, 0)) {
                HibernateUtil.getSession().delete(trace);
            }
        }
    }
    
    private RequestServiceEndpoint gimmeRequestServiceEndpoint() {
        RequestServiceEndpoint endpoint = new RequestServiceEndpoint(new XmlBeansMarshaller());
        endpoint.setRequestSearchService(requestSearchService);
        endpoint.setRequestExternalActionService(requestExternalActionService);
        endpoint.setLocalAuthorityRegistry(localAuthorityRegistry);
        endpoint.setRequestDAO((IRequestDAO)getApplicationBean("requestDAO"));
        endpoint.setRequestExternalService(requestExternalService);
        endpoint.setRequestExportService(requestExportService);
        
        return endpoint;
    }

    private AckRequestServiceEndpoint gimmeAckRequestServiceEndpoint() {
        AckRequestServiceEndpoint endpoint = new AckRequestServiceEndpoint(new XmlBeansMarshaller());
        endpoint.setRequestExternalActionService(requestExternalActionService);
        
        return endpoint;
    }
}
