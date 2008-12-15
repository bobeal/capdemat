package fr.cg95.cvq.generator.plugins.fo;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import groovy.lang.Writable;
import groovy.text.SimpleTemplateEngine;
import groovy.text.Template;

public class FoRenderer {
    private static Logger logger = Logger.getLogger(FoRenderer.class);

    private final String VIEW_DIR = "modules/frontoffice/views/requestType/";

    private final String CONTROLLER_DIR = "modules/frontoffice/controllers/";

    private final String TEMPLATES_DIR = "Generator/src/java/fr/cg95/cvq/generator/plugins/fo/templates/";

    private final String EDIT_TEMPLATE = TEMPLATES_DIR + "edit.tmpl";
    private final String SUMMARY_TEMPLATE = TEMPLATES_DIR + "summary.tmpl";
    private final String CONTROLLER_TEMPLATE = TEMPLATES_DIR + "controller.tmpl";

    private FoObject foObject;

    private String outputDir;

    private StringBuffer stepValidationRender;

    private Template controllerTemplate;
    private Template editTemplate;
    private Template summaryTemplate;


    public FoRenderer(FoObject foObject, String outputDir) {
        this.foObject = foObject;
        this.outputDir = outputDir;
        initTemplates(foObject);

    }

    public void render() {
        createController();
        createEditFile();
        createSummaryFile();
    }
   
    private void createController() {
        String controllerDirName = outputDir + '/' + CONTROLLER_DIR;
        String controllerFileName = controllerDirName + getFoObject().getRequestName()
                + "Controller.groovy";
        File controllerDir = new File(controllerDirName);
        if (!controllerDir.exists())
            controllerDir.mkdirs();
        Map<String, Object> binding = new HashMap<String, Object>();
        binding.put("foObject", foObject);
        Writable w = getControllerTemplate().make(binding);
        createFile(controllerFileName, w);
    }

    private void createEditFile() {
        String editDirName = outputDir + '/' + VIEW_DIR
                + StringUtils.uncapitalize(getFoObject().getRequestName()) + "/";
        String editFileName = editDirName + "edit.gsp";
        File controllerDir = new File(editDirName);
        if (!controllerDir.exists())
            controllerDir.mkdirs();
        Map<String, Object> binding = new HashMap<String, Object>();
        binding.put("foObject", foObject);
        Writable w = getEditTemplate().make(binding);
        createFile(editFileName, w);
    }

    private void createSummaryFile() {
        String summaryDirName = outputDir + '/' + VIEW_DIR
                + StringUtils.uncapitalize(getFoObject().getRequestName()) + "/";
        String summaryFileName = summaryDirName + "_summary.gsp";
        File summaryDir = new File(summaryDirName);
        if (!summaryDir.exists())
            summaryDir.mkdirs();
        Map<String, Object> binding = new HashMap<String, Object>();
        binding.put("foObject", foObject);
        Writable w = summaryTemplate.make(binding);
        createFile(summaryFileName, w);
    }

    private void initTemplates(FoObject foObject) {

        SimpleTemplateEngine simpleEngine = new SimpleTemplateEngine();
        Template template;
        File file;
        try {
            file = new File(CONTROLLER_TEMPLATE);
            template = simpleEngine.createTemplate(file);
            setControllerTemplate(template);
            file = new File(EDIT_TEMPLATE);
            template = simpleEngine.createTemplate(file);
            setEditTemplate(template);
            file = new File(SUMMARY_TEMPLATE);
            summaryTemplate = simpleEngine.createTemplate(file);

        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Templates are not initialized");
        }
    }

    // TODO boolean pour retour réussi
    private void createFile(String fileName, Writable w) {
        PrintWriter writer;
        try {
            writer = new PrintWriter(new FileOutputStream(fileName));
            w.writeTo(writer);
            writer.close();
            logger.info(fileName + " is successfully created");
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    }

    public Template getControllerTemplate() {
        return controllerTemplate;
    }

    public void setControllerTemplate(Template controllerTemplate) {
        this.controllerTemplate = controllerTemplate;
    }

    public Template getEditTemplate() {
        return editTemplate;
    }

    public void setEditTemplate(Template editTemplate) {
        this.editTemplate = editTemplate;
    }

    public StringBuffer getStepValidationRender() {
        return stepValidationRender;
    }

    public FoObject getFoObject() {
        return foObject;
    }

    public void setFoObject(FoObject foObject) {
        this.foObject = foObject;
    }
}
