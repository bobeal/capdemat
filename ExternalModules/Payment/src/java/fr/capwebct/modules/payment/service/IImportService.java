package fr.capwebct.modules.payment.service;

import fr.capwebct.modules.payment.business.ExternalDataType;
import fr.capwebct.modules.payment.exception.CpmBusinessException;

/**
 * A service dedicated to the import of data from external sources.
 * 
 * @author Benoit Orihuela (bor@zenexity.fr)
 */
public interface IImportService {

    /**
     * Import data from an external source.
     * 
     * @param importType the type of import (CSV, XML, ...), currently unused (only CSV is supported) 
     * @param externalApplicationLabel the label of the external application from whom data is exported
     * @param broker the broker associated to the items to be imported
     * @param externalDataType the type of external data
     * @param data the data to import
     * @param detailsData (optional) details file for imported data 
     */
    ImportResultBean importExternalData(final String importType, 
            final long externalApplicationId, String broker, 
            final ExternalDataType externalDataType, final byte[] data, final byte[] detailsData)
        throws CpmBusinessException;
}
