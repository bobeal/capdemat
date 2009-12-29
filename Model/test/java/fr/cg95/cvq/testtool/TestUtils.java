package fr.cg95.cvq.testtool;

import java.util.List;
import java.util.Map;
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
    
    public static void printLocalRefData(Set<LocalReferentialType> allLocalReferentialData) {

        for (LocalReferentialType lrt : allLocalReferentialData) {
            logger.debug("From request : " + lrt.getRequest());
            logger.debug("Data name : " + lrt.getDataName());

            logger.debug("Labels : ");
            Map<String, String> labelsMap = lrt.getLabelsMap();
            for (String lang : labelsMap.keySet()) {
                String value = labelsMap.get(lang);
                logger.debug("Data for lang : " + lang + " is " + value);
            }

            logger.debug("Entries support priority : " + lrt.getEntriesSupportPriority());
            logger.debug("Entries support precision : " + lrt.getEntriesSupportPrecision());
            logger.debug("Entries support multiple : " + lrt.getEntriesSupportMultiple());

            if (lrt.getEntries() != null) {
                for (LocalReferentialEntry lre : lrt.getEntries()) {
                    printEntry(lre, 0);
                }
            }
        }
    }

    public static void printLocalRefDataSummary(Map<String, Map<String, String>> allLocalRefDataSummary) {

        for (String dataName : allLocalRefDataSummary.keySet()) {
            logger.debug("Labels : ");
            Map<String, String> labelsMap = allLocalRefDataSummary.get(dataName);
            for (String lang : labelsMap.keySet()) {
                String value = labelsMap.get(lang);
                logger.debug("Data for lang : " + lang + " is " + value);
            }
        }
    }


    public static void printEntry(LocalReferentialEntry lre, int depth) {

        logger.debug("(" + depth + ") Key : " + lre.getKey());

        Map<String, String> labelsMap = lre.getLabelsMap();
        Set<String> labelsMapKeys = labelsMap.keySet();
        for (String key : labelsMapKeys) {
            logger.debug("(" + depth + ") Label in " + key + " : " + labelsMap.get(key));
        }

        Map<String, String> messagesMap = lre.getMessagesMap();
        if (messagesMap != null) {
            Set<String> messagesMapKeys = messagesMap.keySet();
            for (String key : messagesMapKeys) {
                logger.debug("(" + depth + ") Message in " + key + " : " + messagesMap.get(key));
            }
        }

        Map<String, Map<String, String>> precisionsMap = lre.getPrecisionsMap();
        if (precisionsMap != null) {
            Set<String> precisionsMapKeys = precisionsMap.keySet();
            for (String key : precisionsMapKeys) {
                Map<String, String> precLabelsMap = precisionsMap.get(key);
                Set<String> precLabelsMapKeys = precLabelsMap.keySet();
                for (String langKey : precLabelsMapKeys) {
                    logger.debug("(" + depth + ") Precision " + key + " has label "
                            + precLabelsMap.get(langKey) + " in " + langKey);
                }
            }
        }

        logger.debug("(" + depth + ") Entries support priority : " + lre.getEntriesSupportPriority());
        logger.debug("(" + depth + ") Entries support precision : " + lre.getEntriesSupportPrecision());
        logger.debug("(" + depth + ") Entries support multiple : " + lre.getEntriesSupportMultiple());

        Set<LocalReferentialEntry> entries = lre.getEntries();
        if (entries != null) {
            for (LocalReferentialEntry subLre : entries) {
                printEntry(subLre, depth + 1);
            }
        }
    }
}
