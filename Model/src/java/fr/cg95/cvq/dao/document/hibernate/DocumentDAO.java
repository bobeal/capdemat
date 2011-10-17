package fr.cg95.cvq.dao.document.hibernate;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.event.PostDeleteEvent;
import org.hibernate.event.PostDeleteEventListener;

import fr.cg95.cvq.business.document.ContentType;
import fr.cg95.cvq.business.document.Document;
import fr.cg95.cvq.business.document.DocumentBinary;
import fr.cg95.cvq.business.document.DocumentState;
import fr.cg95.cvq.business.document.DocumentType;
import fr.cg95.cvq.business.users.HomeFolder;
import fr.cg95.cvq.dao.document.IDocumentDAO;
import fr.cg95.cvq.dao.jpa.JpaTemplate;
import fr.cg95.cvq.dao.jpa.JpaUtil;
import fr.cg95.cvq.dao.hibernate.HibernateUtil;
import fr.cg95.cvq.util.Critere;

/**
 * Implementation of the {@link IDocumentDAO} interface.
 * 
 * @author bor@zenexity.fr
 * @author vba@zenexity.fr
 * 
 * TODO; refactor to conform to simple search DAO method pattern in CapDemat
 */
public class DocumentDAO extends JpaTemplate<Document, Long> implements IDocumentDAO, PostDeleteEventListener {

    @Override
    public List<Document> listProvidedDocuments(
            final DocumentType documentType,
            final Long homeFolderId,
            final Long individualId) {

        String query = "from Document d where d.state not in (" +
            "fr.cg95.cvq.business.document.DocumentState.DRAFT, " +
            "fr.cg95.cvq.business.document.DocumentState.REFUSED, " +
            "fr.cg95.cvq.business.document.DocumentState.OUTDATED" +
            ")" +
            " and d.documentType = ? and d.homeFolderId = ?";
        if (individualId != null) {
            query += " and d.individualId = ?";
            return find(query, documentType, homeFolderId, individualId);
        } else {
            return find(query, documentType, homeFolderId);
        }
    }

    @SuppressWarnings("unchecked")
    public List<Document> listByHomeFolder (final Long homeFolderId, int max) {
        Criteria crit = HibernateUtil.getSession().createCriteria(Document.class);
        crit.add(Critere.compose("homeFolderId", homeFolderId, Critere.EQUALS));
        crit.addOrder(Order.desc("creationDate"));

        if (max != -1)
            crit.setMaxResults(max);

        return (List<Document>)crit.list();
    }

    @SuppressWarnings("unchecked")
    public List<Document> listByIndividual(final Long individualId) {
        Criteria crit = HibernateUtil.getSession().createCriteria(Document.class);
        crit.add(Critere.compose("individualId", individualId, Critere.EQUALS));
        crit.addOrder(Order.asc("id"));
        return (List<Document>)crit.list();
    }

    public Integer searchCount(Hashtable<String,Object> searchParams) {
        Criteria criteria = this.buildSearchCriteria(searchParams);
        criteria.setProjection(Projections.rowCount());
        return ((Long)criteria.list().get(0)).intValue();
    }

    @SuppressWarnings("unchecked")
    public List<Document> search(Hashtable<String,Object> searchParams,
        int max,int offset) {
        Criteria criteria = this.buildSearchCriteria(searchParams);
        criteria.addOrder(Order.desc("creationDate"));

        if(max > -1) criteria.setMaxResults(max);
        if(offset > -1) criteria.setFirstResult(offset);

        return (List<Document>)criteria.list();
    }

    @Override
    public List<Long> listByMissingComputedValues() {
        List<BigInteger> ids = HibernateUtil.getSession().createSQLQuery(
            "select document_id from document_binary where content_type is null or content_type = '"
                + ContentType.OCTET_STREAM + "' or preview is null").list();
        List<Long> result = new ArrayList<Long>(ids.size());
        for (BigInteger id : ids) {
            result.add(id.longValue());
        }
        return result;
    }

    @Override
    public List<Long> listOutdated() {
        return HibernateUtil.getSession()
            .createQuery("select id from Document where state in (?, ?, ?) and endValidityDate < ?")
            .setString(0, DocumentState.PENDING.name())
            .setString(1, DocumentState.CHECKED.name())
            .setString(2, DocumentState.VALIDATED.name())
            .setDate(3, new Date())
            .list();
    }

    @Override
    public void onPostDelete(PostDeleteEvent event) {
        Object entity = event.getEntity();
        if (entity instanceof DocumentBinary) {
            ((DocumentBinary)entity).removeData();
        }
    }

    private Criteria buildSearchCriteria(Hashtable<String,Object> params) {
        Criteria criteria = HibernateUtil.getSession()
            .createCriteria(Document.class);
        Hashtable<String,Object> specials = new Hashtable<String,Object>();

        for(String key : params.keySet()) {
            if("individualId".equals(key) || "homeFolderId".equals(key))
                specials.put(key, params.get(key));
            else
                criteria.add(this.processParam(key, params.get(key)));
        }

        if (specials.containsKey("individualId")
            && specials.containsKey("homeFolderId")) {
            Criterion crt;
            if (specials.get("individualId") instanceof Collection<?>)
                crt = this.processParam("individualId",
                    (Collection<?>)specials.get("individualId"));
            else
                crt = this.processParam("individualId",
                    specials.get("individualId"));

            criteria.add(Restrictions.or(crt, 
                this.processParam("homeFolderId",specials.get("homeFolderId"))));
        } else if (specials.containsKey("individualId")) {
            criteria.add(this.processParam("individualId",
                specials.get("individualId")));
        }  else if (specials.containsKey("homeFolderId")) {
            criteria.add(this.processParam("homeFolderId",
                specials.get("homeFolderId")));
        }

        // Never fetch document with state "DRAFT"
        criteria.add(Restrictions.ne("state", DocumentState.DRAFT));

        return criteria;
    }

    private <T extends Collection<?>> Criterion processParam(String key, T param) {
        return Restrictions.in(key, param);
    }

    private <T> Criterion processParam(String key, T param) {
        return Restrictions.eq(key, param);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Document> linkedToHomeFolder(HomeFolder homeFolder, DocumentType documentType) {
        if (homeFolder != null && documentType != null)
            return JpaUtil.getEntityManager()
                .createQuery("select doc from Document as doc where doc.linkedHomeFolder = ? and doc.documentType = ?")
                .setParameter(1, homeFolder)
                .setParameter(2, documentType)
                .getResultList();
        else
            return new ArrayList<Document>();
    }
}
