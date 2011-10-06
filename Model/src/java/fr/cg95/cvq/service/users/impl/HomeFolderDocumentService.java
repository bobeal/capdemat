package fr.cg95.cvq.service.users.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import fr.cg95.cvq.business.document.Document;
import fr.cg95.cvq.business.document.DocumentType;
import fr.cg95.cvq.business.users.GlobalHomeFolderConfiguration;
import fr.cg95.cvq.business.users.HomeFolder;
import fr.cg95.cvq.dao.document.IDocumentDAO;
import fr.cg95.cvq.dao.document.IDocumentTypeDAO;
import fr.cg95.cvq.dao.jpa.IGenericDAO;
import fr.cg95.cvq.dao.users.IHomeFolderDAO;
import fr.cg95.cvq.security.annotation.Context;
import fr.cg95.cvq.security.annotation.ContextPrivilege;
import fr.cg95.cvq.security.annotation.ContextType;
import fr.cg95.cvq.service.users.IHomeFolderDocumentService;

public class HomeFolderDocumentService implements IHomeFolderDocumentService {

    private IHomeFolderDAO homeFolderDAO;
    private IDocumentDAO documentDAO;
    private IGenericDAO genericDAO;
    private IDocumentTypeDAO documentTypeDAO;

    public void setHomeFolderDAO(IHomeFolderDAO homeFolderDAO) {
        this.homeFolderDAO = homeFolderDAO;
    }

    public void setDocumentDAO(IDocumentDAO documentDAO) {
        this.documentDAO = documentDAO;
    }

    public void setGenericDAO(IGenericDAO genericDAO) {
        this.genericDAO = genericDAO;
    }

    public void setDocumentTypeDAO(IDocumentTypeDAO documentTypeDAO) {
        this.documentTypeDAO = documentTypeDAO;
    }

    @Override
    @Context(types = {ContextType.ECITIZEN, ContextType.AGENT}, privilege = ContextPrivilege.WRITE)
    public void link(Long homeFolderId, Long documentId) {
        link(homeFolderDAO.findById(homeFolderId), documentId);
    }

    @Override
    @Context(types = {ContextType.ECITIZEN, ContextType.AGENT}, privilege = ContextPrivilege.WRITE)
    public void link(HomeFolder homeFolder, Long documentId) {
        Document document = documentDAO.findById(documentId);
        if (document != null && homeFolder != null) {
            if (document.getLinkedHomeFolder() != homeFolder) {
                document.setLinkedHomeFolder(homeFolder);
            }
            documentDAO.update(document);
        }
    }

    @Override
    @Context(types = {ContextType.ECITIZEN, ContextType.AGENT}, privilege = ContextPrivilege.WRITE)
    public void unlink(Long homeFolderId, Long documentId) {
        unlink(homeFolderDAO.findById(homeFolderId), documentId);
    }

    @Override
    @Context(types = {ContextType.ECITIZEN, ContextType.AGENT}, privilege = ContextPrivilege.WRITE)
    public void unlink(HomeFolder homeFolder, Long documentId) {
        Document document = documentDAO.findById(documentId);
        if (document != null && homeFolder != null) {
            document.setLinkedHomeFolder(null);
            documentDAO.update(document);
        }
    }

    @Override
    @Context(types = {ContextType.ECITIZEN, ContextType.AGENT}, privilege = ContextPrivilege.READ)
    public List<Document> documentsLinkedToHomeFolder(Long homeFolderId, DocumentType documentType) {
        if (homeFolderId == null)
            return new ArrayList<Document>();
        return documentDAO.linkedToHomeFolder(homeFolderDAO.findById(homeFolderId), documentType);
    }

    private GlobalHomeFolderConfiguration getGlobalHomeFolderConfiguration() {
        GlobalHomeFolderConfiguration conf =
            genericDAO.simpleSelect(GlobalHomeFolderConfiguration.class).unique();

        return (conf != null) ? conf : new GlobalHomeFolderConfiguration();
    }

    @Override
    @Context(types = {ContextType.AGENT}, privilege = ContextPrivilege.MANAGE)
    public void wish(Long documentTypeId) {
        GlobalHomeFolderConfiguration conf = getGlobalHomeFolderConfiguration();

        Set<DocumentType> wished = conf.getWishedDocumentTypes();
        wished.add(documentTypeDAO.findById(documentTypeId));
        conf.setWishedDocumentTypes(wished);

        genericDAO.update(conf);
    }

    @Override
    @Context(types = {ContextType.AGENT}, privilege = ContextPrivilege.MANAGE)
    public void unwish(Long documentTypeId) {
        GlobalHomeFolderConfiguration conf = getGlobalHomeFolderConfiguration();

        Set<DocumentType> wished = conf.getWishedDocumentTypes();
        wished.remove(documentTypeDAO.findById(documentTypeId));
        conf.setWishedDocumentTypes(wished);

        genericDAO.update(conf);
    }

    @Override
    public Set<DocumentType> wishedDocumentTypes() {
        return getGlobalHomeFolderConfiguration().getWishedDocumentTypes();
    }
}
