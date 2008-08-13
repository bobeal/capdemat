package fr.cg95.cvq.generator.plugins.xslfo;

import java.util.HashMap;

/**
 * @author bor@zenexity.fr
 * 
 * @deprecated This element is no longer used. Remove it when its useless is confirmed. 
 */
public class VarargCheckboxElementWithPrecision extends VarargCheckboxElement {

    private HashMap precisions;
    private String precisionElementName;
    private String enumElementName;
    private String enumElementType;

    public VarargCheckboxElementWithPrecision() {
        super();
        precisions = new HashMap();
    }

    public VarargCheckboxElementWithPrecision(Element element) {
        super(element);
        precisions = new HashMap();
    }

    public String getDisplayType() {
        return "vararg_checkbox_with_precision";
    }

    public HashMap getPrecisions() {
        return precisions;
    }

    public void addPrecision(final String displayCondition,
                             final String prefixLabel) {
        precisions.put(displayCondition, prefixLabel);
    }

    public void setPrecisionElementName(final String precisionElementName) {
        this.precisionElementName = precisionElementName;
    }

    public String getPrecisionElementName() {
        return this.precisionElementName;
    }

    public void setEnumElementName(final String enumElementName) {
        this.enumElementName = enumElementName;
    }

    public String getEnumElementName() {
        return this.enumElementName;
    }

    public void setEnumElementType(final String enumElementType) {
        this.enumElementType = enumElementType;
    }

    public String getEnumElementType() {
        return this.enumElementType;
    }
}
