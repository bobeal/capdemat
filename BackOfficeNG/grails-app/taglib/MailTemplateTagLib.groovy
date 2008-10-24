import fr.cg95.cvq.business.request.RequestForm
import fr.cg95.cvq.service.request.IRequestService


class MailTemplateTagLib {
    def forms
    def zones = []
    
    def editableZone = { attrs, body ->
        def zoneId = "editable-"
        
        if(!attrs.id)
            throw new Exception("Editable zone must have an identifier")
        
        def content = forms[0]?.getPersonalizedData()
        // Use following approach to personalize multiple zones : 
        // (forms.find{it?.getShortLabel() == zoneId.replace("editable-","")})
        zoneId+="${attrs.id}:"
        if(forms[0]?.getId()) zoneId += forms[0].getId()
        
        if(!content)content = body()
        else content = new String(content)
        
        out << """<div class="${attrs['class']}" id="$zoneId">$content</div>"""
    }
    
    def templateText = { attrs, body ->
        out << body()
    }
    
    /**
     * Assigns model request forms to taglib
     */
    def requestForms = { attrs, body ->
        this.forms = attrs['forms']
    }
    
    /**
     * Fixes request form if this one hasn't client id (short label) 
     */
    private fixRequestForm = {
        //
    }
    
    /**
     * Generates random string of specified length
     */
    private randomString = { length ->
        def availChars = []  
        ('a'..'z').each { availChars << it.toString() } 
        def max = availChars.size      
        def rnd = new Random()  
        def sb = new StringBuilder()  
        length.times { sb.append(availChars[rnd.nextInt(max)]) }  
        sb.toString()  
    } 
}