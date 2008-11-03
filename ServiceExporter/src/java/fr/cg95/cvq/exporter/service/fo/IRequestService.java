package fr.cg95.cvq.exporter.service.fo;

import java.util.Date;
import java.util.Map;
import java.util.Set;

import fr.cg95.cvq.business.request.election.ElectoralRollRegistrationRequest;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.exception.CvqObjectNotFoundException;

public interface IRequestService {
	
	Set getByHomeFolderId(final Long homeFolderId)
	throws CvqException, CvqObjectNotFoundException;
	
	Long createElectoralRollRegistrationRequest(final ElectoralRollRegistrationRequest errr,
			final Long requesterId, final Long subjectId)
	throws CvqException, CvqObjectNotFoundException;
	
	void addDocuments(final Long requestId, final Set documentsId)
	throws CvqException, CvqObjectNotFoundException;
	
	public boolean hasConsumptions(final String requestLabel)
	throws CvqException;
	
	public Set getBySubjectId(final Long subjectId)
	throws CvqException, CvqObjectNotFoundException ;
	
	public Map getConsumptionsByRequest(final Long requestId ,
			final Date dateFrom, final Date dateTo)
	throws CvqException ;
	
}
