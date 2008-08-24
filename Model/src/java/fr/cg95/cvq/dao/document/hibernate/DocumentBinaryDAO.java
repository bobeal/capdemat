package fr.cg95.cvq.dao.document.hibernate;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.type.Type;

import fr.cg95.cvq.business.document.Document;
import fr.cg95.cvq.business.document.DocumentBinary;
import fr.cg95.cvq.dao.document.IDocumentBinaryDAO;
import fr.cg95.cvq.dao.hibernate.GenericDAO;
import fr.cg95.cvq.dao.hibernate.HibernateUtil;
import fr.cg95.cvq.permission.CvqPermissionException;
import fr.cg95.cvq.permission.PrivilegeDescriptor;
import fr.cg95.cvq.util.Critere;

/**
 * The "DocumentBinary" service Hibernate implementation. This class is
 * responsible for data access logic functions
 * 
 * @author bor@zenexity.fr
 */
public class DocumentBinaryDAO extends GenericDAO implements IDocumentBinaryDAO {

    public DocumentBinaryDAO() {
        super();
    }

    public DocumentBinary findByDocumentAndPageId(final Long documentId, final Integer pageNumber)
            throws CvqPermissionException {

        // checking access to document is sufficient
        // FIXME : catch exception and return a empty array list ?
        Document document = null;
        document = (Document) HibernateUtil.getSession().load(Document.class, documentId);
     
        cvqPolicy.check(document, PrivilegeDescriptor.READ);
        
        Criteria crit = HibernateUtil.getSession().createCriteria(DocumentBinary.class);
        crit.createCriteria("document").add(Critere.compose("id", documentId, Critere.EQUALS));
        crit.add(Critere.compose("pageNumber", pageNumber, Critere.EQUALS));

        return (DocumentBinary) crit.uniqueResult();
    }

    public Integer getPage(final Long documentBinaryId) {

        StringBuffer sb = new StringBuffer();
        sb.append("select docBin.pageNumber from DocumentBinary as docBin");

        List typeList = new ArrayList();
        List objectList = new ArrayList();

        sb.append(" where id = ? ");
        objectList.add(documentBinaryId);
        typeList.add(Hibernate.LONG);

        Type[] typeTab = (Type[]) typeList.toArray(new Type[0]);
        Object[] objectTab = (Object[]) objectList.toArray(new Object[0]);

        return (Integer) HibernateUtil.getSession()
            .createQuery(sb.toString())
            .setParameters(objectTab, typeTab)
            .iterate().next();
    }

    public Long getPagesNumber(final Long documentId) throws CvqPermissionException {

        // checking access to document is sufficient
        // FIXME : catch exception and return a empty array list ?
        Document document = null;
        document = (Document) HibernateUtil.getSession().load(Document.class, documentId);    

        cvqPolicy.check(document, PrivilegeDescriptor.READ);

        StringBuffer sb = new StringBuffer();
        sb.append("select count(*) from DocumentBinary as docBin");

        List typeList = new ArrayList();
        List objectList = new ArrayList();

        sb.append(" where document_id = ? ");
        objectList.add(documentId);
        typeList.add(Hibernate.LONG);

        Type[] typeTab = (Type[]) typeList.toArray(new Type[0]);
        Object[] objectTab = (Object[]) objectList.toArray(new Object[0]);

        return (Long)HibernateUtil.getSession()
            .createQuery(sb.toString())
            .setParameters(objectTab, typeTab)
            .iterate().next();
     
    }

    public boolean hasPage(final Long documentId, final Integer pageNumber)
            throws CvqPermissionException {

        if (documentId == null || pageNumber == null)
            return false;

        // checking access to document is sufficient
        // FIXME : catch exception and return a empty array list ?
        Document document = null;
        document = (Document) HibernateUtil.getSession().load(Document.class, documentId);
        
        cvqPolicy.check(document, PrivilegeDescriptor.READ);

        StringBuffer sb = new StringBuffer();
        sb.append("select count(*) from DocumentBinary as docBin");

        List typeList = new ArrayList();
        List objectList = new ArrayList();

        sb.append(" where document_id = ? ");
        objectList.add(documentId);
        typeList.add(Hibernate.LONG);

        sb.append(" and page_number = ? ");
        objectList.add(pageNumber);
        typeList.add(Hibernate.INTEGER);

        Type[] typeTab = (Type[]) typeList.toArray(new Type[0]);
        Object[] objectTab = (Object[]) objectList.toArray(new Object[0]);
        Long result = (Long) HibernateUtil.getSession()
            .createQuery(sb.toString())
            .setParameters(objectTab, typeTab)
            .iterate().next();
        if (result.longValue() == 0)
            return false;
        else
            return true;
    }

    public Long getNextPageNumber(final Long documentId) throws CvqPermissionException {

        // checking access to document is sufficient
        // FIXME : catch exception and return a empty array list ?
        Document document = null;
        document = (Document) HibernateUtil.getSession().load(Document.class, documentId);
        cvqPolicy.check(document, PrivilegeDescriptor.READ);

        StringBuffer sb = new StringBuffer();
        sb.append("select count(*) from DocumentBinary as docBin");

        List typeList = new ArrayList();
        List objectList = new ArrayList();

        sb.append(" where document_id = ? ");
        objectList.add(documentId);
        typeList.add(Hibernate.LONG);

        Type[] typeTab = (Type[]) typeList.toArray(new Type[0]);
        Object[] objectTab = (Object[]) objectList.toArray(new Object[0]);
        Long currentPage = (Long) HibernateUtil.getSession()
            .createQuery(sb.toString())
            .setParameters(objectTab, typeTab)
            .iterate().next();
        return (currentPage + 1);
    }

    public Long create(final Object object) throws CvqPermissionException {
        if (object instanceof DocumentBinary)
            cvqPolicy.check((DocumentBinary) object, PrivilegeDescriptor.WRITE);

        cvqPolicy.check((DocumentBinary) object, PrivilegeDescriptor.WRITE);

        return super.create(object);
    }

    public void update(final Object object) throws CvqPermissionException {
        if (object instanceof DocumentBinary)
            cvqPolicy.check((DocumentBinary) object, PrivilegeDescriptor.WRITE);

        super.update(object);
    }

    public void delete(final Object object) throws CvqPermissionException {
        if (object instanceof DocumentBinary)
            cvqPolicy.check((DocumentBinary) object, PrivilegeDescriptor.WRITE);

        super.delete(object);
    }
}
