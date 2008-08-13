package fr.cg95.cvq.payment;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;

import org.apache.commons.codec.binary.Base64;

/**
 * Utility methods for payment services.
 *
 * @author bor@zenexity.fr
 */
public class PaymentUtils {

    public static String serializeItems(Collection purchaseItems)
        throws Exception {

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(purchaseItems);
        baos.close();
        String serializedItems = new String(new Base64().encode(baos.toByteArray()));
        serializedItems = serializedItems.replaceAll("\n", ""); // safe URL base64
        serializedItems = serializedItems.replaceAll("\\+", "-"); // safe URL base64
        serializedItems = serializedItems.replaceAll("/", "_"); // safe URL base64
        serializedItems = serializedItems.replaceAll("=", "."); // safe URL base64

        return serializedItems;
    }

    public static Collection deserializeItems(String serializedItems)
        throws Exception {

        serializedItems = serializedItems.replaceAll("-", "\\+"); // safe URL base64
        serializedItems = serializedItems.replaceAll("_", "/"); // safe URL base64
        serializedItems = serializedItems.replaceAll("\\.", "="); // safe URL base64
        ByteArrayInputStream bais =
            new ByteArrayInputStream(Base64.decodeBase64(serializedItems.getBytes()));
        ObjectInputStream ois = new ObjectInputStream(bais);
        Collection purchaseItems = (Collection) ois.readObject();

        return purchaseItems;
    }
    
    public static String formatPrice(int value) {
        String v = String.valueOf(value);
        if (v.length() > 2) {
            return v.substring(0, v.length() - 2) + "," + v.substring(v.length() - 2);
        } else {
            return 0 + "," + v;
        }
    }
}
