package fr.cg95.cvq.generator.plugins.xslfo;

/**
 * @author bor@zenexity.fr
 */
public final class StringElement extends Element {

    private String referential;
    private boolean restrictToChar;
    private String valueWeight;

    public StringElement() {
        super();
    }

    public StringElement(Element element) {
        super(element);
    }

    public String getDisplayType() {
        return "string";
    }

    public String getReferential() {
        return this.referential;
    }

    public void setReferential(final String referential) {
        this.referential = referential;
    }

    public boolean getRestrictToChar() {
        return this.restrictToChar;
    }

    public void setRestrictToChar(String restrictToChar) {
        if (restrictToChar != null)
            this.restrictToChar = (new Boolean(restrictToChar)).booleanValue();
        else
            this.restrictToChar = false;
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
