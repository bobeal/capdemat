package fr.cg95.cvq.generator.plugins.xslfo;

/**
 * @author bor@zenexity.fr
 */
public final class LocalReferentialElement extends Element {

    public LocalReferentialElement() {
        super();
    }

    public LocalReferentialElement(Element element) {
        super(element);
    }

    @Override
    public String getDisplayType() {
        return "local_referential";
    }
}
