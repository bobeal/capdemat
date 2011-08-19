package fr.cg95.cvq.service.users;

import java.util.List;
import java.util.Map;

import fr.cg95.cvq.exception.CvqInvalidTransitionException;
import fr.cg95.cvq.exception.CvqModelException;
import fr.cg95.cvq.security.annotation.IsUser;

public interface IUserDeduplicationService {

    /**
     * Return a summary of duplicates in homeFolderId for duplicateHomeFolderId
     * 
     * Key is either adults or children and value is the number of matches
     */
    Map<String, Long> countHomeFolderDuplicates(@IsUser Long homeFolderId, 
            Long duplicateHomeFolderId);

    /**
     * Return a summary (full name) of duplicates in homeFolderId for duplicateHomeFolderId
     */
    List<String> getHomeFolderDuplicates(Long homeFolderId, Long duplicateHomeFolderId);

    /**
     * Remove duplicate entry on targetHomeFolderId for homeFolderId
     */
    void removeDuplicate(@IsUser Long homeFolderId, Long targetHomeFolderId);
    
    /**
     * Merge homeFolderId into targetHomeFolderId
     */
    void mergeDuplicate(@IsUser Long homeFolderId, Long targetHomeFolderId)
        throws CvqModelException, CvqInvalidTransitionException;
}