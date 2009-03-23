package fr.cg95.cvq.service.request;

import fr.cg95.cvq.business.authority.CategoryProfile;
import fr.cg95.cvq.business.request.RequestType;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.util.Critere;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * High level service interface to get requests related statistics.
 *
 * @author bor@zenexity.fr
 */
public interface IRequestStatisticsService {

    /** service name used by Spring's application context */
	String SERVICE_NAME = "requestStatisticsService";
	
    String QUALITY_TYPE_OK = "qualityTypeOk";
    String QUALITY_TYPE_ORANGE = "qualityTypeOrange";
    String QUALITY_TYPE_RED = "qualityTypeRed";

    public enum Timescale { WEEK, MONTH, YEAR, EVER };
    public enum Lifecycle { CREATED, TREATED };
    
    
    /**
     * Get detailed statistics about requests.
     * 
     * @param timescale timescale of requested statistics
     * @param lifecycle step of the requests lifecycle we are interested in 
     * @param requestTypeId to restrict statistics to a specific request type
     * @param categoryName to restrict statistics to a specific category
     * 
     * @return a map of dates and counts
     */
    Map<Date, Long> getDetailedStats(final Timescale timescale, final Lifecycle lifecycle, 
            final Long requestTypeId, final Long categoryId);
    
    /**
     * Get summarized statistics about requests.
     * 
     * @param timescale timescale of requested statistics
     * @param lifecycle step of the requests lifecycle we are interested in 
     * @param requestTypeId to restrict statistics to a specific request type
     * @param categoryName to restrict statistics to a specific category
     * 
     * @return a map of request types and counts
     */
    Map<RequestType, Long> getSummarizedStats(final Timescale timescale, final Lifecycle lifecycle, 
            final Long requestTypeId, final Long categoryId);
    
    /**
     * Get quality of service statistics about requests. 
     * 
     * @param timescale timescale of requested statistics
     * @param requestTypeId to restrict statistics to a specific request type
     * @param categoryName to restrict statistics to a specific category
     * 
     * @return a map of quality indicator and counts
     * @see {@link #QUALITY_TYPE_OK}, {@link #QUALITY_TYPE_ORANGE}, {@link #QUALITY_TYPE_RED}
    */
//    Map<String, Long> getQualityStats(final Timescale timescale, final Long requestTypeId,
//            final Long categoryId);
    
    /**
     * Get quality of service statistics about requests.
     *
     * @param startDate interval start date
     * @param endDate interval end date
     * @param requestTypeId to restrict statistics to a specific request type
     * @param categoryName to restrict statistics to a specific category
     *
     * @return a map of quality indicator and counts
     * @see {@link #QUALITY_TYPE_OK}, {@link #QUALITY_TYPE_ORANGE}, {@link #QUALITY_TYPE_RED}
    */
    Map<String, Long> getQualityStats(final Date startDate, final Date endDate,
        final Long requestTypeId, final Long categoryId);

    Map<Long, Map<String, Long>> getQualityStatsByType(final Date startDate, final Date endDate,
        final Long requestTypeId, final Long categoryId) throws CvqException;

    /**
     * Get only a count of requests according to a set of criteria.
     * 
     * Needs a {@link CategoryProfile#MANAGER manager profile} to be performed.
     */
    Long getCount(final Set<Critere> criteriaSet)
        throws CvqException;
}
