import java.util.Hashtable;

import fr.cg95.cvq.business.authority.Agent;
import fr.cg95.cvq.business.authority.Category;
import fr.cg95.cvq.business.request.Request
import fr.cg95.cvq.business.request.RequestState
import fr.cg95.cvq.business.request.RequestType;
import fr.cg95.cvq.service.authority.IAgentService
import fr.cg95.cvq.service.authority.ICategoryService
import fr.cg95.cvq.service.request.IRequestService
import fr.cg95.cvq.service.request.IRequestStatisticsService
import fr.cg95.cvq.util.Critere
import fr.cg95.cvq.security.SecurityContext;


class EcitizenService {
    
    InstructionService instructionService;
    TranslationService translationService;
    IRequestService defaultRequestService;
    
    //boolean transactional = true;
    
    def prepareRecords = { requests ->
        if(!requests?.records) requests.records = [];
        
        requests.all.each{
            requests.records.add([
                'id':it.id,
                'label':translationService.getEncodedRequestTypeLabelTranslation(it.requestType.label),
                'creationDate':DateUtils.formatDate(it.creationDate),
                'requesterLastName':it.requester.lastName + " " + it.requester.firstName,
                'subjectLastName':it.subject ? it.subject.lastName + " " + it.subject.firstName : "",
                'homeFolderId':it.homeFolder.id,
                'state':it.state.toString(),
                'lastModificationDate':it.lastModificationDate == null ? "" :  DateUtils.formatDate(it.lastModificationDate),
                'lastInterveningAgentId': instructionService.getActionPosterDetails(it.lastInterveningAgentId) ,
                'permanent':!it.homeFolder.boundToRequest
            ]);
        }
        
        return requests
    }
    
}
