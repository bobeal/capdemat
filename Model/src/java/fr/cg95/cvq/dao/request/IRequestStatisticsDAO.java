package fr.cg95.cvq.dao.request;

import fr.cg95.cvq.business.request.RequestState;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 *
 * @author bor@zenexity.fr
 */
public interface IRequestStatisticsDAO {

    Long countByQuality(final Date startDate, final Date endDate,
        final List<String> resultingStates, final String qualityType, final Long requestTypeId,
        final String categoryFilter);

    Map<Long,Long> countByQualityAndType(final Date startDate, final Date endDate,
        final List<String> resultingStates, final String qualityType,
        final List<Long> requestTypesId);

    Map<RequestState, Long> countByResultingState(final Date startDate, final Date endDate,
        final Long requestTypeId, final String categoryFilter);
}
