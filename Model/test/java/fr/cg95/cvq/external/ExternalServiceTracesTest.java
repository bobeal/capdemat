package fr.cg95.cvq.external;

import java.util.Date;
import java.util.Set;

import junit.framework.Assert;
import fr.cg95.cvq.business.external.ExternalServiceTrace;
import fr.cg95.cvq.business.external.TraceStatusEnum;
import fr.cg95.cvq.security.SecurityContext;
import fr.cg95.cvq.testtool.ServiceTestCase;
import fr.cg95.cvq.util.DateUtils;

public class ExternalServiceTracesTest extends ServiceTestCase {
    
    protected Long newId = -1L;
    protected IExternalService externalService;
    
    @Override
    protected void onSetUp() throws Exception {
        super.onSetUp();
        externalService = (IExternalService) getBean("externalService");
    }
    
    public void testBaseFunctionality() throws Exception {

        try {
            SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.BACK_OFFICE_CONTEXT);
            SecurityContext.setCurrentAgent(agentNameWithCategoriesRoles);
            
            /* Tests entity creation */
            ExternalServiceTrace trace = new ExternalServiceTrace();
            
            trace.setKey(2345L);
            trace.setKeyOwner("MyOwner");
            trace.setMessage("No message");
            trace.setName("MyName");
            trace.setStatus(TraceStatusEnum.SENT);
            
            newId = externalService.addTrace(trace);
            
            continueWithNewTransaction();
            
            Set<ExternalServiceTrace> traces = 
                externalService.getTraces(2345L, null, null, null, null); 
            
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
            
            traces = externalService.getTraces(2345L, "MyName", TraceStatusEnum.SENT, 
                    DateUtils.parseDate("13/09/2007"), new Date());
            assertEquals(1, traces.size());
            
            traces = externalService.getTraces(2345L, null, null, 
                    DateUtils.parseDate("13/09/2007"), DateUtils.parseDate("17/06/2008"));
            assertEquals(0, traces.size());
            
            traces = externalService.getTraces(null, null, null, 
                    DateUtils.parseDate("13/09/2007"), new Date());
            assertEquals(1, traces.size());
            
            /* Test different trace removal methods */
            externalService.addTrace(trace);
            
            traces = externalService.getTraces(null, null, null, 
                    DateUtils.parseDate("13/09/2007"), new Date());
            assertNotNull(traces);
            assertEquals(2, traces.size());
            
            externalService.deleteTraces("MyName");

            continueWithNewTransaction();
            
            traces = externalService.getTraces(null, "MyName", null, null, null);
            assertEquals(0, traces.size());
            
            externalService.addTrace(trace);
            externalService.addTrace(trace);
            externalService.addTrace(trace);

            continueWithNewTransaction();
            
            traces = externalService.getTraces(null, null, null, 
                    DateUtils.parseDate("13/09/2007"), new Date());
            assertEquals(1, traces.size());
            
            int count = externalService.deleteTraces(0L, "");
            assertEquals(0, count);
            
            count = externalService.deleteTraces(2345L, "MyOwner");
            assertEquals(traces.size(), count);
            traces = externalService.getTraces(null, null, null, 
                    DateUtils.parseDate("13/09/2007"), new Date());
            assertEquals(0, traces.size());
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (newId > 0) { 
                externalService.deleteTraces(2345L,null);
                Set<ExternalServiceTrace> traces = 
                    externalService.getTraces(2345L, null, null, null, null);

                Assert.assertEquals(traces.size(),0);            
            }
        }
    }
}
