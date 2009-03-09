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

}
