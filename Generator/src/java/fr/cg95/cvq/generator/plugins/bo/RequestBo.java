package fr.cg95.cvq.generator.plugins.bo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang.StringUtils;

import fr.cg95.cvq.generator.common.Condition;
import fr.cg95.cvq.generator.common.Step;

/**
 * @author rdj@zenexity.fr
 */
public class RequestBo {
    
    private String name;
    private List<Step> steps;
    private Set<Condition> conditions;
    private List<ElementBo> elements;

    public RequestBo(String name) {
        this.name =  StringUtils.uncapitalize(name);
    }
    
    public String getName() {
        return name;
    }
    
    public List<Step> getSteps() {
        return steps;
    }
    public void setSteps(List<Step> steps) {
        this.steps = steps;
        
        for (Iterator<Step> it = steps.iterator(); it.hasNext();) {
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
    
    public List<ElementBo> getElements() {
        return elements;
    }
    
    public void addElement (ElementBo element) {
        if (elements == null)
            elements = new ArrayList<ElementBo>();
        elements.add(element);
    }
    
    public List<ElementBo> getElementsByStep(Step step, int column) {
        List<ElementBo> stepElements = new ArrayList<ElementBo>();
        for (ElementBo element : elements) {
            if (element.getStep().getName().equals(step.getName())
                    && element.getColumn() == column)
                stepElements.add(element);
        }
//        return stepElements;
        return sortByAfterAttribute(stepElements);
    }
    
    private List<ElementBo> sortByAfterAttribute(List<ElementBo> elements) {
        List<ElementBo> sortElements = new ArrayList<ElementBo>();
        Set<ElementBo> notSortElements = new HashSet<ElementBo>();
        
        for (ElementBo element : elements) {
            if (element.getAfter() == null)
                sortElements.add(element);
            else {
                // TODO - test after="ref" validity
                notSortElements.add(element);
            }
        }
        
        for (ElementBo notSortElement : notSortElements) {
            for (ElementBo sortElement : sortElements) {
                if (notSortElement.getAfter().equals(sortElement.getName())) {
                    sortElements.add(sortElements.indexOf(sortElement) + 1  , notSortElement);
                    break;
                }
            }
        }
        return sortElements;
    }
    
}
