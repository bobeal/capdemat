package fr.cg95.cvq.business.request;

import java.io.Serializable;
import java.util.HashSet;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.apache.commons.lang.builder.ToStringBuilder;

@Entity
@Table(name="category")
public class Category implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Long id;

    private String name;

    @Column(name="primary_email")
    private String primaryEmail;

    /** the request types that are handled by this category */
    @OneToMany(fetch=FetchType.LAZY)
    @JoinColumn(name="category_id")
    private Set<RequestType> requestTypes;

    /**
     * the agent roles for this category
     * TODO : rename
     */
    @ElementCollection(fetch=FetchType.LAZY)
    @CollectionTable(name="agent_category_roles", 
            joinColumns=@JoinColumn(name="category_id"))
    private Set<CategoryRoles> categoriesRoles;

    /** emails of contact for this category */
    @ElementCollection(fetch=FetchType.EAGER)
    @Column(name="email")
    @CollectionTable(name="category_emails",joinColumns=@JoinColumn(name="category_id"))
    private Set<String> emails;
    
    /** default constructor */
    public Category() {
    }

    public Category(String name, String primaryEmail) {
        this.name = name;
        this.primaryEmail = primaryEmail;
        this.requestTypes = new HashSet<RequestType>();
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrimaryEmail() {
        return this.primaryEmail;
    }

    public void setPrimaryEmail(String email) {
        this.primaryEmail = email;
    }
    
    public Set<String> getEmails() {
        return emails;
    }

    public void setEmails(Set<String> emails) {
        this.emails = emails;
    }

    public void addEmail(String email) {
        if (this.emails == null)
            this.emails = new HashSet<String>();
        
        this.emails.add(email);
    }
    
    public void removeEmail(String email) {
        if (this.emails == null)
            return;
        else 
            this.emails.remove(email);
    }

    public Set<RequestType> getRequestTypes() {
        return this.requestTypes;
    }

    public void setRequestTypes(Set<RequestType> requestTypes) {
        this.requestTypes = requestTypes;
    }

    public Set<CategoryRoles> getCategoriesRoles() {
        return this.categoriesRoles;
    }

    public void setCategoriesRoles(Set<CategoryRoles> categoriesRoles) {
        this.categoriesRoles = categoriesRoles;
    }

    public void addCategoryRole(CategoryRoles categoryRole) {
        if (this.categoriesRoles == null)
            this.categoriesRoles = new HashSet<CategoryRoles>();
        this.categoriesRoles.add(categoryRole);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
            .append("id", getId())
            .toString();
    }
}
