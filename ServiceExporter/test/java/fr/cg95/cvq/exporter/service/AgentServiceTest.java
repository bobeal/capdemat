package fr.cg95.cvq.exporter.service;

import java.util.Map;

import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.service.authority.IAgentService;


/**
 * Demo client class for remote AgentService, to be invoked as standalone
 * program from the command line, e.g. via "client.bat" or "run.xml".
 *
 * <p>Reads in the application context from a "clientContext.xml" file in
 * the VM execution directory, calling all AgentService proxies defined in it.
 * See that file for details.
 *
 * @author Juergen Hoeller
 * @author Benoit Orihuela (CVQ adaptations)
 * @since 26.12.2003
 * @see fr.cg95.cvq.service.authority.IAgentService
 */
public class AgentServiceTest {

    public static final String CLIENT_CONTEXT_CONFIG_LOCATION = "./test/java/fr/cg95/cvq/exporter/clientContext.xml";

    private final ListableBeanFactory beanFactory;

    public AgentServiceTest(ListableBeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }

    public void invokeAgentService(String agentLogin) {

        Map agentServiceMap =
            this.beanFactory.getBeansOfType(IAgentService.class);
        if (agentServiceMap.size() > 1) {
            System.err.println("Expected only one agent service !");
            return;
        }

        IAgentService agentService =
            (IAgentService) agentServiceMap.values().iterator().next();
        try {
            Map tasksMap = agentService.getAgentTasks(agentLogin);
            if (tasksMap == null) {
                System.err.println("No Tasks !");
            } else {
                System.err.println("Got Tasks !");
            }
        } catch (CvqException e) {
            System.err.println("Error while retrieving tasks");
            e.printStackTrace();
            return;
        }
    }

    public static void main(String[] args) {
        if (args.length == 0 || "".equals(args[0])) {
            System.out.println("You need to specify an agent login");
        } else {
            ListableBeanFactory beanFactory =
                new FileSystemXmlApplicationContext(CLIENT_CONTEXT_CONFIG_LOCATION);
            AgentServiceTest client = new AgentServiceTest(beanFactory);
            client.invokeAgentService(args[0]);
        }
    }
}
