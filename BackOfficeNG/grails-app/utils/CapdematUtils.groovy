class CapdematUtils {

    def translationService

    /*
     * Generic method to adapt CapDemat enums-like classes (Like RequestState / MeansOfContact / TitleType / ...)
     */
    public static adaptCapdematEnum(capdematState, i18nKeyPrefix) {
        return [
            "cssClass": "tag-" + capdematState.toString().toLowerCase(), 
            "i18nKey": i18nKeyPrefix + "." + StringUtils.toLowerCamelCase(capdematState.toString()),
            "enumString": capdematState.toString()
        ]
    }

    // TODO : check how one can inject the translation service in this class
    public static adaptRequestType(translationService, requestType) {
        return [
            id: requestType.id,
            active: requestType.active,
            label: translationService.translateRequestTypeLabel(requestType.label).encodeAsHTML(),
            categoryId: requestType.category?.id, 
            categoryName: requestType.category?.name,
            displayGroupId: requestType.displayGroup?.id, 
            displayGroupLabel: requestType.displayGroup?.label
        ]
    }

    public static adaptDocumentTypeName(name) {
        return "documentType."+ StringUtils.firstCase(name.replaceAll(' ',''),"Lower")
    }

    public static requestTypeLabelAsDir(label) {
        def dirName = StringUtils.firstCase(label.replace(' ', ''), 'Lower')
        if (dirName.endsWith('Request'))
            return dirName
        else
            return dirName + 'Request'
    }
}
