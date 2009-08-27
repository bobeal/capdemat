package fr.cg95.cvq.generator;

import org.w3c.dom.Node;

/**
 * The interface that must be implemented by every plugin that
 * wants to be called from the code generator.
 *
 * An XML schema parsing can be represented as the given flow :
 * <ul>
 *   <li>startRequest
 *     <ul>
 *       <li>onUserInformation (information about the request itself)
 *       <li>onApplicationInformation (idem)
 *       <li>onSampleXml
 *       <li>startElement
 *         <ul>
 *           <li>onUserInformation (information associated to element declaration in current request)
 *           <li>onApplicationInformation (idem)
 *           <li>startElementProperties
 *             <ul>
 *               <li>onUserInformation (information associated to element type definition - whether locally or in referential namespace)
 *               <li>onApplicationInformation (idem)
 *             </ul>
 *           <li>endElementProperties
 *           <li>while element is of complex type and contains elements of type Sequence or Element or Choice
 *             <ul>
 *               <li>startElement (play loop from startElement above)</li>
 *               <li>...</li>
 *               <li>endElement</li>
 *             </ul>
 *         </ul>
 *       <li>endElement</li>
 *     </ul>
 *   <li>endRequest
 * </ul>
 *
 * @author bor@zenexity.fr
 */
public interface IPluginGenerator {

    String APPINFO_NODE = "appinfo";
    String DOCUMENTATION_NODE = "documentation";
    String CONFIGURATION_NODE = "configuration";

    String SHORT_DESC = "http://www.cg95.fr/cvq/schema/shortdesc";
    String LONG_DESC = "http://www.cg95.fr/cvq/schema/longdesc";
    String ENUM_TRANS = "http://www.cg95.fr/cvq/schema/translation/enum";

    // FIXME : make this dynamic
    String XMLBEANS_BASE_TARGET_NS = "fr.cg95.cvq.xml";
    String XMLBEANS_REFERENTIAL_NS = "common";
    String MODEL_BASE_TARGET_NS = "fr.cg95.cvq.business";

    /**
     * Sort of "startup" method that is called when plugin-specific intialization
     * data is found in XML config file (currently corresponds to a configuration
     * node name.
     */
    void initialize(Node configurationNode);

    /**
     * Sort of "shutdown" method to tell plugins that all found requests have been parsed.
     */
    void shutdown();

    void startRequest(String requestName, String targetNamespace);
    void endRequest(String requestName);

    /**
     * Event received when a new element declaration is encountered.
     *
     * @param elementName XML Schema element's name
     * @param type type name of the element as returned by XML Beans
     *
     * @see http://xmlbeans.apache.org/docs/2.0.0/guide/conIntroToTheSchemaTypeSystem.html
     */
    void startElement(String elementName, String type);
    void endElement(String elementName);

    void startElementProperties(ElementProperties elementProperties);
    void endElementProperties();

    void onUserInformation(UserDocumentation userDocumentation);
    void onApplicationInformation(ApplicationDocumentation applicationDocumentationList);
}
