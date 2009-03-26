package fr.cg95.cvq.service.request.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import fr.cg95.cvq.business.authority.Category;
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

    @Override
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

    @Override
    @Context(type=ContextType.AGENT,privilege=ContextPrivilege.MANAGE)
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

    @Override
    @Context(type=ContextType.AGENT,privilege=ContextPrivilege.MANAGE)
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

        Map<RequestState, Long> result = new HashMap<RequestState, Long>();
        for (RequestState requestState : RequestState.allRequestStates)
            result.put(requestState,
                requestStatisticsDAO.countByResultingState(requestState.toString(),
                    startDate, endDate, requestTypeId, sb.toString()));

        return result;
    }

    @Override
    @Context(type=ContextType.AGENT,privilege=ContextPrivilege.MANAGE)
    public Map<Long, Long> getTypeStats(Date startDate, Date endDate, Long requestTypeId,
        Long categoryId) {

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

        return requestStatisticsDAO.countByType(startDate, endDate, requestTypeIds);
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
//    private List<Date> getNextSearchEndDate(final Timescale timescale, Date startDate) {
//
//        logger.debug("getNextSearchEndDate() computing date for timescale "
//                + timescale + " and date " + startDate);
//
//        Calendar calendar = new GregorianCalendar();
//        if (startDate == null) {
//            startDate = new Date();
////            startDate = getShiftedDemoDate();
//            calendar.setTime(startDate);
//            calendar.set(Calendar.HOUR_OF_DAY, 0);
//            calendar.set(Calendar.MINUTE, 0);
//            calendar.set(Calendar.SECOND, 0);
//            switch(timescale) {
//                case MONTH : calendar.add(Calendar.MONTH, -1);break;
//                case WEEK : calendar.add(Calendar.DAY_OF_YEAR, -7);break;
//                case YEAR : calendar.add(Calendar.MONTH, -12);break;
//            }
//        } else {
//            calendar.setTime(startDate);
//        }
//
//        List<Date> results = new ArrayList<Date>();
//        results.add(calendar.getTime());
//        Date now = new Date();
////        Date now = getShiftedDemoDate();
//        if (timescale.equals(Timescale.MONTH) || timescale.equals(Timescale.WEEK)) {
//            calendar.add(Calendar.DAY_OF_YEAR, 1);
//            if (calendar.getTime().after(now))
//                return null;
//            results.add(calendar.getTime());
//            return results;
//        } else if (timescale.equals(Timescale.YEAR)) {
//            calendar.add(Calendar.MONTH, 1);
//            if (calendar.getTime().after(now))
//                return null;
//            results.add(calendar.getTime());
//            return results;
//        } else {
//            return null;
//        }
//    }
    
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
