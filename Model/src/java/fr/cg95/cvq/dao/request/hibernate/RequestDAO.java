package fr.cg95.cvq.dao.request.hibernate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import org.apache.log4j.Logger;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.type.Type;

import fr.cg95.cvq.business.request.Request;
import fr.cg95.cvq.business.request.RequestState;
import fr.cg95.cvq.business.request.ecitizen.VoCardRequest;
import fr.cg95.cvq.dao.hibernate.GenericDAO;
import fr.cg95.cvq.dao.hibernate.HibernateUtil;
import fr.cg95.cvq.dao.request.IRequestDAO;
import fr.cg95.cvq.permission.CvqPermissionException;
import fr.cg95.cvq.permission.PrivilegeDescriptor;
import fr.cg95.cvq.util.Critere;

/**
 * Hibernate implementation of the {@link IRequestDAO} interface.
 * 
 * @author bor@zenexity.fr
 */
public class RequestDAO extends GenericDAO implements IRequestDAO {

    private static Logger logger = Logger.getLogger(RequestDAO.class);

    public RequestDAO() {
        super();
    }
    
    public List search(final Set criteria, final String sort, String dir, int recordsReturned, 
            int startIndex, final boolean onlyIds) {

        StringBuffer sb = new StringBuffer();
        if (onlyIds)
            sb.append("select request.id ");
        sb.append("from Request as request").append(" where 1 = 1 ");

        Iterator critIt = criteria.iterator();

        List<Object> parametersValues = new ArrayList<Object>();
        List<Type> parametersTypes = new ArrayList<Type>();
        
        // go through all the criteria and create the query
        while (critIt.hasNext()) {
            Critere searchCrit = (Critere) critIt.next();
            if (searchCrit.getAttribut().equals(Request.SEARCH_BY_REQUEST_ID)) {
                sb.append(" and request.id " + searchCrit.getComparatif() + " ?");
                parametersValues.add(searchCrit.getLongValue());
                parametersTypes.add(Hibernate.LONG);
                
            } else if (searchCrit.getAttribut().equals(Request.SEARCH_BY_HOME_FOLDER_ID)) {
                sb.append(" and request.homeFolder " + searchCrit.getComparatif() + " ?");
                parametersValues.add(searchCrit.getLongValue());
                parametersTypes.add(Hibernate.LONG);
                
            } else if (searchCrit.getAttribut().equals(Request.SEARCH_BY_REQUESTER_LASTNAME)) {
                sb.append(" and lower(request.requester.lastName) "
                        + searchCrit.getSqlComparatif() + " lower(?)");
                parametersValues.add(searchCrit.getSqlStringValue());
                parametersTypes.add(Hibernate.STRING);
                                
            } else if (searchCrit.getAttribut().equals(Request.SEARCH_BY_CATEGORY_NAME)) {
                sb.append(" and request.requestType.category.name "
                        + searchCrit.getComparatif() + " ?");
                parametersValues.add(searchCrit.getValue());
                parametersTypes.add(Hibernate.STRING);
            
            } else if (searchCrit.getAttribut().equals(Request.SEARCH_BY_CATEGORY_ID)) {
                sb.append(" and request.requestType.category.id "
                        + searchCrit.getComparatif() + " ?");
                parametersValues.add(searchCrit.getLongValue());
                parametersTypes.add(Hibernate.LONG);

            } else if (searchCrit.getAttribut().equals("requestType")) {
                sb.append(" and request.requestType " + searchCrit.getComparatif() + " ?");
                parametersValues.add(searchCrit.getLongValue());
                parametersTypes.add(Hibernate.LONG);

            } else if (searchCrit.getAttribut().equals(Request.SEARCH_BY_REQUEST_TYPE_LABEL)) {
                sb.append(" and request.requestType.label " + searchCrit.getComparatif() + " ?");
                parametersValues.add(searchCrit.getValue());
                parametersTypes.add(Hibernate.STRING);

            } else if (searchCrit.getAttribut().equals(Request.SEARCH_BY_STATE)) {
                sb.append(" and request.state " + searchCrit.getComparatif() + " ?");
                // To ensure we put the good type in the object list
                // FIXME : all states criteria should be sent as RequestState objects
                if (searchCrit.getValue() instanceof RequestState)
                    parametersValues.add(searchCrit.getValue().toString());
                else
                    parametersValues.add(searchCrit.getValue());
                parametersTypes.add(Hibernate.STRING);

            } else if (searchCrit.getAttribut().equals(Request.SEARCH_BY_CREATION_DATE)) {
                sb.append(" and request.creationDate " + searchCrit.getComparatif() + " ?");
                parametersValues.add(searchCrit.getDateValue());
                parametersTypes.add(Hibernate.TIMESTAMP);

            } else if (searchCrit.getAttribut().equals(Request.SEARCH_BY_LAST_MODIFICATION_DATE)) {
                sb.append(" and request.lastModificationDate " + searchCrit.getComparatif() + " ?");
                parametersValues.add(searchCrit.getDateValue());
                parametersTypes.add(Hibernate.DATE);

            } else if (searchCrit.getAttribut().equals(Request.SEARCH_BY_LAST_INTERVENING_AGENT_ID)) {
                sb.append(" and request.lastInterveningAgentId " + searchCrit.getComparatif() + " ?");
                parametersValues.add(searchCrit.getLongValue());
                parametersTypes.add(Hibernate.LONG);

            } else if (searchCrit.getAttribut().equals("belongsToCategory")) {
                sb.append(" and request.requestType.category.id in ( "
                        + searchCrit.getValue() + ")");
            
            } else if (searchCrit.getAttribut().equals(Request.SEARCH_BY_QUALITY_TYPE)) {
                 
                if (searchCrit.getValue().equals(Request.QUALITY_TYPE_ORANGE)) {
                 sb.append(" and request.orangeAlert = true")
                .append(" and request.redAlert = false");
                } else if (searchCrit.getValue().equals(Request.QUALITY_TYPE_RED)) {
                    sb.append(" and request.orangeAlert = false")
                    .append(" and request.redAlert = true");
                }
            }
        }

        if (sort != null) {
            if (sort.equals(Request.SEARCH_BY_REQUEST_ID))
                sb.append(" order by request.id");
            else if (sort.equals(Request.SEARCH_BY_HOME_FOLDER_ID))
                sb.append(" order by request.homeFolder.id");
            else if (sort.equals(Request.SEARCH_BY_REQUESTER_LASTNAME))
                sb.append(" order by request.requester.lastName");
            else if (sort.equals(Request.SEARCH_BY_CATEGORY_NAME))
                sb.append(" order by request.requestType.category.name");
            else if (sort.equals(Request.SEARCH_BY_CREATION_DATE))
                sb.append(" order by request.creationDate");
            else if (sort.equals(Request.SEARCH_BY_LAST_MODIFICATION_DATE))
                sb.append(" order by request.lastModificationDate");
            else if (sort.equals(Request.SEARCH_BY_LAST_INTERVENING_AGENT_ID))
                sb.append(" order by request.lastInterveningAgentId");
            else
                sb.append(" order by request.id");
        } else {
            // default sort order
            sb.append(" order by request.id");
        }

        if (dir != null && dir.equals("desc"))
            sb.append(" desc");
        
        Query query = HibernateUtil.getSession().createQuery(sb.toString());
        query.setParameters(parametersValues.toArray(), parametersTypes.toArray(new Type[0]));
        
        if (recordsReturned > 0)
            query.setMaxResults(recordsReturned);
        query.setFirstResult(startIndex);
        
        return query.list(); 
    }

    /**
     * A customized search method for cases where we just want the requests
     * count. Request is "manually" generated in order to do a single request in
     * DB, which is a <b>lot</b> more performant than Hibernate generated
     * queries
     */
    protected Long searchCount(final Set criteria) {

        StringBuffer sbSelect = new StringBuffer();
        sbSelect.append("select count(*) from Request as request");

        StringBuffer sb = new StringBuffer(" where 1 = 1 ");

        Iterator critIt = criteria.iterator();
        List<Type> typeList = new ArrayList<Type>();
        List<Object> objectList = new ArrayList<Object>();
        
        boolean joinedWithRequestAction = false;
        
        // go through all the criteria and create the query
        while (critIt.hasNext()) {
            Critere searchCrit = (Critere) critIt.next();

            if (searchCrit.getAttribut().equals("id")) {
                sb.append(" and request.id " + searchCrit.getComparatif() + " ?");
                objectList.add(searchCrit.getLongValue());
                typeList.add(Hibernate.LONG);
                
            } else if (searchCrit.getAttribut().equals("homeFolderId")) {
                sb.append(" and request.homeFolder " + searchCrit.getComparatif() + " ?");
                objectList.add(searchCrit.getLongValue());
                typeList.add(Hibernate.LONG);
                
            } else if (searchCrit.getAttribut().equals("requesterLastName")) {
                sb.append(" and lower(request.requester.lastName) "
                        + searchCrit.getSqlComparatif() + " lower(?)");
                objectList.add(searchCrit.getSqlStringValue());
                typeList.add(Hibernate.STRING);
                
            } else if (searchCrit.getAttribut().equals("state")) {
                sb.append(" and state " + searchCrit.getComparatif() + " ?");
                // To ensure we put the good type in the object list
                // FIXME : all states criteria should be sent as
                // RequestState objects
                if (searchCrit.getValue() instanceof RequestState)
                    objectList.add(searchCrit.getValue().toString());
                else
                    objectList.add(searchCrit.getValue());
                typeList.add(Hibernate.STRING);
                
            } else if (searchCrit.getAttribut().equals("categoryId")) {
                sb.append(" and request.requestType = requestType.id")
                    .append(" and requestType.category = category.id").append(
                        " and category.id " + searchCrit.getComparatif() + " ?");
                sbSelect.append(", RequestType as requestType")
                    .append(", Category as category");
                objectList.add(searchCrit.getLongValue());
                typeList.add(Hibernate.LONG);
                
            } else if (searchCrit.getAttribut().equals("categoryName")) {
                sb.append(" and request.requestType.category.name "
                        + searchCrit.getComparatif() + " ?");
                objectList.add(searchCrit.getValue());
                typeList.add(Hibernate.STRING);
                
            } else if (searchCrit.getAttribut().equals("requestType")) {
                sb.append(" and request.requestType " + searchCrit.getComparatif() + " ?");
                objectList.add(searchCrit.getLongValue());
                typeList.add(Hibernate.LONG);
                
            } else if (searchCrit.getAttribut().equals("requestTypeLabel")) {
                sb.append(" and request.requestType.label " + searchCrit.getComparatif()
                        + " ?");
                objectList.add(searchCrit.getValue());
                typeList.add(Hibernate.STRING);
                
            } else if (searchCrit.getAttribut().equals(Request.SEARCH_BY_RESULTING_STATE)) {
                if (!joinedWithRequestAction)
                    sb.append(" and request.id = requestAction.request");
                
                sb.append(" and requestAction.resultingState ")
                    .append(searchCrit.getComparatif()).append(" ?");

                if (!joinedWithRequestAction)
                    sbSelect.append(", RequestAction as requestAction");
                
                joinedWithRequestAction = true;
                objectList.add(searchCrit.getValue());
                typeList.add(Hibernate.STRING);
                
            } else if (searchCrit.getAttribut().equals(Request.SEARCH_BY_CREATION_DATE)) {
                sb.append(" and request.creationDate " + searchCrit.getComparatif() + " ?");
                objectList.add(searchCrit.getDateValue());
                typeList.add(Hibernate.TIMESTAMP);
                
            } else if (searchCrit.getAttribut().equals(Request.SEARCH_BY_LAST_MODIFICATION_DATE)) {
                sb.append(" and request.lastModificationDate " + searchCrit.getComparatif() + " ?");
                objectList.add(searchCrit.getDateValue());
                typeList.add(Hibernate.TIMESTAMP);
                
            } else if (searchCrit.getAttribut().equals(Request.SEARCH_BY_LAST_INTERVENING_AGENT_ID)) {
                sb.append(" and request.lastInterveningAgentId "
                        + searchCrit.getComparatif() + " ?");
                objectList.add(searchCrit.getLongValue());
                typeList.add(Hibernate.LONG);

            } else if (searchCrit.getAttribut().equals(Request.SEARCH_BY_MODIFICATION_DATE)) {
                if (!joinedWithRequestAction)
                    sb.append(" and request.id = requestAction.request");

                sb.append(" and requestAction.date ")
                    .append(searchCrit.getComparatif()).append(" ? ");

                if (!joinedWithRequestAction)
                    sbSelect.append(", RequestAction as requestAction");

                joinedWithRequestAction = true;
                objectList.add(searchCrit.getDateValue());
                typeList.add(Hibernate.TIMESTAMP);
                
            } else if (searchCrit.getAttribut().equals("belongsToCategory")) {
                sb.append(" and request.requestType.category.id in ( "
                        + searchCrit.getValue() + ")");
            } else if (searchCrit.getAttribut().equals(Request.SEARCH_BY_QUALITY_TYPE)) {
                 
                if (searchCrit.getValue().equals(Request.QUALITY_TYPE_ORANGE)) {
                 sb.append(" and request.orangeAlert = true")
                .append(" and request.redAlert = false");
                } else if (searchCrit.getValue().equals(Request.QUALITY_TYPE_RED)) {
                    sb.append(" and request.orangeAlert = false")
                    .append(" and request.redAlert = true");
                }
            }

        }

        sbSelect.append(sb);
        Type[] typeTab = typeList.toArray(new Type[0]);
        Object[] objectTab = objectList.toArray(new Object[0]);
        return (Long) HibernateUtil.getSession()
            .createQuery(sbSelect.toString())
            .setParameters(objectTab, typeTab)
            .iterate().next(); 
    }

    public Long count(final Set criteria) {
        // this function is used by the statistics service
        // but also to get a count of pending requests
        // so there is currently no way to do an access check here

        // FIXME : filter requests that agent is not authorized to see ?
        // (different service)

        // security = SecurityPolicy.get(new Request());
        // security.check(PrivilegeDescriptor.MANAGE);

        return searchCount(criteria).longValue();
    }

    public Long countByQuality(final Date startDate, final Date endDate,
            final List resultingStates, final String qualityType, final Long requestTypeId,
            final Long categoryId) {

        List<Type> typeList = new ArrayList<Type>();
        List<Object> objectList = new ArrayList<Object>();

        StringBuffer sb = new StringBuffer();
        sb.append("select count(*) from Request as request, RequestAction as requestAction")
            .append(" where request.id = requestAction.request");

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

        if (categoryId != null) {
            sb.append(" and request.requestType.category.id = '").append(categoryId)
                .append("'");
        }

        sb.append(" and requestAction.resultingState in (");
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

        if (requestTypeId != null) {
            sb.append(" and request.requestType.id = '").append(requestTypeId).append("'");
        }

        Type[] typeTab = typeList.toArray(new Type[0]);
        Object[] objectTab = objectList.toArray(new Object[0]);
        Iterator resultsIt = HibernateUtil.getSession()
            .createQuery(sb.toString())
            .setParameters(objectTab, typeTab)
            .iterate();
        if (resultsIt != null && resultsIt.hasNext())
            return  (Long)resultsIt.next();
        else
            return new Long(0);
    }

    public Long countByResultingState(final String[] resultingState, final Date startDate, final Date endDate,
            final Long requestTypeId, final Long categoryId) {

        List<Type> typeList = new ArrayList<Type>();
        List<Object> objectList = new ArrayList<Object>();

        StringBuffer sb = new StringBuffer();

        sb.append("select count(*) from Request as request, RequestAction as requestAction")
            .append(" where request.id = requestAction.request");

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

        if (categoryId != null) {
            sb.append(" and request.requestType.category.id = '").append(categoryId)
                .append("'");
        }

        if (resultingState != null && resultingState.length > 0) {
            sb.append(" and (");
            for (int i = 0; i < resultingState.length; i++) {
                String state = resultingState[i];
                sb.append(" requestAction.resultingState = '").append(state).append("'");
                if (i < (resultingState.length - 1))
                    sb.append(" or ");
            }
            sb.append(")");
        }
        
        if (requestTypeId != null) {
            sb.append(" and request.requestType.id = '").append(requestTypeId).append("'");
        }

        logger.debug("countByResultingState() sending : " + sb.toString());
        Type[] typeTab = typeList.toArray(new Type[0]);
        Object[] objectTab = objectList.toArray(new Object[0]);

        Iterator resultsIt = HibernateUtil.getSession()
                .createQuery(sb.toString())
                .setParameters(objectTab, typeTab)
                .iterate();
        
        if (resultsIt != null && resultsIt.hasNext())
            return (Long)resultsIt.next();
        else
            return new Long(0);
    }
    
    public Long oldCountByResultingState(final String[] resultingState, final Date startDate, final Date endDate,
            final Long requestTypeId, final Long categoryId) {

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

        if (categoryId != null) {
            tables.append(" request_type, category,");
            where.append(" and request.request_type_id = request_type.id ")
                .append("and request_type.category_id = ").append(categoryId);
        }

        if (resultingState != null && resultingState.length > 0) {
            where.append(" and (");
            for (int i = 0; i < resultingState.length; i++) {
                String state = resultingState[i];
                where.append(" request_action.resulting_state = '").append(state).append("'");
                if (i < (resultingState.length - 1))
                    where.append(" or ");
            }
            where.append(")");
        }
        
        if (requestTypeId != null) {
            if (tables.indexOf("request_type") == -1) {
                tables.append(" request_type,");
                where.append(" and request.request_type_id = ").append(requestTypeId);
            }
        }

        try {
            ResultSet result = HibernateUtil.getSession().connection()
                    .createStatement().executeQuery(tables.append(subquery).append(where).toString());
            if (result.next()) {
                return new Long(result.getInt(1));
            } else {
                return new Long(0);
            }
        } catch (HibernateException e) {
            e.getMessage();
        } catch (SQLException e) {
            e.getMessage();
        }
        throw new RuntimeException();
    }
    
    private String parseDate(Date date) {
        if (date == null)
            return "";
        
        // create a date formatter
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd", Locale.FRANCE);

        return df.format(date);
    }
    
    public List listByIds(final Long[] ids) {
        
        StringBuffer sb = new StringBuffer().append("from Request as request ");

        sb.append(" where request.id in (");
        for (int i = 0; i < ids.length; i++) {
            sb.append("'").append(ids[i]).append("'");
            if (i != ids.length - 1)
                sb.append(",");
        }
        sb.append(")");

        List results = HibernateUtil.getSession().createQuery(sb.toString()).list();
        return filterSearchResults(results);
    }
    
    public List listByRequester(final Long requesterId) {

        List<Type> typeList = new ArrayList<Type>();
        List<Object> objectList = new ArrayList<Object>();

        StringBuffer sb = new StringBuffer().append("from Request as request ")
            .append("where request.requester = ?");

        objectList.add(requesterId);
        typeList.add(Hibernate.LONG);

        Type[] typeTab = typeList.toArray(new Type[0]);
        Object[] objectTab = objectList.toArray(new Object[0]);
        List results = HibernateUtil.getSession()
            .createQuery(sb.toString())
            .setParameters(objectTab, typeTab)
            .list();
        return filterSearchResults(results);
    }

    public List listBySubject(final Long subjectId) {

        List<Type> typeList = new ArrayList<Type>();
        List<Object> objectList = new ArrayList<Object>();

        StringBuffer sb = new StringBuffer().append("from Request as request ")
            .append("where request.subject.id = ?");

        objectList.add(subjectId);
        typeList.add(Hibernate.LONG);

        Type[] typeTab = typeList.toArray(new Type[0]);
        Object[] objectTab = objectList.toArray(new Object[0]);
        List results = HibernateUtil.getSession()
            .createQuery(sb.toString())
            .setParameters(objectTab, typeTab)
            .list();
        return filterSearchResults(results);
    }

    public List listBySubjectAndLabel(Long subjectId, String label, RequestState[] excludedStates) {

        List<Type> typeList = new ArrayList<Type>();
        List<Object> objectList = new ArrayList<Object>();

        StringBuffer sb = new StringBuffer().append("from Request as request");

        sb.append(" where request.requestType.label = ?");
        objectList.add(label);
        typeList.add(Hibernate.STRING);

        if (subjectId != null) {
        	sb.append(" and request.subject.id = ?");
        	objectList.add(subjectId);
        	typeList.add(Hibernate.LONG);
        }
        
        if (excludedStates != null && excludedStates.length > 0) {
            for (int i = 0; i < excludedStates.length; i++) {
                sb.append(" and request.state != ?");
                objectList.add(excludedStates[i].toString());
                typeList.add(Hibernate.STRING);
            }
        }
        Type[] typeTab = typeList.toArray(new Type[0]);
        Object[] objectTab = objectList.toArray(new Object[0]);
        List results = HibernateUtil.getSession()
            .createQuery(sb.toString())
            .setParameters(objectTab, typeTab)
            .list();
        return filterSearchResults(results);
    }

    public List listByHomeFolder(final Long homeFolderId) {

        List<Type> typeList = new ArrayList<Type>();
        List<Object> objectList = new ArrayList<Object>();

        StringBuffer sb = new StringBuffer().append("from Request as request ")
            .append("where request.homeFolder = ?");

        objectList.add(homeFolderId);
        typeList.add(Hibernate.LONG);

        Type[] typeTab = typeList.toArray(new Type[0]);
        Object[] objectTab = objectList.toArray(new Object[0]);
        List results = HibernateUtil.getSession()
            .createQuery(sb.toString())
            .setParameters(objectTab, typeTab)
            .list();
        List<Request> filteredRequests = filterSearchResults(results);
        return filteredRequests;
    }

    public List listByHomeFolderAndLabel(final Long homeFolderId, final String label,
            final RequestState[] excludedStates) {

        List<Type> typeList = new ArrayList<Type>();
        List<Object> objectList = new ArrayList<Object>();

        StringBuffer sb = new StringBuffer().append("from Request as request");

        sb.append(" where request.homeFolder = ?");
        objectList.add(homeFolderId);
        typeList.add(Hibernate.LONG);

        sb.append(" and request.requestType.label = ?");
        objectList.add(label);
        typeList.add(Hibernate.STRING);

        if (excludedStates != null && excludedStates.length > 0) {
            for (int i = 0; i < excludedStates.length; i++) {
                sb.append(" and request.state != ?");
                objectList.add(excludedStates[i].toString());
                typeList.add(Hibernate.STRING);
            }
        }
        Type[] typeTab = typeList.toArray(new Type[0]);
        Object[] objectTab = objectList.toArray(new Object[0]);
        List results = HibernateUtil.getSession()
            .createQuery(sb.toString())
            .setParameters(objectTab, typeTab)
            .list();
        return filterSearchResults(results);
    }


    public List listByHomeFolderAndSeason(Long homeFolderId, String seasonUuid) {

        List<Type> typeList = new ArrayList<Type>();
        List<Object> objectList = new ArrayList<Object>();

        StringBuffer sb = new StringBuffer().append("from Request as request");

        sb.append(" where request.homeFolder = ?");
        objectList.add(homeFolderId);
        typeList.add(Hibernate.LONG);

        sb.append(" and request.seasonUuid = ?");
        objectList.add(seasonUuid);
        typeList.add(Hibernate.STRING);

        Type[] typeTab = typeList.toArray(new Type[0]);
        Object[] objectTab = objectList.toArray(new Object[0]);
        List results = HibernateUtil.getSession()
        .createQuery(sb.toString())
        .setParameters(objectTab, typeTab)
        .list();
        return filterSearchResults(results);
    }


    public List listByStateAndSeason(RequestState requestState, String seasonUuid) {
        
        List<Type> typeList = new ArrayList<Type>();
        List<Object> objectList = new ArrayList<Object>();

        StringBuffer sb = new StringBuffer().append("from Request as request");

        sb.append(" where request.state = ?");
        objectList.add(requestState.toString());
        typeList.add(Hibernate.STRING);

        sb.append(" and request.seasonUuid = ?");
        objectList.add(seasonUuid);
        typeList.add(Hibernate.STRING);

        Type[] typeTab = typeList.toArray(new Type[0]);
        Object[] objectTab = objectList.toArray(new Object[0]);
        List results = HibernateUtil.getSession()
            .createQuery(sb.toString())
            .setParameters(objectTab, typeTab)
            .list();
        return filterSearchResults(results);
    }

    public List listByLastInterveningAgentId(final Long agentId) {

        List<Type> typeList = new ArrayList<Type>();
        List<Object> objectList = new ArrayList<Object>();

        StringBuffer sb = new StringBuffer()
            .append("from Request as request ")
            .append("where request.lastInterveningAgentId = ? ");

        objectList.add(agentId);
        typeList.add(Hibernate.LONG);

        Type[] typeTab = typeList.toArray(new Type[0]);
        Object[] objectTab = objectList.toArray(new Object[0]);
        List results = HibernateUtil.getSession()
            .createQuery(sb.toString())
            .setParameters(objectTab, typeTab)
            .list();
        return filterSearchResults(results);
    }

    public List listByStates(final Set states) {

        return listByStatesAndType(states, null);
    }

    public List listByStatesAndType(final Set states, final String requestTypeLabel) {

        List<Type> typeList = new ArrayList<Type>();
        List<Object> objectList = new ArrayList<Object>();

        StringBuffer sb = new StringBuffer();
        sb.append("from Request as request ");

        boolean firstStatement = true;
        Iterator statesIt = states.iterator();
        while (statesIt.hasNext()) {
            if (firstStatement) {
                sb.append("where request.state = ? ");
                firstStatement = false;
            } else {
                sb.append("or request.state = ? ");
            }

            objectList.add(statesIt.next().toString());
            typeList.add(Hibernate.STRING);
        }

        if (requestTypeLabel != null) {
            sb.append("and request.requestType.label = ? ");
            objectList.add(requestTypeLabel);
            typeList.add(Hibernate.STRING);
        }

        Type[] typeTab = typeList.toArray(new Type[0]);
        Object[] objectTab = objectList.toArray(new Object[0]);
        List results = HibernateUtil.getSession()
            .createQuery(sb.toString())
            .setParameters(objectTab, typeTab)
            .list();
        return filterSearchResults(results);
    }

    public List listByNotMatchingActionLabel(final String actionLabel) {

        StringBuffer sb = new StringBuffer();
        sb.append("from Request as request ").append("where request.id not in (");
        sb.append("select request.id from Request as request, RequestAction as requestAction ")
            .append(" where request = requestAction.request")
            .append(" and requestAction.label = '").append(actionLabel).append("'");
        sb.append(")");

        return HibernateUtil.getSession().createQuery(sb.toString()).list();
    }

    public Long create(final Object object) throws CvqPermissionException {

        if (!(object instanceof Request))
            return super.create(object);

        // FIXME : do the setCurrentEcitizen in Vo Card Request creation method
        if (!(object instanceof VoCardRequest)) {
            cvqPolicy.check((Request) object, PrivilegeDescriptor.WRITE);
        }

        return super.create(object);
    }

    public void update(final Object object) throws CvqPermissionException {
        if (object instanceof Request)
            cvqPolicy.check((Request) object, PrivilegeDescriptor.WRITE);

        super.update(object);
    }

    public void delete(final Object object) throws CvqPermissionException {
        if (object instanceof Request)
            cvqPolicy.check((Request) object, PrivilegeDescriptor.WRITE);

        super.delete(object);
    }

    protected ArrayList<Request> filterSearchResults(final List results) {

        ArrayList<Request> resultAfterPermissionChecks = new ArrayList<Request>();
        Request request = null;
        for (int i = 0; i < results.size(); i++) {
            request = (Request) results.get(i);
            try {
                cvqPolicy.check(request, PrivilegeDescriptor.READ);
                // if we're here, we are authorized
                resultAfterPermissionChecks.add(request);
            } catch (CvqPermissionException cpe) {
                logger.debug("user is not authorized to see request " + request);
            }
        }

        return resultAfterPermissionChecks;
    }
    
    /*
     * Hacked method to bypass Hibernate mapping 'one class per subclass' strategy 
     * performance limitations.
     * - we create a 'clazz_' column initialized with value 5 in resultSet
     * - we ask Hibernate to transform the resultSet in 'VoCardRequest' object 
     * (to transport result in Capdemat)
     * 
     * note : Hibernate can instanciate a 'VoCardRequestObject' object 
     * from the added 'clazz_' information
     */
    private Request nativeSqlFindById(final Long id) {
        Object request = HibernateUtil.getSession()
             .createSQLQuery(
                     "SELECT id," 
                         +"creation_date," 
                         +"last_modification_date," 
                         +"requester_id," 
                         +"request_type_id," 
                         +"state," 
                         +"request_step," 
                         +"home_folder_id," 
                         +"data_state," 
                         +"last_intervening_agent_id," 
                         +"orange_alert," 
                         +"red_alert," 
                         +"validation_date," 
                         +"subject_table_name," 
                         +"subject_id," 
                         +"season_uuid," 
                         +"means_of_contact_id,"
                         +"5 AS clazz_"
                     +" FROM request WHERE id=" + id)
             .addEntity(VoCardRequest.class)
             .uniqueResult();
        
         return (Request)request;
     }
}
