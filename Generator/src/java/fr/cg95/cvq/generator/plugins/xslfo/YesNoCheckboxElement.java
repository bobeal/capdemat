package fr.cg95.cvq.generator.plugins.xslfo;

/**
 * @author bor@zenexity.fr
 */
public final class YesNoCheckboxElement extends Element {

    public YesNoCheckboxElement() {
        super();
    }

    public YesNoCheckboxElement(Element element) {
        super(element);
    }

    public String getDisplayType() {
        return "yesno_checkbox";
    }
}
