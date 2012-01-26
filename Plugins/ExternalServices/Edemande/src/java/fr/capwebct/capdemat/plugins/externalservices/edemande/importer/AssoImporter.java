package fr.capwebct.capdemat.plugins.externalservices.edemande.importer;

import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.CSVWriter;
import fr.cg95.cvq.business.users.Address;
import fr.cg95.cvq.business.users.Adult;
import fr.cg95.cvq.business.users.TitleType;
import fr.cg95.cvq.dao.jpa.JpaUtil;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.security.SecurityContext;
import fr.cg95.cvq.service.authority.ILocalAuthorityRegistry;
import fr.cg95.cvq.service.authority.impl.LocalAuthorityRegistry;
import fr.cg95.cvq.service.users.IUserWorkflowService;
import fr.cg95.cvq.util.FileUtils;
import fr.cg95.cvq.util.admin.SpringApplicationContextLoader;
import fr.cg95.cvq.util.mail.IMailService;

public class AssoImporter {

    private static Logger logger = Logger.getLogger(AssoImporter.class);
    private static ILocalAuthorityRegistry localAuthorityRegistry;
    private static IUserWorkflowService userWorkflowService;
    private static IMailService mailService;

    public static void main(String[] args) throws CvqException {
        ClassPathXmlApplicationContext cpxa = SpringApplicationContextLoader.loadContext(null);
        AssoImporter assoImporter = new AssoImporter();

        if (args.length == 0 || args[0].equals("help") || args.length < 3){
            assoImporter.getAssoImportUsage();
        }

        String localAuthorityName = args[1];
        String path = args[2];

        System.out.println("Start script process...");

        localAuthorityRegistry = (LocalAuthorityRegistry) cpxa.getBean("localAuthorityRegistry");
        userWorkflowService = (IUserWorkflowService) cpxa.getBean("userWorkflowService");
        mailService = (IMailService) cpxa.getBean("mailService");

        localAuthorityRegistry.callback(localAuthorityName, assoImporter, "importAssoFile",
                new Object[]{path, localAuthorityName});

        System.out.println("End script process.");
        System.exit(0);
    }

    public void importAssoFile(String path, String localAuthName) throws CvqException {
        File csvFile = new File(path);
        if (!csvFile.exists()) {
            logger.error("The path file or folder is bad. Give an absolute path to be sure it is correct.");
            return;
        }

        Writer errorsDetails = new StringWriter();
        CSVWriter csvErrorsDetails = new CSVWriter(errorsDetails);
        Writer importDetails = new StringWriter();
        CSVWriter csvImportDetails = new CSVWriter(importDetails);
        int errorsNumber = 0;

        try {
            Reader csvFileReader = new StringReader(new String(FileUtils.getBytesFromFile(csvFile)));
            CSVReader csvReader = new CSVReader(csvFileReader);
            int lineNumber = 0;
            for (String[] line : csvReader.readAll()) {
                lineNumber++;
                if (lineNumber == 1) continue;
                try {
                    logger.info("Processing line " + lineNumber);
                    Address address = new Address();
                    address.setCity(line[13]);
                    address.setPostalCode(line[12]);
                    String [] street = splitAddressStreetName(line[9]);
                    if (street != null && street.length > 1) {
                        address.setStreetNumber(street[0]);
                        address.setStreetName(street[1]);
                    } else {
                        address.setStreetName(line[9]);
                    }
                    address.setAdditionalDeliveryInformation(line[10]);
                    Adult adult = new Adult();
                    adult.setAddress(address);
                    adult.setProfession(line[1]);
                    adult.setLastName(line[2]);
                    adult.setFirstName(line[3]);
                    adult.setPassword(line[6]);
                    adult.setEmail(line[16]);
                    if ("Madame".equals(line[8])) {
                        adult.setTitle(TitleType.MADAM);
                    } else if ("Mademoiselle".equals(line[8])) {
                        adult.setTitle(TitleType.MISS);
                    } else if ("Monsieur".equals(line[8])) {
                        adult.setTitle(TitleType.MISTER);
                    }
                    String phoneNumber = line[14].trim().replaceAll("\\.", "");
                    if (phoneNumber.startsWith("06") || phoneNumber.startsWith("07")) {
                        adult.setMobilePhone(phoneNumber);
                    } else {
                        adult.setHomePhone(phoneNumber);
                    }
                    userWorkflowService.create(adult, false);
                    String [] record = { adult.getProfession(), adult.getLogin(), adult.getEmail()};
                    csvImportDetails.writeNext(record);
                    JpaUtil.getEntityManager().flush();
                } catch (Exception e) {
                    logger.error("Import error at line " + lineNumber, e);
                    e.printStackTrace();
                    csvErrorsDetails.writeNext(line);
                    errorsNumber++;
                }
            }

            Map<String, byte[]> attachments = new HashMap<String, byte[]>();
            attachments.put("Detail_Import_Associations_"+localAuthName+".csv",
                    importDetails.toString().getBytes());
            if (errorsNumber > 0) {
                attachments.put("Erreurs_Associations_"+localAuthName+".csv",
                        errorsDetails.toString().getBytes());
            }

            StringBuffer body = new StringBuffer();
            body.append("Bonjour, ").append("\n\n")
                .append("Veuillez trouver ci-joint le détail de l'import des associations.")
                .append("\n\n\n")
                .append("Cordialement");

            mailService.send(null, SecurityContext.getCurrentSite().getAdminEmail(),
                    new String[] {"capdemat-dev@zenexity.com"},
                    "Compte rendu de l'import des associations, " + localAuthName, body.toString(),
                    attachments);

        } catch (IOException ioe) {
            logger.error("Import csv file error.", ioe);
        }
    }

    public void getAssoImportUsage() throws CvqException {
        System.out.println(" USAGE - . ./invoke_asso_importer.sh [MODE] [LOCAL_AUTHORITY_NAME] [PATH_FOLDER/FILE]");
        System.out.println("  - [MODE] : One of {deployment | dev | help }");
        System.out.println("  - [LOCAL_AUTHORITY_NAME] : the local authority name.");
        for(String localAuthorityName : localAuthorityRegistry.getAllLocalAuthoritiesNames())
            System.out.println("     . " + localAuthorityName);
        System.out.println("  - [PATH_FOLDER/FILE] : path folder or file wich must to be process.");
        System.exit(0);
    }

    private String[] splitAddressStreetName(String streetInfo) {
        if (streetInfo == null)
            return null;
        Pattern pattern = Pattern.compile("(\\d{1,5}/?\\d{0,5})(.*)");
        Matcher matcher = pattern.matcher(streetInfo);

        if (matcher.find()) {
            String streetNumber = matcher.group(1);
            String streetName = matcher.group(2).trim();
            if (streetNumber.length() < 5) {
                pattern = Pattern.compile("(^BIS\\b)(.*)", Pattern.CASE_INSENSITIVE);
                matcher = pattern.matcher(streetName);
                if (matcher.find()) {
                    streetNumber = streetNumber + "B";
                    streetName = matcher.group(2);
                }
                pattern = Pattern.compile("(^B\\b)(.*)", Pattern.CASE_INSENSITIVE);
                matcher = pattern.matcher(streetName);
                if (matcher.find()) {
                    streetNumber = streetNumber + "B";
                    streetName = matcher.group(2);
                }
                pattern = Pattern.compile("(^TER\\b)(.*)", Pattern.CASE_INSENSITIVE);
                matcher = pattern.matcher(streetName);
                if (matcher.find()) {
                    streetNumber = streetNumber + "T";
                    streetName = matcher.group(2);
                }
            }
            return (new String[]{streetNumber, streetName});
        }
        return null;
    }
}
