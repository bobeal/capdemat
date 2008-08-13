package fr.cg95.cvq.util.localization.impl;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.xml.namespace.QName;
import javax.xml.transform.dom.DOMSource;

import net.sf.saxon.om.NodeInfo;
import net.sf.saxon.xpath.XPathEvaluator;
import net.sf.saxon.xpath.XPathException;

import org.apache.log4j.Logger;
import org.apache.xmlbeans.SchemaAnnotation;
import org.apache.xmlbeans.SchemaGlobalElement;
import org.apache.xmlbeans.SchemaLocalElement;
import org.apache.xmlbeans.SchemaParticle;
import org.apache.xmlbeans.SchemaProperty;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SchemaTypeLoader;
import org.apache.xmlbeans.SchemaTypeSystem;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlCursor;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument;

import fr.cg95.cvq.schema.referential.GlobalReferentialDocument;
import fr.cg95.cvq.schema.referential.GlobalReferentialDocument.GlobalReferential;
import fr.cg95.cvq.schema.referential.GlobalReferentialDocument.GlobalReferential.Data;
import fr.cg95.cvq.schema.referential.GlobalReferentialDocument.GlobalReferential.Data.Entry;
import fr.cg95.cvq.schema.referential.GlobalReferentialDocument.GlobalReferential.Data.Entry.Label;
import fr.cg95.cvq.util.localization.ILocalizationService;

/**
 * Implementation of the {@link ILocalizationService} service.
 *
 * @author bor@zenexity.fr
 * @author mna@zenexity.fr
 */
public class LocalizationService implements ILocalizationService {

    private static Logger logger = Logger.getLogger(LocalizationService.class);

    private static SchemaTypeLoader schemaTypeLoader;
    private static Map<QName, Map> commonEnumerationsMap = 
        Collections.synchronizedMap(new HashMap<QName, Map>());
    
    public void init() {
        logger.info("init()");

        schemaTypeLoader = XmlBeans.typeLoaderForClassLoader(SchemaDocument.class.getClassLoader());
    }

    public String getElementTranslation(final String className, final String elementName,
            final String lang) {

        logger.debug("getElementTranslation() searching for field " + elementName + " in class "
                + className + " for lang " + lang);

        SchemaType schemaType = schemaTypeLoader.typeForClassname(className);
        SchemaParticle schemaParticle = schemaType.getContentModel();

        SchemaProperty[] schemaProperties = schemaType.getElementProperties();
        for (int i = 0; i < schemaProperties.length; i++) {
            QName qName = schemaProperties[i].getName();
            if (qName.getLocalPart().equals(elementName)) {

                // first, try to find translation on annotation inside element
                // particle declaration
                SchemaParticle elementParticle = schemaParticle.getParticleChild(i);
                SchemaLocalElement localElement = (SchemaLocalElement) elementParticle;
                String translation = extractTranslation(localElement.getAnnotation(), lang);
                if (translation != null)
                    return translation;

                // not found so search on element type declaration
                SchemaType propertyType = schemaProperties[i].getType();
                while (propertyType != null) {
                    SchemaAnnotation schemaAnnotation = propertyType.getAnnotation();
                    translation = extractTranslation(schemaAnnotation, lang);
                    if (translation != null)
                        return translation;
                    propertyType = propertyType.getBaseType();
                }
            }
        }

        return elementName;
    }

    public NodeInfo getEnumsDataNode(final String requestNamespace, 
            final String elementTypeName, final String lang) {

        logger.debug("getEnumsDataNode() searching enums of type " + elementTypeName + " in request "
                + requestNamespace);

        QName qname = new QName(requestNamespace, elementTypeName);
        synchronized(this) {
            if (!commonEnumerationsMap.containsKey(qname)) {
                logger.debug("getEnumsDataNode() not in cache");
                SchemaType schemaType = schemaTypeLoader.findType(qname);
                if (schemaType == null) {
                    logger.warn("getEnumsDataNode() could not find QName : " + qname);
                    return null;
                }
                SchemaAnnotation schemaAnnotation = schemaType.getAnnotation();
                commonEnumerationsMap.put(qname, parseEnums(schemaAnnotation, lang));
            } else {
                logger.debug("getEnumsDataNode() returning cached results");                
            }
        }

        Map enumsMap = commonEnumerationsMap.get(qname);
        if (enumsMap == null) {
            logger.warn("getEnumsDataNode() could not find enums of type " + elementTypeName);
            return null;
        }
        
        // create document and set needed information
        GlobalReferentialDocument grdDoc = GlobalReferentialDocument.Factory.newInstance();
        GlobalReferential grd = grdDoc.addNewGlobalReferential();
        Data data = grd.addNewData();
        data.setName(elementTypeName);
        
        Iterator enumsMapIt = enumsMap.keySet().iterator();
        while (enumsMapIt.hasNext()) {
            String key = (String) enumsMapIt.next();
            Entry entry = data.addNewEntry();
            entry.setKey(key);
            Label label = entry.addNewLabel();
            label.setLang(lang);
            label.setStringValue((String) enumsMap.get(key));
        }
        
        // build an XPath evaluator to wrap the document result in a Saxon NodeInfo object
        XPathEvaluator xPathEvaluator = new XPathEvaluator();
        NodeInfo nodeInfo = null;
        try {
            nodeInfo = xPathEvaluator.setSource(new DOMSource(grdDoc.getDomNode()));
        } catch (XPathException xpe) {
            logger.error("XPathException :" + xpe.getMessage());
            return null;
        }
        
        return nodeInfo;
    }
    
    public String getEnumElementTranslation(final String className, final String elementName,
            final String enumValue, final String lang) {

//        logger.debug("getEnumElementTranslation() searching for enum " + enumValue + " in field "
//                + elementName + " for lang " + lang);

        SchemaType schemaType = schemaTypeLoader.typeForClassname(className);
        Map enumsMap = searchEnumsInSchemaType(schemaType, elementName, lang);
        
        return (String) enumsMap.get(enumValue);
    }

    public String getEnumKeyFromTranslation(final String className, final String elementName,
            final String enumTranslatedValue, final String lang) {

        SchemaType schemaType = schemaTypeLoader.typeForClassname(className);
        Map enumsMap = searchEnumsInSchemaType(schemaType, elementName, lang);
        
        Collection translatedValues = enumsMap.keySet();
        Iterator translatedValuesIt = translatedValues.iterator();
        while (translatedValuesIt.hasNext()) {
            String enumKey = (String) translatedValuesIt.next();
            String translatedValue = (String) enumsMap.get(enumKey);
            if (translatedValue.equals(enumTranslatedValue))
                return enumKey;
        }
        
        return null;
    }

    private Map searchEnumsInSchemaType(final SchemaType schemaType, final String elementName, 
            final String lang) {

        SchemaParticle schemaParticle = schemaType.getContentModel();

        SchemaProperty[] schemaProperties = schemaType.getElementProperties();
        for (int i = 0; i < schemaProperties.length; i++) {
            QName qName = schemaProperties[i].getName();
            if (qName.getLocalPart().equals(elementName)) {

                // first, try to find translation on annotation inside element
                // particle declaration
                SchemaParticle elementParticle = schemaParticle.getParticleChild(i);
                SchemaLocalElement localElement = (SchemaLocalElement) elementParticle;
                Map enumsMap = parseEnums(localElement.getAnnotation(), lang);
                if (enumsMap != null && !enumsMap.isEmpty())
                    return enumsMap;

                // not found so search on element type declaration
                SchemaType propertyType = schemaProperties[i].getType();
                while (propertyType != null) {
                    SchemaAnnotation schemaAnnotation = propertyType.getAnnotation();
                    enumsMap = parseEnums(schemaAnnotation, lang);
                    if (enumsMap != null)
                        return enumsMap;
                    propertyType = propertyType.getBaseType();
                }
            }
        }
        
        return null;
    }
    
    private Map<String, String> parseEnums(final SchemaAnnotation schemaAnnotation, 
            final String lang) {
        
        if (schemaAnnotation == null)
            return null;
        
        Map<String, String> resultEnums = new HashMap<String, String>();
        XmlObject[] xmlObjects = schemaAnnotation.getUserInformation();
        for (int j = 0; j < xmlObjects.length; j++) {
            boolean foundLang = false;
            boolean foundSource = false;
            XmlCursor xc = xmlObjects[j].newCursor();
            try {
                xc.push();
                if (xc.toFirstAttribute()) {
                    // look for attributes
                    do {
                        if (xc.getName().getLocalPart().equals("lang")
                                && xc.getTextValue().equals(lang)) {
                            foundLang = true;
                        }
                        if (xc.getName().getLocalPart().equals("source")
                                && xc.getTextValue().equals(
                                        "http://www.cg95.fr/cvq/schema/translation/enum")) {
                            foundSource = true;
                        }
                    } while (xc.toNextAttribute());
                }

                if (foundLang && foundSource) {

                    xc.pop();

                    if (xc.toFirstChild()) {
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

                            resultEnums.put(key, value);
                            
                            xc.pop();

                        } while (xc.toNextSibling());
                    }
                }

            } finally {
                xc.dispose();
            }
        }

        return resultEnums;
    }
    
    public String getRequestLabelTranslation(String requestTypeName, String lang) {

        String requestTypeShortName = requestTypeName.substring(requestTypeName.lastIndexOf('.') + 1);
        SchemaType schemaType = getSchemaTypeFromRequestLabel(requestTypeName);
        SchemaTypeSystem schemaTypeSystem = schemaType.getTypeSystem();
        SchemaGlobalElement[] schemaGlobalElements = schemaTypeSystem.globalElements();
        SchemaGlobalElement schemaGlobalElement = null;
        for (int i = 0; i < schemaGlobalElements.length; i++) {
            String globalElementName = schemaGlobalElements[i].getName().getLocalPart();
            if (globalElementName.equals(requestTypeShortName)) {
                schemaGlobalElement = schemaGlobalElements[i];
                break;
            }
        }
        if (schemaGlobalElement == null) {
            logger.warn("getRequestTypeLabel() no global element with name " 
                    + requestTypeShortName + " found");
            return requestTypeName;
        }
        
        SchemaAnnotation schemaAnnotation = schemaGlobalElement.getAnnotation();
        if (schemaAnnotation == null) {
            logger.warn("getRequestTypeLabel() no annotation found");
            return requestTypeName;
        }

        XmlObject[] xmlObjects = schemaAnnotation.getUserInformation();
        for (int j = 0; j < xmlObjects.length; j++) {
            boolean foundLang = false;
            boolean foundSource = false;
            XmlCursor xc = xmlObjects[j].newCursor();
            try {

                xc.push();

                if (xc.toFirstAttribute()) {
                    // look for attributes
                    do {
                        if (xc.getName().getLocalPart().equals("lang")
                                && xc.getTextValue().equals(lang)) {
                            foundLang = true;
                        }
                        if (xc.getName().getLocalPart().equals("source")
                                && xc.getTextValue().equals(
                                        "http://www.cg95.fr/cvq/schema/longdesc")) {
                            foundSource = true;
                        }

                        if (foundLang && foundSource) {
                            xc.pop();
                            return normalize(xc.getTextValue());
                        }

                    } while (xc.toNextAttribute());
                }

            } finally {
                xc.dispose();
            }
        }

        return requestTypeName;
    }

    private SchemaType getSchemaTypeFromRequestLabel(final String requestLabel) {
        
        String classToLookFor = requestLabel.replaceFirst("business", "xml").concat("Document");
        logger.debug("getSchemaTypeFromRequestLabel() Searching for " + classToLookFor);

        return schemaTypeLoader.typeForClassname(classToLookFor);
    }
    
    private static String extractTranslation(final SchemaAnnotation schemaAnnotation,
            final String lang) {

        if (schemaAnnotation == null)
            return null;

        XmlObject[] xmlObjects = schemaAnnotation.getUserInformation();
        for (int j = 0; j < xmlObjects.length; j++) {
            boolean foundLang = false;
            boolean foundSource = false;
            XmlCursor xc = xmlObjects[j].newCursor();
            try {

                xc.push();

                if (xc.toFirstAttribute()) {
                    // look for attributes
                    do {
                        if (xc.getName().getLocalPart().equals("lang")
                                && xc.getTextValue().equals(lang)) {
                            foundLang = true;
                        }
                        if (xc.getName().getLocalPart().equals("source")
                                && xc.getTextValue().equals(
                                        "http://www.cg95.fr/cvq/schema/shortdesc")) {
                            foundSource = true;
                        }

                        if (foundLang && foundSource) {
                            xc.pop();
                            return normalize(xc.getTextValue());
                        }

                    } while (xc.toNextAttribute());
                }

            } finally {
                xc.dispose();
            }
        }

        return null;
    }

    private static String normalize(final String inputString) {
        String output = inputString.trim();
        output = output.replaceAll("\n\t", "");
        return output;
    }
}
