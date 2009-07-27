package fr.capwebct.modules.payment.service;

import java.util.List;
import java.util.Set;

import fr.capwebct.modules.payment.business.ExternalApplication;
import fr.capwebct.modules.payment.exception.CpmBusinessException;

public interface IExternalApplicationService {

    /**
     * Get an external application by its id.
     */
    ExternalApplication getById(final long id);
    
    /**
     * Get all known external applications.
     */
    List<ExternalApplication> getAll();

    /**
     * Create a new external application.
     * 
     * @throws CpmBusinessException if an external application with the same label already exists.
     */
    ExternalApplication create(final String label, final String description, 
            final Set<String> brokers) throws CpmBusinessException;

    /**
     * Create a new external application.
     * 
     * @throws CpmBusinessException if an external application with the same label already exists.
     */
    void create(ExternalApplication externalApplication) throws CpmBusinessException;
    
    /**
     * Update an external application's label and description.
     * 
     * @throws CpmBusinessException if an external application with the same label already exists.
     */
    void update(final long id, final String newLabel, final String newDescription,
            final Set<String> newBrokers) throws CpmBusinessException;
    
    /**
     * Remove an external application and its associated brokers.
     */
    void delete(final long id);
    
    /**
     * Add a broker to the given external application.
     */
    void addBroker(final long externalApplicationId, final String broker);
    
    /**
     * Remove a broker from the given external application.
     */
    void removeBroker(final long externalApplicationId, final String broker);

    /**
     * Get the list of all known brokers.
     */
    List<String> getAllBrokers();
}
