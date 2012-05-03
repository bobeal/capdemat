package fr.cg95.cvq.util.admin;

import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.HashSet;
import java.util.Set;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import au.com.bytecode.opencsv.CSVReader;
import fr.cg95.cvq.business.request.LocalReferentialEntry;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.exception.CvqLocalReferentialException;
import fr.cg95.cvq.security.SecurityContext;
import fr.cg95.cvq.service.authority.ILocalAuthorityRegistry;
import fr.cg95.cvq.service.authority.impl.LocalAuthorityRegistry;
import fr.cg95.cvq.service.request.ILocalReferentialService;
import fr.cg95.cvq.util.FileUtils;

public class LocalReferentialImporter {
    private static Logger logger = Logger.getLogger(LocalReferentialImporter.class);
    
    private static ILocalAuthorityRegistry localAuthorityRegistry;
    private static ILocalReferentialService localReferentialService;

    private static Set<String> authorizedLrTypeDataNames = new HashSet<String>();
    static {
        authorizedLrTypeDataNames.add("StudyGrantRequest/TaxHouseholdCity");
        authorizedLrTypeDataNames.add("StudyGrantRequest/CurrentSchoolName");
    }
    
    public void csvToLocalReferential(String csvFileName, String rtLabel, String lrtName) {
        String localAuthorityName = SecurityContext.getCurrentSite().getName();
        logger.info("local authority= " + localAuthorityName);
        logger.info("csv file= " + csvFileName);
        
        File csvFile = new File(csvFileName);
        if (!csvFile.exists()) {
            System.out.println(" ERROR - " + csvFileName + " does not exist");
            System.exit(0);
        }
        
        try {
            for (String entryKey : localReferentialService.getLocalReferentialType(rtLabel, lrtName).getEntriesKeys()) {
                localReferentialService.removeLocalReferentialEntry(rtLabel, lrtName, entryKey);
            }
            
            Reader csvFileReader = new StringReader(new String(FileUtils.getBytesFromFile(csvFile)));
            CSVReader csvReader = new CSVReader(csvFileReader,';','"',1);
            
            for (Object o : csvReader.readAll()) {
                String[] line = (String[])o;
                LocalReferentialEntry lrEntry = new LocalReferentialEntry();
                if (line.length == 2) { // line = {key, label}
                    logger.info(line[0] + " : " + line[1]);
                    localReferentialService.addLocalReferentialEntry(rtLabel, lrtName, null, line[0], line[1], null);
                } else { // line = {label}
                    logger.info(line[0]);
                    localReferentialService.addLocalReferentialEntry(rtLabel, lrtName, null, line[0], null);
                }
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (CvqLocalReferentialException cvqlre) {
            cvqlre.printStackTrace();
        } catch (CvqException cvqe) {
            cvqe.printStackTrace();
        }
        logger.info("Local referential import OK");
    }
    
    private static void parseDataName(String dataName, StringBuffer requestTypeLabel, StringBuffer lrtName) {
        String[] parts = dataName.split("/");
        if (parts.length != 2) {
            throw new IllegalArgumentException("Unable to parse the DATANAME");
        }
        logger.debug("DATANAME = " + parts[0] + " -> " + parts[1]);
        requestTypeLabel.append(parts[0]);
        lrtName.append(parts[1]);
    }
    
    public static void main(final String[] args) throws Exception {
        
        Logger rootLogger = Logger.getRootLogger();
        rootLogger.setLevel(Level.OFF);
        logger.setLevel(Level.INFO);
        
        if (args.length == 0 || args[0].equals("help") || args.length < 3){
            System.out.println(" USAGE - . ./invoke_localreferential_importer.sh [MODE] [CSV_FILE] [DATANAME]");
            System.out.println("  - [MODE] : One of {deployment | dev | help }");
            System.out.println("  - [CSV_FILE] : Csv file to import as local referential (separator=';' / quotechar='\"' / first line ignored)");
            System.out.println("                 If the file has two columns, the first one is used as key and the second as label.");
            System.out.println("                 Otherwise, the first column is used as label and the keys are generated.");
            System.out.println("  - [DATANAME] : LocalReferential data to update. One of");
            for(String dataName : authorizedLrTypeDataNames)
                System.out.println("     . " + dataName);
            System.exit(0);
        }
        
        String config = args[0];
        String csvFileName = args[1];
        
        if (!authorizedLrTypeDataNames.contains(args[2])) {
            System.out.println(" ERROR - args[2] must be one of : ");
            for(String dataName : authorizedLrTypeDataNames)
                System.out.println(" . " + dataName);
            System.exit(0);
        }
        
        StringBuffer rtLabel = new StringBuffer();
        StringBuffer lrtName = new StringBuffer();
        parseDataName(args[2], rtLabel, lrtName);
        
        ClassPathXmlApplicationContext cpxa = SpringApplicationContextLoader.loadContext(config);
        localAuthorityRegistry = (LocalAuthorityRegistry)cpxa.getBean("localAuthorityRegistry");
        localReferentialService = (ILocalReferentialService)cpxa.getBean("localReferentialService");
        
        LocalReferentialImporter lrImporter = new LocalReferentialImporter();
        localAuthorityRegistry.browseAndCallback(lrImporter, "csvToLocalReferential", new Object[]{csvFileName, rtLabel.toString(), lrtName.toString()});
    }
}
