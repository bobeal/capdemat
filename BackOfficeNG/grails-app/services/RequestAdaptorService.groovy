import fr.cg95.cvq.business.request.RequestState
import fr.cg95.cvq.security.SecurityContext
import fr.cg95.cvq.service.authority.ICategoryService
import fr.cg95.cvq.service.request.IRequestService
import fr.cg95.cvq.service.request.IRequestTypeService
import fr.cg95.cvq.service.users.IHomeFolderService

import org.joda.time.DateTime;
import org.joda.time.Minutes;

class RequestAdaptorService {

    IRequestService defaultRequestService
    IRequestTypeService requestTypeService
    IHomeFolderService homeFolderService
    ICategoryService categoryService

    def instructionService
    def translationService
    def agentService
    def individualService

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
                        && !defaultRequestService.isLocked(request.id)
        ]
    }

    public prepareRecords(requests) {
        if (!requests.records) requests.records = []
        requests.all.each {
            requests.records.add(prepareRecord(it))
        }
        
        return requests
    }

    public prepareRecordForSummaryView(request) {
        def homeFolder = homeFolderService.getById(request.homeFolderId)
        def quality = 'green'
        if (request.redAlert)
            quality = 'red'
        else if (request.orangeAlert)
            quality = 'orange'
        def record = [
              'id':request.id,
              'label':translationService.translateRequestTypeLabel(request.requestType.label).encodeAsHTML(),
              'creationDate':request.creationDate,
              'requesterLastName':request.requesterLastName + " " + request.requesterFirstName,
              'subjectLastName':request.subjectId ? request.subjectLastName + " " + request.subjectFirstName : "",
              'homeFolderId':request.homeFolderId,
              'state':request.state.toString(),
              'lastModificationDate':request.lastModificationDate,
              'lastInterveningUserId': instructionService.getActionPosterDetails(request.lastInterveningUserId),
              'permanent':!homeFolder.boundToRequest,
              'quality':quality,
              'isViewable':categoryService.hasProfileOnCategory(SecurityContext.currentAgent,
                           request.requestType.category?.id)
        ]

        return record
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

    public stepState(step, state, errorMsg) {
        step.state = state
        step.cssClass = 'tag-' + state
        step.i18nKey = 'request.step.state.' + state
        step.errorMsg = errorMsg
    }

    public prepareLock(requestId) {
        def result = [:]
        result.locked = defaultRequestService.isLocked(requestId)
        result.lockedByCurrentUser =
            defaultRequestService.isLockedByCurrentUser(requestId)
        if (result.lockedByCurrentUser) result.cssClass = "lockacquired"
        else if (result.locked) result.cssClass = "locked"
        else result.cssClass = "free"
        if (result.lockedByCurrentUser || result.locked) result.i18nKey = "locked"
        else result.i18nKey = "free"
        def requestLock = defaultRequestService.getRequestLock(requestId)
        if (requestLock != null) {
            result.age =
                Minutes.minutesBetween(new DateTime(requestLock.getDate()),
                    new DateTime()).minutes
            result.lifetime =
                SecurityContext.currentSite.requestLockMaxDelay - result.age
            if (result.lockedByCurrentUser)
                result.lockerName = translationService.translate("you")
            else {
                if (agentService.exists(requestLock.userId)) {
                    def agent = agentService.getById(requestLock.userId)
                    result.lockerName = "$agent.firstName $agent.lastName"
                } else {
                    result.lockerName =
                        """${translationService.translate("layout.theMale")} ${translationService.translate("eCitizen")}"""
                }
            }
        }
        return result
    }
}
