package fr.cg95.cvq.dao.users;

import java.util.List;
import java.util.Set;

import fr.cg95.cvq.business.users.ActorState;
import fr.cg95.cvq.business.users.Individual;
import fr.cg95.cvq.dao.IGenericDAO;

/**
 * @author bor@zenexity.fr
 */
public interface IIndividualDAO extends IGenericDAO {

    /**
     * Look up an Individual by its login.
     *
     * @return the sole individual if found or none else
     */
    Individual findByLogin(final String login);

    /**
     * Look up an Individual by its certificate stored on the card.
     *
     * @return the sole individual if found or none else
     */
    Individual findByCertificate(final String certificate);

    /**
     * Look up an Individual by its public key.
     *
     * @return the sole individual if found or none else
     */
    Individual findByPublicKey(final String publicKey);

    /**
     * Look up an Individual by its Liberty Alliance federation key.
     *
     * @return the sole individual if found or none else
     */
    Individual findByFederationKey(final String federationKey);

    /**
     * Look up an Individual given a set of search criteria.
     */
    List search(final Set criteria, final String orderedBy, final boolean onlyIds,
            final ActorState[] excludedStates);

    /**
     * List the children whose given individual is responsible of.
     */
    List listClrs(final Individual individual);

    /**
     * Return the list of individual logins that start with the given
     * base login.
     */
    List getSimilarLogins(final String baseLogin);
}
