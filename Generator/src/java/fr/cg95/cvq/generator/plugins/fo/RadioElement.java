package fr.cg95.cvq.generator.plugins.fo;

/**
 * @author maxence.veyret@bull.net
 */
public class RadioElement extends Element {
	
	private String namespace;
	private String elementTypeName;
	private String modelNamespace;
	
	public RadioElement() {
	}
	
	public RadioElement(String namespace, String elementTypeName,
			 String condition) {
		super();
		this.elementTypeName = elementTypeName;
		this.namespace = namespace;
	}
	
	public RadioElement(Element element) {
	    super(element);
	}
	
	public String getNamespace() {
		return namespace;
	}

	public void setNamespace(String namespace) {
		this.namespace = namespace;
	}

	public String getElementTypeName() {
		return elementTypeName;
	}

	public void setElementTypeName(String elementTypeName) {
		this.elementTypeName = elementTypeName;
	}
	
	public String getModelNamespace() {
        return modelNamespace;
    }

    public void setModelNamespace(String modelNamespace) {
        this.modelNamespace = modelNamespace;
    }

	public String toString() {
		super.toString();
		return 	"RadioElement  " + super.toString() + ", namespace:" + this.namespace + 
		", elementTypeName:" +  this.elementTypeName;
	}
		
}
