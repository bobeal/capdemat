package fr.cg95.cvq.exporter.service.fo.impl;

import java.util.Date;
import java.util.Map;
import java.util.Set;

import fr.cg95.cvq.business.election.ElectoralRollRegistrationRequest;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.exception.CvqObjectNotFoundException;
import fr.cg95.cvq.exporter.service.fo.IRequestService;
import fr.cg95.cvq.service.election.IElectoralRollRegistrationRequestService;

public class RequestService implements IRequestService {
	
	private fr.cg95.cvq.service.users.IRequestService requestService;
	private IElectoralRollRegistrationRequestService electoralRollRegistrationRequestService;
	
	public Set getByHomeFolderId(Long homeFolderId) 
	throws CvqException, CvqObjectNotFoundException {
		return requestService.getByHomeFolderId(homeFolderId);
	}
	
	public Long createElectoralRollRegistrationRequest(final ElectoralRollRegistrationRequest errr,
			final Long requesterId, final Long subjectId)
	throws CvqException, CvqObjectNotFoundException {
		
		return electoralRollRegistrationRequestService.create(errr, requesterId);
	}
	
	public void addDocuments(Long requestId, Set documentsId) throws CvqException, CvqObjectNotFoundException {
		requestService.addDocuments(requestId, documentsId);
	}
	
	public void setRequestService(fr.cg95.cvq.service.users.IRequestService requestService) {
		this.requestService = requestService;
	}
	
	public void setElectoralRollRegistrationRequestService(
			IElectoralRollRegistrationRequestService electoralRollRegistrationRequestService) {
		this.electoralRollRegistrationRequestService = electoralRollRegistrationRequestService;
	}
	
	public boolean hasConsumptions(String requestLabel) throws CvqException {
		
		return requestService.hasConsumptions(requestLabel);
	}
	
	public Set getBySubjectId(Long subjectId) throws CvqException, CvqObjectNotFoundException {
		
		return requestService.getBySubjectId(subjectId);
	}
	
	public Map getConsumptionsByRequest(Long requestId, Date dateFrom, Date dateTo) throws CvqException {
		
		return requestService.getConsumptionsByRequest(requestId,dateFrom,dateTo);
	}
	
	
	
	
}
