package fr.cg95.cvq.generator.plugins.fo;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeMap;

import org.apache.log4j.Logger;

import fr.cg95.cvq.generator.plugins.fo.Element;


/**
 * @author maxence.veyret@bull.net
 */
public class FoObject {

	private static Logger logger = Logger.getLogger(FoObject.class);
	
	private String requestName;
	private String xsdNamespace;
	private String namespace;
	private TreeMap<Integer,FoStep> stepMap;
	private Set<String> conditionsNames;
	boolean neededValidation = false;
	
	public FoObject(String requestName, String xsdNamespace) {
		this.requestName = requestName;
		this.xsdNamespace = xsdNamespace;
		this.stepMap = new TreeMap<Integer,FoStep>();
		this.conditionsNames = new HashSet<String>();
	}

	public String getRequestName() {
		return requestName;
	}

	public void setRequestName(String requestName) {
		this.requestName = requestName;
	}
	
    public void addStep(FoStep step) {
        logger.debug("addStep() adding block " + step.getIndex() + " with label " + step.getName());
        stepMap.put(step.getIndex(), step);
    }

    public TreeMap<Integer,FoStep> getStepMap() {
        return this.stepMap;
    }
    
    //TODO SET the name of element throws the exception to addElementToStep
    public FoStep getStepByName(String stepName) {
    	FoStep step = null;
    	if (stepName == null)
            throw new RuntimeException("getStepByName() no step defined for this element");

    	for (int i = 0; i < stepMap.size(); i++) {
    		if (stepMap.get(i).getName().equals(stepName)) step = stepMap.get(i);
    	}
    	if (step == null)
            throw new RuntimeException("getStepByName() no step with name " + stepName + " found");
    	return step;
    }
	
	public String getNamespaceAlias() {
        return xsdNamespace.substring(xsdNamespace.lastIndexOf('/') + 1);
    }
	
	public void addElementToStep(String stepName, Element element) {
	    FoStep step = getStepByName(stepName);
        step.addElement(element);
    }
	
	public String getXsdNamespace() {
        return xsdNamespace;
    }

    public void setXsdNamespace(String xsdNamespace) {
        this.xsdNamespace = xsdNamespace;
    }

    public String getNamespace() {
        return namespace;
    }

    public void setNamespace(String namespace) {
        this.namespace = namespace;
    }
    
    public boolean isNeededValidation() {
        return neededValidation;
    }

    public void setNeededValidation(boolean needsValidation) {
        this.neededValidation = needsValidation;
    }

    public Set<String> getConditionsNames() {
        return conditionsNames;
    }

    public void setConditionsNames(Set<String> conditionsNames) {
        this.conditionsNames = conditionsNames;
    }

    public void displaySteps() {
		try {
		if (stepMap != null) {
			for (int i = 0; i < stepMap.size(); i++) {
				System.out.println(stepMap.get(i).toString());
			}
		}
		} catch (Exception e) {e.printStackTrace();}
	}
}
