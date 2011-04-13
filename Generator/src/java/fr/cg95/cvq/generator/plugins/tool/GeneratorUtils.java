package fr.cg95.cvq.generator.plugins.tool;

public class GeneratorUtils {

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
}
