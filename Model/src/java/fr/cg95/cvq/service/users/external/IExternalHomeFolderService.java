package fr.cg95.cvq.service.users.external;

import java.util.List;

import fr.cg95.cvq.business.payment.external.ExternalHomeFolder;
import fr.cg95.cvq.business.users.external.HomeFolderMapping;
import fr.cg95.cvq.business.users.external.IndividualMapping;
import fr.cg95.cvq.exception.CvqModelException;
import fr.cg95.cvq.security.annotation.IsHomeFolder;
import fr.cg95.cvq.security.annotation.IsIndividual;

public interface IExternalHomeFolderService {

    List<HomeFolderMapping> getHomeFolderMappings(@IsHomeFolder Long homeFolderId);

    void createHomeFolderMapping(HomeFolderMapping homeFolderMapping) throws CvqModelException;

    void modifyHomeFolderMapping(HomeFolderMapping homeFolderMapping) throws CvqModelException;

    HomeFolderMapping getHomeFolderMapping(final String externalServiceLabel,
            @IsHomeFolder final Long homeFolderId);

    HomeFolderMapping getHomeFolderMapping(final String externalServiceLabel, 
            final String externalCapdematId);

    HomeFolderMapping getHomeFolderMapping(String externalServiceLabel, ExternalHomeFolder eh);

    /**
     * Add a new mapping for the given object.
     *
     * If a mapping already exists for the given external service label and home folder id,
     * its external id will be replaced by the given one.
     */
    void addHomeFolderMapping(final String externalServiceLabel,
            @IsHomeFolder final Long homeFolderId, final String externalId);

    void deleteHomeFolderMapping(final String externalServiceLabel, ExternalHomeFolder eh);

    /**
     * Delete mappings for the given external service and home folder (included individual mappings).
     */
    void deleteHomeFolderMappings(final String externalServiceLabel,
            @IsHomeFolder final Long homeFolderId);

    /**
     * Set the external id of an individual for the given external service.
     * 
     * The mapping for the home folder must exist prior to this action.
     * To be used on external id retrieval from the external service.
     */
    void setExternalId(String externalServiceLabel,
        @IsHomeFolder Long homeFolderId, @IsIndividual Long individualId,
        String externalId);

    List<IndividualMapping> getIndividualMappings(@IsIndividual Long individualId);

    IndividualMapping getIndividualMapping(HomeFolderMapping homeFolderMapping, @IsIndividual Long individualId);

    void deleteIndividualMapping(HomeFolderMapping homeFolderMapping, @IsIndividual Long individualId);


}
