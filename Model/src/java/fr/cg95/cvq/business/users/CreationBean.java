package fr.cg95.cvq.business.users;

/**
 * Bean used to communication ecitizens creation information.
 *
 * @author bor@zenexity.fr
 * 
 * FIXME : is it used outside unit tests ?
 */
public class CreationBean {

    private String login;
    private Long requestId;
    private Long homeFolderId;

    public void setLogin(final String login) {
        this.login = login;
    }

    public String getLogin() {
        return this.login;
    }

    public void setRequestId(final Long requestId) {
        this.requestId = requestId;
    }

    public Long getRequestId() {
        return this.requestId;
    }

    public Long getHomeFolderId() {
        return homeFolderId;
    }

    public void setHomeFolderId(Long homeFolderId) {
        this.homeFolderId = homeFolderId;
    }
}
