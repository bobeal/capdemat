package fr.cg95.cvq.generator.plugins.fo;

import java.util.ArrayList;
import java.util.List;

public class ComplexElement extends Element {
    
    private List<Element> elementList;
    
    private boolean isExternalElement = false;
    
    public ComplexElement() {
        setValidation("");
    }
    
    public ComplexElement(Element element) {
        super(element);
        elementList = new ArrayList<Element>();
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
    
    public boolean isExternalElement() {
        return isExternalElement;
    }

    public void setExternalElement(boolean isExternalElement) {
        this.isExternalElement = isExternalElement;
    }

    public String toString() {
        String result = "";
        result = "ComplexElement : " + getName();
        result = "isExternalElement : " + isExternalElement();
        result += super.toString();
//        for (Integer i=0; i < elementList.size(); i++) {
//            if (elementList.get(i).getName() != null)
//                result += i + ":" + elementList.get(i).getName() + ", ";
//            if (elementList.get(i).getValidation() != null)
//                result += " :" + elementList.get(i).getValidation()+ ", ";
//        }
        return result;
    }
    
}