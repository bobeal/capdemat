class CapdematUtils {

    /*
     * Generic method to adapt CapDemat enums-like classes (Like RequestState / MeansOfContact / TitleType / ...)
     */
    public static adaptCapdematEnum(capdematState, i18nKeyPrefix) {
        return [
            "cssClass": "tag-" + capdematState.toString().toLowerCase(), 
            "i18nKey": i18nKeyPrefix + "." + StringUtils.pascalToCamelCase(capdematState.toString()),
            "enumString": capdematState.toString()
        ]
    }

    // TODO : check how one can inject the translation service in this class
    public static adaptRequestType(translationService, requestType) {
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
    
    public static requestTypeLabelAsDir(label) {
        def dirName = StringUtils.firstCase(label.replace(' ', ''), 'Lower')
        if (dirName.endsWith('Request'))
            return dirName
        else
            return dirName + 'Request'
    }
    
    /**
     * Temp static map of requests and groups, while this notion is not fully implemented. 
     */
    public static requestGroup() {
        def requestGroupMap = [
            'school': [ 
                'label' : 'Scolaire',
                'requests': [
                    'School Registration',
                    'Perischool Activity Registration',
                    'School Canteen Registration',
                    'Recreation Activity Registration'
                ]
            ],
            'civil': [ 
                'label' : 'Etat Civil',
                'requests': [
                    'Death Details',
                    'Marriage Details',
                    'Birth Details',
                    'Personal Details',
                    'Military Census'
                ]
            ],
            'social': [ 
                'label' : 'Social',
                'requests': [
                    'Domestic Help',
                    'Handicap Compensation Adult',
                    'Handicap Compensation Child',
                    'Remote Support'
                ]
            ],
            'environment': [ 
                'label' : 'Environnement',
                'requests': [
                    'Bulky Waste Collection',
                    'Compostable Waste Collection'
                ]
            ],
            'election': [ 
                'label' : 'Election',
                'requests': [
                    'Electoral Roll Registration'
                ]
            ],
            'security': [ 
                'label' : 'Sécurité',
                'requests': [
                    'Holiday Security'
                ]
            ],
            'leisure': [ 
                'label' : 'Loisirs',
                'requests': [
                    'Sms Notification',
                    'Music School Registration'
                ]
            ],
            'culture': [ 
                'label' : 'Culturel',
                'requests': [
                    'Place Reservation', 
                    'Library Registration'
                ]
            ],
            'technical': [ 
                'label' : 'Service technique',
                'requests': [
                    'Technical Intervention'
                ]
            ],
            'urbanism': [ 
                'label' : 'Urbanisme',
                'requests': [
                   'Sewer Connection',
                   'Alignment Certificate'
                ]
            ]
        ]

        return requestGroupMap
    }
}