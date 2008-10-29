package fr.cg95.cvq.dao.document.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;

import org.apache.log4j.Logger;

import fr.cg95.cvq.business.document.Document;
import fr.cg95.cvq.business.document.DocumentState;
import fr.cg95.cvq.dao.document.IDocumentDAO;
import fr.cg95.cvq.dao.hibernate.GenericDAO;
import fr.cg95.cvq.dao.hibernate.HibernateUtil;
import fr.cg95.cvq.permission.CvqPermissionException;
import fr.cg95.cvq.permission.PrivilegeDescriptor;
import fr.cg95.cvq.util.Critere;

/**
 * The "Document" service Hibernate implementation. This class is responsible
 * for data access logic functions
 * 
 * @author bor@zenexity.fr
 */
public class DocumentDAO extends GenericDAO implements IDocumentDAO {

    static Logger logger = Logger.getLogger(DocumentDAO.class);

    public DocumentDAO() {
        super();
    }

    public List<Document> listProvidedDocuments(final Long docTypeId, final Long homeFolderId,
            final Long individualId) {

        Criteria crit = HibernateUtil.getSession().createCriteria(Document.class);
        if (docTypeId != null)
            crit.createCriteria("documentType").add(
                    Critere.compose("id", docTypeId, Critere.EQUALS));
        if (homeFolderId != null)
            crit.add(Critere.compose("homeFolderId", homeFolderId, Critere.EQUALS));
        if (individualId != null)
            crit.add(Critere.compose("individualId", individualId, Critere.EQUALS));

        List results = crit.list();

        return filterSearchResults(results);
    }

    public List<Document> listByHomeFolder(final Long homeFolderId) {
        Criteria crit = HibernateUtil.getSession().createCriteria(Document.class);
        crit.add(Critere.compose("homeFolderId", homeFolderId, Critere.EQUALS));

        crit.addOrder(Order.asc("id"));
        List results = crit.list();

        return filterSearchResults(results);
    }

    public List<Document> listByIndividual(final Long individualId) {
        Criteria crit = HibernateUtil.getSession().createCriteria(Document.class);
        crit.add(Critere.compose("individualId", individualId, Critere.EQUALS));

        crit.addOrder(Order.asc("id"));
        List results = crit.list();

        return filterSearchResults(results);
    }

    public List<Document> listByRequest(final Long requestId) {
        Criteria crit = HibernateUtil.getSession().createCriteria(Document.class);
        crit.createCriteria("requests").add(Critere.compose("id", requestId, Critere.EQUALS));

        crit.addOrder(Order.asc("id"));
        List results = crit.list();

        return filterSearchResults(results);
    }

    public List<Document> listByState(final DocumentState documentState) {
        Criteria crit = HibernateUtil.getSession().createCriteria(Document.class);
        crit.add(Critere.compose("state", documentState, Critere.EQUALS));
        crit.addOrder(Order.asc("id"));

        List results = crit.list();

        return filterSearchResults(results);
    }

    protected List<Document> filterSearchResults(final List results) {

        List<Document> resultAfterPermissionChecks = new ArrayList<Document>();
        Document document = null;
        for (int i = 0; i < results.size(); i++) {
            document = (Document) results.get(i);
            try {
                cvqPolicy.check(document, PrivilegeDescriptor.READ);
                // if we're here, we are authorized
                resultAfterPermissionChecks.add(document);
            } catch (CvqPermissionException cpe) {
                logger.debug("user is not authorized to see document " + document);
            }
        }

        return resultAfterPermissionChecks;
    }
}
