package fr.cg95.cvq.generator.plugins.fo;

import org.apache.commons.lang.StringUtils;

/**
 * @author maxence.veyret@bull.net
 */
public class Element {
	//TODO change elementName -> name
	private String name;
	private String validation = "";
	private String condition = "";
	private String after;
	private String parentNamespace;
	private String parentXmlSchemaType;
	private boolean isGlobalElement;
	
    public Element() {}
    
    public Element(String name, String validation, String renderType, String after) {
        this.name = name;
        this.validation = validation;
        this.after = after;
    }
    
    public Element(Element element) {
        this.name = element.getName();
        this.validation = element.getValidation();
        this.after = element.getAfter();
        this.condition = element.getCondition();
        this.isGlobalElement = element.isGlobalElement();
        this.parentNamespace = element.getParentNamespace();
        this.parentXmlSchemaType = element.getParentXmlSchemaType();
    }
    
	public String getName() {
		return name;
	}
	
	public String getJavaName() {
	        return StringUtils.uncapitalize(name);
	}

	public void setName(String name) {
		this.name = name;
	}

    public String getValidation() {
		return validation;
	}

	public void setValidation(String validation) {
		this.validation = validation;
	}
	
	public String getAfter() {
		return after;
	}

	public void setAfter(String after) {
		this.after = after;
	}
	
	public String getParentXmlSchemaType() {
        return parentXmlSchemaType;
    }

    public void setParentXmlSchemaType(String parentXmlSchemaType) {
        this.parentXmlSchemaType = parentXmlSchemaType;
    }
    
    public boolean isGlobalElement() {
        return isGlobalElement;
    }

    public void setGlobalElement(boolean isGlobalElement) {
        this.isGlobalElement = isGlobalElement;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }
    
    public String getParentNamespace() {
        return parentNamespace;
    }

    public void setParentNamespace(String parentNamespace) {
        this.parentNamespace = parentNamespace;
    }

    public String toString() {
    	return "(Element) name:" + this.name + ", parentNamespace:" + this.parentNamespace + 
    	",parentXmlSchemaType:" + this.parentXmlSchemaType + ", validation:" + this.validation +
    	", condition:" + this.condition + ", isGlobalElement:" + this.isGlobalElement ;
    }
    
    private String xmlSchemaType;

    public String getXmlSchemaType() {
        return xmlSchemaType;
    }

    public void setXmlSchemaType(String xmlSchemaType) {
        this.xmlSchemaType = xmlSchemaType;
    }
    
    // HACK for enums managment
    public String[] enumValues;

    public String[] getEnumValues() {
        return enumValues;
    }

    public void setEnumValues(String[] enumValues) {
        this.enumValues = enumValues;
    }
    
    public String getEnumValuesAsString() {
        if (enumValues == null )
            return null;
        
        String s = "[";
        for (int i = 0; i < enumValues.length; i++) {
            s += "'" + enumValues[i] + "'";
            if (i < enumValues.length - 1)
                s += ",";
        }
        s += "]";
        return s;
    }
    
    private String modelNamespace;
    public String getModelNamespace() {
        return modelNamespace;
    }

    public void setModelNamespace(String modelNamespace) {
        this.modelNamespace = modelNamespace;
    }
    
}
