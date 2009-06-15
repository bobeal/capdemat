class TranslateTagLib {
    def translationService
    
    def translateRequestTypeLabel = { attrs, body ->
        out << body() << translationService
            .translateRequestTypeLabel(attrs.label, request.locale).encodeAsHTML()
    }
}
