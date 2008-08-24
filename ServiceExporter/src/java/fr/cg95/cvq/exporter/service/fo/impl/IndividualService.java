package fr.cg95.cvq.exporter.service.fo.impl;

import java.util.Collections;
import java.util.Set;

import fr.cg95.cvq.business.request.HomeFolderModificationRequest;
import fr.cg95.cvq.business.users.CreationBean;
import fr.cg95.cvq.business.users.Individual;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.exception.CvqObjectNotFoundException;
import fr.cg95.cvq.exporter.service.fo.IIndividualService;
import fr.cg95.cvq.service.request.IHomeFolderModificationRequestService;

public class IndividualService implements IIndividualService {

	private fr.cg95.cvq.service.users.IIndividualService individualService = null             ;
	private IHomeFolderModificationRequestService homeFolderModificationRequest = null        ;
	
	public Individual getByLogin(String login) throws CvqException {
		return individualService.getByLogin(login);
	}

	public void setIndividualService(fr.cg95.cvq.service.users.IIndividualService individualService) {
		this.individualService = individualService;
	}
	

	/**
	 * Cette methode permet de modifier soit un adulte soit un enfant
	 * @param homeFolderId l'identificateur du foyer
	 * @param l'identificateur de celui qui c'est connecte
	 * @param l'individu à modifier (adulte ou enfant)
	 * @param isAdult pour dire si c'est un adulte qu'on va modifier ou un enfant
	 */
	public CreationBean modify(final Long homeFolderId, final Long requesterId, Set individus,boolean isAdult) 
	throws CvqException,CvqObjectNotFoundException {
	
		HomeFolderModificationRequest hmr = homeFolderModificationRequest.create(homeFolderId,requesterId) ;
		
		if(isAdult){
		
			return homeFolderModificationRequest.modify(hmr,individus,Collections.EMPTY_SET,null);
	
		}
		return  homeFolderModificationRequest.modify(hmr,Collections.EMPTY_SET,individus,null);
	}
	
	/**
	 * Setter pour que Spring initialise le champ pour nous
	 * @param homeFolderModificationRequestService
	 */
	public void setHomeFolderModificationRequest(IHomeFolderModificationRequestService homeFolderModificationRequest){
		this.homeFolderModificationRequest = homeFolderModificationRequest ;
		
	}

	/**
	 * This method finds up all document for the giving individual
	 * @param individualId the individual's id
	 */
	public Set getAssociatedDocuments(final Long individualId) 
	throws CvqException {
	
		return individualService.getAssociatedDocuments(individualId);
	}
}
