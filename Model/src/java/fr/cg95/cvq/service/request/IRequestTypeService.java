package fr.cg95.cvq.service.request;

import java.util.List;
import java.util.Set;

import fr.cg95.cvq.business.document.DocumentType;
import fr.cg95.cvq.business.request.RequestForm;
import fr.cg95.cvq.business.request.RequestFormType;
import fr.cg95.cvq.business.request.RequestSeason;
import fr.cg95.cvq.business.request.RequestType;
import fr.cg95.cvq.business.request.Requirement;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.exception.CvqModelException;
import fr.cg95.cvq.exception.CvqObjectNotFoundException;
import fr.cg95.cvq.service.request.annotation.IsRequest;
import fr.cg95.cvq.service.request.annotation.IsRequestType;
import fr.cg95.cvq.util.Critere;

/**
 * @author bor@zenexity.fr
 */
public interface IRequestTypeService {

    /**
     * Label used to identify account creation requests.
     * 
     * TODO : rename to ACCOUNT_CREATION_REQUEST
     */
    String VO_CARD_REGISTRATION_REQUEST = "VO Card";
    /**
     * Label used to identify account modification requests.
     * 
     * TODO : rename to ACCOUNT_MODIFICATION_REQUEST
     */    
    String HOME_FOLDER_MODIFICATION_REQUEST = "Home Folder Modification";

    /**
     * Get a list of all existing requests types.
     *
     * For an agent, return the list of requests types for which it has at least a read permission.
     * For an ecitizen, return the list of activated requests types.
     */
    List<RequestType> getAllRequestTypes()
        throws CvqException;

    /**
     * Get the list of requests types handled by the given category in the given activation state.
     *
     */
    List<RequestType> getRequestTypes(Set<Critere> criteriaSet)
        throws CvqException;

    /**
     * Get a list of requests types whose current agent is manager of.
     */
    List<RequestType> getManagedRequestTypes()
        throws CvqException;

    /**
     * Get a request type by id.
     */
    RequestType getRequestTypeById(final Long requestTypeId)
        throws CvqException;

    /**
     * Get a request type by label.
     *
     * @deprecated use {@link #getRequestTypeById(Long)} instead
     */
    RequestType getRequestTypeByLabel(final String requestLabel)
        throws CvqException;

    /**
     * Return whether the given request is an account related request (creation or modification).
     */
    boolean isAccountRequest(@IsRequest final Long requestId) 
        throws CvqException, CvqObjectNotFoundException;
    
    /**
     * Modify a request type properties.
     */
    void modifyRequestType(@IsRequestType RequestType requestType)
        throws CvqException;

    /**
     * Modify a requirement associated to a request type.
     */
    void modifyRequestTypeRequirement(@IsRequestType final Long requestTypeId,
            Requirement requirement)
        throws CvqException;

    /**
     * Add a new requirement to the given request type.
     */
    void addRequestTypeRequirement(@IsRequestType final Long requestTypeId,
            Long documentTypeId)
        throws CvqException;

    /**
     * Remove the requirement between the given request type and document type.
     */
    void removeRequestTypeRequirement(@IsRequestType final Long requestTypeId,
            Long documentTypeId)
        throws CvqException;

    /**
     * Get the list of documents types allowed for the given request type.
     */
    Set<DocumentType> getAllowedDocuments(final Long requestTypeId)
        throws CvqException;

    //////////////////////////////////////////////////////////
    // Seasons related methods
    //////////////////////////////////////////////////////////

    boolean isRegistrationOpen(final Long requestTypeId) throws CvqException;

    /**
     * Associate a new season to the given request type.
     *
     * Expected business error code are :
     * <dl>
     *   <dt>request.season.not_supported</dt>
     *     <dd>Request Type don't support season management</dd>
     *   <dt>request.season.registration_start_required</dt>
     *     <dd>-</dd>
     *   <dt>request.season.registration_end_required</dt>
     *     <dd>-</dd>
     *   <dt>request.season.effect_start_required</dt>
     *     <dd>-</dd>
     *   <dt>request.season.effect_end_required</dt>
     *     <dd>-</dd>
     *   <dt>request.season.registration_start_after_registration_end</dt>
     *     <dd>-</dd>
     *   <dt>request.season.effect_start_after_effect_end</dt>
     *     <dd>-</dd>
     *   <dt>request.season.registration_start_after_effect_start</dt>
     *     <dd>-</dd>
     *   <dt>request.season.registration_end_after_effect_end</dt>
     *     <dd>-</dd>
     *   <dt>registration_start_before_now</dt>
     *     <dd>Season registration start is define in past</dd>
     *   <dt>request.season.already_used_label</dt>
     *     <dd>-</dd>
     * </dl>
     */
    void addRequestSeason(@IsRequestType final Long requestTypeId,
        RequestSeason seasonContainer)
        throws CvqException;

    /**
     * Modify a season associate to requestType
     *
     * @param requestSeason - Don't forget to set season's uuid. It's use to identify season.
     * @throws CvqException
     * <br><br>
     * Refer to createRequestSeasons  business error code.
     * <br>
     * Specific business error code:
     * <dl>
     *   <dt>request.season.effect_ended</dt>
     *     <dd>Season effect end has been occured (only in modify season context)</dd>
     *   <dt>request.season.registration_started</dt>
     *     <dd>Season effect end has been occured (only in modify season context)</dd>
     * </dl>
     */
    void modifyRequestSeason(@IsRequestType final Long requestTypeId,
        RequestSeason seasonContainer)
        throws CvqException;

    void removeRequestSeason(@IsRequestType final Long requestTypeId,
        final Long requestSeasonId)
        throws CvqException;

    Set<RequestSeason> getRequestSeasons(@IsRequestType Long requestTypeId)
        throws CvqException;

    RequestSeason getRequestSeason(@IsRequestType Long requestTypeId, Long id)
        throws CvqException;

    Set<RequestSeason> getOpenSeasons(@IsRequestType RequestType requestType)
        throws CvqModelException;

    //////////////////////////////////////////////////////////
    // RequestForm related Methods
    //////////////////////////////////////////////////////////

    /**
     * TODO ACMF
     */
    RequestForm getRequestFormById(Long id) throws CvqException;

    /**
     * Method that process request form update/creation.
     *
     * Defines by itself which kind of processing has to be produced.
     *
     * @return request form id
     */
    Long modifyRequestTypeForm(@IsRequestType Long requestTypeId,
            RequestForm requestForm) throws CvqException;

    /**
     * Remove a request form.
     *
     * TODO : unused currently but should be
     */
    void removeRequestTypeForm(@IsRequestType final Long requestTypeId, final Long requestFormId)
        throws CvqException;

    /**
     * Remove a request form.
     *
     * @deprecated use {@link #removeRequestTypeForm(Long, Long)} instead
     */
    void removeRequestTypeForm(final Long requestFormId) throws CvqException;

    /**
     * Get request forms by request type and type of request form.
     */
    List<RequestForm> getRequestTypeForms(@IsRequestType final Long requestTypeId,
        RequestFormType requestFormType) throws CvqException;
}
