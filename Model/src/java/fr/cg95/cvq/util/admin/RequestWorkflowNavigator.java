package fr.cg95.cvq.util.admin;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
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
import fr.cg95.cvq.service.request.IRequestSearchService;
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
    private static IRequestSearchService requestSearchService;
    private static IRequestWorkflowService requestWorkflowService;
    
    private static String defaultMotive =
        "Automatic state change by RequestWorkflowNavigator";
    private static List<Request> requests;
    private static Set<String> successes = new HashSet<String>();
    private static Set<String> failures = new HashSet<String>();
    private static String localAuthority;
    private static String requestTypeLabel;
    private static RequestState initialState;
    private static RequestState targetState;

    public static void main(final String[] args) throws Exception {
        Logger rootLogger = Logger.getRootLogger();
        rootLogger.setLevel(Level.OFF);
        logger.setLevel(Level.INFO);
        if (args.length == 0 || args[0].equals("help")
            || (args.length != 5 && args.length != 6)) {
            printUsageAndExit();
        }
        localAuthority = args[1];
        requestTypeLabel = args[2];
        initialState = RequestState.forString(args[3]);
        if (!initialState.toString().equals(args[3])) {
            System.out.println("ERROR : unrecognized initial state " + args[3]);
            System.exit(0);
        }
        targetState = RequestState.forString(args[4]);
        if (!targetState.toString().equals(args[4])) {
            System.out.println("ERROR : unrecognized target state " + args[4]);
            System.exit(0);
        }
        String motive = args.length == 6 ? args[5] : defaultMotive;
        ClassPathXmlApplicationContext cpxa =
            SpringApplicationContextLoader.loadContext(args[0]);
        localAuthorityRegistry =
            (LocalAuthorityRegistry)cpxa.getBean("localAuthorityRegistry");
        requestSearchService =
            (IRequestSearchService)cpxa.getBean("requestSearchService");
        requestWorkflowService =
            (IRequestWorkflowService)cpxa.getBean("requestWorkflowService");
        if (!Arrays.asList(requestWorkflowService.getStatesBefore(targetState))
            .contains(initialState)) {
            System.out.println("FAILED : Target state " + targetState +
                " isn't one transition away from initial state "
                + initialState + " !");
            printUsageAndExit();
        }
        RequestWorkflowNavigator requestWorkflowNavigator =
            new RequestWorkflowNavigator();
        localAuthorityRegistry.callback(localAuthority,
            requestWorkflowNavigator, "setRequests", new Object[0]);
        System.out.println("Found " + requests.size() + " requests to update");
        for (Request request : requests) {
            localAuthorityRegistry.callback(localAuthority,
                requestWorkflowNavigator, "navigateWorkflow",
                new Object[]{request.getId().toString(), motive});
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
            for (String id : successes) fos.write((id + "\n").getBytes());
        } catch(IOException ioe){
            ioe.printStackTrace();
            System.out.println(
                "Couldn't write the list of successful IDs to disk; displaying them here :");
            for (String id : successes) System.out.println(id);
        }
        try {
            FileOutputStream fos =
                new FileOutputStream(File.createTempFile("failed", ".txt"));
            for (String id : failures) fos.write((id + "\n").getBytes());
        } catch(IOException ioe) {
            ioe.printStackTrace();
            System.out.println(
                "Couldn't write the list of failed IDs to disk; displaying them here :");
            for (String id : failures) System.out.println(id);
        }
        System.out.println("Exiting.");
        System.exit(0);
    }

    public void navigateWorkflow(String requestId, String motive) {
        System.out.print("Handling request " + requestId + "... ");
        try {
            requestWorkflowService.updateRequestState(Long.valueOf(requestId),
                targetState, motive);
            System.out.println("OK");
            successes.add(requestId);
        } catch (CvqInvalidTransitionException e) {
            e.printStackTrace();
            System.out.println("FAILED");
            failures.add(requestId);
        } catch (CvqObjectNotFoundException e) {
            e.printStackTrace();
            System.out.println("FAILED");
            failures.add(requestId);
        } catch (CvqException e) {
            e.printStackTrace();
            System.out.println("FAILED");
            failures.add(requestId);
        }
    }

    private static void printUsageAndExit() {
        System.out.println(" USAGE -              ./invoke_request_validator.sh [LOCAL AUTHORITY] [MODE] [REQUEST TYPE LABEL] [INITIAL STATE] [TARGET STATE] [MOTIVE]");
        System.out.println("  - [MODE] : One of { deployment | dev | help }");
        System.out.println("  - [LOCAL AUTHORITY] : The local authority to handle");
        System.out.println("  - [REQUEST TYPE LABEL] : The request type to handle");
        System.out.println("  - [INITIAL STATE] : The state of requests to handle");
        System.out.println("  - [TARGET STATE] : The target state; must be one transition away from initial state");
        System.out.println("  - [MOTIVE] : Motive for state change (optional, default value : \"" + defaultMotive + "\")");
        System.exit(0);
    }

    public void setRequests() {
        Set<Critere> criteres = new HashSet<Critere>();
        criteres.add(new Critere(Request.SEARCH_BY_STATE, initialState,
            Critere.EQUALS));
        criteres.add(new Critere(Request.SEARCH_BY_REQUEST_TYPE_LABEL,
            requestTypeLabel, Critere.EQUALS));
        requests = Collections.emptyList();
        try {
            requests = requestSearchService.get(criteres, null, null, 0, 0, false);
        } catch (CvqException e) {
            e.printStackTrace();
            System.out.println("Couldn't get the list of requests, aborting.");
            System.exit(0);
        }
    }
}
