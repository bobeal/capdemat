package fr.cg95.cvq.util.admin;

import java.lang.reflect.InvocationTargetException;
import java.util.HashSet;
import java.util.Set;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import fr.cg95.cvq.business.request.Request;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.service.request.IRequestSearchService;
import fr.cg95.cvq.service.request.IRequestService;
import fr.cg95.cvq.service.request.IRequestWorkflowService;
import fr.cg95.cvq.util.Critere;

public class StudyGrantDistanceStepRemover {

    private IRequestSearchService requestSearchService;

    private IRequestWorkflowService requestWorkflowService;

    private IRequestService studyGrantRequestService;

    public static void main(final String[] args) {
        ClassPathXmlApplicationContext context = SpringApplicationContextLoader.loadContext(null);
        StudyGrantDistanceStepRemover r = new StudyGrantDistanceStepRemover();
        r.requestSearchService = context.getBean("requestSearchService", IRequestSearchService.class);
        r.requestWorkflowService = context.getBean("requestWorkflowService", IRequestWorkflowService.class);
        r.studyGrantRequestService = context.getBean("studyGrantRequestService", IRequestService.class);
        System.exit(0);
    }

    public void migrate()
        throws CvqException, ClassNotFoundException, IllegalAccessException,
            InvocationTargetException, NoSuchMethodException {
        Set<Critere> criterias = new HashSet<Critere>();
        criterias.add(new Critere(Request.SEARCH_BY_REQUEST_TYPE_LABEL, studyGrantRequestService.getLabel(), Critere.EQUALS));
        for (Request request : requestSearchService.get(criterias, null, null, 0, 0, true)) {
            request.getStepStates().remove("calculationElements");
            requestWorkflowService.validate(request, null);
        }
    }
}
