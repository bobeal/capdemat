class MenuTagLib {
    def static namespace = "menu"
    def exclude = ['backoffice','frontoffice','serviceexporter']
    
    def current = {attrs,body ->
        def elem = attrs['elem']
        def clss = attrs['class']
        def current = getCurrentItem()
        
        if(!elem) elem = 'home'
        if(!clss) clss = 'current'
        
        if(elem.toLowerCase() != current.toLowerCase()) clss = ''
        
        out << clss
    }
    
    def protected getCurrentItem = {
        def result = controllerName
        exclude.each {result = result.replaceAll(it,'')}
        return result.toLowerCase()
    }
}