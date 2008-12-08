package fr.cg95.cvq.generator.plugins.fo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import groovy.lang.Writable;
import groovy.text.SimpleTemplateEngine;
import groovy.text.Template;

public class FoRenderer {
    private static Logger logger = Logger.getLogger(FoRenderer.class);
    
    private final String I18N_DIR = "grails-app/i18n/";

    private final String VIEW_DIR = "modules/frontoffice/views/requestType/";

    private final String CONTROLLER_DIR = "modules/frontoffice/controllers/";

    private final String TEMPLATES_DIR = "Generator/src/java/fr/cg95/cvq/generator/plugins/fo/templates/";

    private final String I18N_TEMPLATE = TEMPLATES_DIR + "i18n.properties.tmpl";

    private final String EDIT_TEMPLATE = TEMPLATES_DIR + "edit.tmpl";

    private final String CONTROLLER_TEMPLATE = TEMPLATES_DIR + "controller.tmpl";

    private final String WIDGET_TEMPLATE = TEMPLATES_DIR + "widget.tmpl";

    private final String WIDGET_DESC_TEMPLATE = TEMPLATES_DIR + "widgetDesc.tmpl";
    
    private final String DOCUMENT_REF_TEMPLATE = TEMPLATES_DIR + "documentRef.tmpl";
    
    private final String MEANS_OF_CONTACT_TEMPLATE = TEMPLATES_DIR + "meansOfContact.tmpl";

    private FoObject foObject;

    private String outputDir;

    private StringBuffer stepValidationRender;

    private Template controllerTemplate;

    private Template editTemplate;

    private Template i18nTemplate;

    private Template widgetTemplate;

    private Template widgetDescTemplate;
    
    private Template documentTemplate;
    
    private Template meansOfContactTemplate;

    public FoRenderer(FoObject foObject, String outputDir) {
        this.foObject = foObject;
        this.outputDir = outputDir;
        initTemplates(foObject);

    }

    public void render() {
        createController();
        createEditFile();
        createI18nFiles();
        createSteps();
    }

    private void createSteps() {
        try {
            boolean needsValidation = getFoObject().isNeededValidation();
            String stepsDirName = outputDir + '/' + VIEW_DIR
                    + StringUtils.uncapitalize(getFoObject().getRequestName()) + "/steps/";
            File stepsDir = new File(stepsDirName);
            if (!stepsDir.exists())
                stepsDir.mkdirs();
            if (needsValidation) {
                stepsDir = new File(stepsDirName + "validation/");
                if (!stepsDir.exists())
                    stepsDir.mkdirs();
            }
            StringBuffer editValidationRender = new StringBuffer();
            for (Iterator<FoStep> i = getFoObject().getStepMap().values().iterator(); i.hasNext();) {
                FoStep step = i.next();
                StringBuffer stepRender = new StringBuffer();
                if (step.getRef() == null) {
                    if (needsValidation) {
                        setStepValidationRender(new StringBuffer());
                        editValidationRender.append(getEditValidationRender(step.getName()));
                    }
                    for (Element element : step.getElementList()) {
                        stepRender.append(getElementRender(element, "", needsValidation));
                    }
                } else {
                    if (step.getRef().equals("validation")) {
                        stepRender.append(getMeansOfContact());
                        stepRender.append(editValidationRender);
                    }
                    if (step.getRef().equals("document"))
                        stepRender.append(getDocumentRef());
                }
                createStepRender(stepsDirName, step.getName(), stepRender);
                if(needsValidation && step.getRef() == null)
                    createValidationStepRender(stepsDirName, step.getName(), getStepValidationRender());

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private StringBuffer getEditValidationRender(String stepName) {
        StringBuffer result = new StringBuffer();
        result.append("<h3><g:message code='" + getFoObject().getNamespaceAlias() + ".step."
                + stepName + ".label' /></h3> \n");
        result.append("<g:render template=\"/frontofficeRequestType/"
                + StringUtils.uncapitalize(getFoObject().getRequestName())
                + "/steps/validation/" + stepName + "\" />\n");
        return result;

    }

    private void createValidationStepRender(String stepsDirName, String StepName,
            StringBuffer stepRender) {
        createFile(stepsDirName + "validation/_" + StepName + ".gsp", stepRender);
    }

    private void createStepRender(String stepsDirName, String StepName, StringBuffer stepRender) {
        createFile(stepsDirName + "_" + StepName + ".gsp", stepRender);
    }
    
    private Writable getDocumentRef() {
        Writable w = getDocumentTemplate().make();
        return w;
    }
    
    private Writable getMeansOfContact() {
        Writable w = getMeansOfContactTemplate().make();
        return w;
    }

    private Writable getWidgetRender(Element currentElement, String widgetType, String valuePrefix, boolean validationStep) {
        Map<String, Object> binding = new HashMap<String, Object>();
        binding.put("widgetType", widgetType);
        binding.put("element", currentElement);
        binding.put("namespaceAlias", getFoObject().getNamespaceAlias());
        binding.put("xsdNamespace", getFoObject().getXsdNamespace());
        binding.put("valuePrefix", valuePrefix);
        binding.put("validationStep", validationStep);
        Writable w = getWidgetTemplate().make(binding);
        return w;
    }

    private Writable getWidgetDescRender(Element currentElement, String widgetType,
            String valuePrefix, boolean validationStep) {
        Map<String, Object> binding = new HashMap<String, Object>();
        binding.put("widgetType", widgetType);
        binding.put("element", currentElement);
        binding.put("namespaceAlias", getFoObject().getNamespaceAlias());
        binding.put("valuePrefix", valuePrefix);
        binding.put("validationStep", validationStep);
        Writable w = getWidgetDescTemplate().make(binding);
        return w;
    }

    private StringBuffer getElementRender(Element currentElement, String valuePrefix,
            boolean needsValidation) {
        StringBuffer result = new StringBuffer();
        if (currentElement instanceof RadioElement) {
            result.append(getWidgetDescRender(currentElement, "labelWidget", valuePrefix, false));
            result.append(getWidgetRender(currentElement, "radioWidget", valuePrefix, false));
            if (needsValidation == true) {
                getStepValidationRender().append(
                        getWidgetDescRender(currentElement, "labelWidget", valuePrefix, true));
                getStepValidationRender().append(getWidgetRender(currentElement, "radioWidget", valuePrefix, true));
            }
        } else if (currentElement instanceof SelectElement) {
            result.append(getWidgetDescRender(currentElement, "labelWidget", valuePrefix, false));
            result.append(getWidgetRender(currentElement, "selectWidget", valuePrefix, false));
            if (needsValidation == true) {
                getStepValidationRender().append(
                        getWidgetDescRender(currentElement, "labelWidget", valuePrefix, true));
                getStepValidationRender().append(getWidgetRender(currentElement, "selectWidget", valuePrefix, true));
            }
        } else if (currentElement instanceof TextareaElement) {
            result.append(getWidgetDescRender(currentElement, "labelWidget", valuePrefix, false));
            result.append(getWidgetRender(currentElement, "textareaWidget", valuePrefix, false));
            if (needsValidation == true) {
                getStepValidationRender().append(
                        getWidgetDescRender(currentElement, "labelWidget", valuePrefix, true));
                getStepValidationRender().append(getWidgetRender(currentElement, "textareaWidget", valuePrefix, true));
            }
        } else if (currentElement instanceof YesnoElement) {
            result.append(getWidgetDescRender(currentElement, "labelWidget", valuePrefix, false));
            result.append(getWidgetRender(currentElement, "yesnoWidget", valuePrefix, false));
            if (needsValidation == true) {
                getStepValidationRender().append(
                        getWidgetDescRender(currentElement, "labelWidget", valuePrefix, true));
                getStepValidationRender().append(getWidgetRender(currentElement, "yesnoWidget", valuePrefix, true));
            }
        } else if (currentElement instanceof TextElement) {
            result.append(getWidgetDescRender(currentElement, "labelWidget", valuePrefix, false));
            result.append(getWidgetRender(currentElement, "textWidget", valuePrefix, false));
            if (needsValidation == true) {
                getStepValidationRender().append(
                        getWidgetDescRender(currentElement, "labelWidget", valuePrefix, true));
                getStepValidationRender().append(getWidgetRender(currentElement, "textWidget", valuePrefix, true));
            }
        } else if (currentElement instanceof FieldsetElement) {
            FieldsetElement fieldsetElement = (FieldsetElement) currentElement;
            result.append("<fieldset class=\"" + currentElement.getCondition() + "\">\n");
            result.append(getWidgetDescRender(currentElement, "legendWidget", valuePrefix, false));
            if (needsValidation == true) {
                getStepValidationRender().append(
                        "<fieldset class=\"" + currentElement.getCondition() + "\">\n");
                getStepValidationRender().append(
                        getWidgetDescRender(currentElement, "legendWidget", valuePrefix, false));
            }
            for (Element element : fieldsetElement.getElementList()) {
                if (fieldsetElement.isExternalElement())
                    result.append(getElementRender(element, valuePrefix
                            + StringUtils.uncapitalize(currentElement.getName()) + "?.",
                            needsValidation));
                else
                    result.append(getElementRender(element, valuePrefix, needsValidation));
            }
            if (needsValidation == true)
                getStepValidationRender().append("</fieldset>\n");
            result.append("</fieldset>\n");
        } else if (currentElement instanceof OneToManyElement) {
//            OneToManyElement oneToMany = (OneToManyElement) currentElement;
//            result
//                    .append("<strong><font color=\"red\"> I m a oneToMany widget but there s not a widget render !!!!</font></strong>");
//            result.append("<fieldset class=\"" + currentElement.getCondition() + "\">\n");
//            for (Element element : oneToMany.getElementList()) {
//                result.append(getElementRender(element, StringUtils.uncapitalize(currentElement
//                        .getName())
//                        + "?.", needsValidation));
//            }
//            result.append("</fieldset>\n");
        } else if (currentElement instanceof ComplexElement) {
            ComplexElement complexElement = (ComplexElement) currentElement;
            for (Element element : complexElement.getElementList()) {
                if (complexElement.isExternalElement())
                    result.append(getElementRender(element, valuePrefix
                            + StringUtils.uncapitalize(currentElement.getName()) + "?.",
                            needsValidation));
                else
                    result.append(getElementRender(element, valuePrefix, needsValidation));
            }
        } else {
            logger.error("Don't pass here ... ");
        }
        return result;
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

    private void createI18nFiles() {
        createI18nFile("fr");
        createI18nFile("en");
    }

    private void createI18nFile(String lang) {
        String i18nDirName = outputDir + '/' + I18N_DIR;
        String i18nFileName = i18nDirName + getFoObject().getNamespaceAlias() + "_" + lang
                + ".properties.tpl";
        File i18nDir = new File(i18nDirName);
        if (!i18nDir.exists())
            i18nDir.mkdirs();
        Properties default_messages = new Properties();
        try {
            FileInputStream in = new FileInputStream(TEMPLATES_DIR + "i18n_" + lang + ".properties");
            default_messages.load(in);
            Map<String, Object> binding = new HashMap<String, Object>();
            binding.put("foObject", foObject);
            binding.put("default_messages", default_messages);
            Writable w = getI18nTemplate().make(binding);

            createFile(i18nFileName, w);

            if (lang.equals("en")) {
                // ant.copy(file: i18nDir + '/' + foObject.namespaceAlias + "_"
                // + lang + '.properties.tpl',
                // tofile: i18nDir + '/' + foObject.namespaceAlias +
                // '.properties.tpl')
            }
            in.close();
        } catch (Exception e) {
            logger.error("i18n files generation error");
        }
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
            file = new File(I18N_TEMPLATE);
            template = simpleEngine.createTemplate(file);
            setI18nTemplate(template);
            file = new File(WIDGET_TEMPLATE);
            template = simpleEngine.createTemplate(file);
            setWidgetTemplate(template);
            file = new File(WIDGET_DESC_TEMPLATE);
            template = simpleEngine.createTemplate(file);
            setWidgetDescTemplate(template);
            file = new File(DOCUMENT_REF_TEMPLATE);
            template = simpleEngine.createTemplate(file);
            setDocumentTemplate(template);
            file = new File(MEANS_OF_CONTACT_TEMPLATE);
            template = simpleEngine.createTemplate(file);
            setMeansOfContactTemplate(template);

        } catch (Exception e) {
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
            logger.error("create file error");
        }
    }

    // TODO boolean pour retour réussi
    private void createFile(String fileName, StringBuffer render) {
        PrintWriter writer;
        try {
            writer = new PrintWriter(new FileOutputStream(fileName));
            writer.print(render.toString());
            writer.close();
            logger.info(fileName + " is successfully created");
        } catch (Exception e1) {
            logger.error(fileName + " is not successfully created");
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

    public Template getI18nTemplate() {
        return i18nTemplate;
    }

    public void setI18nTemplate(Template template) {
        i18nTemplate = template;
    }

    public Template getWidgetTemplate() {
        return widgetTemplate;
    }

    public void setWidgetTemplate(Template widgetTemplate) {
        this.widgetTemplate = widgetTemplate;
    }

    public Template getWidgetDescTemplate() {
        return widgetDescTemplate;
    }

    public void setWidgetDescTemplate(Template widgetDescTemplate) {
        this.widgetDescTemplate = widgetDescTemplate;
    }

    public StringBuffer getStepValidationRender() {
        return stepValidationRender;
    }

    public void setStepValidationRender(StringBuffer stepValidationRender) {
        this.stepValidationRender = stepValidationRender;
    }
    
    public Template getDocumentTemplate() {
        return documentTemplate;
    }

    public void setDocumentTemplate(Template documentTemplate) {
        this.documentTemplate = documentTemplate;
    }

    public Template getMeansOfContactTemplate() {
        return meansOfContactTemplate;
    }

    public void setMeansOfContactTemplate(Template meansOfContactTemplate) {
        this.meansOfContactTemplate = meansOfContactTemplate;
    }

    public FoObject getFoObject() {
        return foObject;
    }

    public void setFoObject(FoObject foObject) {
        this.foObject = foObject;
    }
}
