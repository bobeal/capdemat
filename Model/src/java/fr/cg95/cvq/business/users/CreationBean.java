package fr.cg95.cvq.business.users;

/**
 * Bean used to communication ecitizens creation information
 *
 * @author bor@zenexity.fr
 */
public class CreationBean {

    private String login;
    private Long requestId;

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
}
