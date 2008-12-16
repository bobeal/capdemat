package fr.cg95.cvq.generator.plugins.fo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.codehaus.groovy.control.CompilationFailedException;

import groovy.text.SimpleTemplateEngine;
import groovy.text.Template;

public class FoRenderer {
    private static Logger logger = Logger.getLogger(FoRenderer.class);

    private final String VIEW_DIR = "modules/frontoffice/views/requestType/";
    private final String CONTROLLER_DIR = "modules/frontoffice/controllers/";
    private final String TEMPLATES_DIR = "Generator/src/java/fr/cg95/cvq/generator/plugins/fo/templates/";

    private final String EDIT_TEMPLATE = TEMPLATES_DIR + "edit.tmpl";
    private final String STEP_TEMPLATE = TEMPLATES_DIR + "step.tmpl";
    private final String SUMMARY_TEMPLATE = TEMPLATES_DIR + "summary.tmpl";
    private final String CONTROLLER_TEMPLATE = TEMPLATES_DIR + "controller.tmpl";

    private FoObject foObject;
    private String outputDir;


    public FoRenderer(FoObject foObject, String outputDir) {
        this.foObject = foObject;
        this.outputDir = outputDir;
    }

    public void render() {
        try {
            String output = outputDir + '/' + CONTROLLER_DIR;
            File controllerDir = new File(outputDir);
            if (!controllerDir.exists())
                controllerDir.mkdirs();
            createController(output);
            
            output = outputDir + '/' + VIEW_DIR + StringUtils.uncapitalize(foObject.getRequestName()) + "/";
            File viewDir = new File(outputDir);
            if (!viewDir .exists())
                viewDir .mkdirs();
            createEditFile(output);
            createStepsFile(output);
            createSummaryFile(output);   
            
        } catch (CompilationFailedException e) {
            logger.error(e.getMessage());
        } catch (FileNotFoundException e) {
            logger.error(e.getMessage());
        } catch (ClassNotFoundException e) {
            logger.error(e.getMessage());
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
    }
   
    private void createController(String outputDir)
        throws CompilationFailedException, FileNotFoundException, ClassNotFoundException, IOException {
        
        SimpleTemplateEngine templateEngine = new SimpleTemplateEngine();
        Template template = templateEngine.createTemplate(new File(CONTROLLER_TEMPLATE));
        Map<String, Object> bindingMap = new HashMap<String, Object>();
        bindingMap.put("foObject", foObject);
        template.make(bindingMap).writeTo(new FileWriter(outputDir +  foObject.getRequestName() + "Controller.groovy"));
        logger.warn("createController() SUCCESS");
    }

    private void createEditFile(String outputDir)        
        throws CompilationFailedException, FileNotFoundException, ClassNotFoundException, IOException {
        
        SimpleTemplateEngine templateEngine = new SimpleTemplateEngine();
        Template template = templateEngine.createTemplate(new File(EDIT_TEMPLATE));
        Map<String, Object> bindingMap = new HashMap<String, Object>();
        bindingMap.put("foObject", foObject);
        template.make(bindingMap).writeTo(new FileWriter(outputDir + "edit.gsp"));
        logger.warn("createEditFile() SUCCESS");
    }
    
    private void createStepsFile(String outputDir) 
        throws CompilationFailedException, FileNotFoundException, ClassNotFoundException, IOException {
        
        SimpleTemplateEngine templateEngine = new SimpleTemplateEngine();
        Template template = templateEngine.createTemplate(new File(STEP_TEMPLATE));
        
        Map<String, Object> bindingMap = new HashMap<String, Object>();
        bindingMap.put("foObject", foObject);
        for (FoStep step : foObject.getStepMap().values()) {
            if (step.getElementList() == null || step.getElementList().size() > 0 ) {
                bindingMap.put("step", step);
                template.make(bindingMap).writeTo(new FileWriter(outputDir + "_" + step.getName() + ".gsp"));
            }
        }
        logger.warn("createStepsFile() SUCCESS");
    }

    private void createSummaryFile(String outputDir)        
        throws CompilationFailedException, FileNotFoundException, ClassNotFoundException, IOException {
        
        SimpleTemplateEngine templateEngine = new SimpleTemplateEngine();
        Template template = templateEngine.createTemplate(new File(SUMMARY_TEMPLATE));
        Map<String, Object> bindingMap = new HashMap<String, Object>();
        bindingMap.put("foObject", foObject);
        template.make(bindingMap).writeTo(new FileWriter(outputDir + "_summary.gsp"));
        logger.warn("createSummaryFile() SUCCESS");
    }

}
