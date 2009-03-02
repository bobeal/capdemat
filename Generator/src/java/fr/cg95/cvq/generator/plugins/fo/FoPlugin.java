package fr.cg95.cvq.generator.plugins.fo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.codehaus.groovy.control.CompilationFailedException;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

import fr.cg95.cvq.generator.ApplicationDocumentation;
import fr.cg95.cvq.generator.ElementProperties;
import fr.cg95.cvq.generator.IPluginGenerator;
import fr.cg95.cvq.generator.UserDocumentation;
import fr.cg95.cvq.generator.common.RequestCommon;
import fr.cg95.cvq.generator.common.Step;
import groovy.text.SimpleTemplateEngine;
import groovy.text.Template;

/**
 * @author rdj@zenexity.fr
 */
public class FoPlugin implements IPluginGenerator {
    
    private static Logger logger = Logger.getLogger(FoPlugin.class);
    
    private int depth;
    
    private String outputDir;
    private String editTemplate;
    private String stepTemplate;
    private String validationTemplate;
    private String summaryTemplate;
    
    private RequestFo requestFo;
    private ElementStack elementFoStack;
    
    public void initialize(Node configurationNode) {
        logger.debug("initialize()");
        try {
            NamedNodeMap childAttributesMap = configurationNode.getFirstChild().getAttributes();
            outputDir = childAttributesMap.getNamedItem("outputdir").getNodeValue();
            editTemplate = childAttributesMap.getNamedItem("edittemplate").getNodeValue();
            stepTemplate = childAttributesMap.getNamedItem("steptemplate").getNodeValue();
            validationTemplate = childAttributesMap.getNamedItem("validationtemplate").getNodeValue();
            summaryTemplate = childAttributesMap.getNamedItem("summarytemplate").getNodeValue();
        } catch (NullPointerException npe) {
            throw new RuntimeException ("Check fo-plugin.xml <properties outputdir=\"\" edittemplate=\"\" steptemplate=\"\" summarytemplate=\"\"/> configuration tag");
        }
    }
    
    public void startRequest(String requestName, String targetNamespace) {
        logger.debug("startRequest()");
        depth = 0;
        requestFo = new RequestFo(requestName, targetNamespace);
        elementFoStack = new ElementStack();
    }
    
    public void endRequest(String requestName) {
        logger.debug("endRequest()");
        try {
            String output = outputDir + "/" + requestFo.getName() + "/";
            if (! new File(output).exists())
                new File(output).mkdir();
            
            SimpleTemplateEngine templateEngine = new SimpleTemplateEngine();
            
            // main edit.gsp view
            Template template = templateEngine.createTemplate(new File(editTemplate));
            Map<String, Object> bindingMap = new HashMap<String, Object>();
            bindingMap.put("requestFo", requestFo);
            template.make(bindingMap).writeTo(new FileWriter(output + "edit.gsp" ));
            logger.warn("endRequest() - edit.gsp.tpl OK");
            
            // _summary.gsp template 
            template = templateEngine.createTemplate(new File(summaryTemplate));
            template.make(bindingMap).writeTo(new FileWriter(output + "_summary.gsp" ));
            logger.warn("endRequest() - summaryTemplate.gsp.tpl OK");
            
            // _validation.gsp template
            template = templateEngine.createTemplate(new File(validationTemplate));
            bindingMap = new HashMap<String, Object>();
            bindingMap.put("requestFo", requestFo);
            int bundleIndex = 0;
            List<List<Step>> test = requestFo.getStepBundles();
            for (List<Step> stepBundle : requestFo.getStepBundles()) {
                bindingMap.put("stepBundle", stepBundle);
                template.make(bindingMap).writeTo(new FileWriter(output + "_validation"+ bundleIndex++ +".gsp" ));
            }
            logger.warn("endRequest() - validation.gsp.tpl OK");
            
            // _<step>.gsp templates
            template = templateEngine.createTemplate(new File(stepTemplate));
            bindingMap = new HashMap<String, Object>();
            bindingMap.put("acronym", requestFo.getAcronym());
            for (Step step : requestFo.getSteps()) {
                if (!step.getName().equals(step.getRef())) {
                    bindingMap.put("step", step);
                    bindingMap.put("elementList", requestFo.getElementsByStep(step));
                    template.make(bindingMap).writeTo(new FileWriter(output + "_" + step.getName() + ".gsp"));
                }
            }
            logger.warn("endRequest() - step.gsp.tpl OK");
            
        } catch (CompilationFailedException cfe) {
            logger.error(cfe.getMessage()); 
        } catch (ClassNotFoundException cnfe) {
            logger.error(cnfe.getMessage()); 
        } catch (IOException ioe) {
            logger.error(ioe.getMessage()); 
        }
    }
    
    public void startElement(String elementName, String type) {
        logger.debug("endElement()");
        elementFoStack.push(++depth, new ElementFo(elementName, this.requestFo.getAcronym()));
    }
    
    public void endElement(String elementName) {
        logger.debug("endElement()");
        if (depth <= 1 && elementFoStack.peek(depth).isDisplay())
            requestFo.addElement(elementFoStack.pop(depth));
        else if (elementFoStack.peek(depth).isDisplay())
            elementFoStack.store(depth);
        else
            elementFoStack.pop(depth);
        depth--;
    }

    public void startElementProperties(ElementProperties elementProp) {
        logger.debug("startElementProperties()");
        ElementFo elementFo = elementFoStack.peek(depth);
        elementFo.setType(elementProp.getXmlSchemaType());
        
        // TODO - define a more robust namespace mapping policy
        if (elementProp.isReferentialType())
            elementFo.setModelNamespace(IPluginGenerator.MODEL_BASE_TARGET_NS + ".users");
        
        if (elementProp.isSimpleType())
            elementFo.setTypeClass(ElementFo.ElementTypeClass.SIMPLE);
        else if (elementProp.isComplexType())
            elementFo.setTypeClass(ElementFo.ElementTypeClass.COMPLEX);
        
        if (elementProp.getMaxOccurs() == null
                || elementProp.getMaxOccurs().compareTo(BigInteger.valueOf(1)) == 1)
            elementFo.setTypeClass(ElementFo.ElementTypeClass.COLLECTION);
        
        if (elementProp.getMinOccurs().compareTo(BigInteger.valueOf(0)) == 0)
            elementFo.setMandatory(false);
        
        if (elementProp.getEnumValues() != null) {
            elementFo.setWidget("select");
            elementFo.setEnumValues(elementProp.getEnumValues());
        }
        else
            elementFo.setWidget(elementProp.getXmlSchemaType());
    }
    
    public void endElementProperties() {
        logger.debug("endElementProperties()");
    }

    public void onApplicationInformation(ApplicationDocumentation appDoc) {
        logger.debug("onApplicationInformation()");

        if (depth < 1) {
            requestFo.setSteps(appDoc.getRequestCommon().getSteps());
        } else if (depth >= 1) {
            ElementFo elementFo = elementFoStack.peek(depth);
            elementFo.setStep(appDoc.getRequestCommon().getCurrentElementCommon().getStep());
            elementFo.setConditions(appDoc.getRequestCommon().getCurrentElementCommon().getConditions());
            elementFo.setModelNamespace(RequestCommon.MODEL_REQUEST_NS + "." + appDoc.getRequestCommon().getNamespace());
            elementFo.setJsRegexp(appDoc.getRequestCommon().getCurrentElementCommon().getJsRegexp());
            elementFo.setDisplay(true);
            
            if (appDoc.getNodeName().equals("fo")) {
                Node node = appDoc.getXmlNode();
                elementFo.setElementToDisplay(ApplicationDocumentation.getNodeAttributeValue(node, "element"));
                elementFo.setAfter(ApplicationDocumentation.getNodeAttributeValue(node, "after"));
                elementFo.setModifier(ApplicationDocumentation.getNodeAttributeValue(node, "modifier"));
                
                if (appDoc.hasChildNode("select"))
                    elementFo.setWidget("select");
                if (appDoc.hasChildNode("radio"))
                    elementFo.setWidget("radio");
                
                if (appDoc.hasChildNode("textarea")) {
                    elementFo.setWidget("textarea");
                    elementFo.setRows(ApplicationDocumentation.getNodeAttributeValue(
                            appDoc.getChildrenNodes("textarea")[0], "rows"));
                }
            }
         }
    }
    
    public void onUserInformation(UserDocumentation userDoc) {
        logger.debug("onUserInformation()");
    }
    
    public void shutdown() { }

}