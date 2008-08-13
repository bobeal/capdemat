package fr.cg95.cvq.generator.plugins.xslfo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;
import java.util.TreeMap;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import fr.cg95.cvq.generator.ApplicationDocumentation;
import fr.cg95.cvq.generator.ElementProperties;
import fr.cg95.cvq.generator.IPluginGenerator;
import fr.cg95.cvq.generator.UserDocumentation;
import fr.cg95.cvq.generator.plugins.tool.VelocityManager;

/**
 * The xslfo plugin is responsible for the generation of XSL-FO stylesheets.
 *
 * @author bor@zenexity.fr
 * @author rdj@zenexity.fr
 */
public class XslFoPlugin implements IPluginGenerator {

    private static Logger logger =
        Logger.getLogger(XslFoPlugin.class);

    /**
     * Current depth inside the request
     */
    private int depth = 0;

    /**
     * The directory in which the XSL-FO files are to be generated
     */
    private String outputDir;

    /**
     * The container for the XSL-FO blocks of the current request
     */
    private XslFoObject xslFoObject;

    /**
     * Map of xslfo elements for the current schema element
     */
    private Stack<StackElementXslFo> currentElementBlockLines;

    /**
     * Map of xslfo elements whose definition resides within parent type.
     * Those elements are dealt with as we encounter them
     */
    private List<StackElementXslFo> uncompleteElementBlockLines;
    
    /**
     * Stack of current processed element and its direct descendants
     */
    private Stack<StackElementProperties> currentElementsStack;
    
    public void initialize(Node configurationNode) {
        logger.debug("initialize()");

        NodeList nodeList = configurationNode.getChildNodes();
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node childNode = nodeList.item(i);
            if (childNode.getNodeName().equals("output")) {
                NamedNodeMap childAttributesMap = childNode.getAttributes();
                Node valueAttribute = childAttributesMap.getNamedItem("dir");
                logger.debug("initialize() output dir : " + valueAttribute.getNodeValue());
                outputDir = valueAttribute.getNodeValue();
            }
        }
        currentElementBlockLines = new Stack<StackElementXslFo>();
        uncompleteElementBlockLines = new ArrayList<StackElementXslFo>();
        currentElementsStack = new Stack<StackElementProperties>();
    }

    public void shutdown() {
        logger.debug("shutdown()");
    }

    public void startRequest(String requestName, String targetNamespace) {
        logger.debug("startRequest() Name : " + requestName);
        xslFoObject = new XslFoObject(requestName, targetNamespace);
    }

    public void endRequest(String requestName) {
        logger.debug("endRequest() Name : " + requestName);
        HashMap contextsObjects = new HashMap();
        contextsObjects.put("request", xslFoObject);
        VelocityManager.launchGeneration("Generator/src/java/fr/cg95/cvq/generator/plugins/xslfo/XslFoPlugin.vm", 
                StringUtils.uncapitalize(requestName) + ".xsl", outputDir, null, contextsObjects);
    }

    public void startElement(String elementName, String type) {
        depth++;
        logger.debug("startElement() Name : " + elementName + " of type " + type);
        
        StackElementProperties topStackElement;
        if (depth == 1)
            topStackElement = new StackElementProperties(elementName, type, depth , false);
        else
            topStackElement = new StackElementProperties(elementName, type, depth , 
                    currentElementsStack.peek().isInsideLocalComplexType());
        
        currentElementsStack.push(topStackElement);
    }

    public void endElement(String elementName) {
        StackElementProperties topStackElement = currentElementsStack.peek();
        
        if (!currentElementBlockLines.isEmpty()) {
            Element element = currentElementBlockLines.peek().getElement();
            
            if (element.getPrefixLabel() == null && element.getUsePrefixLabel()) {
                if (element.getUseLongDesc())
                    element.setPrefixLabel(topStackElement.getLongDesc());
                else
                    element.setPrefixLabel(topStackElement.getShortDesc());
            }
            if (depth == 2) {
                if (element instanceof ComplexTemplateElement) {
                    ComplexTemplateElement complexElement = (ComplexTemplateElement) element;
                    if (complexElement.getSelectElementName() != null
                        && complexElement.getSelectElementName().equals(elementName)) {
                        complexElement.setElementName(elementName);
                        complexElement.setElementType(elementName + "Type");
                        complexElement.setParentElementName(currentElementsStack.get(currentElementsStack.size() - 2).getName());
                    }
                }
            } else if (depth == 1) {
                while ( ! currentElementBlockLines.isEmpty()) {
                    element = currentElementBlockLines.peek().getElement();
                    String blockId = (String) currentElementBlockLines.peek().getBlockId();
                    xslFoObject.addLineToBlock(new Integer(blockId), element);
                    currentElementBlockLines.pop();
                }
            }
        }

        currentElementsStack.pop();
        depth--;
        logger.debug("endElement() Name : " + elementName);
    }

    public void startElementProperties(ElementProperties elementProperties) {
        StackElementProperties topStackElement = currentElementsStack.peek();
        
        if (depth == 1 && elementProperties.isRequestType() && elementProperties.isComplexType())
            currentElementsStack.peek().setInsideLocalComplexType(true);
       
        if (!currentElementBlockLines.isEmpty()) {
            Element element = currentElementBlockLines.peek().getElement();
            
            // to know when we have to display an "information required" flag in the form
            if (elementProperties.getMinOccurs().intValue() == 1 && depth == 1) {
                if ( element.getSelectXPath() == null)
                    element.setRequiredSymbol(true);
            }
        
            // to know when we have to call a for-each instruction
            // (XMLBeans returns null if it is unbounded)
            if (elementProperties.getMaxOccurs() == null 
                    || (elementProperties.getMaxOccurs() != null 
                            && elementProperties.getMaxOccurs().intValue() > 1)) {
                
                if (depth == 1 && element.getSelectXPath() == null)
                    element.setManyValues(true);
                if (depth > 1 && element.getSelectXPath() != null
                    && element.getSelectElementName().equals(topStackElement.getName()))
                    element.setManyValues(true);
            }
            
            // process namespaces aliases used in XPath expressions
            if (depth == 1 && !elementProperties.isInherited()) {
                // element defined in request itself
                element.setNamespaceAlias(xslFoObject.getNamespaceAlias());
                topStackElement.setNamespaceAlias(xslFoObject.getNamespaceAlias());
            } else if (depth > 1 && !elementProperties.isInherited() && topStackElement.isInsideLocalComplexType() ) {
                // element defined in request's complex element
                element.setNamespaceAlias(xslFoObject.getNamespaceAlias());
                topStackElement.setNamespaceAlias(xslFoObject.getNamespaceAlias());
            } else if (element.getNamespaceAlias() == null) {
                // else fallbacks to CVQ referential namespace
                // FIXME : don't remember why we had to check for namespacealias != null
                element.setNamespaceAlias("cvq");
                topStackElement.setNamespaceAlias("cvq");
            }
            
            // To complete the definition of last addes element to the current LocalComplexElement list
            if (element instanceof LocalComplexElement) {
                LocalComplexElement localComplexElement = (LocalComplexElement)element;
                if(localComplexElement.getElementList() != null)
                    element = localComplexElement.getChildElement(localComplexElement.getElementList().size() - 1);
            }
            
            // retrieve the XML schema type of the complex element referenced by this element
            // it is then used to call an XSL template of the same name
            // FIXME : the non-null check of templateName has been added because of the
            //         child/legal responsible relation that contain two <LegalResponsible>
            //         nodes (so we take the first encountered)
            if (element instanceof ComplexTemplateElement) {
                ComplexTemplateElement cte = (ComplexTemplateElement) element;
                if (depth == 1 && cte.getSelectXPath() == null) {
                    cte.setTemplateName(elementProperties.getXmlSchemaType());
                } else if (depth > 1 && cte.getSelectXPath() != null
                           && cte.getSelectElementName().equals(topStackElement.getName())
                           && cte.getTemplateName() == null) {
                    cte.setTemplateName(elementProperties.getXmlSchemaType());
                } else if (depth > 1 && cte.getTemplateName() == null) {
                    // element defined in depth > 2
                    cte.setTemplateName(elementProperties.getXmlSchemaType());
                }
            }
            
            if (depth == 2 && (element instanceof VarargCheckboxElementWithPrecision)) {
                VarargCheckboxElementWithPrecision vcewp =
                    (VarargCheckboxElementWithPrecision) element;
                if (elementProperties.getEnumValues() != null) {
                    if (elementProperties.getXmlSchemaType() == null) {
                        // an anonymously defined enumeration type
                        // use element name instead
                        vcewp.setEnumElementType(topStackElement.getName());
                    } else {
                        vcewp.setEnumElementType(elementProperties.getXmlSchemaType());
                    }
                    vcewp.setEnumElementName(topStackElement.getName());
                } else {
                    vcewp.setPrecisionElementName(topStackElement.getName());
                }
            }
        }
        
        Iterator<StackElementXslFo> iterator = uncompleteElementBlockLines.iterator();
        while(iterator.hasNext()) {
            StackElementXslFo elementXslFo = iterator.next();
            Element element = elementXslFo.getElement();
            String key = elementXslFo.getBlockId();
            String link = key.substring(0, key.indexOf('@'));
            if (link.equals(topStackElement.getName())) {
                // we found linked element, set some information and add it to current
                // element block lines
                element.setElementName(topStackElement.getName());
                element.setElementType(topStackElement.getType());
                element.setElementTypeNamespace(topStackElement.getTypeNamespace());
                element.setNamespaceAlias("cvq");
                String blockId = key.substring(key.indexOf('@') + 1);
                if (element instanceof ComplexTemplateElement) {
                    ComplexTemplateElement cte = (ComplexTemplateElement) element;
                    cte.setTemplateName(elementProperties.getXmlSchemaType());
                }
                currentElementBlockLines.push(new StackElementXslFo(element, blockId));
                iterator.remove();
            } 
        }
    }

    public void endElementProperties() {
    }

    public void onUserInformation(UserDocumentation userDocumentation) {
        String lang = userDocumentation.getLang();
        String text = userDocumentation.getText();
        if (currentElementsStack.isEmpty()) {
            // at the request level
            xslFoObject.addFriendlyName(text, lang);
        } else {
            StackElementProperties topStackElement = currentElementsStack.peek();
            // take the most specific description we have
            // ie the first encountered while parsing the schema
            if (userDocumentation.getSourceUri().equals(IPluginGenerator.SHORT_DESC) 
                    && topStackElement.getShortDesc() == null)
                topStackElement.setShortDesc(text);    
            else if (userDocumentation.getSourceUri().equals(IPluginGenerator.LONG_DESC)
                    && topStackElement.getLongDesc() == null)
                topStackElement.setLongDesc(text);
        }
    }

    public void onApplicationInformation(ApplicationDocumentation applicationDocumentation) {
        // at the request level
        if (depth == 0) {
            if (!applicationDocumentation.hasChildNode("blocks-def")) {
                logger.error("onApplicationInformation() No blocks definition for request !");
                return;
            }
            // look for blocks definitions
            Node[] blocksNodesTab = applicationDocumentation.getChildrenNodes("blocks-def");
            Node blocksNode = blocksNodesTab[0];
            NodeList blockDefList = blocksNode.getChildNodes();
            for (int i = 0; i < blockDefList.getLength(); i++) {
                Node blockDefNode = blockDefList.item(i);
                if ("block".equals(blockDefNode.getNodeName())) {
                    String blockId =
                        ApplicationDocumentation.getNodeAttributeValue(blockDefNode, "id");
                    String blockLabel =
                        ApplicationDocumentation.getNodeAttributeValue(blockDefNode, "label");
                    String blockColumnNb =
                        ApplicationDocumentation.getNodeAttributeValue(blockDefNode, "column");
                    String displayCondition =
                        ApplicationDocumentation.getNodeAttributeValue(blockDefNode, "displayCondition");
                    String breakAfter =
                        ApplicationDocumentation.getNodeAttributeValue(blockDefNode, "breakAfter");

                    BlockDef blockDef = new BlockDef(new Integer(blockId),
                                                     blockLabel, blockColumnNb,
                                                     displayCondition, breakAfter);
                    xslFoObject.addBlockDef(blockDef);
                }
            }
        }
        if (applicationDocumentation.hasChildNode("element")) {
            Node[] blockTab = applicationDocumentation.getChildrenNodes("element");
            for (int i=0; i < blockTab.length; i++) {
                Node block = blockTab[i];
                processBlockNode(block);
            }
        }
    }
    
    /**
     * Insert element in Local Complex Element if it belong to that
     */
    private boolean fillLocalComplexElement(final Element element, final String blockId) {
        if (currentElementsStack.isEmpty())
            return false;
        
        StackElementProperties topStackElement = currentElementsStack.peek();
        // Add subElement to current localComplexElement
        if (topStackElement.isInsideLocalComplexType() && depth == 2) {   
            if (currentElementBlockLines.peek().getElement() instanceof LocalComplexElement) {
                LocalComplexElement localComplexElement = (LocalComplexElement)currentElementBlockLines.peek().getElement();
                if (currentElementBlockLines.peek().getBlockId().equals(blockId)){
                    // Set element properies used to format Xpath expression
                    element.setParentElementName(currentElementsStack.get(currentElementsStack.size() - 2).getName());
                    element.setNamespaceAlias(xslFoObject.getNamespaceAlias());
                    return(localComplexElement.addElement(element));
                }
            }
        }
        return false ;
    }
    
    private void foldElement(final Element element, final String link, final String blockId) {
        if (!fillLocalComplexElement(element, blockId)) {
            if (link == null)
                currentElementBlockLines.push(new StackElementXslFo(element, blockId));
            else
                uncompleteElementBlockLines.add(new StackElementXslFo(element, link + "@" + blockId));
        }
    }

    /**
     * Extract information from a {@link Node} object and builds a {@link Element} from it.
     */
    private void processBlockNode(final Node blockNode) {
        String link = ApplicationDocumentation.getNodeAttributeValue(blockNode, "link");
        String blockId = ApplicationDocumentation.getNodeAttributeValue(blockNode, "blockId");

        Element element = new Element();
        element.setLineId(new Integer(ApplicationDocumentation.getNodeAttributeValue(blockNode, "line")));
        element.setColumnId(new Integer(ApplicationDocumentation.getNodeAttributeValue(blockNode, "column")));
        String columnSpan = ApplicationDocumentation.getNodeAttributeValue(blockNode, "columnSpan");
        if (columnSpan != null)
            element.setColumnSpan(new Integer(columnSpan));

        element.setPrefixLabel(ApplicationDocumentation.getNodeAttributeValue(blockNode, "prefixLabel"));
        element.setUsePrefixLabel(ApplicationDocumentation.getNodeAttributeValue(blockNode, "usePrefixLabel"));
        element.setUseLongDesc(ApplicationDocumentation.getNodeAttributeValue(blockNode, "useLongDesc"));
        element.setFootNotice(ApplicationDocumentation.getNodeAttributeValue(blockNode, "footNotice"));
        element.setDisplayCondition(ApplicationDocumentation.getNodeAttributeValue(blockNode, "displayCondition"));
        
        if ( !currentElementsStack.isEmpty()) {
            StackElementProperties topStackElement = currentElementsStack.peek();
            
            element.setElementName(topStackElement.getName());
            element.setElementType(topStackElement.getType());
            element.setElementTypeNamespace(topStackElement.getTypeNamespace());
            
            if (element.getPrefixLabel() == null && element.getUsePrefixLabel()) {
                if (element.getUseLongDesc())
                    element.setPrefixLabel(topStackElement.getLongDesc());
                else
                    element.setPrefixLabel(topStackElement.getShortDesc());
            }
        }
        
        NodeList childrenList = blockNode.getChildNodes();
        for (int j=0; j < childrenList.getLength(); j++) {
            Node child = childrenList.item(j);
            element.setSelectXPath(ApplicationDocumentation.getNodeAttributeValue(child, "selectXPath"));
            if (child.getNodeName().equals("varargCheckbox")) {
                VarargCheckboxElement varargCheckboxElement = new VarargCheckboxElement(element);

                varargCheckboxElement.setDisplayModulo(ApplicationDocumentation.getNodeAttributeValue(child, "displayModulo"));
                foldElement(varargCheckboxElement, link, blockId);
            } else if (child.getNodeName().equals("varargCheckboxWithPrecision")) {
                VarargCheckboxElementWithPrecision varargCheckboxElementWithPrecision
                    = new VarargCheckboxElementWithPrecision(element);

                varargCheckboxElementWithPrecision.setDisplayModulo(ApplicationDocumentation.getNodeAttributeValue(child, "displayModulo"));
                Node[] precisions = ApplicationDocumentation.getChildrenNodes(child,"precision");
                for (int i = 0; i < precisions.length; i++) {
                    Node node = precisions[i];
                    String displayCondition =
                        ApplicationDocumentation.getNodeAttributeValue(node, "displayCondition");
                    String prefixLabel =
                        ApplicationDocumentation.getNodeAttributeValue(node, "prefixLabel");
                    varargCheckboxElementWithPrecision.addPrecision(displayCondition, prefixLabel);
                }
                foldElement(varargCheckboxElementWithPrecision, link, blockId);
            } else if (child.getNodeName().equals("yesnoCheckbox")) {
                YesNoCheckboxElement yesnoElement = new YesNoCheckboxElement(element);
                foldElement(yesnoElement, link, blockId);
            } else if (child.getNodeName().equals("signature")) {
                SignatureElement signatureElement = new SignatureElement(element);

                Node[] acceptMsgNodes = ApplicationDocumentation.getChildrenNodes(child, "acceptMessage");
                TreeMap acceptMsg = null;
                if (acceptMsgNodes != null) {
                    acceptMsg = new TreeMap();
                    for (int i = 0; i < acceptMsgNodes.length; i++) {
                        Node msgNode = acceptMsgNodes[i];
                        Integer index =
                            new Integer(ApplicationDocumentation.getNodeAttributeValue(msgNode, "index"));
                        String msgValue = msgNode.getChildNodes().item(0).getNodeValue();
                        acceptMsg.put(index, msgValue);
                    }
                }
                signatureElement.setAcceptMessages(acceptMsg);

                Node[] rejectMsgNodes = ApplicationDocumentation.getChildrenNodes(child, "rejectMessage");
                TreeMap rejectMsg = null;
                if (rejectMsgNodes != null) {
                    rejectMsg = new TreeMap();
                    for (int i = 0; i < rejectMsgNodes.length; i++) {
                        Node msgNode = rejectMsgNodes[i];
                        Integer index =
                            new Integer(ApplicationDocumentation.getNodeAttributeValue(msgNode, "index"));
                        String msgValue = msgNode.getChildNodes().item(0).getNodeValue();
                        rejectMsg.put(index, msgValue);
                    }
                }
                signatureElement.setRejectMessages(rejectMsg);
                foldElement(signatureElement, link, blockId);
            } else if (child.getNodeName().equals("string")) {
                StringElement stringElement = new StringElement(element);
                stringElement.setSelectXPath(ApplicationDocumentation.getNodeAttributeValue(child, "selectXPath"));
                stringElement.setReferential(ApplicationDocumentation.getNodeAttributeValue(child, "referential"));
                stringElement.setRestrictToChar(ApplicationDocumentation.getNodeAttributeValue(child, "restrictToChar"));
                stringElement.setValueWeight(ApplicationDocumentation.getNodeAttributeValue(child, "valueWeight"));
                foldElement(stringElement, link, blockId);
            } else if (child.getNodeName().equals("complexTemplate")) {
                ComplexTemplateElement complexElement = new ComplexTemplateElement(element);
                complexElement.setSelectXPath(ApplicationDocumentation.getNodeAttributeValue(child, "selectXPath"));
                foldElement(complexElement, link, blockId);
            } else if (child.getNodeName().equals("localReferential")) {
                LocalReferentialElement localReferentialElement =
                    new LocalReferentialElement(element);
                foldElement(localReferentialElement, link, blockId);
            } else if (child.getNodeName().equals("placeReservation")) {
                PlaceReservationElement placeReservationElement =
                    new PlaceReservationElement(element);
                foldElement(placeReservationElement, link, blockId);
            } else if (child.getNodeName().equals("simpleTemplate")) {
                SimpleTemplateElement simpleElement = new SimpleTemplateElement(element);

                simpleElement.setTemplateName(ApplicationDocumentation.getNodeAttributeValue(child, "templateName"));
                simpleElement.setTemplateParam(ApplicationDocumentation.getNodeAttributeValue(child, "templateParam"));
                simpleElement.setValueWeight(ApplicationDocumentation.getNodeAttributeValue(child, "valueWeight"));
                foldElement(simpleElement, link, blockId);
            }
            else if (child.getNodeName().equals("localComplexElement")){
                LocalComplexElement localComplexElement = new LocalComplexElement(element);
                localComplexElement.setWithTotal(new Boolean( ApplicationDocumentation.getNodeAttributeValue(child, "withTotal")));
                foldElement(localComplexElement, link, blockId);
            }
        }
    }
    
    private class StackElementXslFo {
        
        private Element element;
        private String blockId;
        
        public StackElementXslFo(Element element, String blockId) {
            this.setElement(element);
            this.setBlockId(blockId);
        }
        
        public String getBlockId() {
            return blockId;
        }
        public void setBlockId(String blockId) {
            this.blockId = blockId;
        }
        public Element getElement() {
            return element;
        }
        public void setElement(Element element) {
            this.element = element;
        }
    }

    private class StackElementProperties {
        
        private String name;
        private String type;
        private String typeNamespace;
        private String shortDesc;
        private String longDesc;
        private String namespaceAlias;
        
        private boolean insideLocalComplexType;
        
        private int depth;
        
        public StackElementProperties(String name, String type, int depth, boolean insideLocalComplexType) {
            this.setDepth(depth);
            this.setName(name);
            this.setType(type.substring(type.indexOf('=') + 1, type.indexOf('@')));
            this.setTypeNamespace(type.substring(type.indexOf('@') + 1));
            this.setInsideLocalComplexType(insideLocalComplexType);
        }
        
        public String getLongDesc() {
            return longDesc;
        }
        public void setLongDesc(String longDesc) {
            this.longDesc = longDesc;
        }
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        public String getNamespaceAlias() {
            return namespaceAlias;
        }
        public void setNamespaceAlias(String namespaceAlias) {
            this.namespaceAlias = namespaceAlias;
        }
        public String getShortDesc() {
            return shortDesc;
        }
        public void setShortDesc(String shortDesc) {
            this.shortDesc = shortDesc;
        }
        public String getType() {
            return type;
        }
        public void setType(String type) {
            this.type = type;
        }
        public String getTypeNamespace() {
            return typeNamespace;
        }
        public void setTypeNamespace(String typeNamespace) {
            this.typeNamespace = typeNamespace;
        }
        
        public int getDepth() {
            return depth;
        }
        public void setDepth(int depth) {
            this.depth = depth;
        }

        public boolean isInsideLocalComplexType() {
            return insideLocalComplexType;
        }

        public void setInsideLocalComplexType(boolean insideLocalComplexType) {
            this.insideLocalComplexType = insideLocalComplexType;
        }
    }
}
