package com.zenexity.pict.cvq.fo.util;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import fr.cg95.cvq.business.election.ElectoralMotiveType;
import fr.cg95.cvq.business.election.ElectoralRollRegistrationRequest;
import fr.cg95.cvq.business.users.Adult;
import fr.cg95.cvq.exception.CvqException;

public class RequestCreator {

	private Log logger = LogFactory.getLog(RequestCreator.class);
	private FoHttpInvoker foHttpInvoker;
	private EcitizenDataCache ecitizenDataCache;
	
	public Long create(ElectoralRollRegistrationRequest request, Adult adult, List documentList, 
			String currentUser) throws Exception {
		
		logger.debug("create()");
		logger.debug("create() individual name : " + adult.getLastName());
		logger.debug("create() individual id : " + adult.getId());
		logger.debug("create() documents # : " + documentList.size());
		logger.debug("create() request subject : " + request.getSubjectNationality());
		logger.debug("create() requester : " + currentUser);
		
		request.setMotive(ElectoralMotiveType.NEW_CITY_RESIDENT);
		Long subjectId = Long.valueOf(adult.getId());
		Long requesterId = ecitizenDataCache.getUserId(currentUser);
		Long requestId = null;
		try {
			requestId = foHttpInvoker.createElectoralRollRegistrationRequest(request, currentUser, requesterId, subjectId);
		} catch (CvqException e) {
			logger.error("error while creating request");
			return new Long("-1");
		}
		
		Set<Long> documentsSet = new HashSet<Long>();
		for (int i=0; i < documentList.size(); i++) {
			String documentId = (String) documentList.get(i);
			documentsSet.add(Long.valueOf(documentId));
		}
		try {
			foHttpInvoker.addDocumentsToRequest(currentUser, requestId, documentsSet);
		} catch (CvqException e) {
			logger.error("error while adding documents to request");
			return new Long("-1");
		}

		try {
			ecitizenDataCache.refreshRequestsCache(currentUser);
		} catch (Exception e) {
			logger.warn("error while updating request cache");
			e.printStackTrace();
		}
		return requestId;
	}

	public ElectoralRollRegistrationRequest getNewElectoralRollRegistrationRequest() {
		return new ElectoralRollRegistrationRequest();
	}
	
	public void setFoHttpInvoker(FoHttpInvoker foHttpInvoker) {
		this.foHttpInvoker = foHttpInvoker;
	}

	public void setEcitizenDataCache(EcitizenDataCache ecitizenDataCache) {
		this.ecitizenDataCache = ecitizenDataCache;
	}
}
