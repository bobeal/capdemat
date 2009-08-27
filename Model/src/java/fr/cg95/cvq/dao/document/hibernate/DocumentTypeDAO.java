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

    public DocumentType findByType(final Integer typeId) {
        Criteria crit = HibernateUtil.getSession().createCriteria(DocumentType.class);
        crit.add(Critere.compose("type", typeId, Critere.EQUALS));
        return (DocumentType) crit.uniqueResult();
    }

    @SuppressWarnings("unchecked")
    public List<DocumentType> listAll() {
        return (List<DocumentType>)HibernateUtil.getSession()
            .createQuery("from DocumentType as documentType").list();
    }
}
