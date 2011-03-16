package fr.cg95.cvq.generator.plugins.model;

import java.util.HashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

import org.apache.log4j.Logger;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import fr.cg95.cvq.generator.ApplicationDocumentation;
import fr.cg95.cvq.generator.ElementProperties;
import fr.cg95.cvq.generator.IPluginGenerator;
import fr.cg95.cvq.generator.UserDocumentation;
import fr.cg95.cvq.generator.common.ElementCommon;
import fr.cg95.cvq.generator.plugins.model.ModelRequestObject.ComplexType;

/**
 * The model plugin that is in charge of receiving generator events, filtering those
 * that of interest for the model and "filling" the model request object with only
 * useful data for code generation
 *
 * @author bor@zenexity.fr
 */
public class ModelPlugin implements IPluginGenerator {

    private static Logger logger =
        Logger.getLogger(ModelPlugin.class);

    private int depth = 0;

    private ModelRequestObject modelRequestObject;

    private boolean includeDepthThreeElements = false;

    /** whether or not we are currently inspecting a choice type */
    private boolean insideChoiceElement = false;

    /** whether or not we are currently inspecting a locally defined complex type */
    private boolean insideLocalComplexType = false;

    /**
     * for a locally defined complex type, whether or not we expand its elements directly
     * inside the request object (the case for one to one relationships)
     */
    private boolean explodeLocalComplexType = false;

    /*
     * left choice elements support for historical purposes
     * but there are currently not used anymore
     * (were used for acceptance elements)
     */
    private String choiceKey;
    private String choiceName;
    private String choiceDefaultValue;

    private String currentElement;
    private String currentElementTypeName;

    // FIXME : rename because its uses have evolved since then ...
    private String currentContainerComplexElement;
    private String currentContainerComplexElementType;

    private SortedMap<String, ElementCommon> commonElements;

    public void initialize(Node configurationNode) {
        logger.debug("initialize()");

        modelRequestObject = new ModelRequestObject();
        commonElements = new TreeMap<String, ElementCommon>();

        NodeList nodeList = configurationNode.getChildNodes();
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node childNode = nodeList.item(i);
            if (childNode.getNodeName().equals("output")) {
                NamedNodeMap childAttributesMap = childNode.getAttributes();
                Node valueAttribute = childAttributesMap.getNamedItem("dir");
                modelRequestObject.setOutputDir(valueAttribute.getNodeValue());
                valueAttribute = childAttributesMap.getNamedItem("testdir");
                modelRequestObject.setOutputTestDir(valueAttribute.getNodeValue());
            }
        }
    }

    public void shutdown() {
        logger.debug("shutdown()");
    }

    public void startRequest(String requestName, String targetNamespace) {

        logger.debug("startRequest() Name : " + requestName);
        modelRequestObject.setRequestName(requestName);
    }

    public void endRequest(String requestName) {

        logger.debug("endRequest() Name : " + requestName);
        for (ComplexType complexType : modelRequestObject.getComplexTypesMap().values()) {
            complexType.getProperties().setElementCommon(commonElements.get(complexType.getProperties().getElementName()));
        }
        for (Map.Entry<String, ElementCommon> commonElement : commonElements.entrySet()) {
            ElementModelProperties element = modelRequestObject.getField(commonElement.getKey());
            if (element != null) {
                element.setElementCommon(commonElement.getValue());
            } else {
                for (ComplexType complexType : modelRequestObject.getComplexTypesMap().values()) {
                    ElementModelProperties nestedElement =
                        complexType.getElementModelProperties(commonElement.getKey());
                    if (nestedElement != null) {
                        nestedElement.setElementCommon(commonElement.getValue());
                    }
                }
                for (ElementModelProperties elementModelProperties :
                    modelRequestObject.getElementsPropertiesMap().values()) {
                    if (commonElement.getKey().equals(elementModelProperties.getComplexContainerElementName())) {
                        elementModelProperties.setComplexContainerConditionListener(
                            commonElement.getValue().getConditionListener());
                    }
                }
            }
        }
        commonElements.clear();
        modelRequestObject.generateRequest();
    }

    public void startElement(String elementName, String type) {

        depth++;

        // starting a new first-level element, reset contextual variables
        if (depth == 1) {
            insideChoiceElement = false;
            insideLocalComplexType = false;
            explodeLocalComplexType = false;
            choiceKey = null;
            choiceName = null;
            choiceDefaultValue = null;
            currentContainerComplexElement = null;
        } else if (depth == 2) {
            includeDepthThreeElements = false;
        }

        currentElement = elementName;
        currentElementTypeName = type.substring(type.indexOf('=') + 1, type.indexOf('@'));
        logger.debug(getIndent() + "startElement() Name : " + elementName + " of type " + currentElementTypeName);
    }

    public void endElement(String elementName) {

        logger.debug(getIndent() + "endElement() Name : " + elementName);
        currentElement = null;
        depth--;
    }

    public void startElementProperties(ElementProperties elementProperties) {

        if (depth == 1) {
            // a first-level element inherited from request base type
            if (elementProperties.isInherited()) {
                return;
            } else if (elementProperties.isRequestType() && elementProperties.isComplexType()) {

                currentContainerComplexElement = currentElement;
                // keep a trace of the parent complex element type
                currentContainerComplexElementType = elementProperties.getXmlSchemaType();

                insideLocalComplexType = true;

                if (elementProperties.getMaxOccurs() != null
                    && elementProperties.getMaxOccurs().intValue() == 1) {
                    // a local complex type, expand its elements inside current request
                    // if maxOccurs = 1 (so ignore container type)
                    logger.debug(getIndent() + "Local complex type with a one relationship");
                    explodeLocalComplexType = true;
                } else {
                    // a local complex type with a one-to-many relationship
                    // add as a field of the request itself
                    logger.debug(getIndent() + "Local complex type with a many relationship : " 
                            + elementProperties.getXmlSchemaType());
                    modelRequestObject.addField(currentElement, elementProperties, null, null);
                    explodeLocalComplexType = false;
                    // and also add as to be generated as its own type
                    modelRequestObject
                        .addComplexType(elementProperties.getXmlSchemaType(), elementProperties)
                            .getProperties().setElementName(currentElement);
                }
            } else {
                // a "normal" first-level element :-)
                modelRequestObject.addField(currentElement, elementProperties, null, null);
            }

            return;
        }

        // depth can now only be equal to 2
        if (depth == 2) {
            if (insideLocalComplexType) {
                if (!explodeLocalComplexType) {
                    modelRequestObject.addElementToComplexType(currentContainerComplexElementType,
                            currentElement, elementProperties);
                } else {
                    // at this depth, only interested in locally defined elements
                    modelRequestObject.addField(currentElement, elementProperties,
                            currentContainerComplexElementType,
                            currentContainerComplexElement);
                }
            } else if (insideChoiceElement) {
                if (!elementProperties.isChoiceElement()) {
                    logger.error("startElementProperties() Was expecting choice element !");
                } else {
                    // found the choice element of interest
                    if (currentElement.equals(choiceKey)) {
                        if (!elementProperties.isComplexType()) {
                            logger.debug("startElementProperties() Choosen element is not a complex type, that's ok");
                            if (choiceDefaultValue != null)
                                elementProperties.setDefaultValue(choiceDefaultValue);
                            modelRequestObject.addField(choiceName, elementProperties,
                                    currentContainerComplexElementType,
                                    currentContainerComplexElement);
                        } else {
                            logger.debug("startElementProperties() Choice element is a complex type, have to deal with its elements instead");
                            includeDepthThreeElements = true;
                        }
                    }
                }
            }
        }

        if (depth == 3 && includeDepthThreeElements) {
            logger.debug("startElementProperties() Adding " + currentElement + " as a choice");
            elementProperties.setChoiceElement(true);
            if (choiceDefaultValue != null)
                elementProperties.setDefaultValue(choiceDefaultValue);
            modelRequestObject.addField(currentElement, elementProperties,
                                        currentContainerComplexElementType,
                                        currentContainerComplexElement);
        }
    }

    public void endElementProperties() {
    }

    public void onUserInformation(UserDocumentation userDocumentation) {
    }

    public void onApplicationInformation(ApplicationDocumentation applicationDocumentation) {
        if (depth > 1 && !insideLocalComplexType)
            return;

        if (depth == 0) {
            // at the request level
            if ("model".equals(applicationDocumentation.getNodeName())) {
                Node applicationNode = applicationDocumentation.getXmlNode();
                NamedNodeMap applicationAttributesMap = applicationNode.getAttributes();
                modelRequestObject.setRequestNamespaceLastParticle(
                    applicationAttributesMap.getNamedItem("namespace").getNodeValue());
            }
        } else {
            // at the request elements level
            if ("model".equals(applicationDocumentation.getNodeName())) {
                // first look if we have to deal with a choice
                // if so, remove current element from map and store choice
                Node[] childrenNodes = applicationDocumentation.getChildrenNodes("choice");
                if (childrenNodes != null) {
                    // we can only have one
                    Node childNode = childrenNodes[0];
                    NamedNodeMap childAttributesMap = childNode.getAttributes();
                    choiceKey = childAttributesMap.getNamedItem("key").getNodeValue();
                    choiceName = currentElement;
                    if (childAttributesMap.getNamedItem("default") != null)
                        choiceDefaultValue =
                            childAttributesMap.getNamedItem("default").getNodeValue();
                    modelRequestObject.removeField(currentElement);
                    insideChoiceElement = true;
                    currentContainerComplexElement = currentElement;
                }
                modelRequestObject.addFieldInfo(currentElement, applicationDocumentation);
            } else {
                commonElements.put(currentElement,
                    applicationDocumentation.getRequestCommon().getCurrentElementCommon());
            }
        }
    }

    private String getIndent() {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < depth; i++) {
            sb.append("\t");
        }
        return sb.toString();
    }
}
