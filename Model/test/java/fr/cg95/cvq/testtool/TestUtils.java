package fr.cg95.cvq.testtool;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;

import fr.cg95.cvq.business.authority.LocalReferentialEntry;
import fr.cg95.cvq.business.authority.LocalReferentialType;
import fr.cg95.cvq.business.request.Request;
import fr.cg95.cvq.business.users.Adult;
import fr.cg95.cvq.business.users.Child;
import fr.cg95.cvq.business.users.HomeFolder;
import fr.cg95.cvq.business.users.Individual;
import fr.cg95.cvq.service.request.IRequestService;

public final class TestUtils {

    protected static Logger logger = Logger.getLogger(TestUtils.class);

    public static void feedRequestSubject(Request request, String subjectPolicy, 
            Adult requester, HomeFolder homeFolder) {
        
        if (homeFolder != null) {
            List<Individual> individuals = homeFolder.getIndividuals();
            for (Individual individual : individuals) {
                if (individual instanceof Adult && 
                        (subjectPolicy.equals(IRequestService.SUBJECT_POLICY_ADULT)
                                || subjectPolicy.equals(IRequestService.SUBJECT_POLICY_INDIVIDUAL))) {
                    request.setSubjectId(individual.getId());
                    break;
                } else if (individual instanceof Child 
                        && subjectPolicy.equals(IRequestService.SUBJECT_POLICY_CHILD)) {
                    request.setSubjectId(individual.getId());
                    break;
                }
            }
        } else {
            if (subjectPolicy.equals(IRequestService.SUBJECT_POLICY_ADULT)
                                || subjectPolicy.equals(IRequestService.SUBJECT_POLICY_INDIVIDUAL)) {
                request.setSubjectId(request.getRequesterId());
            } else if (subjectPolicy.equals(IRequestService.SUBJECT_POLICY_CHILD)) {
                Child child = BusinessObjectsFactory.gimmeChild("LASTNAME", "Firstname");
                request.setSubjectId(child.getId());
            }
        }
    }
    
    public static void printLocalRefData(Set allLocalReferentialData) {

        Iterator dataIt = allLocalReferentialData.iterator();
        while (dataIt.hasNext()) {
            LocalReferentialType lrt = (LocalReferentialType) dataIt.next();
            logger.debug("From request : " + lrt.getRequest());
            logger.debug("Data name : " + lrt.getDataName());

            logger.debug("Labels : ");
            Map labelsMap = lrt.getLabelsMap();
            Iterator langIt = labelsMap.keySet().iterator();
            while (langIt.hasNext()) {
                String lang = (String) langIt.next();
                String value = (String) labelsMap.get(lang);
                logger.debug("Data for lang : " + lang + " is " + value);
            }

            logger.debug("Entries support priority : " + lrt.getEntriesSupportPriority());
            logger.debug("Entries support precision : " + lrt.getEntriesSupportPrecision());
            logger.debug("Entries support quota : " + lrt.getEntriesSupportQuota());
            logger.debug("Entries support multiple : " + lrt.getEntriesSupportMultiple());

            if (lrt.getEntries() != null) {
                Set entries = lrt.getEntries();
                Iterator entriesIt = entries.iterator();
                while (entriesIt.hasNext()) {
                    LocalReferentialEntry lre = (LocalReferentialEntry) entriesIt.next();
                    printEntry(lre, 0);
                }
            }
        }
    }

    public static void printLocalRefDataSummary(Map allLocalRefDataSummary) {

        Iterator keysIt = allLocalRefDataSummary.keySet().iterator();
        while (keysIt.hasNext()) {
            String dataName = (String) keysIt.next();
            logger.debug("Labels : ");
            Map labelsMap = (Map) allLocalRefDataSummary.get(dataName);
            Iterator langIt = labelsMap.keySet().iterator();
            while (langIt.hasNext()) {
                String lang = (String) langIt.next();
                String value = (String) labelsMap.get(lang);
                logger.debug("Data for lang : " + lang + " is " + value);
            }
        }
    }


    public static void printEntry(LocalReferentialEntry lre, int depth) {

        logger.debug("(" + depth + ") Key : " + lre.getKey());

        Map labelsMap = lre.getLabelsMap();
        Set labelsMapKeys = labelsMap.keySet();
        Iterator labelsMapKeysIt = labelsMapKeys.iterator();
        while (labelsMapKeysIt.hasNext()) {
            String key = (String) labelsMapKeysIt.next();
            logger.debug("(" + depth + ") Label in " + key + " : " + labelsMap.get(key));
        }

        Map messagesMap = lre.getMessagesMap();
        if (messagesMap != null) {
            Set messagesMapKeys = messagesMap.keySet();
            Iterator messagesMapKeysIt = messagesMapKeys.iterator();
            while (messagesMapKeysIt.hasNext()) {
                String key = (String) messagesMapKeysIt.next();
                logger.debug("(" + depth + ") Message in " + key + " : " + messagesMap.get(key));
            }
        }

        Map precisionsMap = lre.getPrecisionsMap();
        if (precisionsMap != null) {
            Set precisionsMapKeys = precisionsMap.keySet();
            Iterator precisionsMapKeysIt = precisionsMapKeys.iterator();
            while (precisionsMapKeysIt.hasNext()) {
                String key = (String) precisionsMapKeysIt.next();
                Map precLabelsMap = (Map) precisionsMap.get(key);
                Set precLabelsMapKeys = precLabelsMap.keySet();
                Iterator precLabelsMapKeysIt = precLabelsMapKeys.iterator();
                while (precLabelsMapKeysIt.hasNext()) {
                    String langKey = (String) precLabelsMapKeysIt.next();
                    logger.debug("(" + depth + ") Precision " + key + " has label "
                                 + precLabelsMap.get(langKey) + " in " + langKey);
                }
            }
        }

        logger.debug("(" + depth + ") Entries support priority : " + lre.getEntriesSupportPriority());
        logger.debug("(" + depth + ") Entries support precision : " + lre.getEntriesSupportPrecision());
        logger.debug("(" + depth + ") Entries support multiple : " + lre.getEntriesSupportMultiple());

        Set entries = lre.getEntries();
        if (entries != null) {
            Iterator entriesIt = entries.iterator();
            while (entriesIt.hasNext()) {
                LocalReferentialEntry subLre = (LocalReferentialEntry) entriesIt.next();
                printEntry(subLre, depth + 1);
            }
        }
    }
}
