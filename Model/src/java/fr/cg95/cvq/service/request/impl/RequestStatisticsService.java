package fr.cg95.cvq.service.request.impl;

import fr.cg95.cvq.business.authority.Category;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.log4j.Logger;

import fr.cg95.cvq.business.request.RequestState;
import fr.cg95.cvq.business.request.RequestType;
import fr.cg95.cvq.dao.request.IRequestStatisticsDAO;
import fr.cg95.cvq.dao.request.IRequestTypeDAO;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.security.SecurityContext;
import fr.cg95.cvq.security.annotation.Context;
import fr.cg95.cvq.security.annotation.ContextPrivilege;
import fr.cg95.cvq.security.annotation.ContextType;
import fr.cg95.cvq.service.authority.ICategoryService;
import fr.cg95.cvq.service.authority.LocalAuthorityConfigurationBean;
import fr.cg95.cvq.service.request.IRequestStatisticsService;
import fr.cg95.cvq.service.request.annotation.RequestFilter;
import fr.cg95.cvq.util.Critere;

/**
 * This class provides statistics about requests.
 *
 * @author Benoit Orihuela (bor@zenexity.fr)
 */
public class RequestStatisticsService implements IRequestStatisticsService {

    private static Logger logger = Logger.getLogger(RequestStatisticsService.class);
    
    private IRequestStatisticsDAO requestStatisticsDAO;
    private ICategoryService categoryService;
    private IRequestTypeDAO requestTypeDAO;
    
//    @Context(type=ContextType.AGENT,privilege=ContextPrivilege.MANAGE)
//    @RequestFilter(privilege=ContextPrivilege.MANAGE)
//    public Long getCount(final Set<Critere> criteriaSet)
//        throws CvqException {
//
//        return requestStatisticsDAO.count(criteriaSet);
//    }

    public Map<Date, Long> getDetailedStats(final Timescale timescale, final Lifecycle lifecycle, 
            final Long requestTypeId, final Long categoryId) {

        Map<Date, Long> results = new TreeMap<Date, Long>();

//        String[] resultingState = getStatesFromLifecycle(lifecycle);
//
//        List<Date> searchDates = getNextSearchEndDate(timescale, null);
//        while (searchDates != null) {
//            logger.debug("getDetailedStats() searching between " + searchDates.get(0)
//                    + " and " + searchDates.get(1));
//            Long count = requestStatisticsDAO.countByResultingState(resultingState, searchDates.get(0),
//                    searchDates.get(1), requestTypeId, categoryId);
//            logger.debug("getDetailedStats() adding " + count
//                    + " to date " + searchDates.get(0));
//            results.put(searchDates.get(0), count);
//            searchDates = getNextSearchEndDate(timescale, searchDates.get(1));
//        }
        
        return results;
    }

    public Map<RequestType, Long> getSummarizedStats(final Timescale timescale, 
            final Lifecycle lifecycle, final Long requestTypeId, final Long categoryId) {

        Map<RequestType, Long> results = new HashMap<RequestType, Long>();

//        String[] resultingState = getStatesFromLifecycle(lifecycle);
//        List<Date> searchDates = getNextSearchEndDate(timescale, null);
//
//        Date now = new Date();
////        Date now = getShiftedDemoDate();
//
//        if (requestTypeId == null && categoryId == null) {
//            List<RequestType> requestTypes = requestTypeDAO.listAll();
//            for (RequestType requestType : requestTypes) {
//                Long count = requestStatisticsDAO.countByResultingState(resultingState, searchDates.get(0),
//                        now, requestType.getId(), null);
//                results.put(requestType, count);
//            }
//        }
        
        return results;
    }

    @Context(type=ContextType.AGENT,privilege=ContextPrivilege.MANAGE)
    public Map<String, Long> getQualityStats(final Timescale timescale, final Long requestTypeId,
            final Long categoryId) {


        LocalAuthorityConfigurationBean lacb = SecurityContext.getCurrentConfigurationBean();
        if (!lacb.getInstructionAlertsEnabled())
            return null;

        StringBuffer sb = new StringBuffer();
        if (categoryId == null) {
            List<Category> agentCategories = categoryService.getManaged();
            for (Category category : agentCategories) {
                if (sb.length() > 0) {
                    sb.append(",");
                }
                sb.append("'").append(category.getId()).append("'");
            }
        } else {
            sb.append("'").append(categoryId).append("'");
        }

        List<Date> searchDates = getNextSearchEndDate(timescale, null);

        Date now = new Date();
//        Date now = getShiftedDemoDate();

        Map<String, Long> results = new HashMap<String, Long>();
        Long count = requestStatisticsDAO.countByQuality(searchDates.get(0), now,
                lacb.getInstructionDoneStates(), QUALITY_TYPE_OK, requestTypeId, sb.toString());
        results.put(QUALITY_TYPE_OK, count);
        // (startDate, endDate, resultingStates, qualityType, requestTypeLabel, categoriesNames)
        count = requestStatisticsDAO.countByQuality(searchDates.get(0), now,
                lacb.getInstructionDoneStates(), QUALITY_TYPE_ORANGE, requestTypeId, sb.toString());
        results.put(QUALITY_TYPE_ORANGE, count);

        count = requestStatisticsDAO.countByQuality(searchDates.get(0), now,
                lacb.getInstructionDoneStates(), QUALITY_TYPE_RED, requestTypeId, sb.toString());
        results.put(QUALITY_TYPE_RED, count);

        return results;
    }

    @Context(type=ContextType.AGENT,privilege=ContextPrivilege.MANAGE)
    public Map<String, Long> getQualityStats(final Date startDate, final Date endDate,
        final Long requestTypeId, final Long categoryId) {

        LocalAuthorityConfigurationBean lacb = SecurityContext.getCurrentConfigurationBean();
        if (!lacb.getInstructionAlertsEnabled())
            return null;

        StringBuffer sb = new StringBuffer();
        if (categoryId == null) {
            List<Category> agentCategories = categoryService.getManaged();
            for (Category category : agentCategories) {
                if (sb.length() > 0) {
                    sb.append(",");
                }
                sb.append("'").append(category.getId()).append("'");
            }
        } else {
            sb.append("'").append(categoryId).append("'");
        }

        Map<String, Long> results = new HashMap<String, Long>();

        Long count = requestStatisticsDAO.countByQuality(startDate, endDate,
                lacb.getInstructionDoneStates(), QUALITY_TYPE_OK, requestTypeId, sb.toString());
        results.put(QUALITY_TYPE_OK, count);

        count = requestStatisticsDAO.countByQuality(startDate, endDate,
                lacb.getInstructionDoneStates(), QUALITY_TYPE_ORANGE, requestTypeId, sb.toString());
        results.put(QUALITY_TYPE_ORANGE, count);

        count = requestStatisticsDAO.countByQuality(startDate, endDate,
                lacb.getInstructionDoneStates(), QUALITY_TYPE_RED, requestTypeId, sb.toString());
        results.put(QUALITY_TYPE_RED, count);

        return results;
    }

    public Map<Long, Map<String, Long>> getQualityStatsByType(final Date startDate, 
        final Date endDate, final Long requestTypeId, final Long categoryId)
        throws CvqException {

        LocalAuthorityConfigurationBean lacb = SecurityContext.getCurrentConfigurationBean();
        if (!lacb.getInstructionAlertsEnabled())
            return null;

        List<Long> requestTypes = new ArrayList<Long>();
        if (requestTypeId != null) {
            requestTypes.add(requestTypeId);
        } else if (categoryId != null) {
            Category category = categoryService.getById(categoryId);
            for (RequestType requestType : category.getRequestTypes()) {
                requestTypes.add(requestType.getId());
            }
        } else {
            List<Category> agentCategories = categoryService.getManaged();
            for (Category category : agentCategories) {
                for (RequestType requestType : category.getRequestTypes()) {
                    requestTypes.add(requestType.getId());
                }
            }
        }

        Map<Long, Map<String, Long>> results = new HashMap<Long, Map<String,Long>>();
        for (String qualityType : new String[] {QUALITY_TYPE_OK, QUALITY_TYPE_ORANGE,
                QUALITY_TYPE_RED}) {
            Map<Long, Long> resultsByQuality =
                requestStatisticsDAO.countByQualityAndType(startDate, endDate, lacb.getInstructionDoneStates(),
                    qualityType, requestTypes);
            for (Long rtId : resultsByQuality.keySet()) {
                if (results.get(rtId) == null)
                    results.put(rtId, new HashMap<String, Long>());
                results.get(rtId).put(qualityType, resultsByQuality.get(rtId));
            }
        }

        return results;
    }

    public Map<RequestState, Long> getStateStats(Date startDate, Date endDate, Long requestTypeId,
        Long categoryId) {

        StringBuffer sb = new StringBuffer();
        if (categoryId == null) {
            List<Category> agentCategories = categoryService.getManaged();
            for (Category category : agentCategories) {
                if (sb.length() > 0) {
                    sb.append(",");
                }
                sb.append("'").append(category.getId()).append("'");
            }
        } else {
            sb.append("'").append(categoryId).append("'");
        }

        return requestStatisticsDAO.countByResultingState(startDate, endDate,
            requestTypeId, sb.toString());
    }

    /**
     * Use this method if you need fake dates for demo purposes.
     */
    private Date getShiftedDemoDate() {
        Date date = new Date();
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.add(Calendar.YEAR, -3);

        return calendar.getTime();
    }

    /**
     * Compute the next search period according to a timescale and start date.
     * 
     * @return a list containing a start and end date or null if no more dates
     * @deprecated was used for a PoC, deprecated till eventual resurrection
     */
    private List<Date> getNextSearchEndDate(final Timescale timescale, Date startDate) {
        
        logger.debug("getNextSearchEndDate() computing date for timescale "
                + timescale + " and date " + startDate);
        
        Calendar calendar = new GregorianCalendar();
        if (startDate == null) {
            startDate = new Date();
//            startDate = getShiftedDemoDate();
            calendar.setTime(startDate);
            calendar.set(Calendar.HOUR_OF_DAY, 0);
            calendar.set(Calendar.MINUTE, 0);
            calendar.set(Calendar.SECOND, 0);
            switch(timescale) {
                case MONTH : calendar.add(Calendar.MONTH, -1);break;
                case WEEK : calendar.add(Calendar.DAY_OF_YEAR, -7);break;
                case YEAR : calendar.add(Calendar.MONTH, -12);break;
            }
        } else {
            calendar.setTime(startDate);
        }
        
        List<Date> results = new ArrayList<Date>();
        results.add(calendar.getTime());
        Date now = new Date();
//        Date now = getShiftedDemoDate();
        if (timescale.equals(Timescale.MONTH) || timescale.equals(Timescale.WEEK)) {
            calendar.add(Calendar.DAY_OF_YEAR, 1);
            if (calendar.getTime().after(now))
                return null;
            results.add(calendar.getTime());
            return results;
        } else if (timescale.equals(Timescale.YEAR)) {
            calendar.add(Calendar.MONTH, 1);
            if (calendar.getTime().after(now))
                return null;
            results.add(calendar.getTime());
            return results;
        } else {
            return null;
        }
    }
    
    /**
     * @deprecated was used for a PoC, deprecated till eventual resurrection
     */
    private String[] getStatesFromLifecycle(final Lifecycle lifecycle) {
        String[] resultingState = null;
        if (lifecycle.equals(Lifecycle.CREATED)) {
            resultingState = new String[] { RequestState.PENDING.toString() };
        } else {
            resultingState = new String[] { 
                    RequestState.CANCELLED.toString(),
                    RequestState.REJECTED.toString(),
                    RequestState.VALIDATED.toString()
            };
        }
        
        return resultingState;
    }
    
    public void setRequestStatisticsDAO(IRequestStatisticsDAO requestStatisticsDAO) {
        this.requestStatisticsDAO = requestStatisticsDAO;
    }

    public void setRequestTypeDAO(IRequestTypeDAO requestTypeDAO) {
        this.requestTypeDAO = requestTypeDAO;
    }

    public void setCategoryService(ICategoryService categoryService) {
        this.categoryService = categoryService;
    }
}
