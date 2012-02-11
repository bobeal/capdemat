package fr.cg95.cvq.util.admin;

import java.lang.reflect.InvocationTargetException;
import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import fr.cg95.cvq.business.request.external.RequestExternalAction;
import fr.cg95.cvq.dao.jpa.IGenericDAO;
import fr.cg95.cvq.dao.jpa.JpaUtil;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.external.IExternalProviderService;
import fr.cg95.cvq.service.authority.impl.LocalAuthorityRegistry;
import fr.cg95.cvq.service.request.external.IRequestExternalActionService;
import fr.cg95.cvq.service.request.external.IRequestExternalService;
import fr.cg95.cvq.util.Critere;

public class EdemandeTracesSquasher {

    private IExternalProviderService edemandeService;

    private IGenericDAO genericDAO;

    private LocalAuthorityRegistry localAuthorityRegistry;

    private IRequestExternalActionService requestExternalActionService;

    private IRequestExternalService requestExternalService;

    public static void main(final String[] args) {
        ClassPathXmlApplicationContext context = SpringApplicationContextLoader.loadContext(null);
        EdemandeTracesSquasher ets = new EdemandeTracesSquasher();
        ets.edemandeService = context.getBean("edemandeExternalService", IExternalProviderService.class);
        ets.genericDAO = context.getBean("genericDAO", IGenericDAO.class);
        ets.localAuthorityRegistry = context.getBean("localAuthorityRegistry", LocalAuthorityRegistry.class);
        ets.requestExternalActionService = context.getBean("requestExternalActionService", IRequestExternalActionService.class);
        ets.requestExternalService = context.getBean("requestExternalService", IRequestExternalService.class);
        ets.localAuthorityRegistry.browseAndCallback(ets, "migrate", new String[0]);
        System.exit(0);
    }

    public void migrate()
        throws CvqException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        Set<Critere> criterias = new HashSet<Critere>();
        criterias.add(new Critere(RequestExternalAction.SEARCH_BY_NAME, edemandeService.getLabel(),
            Critere.EQUALS));
        for (String key : requestExternalService.getKeys(criterias)) {
            RequestExternalAction previous = null;
            Set<Critere> criterias2 = new HashSet<Critere>(criterias);
            criterias2.add(new Critere(RequestExternalAction.SEARCH_BY_KEY, key, Critere.EQUALS));
            for (RequestExternalAction action : requestExternalActionService.getTraces(criterias2,
                RequestExternalAction.SEARCH_BY_DATE, "asc", 0, 0)) {
                if (previous != null && previous.getStatus().equals(action.getStatus()) &&
                    StringUtils.equals((String)action.getComplementaryData().get("individual"),
                        (String)action.getComplementaryData().get("individual"))) {
                    Integer count = (Integer)previous.getComplementaryData().get("count");
                    if (count == null) count = 2; else count++;
                    action.getComplementaryData().put("count", count);
                    genericDAO.delete(previous);
                    genericDAO.update(action);
                }
                previous = action;
            }
            JpaUtil.closeAndReOpen(false);
        }
    }
}
