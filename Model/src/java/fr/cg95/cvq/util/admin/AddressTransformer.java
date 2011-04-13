package fr.cg95.cvq.util.admin;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import fr.cg95.cvq.business.users.Address;
import fr.cg95.cvq.dao.jpa.GenericDAO;
import fr.cg95.cvq.dao.jpa.IGenericDAO;
import fr.cg95.cvq.dao.jpa.JpaTemplate;
import fr.cg95.cvq.dao.hibernate.HibernateUtil;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.security.SecurityContext;
import fr.cg95.cvq.service.authority.ILocalAuthorityRegistry;
import fr.cg95.cvq.service.authority.impl.LocalAuthorityRegistry;

public class AddressTransformer {
    private static Logger logger = Logger.getLogger(AddressTransformer.class);
    private static ILocalAuthorityRegistry localAuthorityRegistry;
    private static IGenericDAO genericDAO;

    public AddressTransformer() {
    }
    
    /* Split StreetName (ax Address) field into StreetNumber 
     * and StreetName.
     */
    private String[] splitAddressStreetName(String streetInfo){
        if (streetInfo == null)
            return null;
        Pattern pattern = Pattern.compile("(\\d{1,5}/?\\d{0,5})(.*)");
        Matcher matcher = pattern.matcher(streetInfo);
//        if (matcher.find()) {
//            String streetNumber = matcher.group(1);
//            if (streetNumber.length() > 5) {
//                pattern = Pattern.compile("(\\d{1,5})(.*)");
//                matcher = pattern.matcher(streetInfo);
//            } else {
//                matcher.reset();
//            }
//        }
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
    
    /* Generate an update instruction if :
     * - StreetName is greater than 32
     * - StreetName contents "/ " char 
     */
    private StringBuffer generateBigStreetNameUpdate(Address address) {
        if (address.getStreetName() != null)
            if ((address.getStreetName().length() > 32)
                    || (address.getStreetName().contains("/"))){
                String streetNumber = "" ;
                if (address.getStreetNumber() != null)
                    streetNumber = address.getStreetNumber();
                String streetName = address.getStreetName();
                
                StringBuffer sb = new StringBuffer("UPDATE address SET ")
                        .append("street_number='").append(streetNumber).append("', ")
                        .append("street_name='").append(streetName).append("' ")
                        .append("WHERE id=").append(address.getId()).append(";"); 
                return sb;
            }
        return null;
    }
    
    /* Format StreetName Field
     * Delete all ponctuation mark from StreetName
     */
    private void formatAddressField(Address address){
        if (address.getStreetName() != null) {
//            address.setStreetName(address.getStreetName().replace(',', ' '));
//            address.setStreetName(address.getStreetName().replace(';', ' '));
            address.setStreetName(address.getStreetName().replace('\r', ' '));
            address.setStreetName(address.getStreetName().replace('\n', ' '));
//            address.setStreetName(address.getStreetName().replace('\'', ' '));
//            address.setStreetName(address.getStreetName().replace('"', ' '));
//            address.setStreetName(address.getStreetName().replace('-', ' '));
//            address.setStreetName(address.getStreetName().replace('.', ' '));
//            address.setStreetName(address.getStreetName().replace('!', ' '));
//            address.setStreetName(address.getStreetName().replace('?', ' '));
//            address.setStreetName(address.getStreetName().replace('_', ' '));
            address.setStreetName(address.getStreetName().replace("  ", " "));
            address.setStreetName(address.getStreetName().replace("  ", " "));

//            address.setStreetName(address.getStreetName().trim().toUpperCase());
        }
//        if (address.getStreetNumber() != null)
//            address.setStreetNumber(address.getStreetNumber().trim().toUpperCase());
    }
    
    /* Apply address normalization rules to all local authority's address
     */
    public void normalizeAddress() throws CvqException {
        // Display current Local Authority
        String localAuthorityName = SecurityContext.getCurrentSite().getName();
        System.out.println("Address's migration for : " + localAuthorityName);
        
        StringBuffer updateScriptStringBuffer = 
            new StringBuffer("-- ADDRESS NORMALIZATION : AMBIGUOUS CASES").append("\n\n");
        
        List addressList = AddressDAO.listAll();
        int size = addressList.size();
        int i = 0;
        for (Object it : addressList) {
            Address address = (Address)it;
            String[] streetInfo = splitAddressStreetName(address.getStreetName());
            if (streetInfo != null) {
                address.setStreetNumber(streetInfo[0]);
                address.setStreetName(streetInfo[1]);
            }
            formatAddressField(address);
            StringBuffer sb = generateBigStreetNameUpdate(address);
            if (sb != null)
                updateScriptStringBuffer.append(sb).append("\n");
            genericDAO.update(address);
            
            i++;
            if ((size - i ) % 20 == 0)
                System.out.print(".");
        }
        System.out.println();
        
        try {
            // Generate an sql update script for ambiguous addresses
            File xmlFile = 
                File.createTempFile(localAuthorityName + "_address_ambiguous_", ".sql");
            FileOutputStream xmlFos = new FileOutputStream(xmlFile);
            xmlFos.write(updateScriptStringBuffer.toString().getBytes());
        } catch(IOException ioe){
            throw new CvqException(ioe.getMessage());
        }
    }
    
    public static void main(final String[] args) throws Exception {
        String config = args[0];
//        String localAuthoriy = args[1];
        
        // Switch Off logs for localAuthorityRegistry
        Logger loggerLAR = Logger.getLogger(LocalAuthorityRegistry.class);
        loggerLAR.setLevel(Level.OFF);
        // Switch Off logs for this
        logger.setLevel(Level.DEBUG);
        
        ClassPathXmlApplicationContext cpxa = SpringApplicationContextLoader.loadContext(config);
        
        localAuthorityRegistry = (LocalAuthorityRegistry)cpxa.getBean("localAuthorityRegistry");
        genericDAO = (GenericDAO)cpxa.getBean("genericDAO");
        
        AddressTransformer addressTransformer = new AddressTransformer();
        localAuthorityRegistry.browseAndCallback(addressTransformer, "normalizeAddress", null);
    }
    
    /*
     * private Address DAO
     */
    private static class AddressDAO extends JpaTemplate<Address, Long>{
        public static List listAll(){
            return HibernateUtil.getSession().createQuery("from Address order by id").list();
        }
    }
}
