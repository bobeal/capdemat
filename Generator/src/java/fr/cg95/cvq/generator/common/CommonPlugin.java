package fr.cg95.cvq.generator.common;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.w3c.dom.Node;

import fr.cg95.cvq.generator.ApplicationDocumentation;
import fr.cg95.cvq.generator.ElementProperties;
import fr.cg95.cvq.generator.IPluginGenerator;
import fr.cg95.cvq.generator.UserDocumentation;


/**
 * Common (pseudo) Plugin manage application's informations shared by all Plugin
 * 
 * @author rdj@zenexity.fr
 */
public class CommonPlugin implements IPluginGenerator {
    private static Logger logger =
        Logger.getLogger(CommonPlugin.class);
    
    private RequestCommon requestCommon;
    private int depth;
    
    public static CommonPlugin getInstance() { return INSTANCE; }
    
    private static final CommonPlugin INSTANCE = new CommonPlugin();
    
    private CommonPlugin() {}
    
    
    public void onApplicationInformation(ApplicationDocumentation appDoc) {
        logger.warn( "onApplicationInformation() " + 
                appDoc.getNodeName() + " / " + appDoc.getXmlString());
        
        Node [] fetchNodes;
        Map<String,String> attributeValueMap;
        if (depth < 1 ) {
            if (appDoc.hasChildNode("namespace")) {
                fetchNodes =  appDoc.getChildrenNodes("namespace");
                requestCommon.setNamespace(
                        ApplicationDocumentation.getNodeAttributeValue(fetchNodes[0], "name"));
            }
            
            if (appDoc.hasChildNode("steps")) {
                fetchNodes =  ApplicationDocumentation.getChildrenNodes(
                        appDoc.getChildrenNodes("steps")[0], "step");
                for (Node node : fetchNodes) {
                    attributeValueMap = new HashMap<String,String>();
                    attributeValueMap.put("index", 
                            ApplicationDocumentation.getNodeAttributeValue(node, "index"));
                    attributeValueMap.put("name", 
                            ApplicationDocumentation.getNodeAttributeValue(node, "name"));
                    attributeValueMap.put("ref", 
                            ApplicationDocumentation.getNodeAttributeValue(node, "ref"));
                    
                    requestCommon.addStep(new Step(
                            attributeValueMap.get("index"), attributeValueMap.get("name"), 
                            attributeValueMap.get("ref")));
                }
            }
            
            if (appDoc.hasChildNode("conditions")) {
                fetchNodes =  ApplicationDocumentation.getChildrenNodes(
                        appDoc.getChildrenNodes("conditions")[0], "condition");
                for (Node node : fetchNodes) {
                    requestCommon.addCondition( new Condition(
                            ApplicationDocumentation.getNodeAttributeValue(node, "name"), null));
                }
            }
            appDoc.setRequestCommon(requestCommon);
        }
        else {
            if (appDoc.hasChildNode("step")) {
                fetchNodes = appDoc.getChildrenNodes("step");
                requestCommon.setCurrentElementStep(new Step(-1, 
                        ApplicationDocumentation.getNodeAttributeValue(fetchNodes[0], "name"), null));
            }
            if (appDoc.hasChildNode("condition")) {
                fetchNodes = appDoc.getChildrenNodes("condition");
                attributeValueMap = new HashMap<String,String>();
                attributeValueMap.put("name",
                        ApplicationDocumentation.getNodeAttributeValue(fetchNodes[0], "name"));
                attributeValueMap.put("type", 
                        ApplicationDocumentation.getNodeAttributeValue(fetchNodes[0], "type"));
                requestCommon.setCurrentElementCondition(new Condition(
                        attributeValueMap.get("name"), attributeValueMap.get("type"))); 
            }   
        }
        
        if (depth < 1)
            logger.debug("onApplicationInformation - requestCommon=[" +
                    "namespace: " + requestCommon.getNamespace() +
                    ", steps.size: " + requestCommon.getSteps().size() +
                    ", conditions.size: " + requestCommon.getConditions().size() +
                    "]");
        else {
            String stepName = requestCommon.getCurrentElementCommon().getStep().getName();
            String conditionName = requestCommon.getCurrentElementCommon().getCondition() != null ?
                    requestCommon.getCurrentElementCommon().getCondition().getName() : "NO-CONDITION";
            
            logger.debug("onApplicationInformation() - currentElementCommom= [" +
            		"step: [name:" + stepName   +
            		"] condition: [name: " + conditionName +
            		"]");
        }
    
    }
    
    public void onOtherApplicationInformation(ApplicationDocumentation appDoc) {
        appDoc.setRequestCommon(requestCommon);
    }

    public void startRequest(String requestName, String targetNamespace) {
        logger.debug("startRequest() - ");
        requestCommon = new RequestCommon();
        depth = 0;
    }
    
    public void startElement(String elementName, String type) {
        depth ++;
    }
    
    public void onUserInformation(UserDocumentation userDocumentation) {}
    
    public void startElementProperties(ElementProperties elementProperties) {}
    
    public void endElementProperties() { }
    
    public void endElement(String elementName) {
        requestCommon.setCurrentElementCommon(null);
        depth --;
    }

    public void endRequest(String requestName) {}

    public void shutdown() {}

    @Override
    public void initialize(Node configurationNode) {
        // TODO Auto-generated method stub
        
    }
   
} 
