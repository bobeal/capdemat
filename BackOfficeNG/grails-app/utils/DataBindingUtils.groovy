import org.codehaus.groovy.grails.web.servlet.mvc.GrailsParameterMap

public class DataBindingUtils {

    public static initBind(object, params) {
        params.each { param ->
            def paramKey = validParamKey(params, param.key)
            if (param.value.getClass() == GrailsParameterMap.class && paramKey != '') {
                def propertyName = StringUtils.firstCase(paramKey.tokenize('.')[0].tokenize('[')[0], 'Upper')
                def getterMethod = object.class.getMethod('get' + propertyName)
                
                if (getterMethod.invoke(object, null) == null) {
                    def setterMethod = object.class.getMethod('set' + propertyName, [getterMethod.returnType] as Class[])
                    def fieldConstructor
                    if (getterMethod.returnType.equals(Class.forName('java.util.List')))
                        fieldConstructor = Class.forName('java.util.ArrayList').getConstructor()
                    else
                        fieldConstructor = getterMethod.returnType.getConstructor(null)

                    setterMethod.invoke(object, [fieldConstructor.newInstance(null)] as Object[])
                }
                // add/update a new element to list (it will be update by databinder)
                if (getterMethod.returnType.equals(Class.forName('java.util.List'))) {
                    def list = getterMethod.invoke(object, null);
                    def index = Integer.valueOf(paramKey.tokenize('[]')[1]).intValue()
                    if (index >= list.size()) {
                        def listElemType = getterMethod.genericReturnType.actualTypeArguments[0]
                        while (!(index == list.size())) {
                            def emptylistElem = listElemType.getConstructor(null).newInstance(null)
                            list.add(emptylistElem)
                        }
                        def listElem = listElemType.getConstructor(null).newInstance(null)
                        initBind(listElem, param.value)
                        list.add(listElem)
                    } else {
                        def listElem = list.get(index)
                        initBind(listElem, param.value)
                    }
                }
            }
        }
    }
    
    public static cleanBind(object, params) {
        def paramAsString
        params.each { param ->
            def paramKey = validParamKey(params, param.key)
            if (param.value.getClass() == GrailsParameterMap.class  && paramKey != '') {
                def propertyName = StringUtils.firstCase(paramKey.tokenize('.')[0].tokenize('[')[0], 'Upper')
                def getterMethod = object.class.getMethod('get' + propertyName)
                def setterMethod = object.class.getMethod('set' + propertyName, [getterMethod.returnType] as Class[])
                    
                if (isEmptyParamValue(param)) {
                    if (getterMethod.returnType.equals(Class.forName('java.util.List'))) {
                        def index = Integer.valueOf(paramKey.tokenize('[]')[1]).intValue()
                        def list = getterMethod.invoke(object, null)
                        if (isListElemRemovable(params, paramKey, list)) {
                            while (!(index == list.size())) {
                                list.remove(list.size() -1 )
                            }
                            /*if (list.size() == 0)
                                setterMethod.invoke(object, [null] as Object[])*/
                        }
                    }
                    else
                        setterMethod.invoke(object, [null] as Object[])
                }
            }
        }
    }
    
    /* Allow to manage Spring DataBinding tip for empty checkBox POST <input type="hidden" name="_javaFieldName"> */
    private static validParamKey(params, paramKey) {
        if (paramKey.startsWith('_')) {
            if (params[paramKey.substring(1)] == null) return paramKey.substring(1)
            else return ''
        } else
            return paramKey
    }
    
    /* Authorize multi remove in context of Spring DataBinding tip for empty checkBox POST */
    private static isListElemRemovable(params, paramKey, list) {
        if (list == null)
            return false;
        def index = Integer.valueOf(paramKey.tokenize('[]')[1]).intValue()
        if (index == list.size() - 1)
            return true
        if (index > list.size() - 1)
            return false

        def result = true
        def listName = paramKey.tokenize('.')[0].tokenize('[')[0]
        params.each {
            if (it.key.tokenize('.')[0].tokenize('[')[0] == listName
                && it.value.getClass() == GrailsParameterMap.class) {
                def itKey = validParamKey(params, it.key)
                def itIndex = Integer.valueOf(it.key.tokenize('[]')[1]).intValue()
                if (it.key != paramKey && it.key != '' && !isEmptyParamValue(it) && itIndex > index)
                    result = false
            }
        }
        return result
    }

    /* Test if a complex (object/collection) params is empty */
    private static isEmptyParamValue(param) {
        def paramAsString = paramValueAsString(param)
        if (paramAsString.length() == 0) return true
        else return false
    }

    /* Concat recursivly param's values into a string
       - if resulting string's is empty then values are not filled
       - param is a EntryMap
    */
    private static paramValueAsString(param) {
        def result = ''
        param.value.each {
            if (it.value.getClass() == GrailsParameterMap.class)
                result += paramValueAsString(it)
            else
                result += it.value.replaceAll(/"\w+":""/,'').replaceAll(/[\[\],]/, '').trim()
        }
        return result
    }
}

