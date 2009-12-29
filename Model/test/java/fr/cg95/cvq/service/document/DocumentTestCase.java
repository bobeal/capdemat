package fr.cg95.cvq.service.document;

import fr.cg95.cvq.service.document.IDocumentService;
import fr.cg95.cvq.service.document.IDocumentTypeService;
import fr.cg95.cvq.testtool.ServiceTestCase;

public class DocumentTestCase extends ServiceTestCase {

    protected static IDocumentService iDocumentService;
    protected static IDocumentTypeService iDocumentTypeService;

    public void setDocumentService(IDocumentService documentService) {
        iDocumentService = documentService;
    }
    
    public void setDocumentTypeService(IDocumentTypeService documentTypeService) {
        iDocumentTypeService = documentTypeService;
    }
}
