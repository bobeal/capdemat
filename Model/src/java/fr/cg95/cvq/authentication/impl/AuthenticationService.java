package fr.cg95.cvq.authentication.impl;

import java.security.MessageDigest;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Random;
import java.util.TreeSet;
import java.util.Vector;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import fr.cg95.cvq.authentication.IAuthenticationService;
import fr.cg95.cvq.business.users.UserState;
import fr.cg95.cvq.business.users.Adult;
import fr.cg95.cvq.business.users.HomeFolder;
import fr.cg95.cvq.dao.users.IAdultDAO;
import fr.cg95.cvq.dao.users.IIndividualDAO;
import fr.cg95.cvq.exception.CvqAuthenticationFailedException;
import fr.cg95.cvq.exception.CvqDisabledAccountException;
import fr.cg95.cvq.exception.CvqModelException;
import fr.cg95.cvq.exception.CvqUnknownUserException;
import fr.cg95.cvq.security.annotation.Context;
import fr.cg95.cvq.security.annotation.ContextPrivilege;
import fr.cg95.cvq.security.annotation.ContextType;

/**
 * Implementation of the {@link IAuthenticationService authentication service}.
 *
 * @author bor@zenexity.fr
 */
public class AuthenticationService implements IAuthenticationService {

    static Logger logger = Logger.getLogger(AuthenticationService.class);

    private IIndividualDAO individualDAO;

    private IAdultDAO adultDAO;

    private static String[] alph = {
        "A","B","C","D","E","F","G","H","I","J","K","L","M","N","O",
        "P","Q","R","S","T","U","V","W","X","Y","Z","a","b","c","d","e","f",
        "g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w",
        "x","y","z"
    };

    private static Collection<String> bookedLogin =
        Collections.synchronizedCollection(new ArrayList<String>());

    // Random object to generate passwords
    private static Random r1 = new Random();

    public AuthenticationService() {
        super();
    }

    private void migrateFromSHA(Adult adult, String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            md.update(password.getBytes());
            if (StringUtils.equals(adult.getPassword(),
                "{SHA}" + new String(Base64.encodeBase64(md.digest()), "8859_1"))) {
                resetAdultPassword(adult, password);
            }
        } catch (Exception e) {
            logger.debug("migrateFromSHA() : could not migrate old password", e);
        }
    }

    public String encryptPassword(final String clearPassword) {
        return BCrypt.hashpw(clearPassword, BCrypt.gensalt());
    }

    @Override
    public boolean check(String plaintext, String hashed) {
        try {
            return BCrypt.checkpw(plaintext, hashed);
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Adult authenticate(final String login, final String passwd)
        throws CvqModelException, CvqUnknownUserException,
               CvqAuthenticationFailedException, CvqDisabledAccountException {

        Adult adult = adultDAO.findByLogin(login);
        if (adult == null)
            throw new CvqUnknownUserException();
        if (adult.getPassword() != null && adult.getPassword().startsWith("{SHA}"))
            migrateFromSHA(adult, passwd);
        HomeFolder homeFolder = adult.getHomeFolder();
        if (homeFolder == null)
            throw new CvqModelException("authenticate() : no home folder bound to individual " + adult.getId());
        if (homeFolder.getState().equals(UserState.ARCHIVED)) {
            logger.warn("authenticate() user belongs to an archived account");
            throw new CvqUnknownUserException();
        }
        if (!homeFolder.getEnabled()) {
            logger.warn("authenticate() user belongs to a disabled account");
            throw new CvqDisabledAccountException();
        }
        if (UserState.ARCHIVED.equals(adult.getState())) {
            logger.warn("authenticate() user is archived");
            throw new CvqUnknownUserException();
        }
        if (!check(passwd, adult.getPassword())) {
            logger.error("authenticate() bad password for login " + login);
            throw new CvqAuthenticationFailedException("individual.error.badPassword");
        }
        return adult;
    }
    
    public void resetAdultPassword(final Adult adult, final String newPassword) {

        String encryptedPassword = encryptPassword(newPassword);
        adult.setPassword(encryptedPassword);
        adultDAO.update(adult);
    }

    /**
     * Generate random "String" with alphabetic characters or numeric characters.
     * 
     * @param p_index int (number of characters of the string).
     * @param p_boolAlph boolean (true for alphabetic, false for numeric).
     * @return java.lang.String[] (generated string).
     */
    protected String[] getAlphPassword(int p_index, boolean p_boolAlph) {

        String[] pass = new String[p_index];

        if (p_boolAlph) {
            for (int i=0; i < p_index; i++) {
                pass[i] = alph[r1.nextInt(51)];
            }
        } else {
            for (int i=0; i < p_index; i++) {
                pass[i] = String.valueOf(r1.nextInt(9));
            }
        }
        
        return pass;
    }

    @Override
    @Context(types = {ContextType.AGENT}, privilege = ContextPrivilege.WRITE)
    public synchronized String generateLogin(Adult adult) {
        String baseLogin =  Normalizer.normalize(
            (adult.getFirstName().trim() + '.' + adult.getLastName().trim())
                .replaceAll("\\s", "-")
                .replaceAll("'", ""),
            Normalizer.Form.NFD)
                .replaceAll("[^\\p{ASCII}]","").toLowerCase();
        logger.debug("generateLogin() searching from " + baseLogin);
        TreeSet<Integer> indexesSet = new TreeSet<Integer>();
        for (String login : individualDAO.getSimilarLogins(baseLogin)) {
            String index = login.substring(baseLogin.length());
            if (index == null || index.equals(""))
                index = "1";
            try {
                Integer intIndex = Integer.valueOf(index);
                indexesSet.add(intIndex);
            } catch (NumberFormatException nfe) {
                // the tail was not an integer, ignore it
            }
        }
        int finalIndex = 0;
        if (!indexesSet.isEmpty()) {
            finalIndex = indexesSet.last();
        }
        logger.debug("generateLogin() got final index " + finalIndex);
        String loginFromDb = null;
        if (finalIndex == 0)
            loginFromDb = baseLogin;
        else
            loginFromDb = baseLogin + String.valueOf(++finalIndex);
        logger.debug("generateLogin() got new login from DB " + loginFromDb);
        String finalLogin = loginFromDb;
        if (bookedLogin.contains(loginFromDb)) {
            String currentIndex = loginFromDb.substring(baseLogin.length());
            int currIdx = 1;
            if (currentIndex != null && !currentIndex.equals(""))
                currIdx = Integer.parseInt(currentIndex) > finalIndex ?
                    Integer.parseInt(currentIndex) : finalIndex;
            String loginToTest = null;
            do {
                currIdx++;
                loginToTest = baseLogin + String.valueOf(currIdx);
            } while (bookedLogin.contains(loginToTest));
            finalLogin = loginToTest;
        }
        bookedLogin.add(finalLogin);
        return finalLogin;
    }

    public String generatePassword() {

        // Inits result variable
        String password = "";

        Vector<String> vectorPassword = new Vector<String>();
        int l=0;

        // get 4 alphabetic characters
        String[] passAlph = getAlphPassword(4, true);
        for (int k=0; k<passAlph.length; k++) {
            vectorPassword.addElement(passAlph[k]);
            l++;
        }

        // get 4 numeric characters
        String[] passNum = getAlphPassword(4, false);
        for (int k = 0; k < passNum.length; k++) {
            vectorPassword.addElement(passNum[k]);
            l++;
        }

        // puts alphabetic characters and numeric characters in random order
        StringBuffer sb = new StringBuffer();
        for (int i=vectorPassword.size()-1; i>=0; i--) {
            int indexArray = (int)(r1.nextDouble()*(i+1));
            sb.append(vectorPassword.elementAt(indexArray));
            vectorPassword.removeElementAt(indexArray);
        }
        password = sb.toString();

        return password;
    }

    public void setAdultDAO(IAdultDAO adultDAO) {
        this.adultDAO = adultDAO;
    }

    public void setIndividualDAO(IIndividualDAO individualDAO) {
        this.individualDAO = individualDAO;
    }
}
