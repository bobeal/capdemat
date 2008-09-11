import fr.cg95.cvq.business.authority.CategoryProfile

class TranslateTagLib {
    def translationService
    
	  def translateRequestTypeLabel = { attrs, body ->
	      out << body() << translationService.getEncodedRequestTypeLabelTranslation(attrs.label)
	  }
    
    // deprecated !
    // TODO - remove this closure
    def translateCategoryProfile = { attrs, body ->
        def agent = attrs.agent
        def translation
        
        if (agent.categoriesRole != null) {
       	    if (agent.categoriesRole.profile == CategoryProfile.READ_ONLY)
       	        translation = "<span class='tag-read_only'>Consultation</span>"
       	    else if (agent.categoriesRole.profile == CategoryProfile.READ_WRITE)
       	        translation = "<span class='tag-read_write'>Modification</span>"
       	    
       	    out << body() << translation
     	  } else 
     	      out << body() << ""
    }
    
}
