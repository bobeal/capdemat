/**
 * Created by vba@zenexity.fr
 * Date: 14.01.2009
 * Time: 17:42:27
 */

public class ModuleTagLib {
    def static namespace = "module"
    def modules = ['backoffice','frontoffice','serviceexporter','monitoring']
    
    def createLink = { attrs, body ->
        def link = this.preBuildLink(attrs)
        out << g.createLink(link,body)
    }
    
    def protected preBuildLink = {attrs ->
        def result = [:]
        
        if(modules.contains(attrs.module) && attrs.controller) {
            result.controller = this.buildControllerName(attrs.module,attrs.controller)
        }
        
        if(!attrs.controller) result.controller = controllerName
        if(!attrs.action) result.action = actionName
        else result.action = attrs.action
        
        result.url = attrs.url
        result.id = attrs.id
        
        return result
    }
    
    def protected buildControllerName = {m,c ->
        def contr = c as List
        contr[0] = contr[0].toUpperCase()
        return m + contr.join('')
    }

}