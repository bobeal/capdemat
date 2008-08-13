package fr.cg95.cvq.generator.plugins.gui;

import java.util.HashMap;

public class JavaClass {

    private String name = null;
    private boolean defaultClassName = true;
    private String modelClass = null;

    private HashMap javaFields = null;
    
    public JavaClass() {
        super();
    }

    public JavaClass(String name) {
        super();
        this.name = name;
    }

    public void addJavaDisplayElement(DisplayElement displayElement) {
        if (javaFields == null)
            javaFields = new HashMap();
        
        DisplayElement existingElement = (DisplayElement)javaFields.get(displayElement.getProperty());
        if (existingElement != null) {
            if ((displayElement.getCondition() != null) && displayElement.getCondition().length() > 0)
                existingElement.setCondition(displayElement.getCondition());
            
        } else if ((displayElement.getGuiControl() != null) && 
                !displayElement.getGuiControl().equals("checklist") &&
                !displayElement.getGuiControl().equals("objectlist")) 
            javaFields.put(displayElement.getProperty(),displayElement);
        
        else if (displayElement.getType().equals("javaOnly"))
            javaFields.put(displayElement.getProperty(),displayElement);

        else if (displayElement.isRepository())
            javaFields.put(displayElement.getProperty(),displayElement);
    }

    public HashMap getJavaFields() {
        return javaFields;
    }

    public void setJavaFields(HashMap javaFields) {
        this.javaFields = javaFields;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isDefaultClassName() {
        return defaultClassName;
    }

    public void setDefaultClassName(boolean requestClass) {
        this.defaultClassName = requestClass;
    }

    public String getModelClass() {
        return modelClass;
    }

    public void setModelClass(String modelClass) {
        this.modelClass = modelClass;
    }
    
}
