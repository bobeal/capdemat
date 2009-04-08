package fr.cg95.cvq.service.request.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.joda.time.DateTime;
import org.joda.time.Days;

import org.apache.log4j.Logger;

import fr.cg95.cvq.business.authority.Category;
import fr.cg95.cvq.business.authority.LocalAuthority;
import fr.cg95.cvq.business.request.RequestState;
import fr.cg95.cvq.business.request.RequestType;
import fr.cg95.cvq.dao.request.IRequestStatisticsDAO;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.security.SecurityContext;
import fr.cg95.cvq.security.annotation.Context;
import fr.cg95.cvq.security.annotation.ContextPrivilege;
import fr.cg95.cvq.security.annotation.ContextType;
import fr.cg95.cvq.service.authority.ICategoryService;
import fr.cg95.cvq.service.request.IRequestStatisticsService;
import fr.cg95.cvq.service.request.IRequestWorkflowService;

/**
 * This class provides statistics about requests.
 *
 * @author Benoit Orihuela (bor@zenexity.fr)
 */
public class RequestStatisticsService implements IRequestStatisticsService {

    private static Logger logger = Logger.getLogger(RequestStatisticsService.class);
    
    private IRequestStatisticsDAO requestStatisticsDAO;
    private ICategoryService categoryService;
    private IRequestWorkflowService requestWorkflowService;

    @Override
    @Context(type=ContextType.AGENT,privilege=ContextPrivilege.MANAGE)
    public Map<String, Long> getQualityStats(final Date startDate, final Date endDate,
        final Long requestTypeId, final Long categoryId) {

        LocalAuthority la = SecurityContext.getCurrentSite();
        if (!la.isInstructionAlertsEnabled())
            return null;

        List<Long> requestTypes = getRequestTypeIdsFromParameters(requestTypeId, categoryId);
        DateTime[] intervalDates = computeDateIntervals(startDate, endDate);

        Map<String, Long> results = new HashMap<String, Long>();

        for (String qualityType : new String[] {QUALITY_TYPE_OK, QUALITY_TYPE_ORANGE,
                QUALITY_TYPE_RED}) {
            Long count = requestStatisticsDAO.countByQuality(intervalDates[0].toDate(),
                intervalDates[1].toDate(), requestWorkflowService.getInstructionDoneStates(),
                qualityType, requestTypes);
            results.put(qualityType, count);
        }

        return results;
    }

    @Override
    @Context(type=ContextType.AGENT,privilege=ContextPrivilege.MANAGE)
    public Map<Long, Map<String, Long>> getQualityStatsByType(final Date startDate, 
        final Date endDate, final Long requestTypeId, final Long categoryId)
        throws CvqException {

        LocalAuthority la = SecurityContext.getCurrentSite();
        if (!la.isInstructionAlertsEnabled())
            return null;

        List<Long> requestTypes = getRequestTypeIdsFromParameters(requestTypeId, categoryId);
        DateTime[] intervalDates = computeDateIntervals(startDate, endDate);

        Map<Long, Map<String, Long>> results = new HashMap<Long, Map<String,Long>>();
        for (String qualityType : new String[] {QUALITY_TYPE_OK, QUALITY_TYPE_ORANGE,
                QUALITY_TYPE_RED}) {
            Map<Long, Long> resultsByQuality =
                requestStatisticsDAO.countByQualityAndType(intervalDates[0].toDate(), 
                    intervalDates[1].toDate(), requestWorkflowService.getInstructionDoneStates(),
                    qualityType, requestTypes);
            for (Long rtId : resultsByQuality.keySet()) {
                if (results.get(rtId) == null)
                    results.put(rtId, new HashMap<String, Long>());
                results.get(rtId).put(qualityType, resultsByQuality.get(rtId));
            }
        }

        return results;
    }

    @Override
    @Context(type=ContextType.AGENT,privilege=ContextPrivilege.MANAGE)
    public Map<RequestState, Long> getStateStats(Date startDate, Date endDate, Long requestTypeId,
        Long categoryId) {

        List<Long> requestTypes = getRequestTypeIdsFromParameters(requestTypeId, categoryId);
        DateTime[] intervalDates = computeDateIntervals(startDate, endDate);

        Map<RequestState, Long> result = new HashMap<RequestState, Long>();
        for (RequestState requestState : RequestState.allRequestStates)
            result.put(requestState,
                requestStatisticsDAO.countByResultingState(requestState.toString(),
                    intervalDates[0].toDate(), intervalDates[1].toDate(), requestTypes));

        return result;
    }

    @Override
    @Context(type=ContextType.AGENT,privilege=ContextPrivilege.MANAGE)
    public Map<Long, Long> getTypeStats(Date startDate, Date endDate, Long requestTypeId,
        Long categoryId) {

        DateTime[] intervalDates = computeDateIntervals(startDate, endDate);

        return requestStatisticsDAO.countByType(intervalDates[0].toDate(), intervalDates[1].toDate(),
            getRequestTypeIdsFromParameters(requestTypeId, categoryId));
    }

    @Override
    @Context(type=ContextType.AGENT,privilege=ContextPrivilege.MANAGE)
    public Map<Date, Long> getTypeStatsByPeriod(final Date startDate, final Date endDate,
        final Long requestTypeId, final Long categoryId) {

        Map<Date, Long> result = new TreeMap<Date, Long>();

        DateTime[] intervalDates = computeDateIntervals(startDate, endDate);

        if (!intervalDates[0].isBefore(intervalDates[1])) {
            logger.warn("getTypeStatsByPeriod() start search date is after end search date");
            return result;
        }

        TypeStatsIntervalType typeStatsIntervalType = 
            getTypeStatsIntervalType(intervalDates[0].toDate(), intervalDates[1].toDate());
        DateTime startSearchTime = new DateTime(intervalDates[0]);
        DateTime endSearchTime = getNextSearchDateTime(intervalDates[0], typeStatsIntervalType);
        do {
            Long count =
                requestStatisticsDAO.countByPeriod(startSearchTime.toDate(),
                    endSearchTime.toDate(),
                    getRequestTypeIdsFromParameters(requestTypeId, categoryId));
            result.put(startSearchTime.toDate(), count);
            startSearchTime = getNextSearchDateTime(startSearchTime, typeStatsIntervalType);
            endSearchTime = getNextSearchDateTime(endSearchTime, typeStatsIntervalType);
        } while (startSearchTime.isBefore(intervalDates[1]));

        return result;
    }

    @Override
    public TypeStatsIntervalType getTypeStatsIntervalType(Date startDate, Date endDate) {

        DateTime[] intervalDates = computeDateIntervals(startDate, endDate);

        Days intervalDays = Days.daysBetween(intervalDates[0], intervalDates[1]);
        if (intervalDays.getDays() == 0)
            // if one day, display hourly statistics
            return TypeStatsIntervalType.HOUR;
        else if (intervalDays.getDays() <= 14)
            // if less than two weeks, display dayly statistics
            return TypeStatsIntervalType.DAY;
        else if (intervalDays.getDays() <= 60)
            // if between two weeks and two months, display bi-dayly (?) statistics
            return TypeStatsIntervalType.TWO_DAYS;
        else if (intervalDays.getDays() <= 180)
            // if between two and six months, display weekly statistics
            return TypeStatsIntervalType.WEEK;
        else if (intervalDays.getDays() <= 730)
            // if between six months and two years, display monthly statistics
            return TypeStatsIntervalType.MONTH;
        else
            return TypeStatsIntervalType.YEAR;
    }

    private DateTime getNextSearchDateTime(DateTime dateTime,
        TypeStatsIntervalType typeStatsIntervalType) {

        switch (typeStatsIntervalType) {
            case HOUR: return dateTime.plusHours(1);
            case DAY: return dateTime.plusDays(1);
            case TWO_DAYS: return dateTime.plusDays(2);
            case WEEK: return dateTime.plusDays(7);
            case MONTH: return dateTime.plusMonths(1);
            default: return dateTime.plusYears(1);
        }
    }

    private List<Long> getRequestTypeIdsFromParameters(final Long requestTypeId,
        final Long categoryId) {

        List<Long> requestTypeIds = new ArrayList<Long>();
        if (requestTypeId != null) {
            requestTypeIds.add(requestTypeId);
        } else if (categoryId != null) {
            try {
                Category category = categoryService.getById(categoryId);
                for (RequestType requestType : category.getRequestTypes()) {
                    requestTypeIds.add(requestType.getId());
                }
            } catch (CvqException ex) {
            }

        } else {
            List<Category> agentCategories = categoryService.getManaged();
            for (Category category : agentCategories) {
                for (RequestType requestType : category.getRequestTypes()) {
                    requestTypeIds.add(requestType.getId());
                }
            }
        }

        return requestTypeIds;
    }

    private DateTime[] computeDateIntervals(final Date startDate, final Date endDate) {

        DateTime startDateTime = null;
        DateTime endDateTime = null;

        if (startDate != null) {
            startDateTime = new DateTime(startDate).withTime(0, 0, 0, 0);
        } else {
            Date oldestRequestDate = requestStatisticsDAO.getOldestRequest();
            startDateTime = new DateTime(oldestRequestDate).withTime(0, 0, 0, 0);
        }

        endDateTime = new DateTime(endDate).withTime(23, 59, 59, 999);

        return new DateTime[] {startDateTime, endDateTime};
    }

    public void setRequestStatisticsDAO(IRequestStatisticsDAO requestStatisticsDAO) {
        this.requestStatisticsDAO = requestStatisticsDAO;
    }

    public void setCategoryService(ICategoryService categoryService) {
        this.categoryService = categoryService;
    }

    public void setRequestWorkflowService(IRequestWorkflowService requestWorkflowService) {
        this.requestWorkflowService = requestWorkflowService;
    }
}
