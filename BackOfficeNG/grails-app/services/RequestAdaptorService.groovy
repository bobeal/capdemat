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
                    label:translationService.getEncodedRequestTypeLabelTranslation(it.label).decodeHTML()])
        }
        return allRequestTypesTranslated.sort{it.label}
    }

    public prepareRecords(requests) {
        if (!requests.records) requests.records = []
        requests.all.each {
            requests.records.add([
                'id':it.id,
                'draft':it.draft,
                'requestTypeLabel':it.requestType.label,
                'label':translationService.getEncodedRequestTypeLabelTranslation(it.requestType.label),
                'creationDate':it.creationDate,
                'requesterLastName':it.requesterLastName,
                'requesterFirstName': it.requesterFirstName,
                'subjectLastName':it.subjectLastName,
                'subjectFirstName': it.subjectFirstName,
                'state':it.state.toString(),
                'lastModificationDate':it.lastModificationDate,
                'lastInterveningAgentId': instructionService.getActionPosterDetails(it.lastInterveningAgentId) ,
            ]);
        }
        
        return requests
    }
}
