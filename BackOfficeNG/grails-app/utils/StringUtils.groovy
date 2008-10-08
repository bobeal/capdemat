
public class StringUtils {
    /* 
     * Transforme a string like 'FIRST_NAME' in 'firstName'
     * FIXME : not ever used 
     */
    public static toCamelCase (String s) {
        def camelCaseSb = new StringBuffer()
        def isNewWord = false
        
        s.toLowerCase().each {
            if (it != '_') {
                if (! isNewWord)
                    camelCaseSb << it
                else {
                  camelCaseSb << it.toUpperCase()
                  isNewWord = false
                }
            } else
                isNewWord = true
        }
        return camelCaseSb.toString()
    }
    
     /* 
     * Transforme a string like 'FIRST_NAME' in 'FirstName'
     */
    public static toPascalCase (String s) { 
        def pascalCaseSb = new StringBuffer()
        def isNewWord = false
        
        s.toLowerCase().eachWithIndex { obj, i ->
            if (obj != '_') {
                if (i == 0) 
                    pascalCaseSb << obj.toUpperCase()
                else if (! isNewWord)
                    pascalCaseSb << obj
                else {
                  pascalCaseSb << obj.toUpperCase()
                  isNewWord = false
                }
            } else
                isNewWord = true
        }
        return pascalCaseSb.toString()
    }
    
    
    public static pascalToCamelCase (String s) {
        def camelCaseSb = new StringBuffer()
        s.eachWithIndex { obj, i ->
            if (i == 0)
                camelCaseSb << obj.toLowerCase()
            else         
              camelCaseSb << obj
        }
        return camelCaseSb.toString()
    }
}
