package fr.cg95.cvq.generator.plugins.xslfo;

/**
 * @author bor@zenexity.fr
 */
public class Element {

    private Integer lineId;
    private Integer columnId;
    private Integer columnSpan;

    private String prefixLabel;
    private boolean usePrefixLabel;
    private boolean useLongDesc;
    private String footNotice;

    private String elementName;
    private String parentElementName;
    private String elementType;
    /**
     * full namespace of the element's type, used for dynamic retrieval of global referential data 
     * information from XML schemas.
     */
    private String elementTypeNamespace;
    private String namespaceAlias;

    private boolean requiredSymbol;
    private boolean manyValues;
    private String selectXPath;
    private String displayCondition;

    public Element() {
        this.columnSpan = new Integer(1);
    }

    public Element(Element element) {
        this.lineId = element.getLineId();
        this.columnId = element.getColumnId();
        this.columnSpan = element.getColumnSpan();

        this.prefixLabel = element.getPrefixLabel();
        this.usePrefixLabel = element.getUsePrefixLabel();
        this.useLongDesc = element.getUseLongDesc();
        this.footNotice = element.getFootNotice();

        this.elementName = element.getElementName();
        this.elementType = element.getElementType();
        this.elementTypeNamespace = element.getElementTypeNamespace();
        this.namespaceAlias = element.getNamespaceAlias();

        this.requiredSymbol = element.getRequiredSymbol();
        this.manyValues = element.getManyValues();
        this.selectXPath = element.getSelectXPath();
        this.displayCondition = element.getDisplayCondition();
    }

    public String getDisplayType() {
        return "";
    }

    public Integer getLineId() {
        return this.lineId;
    }

    public void setLineId(final Integer lineId) {
        if (lineId == null)
            throw new RuntimeException("An XSL-FO element must have a lineId attribute");
        this.lineId = lineId;
    }

    public Integer getColumnId() {
        return this.columnId;
    }

    public void setColumnId(final Integer columnId) {
        if (columnId == null)
            throw new RuntimeException("An XSL-FO element must have a columnId attribute");
        this.columnId = columnId;
    }

    public Integer getColumnSpan() {
        return this.columnSpan;
    }

    public void setColumnSpan(final Integer columnSpan) {
        if (columnSpan != null)
            this.columnSpan = columnSpan;
        else
            this.columnSpan = new Integer(1);
    }

    public String getPrefixLabel() {
        return this.prefixLabel;
    }

    public void setPrefixLabel(String prefixLabel) {
        this.prefixLabel = prefixLabel;
    }

    public boolean getUsePrefixLabel() {
        return this.usePrefixLabel;
    }

    public void setUsePrefixLabel(String usePrefixLabel) {
        if (usePrefixLabel != null)
            this.usePrefixLabel = (new Boolean(usePrefixLabel)).booleanValue();
        else
            this.usePrefixLabel = true;
    }

    public boolean getUseLongDesc() {
        return this.useLongDesc;
    }

    public void setUseLongDesc(String useLongDesc) {
        if (useLongDesc != null)
            this.useLongDesc = (new Boolean(useLongDesc)).booleanValue();
        else
            this.useLongDesc = false;
    }

    public boolean getRequiredSymbol() {
        return this.requiredSymbol;
    }

    public void setRequiredSymbol(boolean requiredSymbol) {
        this.requiredSymbol = requiredSymbol;
    }

    public boolean getManyValues() {
        return this.manyValues;
    }

    public void setManyValues(boolean manyValues) {
        this.manyValues = manyValues;
    }

    public String getFootNotice() {
        return this.footNotice;
    }

    public void setFootNotice(String footNotice) {
        this.footNotice = footNotice;
    }

    public String getElementName() {
        return this.elementName;
    }

    public void setElementName(String elementName) {
        this.elementName = elementName;
    }

    public String getParentElementName() {
        return parentElementName;
    }

    public void setParentElementName(String parentElementName) {
        this.parentElementName = parentElementName;
    }

    public String getElementType() {
        return this.elementType;
    }

    public void setElementType(String elementType) {
        this.elementType = elementType;
    }

    public String getNamespaceAlias() {
        return this.namespaceAlias;
    }

    public void setNamespaceAlias(String namespaceAlias) {
        this.namespaceAlias = namespaceAlias;
    }

    public String getSelectXPath() {
        return this.selectXPath;
    }

    public void setSelectXPath(final String selectXPath) {
        this.selectXPath = selectXPath;
    }

    /**
     * Return the final element name pointed by the select XPath expression
     */
    public String getSelectElementName() {
        if (selectXPath == null)
            return null;

        int index = selectXPath.lastIndexOf(':');
        String selectElementName = selectXPath.substring(index + 1);
        return selectElementName;
    }

    public void setDisplayCondition(final String displayCondition) {
        this.displayCondition = displayCondition;
    }

    public String getDisplayCondition() {
        return this.displayCondition;
    }

    public String getElementTypeNamespace() {
        return elementTypeNamespace;
    }

    public void setElementTypeNamespace(String elementTypeNamespace) {
        this.elementTypeNamespace = elementTypeNamespace;
    }
}
