package fr.cg95.cvq.business.authority;

import fr.cg95.cvq.business.request.RequestType;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang.builder.ToStringBuilder;


/**
 * @hibernate.class
 *  table="category"
 *  lazy="false"
 *
 * @author bor@zenexity.fr
 */
public class Category implements Serializable {

	private static final long serialVersionUID = 1L;

	/** identifier field */
    private Long id;
    private String name;
    private String primaryEmail;

    /** the request types that are handled by this category */
    private Set requestTypes;

    /** emails of contact for this category */
    private Set emails;
    
    /** default constructor */
    public Category() {
    }

    /**
     * @hibernate.id
     *  generator-class="sequence"
     *  column="id"
     */
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @hibernate.property
     *  column="name"
     */
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * @hibernate.property
     *  column="primary_email"
     */  
    public String getPrimaryEmail() {
        return this.primaryEmail;
    }
    
    public void setPrimaryEmail(String email) {
        this.primaryEmail = email;
    }
    
    /**
     * @hibernate.set
     *  table="category_emails"
     * @hibernate.key
     *  column="category_id"
     * @hibernate.element
     *  column="email"
     *  type="string"
     */
    public Set getEmails() {
        return emails;
    }

    public void setEmails(Set emails) {
        this.emails = emails;
    }

    public void addEmail(String email) {
        if (this.emails == null)
            this.emails = new HashSet();
        
        this.emails.add(email);
    }
    
    public void removeEmail(String email) {
        if (this.emails == null)
            return;
        else 
            this.emails.remove(email);
    }
    
    /**
     * @hibernate.set
     *  inverse="true"
     *  lazy="true"
     * @hibernate.key
     *  column="category_id"
     * @hibernate.one-to-many
     *  class="fr.cg95.cvq.business.request.RequestType"
     */
    public Set<RequestType> getRequestTypes() {
        return this.requestTypes;
    }

    public void setRequestTypes(Set<RequestType> requestTypes) {
        this.requestTypes = requestTypes;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
            .append("id", getId())
            .toString();
    }

}
