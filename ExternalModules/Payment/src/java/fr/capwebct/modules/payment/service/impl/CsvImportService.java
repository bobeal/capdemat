package fr.capwebct.modules.payment.service.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import net.sf.anupam.csv.CSVParser;
import net.sf.anupam.csv.CSVParserFactory;
import net.sf.anupam.csv.exceptions.CSVOException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.io.Resource;

import fr.capwebct.modules.payment.business.ExternalDataType;
import fr.capwebct.modules.payment.exception.CpmParsingException;
import fr.capwebct.modules.payment.service.ICsvImportService;

public class CsvImportService implements ICsvImportService, ApplicationContextAware {

    private static Log log = LogFactory.getLog(CsvImportService.class);

    private Map<String, Map<String, Map<String, File>>> importers =
        new HashMap<String, Map<String, Map<String, File>>>();
    
    private Map<String, Map<String, String>> accountsImporters;
    private Map<String, Map<String, String>> invoicesImporters;    
    private Map<String, Map<String, String>> contractsImporters;    
    private Map<String, Map<String, String>> invoiceDetailsImporters;    
    private Map<String, Map<String, String>> accountDetailsImporters;    
    private Map<String, Map<String, String>> externalFamilyAccountsImporters;    

    private ApplicationContext applicationContext;
    
    public void init() {    
        parseImporter(ExternalDataType.ACCOUNT.getKey(), accountsImporters);
        parseImporter(ExternalDataType.INVOICE.getKey(), invoicesImporters);
        parseImporter(ExternalDataType.CONTRACT.getKey(), contractsImporters);
        parseImporter(ExternalDataType.INVOICE_DETAIL.getKey(), invoiceDetailsImporters);
        parseImporter(ExternalDataType.ACCOUNT_DETAIL.getKey(), accountDetailsImporters);
        parseImporter(ExternalDataType.EXTERNAL_FAMILY_ACCOUNT.getKey(), 
                externalFamilyAccountsImporters);
    }
    
    private void parseImporter(final String dataType, final Map<String, Map<String, String>> importer) {
        
        if (importer == null)
            return;
        
        Set<String> importTypesSet = importer.keySet();
        for (String importType : importTypesSet) {
            Map<String, String> importTypeData = importer.get(importType);
            Map<String, File> dataTypeConfiguration = new HashMap<String, File>();
            try {
                String mappingConfiguration = importTypeData.get("mapping");
                Resource mappingResource = applicationContext.getResource(mappingConfiguration);
                if (!mappingResource.exists()) {
                    throw new RuntimeException("Mapping file " + mappingConfiguration + " not found");
                }
                dataTypeConfiguration.put("mapping", mappingResource.getFile());
                String formatterConfiguration = importTypeData.get("formatter");
                Resource formatterResource = applicationContext.getResource(formatterConfiguration);
                dataTypeConfiguration.put("formatter", formatterResource.getFile());
            } catch (FileNotFoundException fnfe) {
                throw new RuntimeException("File not found : " + fnfe.getMessage());            
            } catch (IOException ioe) {
                throw new RuntimeException("IO Exception : "  + ioe.getMessage());
            }
            
            Map<String, Map<String, File>> importTypeMap =
                new HashMap<String, Map<String, File>>();
            importTypeMap.put(dataType, dataTypeConfiguration);
            
            if (importers.get(importType) != null) {
                Map<String, Map<String, File>> currentImportTypeData = importers.get(importType);
                if (currentImportTypeData.get(dataType) != null)
                    throw new RuntimeException("Duplicate data type " + dataType 
                            + " for import type " + importType);
                currentImportTypeData.putAll(importTypeMap);
            } else {
                importers.put(importType, importTypeMap);
            }
        }
    }
    
    public List<Object> parseData(final String importType, final ExternalDataType dataType, 
            final byte[] data) 
        throws CpmParsingException {

        Map<String, File> dataMap = importers.get(importType).get(dataType.toString());

        List<Object> parsedObjects = new ArrayList<Object>();
        try {
            FileReader xmlMappingReader = new FileReader(dataMap.get("mapping"));
            FileReader formatterConfigurationReader = new FileReader(dataMap.get("formatter"));
            final CSVParserFactory factory = 
                new CSVParserFactory(xmlMappingReader, formatterConfigurationReader);
            StringReader csvReader = new StringReader(new String(data));
            final CSVParser parser = 
                factory.getCSVParser(dataType.toString() + "-" + importType, csvReader);
            for (Object bean : parser) {
                parsedObjects.add(bean);
            }
            parser.close();

        } catch (CSVOException ce) {
            ce.printStackTrace();
            log.error("CSVO exception : " + ce.getLocalizedMessage());
            throw new CpmParsingException(ce.getLocalizedMessage());
        } catch (Exception e) {
            e.printStackTrace();
            log.error("Exception : " + e.getLocalizedMessage());
            throw new CpmParsingException(e.getLocalizedMessage());            
        }

        return parsedObjects;
    }

    public void setAccountsImporters(Map<String, Map<String, String>> accountsImporters) {
        this.accountsImporters = accountsImporters;
    }

    public void setInvoicesImporters(Map<String, Map<String, String>> invoicesImporters) {
        this.invoicesImporters = invoicesImporters;
    }

    public void setContractsImporters(Map<String, Map<String, String>> contractsImporters) {
        this.contractsImporters = contractsImporters;
    }

    public void setInvoiceDetailsImporters(Map<String, Map<String, String>> invoiceDetailsImporters) {
        this.invoiceDetailsImporters = invoiceDetailsImporters;
    }

    public void setAccountDetailsImporters(Map<String, Map<String, String>> accountDetailsImporters) {
        this.accountDetailsImporters = accountDetailsImporters;
    }

    public void setExternalFamilyAccountsImporters(Map<String, Map<String, String>> externalFamilyAccountsImporters) {
        this.externalFamilyAccountsImporters = externalFamilyAccountsImporters;
    }

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
