package fr.cg95.cvq.dao.document.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;

import fr.cg95.cvq.business.document.Document;
import fr.cg95.cvq.business.document.DocumentState;
import fr.cg95.cvq.dao.document.IDocumentDAO;
import fr.cg95.cvq.dao.hibernate.GenericDAO;
import fr.cg95.cvq.dao.hibernate.HibernateUtil;
import fr.cg95.cvq.util.Critere;

/**
 * Implementation of the {@link IDocumentDAO} interface.
 * 
 * @author bor@zenexity.fr
 */
public class DocumentDAO extends GenericDAO implements IDocumentDAO {

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

        return crit.list();
    }

    public List<Document> listByHomeFolder(final Long homeFolderId) {
        Criteria crit = HibernateUtil.getSession().createCriteria(Document.class);
        crit.add(Critere.compose("homeFolderId", homeFolderId, Critere.EQUALS));
        crit.addOrder(Order.asc("id"));
        
        return crit.list();
    }
    
    public List<Document> listByHomeFolder (final Long homeFolderId, int max) {
        Criteria crit = HibernateUtil.getSession().createCriteria(Document.class);
        crit.createCriteria("homeFolder").add(Critere.compose("id", homeFolderId, Critere.EQUALS));
        crit.addOrder(Order.asc("id"));
        crit.setMaxResults(max);
        List<Document> results = crit.list();
        
        return filterSearchResults(results);
    }

    public List<Document> listByIndividual(final Long individualId) {
        Criteria crit = HibernateUtil.getSession().createCriteria(Document.class);
        crit.add(Critere.compose("individualId", individualId, Critere.EQUALS));
        crit.addOrder(Order.asc("id"));
        
        return crit.list();
    }

    public List<Document> listByState(final DocumentState documentState) {
        Criteria crit = HibernateUtil.getSession().createCriteria(Document.class);
        crit.add(Critere.compose("state", documentState, Critere.EQUALS));
        crit.addOrder(Order.asc("id"));

        return crit.list();
    }
}
