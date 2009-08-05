package fr.cg95.cvq.util.admin;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import fr.cg95.cvq.business.request.Request;
import fr.cg95.cvq.business.request.RequestState;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.exception.CvqInvalidTransitionException;
import fr.cg95.cvq.exception.CvqObjectNotFoundException;
import fr.cg95.cvq.service.authority.ILocalAuthorityRegistry;
import fr.cg95.cvq.service.authority.impl.LocalAuthorityRegistry;
import fr.cg95.cvq.service.request.IRequestService;
import fr.cg95.cvq.service.request.IRequestWorkflowService;
import fr.cg95.cvq.util.Critere;

/**
 * Changes all requests of a specified request type in the specified initial
 * state and updates their state to the specified target state.
 * 
 * @author jsb@zenexity.fr
 *
 */
public class RequestWorkflowNavigator {

    private static Logger logger =
        Logger.getLogger(RequestWorkflowNavigator.class);

    private static ILocalAuthorityRegistry localAuthorityRegistry;
    private static IRequestService requestService;
    private static IRequestWorkflowService requestWorkflowService;
    private static String defaultMotive =
        "Automatic state change by RequestWorkflowNavigator";

    public static void main(final String[] args) throws Exception {
        Logger rootLogger = Logger.getRootLogger();
        rootLogger.setLevel(Level.OFF);
        logger.setLevel(Level.INFO);
        if (args.length == 0 || args[0].equals("help")
            || (args.length != 4 && args.length != 5)) {
            printUsageAndExit();
        }
        String requestTypeLabel = args[1];
        String initialState = args[2];
        String targetState = args[3];
        String motive = args.length == 5 ? args[4] : defaultMotive;
        ClassPathXmlApplicationContext cpxa =
            SpringApplicationContextLoader.loadContext(args[0]);
        localAuthorityRegistry =
            (LocalAuthorityRegistry)cpxa.getBean("localAuthorityRegistry");
        requestService =
            (IRequestService)cpxa.getBean("defaultRequestService");
        requestWorkflowService =
            (IRequestWorkflowService)cpxa.getBean("requestWorkflowService");
        RequestWorkflowNavigator requestWorkflowNavigator =
            new RequestWorkflowNavigator();
        localAuthorityRegistry.browseAndCallback(requestWorkflowNavigator,
            "navigateWorkflow",
            new Object[]{requestTypeLabel, initialState, targetState, motive});
        System.exit(0);
    }

    public void navigateWorkflow(String requestTypeLabel, String initial,
        String target, String motive) {
        RequestState initialState = RequestState.forString(initial);
        RequestState targetState = RequestState.forString(target);
        if (!requestWorkflowService.getStatesBefore(targetState)
            .contains(initialState)) {
            System.out.println("FAILED : Target state " + targetState +
                " isn't one transition away from initial state "
                + initialState + " !");
            printUsageAndExit();
        }
        Set<Critere> criteres = new HashSet<Critere>();
        Critere critere = new Critere(Request.SEARCH_BY_STATE,
                initialState, Critere.EQUALS);
        criteres.add(critere);
        critere = new Critere(Request.SEARCH_BY_REQUEST_TYPE_LABEL,
            requestTypeLabel, Critere.EQUALS);
        criteres.add(critere);
        List<Request> requests;
        Set<Long> successes = new HashSet<Long>();
        Set<Long> failures = new HashSet<Long>();
        try {
            requests = requestService.get(criteres, null, null, 0, 0);
        } catch (CvqException e) {
            e.printStackTrace();
            System.out.println("Couldn't get the list of requests, aborting.");
            return;
        }
        System.out.println("Found " + requests.size() + " requests to update");
        for (Request request : requests) {
            System.out.print("Handling request " + request.getId() + "... ");
            try {
                requestWorkflowService.updateRequestState(request.getId(),
                    targetState, motive);
                System.out.println("OK");
                successes.add(request.getId());
            } catch (CvqInvalidTransitionException e) {
                e.printStackTrace();
                System.out.println("FAILED");
                failures.add(request.getId());
            } catch (CvqObjectNotFoundException e) {
                e.printStackTrace();
                System.out.println("FAILED");
                failures.add(request.getId());
            } catch (CvqException e) {
                e.printStackTrace();
                System.out.println("FAILED");
                failures.add(request.getId());
            }
        }
        if (failures.isEmpty()) {
            System.out.println("All request states were successfully updated");
        } else {
            System.out
                .println("Warning : some request states couldn't be updated");
        }
        try {
            FileOutputStream fos =
                new FileOutputStream(File.createTempFile("successfull", ".txt"));
            for (Long id : successes) fos.write((id + "\n").getBytes());
        } catch(IOException ioe){
            ioe.printStackTrace();
            System.out.println(
                "Couldn't write the list of successful IDs to disk; displaying them here :");
            for (Long id : successes) System.out.println(id);
        }
        try {
            FileOutputStream fos =
                new FileOutputStream(File.createTempFile("failed", ".txt"));
            for (Long id : failures) fos.write((id + "\n").getBytes());
        } catch(IOException ioe) {
            ioe.printStackTrace();
            System.out.println(
                "Couldn't write the list of failed IDs to disk; displaying them here :");
            for (Long id : failures) System.out.println(id);
        }
    }

    private static void printUsageAndExit() {
        System.out.println(" USAGE -              ./invoke_request_validator.sh [MODE] [REQUEST TYPE LABEL] [INITIAL STATE] [TARGET STATE]");
        System.out.println("  - [MODE] : One of { deployment | dev | help }");
        System.out.println("  - [REQUEST TYPE LABEL] : The request type to handle");
        System.out.println("  - [INITIAL STATE] : The state of requests to handle");
        System.out.println("  - [TARGET STATE] : The target state; must be one transition away from initial state");
        System.out.println("  - [MOTIVE] : Motive for state change (optional, default value : \"" + defaultMotive + "\")");
        System.exit(0);
    }
}
