package fr.capwebct.capdemat.plugins.externalservices.horanet.service;

import fr.cg95.cvq.business.school.SchoolCanteenRegistrationRequest;
import fr.cg95.cvq.business.users.Request;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.service.users.IRequestServiceRegistry;
import fr.cg95.cvq.service.users.IRequestService;
import fr.cg95.cvq.service.authority.LocalAuthorityConfigurationBean;
import fr.cg95.cvq.dao.hibernate.HibernateUtil;
import fr.cg95.cvq.security.SecurityContext;
import fr.cg95.cvq.external.IExternalService;

import org.hibernate.SessionFactory;

import org.apache.log4j.Logger;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Iterator;
import java.util.Set;
import java.util.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Utility class to test interactions with HoraNet on command line.
 *
 * @author Benoit Orihuela (bor@zenexity.fr) bor@zenexity.fr
 * @deprecated
 */
public class HoranetCommandLineTester {

    private static Logger logger = Logger.getLogger(HoranetCommandLineTester.class);
    private static IExternalService service = null;
    private static IRequestService requestService;

    public HoranetCommandLineTester() {
    }

    public final void sendRequest(final String requestId) throws CvqException {

        if (requestId != null) {
            Request request = null;
            try {
                request = requestService.getById(new Long(requestId));
            } catch (RuntimeException e) {
                e.printStackTrace();
                throw new CvqException("Could not get request : " + e.toString());
            }
            logger.error("Sending request");
            service.sendRequest(request);
        }
    }

    public final void creditAccount(final String homeFolderId, final String accountId,
                                    final String childId, final String requestId)
        throws CvqException {

//        if (homeFolderId != null && accountId != null && childId != null && requestId != null) {
//            PurchaseItem purchaseItem = new PurchaseItem(accountId, "label-test", 0, new Date(),
//                    Long.valueOf(childId), null, 3, 350);
//            Collection purchaseItems = new ArrayList();
//            purchaseItems.add(purchaseItem);
//            logger.error("Crediting account");
//            service.creditHomeFolderAccounts(purchaseItems, "transaction-test",
//                                             "bank-grant-test", Long.valueOf(homeFolderId), new Date());
//        }
    }

    public final void getConsumptions(final String requestId) throws CvqException {

        if (requestId != null) {
            Request request = null;
            try {
                request = requestService.getById(new Long(requestId));
            } catch (RuntimeException e) {
                e.printStackTrace();
                throw new CvqException("Could not get request : " + e.toString());
            }
            logger.error("Asking for consumptions");

            Calendar fromDate = new GregorianCalendar();
            fromDate.setTime(new Date());
            fromDate.set(Calendar.DAY_OF_MONTH, 1);
            Calendar toDate = new GregorianCalendar();
            toDate.setTime(new Date());
            toDate.set(Calendar.DAY_OF_MONTH, 28);

            logger.debug("Start date " + fromDate.getTime());
            logger.debug("End date " + toDate.getTime());

            service.getConsumptionsByRequest(request, fromDate.getTime(), toDate.getTime());
        }
    }

    public static void main(final String[] args) throws Exception {
        String config = args[0];
        String localAuthorityName = args[1];
        String action = args[2];

        String[] configLocations = new String[3];
        configLocations[0] = "/applicationContext.xml";
        if (config != null && config.equals("test"))
            configLocations[1] = "/applicationContext-test.xml";
        else
            configLocations[1] = "/applicationContext-deployment.xml";
        configLocations[2] = "/localAuthority-" + localAuthorityName.toLowerCase() + ".xml";

        ClassPathXmlApplicationContext cpxa = new ClassPathXmlApplicationContext(configLocations);
        SessionFactory sessionFactory =
            (SessionFactory) cpxa.getBean("sessionFactory_" + localAuthorityName.toLowerCase());

        try {
            HibernateUtil.setSessionFactory(sessionFactory);
            HibernateUtil.beginTransaction();

            SecurityContext.setCurrentSite(localAuthorityName.toLowerCase(),
                    SecurityContext.BACK_OFFICE_CONTEXT);
            SecurityContext.setCurrentAgent(localAuthorityName.toLowerCase() + ".admin");

            IRequestServiceRegistry requestServiceRegistry =
                (IRequestServiceRegistry) cpxa.getBean("requestServiceRegistry");
            SchoolCanteenRegistrationRequest scrr = new SchoolCanteenRegistrationRequest();
            requestService = (IRequestService) requestServiceRegistry.getRequestService(scrr);
            LocalAuthorityConfigurationBean lacb = SecurityContext.getCurrentConfigurationBean();
            logger.error("Searching service " + requestService.getLabel());
            Set externalServices =
                lacb.getExternalServicesByRequestType(requestService.getLabel());
            Iterator externalServicesIt = externalServices.iterator();
            while (externalServicesIt.hasNext()) {
                IExternalService tempService = (IExternalService) externalServicesIt.next();
                if (tempService instanceof HoranetService)
                    service = tempService;
            }
            if (service == null) {
                logger.error("Did not find Horanet service");
                return;
            }

            HoranetCommandLineTester hclt = new HoranetCommandLineTester();

            if (action.equals("sendRequest")) {
                hclt.sendRequest(args[3]);
            } else if (action.equals("helloWorld")) {
//                 hclt.helloWorld();
            } else if (action.equals("getConsumptions")) {
                hclt.getConsumptions(args[3]);
            } else if (action.equals("creditAccount")) {
                hclt.creditAccount(args[3], args[4], args[5], args[6]);
            }
        } catch (Exception e) {
            System.out.println("Erreur: " + e.getClass() + "Message:" + e.getMessage());
            e.printStackTrace();
            HibernateUtil.rollbackTransaction();
        } finally {
            HibernateUtil.commitTransaction();
        }
    }
}
