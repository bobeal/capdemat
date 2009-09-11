import org.apache.commons.lang.StringUtils


class MenuTagLib {
    def static namespace = "menu"
    def exclude = ['backoffice','frontoffice','serviceexporter','monitoring']
    
    def current = {attrs,body ->
        def elem = attrs['elem']
        def clss = attrs['class']
        def current = getCurrentItem()
        
        if(!elem) elem = 'home'
        if(!clss) clss = 'current'
        
        if(elem.toLowerCase() != current.toLowerCase()) clss = ''
        
        out << clss
    }
    
    def subMenu = {attrs,body ->
        def items = attrs['data'], id = attrs['id'], blocks = ''
        def i18nPrefix = attrs['i18nPrefix']
        def itemAction, itemController, itemModule
        
        for(String item : items) {
            itemAction = item.split('\\.')[1]
            itemController = item.split('\\.')[0]
            itemModule = exclude.find { controllerName.contains(it) }
 
            if ((itemAction != actionName) || (itemModule + itemController != controllerName)) {
                blocks += """
                <li>
                  <span class="second-level-menu-item">
                    <a id="display${StringUtils.capitalize(item)}" href="${createLink(controller:itemModule+StringUtils.capitalize(itemController), action:itemAction)}" target="_self">
                     ${message(code:itemController+'.'+i18nPrefix+'.'+itemAction)}
                    </a>
                  </span>
                </li>
                """
            } else {
                blocks += """
                <li>
                  <span class="second-level-menu-item">
                   ${message(code:itemController+'.'+i18nPrefix+'.'+itemAction)}
                  </span>
                </li>
                """
            }
        }
        
        out << """
          <div class="nobox">
            <h3>${message(code:'header.subMenus')}</h3>
            <div class="body">
              <ul class="second-level-menu" id="${id}">
                ${blocks}
              </ul>
            </div>
          </div>
        """
    }
    
    def protected getCurrentItem = {
        def result = controllerName
        exclude.each {result = result.replaceAll(it,'')}
        return result.toLowerCase()
    }
}
