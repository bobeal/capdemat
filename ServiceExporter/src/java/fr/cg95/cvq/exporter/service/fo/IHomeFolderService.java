package fr.cg95.cvq.exporter.service.fo;

import java.util.Set;

import fr.cg95.cvq.exception.CvqException;

public interface IHomeFolderService {

    Set getChildren(final Long homeFolderId)
    		throws CvqException;
    
    Set getAdults(final Long homeFolderId)
    		throws CvqException;
    
    Set getAssociatedDocuments(final Long homeFolderId)
    		throws CvqException;
}
