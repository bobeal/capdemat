package fr.cg95.cvq.service.users.external.impl;

import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import fr.cg95.cvq.business.users.external.HomeFolderMapping;
import fr.cg95.cvq.business.users.external.IndividualMapping;
import fr.cg95.cvq.dao.users.external.IExternalHomeFolderDAO;
import fr.cg95.cvq.exception.CvqModelException;
import fr.cg95.cvq.security.annotation.Context;
import fr.cg95.cvq.security.annotation.ContextPrivilege;
import fr.cg95.cvq.security.annotation.ContextType;
import fr.cg95.cvq.service.users.external.IExternalHomeFolderService;

public class ExternalHomeFolderService implements IExternalHomeFolderService {

    private IExternalHomeFolderDAO externalHomeFolderDAO;

    @Override
    public void createHomeFolderMapping(HomeFolderMapping homeFolderMapping)
            throws CvqModelException {
        externalHomeFolderDAO.create(homeFolderMapping);
    }

    @Override
    public void modifyHomeFolderMapping(HomeFolderMapping homeFolderMapping)
            throws CvqModelException {
        externalHomeFolderDAO.update(homeFolderMapping);
    }

    @Override
    @Context(types = {ContextType.ECITIZEN, ContextType.AGENT}, privilege = ContextPrivilege.READ)
    public HomeFolderMapping
        getHomeFolderMapping(String externalServiceLabel, Long homeFolderId) {
        return externalHomeFolderDAO
            .findHomeFolderMappingBy(externalServiceLabel, homeFolderId);
    }

    @Override
    @Context(types = {ContextType.ECITIZEN, ContextType.AGENT}, privilege = ContextPrivilege.READ)
    public HomeFolderMapping
        getHomeFolderMapping(String externalServiceLabel, String externalCapdematId) {
        return externalHomeFolderDAO.findHomeFolderMappingBy(externalServiceLabel, externalCapdematId);
    }

    @Override
    @Context(types = {ContextType.ECITIZEN, ContextType.AGENT}, privilege = ContextPrivilege.WRITE)
    public List<HomeFolderMapping> getHomeFolderMappings(Long homeFolderId) {
        return externalHomeFolderDAO.findBySimpleProperty(HomeFolderMapping.class, "homeFolderId", homeFolderId);
    }

    @Override
    @Context(types = {ContextType.AGENT}, privilege = ContextPrivilege.WRITE)
    public void setExternalId(String externalServiceLabel, Long homeFolderId, Long individualId, 
            String externalId) {
        HomeFolderMapping identifierMapping = 
            getHomeFolderMapping(externalServiceLabel, homeFolderId);
        
        if (identifierMapping.getIndividualsMappings() == null) {
            identifierMapping.addIndividualMapping(individualId, UUID.randomUUID().toString(), externalId);
        } else {
            Iterator<IndividualMapping> it = 
                identifierMapping.getIndividualsMappings().iterator();
            IndividualMapping newMapping = 
                new IndividualMapping(individualId, UUID.randomUUID().toString(), externalId);
            while (it.hasNext()) {
                IndividualMapping esim = it.next();
                if (esim.getIndividualId().equals(individualId)) {
                    newMapping.setExternalCapDematId(esim.getExternalCapDematId());
                    it.remove();
                    break;
                }
            }
            identifierMapping.getIndividualsMappings().add(newMapping);
        }
        externalHomeFolderDAO.update(identifierMapping);
    }

    @Override
    @Context(types = {ContextType.AGENT}, privilege = ContextPrivilege.WRITE)
    public void addHomeFolderMapping(String externalServiceLabel, Long homeFolderId,
            String externalId) {

        HomeFolderMapping esim =
            getHomeFolderMapping(externalServiceLabel, homeFolderId);
        if (esim == null) {
            esim = new HomeFolderMapping();
            esim.setExternalServiceLabel(externalServiceLabel);
            esim.setHomeFolderId(homeFolderId);
            esim.setExternalCapDematId(UUID.randomUUID().toString());
        }

        esim.setExternalId(externalId);

        externalHomeFolderDAO.create(esim);
    }

    @Override
    @Context(types = {ContextType.AGENT}, privilege = ContextPrivilege.WRITE)
    public void deleteHomeFolderMappings(final String externalServiceLabel, final Long homeFolderId) {
        HomeFolderMapping esim = getHomeFolderMapping(externalServiceLabel, homeFolderId);
        externalHomeFolderDAO.delete(esim);
    }

    public void setExternalHomeFolderDAO(IExternalHomeFolderDAO externalHomeFolderDAO) {
        this.externalHomeFolderDAO = externalHomeFolderDAO;
    }

}
