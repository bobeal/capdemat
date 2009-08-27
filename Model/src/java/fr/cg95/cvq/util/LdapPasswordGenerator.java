package fr.cg95.cvq.util;

import java.security.MessageDigest;

import sun.misc.BASE64Encoder;

/**
 * Standalone class used to generate a LDAP SHA password.
 *
 * @author bor@zenexity.fr
 */
public class LdapPasswordGenerator {

    public static void main(String[] args) {

        if (args.length < 1)
            return;

        String clearPassword = args[0];
        try {
            MessageDigest md=MessageDigest.getInstance("SHA-1");
            byte buf[]=clearPassword.getBytes();

            md.update(buf);     //so we avoid password recovery
            byte hash[]=md.digest();     //hash of new password

            if(hash.length > 0) {
                System.err.println("{SHA}"+ new BASE64Encoder().encode(hash));
            } else if(hash.length <= 0) {    //no password was entered
                System.err.println("No password to hash");
            }
        } catch(Exception e) {
            System.err.println(e);
        }

        return;
    }
}
