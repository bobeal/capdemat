package fr.cg95.cvq.generator.common;

/**
 * @author jsb@zenexity.fr
 *
 */
public class CustomStep extends Step {

    private String name;
    private boolean required = true;

    public CustomStep(String index, String name, String required) {
        super(index);
        try {
            CommonStep.Ref.valueOf(name);
            throw new RuntimeException("Step() - attempt to use reserved name "
                 + name + " for a custom step");
        } catch (IllegalArgumentException e) {
            // OK, the name isn't reserved
        }
        this.name = name;
        if (required != null)
            this.required = Boolean.valueOf(required);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean isRequired() {
        return required;
    }
}
