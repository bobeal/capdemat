package fr.cg95.cvq.service.importer;

import fr.cg95.cvq.exception.CvqException;

/**
 * Service used to parse CSV exported data.
 * 
 * @author Benoit Orihuela (bor@zenexity.fr)
 */
public interface ICsvParserService {

    final String SERVICE_NAME = "csvParserService";
    
    /**
     * Parse CSV data according to provided CSV importer and data.
     */
    void parseData(String importerName, byte[] csvData)
        throws CvqException;
}
