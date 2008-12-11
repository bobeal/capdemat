
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
    
    /**
     * Temp static map of requests and groups, while this notion is not fully implemented. 
     */
    public static requestGroup() {
        def requestGroupMap = [
            'school': [ 
                'label' : 'Scolaire',
                'requests': [
                    'School Registration':[
                        'link': 'School Registration'.replaceAll(' ','') + "Request"
                    ],
                    'Perischool Activity Registration':[
                        'link': 'Perischool Activity Registration'.replaceAll(' ','') + "Request"],
                    'School Canteen Registration':[
                        'link': 'School Canteen Activity Registration'.replaceAll(' ','') + "Request"],
                    'Recreation Activity Registration':[
                        'link': 'Recreation Activity Registration'.replaceAll(' ','') + "Request"]
                ]
            ],
            'civil': [ 
                'label' : 'Etat Civil',
                'requests': [
                    'Death Details':[
                        'link': 'Perischool Activity Registration'.replaceAll(' ','') + "Request"],
                    'Marriage Details':[
                        'link': 'Perischool Activity Registration'.replaceAll(' ','') + "Request"],
                    'Birth Details':[
                        'link': 'Perischool Activity Registration'.replaceAll(' ','') + "Request"],
                    'Personal Details':[
                        'link': 'Perischool Activity Registration'.replaceAll(' ','') + "Request"],
                    'Military Census':[
                        'link': 'Perischool Activity Registration'.replaceAll(' ','') + "Request"]
                ]
            ],
            'social': [ 
                'label' : 'Social',
                'requests': [
                    'Domestic Help':[
                        'link': 'Perischool Activity Registration'.replaceAll(' ','') + "Request"],
                    'Handicap Allowance':[
                        'link': 'Perischool Activity Registration'.replaceAll(' ','') + "Request"],
                    'Remote Support':[
                        'link': 'Perischool Activity Registration'.replaceAll(' ','') + "Request"]
                ]
            ],
            'environment': [ 
                'label' : 'Environnement',
                'requests': [
                    'Bulky Waste Collection':[
                        'link': 'Perischool Activity Registration'.replaceAll(' ','') + "Request"],
                    'Compostable Waste Collection':[
                        'link': 'Perischool Activity Registration'.replaceAll(' ','') + "Request"]
                ]
            ],
            'election': [ 
                'label' : 'Election',
                'requests': [
                    'Electoral Roll Registration':[
                        'link': 'Perischool Activity Registration'.replaceAll(' ','') + "Request"]
                ]
            ],
            'security': [ 
                'label' : 'Sécurité',
                'requests': [
                    'Holiday Security':[
                        'link': 'Perischool Activity Registration'.replaceAll(' ','') + "Request"]
                ]
            ],
            'leisure': [ 
                'label' : 'Loisirs',
                'requests': [
                    'Sms Notification':[
                        'link': 'Perischool Activity Registration'.replaceAll(' ','') + "Request"],
                    'Music School Registration':[
                        'link': 'Perischool Activity Registration'.replaceAll(' ','') + "Request"]
                ]
            ],
            'culture': [ 
                'label' : 'Culturel',
                'requests': [
                    'Place Reservation':[
                        'link': 'Perischool Activity Registration'.replaceAll(' ','') + "Request"], 
                    'Library Registration':[
                        'link': 'Perischool Activity Registration'.replaceAll(' ','') + "Request"]
                ]
            ],
            'technical': [ 
                'label' : 'Service technique',
                'requests': [
                    'Technical Intervention':[
                        'link': 'Perischool Activity Registration'.replaceAll(' ','') + "Request"]
                ]
            ],
            'urbanism': [ 
                'label' : 'Urbanisme',
                'requests': [
                   'Sewer Connection':[
                        'link': 'Perischool Activity Registration'.replaceAll(' ','') + "Request"],
                   'Alignment Certificate':[
                        'link': 'Perischool Activity Registration'.replaceAll(' ','') + "Request"]
                ]
            ]
        ]

        return requestGroupMap
    }
}
