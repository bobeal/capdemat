package fr.cg95.cvq.generator.plugins.bo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.StringUtils;

import fr.cg95.cvq.generator.ElementTypeClass;
import fr.cg95.cvq.generator.common.CommonStep;
import fr.cg95.cvq.generator.common.Step;
import fr.cg95.cvq.generator.common.Widget;

/**
 * @author rdj@zenexity.fr
 */
public class RequestBo {
    
    private String name;
    private String acronym;
    private List<Step> steps;
    private List<ElementBo> elements;

    // Useful to divide steps into smaller group to bypass (grails view limit size)
    private List<List<Step>> stepBundles;
    
    // Useful to cache step elements
    private Map<String, List<ElementBo>> stepElementsCache = new HashMap<String, List<ElementBo>>();
    
    public RequestBo(String name, String targetNamespace) {
        this.name =  StringUtils.uncapitalize(name);
        this.acronym = StringUtils.substringAfterLast(targetNamespace, "/");
    }
    
    public String getName() {
        return name;
    }
    
    public String getAcronym() {
        return acronym;
    }

    public List<Step> getSteps() {
        return steps;
    }
    
    public void setSteps(List<Step> steps) {
        this.steps = new ArrayList<Step>();
        for (Step step : steps) {
            if (!(step instanceof CommonStep)
                || CommonStep.Ref.administration.name().equals(step.getName()))
                this.steps.add(step);
        }
    }
    
    public List<List<Step>> getStepBundles() {
        if (stepBundles == null)
            setStepBundles();
        return stepBundles;
    }
    
    public List<ElementBo> getElements() {
        return elements;
    }
    
    public void addElement (ElementBo element) {
        if (elements == null)
            elements = new ArrayList<ElementBo>();
        elements.add(element);
    }
    
    public List<ElementBo> getElementsByTypeClass(ElementTypeClass typeClass) {
        List<ElementBo> typeClassElements = new ArrayList<ElementBo>();
        for (ElementBo element : elements)
            if (element.getTypeClass().equals(typeClass.toString()))
                typeClassElements.add(element);
        
        return typeClassElements;
    }
    
    public List<ElementBo> getElementsByStep(Step step, int column) {
        String stepColumnKey = step.getName() + "_" + column;
        if (stepElementsCache.containsKey(stepColumnKey))
            return stepElementsCache.get(stepColumnKey);
        
        List<ElementBo> stepElements = new ArrayList<ElementBo>();
        for (ElementBo element : elements) {
            if (element.getStep().getName().equals(step.getName())
                    && element.getColumn() == column)
                stepElements.add(element);
        }
        testAfterAttribute(stepElements);
        if (column == 1)
            stepElementsCache.put(stepColumnKey, addwidgetAsElement(step, sortByAfterAttribute(stepElements)));
        else
            stepElementsCache.put(stepColumnKey,sortByAfterAttribute(stepElements));
            
        return stepElementsCache.get(stepColumnKey);
    }
    
    private List<ElementBo> sortByAfterAttribute(List<ElementBo> elements) {
        List<ElementBo> sortedElements = new ArrayList<ElementBo>();
        Set<ElementBo> notSortedElements = new HashSet<ElementBo>();
        for (ElementBo element : elements) {
            if (element.getAfter() == null)
                sortedElements.add(element);
            else 
                notSortedElements.add(element);
        }
        for (ElementBo notSortedElement : notSortedElements) {
            for (ElementBo sortedElement : sortedElements) {
                if (notSortedElement.getAfter().equals(sortedElement.getName())) {
                    sortedElements.add(sortedElements.indexOf(sortedElement) + 1  , notSortedElement);
                    break;
                }
            }
        }
        return sortedElements;
    }
    
    private void testAfterAttribute(List<ElementBo> elements) {
        Map<String, String> name_afterMap = new HashMap<String, String>();
        for (ElementBo element : elements)
            name_afterMap.put(element.getName(), element.getAfter());
        
        Set<String> afters = new HashSet<String>();
        for (String name : name_afterMap.keySet()) {
            String after = name_afterMap.get(name);
            if (after != null) {
                if (!name_afterMap.keySet().contains(after))
                    throw new RuntimeException("testAfterAttribute() - {" + after +"} not exist");
                if (after.equals(name))
                    throw new RuntimeException("testAfterAttribute() - self reference {" + name +"} <->{" + after +"}");
                if (name_afterMap.get(after) != null && name_afterMap.get(after).equals(name))
                    throw new RuntimeException("testAfterAttribute() - cyclic reference : {" + name +"} <->{" + after +"}");
                if (afters.contains(after))
                    throw new RuntimeException("testAfterAttribute() - not unique reference for {" + after +"}");
                else
                    afters.add(after);
            }
        }
    }
    
    private List<ElementBo> addwidgetAsElement(Step step, List<ElementBo> elements) {
        if (step.getIndex() != 0 || step.getWidgets().isEmpty())
            return elements;
        for (Widget w : step.getWidgets()) {
            ElementBo wElement = new ElementBo(w.getName(), "request");
            wElement.setDisplay(true);
            wElement.setWidget(w.getName());
            wElement.setTypeClass(ElementTypeClass.SIMPLE);
            if (w.getInto() == null)
                elements.add(0, wElement);
            else {
                ElementBo firstElement = elements.get(0);
                if (!firstElement.getTypeClass().equals(ElementTypeClass.COMPLEX.toString()))
                    throw new RuntimeException("addwidgetAsElement() - Widget {"+ w.getName() +"} " +
                            "[into] attribute can not reference {"+ w.getInto() +"}." +
                            " It isn't the first element of step {"+ step.getName() +"}");
                if (!firstElement.getName().equals(w.getInto()))
                    throw new RuntimeException("addwidgetAsElement() - Widget {"+ w.getName() +"} " +
                            "[into] attribute do not reference the first and complex element of step {"+ step.getName() +"}");
                firstElement.getElements().add(0,wElement);
            }
        }
        return elements;
    }
    
    private int getStepWeight(Step step) {
        int weight = 0;
        for (ElementBo element : elements) { 
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
            if (bundleWeight < 100)
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
