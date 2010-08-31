package fr.cg95.cvq.util.admin;

import java.io.File;
import java.lang.reflect.Method;
import java.util.List;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.springframework.aop.framework.Advised;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import zdb.core.Store;
import fr.cg95.cvq.business.document.ContentType;
import fr.cg95.cvq.business.document.DocumentBinary;
import fr.cg95.cvq.dao.document.IDocumentDAO;
import fr.cg95.cvq.dao.hibernate.HibernateUtil;
import fr.cg95.cvq.exception.CvqObjectNotFoundException;
import fr.cg95.cvq.security.SecurityContext;
import fr.cg95.cvq.service.authority.ILocalAuthorityRegistry;
import fr.cg95.cvq.service.document.IDocumentService;
import fr.cg95.cvq.service.document.impl.DocumentService;
import fr.cg95.cvq.service.document.impl.MimeUtil;

public class DocumentToZDBExtractor {

    public ILocalAuthorityRegistry localAuthorityRegistry;

    public IDocumentService documentService;
    public IDocumentDAO documentDAO;

    public static void main(final String[] args) {
        Logger.getRootLogger().setLevel(Level.OFF);
        ClassPathXmlApplicationContext cpxa = SpringApplicationContextLoader.loadContext(args[0]);
        DocumentToZDBExtractor extractor = new DocumentToZDBExtractor();
        extractor.localAuthorityRegistry = cpxa.getBean("localAuthorityRegistry", ILocalAuthorityRegistry.class);
        extractor.documentService = cpxa.getBean("documentService", IDocumentService.class);
        extractor.documentDAO = cpxa.getBean("documentDAO", IDocumentDAO.class);
        extractor.localAuthorityRegistry.browseAndCallback(extractor, "extract", null);
        System.exit(0);
    }

    public void extract()
        throws NoSuchMethodException {
        Method method = DocumentService.class.getDeclaredMethod("createPreview", DocumentBinary.class);
        method.setAccessible(true);
        Store.init(new File(localAuthorityRegistry.getAssetsBase() + SecurityContext.getCurrentSite().getName(), "zdb"));
        DocumentBinary docBin;
        byte[] data;
        for (Long id : (List<Long>)HibernateUtil.getSession().createQuery("select id from DocumentBinary").list()) {
            HibernateUtil.beginTransaction();
            try {
                docBin = (DocumentBinary)documentDAO.findById(DocumentBinary.class, id.longValue());
            } catch (CvqObjectNotFoundException e) {
                // srsly?
                continue;
            }
            data = (byte[])HibernateUtil.getSession()
                .createSQLQuery("select data from document_binary where id = :id")
                    .setLong("id", id).uniqueResult();
            if (data == null) {
                docBin.setContentType(ContentType.OCTET_STREAM);
            } else {
                docBin.setContentType(ContentType.forString(
                    MimeUtil.getMostSpecificMimeType(new MimeUtil().getMimeTypes(data)).toString()));
            }
            docBin.setData(data);
            try {
                method.invoke(((Advised)documentService).getTargetSource().getTarget(), docBin);
            } catch (Exception e) {
                // whatever...
            }
            documentDAO.update(docBin);
            HibernateUtil.commitTransaction();
            HibernateUtil.closeSession();
        }
    }
}
