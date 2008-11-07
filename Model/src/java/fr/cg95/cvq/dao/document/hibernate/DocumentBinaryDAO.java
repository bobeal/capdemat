package fr.cg95.cvq.dao.document.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.type.Type;

import fr.cg95.cvq.business.document.DocumentBinary;
import fr.cg95.cvq.dao.document.IDocumentBinaryDAO;
import fr.cg95.cvq.dao.hibernate.GenericDAO;
import fr.cg95.cvq.dao.hibernate.HibernateUtil;

/**
 * Implementation of the {@link IDocumentBinaryDAO} interface.
 * 
 * @author bor@zenexity.fr
 */
public class DocumentBinaryDAO extends GenericDAO implements IDocumentBinaryDAO {

    public DocumentBinary findByDocumentAndPageId(final Long documentId, final Integer pageNumber) {

        StringBuffer sb = new StringBuffer();
        sb.append("from DocumentBinary as documentBinary");

        List<Type> typeList = new ArrayList<Type>();
        List<Object> objectList = new ArrayList<Object>();

        sb.append(" where document_id = ? ");
        objectList.add(documentId);
        typeList.add(Hibernate.LONG);

        sb.append(" and page_number = ? ");
        objectList.add(pageNumber);
        typeList.add(Hibernate.INTEGER);
        
        Type[] typeTab = typeList.toArray(new Type[0]);
        Object[] objectTab = objectList.toArray(new Object[0]);

        return (DocumentBinary) HibernateUtil.getSession()
            .createQuery(sb.toString())
            .setParameters(objectTab, typeTab).uniqueResult();
    }

    public Integer getPage(final Long documentBinaryId) {

        StringBuffer sb = new StringBuffer();
        sb.append("select docBin.pageNumber from DocumentBinary as docBin");

        List<Type> typeList = new ArrayList<Type>();
        List<Object> objectList = new ArrayList<Object>();

        sb.append(" where id = ? ");
        objectList.add(documentBinaryId);
        typeList.add(Hibernate.LONG);

        Type[] typeTab = typeList.toArray(new Type[0]);
        Object[] objectTab = objectList.toArray(new Object[0]);

        return (Integer) HibernateUtil.getSession()
            .createQuery(sb.toString())
            .setParameters(objectTab, typeTab)
            .iterate().next();
    }

    public Long getPagesNumber(final Long documentId) {

        StringBuffer sb = new StringBuffer();
        sb.append("select count(*) from DocumentBinary as docBin");

        List<Type> typeList = new ArrayList<Type>();
        List<Object> objectList = new ArrayList<Object>();

        sb.append(" where document_id = ? ");
        objectList.add(documentId);
        typeList.add(Hibernate.LONG);

        Type[] typeTab = typeList.toArray(new Type[0]);
        Object[] objectTab = objectList.toArray(new Object[0]);

        return (Long)HibernateUtil.getSession()
            .createQuery(sb.toString())
            .setParameters(objectTab, typeTab)
            .iterate().next();
    }

    public boolean hasPage(final Long documentId, final Integer pageNumber) {

        StringBuffer sb = new StringBuffer();
        sb.append("select count(*) from DocumentBinary as docBin");

        List<Type> typeList = new ArrayList<Type>();
        List<Object> objectList = new ArrayList<Object>();

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

    public Long getNextPageNumber(final Long documentId) {

        StringBuffer sb = new StringBuffer();
        sb.append("select count(*) from DocumentBinary as docBin");

        List<Type> typeList = new ArrayList<Type>();
        List<Object> objectList = new ArrayList<Object>();

        sb.append(" where document_id = ? ");
        objectList.add(documentId);
        typeList.add(Hibernate.LONG);

        Type[] typeTab = typeList.toArray(new Type[0]);
        Object[] objectTab = objectList.toArray(new Object[0]);
        Long currentPage = (Long) HibernateUtil.getSession()
            .createQuery(sb.toString())
            .setParameters(objectTab, typeTab)
            .iterate().next();

        return (currentPage + 1);
    }
}
