package fr.cg95.cvq.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EnumTool {

    static Pattern p = Pattern.compile("([_@])([A-Za-z0-9])");
    /**
     * Transform a string like 'FIRST_NAME' or 'FirstName' to 'firstName'
     */
    public static String toLowerCamelCase(String s){
        s = s.replaceAll( "([a-z])([A-Z])", "$1@$2" ).toLowerCase(); //add @ between words and lowcase the string
        Matcher m = p.matcher(s); 
        while (m.find()) {
          s = s.replace(m.group(1)+m.group(2), m.group(2).toUpperCase());
        }
        return s;
    }

    public static void main(String[] args) {
        System.out.println(toLowerCamelCase("C_L_I_S_S"));
        System.out.println(toLowerCamelCase("FirstName"));
        System.out.println(toLowerCamelCase("PC"));
        System.out.println(toLowerCamelCase("C_E1"));
        System.out.println(toLowerCamelCase("UNKNOW"));
        System.out.println(toLowerCamelCase("BEFORE_FIRST_SECTION"));
    }
}