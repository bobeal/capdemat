package fr.cg95.cvq.generator.plugins.fo;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Stack;

import org.apache.log4j.Logger;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import fr.cg95.cvq.generator.ApplicationDocumentation;
import fr.cg95.cvq.generator.ElementProperties;
import fr.cg95.cvq.generator.IPluginGenerator;
import fr.cg95.cvq.generator.UserDocumentation;
import fr.cg95.cvq.generator.common.Condition;
import fr.cg95.cvq.generator.common.Step;

/**
 * The fo plugin is responsible for the generation of FrontOffice interfaces.
 *
 * @author maxence.veyret@bull.net
 */
public class FoPlugin implements IPluginGenerator {
	
    public final static String MODEL_REQUEST_NS = "fr.cg95.cvq.business.request";
    public final static String MODEL_USERS_NS = "fr.cg95.cvq.business.users";
    
	private static final String CONF_OUTPUT_TAG = "output";
	private static final String CONF_DIR_ATTRIBUTE = "dir";
	private static final String FO_TAG = "fo";
	private static final String LABEL_TAG = "label";
	private static final String RADIO_TAG = "radio";
	private static final String SELECT_TAG = "select";
	private static final String TEXTAREA_TAG = "textarea";
	private static final String ONETOMANY_TAG = "oneToMany";
	private static final String ROWS_ATTRIBUTE = "rows";
	//private static final String AFTER_ATTRIBUTE = "after";
	
	private String outputDir = null;
	
    /**
     * Current depth inside the request
     */
    private int depth = 0;
    
    /**
     * Map of simple fo elements for the current schema element
     */
    private Stack<StackElementFo> currentSimpleFoElementsStack;
    
    /**
     * Map of complex fo elements for the current schema element
     */
    private Stack<StackComplexFoElement> currentComplexFoElementsStack;
    
    /**
     * Stack of current processed element and its direct descendants
     */
    private Stack<StackElementProperties> currentElementsStack;
    
    /**
     * Stack of current processed element and its direct descendants
     */
    private Stack<StackComplexElementProperties> currentComplexElementsStack;
	
	private FoObject foObject;
	
	private static Logger logger = Logger.getLogger(FoPlugin.class);

	public FoPlugin() {
		super();
	}

	public void initialize(Node configurationNode) {
		logger.debug("initialize()");
		NodeList nodeList = configurationNode.getChildNodes();
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node childNode = nodeList.item(i);
            if (childNode.getNodeName().equals(CONF_OUTPUT_TAG)) {
                NamedNodeMap childAttributesMap = childNode.getAttributes();
                Node valueAttribute = childAttributesMap.getNamedItem(CONF_DIR_ATTRIBUTE);
                logger.debug("initialize() " + CONF_OUTPUT_TAG + " : " + valueAttribute.getNodeValue());
                outputDir = valueAttribute.getNodeValue();
            }
        }
        currentElementsStack = new Stack<StackElementProperties>();
        currentComplexElementsStack = new Stack<StackComplexElementProperties>();
        currentSimpleFoElementsStack = new Stack<StackElementFo>();
        currentComplexFoElementsStack = new Stack<StackComplexFoElement>();
	}


	public void shutdown() {
		logger.debug("shutdown()");
	}

	public void startRequest(String requestName, String xsdNamespace) {
		logger.debug("startRequest() - " + requestName);
		foObject = new FoObject(requestName, xsdNamespace);
	}

	public void endRequest(String requestName) {
	    logger.debug("endRequest() - " + requestName);
        FoRenderer foRenderer = new FoRenderer(foObject, outputDir);
        foRenderer.render();
        logger.warn("endRequest() GENERATION SUCCESS FOR - " + requestName);
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
        logger.debug("endElement()");
        if (currentElementsStack.peek().isFoElementComplete()) {
            if (!currentSimpleFoElementsStack.isEmpty()) {
                StackElementFo currentElement = currentSimpleFoElementsStack.peek();
                if (currentElement != null) {
                    if (currentComplexFoElementsStack.isEmpty()) {
                        foObject.addElementToStep(currentElement.getStepName(), currentElement
                                .getElement());
                    } else {
                        currentComplexFoElementsStack.peek().getElement().addElement(
                                currentElement.getElement());
                    }
                }
                currentSimpleFoElementsStack.pop();
            } else {
                if (!currentComplexFoElementsStack.isEmpty()) {
                    StackComplexFoElement currentElement = currentComplexFoElementsStack.pop();
                    if (currentElement != null) {
                        if (currentComplexFoElementsStack.isEmpty()) {
                            foObject.addElementToStep(currentElement.getStepName(), currentElement
                                    .getElement());
                        } else {
                            currentComplexFoElementsStack.peek().getElement().addElement(currentElement.getElement());
                        }
                    }
                }
            }
        }
        if (!currentElementsStack.isEmpty()) {
            if (currentElementsStack.peek().isComplexType()) {
                currentComplexElementsStack.pop();
            }
        }
		currentElementsStack.pop();
        depth--;
        logger.debug("endElement() Name : " + elementName);
	}
	
    public void startElementProperties(ElementProperties elementProperties) {
        logger.debug("startElementProperties()");
        
        if (depth == 1 && elementProperties.isRequestType() && elementProperties.isComplexType())
            currentElementsStack.peek().setInsideLocalComplexType(true);

        // CHECK ElementStackNotComplete
        if (!currentElementsStack.isEmpty()) {
            if (currentElementsStack.peek().isFoElementNotComplete()) { 
                Element element = createElement(currentElementsStack.peek().getConditions());
                processDefaultElement(elementProperties, currentElementsStack.peek(), element); 
            } else if (!currentElementsStack.peek().isFoElementComplete){
                if (!currentComplexFoElementsStack.isEmpty()) {
                    if (currentComplexFoElementsStack.peek().getElement().isExternalElement()){
                        Element element = createElement(currentElementsStack.peek().getConditions());
                        //TODO not Id (=> keywords)
                        if (!currentElementsStack.peek().getName().equals("Id")){
                            processDefaultElement(elementProperties, currentElementsStack.peek(), element);
                        } 
                    }     
                }
            } else {
                // Treat Fieldset externElement (Label)
                if (!currentComplexFoElementsStack.isEmpty() && !currentElementsStack.isEmpty()) {
                    if (!currentElementsStack.peek().getTypeNamespace().equals(foObject.getXsdNamespace())
                            && elementProperties.isComplexType()) {
                        currentComplexFoElementsStack.peek().getElement().setExternalElement(true);
                        currentComplexFoElementsStack.peek().getElement().setXmlSchemaType(elementProperties.getXmlSchemaType());
                    }
                }
            }
        } 
        // VALIDATION
        if (!currentSimpleFoElementsStack.isEmpty()) {
            StackElementProperties topStackElement = currentElementsStack.peek();
            Element element = currentSimpleFoElementsStack.peek().getElement();
            if (!elementProperties.isComplexType())
                element.setValidation(Validation.getValidation(element, elementProperties
                        .getXmlSchemaType(), elementProperties.getMinOccurs().intValue()));
        }
        if (elementProperties.isComplexType()) {
            if (!currentElementsStack.isEmpty()) {
               currentComplexElementsStack.push(new StackComplexElementProperties(
                        currentElementsStack.peek().getTypeNamespace(), elementProperties
                                .getXmlSchemaType(), currentElementsStack.peek().getName()));

                currentElementsStack.peek().setComplexType(true);
            }
        }
        
        // HACK for enumeraation managment
        if(!currentSimpleFoElementsStack.isEmpty()) {
            currentSimpleFoElementsStack.peek().getElement().setEnumValues(elementProperties.getEnumValues());
            currentSimpleFoElementsStack.peek().getElement().setJavaType(elementProperties.getXmlSchemaType());
            if (elementProperties.isReferentialType())
                currentSimpleFoElementsStack.peek().getElement().setModelNamespace(MODEL_USERS_NS);
        }
    }

	public void endElementProperties() {
	    
	}
	
	public void onUserInformation(UserDocumentation userDocumentation) {
		logger.debug("onUserInformation()");   
	}

	public void onApplicationInformation(ApplicationDocumentation applicationDocumentation) {
		logger.debug("onApplicationInformation()");
		
		// at the request level
		if (depth == 0) {
		    foObject.setNamespace(applicationDocumentation.getRequestCommon().getNamespace());
		    
		    String stepName = "";
		    List<Step> steps =  applicationDocumentation.getRequestCommon().getSteps();
	        for (Step step : steps) {
	           if (step.getRef() != null) {
	               if (step.getRef().equals("validation")) {
	                   stepName = "validationRef";
	                   foObject.setNeededValidation(true);
	               }
	               if (step.getRef().equals("document")) stepName = "documentRef";   
	           }
	           else stepName = step.getName();
	           foObject.addStep(new FoStep(step.getIndex(), stepName, step.getRef()));
	        }
	        
	        Set<Condition> conditions = applicationDocumentation.getRequestCommon().getConditions();
	        if (conditions != null) {
	            Set<String> conditionsName = new HashSet<String>();
	            for (Iterator<Condition> it = conditions.iterator(); it.hasNext();) {
	                conditionsName.add(it.next().getName());
	            }
	            foObject.setConditionsNames(conditionsName);
	        }
        }
		
        if (applicationDocumentation.getNodeName().equals(FO_TAG)) {
            Set<Condition>  conditions = null;
            if (applicationDocumentation.getRequestCommon()!= null){
                if (applicationDocumentation.getRequestCommon().getCurrentElementCommon() != null) {
                    conditions = applicationDocumentation.getRequestCommon().getCurrentElementCommon().getConditions();
                }
            }
            //("after : " + ApplicationDocumentation.getNodeAttributeValue(applicationDocumentation.getXmlNode(), AFTER_ATTRIBUTE));             
          //TODO oneToMany, label if complexType 
            if (applicationDocumentation.hasChildNode(RADIO_TAG) || 
                applicationDocumentation.hasChildNode(TEXTAREA_TAG) ||
                applicationDocumentation.hasChildNode(SELECT_TAG) ||
                applicationDocumentation.hasChildNode(LABEL_TAG) || 
                applicationDocumentation.hasChildNode(ONETOMANY_TAG)) {
                processFoChildNode(applicationDocumentation, conditions);
            } else { 
                if (!currentElementsStack.isEmpty()) {
                    currentElementsStack.peek().setFoElementNotComplete(true);
                    currentElementsStack.peek().setStepName(applicationDocumentation.getRequestCommon().getCurrentElementCommon().getStep().getName());
                    if (conditions != null)
                        currentElementsStack.peek().setConditions(conditions);
                }
                
            }
        } 
	}
	
	private void processFoChildNode(ApplicationDocumentation applicationDocumentation, Set<Condition> conditions) {
		logger.debug("processFoChildNode()");
        Element element = createElement(conditions);
        element.setModelNamespace(MODEL_REQUEST_NS + "." + foObject.getNamespace());
        // Must rewrite be rewrite
        if (applicationDocumentation.hasChildNode(RADIO_TAG)) {
            Node[] widgetTab = applicationDocumentation.getChildrenNodes(RADIO_TAG);
            Node widget = widgetTab[0];
            processRadioNode(applicationDocumentation.getRequestCommon().getCurrentElementCommon()
                    .getStep().getName(), widget, element);
        } else if (applicationDocumentation.hasChildNode(SELECT_TAG)) {
            Node[] widgetTab = applicationDocumentation.getChildrenNodes(SELECT_TAG);
            Node widget = widgetTab[0];
            processSelectNode(applicationDocumentation.getRequestCommon().getCurrentElementCommon()
                    .getStep().getName(), widget, element);
        } else if (applicationDocumentation.hasChildNode(TEXTAREA_TAG)) {
            Node[] widgetTab = applicationDocumentation.getChildrenNodes(TEXTAREA_TAG);
            Node widget = widgetTab[0];
            processTextareaNode(applicationDocumentation.getRequestCommon()
                    .getCurrentElementCommon().getStep().getName(), widget, element);
        } else if (applicationDocumentation.hasChildNode(LABEL_TAG)) {
            Node[] widgetTab = applicationDocumentation.getChildrenNodes(LABEL_TAG);
            Node widget = widgetTab[0];
            processLabelNode(applicationDocumentation.getRequestCommon().getCurrentElementCommon()
                    .getStep().getName(), widget, element);
        } else if (applicationDocumentation.hasChildNode(ONETOMANY_TAG)) {
            Node[] widgetTab = applicationDocumentation.getChildrenNodes(ONETOMANY_TAG);
            Node widget = widgetTab[0];
            processOneToManyNode(applicationDocumentation.getRequestCommon()
                    .getCurrentElementCommon().getStep().getName(), widget, element);
        }
    }
	
	private Element createElement(Set<Condition> conditions) {
	    Element element = new Element();
	    if (!currentElementsStack.isEmpty()) {
	        StackElementProperties topStackElement = currentElementsStack.peek();
	        element.setName(topStackElement.getName());
	        if (depth == 1) element.setGlobalElement(true);
            else element.setGlobalElement(false);
	        if (!currentComplexElementsStack.isEmpty()) {
	            element.setParentNamespace(currentComplexElementsStack.peek().getNamespace());
	            element.setParentXmlSchemaType(currentComplexElementsStack.peek().getType());
	        }
	        if (conditions != null) {
	            StringBuffer elementCondition = new StringBuffer();
	            for (Iterator<Condition> i = conditions.iterator(); i.hasNext();) {
                    Condition condition = i.next();
                    elementCondition.append(condition.getName() + "-" + condition.getType() + " ");
                }
	            element.setCondition(elementCondition.toString());
	        }
	    }
	    return element;
	}
	
	private void processOneToManyNode(String stepName, Node textarea, Element element) { 
	     logger.debug("processOneToManyNode()");
	     OneToManyElement oneToManyElement = new OneToManyElement(element); 
	     if ( !currentElementsStack.isEmpty()) {
	         currentComplexFoElementsStack.push(new StackComplexFoElement(stepName, oneToManyElement));
	         currentElementsStack.peek().setFoElementComplete(true);
	     } 
    }
	
	private void processTextareaNode(String stepName, Node textarea, Element element) {	
		logger.debug("processTextareaNode()");
		Integer rows = 0;
		TextareaElement textareaElement = new TextareaElement(element); 
		try {
			rows = new Integer(ApplicationDocumentation.getNodeAttributeValue(textarea, ROWS_ATTRIBUTE));
		} catch (Exception e) {
			logger.error("rows is required and must be a number");
		}
		if ( !currentElementsStack.isEmpty()) {
            textareaElement.setRows(rows);
            currentSimpleFoElementsStack.push(new StackElementFo(stepName, textareaElement));
            currentElementsStack.peek().setFoElementComplete(true);
        } 
	}
	
	private void processRadioNode(String stepName, Node radio, Element element) {
		logger.debug("processRadioNode()");
		RadioElement radioElement = new RadioElement(element); 
        if ( !currentElementsStack.isEmpty()) {
            StackElementProperties topStackElement = currentElementsStack.peek();
            radioElement.setElementTypeName(topStackElement.getType());
            radioElement.setNamespace(topStackElement.getTypeNamespace());
            if (radioElement.getNamespace().contains(XMLBEANS_REFERENTIAL_NS)) {
                radioElement.setModelNamespace(MODEL_USERS_NS);
            } else {
                radioElement.setModelNamespace(MODEL_REQUEST_NS + "." + foObject.getNamespace());
            }
            currentSimpleFoElementsStack.push(new StackElementFo(stepName, radioElement));
            currentElementsStack.peek().setFoElementComplete(true);
        } 
	}
	
	private void processSelectNode(String stepName, Node select, Element element) {
		logger.debug("processSelectNode()");
		SelectElement selectElement = new SelectElement(element); 
		if ( !currentElementsStack.isEmpty()) {
            StackElementProperties topStackElement = currentElementsStack.peek();
            selectElement.setElementTypeName(topStackElement.getType());
            selectElement.setNamespace(topStackElement.getTypeNamespace());
            if (selectElement.getNamespace().contains(XMLBEANS_REFERENTIAL_NS)) {
                selectElement.setModelNamespace(MODEL_USERS_NS);
            } else {
                selectElement.setModelNamespace(MODEL_REQUEST_NS + "." + foObject.getNamespace());
            }
            currentSimpleFoElementsStack.push(new StackElementFo(stepName, selectElement));
            currentElementsStack.peek().setFoElementComplete(true);
        } 
	}
	
	private void processLabelNode(String stepName, Node label, Element element) {
		logger.debug("processLabelNode()");
		FieldsetElement fielsetElement = new FieldsetElement(element);
		if ( !currentElementsStack.isEmpty()) {
            currentComplexFoElementsStack.push(new StackComplexFoElement(stepName, fielsetElement));
            //currentElementsStack.peek().setFoElementComplete(true);
            currentElementsStack.peek().setFoElementComplete(true);
        }
	}
	
	private void processDefaultElement(ElementProperties elementProperties,
            StackElementProperties topStackElement, Element element) {
	        	    
            if (elementProperties.isSimpleType()) {
                if (elementProperties.getJavaType().equals("Boolean")) {
                    // Default yesno for xs:boolean
                    YesnoElement yesnoElement = new YesnoElement(element);
                    if (!currentElementsStack.isEmpty()) {
                        currentSimpleFoElementsStack.push(new StackElementFo(
                                currentElementsStack.peek().getStepName(), yesnoElement));
                        currentElementsStack.peek().setFoElementComplete(true);
                    }
                } else {
                    // Default select for Enum
                    if (elementProperties.getEnumValues() != null) {
                        SelectElement selectElement = new SelectElement(element);
                        if ( !currentElementsStack.isEmpty()) {
                            selectElement.setElementTypeName(topStackElement.getType());
                            selectElement.setNamespace(topStackElement.getTypeNamespace());
                            if (selectElement.getNamespace().contains(XMLBEANS_REFERENTIAL_NS)) {
                                selectElement.setModelNamespace(MODEL_USERS_NS);
                            } else {
                                selectElement.setModelNamespace(MODEL_REQUEST_NS + "." + foObject.getNamespace());
                            }
                            currentSimpleFoElementsStack.push(new StackElementFo(
                                    currentElementsStack.peek().getStepName(), selectElement));
                            currentElementsStack.peek().setFoElementComplete(true);
                        } 
                    } else {
                        // Default text for the others
                        TextElement textElement = new TextElement(element);
                        if (!currentElementsStack.isEmpty()) {
                           currentElementsStack.peek().setFoElementComplete(true);
                            currentSimpleFoElementsStack.push(new StackElementFo(
                                    currentElementsStack.peek().getStepName(), textElement));
                        }
                    }
                }
            } else if (elementProperties.isComplexType()) {
                ComplexElement complexElement;
                if (currentElementsStack.peek().isFoElementNotComplete) {
                    complexElement = new ComplexElement(element);
                } else {
                    complexElement = new FieldsetElement(element);
                }
                if (!currentElementsStack.peek().getTypeNamespace().equals(foObject.getXsdNamespace())) {
                    complexElement.setExternalElement(true);
                    currentComplexFoElementsStack.push(new StackComplexFoElement(
                            currentElementsStack.peek().getStepName(), complexElement));
                    currentElementsStack.peek().setFoElementComplete(true);
                }
            } 
	    
	}
    
	 private class StackElementFo {

        private Element element;

        private String stepName;

        public StackElementFo(String stepName, Element element) {
            this.setStepName(stepName);
            this.setElement(element);
        }

        public Element getElement() {
            return element;
        }

        public void setElement(Element element) {
            this.element = element;
        }

        public String getStepName() {
            return stepName;
        }

        public void setStepName(String stepName) {
            this.stepName = stepName;
        }
    }

    private class StackComplexFoElement {

        private ComplexElement element;

        private String stepName;

        public StackComplexFoElement(String stepName, ComplexElement element) {
            this.setStepName(stepName);
            this.setElement(element);
        }

        public ComplexElement getElement() {
            return element;
        }

        public void setElement(ComplexElement element) {
            this.element = element;
        }

        public String getStepName() {
            return stepName;
        }

        public void setStepName(String stepName) {
            this.stepName = stepName;
        }
    }
    
    private class StackComplexElementProperties {
        
        private String name;
        private String namespace;
        private String type;

        public StackComplexElementProperties(String namespace, String type, String name) {
            this.setNamespace(namespace);
            this.setType(type);
            this.setName(name);
        }

        public String getNamespace() {
            return namespace;
        }

        public void setNamespace(String namespace) {
            this.namespace = namespace;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    private class StackElementProperties {

        private String name;

        private String type;

        private String typeNamespace;

        private String namespaceAlias;

        private String stepName;

        private boolean insideLocalComplexType;
        
        private boolean isComplexType;

        private boolean isFoElementNotComplete = false;

        private boolean isFoElementComplete = false;
        
        private Set<Condition> conditions;

        private int depth;

        public StackElementProperties(String name, String type, int depth,
                boolean insideLocalComplexType) {
            this.setDepth(depth);
            this.setName(name);
            this.setType(type.substring(type.indexOf('=') + 1, type.indexOf('@')));
            this.setTypeNamespace(type.substring(type.indexOf('@') + 1));
            this.setInsideLocalComplexType(insideLocalComplexType);
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

        public boolean isFoElementNotComplete() {
            return isFoElementNotComplete;
        }

        public void setFoElementNotComplete(boolean isFoElementNotComplete) {
            this.isFoElementNotComplete = isFoElementNotComplete;
        }

        public boolean isFoElementComplete() {
            return isFoElementComplete;
        }

        public void setFoElementComplete(boolean isFoElementComplete) {
            this.isFoElementComplete = isFoElementComplete;
        }

        public String getStepName() {
            return stepName;
        }

        public void setStepName(String stepName) {
            this.stepName = stepName;
        }

        public boolean isComplexType() {
            return isComplexType;
        }

        public void setComplexType(boolean isComplexType) {
            this.isComplexType = isComplexType;
        }

        public Set<Condition> getConditions() {
            return conditions;
        }

        public void setConditions(Set<Condition> conditions) {
            this.conditions = conditions;
        }
        
    }
}
