package fr.cg95.cvq.service.document.impl;

import java.util.List;

import org.apache.log4j.Logger;

import fr.cg95.cvq.business.document.DocumentType;
import fr.cg95.cvq.dao.document.IDocumentTypeDAO;
import fr.cg95.cvq.exception.CvqObjectNotFoundException;
import fr.cg95.cvq.security.SecurityContext;
import fr.cg95.cvq.security.annotation.Context;
import fr.cg95.cvq.security.annotation.ContextType;
import fr.cg95.cvq.service.authority.ILocalAuthorityLifecycleAware;
import fr.cg95.cvq.service.authority.ILocalAuthorityRegistry;
import fr.cg95.cvq.service.document.IDocumentTypeService;

public class DocumentTypeService
    implements IDocumentTypeService, ILocalAuthorityLifecycleAware {

    static Logger logger = Logger.getLogger(DocumentTypeService.class);

    protected IDocumentTypeDAO documentTypeDAO;
    protected ILocalAuthorityRegistry localAuthorityRegistry;

    private Boolean performDbUpdates;
    private DocumentBootstrapper documentBootstrapper;

    @Context(type=ContextType.SUPER_ADMIN)
    private void initSampleDocumentTypes() {
        logger.debug("initSampleDocumentTypes() init for " 
            + SecurityContext.getCurrentSite().getName());
        documentBootstrapper.bootstrapForCurrentLocalAuthority();
    }

    @Override
    @Context(type=ContextType.SUPER_ADMIN)
    public void addLocalAuthority(String localAuthorityName) {
        if (performDbUpdates) initSampleDocumentTypes();
    }

    @Override
    @Context(type=ContextType.SUPER_ADMIN)
    public void removeLocalAuthority(String localAuthorityName) {
    }

    @Override
    public DocumentType getDocumentTypeByType(final Integer id) {
        return documentTypeDAO.findByType(id);
    }

    @Override
    public DocumentType getDocumentTypeById(Long id)
        throws CvqObjectNotFoundException {
        return (DocumentType) documentTypeDAO.findById(DocumentType.class, id);
    }

    @Override
    public List<DocumentType> getAllDocumentTypes() {
        return documentTypeDAO.listAll();
    }

    public void setDocumentTypeDAO(final IDocumentTypeDAO documentTypeDAO) {
        this.documentTypeDAO = documentTypeDAO;
    }
    
    public void setLocalAuthorityRegistry(ILocalAuthorityRegistry localAuthorityRegistry) {
        this.localAuthorityRegistry = localAuthorityRegistry;
    }

    public void setPerformDbUpdates(Boolean performDbUpdates) {
        if (performDbUpdates != null)
            this.performDbUpdates = performDbUpdates;
        else
            this.performDbUpdates = Boolean.FALSE;
    }

    public void setDocumentBootstrapper(DocumentBootstrapper documentBootstrapper) {
        this.documentBootstrapper = documentBootstrapper;
    }
}
