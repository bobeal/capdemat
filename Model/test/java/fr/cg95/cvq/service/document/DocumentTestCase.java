package fr.cg95.cvq.service.document;

import fr.cg95.cvq.service.document.IDocumentService;
import fr.cg95.cvq.service.document.IDocumentTypeService;
import fr.cg95.cvq.testtool.ServiceTestCase;

public class DocumentTestCase extends ServiceTestCase {

    protected IDocumentService documentService;
    protected IDocumentTypeService documentTypeService;

    public void setDocumentService(IDocumentService documentService) {
        this.documentService = documentService;
    }
    
    public void setDocumentTypeService(IDocumentTypeService documentTypeService) {
        this.documentTypeService = documentTypeService;
    }
}
