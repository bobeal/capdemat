package fr.cg95.cvq.service.document;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;

import fr.cg95.cvq.business.document.Document;
import fr.cg95.cvq.business.document.DocumentState;
import fr.cg95.cvq.business.document.DocumentType;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.exception.CvqObjectNotFoundException;
import fr.cg95.cvq.testtool.ServiceTestCase;

public class DocumentTestCase extends ServiceTestCase {

    @Autowired
    protected IDocumentService documentService;
    @Autowired
    protected IDocumentTypeService documentTypeService;
        
    public Long gimmeImageDocument() 
        throws CvqObjectNotFoundException, CvqException, IOException {
        DocumentType docType = documentTypeService.getDocumentTypeByType(IDocumentTypeService.OLD_CNI_TYPE);
        Document document = new Document(null, null, docType, DocumentState.PENDING);
        
        Long docId = documentService.create(document);
        
        documentService.addPage(docId, getImageDocumentBinary());
        
        documentService.addPage(docId, getImageDocumentBinary());
        
        return docId;
    }
    
    public Long gimmePdfDocument()
        throws CvqObjectNotFoundException, CvqException, IOException {
        DocumentType docType = documentTypeService.getDocumentTypeByType(IDocumentTypeService.OLD_CNI_TYPE);
        Document document = new Document(null, null, docType, DocumentState.PENDING);

        Long docId = documentService.create(document);

        documentService.addPage(docId, getPdfDocumentBinary());

        return docId;
    }
    
    public byte[] getImageDocumentBinary()
        throws IOException {
        File fileJpg = getResourceFile("test.jpg");
        byte[] dataJpg = new byte[(int) fileJpg.length()];
        FileInputStream fis = new FileInputStream(fileJpg);
        fis.read(dataJpg);
        return dataJpg;
    }
    
    public byte[] getPdfDocumentBinary()
        throws IOException {
        File filePdf = getResourceFile("test.pdf");
        byte[] dataPdf = new byte[(int) filePdf.length()];
        FileInputStream fis = new FileInputStream(filePdf);
        fis.read(dataPdf);
        return dataPdf;
    }
    
    public byte[] getBadTypeDocumentBinary()
        throws IOException {
        File fileHtml = getResourceFile("test.html");
        byte[] dataHtml = new byte[(int) fileHtml.length()];
        FileInputStream fis = new FileInputStream(fileHtml);
        fis.read(dataHtml);
        return dataHtml;
    }
}
