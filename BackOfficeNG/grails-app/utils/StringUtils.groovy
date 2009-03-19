
public class StringUtils {
    
    /**
    * Transform a string like 'FIRST_NAME' into 'FirstName'
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

    /**
     * Transform a string like 'FirstName' into 'firstName'
     */
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

    /**
     * Upper or lower case the first character of the given string
     */
    public static firstCase = { str,cs ->
        if(!['Upper','Lower'].contains(cs)) cs = 'Upper'
        def result = str as List
        result[0] = result[0]."to${cs}Case"()
        return result.join('')
    }
}
