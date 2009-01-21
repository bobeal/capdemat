package fr.cg95.cvq.dao.request;

import java.util.Date;
import java.util.List;
import java.util.Set;

import fr.cg95.cvq.business.request.Request;
import fr.cg95.cvq.business.request.RequestState;
import fr.cg95.cvq.dao.IGenericDAO;
import fr.cg95.cvq.util.Critere;

/**
 * @author bor@zenexity.fr
 */
public interface IRequestDAO extends IGenericDAO {

    /**
     * Look up requests given a set of search criteria.
     *
     * @param criteria a set of {@link fr.cg95.cvq.util.Critere} criteria
     * @param sort an optional string to sort results on
     * @param dir sort direction (asc or desc)
     * @param recordsReturned number of records to return (-1 for all)
     * @param startIndex start index of the records to return
     */
    List<Request> search(final Set<Critere> criteria, final String sort, String dir, 
            int recordsReturned, int startIndex);

    /**
     * Return the number of requests that match a set of search criteria.
     */
    Long count(final Set<Critere> criteria);

    Long countByQuality(final Date startDate, final Date endDate, final List resultingStates,
    		final String qualityType, final Long requestTypeId, final Long categoryId);
    
    Long countByResultingState(final String[] resultingState, final Date startDate, final Date endDate, 
            final Long requestTypeId, final Long categoryId);

    /**
     * Return the list of all requests whose requester has the given id.
     */
    List<Request> listByRequester(final Long requesterId);

    /**
     * Return the list of all requests whose subject, if any, has the given id.
     */
    List<Request> listBySubject(final Long subjectId);

    /**
     * Return the list of requests with the given label whose associated subject has
     * the given id.
     *
     * @param label label identifier as used internally by all requests-related services
     */
    List<Request> listBySubjectAndLabel(final Long subjectId, final String label, 
            final RequestState[] excludedStates);

    /**
     * Return the list of all requests whose associated home folder has the given id.
     */
    List<Request> listByHomeFolder(final Long homeFolderId);

    /**
     * Return the list of requests with the given label whose associated home folder has
     * the given id.
     *
     * @param label label identifier as used internally by all requests-related services
     */
    List<Request> listByHomeFolderAndLabel(final Long homeFolderId, final String label, 
            final RequestState[] excludedStates);

    /**
     * Return the list of requests whose associated home folder has already a registration
     * for the given season.
     */
    List<Request> listByHomeFolderAndSeason(final Long homeFolderId, final String seasonUuid);
    
    List<Request> listByStateAndSeason(final RequestState requestState, final String seasonUuid);
    
    /**
     * Return the list of all requests who are in one of the given states.
     */
    List<Request> listByStates(final Set<RequestState> states);
    
    /**
     * Return the list of all requests of the given type who are in one of the given states.
     */
    List<Request> listByStatesAndType(final Set<RequestState> states, 
            final String requestTypeLabel);
    
    /**
     * Return the list of requests which do not have the given action label.
     */
    List<Request> listByNotMatchingActionLabel(final String actionLabel);

    /**
     * Return list of request drafts prepared for delete notification
     * 
     * @param actionLabel Notification label
     * @param date Limit date
     * @return drafts list
     */
    List<Request> listByDraftNotification(String actionLabel, Date date);
    
    Object getSubjectId (Long requestId);

    List<Long> getHomeFolderSubjectIds(Long homeFolderId, String label, 
                                              RequestState[] excludedStates);
}
