/**
 * 
 */
package fr.cg95.cvq.util.admin;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import fr.cg95.cvq.business.request.school.OtherIndividual;
import fr.cg95.cvq.business.users.Address;
import fr.cg95.cvq.dao.IGenericDAO;
import fr.cg95.cvq.dao.hibernate.GenericDAO;
import fr.cg95.cvq.dao.hibernate.HibernateUtil;
import fr.cg95.cvq.security.SecurityContext;
import fr.cg95.cvq.service.authority.impl.LocalAuthorityRegistry;

/**
 * @author jsb@zenexity.fr
 *
 */
public class AddressBeanCreator {

    private LocalAuthorityRegistry localAuthorityRegistry;
    private CustomDAO customDAO;
    private String forbiddenCharacters = "[\\s,;]";
    private Pattern streetNumberPattern = Pattern.compile("(\\d{1,5})(.*)");
    private Pattern otherFieldsPattern = Pattern.compile("(.*?)?((\\d{5})(.*?))?");

    public static void main(String[] args) {
        ClassPathXmlApplicationContext cpxa = SpringApplicationContaxtLoader.loadContext(null);
        AddressBeanCreator addressBeanCreator = new AddressBeanCreator();
        addressBeanCreator.localAuthorityRegistry = (LocalAuthorityRegistry)cpxa.getBean("localAuthorityRegistry");
        addressBeanCreator.customDAO = new CustomDAO();
        addressBeanCreator.localAuthorityRegistry.browseAndCallback(addressBeanCreator, "createAddressBeans", null);
    }

    public void createAddressBeans() {
        String localAuthorityName = SecurityContext.getCurrentSite().getName();
        System.out.println("OtherIndividual addresses' migration for : " + localAuthorityName);
        System.out.println();
        Map<Long, String> errors = new HashMap<Long, String>();
        for (OtherIndividual o : customDAO.listAll()) {
            System.out.println("\tdealing with address " + o.getAddress());
            if (o.getAddress() != null) {
                Address address = parseAddress(o.getAddress());
                if (address != null) {
                    System.out.println("\tgenerated address bean : " + address);
                    customDAO.saveOrUpdate(address);
                    o.setAddress(address.getId().toString());
                    customDAO.saveOrUpdate(o);
                } else {
                    errors.put(o.getId(), o.getAddress());
                }
            }
            System.out.println();
        }
        try {
            File file = 
                File.createTempFile(localAuthorityName + "_otherindividual_ambiguous_addresses_", ".txt");
            FileOutputStream fos = new FileOutputStream(file);
            for (Long id : errors.keySet()) {
                fos.write((id + " : " + errors.get(id) + "\n").getBytes());
            }
        } catch(IOException ioe){
            ioe.printStackTrace();
        }
    }

    private Address parseAddress(String source) {
        System.out.println("\t\tParsing string : " + source);
        source = source.replaceAll(forbiddenCharacters, " ").trim();
        System.out.println("\t\tSanitized string : " + source);
        String tempStreetNumber = null;
        Matcher streetNumberMatcher = streetNumberPattern.matcher(source);
        if (streetNumberMatcher.matches()) {
            tempStreetNumber = streetNumberMatcher.group(1);
            System.out.println("\t\tExtracting street number : " + tempStreetNumber);
            source = streetNumberMatcher.group(2).trim();
            System.out.println("\t\tRemainging source : " + source);
        }
        Matcher otherFieldsMatcher = otherFieldsPattern.matcher(source);
        if (otherFieldsMatcher.matches()) {
            System.out.println("\t\tSource matches our pattern");
            Address address = new Address();
            address.setStreetNumber(tempStreetNumber);
            if (otherFieldsMatcher.group(1) != null) {
                address.setStreetName(otherFieldsMatcher.group(1).trim());
            }
            if (otherFieldsMatcher.group(3) != null) {
                address.setPostalCode(otherFieldsMatcher.group(3).trim());
            }
            if (otherFieldsMatcher.group(4) != null) {
                address.setCity(otherFieldsMatcher.group(4).trim());
            }
            return address;
        }
        if ((tempStreetNumber + " " + source).trim().length() < 115) {
            System.out.println("\t\tSource doesn't match our pattern but is small enough, we put it in street name");
            Address address = new Address();
            address.setStreetName((tempStreetNumber + " " + source).trim());
            return address;
        }
        System.out.println("\t\tCouldn't handle address !");
        return null;
    }

    private static class CustomDAO extends GenericDAO implements IGenericDAO {
        @SuppressWarnings("unchecked")
        public List<OtherIndividual> listAll() {
            return (List<OtherIndividual>)HibernateUtil.getSession().createCriteria(OtherIndividual.class).list();
        }
    }
}
