package fr.cg95.cvq.business.request;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import java.util.Set;

import net.sf.oval.constraint.AssertValid;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.xmlbeans.XmlObject;

import fr.cg95.cvq.business.users.MeansOfContact;
import fr.cg95.cvq.exception.CvqException;

/**
 * Represents a request issued by an e-citizen.
 *
 * @author bor@zenexity.fr
 */
public class Request implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final String SEARCH_BY_REQUEST_ID = "id";
    public static final String SEARCH_BY_HOME_FOLDER_ID = "homeFolderId";
    public static final String SEARCH_BY_REQUESTER_LASTNAME = "requesterLastName";
    public static final String SEARCH_BY_SUBJECT_LASTNAME = "subjectLastName";
    public static final String SEARCH_BY_SUBJECT_ID = "subjectId";
    public static final String SEARCH_BY_CATEGORY_NAME = "categoryName";
    public static final String SEARCH_BY_CATEGORY_ID = "categoryId";
    public static final String SEARCH_BY_REQUEST_TYPE_ID = "requestTypeId";
    public static final String SEARCH_BY_REQUEST_TYPE_LABEL = "requestTypeLabel";
    public static final String SEARCH_BY_SEASON_ID = "requestSeason.id";
    public static final String SEARCH_BY_STATE = "state";    
    public static final String SEARCH_BY_CREATION_DATE = "creationDate";
    public static final String SEARCH_BY_VALIDATION_DATE = "validationDate";
    public static final String SEARCH_BY_LAST_MODIFICATION_DATE = "lastModificationDate";
    public static final String SEARCH_BY_LAST_INTERVENING_USER_ID = "lastInterveningUserId";
    public static final String SEARCH_BY_QUALITY_TYPE = "qualityType";
    public static final String SEARCH_BY_RESULTING_STATE = "resultingState";
    public static final String SEARCH_BY_MODIFICATION_DATE = "modificationDate";
    public static final String QUALITY_TYPE_OK = "qualityTypeOk";
    public static final String QUALITY_TYPE_ORANGE = "qualityTypeOrange";
    public static final String QUALITY_TYPE_RED = "qualityTypeRed";

    @AssertValid(message = "")
    private RequestData requestData;

    public Request(RequestData requestData) {
        this.requestData = requestData;
    }

    public Request() {
        this.requestData = new RequestData();
    }

    public XmlObject modelToXml() {
        fr.cg95.cvq.xml.common.RequestType requestType =
            fr.cg95.cvq.xml.common.RequestType.Factory.newInstance();
        fillCommonXmlInfo(requestType);
        return requestType;
    }

    public String modelToXmlString() {
        return modelToXml().toString();
    }

    public fr.cg95.cvq.xml.common.RequestType modelToXmlRequest() {
        return (fr.cg95.cvq.xml.common.RequestType)modelToXml();
    }

    public void fillCommonXmlInfo(fr.cg95.cvq.xml.common.RequestType requestType) {
        Calendar calendar = Calendar.getInstance();
        requestType.setRequestTypeLabel(getRequestType().getLabel());
        if (getId() != null)
            requestType.setId(getId().longValue());
            // creation date can't be null, this is certified by the model :-)
            // hmm ... it can in fact be null when we generate test empty PDFs ...
        if (getCreationDate() != null) {
            calendar.setTime(getCreationDate());
            requestType.setCreationDate(calendar);
        }
        if (getLastModificationDate() != null) {
            calendar.setTime(getLastModificationDate());
            requestType.setLastModificationDate(calendar);
        }
        if (getValidationDate() != null) {
            calendar.setTime(getValidationDate());
            requestType.setValidationDate(calendar);
        }
        if (getLastInterveningUserId() != null)
            requestType.setLastInterveningUserId(getLastInterveningUserId().longValue());
        if (getState() != null)
            requestType.setState(fr.cg95.cvq.xml.common.RequestStateType.Enum.forString(getState().toString()));
        if (getDataState() != null)
            requestType.setDataState(fr.cg95.cvq.xml.common.DataStateType.Enum.forString(getDataState().toString()));
        if (getMeansOfContact() != null)
            requestType.setMeansOfContact(MeansOfContact.modelToXml(getMeansOfContact()));
        if (getStep() != null)
            requestType.setStep(fr.cg95.cvq.xml.common.RequestType.Step.Enum.forString(getStep().toString()));
        if (getRequestSeason() != null)
            requestType.setRequestSeason(RequestSeason.modelToXml(getRequestSeason()));
    }

    public void fillCommonModelInfo(Request request,
        fr.cg95.cvq.xml.common.RequestType requestType) {
        Calendar calendar = Calendar.getInstance();
        request.setId(new Long(requestType.getId()));
        if (requestType.getHomeFolder() != null)
            request.setHomeFolderId(requestType.getHomeFolder().getId());
        // creation date can be null, this is certified by the model :-)
        calendar = requestType.getCreationDate();
        if (calendar != null)
            request.setCreationDate(calendar.getTime());
        calendar = requestType.getLastModificationDate();
        if (calendar != null)
            request.setLastModificationDate(calendar.getTime());
        calendar = requestType.getValidationDate();
        if (calendar != null)
            request.setValidationDate(calendar.getTime());
        request.setLastInterveningUserId(new Long(requestType.getLastInterveningUserId()));
        if (requestType.getState() != null)
            request.setState(RequestState.forString(requestType.getState().toString()));
        if (requestType.getMeansOfContact() != null)
            request.setMeansOfContact(MeansOfContact.xmlToModel(requestType.getMeansOfContact()));
        if (requestType.getStep() != null)
            request.setStep(RequestStep.forString(requestType.getStep().toString()));
        if (requestType.getRequestSeason() != null)
            request.setRequestSeason(RequestSeason.xmlToModel(requestType.getRequestSeason()));
    }

    public Long getId() {
        return requestData.getId();
    }

    public void setId(Long id) {
        requestData.setId(id);
    }

    public Long getHomeFolderId() {
        return requestData.getHomeFolderId();
    }

    public void setHomeFolderId(Long homeFolderId) {
        requestData.setHomeFolderId(homeFolderId);
    }

    public Date getCreationDate() {
        return requestData.getCreationDate();
    }

    public void setCreationDate(Date creationDate) {
        requestData.setCreationDate(creationDate);
    }

    public Date getLastModificationDate() {
        return requestData.getLastModificationDate();
    }

    public void setLastModificationDate(Date lastModificationDate) {
        requestData.setLastModificationDate(lastModificationDate);
    }

    public Long getLastInterveningUserId() {
        return requestData.getLastInterveningUserId();
    }

    public void setLastInterveningUserId(Long lastInterveningUserId) {
        requestData.setLastInterveningUserId(lastInterveningUserId);
    }

    public RequestState getState() {
        return requestData.getState();
    }

    public void setState(RequestState state) {
        requestData.setState(state);
    }

    public DataState getDataState() {
        return requestData.getDataState();
    }

    public void setDataState(DataState dataState) {
        requestData.setDataState(dataState);
    }

    public MeansOfContact getMeansOfContact() {
        return requestData.getMeansOfContact();
    }

    public void setMeansOfContact(MeansOfContact meansOfContact) {
        requestData.setMeansOfContact(meansOfContact);
    }

    public RequestStep getStep() {
        return requestData.getStep();
    }

    public void setStep(RequestStep step) {
        requestData.setStep(step);
    }

    public Long getRequesterId() {
        return requestData.getRequesterId();
    }

    public void setRequesterId(Long requesterId) {
        requestData.setRequesterId(requesterId);
    }

    public String getRequesterLastName() {
        return requestData.getRequesterLastName();
    }

    public void setRequesterLastName(String requesterLastName) {
        requestData.setRequesterLastName(requesterLastName);
    }

    public String getRequesterFirstName() {
        return requestData.getRequesterFirstName();
    }

    public void setRequesterFirstName(String requesterFirstName) {
        requestData.setRequesterFirstName(requesterFirstName);
    }

    public RequestType getRequestType() {
        return requestData.getRequestType();
    }

    public void setRequestType(RequestType requestType) {
        requestData.setRequestType(requestType);
    }

    public RequestSeason getRequestSeason() {
        return requestData.getRequestSeason();
    }

    public void setRequestSeason(RequestSeason requestSeason) {
        requestData.setRequestSeason(requestSeason);
    }

    public Set<RequestDocument> getDocuments() {
        return requestData.getDocuments();
    }

    public void setDocuments(Set<RequestDocument> documents) {
        requestData.setDocuments(documents);
    }

    public Set<RequestAction> getActions() {
        return requestData.getActions();
    }

    public void setActions(Set<RequestAction> actions) {
        requestData.setActions(actions);
    }

    public Set<RequestNote> getNotes() {
        return requestData.getNotes();
    }

    public void setNotes(Set<RequestNote> notes) {
        requestData.setNotes(notes);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("id", getId()).toString();
    }

    public Boolean getOrangeAlert() {
        return requestData.getOrangeAlert();
    }

    public void setOrangeAlert(Boolean orangeAlert) {
        requestData.setOrangeAlert(orangeAlert);
    }

    public Boolean getRedAlert() {
        return requestData.getRedAlert();
    }

    public void setRedAlert(Boolean redAlert) {
        requestData.setRedAlert(redAlert);
    }

    public Date getValidationDate() {
        return requestData.getValidationDate();
    }

    public void setValidationDate(Date validationDate) {
        requestData.setValidationDate(validationDate);
    }

    public Long getSubjectId() {
        return requestData.getSubjectId();
    }

    public void setSubjectId(Long subjectId) {
        requestData.setSubjectId(subjectId);
    }

    public String getSubjectLastName() {
        return requestData.getSubjectLastName();
    }

    public void setSubjectLastName(String subjectLastName) {
        requestData.setSubjectLastName(subjectLastName);
    }

    public String getSubjectFirstName() {
        return requestData.getSubjectFirstName();
    }

    public void setSubjectFirstName(String subjectFirstName) {
        requestData.setSubjectFirstName(subjectFirstName);
    }

    public Map<String, Map<String, Object>> getStepStates() {
        return requestData.getStepStates();
    }

    public void setStepStates(Map<String, Map<String, Object>> stepStates) {
        requestData.setStepStates(stepStates);
    }

    public boolean getHasTiedHomeFolder() {
        return requestData.getHasTiedHomeFolder();
    }

    public void setHasTiedHomeFolder(boolean hasTiedHomeFolder) {
        requestData.setHasTiedHomeFolder(hasTiedHomeFolder);
    }

    public byte[] getDocumentsArchive() {
        return requestData.getDocumentsArchive();
    }

    public void setDocumentsArchive(byte[] documentsArchive) {
        requestData.setDocumentsArchive(documentsArchive);
    }

    /**
     * Reserved for RequestDAO !
     */
    public RequestData getRequestData() {
        return requestData;
    }

    /**
     * Reserved for RequestDAO !
     */
    public void setRequestData(RequestData requestData) {
        this.requestData = requestData;
    }

    /**
     * Reserved for RequestDAO !
     *
     * @throws CvqException if called on a raw Request and not a subclass
     */
    public Object getSpecificData() throws CvqException {
        throw new CvqException("Trying to get specific data from a raw Request");
    }

    /**
     * Reserved for RequestDAO !
     *
     * @throws CvqException if called on a raw Request and not a subclass
     */
    public void setSpecificData(Object specificData) throws CvqException {
        throw new CvqException("Trying to set specific data on a raw Request");
    }
}
