package fr.cg95.cvq.service.users;

import fr.cg95.cvq.business.users.Card;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.exception.CvqObjectAlreadyExistsException;
import fr.cg95.cvq.exception.CvqObjectNotFoundException;

/**
 * @author bor@zenexity.fr
 *
 */
public interface ICardService {

    /** service name used by Spring's application context */
    public final String SERVICE_NAME = "cardService";

    /**
     * Create a card (typically a Cartevaloise one but can be of another type)
     * associated to the given individual
     *
     * @param card a transient card object pre-filled with needed information
     * @param individualId the individual for whom the card is
     *
     * @throws CvqObjectNotFoundException if individualId does not match an individual
     *         in the database
     * @throws CvqObjectAlreadyExistsException if the given individual already has
     *         a card object associated
     */
    public abstract Long create(final Card card,
                                final Long individualId)
        throws CvqException, CvqObjectNotFoundException,
               CvqObjectAlreadyExistsException;

    public abstract void modify(final Card card)
        throws CvqException;
   
    /**
     * Get a card by id
     */
    public abstract Card getById(final Long id)
        throws CvqException, CvqObjectNotFoundException;
}
