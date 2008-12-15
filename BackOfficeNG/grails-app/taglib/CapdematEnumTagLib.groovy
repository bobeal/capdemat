// TODO - maybe merge all tags
class CapdematEnumTagLib {
    
    def capdematEnumToFlag = { attrs, body ->
        def capdematEnum = CapdematUtils.adaptCapdematEnum(attrs.var, attrs.i18nKeyPrefix)
        
        def sb = new StringBuffer()
        sb << "<span class=\"" 
        sb << capdematEnum.cssClass
        sb << " tag-state\">"
        sb << g.message(code: capdematEnum.i18nKey)
        sb << "</span>"
          
	      out << body() << sb
	  }
	  
	   def capdematEnumToText = { attrs, body ->
        def capdematEnum = CapdematUtils.adaptCapdematEnum(attrs.var, attrs.i18nKeyPrefix)  
	      out << body() << g.message(code: capdematEnum.i18nKey)
	  }
	  
	  def capdematEnumToField = { attrs, body ->
        
        def sb = new StringBuffer()

        // TODO : finished it in a more industrialized way
        if (attrs.var == null) {
            sb << "<span class=\"" 
            sb << attrs.i18nKeyPrefix
            sb << "\">"
            sb << "&nbsp;"
            sb << "</span>"
        } else {
            def capdematEnum = CapdematUtils.adaptCapdematEnum(attrs.var, attrs.i18nKeyPrefix)
            sb << "<span class=\"" 
            sb << capdematEnum.enumString
            sb << " "
            sb << attrs.i18nKeyPrefix
            sb << "\">"
            sb << g.message(code: capdematEnum.i18nKey)
            sb << "</span>"
        }
	      out << body() << sb
	  }
}
