package fr.cg95.cvq.external;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import fr.cg95.cvq.business.external.ExternalServiceTrace;
import fr.cg95.cvq.business.external.TraceStatusEnum;
import fr.cg95.cvq.security.SecurityContext;
import fr.cg95.cvq.util.Critere;
import fr.cg95.cvq.util.DateUtils;

public class ExternalServiceTracesTest extends ExternalServiceTestCase {
    
    protected Long newId = -1L;
    
    public void testBaseFunctionality() throws Exception {

        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.BACK_OFFICE_CONTEXT);
        SecurityContext.setCurrentAgent(agentNameWithCategoriesRoles);

        /* Tests entity creation */
        ExternalServiceTrace trace = new ExternalServiceTrace();

        trace.setKey("2345");
        trace.setKeyOwner("MyOwner");
        trace.setMessage("No message");
        trace.setName("MyName");
        trace.setStatus(TraceStatusEnum.SENT);

        newId = externalService.addTrace(trace);

        continueWithNewTransaction();

        Set<Critere> criteriaSet = new HashSet<Critere>();
        criteriaSet.add(new Critere(ExternalServiceTrace.SEARCH_BY_KEY,
            "2345", Critere.EQUALS));
        List<ExternalServiceTrace> traces =
            externalService.getTraces(criteriaSet, null, null);

        assertNotNull(traces);
        assertEquals(1, traces.size());

        /* Test returned entity */
        ExternalServiceTrace traceFromDb = traces.iterator().next();
        assertNotNull(traceFromDb);
        assertEquals(traceFromDb.getId(), newId);
        assertEquals(traceFromDb.getKey(), trace.getKey());
        assertEquals(traceFromDb.getKeyOwner(), trace.getKeyOwner());
        assertEquals(traceFromDb.getMessage(), trace.getMessage());
        assertNotNull(traceFromDb.getDate());
        assertEquals(traceFromDb.getStatus(), trace.getStatus());     

        criteriaSet.add(new Critere(ExternalServiceTrace.SEARCH_BY_NAME,
            "MyName", Critere.EQUALS));
        criteriaSet.add(new Critere(ExternalServiceTrace.SEARCH_BY_STATUS,
                TraceStatusEnum.SENT, Critere.EQUALS));
        criteriaSet.add(new Critere(ExternalServiceTrace.SEARCH_BY_DATE,
                DateUtils.parseDate("13/09/2007"), Critere.GT));
        criteriaSet.add(new Critere(ExternalServiceTrace.SEARCH_BY_DATE,
                new Date(), Critere.LTE));
        traces = externalService.getTraces(criteriaSet, null, null);
        assertEquals(1, traces.size());

        criteriaSet = new HashSet<Critere>();
        criteriaSet.add(new Critere(ExternalServiceTrace.SEARCH_BY_KEY,
            "2345", Critere.EQUALS));
        criteriaSet.add(new Critere(ExternalServiceTrace.SEARCH_BY_DATE,
                DateUtils.parseDate("13/09/2007"), Critere.GT));
        criteriaSet.add(new Critere(ExternalServiceTrace.SEARCH_BY_DATE,
                DateUtils.parseDate("17/06/2008"), Critere.LTE));
        traces = externalService.getTraces(criteriaSet, null, null);
        assertEquals(0, traces.size());

        criteriaSet = new HashSet<Critere>();
        criteriaSet.add(new Critere(ExternalServiceTrace.SEARCH_BY_DATE,
                DateUtils.parseDate("13/09/2007"), Critere.GT));
        criteriaSet.add(new Critere(ExternalServiceTrace.SEARCH_BY_DATE,
                new Date(), Critere.LTE));
        traces = externalService.getTraces(criteriaSet, null, null);
        assertEquals(1, traces.size());
    }
}
