package fr.cg95.cvq.service.request;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Set;

import junit.framework.Assert;
import fr.cg95.cvq.business.request.Request;
import fr.cg95.cvq.business.request.RequestState;
import fr.cg95.cvq.business.users.CreationBean;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.security.PermissionException;
import fr.cg95.cvq.security.SecurityContext;
import fr.cg95.cvq.testtool.ServiceTestCase;
import fr.cg95.cvq.util.Critere;
import java.util.Map;

public class RequestStatisticsServiceTest extends ServiceTestCase {

    public void testRequestStatistic() throws CvqException {
        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.BACK_OFFICE_CONTEXT);
        SecurityContext.setCurrentAgent(agentNameWithCategoriesRoles);

        CreationBean cb = gimmeAnHomeFolder();
        Request request = iRequestService.getById(cb.getRequestId());

        Long requestTypeId = request.getRequestType().getId();
        Long categoryId = request.getRequestType().getCategory().getId();

        iRequestService.complete(request.getId());
        iRequestService.cancel(request.getId());

        continueWithNewTransaction();
        SecurityContext.setCurrentAgent(agentNameWithCategoriesRoles);

        Calendar startDate = Calendar.getInstance();
        startDate.add(Calendar.MINUTE, -1);
        Calendar endDate = Calendar.getInstance();
        endDate.add(Calendar.MINUTE, 1);

        Map<String, Long> qualityStats = null;
        try {
            qualityStats = iRequestStatisticsService.getQualityStats(startDate.getTime(),
                    endDate.getTime(), requestTypeId, categoryId);
            fail("should have thrown an exception");
        } catch (PermissionException pe) {
            // that was expected
        }

        SecurityContext.setCurrentAgent(agentNameWithManageRoles);

        qualityStats = iRequestStatisticsService.getQualityStats(startDate.getTime(),
                endDate.getTime(), requestTypeId, categoryId);
        assertEquals(Long.valueOf(1), qualityStats.get(IRequestStatisticsService.QUALITY_TYPE_OK));
        assertEquals(Long.valueOf(0),
            qualityStats.get(iRequestStatisticsService.QUALITY_TYPE_ORANGE));
        assertEquals(Long.valueOf(0), qualityStats.get(IRequestStatisticsService.QUALITY_TYPE_RED));

        qualityStats = iRequestStatisticsService.getQualityStats(startDate.getTime(),
                endDate.getTime(), requestTypeId, null);
        assertEquals(Long.valueOf(1), qualityStats.get(IRequestStatisticsService.QUALITY_TYPE_OK));
        assertEquals(Long.valueOf(0),
            qualityStats.get(iRequestStatisticsService.QUALITY_TYPE_ORANGE));
        assertEquals(Long.valueOf(0), qualityStats.get(IRequestStatisticsService.QUALITY_TYPE_RED));

        Map<Long, Map<String, Long>> qualityByTypeMap =
            iRequestStatisticsService.getQualityStatsByType(startDate.getTime(), endDate.getTime(),
            null, null);
        assertNotNull(qualityByTypeMap.get(request.getRequestType().getId()));
        Map<String,Long> qualityForVocr = qualityByTypeMap.get(request.getRequestType().getId());
        assertEquals(Long.valueOf(1),
            qualityForVocr.get(IRequestStatisticsService.QUALITY_TYPE_OK));
        assertEquals(null,
            qualityForVocr.get(IRequestStatisticsService.QUALITY_TYPE_ORANGE));
        assertEquals(null,
            qualityForVocr.get(IRequestStatisticsService.QUALITY_TYPE_RED));



        // By resultingState
//        countFetch = iRequestStatisticsService.getCountByResultingState(
//                RequestState.CANCELLED.toString(), startDate.getTime(), endDate.getTime(),
//                requestTypeLabel, null);
//        Assert.assertEquals(1, countFetch.intValue());
//
//        countFetch = iRequestStatisticsService.getCountByResultingState(
//                RequestState.CANCELLED.toString(), startDate.getTime(), endDate.getTime(),
//                requestTypeLabel, categoryName);
//        Assert.assertEquals(1, countFetch.intValue());
//
//        countFetch = iRequestStatisticsService.getCountByResultingState(
//                RequestState.PENDING.toString(), startDate.getTime(), endDate.getTime(),
//                requestTypeLabel, categoryName);
//        Assert.assertEquals(1, countFetch.intValue());
//
//        countFetch = iRequestStatisticsService.getCountByResultingState(
//                RequestState.PENDING.toString(), startDate.getTime(), endDate.getTime(),
//                requestTypeLabel, null);
//        Assert.assertEquals(1, countFetch.intValue());
//
//        countFetch = iRequestStatisticsService.getCountByResultingState(
//                RequestState.ARCHIVED.toString(), startDate.getTime(), endDate.getTime(),
//                requestTypeLabel, categoryName);
//        Assert.assertEquals(0, countFetch.intValue());
//
//        countFetch = iRequestStatisticsService.getCountByResultingState(
//                RequestState.ARCHIVED.toString(), startDate.getTime(), endDate.getTime(),
//                requestTypeLabel, null);
//        Assert.assertEquals(0, countFetch.intValue());
    }

    public void testGetCount() throws CvqException {

        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.BACK_OFFICE_CONTEXT);
        SecurityContext.setCurrentAgent(agentNameWithManageRoles);

        Long initialRequestsCount = iRequestStatisticsService.getCount(new HashSet());
        Assert.assertEquals(0, initialRequestsCount.longValue());
        
        // create an home folder in order to have at least one request in DB
        gimmeAnHomeFolder();

        Long requestsCount = iRequestStatisticsService.getCount(new HashSet());
        Assert.assertEquals(1, requestsCount.longValue());
        
        Calendar calendar = new GregorianCalendar();

        // search by resulting state COMPLETE
        Critere crit = new Critere();
        crit.setAttribut(Request.SEARCH_BY_RESULTING_STATE);
        crit.setComparatif(Critere.EQUALS);
        crit.setValue(RequestState.COMPLETE.toString());
        Set<Critere> critSet = new HashSet<Critere>();
        critSet.add(crit);
        requestsCount = iRequestStatisticsService.getCount(critSet);
        Assert.assertEquals(0, requestsCount.longValue());

        // search by resulting state != COMPLETE
        crit = new Critere();
        crit.setAttribut(Request.SEARCH_BY_RESULTING_STATE);
        crit.setComparatif(Critere.NEQUALS);
        crit.setValue(RequestState.COMPLETE.toString());
        critSet = new HashSet<Critere>();
        critSet.add(crit);
        requestsCount = iRequestStatisticsService.getCount(critSet);
        Assert.assertEquals(1, requestsCount.longValue());

        // search by PENDING state
        crit = new Critere();
        crit.setAttribut(Request.SEARCH_BY_STATE);
        crit.setComparatif(Critere.EQUALS);
        crit.setValue(RequestState.PENDING.toString());
        critSet = new HashSet<Critere>();
        critSet.add(crit);
        requestsCount = iRequestStatisticsService.getCount(critSet);
        Assert.assertEquals(1, requestsCount.longValue());

        // search by resulting state and modification date
        crit = new Critere();
        crit.setAttribut(Request.SEARCH_BY_RESULTING_STATE);
        crit.setComparatif(Critere.EQUALS);
        crit.setValue(RequestState.COMPLETE.toString());
        Critere crit2 = new Critere();
        crit2.setAttribut(Request.SEARCH_BY_MODIFICATION_DATE);
        crit2.setComparatif(Critere.GT);
        calendar.set(2004,5,1);
        crit2.setValue(calendar.getTime());
        Critere crit3 = new Critere();
        crit3.setAttribut(Request.SEARCH_BY_MODIFICATION_DATE);
        crit3.setComparatif(Critere.LT);
        calendar.set(2004,5,30);
        crit3.setValue(calendar.getTime());
        critSet = new HashSet<Critere>();
        critSet.add(crit);
        critSet.add(crit2);
        critSet.add(crit3);
        requestsCount = iRequestStatisticsService.getCount(critSet);
        Assert.assertEquals(0, requestsCount.longValue());

        // search by resulting state and request type
        crit = new Critere();
        crit.setAttribut(Request.SEARCH_BY_RESULTING_STATE);
        crit.setComparatif(Critere.EQUALS);
        crit.setValue(RequestState.PENDING.toString());
        critSet = new HashSet<Critere>();
        critSet.add(crit);
        critSet.add(crit2);
        requestsCount = iRequestStatisticsService.getCount(critSet);
        Assert.assertEquals(1, requestsCount.longValue());
    }
}
