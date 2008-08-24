package fr.cg95.cvq.service.users;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Set;

import junit.framework.Assert;
import fr.cg95.cvq.business.request.Request;
import fr.cg95.cvq.business.request.RequestState;
import fr.cg95.cvq.business.users.CreationBean;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.permission.CvqPermissionException;
import fr.cg95.cvq.security.SecurityContext;
import fr.cg95.cvq.testtool.ServiceTestCase;
import fr.cg95.cvq.util.Critere;

// TODO : Migrate to test new statistic API
public class RequestStatisticsServiceTest extends ServiceTestCase {

    public void testRequestStatistic() throws CvqException {
//        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.BACK_OFFICE_CONTEXT);
//        SecurityContext.setCurrentAgent(agentNameWithCategoriesRoles);
//
//        CreationBean cb = gimmeAnHomeFolder();
//        Request request = iRequestService.getById(cb.getRequestId());
//        
//        String requestTypeLabel = request.getRequestType().getLabel();
//        String categoryName = request.getRequestType().getCategory().getName();
//        
//        iRequestService.complete(request.getId());
//        iRequestService.cancel(request.getId());
//
//        continueWithNewTransaction();
//        request = iRequestService.getById(cb.getRequestId());
//
//        Calendar startDate = Calendar.getInstance();
//        startDate.add(Calendar.MINUTE, -1);
//        Calendar endDate = Calendar.getInstance();
//        endDate.add(Calendar.MINUTE, 1);
//
//        Long countFetch = null;
//        
//        // By Quality
//        try {
//            countFetch = iRequestStatisticsService.getCountByQuality(startDate.getTime(), 
//                    endDate.getTime(), Request.QUALITY_TYPE_OK, requestTypeLabel, categoryName);
//            fail("should have thrown an exception");
//        } catch (CvqPermissionException cpe) {
//            // that was expected
//        }
//        
//        SecurityContext.setCurrentAgent(agentNameWithManageRoles);
//        
//        countFetch = iRequestStatisticsService.getCountByQuality(startDate.getTime(), 
//                endDate.getTime(), Request.QUALITY_TYPE_OK, requestTypeLabel, categoryName);
//        Assert.assertEquals(1, countFetch.intValue());
//
//        countFetch = iRequestStatisticsService.getCountByQuality(startDate.getTime(), 
//                endDate.getTime(), Request.QUALITY_TYPE_OK, requestTypeLabel, null);
//        Assert.assertEquals(1, countFetch.intValue());
//
//        countFetch = iRequestStatisticsService.getCountByQuality(startDate.getTime(), 
//                endDate.getTime(), Request.QUALITY_TYPE_ORANGE, requestTypeLabel, categoryName);
//        Assert.assertEquals(0, countFetch.intValue());
//
//        countFetch = iRequestStatisticsService.getCountByQuality(startDate.getTime(), 
//                endDate.getTime(), Request.QUALITY_TYPE_ORANGE, requestTypeLabel, null);
//        Assert.assertEquals(0, countFetch.intValue());
//
//        // By resultingState
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
//
//        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.BACK_OFFICE_CONTEXT);
//        SecurityContext.setCurrentAgent(agentNameWithManageRoles);
//
//        Long initialRequestsCount = iRequestStatisticsService.getCount(new HashSet());
//        Assert.assertEquals(0, initialRequestsCount.longValue());
//        
//        // create an home folder in order to have at least one request in DB
//        gimmeAnHomeFolder();
//
//        Long requestsCount = iRequestStatisticsService.getCount(new HashSet());
//        Assert.assertEquals(1, requestsCount.longValue());
//        
//        Calendar calendar = new GregorianCalendar();
//
//        // search by resulting state COMPLETE
//        Critere crit = new Critere();
//        crit.setAttribut(Request.SEARCH_BY_RESULTING_STATE);
//        crit.setComparatif(Critere.EQUALS);
//        crit.setValue(RequestState.COMPLETE.toString());
//        Set<Critere> critSet = new HashSet<Critere>();
//        critSet.add(crit);
//        requestsCount = iRequestStatisticsService.getCount(critSet);
//        Assert.assertEquals(0, requestsCount.longValue());
//
//        // search by resulting state != COMPLETE
//        crit = new Critere();
//        crit.setAttribut(Request.SEARCH_BY_RESULTING_STATE);
//        crit.setComparatif(Critere.NEQUALS);
//        crit.setValue(RequestState.COMPLETE.toString());
//        critSet = new HashSet<Critere>();
//        critSet.add(crit);
//        requestsCount = iRequestStatisticsService.getCount(critSet);
//        Assert.assertEquals(1, requestsCount.longValue());
//
//        // search by PENDING state
//        crit = new Critere();
//        crit.setAttribut(Request.SEARCH_BY_STATE);
//        crit.setComparatif(Critere.EQUALS);
//        crit.setValue(RequestState.PENDING.toString());
//        critSet = new HashSet<Critere>();
//        critSet.add(crit);
//        requestsCount = iRequestStatisticsService.getCount(critSet);
//        Assert.assertEquals(1, requestsCount.longValue());
//
//        // search by resulting state and modification date
//        crit = new Critere();
//        crit.setAttribut(Request.SEARCH_BY_RESULTING_STATE);
//        crit.setComparatif(Critere.EQUALS);
//        crit.setValue(RequestState.COMPLETE.toString());
//        Critere crit2 = new Critere();
//        crit2.setAttribut(Request.SEARCH_BY_MODIFICATION_DATE);
//        crit2.setComparatif(Critere.GT);
//        calendar.set(2004,5,1);
//        crit2.setValue(calendar.getTime());
//        Critere crit3 = new Critere();
//        crit3.setAttribut(Request.SEARCH_BY_MODIFICATION_DATE);
//        crit3.setComparatif(Critere.LT);
//        calendar.set(2004,5,30);
//        crit3.setValue(calendar.getTime());
//        critSet = new HashSet<Critere>();
//        critSet.add(crit);
//        critSet.add(crit2);
//        critSet.add(crit3);
//        requestsCount = iRequestStatisticsService.getCount(critSet);
//        Assert.assertEquals(0, requestsCount.longValue());
//
//        // search by resulting state and request type
//        crit = new Critere();
//        crit.setAttribut(Request.SEARCH_BY_RESULTING_STATE);
//        crit.setComparatif(Critere.EQUALS);
//        crit.setValue(RequestState.PENDING.toString());
//        critSet = new HashSet<Critere>();
//        critSet.add(crit);
//        critSet.add(crit2);
//        requestsCount = iRequestStatisticsService.getCount(critSet);
//        Assert.assertEquals(1, requestsCount.longValue());
    }
}
