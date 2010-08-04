package fr.cg95.cvq.generator.plugins.enumeration;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import fr.cg95.cvq.generator.ApplicationDocumentation;
import fr.cg95.cvq.generator.ElementProperties;
import fr.cg95.cvq.generator.IPluginGenerator;
import fr.cg95.cvq.generator.UserDocumentation;
import fr.cg95.cvq.generator.tool.XmlValidator;
import fr.cg95.cvq.schema.referential.LocalReferentialDocument;
import fr.cg95.cvq.schema.referential.LocalReferentialDocument.LocalReferential;

/**
 * The enumeration plugin is interested in global (ie statically defined enumerations strings)
 * and local (ie up to the collectivity's choice) referential data.
 *
 * It generateds the following XML files :
 * <li>
 *   <ul>An XML global referential file</ul>
 *   <ul>An XML local referential file for each request defining a new one</ul>
 *   <ul>An XML local referential file for common referential data types</ul>
 * </li>
 *
 * @author bor@zenexity.fr
 * @see Generator/src/xml/schemas/referential/ReferentialData.xsd
 */
public class EnumerationPlugin implements IPluginGenerator {

    private static Logger logger = Logger.getLogger(EnumerationPlugin.class);

    private static String LOCAL_REFERENTIAL_TYPE = "LocalReferentialDataType";

    private static String XML_HEADER_DECLARATION = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n";

    /**
     * The directory in which the XML local referential skeleton file is to be generated.
     */
    private String localReferentialDir;

    /**
     * The current request name.
     */
    private String currentRequestName;

    /**
     * The current request's namespace.
     */
    private String currentRequestNamespace;

    /**
     * The name of the current element (is used as the enumeration type if it is an anonymous one).
     */
    private String currentElementName;

    /**
     * To know when we have to parse user documentation to retrieve a local referential element's
     * information.
     */
    private boolean waitingForLocalReferential;

    private LocalReferentialDocument requestLrdDoc;
    
    private LocalReferential.Data currentLocalReferentialData;
    
    public void initialize(Node configurationNode) {
        logger.debug("initialize()");

        NodeList nodeList = configurationNode.getChildNodes();
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node childNode = nodeList.item(i);
            if (childNode.getNodeName().equals("output")) {
                NamedNodeMap childAttributesMap = childNode.getAttributes();
                Node valueAttribute = childAttributesMap.getNamedItem("localdir");
                logger.debug("initialize() local referential dir : " + valueAttribute.getNodeValue());
                localReferentialDir = valueAttribute.getNodeValue();
            }
        }
    }

    public void shutdown() {
        logger.debug("shutdown()");
    }

    public void startRequest(String requestName, String targetNamespace) {
        logger.debug("startRequest() Name : " + requestName);
        logger.debug("startRequest() Target namespace : " + targetNamespace);
        currentRequestName = requestName;
        currentRequestNamespace = targetNamespace;
    }

    public void endRequest(String requestName) {
        logger.debug("endRequest() Name : " + requestName);
        generateLocalReferential();
        requestLrdDoc = null;
    }

    public void startElement(String elementName, String type) {
        currentElementName = elementName;
        logger.debug("startElement() Type : " + type);

        if (type.indexOf(LOCAL_REFERENTIAL_TYPE) != -1) {
            // local referential : LocalReferentialDataType
            logger.debug("startElement() got a local referential : " + currentElementName);
            waitingForLocalReferential = true;
        }
    }

    public void endElement(String elementName) {
        currentElementName = null;
        waitingForLocalReferential = false;
        currentLocalReferentialData = null;
    }

    public void startElementProperties(ElementProperties elementProperties) {

        // local referential
        if (waitingForLocalReferential) {
            // not inherited so that's a request local referential type
            LocalReferential localReferential = null;
            if (requestLrdDoc == null) {
                requestLrdDoc = LocalReferentialDocument.Factory.newInstance();
                localReferential = requestLrdDoc.addNewLocalReferential();
                localReferential.setRequest(currentRequestName);
            } else {
                localReferential = requestLrdDoc.getLocalReferential();
            }
            localReferential.addNewData();
            localReferential.setDataArray(localReferential.sizeOfDataArray() - 1, 
                    currentLocalReferentialData);
        }
    }

    public void endElementProperties() {
    }

    public void onUserInformation(UserDocumentation userDocumentation) {

        if (waitingForLocalReferential
            && userDocumentation.getSourceUri().equalsIgnoreCase(SHORT_DESC)) {
            if (currentLocalReferentialData == null)
                currentLocalReferentialData = LocalReferential.Data.Factory.newInstance();
            currentLocalReferentialData.setName(currentElementName);
            LocalReferential.Data.Label label = currentLocalReferentialData.addNewLabel();
            label.setLang(userDocumentation.getLang());
            label.setStringValue(userDocumentation.getText());
        }
    }

    public void onApplicationInformation(ApplicationDocumentation applicationDocumentation) {
    }

    /**
     * Create and save the XML file containing all local referential data declared in a given
     * request.
     */
    private void generateLocalReferential() {

        logger.debug("generateLocalReferential()");

        if (requestLrdDoc == null) {
            logger.debug("generateLocalReferential() nothing to generate, returning");
            return;
        }

        if (!XmlValidator.validate(requestLrdDoc)) {
            logger.error("generateLocalReferential() local referential file is not valid, cancelling generation ...");
            return;
        }

        String currentNamespaceAlias =
            currentRequestNamespace.substring(currentRequestNamespace.lastIndexOf('/') + 1);
        StringBuffer outputFile = new StringBuffer().append(localReferentialDir).append("/")
            .append("local_referential_").append(currentNamespaceAlias).append(".xml");

        writeXmlFile(outputFile.toString(), requestLrdDoc);
    }

    
    private final void writeXmlFile(final String filename, final XmlObject xmlObject) {

        XmlOptions opts = new XmlOptions();
        opts.setSavePrettyPrint();
        opts.setSavePrettyPrintIndent(4);
        opts.setUseDefaultNamespace();
        opts.setCharacterEncoding("UTF-8");
        String dataToWrite = xmlObject.xmlText(opts);

        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(filename);
            fos.write(XML_HEADER_DECLARATION.getBytes());
            fos.write(dataToWrite.getBytes());
        } catch (FileNotFoundException fnfe) {
            logger.error("writeXmlFile() unable to create file : " + filename.toString());
        } catch (IOException ioe) {
            logger.error("writeXmlFile() error writing XML file " + ioe.getMessage());
        }
    }
}

