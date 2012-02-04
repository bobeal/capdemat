package fr.cg95.cvq.service.request.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipArchiveOutputStream;
import org.apache.commons.compress.archivers.zip.ZipArchiveOutputStream.UnicodeExtraFieldPolicy;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;

import fr.cg95.cvq.business.authority.LocalAuthorityResource;
import fr.cg95.cvq.business.request.Request;
import fr.cg95.cvq.business.request.RequestAction;
import fr.cg95.cvq.business.request.RequestAdminAction;
import fr.cg95.cvq.business.request.RequestState;
import fr.cg95.cvq.dao.jpa.IGenericDAO;
import fr.cg95.cvq.dao.request.IRequestDAO;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.exception.CvqObjectNotFoundException;
import fr.cg95.cvq.security.annotation.Context;
import fr.cg95.cvq.security.annotation.ContextPrivilege;
import fr.cg95.cvq.security.annotation.ContextType;
import fr.cg95.cvq.service.authority.ILocalAuthorityRegistry;
import fr.cg95.cvq.service.request.IRequestSearchService;
import fr.cg95.cvq.service.request.annotation.RequestFilter;
import fr.cg95.cvq.util.Critere;

public class RequestSearchService implements IRequestSearchService, BeanFactoryAware {

    private BeanFactory beanFactory;
    private ILocalAuthorityRegistry localAuthorityRegistry;
    private IRequestDAO requestDAO;
    private IGenericDAO genericDAO;

    @Override
    @Context(types = {ContextType.ECITIZEN, ContextType.AGENT}, privilege = ContextPrivilege.NONE)
    @RequestFilter(privilege=ContextPrivilege.READ)
    public List<Request> get(Set<Critere> criteriaSet, final String sort, final String dir,
            final int recordsReturned, final int startIndex, final boolean full)
        throws CvqException {

        return requestDAO.search(criteriaSet, sort, dir, recordsReturned, startIndex, full);
    }

    @Override
    @Context(types = {ContextType.ECITIZEN, ContextType.AGENT}, privilege = ContextPrivilege.NONE)
    @RequestFilter(privilege=ContextPrivilege.READ)
    public Long getCount(Set<Critere> criteriaSet) throws CvqException {

        return requestDAO.count(criteriaSet);
    }

    @Override
    @Context(types = {ContextType.ECITIZEN, ContextType.AGENT, ContextType.EXTERNAL_SERVICE},
            privilege = ContextPrivilege.READ)
    public Request getById(final Long id, final boolean full) {
        return requestDAO.findById(id, full);
    }

    @Override
    @Context(types = {ContextType.ECITIZEN, ContextType.AGENT}, privilege = ContextPrivilege.READ)
    public List<Request> getByHomeFolderId(final Long homeFolderId, final boolean full) {

        return requestDAO.listByHomeFolder(homeFolderId, full);
    }

    @Override
    @Context(types = {ContextType.ECITIZEN, ContextType.AGENT}, privilege = ContextPrivilege.READ)
    public List<Request> getByHomeFolderIdAndRequestLabel(final Long homeFolderId, 
        final String requestLabel, final boolean full)
        throws CvqException, CvqObjectNotFoundException {

        return requestDAO.listByHomeFolderAndLabel(homeFolderId, requestLabel, null, full);
    }

    @Override
    @Context(types = {ContextType.ECITIZEN, ContextType.AGENT}, privilege = ContextPrivilege.READ)
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
    @Context(types = {ContextType.ECITIZEN, ContextType.AGENT, ContextType.EXTERNAL_SERVICE},
            privilege = ContextPrivilege.READ)
    public byte[] getCertificate(final Long requestId) throws CvqException {
        byte[] data = getCertificate(requestId, RequestState.VALIDATED);
        return data != null ? data : getCertificate(requestId, RequestState.PENDING);
    }

    @Override
    @Context(types = {ContextType.ADMIN}, privilege = ContextPrivilege.READ)
    public File getArchives(List<String> names) throws IOException {
        File result = null;
        if (names.size() == 1) {
            result = localAuthorityRegistry.getLocalAuthorityResourceFile(
                LocalAuthorityResource.Type.REQUEST_ARCHIVE, names.get(0), false);
        } else {
            result = File.createTempFile("archives", "zip");
            ZipArchiveOutputStream zipStream = new ZipArchiveOutputStream(result);
            zipStream.setEncoding("UTF8");
            zipStream.setUseLanguageEncodingFlag(true);
            zipStream.setCreateUnicodeExtraFields(UnicodeExtraFieldPolicy.ALWAYS);
            zipStream.setFallbackToUTF8(true);
            for (String name : names) {
                FileInputStream archive = new FileInputStream(
                    localAuthorityRegistry.getLocalAuthorityResourceFile(
                        LocalAuthorityResource.Type.REQUEST_ARCHIVE, name, false));
                ZipArchiveEntry entry = new ZipArchiveEntry(name);
                zipStream.putArchiveEntry(entry);
                byte buf[] = new byte[1024*1024];
                int n;
                while ((n = archive.read(buf)) > -1) {
                    zipStream.write(buf, 0, n);
                }
                zipStream.closeArchiveEntry();
            }
            zipStream.close();
        }
        RequestAdminAction action =
            new RequestAdminAction(RequestAdminAction.Type.ARCHIVES_DOWNLOADED);
        action.getComplementaryData().put(RequestAdminAction.Data.ARCHIVE_NAMES,
            new ArrayList<String>(names));
        genericDAO.saveOrUpdate(action);
        return result;
    }

    @Override
    @Context(types = {ContextType.ADMIN}, privilege = ContextPrivilege.WRITE)
    public List<String> deleteArchives(List<String> names) {
        ArrayList<String> deleted = new ArrayList<String>();
        List<String> failures = new ArrayList<String>();
        for (String name : names) {
            if (localAuthorityRegistry.getLocalAuthorityResourceFile(
                LocalAuthorityResource.Type.REQUEST_ARCHIVE, name, false).delete()) {
                deleted.add(name);
            } else {
                failures.add(name);
            }
        }
        if (!deleted.isEmpty()) {
            RequestAdminAction action =
                new RequestAdminAction(RequestAdminAction.Type.ARCHIVES_DELETED);
            action.getComplementaryData().put(RequestAdminAction.Data.ARCHIVE_NAMES, deleted);
            genericDAO.saveOrUpdate(action);
        }
        return failures;
    }

    public void setRequestDAO(IRequestDAO requestDAO) {
        this.requestDAO = requestDAO;
    }

    public void setGenericDAO(IGenericDAO genericDAO) {
        this.genericDAO = genericDAO;
    }

    public void setLocalAuthorityRegistry(ILocalAuthorityRegistry localAuthorityRegistry) {
        this.localAuthorityRegistry = localAuthorityRegistry;
    }

    @Override
    @Context(types = {ContextType.AGENT}, privilege = ContextPrivilege.READ)
    public List<Request> listTasks(String qoS, String sortBy, int max) throws CvqException {
        // FIXME JSB : hack to avoid bypassing aspect security
        return ((IRequestSearchService)beanFactory.getBean("requestSearchService")).get(composeTasksCriteria(qoS), sortBy, null, max, 0, false);
    }

    @Override
    @Context(types = {ContextType.AGENT}, privilege = ContextPrivilege.READ)
    public Long countTasks(final String qoS) throws CvqException {
        // FIXME JSB : hack to avoid bypassing aspect security
        return ((IRequestSearchService) beanFactory.getBean("requestSearchService")).getCount(composeTasksCriteria(qoS));
    }
    
    private Set<Critere> composeTasksCriteria(final String qoS) {
        Set<Critere> criteria = new HashSet<Critere>(2);

        Critere criterion = new Critere();
        criterion.setComparatif(Critere.IN);
        criterion.setAttribut(Request.SEARCH_BY_STATE);

        Set<RequestState> states = new HashSet<RequestState>(3);
        states.add(RequestState.PENDING);
        states.add(RequestState.INPROGRESS);
        states.add(RequestState.RECTIFIED);
        criterion.setValue(states);

        criteria.add(criterion);

        criterion = new Critere();
        criterion.setComparatif(Critere.EQUALS);
        criterion.setAttribut(Request.SEARCH_BY_QUALITY_TYPE);
        criterion.setValue(qoS);
        criteria.add(criterion);

        return criteria;
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory)
        throws BeansException {
        this.beanFactory = beanFactory;
    }

    @Override
    public List<Request> find(String query, Object... params) {
        return find(true, query, params);
    }

    @Override
    public List<Request> find(final Boolean full, String query, Object... params) {
        return requestDAO.find(full, query, params);
    }
}
