package fr.cg95.cvq.wizard;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.velocity.Template;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.exception.ParseErrorException;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.apache.velocity.runtime.RuntimeConstants;

import fr.cg95.cvq.wizard.manager.ManagerWizardPlugin;
import fr.cg95.cvq.wizard.manager.ManagerWizardState;
import fr.cg95.cvq.wizard.process.ProcessWizardPlugin;
import fr.cg95.cvq.wizard.process.ProcessWizardState;

public class VelocityUtils {

    /** Commons Logging instance. */
    protected static Logger log = Logger.getLogger(VelocityUtils.class);

    public static Template loadTemplate(String resource) {
        try {
            int BUFFER_SIZE = 4096;
            File templateFile = File.createTempFile("cvq", ".vm");

            InputStream is = VelocityUtils.class.getResourceAsStream(resource);
            OutputStream os = new FileOutputStream(templateFile);
            byte b[] = new byte[BUFFER_SIZE];
            int read = is.read(b);
            while (read == BUFFER_SIZE) {
                os.write(b);
                read = is.read(b);
            }
            if (read > 0)
                os.write(b, 0, read);
            is.close();
            os.close();

            Template template = getVelocityTemplate(templateFile);

            templateFile.delete();
            
            return template;

        } catch (Exception e) {
            log.error("CVQ - Wizard failed to initialize Velocity context: " + e);
        }
        return null;
    }
    
    public static Template getVelocityTemplate(File template) {
        if (template.exists()) try {
            String directory = template.getAbsolutePath();
            directory = directory.substring(0,directory.indexOf(template.getName()));
            VelocityEngine ve = new VelocityEngine();
            ve.setProperty(RuntimeConstants.RUNTIME_LOG_LOGSYSTEM_CLASS,
                    "org.apache.velocity.runtime.log.SimpleLog4JLogSystem");
            ve.setProperty("runtime.log.logsystem.log4j.category", "stdout");
            ve.setProperty("file.resource.loader.path", directory);
            // make it shut up about VM_global_library blah
            ve.setProperty("velocimacro.library","");
            ve.setProperty("input.encoding", "UTF-8");
            ve.setProperty("output.encoding", "UTF-8");
            ve.init();
            try {
                return ve.getTemplate(template.getName(), "UTF-8");

            } catch (ResourceNotFoundException rnfe) {
                log.error("CVQ - Wizard cannot find template " + template.getName() + ": " + rnfe);
            } catch (ParseErrorException pee) {
                log.error("CVQ - Wizard syntax error in template " + template.getName() + ": "
                        + pee);
            }
        } catch (Exception e) {
            log.error("CVQ - Wizard failed to initialize Velocity context: " + e);
        }
        return null;
    }

    public static Template getTagTemplate(HttpSession session) {
        ProcessWizardState processState = ProcessWizardState.getWizardState(session);
        ManagerWizardState managerState = ManagerWizardState.getWizardState(session, 0);

        Template tagTemplate = null;
        if (processState != null) {
            tagTemplate = processState.getTagTemplate();

            if (tagTemplate == null)
                tagTemplate = ProcessWizardPlugin.plugin().getTagTemplate();

        } else if (managerState != null) {
            tagTemplate = managerState.getTagTemplate();

            if (tagTemplate == null)
                tagTemplate = ManagerWizardPlugin.plugin().getTagTemplate();
        } else {
            tagTemplate = ProcessWizardPlugin.plugin().getTagTemplate();
        }
        return tagTemplate;
    }
    
}
