package fr.cg95.cvq.service.request;

import java.util.Map;
import java.util.Set;

import fr.cg95.cvq.business.request.LocalReferentialType;
import fr.cg95.cvq.exception.CvqException;

public interface ILocalReferentialService {

    /**
     * Get a list of all known local referential data.
     * @deprecated only used in unit tests
     */
    @Deprecated
    Set<LocalReferentialType> getAllLocalReferentialData()
        throws CvqException;

    /**
     * Get a summary of all local referential data names (data name being the name of the
     * corresponding element in the request's XML schema).
     *
     * @return a map of (dataName, {@link Map}(lang, value))
     * @deprecated only used in unit tests
     */
    @Deprecated
    Map<String, Map<String, String>> getAllLocalReferentialDataNames()
        throws CvqException;

    /**
     * Get all information related to the given data.
     */
    LocalReferentialType getLocalReferentialDataByName(final String dataName)
        throws CvqException;

    /**
     * Get a list of all local referential data names belonging to a given request type.
     */
    Set<LocalReferentialType> getLocalReferentialDataByRequestType(final String requestTypeLabel)
        throws CvqException;

    /**
     * Return whether local referential is configured for the given request type.
     * 
     * @return false if at least one localReferentialType has null or empty entries. 
     *  Otherwise return true.
     */
    public boolean isLocalReferentialConfigured(final String requestTypeLabel) throws CvqException;
    
    /**
     * Set local referential data.
     */
    void setLocalReferentialData(final LocalReferentialType localReferentialType)
        throws CvqException;
}
