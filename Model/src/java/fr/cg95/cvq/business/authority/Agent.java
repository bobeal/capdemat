package fr.cg95.cvq.business.authority;

import java.io.Serializable;
import java.util.Hashtable;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import org.apache.commons.lang.builder.ToStringBuilder;


/**
 * @author bor@zenexity.fr
 */
@Entity
@Table(name="agent")
public class Agent implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Long id;

    @Column(name="login")
    private String login;

    @Column(name="last_name")
    private String lastName;

    @Column(name="first_name")
    private String firstName;

    @Column(name="active")
    private Boolean active = true;

    @Column(name="email")
    private String email;

    @ElementCollection(fetch=FetchType.LAZY)
    @CollectionTable(
          name="agent_site_roles",
          joinColumns=@JoinColumn(name="agent_id")
    )
    private Set<SiteRoles> sitesRoles;

    @Column(name="preferences")
    private Hashtable<String, Hashtable<String, String>> preferences; 

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return this.login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Set<SiteRoles> getSitesRoles() {
        return this.sitesRoles;
    }

    public void setSitesRoles(Set<SiteRoles> sitesRoles) {
        this.sitesRoles = sitesRoles;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Hashtable<String, Hashtable<String, String>> getPreferences() {
        return this.preferences;
    }

    public void setPreferences(Hashtable<String, Hashtable<String, String>> preferences) {
        this.preferences = preferences;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
            .append("login", getLogin())
            .append("id", getId())
            .toString();
    }
}
