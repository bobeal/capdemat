package fr.cg95.cvq.service.users.external;

import java.util.List;

import fr.cg95.cvq.business.payment.external.ExternalApplication;
import fr.cg95.cvq.business.payment.external.ExternalHomeFolder;
import fr.cg95.cvq.business.users.external.HomeFolderMapping;
import fr.cg95.cvq.business.users.external.IndividualMapping;
import fr.cg95.cvq.exception.CvqModelException;
import fr.cg95.cvq.security.annotation.IsUser;

public interface IExternalHomeFolderService {

    List<HomeFolderMapping> getHomeFolderMappings(@IsUser Long homeFolderId);

    void createHomeFolderMapping(HomeFolderMapping homeFolderMapping) throws CvqModelException;

    void modifyHomeFolderMapping(HomeFolderMapping homeFolderMapping) throws CvqModelException;

    HomeFolderMapping getHomeFolderMapping(final String externalServiceLabel,
        @IsUser final Long homeFolderId);

    HomeFolderMapping getHomeFolderMapping(final String externalServiceLabel, 
            final String externalCapdematId);

    HomeFolderMapping getHomeFolderMapping(String externalServiceLabel, ExternalHomeFolder eh);

    HomeFolderMapping getHomeFolderMapping(String externalServiceLabel,
            ExternalApplication externalApplication, String externalHomeFolderId);

    /**
     * Add a new mapping for the given object.
     *
     * If a mapping already exists for the given external service label and home folder id,
     * its external id will be replaced by the given one.
     */
    void addHomeFolderMapping(final String externalServiceLabel,
        @IsUser final Long homeFolderId, final String externalId);

    void deleteHomeFolderMapping(final String externalServiceLabel, ExternalHomeFolder eh);

    /**
     * Delete mappings for the given external service and home folder (included individual mappings).
     */
    void deleteHomeFolderMappings(final String externalServiceLabel,
        @IsUser final Long homeFolderId);

    /**
     * Set the external id of an individual for the given external service.
     * 
     * The mapping for the home folder must exist prior to this action.
     * To be used on external id retrieval from the external service.
     */
    void setExternalId(String externalServiceLabel,
        @IsUser Long homeFolderId, @IsUser Long individualId,
        String externalId);

    List<IndividualMapping> getIndividualMappings(@IsUser Long individualId);

    IndividualMapping getIndividualMapping(HomeFolderMapping homeFolderMapping, @IsUser Long individualId);

    void deleteIndividualMapping(HomeFolderMapping homeFolderMapping, @IsUser Long individualId);
}
