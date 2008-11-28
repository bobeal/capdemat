package fr.cg95.cvq.dao.document.hibernate;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Query;
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

    public List search(final Set criteria) {

        if (criteria.isEmpty())
            return listAll();

        Criteria crit = HibernateUtil.getSession().createCriteria(Document.class);
        Iterator critIt = criteria.iterator();

        // go through all the criteria and create the query
        while (critIt.hasNext()) {
            Critere searchCrit = (Critere) critIt.next();
            if (searchCrit.getAttribut().equals("id")) {
                crit.add(Critere.compose(searchCrit.getAttribut(), searchCrit.getLongValue(),
                        searchCrit.getComparatif()));
            } else if (searchCrit.getAttribut().equals("type")) {
                crit.add(Critere.compose(searchCrit.getAttribut(), searchCrit.getValue(),
                        searchCrit.getComparatif()));
            } else if (searchCrit.getAttribut().equals("state")) {
                crit.add(Critere.compose(searchCrit.getAttribut(), searchCrit.getValue(),
                        searchCrit.getComparatif()));
            } else if (searchCrit.getAttribut().equals("homeFolderId")) {
                crit.createCriteria("homeFolder").add(
                        Critere.compose("id", searchCrit.getValue(), 
                                searchCrit.getComparatif()));
            } else if (searchCrit.getAttribut().equals("individualName")) {
                crit.createCriteria("adult").add(
                        Critere.compose("lastName", searchCrit.getValue(), 
                                searchCrit.getComparatif()));
            } else {
                logger.warn("Unknown search criteria for Adult object");
            }
        }

        crit.addOrder(Order.asc("type"));
        List results = crit.list();
        return filterSearchResults(results);
    }

    public List listAll() {

        StringBuffer sb = new StringBuffer(100);
        sb.append("from Document as document");

        Query query = HibernateUtil.getSession().createQuery(sb.toString());
        List results = query.list();

        return filterSearchResults(results);
    }

    public List listProvidedDocuments(final Long docTypeId, final Long homeFolderId,
            final Long individualId) {

        Criteria crit = HibernateUtil.getSession().createCriteria(Document.class);
        if (docTypeId != null)
            crit.createCriteria("documentType").add(
                    Critere.compose("id", docTypeId, Critere.EQUALS));
        if (homeFolderId != null)
            crit.createCriteria("homeFolder").add(
                    Critere.compose("id", homeFolderId, Critere.EQUALS));
        if (individualId != null)
            crit.createCriteria("individual").add(
                    Critere.compose("id", individualId, Critere.EQUALS));

        List results = crit.list();

        return filterSearchResults(results);
    }

    public List listByHomeFolder(final Long homeFolderId) {
        Criteria crit = HibernateUtil.getSession().createCriteria(Document.class);
        crit.createCriteria("homeFolder").add(
                Critere.compose("id", homeFolderId, Critere.EQUALS));

        crit.addOrder(Order.asc("id"));
        List results = crit.list();

        return filterSearchResults(results);
    }
    
    public List<Document> listByHomeFolder (final Long homeFolderId, int max) {
        Criteria crit = HibernateUtil.getSession().createCriteria(Document.class);
        crit.createCriteria("homeFolder").add(Critere.compose("id", homeFolderId, Critere.EQUALS));
        crit.addOrder(Order.asc("id"));
        crit.setMaxResults(max);
        List<Document> results = crit.list();
        
        return filterSearchResults(results);
    }

    public List listByIndividual(final Long individualId) {
        Criteria crit = HibernateUtil.getSession().createCriteria(Document.class);
        crit.createCriteria("individual").add(
                Critere.compose("id", individualId, Critere.EQUALS));

        crit.addOrder(Order.asc("id"));
        List results = crit.list();

        return filterSearchResults(results);
    }

    public List listByRequest(final Long requestId) {
        Criteria crit = HibernateUtil.getSession().createCriteria(Document.class);
        crit.createCriteria("requests").add(Critere.compose("id", requestId, Critere.EQUALS));

        crit.addOrder(Order.asc("id"));
        List results = crit.list();

        return filterSearchResults(results);
    }

    public List listByState(final DocumentState documentState) {
        Criteria crit = HibernateUtil.getSession().createCriteria(Document.class);
        crit.add(Critere.compose("state", documentState, Critere.EQUALS));
        crit.addOrder(Order.asc("id"));

        List results = crit.list();

        return filterSearchResults(results);
    }

    public Long create(final Object object) throws CvqPermissionException {
        if (object instanceof Document)
            cvqPolicy.check((Document) object, PrivilegeDescriptor.WRITE);

        return super.create(object);
    }

    public void update(final Object object) throws CvqPermissionException {
        if (object instanceof Document)
            cvqPolicy.check((Document) object, PrivilegeDescriptor.WRITE);

        super.update(object);
    }

    public void delete(final Object object) throws CvqPermissionException {
        if (object instanceof Document)
            cvqPolicy.check((Document) object, PrivilegeDescriptor.WRITE);

        super.delete(object);
    }

    protected ArrayList filterSearchResults(final List results) {

        ArrayList resultAfterPermissionChecks = new ArrayList();
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
