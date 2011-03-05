package fr.cg95.cvq.external;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import fr.cg95.cvq.business.request.external.RequestExternalAction;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.security.SecurityContext;
import fr.cg95.cvq.service.authority.LocalAuthorityConfigurationBean;
import fr.cg95.cvq.util.Critere;
import fr.cg95.cvq.util.DateUtils;

public class RequestExternalActionTest extends ExternalServiceTestCase {

    protected Long newId = -1L;

    @Before
    public void before() throws Exception {
        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.EXTERNAL_SERVICE_CONTEXT);

        ExternalServiceBean esb = new ExternalServiceBean();
        List<String> requestTypes = new ArrayList<String>();
        requestTypes.add(requestTypeService.getRequestTypeByLabel(tirLabel).getLabel());
        esb.setRequestTypes(requestTypes);
        LocalAuthorityConfigurationBean lacb = SecurityContext.getCurrentConfigurationBean();
        fakeExternalService = getApplicationBean("fakeExternalService");
        lacb.registerExternalService(fakeExternalService, esb);
    }

    @Test
    public void testBaseFunctionality() throws Exception {

        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.BACK_OFFICE_CONTEXT);
        SecurityContext.setCurrentAgent(agentNameWithCategoriesRoles);

        /* Tests entity creation */
        RequestExternalAction trace = new RequestExternalAction();

        trace.setKey(request.getId().toString());
        trace.setKeyOwner("MyOwner");
        trace.setMessage("No message");
        trace.setName("MyName");
        trace.setStatus(RequestExternalAction.Status.SENT);

        newId = requestExternalActionService.addTrace(trace);

        continueWithNewTransaction();

        Set<Critere> criteriaSet = new HashSet<Critere>();
        criteriaSet.add(new Critere(RequestExternalAction.SEARCH_BY_KEY,
            request.getId().toString(), Critere.EQUALS));
        List<RequestExternalAction> traces =
            requestExternalActionService.getTraces(criteriaSet, null, null, 0, 0);

        assertNotNull(traces);
        assertEquals(1, traces.size());

        /* Test returned entity */
        RequestExternalAction traceFromDb = traces.iterator().next();
        assertNotNull(traceFromDb);
        assertEquals(traceFromDb.getId(), newId);
        assertEquals(traceFromDb.getKey(), trace.getKey());
        assertEquals(traceFromDb.getKeyOwner(), trace.getKeyOwner());
        assertEquals(traceFromDb.getMessage(), trace.getMessage());
        assertNotNull(traceFromDb.getDate());
        assertEquals(traceFromDb.getStatus(), trace.getStatus());

        criteriaSet.add(new Critere(RequestExternalAction.SEARCH_BY_NAME,
            "MyName", Critere.EQUALS));
        criteriaSet.add(new Critere(RequestExternalAction.SEARCH_BY_STATUS,
                RequestExternalAction.Status.SENT, Critere.EQUALS));
        criteriaSet.add(new Critere(RequestExternalAction.SEARCH_BY_DATE,
                DateUtils.parseDate("13/09/2007"), Critere.GT));
        criteriaSet.add(new Critere(RequestExternalAction.SEARCH_BY_DATE,
                new Date(), Critere.LTE));
        assertEquals(1, requestExternalActionService.getTracesCount(criteriaSet).longValue());

        criteriaSet = new HashSet<Critere>();
        criteriaSet.add(new Critere(RequestExternalAction.SEARCH_BY_KEY,
            request.getId().toString(), Critere.EQUALS));
        criteriaSet.add(new Critere(RequestExternalAction.SEARCH_BY_DATE,
                DateUtils.parseDate("13/09/2007"), Critere.GT));
        criteriaSet.add(new Critere(RequestExternalAction.SEARCH_BY_DATE,
                DateUtils.parseDate("17/06/2008"), Critere.LTE));
        assertEquals(0, requestExternalActionService.getTracesCount(criteriaSet).longValue());

        criteriaSet = new HashSet<Critere>();
        criteriaSet.add(new Critere(RequestExternalAction.SEARCH_BY_KEY,
                request.getId().toString(), Critere.EQUALS));
        criteriaSet.add(new Critere(RequestExternalAction.SEARCH_BY_DATE,
                DateUtils.parseDate("13/09/2007"), Critere.GT));
        criteriaSet.add(new Critere(RequestExternalAction.SEARCH_BY_DATE,
                new Date(), Critere.LTE));
        assertEquals(1, requestExternalActionService.getTracesCount(criteriaSet).longValue());
    }

    @Test
    public void testAddTrace() throws CvqException{

        SecurityContext.setCurrentContext(SecurityContext.EXTERNAL_SERVICE_CONTEXT);
        SecurityContext.setCurrentExternalService(fakeExternalService.getLabel());

        RequestExternalAction rea = new RequestExternalAction();
        rea.setKey(request.getId().toString());
        rea.setKeyOwner("capdemat");

        requestExternalActionService.addTrace(rea);
        continueWithNewTransaction();

        HashSet<Critere> criteriaSet = new HashSet<Critere>();
        criteriaSet.add(new Critere(RequestExternalAction.SEARCH_BY_KEY,
            request.getId().toString(), Critere.EQUALS));

        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.BACK_OFFICE_CONTEXT);
        SecurityContext.setCurrentAgent(agentNameWithCategoriesRoles);

        assertEquals(1, requestExternalActionService.getTracesCount(criteriaSet).longValue());
    }
}
