package fr.cg95.cvq.generator.plugins.bo;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import fr.cg95.cvq.generator.common.Condition;
import fr.cg95.cvq.generator.common.Step;

/**
 * @author rdj@zenexity.fr
 */
public class ElementBo {
    
    public enum ElementTypeClass { SIMPLE, COMPLEX, COLLECTION; }
    
    private String label;
    private String name;
    private String javaFieldName;
    private String type;
    
    private ElementTypeClass typeClass;
    private boolean mandatory;

    // TODO - remove property
    private int depth;
    
    private boolean display;

    private int column;
    private String after;

    private Step step;
    private Condition condition;
    
    private List<ElementBo> elements;
    
    public ElementBo(String name) {
        this.name = name;
        this.javaFieldName = StringUtils.uncapitalize(name);
        display = false;
    }
    
    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        this.javaFieldName = StringUtils.uncapitalize(name);
    }
    
    public String getJavaFieldName() {
        return javaFieldName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    public String getTypeClass() {
        return typeClass.toString();
    }

    public void setTypeClass(ElementTypeClass typeClass) {
        this.typeClass = typeClass;
    }
    
    public boolean isMandatory() {
        return mandatory;
    }

    public void setMandatory(boolean mandatory) {
        this.mandatory = mandatory;
    }
    
    public boolean isDisplay() {
        return display;
    }

    public void setDisplay(boolean display) {
        this.display = display;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(String column) {
        if (column == null)
            return;
        try {
            this.column = Integer.valueOf(column).intValue();
        } catch (NumberFormatException nfe) {
            throw new RuntimeException("setColumn() - Column {"+ column +"} is not an integer");
        }
    }

    public String getAfter() {
        return after;
    }

    public void setAfter(String after) {
        if (after == null)
            return;
        this.after = after;
    }

    public Step getStep() {
        return step;
    }

    public void setStep(Step step) {
        this.step = step;
    }

    public Condition getCondition() {
        return condition;
    }

    public void setCondition(Condition condition) {
        this.condition = condition;
    }

    public List<ElementBo> getElements() {
        return elements;
    }

    public void addElement (ElementBo element) {
        if (elements == null)
            elements = new ArrayList<ElementBo>();
        elements.add(element);
    }
    
}
