package fr.cg95.cvq.generator.plugins.xslfo;

/**
 * @author bor@zenexity.fr
 */
public final class ComplexTemplateElement extends Element {

    private String parentElementName;

    /**
     * The name of the XSL template to call for displaying of the complex element.
     * (XSL template name matches the XML Schema type name of the complex element)
     */
    private String templateName;

    public ComplexTemplateElement() {
        super();
    }

    public ComplexTemplateElement(Element element) {
        super(element);
    }

    public String getDisplayType() {
        return "complex_template";
    }

    public String getParentElementName() {
        return this.parentElementName;
    }

    public void setParentElementName(final String parentElementName) {
        this.parentElementName = parentElementName;
    }

    public String getTemplateName() {
        return this.templateName;
    }

    public void setTemplateName(final String templateName) {
        this.templateName = templateName;
    }
}
