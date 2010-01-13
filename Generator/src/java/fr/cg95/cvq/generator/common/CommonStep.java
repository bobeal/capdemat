package fr.cg95.cvq.generator.common;

/**
 * @author jsb@zenexity.fr
 *
 */
public class CommonStep extends Step {

    public enum Ref {
        document(false),
        validation(true);
        private boolean required;
        private Ref(boolean required) { this.required = required; }
        public boolean isRequired() { return required; }
    }

    private Ref ref;

    public CommonStep(String index, String ref) {
        super(index);
        this.ref = Ref.valueOf(ref);
    }

    @Override
    public String getName() {
        return ref.toString();
    }

    @Override
    public boolean isRequired() {
        return ref.isRequired();
    }
}
