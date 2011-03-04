package fr.cg95.cvq.business.users;

import fr.cg95.cvq.business.CapDematEvent;

public class UsersEvent extends CapDematEvent {

    private static final long serialVersionUID = 1L;

    public static enum EVENT_TYPE {
        HOME_FOLDER_ARCHIVE,
        HOME_FOLDER_DELETE,
        HOME_FOLDER_VALIDATE,
        INDIVIDUAL_ARCHIVE,
        INDIVIDUAL_DELETE,
        LOGIN_ASSIGNED
    }

    private EVENT_TYPE event;
    private Long homeFolderId;
    private Long individualId;
    
    public UsersEvent(Object source, EVENT_TYPE event, Long homeFolderId, Long individualId) {
        super(source);
        this.event = event;
        this.homeFolderId = homeFolderId;
        this.individualId = individualId;
    }

    public Long getHomeFolderId() {
        return homeFolderId;
    }

    public Long getIndividualId() {
        return individualId;
    }

    public EVENT_TYPE getEvent() {
        return event;
    }
}
