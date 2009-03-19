import fr.cg95.cvq.service.request.IRequestService

class RequestAdaptorService {

    IRequestService defaultRequestService

    def instructionService
    def translationService
    
    public translateAndSortRequestTypes(onlyManaged = false) {
        def allRequestTypes =
            onlyManaged ? defaultRequestService.getManagedRequestTypes() : defaultRequestService.getAllRequestTypes()
        def allRequestTypesTranslated =  []
        allRequestTypes.each {
            allRequestTypesTranslated.add([
                id:it.id,
                label:translationService.getEncodedRequestTypeLabelTranslation(it.label).decodeHTML(),
                categoryId:it.category?.id
            ])
        }
        return allRequestTypesTranslated.sort{it.label}
    }

    /* currently unused, remove it later if still not used */
    public translateRequestType(requestTypeId) {
        def requestType = defaultRequestService.getRequestTypeById(requestTypeId)
        return translationService.getEncodedRequestTypeLabelTranslation(requestType.label).decodeHTML()
    }

    public prepareRecord(request) {
        return ['id':request.id,
                'draft':request.draft,
                'requestTypeLabel':request.requestType.label,
                'label':translationService.getEncodedRequestTypeLabelTranslation(request.requestType.label),
                'creationDate':request.creationDate,
                'requesterLastName':request.requesterLastName,
                'requesterFirstName': request.requesterFirstName,
                'subjectLastName':request.subjectLastName,
                'subjectFirstName': request.subjectFirstName,
                'state':request.state.toString(),
                'lastModificationDate':request.lastModificationDate,
                'lastInterveningAgentId': instructionService.getActionPosterDetails(request.lastInterveningAgentId) ,
        ]
    }

    public prepareRecords(requests) {
        if (!requests.records) requests.records = []
        requests.all.each {
            requests.records.add(prepareRecord(it))
        }
        
        return requests
    }
}
