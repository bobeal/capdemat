package fr.cg95.cvq.service.request;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import fr.cg95.cvq.business.authority.Category;
import fr.cg95.cvq.business.request.Request;

/**
 * Some utility methods to manipulate request objects.
 * 
 * @author Benoit Orihuela (bor@zenexity.fr)
 */
public class RequestUtils {

    private static Logger logger = Logger.getLogger(RequestUtils.class);
    
    /**
     * Sort a list of requests by type.
     */
    public static void groupByRequestType(final List<Request> requests) {
        Collections.sort(requests, new Comparator<Request>() {
            public int compare(Request r1, Request r2) {
                return r1.getRequestType().getLabel().compareTo(r2.getRequestType().getLabel());
            }
        });
    }
    
    /**
     * Organize a list of requests by category.
     */
    public static Map<Category, List<Request>> groupByCategory(final List<Request> requests) {
        Map<Category, List<Request>> resultMap = new HashMap<Category, List<Request>>();
        for (Request request : requests) {
            Category category = request.getRequestType().getCategory();
            if (category != null) {
                if (resultMap.get(category) == null) {
                    List<Request> requestList = new ArrayList<Request>();
                    requestList.add(request);
                    resultMap.put(category, requestList);
                } else {
                    List<Request> requestList = resultMap.get(category);
                    requestList.add(request);
                }
            } else {
                logger.warn("groupByCategory() request " + request 
                        + " has no associated category");
            }
        }

        return resultMap;
    }
}
