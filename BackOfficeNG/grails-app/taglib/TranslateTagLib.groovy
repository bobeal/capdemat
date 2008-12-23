class TranslateTagLib {
    def translationService
    
    def translateRequestTypeLabel = { attrs, body ->
        out << body() << translationService.getEncodedRequestTypeLabelTranslation(attrs.label)
    }
}
