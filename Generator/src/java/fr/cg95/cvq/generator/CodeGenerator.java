package fr.cg95.cvq.generator;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

import org.apache.log4j.Logger;
import org.apache.xmlbeans.SchemaAnnotated;
import org.apache.xmlbeans.SchemaAnnotation;
import org.apache.xmlbeans.SchemaGlobalElement;
import org.apache.xmlbeans.SchemaLocalElement;
import org.apache.xmlbeans.SchemaParticle;
import org.apache.xmlbeans.SchemaProperty;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SchemaTypeLoader;
import org.apache.xmlbeans.SchemaTypeSystem;
import org.apache.xmlbeans.XmlAnySimpleType;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlCursor;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument;
import org.w3c.dom.Node;

import fr.cg95.cvq.generator.common.CommonPlugin;

/**
 * The main entry point for code generation.
 *
 * Load XSD files and parses them, calling registered plugins as needed.
 *
 * @author bor@zenexity.fr
 * @author rdj@zenexity.fr
 */
public final class CodeGenerator {

    private static final String W3C_NS = "http://www.w3.org/2001/XMLSchema";

    private static Logger logger = Logger.getLogger(CodeGenerator.class);

    /** a list of registered code generator plugins */
    private ArrayList<PluginDefinition> registeredPlugins = new ArrayList<PluginDefinition>();
    
    /** a pseudo plugin used to managed common application information **/
    private CommonPlugin commonPlugin = CommonPlugin.getInstance();
    
    /** the target namespace of the request being processed */
    private String targetNamespace;

    /**
     * The map containing association between XMLBeans java types
     * and "standard" java types
     */
    private static HashMap<String, String> javaTypesMap = new HashMap<String, String>();
    

    /**
     * @todo handle other XML Schema built-in primitives types
     */
    static {
        javaTypesMap.put("org.apache.xmlbeans.XmlString", "String");
        javaTypesMap.put("org.apache.xmlbeans.XmlLong", "Long");
        javaTypesMap.put("org.apache.xmlbeans.XmlDate", "java.util.Date");
        javaTypesMap.put("org.apache.xmlbeans.XmlPositiveInteger", "java.math.BigInteger");
        javaTypesMap.put("org.apache.xmlbeans.XmlToken", "String");
        javaTypesMap.put("org.apache.xmlbeans.XmlBoolean", "Boolean");
        javaTypesMap.put("org.apache.xmlbeans.XmlDecimal", "Short");
        javaTypesMap.put("org.apache.xmlbeans.XmlDouble", "Double");
    }

    public void parseXsdFile(File xsdFile) {

        try {

            logger.debug("parseXsdFile() Parsing XSD file : " + xsdFile);
            SchemaTypeLoader loader =
                XmlBeans.typeLoaderForClassLoader(SchemaDocument.class.getClassLoader());
            XmlObject[] xmlObjects = new XmlObject[1];
            xmlObjects[0] = loader.parse(xsdFile, null, null);

            SchemaTypeSystem sts =
                XmlBeans.compileXsd(xmlObjects,
                                    XmlBeans.getBuiltinTypeSystem(),
                                    null);

            SchemaGlobalElement[] globals = sts.globalElements();

            // one global element : the request itself
            for (int i = 0; i < globals.length; i++) {
                SchemaGlobalElement sge = globals[i];
                targetNamespace = sge.getName().getNamespaceURI();
                logger.debug("parseXsdFile() Target namespace : " + targetNamespace);

                startRequest(sge.getName().getLocalPart(), targetNamespace);

                processUserInformation(getUserInformation(sge), "request");
                processApplicationInformation(getApplicationInformation(sge), "request");

                SchemaType st = sge.getType();
                SchemaType basicType = sge.getType().getBaseType();
                // used to retrieve elements local annotations
                SchemaParticle schemaParticle = st.getContentModel();

                SchemaProperty[] properties = st.getProperties();
                for (int k = 0; k < properties.length; k++) {
                    SchemaProperty property = properties[k];
                    processProperty(property, schemaParticle,
                                    basicType.getContentModel(), k);
                }

                endRequest(sge.getName().getLocalPart());
            }
        } catch (XmlException xe) {
            logger.debug("XMLException : " + xe.getMessage());
            xe.printStackTrace();
        } catch (IOException ie) {
            logger.debug("IOException : " + ie.getMessage());
            ie.printStackTrace();
        }
    }

    private void parseContainedSelectors(XmlCursor xmlCursor, PluginDefinition pluginDefinition) {

        // store original state to restore it before returning
        xmlCursor.push();

        String upperNode = xmlCursor.getName().getLocalPart();
        if (xmlCursor.toFirstChild()) {
            do {
                // store current cointainer <container> element position
                // (we need it to go to the next sibling
                xmlCursor.push();

                if (IPluginGenerator.DOCUMENTATION_NODE.equals(upperNode)) {
                    String parent = null;
                    String source = null;
                    if (xmlCursor.toFirstAttribute()) {
                        // look for expected attributes
                        do {
                            if (xmlCursor.getName().getLocalPart().equals("parent")) {
                                parent = xmlCursor.getTextValue();
                            }
                            if (xmlCursor.getName().getLocalPart().equals("source")) {
                                source = xmlCursor.getTextValue();
                            }
                        } while (xmlCursor.toNextAttribute());

                        String[] parentSplit = parent.split(",");
                        for (int i = 0; i < parentSplit.length; i++) {
                            logger.debug("parseContainedSelectors() Adding " + parentSplit[i] + " with " + source);
                            pluginDefinition.addDocumentationSelector(parentSplit[i],
                                                                      source);
                        }
                    }
                } else if (IPluginGenerator.APPINFO_NODE.equals(upperNode)) {
                    String parent = null;
                    String node = null;
                    if (xmlCursor.toFirstAttribute()) {
                        // look for expected attributes
                        do {
                            if (xmlCursor.getName().getLocalPart().equals("parent")) {
                                parent = xmlCursor.getTextValue();
                            }
                            if (xmlCursor.getName().getLocalPart().equals("node")) {
                                node = xmlCursor.getTextValue();
                            }
                        } while (xmlCursor.toNextAttribute());

                        String[] parentSplit = parent.split(",");
                        String[] nodeSplit = node.split(",");
                        for (int i = 0; i < parentSplit.length; i++) {
                            logger.debug("parseContainedSelectors() Adding " + parentSplit[i]);
                            for (int j = 0; j < nodeSplit.length; j++)
                                logger.debug("parseContainedSelectors() \tWith node : " + nodeSplit[j]);
                            pluginDefinition.addApplicationSelector(parentSplit[i],
                                                                    nodeSplit);
                        }
                    }
                } else if (IPluginGenerator.CONFIGURATION_NODE.equals(upperNode)) {
                    IPluginGenerator pluginObj = pluginDefinition.getPluginInstance();
                    pluginObj.initialize(xmlCursor.newDomNode());
                } else {
                    logger.warn("parseContainedSelectors() Unrecognized node name : " + upperNode);
                }

                xmlCursor.pop();

            } while (xmlCursor.toNextSibling());
        }

        // restore cursor in its original state
        xmlCursor.pop();
    }

    public void registerPlugin(File pluginDefFile)
        throws PluginInstanciationException, IOException {
        
        logger.debug("registerPlugin() Received file : " + pluginDefFile);

        PluginDefinition pluginDefinition = new PluginDefinition();

        XmlObject[] xmlObjects = new XmlObject[1];
        try {
            xmlObjects[0] = XmlObject.Factory.parse(pluginDefFile);
        } catch (XmlException xe) {
            logger.fatal("registerPlugin() Error while parsing plugin definition file");
            throw new PluginInstanciationException("Error while parsing plugin definition file");
        }
        XmlCursor xmlCursor = xmlObjects[0].newCursor();
        try {
            xmlCursor.toFirstChild();
            xmlCursor.push();

            if (xmlCursor.toFirstAttribute()) {
                // look for attributes
                do {
                    if (xmlCursor.getName().getLocalPart().equals("id")) {
                        pluginDefinition.setId(xmlCursor.getTextValue());
                    }
                    if (xmlCursor.getName().getLocalPart().equals("classname")) {
                        String className = xmlCursor.getTextValue();
                        Class<?> realClass = null;
                        Object pluginObject = null;
                        try {
                            realClass = Class.forName(className);
                            pluginObject = realClass.newInstance();
                        } catch (Exception ie) {
                            logger.fatal("registerPlugin() Unable to instanciate plugin object for class " + className);
                            throw new PluginInstanciationException("Unable to instanciate plugin object for class " + realClass);
                        }
                        if (!(pluginObject instanceof IPluginGenerator)) {
                            logger.fatal("registerPlugin() Provided plugin class does not implement required plugin interface");
                            throw new PluginInstanciationException("Provided plugin class does not implement required plugin interface");
                        }
                        pluginDefinition.setPluginInstance((IPluginGenerator) pluginObject);
                    }
                } while (xmlCursor.toNextAttribute());
            }

            if (pluginDefinition.getId() == null
                || pluginDefinition.getPluginInstance() == null) {
                logger.fatal("registerPlugin() Invalid plugin definition, missing id or classname");
                throw new PluginInstanciationException("Invalid plugin definition, missing id or classname");
            }

            xmlCursor.pop();

            // no restrictions for this plugin
            if (!xmlCursor.toFirstChild()) {
                registeredPlugins.add(pluginDefinition);
                return;
            }

            xmlCursor.push();

            do {
                logger.debug("registerPlugin() Parsing : " + xmlCursor.getName().getLocalPart());
                parseContainedSelectors(xmlCursor, pluginDefinition);
            } while (xmlCursor.toNextSibling());
        } finally {
            xmlCursor.dispose();
        }

        logger.debug("registerPlugin() Registered plugin id : " + pluginDefinition.getId());
        registeredPlugins.add(pluginDefinition);
    }

    public void shutdownPlugins() {
        for (int i = 0; i < registeredPlugins.size(); i++) {
            PluginDefinition pluginDef = registeredPlugins.get(i);
            IPluginGenerator pluginObj = pluginDef.getPluginInstance();
            pluginObj.shutdown();
        }
    }

    /**
     * Simple utility method to remove leading and trailing unwanted characters
     */
    private static String normalize(final String inputString) {
        String output = inputString.trim();
        output = output.replaceAll("\n\t","");
        return output;
    }

    private static ArrayList<UserDocumentation> getUserInformation(SchemaAnnotated schemaAnnotated) {
        ArrayList<UserDocumentation> userDocList = new ArrayList<UserDocumentation>();
        SchemaAnnotation annotation = schemaAnnotated.getAnnotation();
        if (annotation != null) {
            String text = null;
            String lang = null;
            String source = null;
            HashMap<String, String> xmlTln = null;

            XmlObject[] userObjects = annotation.getUserInformation();
            for (int j = 0; j < userObjects.length; j++) {
                XmlCursor xc = userObjects[j].newCursor();
                try {
                    text = normalize(xc.getTextValue());

                    xc.push();

                    if (xc.toFirstAttribute()) {
                        // look for attributes
                        do {
                            if (xc.getName().getLocalPart().equals("lang")) {
                                lang = xc.getTextValue();
                            }
                            if (xc.getName().getLocalPart().equals("source")) {
                                source = xc.getTextValue();
                            }
                        } while (xc.toNextAttribute());
                    }

                    xc.pop();

                    if (xc.toFirstChild()) {
                        xmlTln = new HashMap<String, String>();
                        String key = null;
                        String value = null;
                        do {
                            xc.push();

                            if (xc.toFirstAttribute()) {
                                // look for attributes
                                do {
                                    if (xc.getName().getLocalPart().equals("key")) {
                                        key = xc.getTextValue();
                                    }
                                    if (xc.getName().getLocalPart().equals("value")) {
                                        value = xc.getTextValue();
                                    }
                                } while (xc.toNextAttribute());
                            }

                            if (key == null || value == null)
                                logger.warn("getUserInformation() Missing key or value attribute on annotation !");
                            else
                                xmlTln.put(key, value);

                            xc.pop();

                        } while (xc.toNextSibling());

                    }
                } finally {
                    xc.dispose();
                }
                UserDocumentation userDocumentation =
                    new UserDocumentation(source,lang,text,xmlTln);
                userDocList.add(userDocumentation);
            }
        }

        return userDocList;
    }

    private static ArrayList<ApplicationDocumentation> getApplicationInformation(SchemaAnnotated schemaAnnotated) {
        ArrayList<ApplicationDocumentation> appDocList = new ArrayList<ApplicationDocumentation>();
        SchemaAnnotation annotation = schemaAnnotated.getAnnotation();
        if (annotation != null) {
            String nodeName = null;
            String xmlString = null;
            Node xmlNode = null;

            XmlObject[] appObjects = annotation.getApplicationInformation();
            for (int j = 0; j < appObjects.length; j++) {
                XmlCursor xc = appObjects[j].newCursor();
                try {
                    xc.toFirstChild();
                    do {
                        nodeName = xc.getName().getLocalPart().toString();
                        xmlString = xc.xmlText();
                        xmlNode = xc.getDomNode();
                        ApplicationDocumentation appDocumentation =
                            new ApplicationDocumentation(nodeName, xmlString, xmlNode);
                        appDocList.add(appDocumentation);
                    } while (xc.toNextSibling());
                } finally {
                    xc.dispose();
                }
            }
        }

        return appDocList;
    }

    private void startRequest(String requestName, String targetNamespace) {
        commonPlugin.startRequest(requestName, targetNamespace);
        for (int i = 0; i < registeredPlugins.size(); i++) {
            PluginDefinition pluginDef = registeredPlugins.get(i);
            IPluginGenerator pluginObj = pluginDef.getPluginInstance();
            pluginObj.startRequest(requestName, targetNamespace);
        }
    }

    private void endRequest(String requestName) {
        
        for (int i = 0; i < registeredPlugins.size(); i++) {
            PluginDefinition pluginDef = registeredPlugins.get(i);
            IPluginGenerator pluginObj = pluginDef.getPluginInstance();
            pluginObj.endRequest(requestName);
        }
    }

    private void startElement(String elementName, String type) {
        commonPlugin.startElement(elementName, type);
        for (int i = 0; i < registeredPlugins.size(); i++) {
            PluginDefinition pluginDef = registeredPlugins.get(i);
            IPluginGenerator pluginObj = pluginDef.getPluginInstance();
            pluginObj.startElement(elementName, type);
        }
    }

    private void endElement(String elementName) {
        commonPlugin.endElement(elementName);
        for (int i = 0; i < registeredPlugins.size(); i++) {
            PluginDefinition pluginDef = registeredPlugins.get(i);
            IPluginGenerator pluginObj = pluginDef.getPluginInstance();
            pluginObj.endElement(elementName);
        }
    }

    private void startElementProperties(ElementProperties elementProperties) {

        for (int i = 0; i < registeredPlugins.size(); i++) {
            PluginDefinition pluginDef = registeredPlugins.get(i);
            IPluginGenerator pluginObj = pluginDef.getPluginInstance();
            pluginObj.startElementProperties(elementProperties);
        }
    }

    private void endElementProperties() {

        for (int i = 0; i < registeredPlugins.size(); i++) {
            PluginDefinition pluginDef = registeredPlugins.get(i);
            IPluginGenerator pluginObj = pluginDef.getPluginInstance();
            pluginObj.endElementProperties();
        }
    }

    private boolean belongsToBaseContentModel(SchemaParticle elementParticle,
                                                SchemaParticle baseContentModelParticle) {
        if (baseContentModelParticle.countOfParticleChild() > 0) {
            SchemaParticle[] baseParticles =
                baseContentModelParticle.getParticleChildren();
            for (int i = 0; i < baseParticles.length; i++) {
                if (baseParticles[i].getName().equals(elementParticle.getName()))
                    return true;
            }
        }

        return false;
    }

    /**
     * Process an XML Schema global property.
     */
    private void processProperty(SchemaProperty schemaProperty, SchemaParticle schemaParticle,
            SchemaParticle baseContentModelParticle, int propertyRank) {

        String elementName = schemaProperty.getName().getLocalPart().toString();

        // create the element's associated properties bean and start filling
        // some basic information
        ElementProperties eltProperties = new ElementProperties();
        eltProperties.setMinOccurs(schemaProperty.getMinOccurs());
        eltProperties.setMaxOccurs(schemaProperty.getMaxOccurs());
        if (schemaProperty.getDefaultValue() != null)
            eltProperties.setDefaultValue(schemaProperty.getDefaultValue().getStringValue());

        // calculate element's namespace
        // it will be used to make some deductions about element's properties (see below)
        String propertyNamespaceURI = null;
        SchemaType propertyType = schemaProperty.getType();
        if (propertyType.getName() != null) {
            propertyNamespaceURI = propertyType.getName().getNamespaceURI();
        } else if (propertyType.getSimpleVariety() == SchemaType.LIST) {
            // for lists, we have to pass through the list item type
            propertyNamespaceURI = propertyType.getListItemType().getPrimitiveType().getName().getNamespaceURI();
        } else {
            SchemaType propPrimitiveType = propertyType.getPrimitiveType();
            propertyNamespaceURI = propPrimitiveType.getName().getNamespaceURI();
        }

        // set some properties according to element's namespace
        if (propertyNamespaceURI.equals(targetNamespace)) {
            eltProperties.setRequestType(true);
            eltProperties.setReferentialType(false);
            eltProperties.setPrimitiveType(false);
        } else if (propertyNamespaceURI.equals(W3C_NS)) {
            eltProperties.setRequestType(false);
            eltProperties.setReferentialType(false);
            eltProperties.setPrimitiveType(true);
        } else {
            eltProperties.setRequestType(false);
            eltProperties.setReferentialType(true);
            eltProperties.setPrimitiveType(false);
        }
        eltProperties.setPatterns(propertyType.getPatterns());
        XmlAnySimpleType minLengthFacet = propertyType.getFacet(SchemaType.FACET_MIN_LENGTH);
        if (minLengthFacet != null) {
            int minLength = (new Integer(minLengthFacet.getStringValue())).intValue();
            eltProperties.setMinLength(minLength);
        }
        XmlAnySimpleType maxLengthFacet = propertyType.getFacet(SchemaType.FACET_MAX_LENGTH);
        if (maxLengthFacet != null) {
            int maxLength = (new Integer(maxLengthFacet.getStringValue())).intValue();
            eltProperties.setMaxLength(maxLength);
        }
        XmlAnySimpleType lengthFacet = propertyType.getFacet(SchemaType.FACET_LENGTH);
        if (lengthFacet != null) {
            int length = (new Integer(lengthFacet.getStringValue())).intValue();
            eltProperties.setLength(length);
        }
        if (propertyType.getFullJavaName() != null) {
            eltProperties.setXmlBeanType(propertyType.getFullJavaName());
        } else {
            // get up along the schema type hierarchy 'till we find a non-null XML Beans type
            SchemaType baseSchemaType = propertyType.getBaseType();
            while (baseSchemaType.getFullJavaName() == null) {
                baseSchemaType = baseSchemaType.getBaseType();
                if (baseSchemaType == null)
                    break;
            }
            if (baseSchemaType != null)
                eltProperties.setXmlBeanType(baseSchemaType.getFullJavaName());
            else
                eltProperties.setXmlBeanType(null);
        }

        if (javaTypesMap.get(eltProperties.getXmlBeanType()) != null) {
            String javaType = javaTypesMap.get(eltProperties.getXmlBeanType());
            eltProperties.setJavaType(javaType);
        }

        startElement(elementName, propertyType.toString());

        // go to the corresponding element particle to get the
        // annotations defined in this schema on the element
        SchemaParticle elementParticle = null;
        if (!schemaProperty.isAttribute()) {
            if (schemaParticle.getParticleType() == SchemaParticle.SEQUENCE) {
                elementParticle = schemaParticle.getParticleChild(propertyRank);
            } else if (schemaParticle.getParticleType() == SchemaParticle.ELEMENT) {
                // if schema particle is an element, we can access directly to its
                // schema local element
                elementParticle = schemaParticle;
            }

            // we found a schema particle for our element
            if (elementParticle != null) {
                SchemaLocalElement sle = (SchemaLocalElement) elementParticle;
                processUserInformation(getUserInformation(sle), "element");
                processApplicationInformation(getApplicationInformation(sle), "element");
                if (belongsToBaseContentModel(elementParticle, baseContentModelParticle))
                    eltProperties.setInherited(true);
                else
                    eltProperties.setInherited(false);
            } else {
                // this is a leaf, no inheriting
                eltProperties.setInherited(false);
            }
        }

        if (schemaParticle.getParticleType() == SchemaParticle.CHOICE)
            eltProperties.setChoiceElement(true);
        else
            eltProperties.setChoiceElement(false);

        if (propertyType.getName() != null)
            eltProperties.setXmlSchemaType(propertyType.getName().getLocalPart());

        if (propertyType.isSimpleType()) {
            eltProperties.setSimpleType(true);
            eltProperties.setComplexType(false);

            if (propertyType.getSimpleVariety() == SchemaType.ATOMIC) {
                int j = 0;
                XmlAnySimpleType[] xmlAst = propertyType.getEnumerationValues();
                if (xmlAst != null) {
                    String[] enumValues = new String[xmlAst.length];
                    for (j = 0; j < xmlAst.length; j++) {
                        enumValues[j] = xmlAst[j].getStringValue();
                    }
                    eltProperties.setEnumValues(enumValues);
                }
            } else if (propertyType.getSimpleVariety() == SchemaType.LIST) {
                eltProperties.setListType(true);
                XmlAnySimpleType listLengthFacet =
                    propertyType.getListItemType().getFacet(SchemaType.FACET_LENGTH);
                if (listLengthFacet != null) {
                    int length = (new Integer(listLengthFacet.getStringValue())).intValue();
                    eltProperties.setListLength(length);
                }
            } else if (propertyType.getSimpleVariety() == SchemaType.UNION) {
                logger.warn("processProperty() Simple Union Type not yet implemented");
            }

            startElementProperties(eltProperties);
            processUserInformation(getUserInformation(propertyType), "property");
            processApplicationInformation(getApplicationInformation(propertyType), "property");
            endElementProperties();

        } else {

            eltProperties.setSimpleType(false);
            eltProperties.setComplexType(true);
            if (propertyType.getName() != null
                && propertyType.getName().getLocalPart().equals("LocalReferentialType"))
                eltProperties.setLocalReferential(true);

            startElementProperties(eltProperties);
            processUserInformation(getUserInformation(propertyType), "property");
            processApplicationInformation(getApplicationInformation(propertyType), "property");
            endElementProperties();

            if (propertyType.getContentType() == SchemaType.EMPTY_CONTENT) {
                logger.warn("processProperty() Complex Empty Content not yet implemented");
            } else if (propertyType.getContentType() == SchemaType.SIMPLE_CONTENT) {
                logger.warn("processProperty() Complex Simple Content not yet implemented");
            } if (propertyType.getContentType() == SchemaType.ELEMENT_CONTENT) {
                SchemaParticle sp = propertyType.getContentModel();
                if (sp != null) {
                    if (sp.getParticleType() == SchemaParticle.ALL) {
                        logger.warn("processProperty() Complex Element Content of type ALL not yet implemented");

                    } else if (sp.getParticleType() == SchemaParticle.SEQUENCE
                               || sp.getParticleType() == SchemaParticle.ELEMENT
                               || sp.getParticleType() == SchemaParticle.CHOICE) {
                        if (propertyType.getName().getLocalPart().equals("LocalReferentialDataType")) {
                            logger.warn("processProperty() Dealing with local referential data type, not going into an endless recursive loop !");
                        } else {
                            SchemaProperty[] schemaSubProperties = propertyType.getProperties();
                            for (int m = 0; m < schemaSubProperties.length; m++) {
                                processProperty(schemaSubProperties[m], sp,
                                                propertyType.getBaseType().getContentModel(), m);
                            }
                        }
                    } else if (sp.getParticleType() == SchemaParticle.WILDCARD) {
                        logger.warn("processProperty() Complex Element Content of type WILDCARD not yet implemented");

                    }
                }
            } if (propertyType.getContentType() == SchemaType.MIXED_CONTENT) {
                logger.debug("processProperty() Complex Mixed content not yet implemented");
            }
        }

        endElement(elementName);
    }

    private void processUserInformation(
        ArrayList<UserDocumentation> userDocumentationList, String parent) {

        if (userDocumentationList == null || userDocumentationList.size() == 0)
            return;

        // for each documentation element in the list, send data to plugins
        // interested in this (parent, source) pair
        for (UserDocumentation userDocumentation : userDocumentationList) {
//             logger.debug("processUserInformation() User documentation has source " + userDocumentation.getSourceUri() + " and parent " + parent);
            for (PluginDefinition pluginDef : registeredPlugins) {
                for (Map.Entry<String, String> entry :
                    pluginDef.getDocumentationSelectors().entrySet()) {
//                     logger.debug("processUserInformation() Plugin has source " + source + " and parent " + docParent);
                    if (parent.equals(entry.getKey()) || entry.getKey().equals("*")) {
                        if ((userDocumentation.getSourceUri() != null
                             && userDocumentation.getSourceUri().equals(entry.getValue()))
                            || entry.getValue().equals("*")) {
                            // parent and source match, send event and go to the next
                            // plugin
                            IPluginGenerator pluginObj = pluginDef.getPluginInstance();
                            pluginObj.onUserInformation(userDocumentation);
                            break;
                        } else {
                            // parent matches but not source, let's go to the next plugin
                            break;
                        }
                    }
                }
            }
        }
    }

    private void processApplicationInformation(
        ArrayList<ApplicationDocumentation> applicationDocumentationList,
        String parent) {

        // for each application element in the list, send data to plugins
        // interested in this (parent, node) pair
        for (ApplicationDocumentation applicationDocumentation :
            applicationDocumentationList) {
//             logger.debug("processApplicationInformation() Application documentation has node " + applicationDocumentation.getNodeName() + " and parent " + parent);

            if (applicationDocumentation.getNodeName().equals("common"))
                commonPlugin.onApplicationInformation(applicationDocumentation);
            else
                commonPlugin.onOtherApplicationInformation(applicationDocumentation);

            for (PluginDefinition pluginDef : registeredPlugins) {
                for (Map.Entry<String, String[]> entry : pluginDef.getApplicationSelectors().entrySet()) {
                    if (parent.equals(entry.getKey()) || entry.getKey().equals("*")) {
                        boolean foundNode = false;
                        for (String currentNode : entry.getValue()) {
                            logger.debug("processApplicationInformation() Plugin has node " + currentNode + " and parent " + entry.getKey());
                            if (applicationDocumentation.getNodeName().equals(currentNode)
                                || currentNode.equals("*")) {
                                // parent and node name match, send event and go to the next
                                // plugin
                                IPluginGenerator pluginObj = pluginDef.getPluginInstance();
                                pluginObj.onApplicationInformation(applicationDocumentation);
                                foundNode = true;
                                break;
                            }
                        }
                        if (!foundNode)
                            // parent matches but not node name, let's go to the next plugin
                            break;
                    }
                }
            }
        }
    }

    private class PluginDefinition {

        /** an unique string representing the plugin */
        private String id;
        /** interface to the real plugin class */
        private IPluginGenerator pluginInstance;
        /** a hashmap of (selector, source) pairs */
        private HashMap<String, String> documentationSelectors;
        /** a hashmap of (selector, node) pairs */
        private HashMap<String, String[]> applicationSelectors;

        public PluginDefinition() {
            documentationSelectors = new HashMap<String, String>();
            applicationSelectors = new HashMap<String, String[]>();
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public IPluginGenerator getPluginInstance() {
            return pluginInstance;
        }

        public void setPluginInstance(IPluginGenerator pluginInstance) {
            this.pluginInstance = pluginInstance;
        }

        public HashMap<String, String> getDocumentationSelectors() {
            return documentationSelectors;
        }

        public void setDocumentationSelectors(HashMap<String, String> documentationSelectors) {
            this.documentationSelectors = documentationSelectors;
        }

        public void addDocumentationSelector(String path, String source) {
            this.documentationSelectors.put(path, source);
        }

        public HashMap<String, String[]> getApplicationSelectors() {
            return applicationSelectors;
        }

        public void setApplicationSelectors(HashMap<String, String[]> applicationSelectors) {
            this.applicationSelectors = applicationSelectors;
        }

        public void addApplicationSelector(String path, String[] nodes) {
            this.applicationSelectors.put(path, nodes);
        }
    }

    /**
     * An entry point to test code generator without the whole ant machinery
     *
     * @todo update to the latest version
     */
    public static void main(String args[]) {

        if (args.length < 2) {
            System.out.println("No xml schema file.");
            if (args.length < 1)
                System.out.println("No plugin directory.");

            return;
        }
        File xmlDir = new File(args[0]);
        if (!xmlDir.isDirectory()) {
            System.out.println("The first parameter does not contain a directory (for the plugins).");
            return;
        }

        StringTokenizer tokens = new StringTokenizer(args[1],",");
        Set<String> plugins = new HashSet<String>();
        while (tokens.hasMoreTokens())
            plugins.add(tokens.nextToken());
        
        File xsdFile = new File(args[2]);
        if (!xsdFile.isFile()) {
            System.out.println("The second parameter does not contain a file (for the xml schema).");
            return;
        }

        CodeGenerator codeGenerator = new CodeGenerator();

        // register plugins

        String[] pathElements = xmlDir.list();
        for (int i = 0; i < pathElements.length; i++) {
            String elem = pathElements[i];
            if (elem.endsWith("_plugin.xml")) {
                elem = elem.substring(0, elem.lastIndexOf("_plugin.xml"));
                if (plugins.contains(elem))
                    try {
                        codeGenerator.registerPlugin(new File(xmlDir, pathElements[i]));
                    } catch (PluginInstanciationException pie) {
                        System.out.println("Error while loading plugin " + pathElements[i] + "("
                                + pie.getMessage() + ")");
                    } catch (IOException xe) {
                        System.out.println("IO Exception while parsing plugin definition from "
                                + pathElements[i]);
                    }
            }
        }

        codeGenerator.parseXsdFile(xsdFile);
    }
}
