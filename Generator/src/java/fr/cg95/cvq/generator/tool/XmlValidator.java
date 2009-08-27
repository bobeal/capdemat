package fr.cg95.cvq.generator.tool;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.xmlbeans.XmlError;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;

/**
 * Utility class to test XML instances validation
 *
 * @author bor@zenexity.fr
 */
public final class XmlValidator {

    public static boolean validate(XmlObject object) {
        ArrayList<XmlError> validationErrors = new ArrayList<XmlError>();
        XmlOptions options = new XmlOptions();
        options.setErrorListener(validationErrors);
        boolean isValid = object.validate(options);
        if (!isValid) {
            for (XmlError error : validationErrors) {
                System.out.println(">> " + error + "\n");
            }
            return false;
        }
        return true;
    }

    public static void main(String args[]) {

        if (args.length < 2) {
            System.out.println("Missing xml schema file or xml instance file.");
            return;
        }

        File xmlFile = new File(args[0]);
        if (!xmlFile.isFile()) {
            System.out.println("The first parameter does not contain a file (for the xml).");
            return;
        }

        File xsdFile = new File(args[1]);
        if (!xsdFile.isFile()) {
            System.out.println("The second parameter does not contain a file (for the xml schema).");
            return;
        }

        XmlObject xml = null;
        try {
            xml = XmlObject.Factory.parse(xmlFile);
        } catch (XmlException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        XmlValidator.validate(xml);
    }
}
