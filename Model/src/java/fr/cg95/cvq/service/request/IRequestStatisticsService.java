package fr.cg95.cvq.service.request;

import fr.cg95.cvq.business.request.RequestState;
import fr.cg95.cvq.exception.CvqException;

import java.util.Date;
import java.util.Map;

/**
 * High level service interface to get requests related statistics.
 *
 * @author bor@zenexity.fr
 */
public interface IRequestStatisticsService {

    String QUALITY_TYPE_OK = "qualityTypeOk";
    String QUALITY_TYPE_ORANGE = "qualityTypeOrange";
    String QUALITY_TYPE_RED = "qualityTypeRed";

    /**
     * Get quality of service statistics about requests.
     *
     * @param startDate interval start date
     * @param endDate interval end date
     * @param requestTypeId to restrict statistics to a specific request type
     * @param categoryId to restrict statistics to a specific category
     *
     * @return a map of quality indicator and counts
     * @see {@link #QUALITY_TYPE_OK}, {@link #QUALITY_TYPE_ORANGE}, {@link #QUALITY_TYPE_RED}
     */
    Map<String, Long> getQualityStats(final Date startDate, final Date endDate,
        final Long requestTypeId, final Long categoryId);

    /**
     * The same as {@link #getQualityStats} but with results grouped by request type id.
     *
     * @param startDate interval start date
     * @param endDate interval end date
     * @param requestTypeId to restrict statistics to a specific request type
     * @param categoryId to restrict statistics to a specific category
     */
    Map<Long, Map<String, Long>> getQualityStatsByType(final Date startDate, final Date endDate,
        final Long requestTypeId, final Long categoryId) throws CvqException;

    Map<RequestState, Long> getStateStats(final Date startDate, final Date endDate,
        final Long requestTypeId, final Long categoryId);

    Map<Long, Long> getTypeStats(final Date startDate, final Date endDate,
        final Long requestTypeId, final Long categoryId);

    Map<Date, Long> getTypeStatsByPeriod(final Date startDate, final Date endDate,
        final Long requestTypeId, final Long categoryId);
}
