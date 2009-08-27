package fr.cg95.cvq.generator.plugins.xslfo;

/**
 * @author bor@zenexity.fr
 */
public final class SimpleTemplateElement extends Element {

    private String templateName;
    private String templateParam;
    private String valueWeight;

    public SimpleTemplateElement() {
        super();
    }

    public SimpleTemplateElement(Element element) {
        super(element);
    }

    @Override
    public String getDisplayType() {
        return "simple_template";
    }

    public String getTemplateName() {
        return this.templateName;
    }

    public String getTemplateParam() {
        return this.templateParam;
    }

    public void setTemplateName(final String templateName) {
        this.templateName = templateName;
    }

    public void setTemplateParam(final String templateParam) {
        this.templateParam = templateParam;
    }

    public Integer getValueWeight() {
        if (this.valueWeight != null)
            return new Integer(this.valueWeight);
        else
            return new Integer(1);
    }

    public void setValueWeight(final String valueWeight) {
        this.valueWeight = valueWeight;
    }
}
