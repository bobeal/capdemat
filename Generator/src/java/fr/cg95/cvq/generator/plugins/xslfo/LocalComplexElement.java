package fr.cg95.cvq.generator.plugins.xslfo;

import java.util.ArrayList;
import java.util.List;

/**
 * LocalComplexElement is a elements's container widget. It is used to manage the display 
 * of XML Schema Element with complexType and maxoccur >= 0.
 * 
 * @author rdj@zenexity.fr
 */
public class LocalComplexElement extends Element {

    private List<Element> elementList;
    
    //FIXME Think on a new solution to display List's element and their total
    private boolean withTotal;

    public LocalComplexElement(Element element) {
        super(element);
    }    
    
    public LocalComplexElement() {
        super();
    }      
    
    public String getDisplayType() {
        return "local_complex_element";
    }
    
    public List<Element> getElementList() {
        return elementList;
    }

    public void setElementList(List<Element> elementList) {
        this.elementList = elementList;
    }
    
    public boolean addElement(Element element){
        if (elementList == null)
            elementList = new ArrayList<Element>();
        
       return( elementList.add(element));
    }
    
    public Element getChildElement(int index) {
        return elementList.get(index);
    }

    public boolean isWithTotal() {
        return withTotal;
    }

    public void setWithTotal(boolean withTotal) {
        this.withTotal = withTotal;
    }
}
