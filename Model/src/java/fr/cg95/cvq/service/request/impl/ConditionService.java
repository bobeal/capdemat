package fr.cg95.cvq.service.request.impl;

import java.util.Map;
import java.util.Map.Entry;

import fr.cg95.cvq.service.request.IConditionService;
import fr.cg95.cvq.service.request.IRequestServiceRegistry;
import fr.cg95.cvq.service.request.condition.IConditionChecker;

public class ConditionService implements IConditionService {

    private IRequestServiceRegistry requestServiceRegistry;

    @Override
    public boolean isConditionFilled(final String requestTypeLabel, Map<String, String> triggers) {
        Map<String, IConditionChecker> requestConditions = null;
        try {
            requestConditions = (Map<String, IConditionChecker>)
                requestServiceRegistry.getRequestService(requestTypeLabel)
                    .getSkeletonRequest().getClass().getField("conditions").get(null);
        } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        for (Entry<String, String> trigger : triggers.entrySet()) {
            if (requestConditions.get(trigger.getKey()) == null
                || !requestConditions.get(trigger.getKey()).test(trigger.getValue()))
                return false;
        }
        return true;
    }

    public void setRequestServiceRegistry(IRequestServiceRegistry requestServiceRegistry) {
        this.requestServiceRegistry = requestServiceRegistry;
    }
}
