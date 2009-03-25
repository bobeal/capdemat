package fr.cg95.cvq.dao.request.hibernate;

import fr.cg95.cvq.dao.hibernate.GenericDAO;
import fr.cg95.cvq.dao.hibernate.HibernateUtil;
import fr.cg95.cvq.dao.request.IRequestStatisticsDAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
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

    public Long countByResultingState(final String resultingState,
            final Date startDate, final Date endDate,
            final Long requestTypeId, final String categoryFilter) {

        StringBuffer tables = new StringBuffer();
        StringBuffer subquery = new StringBuffer();
        StringBuffer where = new StringBuffer();

        tables.append("select count(*) from request, request_action,");

        subquery.append("(select request_id, max(date) as date from request_action")
            .append(" where resulting_state <> '' group by request_id) last_entries");

        where.append(" where request.id=request_action.request_id")
            .append(" and request_action.request_id=last_entries.request_id")
            .append(" and request_action.date=last_entries.date");

        if (startDate != null) {
            where.append(" and request_action.date > '")
                .append(parseDate(startDate) + "'");
        }
        if (endDate != null) {
            where.append(" and request_action.date < '")
                .append(parseDate(endDate) + "'");
        }

        if (categoryFilter != null && !categoryFilter.isEmpty()) {
            tables.append(" request_type, category,");
            where.append(" and request.request_type_id = request_type.id ")
                .append("and request_type.category_id = category.id")
                .append(" and category.id in (").append(categoryFilter).append(")");
        }

        if (resultingState != null && !resultingState.equals("")) {
            where.append(" and request_action.resulting_state = '").append(resultingState).append("'");
        }

        if (requestTypeId != null) {
            if (tables.indexOf("request_type") == -1) {
                tables.append(" request_type,");
            }
            where.append(" and request.request_type_id = '").append(requestTypeId).append("'");
        }

        try {
            ResultSet result = HibernateUtil.getSession().connection()
                .createStatement().executeQuery(tables.append(subquery).append(where).toString());
            if (result.next()) {
                return new Long(result.getInt(1));
            } else {
                return new Long(0);
            }
        } catch (SQLException e) {
            e.getMessage();
            e.printStackTrace();
            return new Long(0);
        }
    }

    private String parseDate(Date date) {
        if (date == null)
            return "";
        // create a date formatter
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.FRANCE);

        return df.format(date);
    }

    public Map<Long, Long> countByType(final Date startDate, final Date endDate,
        final List<Long> requestTypeIds) {

        StringBuffer sb = new StringBuffer();
        sb.append("select request.requestType.id, count(*) from Request as request")
            .append(" where 1 = 1 ");

        List<Type> typeList = new ArrayList<Type>();
        List<Object> objectList = new ArrayList<Object>();

        if (startDate != null) {
            sb.append(" and request.creationDate > ? ");
            objectList.add(startDate);
            typeList.add(Hibernate.TIMESTAMP);
        }

        if (endDate != null) {
            sb.append(" and request.creationDate < ? ");
            objectList.add(endDate);
            typeList.add(Hibernate.TIMESTAMP);
        }

        if (requestTypeIds != null && !requestTypeIds.isEmpty()) {
            sb.append(" and request.requestType.id in (");
            for (Long requestTypeId : requestTypeIds) {
                sb.append("'").append(requestTypeId).append("',");
            }
            sb.deleteCharAt(sb.length() - 1);
            sb.append(")");
        }

        sb.append(" group by request.requestType.id");
        
        Type[] typeTab = typeList.toArray(new Type[0]);
        Object[] objectTab = objectList.toArray(new Object[0]);
        List<Object[]> tempResult =
            HibernateUtil.getSession().createQuery(sb.toString())
                .setParameters(objectTab, typeTab).list();
        Map<Long,Long> result = new HashMap<Long, Long>();
        for (Object[] object : tempResult) {
            result.put((Long) object[0], (Long) object[1]);
        }

        return result;
    }
}
