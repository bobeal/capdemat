package fr.cg95.cvq.generator.plugins.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import fr.cg95.cvq.generator.ApplicationDocumentation;
import fr.cg95.cvq.generator.ElementProperties;
import fr.cg95.cvq.generator.IPluginGenerator;
import fr.cg95.cvq.generator.plugins.tool.GroovyManager;

/**
 * An in-memory representation of the to-be-generated request.
 *
 * An instance of this class is filled by the model plugin as it receives
 * events from the generator. Upon completion of the parsing, the model plugin
 * asks this class to generate the effective code.
 *
 * @author bor@zenexity.fr
 */
public class ModelRequestObject {

    private static Logger logger = Logger.getLogger(ModelRequestObject.class);

    private static final String BUSINESS_OBJECTS_PREFIX_DIR = "/business/request/";

    /**
     * The base directory in which we generate business objects.
     * Configurable in Model plugin configuration file (src/xml/plugins/model_plugin.xml)
     */
    private String outputDir;

    /**
     * The base directory in which we generate services test classes
     * Configurable in Model plugin configuration file (src/xml/plugins/model_plugin.xml)
     */
    private String outputTestDir;

    /** the name of the request being generated */
    private String requestName;

    /** the last particle of the namespace in which business object is generated
     * (eg school) */
    private String requestNamespaceLastParticle;

    /** a map of first-level elements with their properties */
    private SortedMap<String, ElementModelProperties> elementsPropertiesMap;

    /** a map of first-level elements with their model annotations */
    private SortedMap<String, ApplicationDocumentation> elementsModelInfoMap;

    /** the complex types defined locally (ie in the current request) */
    private SortedMap<String, ComplexType> complexTypesMap;

    public ModelRequestObject() {
        elementsPropertiesMap = new TreeMap<String, ElementModelProperties>();
        elementsModelInfoMap = new TreeMap<String, ApplicationDocumentation>();
        complexTypesMap = new TreeMap<String, ComplexType>();
    }

    /**
     * Add a first-level element (ie an element of the request itself)
     *
     * @param elementName name of the field to be added
     * @param eltProperties properties associated to this element
     * @param complexContainerElementTypeName for elements defined within a local complex type,
     *        the type name of this complex type
     * @param complexContainerElementName for elements defined within a local complex type,
     *        the name of this complex type
     */
    public void addField(String elementName, ElementProperties eltProperties,
            String complexContainerElementTypeName, String complexContainerElementName) {

        ElementModelProperties eltModelProp = new ElementModelProperties(eltProperties);
        eltModelProp.setElementName(elementName);

        if (complexContainerElementTypeName != null) {
            eltModelProp.setComplexContainerElementTypeName(complexContainerElementTypeName);
            eltModelProp.setComplexContainerElementName(complexContainerElementName);
        }
        eltModelProp.setNameAsParam(StringUtils.uncapitalize(elementName));
        elementsPropertiesMap.put(elementName, eltModelProp);

        processElementApplicationDocumentation(eltModelProp, elementName);
    }

    /**
     * Remove a first-level field/element from the current request
     */
    public void removeField(String elementName) {
        elementsPropertiesMap.remove(elementName);
    }

    /**
     * Get the properties of the given field
     *
     * @return the {@link ElementModelProperties} object associated to this field
     */
    public ElementModelProperties getField(String elementName) {
        return elementsPropertiesMap.get(elementName);
    }

    /**
     * Add documentation information for the given first-level element.
     *
     * @param elementName name of the field to be added
     * @param appDocumentation documentation information associated with the field
     */
    public void addFieldInfo(String elementName, ApplicationDocumentation appDocumentation) {
        elementsModelInfoMap.put(elementName, appDocumentation);
    }

    /**
     * Add the definition of a complex type local to the request (ie it is defined
     * in the same XSD file)
     *
     * @param typeName name of the "local" complex type
     * @param eltProperties properties associated to this complex type
     */
    public ComplexType addComplexType(String typeName, ElementProperties eltProperties) {
        ComplexType complexType = new ComplexType();
        complexType.setTypeName(StringUtils.removeEnd(typeName,"Type"));
        ElementModelProperties eltModelProperties = new ElementModelProperties(eltProperties);
        complexType.setProperties(eltModelProperties);

        complexTypesMap.put(typeName, complexType);
        return complexType;
    }

    private void processElementApplicationDocumentation(ElementModelProperties eltModelProperties,
            final String elementName) {
        ApplicationDocumentation appDocumentation = elementsModelInfoMap.get(elementName);
        if (appDocumentation == null) {
            // no namespace definition override in application documentation
            // so it defaults to the current request namespace
            eltModelProperties.setNamespaceLastParticle(requestNamespaceLastParticle);
            eltModelProperties.setJavaPackageName(IPluginGenerator.MODEL_BASE_TARGET_NS + ".request."
                                            + requestNamespaceLastParticle + ".");
        } else {
            String namespaceLastParticle =
                ApplicationDocumentation.getNodeAttributeValue(appDocumentation.getXmlNode(), "namespace");
            logger.debug("processElementApplicationDocumentation() namespace last particle " 
                    + namespaceLastParticle);

            eltModelProperties.setNamespaceLastParticle(namespaceLastParticle);

            // if it comes from the referential, namespace is provided within the XML schema file
            // else it belongs to the current request's namespace
            if (namespaceLastParticle != null
                && namespaceLastParticle.equals(requestNamespaceLastParticle ))
                eltModelProperties.setJavaPackageName(IPluginGenerator.MODEL_BASE_TARGET_NS + ".request."
                                                + namespaceLastParticle + ".");
            else if (namespaceLastParticle != null)
                eltModelProperties.setJavaPackageName(IPluginGenerator.MODEL_BASE_TARGET_NS + "."
                                                + namespaceLastParticle + ".");
            else if (eltModelProperties.isRequestType())
                eltModelProperties.setJavaPackageName(IPluginGenerator.MODEL_BASE_TARGET_NS + "."
                                                + requestNamespaceLastParticle + ".");
            else
                eltModelProperties.setJavaPackageName("");
            
            String isTiedToRequest =
                ApplicationDocumentation.getNodeAttributeValue(appDocumentation.getXmlNode(), "isTiedToRequest");
            if (isTiedToRequest == null || !isTiedToRequest.equals("true"))
                eltModelProperties.setTiedToRequest(false);
            else
                eltModelProperties.setTiedToRequest(true);
        }
    }
    
    /**
     * Add the definition of an element to a local complex type.
     *
     * @param complexTypeName name of the local complex type for which we want to add an
     *                 element's definition
     * @param elementName name of the element to be added
     * @param eltProperties properties of the element to be added
     */
    public void addElementToComplexType(String complexTypeName, String elementName,
            ElementProperties eltProperties) {

        ComplexType complexType = complexTypesMap.get(complexTypeName);
        ElementModelProperties eltModelProperties = new ElementModelProperties(eltProperties);
        eltModelProperties.setNameAsParam(StringUtils.uncapitalize(elementName));
        
        processElementApplicationDocumentation(eltModelProperties, elementName);
 
        complexType.addElement(elementName, eltModelProperties);
    }

    private String transformNamespaceLastParticle(final String namespaceLastParticle) {
        return namespaceLastParticle.replace('.','/');
    }

    /**
     * Utility method that creates and opens a file aimed at receiving the contents
     * of a business object
     */
    private void writeBusinessObjectFile(String baseFileName, byte[] data) {
        String directory = outputDir + BUSINESS_OBJECTS_PREFIX_DIR
            + transformNamespaceLastParticle(requestNamespaceLastParticle);
        String filename = directory + "/" + baseFileName + ".java";

        // create directories on the path if they do not exist
        File dirPath = new File(directory);
        dirPath.mkdirs();

        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(filename);
            fos.write(data);
        } catch (FileNotFoundException fnfe) {
            logger.error("writeBusinessObjectFile() unable to create file : " + filename);
        } catch (IOException ioe) {
            logger.error("writeBusinessObjectFile() error while writing business object " + ioe.getMessage());
        }

        logger.debug("writeBusinessObjectFile() successfully wrote file : " + filename);
    }

    /**
     * Entry point for the generation of files associated to a request.
     * Call respectively the generation of business objects and a sample service test class.
     */
    public void generateRequest() {
        generateRequestObject();
        for (ComplexType complexType : complexTypesMap.values()) {
            complexType.generate();
        }
        generateSampleServiceTestClass();

        // reset local maps for the next request
        elementsPropertiesMap.clear();
        elementsModelInfoMap.clear();
        complexTypesMap.clear();
    }

    /**
     * Generate a base service test class and an empty class where to feed request
     * with specific data.
     */
    private void generateSampleServiceTestClass() {
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("request", this);
        String basePath = outputTestDir + "/"
            + transformNamespaceLastParticle(requestNamespaceLastParticle) + "/" + requestName;
        GroovyManager.generate(basePath + "ServiceTest.java", "ServiceTest.groovy", model);
        File javaFile = new File(basePath + "Feeder.java");
        if (javaFile.exists()) {
            logger.debug("generateSampleServiceTestClass() Request feeder class already exists, ignoring");
        } else {
            GroovyManager.generate(javaFile, "RequestFeeder.groovy", model);
        }
    }

    private void generateRequestObject() {
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("request", this);
        model.put("baseNS", IPluginGenerator.MODEL_BASE_TARGET_NS);
        model.put("lastParticle", requestNamespaceLastParticle);
        model.put("XMLBeansBaseNS", IPluginGenerator.XMLBEANS_BASE_TARGET_NS);
        model.put("sqlName", ModelPluginUtils.getSQLName(requestName));
        model.put("requestName", requestName);
        Map<String, String> constructorAttributes = new LinkedHashMap<String, String>();
        for (String elementName : elementsPropertiesMap.keySet()) {
            ElementModelProperties eltProperties = elementsPropertiesMap.get(elementName);
            if (eltProperties.getDefaultValue() != null) {
                // currently only identified two cases where default values have a sense :
                //     -> a string with enumerations
                //     -> a boolean
                String xmlBeanType = eltProperties.getXmlBeanType();
                if (xmlBeanType.indexOf("XmlString") != -1
                    && eltProperties.getEnumValues() != null) {
                    String type = eltProperties.getJavaPackageName();
                    if (eltProperties.getXmlSchemaType() != null)
                        type += eltProperties.getXmlSchemaType();
                    else
                        type += elementName;
                    constructorAttributes.put(eltProperties.getNameAsParam(),
                        type + "." + ModelPluginUtils.getEnumStaticName(eltProperties.getDefaultValue()));
                } else if (xmlBeanType.indexOf("XmlBoolean") != -1) {
                    constructorAttributes.put(eltProperties.getNameAsParam(),
                        "Boolean.valueOf(" + eltProperties.getDefaultValue() + ")");
                }
            }
            if (eltProperties.isSimpleType() && eltProperties.getEnumValues() != null
                && eltProperties.isRequestType()) {
                generateEnumClass(eltProperties.getXmlSchemaType(), eltProperties);
            }
        }
        model.put("constructorAttributes", constructorAttributes);
        model.put("elements", elementsPropertiesMap.values());
        writeBusinessObjectFile(requestName, GroovyManager.generate("Request.groovy", model).getBytes());
        writeBusinessObjectFile(requestName + "Data", GroovyManager.generate("RequestData.groovy", model).getBytes());
    }

    private void generateEnumClass(String className, ElementProperties eltProperties) {
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("baseNS", IPluginGenerator.MODEL_BASE_TARGET_NS);
        model.put("lastParticle", requestNamespaceLastParticle);
        model.put("name", className);
        Map<String, String> values = new LinkedHashMap<String, String>();
        for (String value : eltProperties.getEnumValues()) {
            values.put(ModelPluginUtils.getEnumStaticName(value), value);
        }
        model.put("values", values);
        model.put("defaultValue",
            eltProperties.getDefaultValue() == null ? null :
                ModelPluginUtils.getEnumStaticName(eltProperties.getDefaultValue()));
        writeBusinessObjectFile(className, GroovyManager.generate("Enum.groovy", model).getBytes());
    }

    /**
     * Utility method called from the Groovy template that is in charge of generating
     * unit tests skeletons.
     */
    public String getRandomEnumFromTab(String[] enumValues) {
        return enumValues[0];
    }
    
    public class ComplexType {

        private String typeName;
        private ElementModelProperties eltModelProperties;
        private HashMap<String, ElementModelProperties>
            elementsModelPropertiesMap;
        private HashMap<String, ApplicationDocumentation> elementsModelInfoMap;

        public ComplexType() {
            elementsModelPropertiesMap =
                new HashMap<String, ElementModelProperties>();
            elementsModelInfoMap =
                new HashMap<String, ApplicationDocumentation>();
        }

        private void generate() {
            Map<String, Object> model = new HashMap<String, Object>();
            model.put("complexType", this);
            model.put("baseNS", IPluginGenerator.MODEL_BASE_TARGET_NS);
            model.put("lastParticle", requestNamespaceLastParticle);
            model.put("XMLBeansBaseNS", IPluginGenerator.XMLBEANS_BASE_TARGET_NS);
            model.put("sqlName", ModelPluginUtils.getSQLName(typeName));
            model.put("className", typeName);
            Map<String, String> constructorAttributes = new LinkedHashMap<String, String>();
            for (String elementName : elementsModelPropertiesMap.keySet()) {
                ElementModelProperties eltProperties = elementsModelPropertiesMap.get(elementName);
                if (eltProperties.getDefaultValue() != null) {
                    // currently only identified two cases where default values have a sense :
                    //     -> a string with enumerations
                    //     -> a boolean
                    String xmlBeanType = eltProperties.getXmlBeanType();
                    if (xmlBeanType.indexOf("XmlString") != -1
                        && eltProperties.getEnumValues() != null) {
                        String type = eltProperties.getJavaPackageName();
                        if (eltProperties.getXmlSchemaType() != null)
                            type += eltProperties.getXmlSchemaType();
                        else
                            type += elementName;
                        constructorAttributes.put(eltProperties.getNameAsParam(),
                            type + "." + ModelPluginUtils.getEnumStaticName(eltProperties.getDefaultValue()));
                    } else if (xmlBeanType.indexOf("XmlBoolean") != -1) {
                        constructorAttributes.put(eltProperties.getNameAsParam(),
                            "Boolean.valueOf(" + eltProperties.getDefaultValue() + ")");
                    }
                }
                if (eltProperties.isSimpleType() && eltProperties.getEnumValues() != null
                    && eltProperties.isRequestType()) {
                    generateEnumClass(eltProperties.getXmlSchemaType(), eltProperties);
                }
            }
            model.put("constructorAttributes", constructorAttributes);
            model.put("elements", elementsModelPropertiesMap.values());
            writeBusinessObjectFile(typeName, GroovyManager.generate("ComplexType.groovy", model).getBytes());
        }

        public void setTypeName(String typeName) {
            this.typeName = typeName;
        }

        public String getTypeName() {
            return this.typeName;
        }

        public void setProperties(ElementModelProperties eltModelProperties) {
            this.eltModelProperties = eltModelProperties;
        }

        public ElementModelProperties getProperties() {
            return this.eltModelProperties;
        }

        public void addElement(String elementName,
            ElementModelProperties eltModelProperties) {
            elementsModelPropertiesMap.put(elementName, eltModelProperties);
        }

        public Set<String> getElementsNames() {
            return elementsModelPropertiesMap.keySet();
        }

        public ElementModelProperties getElementModelProperties(String elementName) {
            return elementsModelPropertiesMap.get(elementName);
        }

        public HashMap<String, ElementModelProperties>
            getElementsModelPropertiesMap() {
            return elementsModelPropertiesMap;
        }

        public void addElementModelInfo(String elementName,
            ApplicationDocumentation appDocumentation) {
            elementsModelInfoMap.put(elementName, appDocumentation);
        }

        public ApplicationDocumentation getElementModelInfo(String elementName) {
            return elementsModelInfoMap.get(elementName);
        }

        public HashMap<String, ApplicationDocumentation>
            getElementsModelInfoMap() {
            return elementsModelInfoMap;
        }
    }

    // getters and setters go below

    public void setOutputDir(String outputDir) {
        this.outputDir = outputDir;
    }

    public void setOutputTestDir(String outputTestDir) {
        this.outputTestDir = outputTestDir;
    }

    public void setRequestName(String requestName) {
        this.requestName = requestName;
    }

    public String getRequestName() {
        return this.requestName;
    }

    public void setRequestNamespaceLastParticle(String requestNamespaceLastParticle) {
        this.requestNamespaceLastParticle = requestNamespaceLastParticle;
    }

    public String getRequestNamespaceLastParticle() {
        return this.requestNamespaceLastParticle;
    }

    public Map<String, ElementModelProperties> getElementsPropertiesMap() {
        return this.elementsPropertiesMap;
    }

    public Map<String, ComplexType> getComplexTypesMap() {
        return complexTypesMap;
    }
}
