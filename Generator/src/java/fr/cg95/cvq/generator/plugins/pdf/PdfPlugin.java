package fr.cg95.cvq.generator.plugins.pdf;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.codehaus.groovy.control.CompilationFailedException;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

import fr.cg95.cvq.generator.ApplicationDocumentation;
import fr.cg95.cvq.generator.ElementProperties;
import fr.cg95.cvq.generator.IPluginGenerator;
import fr.cg95.cvq.generator.UserDocumentation;
import fr.cg95.cvq.generator.common.ElementStack;
import fr.cg95.cvq.generator.common.RequestCommon;
import groovy.text.SimpleTemplateEngine;
import groovy.text.Template;

/**
 * @author rdj@zenexity.fr
 */
public class PdfPlugin implements IPluginGenerator {

    private static Logger logger = Logger.getLogger(PdfPlugin.class);

    private int depth;

    private String outputDir;
    private String pdfTemplate;


    private RequestPdf requestPdf;
    private ElementStack<ElementPdf> elementPdfStack;

    public void initialize(Node configurationNode) {
        logger.debug("initialize()");
        try {
            NamedNodeMap childAttributesMap = configurationNode.getFirstChild().getAttributes();
            outputDir = childAttributesMap.getNamedItem("outputdir").getNodeValue();
            pdfTemplate = childAttributesMap.getNamedItem("pdftemplate").getNodeValue();
        } catch (NullPointerException npe) {
            throw new RuntimeException ("Check fo-plugin.xml <properties outputdir=\"\" pdftemplate=\"\" /> configuration tag");
        }
    }

    public void startRequest(String requestName, String targetNamespace) {
        logger.debug("startRequest()");
        depth = 0;
        requestPdf = new RequestPdf(requestName, targetNamespace);
        elementPdfStack = new ElementStack<ElementPdf>();
    }

    public void endRequest(String requestName) {
        logger.warn("endRequest()");
        try {
            String output = outputDir + "/";
            if (! new File(output).exists())
                new File(output).mkdir();

            SimpleTemplateEngine templateEngine = new SimpleTemplateEngine();
            Template template = templateEngine.createTemplate(new File(pdfTemplate));
            Map<String, Object> bindingMap = new HashMap<String, Object>();
            bindingMap.put("requestPdf", requestPdf);
            template.make(bindingMap).writeTo(new FileWriter(output + requestPdf.getName() +".html"));
            logger.warn("endRequest() - pdf.html.tpl OK");
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
        elementPdfStack.push(++depth, new ElementPdf(elementName, this.requestPdf.getAcronym()));
    }

    public void endElement(String elementName) {
        logger.debug("endElement()");
        if (depth <= 1 && elementPdfStack.peek(depth).isDisplay())
            requestPdf.addElement(elementPdfStack.pop(depth));
        else if (elementPdfStack.peek(depth).isDisplay())
            elementPdfStack.store(depth);
        else
            elementPdfStack.pop(depth);
        depth--;
    }

    public void startElementProperties(ElementProperties elementProp) {
        logger.debug("startElementProperties()");
        ElementPdf elementPdf = elementPdfStack.peek(depth);
        elementPdf.setType(elementProp.getXmlSchemaType());
        elementPdf.setTypeClass(elementProp.getTypeClass());
        // TODO - define a more robust namespace mapping policy
        if (elementProp.isReferentialType())
            elementPdf.setModelNamespace(IPluginGenerator.MODEL_BASE_TARGET_NS + ".users");

        if (elementProp.getMinOccurs().compareTo(BigInteger.valueOf(0)) == 0)
            elementPdf.setMandatory(false);
        
        if (elementProp.getEnumValues() != null) {
            elementPdf.setWidget("pick");
            elementPdf.setEnumValues(elementProp.getEnumValues());
        }
        else
            elementPdf.setWidget(elementProp.getXmlSchemaType());
    }

    public void endElementProperties() {
        logger.debug("endElementProperties()");
    }

    public void onApplicationInformation(ApplicationDocumentation appDoc) {
        logger.debug("onApplicationInformation()");

        if (depth < 1) {
            requestPdf.setSteps(appDoc.getRequestCommon().getSteps());
        } else if (depth >= 1) {
            ElementPdf elementPdf = elementPdfStack.peek(depth);
            elementPdf.setStep(appDoc.getRequestCommon().getCurrentElementCommon().getStep());
            elementPdf.setConditionListener(appDoc.getRequestCommon().getCurrentElementCommon().getConditionListener());
            elementPdf.setModelNamespace(RequestCommon.MODEL_REQUEST_NS + "." + appDoc.getRequestCommon().getNamespace());
            elementPdf.setDisplay(true);

            if (appDoc.getNodeName().equals("pdf")) {
                Node node = appDoc.getXmlNode();
                elementPdf.setElementToDisplay(ApplicationDocumentation.getNodeAttributeValue(node, "element"));
                elementPdf.setAfter(ApplicationDocumentation.getNodeAttributeValue(node, "after"));
                elementPdf.setModifier(ApplicationDocumentation.getNodeAttributeValue(node, "modifier"));
                
                if (appDoc.hasChildNode("choice"))
                    elementPdf.setWidget("choice");
            }
        }
    }

    public void onUserInformation(UserDocumentation userDoc) {
        logger.debug("onUserInformation()");
    }

    public void shutdown() { }

}
