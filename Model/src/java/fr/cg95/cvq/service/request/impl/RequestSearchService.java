package fr.cg95.cvq.service.request.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import fr.cg95.cvq.business.request.Request;
import fr.cg95.cvq.business.request.RequestAction;
import fr.cg95.cvq.business.request.RequestState;
import fr.cg95.cvq.dao.request.IRequestActionDAO;
import fr.cg95.cvq.dao.request.IRequestDAO;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.exception.CvqModelException;
import fr.cg95.cvq.exception.CvqObjectNotFoundException;
import fr.cg95.cvq.security.annotation.Context;
import fr.cg95.cvq.security.annotation.ContextPrivilege;
import fr.cg95.cvq.security.annotation.ContextType;
import fr.cg95.cvq.service.request.IRequestSearchService;
import fr.cg95.cvq.service.request.annotation.RequestFilter;
import fr.cg95.cvq.util.Critere;

public class RequestSearchService implements IRequestSearchService {

    private IRequestDAO requestDAO;
    private IRequestActionDAO requestActionDAO;
    
    @Override
    @Context(type=ContextType.ECITIZEN_AGENT, privilege=ContextPrivilege.NONE)
    @RequestFilter(privilege=ContextPrivilege.READ)
    public List<Request> get(Set<Critere> criteriaSet, final String sort, final String dir,
            final int recordsReturned, final int startIndex)
        throws CvqException {

        return requestDAO.search(criteriaSet, sort, dir, recordsReturned, startIndex);
    }

    @Override
    @Context(type=ContextType.ECITIZEN_AGENT, privilege=ContextPrivilege.NONE)
    @RequestFilter(privilege=ContextPrivilege.READ)
    public Long getCount(Set<Critere> criteriaSet) throws CvqException {

        return requestDAO.count(criteriaSet);
    }

    @Override
    @Context(type=ContextType.ECITIZEN_AGENT,privilege=ContextPrivilege.READ)
    public Request getById(final Long id)
        throws CvqException, CvqObjectNotFoundException {
        return (Request) requestDAO.findById(Request.class, id);
    }

    @Override
    @Context(type=ContextType.ECITIZEN_AGENT,privilege=ContextPrivilege.READ)
    public List<Request> getByRequesterId(final Long requesterId)
        throws CvqException {

        return requestDAO.listByRequester(requesterId);
    }

    @Override
    @Context(type=ContextType.ECITIZEN_AGENT,privilege=ContextPrivilege.READ)
    public List<Request> getBySubjectId(final Long subjectId)
        throws CvqException, CvqObjectNotFoundException {

        return requestDAO.listBySubject(subjectId);
    }

    @Override
    @Context(type=ContextType.ECITIZEN_AGENT,privilege=ContextPrivilege.READ)
    public List<Request> getBySubjectIdAndRequestLabel(final Long subjectId, 
            final String requestLabel, boolean retrieveArchived)
        throws CvqException, CvqObjectNotFoundException {

        if (requestLabel == null)
            throw new CvqModelException("request.label_required");

        RequestState[] excludedStates = null;
        if (!retrieveArchived)
            excludedStates = new RequestState[] { RequestState.ARCHIVED };

        return requestDAO.listBySubjectAndLabel(subjectId, requestLabel, excludedStates);
    }

    @Override
    @Context(type=ContextType.ECITIZEN_AGENT,privilege=ContextPrivilege.READ)
    public List<Request> getByHomeFolderId(final Long homeFolderId) throws CvqException {

        return requestDAO.listByHomeFolder(homeFolderId);
    }

    @Override
    @Context(type=ContextType.ECITIZEN_AGENT,privilege=ContextPrivilege.READ)
    public List<Request> getByHomeFolderIdAndRequestLabel(final Long homeFolderId, 
            final String requestLabel)
        throws CvqException, CvqObjectNotFoundException {

        return requestDAO.listByHomeFolderAndLabel(homeFolderId, requestLabel, null);
    }

    @Override
    @Context(type=ContextType.ECITIZEN_AGENT,privilege=ContextPrivilege.READ)
    public byte[] getCertificate(final Long id, final RequestState requestState)
        throws CvqException {
        Set<Critere> criteriaSet = new HashSet<Critere>();
        criteriaSet.add(new Critere(RequestAction.SEARCH_BY_REQUEST_ID,
            id, Critere.EQUALS));
        criteriaSet.add(new Critere(RequestAction.SEARCH_BY_RESULTING_STATE,
            requestState, Critere.EQUALS));
        List<RequestAction> action =
            requestActionDAO.get(criteriaSet, RequestAction.SEARCH_BY_DATE,
                "desc", 1, 0);
        return !action.isEmpty() ? action.get(0).getFile() : null;
    }

    @Override
    @Context(type=ContextType.ECITIZEN_AGENT,privilege=ContextPrivilege.READ)
    public byte[] getCertificate(final Long requestId)
        throws CvqException {
        byte[] data = getCertificate(requestId, RequestState.VALIDATED);
        return data != null ? data :
            getCertificate(requestId, RequestState.PENDING);
    }

    public void setRequestDAO(IRequestDAO requestDAO) {
        this.requestDAO = requestDAO;
    }

    public void setRequestActionDAO(IRequestActionDAO requestActionDAO) {
        this.requestActionDAO = requestActionDAO;
    }
}
