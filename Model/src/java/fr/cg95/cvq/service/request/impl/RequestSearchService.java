package fr.cg95.cvq.service.request.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import fr.cg95.cvq.business.request.Request;
import fr.cg95.cvq.business.request.RequestAction;
import fr.cg95.cvq.business.request.RequestState;
import fr.cg95.cvq.dao.request.IRequestDAO;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.exception.CvqObjectNotFoundException;
import fr.cg95.cvq.security.annotation.Context;
import fr.cg95.cvq.security.annotation.ContextPrivilege;
import fr.cg95.cvq.security.annotation.ContextType;
import fr.cg95.cvq.service.request.IRequestSearchService;
import fr.cg95.cvq.service.request.annotation.RequestFilter;
import fr.cg95.cvq.util.Critere;

public class RequestSearchService implements IRequestSearchService {

    private IRequestDAO requestDAO;

    @Override
    @Context(type=ContextType.ECITIZEN_AGENT, privilege=ContextPrivilege.NONE)
    @RequestFilter(privilege=ContextPrivilege.READ)
    public List<Request> get(Set<Critere> criteriaSet, final String sort, final String dir,
            final int recordsReturned, final int startIndex, final boolean full)
        throws CvqException {

        return requestDAO.search(criteriaSet, sort, dir, recordsReturned, startIndex, full);
    }

    @Override
    @Context(type=ContextType.ECITIZEN_AGENT, privilege=ContextPrivilege.NONE)
    @RequestFilter(privilege=ContextPrivilege.READ)
    public Long getCount(Set<Critere> criteriaSet) throws CvqException {

        return requestDAO.count(criteriaSet);
    }

    @Override
    @Context(type=ContextType.ECITIZEN_AGENT,privilege=ContextPrivilege.READ)
    public Request getById(final Long id, final boolean full)
        throws CvqException, CvqObjectNotFoundException {
        return requestDAO.findById(id, full);
    }

    @Override
    @Context(type=ContextType.ECITIZEN_AGENT,privilege=ContextPrivilege.READ)
    public List<Request> getByHomeFolderId(final Long homeFolderId, final boolean full) throws CvqException {

        return requestDAO.listByHomeFolder(homeFolderId, full);
    }

    @Override
    @Context(type=ContextType.ECITIZEN_AGENT,privilege=ContextPrivilege.READ)
    public List<Request> getByHomeFolderIdAndRequestLabel(final Long homeFolderId, 
        final String requestLabel, final boolean full)
        throws CvqException, CvqObjectNotFoundException {

        return requestDAO.listByHomeFolderAndLabel(homeFolderId, requestLabel, null, full);
    }

    @Override
    @Context(type=ContextType.ECITIZEN_AGENT,privilege=ContextPrivilege.READ)
    public byte[] getCertificate(final Long id, final RequestState requestState)
        throws CvqException {
        List<RequestAction> actions = new ArrayList<RequestAction>(getById(id, false).getActions());
        Collections.reverse(actions);
        for (RequestAction action : actions) {
            if (requestState.equals(action.getResultingState()))
                return action.getFile();
        }
        return null;
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
}
