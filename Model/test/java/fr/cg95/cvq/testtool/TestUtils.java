package fr.cg95.cvq.testtool;

import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;

import fr.cg95.cvq.business.request.LocalReferentialEntry;
import fr.cg95.cvq.business.request.LocalReferentialType;
import fr.cg95.cvq.business.request.Request;
import fr.cg95.cvq.business.users.Adult;
import fr.cg95.cvq.business.users.Child;
import fr.cg95.cvq.business.users.HomeFolder;
import fr.cg95.cvq.business.users.Individual;
import fr.cg95.cvq.service.request.IRequestWorkflowService;
import fr.cg95.cvq.util.development.BusinessObjectsFactory;

public final class TestUtils {

    protected static Logger logger = Logger.getLogger(TestUtils.class);

    public static void feedRequestSubject(Request request, String subjectPolicy, 
            Adult requester, HomeFolder homeFolder) {
        
        if (homeFolder != null) {
            List<Individual> individuals = homeFolder.getIndividuals();
            for (Individual individual : individuals) {
                if (individual instanceof Adult && 
                        (subjectPolicy.equals(IRequestWorkflowService.SUBJECT_POLICY_ADULT)
                                || subjectPolicy.equals(IRequestWorkflowService.SUBJECT_POLICY_INDIVIDUAL))) {
                    request.setSubjectId(individual.getId());
                    break;
                } else if (individual instanceof Child 
                        && subjectPolicy.equals(IRequestWorkflowService.SUBJECT_POLICY_CHILD)) {
                    request.setSubjectId(individual.getId());
                    break;
                }
            }
        } else {
            if (subjectPolicy.equals(IRequestWorkflowService.SUBJECT_POLICY_ADULT)
                                || subjectPolicy.equals(IRequestWorkflowService.SUBJECT_POLICY_INDIVIDUAL)) {
                request.setSubjectId(request.getRequesterId());
            } else if (subjectPolicy.equals(IRequestWorkflowService.SUBJECT_POLICY_CHILD)) {
                Child child = BusinessObjectsFactory.gimmeChild("LASTNAME", "Firstname");
                request.setSubjectId(child.getId());
            }
        }
    }
    
    public static void printLocalRefData(Iterable<LocalReferentialType> allLocalReferentialData) {

        for (LocalReferentialType lrt : allLocalReferentialData) {
            logger.debug("Data name : " + lrt.getName());

            logger.debug("Label : " + lrt.getLabel());

            logger.debug("Entries support multiple : " + lrt.isMultiple());

            if (lrt.getEntries() != null) {
                for (LocalReferentialEntry lre : lrt.getEntries()) {
                    printEntry(lre, 0);
                }
            }
        }
    }


    public static void printEntry(LocalReferentialEntry lre, int depth) {

        logger.debug("(" + depth + ") Key : " + lre.getKey());

        logger.debug("(" + depth + ") Label : " + lre.getLabel());

        logger.debug("(" + depth + ") Message : " + lre.getMessage());

        Set<LocalReferentialEntry> entries = lre.getEntries();
        if (entries != null) {
            for (LocalReferentialEntry subLre : entries) {
                printEntry(subLre, depth + 1);
            }
        }
    }
}
