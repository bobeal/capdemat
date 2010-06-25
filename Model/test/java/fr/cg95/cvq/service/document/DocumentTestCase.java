package fr.cg95.cvq.service.document;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;

import fr.cg95.cvq.business.document.Document;
import fr.cg95.cvq.business.document.DocumentBinary;
import fr.cg95.cvq.business.document.DocumentType;
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
        DocumentType docType = documentTypeService.getDocumentTypeByType(IDocumentTypeService.OLD_CNI_TYPE);
        Document document = new Document(null, null, docType, null);
        
        Long docId = documentService.create(document);
        
        DocumentBinary docBin = getImageDocumentBinary();
        documentService.addPage(docId, docBin);
        
        docBin = getImageDocumentBinary();
        documentService.addPage(docId, docBin);
        
        return docId;
    }
    
    public Long gimmePdfDocument() 
        throws CvqObjectNotFoundException, CvqException, IOException {
        DocumentType docType = documentTypeService.getDocumentTypeByType(IDocumentTypeService.OLD_CNI_TYPE);
        Document document = new Document(null, null, docType, null);

        Long docId = documentService.create(document);

        DocumentBinary docBin = getPdfDocumentBinary();
        documentService.addPage(docId, docBin);

        return docId;
    }
    
    public DocumentBinary getImageDocumentBinary() 
        throws IOException {
        DocumentBinary docBin = new DocumentBinary();
        File fileJpg = getResourceFile("test.jpg");
        byte[] dataJpg = new byte[(int) fileJpg.length()];
        FileInputStream fis = new FileInputStream(fileJpg);
        fis.read(dataJpg);
        docBin.setData(dataJpg);
        return docBin;
    }
    
    public DocumentBinary getPdfDocumentBinary() 
        throws IOException {
        DocumentBinary docBin = new DocumentBinary();
        File filePdf = getResourceFile("test.pdf");
        byte[] dataPdf = new byte[(int) filePdf.length()];
        FileInputStream fis = new FileInputStream(filePdf);
        fis.read(dataPdf);
        docBin.setData(dataPdf);
        return docBin;
    }
    
    public DocumentBinary getBadTypeDocumentBinary() 
        throws IOException {
        DocumentBinary docBin = new DocumentBinary();
        File fileHtml = getResourceFile("test.html");
        byte[] dataHtml = new byte[(int) fileHtml.length()];
        FileInputStream fis = new FileInputStream(fileHtml);
        fis.read(dataHtml);
        docBin.setData(dataHtml);
        return docBin;
    }
}
