package fr.cg95.cvq.dao.request.hibernate;

import fr.cg95.cvq.business.request.RequestState;
import fr.cg95.cvq.dao.hibernate.GenericDAO;
import fr.cg95.cvq.dao.hibernate.HibernateUtil;
import fr.cg95.cvq.dao.request.IRequestStatisticsDAO;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Hibernate;
import org.hibernate.type.Type;

/**
 * @author bor@zenexity.fr
 */
public class RequestStatisticsDAO extends GenericDAO implements IRequestStatisticsDAO {

    public Long countByQuality(final Date startDate, final Date endDate,
            final List<String> resultingStates, final String qualityType, final Long requestTypeId,
            final String categoryFilter) {

        List<Type> typeList = new ArrayList<Type>();
        List<Object> objectList = new ArrayList<Object>();

        StringBuffer sb = new StringBuffer();
        sb.append("select distinct(request.id) from Request request join request.actions action")
            .append(" where request.requestType.category.id in ( " + categoryFilter + ")");

        if (startDate != null) {
            sb.append(" and action.date > ?");
            objectList.add(startDate);
            typeList.add(Hibernate.TIMESTAMP);
        }
        if (endDate != null) {
            sb.append(" and action.date < ?");
            objectList.add(endDate);
            typeList.add(Hibernate.TIMESTAMP);
        }

        if (requestTypeId != null)
            sb.append(" and request.requestType.id = '").append(requestTypeId).append("'");

        sb.append(" and action.resultingState in (");
        for (int i = 0; i < resultingStates.size(); i++) {
            sb.append("'").append(resultingStates.get(i)).append("'");
            if (i != resultingStates.size() - 1)
                sb.append(",");
        }
        sb.append(")");

        if (qualityType.equals("qualityTypeOk")) {
            sb.append(" and request.orangeAlert = false")
                .append(" and request.redAlert = false");
        } else if (qualityType.equals("qualityTypeOrange")) {
            sb.append(" and request.orangeAlert = true")
                .append(" and request.redAlert = false");
        } else if (qualityType.equals("qualityTypeRed")) {
            sb.append(" and request.orangeAlert = false")
                .append(" and request.redAlert = true");
        }

        Type[] typeTab = typeList.toArray(new Type[0]);
        Object[] objectTab = objectList.toArray(new Object[0]);

        return Long.valueOf(HibernateUtil.getSession()
            .createQuery(sb.toString())
            .setParameters(objectTab, typeTab).list().size());
    }

    public Map<Long,Long> countByQualityAndType(final Date startDate, final Date endDate,
            final List<String> resultingStates, final String qualityType,
            final List<Long> requestTypesId) {

        List<Type> typeList = new ArrayList<Type>();
        List<Object> objectList = new ArrayList<Object>();

        StringBuffer sb = new StringBuffer();
        sb.append("select request.requestType.id, count(request.id) from Request request")
            .append(" join request.actions action");

        sb.append(" where request.requestType.id in ( ");
        for (int i = 0; i < requestTypesId.size(); i++) {
            sb.append("'").append(requestTypesId.get(i)).append("'");
            if (i != requestTypesId.size() - 1)
                sb.append(",");
        }
        sb.substring(sb.length() - 1);
        sb.append(" )");

        if (startDate != null) {
            sb.append(" and action.date > ?");
            objectList.add(startDate);
            typeList.add(Hibernate.TIMESTAMP);
        }
        if (endDate != null) {
            sb.append(" and action.date < ?");
            objectList.add(endDate);
            typeList.add(Hibernate.TIMESTAMP);
        }

        sb.append(" and action.resultingState in (");
        for (int i = 0; i < resultingStates.size(); i++) {
            sb.append("'").append(resultingStates.get(i)).append("'");
            if (i != resultingStates.size() - 1)
                sb.append(",");
        }
        sb.append(")");

        if (qualityType.equals("qualityTypeOk")) {
            sb.append(" and request.orangeAlert = false")
                .append(" and request.redAlert = false");
        } else if (qualityType.equals("qualityTypeOrange")) {
            sb.append(" and request.orangeAlert = true")
                .append(" and request.redAlert = false");
        } else if (qualityType.equals("qualityTypeRed")) {
            sb.append(" and request.orangeAlert = false")
                .append(" and request.redAlert = true");
        }

        sb.append(" group by request.requestType.id");

        Type[] typeTab = typeList.toArray(new Type[0]);
        Object[] objectTab = objectList.toArray(new Object[0]);

        List<Object[]> tempResult = HibernateUtil.getSession()
            .createQuery(sb.toString())
            .setParameters(objectTab, typeTab).list();
        Map<Long,Long> result = new HashMap<Long, Long>();
        for (Object[] object : tempResult) {
            result.put((Long) object[0], (Long) object[1]);
        }
        return result;
    }

    public Map<RequestState, Long> countByResultingState(final Date startDate, final Date endDate,
        final Long requestTypeId, final String categoryFilter) {

        List<Type> typeList = new ArrayList<Type>();
        List<Object> objectList = new ArrayList<Object>();

        StringBuffer sb = new StringBuffer();

        sb.append("select resultingState, date from RequestAction requestAction");
//            .append(" where request.requestType.category.id in ( " + categoryFilter + ")");

        sb.append(" where 1 = 1 ");
        if (startDate != null) {
            sb.append(" and requestAction.date > ?");
            objectList.add(startDate);
            typeList.add(Hibernate.TIMESTAMP);
        }
        if (endDate != null) {
            sb.append(" and requestAction.date < ?");
            objectList.add(endDate);
            typeList.add(Hibernate.TIMESTAMP);
        }
        sb.append(" and requestAction.resultingState is not null");

//        if (requestTypeId != null) {
//            sb.append(" and request.requestType.id = '").append(requestTypeId).append("'");
//        }

        sb.append(" group by resultingState");

        Type[] typeTab = typeList.toArray(new Type[0]);
        Object[] objectTab = objectList.toArray(new Object[0]);

        List<Object[]> tempResult = HibernateUtil.getSession()
            .createQuery(sb.toString())
            .setParameters(objectTab, typeTab).list();
        Map<RequestState,Long> result = new HashMap<RequestState, Long>();
        for (Object[] object : tempResult) {
            System.err.println(object[0] + " / " + object[1] + " / ");
            result.put((RequestState) object[1], (Long) object[0]);
        }
        return result;
    }

}
