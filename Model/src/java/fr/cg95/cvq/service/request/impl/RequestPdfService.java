package fr.cg95.cvq.service.request.impl;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.pdfbox.exceptions.COSVisitorException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.util.PDFMergerUtility;
import org.codehaus.groovy.control.CompilationFailedException;
import org.xhtmlrenderer.pdf.ITextRenderer;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.pdf.PdfCopy;
import com.lowagie.text.pdf.PdfName;
import com.lowagie.text.pdf.PdfReader;
import com.lowagie.text.pdf.PdfStamper;

import fr.cg95.cvq.business.authority.LocalAuthorityResource;
import fr.cg95.cvq.business.authority.LocalAuthorityResource.Type;
import fr.cg95.cvq.business.request.LocalReferentialType;
import fr.cg95.cvq.business.request.Request;
import fr.cg95.cvq.business.request.RequestAction;
import fr.cg95.cvq.business.request.RequestActionType;
import fr.cg95.cvq.business.request.RequestDocument;
import fr.cg95.cvq.business.request.RequestState;
import fr.cg95.cvq.business.request.external.RequestExternalAction;
import fr.cg95.cvq.business.users.Adult;
import fr.cg95.cvq.business.users.Child;
import fr.cg95.cvq.business.users.Individual;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.external.IExternalService;
import fr.cg95.cvq.security.SecurityContext;
import fr.cg95.cvq.service.authority.IAgentService;
import fr.cg95.cvq.service.authority.ILocalAuthorityRegistry;
import fr.cg95.cvq.service.document.IDocumentService;
import fr.cg95.cvq.service.request.ILocalReferentialService;
import fr.cg95.cvq.service.request.IRequestPdfService;
import fr.cg95.cvq.service.request.IRequestSearchService;
import fr.cg95.cvq.service.request.external.IRequestExternalActionService;
import fr.cg95.cvq.service.users.IHomeFolderService;
import fr.cg95.cvq.service.users.IIndividualService;
import fr.cg95.cvq.util.Critere;
import fr.cg95.cvq.util.translation.ITranslationService;
import groovy.text.SimpleTemplateEngine;
import groovy.text.Template;

/**
 * TODO : mutualize technical tasks of generation in a specific service (to be reused by others).
 */
public class RequestPdfService implements IRequestPdfService {

    private static Logger logger = Logger.getLogger(RequestPdfService.class);

    protected ILocalAuthorityRegistry localAuthorityRegistry;
    protected ITranslationService translationService;
    protected IIndividualService individualService;
    protected IHomeFolderService homeFolderService;
    protected ILocalReferentialService localReferentialService;
    private IRequestSearchService requestSearchService;
    private IAgentService agentService;
    private IRequestExternalActionService requestExternalActionService;
    private IDocumentService documentService;

    public byte[] generateCertificate(Request request) throws CvqException {
        String htmlFilename = 
            StringUtils.uncapitalize(request.getRequestType().getLabel().replace(" ", "")) + "Request";
        File htmlTemplate =
            localAuthorityRegistry.getReferentialResource(Type.CERTIFICATE_TEMPLATE, htmlFilename);
        if (htmlTemplate == null || !htmlTemplate.exists()) {
            throw new CvqException("generate() certificate template file denoted by name "
                + htmlFilename + ".html does not exist on filesystem");
        }
        File logoFile = localAuthorityRegistry.getLocalAuthorityResourceFile(
                LocalAuthorityResource.LOGO_PDF.getId());
        
        File cssFile = localAuthorityRegistry.getLocalAuthorityResourceFile(
                LocalAuthorityResource.Type.CSS,"certificate", true);
        
        Adult requester = null;
        if (request.getRequesterId() != null)
            requester = individualService.getAdultById(request.getRequesterId());
        Individual subject = null;
        if (request.getSubjectId() != null)
            subject = individualService.getById(request.getSubjectId());
       
        try {
            SimpleTemplateEngine templateEngine = new SimpleTemplateEngine();
            Template template = templateEngine.createTemplate(htmlTemplate);
            Map<String, Object> bindings = new HashMap<String, Object>();
            bindings.put("localAuthority", SecurityContext.getCurrentSite());
            bindings.put("rqt", request);
            if (Arrays.asList(new String[]{"VO Card","Home Folder Modification"})
                    .contains(request.getRequestType().getLabel())) {
                bindings.put("adults", homeFolderService.getAdults(request.getHomeFolderId()));
                bindings.put("children", homeFolderService.getChildren(request.getHomeFolderId()));
            }
            bindings.put("requester", requester);
            bindings.put("subject", subject);
            if (subject != null && subject instanceof Child)
                bindings.put("subjectIsChild", true);
            else
                bindings.put("subjectIsChild", false);
            bindings.put("lrTypes", getLocalReferentialTypes(request.getRequestType().getLabel()));
            bindings.put("cssPath", cssFile.getAbsolutePath());
            bindings.put("logoPath", logoFile.getAbsolutePath());
            bindings.put("i18n", translationService);
            File htmlCertificateFile = File.createTempFile(htmlFilename, ".html");
            template.make(bindings).writeTo(new FileWriter(htmlCertificateFile));
            
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ITextRenderer renderer = new ITextRenderer();
            renderer.setDocument(htmlCertificateFile);
            renderer.layout();
            renderer.createPDF(baos);
            htmlCertificateFile.delete();
            return baos.toByteArray();
        } catch (CompilationFailedException e) {
            logger.error(e.getStackTrace());
            throw new CvqException("generate(): Can't generate PDF request certificate");
        } catch (FileNotFoundException e) {
            logger.error(e.getStackTrace());
            throw new CvqException("generate(): Can't generate PDF request certificate");
        } catch (ClassNotFoundException e) {
            logger.error(e.getStackTrace());
            throw new CvqException("generate(): Can't generate PDF request certificate");
        } catch (IOException e) {
            logger.error(e.getStackTrace());
            throw new CvqException("generate(): Can't generate PDF request certificate");
        } catch (DocumentException e) {
            logger.error(e.getStackTrace());
            throw new CvqException("generate(): Can't generate PDF request certificate");
        }
    }

    public byte[] generateArchive(Long requestId)
        throws CvqException, CompilationFailedException, ClassNotFoundException, IOException,
            DocumentException {
        File certificateCSSFile = localAuthorityRegistry.getLocalAuthorityResourceFile(
            LocalAuthorityResource.Type.CSS, "certificate", true);
        File archiveCSSFile = localAuthorityRegistry.getLocalAuthorityResourceFile(
            LocalAuthorityResource.Type.CSS, "archive", true);
        File tagCSSFile = localAuthorityRegistry.getLocalAuthorityResourceFile(
            LocalAuthorityResource.Type.CSS, "tag", true);
        Set<Critere> criteriaSet = new HashSet<Critere>(1);
        criteriaSet.add(new Critere(RequestExternalAction.SEARCH_BY_KEY,
            String.valueOf(requestId), Critere.EQUALS));
        Map<String, List<RequestExternalAction>> traces =
            new HashMap<String, List<RequestExternalAction>>();
        for (RequestExternalAction trace :
            requestExternalActionService.getTraces(criteriaSet, RequestExternalAction.SEARCH_BY_DATE, "asc", 0, 0)) {
            List<RequestExternalAction> current = traces.get(trace.getName());
            if (current == null) {
                current = new ArrayList<RequestExternalAction>();
                traces.put(trace.getName(), current);
            }
            current.add(trace);
        }
        Request request = requestSearchService.getById(requestId, true);
        File historyTemplate =
            localAuthorityRegistry.getReferentialResource(Type.ARCHIVE_TEMPLATES, "history");
        if (historyTemplate == null || !historyTemplate.exists()) {
            throw new CvqException("generateArchive() : template file archive.html does not exist on filesystem");
        }
        SimpleTemplateEngine templateEngine = new SimpleTemplateEngine();
        Template template = templateEngine.createTemplate(historyTemplate);
        Map<String, Object> bindings = new HashMap<String, Object>();
        bindings.put("certificateCSSPath", certificateCSSFile.getAbsolutePath());
        bindings.put("archiveCSSPath", archiveCSSFile.getAbsolutePath());
        bindings.put("tagCSSPath", tagCSSFile.getAbsolutePath());
        bindings.put("request", requestSearchService.getById(requestId, false));
        bindings.put("externalTraces", traces);
        bindings.put("i18n", translationService);
        bindings.put("individualService", individualService);
        bindings.put("agentService", agentService);
        File htmlCertificateFile = File.createTempFile("history", ".html");
        template.make(bindings).writeTo(new FileWriter(htmlCertificateFile));
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ITextRenderer renderer = new ITextRenderer();
        renderer.setDocument(htmlCertificateFile);
        renderer.layout();
        renderer.createPDF(baos);
        htmlCertificateFile.delete();
        byte history[] = baos.toByteArray();
        List<byte[]> mails = new ArrayList<byte[]>();
        for (RequestAction action : request.getActions()) {
            if (RequestActionType.CONTACT_CITIZEN.equals(action.getType())
                && action.getFile() != null) {
                mails.add(action.getFile());
            }
        }
        byte[] mailsHeader = null;
        if (!mails.isEmpty()) {
            File mailsTemplate =
                localAuthorityRegistry.getReferentialResource(Type.ARCHIVE_TEMPLATES, "mails");
            if (mailsTemplate == null || !mailsTemplate.exists()) {
                throw new CvqException("generateArchive() : template file mails.html does not exist on filesystem");
            }
            template = templateEngine.createTemplate(mailsTemplate);
            bindings = new HashMap<String, Object>();
            bindings.put("certificateCSSPath", certificateCSSFile.getAbsolutePath());
            bindings.put("archiveCSSPath", archiveCSSFile.getAbsolutePath());
            bindings.put("tagCSSPath", tagCSSFile.getAbsolutePath());
            bindings.put("i18n", translationService);
            File htmlFile = File.createTempFile("mails", ".html");
            template.make(bindings).writeTo(new FileWriter(htmlFile));
            baos = new ByteArrayOutputStream();
            renderer.setDocument(htmlFile);
            renderer.layout();
            renderer.createPDF(baos);
            htmlFile.delete();
            mailsHeader = baos.toByteArray();
        }
        byte certificate[] =
            requestSearchService.getCertificate(requestId, RequestState.VALIDATED);
        if (certificate == null) {
            certificate = generateCertificate(request);
        }
        PdfReader reader = new PdfReader(certificate);
        Document document = new Document(reader.getPageSizeWithRotation(1));
        baos = new ByteArrayOutputStream();
        PdfCopy copy = new PdfCopy(document, baos);
        document.open();
        for (int i = 1; i <= reader.getNumberOfPages(); i++) {
            copy.addPage(copy.getImportedPage(reader, i));
        }
        reader = new PdfReader(history);
        int i;
        for (i = 1; i <= reader.getNumberOfPages(); i++) {
            copy.addPage(copy.getImportedPage(reader, i));
        }
        if (!mails.isEmpty()) {
            reader = new PdfReader(mailsHeader);
            for (i = 1; i <= reader.getNumberOfPages(); i++) {
                copy.addPage(copy.getImportedPage(reader, i));
            }
            for (byte[] mail : mails) {
                reader = new PdfReader(mail);
                for (i = 1; i <= reader.getNumberOfPages(); i++) {
                    copy.addPage(copy.getImportedPage(reader, i));
                }
            }
        }
        if (request.getDocumentsArchive() != null) {
            reader = new PdfReader(request.getDocumentsArchive());
            for (i = 1; i <= reader.getNumberOfPages(); i++) {
                copy.addPage(copy.getImportedPage(reader, i));
            }
        }
        document.close();
        reader = new PdfReader(baos.toByteArray());
        baos = new ByteArrayOutputStream();
        PdfStamper stamper = new PdfStamper(reader, baos);
        HashMap<String, Object> metadata = reader.getInfo();
        String author = SecurityContext.getCurrentSite().getDisplayTitle();
        String title = translationService.translate(
            "requestArchive.title",
            new Object[] {
                request.getId().toString(),
                translationService
                    .translateRequestTypeLabel(request.getRequestType().getLabel())
            }
        );
        metadata.put("Author", author);
        metadata.put("Title", title);
        stamper.setMoreInfo(metadata);
        reader.getCatalog().put(PdfName.AUTHOR, new PdfName(author));
        reader.getCatalog().put(PdfName.TITLE, new PdfName(title));
        stamper.close();
        return baos.toByteArray();
    }

    public byte[] generateDocumentsArchive(Collection<RequestDocument> requestDocuments)
        throws CvqException {
        if (requestDocuments.isEmpty()) return null;
        File htmlTemplate =
            localAuthorityRegistry.getReferentialResource(Type.ARCHIVE_TEMPLATES, "documents");
        File certificateCSSFile = localAuthorityRegistry.getLocalAuthorityResourceFile(
                LocalAuthorityResource.Type.CSS, "certificate", true);
        File archiveCSSFile = localAuthorityRegistry.getLocalAuthorityResourceFile(
                LocalAuthorityResource.Type.CSS, "archive", true);
        File tagCSSFile = localAuthorityRegistry.getLocalAuthorityResourceFile(
                LocalAuthorityResource.Type.CSS, "tag", true);
        byte[] header;
        try {
            SimpleTemplateEngine templateEngine = new SimpleTemplateEngine();
            Template template = templateEngine.createTemplate(htmlTemplate);
            Map<String, Object> bindings = new HashMap<String, Object>();
            bindings.put("certificateCSSPath", certificateCSSFile.getAbsolutePath());
            bindings.put("archiveCSSPath", archiveCSSFile.getAbsolutePath());
            bindings.put("tagCSSPath", tagCSSFile.getAbsolutePath());
            bindings.put("i18n", translationService);
            File htmlFile = File.createTempFile("documents", ".html");
            template.make(bindings).writeTo(new FileWriter(htmlFile));
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ITextRenderer renderer = new ITextRenderer();
            renderer.setDocument(htmlFile);
            renderer.layout();
            renderer.createPDF(baos);
            htmlFile.delete();
            header = baos.toByteArray();
        } catch (CompilationFailedException e) {
            e.printStackTrace();
            throw new CvqException("generateDocumentsArchive(): got exception");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new CvqException("generateDocumentsArchive(): got exception");
        } catch (IOException e) {
            e.printStackTrace();
            throw new CvqException("generateDocumentsArchive(): got exception");
        } catch (DocumentException e) {
            e.printStackTrace();
            throw new CvqException("generateDocumentsArchive(): got exception");
        }
        try {
            PDDocument pdDoc, pdDocNew;
            List<fr.cg95.cvq.business.document.Document> documents = 
                new ArrayList<fr.cg95.cvq.business.document.Document>();
            for (RequestDocument doc : requestDocuments) {
                fr.cg95.cvq.business.document.Document document = documentService.getById(doc.getDocumentId());
                documentService.mergeDocumentBinary(document);
                documents.add(document);
            }
            pdDoc = 
                documentService.byteToPDDocument(header);
            for (fr.cg95.cvq.business.document.Document doc : documents) {
                pdDocNew = documentService.byteToPDDocument(doc.getDatas().get(0).getData());
                if (!pdDocNew.isEncrypted()) {
                    PDFMergerUtility pmu = new PDFMergerUtility();
                    pmu.appendDocument(pdDoc, pdDocNew);
                }
            }

            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            pdDoc.save(baos);
            pdDoc.close();
            return baos.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
            throw new CvqException("generateDocumentsArchive(): got exception");
        } catch (COSVisitorException e) {
            e.printStackTrace();
            throw new CvqException("generateDocumentsArchive(): got exception");
        }
    }

    // FIXME - feature duplicated in RequestTypeAdaptorService.groovy
    // TODO - mutualize
    private Map<String,LocalReferentialType> getLocalReferentialTypes(String requestTypeLabel) {
        Map<String,LocalReferentialType> result = new HashMap<String,LocalReferentialType>();
        try {
            for(LocalReferentialType lrt : 
                localReferentialService.getLocalReferentialDataByRequestType(requestTypeLabel))
                result.put(StringUtils.uncapitalize(lrt.getDataName()), lrt);
        } catch (CvqException ce) { /* No localReferentialData found ! */ }
        return result;
    }
    
    public void setLocalAuthorityRegistry(ILocalAuthorityRegistry localAuthorityRegistry) {
        this.localAuthorityRegistry = localAuthorityRegistry;
    }

    public void setTranslationService(ITranslationService translationService) {
        this.translationService = translationService;
    }

    public void setIndividualService(IIndividualService individualService) {
        this.individualService = individualService;
    }

    public void setHomeFolderService(IHomeFolderService homeFolderService) {
        this.homeFolderService = homeFolderService;
    }

    public void setLocalReferentialService(ILocalReferentialService localReferentialService) {
        this.localReferentialService = localReferentialService;
    }

    public void setRequestSearchService(IRequestSearchService requestSearchService) {
        this.requestSearchService = requestSearchService;
    }

    public void setAgentService(IAgentService agentService) {
        this.agentService = agentService;
    }

    public void setRequestExternalActionService(
            IRequestExternalActionService requestExternalActionService) {
        this.requestExternalActionService = requestExternalActionService;
    }

    public void setDocumentService(IDocumentService documentService) {
        this.documentService = documentService;
    }
}
