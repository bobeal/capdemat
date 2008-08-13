package fr.cg95.cvq.service.importer;

import java.util.List;

import fr.cg95.cvq.exception.CvqException;

/**
 * The interface that all CSV importers plugins must implement.
 * 
 * @author Benoit Orihuela (bor@zenexity.fr)
 */
public interface ICsvImportProviderService {

    /**
     * Callback method called when the CSV parser service finished the parsing
     * of CSV data.
     */
    public void importData(List<Object> parsedLines) throws CvqException;

    /**
     * Return an unique friendly label used to identify the current importer provider.
     */
    public String getLabel();
    
    /**
     * Return the mapping definition data.
     */
    public byte[] getXmlMappingData();
    
    /**
     * Return the formatters configuration data.
     */
    public byte[] getFormatterConfigurationData();
}
