package fr.cg95.cvq.service.document;

import org.springframework.beans.factory.annotation.Autowired;

import fr.cg95.cvq.service.document.IDocumentService;
import fr.cg95.cvq.service.document.IDocumentTypeService;
import fr.cg95.cvq.testtool.ServiceTestCase;

public class DocumentTestCase extends ServiceTestCase {

    @Autowired
    protected IDocumentService documentService;
    @Autowired
    protected IDocumentTypeService documentTypeService;
}
