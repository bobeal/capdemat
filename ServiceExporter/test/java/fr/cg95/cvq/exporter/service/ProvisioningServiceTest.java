package fr.cg95.cvq.exporter.service;

import java.util.Map;

import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.exception.CvqUnknownUserException;
import fr.cg95.cvq.exception.CvqUserAlreadyExistsException;
import fr.cg95.cvq.exporter.service.bo.IProvisioningService;


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
 * @see fr.cg95.cvq.exporter.service.IProvisioningService
 */
public class ProvisioningServiceTest {

    public static final String CLIENT_CONTEXT_CONFIG_LOCATION = "./test/java/fr/cg95/cvq/exporter/clientContext.xml";

    private final ListableBeanFactory beanFactory;

    public ProvisioningServiceTest(ListableBeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }

    public void doAgentProvisioningWorkflow(final String agentLoginToCreate) {

        Map provisioningServiceMap =
            this.beanFactory.getBeansOfType(IProvisioningService.class);
        if (provisioningServiceMap.size() > 1) {
            System.err.println("Expected only one provisioning service !");
            return;
        }

        String[] originalGroups = new String[] { "CVQ_CONTRIBUTORS" };
        String[] newGroups = new String[] { "CVQ_ADMINISTRATORS" };
        
        IProvisioningService provisioningService =
            (IProvisioningService) provisioningServiceMap.values().iterator().next();
        try {
            provisioningService.createAgent("valdoise", agentLoginToCreate, "valdoise", "admin", 
                    originalGroups);
            boolean agentExists = provisioningService.agentExists("valdoise", agentLoginToCreate);
            if (!agentExists) {
                System.err.println("Agent was not created !");
                return;
            }
            provisioningService.modifyAgent("valdoise", agentLoginToCreate, 
                    agentLoginToCreate + "blop", "valdoise", "admin", newGroups);
            provisioningService.deleteAgent("valdoise", agentLoginToCreate + "blop");
        } catch (CvqUserAlreadyExistsException e) {
            System.err.println("Error while dealing with agent");
            e.printStackTrace();
            return;
        } catch (CvqUnknownUserException e) {
            System.err.println("Error while dealing with agent");
            e.printStackTrace();
            return;
        } catch (CvqException e) {
            System.err.println("Error while dealing with agent");
            e.printStackTrace();
            return;
        } 
    }

    public static void main(String[] args) {
        if (args.length == 0 || "".equals(args[0])) {
            System.out.println("You need to specify an agent login to create");
        } else {
            ListableBeanFactory beanFactory =
                new FileSystemXmlApplicationContext(CLIENT_CONTEXT_CONFIG_LOCATION);
            ProvisioningServiceTest client = new ProvisioningServiceTest(beanFactory);
            client.doAgentProvisioningWorkflow(args[0]);
        }
    }
}
