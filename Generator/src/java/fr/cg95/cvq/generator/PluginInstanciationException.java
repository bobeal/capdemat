package fr.cg95.cvq.generator;

/**
 * Exception class used to wrap exceptions while loading a generator plugin
 * 
 * @author bor@zenexity.fr
 */
public class PluginInstanciationException extends Exception {

    private static final long serialVersionUID = 1L;

    public PluginInstanciationException() {
        super();
    }

    public PluginInstanciationException(String reason) {
        super(reason);
    }
}
