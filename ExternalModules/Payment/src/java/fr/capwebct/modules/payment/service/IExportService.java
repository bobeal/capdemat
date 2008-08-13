package fr.capwebct.modules.payment.service;

import fr.capwebct.modules.payment.exception.CpmBusinessException;

/**
 * Interface that has to be implemented by export services.
 * 
 * @author Benoit Orihuela (bor@zenexity.fr)
 */
public interface IExportService {

    void exportPayments() throws CpmBusinessException;
}
