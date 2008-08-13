package fr.cg95.cvq.generator.plugins.xslfo;

/**
 * @author bor@zenexity.fr
 */
public class VarargCheckboxElement extends Element {

    private String displayModulo;

    public VarargCheckboxElement() {
        super();
    }

    public VarargCheckboxElement(Element element) {
        super(element);
    }

    public String getDisplayType() {
        return "vararg_checkbox";
    }

    public String getDisplayModulo() {
        return this.displayModulo;
    }

    public void setDisplayModulo(final String displayModulo) {
        this.displayModulo = displayModulo;
    }
}
