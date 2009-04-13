package fr.cg95.cvq.dao.request;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 *
 * @author bor@zenexity.fr
 */
public interface IRequestStatisticsDAO {

    Long countByQuality(final Date startDate, final Date endDate,
        final List<String> resultingStates, final String qualityType, 
        final List<Long> requestTypesId);

    Map<Long,Long> countByQualityAndType(final Date startDate, final Date endDate,
        final List<String> resultingStates, final String qualityType,
        final List<Long> requestTypesId);

    Long countByResultingState(final String resultingState,
        final Date startDate, final Date endDate,
        final List<Long> requestTypesId);

    Map<Long, Long> countByType(final Date startDate, final Date endDate,
        final List<Long> requestTypeIds);

    Long countByPeriod(final Date startDate, final Date endDate,
        final List<Long> requestTypeIds);

    Date getOldestRequest();
}
