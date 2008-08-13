package fr.cg95.cvq.exporter.service.fo;

import java.util.Set;

import fr.cg95.cvq.business.users.CreationBean;
import fr.cg95.cvq.business.users.Individual;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.exception.CvqObjectNotFoundException;

public interface IIndividualService {
	
	public Individual getByLogin(final String login)
	    throws CvqException;
	
	public CreationBean modify(Long homeFolderId,Long requesterId,Set individus,boolean isAdult)
	    throws CvqException, CvqObjectNotFoundException ;
	
	public Set getAssociatedDocuments(final Long individualId)
	    throws CvqException;
}
