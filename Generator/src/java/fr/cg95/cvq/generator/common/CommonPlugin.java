package fr.cg95.cvq.generator.common;

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
        
        if (depth < 1 ) {
            if (appDoc.hasChildNode("namespace"))
                requestCommon.setNamespace(ApplicationDocumentation.getNodeAttributeValue(
                        appDoc.getChildrenNodes("namespace")[0], "name"));

            Step step;
            if (appDoc.hasChildNode("steps")) {
                for (Node node : 
                    ApplicationDocumentation.getChildrenNodes(appDoc.getChildrenNodes("steps")[0], "step")) {
                    step = new Step(
                             ApplicationDocumentation.getNodeAttributeValue(node, "index")
                            ,ApplicationDocumentation.getNodeAttributeValue(node, "name")
                            ,ApplicationDocumentation.getNodeAttributeValue(node, "ref"));
                    
                    requestCommon.addStep(step);
                    
                    Node[] conditionsNodes = ApplicationDocumentation.getChildrenNodes(node, "conditions");
                    if(conditionsNodes != null)
                        for (Node conditionNode : 
                            ApplicationDocumentation.getChildrenNodes(conditionsNodes[0], "condition"))
                            requestCommon.addConditionToStep(step, new Condition(
                                    ApplicationDocumentation.getNodeAttributeValue(conditionNode, "name"), null, null));
                }
            }
            appDoc.setRequestCommon(requestCommon);
        }
        else {
            if (appDoc.hasChildNode("step"))
                requestCommon.setCurrentElementStep(
                        new Step(-1, ApplicationDocumentation.getNodeAttributeValue(
                                appDoc.getChildrenNodes("step")[0], "name"), null));

            if (appDoc.hasChildNode("conditions"))
                for (Node node : 
                    ApplicationDocumentation.getChildrenNodes(appDoc.getChildrenNodes("conditions")[0], "condition"))
                    requestCommon.addCurrentElementCondition(new Condition(
                            ApplicationDocumentation.getNodeAttributeValue(node, "name") 
                            ,ApplicationDocumentation.getNodeAttributeValue(node, "type")
                            ,ApplicationDocumentation.getNodeAttributeValue(node, "required")));
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
        requestCommon.setCurrentElementCommon(new ElementCommon());
        depth ++;
    }
    
    public void onUserInformation(UserDocumentation userDocumentation) {}
    
    public void startElementProperties(ElementProperties elementProperties) {}
    
    public void endElementProperties() {}
    
    public void endElement(String elementName) {
        depth --;
    }

    public void endRequest(String requestName) {}

    public void shutdown() {}

    public void initialize(Node configurationNode) {}
}