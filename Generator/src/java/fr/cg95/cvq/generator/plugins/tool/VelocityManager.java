package fr.cg95.cvq.generator.plugins.tool;

import java.io.File;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.exception.ParseErrorException;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.apache.velocity.runtime.RuntimeConstants;

/**
 * An utility class used to call Velocity template engine
 *
 * @author bor@zenexity.fr
 */
public class VelocityManager {

    private static Logger logger = Logger.getLogger(VelocityManager.class);

    /**
     * Generic method used to call the Velocity engine
     *
     * @param templateFile velocity template file name (with path)
     * @param fileName the complete name of the file to be generated
     * @param outputDir the directory in which generated file will be placed
     * @param packageName the generated file's package name
     * @param contextsObjects a map of context key/value pairs
     */
    public static void launchGeneration(String templateFile, String fileName,
        String outputDir, String packageName,
        HashMap<String, ? extends Object> contextsObjects) {

        try {

            VelocityEngine ve = new VelocityEngine();
            ve.setProperty(RuntimeConstants.RUNTIME_LOG_LOGSYSTEM_CLASS,
                           "org.apache.velocity.runtime.log.SimpleLog4JLogSystem" );
            ve.setProperty("runtime.log.logsystem.log4j.category", "stdout");
            // make it shut up about VM_global_library blah
            ve.setProperty("velocimacro.library","");
            ve.init();
            VelocityContext context = new VelocityContext();

            // Load the template file
            Template template = null;

            try {
                template = ve.getTemplate(templateFile);
            } catch (ResourceNotFoundException rnfe) {
                logger.error("launchGeneration() Cannot find template " + templateFile);
            } catch (ParseErrorException pee) {
                logger.error("launchGeneration() Syntax error in template " + templateFile + ":" + pee);
            }

            File outputDirFile = new File(outputDir);
            File packageDir = null;
            if (packageName != null)
                packageDir = new File(outputDirFile, packageName);
            else
                packageDir = outputDirFile;
            packageDir.mkdirs();

            if (template != null) {
                File javaFile = new File(packageDir, fileName);

                logger.info("launchGeneration() Generating file : " + javaFile.getPath());
                for (Map.Entry<String, ? extends Object> entry :
                    contextsObjects.entrySet()) {
                    context.put(entry.getKey(), entry.getValue());
                }
                FileWriter javaWriter = new FileWriter(javaFile);
                template.merge(context, javaWriter);

                javaWriter.flush();
                javaWriter.close();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
