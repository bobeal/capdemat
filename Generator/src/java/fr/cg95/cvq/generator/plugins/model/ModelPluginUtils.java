package fr.cg95.cvq.generator.plugins.model;

import org.apache.commons.lang.StringUtils;

public class ModelPluginUtils {

    /**
     * Transform a given enum value name (eg FullCopy) into a name conform to our
     * naming convention (eg FULL_COPY)
     */
    public static String getEnumStaticName(String enumValue) {
        StringBuffer result = new StringBuffer();
        for (int i = 0; i < enumValue.length(); i++) {
            char currentChar = enumValue.charAt(i);
            if (Character.isUpperCase(currentChar) && i > 0) {
                result.append("_").append(currentChar);
            } else {
                result.append(Character.toUpperCase(currentChar));
            }
        }
        return result.toString();
    }

    /**
     * Transform a given element name (eg StartDate) into a SQL name conform to our
     * convention (eg start_date)
     */
    public static String getSQLName(String elementName) {
        String uncapitalizedName = StringUtils.uncapitalize(elementName);
        StringBuffer result = new StringBuffer();
        for (int i = 0; i < uncapitalizedName.length(); i++) {
            char currentChar = uncapitalizedName.charAt(i);
            if (Character.isUpperCase(currentChar)) {
                result.append("_").append(Character.toLowerCase(currentChar));
            } else {
                result.append(currentChar);
            }
        }
        return result.toString();
    }
}
