package fr.cg95.cvq.generator.plugins.fo;

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
}
