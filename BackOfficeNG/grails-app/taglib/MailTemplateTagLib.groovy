
class MailTemplateTagLib {
    def forms

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

    /**
     * Assigns model request forms to taglib
     */
    def requestForms = { attrs, body ->
        this.forms = attrs['forms']
    }
}
