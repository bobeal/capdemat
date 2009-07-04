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
        
        for(String item : items) {
            if(item != actionName) {
                blocks += """
                <li>
                  <span class="second-level-menu-item">
                    <a id="display${StringUtils.capitalize(item)}" href="${createLink(action:item)}" target="_self">
                     ${message(code:i18nPrefix+'.'+item)}
                    </a>
                  </span>
                </li>
                """
            } else {
                blocks += """
                <li>
                  <span class="second-level-menu-item">
                   ${message(code:i18nPrefix+'.'+item)}
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