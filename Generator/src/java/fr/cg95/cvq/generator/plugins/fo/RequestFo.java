package fr.cg95.cvq.generator.plugins.fo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.StringUtils;

import fr.cg95.cvq.generator.ElementTypeClass;
import fr.cg95.cvq.generator.common.Step;
import fr.cg95.cvq.generator.common.Widget;

/**
 * @author rdj@zenexity.fr
 */
public class RequestFo {
    
    private String name;
    private String acronym;
    private List<Step> steps;
    private List<ElementFo> elements;
    
    // Useful to divide steps into smaller group to bypass (grails view limit size)
    private List<List<Step>> stepBundles;
    
    // Useful to cache step elements
    private Map<String, List<ElementFo>> stepElementsCache = new HashMap<String, List<ElementFo>>();

    public RequestFo(String name, String targetNamespace) {
        this.name =  StringUtils.uncapitalize(name);
        this.acronym = StringUtils.substringAfterLast(targetNamespace, "/");
    }
    
    public String getName() {
        return name;
    }
    
    public String getCamelCaseName() {
        return StringUtils.uncapitalize(name);
    }
    
    public String getAcronym() {
        return acronym;
    }

    public List<Step> getSteps() {
        return steps;
    }
    
    public List<List<Step>> getStepBundles() {
        if (stepBundles == null)
            setStepBundles();
        return stepBundles;
    }

    public void setSteps(List<Step> steps) {
        this.steps = new ArrayList<Step>(steps);
    }
    
    public List<ElementFo> getElements() {
        return elements;
    }
    
    public void addElement (ElementFo element) {
        if (elements == null)
            elements = new ArrayList<ElementFo>();
        elements.add(element);
    }
    
    public List<ElementFo> getElementsByStep(Step step) {
        if (stepElementsCache.containsKey(step.getName()))
            return stepElementsCache.get(step.getName());
        
        List<ElementFo> stepElements = new ArrayList<ElementFo>();
        for (ElementFo element : elements) {
            if (element.getStep().getName().equals(step.getName()))
                stepElements.add(element);
        }
        testAfterAttribute(stepElements);
        stepElementsCache.put(step.getName(),
                addwidgetAsElement(step, sortByAfterAttribute(stepElements)));
        return stepElementsCache.get(step.getName());
    }
    
    private List<ElementFo> sortByAfterAttribute(List<ElementFo> elements) {
        List<ElementFo> sortedElements = new ArrayList<ElementFo>();
        Set<ElementFo> notSortedElements = new HashSet<ElementFo>();
        for (ElementFo element : elements) {
            if (element.getAfter() == null)
                sortedElements.add(element);
            else 
                notSortedElements.add(element);
        }
        for (ElementFo notSortedElement : notSortedElements) {
            for (ElementFo sortedElement : sortedElements) {
                if (notSortedElement.getAfter().equals(sortedElement.getName())) {
                    sortedElements.add(sortedElements.indexOf(sortedElement) + 1  , notSortedElement);
                    break;
                }
            }
        }
        return sortedElements;
    }
    
    private void testAfterAttribute(List<ElementFo> elements) {
        Map<String, String> name_afterMap = new HashMap<String, String>();
        for (ElementFo element : elements)
            name_afterMap.put(element.getName(), element.getAfter());
        
        Set<String> afters = new HashSet<String>();
        for (String name : name_afterMap.keySet()) {
            String after = name_afterMap.get(name);
            if (after != null) {
                if (!name_afterMap.keySet().contains(after))
                    throw new RuntimeException("testAfterAttribute() - {" + after +"} not exist");
                if (after.equals(name))
                    throw new RuntimeException("testAfterAttribute() - self reference {" + name +"} <-> {" + after +"}");
                if (name_afterMap.get(after) != null && name_afterMap.get(after).equals(name))
                    throw new RuntimeException("testAfterAttribute() - cyclic reference : {" + name +"} <-> {" + after +"}");
                if (afters.contains(after))
                    throw new RuntimeException("testAfterAttribute() - not unique reference for {" + after +"}");
                else
                    afters.add(after);
            }
        }
    }
    
    private List<ElementFo> addwidgetAsElement(Step step, List<ElementFo> elements) {
        if (step.getIndex() != 0 || step.getWidgets().isEmpty())
            return elements;
        for (Widget w : step.getWidgets()) {
            ElementFo wElement = new ElementFo(w.getName(), "request");
            wElement.setDisplay(true);
            wElement.setWidget(w.getName());
            wElement.setAutofill(w.getAutofill());
            wElement.setTypeClass(ElementTypeClass.SIMPLE);
            if (w.getInto() == null)
                elements.add(0, wElement);
            else {
                ElementFo firstElement = elements.get(0);
                if (!firstElement.getTypeClass().equals(ElementTypeClass.COMPLEX.toString()))
                    throw new RuntimeException("addwidgetAsElement() - Widget {"+ w.getName() +"} " +
                            "[into] attribute do not reference the first complex element of step {"+ step.getName() +"}");
                if (!firstElement.getName().equals(w.getInto()))
                    throw new RuntimeException("addwidgetAsElement() - Widget {"+ w.getName() +"} " +
                    		"[into] attribute do not reference the first complex element of step {"+ step.getName() +"}");
                firstElement.getElements().add(0,wElement);
            }
        }
        return elements;
    }
    
    private int getStepWeight(Step step) {
        int weight = 0;
        for (ElementFo element : elements) { 
            if (element.getStep().getName().equals(step.getName())) {
                weight++;
                if (element.getElements() != null)
                    weight += element.getElements().size();
            }   
        }
        return weight ;
    }
    
    // TODO - Evaluate the best max bundleWeight
    private void setStepBundles() {
        int bundleWeight = 0;
        List<Step> stepBundle = new ArrayList<Step>();
        stepBundles = new ArrayList<List<Step>>();
        
        for (Step step : this.steps) {
            bundleWeight += getStepWeight(step);
            if (bundleWeight < 150)
                stepBundle.add(step);
            else {
                stepBundles.add(stepBundle);
                stepBundle = new ArrayList<Step>();
                bundleWeight = getStepWeight(step);
                stepBundle.add(step);
            }
        }
        if (stepBundle.size() > 0)
            stepBundles.add(stepBundle);
    }
    
}
