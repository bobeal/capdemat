package fr.cg95.cvq.generator.plugins.fo;

/**
 * @author maxence.veyret@bull.net
 */
public class TextareaElement extends Element {
	
	private Integer rows;
	
	public TextareaElement() {
	}
	
	public TextareaElement(Element element) {
	    super(element);
	}
	
	public TextareaElement(Integer rows) {
		super();
		this.rows = rows;
	}
	
	public Integer getRows() {
		return rows;
	}
	
	public void setRows(Integer rows) {
		this.rows = rows;
	}
	
	public String toString() {
		
		return "TextareaElement " + super.toString() + ", rows:" +  rows;
	}
}
