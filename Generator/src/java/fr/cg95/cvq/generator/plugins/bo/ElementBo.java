package fr.cg95.cvq.generator.plugins.bo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import fr.cg95.cvq.generator.common.Condition;
import fr.cg95.cvq.generator.common.Step;

/**
 * @author rdj@zenexity.fr
 */
public class ElementBo {
    
    public enum ElementTypeClass { SIMPLE, COMPLEX, COLLECTION; }
    
    /* Specific bo widget. default is string widget
     * key=xmlSchemaType; value=boWidgetType
     */
    private final static Map<String,String> boWidgets = new HashMap<String, String>(){{
        put("date", "date");
        put("capdematEnum", "capdematEnum");
        put("AddressType", "adress");
    }};
    
    private String label;
    private String name;
    private String javaFieldName;
    private String modelNamespace;
    private String type;
    
    private String i18nLabelCode;
    private String i18nValidationErrorCode;
    private String htmlClass;
    
    private ElementTypeClass typeClass;
    private boolean mandatory;
 
    private boolean display;

    private int column;
    private String after;

    private Step step;
    private Condition condition;
    
    private List<ElementBo> elements;
    
    public ElementBo(String name, String requestAcronym) {
        this.name = name;
        this.javaFieldName = StringUtils.uncapitalize(name);
        this.i18nLabelCode = requestAcronym + ".property." + this.javaFieldName + ".label";
        this.i18nValidationErrorCode = requestAcronym + ".property." + this.javaFieldName + ".validationError";
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

    public String getModelNamespace() {
        return modelNamespace;
    }

    public void setModelNamespace(String modelNamespace) {
        this.modelNamespace = modelNamespace;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
    public String getQualifiedType() {
        return modelNamespace + "." + type;
    }

    public String getI18nLabelCode() {
        return i18nLabelCode;
    }

    public String getI18nValidationErrorCode() {
        return i18nValidationErrorCode;
    }

    public String getHtmlClass() {
        return htmlClass;
    }

    public void setHtmlClass(String xmlSchemaType) {
        this.htmlClass = 
            (boWidgets.get(xmlSchemaType) == null ? "string" : boWidgets.get(xmlSchemaType))
            + " " + (mandatory ? "required" : "null")
            + " " + i18nValidationErrorCode
            + " " + (condition != null ? condition.getName() + "-" + condition.getType() : "null");
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
        if (this.column < 1 || this.column > 2)
            throw new RuntimeException("setColumn() - Column {"+ column +"} is not in [1,2]");
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
