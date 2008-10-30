package fr.cg95.cvq.dao.document.hibernate;

import java.util.List;

import org.hibernate.Criteria;

import fr.cg95.cvq.business.document.DocumentType;
import fr.cg95.cvq.dao.document.IDocumentTypeDAO;
import fr.cg95.cvq.dao.hibernate.GenericDAO;
import fr.cg95.cvq.dao.hibernate.HibernateUtil;
import fr.cg95.cvq.util.Critere;

/**
 * Implementation of the {@link IDocumentTypeDAO} interface.
 * 
 * @author bor@zenexity.fr
 */
public class DocumentTypeDAO extends GenericDAO implements IDocumentTypeDAO {

    public DocumentTypeDAO() {
        super();
    }

    public DocumentType findByType(final Integer typeId) {
        Criteria crit = HibernateUtil.getSession().createCriteria(DocumentType.class);
        crit.add(Critere.compose("type", typeId, Critere.EQUALS));
        return (DocumentType) crit.uniqueResult();
    }

    public List<DocumentType> listAll() {
        StringBuffer sb = new StringBuffer();
        sb.append("from DocumentType as documentType");
        return HibernateUtil.getSession().createQuery(sb.toString()).list();
    }
}
