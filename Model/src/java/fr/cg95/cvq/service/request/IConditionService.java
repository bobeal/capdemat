package fr.cg95.cvq.service.request;

import java.util.Map;

public interface IConditionService {

    /**
     * Entry point for business conditions treatments.
     * 
     * @param triggers - A map where key=control.name and value=control.value, 
     *      for all controls triggering the same condition 
     */
    boolean isConditionFilled (final String requestTypeLabel, Map<String, String> triggers);
}
