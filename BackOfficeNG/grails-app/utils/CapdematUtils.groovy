
class CapdematUtils {

    /*
     * Generic method to adapt CapDemat enums-like classes (Like RequestState / MeansOfContact / TitleType / ...)
     */
    public static adaptCapdematEnum (capdematState, i18nKeyPrefix) {
        return [
            "cssClass": "tag-" + capdematState.toString().toLowerCase(), 
            "i18nKey": i18nKeyPrefix + "." + StringUtils.pascalToCamelCase(capdematState.toString()),
            "enumString": capdematState.toString()
        ]
    }
    
    // TODO : check how one can inject the translation service in this class
    public static adaptRequestType (translationService, requestType) {
        return [
            id: requestType.id,
            active: requestType.active,
            label: translationService.getEncodedRequestTypeLabelTranslation(requestType.label),
            categoryId: requestType.category?.id, 
            categoryName: requestType.category?.name
        ]
    }

    public static adaptDocumentTypeName(name) {
        return "documentType."+ StringUtils.firstCase(name.replaceAll(' ',''),"Lower")
    }
    
    public static adaptRequestActionLabel(label) {
        def transformedLabel = label.toLowerCase().replaceAll('_.',{it.toUpperCase().substring(1)})
        return "request.actionLabel.${transformedLabel}"
    }
    
    public static requestGroup() {
        return [
            'school': [ 
                'School Registration',
                'Perischool Activity Registration',
                'School Canteen Registration',
                'Recreation Activity Registration'
            ],
            'civil': [
                'Death Details',
                'Marriage Details',
                'Birth Details',
                'Personal Details',
                'Military Census'
            ],
            'social': [
                'Domestic Help',
                'Handicap Allowance',
                'Remote Support'
            ],
            'environment': [
                'Bulky Waste Collection',
                'Compostable Waste Collection'
            ],
            'election': [
                'Electoral Roll Registration'
            ],
            'security': [
                'Holiday Security'
            ],
            'leisure': [
                'Sms Notification',
                'Music School Registration'
            ],
            'culture': [
                'Place Reservation', 
                'Library Registration'
            ],
            'technical': [
                'Technical Intervention'
            ],
            'urbanism': [
                'Sewer Connection',
                'Alignment Certificate'
            ]
//            ,
//            'ecitizen' : [
//                'VO Card Request',
//                'Home Folder Modification'
//            ]
        ]

    }
}
