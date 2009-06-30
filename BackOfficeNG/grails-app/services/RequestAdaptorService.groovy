import fr.cg95.cvq.business.request.RequestState
import fr.cg95.cvq.service.request.IRequestService
import fr.cg95.cvq.service.request.IRequestTypeService

class RequestAdaptorService {

    IRequestTypeService requestTypeService

    def instructionService
    def translationService
    
    public translateAndSortRequestTypes(onlyManaged = false) {
        def allRequestTypes =
            onlyManaged ? requestTypeService.getManagedRequestTypes() : requestTypeService.getAllRequestTypes()
        def allRequestTypesTranslated =  []
        allRequestTypes.each {
            allRequestTypesTranslated.add([
                id:it.id,
                label:translationService.translateRequestTypeLabel(it.label),
                categoryId:it.category?.id
            ])
        }
        return allRequestTypesTranslated.sort{it.label}
    }

    /* currently unused, remove it later if still not used */
    public translateRequestType(requestTypeId) {
        def requestType = requestTypeService.getRequestTypeById(requestTypeId)
        return translationService.translateRequestTypeLabel(requestType.label)
    }

    public prepareRecord(request) {
        return ['id':request.id,
                'draft':request.draft,
                'requestTypeLabel':request.requestType.label,
                'label':translationService
                    .translateRequestTypeLabel(request.requestType.label).encodeAsHTML(),
                'creationDate':request.creationDate,
                'requesterLastName':request.requesterLastName,
                'requesterFirstName': request.requesterFirstName,
                'subjectLastName':request.subjectLastName,
                'subjectFirstName': request.subjectFirstName,
                'state':request.state.toString(),
                'lastModificationDate':request.lastModificationDate,
                'lastInterveningUserId': instructionService.getActionPosterDetails(request.lastInterveningUserId),
                /* FIXME : use IRequestWorkflowService.isEditable when circular dependencies are resolved */
                'isEditable' : (RequestState.PENDING.equals(request.state) 
                        || RequestState.UNCOMPLETE.equals(request.state)) 
                        && !IRequestService.VO_CARD_REGISTRATION_REQUEST.equals(request.requestType.label)
                        && !IRequestService.HOME_FOLDER_MODIFICATION_REQUEST.equals(request.requestType.label)
        ]
    }

    public prepareRecords(requests) {
        if (!requests.records) requests.records = []
        requests.all.each {
            requests.records.add(prepareRecord(it))
        }
        
        return requests
    }

    public prepareNote(requestNote) {
        if (!requestNote) return null
        def user = instructionService.getActionPosterDetails(requestNote.userId, true)
        return [
            'id':requestNote.id,
            'user_name':user.displayName,
            'nature':user.nature,
            'type':requestNote.type,
            'note':requestNote.note,
            'date':requestNote.date
        ]
    }

    public prepareNotes(requestNotes) {
        if (!requestNotes) requestNotes = []
        return requestNotes.collect{ prepareNote(it) }
    }
}
