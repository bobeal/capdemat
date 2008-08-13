package fr.cg95.cvq.exporter.service.fo.impl;

import java.util.Set;

import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.exporter.service.fo.IHomeFolderService;

public class HomeFolderService implements IHomeFolderService {

	private fr.cg95.cvq.service.users.IHomeFolderService homeFolderService;
	
	public Set getChildren(Long homeFolderId) throws CvqException {
		return homeFolderService.getChildren(homeFolderId);
	}

	public Set getAdults(Long homeFolderId) throws CvqException {
		return homeFolderService.getAdults(homeFolderId);
	}

	public Set getAssociatedDocuments(final Long homeFolderId)
		throws CvqException {
		return homeFolderService.getAssociatedDocuments(homeFolderId);
	}
	
	public void setHomeFolderService(fr.cg95.cvq.service.users.IHomeFolderService homeFolderService) {
		this.homeFolderService = homeFolderService;
	}
}
