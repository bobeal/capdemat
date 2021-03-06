package fr.cg95.cvq.service.document.impl;

import java.util.List;

import org.apache.log4j.Logger;

import fr.cg95.cvq.business.document.DocumentType;
import fr.cg95.cvq.dao.document.IDocumentTypeDAO;
import fr.cg95.cvq.security.SecurityContext;
import fr.cg95.cvq.security.annotation.Context;
import fr.cg95.cvq.security.annotation.ContextType;
import fr.cg95.cvq.service.authority.ILocalAuthorityLifecycleAware;
import fr.cg95.cvq.service.document.IDocumentTypeService;

public class DocumentTypeService
    implements IDocumentTypeService, ILocalAuthorityLifecycleAware {

    static Logger logger = Logger.getLogger(DocumentTypeService.class);

    protected IDocumentTypeDAO documentTypeDAO;

    private DocumentBootstrapper documentBootstrapper;

    @Context(types = {ContextType.SUPER_ADMIN})
    private void initSampleDocumentTypes() {
        logger.debug("initSampleDocumentTypes() init for " 
            + SecurityContext.getCurrentSite().getName());
        documentBootstrapper.bootstrapForCurrentLocalAuthority();
    }

    @Override
    @Context(types = {ContextType.SUPER_ADMIN})
    public void addLocalAuthority(String localAuthorityName) {
        initSampleDocumentTypes();
    }

    @Override
    @Context(types = {ContextType.SUPER_ADMIN})
    public void removeLocalAuthority(String localAuthorityName) {
    }

    @Override
    public DocumentType getDocumentTypeByType(final Integer id) {
        return documentTypeDAO.findByType(id);
    }

    @Override
    public DocumentType getDocumentTypeById(Long id) {
        return documentTypeDAO.findById(id);
    }

    @Override
    public List<DocumentType> getAllDocumentTypes() {
        return documentTypeDAO.listAll();
    }

    public void setDocumentTypeDAO(final IDocumentTypeDAO documentTypeDAO) {
        this.documentTypeDAO = documentTypeDAO;
    }
    
    public void setDocumentBootstrapper(DocumentBootstrapper documentBootstrapper) {
        this.documentBootstrapper = documentBootstrapper;
    }
}
