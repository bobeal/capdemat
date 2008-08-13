package fr.cg95.cvq.service.users;

import java.util.Date;
import java.util.Set;

import fr.cg95.cvq.exception.CvqException;

/**
 * High level service interface to get requests related statistics.
 *
 * @author bor@zenexity.fr
 */
public interface IRequestStatisticsService {

    /** service name used by Spring's application context */
	String SERVICE_NAME = "requestStatisticsService";
    
    /**
     * Return a count of requests according to quality parameters.
     * 
     * Need instruction alerts to be enabled for the local authority.
     */
    Long getCountByQuality(final Date startDate, final Date endDate, final String qualityType,
    		final String requestTypeLabel, final String categoryName)
    		throws CvqException;
    
    public Long getCountByResultingState(final String resultingState, final Date startDate, final Date endDate, 
            final String requestTypeLabel, final String categoryName) 
            throws CvqException;
    
    /**
     * Get only a count of requests according to a set of criteria.
     * Needs an Manage profile to be performed
     *
     * @see fr.cg95.cvq.business.authority.SiteProfile
     */
    Long getCount(final Set criteriaSet)
        throws CvqException;
}
