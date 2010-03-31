package fr.cg95.cvq.service.importer.impl;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.anupam.csv.CSVParser;
import net.sf.anupam.csv.CSVParserFactory;
import net.sf.anupam.csv.exceptions.CSVOException;

import org.apache.log4j.Logger;

import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.security.annotation.Context;
import fr.cg95.cvq.security.annotation.ContextPrivilege;
import fr.cg95.cvq.security.annotation.ContextType;
import fr.cg95.cvq.service.importer.ICsvImportProviderService;
import fr.cg95.cvq.service.importer.ICsvParserService;

/**
 * Implementation of the {@link ICsvParserService} service.
 * 
 * @author Benoit Orihuela (bor@zenexity.fr)
 */
public class CsvParserService implements ICsvParserService {

    private static Logger logger = Logger.getLogger(CsvParserService.class);

    private Map<String, ICsvImportProviderService> registeredImporters 
        = new HashMap<String, ICsvImportProviderService>();

    @Override
    @Context(types = {ContextType.ADMIN}, privilege = ContextPrivilege.NONE)
    public void parseData(String importerName, byte[] csvData) 
        throws CvqException {

        ICsvImportProviderService csvImportProviderService =
            registeredImporters.get(importerName);
        if (csvImportProviderService == null) {
            logger.error("parseData() no importer called " + importerName
                + " found !");
            throw new CvqException("parseData() no importer called "
                + importerName + " found !");
        } else {
            logger.debug("parseData() found importer " + importerName);
        }

        List<Object> parsedObjects = new ArrayList<Object>();

        try {
            StringReader xmlMappingReader = 
            	new StringReader(new String(csvImportProviderService.getXmlMappingData()));
            StringReader formatterConfigurationReader = null;
            if (csvImportProviderService.getFormatterConfigurationData() != null)
                formatterConfigurationReader = 
                    new StringReader(new String(csvImportProviderService.getFormatterConfigurationData()));
            final CSVParserFactory factory = 
            	new CSVParserFactory(xmlMappingReader, formatterConfigurationReader);
            StringReader csvReader = new StringReader(new String(csvData));
            final CSVParser parser = factory.getCSVParser(importerName, csvReader);
            for (Object bean : parser) {
                parsedObjects.add(bean);
            }
            parser.close();
            
        } catch (CSVOException ce) {
            logger.error("CSVO exception : " + ce.getLocalizedMessage());
            throw new CvqException("CSVO exception : "
                + ce.getLocalizedMessage());
        }
        
        csvImportProviderService.importData(parsedObjects);
    }

    /**
     * Set the importers that will be available on current instance.
     */
    public void setImporters(List<Object> importers) {
        for (Object o : importers) {
            if (o instanceof ICsvImportProviderService) {
                ICsvImportProviderService csvImportProviderService = 
                    (ICsvImportProviderService) o;
                this.registeredImporters.put(csvImportProviderService.getLabel(), 
                        csvImportProviderService);
                logger.debug("CSV plugin " + csvImportProviderService.getLabel() + " added");
            } else {
                logger.error("Wrong object added to importers property " + o);
            }
        }
    }
}
