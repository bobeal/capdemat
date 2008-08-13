package fr.cg95.cvq.dao.authority.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import fr.cg95.cvq.business.authority.DocumentType;
import fr.cg95.cvq.dao.authority.IDocumentTypeDAO;
import fr.cg95.cvq.dao.hibernate.GenericDAO;
import fr.cg95.cvq.dao.hibernate.HibernateUtil;
import fr.cg95.cvq.permission.CvqPermissionException;
import fr.cg95.cvq.permission.PrivilegeDescriptor;
import fr.cg95.cvq.util.Critere;

/**
 * The "DocumentType" service Hibernate implementation. This class is
 * responsible for data access logic functions
 * 
 * @author bor@zenexity.fr
 */
public class DocumentTypeDAO extends GenericDAO implements IDocumentTypeDAO {

    public DocumentTypeDAO() {
        super();
    }

    public DocumentType findByType(final Integer typeId) {
        // no meaning in restricting read access to document types
            Criteria crit = HibernateUtil.getSession().createCriteria(DocumentType.class);
            crit.add(Critere.compose("type", typeId, Critere.EQUALS));
            return (DocumentType) crit.uniqueResult();
    }

    public List listAll() {
        // no meaning in restricting read access to document types
        StringBuffer sb = new StringBuffer(100);
        sb.append("from DocumentType as documentType");
        return HibernateUtil.getSession().createQuery(sb.toString()).list();
    }

    public Long create(final Object object) throws CvqPermissionException {
        if (object instanceof DocumentType)
            cvqPolicy.check((DocumentType) object, PrivilegeDescriptor.ADMIN);

        return super.create(object);
    }

    public void update(final Object object) throws CvqPermissionException {
        if (object instanceof DocumentType)
            cvqPolicy.check((DocumentType) object, PrivilegeDescriptor.ADMIN);

        super.update(object);
    }

    public void delete(final Object object) throws CvqPermissionException {
        if (object instanceof DocumentType)
            cvqPolicy.check((DocumentType) object, PrivilegeDescriptor.ADMIN);

        super.delete(object);
    }
}
