package fr.cg95.cvq.service.document.impl;

import java.util.List;

import org.apache.log4j.Logger;

import fr.cg95.cvq.business.document.DocumentType;
import fr.cg95.cvq.dao.document.IDocumentTypeDAO;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.exception.CvqObjectNotFoundException;
import fr.cg95.cvq.service.authority.ILocalAuthorityLifecycleAware;
import fr.cg95.cvq.service.authority.ILocalAuthorityRegistry;
import fr.cg95.cvq.service.document.IDocumentTypeService;

public class DocumentTypeService implements IDocumentTypeService, ILocalAuthorityLifecycleAware {

    static Logger logger = Logger.getLogger(DocumentTypeService.class);

    protected IDocumentTypeDAO documentTypeDAO;
    protected ILocalAuthorityRegistry localAuthorityRegistry;
    
    private Boolean performDbUpdates;
    private DocumentBootstrapper documentBootstrapper;
    
    public void initSampleDocumentTypes(final String localAuthorityName) 
        throws CvqException {
        logger.debug("initSampleDocumentTypes() init for " + localAuthorityName);
        documentBootstrapper.bootstrapForCurrentLocalAuthority();
    }

    public void addLocalAuthority(String localAuthorityName) {
        if (performDbUpdates)
            localAuthorityRegistry.callback(localAuthorityName, this, "initSampleDocumentTypes", null);
    }

    public void removeLocalAuthority(String localAuthorityName) {
    }

    @Override
    public DocumentType getDocumentTypeById(final Integer id)
        throws CvqException, CvqObjectNotFoundException {

        return documentTypeDAO.findByType(id);
    }

    @Override
    public List<DocumentType> getAllDocumentTypes()
        throws CvqException {

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
