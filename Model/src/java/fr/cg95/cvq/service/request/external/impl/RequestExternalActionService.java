package fr.cg95.cvq.service.request.external.impl;

import java.util.Date;
import java.util.List;
import java.util.Set;

import fr.cg95.cvq.business.request.external.RequestExternalAction;
import fr.cg95.cvq.dao.request.external.IRequestExternalActionDAO;
import fr.cg95.cvq.security.annotation.Context;
import fr.cg95.cvq.security.annotation.ContextPrivilege;
import fr.cg95.cvq.security.annotation.ContextType;
import fr.cg95.cvq.service.request.annotation.RequestFilter;
import fr.cg95.cvq.service.request.external.IRequestExternalActionService;
import fr.cg95.cvq.util.Critere;

public class RequestExternalActionService implements IRequestExternalActionService {

    private IRequestExternalActionDAO requestExternalActionDAO;

    @Override
    @Context(types = {ContextType.AGENT}, privilege = ContextPrivilege.WRITE)
    public Long addTrace(RequestExternalAction trace) {
        trace.setDate(new Date());
        return requestExternalActionDAO.create(trace);
    }

    @Override
    @Context(types = {ContextType.ECITIZEN, ContextType.AGENT}, privilege = ContextPrivilege.READ)
    public List<RequestExternalAction> getTraces(Set<Critere> criteriaSet,
        String sort, String dir, int count, int offset) {
        return requestExternalActionDAO.get(criteriaSet, sort, dir, count, offset, false);
    }

    @Override
    @Context(types = {ContextType.ECITIZEN, ContextType.AGENT}, privilege = ContextPrivilege.READ)
    public Long getTracesCount(Set<Critere> criteriaSet) {
        return requestExternalActionDAO.getCount(criteriaSet, false);
    }

    @Override
    @Context(types = {ContextType.ECITIZEN, ContextType.AGENT}, privilege = ContextPrivilege.READ)
    public List<RequestExternalAction> getLastTraces(Set<Critere> criteriaSet,
        String sort, String dir, int count, int offset) {
        return requestExternalActionDAO.get(criteriaSet, sort, dir, count, offset, true);
    }

    @Override
    @Context(types = {ContextType.ECITIZEN, ContextType.AGENT}, privilege = ContextPrivilege.READ)
    public Long getLastTracesCount(Set<Critere> criteriaSet) {
        return requestExternalActionDAO.getCount(criteriaSet, true);
    }

    @Override
    @Context(types = {ContextType.AGENT}, privilege = ContextPrivilege.MANAGE)
    public List<String> getKeys(Set<Critere> criterias) {
        return requestExternalActionDAO.getKeys(criterias);
    }

    public void setRequestExternalActionDAO(IRequestExternalActionDAO requestExternalActionDAO) {
        this.requestExternalActionDAO = requestExternalActionDAO;
    }

}
