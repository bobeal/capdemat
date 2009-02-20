import fr.cg95.cvq.service.request.IRequestService

class RequestAdaptorService {

    IRequestService defaultRequestService

    def instructionService
    def translationService
    
    public translateAndSortRequestTypes() {
        def allRequestTypes = defaultRequestService.getAllRequestTypes()
        def allRequestTypesTranslated =  []
        allRequestTypes.each {
            allRequestTypesTranslated.add([
                id:it.id,
                label:translationService.getEncodedRequestTypeLabelTranslation(it.label).decodeHTML()
            ])
        }
        return allRequestTypesTranslated.sort{it.label}
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
