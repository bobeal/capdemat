package fr.cg95.cvq.service.document;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import fr.cg95.cvq.business.document.DepositOrigin;
import fr.cg95.cvq.business.document.DepositType;
import fr.cg95.cvq.business.document.Document;
import fr.cg95.cvq.business.document.DocumentBinary;
import fr.cg95.cvq.business.document.DocumentType;
import fr.cg95.cvq.business.request.RequestDocument;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.exception.CvqObjectNotFoundException;
import fr.cg95.cvq.service.document.IDocumentService;
import fr.cg95.cvq.service.document.IDocumentTypeService;
import fr.cg95.cvq.testtool.ServiceTestCase;

public class DocumentTestCase extends ServiceTestCase {

    @Autowired
    protected IDocumentService documentService;
    @Autowired
    protected IDocumentTypeService documentTypeService;
        
    public Long gimmeImageDocument() 
        throws CvqObjectNotFoundException, CvqException, IOException {
        DocumentType docType = documentTypeService.getDocumentTypeByType(documentTypeService.OLD_CNI_TYPE);
        Document document = new Document(null, null, docType, null);
        
        Long docId = documentService.create(document);
        
        DocumentBinary docBin = new DocumentBinary();
        File fileJpg = getResourceFile("health_notebook.jpg");
        byte[] dataJpg = new byte[(int) fileJpg.length()];
        FileInputStream fis = new FileInputStream(fileJpg);
        fis.read(dataJpg);
        docBin.setData(dataJpg);
        documentService.addPage(docId, docBin);
        
        docBin = new DocumentBinary();
        docBin.setData(dataJpg);
        documentService.addPage(docId, docBin);
        
        return docId;
    }
    
    public Long gimmePdfDocument() 
    throws CvqObjectNotFoundException, CvqException, IOException {
    DocumentType docType = documentTypeService.getDocumentTypeByType(documentTypeService.OLD_CNI_TYPE);
    Document document = new Document(null, null, docType, null);
    
    Long docId = documentService.create(document);
    
    DocumentBinary docBin = new DocumentBinary();
    File fileJpg = getResourceFile("test.pdf");
    byte[] dataJpg = new byte[(int) fileJpg.length()];
    FileInputStream fis = new FileInputStream(fileJpg);
    fis.read(dataJpg);
    docBin.setData(dataJpg);
    documentService.addPage(docId, docBin);
    
    return docId;
}
}
