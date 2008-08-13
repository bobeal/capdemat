package fr.cg95.cvq.bo.dispatcher;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.UnrecoverableKeyException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.xml.security.algorithms.MessageDigestAlgorithm;
import org.apache.xml.security.transforms.Transforms;
import org.apache.xml.security.utils.Base64;

import com.lexpersona.xlp7.LP7Crypto;
import com.lexpersona.xlp7.LP7Document;
import com.lexpersona.xlp7.LP7DocumentFactory;
import com.lexpersona.xlp7.LP7SignatureProductionPlace;
import com.lexpersona.xlp7.LP7TimeStampProtocolParams;
import com.lexpersona.xlp7.content.EnvelopedSignedContent;
import com.lexpersona.xlp7.exceptions.LP7Exception;
import com.lexpersona.xlp7.signature.LP7AppellationSignature;
import com.lexpersona.xlp7.signature.LP7AppellationSignatureFactory;
import com.lexpersona.xlp7.signature.LP7SignatureFactory;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Image;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;

import fr.cg95.cvq.bo.LP7CertifyProperties;
import fr.cg95.cvq.bo.business.BusinessManager;
import fr.cg95.cvq.bo.manager.CertificateManager;
import fr.cg95.cvq.bo.manager.StateManager;
import fr.cg95.cvq.bo.record.PaperRecord;
import fr.cg95.cvq.bo.record.RequestRecord;
import fr.cg95.cvq.security.SecurityContext;

public class Lp7Dispatcher extends HttpServlet {

    public Lp7Dispatcher() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        String action = request.getPathInfo();
        
        StateManager stateManager = (StateManager) request.getSession().getAttribute(
                StateManager.STATE_MANAGER);
        RequestRecord record = (RequestRecord) stateManager.getSelectedRecord();
        PaperRecord paper = (PaperRecord) record.getSelectedPaper();

        try {
            if (action.equals("/create")) {
                File pdfFile = null;
                String contentName = "";
                if (request.getParameter("file") != null) {
                    pdfFile = StartupServlet.getContextFile(request.getSession(), request.getParameter("file"));
                    contentName = "Courrier";
                } else {
                    pdfFile = createPdf(request, paper);
                    contentName = paper.getType();
                }
                String site = SecurityContext.getCurrentSite().getName();
                // Create the LP7 document
                LP7Document lp7Document = createLP7Document(site, pdfFile, contentName, "pdf");
    
                String pdfFileName = pdfFile.getName();
                String lp7FileName = pdfFileName.substring(0,pdfFileName.indexOf("."))+".lp7";
                File lp7File = StartupServlet.getContextFile(request.getSession(), lp7FileName);
                FileOutputStream fop = new FileOutputStream(lp7File);
    
                lp7Document.write(fop);
    
                fop.close();
    
                // Send the original LP7 document
                lp7Document.write(response.getOutputStream());

            } else if (action.equals("/view")) {
                ServletOutputStream outputStream = response.getOutputStream();
                outputStream.write(paper.getCertifiedData());
                outputStream.flush();
                outputStream.close();
            }

        } catch (Exception e) {
            response.sendError(501);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        try {
            String action = request.getPathInfo();

            if (action.equals("/save")) {
                // Get the signed LP7 document
                LP7Document lp7Document = LP7DocumentFactory.getInstance(request.getInputStream(), "");
    
                // Verify the LP7Document
                lp7Document.verify();
    
                // Store the LP7 document
                File lp7File = null;
                if (request.getParameter("file") != null) {
                    lp7File = StartupServlet.getContextFile(request.getSession(), request.getParameter("file"));
                } else {
                    lp7File = StartupServlet.getTempContextFile(request.getSession(), "tmp", ".lp7");
                }
                FileOutputStream fos = new FileOutputStream(lp7File);
    
                lp7Document.write(fos);
    
                fos.close();
                
                if (request.getParameter("file") == null) {
                    StateManager stateManager = (StateManager) request.getSession().getAttribute(
                            StateManager.STATE_MANAGER);
                    RequestRecord record = (RequestRecord) stateManager.getSelectedRecord();
                    PaperRecord paper = (PaperRecord) record.getSelectedPaper();
        
                    ByteArrayOutputStream baos = new ByteArrayOutputStream();
                    lp7Document.write(baos);
                    
                    paper.setCertifiedData(baos.toByteArray());
                }
            }            

        } catch (LP7Exception exception) {
            response.sendError(500, exception.toString());
            exception.printStackTrace();
        }
    }

    private File createPdf(HttpServletRequest request, PaperRecord paper) {
        // Load document data on demand
        if (paper.getDataFile() == null)
            BusinessManager.getDocumentData(request.getSession(), paper);

        // step 1: creation of a document-object
        Document document = new Document(PageSize.A4, 0, 0, 0, 0);
        File pdfFile = null;
        try {
            pdfFile = StartupServlet.getTempContextFile(request.getSession(), "tmp", ".pdf");
            // step 2:
            // we create a writer that listens to the document
            // and directs a PDF-stream to a file
            PdfWriter.getInstance(document, new FileOutputStream(pdfFile));

            // step 3: we open the document
            document.open();

            // step 4:
            int currentPage = paper.getPage();
            document.add(new Paragraph("Nature du justificatif: " + paper.getType()));
            for (int page = 0; page < paper.getNbPages(); page++) {

                String imageFile = paper.getDataFile(page).getAbsolutePath();
                if (page > 0)
                    document.newPage();

                document.add(new Paragraph("Page: " + (page + 1) + "/" + paper.getNbPages()));
                Image jpg = Image.getInstance(imageFile);
                document.add(jpg);
            }
            paper.setPage(currentPage);
            
        } catch (DocumentException de) {
            System.err.println(de.getMessage());
        } catch (IOException ioe) {
            System.err.println(ioe.getMessage());
        }

        // step 5: we close the document
        document.close();

        return pdfFile;
    }

    /**
     * Create the original LP7 document.
     * 
     * @param content
     * @param contentFileName
     * @param contentFileExtension
     * @throws LP7Exception
     */
    private LP7Document createLP7Document(String site, File dataFile, String contentFileName, String contentFileExtension)
            throws LP7Exception, NoSuchProviderException, NoSuchAlgorithmException, IOException,
            CertificateException, UnrecoverableKeyException, KeyStoreException {
        LP7CertifyProperties lp7Properties = new LP7CertifyProperties();
        lp7Properties.init(site);

        FileInputStream fis = new FileInputStream(dataFile);

        byte[] data = new byte[fis.available()];
        fis.read(data);
        fis.close();
        String content = Base64.encode(data);

        Date contentLastDateModified = new Date(dataFile.lastModified());

        // Load appellation certificate and private key from a PKCS#12 file
        CertificateManager appellation = new CertificateManager();
        appellation.loadFromPkcs12File(lp7Properties.getAppellationSignatureFile(), lp7Properties
                .getAppellationSignaturePassword().toCharArray(), lp7Properties.getJceProvider());

        PrivateKey appellationPrivateKey = appellation.getPrivateKey();
        Certificate[] appellationCertificateChain = appellation.getAllCertificates();

        // Appellation signature method id
        String signatureAlgorithm = appellationPrivateKey.getAlgorithm();
        String appellationSignatureMethodID = null;
        if ("RSA".equals(signatureAlgorithm)) {
            appellationSignatureMethodID = LP7SignatureFactory.ALGO_ID_SIGNATURE_RSA_SHA1;
        } else if ("DSA".equals(signatureAlgorithm)) {
            appellationSignatureMethodID = LP7SignatureFactory.ALGO_ID_SIGNATURE_DSA;
        }

        PrivateKey transactionPrivateKey = appellationPrivateKey;
        Certificate[] transactionCertificateChain = appellationCertificateChain;
        String transactionSignatureMethodId = appellationSignatureMethodID;

        if (!lp7Properties.getAppellationSignatureFile().equals(lp7Properties.getTransactionSignatureFile())) {
            // Load transaction certificate and private key from a PKCS#12 file
            CertificateManager transaction = new CertificateManager();
            transaction.loadFromPkcs12File(lp7Properties.getTransactionSignatureFile(), lp7Properties
                    .getTransactionSignaturePassword().toCharArray(), lp7Properties.getJceProvider());

            transactionPrivateKey = transaction.getPrivateKey();
            transactionCertificateChain = transaction.getAllCertificates();

            signatureAlgorithm = transactionPrivateKey.getAlgorithm();
            if ("RSA".equals(signatureAlgorithm)) {
                transactionSignatureMethodId = LP7SignatureFactory.ALGO_ID_SIGNATURE_RSA_SHA1;
            } else if ("DSA".equals(signatureAlgorithm)) {
                transactionSignatureMethodId = LP7SignatureFactory.ALGO_ID_SIGNATURE_DSA;
            }
        }

        // Time stamp protocol parameters
        LP7TimeStampProtocolParams tspParams = null;
        if (lp7Properties.getTsaServerUrl() != null) {
            tspParams = new LP7TimeStampProtocolParams(lp7Properties.getTsaServerUrl(), LP7Crypto.DIGEST_SHA1);
        }

        // Create the LP7 document
        LP7Document lp7Document = LP7DocumentFactory.createInstance("");

        LP7AppellationSignatureFactory appellationFactory = new LP7AppellationSignatureFactory(lp7Document,
                appellationSignatureMethodID);

        LP7SignatureProductionPlace signatureProductionPlace = new LP7SignatureProductionPlace();
        signatureProductionPlace.setCity(lp7Properties.getAppellationSppCity());
        signatureProductionPlace.setCountryName(lp7Properties.getAppellationSppCountryName());
        signatureProductionPlace.setPostalCode(lp7Properties.getAppellationSppPostalCode());
        signatureProductionPlace.setStateOrProvince(lp7Properties.getAppellationSppStateOrProvince());
        appellationFactory.setSignatureProductionPlace(signatureProductionPlace);

        appellationFactory.setSignerCertificatePath(appellationCertificateChain);
        appellationFactory.setTransactionCertificate((X509Certificate) transactionCertificateChain[0]);

        EnvelopedSignedContent envolopedSignedContent = new EnvelopedSignedContent(content);
        envolopedSignedContent.setMimeType("plain/text");
        envolopedSignedContent.setEncoding("base64");
        envolopedSignedContent.setFileName(contentFileName);
        envolopedSignedContent.setFileExtension(contentFileExtension);
        envolopedSignedContent.setFileLastDateModified(contentLastDateModified);
        envolopedSignedContent
                .setTransformsAlgortihm(new String[] { Transforms.TRANSFORM_C14N_EXCL_OMIT_COMMENTS });
        envolopedSignedContent.setMessageDigestAlgorithm(MessageDigestAlgorithm.ALGO_ID_DIGEST_SHA256);
        appellationFactory.addSignedContent(envolopedSignedContent);

        LP7AppellationSignature appellationSignature = (LP7AppellationSignature) appellationFactory
                .generateSignature();

        appellationSignature.sign(appellationPrivateKey, lp7Properties.getJceProvider(),
                new LP7TimeStampProtocolParams[] { tspParams }, transactionPrivateKey, lp7Properties
                        .getJceProvider(), transactionCertificateChain, transactionSignatureMethodId);

        return lp7Document;
    }
}
