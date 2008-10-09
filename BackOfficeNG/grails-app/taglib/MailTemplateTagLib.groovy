
class MailTemplateTagLib {
    def editableZone = { attrs, body ->
        def typeId = attrs['requestTypeId']
        def formId = attrs['requestFormId']
        def zoneId = "editable-${attrs['id']}"
        def content = body()
        
        if(formId) content = personalize(formId)
        out << """<div class="${attrs['class']}" id="$zoneId">$content</div>"""
    }
    
    private personalize = { formId ->
        // TODO: Get personalized body using request form services
        return content = " Lorem personalized ${BODY}"
    }
}