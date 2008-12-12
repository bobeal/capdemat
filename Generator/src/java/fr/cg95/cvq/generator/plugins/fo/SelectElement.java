package fr.cg95.cvq.generator.plugins.fo;

/**
 * @author maxence.veyret@bull.net
 */
public class SelectElement extends Element{
	
	private String namespace;
	private String elementTypeName;
	private String modelNamespace;
	
	public SelectElement() {
	}
	
	public SelectElement(String namespace, String elementTypeName,
			String validation, String condition) {
		super();
		this.elementTypeName = elementTypeName;
		this.namespace = namespace;
	}
	
	public SelectElement(Element element) {
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
		return 	"SelectElement " + super.toString() + ", namespace : " + this.namespace + 
		", elementTypeName : " +  this.elementTypeName;
	}
    
}
