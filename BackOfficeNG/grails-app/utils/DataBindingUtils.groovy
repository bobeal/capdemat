import org.codehaus.groovy.grails.web.servlet.mvc.GrailsParameterMap

public class DataBindingUtils {

    public static initBind(object, params) {
        params.each { param ->
            if (param.value.getClass() == GrailsParameterMap.class) {
                def propertyName = StringUtils.firstCase(param.key.tokenize('.')[0].tokenize('[')[0], 'Upper')
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
                    def index = Integer.valueOf(param.key.tokenize('[]')[1]).intValue()
                    if (index >= list.size()) {
                        def listElemType = getterMethod.genericReturnType.actualTypeArguments[0]
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
            if (param.value.getClass() == GrailsParameterMap.class) { 
                paramAsString = param.value.values().join()
                        .replaceAll(/"\w+":""/,'').replaceAll(/[\[\],]/, '').trim()
                def propertyName = StringUtils.firstCase(param.key.tokenize('.')[0].tokenize('[')[0], 'Upper')
                def getterMethod = object.class.getMethod('get' + propertyName)
                def setterMethod = object.class.getMethod('set' + propertyName, [getterMethod.returnType] as Class[])
                    
                if (paramAsString.length() == 0) {
                    if (getterMethod.returnType.equals(Class.forName('java.util.List'))) {
                        def list = getterMethod.invoke(object, null)
                        list.remove(list.size() - 1)
                        if (list.size() == 0)
                            setterMethod.invoke(object, [null] as Object[])
                    }
                    else
                        setterMethod.invoke(object, [null] as Object[])
                }
            }
        }
    }
    
}
