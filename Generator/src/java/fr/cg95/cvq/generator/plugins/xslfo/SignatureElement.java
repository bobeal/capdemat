package fr.cg95.cvq.generator.plugins.xslfo;

import java.util.TreeMap;

/**
 * @author bor@zenexity.fr
 */
public final class SignatureElement extends Element {

    private TreeMap acceptMessages;
    private TreeMap rejectMessages;

    public SignatureElement() {
        super();
    }

    public SignatureElement(Element element) {
        super(element);
    }

    @Override
    public String getDisplayType() {
        return "signature";
    }

    public TreeMap getAcceptMessages() {
        return acceptMessages;
    }

    public TreeMap getRejectMessages() {
        return rejectMessages;
    }

    public void setAcceptMessages(final TreeMap acceptMessages) {
        this.acceptMessages = acceptMessages;
    }

    public void setRejectMessages(final TreeMap rejectMessages) {
        this.rejectMessages = rejectMessages;
    }
}
