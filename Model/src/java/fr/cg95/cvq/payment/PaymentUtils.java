package fr.cg95.cvq.payment;

/**
 * Utility methods for payment services.
 *
 * @author bor@zenexity.fr
 */
public class PaymentUtils {

    public static String formatPrice(int value) {
        String v = String.valueOf(value);
        if (v.length() > 2) {
            return v.substring(0, v.length() - 2) + "," + v.substring(v.length() - 2);
        } else {
            return 0 + "," + v;
        }
    }
}
