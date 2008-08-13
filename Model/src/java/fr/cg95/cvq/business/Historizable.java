package fr.cg95.cvq.business;

/**
 * Marker interface for objects interested in automatic historization.
 * 
 * Currently only applies in the context of an home folder modification request but
 * can be extended to other usages.
 * 
 * @author bor@zenexity.fr
 *
 */
public interface Historizable {
    public Long getId();
}
