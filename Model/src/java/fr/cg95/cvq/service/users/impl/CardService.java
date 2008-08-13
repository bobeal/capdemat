package fr.cg95.cvq.service.users.impl;

import java.util.Date;

import org.apache.log4j.Logger;

import fr.cg95.cvq.business.users.Card;
import fr.cg95.cvq.business.users.CardState;
import fr.cg95.cvq.business.users.Individual;
import fr.cg95.cvq.dao.IGenericDAO;
import fr.cg95.cvq.dao.users.IIndividualDAO;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.exception.CvqObjectAlreadyExistsException;
import fr.cg95.cvq.exception.CvqObjectNotFoundException;
import fr.cg95.cvq.service.users.ICardService;

/**
 * This class provides Card related business logic and
 * services to other layers.
 *
 * @author bor@zenexity.fr
 *
 */
public class CardService implements ICardService {

    static Logger logger = Logger.getLogger(CardService.class);

    protected IGenericDAO iDAO;
    protected IIndividualDAO iIndividualDAO;

    public CardService() {
        super();
    }

    public Card getById(final Long id)
        throws CvqException, CvqObjectNotFoundException {
        return (Card) iDAO.findById(Card.class, id);
    }

    public Long create(final Card card,
                       final Long individualId)
        throws CvqException, CvqObjectNotFoundException,
               CvqObjectAlreadyExistsException {

        if (card == null)
            throw new CvqException("No card object provided");
        if (individualId == null)
            throw new CvqException("No individual id provided");

        Individual individual = null;
        individual = (Individual) iIndividualDAO.findById(Individual.class, individualId);    

        if (individual.getCard() != null)
            throw new CvqObjectAlreadyExistsException("Provided individual already has a card associated to its record !");

        card.setCardState(CardState.ACTIVE);
        card.setCardDeliveryDate(new Date());
        individual.setCard(card);
        iDAO.create(card);
            
        logger.debug("Created card object with id : " + card.getId());

        return card.getId();
    }

    public void modify(final Card card)
        throws CvqException {

        if (card == null)
            throw new CvqException("No card object provided");

        iDAO.update(card);
        
    }

    public void setDAO(IGenericDAO iDAO) {
        this.iDAO = iDAO;
    }

    public void setIndividualDAO(IIndividualDAO iDAO) {
        this.iIndividualDAO = iDAO;
    }
}

