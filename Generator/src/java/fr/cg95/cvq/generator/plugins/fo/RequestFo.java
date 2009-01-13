package fr.cg95.cvq.generator.plugins.fo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.StringUtils;

import fr.cg95.cvq.generator.common.Condition;
import fr.cg95.cvq.generator.common.Step;

/**
 * @author rdj@zenexity.fr
 */
public class RequestFo {
    
    private String name;
    private String acronym;
    private List<Step> steps;
    private Set<Condition> conditions;
    private List<ElementFo> elements;

    public RequestFo(String name, String targetNamespace) {
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
        this.steps = new ArrayList<Step>(steps);
        
        for (Iterator<Step> it = this.steps.iterator(); it.hasNext();) {
            if (it.next().getName() == null)
                it.remove();
        }
    }
    
    public Set<Condition> getConditions() {
        return conditions;
    }
    
    public void setConditions(Set<Condition> conditions) {
        this.conditions = conditions;
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
        List<ElementFo> stepElements = new ArrayList<ElementFo>();
        for (ElementFo element : elements) {
            if (element.getStep().getName().equals(step.getName()))
                stepElements.add(element);
        }
        testAfterAttribute(stepElements);
        return sortByAfterAttribute(stepElements);
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
    
}
